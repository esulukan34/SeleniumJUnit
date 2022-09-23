package day12;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_FileExistsUpload extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
         /*
    1- https://the-internet.herokuapp.com/upload adresine gidelim
    2- chooseFile butonuna basalim
    3- Yuklemek istediginiz dosyayi secelim.
    4- Upload butonuna basalim.
    5- “File Uploaded!” textinin goruntulendigini test edelim.
      */
        // 1- https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // 2- chooseFile butonuna basalim
        WebElement upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
        //3- Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "/Users/emresulukan/Desktop/C01.txt";
        Thread.sleep(2000);
        upload.sendKeys(dosyaYolu);
        //4- Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        //5- “File Uploaded!” textinin goruntulendigini test edelim.
        String actualWord = driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();
        String expectedWord = "File Uploaded!";
        Assert.assertEquals(expectedWord, actualWord);
    }
}