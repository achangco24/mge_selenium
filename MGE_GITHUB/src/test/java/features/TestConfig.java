/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Features
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    		Reason: 
 * 2020-08-10	RExtra	 	Added constants for Database Util     
 * 
 *************************************************************************************
 */
package features;

public class TestConfig {
	public static final String browser = "ie";
	//public static final String browser = "chrome";
	public static final String webDriverPath = "IEDriverServer.exe";
	//public static final String webDriverPath = "chromedriver.exe";
	public static final int implicitWait = 30;
	public static final int explicitWait = 60;
	public static final String screenshotNameTemplate = "ccb27_";
	public static final String screenshotExtension = "png";
	
	public static final String wua26Tst1 = "https://ccb26tst1-app.abcwua.org:6501/ouaf/loginPage.jsp";
	public static final String wua26Dev = "https://ccb26dev-app.abcwua.org:6501/ouaf/cis.jsp";
	public static final String azure27CCB = "https://10.101.188.227:6501/ouaf/loginPage.jsp";
	public static final String dpu27Pkg = "https://10.101.188.227:6501/ouaf/loginPage.jsp";
	public static final String dpu27Dev = "https://10.140.236.20:7501/ouaf/cis.jsp";
	public static final String dpu27Tst2 = "https://10.140.236.21:13501/ouaf/loginPage.jsp";//this
	public static final String seiCCBDev = "https://cwdwdcnina102:6501/ouaf/cis.jsp";
	public static final String seiTST2 = "https://cwdwdcnina101:7501/ouaf/loginPage.jsp";
	public static final String seiPROD = "https://cwdwdcpina101:6501/ouaf/loginPage.jsp";
	public static final String ccbTRN = "https://cwdwdcnina101:8501/ouaf/cis.jsp";
	public static final String ccbGOLD = "https://192.168.8.130:8501/ouaf/loginPage.jsp";
	
	
	
	
}
