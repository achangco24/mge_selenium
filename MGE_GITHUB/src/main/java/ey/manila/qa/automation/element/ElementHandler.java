/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Element Handler
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

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * <p>Handler object that processes the automatic navigation between HTML frames when
 * accessing a WebElement object. The class also provides additional and basic functionalities to a WebElement that is not 
 * available in native web driver.</p>
 * <p>Use the toWebElement() method of this class to access the native web driver functionalities of a WebElement
 * while utilizing the automatic navigation. That is, you no longer need to switch between frames as long as
 * you call the toWebElement() method.</p>
 * <p>The automatic navigation between frames eliminates the manual switching when performing an action, such as click or setting of text.</p>
 * <p>Some web pages have nested frames in their HTML layout. The WebDriver can only
 * access a WebElement if the WebDriver is switched to the frame that contains the WebElement.<br>
 * <strong>Example:</strong><br>
 * <ul>
 * 	<li>main HTML Body</li>
 * 	<ul>
 * 		<li>Frame1</li>
 * 			<ul>
 * 				<li>WebElement1</li>
 * 			</ul>
 * 		<li>Frame2</li>
 * 			<ul>
 * 				<li>WebElement2</li>
 * 			</ul>
 * 	</ul>
 * </ul>
 * The WebDriver cannot access <b>WebElement1</b> and <b>WebElement2</b> if the WebDriver
 * is switched to the <b>main HTML Body</b>. This is because an HTML Frame contains its own set of
 * HTML structure that is different from other frames and from the main HTML. Thus, a WebElement inside
 * a frame is residing only within that frame and is inaccessible from another frame.</p>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-06-07
 */
public class ElementHandler {
	private WebDriver driver;
	private By byLocator;
	private List<By> frameMap;
	
	/**
	 * <p>Converts the current handler to its equivalent WebElement object.</p>
	 * <p>The current WebDriver is automatically switched to the frame that contains
	 * the WebElement. Thus, allowing the free use of WebElement without worrying
	 * on switching between frames.</p>
	 * <p><b>Note</b><br>
	 * <ul>
	 * 	<li>
	 * 		The WebDriver is switched back to the main HTML <b>at the beginning of this method</b>.
	 * 		Thus, there is no need to manually switch to main HTML before calling this method.
	 * 	</li>
	 * 	<li>
	 * 		The WebDriver is <b>not</b> switched back to the main HTML <b>at the end of this method</b>.
	 * 		Thus, it might be needed to manually switch back to main HTML should another WebElement
	 * 		be accessed without calling this method.
	 * 	</li>
	 * </ul>
	 * </p>
	 * @return Equivalent WebElement object of the current handler
	 * @throws Exception
	 */
	public WebElement toWebElement() throws Exception{
		setToContext();
		return driver.findElement(byLocator);
	}
	
	/**
	 * <p>Retrieve a list of the By locators of the object.</p>
	 * @return List of By locators of the current ElementHandler object
	 */
	public List<By> toFrameMap() {
		return this.frameMap;
	}
	
	/**
	 * <p>Creates a handler class to access a WebElement without manually switching between HTML frames.</p>
	 * @param driver {@link org.openqa.selenium.WebDriver} object representing the application
	 * @param byLocator {@link org.openqa.selenium.By} reference that will identify the target WebElement
	 */
	public ElementHandler(WebDriver driver, By byLocator) {
		this.driver = driver;
		this.byLocator = byLocator;
		this.frameMap = new ArrayList<By>();
	}
	
	/**
	 * <p>Creates a handler class to access a WebElement without manually switching between HTML frames.</p>
	 * @param aut {@link org.openqa.selenium.WebDriver} object representing the application
	 * @param byLocator {@link org.openqa.selenium.By} reference that will identify the target WebElement
	 * @param frameMap Sequential list of {@link org.openqa.selenium.By} from main HTML leading to the target WebElement
	 */
	public ElementHandler(WebDriver aut, By byLocator, List<By> frameMap) {
		this.driver = aut;
		this.byLocator = byLocator;
		this.frameMap = frameMap;
	}
	
	/**
	 * <p>Waits for the target attribute to become available in the input WebElement.</p>
	 * @param attribute String representation of the attribute to be checked
	 * @throws Exception
	 */
	public void waitForAttribute(String attribute) throws Exception {
		WebElement element = this.toWebElement();
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
	 * <p>Waits while a WebElement has the specified value of an attribute. The method can be used when waiting for an attribute change
	 * prior to executing a command.</p>
	 * @param attribute The attribute name to be checked
	 * @param value The current value of the attribute. The method will exit once the attribute value is no longer equal to this parameter
	 * @throws Exception
	 */
	public void waitWhileAttributeValue(String attribute, String value) throws Exception {
		WebElement element = this.toWebElement();
		String description = element.getAttribute(attribute);
		while (description.equals(value)) {
			description = element.getAttribute(attribute);
		}
	}
	
	/**
	 * <p>Selects or deselects an input checkbox.</p>
	 * @param isSelect Boolean flag. TRUE if checkbox is to be selected. Otherwise, set to FALSE
	 * @throws Exception
	 */
	public void tickAs(boolean isSelect) throws Exception {
		WebElement element = this.toWebElement();
		if(isSelect && element.isSelected() ||			// Element should be checked, but is already checked
			!isSelect && !element.isSelected()) {			// Element should be unchecked, but is already unchecked
			return;
		}
		
		boolean isSelected = element.isSelected();
		while (isSelected != isSelect) {
			element.click();
			isSelected = element.isSelected();
		}
	}
	
	/**
	 * <p>Selects the specified text from the list of available options in a web select element.</p>
	 * @param text String value to be selected from the web select element
	 * @throws Exception
	 */
	public void selectTextAs(String text) throws Exception {
		Select select = new Select(this.toWebElement());
		select.selectByVisibleText(text);
	}
	
	/**
	 * <p>Performs a mouse hover on the target WebElement. This method is useful when accessing WebElements
	 * that becomes visible only when a mouse is hovered on a parent WebElement</p>
	 * <p><b>Example: </b>Accessing submenus when putting the mouse cursor over a Menu item.</p>
	 * @param driver {@link org.openqa.selenium.WebDriver} object representing the application
	 * @param element Target {@link org.openqa.selenium.WebElement} to be accessed
	 * @throws Exception 
	 * @deprecated This method is still experimental
	 */
	@Deprecated
	public void hover() throws Exception {
		WebElement element = this.toWebElement();
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
	 *  <p>Switches to WebDriver to the frame that contains the target WebElement. This method is helpful
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
	 * @throws Exception
	 */
	public void setToContext() throws Exception {
		driver.switchTo().defaultContent();
		for (By byLocator : frameMap) {
			driver.switchTo().frame(driver.findElement(byLocator));
		}
	}
	
	public By getLocator() throws Exception{
		return byLocator;
	}
}
