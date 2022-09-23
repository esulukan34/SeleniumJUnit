package Odevler;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class day13_W3 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // Bir Class olusturun D19_WebtablesHomework
        // “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // Headers da bulunan department isimlerini yazdirin
        //WebElement headers = driver.findElement(By.xpath("//*[text()='Department']"));
        //System.out.println(headers.getText());
        // sutunun basligini yazdirin
        WebElement headers = driver.findElement(By.xpath("//*[@class='rt-tr']"));
        System.out.println(headers.getText());
        // Tablodaki tum datalari yazdirin

        // Tabloda kac cell (data) oldugunu yazdirin
        // Tablodaki satir sayisini yazdirin
        // Tablodaki sutun sayisini yazdirin
        // Tablodaki 3.kolonu yazdirin
        // Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        // Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
    }

}
