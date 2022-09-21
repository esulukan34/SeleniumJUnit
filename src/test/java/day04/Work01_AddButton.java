package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Work01_AddButton {

     public static void main(String[] args) throws InterruptedException {
         System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
         driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

         //2- Add Element butonuna 10 kez basinız
         int sayi = 9;
         int sayac =0;
         while(sayac<=sayi) {
             driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
             sayac++;
         }
         Thread.sleep(3000);

         //3- 10 kez Add element butonuna basıldığını test ediniz
         List<WebElement> addElement = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
         if (addElement.size()==10){
             System.out.println("Add element butonuna 10 defa basildi");
         }else
             System.out.println("Test FAILED");
         Thread.sleep(3000  );

         // 4 - Delete butonuna görünmeyene kadar basınız
         int sayi2 = 1;
         while(sayac>=sayi2) {
             driver.findElement(By.xpath("//*[@class='added-manually']")).click();
             sayi2++;
         }

         //5- Delete butonunun görünmediğini test ediniz
         WebElement expectedResult = driver.findElement(By.className("no-js"));
         String actualResult = expectedResult.getText();
         if (!actualResult.contains("delete")){
             System.out.println("Test PASSED");
         }else
             System.out.println("Test FAILED");

         // sayfayi kapatin
         driver.close();





     }

}
