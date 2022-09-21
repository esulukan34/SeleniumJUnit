package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_SinifCalismasi {

    //Main method oluşturun ve aşağıdaki görevi tamamlayın.
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        //b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();

        //c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextbox =driver.findElement(By.id("session_email"));
        WebElement password = driver.findElement(By.id("session_password"));
        WebElement signIn = driver.findElement(By.name("commit"));

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //i. Username : testtechproed@gmail.com
        emailTextbox.sendKeys("testtechproed@gmail.com");

        //ii. Password : Test1234!
        password.sendKeys("Test1234!");

        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        signIn.click();

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement bulunacakKelime = driver.findElement(By.xpath("//a[@class='nav-item nav-link'][1]"));
        if(bulunacakKelime.isDisplayed()){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAILED");

        WebElement bulunacakKelime2 = driver.findElement(By.xpath("//a[@class='nav-item nav-link'][2]"));

        if(bulunacakKelime2.isDisplayed()){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAILED");

        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> tag = driver.findElements(By.tagName("a"));
        System.out.println("Sayfada "+ tag.size() + " tane link var");

        //4. Linkleri yazdiriniz

        for (WebElement w: tag ) {
            System.out.println(w.getText());
        }
        //5. Linkleri LAMBDA ile yazdiriniz
        System.out.println("Lambda ile ");
        tag.forEach(t-> System.out.println(t.getText()));

        //6. sayfayi kapatiniz
        driver.close();

    }
}
