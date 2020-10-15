package features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;





import ey.manila.qa.utilities.DateTime;

public class InputFileBuilder {
	
	//Constants
	final static String PATH = "src\\test\\java\\dpu_features\\";
	final static String USERNAME = "SYSUSER";
	final static String PASSWORD = "sysuser00"; //TST2, TRN
	final static String CPPUSERNAME = "cppuser";
	final static String CWDUSERNAME = "cwduser";
	
	//final static String PASSWORD = "SysUser01!"; //SEI-CCBPROD
	
	final static String MANUAL = "MANUAL";
	
	static String columnNames;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		Map<String, String> listPair = loadTestScenarios();
		File file = null;
		String testName = "";
		String columnNames = "";
		
		DatabaseUtil dbUtil = new DatabaseUtil();
		Connection connection = dbUtil.connectToDB();
		
		
		if(!listPair.isEmpty()){
			
			for(String key : listPair.keySet()){
				file = new File(PATH + key);
				testName = getTestName(key);
				System.out.println("" + DateTime.stamp() + " -- Starting Data Load for " + key);
				if(fileExists(file)){
					fileCleanUp(file);
					
					Scanner myReader = new Scanner(file);
					FileWriter fw = new FileWriter(file, true);
					while (myReader.hasNextLine()){
						String line = myReader.nextLine().toString();
				        if(line.equals("Examples:")){
				        	try {
				        		if(listPair.get(key).equals(MANUAL)){
				        			if(testName.equals("CI016CreateAPremise"))
				        				CI016CreateAPremiseFormat(fw, testName);
				        			
				        			if(testName.equals("CPCI001AddingAPersonRecord"))
				        				CPCI001AddingAPersonRecordFormat(fw, testName);
				        			
				        			if(testName.equals("CPFIN03AddingADepositTenderControl"))
				        				CPFIN03AddingADepositTenderControlFormat(fw, testName);
				        			
				        			if(testName.equals("CPCI008AddingAPremiseRecord"))
				        				CPCI008AddingAPremiseRecordFormat(fw, testName);
				        			
				        			System.out.println("" + DateTime.stamp() + " -- Successfully Loaded Input Data for file: " + key);
				        		} else{
				        			ResultSet result = dbUtil.executeQuery(connection, listPair.get(key));
						    		
						    		if(!result.isBeforeFirst()){
						    			System.out.println("No Data Retrieved for Test: " + key);
						    		} else{
						    			
						    			if(testName.equals("CI018AddSPRecordToAPremise"))
						    				CI018AddSPRecordToAPremiseFormat(fw, testName, result);
						    			
						    			if(testName.equals("CI022AddALogEntryToACustomerContact"))
						    				CI022AddALogEntryToACustomerContactFormat(fw, testName, result);
						    			
						    			if(testName.equals("FS001AddAFieldActivity"))
						    				FS001AddAFieldActivityFormat(fw, testName, result);
						    			
						    			if(testName.equals("FS002UpdateExistingFAScheduledDate"))
						    				FS002UpdateExistingFAScheduledDateFormat(fw, testName, result);
						    			
						    			if(testName.equals("FS003CancelAnExistingFA"))
						    				FS003CancelAnExistingFAFormat(fw, testName, result);
						    			
						    			if(testName.equals("MT003AddAMeterRead"))
						    				MT003AddAMeterReadFormat(fw, testName, result);
						    			
						    			if(testName.equals("PY005SearchingForAPayment"))
						    				PY005SearchingForAPaymentFormat(fw, testName, result);
						    			
						    			if(testName.equals("PY010CancellingAPayment"))
						    				PY010CancellingAPaymentFormat(fw, testName, result);
						    			
						    			if(testName.equals("TD001CompletingAToDo"))
						    				TD001CompletingAToDoFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC003AddingACollectionProcess"))
						    				CPCC003AddingACollectionProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC005AddingASeveranceProcess"))
						    				CPCC005AddingASeveranceProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC007AddingAWriteOffProcess"))
						    				CPCC007AddingAWriteOffProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC020ModifyingACollectionEventTriggerDate"))
						    				CPCC020ModifyingACollectionEventTriggerDateFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC021ModifyingASeveranceEventTriggerDate"))
						    				CPCC021ModifyingASeveranceEventTriggerDateFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC022ModifyingAWriteOffEventTriggerDate"))
						    				CPCC022ModifyingAWriteOffEventTriggerDateFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC025ViewingACollectionProcess"))
						    				CPCC025ViewingACollectionProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC026ViewingASeveranceProcess"))
						    				CPCC026ViewingASeveranceProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC027ViewingAWriteOffProcess"))
						    				CPCC027ViewingAWriteOffProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC010CancelingACollectionProcess"))
						    				CPCC010CancelingACollectionProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC013CancelingASeveranceProcess"))
						    				CPCC013CancelingASeveranceProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC015CancelingAWriteOffProcess"))
						    				CPCC015CancelingAWriteOffProcessFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC019ManuallyAddingCreditPoints"))
						    				CPCC019ManuallyAddingCreditPointsFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFIN01AddingAnAdjustment"))
						    				CPFIN01AddingAnAdjustmentFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFIN02CancelingAnAdjustment"))
						    				CPFIN02CancelingAnAdjustmentFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFIN08AddingAPaymentEvent"))
						    				CPFIN08AddingAPaymentEventFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFIN11CancelingAutoPay"))
						    				CPFIN11CancelingAutoPayFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI004SettingUpAutopay"))
						    				CPCI004SettingUpAutopayFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI009AddingAServicePointRecord"))
						    				CPCI009AddingAServicePointRecordFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI032AddingAManualAlert"))
						    				CPCI032AddingAManualAlertFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPBI014SettingAMaximumBillThreshold"))
						    				CPBI014SettingAMaximumBillThresholdFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFS001CreateANewFAManually"))
						    				CPFS001CreateANewFAManuallyFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI022CreatingADepositSA"))
						    				CPCI022CreatingADepositSAFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI031AddingACustomerContact"))
						    				CPCI031AddingACustomerContactFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFS002UpdateExistingFAScheduledDate"))
						    				CPFS002UpdateExistingFAScheduledDateFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFS003CancelExistingFA"))
						    				CPFS003CancelExistingFAFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFS009CreateAndCompleteFA"))
						    				CPFS009CreateAndCompleteFAFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI014AddingAManualToDo"))
						    				CPCI014AddingAManualToDoFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC002AddingACollectionAgencyReferral"))
						    				CPCC002AddingACollectionAgencyReferralFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCC028AddingAPayPlan"))
						    				CPCC028AddingAPayPlanFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI031CancelingAPayPlan"))
						    				CPCI031CancelingAPayPlanFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPBI001ManuallyGeneratingABill"))
						    				CPBI001ManuallyGeneratingABillFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPFIN26TransferringOfBalance"))
						    				CPFIN26TransferringOfBalanceFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI030AddingAPaymentArrangementRequest"))
						    				CPCI030AddingAPaymentArrangementRequestFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI068StartingServiceUsingAnOrderCampaignRES"))
						    				CPCI068StartingServiceUsingAnOrderCampaignRESFormat(fw, testName, result);
						    			
						    			if(testName.equals("CPCI069StartingServiceUsingAnOrderCampaignCOM"))
						    				CPCI069StartingServiceUsingAnOrderCampaignCOMFormat(fw, testName, result);
						    			
						    			if(testName.equals("SEC001CheckPremiseCWDCISDivision"))
						    				SEC001CheckPremiseCWDCISDivisionFormat(fw, testName, result);
						    			
						    			if(testName.equals("SEC002CheckPremiseCPPCISDivision"))
						    				SEC002CheckPremiseCPPCISDivisionFormat(fw, testName, result);
						    			
						    			
						    			System.out.println("" + DateTime.stamp() + " -- Successfully Loaded Input Data for file: " + key);
						    		}
				        		}
				        	} catch (Exception e){
				        		e.printStackTrace();
				        		System.out.println("Failed Loading Data for Test: " + key);
				        	}
				    		
				        }
					}
					myReader.close();
					fw.close();
				} else {
					System.out.println("File does not exist: " + PATH + key);
				}
			}
		}else{
			System.out.println("List is Empty");
		}
		
