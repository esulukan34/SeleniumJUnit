package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    static WebDriver driver;
    /*
    - Amazon sayfasina gidelim
    3 farkli test olusturalim
        a- Url'nin amazon icerdigini test edelim
        b- Title'in facebook icermedigini test edelim
        c- sol ust kosede amazon logosunun gorundugunu test edelim
        d- Url'in www.facebook.com olmadigini test edelim
     */
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
        driver.close();
    }
    @Test
    public void test1() {
    //a- Url'nin amazon icerdigini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
    @Test
    public void test2(){
    //b- Title'in facebook icermedigini test edelim
    String expectedTitle = "facebook";
    String actualTitle = driver.getTitle();
    Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
    //c- sol ust kosede amazon logosunun gorundugunu test edelim
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogo.isDisplayed());
    }
    @Test
    public void test4(){
    // d- Url'in www.facebook.com olmadigini test edelim
    String expectedUrl2 = "www.facebook.com";
    String actualUrl2 = driver.getCurrentUrl();
    Assert.assertNotEquals(actualUrl2,expectedUrl2);
    }

}
