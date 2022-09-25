package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resourcues/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // Olusturmus oldugumuz dosyayi sistemde isleme alir

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); // workbook objesiyle fis objesi ile akisa aldigimiz bie excell dosyasi create ettik
        //- WorkbookFactory.create(fileInputStream)

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String actualData = workbook
                .getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
        System.out.println(actualData);

    }
}
