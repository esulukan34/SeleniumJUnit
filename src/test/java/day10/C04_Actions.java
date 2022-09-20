package day10;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    // Yeni bir class olusturalim: MouseActions1
    // https://the-internet.herokuapp.com/context_menu sitesine gidelim
    // Alert’te cikan yazinin “You selected a context menu” oldugunu
    // 3- Cizili alan uzerinde sag click yapalim
    // test edelim.
    // Tamam diyerek alert’i kapatalim
    // Elemental Selenium linkine tiklayalim
    // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.navigate().to("https:////the-internet.herokuapp.com/context_menu");
        // Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions= new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();
        Thread.sleep(2000);
        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);
        Assert.assertEquals("You selected a context menu",actualAlertYazisi);
        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        driver.findElement(By.xpath("//h1")).click();
        String expectedH1 = "Elemental Selenium";
        String actualH1 = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedH1,actualH1);
        driver.navigate().refresh();

    }
}
