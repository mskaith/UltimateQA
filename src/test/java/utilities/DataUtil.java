package utilities;



import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import base.BaseTest;

public class DataUtil extends BaseTest {

	@DataProvider(name="dp1")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TCWExcelFile.xlsx");

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;


	}
	
	@DataProvider(name="dp2")
	public Object[][] getData1(Method m) {

		String sheetName = m.getName();
		excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TCWExcelFile.xlsx");

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		Hashtable<String,String> table =null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String,String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}

		return data;

	}
}
