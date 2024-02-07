package io.util;
import org.apache.poi.ss.usermodel.Cell;
import  org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
XSSFWorkbook workbook;
XSSFSheet sheet;
public ExcelUtil (String filePath, int sheetIndex){
    String path = "/home/aditya/Downloads/PetsData.xlsx";

    try{
        workbook = new XSSFWorkbook(path);
        sheet = workbook.getSheetAt(0);
    }
    catch (IOException e){
        System.out.println(e);
    }
}
public List<Pet> readFile(){
List<Pet> fileData = new ArrayList<>();

for(int i=1; i<sheet.getPhysicalNumberOfRows()-1;i++){
    if("N".equalsIgnoreCase(sheet.getRow(i).getCell(1).toString())){
        continue;
    }

    Pet pet = new Pet();
    pet.setTCID(sheet.getRow(i).getCell(0).toString());
    pet.setExcecution(sheet.getRow(i).getCell(1).toString());
    pet.setPetId(sheet.getRow(i).getCell(2).toString());
    pet.setAdditionalMetaData(sheet.getRow(i).getCell(3).toString());
    pet.setFilepath(sheet.getRow(i).getCell(4).toString());

    fileData.add(pet);
}

return  fileData;
}

public void updateTestStatus(Pet petTestData){
    Cell cell = sheet.getRow(Integer.parseInt(petTestData.getTCID())).getCell(5);
    cell.setCellValue(petTestData.getStatus());

        try {
            FileOutputStream fileOut = new FileOutputStream("/home/aditya/Downloads/PetsData.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Cell value updated successfully.");
        }
        catch (IOException e){
            System.out.println(e);
        }
}
}


