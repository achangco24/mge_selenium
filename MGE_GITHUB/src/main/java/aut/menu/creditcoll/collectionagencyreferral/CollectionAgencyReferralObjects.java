/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Collection Agency Referral Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-06-30	RExtra	CP_CC.002	Add components to Add Collection Agency Referral            
 * 
 *************************************************************************************
 */
package aut.menu.creditcoll.collectionagencyreferral;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class CollectionAgencyReferralObjects extends WebElementRepository{
	private EntityFrameObjects frame;
	private WebDriver driver;
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	private final ElementHandler frameCollRefHist;
	
	public final ElementHandler collectionAgency;
	public final ElementHandler startDate;
	public final ElementHandler referralStatus;
	public final ElementHandler comments;
	
	public final ElementHandler acctID;
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
	
	public CollectionAgencyReferralObjects(WebDriver aut, EntityFrameObjects frame) {
		this.frame = frame;
		driver = aut;
		
		/*
		 * CP_CC.002 - 2020-06-30 - Start Add
		 */
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("collRefHis_datagrid"));
		frameCollRefHist = new ElementHandler(driver, By.id("collRefHis_datagrid"), map);
		
		collectionAgency = new ElementHandler(aut, By.id("AGY_REF$COLL_AGY_CD"), this.frame.tabPage.toFrameMap());
		startDate = new ElementHandler(aut, By.id("AGY_REF$START_DT"), this.frame.tabPage.toFrameMap());
		referralStatus = new ElementHandler(aut, By.id("AGY_REF$REF_STATUS_FLG"), this.frame.tabPage.toFrameMap());
		comments = new ElementHandler(aut, By.id("AGY_REF$COMMENTS"), this.frame.tabPage.toFrameMap());
		
		acctID = new ElementHandler(aut, By.id("ACCT_ID"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CC.002 - 2020-06-30 - End Add
		 */
	}
	
	/*
	 * CP_CC.002 - 2020-06-30 - Start Add
	 */
	public ElementHandler getCreationDateElementAtIndex(int index) {
		String id = "AGY_HIS:" + String.valueOf(index) + "$CRE_DT";
		return new ElementHandler(driver, By.id(id), frameCollRefHist.toFrameMap());
	}
	
	public ElementHandler getReferralAmtElementAtIndex(int index) {
		String id = "AGY_HIS:" + String.valueOf(index) + "$REF_AMT";
		return new ElementHandler(driver, By.id(id), frameCollRefHist.toFrameMap());
	}
	
	public ElementHandler getReasonElementAtIndex(int index) {
		String id = "AGY_HIS:" + String.valueOf(index) + "$REF_HIST_RSN_FLG";
		return new ElementHandler(driver, By.id(id), frameCollRefHist.toFrameMap());
	}
	/*
	 * CP_CC.002 - 2020-06-30 - End Add
	 */
}
