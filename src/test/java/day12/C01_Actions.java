package day12;

import day10_utilities.TestBaseBeforeAfter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Automationxercise.com sitesine gidelim
        driver.get("https://automationexercise.com");
        //Product bolumune girelim
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        //ilk urune tiklayalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@class='fa fa-plus-square']")).click();
    }
}