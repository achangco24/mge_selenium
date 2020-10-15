/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Util
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
package aut;

import java.util.Random;

public class Util {
	public static String generateText(int lengthLimit) {
		String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder name = new StringBuilder();

		int ctr = 0;
		Random rnd = new Random();
		while (ctr < lengthLimit) {
			// length of the random string.
			int index = (int) (rnd.nextFloat() * saltChars.length());
			name.append(saltChars.charAt(index));
			ctr++;
		}

		return name.toString();
	}
	
	public static String generateNumber(int lengthLimit) {
		String saltChars = "0123456789";
		StringBuilder number = new StringBuilder();

		int ctr = 0;
		Random rnd = new Random();
		while (ctr < lengthLimit) {
			// length of the random string.
			int index = (int) (rnd.nextFloat() * saltChars.length());
			number.append(saltChars.charAt(index));
			ctr++;
		}

		return number.toString();
	}
	
	public static String generatePhoneNumber() {
		String phoneNumber = generateNumber(10);
		return phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
	}
}
