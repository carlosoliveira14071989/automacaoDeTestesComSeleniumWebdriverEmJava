package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

public class informacoesUsuarioPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }
        @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        new LoginPage(navegador)
       .clickSign()
       .fazerLogin("julio0001","123456")
       .clicarMe()
       .clicarMoredataAboutYou()
       .clicarNoBotaoAddMoreDataAboutYou();




        }



    @After
    public void tearDown(){
        navegador.quit();
    }
}
