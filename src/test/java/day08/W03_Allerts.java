package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W03_Allerts {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
        /*
        // 1.http://zero.webappsecurity.com/ Adresinegidin




        // 7.“Purchase Foreign Currency” tusuna basin
        // 8.“Currency” drop down menusunden Eurozone’usecin
        // 9.“amount” kutusuna bir sayigirin
        // 10.“US Dollars” in secilmedigini testedin
        // 11.“Selected currency” butonunusecin
        // 12.“Calculate Costs” butonuna basin sonra “purchase” butonunabasin
        // 13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontroledin.
         */
    }
    @Test
    public void test() throws InterruptedException {
        // 2.Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        // 3.Login kutusuna “username”yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        // 4.Password kutusuna “password.”yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        Thread.sleep(5000);
        // 5.Sign in tusuna basin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        // 6.Pay Bills sayfasina gidin


    }

}
