package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_ManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();




        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Pencere konumu :"+driver.manage().window().getPosition());//(22, 47)
        System.out.println("Pencere olculeri :"+driver.manage().window().getSize()); //(1200, 765)

        // Sayfayi simge durumuna getirin
        driver.manage().window().minimize();// Pencereyi simge durumuna getirir
        // Simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        // Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Pencere maximize konumu :"+driver.manage().window().getPosition());//(0, 25)
        System.out.println("Pencere maximize olculeri :"+driver.manage().window().getSize()); //(1440, 809)
        Thread.sleep(2000);

        // Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        // Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Pencere fullscreen konumu :"+driver.manage().window().getPosition());//(0, 0)
        System.out.println("Pencere fullscreen olculeri :"+driver.manage().window().getSize()); //(1440, 900)
        Thread.sleep(2000);

        // Sayfayi kapatin
        driver.close();




    }
}
