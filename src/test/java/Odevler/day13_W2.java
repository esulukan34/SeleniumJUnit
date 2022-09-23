package Odevler;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class day13_W2 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // Bir class oluşturun : D18_WebTables
        // login( ) metodun oluşturun ve oturum açın.
        // https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");

        // Username : manager  ○ Password : Manager2!
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(login).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager2!").
                sendKeys(Keys.ENTER).perform();

        // table( ) metodu oluşturun
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        // Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        // printRows( ) metodu oluşturun //tr
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //         4.satirdaki(row) elementleri konsolda yazdırın.
        // printCells( ) metodu oluşturun //td
        // table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        // Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        // printColumns( ) metodu oluşturun
        // table body’sinde bulunan toplam sutun(column) sayısını bulun.
        // Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        //         5.column daki elementleri konsolda yazdırın.
    }



}