package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class W01 {
    public static void main(String[] args) {
        /*
        Yeni bir package olusturalim : day01
        Yeni bir class olusturalim : C03_GetMethods
        Amazon sayfasina gidelim. https://www.amazon.com/
        Sayfa basligini(title) yazdirin
        Sayfa basliginin “Amazon” icerdigini test edin
        Sayfa adresini(url) yazdirin
        Sayfa url’inin “amazon” icerdigini test edin.
        Sayfa handle degerini yazdirin
        Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        Sayfayi kapatin.
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();
        String istenenKelime1 = "Amazon";
        if (actualTitle.contains(istenenKelime1)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

        //Sayfa url’inin “amazon” icerdigini test edin.
        String actualUrl = driver.getTitle();
        String istenenKelime2 = "Amazon";
        if (actualUrl.contains(istenenKelime2)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String actualHtml = driver.getWindowHandle();
        String istenenKelime3 = "Gateway";
        if (actualHtml.contains(istenenKelime3)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        driver.close();


    }
}
