package Odevler;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class W01_KeybordActions extends TestBaseBeforeAfter {




    @Test
    public void test() throws InterruptedException {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hover = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hover).perform();
        Thread.sleep(2000);
        // Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
        // Popup mesajini yazdirin
        System.out.println("Popup mesaji : "+driver.switchTo().alert().getText());
        Thread.sleep(2000);
        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        // “Click and hold" kutusuna basili tutun
        WebElement clickOnHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickOnHold).perform();
        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickOnHold.getText());
        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClick).perform();

    }
}
