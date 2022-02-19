package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basics {
	
	public static String excelRead(int rowNum, int cellNum) throws IOException {
		

		
		//Give the Location of the file
		File source = new File("C:\\Users\\mari\\eclipse-workspace\\Task10\\ExcelFiles\\DatadrivProject.xlsx");
				
				
		//Read the File
		FileInputStream fin = new FileInputStream(source);
				
		//WorkBook
		Workbook wrkbook = new XSSFWorkbook(fin);
				
		//Get A Sheet
		Sheet sheet = wrkbook.getSheet("Sheet1");
				
			Row row = sheet.getRow(rowNum);
				
			Cell cell = row.getCell(cellNum);
						
			String value = "";
						
			int cellType = cell.getCellType();
						
				if (cellType==1) {
				//cell type is String 
				value = cell.getStringCellValue();
			}
						
				else if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(dateCellValue);
			}
						
				else {
				double num = cell.getNumericCellValue();
				//NewDatatype ref = (newDatatype)oldvariable;
				long l = (long)num;
				value = String.valueOf(l);
			}
				
				return value;
						
		}
	
		public static WebDriver driver;
		
		public static Actions a;
		
		public	static JavascriptExecutor js;
		
		public 	static Robot r;
		
		public	static Select s;
	
	public static void browserLaunch() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
	}
	
	public static void windowsMax() {
		driver.manage().window().maximize();
	}
	
	public static void urlLaunch(String url) {	
		driver.get(url);
	}
	
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public static void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	public static void closingBrowser() {
		driver.quit();
	}
	
	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
	
	public static void getAttribute(WebElement element, String text) {
		String attribute = element.getAttribute(text);
		System.out.println("You're Order ID is : "+attribute);
	}
	
	public static void fillText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void click(WebElement element) {
		element.click();
	}
	
	public static void mouseHover(WebElement element) {
		 a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public static void dragAnddrop(WebElement element, WebElement element1) {
		a = new Actions(driver);
		a.dragAndDrop(element, element1);
	}
	
	public static void doubleeClick(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public static void contextClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public static void KeyboardActions(int keycode, int keycode1) throws AWTException {
		r = new Robot();
		r.keyPress(keycode);
		r.keyRelease(keycode1);
	}
	
	public static void doublePress( int keycode, int keycode1) throws AWTException {
		r = new Robot();
		r.keyPress(keycode);
		r.keyPress(keycode1);
	}
	
	public static void doubleRelease(int keycode, int keycode1) throws AWTException {
		r = new Robot();
		r.keyRelease(keycode);
		r.keyRelease(keycode1);
	}
	
	public static void screenShot(String SS) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:\\Users\\mari\\eclipse-workspace\\FrameWork3\\ScreenShot\\"+SS+".png");
		FileUtils.copyFile(source, Destination); 
	}
	
	public static void jsFillText(String string, WebElement args) {
		js = (JavascriptExecutor)driver;
		js.executeScript(string, args);
	}
	
	public static void jsScrollDown(String string, WebElement args) {
		js = (JavascriptExecutor)driver;
		js.executeScript(string, args);
	}
	
	public static void jsScrollUp(String string, WebElement args) {
		js = (JavascriptExecutor)driver;
		js.executeScript(string, args);
	}
	
	public static void jsClick(String string, WebElement args) {
		js = (JavascriptExecutor)driver;
		js.executeScript(string, args);
	}
	
	public static void sleep(long secs) throws InterruptedException {
		Thread.sleep(secs);
	}
	
	public static void timeOut(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public static void selectByVisibleText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public static void selectByValue(WebElement element,String value) {
		s = new Select(element);
		s.selectByValue(value);
	}
	
	public static void selectByIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}
	
	public static void findSysdate() {
		
		Date d = new Date();
		System.out.println(d);
	}

	public static void reFresh() {
		
		driver.navigate().refresh();
	}

}
