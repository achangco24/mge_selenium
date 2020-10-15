/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Order Objects
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-14	RExtra	CP_CI.068	Add components for Starting Service Using an
 * 									Order/Campaign RES
 * 2020-07-16	RExtra	CP_CI.069	Add components for Starting Service Using an
 * 									Order/Campaign COM        
 * 
 *************************************************************************************
 */
package aut.menu.salesmarketing.order;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import aut.entity.EntityFrameObjects;
import ey.manila.qa.automation.element.ElementHandler;
import ey.manila.qa.automation.element.WebElementRepository;

public class OrderObjects extends WebElementRepository {
	private WebDriver driver;
	private EntityFrameObjects frame;
	
	public final ElementHandler campaign;
	public final ElementHandler name;
	public final ElementHandler eligibilityBtn;
	public final ElementHandler orderPackage;
	public final ElementHandler completeBtn;
	public final ElementHandler pkgInfo;
	public final ElementHandler qResponse0, qResponse1;
	
	//Elements under Order Search Pop-up
	public final ElementHandler ordId;
	public final ElementHandler ordIdSearchBtn;
	public final ElementHandler overridelink;
	public final ElementHandler moreInfo;
	
	/*
	 * CP_CI.068 - 2020-07-14 - Start Add
	 */
	public final ElementHandler campaignInfo;
	public final ElementHandler startDate;
	
	public final ElementHandler personInfoFlg;
	public final ElementHandler personNameFrame;
	public final ElementHandler personContactsFrame;
	
	public final ElementHandler acctInfoFlg;
	public final ElementHandler customerClass;
	
	/*
	 * CP_CI.068 - 2020-07-14 - End Add
	 */
	
	/*
	 * CP_CI.069 - 2020-07-16 - Start Add
	 */
	public final ElementHandler perOrBusFlg;
	/*
	 * CP_CI.069 - 2020-07-16 - End Add
	 */
	
	public OrderObjects(WebDriver aut, EntityFrameObjects frame) {
		driver = aut;
		this.frame = frame;
		
		campaign = new ElementHandler(driver, By.id("CAMPAIGN_CD"), this.frame.tabPage.toFrameMap());
		name = new ElementHandler(driver, By.id("ENRL_NM:0$ENTITY_NAME"), this.frame.enrollName.toFrameMap());
		eligibilityBtn = new ElementHandler(driver, By.id("ACTION_SHOW_PKG_SW"), this.frame.tabPage.toFrameMap());
		orderPackage = new ElementHandler(driver, By.xpath("/html/body/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/span"), this.frame.pkgTree.toFrameMap());
    	completeBtn = new ElementHandler(driver, By.id("ACTION_COMPLETE_SW"));
    	pkgInfo = new ElementHandler(driver, By.id("PACKAGE_INFO"));
    	
    	qResponse0 = new ElementHandler(driver, By.id("ENRL_FLD:0$CHAR_VAL"), this.frame.enrollField.toFrameMap());
    	qResponse1 = new ElementHandler(driver, By.id("ENRL_FLD:1$CHAR_VAL"), this.frame.enrollField.toFrameMap());
    	
		//Order Search Pop-up
		ordId = new ElementHandler(aut, By.id("ENRL_ID"));
		ordIdSearchBtn = new ElementHandler(aut, By.id("BU_Main_enrlSrch"));
		overridelink = new ElementHandler(aut, By.id("overridelink"));
		moreInfo = new ElementHandler(aut, By.id("infoBlockIDImage"));
		
		/*
		 * CP_CI.068 - 2020-07-14 - Start Add
		 */
		campaignInfo = new ElementHandler(driver, By.id("CAMPAIGN_INFO"), this.frame.tabPage.toFrameMap());
		startDate = new ElementHandler(driver, By.id("START_DT"), this.frame.tabPage.toFrameMap());
		personInfoFlg = new ElementHandler(driver, By.id("ENRL_PER_INFO_FLG"), this.frame.tabPage.toFrameMap());
		
		List<By> map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("ENRL_NM"));
		personNameFrame = new ElementHandler(driver, By.id("ENRL_NM"), map);
		
		map = new ArrayList<By>();
		map.addAll(frame.tabPage.toFrameMap());
		map.add(By.id("ENRL_PER_CON_DETL"));
		personContactsFrame = new ElementHandler(driver, By.id("ENRL_PER_CON_DETL"), map);
		
		
		acctInfoFlg = new ElementHandler(driver, By.id("ENRL_ACCT_INFO_FLG"), this.frame.tabPage.toFrameMap());
		customerClass = new ElementHandler(driver, By.id("CUST_CL_CD"), this.frame.tabPage.toFrameMap());
		/*
		 * CP_CI.068 - 2020-07-14 - End Add
		 */
		
		/*
		 * CP_CI.069 - 2020-07-16 - Start Add
		 */
		perOrBusFlg = new ElementHandler(driver, By.id("PER_OR_BUS_FLG"), this.frame.tabPage.toFrameMap());;
		/*
		 * CP_CI.069 - 2020-07-16 - End Add
		 */
	}
	
	/*
	 * CP_CI.068 - 2020-07-14 - Start Add
	 */
	public ElementHandler getPersonNameTypeElementAtIndex(int index) {
		String id = "ENRL_NM:" + String.valueOf(index) + "$NAME_TYPE_FLG";
		return new ElementHandler(driver, By.id(id), personNameFrame.toFrameMap());
	}
	
	public ElementHandler getPersonNameElementAtIndex(int index) {
		String id = "ENRL_NM:" + String.valueOf(index) + "$ENTITY_NAME";
		return new ElementHandler(driver, By.id(id), personNameFrame.toFrameMap());
	}
	
	public ElementHandler getPersonContactTypeElementAtIndex(int index) {
		String id = "ENRL_CON:" + String.valueOf(index) + "$COMM_RTE_TYPE_CD";
		return new ElementHandler(driver, By.id(id), personContactsFrame.toFrameMap());
	}
	
	public ElementHandler getPersonContactInfoElementAtIndex(int index) {
		String id = "ENRL_CON:" + String.valueOf(index) + "$CONTACT_VALUE";
		return new ElementHandler(driver, By.id(id), personContactsFrame.toFrameMap());
	}
	
	public ElementHandler getPersonContactPrimaryElementAtIndex(int index) {
		String id = "ENRL_CON:" + String.valueOf(index) + "$CND_PRIMARY_SW";
		return new ElementHandler(driver, By.id(id), personContactsFrame.toFrameMap());
	}
	
	public ElementHandler getQuestionResponseElementAtIndex(int index) {
		String id = "ENRL_FLD:" + String.valueOf(index) + "$CHAR_VAL";
		return new ElementHandler(driver, By.id(id), this.frame.enrollField.toFrameMap());
	}
	/*
	 * CP_CI.068 - 2020-07-14 - End Add
	 */
	
	
}

