package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_IlkTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        /*
        1- Amazon sayfasina gidiniz
        2- Basligin "Amazon" icerdigini test ediniz
        3- Url'nin amazon icerdigini test ediniz
        4- Sayfayi kapatiniz
         */

        // Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();

        // Basligin "Amazon" icerdigini test ediniz
        String actualTitle = driver.getTitle();
        String istenenKelime1 = "Amazon";
        if (actualTitle.contains(istenenKelime1)){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAILED");

        // Url'nin amazon icerdigini test ediniz
        String actualUrl = driver.getCurrentUrl();
        String istenenKelime2 = "amazon";
        if (actualUrl.contains(istenenKelime2)){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAILED");

        //Sayfayi kapatiniz
        driver.close();



    }
}
