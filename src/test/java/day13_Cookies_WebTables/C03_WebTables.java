package day13_Cookies_WebTables;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_WebTables extends TestBaseBeforeAfter {
    /*
    Bir onceki class'taki adrese gidelim
    login() methodunu kullanarak sayfaya giris yapalim
    input olarak verilen satir ve sutun sayisina sahip
    cell'deki texti yazdiralim.

    int satir = 3;
    int sutun = 4;

     */

    @Test
    public void test() {
        login();
        int satir = 3;
        int sutun = 4;
        WebElement arananCell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(arananCell);
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }
}
