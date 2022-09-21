package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_WindowHandle {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();

        System.out.println(driver.getWindowHandle()); // CDwindow-8E305F7E295C6B25B6FEFD996E18DC07
        // farkli pencereler arasinda gezinebilmek icin getWindowHandle() method'unu kullaniriz

    }
}
