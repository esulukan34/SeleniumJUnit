package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxTest {
    WebDriver driver;

    @Before
    // Before notasyonu her testten önce çalışır
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /*
      1. Bir class oluşturun : CheckBoxTest
      2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
      a. Verilen web sayfasına gidin.
      https://the-internet.herokuapp.com/checkboxes
      b. Checkbox1 ve checkbox2 elementlerini locate edin.
      c. Checkbox1 seçili değilse onay kutusunu tıklayın
      d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */
    @Test
    public void method() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@type='checkbox'][2]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(2000);
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(2000);
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
    }

    @After
    //After notasyonu her testten sonra çalışır
    public void tearDown() {
        driver.close();
    }
}
