/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Command
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Acts as a wrapper class to run a command via the Windows command prompt.
 * Note that no prompt window will be visible to the user when the command is run.</p>
 * 
 * <p>The command is run through the following logic:</p>
 * <ul>
 * 	<li>The command and its arguments are passed to an instance of {@link java.lang.ProcessBuilder}</li>
 * 	<li>The process builder is then started and passed to the native process through {@link java.lang.Process}</li>
 * </ul>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-05-22
 * @see java.lang.Process
 * @see java.lang.ProcessBuilder
 */
public class Command {
	private String confirmationText = "";
	private Process commandProcess;
	private BufferedReader inputStream = null;
	private BufferedWriter outputStream = null;
	
	private List<String> output = new ArrayList<String>();
	/**
	 * <p>Gets the output of the command as a list of string</p> 
	 * @return {@link java.util.List} of String of the command output
	 * associated with the property reader
	 */
	public List<String> getOutput() {
		return this.output;
	}
	
	/**
	 * <p>Creates an instance to run commands via Windows command prompt,
	 * with the default "press any key to continue" as an indicator that
	 * the command has completed.</p>
	 */
	public Command() {
		this.confirmationText = "press any key to continue";
	}
	
	/**
	 * <p>Creates an instance to run commands via Windows command prompt,
	 * with the String input parameter as an indicator that the command has completed.</p>
	 * @param confirmationText String reference used by the process to check that
	 * the command has completed.
	 */
	public Command(String confirmationText) {
		this.confirmationText = confirmationText;
	}
	
	/**
	 * <p>Runs the input command in a Windows command prompt.</p>
	 * @param command Command represented as a String to be run in a prompt
	 * @throws Exception
	 */
	public void execute (String command) throws Exception {
		try {
			List<String> commandPrompt = new ArrayList<String>();
			commandPrompt.add("CMD");
			commandPrompt.add("/C");
			commandPrompt.add(command);
			execute(commandPrompt);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * <p>Runs the input command with arguments in a Windows command prompt.</p>
	 * @param arguments {@link java.util.List} of String that represents the program to be run
	 * together with its arguments and other commands.<br><br><strong>Note: </strong>
	 * <ul>
	 * 	<li>The first element of the list should be the program to be run</li>
	 * 	<li>Each argument should be made as separate entries in the list</li>
	 * </ul>
	 * @throws Exception
	 */
	public void execute (List<String> arguments) throws Exception {
		File currentDirectory = new File(System.getProperty("user.dir"));
		
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(arguments);
			processBuilder.directory(currentDirectory).redirectErrorStream(true);

			this.commandProcess = processBuilder.start();
			
			this.inputStream = null;
			this.inputStream = new BufferedReader(new InputStreamReader(this.commandProcess.getInputStream()));
			
			this.outputStream = null;
			this.outputStream = new BufferedWriter(new OutputStreamWriter(this.commandProcess.getOutputStream()));
			
			readCommandOutput();
			this.commandProcess.waitFor();
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * <p>Prints in the console the output of the command.</p>
	 * @deprecated This method is still experimental.
	 */
	@Deprecated
	public void printOutput() {
		try {
			String line;
			while (!(line = this.inputStream.readLine()).equals(null)) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Exception occured:");
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * <p>Gets the line of text at the specified line number from the output of the command
	 * that was run.</p>
	 * @param lineNumber Line number of the text to be retrieved
	 * @return String representation of the line of text at the specified line number of the command output
	 */
	public String getOutputAtLine(int lineNumber) {
		if (lineNumber < 0 || lineNumber > this.output.size()) {
			return "";
		}
		
		return output.get(lineNumber);
	}
	
	/**
	 * <p>Checks the output of the command that was run and returns the string that matches the specified
	 * pattern. Otherwise, returns an empty string.</p>
	 * @param regexPattern String representation of the regular expression
	 * pattern to be searched
	 * @param regexGroup Group number in the input pattern where the return value will be extracted from
	 * the matching line.<br><br>
	 * <strong>Note:</strong>
	 * <ul>
	 * 	<li>Use zero as the group number when the corresponding input pattern has no groupings.</li>
	 * </ul>
	 * @return String that matches the specified regular expression pattern and group number. Otherwise,
	 * returns an empty string if no match was found.
	 * @throws Exception
	 */
	public String getMatchFromOutput(String regexPattern, int regexGroup) throws Exception {
		try {
			Pattern pattern  = Pattern.compile(regexPattern);
			Matcher matcher;
			for (String line : this.output) {
				matcher = pattern.matcher(line);
				if (matcher.find()) {
					return matcher.group(regexGroup);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		
		return "";
	}
	
	/**
	 * <p>Checks the output of the command that was run if the specified text is existing.</p>
	 * @param text String to be checked if existing in the command output
	 * @param ignoreLeadingAndTrailingWhitespace TRUE if white spaces before and after the text will be ignored.
	 * Otherwise, set to FALSE
	 * @param caseSensitive TRUE if checking should consider upper and lower casing of the text. Otherwise, set to FALSE
	 * @return Boolean flag. TRUE if found, otherwise returns FALSE
	 */
	public boolean isLineExistWithText(String text, boolean ignoreLeadingAndTrailingWhitespace, boolean caseSensitive) {
		if (!caseSensitive) {
			text = text.toLowerCase();
		}
		
		if (ignoreLeadingAndTrailingWhitespace) {
			text = text.trim();
		}
		
		for (String line : this.output) {
			if (!caseSensitive) {
				line = line.toLowerCase();
			}
			
			if (ignoreLeadingAndTrailingWhitespace) {
				line = line.trim();
			}
			
			if (line.equals(text)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * <p>Checks if the command is still running.</p>
	 * @return Boolean flag. TRUE if command is still running, otherwise returns FALSE
	 */
	public boolean isRunning() {
		try {
			if (this.commandProcess.exitValue() == 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	/**
	 * <p>Aborts the command by destroying its corresponding {@link java.lang.Process}</p>
	 * 
	 * @see java.lang.Process
	 */
	public void kill() {
		this.commandProcess.destroy();
		
		this.inputStream = null;
		this.outputStream = null;
		this.output.clear();
	}
	
	private void readCommandOutput() throws Exception {
		String line = null;
		try {
			while ((line = this.inputStream.readLine()) != null) {			
				this.output.add(line);
				if (line.toLowerCase().trim().contains(this.confirmationText)) {
					this.outputStream.write(System.lineSeparator());
					this.outputStream.flush();
					this.outputStream.close();
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
