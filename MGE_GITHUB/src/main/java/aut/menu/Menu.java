/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Menu
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
package aut.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.entity.EntityFrameObjects;
import aut.menu.todo.ToDo;
import aut.menu.tool.Tool;
import aut.menu.creditcoll.CreditCollection;
import aut.menu.custinfo.CustomerInformation;
import aut.menu.fieldorder.FieldOrder;
import aut.menu.financial.Financial;
import aut.menu.financialquery.FinancialQuery;
import aut.menu.meter.Meter;
import aut.menu.meterread.MeterRead;
import aut.menu.salesmarketing.SalesMarketing;

public class Menu {
	public final CreditCollection creditCollection;
	public final CustomerInformation customerInformation;
	public final Meter meter;
	public final MeterRead meterRead;
	public final Financial financial;
	public final FieldOrder fieldOrder;
	public final Tool tool;
	public final SalesMarketing salesMarketing;
	public final FinancialQuery financialQuery;
	public final ToDo toDo;

	
	public Menu(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
		customerInformation = new CustomerInformation(aut, frame, wait);
		meter = new Meter(aut, frame, wait);
		meterRead = new MeterRead(aut, frame, wait);
		financial = new Financial(aut, frame, wait);
		fieldOrder = new FieldOrder(aut, frame, wait);
		tool = new Tool(aut, frame, wait);
		salesMarketing = new SalesMarketing(aut, frame, wait);
		creditCollection = new CreditCollection(aut, frame, wait);
		financialQuery = new FinancialQuery(aut, frame, wait);
		toDo = new ToDo(aut, frame, wait);
	}
}