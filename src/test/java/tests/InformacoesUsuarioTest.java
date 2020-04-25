package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
    @Test

public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Carlito\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.juliodelima.com.br/taskit/");
        navegador.manage().window().maximize();

        //Clicar no link com o texto "Sign in"

        //Preencher o campo login com "julio0001" dentro do formulario de id "signinbox"

        //Preencher o password com "123456" dentro do formulario de id "signinbox"

        //Clicar no link com o texto "SIGN IN"

        //Validar que dentro do elemento com class "me" possui o texto "Hi, Julio"

        //Fechar o navegador





    }
}
