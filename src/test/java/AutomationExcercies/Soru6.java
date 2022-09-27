package AutomationExcercies;
import com.github.javafaker.Faker;
import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Soru6 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //   1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
        //4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href=\"/contact_us\"]")).click();
        //5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='title text-center'])[2]")).isDisplayed());
        //6. Adı, e-posta adresini, konuyu ve mesajı girin
        WebElement ad = driver.findElement(By.xpath("//*[@name='name']"));
        faker= new Faker();
        actions.click(ad).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys("Sayfa giris tetleri")
                .sendKeys(Keys.TAB).sendKeys("Sayfanızı test ediyoruz hatalarinizi düzeltiniz!!").perform();
        //7. Dosya yükle
        driver.findElement(By.xpath("//*[@name='upload_file']"))
                .sendKeys("/Users/emresulukan/IdeaProjects/com.Batch81JUnitt/src/test/java/AutomationExcercies/redCar.png");

        //8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@name='submit']")).sendKeys(Keys.ENTER);
        //9. Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();
        //10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()=\"Success! Your details have been submitted successfully.\"])[1]")).isDisplayed());
        //11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
    }
}