package day11;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class W03_ extends TestBaseBeforeAfter {


    @Test
    public void test1() {
        // -  amazon gidin
        driver.get("https://www.amazon.com");
        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        for (WebElement w : drops) {
            System.out.println(w.getText());
        }
        // dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println(drops.size());//28
        int expectedSayi = 40;
        Assert.assertNotEquals(drops.size(), expectedSayi);

        // Test02
        // dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByIndex(10);

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("arama sonucu : " + aramaSonucu.getText());

        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(aramaSonucu.getText().contains("iphone"));

        // ikinci ürüne relative locater kullanarak tıklayin

        // ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        // Test03
        // yeni bir sekme açarak amazon anasayfaya gidin
        // dropdown’dan bebek bölümüne secin
        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        // sonuç yazsının puset içerdiğini test edin
        // 5-üçüncü ürüne relative locater kullanarak tıklayin
        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
}
