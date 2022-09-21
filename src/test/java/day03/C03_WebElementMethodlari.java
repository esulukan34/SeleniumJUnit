package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C03_WebElementMethodlari {
    public static void main(String[] args) throws InterruptedException {
        //1. Bir class oluşturun : AmazonSearchTest
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



       //a. web sayfasına gidin. https://www. amazon.com/
        driver.get("https://www.amazon.com");

       //b. Search(ara) “city bike”
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);
        Thread.sleep(3000);

       //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(aramaKutusu.getText());

        //2.Yol: Liste ekledik 1.indexi yazdiridk
        List<WebElement> aramaKutusu2 = driver.findElements(By.className("sg-col-inner"));
        String sonucYazisi = aramaKutusu2.get(0).getText();
        System.out.println(sonucYazisi);

        //d. Sadece sonuc yazisini yazdiriniz
        String [] sonucYazisiE = sonucYazisi.split(" ");
        System.out.println("City Bike arama sonucu = " + sonucYazisiE[2]);

        // Sonuc sayisini LAMBDA ile yazdiriniz
        Arrays.stream(sonucYazisi.split(" ")).limit(3).skip(2).forEach(System.out::println);

        //e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın
        //driver.findElement(By.xpath("//img[@class='s-image'][1]")).click();

        //2.Yol: Liste ekledik 1.indexi yazdiridk
        List<WebElement> aramaKutusu3 = driver.findElements(By.className("s-image"));
        aramaKutusu3.get(0).click();

        driver.close();


    }
}
