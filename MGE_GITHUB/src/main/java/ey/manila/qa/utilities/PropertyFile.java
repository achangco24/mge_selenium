/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Property File
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
package ey.manila.qa.utilities;

import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;


/**
 * <p>Provides an object reference for external property files. Only one property file
 * can be associated to an instance of PropertyFile.</p>
 * 
 * <p>Upon creating the instance, it can be used to retrieve the String values
 * associated to a key from an external property file.</p>
 * 
 * <p><strong>Note: </strong>Updating of property values are currently not supported.</p>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-05-18
 */
public class PropertyFile {
	private InputStream streamPropertyFile;
	private Properties prop;
	
	private String filePath = "";
	/**
	 * <p>Gets the corresponding file path of the current property reader</p> 
	 * @return {@link java.lang.String} representation of the file path
	 * associated with the property reader
	 */
	public String getFilePath() {
		return this.filePath;
	}
	
	/**
	 * <p>Loads the contents of property file into a stream.</p>
	 * <p>No need to invoke {@link #initialize(String propertyfilePath)} method
	 * when using this overloaded constructor. Note that only one property
	 * file can be associated to an instance of PropertyFile.</p>
	 * @param propertyFilePath String file path of the property file
	 */
	public PropertyFile(String propertyFilePath) throws Exception{
		this.filePath = propertyFilePath;
		
		// Initialize the property file
		prop = new Properties();
		try {
			streamPropertyFile = new FileInputStream(propertyFilePath);
			prop.load(streamPropertyFile);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * <p>Retrieves the value identified by the given key from the
	 * property file represented by the current PropertyFile
	 * class instance.</p>
	 * @param key String key to be searched in the property file
	 * @return String value corresponding to the input Key.
	 * Returns empty String if no value or Key was found.
	 */
	public String getValue(String key) {
		String value = prop.getProperty(key);
		
		if (value == null) {
			return "";
		}
		
		return value;
	}
	
	/**
	 * <p>Closes the property file stream represented by the current
	 * PropertyFile class instance.</p>
	 */
	public void close() throws Exception {
		try {
			prop.clear();
			streamPropertyFile.close();
		}
		catch (Exception e) {
			throw e;
		}
	}
}