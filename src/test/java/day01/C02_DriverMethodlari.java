package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        // Kaynak kpdlarinin icinde "Gateway" kelimesinin oldugunu test ediniz

        String str = driver.getPageSource();
        if(str.contains("Gateway")){
            System.out.println("Sayfada Gateway var");
        }else{
            System.out.println("Aranan kelime yok");
        }
        /*2.yol:
        String istenenKelime = "Gateway";
        if (driver.getPageSource().contains("istenenKelime")){
            System.out.println("PageSource testi PASSED");
        }else
            System.out.println("PageSource testi FAILED");
        */
        driver.close(); // sayfayi kapatir
        // driver.quit()--> Birden fazla sayfa varsa hepsini kapatir
    }
}
