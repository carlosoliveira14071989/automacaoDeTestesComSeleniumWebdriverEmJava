package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Carlito\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.juliodelima.com.br/taskit/");
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return navegador;

    }
}
