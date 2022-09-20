package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Work01 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    // 2. 'http://automationexercise.com' url'sine gidin
    public void method() {
        driver.get("https://automationexercise.com");
    }
    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    //@Test
    //public void method1() {
        //WebElement anasayfa = driver.findElement(By.xpath("//*[@id='slider']"));
    }


