package src.com.assesment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * 
 */
public class Login extends Util {

	private XSSFWorkbook Workbook;
	private XSSFSheet sheet;
	private XSSFCell cell;
	private static Login obj;

	@Test
	public void readFile() throws IOException, InterruptedException {
		// change the test data file path accordingly
		File file = new File("E:\\Eclipse_SeleniumWorkSpace\\Trucknet_Assesment\\Trucknet_Assesment\\TestData\\TestData.xlsx");

		FileInputStream fis = new FileInputStream(file);
		Workbook = new XSSFWorkbook(fis);
		sheet = Workbook.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			cell = sheet.getRow(i).getCell(0);
			DataFormatter formatter = new DataFormatter();
			String username = formatter.formatCellValue(cell);
			cell = sheet.getRow(i).getCell(1);
			String password = formatter.formatCellValue(cell);
			
			//setting up the browser to connect to facebook.com
			obj.setupBrowser("https://www.facebook.com");

			driver.findElement(By.cssSelector("#email")).sendKeys(username);
			System.out.println(username);

			driver.findElement(By.name("pass")).sendKeys(password);
			System.out.println(password);

			driver.findElement(By.name("login")).click();
			Thread.sleep(3000);

		}
	}

	@BeforeTest
	public void beforeTest() {
		obj = new Login();

	}

	@AfterTest
	public void AfterTest() {
		// closing the driver
		driver.close();

	}

}
