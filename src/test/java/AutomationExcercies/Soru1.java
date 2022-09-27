package AutomationExcercies;

import com.github.javafaker.Faker;
import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class Soru1 extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        WebElement kayit= driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        kayit.click();
        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        //6. Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Ali Can");
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("alicannn@gmail.com", Keys.ENTER);
        //7. 'Kaydol' düğmesini tıklayın

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();
        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        WebElement kayitOl = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        faker = new Faker();
        actions.click(kayitOl).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys("5")
                .sendKeys(Keys.TAB).sendKeys("January")
                .sendKeys(Keys.TAB).sendKeys("1986").perform();
        Thread.sleep(1000);

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[text()='Sign up for our newsletter!']")).click();
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[text()='Receive special offers from our partners!']")).click();
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        WebElement isim = driver.findElement(By.xpath("//*[@id='first_name']"));
        faker = new Faker();
        actions.click(isim).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys("Amazon")
                .sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("United State").sendKeys(Keys.TAB)
                .sendKeys("Texas").sendKeys(Keys.TAB)
                .sendKeys("Dallas").sendKeys(Keys.TAB)
                .sendKeys("60100").sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //13. 'Hesap Oluştur düğmesini' tıklayın
        //14. 'HESAP OLUŞTURULDU!' görünür
        driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed();

        //15. 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed();

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();

        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='DELETE']")).isDisplayed();


    }
}
