package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkClass {
    public static void main(String[] args) {
        /*
        En temel haliyle bir otomasyon yapmak icin
        Class'imiza otomasyon icin gerekli olan webdriver'in
        yerine gostermemiz gerekir. Bunun icin Java kutuphanesinden
        System.setProperty() methodunu kullaniriz
        ve method'un icine ilk olarak driver'i yazariz. İkinci olarak
        onun fiziki yolunu kopyalariz.
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println("Actual title :" + driver.getTitle()); // Gidilen sitenin basligini yazdirir

        System.out.println("Actual url : " + driver.getCurrentUrl());// Gidilen sitenin url'ini getirir

        System.out.println(driver.getPageSource()); // Gidilen sitenin kaynak kodlarini getirir

    }
}
