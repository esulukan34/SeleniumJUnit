package Odevler;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class W03_AmazonShopping extends TestBaseBeforeAfter {


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
        WebElement ddmElektronik = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddmElektronik);
        select.selectByIndex(10);

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("arama sonucu : " + aramaSonucu.getText());

        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(aramaSonucu.getText().contains("iphone"));

        // ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).click();

        // ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        WebElement urunTitle = driver.findElement(By.xpath("//*[@id='title']"));
        //WebElement fiyat = driver.findElement(By.xpath("//*[@class='go2443863843 grid items-center w-full h-full gap-2 pr-2 m-auto max-w-[1200px]']"));


        // Test03
        // yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com");

        // dropdown’dan bebek bölümüne secin
        WebElement ddmBebek = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select1 = new Select(ddmBebek);
        select1.selectByIndex(3);

        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu1 = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu1.sendKeys("bebek puset", Keys.ENTER);
        WebElement aramaSonucu1 = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("arama sonucu : " + aramaSonucu1.getText());

        // sonuç yazisının puset içerdiğini test edin
        Assert.assertTrue(aramaSonucu1.getText().contains("bebek puset"));

        // 5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();

        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        WebElement pusetTitle = driver.findElement(By.xpath("//*[@id='productTitle']"));
        driver.findElement(By.xpath("//*[@class='a-section a-spacing-none aok-align-center']"));
        WebElement sepetPuset = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
        sepetPuset.click();

        // Test 4
        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
}
