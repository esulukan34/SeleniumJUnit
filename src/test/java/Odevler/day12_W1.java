package Odevler;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;

public class day12_W1 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("https://webdriveruniversity.com/IFrame/index.html");
        // “Our Products” butonuna basin
        driver.findElement(By.xpath("//*[text()='Our Products']"));
        // “Cameras product”i tiklayin

        // Popup mesajini yazdirin

        // “close” butonuna basin
        // "WebdriverUniversity.com (IFrame)" linkini tiklayin
        // "http://webdriveruniversity.com/index.html" adresine gittigini test edin
    }
}
