package day13_Cookies_WebTables;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        login();
        //Username : manager
        //Password : Manager1!
        //table( ) metodu oluşturun
        table();

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        /*
        Tabloda <table> tag'i altinda tablonun basligini gosteren <thead> tag, bulunur.
        Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tag'i vardir
        ve basliktaki sutunlara yani hucrelere(cell) de <th> tag'i ile ulasilir
        Basligin altindaki tablolara <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i
        ile sutunlara yani hıcrelere <td> tag'i ile ulasilir
         */
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi : " + sutunSayisi.size());
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("basliklar : " + basliklar.getText());
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body :" + body.getText());
        //printRows() metodu oluşturun //tr
        printRows();
    }

    private void printRows() {
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi : " + satirList.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.stream().forEach(t-> System.out.println(t.getText()));
        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4.satirdaki elementler : " +driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }

}