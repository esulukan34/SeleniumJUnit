package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_WindowHandle {
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



    @Test
    public void test1() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "amazon";
        Assert.assertTrue(expectedUrl.contains(actualUrl));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = driver.getTitle();
        String actualTitle = "Best Buy";
        Assert.assertTrue(expectedTitle.contains(actualTitle));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "java";
        String actualSonuc = aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed();
        //9- Sayfaları Kapatalım

    }
}
