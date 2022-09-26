package AutomationExcercies;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Soru5 extends TestBaseBeforeAfter {
    @Test
    public void name() {

    // 1. Tarayıcıyı başlatın
    // 2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
    // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='slider']")).isDisplayed());
    // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
    // 5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
    // 6. Adı ve kayıtlı e-posta adresini girin
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Veli Can");
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("veliiiiii@gmail.com",Keys.ENTER);
    // 7. 'Kaydol' düğmesini tıklayın
    // 8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());

    }

}
