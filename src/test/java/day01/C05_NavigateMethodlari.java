package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com");
        // driver.navigate().to() methodu sayfada ileri geri yapicaksak kullanilir
        // driver.get() methodu gibi bizi istedigimiz Url'e goturur

        driver.navigate().to("https://www.facebook.com");
        // Tekrar amazon sayfasina donelim
        Thread.sleep(3000);
        driver.navigate().back(); // bir onceki sayfaya geri doner

        // Tekrar facebook sayfasina gidelim
        Thread.sleep(3000);
        driver.navigate().forward(); // back ile donulen sayfadan geri doner

        // facebook sayfasini
        driver.navigate().refresh();

        driver.close();


    }
}
