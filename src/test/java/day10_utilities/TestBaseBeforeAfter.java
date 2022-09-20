package day10_utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public abstract class TestBaseBeforeAfter {

    protected WebDriver driver;
    //protected Actions actions;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
        // utilities package'ında abstract class oluşturduk. Buradaki class'ı Utilites package'ındaki
        // class'a extent yaptik.@Before ve @after methodlarını oradaki class'ta olusturdugumuz icin
        // bu sayfada olusturmamıza gerek kalmadı
}
