package com.evershop.utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	public DataProviderClass() {
		
	}
	
	@DataProvider(name="dataSuccesfullRegister")
    public Object[][] registerSuccessDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Register-01");
        return arrObj;
    }
	
	@DataProvider(name="dataObligatoryFields")
    public Object[][] obligatoryFieldsDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Register-02");
        return arrObj;
    }
	
	@DataProvider(name="dataValidEmail")
    public Object[][] invalidEmailDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Register-03");
        return arrObj;
    }

	@DataProvider(name="dataValidPassword")
    public Object[][] invalidPasswordlDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Register-04");
        return arrObj;
    }

	

	@DataProvider(name="dataSuccessfullLogin")
    public Object[][] loginSuccessDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Login-01");
        return arrObj;
    }
	
	@DataProvider(name="dataCorrectCredentials")
    public Object[][] correctCredentialsDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Login-02");
        return arrObj;
    }

	@DataProvider(name="dataWithOutCredentials")
    public Object[][] withOutCredentialsDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Login-03");
        return arrObj;
    }

	@DataProvider(name="dataForgotPassword")
    public Object[][] forgotPasslDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Login-05");
        return arrObj;
    }
	
	@DataProvider(name="addItemsToCart")
    public Object[][] addItemsToCartDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Order-01");
        return arrObj;
    }
	
	@DataProvider(name="deleteItemsToCart")
    public Object[][] deleteItemsToCartDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Order-02");
        return arrObj;
    }
	
	@DataProvider(name="checkOutOrder")
    public Object[][] checkOutOrderDP(){
        Object[][] arrObj= getExcelData("src/test/resources/data/DataTable.xlsx","TC-Order-04");
        return arrObj;
    }

	
	  public Object[][] getExcelData(String fileName, String sheetName){
    	Object[][] data=null;
        Workbook wb=null;
        try{
            FileInputStream inputStream= new FileInputStream(fileName);
            String fileExtensionName= fileName.substring(fileName.indexOf("."));

            if(fileExtensionName.equals(".xlsx"))
                wb=new XSSFWorkbook(inputStream);
            else if(fileExtensionName.equals(".xls")){
                wb=new HSSFWorkbook(inputStream);
            }
            Sheet sh=wb.getSheet(sheetName);
            Row row=sh.getRow(0);
            int noOfRows=sh.getPhysicalNumberOfRows(); 
            int noOfCols=row.getLastCellNum();
            Cell cell;
            System.out.println("Se obtuvieron " + (noOfRows-1) +" registros del excel.");
            data=new Object[noOfRows-1][noOfCols];
            for(int i=1;i<noOfRows;i++){// inicia en 1 para brincar el header
                for(int j=0;j<noOfCols;j++){
                    row=sh.getRow(i);
                    cell=row.getCell(j);

                    switch(cell.getCellType()){
                        case STRING:
                            data[i-1][j]=cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i-1][j]=(int)cell.getNumericCellValue();
                            break;
                        case BLANK:
                            data[i-1][j]=null;
                            break;
                        default:
                            data[i-1][j]=null;
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: "+ e.getMessage());
        }
        return data;
    }
	
}