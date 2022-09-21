package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_GetMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //Arama kutusunu locate ediniz
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //Arama kutusunun tagName'inin input olduğunu test ediniz
        String expectedTagname = "input";
        String actualTagname = aramaKutusu.getTagName();
        if (actualTagname.equals(expectedTagname)){
            System.out.println("tagName testi PASSED");
        }else
            System.out.println("tagname testi FAILED");

        //Arama kutusunun name atributu'nun değerinin field-keywords olduğunu test ediniz
        String expectedAtributuName = "field-keywords";
        String actualAtributuName = aramaKutusu.getAttribute("name");
        if(actualAtributuName.equals(expectedAtributuName)){
            System.out.println("Atributu testi PASSED");
        }else
            System.out.println("Atributu testi FAILED");

        // arama kutusunun konumunu yazdiriniz
        System.out.println("arama kutusunun konumu : " + aramaKutusu.getLocation());

        //Sayfayı kapatınız
        driver.close();

    }
}
