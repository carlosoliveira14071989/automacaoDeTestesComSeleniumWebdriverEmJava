package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.ScreenShot;
import suporte.Web;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths ="informacoesUsuarioTest.csv")
public class informacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {

        navegador = Web.createChrome();

        //Clicar no link com o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //Preencher o campo login com "julio0001" dentro do formulario de id "signinbox"
        WebElement formularioSigninBox = navegador.findElement(By.id("signinbox"));
        formularioSigninBox.findElement(By.name("login")).sendKeys("julio0001");
        //Preencher o password com "123456" dentro do formulario de id "signinbox"
        formularioSigninBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Validar que dentro do elemento com class "me" possui o texto "Hi, Julio"

        //Clicar em um elemento que possui a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar no link "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();


    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo,@Param(name="contato")String contato,@Param(name="mensagem")String mensagem) {

        //Clicar no button add more data através do xpath "//button[@data-target='addmoredata']"
        navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click();

        //Identificar a pop up onde está o formulario de id ="addmoredata"
        WebElement formularioAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na combo de name type, escolher a opção "Phone"
        WebElement campoType = formularioAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        //No campo de name "contact" digitar o telefone "11920021852"
        navegador.findElement(By.name("contact")).sendKeys(contato);

        // clicar no link de texto "SAVE"
        navegador.findElement(By.linkText("SAVE")).click();
        // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        String textoToast = navegador.findElement(By.id("toast-container")).getText();
        assertEquals(mensagem, textoToast);
        System.out.print(textoToast);

    }

    @Test
    public void removerUmContatoDeUmUsuario() {
        //Clicar no elemento pelo seu xpath: "//span[text()="11920021707"]/following-sibling::a"
        navegador.findElement(By.xpath("//span[text()=\"11920021707\"]/following-sibling::a")).click();

        //Confirmar a janela javascript
        navegador.switchTo().alert().accept();
        //Validar que a mensagem apresentada foi "Rest in peace, dear phone!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Rest in peace, dear phone!",mensagem);
        String screenShotArquivo = "C:\\Screenshots\\" + Generator.dataHoraParaArquivo()+ test.getMethodName() +".png";

        ScreenShot.tirar(navegador,screenShotArquivo);

        //Aguardar até 10 segundo para a janela desaparecer
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
        //Clicar no link com o texto "Logout"
        navegador.findElement(By.linkText("Logout"));

    }


    @After
    public void tearDown() {
        navegador.quit();


    }


}
