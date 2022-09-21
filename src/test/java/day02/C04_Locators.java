package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Locators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// Gidilen sayfada 15 sn icinde calısmazsa kapanir

        driver.get("https://www.amazon.com");

        // amazonda nutella aratin

        //1.yol: By.id ile
        // WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //aramaKutusu.sendKeys("Nutella, Keys.Enter");

        //2.yol: By.name ile
        //WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));
        //aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //3.Yol:


        //4.Yol:
        driver.findElement(By.partialLinkText("Sell products on Amazon")).click();






    }
}
