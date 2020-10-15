/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Log File
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
package ey.manila.qa.logger;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Logger;
import org.pmw.tinylog.writers.FileWriter;

/**
 * <p>Acts as a wrapper class for third party logging utility.</p>
 * 
 * <p>This wrapper class minimizes additional code changes on external classes
 * and packages in case the third party logging utility has been changed.</p>
 * 
 * <p>Strings and Exception objects, along with its corresponding stack trace,
 * are allowed to be logged in an external log file.</p>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-05-17
 */
public class LogFile {
	/**
	 * <p>Tags the message as INFO when logged in the log file</p>
	 */
	public static final String INFO = "info";
	
	/**
	 * <p>Tags the message as ERROR when logged in the log file</p>
	 */
	public static final String ERROR = "error";
	
	/**
	 * <p>Tags the message as WARNING when logged in the log file</p>
	 */
	public static final String WARNING = "warning";
	
	private String filePath = "";
	/**
	 * <p>Gets the corresponding file path of the current log file</p> 
	 * @return {@link java.lang.String} representation of the file path
	 * associated with the log
	 */
	public String getFilePath() {
		return this.filePath;
	}
	
	/**
	 * <p>Associates the input {@link java.lang.String} filePath to a new instance of the LogFile class.</p>
	 * @param filePath {@link java.lang.String} representation of the log file path to be created.
	 * @param isAppend Set to {@link java.lang.Boolean} true if new entries will be appended to the log. Otherwise, set to false
	 * to overwrite existing entries in the log.
	 */
	public LogFile(String filePath, boolean isAppend) {
		this.filePath = filePath;
		
		// Initialize the Configurator object associated with the logger
		String pattern = "{date} [{thread}] {level}: {message}";
		Configurator.currentConfig()
			.writer(new FileWriter(this.filePath, true, isAppend))
			.formatPattern(pattern)
			.activate();
	}
	
	/**
	 * <p>Creates a new entry in the log for the input message.<br>
	 * <strong>Note:</strong> This method logs the message as an {@link #INFO} type.</p>
	 * <p>Use the {@link #log(String message, String logLevel)} to specify another log type for the message.</p>
	 * @param message {@link java.lang.String} message of the entry to be logged.
	 */
	public void log(String message) {
		logAs(LogFile.INFO, message);
	}
	
	/**
	 * <p>Creates a new entry in the log for the input message. The entry will be logged according to the log type
	 * specified by the logLevel parameter.</p>
	 * @param message {@link java.lang.String} message of the entry to be logged.
	 * @param logLevel {@link java.lang.String} log type that the message will be tagged with.
	 * This input parameter can use either of the following values:
	 * <ul>
	 * 	<li>{@link #INFO}</li>
	 * 	<li>{@link #ERROR}</li>
	 * 	<li>{@link #WARNING}</li>
	 * </ul>
	 */
	public void log(String logLevel, String message) {
		logAs(logLevel, message);
	}
	
	/**
	 * <p>Creates a new entry in the log for the input exception.<br>
	 * <strong>Note:</strong><br>
	 * <ol>
	 * 	<li>This method logs the message as an {@link #INFO} type.</li>
	 * 	<li>The Exception is logged in the file as the exception message
	 * 			together with its stack trace.</li>
	 * </ol></p>
	 * <p>Use the {@link #log(Exception e, String logLevel)} to specify another log type for the exception.</p>
	 * @param e {@link java.lang.Exception} to be logged.
	 */
	public void log(Exception e) {
		logAs(LogFile.ERROR, ExceptionUtils.getStackTrace(e));
	}
	
	/**
	 * <p>Creates a new entry in the log for the input exception.<br>
	 * <strong>Note:</strong><br>
	 * <ol>
	 * 	<li>This method logs the message as an {@link #INFO} type.</li>
	 * 	<li>The Exception is logged in the file as the exception message
	 * 			together with its stack trace.</li>
	 * </ol></p>
	 * @param e {@link java.lang.Exception} to be logged.
	 * @param logLevel {@link java.lang.String} log type that the message will be tagged with.
	 * This input parameter can use either of the following values:
	 * <ul>
	 * 	<li>{@link #INFO}</li>
	 * 	<li>{@link #ERROR}</li>
	 * 	<li>{@link #WARNING}</li>
	 * </ul>
	 */
	public void log(Exception e, String logLevel) {
		logAs(logLevel, ExceptionUtils.getStackTrace(e));
	}
	
	/*
	 * Creates a log entry by accessing the tinylog API.
	 * 
	 * Note that the tinylog API accepts other log levels other than INFO, ERROR, and WARNING.
	 * But this wrapper limits the log levels to the three values, and uses INFO as the default level.
	 */
	private void logAs(String logLevel, String message) {
		message = message.trim();
		
		if (logLevel.toLowerCase().equals(LogFile.INFO)) 
			Logger.info(message);
		else if (logLevel.toLowerCase().equals(LogFile.ERROR))
			Logger.error(message);
		else if (logLevel.toLowerCase().equals(LogFile.WARNING))
			Logger.warn(message);
		else 
			Logger.info(message);
	}
		/*
		switch (logLevel.toLowerCase()) {
			case LogFile.INFO:
				Logger.info(message);
				break;
			case LogFile.ERROR:
				Logger.error(message);
				break;
			case LogFile.WARNING:
				Logger.warn(message);
				break;
			default:
				Logger.info(message);
				break;
		}
		*/
}
