package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Trendyol {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1-https://www.trendyol.com adresine git
        driver.get("https://www.trendyol.com");
        driver.navigate().refresh();

        // "Giris yap" butonuna tikla
        driver.findElement(By.xpath("(//p[@class='link-text'])[1]")).click();

        //E-posta adresin "esulukan34@gmail.com" giriniz
        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("esulukan34@gmail.com");
        Thread.sleep(2000);

        //Sifre icin
        driver.findElement(By.id("login-password-input")).sendKeys("2101emre", Keys.ENTER);
        Thread.sleep(2000);

        // - "macbook m1" arattir, bir tanesine tikla
        driver.findElement(By.className("search-box")).sendKeys("macbook m1", Keys.ENTER);
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//div[@class='image-overlay-body'])[3]")).click();



    }
}
