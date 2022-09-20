package day10;

import day10_utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_ActionsClass extends TestBaseBeforeAfter{
    @Test
    public void test1() {
        // amazon sayfasina gidelim
        driver.get("https://amazon.com");
        // Account menusunden create a list linkine tiklayalim
        Actions actions = new Actions(driver);
        WebElement accountLink = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        actions.moveToElement(accountLink).perform();
        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek actions.moveToElement()
        methodunu kullanmamız gerekir. Aksi takdirde html kodları arasında web elementi bulur ama ulaşamadığı
        için ElemenNotInteractableException: element not interactable exception'i fırlatır
        */
        driver.findElement(By.xpath("(//*[@class='nav-text'])[1]")).click();
    }
}
