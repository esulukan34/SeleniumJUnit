package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme01 {

    /*
    - Amazon sayfasina gidelim
    4 farkli test olusturalim
        a- Url'nin amazon icerdigini test edelim
        b- Title'in facebook icermedigini test edelim
        c- sol ust kosede amazon logosunun gorundugunu test edelim
        d- Url'in www.facebook.com olmadigini test edelim
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }
    @Test
    public void test1(){
    // a- Url'nin amazon icerdigini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Test
    public void test2(){
    // b- Title'in facebook icermedigini test edelim
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
    // c- sol ust kosede amazon logosunun gorundugunu test edelim
        WebElement  logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
