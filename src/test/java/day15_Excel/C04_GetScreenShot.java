package day15_Excel;

import com.github.javafaker.Faker;
import day10_utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;


public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void Test() throws IOException {
        // Amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https://www.bestbuy.com");


        /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
        tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz
         */

        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaResmi = tss.getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/.jpeg" + faker.name()));
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg" ));

        driver.close();

    }
}
