package day02;

public class C04_duzeltme {
    /*

   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.com");
        //Amazonda nutella aratınız
        //WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //aramaKutusu.sendKeys("Nutella"+ Keys.ENTER); // id uniqe olduğu bu sorunsuz çalışır
        //WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));
        //aramaKutusu.sendKeys("Nutella"+ Keys.ENTER); // uniqe olduğu için sorunsuz çalışır
        //WebElement aramaKutusu = driver.findElement(By.className("nav-search-field "));
        /*
        Bu locatar çalismadı
        Locatar alırken gözümüzden kaçan detaylar olabilir
        aldığımız bir locatar çalışmazsa alternatif locatorlar denemeliyiz
         */
    /*
        driver.findElement(By.partialLinkText("oducts on Amazon")).click(); // a tag'ındaki link isminden istediğimiz bir parçayla locate edebiliriz
        driver.findElement(By.linkText("Sell products on Amazon")).click();
     */

}
