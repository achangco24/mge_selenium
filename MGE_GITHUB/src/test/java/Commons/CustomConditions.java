package Commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import aut.entity.EntityFrameObjects;

public class CustomConditions {
	
	
	public static ExpectedCondition<Boolean> checkWindowReadyState() {
	    return new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        Object a =  ((JavascriptExecutor) driver)
	                 .executeScript("return document.readyState");
	        
	        if (a.toString().trim().equals("complete")){
	        	//System.out.println("Page loaded");
	        	return true;
	        
	        }else{

	        	return false;
	        }
	      }
	    };
	  }
	
	public static ExpectedCondition<Boolean> checkElementExists(final String element, final WebElement frame) {
	    return new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	    	driver.switchTo().defaultContent();
	    	driver.switchTo().frame(frame);
	        Boolean result = (Boolean) ((JavascriptExecutor) driver)
	                 .executeScript("return !!document.getElementById('"+ element + "') ? true : false");

	        System.out.println(result);
	        return result; 
	    }
	  };
	}
}
