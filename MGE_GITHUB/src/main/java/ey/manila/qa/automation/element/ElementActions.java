/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Element Actions
 * 
 *************************************************************************************
 *  
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * YYYY-MM-DD	IN		Reason text.    
 * 
 *************************************************************************************
 */
package ey.manila.qa.automation.element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * <p>Contains a collection of custom actions for a {@link org.openqa.selenium.WebElement} object.
 * These custom actions are usually those that are not readily provided by the WebElement class.</p>
 * 
 * <p>The custom actions can be accessed as static methods.</p>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-05-29
 * @see org.openqa.selenium.WebElement
 */
public class ElementActions {
	/**
	 * <p>Selects or deselects an input checkbox.</p>
	 * @param isSelect Boolean flag. TRUE if checkbox is to be selected. Otherwise, set to FALSE
	 * @param element {@link org.openqa.selenium.WebElement} representation of the target checkbox
	 */
	public static void tickAs(boolean isSelect, WebElement element) {
		if(isSelect && element.isSelected() ||			// Element should be checked, but is already checked
			!isSelect && !element.isSelected()) {			// Element should be unchecked, but is already unchecked
			return;
		}
		
		element.click();
	}
	
	/**
	 * <p>Waits for the target attribute to become available in the input WebElement.</p>
	 * @param attribute String representation of the attribute to be checked
	 * @param element {@link org.openqa.selenium.WebElement} representation of the element
	 * where the attribute will be checked
	 */
	public static void waitForAttribute(String attribute, WebElement element) {
		String tempAttribute;
		boolean isAttributePresent = false;
		
		// Check for the presence of the attribute until it becomes available
		while (!isAttributePresent) {
			tempAttribute = element.getAttribute(attribute);
			if (tempAttribute != null) {
				isAttributePresent = true;
			}
		}
	}
	
	/**
	 * <p>Waits for the target attribute to become available in the input WebElement.</p>
	 * @param attribute String representation of the attribute to be checked
	 * @param element {@link ey.manila.qa.automation.element.ElementHandler} representation of the element
	 * where the attribute will be checked
	 * @throws Exception
	 */
	public static void waitForAttribute(String attribute, ElementHandler element) throws Exception {
		ElementActions.waitForAttribute(attribute, element.toWebElement());
	}
	
	/**
	 * <p>Switches to WebDriver to the frame that contains the target WebElement. This method is helpful
	 * when accessing a WebElement in a page that has nested frames.</p>
	 * 
	 * <p><blockquote><b>Important: </b>You might need to call WebDriver.switchTo().defaultContent()
	 * to switch the WebDriver back to the main HTML.</blockquote></p>
	 * 
	 * <p>Some web pages have nested frames in their HTML layout. The WebDriver can only
	 * access a WebElement if the WebDriver is switched to the frame that contains the WebElement.<br>
	 * <strong>Example:</strong><br>
	 * <ul>
	 * 	<li>main HTML Body</li>
	 * 		<ul>
	 * 			<li>Frame1</li>
	 * 				<ul>
	 * 					<li>WebElement1</li>
	 * 				</ul>
	 * 			<li>Frame2</li>
	 * 				<ul>
	 * 					<li>WebElement2</li>
	 * 				</ul>
	 * 		</ul>
	 * </ul>
	 * The WebDriver cannot access <b>WebElement1</b> and <b>WebElement2</b> if the WebDriver
	 * is switched to the <b>main HTML Body</b>. This is because an HTML Frame contains its own set of
	 * HTML structure that is different from other frames and from the main HTML. Thus, a WebElement inside
	 * a frame is residing only within that frame and is inaccessible from another frame.</p>
	 * @param driver {@link org.openqa.selenium.WebDriver} object representing the application
	 * @param frameMap Sequential list of {@link org.openqa.selenium.By} from main HTML leading to the target WebElement
	 * @throws Exception
	 */
	public static void setToContext(WebDriver driver, List<By> frameMap) throws Exception {
		driver.switchTo().defaultContent();
		if (frameMap != null) {
			for (By byLocator : frameMap) {
				driver.switchTo().frame(driver.findElement(byLocator));
			}
		}
	}
	
	/**
	 * <p>Performs a mouse hover on the target WebElement. This method is useful when accessing WebElements
	 * that becomes visible only when a mouse is hovered on a parent WebElement</p>
	 * <p><b>Example: </b>Accessing submenus when putting the mouse cursor over a Menu item.</p>
	 * @param driver {@link org.openqa.selenium.WebDriver} object representing the application
	 * @param element Target {@link org.openqa.selenium.WebElement} to be accessed
	 * @throws Exception 
	 */
	public static void hover(WebDriver driver, WebElement element) throws Exception {
		/*List<By> frameMap = new ArrayList<By>();
		frameMap.add(By.id("frmMain"));
		ElementHandler home = new ElementHandler(driver, By.id("ctl00_siteMenu_rptSiteMenu_ctl01_liTag"), frameMap);
		
		element = home.toWebElement();*/
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		//Locatable hoverItem = (Locatable) element;
		//Mouse mouse = ((HasInputDevices) driver).getMouse();
		//mouse.mouseMove(hoverItem.getCoordinates());
		
		/*int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		
		Robot robot = new Robot();
		robot.mouseMove(x + (width / 2), y + (height / 2));
		robot.delay(robot.getAutoDelay());*/
	}
	
	/**
	 * <p>Performs a mouse hover on the target WebElement. This method is useful when accessing WebElements
	 * that becomes visible only when a mouse is hovered on a parent WebElement</p>
	 * <p><b>Example: </b>Accessing submenus when putting the mouse cursor over a Menu item.</p>
	 * @param driver {@link org.openqa.selenium.WebDriver} object representing the application
	 * @param element Target {@link ey.manila.qa.automation.element.ElementHandler} to be accessed
	 * @throws Exception
	 */
	public static void hover(WebDriver driver, ElementHandler element) throws Exception {
		ElementActions.hover(driver, element.toWebElement());
	}
}
