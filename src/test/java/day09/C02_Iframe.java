package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Iframe {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }
    @After
    public void tearDown() {
        driver.close();
    }
    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */
    @Test
    public void test1() throws InterruptedException {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //● Bir metod olusturun: iframeTest

        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());

        // ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement texBox = driver.findElement(By.id("mce_0_ifr"));// Frame'e gecis yapmadan once orayi id ile locate ettik
        driver.switchTo().frame(texBox);// Locate ettigimi frame'e gecmek icin bu methodu kullaniliriz
        Thread.sleep(2000);
        WebElement texBoxFrame = driver.findElement(By.xpath("//p"));
        texBoxFrame.clear(); // clear methodu texbox'in icini temizler
        Thread.sleep(2000);
        texBoxFrame.sendKeys("Merhaba Dunya");



        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent(); // frame'den cikmamiz gerekiyor ki diger yerleri locate edebilelim
        WebElement seleniumYazisi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(seleniumYazisi.isDisplayed());
        System.out.println(seleniumYazisi.getText());


    }
}
