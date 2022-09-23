package Odevler;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class W02_Video extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video’yu gorecek kadar asagi inin
        WebElement yanTus = driver.findElement(By.xpath("//*[@class='site-header clearfix']"));
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        // videoyu izlemek icin Play tusuna basin
        WebElement youtubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        // videoyu calistirdiginizi test edin
    }
}
