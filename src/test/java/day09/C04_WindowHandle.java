package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowHandle {
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
        //driver.quit();
    }

    // Yeni bir class olusturun: WindowHandle
    // Amazon anasayfa adresine gidin.
    // Sayfa’nin window handle degerini String bir degiskene atayin
    // Sayfa title’nin “Amazon” icerdigini test edin
    // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    // Sayfa title’nin “Walmart” icerdigini test edin
    // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    @Test
    public void test1() throws InterruptedException {
        // Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com/");
        // Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();
        // Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle = driver.getTitle();
        String actualTitle = "Amazon";
        Assert.assertTrue(expectedTitle.contains(actualTitle));
        // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String expectedTitle2 = driver.getTitle();
        String actualTitle2 = "TECHPROEDUCATION";
        Assert.assertFalse(expectedTitle2.contains(actualTitle2));
        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");
        // Sayfa title’nin “Walmart” icerdigini test edin
        String expectedTitle3 = driver.getTitle();
        String actualTitle3 = "Walmart";
        driver.navigate().refresh();
        Assert.assertTrue(expectedTitle3.contains(actualTitle3));
        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "amazon.com";
        Assert.assertTrue(expectedUrl.contains(actualUrl));








    }












}
