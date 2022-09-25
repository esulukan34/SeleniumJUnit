package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {


        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resourcues/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-Turkce baskentler sutununu yazdiralim
        int sonSatir = workbook
                .getSheet("Sayfa1")
                .getLastRowNum(); // burada kac satir oldugunu bulduk
        System.out.println("Satir sayisi : " + sonSatir); //190
        String turkceBaskentler = "";
        for (int i = 0; i <= sonSatir; i++) {
            turkceBaskentler = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }
        System.out.println("********************");
        String ingilizceBaskentler = "";
        for (int i = 0; i <=sonSatir ; i++) {
            ingilizceBaskentler = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(ingilizceBaskentler);
        }
        List<String> list=new ArrayList<>();
        for (int i = 0; i <= sonSatir ; i++) {
            list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
        list.forEach(t-> System.out.println(t));
    }
}
