package ey.manila.qa.automation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarUtil {
	private WebDriver calDriver;
	public WebElement monthField;
	public WebElement yearField;
	public WebElement nextBtn;
	public WebElement acceptBtn;
	
	public String month;
	public String year;
	public String day;

	//public final WebElement securityOverrideElement;
	
	DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy");
	
	public CalendarUtil(WebDriver driver, String strInputDate) {
		this.calDriver = driver;

		//securityOverrideElement =  driver.findElement(By.id("overridelink"));
		
		monthField = driver.findElement(By.xpath("//*[@id='sMonth']"));
		yearField = driver.findElement(By.xpath("//*[@id='sYear']"));
		nextBtn = driver.findElement(By.xpath("//*[@id='mainDiv']/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr/td[3]/img"));
		acceptBtn = driver.findElement(By.xpath("//*[@id='mainDiv']/tbody/tr[2]/td/div/input[1]"));
	}
	
	public CalendarUtil(WebDriver driver) {
		this.calDriver = driver;
	}
		
	public String getMonth(String strInputDate) {
		LocalDate targetDate = LocalDate.parse(strInputDate, dateFormat);
		String month = targetDate.getMonth().name();
		return month;
	}
	
	public String getDay(String strInputDate) {
		LocalDate targetDate = LocalDate.parse(strInputDate, dateFormat);
		int day = targetDate.getDayOfMonth();
		
		return String.valueOf(day);
	}
	
	public String getYear(String strInputDate) {
		LocalDate targetDate = LocalDate.parse(strInputDate, dateFormat);
		int year = targetDate.getYear();
		
		return String.valueOf(year);
	}
	
	public void navigateToTargetMonth(String targetMonth){
		String currentSelectedMonth = monthField.getAttribute("value");
		
		while(!currentSelectedMonth.equalsIgnoreCase(targetMonth)){
			nextBtn.click();
			WebDriverWait screenWait = new WebDriverWait(calDriver, 10);
			screenWait.until(ExpectedConditions.elementToBeClickable(monthField));
			currentSelectedMonth = monthField.getAttribute("value");
		}
	}
	
	public void setYearValue(String targetYear) {
		JavascriptExecutor js = (JavascriptExecutor) calDriver;
		js.executeScript("document.getElementById(\"" + yearField.getAttribute("id") + "\").value = '" + targetYear + "'");
	}
	
	public void selectDay(String targetDay) {
		WebElement dayField = null;
		for(int ctr=0; ctr <= 35; ctr++){
			String optionStr = calDriver.findElement(By.xpath("//*[@id='calDay" + ctr + "']")).getText();
			if(optionStr == null)
				optionStr = "";
			if(optionStr.equals(targetDay)){
				dayField = calDriver.findElement(By.xpath("//*[@id='calDay" + ctr + "']"));
				dayField.click();
				break;
			}	
		}
		acceptBtn.click();
	}

	public String addDays(String oldDate, int days){
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE.ofPattern("MM-dd-yyyy");
		LocalDate newDate = LocalDate.parse(oldDate, df).plusDays(days);
		
		return newDate.format(df);	
	}
	
}
