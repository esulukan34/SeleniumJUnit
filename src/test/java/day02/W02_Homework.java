package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W02_Homework {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ChromeDriver karakullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        // oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else
            //eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
            System.out.println("Sayfanin basligi " + driver.getTitle());

        // Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        String actualUrl = driver.getCurrentUrl();
        String exceptedUrl = "facebook";
        if (actualUrl.contains(exceptedUrl)){
            System.out.println("Test PASSED");
        }else{
            System.out.println(driver.getCurrentUrl());
        }

        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");

        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Walmart.com";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else
            //eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
            System.out.println("Sayfanin basligi " + driver.getTitle());
        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // Sayfayi yenileyin
        driver.navigate().refresh();

        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // 9.Browser’i kapatin
        driver.close();

    }
}
