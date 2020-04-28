package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

       @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Carlito\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.get("http://www.juliodelima.com.br/taskit/");
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {


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
     navegador.findElement(By.className("me"));

     //Clicar no link "MORE DATA ABOUT YOU"

     //Clicar no button add more data através do xpath "//button[@data-target='addmoredata']"

      //Identificar a pop up onde está o formulario de id ="addmoredata"

      // Na combo de name type, escolher a opção "Phone"

      //No campo de name "contact" digitar o telefone "11920021852"

      // clicar no link de texto "SAVE"

      // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"

}



@After
        public void tearDown(){
        navegador.quit();


    }


    }
