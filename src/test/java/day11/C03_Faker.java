package day11;

import com.github.javafaker.Faker;
import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C03_Faker extends TestBaseBeforeAfter {
    // “surname” giris kutusuna bir soyisim yazin
    // “email” giris kutusuna bir email yazin
    // “email” onay kutusuna emaili tekrar yazin
    // Bir sifre girin
    // Tarih icin gun secin
    // Tarih icin ay secin
    // Tarih icin yil secin
    // Cinsiyeti secin
    // Kaydol butonuna basın
    // Sayfayi kapatin
    @Test
    public void test1() {
        // "https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        // “create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // “firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        String email = faker.internet().emailAddress();
        actions.click(isim).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("5")
                .sendKeys(Keys.TAB).sendKeys("Oca")
                .sendKeys(Keys.TAB).sendKeys("1986")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT)
                .sendKeys(Keys.ENTER).perform();

    }
}
