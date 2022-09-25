package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        // Belirtilen satirNo ve sutunNo degerlerini parametre olarak alip o cell'deki datayi konsola yazdiralim.

        int satirNo = 12;
        int sutunNo = 2;
        String dosyaYolu = "src/resourcues/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu); // Olusturmus oldugumuz dosyayi sistemde isleme alir
        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook
                .getSheet("Sayfa1")
                .getRow(satirNo-1)
                .getCell(sutunNo-1).toString();
        // index 0'dan basladigig icin bizden istenen satira ulasabilmek icin
        System.out.println(actualData);
        // Sonucun konsolda yazanla ayni oldugunu dogrulayin
        String expectedData = "Baku";
        Assert.assertEquals(expectedData,actualData);

    }
}
