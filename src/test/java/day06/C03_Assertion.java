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

public class C03_Assertion {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
         ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
         ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
         ○ logoTest => BestBuy logosunun görüntülendigini test edin
         ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test1(){
        //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test
    public void test2(){
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String sayfaBasligi = driver.getTitle();
        Assert.assertFalse(sayfaBasligi.contains("Rest"));
    }
    @Test
    public void test3(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("//*[@class='logo'][1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void test4(){
        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement FrancaisLinkTest =driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(FrancaisLinkTest.isDisplayed());

    }












}
