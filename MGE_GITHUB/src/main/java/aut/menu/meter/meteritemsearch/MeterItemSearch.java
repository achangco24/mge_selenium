/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Meter/Item Search
 * 
 *************************************************************************************
 * 
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason: 
 * 2020-07-08	RExtra	CP_BI.002	Add components to CancelRebilling a Bill Segment
 * 
 *************************************************************************************
 */
package aut.menu.meter.meteritemsearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ey.manila.qa.automation.ScreenShot;
import ey.manila.qa.error.ErrorHandle;
import ey.manila.qa.logger.LogFile;
import aut.Ccb;
import aut.entity.Entity;
import aut.tabs.locationhistory.LocationHistoryGrid;

public class MeterItemSearch extends Entity{
	private MeterItemSearchObjects repo;
	private LogFile logger;
	private ErrorHandle errorHandle;
	private ScreenShot screenshot;
	private LocationHistoryGrid locationHistory;
	private Ccb ccb;
	
	public MeterItemSearch(Ccb ccb) {
		this.pageTitle = "Meter/Item Search";
		initialize(ccb);
		
		repo = new MeterItemSearchObjects(ccb.getDriver(), ccb.getCcbFrames());
	}
	
	/*
	 * CP_BI.002 - 2020-07-08 - Start Add
	 */
	public boolean openMeterItemInfoContextMenu() throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(repo.meterItemTbl.toWebElement()));
			List <WebElement> tableRows = repo.meterItemTbl.toWebElement().findElements(By.xpath("//*[@id='dataTableBody']/tr"));
			int tableSize = tableRows.size();
			for(int i = 0;i < tableSize; i++) {
				WebElement mtrItmInfoCntxMenu = repo.meterItemTbl.toWebElement().findElement(By.xpath("//*[@id='IM_MTR_ITEM:" + i + "$Grid_mtrCntxt']"));
				wait.until(ExpectedConditions.elementToBeClickable(repo.meterItemTbl.toWebElement()));
				mtrItmInfoCntxMenu.click();
			}
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Open Meter/Item Search Context Menu");
			logger.log(e);
			return false;
			}

	}
	
	public boolean navToSearchMeterRead() throws Exception {
		try {
			openMeterItemInfoContextMenu();
			repo.meterReadMenu.toWebElement().click();
			repo.search.toWebElement().click();			
			return true;
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorHandle.ExceptionHandle(screenshot, driver, "Failed to Navigate to Meter Read Search via Meter/Item Search Info Context Menu");
			logger.log(e);
			return false;
		}
	}
	
	/*
	 * CP_BI.002 - 2020-07-08 - End Add
	 */

	@Override
	public boolean open() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
