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

public class C04_Assertion {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    @Test
    public void test() {
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void test1() {
        //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test2() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[1]"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void test3() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitle1 = "youtube";
        String actualTitle1 = driver.getTitle();
        Assert.assertFalse(actualTitle1.contains(expectedTitle1));
    }
}

