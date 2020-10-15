/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Admin
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
package aut.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import aut.admin.a.AdminA;
import aut.admin.b.AdminB;
import aut.admin.s.AdminS;
import aut.admin.d.AdminD;
import aut.admin.p.AdminP;

import aut.entity.EntityFrameObjects;


public class Admin {
	public final AdminB b;
	public final AdminS s;
	public final AdminD d;
	public final AdminA a;
	public final AdminP p;
	//public final  customerInformation;
	//public final Meter meter;
	//public final MeterRead meterRead;
	//public final Financial financial;
	
	public Admin(WebDriver aut, EntityFrameObjects frame, WebDriverWait wait) {
	//	customerInformation = new CustomerInformation(aut, frame, wait);
	//		meter = new Meter(aut, frame, wait);
	//	meterRead = new MeterRead(aut, frame, wait);
	//	financial = new Financial(aut, frame, wait);
		a = new AdminA(aut, frame, wait);
		b = new AdminB(aut, frame, wait);
		d = new AdminD(aut, frame, wait);
		s = new AdminS(aut, frame, wait);
		p = new AdminP(aut, frame, wait);
	}
}
