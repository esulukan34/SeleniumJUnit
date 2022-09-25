package day11_Faker;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C02_KeybordActions extends TestBaseBeforeAfter {


    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    // 4- Kaydol tusuna basalim

    @Test
    public void test1() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys("Emre");
        actions.sendKeys(Keys.TAB).sendKeys("Sulukan")
                .sendKeys(Keys.TAB).sendKeys("emre@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("emre@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("123456emre")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("5")
                .sendKeys(Keys.TAB).sendKeys("Oca")
                .sendKeys(Keys.TAB).sendKeys("1986")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT)
                .sendKeys(Keys.ENTER).perform();

    }
}