	    dbUtil.cleanUp(connection);
	}
	
	public static boolean fileExists(File file){
		if(file.exists() && !file.isDirectory()){
			//System.out.println("File found!");
			return true;
		} else{
			//System.out.println("File not Found!");
			return false;
		}
	}

	public static void fileCleanUp(File file) {
		try {
	        BufferedReader bf = new BufferedReader(new FileReader(file));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;
	        boolean markerFound = false;

	        while ((line = bf.readLine()) != null) {
	        	
	        	if(!markerFound){
	        		inputBuffer.append(line);
		            inputBuffer.append('\n');
	        	}
	            
	        	if((line.equals("Examples:")) && (!markerFound))
	            	markerFound = true;
	            
	        }
	        bf.close();

	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream(file);
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem Reading File: " + file);
	    }
	}
	
	
	public static String getTestName(String fileName){
		return fileName.substring(0, (fileName.length() - 8));
	}
	
	public static Map<String, String> loadTestScenarios(){
		Map<String, String> listPair = new HashMap<String, String>();

//		listPair.put("CI016CreateAPremise.feature", MANUAL);
//		listPair.put("CI018AddSPRecordToAPremise.feature", "SELECT PREM_ID FROM CI_PREM FETCH FIRST ROW ONLY");
//		listPair.put("CI022AddALogEntryToACustomerContact.feature", "SELECT CC_ID FROM CI_CC FETCH FIRST ROW ONLY");
//		listPair.put("FS001AddAFieldActivity.feature", "SELECT SA1.ACCT_ID, SASP1.SP_ID FROM CI_SA SA1, CI_SA_SP SASP1, CI_SP SP, CI_ACCT ACCT WHERE SA1.SA_ID = SASP1.SA_ID AND SASP1.SP_ID = SP.SP_ID AND SP_TYPE_CD = 'WS-RESSM' AND ACCT.ACCT_ID = SA1.ACCT_ID AND ACCT.CIS_DIVISION = 'CLE' AND NOT EXISTS (SELECT SA2.ACCT_ID FROM CI_FA FA2, CI_SA SA2, CI_SA_SP SASP2 WHERE SA2.SA_ID = SASP2.SA_ID AND SASP2.SP_ID = FA2.SP_ID AND SA2.ACCT_ID = SA1.ACCT_ID AND FA2.FA_TYPE_CD = 'INV-AMR') FETCH FIRST ROW ONLY");
//		listPair.put("FS002UpdateExistingFAScheduledDate.feature", "SELECT DISTINCT(SA.ACCT_ID) FROM CI_SA SA, CI_SA_SP SASP, CI_FA FA1, CI_ACCT ACCT WHERE SA.SA_ID = SASP.SA_ID AND ACCT.ACCT_ID = SA.ACCT_ID AND ACCT.CIS_DIVISION = 'CLE' AND SASP.SP_ID = FA1.SP_ID AND SA.SA_STATUS_FLG = '20' AND FA1.FA_STATUS_FLG = 'P' AND NOT EXISTS (SELECT FA2.FA_ID FROM CI_FA FA2 WHERE FA2.SP_ID = FA1.SP_ID AND FA2.SCHED_DTTM = '01-JAN-20') FETCH FIRST ROW ONLY");
//		listPair.put("FS003CancelAnExistingFA.feature", "SELECT DISTINCT(SA.ACCT_ID) FROM CI_SA SA, CI_SA_SP SASP, CI_FA FA1, CI_ACCT ACCT WHERE SA.SA_ID = SASP.SA_ID AND ACCT.ACCT_ID = SA.ACCT_ID AND ACCT.CIS_DIVISION = 'CLE' AND SASP.SP_ID = FA1.SP_ID AND SA.SA_STATUS_FLG = '20' AND FA1.FA_STATUS_FLG = 'P' FETCH FIRST ROW ONLY");
		listPair.put("MT003AddAMeterRead.feature", "SELECT SA.ACCT_ID, SPTYPE.DESCR SP_TYPE, TO_CHAR(MR1.READ_DTTM, 'MM-DD-YYYY') READ_DTTM, RR.REG_READING FROM CI_SA SA, CI_SA_SP SASP, CI_CFG_SPMR_VW SMI, CI_MR MR1, CI_REG_READ RR, CI_SP SP, CI_SP_TYPE_L SPTYPE WHERE SA.SA_ID = SASP.SA_ID AND SA.SA_STATUS_FLG = '20' AND SASP.SP_ID = SMI.SP_ID AND SASP.SP_ID = SP.SP_ID AND SP.SP_STATUS_FLG = 'R' AND SP.SP_TYPE_CD = SPTYPE.SP_TYPE_CD AND SMI.REMOVAL_MR_ID = ' ' AND SMI.MTR_CONFIG_ID = MR1.MTR_CONFIG_ID AND MR1.MR_ID = (SELECT MR2.MR_ID FROM CI_MR MR2 WHERE MR2.MTR_CONFIG_ID = MR1.MTR_CONFIG_ID ORDER BY MR2.READ_DTTM DESC FETCH FIRST 1 ROW ONLY) AND MR1.MR_ID = RR.MR_ID FETCH FIRST ROW ONLY");
//		listPair.put("PY005SearchingForAPayment.feature", "SELECT ACCT_ID FROM CI_PAY WHERE PAY_STATUS_FLG = '50' FETCH FIRST ROW ONLY");
//		listPair.put("PY010CancellingAPayment.feature", "SELECT ACCT_ID FROM CI_PAY WHERE PAY_STATUS_FLG = '50' FETCH FIRST ROW ONLY");
//		listPair.put("TD001CompletingAToDo.feature", "SELECT TDE.TD_ENTRY_ID FROM CI_TD_ENTRY TDE, CI_ROLE_USER RU WHERE TDE.ROLE_ID = RU.ROLE_ID AND TDE.ENTRY_STATUS_FLG = 'O' AND RU.USER_ID = '" + USERNAME + "' FETCH FIRST ROW ONLY");
//		
//		listPair.put("CPCC003AddingACollectionProcess.feature", "SELECT ACCT.ACCT_ID, SA.SA_ID FROM CI_ACCT ACCT, CI_SA SA, CI_FT FT WHERE SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND SA.SA_STATUS_FLG = '20' AND SA.SA_TYPE_CD = 'E-RES' AND SA.SA_ID = FT.SA_ID AND NOT EXISTS (SELECT 1 FROM CI_COLL_PROC CP WHERE ACCT.ACCT_ID = CP.ACCT_ID AND CP.COLL_STATUS_FLG = '10') AND NOT EXISTS (SELECT 1 FROM CI_SEV_PROC SP WHERE SA.SA_ID = SP.SA_ID AND SP.SEV_STATUS_FLG = '10') GROUP BY ACCT.ACCT_ID, SA.SA_ID HAVING SUM(FT.CUR_AMT) >= 100 AND ROUND(SYSDATE-MAX(FT.CRE_DTTM)) > 40 FETCH FIRST ROW ONLY");
//		listPair.put("CPCC005AddingASeveranceProcess.feature", "SELECT ACCT.ACCT_ID, SA.SA_ID FROM CI_ACCT ACCT, CI_SA SA, CI_FT FT WHERE SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND SA.SA_STATUS_FLG = '20' AND SA.SA_TYPE_CD = 'E-RES' AND SA.SA_ID = FT.SA_ID AND NOT EXISTS (SELECT 1 FROM CI_COLL_PROC CP WHERE ACCT.ACCT_ID = CP.ACCT_ID AND CP.COLL_STATUS_FLG = '10') AND NOT EXISTS (SELECT 1 FROM CI_SEV_PROC SP WHERE SA.SA_ID = SP.SA_ID AND SP.SEV_STATUS_FLG = '10') GROUP BY ACCT.ACCT_ID, SA.SA_ID HAVING SUM(FT.CUR_AMT) >= 150 AND ROUND(SYSDATE-MAX(FT.CRE_DTTM)) > 40 FETCH FIRST ROW ONLY");
//		listPair.put("CPCC007AddingAWriteOffProcess.feature", "SELECT ACCT.ACCT_ID, SA.SA_ID FROM CI_ACCT ACCT, CI_SA SA, CI_FT FT WHERE SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND SA.SA_TYPE_CD = 'E-RES' AND SA.SA_STATUS_FLG = '20' AND SA.SA_ID = FT.SA_ID AND NOT EXISTS (SELECT 1 FROM CI_WO_PROC WP WHERE ACCT.ACCT_ID = WP.ACCT_ID AND WP.WO_STATUS_FLG = '10') GROUP BY ACCT.ACCT_ID, SA.SA_ID HAVING SUM(FT.CUR_AMT) > 0 FETCH FIRST ROW ONLY");
//		listPair.put("CPCC020ModifyingACollectionEventTriggerDate.feature", "SELECT CP.ACCT_ID, CE.EVT_SEQ, TO_CHAR((CE.TRIGGER_DT + 2), 'MM-DD-YYYY') newTriggerDate FROM CI_COLL_PROC CP, CI_COLL_EVT CE, CI_ACCT ACCT WHERE CP.COLL_STATUS_FLG = '10' AND CP.COLL_PROC_ID = CE.COLL_PROC_ID AND CE.EVT_SEQ = (SELECT MIN(CE2.EVT_SEQ) FROM CI_COLL_EVT CE2 WHERE CE2.COLL_PROC_ID = CE.COLL_PROC_ID AND CE2.COLL_EVT_STAT_FLG = '10') AND (CE.TRIGGER_DT + 2) < (SELECT MIN(CE3.TRIGGER_DT) FROM CI_COLL_EVT CE3 WHERE CE3.EVT_SEQ <> CE.EVT_SEQ AND CE3.COLL_PROC_ID = CE.COLL_PROC_ID AND CE3.COLL_EVT_STAT_FLG = '10') AND CP.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND ACCT.CUST_CL_CD = 'E-RES' FETCH FIRST ROW ONLY");
//		listPair.put("CPCC021ModifyingASeveranceEventTriggerDate.feature", "SELECT ACCT.ACCT_ID, SE.EVT_SEQ, TO_CHAR((SE.TRIGGER_DT + 2), 'MM-DD-YYYY') newTriggerDate FROM CI_SEV_PROC SP, CI_SEV_EVT SE, CI_ACCT ACCT, CI_SA SA WHERE SP.SEV_STATUS_FLG = '10' AND SP.SEV_PROC_ID = SE.SEV_PROC_ID AND SE.EVT_SEQ = (SELECT MIN(SE2.EVT_SEQ) FROM CI_SEV_EVT SE2 WHERE SE2.SEV_PROC_ID = SE.SEV_PROC_ID AND SE2.SEV_EVT_STAT_FLG = '10') AND (SE.TRIGGER_DT + 2) < (SELECT MIN(SE3.TRIGGER_DT) FROM CI_SEV_EVT SE3 WHERE SE3.EVT_SEQ <> SE.EVT_SEQ AND SE3.SEV_PROC_ID = SE.SEV_PROC_ID AND SE3.SEV_EVT_STAT_FLG = '10') AND SP.SA_ID = SA.SA_ID AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CUST_CL_CD = 'E-RES' AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPCC022ModifyingAWriteOffEventTriggerDate.feature", "SELECT WP.ACCT_ID, WE.EVT_SEQ, TO_CHAR((WE.TRIGGER_DT + 2), 'MM-DD-YYYY') newTriggerDate FROM CI_WO_PROC WP, CI_WO_EVT WE, CI_ACCT ACCT WHERE WP.WO_STATUS_FLG = '10' AND WP.WO_PROC_ID = WE.WO_PROC_ID AND WE.EVT_SEQ = (SELECT MIN(WE2.EVT_SEQ) FROM CI_WO_EVT WE2 WHERE WE2.WO_PROC_ID = WE.WO_PROC_ID AND WE2.WO_EVT_STAT_FLG = '10') AND (WE.TRIGGER_DT + 2) < (SELECT MIN(WE3.TRIGGER_DT) FROM CI_WO_EVT WE3 WHERE WE3.EVT_SEQ <> WE.EVT_SEQ AND WE3.WO_PROC_ID = WE.WO_PROC_ID AND WE3.WO_EVT_STAT_FLG = '10') AND WP.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND ACCT.CUST_CL_CD = 'E-RES' FETCH FIRST ROW ONLY");
//		listPair.put("CPCC025ViewingACollectionProcess.feature", "SELECT CP.ACCT_ID, MIN(CE.EVT_SEQ) EVT_SEQ FROM CI_COLL_PROC CP, CI_COLL_EVT CE, CI_ACCT ACCT WHERE CP.COLL_STATUS_FLG = '10' AND CP.COLL_PROC_ID = CE.COLL_PROC_ID AND CE.COLL_EVT_STAT_FLG = '10' AND CP.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND ACCT.CUST_CL_CD = 'E-RES' GROUP BY CP.ACCT_ID FETCH FIRST ROW ONLY");
//		listPair.put("CPCC026ViewingASeveranceProcess.feature", "SELECT ACCT.ACCT_ID, MIN(SE.EVT_SEQ) EVT_SEQ FROM CI_SEV_PROC SP, CI_SEV_EVT SE, CI_SA SA, CI_ACCT ACCT WHERE SP.SEV_STATUS_FLG = '10' AND SP.SEV_PROC_ID = SE.SEV_PROC_ID AND SE.SEV_EVT_STAT_FLG = '10' AND SP.SA_ID = SA.SA_ID AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND ACCT.CUST_CL_CD = 'E-RES' GROUP BY ACCT.ACCT_ID FETCH FIRST ROW ONLY");
//		listPair.put("CPCC027ViewingAWriteOffProcess.feature", "SELECT WP.ACCT_ID, MIN(WE.EVT_SEQ) EVT_SEQ FROM CI_WO_PROC WP, CI_WO_EVT WE, CI_ACCT ACCT WHERE WP.WO_STATUS_FLG = '10' AND WP.WO_PROC_ID = WE.WO_PROC_ID AND WE.WO_EVT_STAT_FLG = '10' AND WP.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND ACCT.CUST_CL_CD = 'E-RES' GROUP BY WP.ACCT_ID FETCH FIRST ROW ONLY");
//		listPair.put("CPCC010CancelingACollectionProcess.feature", "SELECT CP.ACCT_ID FROM CI_COLL_PROC CP, CI_ACCT ACCT WHERE CP.COLL_STATUS_FLG = '10' AND CP.ACCT_ID = ACCT.ACCT_ID AND ACCT.CUST_CL_CD = 'E-RES' AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPCC013CancelingASeveranceProcess.feature", "SELECT ACCT.ACCT_ID FROM CI_SEV_PROC SP, CI_ACCT ACCT, CI_SA SA WHERE SP.SEV_STATUS_FLG = '10' AND SP.SA_ID = SA.SA_ID AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CUST_CL_CD = 'E-RES' AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPCC015CancelingAWriteOffProcess.feature", "SELECT WP.ACCT_ID FROM CI_WO_PROC WP, CI_ACCT ACCT WHERE WP.WO_STATUS_FLG = '10' AND WP.ACCT_ID = ACCT.ACCT_ID AND ACCT.CUST_CL_CD = 'E-RES' AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPCC019ManuallyAddingCreditPoints.feature", "SELECT ACCT.ACCT_ID FROM CI_ACCT ACCT WHERE ACCT.ACCT_ID NOT IN (SELECT CRH.ACCT_ID FROM CI_CR_RAT_HIST CRH) AND ACCT.CIS_DIVISION = 'CPP' AND ACCT.CUST_CL_CD = 'E-RES' FETCH FIRST ROW ONLY");
//		
//		
//		
		listPair.put("CPFIN01AddingAnAdjustment.feature", "SELECT ACCT.ACCT_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.SA_TYPE_CD = 'E-RES' AND SA.SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPFIN02CancelingAnAdjustment.feature", "SELECT ADJ.ADJ_ID FROM CI_ADJ ADJ, CI_SA SA, CI_ACCT ACCT WHERE ADJ.ADJ_STATUS_FLG = '50' AND ADJ.ADJ_TYPE_CD = 'E-NSF' AND ADJ.ADJ_AMT > 0 AND ADJ.SA_ID = SA.SA_ID AND SA.SA_STATUS_FLG= '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPFIN08AddingAPaymentEvent.feature", "SELECT SA.ACCT_ID FROM  CI_SA SA, CI_FT FT, CI_ACCT ACCT WHERE SA.SA_ID = FT.SA_ID AND FT.FREEZE_SW = 'Y' AND SA.SA_TYPE_CD = 'E-RES' AND SA.SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' HAVING SUM(FT.TOT_AMT) > 100 GROUP BY SA.ACCT_ID FETCH FIRST ROW ONLY");
//		listPair.put("CPFIN09AddingAPaymentToMultipleAccounts.feature", "");
//		listPair.put("CPFIN10CancellingAPaymentEvent.feature", "");
//		listPair.put("CPFIN11CancelingAutoPay.feature", "SELECT DISTINCT(AP.ACCT_ID), TO_CHAR(ADD_MONTHS(AP.START_DT,1), 'MM-DD-YYYY') AS END_DATE FROM CI_ACCT_APAY AP, CI_ACCT AC WHERE AC.ACCT_ID=AP.ACCT_ID AND AC.CIS_DIVISION='CPP' AND AP.END_DT IS NULL FETCH FIRST ROW ONLY");
//		
//		listPair.put("CPCI001AddingAPersonRecord.feature", MANUAL);
//		listPair.put("CPCI004SettingUpAutopay.feature", "SELECT SA.ACCT_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.SA_TYPE_CD =  'E-RES' AND SA.SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND NOT EXISTS (SELECT 'X' FROM CI_ACCT_APAY AP WHERE AP.ACCT_ID = SA.ACCT_ID) FETCH FIRST ROW ONLY");
//		listPair.put("CPCI009AddingAServicePointRecord.feature", "SELECT PREM_ID FROM CI_PREM WHERE CIS_DIVISION='CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPCI032AddingAManualAlert.feature", "SELECT SA.ACCT_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.SA_TYPE_CD =  'E-RES' AND SA.SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND NOT EXISTS (SELECT 'X' FROM CI_ACCT_ALERT ALERT WHERE ALERT.ACCT_ID = ACCT.ACCT_ID AND ALERT.ALERT_TYPE_CD = 'PPLSBILL') FETCH FIRST ROW ONLY");
//		listPair.put("CPBI014SettingAMaximumBillThreshold.feature", "SELECT SA.ACCT_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.SA_STATUS_FLG='20'  AND SA.SA_TYPE_CD = 'E-RES' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' GROUP BY SA.ACCT_ID HAVING COUNT(SA.ACCT_ID) = 1 FETCH FIRST ROW ONLY");
//		listPair.put("CPFS001CreateANewFAManually.feature", "SELECT SA1.ACCT_ID, SASP1.SP_ID FROM CI_SA SA1, CI_SA_SP SASP1, CI_ACCT ACCT WHERE SA1.SA_ID = SASP1.SA_ID AND ACCT.ACCT_ID = SA1.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND NOT EXISTS (SELECT SA2.ACCT_ID, FA2.SP_ID FROM CI_FA FA2, CI_SA SA2, CI_SA_SP SASP2 WHERE SA2.SA_ID = SASP2.SA_ID AND SASP2.SP_ID = FA2.SP_ID AND SA2.ACCT_ID = SA1.ACCT_ID AND FA2.FA_TYPE_CD = 'INV-AMR') FETCH FIRST ROW ONLY");
		listPair.put("CPCI022CreatingADepositSA.feature", "SELECT SA.ACCT_ID, SA.CHAR_PREM_ID PREM_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.ACCT_ID = ACCT.ACCT_ID AND SA.SA_TYPE_CD = 'E-RES' AND SA_STATUS_FLG = '20' AND ACCT.CIS_DIVISION = 'CPP' AND SA.ACCT_ID NOT IN(SELECT SA2.ACCT_ID FROM CI_SA SA2 WHERE SA2.ACCT_ID = SA.ACCT_ID AND SA2.SA_TYPE_CD = 'E-RESDEP') FETCH FIRST ROW ONLY");
//		
//		listPair.put("CPCI031AddingACustomerContact.feature", "SELECT ACCT.ACCT_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.SA_TYPE_CD =  'E-RES' AND SA.SA_STATUS_FLG='20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPFS002UpdateExistingFAScheduledDate.feature", "SELECT DISTINCT(FA1.FA_ID) FROM CI_SA SA, CI_SA_SP SASP, CI_FA FA1, CI_ACCT ACCT WHERE SA.SA_ID = SASP.SA_ID AND ACCT.ACCT_ID = SA.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND SASP.SP_ID = FA1.SP_ID AND SA.SA_STATUS_FLG = '20' AND FA1.FA_STATUS_FLG = 'P' AND NOT EXISTS (SELECT FA2.FA_ID FROM CI_FA FA2 WHERE FA2.SP_ID = FA1.SP_ID AND FA2.SCHED_DTTM = '01-JAN-20') FETCH FIRST ROW ONLY");
//		listPair.put("CPFS003CancelExistingFA.feature", "SELECT DISTINCT(FA1.FA_ID) FROM CI_SA SA, CI_SA_SP SASP, CI_FA FA1, CI_ACCT ACCT WHERE SA.SA_ID = SASP.SA_ID AND ACCT.ACCT_ID = SA.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND SASP.SP_ID = FA1.SP_ID AND SA.SA_STATUS_FLG = '20' AND FA1.FA_STATUS_FLG = 'P' FETCH FIRST ROW ONLY");
//		listPair.put("CPFIN03AddingADepositTenderControl.feature", MANUAL);
//		listPair.put("CPFS009CreateAndCompleteFA.feature", "SELECT SA.ACCT_ID, SASP.SP_ID FROM CI_SA SA, CI_SA_SP SASP, CI_SP SP WHERE SA.SA_ID = SASP.SA_ID AND SA.SA_STATUS_FLG = '20' AND SA.SA_TYPE_CD = 'E-RES' AND SP.SP_ID = SASP.SP_ID AND SP.SP_SRC_STATUS_FLG = 'C' AND NOT EXISTS (SELECT 'X' FROM CI_FA FA WHERE FA.FA_TYPE_CD = 'ELMTROFF' AND FA.FA_STATUS_FLG = 'P' AND FA.SP_ID = SP.SP_ID) FETCH FIRST ROW ONLY");
//		
//		
//		listPair.put("CPCI008AddingAPremiseRecord.feature", MANUAL);
//		listPair.put("CPCI014AddingAManualToDo.feature", "SELECT SA.ACCT_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.SA_TYPE_CD = 'E-RES' AND SA.SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPCC002AddingACollectionAgencyReferral.feature", "SELECT SA.ACCT_ID FROM CI_SA SA, CI_FT FT, CI_ACCT ACCT WHERE SA.SA_ID = FT.SA_ID AND SA.SA_TYPE_CD = 'E-RES' AND SA.SA_STATUS_FLG = '40' AND ACCT.ACCT_ID = SA.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' HAVING SUM(FT.CUR_AMT)> 100 GROUP BY SA.ACCT_ID FETCH FIRST ROW ONLY");
//		listPair.put("CPCC028AddingAPayPlan.feature", "SELECT SA.ACCT_ID, SUM(FT.CUR_AMT) BALANCE FROM CI_SA SA, CI_FT FT, CI_ACCT ACCT WHERE SA.SA_ID = FT.SA_ID AND SA.SA_TYPE_CD = 'E-RES' AND SA.SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND NOT EXISTS (SELECT 'X' FROM CI_PP PP WHERE PP.PP_STAT_FLG = '20' AND PP.PP_TYPE_CD = 'ELECTRIC' AND PP.ACCT_ID = SA.ACCT_ID) HAVING SUM(FT.CUR_AMT)> 300 GROUP BY SA.ACCT_ID FETCH FIRST ROW ONLY");
//		listPair.put("CPCI031CancelingAPayPlan.feature", "SELECT PP.ACCT_ID FROM CI_PP PP, CI_ACCT ACCT WHERE PP_TYPE_CD = 'ELECTRIC' AND PP_STAT_FLG = '20' AND PP.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPBI001ManuallyGeneratingABill.feature", "SELECT SA.ACCT_ID, TO_CHAR(MR1.READ_DTTM, 'MM-DD-YYYY') READ_DTTM, RR.REG_READING FROM CI_SA SA, CI_SA_SP SASP, CI_CFG_SPMR_VW SMI, CI_MR MR1, CI_REG_READ RR, CI_SP SP, CI_SP_TYPE_L SPTYPE, CI_ACCT ACCT WHERE SA.SA_ID = SASP.SA_ID AND SA.SA_STATUS_FLG = '20' AND SASP.SP_ID = SMI.SP_ID AND SASP.SP_ID = SP.SP_ID AND SP.SP_STATUS_FLG = 'R' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND SP.SP_TYPE_CD = SPTYPE.SP_TYPE_CD AND SMI.REMOVAL_MR_ID = ' ' AND SMI.MTR_CONFIG_ID = MR1.MTR_CONFIG_ID AND MR1.READ_DTTM < '01-JULY-2020' AND MR1.MR_ID = (SELECT MR2.MR_ID FROM CI_MR MR2 WHERE MR2.MTR_CONFIG_ID = MR1.MTR_CONFIG_ID ORDER BY MR2.READ_DTTM DESC FETCH FIRST 1 ROW ONLY) AND MR1.MR_ID = RR.MR_ID FETCH FIRST ROW ONLY");
//		
//		listPair.put("CPFIN26TransferringOfBalance.feature", "SELECT ACCT.ACCT_ID, SA.SA_ID FROM CI_ACCT ACCT, CI_SA SA, CI_FT FT WHERE SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' AND SA.SA_STATUS_FLG = '20' AND SA.SA_TYPE_CD = 'E-RES' AND SA.SA_ID = FT.SA_ID GROUP BY ACCT.ACCT_ID, SA.SA_ID HAVING SUM(FT.CUR_AMT) >= 100 FETCH FIRST ROW ONLY");
//		listPair.put("CPCI030AddingAPaymentArrangementRequest.feature", "SELECT SA.ACCT_ID, SUM(FT.CUR_AMT) FROM CI_SA SA, CI_FT FT, CI_ACCT ACCT WHERE SA.SA_ID = FT.SA_ID AND SA.SA_TYPE_CD = 'E-RES' AND SA.SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' HAVING SUM (FT.CUR_AMT) > 1000 GROUP BY SA.ACCT_ID FETCH FIRST ROW ONLY");
//		listPair.put("CPCI068StartingServiceUsingAnOrderCampaignRES.feature", "SELECT SA.CHAR_PREM_ID PREM_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.SA_TYPE_CD = 'E-RES' AND SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		listPair.put("CPCI069StartingServiceUsingAnOrderCampaignCOM.feature", "SELECT SA.CHAR_PREM_ID PREM_ID FROM CI_SA SA, CI_ACCT ACCT WHERE SA.SA_TYPE_CD = 'E-COM' AND SA_STATUS_FLG = '20' AND SA.ACCT_ID = ACCT.ACCT_ID AND ACCT.CIS_DIVISION = 'CPP' FETCH FIRST ROW ONLY");
//		
//		listPair.put("SEC001CheckPremiseCWDCISDivision.feature", "SELECT PREM.PREM_ID FROM CI_PREM PREM, C1_USER_CIS_DIV USRDIV WHERE ADDRESS1 LIKE '%4110 DENISON%' AND PREM.CIS_DIVISION = USRDIV.CIS_DIVISION AND USRDIV.USER_ID = 'CWDUSER'");
//		listPair.put("SEC002CheckPremiseCPPCISDivision.feature", "SELECT PREM.PREM_ID FROM CI_PREM PREM, C1_USER_CIS_DIV USRDIV WHERE ADDRESS1 LIKE '%4110 DENISON%' AND PREM.CIS_DIVISION = USRDIV.CIS_DIVISION AND USRDIV.USER_ID = 'CPPUSER'");
		
		
		return listPair;
	}
	
	
	public static void CI016CreateAPremiseFormat(FileWriter fw, String testName) throws IOException{
		columnNames = "|testName|username|password|premType|cisDiv|address1|cityField|state|trendArea|premChar|charVal|premChar1|charVal1|premGeoType|premGeoVal|";
		fw.append(columnNames + "\n");
    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Single family home|Cleveland|448 Main Street|Cleveland|OH|Cleveland Metropolitan Area|City Code|001000|Level|C1|Street Name|Main|\n");
	}
	
	public static void CI018AddSPRecordToAPremiseFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|premId|spType|meterLocation|serviceCycle|serviceRoute|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String premID  = result.getString("PREM_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + premID + "|E-RES|9|MB20|119669|Add|\n");
      	}
	}
	
	public static void CI022AddALogEntryToACustomerContactFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|ccId|comment|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String ccID  = result.getString("CC_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + ccID + "|Selenium Comment|\n");
      	}
	}
	
	public static void FS001AddAFieldActivityFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|spId|faType|schedDate|time|instructions|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String spID  = result.getString("SP_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + spID + "|INV-AMR|08-26-2020|12:00AM|Selenium Test|Add|\n");
      	}
	}
	
	public static void FS002UpdateExistingFAScheduledDateFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|faStatus|schedDate|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Pending|01-01-2020|Update|\n");
      	}
	}
	
	public static void FS003CancelAnExistingFAFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|faStatus|cancelReason|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Pending|Office Cancelled|\n");
      	}
	}
	
	public static void MT003AddAMeterReadFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|spType|spStatus|readDate|addDays|regType|regRead|addMeterRead|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String spType  = result.getString("SP_TYPE").trim();
			String readDate  = result.getString("READ_DTTM").trim();
			String regReading  = result.getString("REG_READING").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + spType + "|In Service|" + readDate + "|15|Regular|" + regReading + "|50.0|\n");
      	}
	}
	
	public static void PY005SearchingForAPaymentFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchFor|paymentAccount|accountId|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Payment|Account|" + acctID + "|\n");
      	}
	}
	
	public static void PY010CancellingAPaymentFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|paymentStatus|cancelReason|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Frozen|Stopped payment|\n");
      	}
	}
	
	public static void TD001CompletingAToDoFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|toDoId|comment|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String toDoID  = result.getString("TD_ENTRY_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + toDoID + "|Selenium Testing|\n");
      	}
	}
	
	public static void CPCC003AddingACollectionProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|collClassCtrlCode|collProcTemplate|daysInArrears|comment|saID|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String saID  = result.getString("SA_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|E-RES-REGULAR|CPP COLLECTIONS TIER1|40|Selenium Test|" + saID + "|Add|\n");
      	}
	}
	
	public static void CPCC005AddingASeveranceProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|saID|sevProcTemplate|daysInArrears|comment|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String saID  = result.getString("SA_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + saID + "|Stormwater Only Severance Lien|40|Selenium Test Add SEVPROC|Add|\n");
      	}
	}
	
	public static void CPCC007AddingAWriteOffProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|writeOffControl|comments|writeOffProcTmplt|saID|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String saID  = result.getString("SA_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|RES ELEC WO|Selenium Test|Write Off Electric|" + saID + "|Add|\n");
      	}
	}
	
	public static void CPCC020ModifyingACollectionEventTriggerDateFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|comments|eventSequence|newTriggerDate|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String eventSeq  = result.getString("EVT_SEQ").trim();
			String newTriggerDate  = result.getString("NEWTRIGGERDATE").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Selenium Test Modify|" + eventSeq + "|" + newTriggerDate + "|Update|\n");
      	}
	}
	
	public static void CPCC021ModifyingASeveranceEventTriggerDateFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|comments|eventSequence|newTriggerDate|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String eventSeq  = result.getString("EVT_SEQ").trim();
			String newTriggerDate  = result.getString("NEWTRIGGERDATE").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Selenium Test Modify|" + eventSeq + "|" + newTriggerDate + "|Update|\n");
      	}
	}
	
	public static void CPCC022ModifyingAWriteOffEventTriggerDateFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|comments|eventSequence|newTriggerDate|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String eventSeq  = result.getString("EVT_SEQ").trim();
			String newTriggerDate  = result.getString("NEWTRIGGERDATE").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Selenium Test Modify|" + eventSeq + "|" + newTriggerDate + "|Update|\n");
      	}
	}
	
	public static void CPCC025ViewingACollectionProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|eventSequence|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String eventSeq  = result.getString("EVT_SEQ").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + eventSeq + "|\n");
      	}
	}
	
	public static void CPCC026ViewingASeveranceProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|eventSequence|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String eventSeq  = result.getString("EVT_SEQ").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + eventSeq + "|\n");
      	}
	}
	
	public static void CPCC027ViewingAWriteOffProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|eventSequence|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String eventSeq  = result.getString("EVT_SEQ").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + eventSeq + "|\n");
      	}
	}
	
	public static void CPCC010CancelingACollectionProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|comments|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Selenium Test Cancel|\n");
      	}
	}
	
	public static void CPCC013CancelingASeveranceProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|comments|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Selenium Test Cancel|\n");
      	}
	}
	
	public static void CPCC015CancelingAWriteOffProcessFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|comments|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Selenium Test Cancel|\n");
      	}
	}
	
	public static void CPCC019ManuallyAddingCreditPointsFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|rollOffDays|credits|comments|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|7|12|Selenium Test|\n");
      	}
	}
	
	public static void CPFIN01AddingAnAdjustmentFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|adjustmentType|amount|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|E-NSF|$25.00|\n");
      	}
	}
	
	public static void CPFIN02CancelingAnAdjustmentFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|adjustmentID|comment|cancelReason|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String adjID  = result.getString("ADJ_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + adjID + "|Selenium Testing|Incorrect Adjustment|\n");
      	}
	}
	
	public static void CPFIN08AddingAPaymentEventFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|date|distributionCode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|08-10-2020|Distribute and Freeze if OK|\n");
      	}
	}
	
	public static void CPFIN11CancelingAutoPayFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|endDate|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String endDate  = result.getString("END_DATE").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + endDate + "|\n");
      	}
	}
	
	public static void CPCI001AddingAPersonRecordFormat(FileWriter fw, String testName) throws IOException, SQLException{
		columnNames = "|testName|username|password|type|name|contactType|contactNo|idType|idNo|custClass|";
		fw.append(columnNames + "\n");
		fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Person|CPP, CCC|Cell Phone|(222) 444-5555|Social security number|444-55-1111|Electric Residential|\n");
	}
	
	public static void CPCI004SettingUpAutopayFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|startDate|sourceCode|externalAcctID|name|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|08-20-2020|CPPDOLLARBNK|1234567890|CPP, CPP|\n");
      	}
	}
	
	public static void CPCI009AddingAServicePointRecordFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|premId|spType|meterLocation|serviceCycle|serviceRoute|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String premID  = result.getString("PREM_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + premID + "|E-RES|9|EM08|3399|Update|\n");
      	}
	}
	
	public static void CPCI032AddingAManualAlertFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|alertType|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Enrolled in Paperless Billing|\n");
      	}
	}
	
	public static void CPBI014SettingAMaximumBillThresholdFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|maxBillThreshold|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|$100.00|\n");
      	}
	}
	
	public static void CPFS001CreateANewFAManuallyFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|spID|faType|scheduleDate|scheduleTime|instructions|dispatchGroup|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String spID  = result.getString("SP_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + spID + "|EVADD|08-26-2020|12:00AM|Selenium Test|CPPMTR|Add|\n");
      	}
	}
	
	public static void CPCI022CreatingADepositSAFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|saType|premID|depositAmt|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String premID  = result.getString("PREM_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|E-RESDEP|" + premID + "|150.00|\n");
      	}
	}
	
	public static void CPCI031AddingACustomerContactFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|contactClass|contactType|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|General customer contact|CPPWELCOME|\n");
      	}
	}
	
	public static void CPFS002UpdateExistingFAScheduledDateFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|faID|schedDate|mode|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String faID  = result.getString("FA_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + faID + "|01-01-2020|Update|\n");
      	}
	}
	
	public static void CPFS003CancelExistingFAFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|faID|cancelReason|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String faID  = result.getString("FA_ID").trim();
	    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + faID + "|Office Cancelled|\n");
      	}
	}
	
	public static void CPFIN03AddingADepositTenderControlFormat(FileWriter fw, String testName) throws IOException{
		columnNames = "|testName|username|password|endBal|tenderSource|";
		fw.append(columnNames + "\n");
    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|$0.00|CPPMANUL|\n");
	}
	
	public static void CPFS009CreateAndCompleteFAFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|spID|faType|scheduleDate|scheduleTime|instructions|dispatchGroup|mode|spStatus|disconnectLoc|mode2|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String spID  = result.getString("SP_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + spID + "|ELMTROFF|08-20-2020|10:30AM|Selenium Test|CPPMTR|Add|Disconnected|Connection|Update|\n");
      	}
	}
	
	public static void CPCI008AddingAPremiseRecordFormat(FileWriter fw, String testName) throws IOException{
		columnNames = "|testName|username|password|premType|cisDiv|postalCode|address1|cityField|county|state|trendArea|premChar|charVal|premChar1|charVal1|timeZone|premGeoType|premGeoVal|";
		fw.append(columnNames + "\n");
    	fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Single family home|Cleveland Public Power|44105|448 Main Street|Cleveland|Cuyahoga|OH|Cleveland Public Power|City Code|001000|Level|C1|US Eastern Time|Parcel ID Number|56782145|\n");
	}
	
	public static void CPCI014AddingAManualToDoFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|toDoType|priority|subject|comment|sendTo|role|acctID|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Customer Refund|Priority 10 -- Highest|Test|Test|Role|CMCSMGRSUP|" + acctID + "|\n");
      	}
	}
	
	public static void CPCC002AddingACollectionAgencyReferralFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|collAgency|status|comments|creationDate|referralAmt|referralRsn|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|CPPCOLAG|Active|Selenium Test|08-20-2020|$20.00|Initial Referral|\n");
      	}
	}
	
	public static void CPCC028AddingAPayPlanFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|ppType|payMethod|schedDate|schedAmt|comments|contactClass|contactType|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String balance  = result.getString("BALANCE").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|ELECTRIC|Voucher|08-20-2020|" + balance + "|Selenium Test|Customer Service|ANONYMOUS|\n");
      	}
	}
	
	public static void CPCI031CancelingAPayPlanFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|comments|contactClass|contactType|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|Cancel Pay Plan|Credit and Collections contacts|MISINFO|\n");
      	}
	}
	
	public static void CPBI001ManuallyGeneratingABillFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|readDate|addDays|regType|meterRead|addMeterRead|cutOff|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String readDate  = result.getString("READ_DTTM").trim();
			String regReading  = result.getString("REG_READING").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|" + readDate + "|15|Regular|" + regReading + "|250|08-17-2020|\n");
      	}
	}
	
	public static void CPFIN26TransferringOfBalanceFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|adjustmentType|amount|comments|transferSaId|comment2|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			String saID  = result.getString("SA_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|E-XFER|$5.00|Selenium Testing|" + saID + "|Selenium Testing|\n");
      	}
	}
	
	public static void CPCI030AddingAPaymentArrangementRequestFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|accountId|payArrReqType|numbOfInstallments|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String acctID  = result.getString("ACCT_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|Account ID|" + acctID + "|PA - Select SAs / Down Payment Optional / Elig Crit / No Approval|3|\n");
      	}
	}
	
	public static void CPCI068StartingServiceUsingAnOrderCampaignRESFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|premId|campaign|perInfoFlg|perNameType|perName|perContactType|perContactInfo|acctInfoFlg|custClass|mode|q0|q1|q2|q3|q4|q5|q6|q7|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String premID  = result.getString("PREM_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + premID + "|RES-CPPSTRT|Create New Person|Primary|TEST, RESPERD|Cell Phone|(678) 495-4444|Create New Account|Electric Residential|DEFAULT|~|~|~|~|~|~|~|~|\n");
      	}
	}
	
	public static void CPCI069StartingServiceUsingAnOrderCampaignCOMFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|premId|campaign|perOrBusFlg|perInfoFlg|perNameType|perName|perContactType|perContactInfo|acctInfoFlg|custClass|mode|q0|q1|q2|q3|q4|q5|q6|q7|q8|q9|q10|q11|";
		fw.append(columnNames + "\n");
		while(result.next()){
			String premID  = result.getString("PREM_ID").trim();
			fw.append("|" + testName + "|" + USERNAME + "|" + PASSWORD + "|" + premID + "|COM-CPPSTRT|Business|Create New Person|Primary|Luke Lounge|Cell Phone|(678) 495-3652|Create New Account|Electric Commercial|DEFAULT|~|~|~|~|~|~|~|~|~|~|~|~|\n");
      	}
	}
	
	public static void SEC001CheckPremiseCWDCISDivisionFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|address|premiseIDs|";
		fw.append(columnNames + "\n");
		String IDs = "";
		
		while(result.next()){
			String premID  = result.getString("PREM_ID").trim();
			IDs = IDs.concat(premID + "~");
      	}
		IDs = IDs.substring(0, IDs.length()-1);
		fw.append("|" + testName + "|cwduser|cwduser001|Name and Address|4110 DENISON|" + IDs + "|\n");
	}
	
	public static void SEC002CheckPremiseCPPCISDivisionFormat(FileWriter fw, String testName, ResultSet result) throws IOException, SQLException{
		columnNames = "|testName|username|password|searchType|address|premiseIDs|";
		fw.append(columnNames + "\n");
		String IDs = "";
		
		while(result.next()){
			String premID  = result.getString("PREM_ID").trim();
			IDs = IDs.concat(premID + "~");
      	}
		IDs = IDs.substring(0, IDs.length()-1);
		fw.append("|" + testName + "|cppuser|cppuser001|Name and Address|4110 DENISON|" + IDs + "|\n");
	}
}
