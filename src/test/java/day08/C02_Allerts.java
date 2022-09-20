package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {
    /*
    Bir web sirtesine girdimizde karsimiza bir uyari mesaji yada bir butona tikladigimizda bir uyari(alert)
    cikabilir. Eger bu uyarıya incele(sag tik-inspect) yaoabiliyorsak bu tur alertt'lere HTML alert denir
    ve istedigimiz locate'i alabiliriz fakat gelen uyari kutusuna mudahale (sag tik-incele) edemiyorsak
    bu tur alert'lere jd alert denir. js alert'lere mudahale edebilmek icin
    - tamam yada ok icin --> driver.switchTo().alert().accept() kullanilir
    - iptal icin --> driver.switchTo().alert().dismiss() kullanilir
    - Alert icindekiğ mesaji almak icin --> driver.switchTo().alert().getText() kullanilir
    - Alert bizde bir metin istiyorsa --> driver.switchTo().alert().sendKeys() kullanilir
     */
    /*
    Bir class olusturun: Alerts

     Bir metod olusturun: acceptAlert
     1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
     Bir metod olusturun: dismissAlert
     2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
     “successfuly” icermedigini test edin.
     Bir metod olusturun: sendKeysAlert
     3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj, actualMesaj);

    }

    @Test
    public void test2() throws InterruptedException {
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının  “successfuly” icermedigini test edin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick ='jsConfirm()']")).click();
        // Allert uzerindeki mesaji alin
        System.out.println("2.butonun alert mesaji : " + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String actualMesaj = driver.findElement(By.className("no-js")).getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(expectedMesaj.contains(actualMesaj));

    }

    @Test
    public void test3() throws InterruptedException {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick ='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Emre");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        WebElement isim = driver.findElement(By.xpath("//*[@id ='result']"));
        String actualIsim = isim.getText();
        String expectedIsim = "Emre";
        Assert.assertTrue(actualIsim.contains(expectedIsim));
    }
}
