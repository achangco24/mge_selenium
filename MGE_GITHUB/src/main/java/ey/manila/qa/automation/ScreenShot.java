/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Screen Shot
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
package ey.manila.qa.automation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ey.manila.qa.utilities.DateTime;
import ey.manila.qa.utilities.DateTime.Format;

/**
 * <p>Provides functionalities to take screenshots of any web browser that implements from
 * {@link org.openqa.selenium.WebDriver}.</p>
 * 
 * <p>This class wraps {@link org.openqa.selenium.TakesScreenshot} API to allow more convenient taking of screenshots
 * and automatic saving to a physical image file after each screenshot.</p>
 * 
 * <p><strong>Note: </strong>This class is not yet tested against a headless WebDriver; ie: PhantomJS</p>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-05-24
 * @see org.openqa.selenium.TakesScreenshot
 * @see org.openqa.selenium.WebDriver
 */
public class ScreenShot {
	private int nameCtr;
	private String nameTemplate;
	private String extension;
	private String captureDirectory;
	private File screenshot;
	private WebDriver aut;
	
	/**
	 * <p>Creates an object reference to take screenshots of the active WebDriver.</p>
	 * @param driver {@link org.openqa.selenium.WebDriver} instance to be screenshot
	 * @param filenameTemplate String template that will be used for the naming convention
	 * of the generated screenshots. Note that the final filename will be appended with
	 * additional parameters including a counter and a time stamp to the String template.
	 * @param filenameExtension File extension to be used for the screenshot; ie: png, jpg
	 * @param captureDirectory String path where the screenshots will be saved
	 * @throws Exception
	 */
	public ScreenShot(WebDriver driver, String filenameTemplate, String filenameExtension, String captureDirectory) throws Exception {
		try {
			this.nameCtr = 0;
			this.nameTemplate = filenameTemplate;
			this.captureDirectory = captureDirectory;
			this.aut = driver;
			
			// Ensure that captureDirectory does not end with a path separator
			String temp = "";
			if (captureDirectory.endsWith(File.separator)) {
				temp = captureDirectory.substring(0, captureDirectory.length() - 1);
			} else {
				temp = captureDirectory;
			}
			this.captureDirectory = System.getProperty("user.dir") + File.separator + temp;
			
			// Ensure that extension does not start with "."
			if (filenameExtension.startsWith(".")) {
				this.extension = filenameExtension.substring(1, filenameExtension.length() - 1);
			} else {
				this.extension = filenameExtension;
			}
			
			// Create the directory for screen captures
			if(!Files.isDirectory(Paths.get(this.captureDirectory))) {
				new File(this.captureDirectory).mkdirs();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * <p>Captures the entire screenshot of the the associated {@link org.openqa.selenium.WebDriver}</p>
	 * @return String path where the screenshot was saved
	 * @throws Exception
	 */
	public String capture() throws Exception {
		String capturePath = "";
		try {
			this.screenshot = ((TakesScreenshot)aut).getScreenshotAs(OutputType.FILE);		// Screenshot the AUT active window
			
			// Save the screenshot in the target path
			capturePath = generateCapturePath();
			FileUtils.copyFile(this.screenshot, new File(capturePath));
		} catch (Exception e) {
			throw e;
		}
		
		return capturePath;
	}
	
	/**
	 * <p>Captures a screenshot of the specified {@link org.openqa.selenium.WebElement} from the associated {@link org.openqa.selenium.WebDriver}.</p>
	 * <p>This can be achieved through the following steps:</p>
	 * <ol>
	 * 	<li>Take a full screenshot of the associated {@link org.openqa.selenium.WebDriver}</li>
	 * 	<li>Crop the screenshot to the target {@link org.openqa.selenium.WebDriver}</li>
	 * 	<li>Save the cropped screenshot showing the target WebElement</li>
	 * </ol>
	 * @param element Target {@link org.openqa.selenium.WebElement} to be screenshot
	 * @return String path where the screenshot was saved
	 * @throws Exception
	 */
	public String capture(WebElement element) throws Exception {
		String capturePath = "";
		try {
			// Screenshot the active window
			this.screenshot = ((TakesScreenshot)aut).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImage = ImageIO.read(screenshot);
			
			// Get element dimensions
			Point elementPoint = element.getLocation();
			int width = element.getSize().getWidth();
			int height = element.getSize().getHeight();
			
			// Crop the active window screenshot to the target element
			BufferedImage elementImage = fullImage.getSubimage(elementPoint.getX(), elementPoint.getY(), width, height);
			ImageIO.write(elementImage, this.extension, this.screenshot);
			
			// Save the screenshot in the target path
			capturePath = generateCapturePath();
			FileUtils.copyFile(this.screenshot, new File(capturePath));
		} catch (Exception e) {
			throw e;
		}
		
		return capturePath;
	}
	
	/*
	 * Generates a new path and file name for the screenshot. The generated path and
	 * file name follows the following format:
	 * 	[Screenshot Directory]\[File name template][counter]_[Time Stamp].[Filename extension]
	 * 	Example:
	 * 		D:\screenshot\img0_20180524192310.png
	 */
	private String generateCapturePath() {
		String fullPath = this.captureDirectory
				+ File.separator
				+ this.nameTemplate
				+ String.valueOf(this.nameCtr) + "_"
				+ (DateTime.stamp(Format.CUSTOMLONGDATE))
				+ "." + this.extension;
		
		this.nameCtr++;
		return fullPath;
	}
}
