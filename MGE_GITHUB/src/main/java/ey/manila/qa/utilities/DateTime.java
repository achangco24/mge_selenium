/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Date Time
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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <p>Acts as a wrapper class for various utilities concerning dates and time stamps.</p>
 * 
 * <p><b>Note</b><br>Time stamps for either the current date or a specified date
 * are generated through the {@link java.sql.Timestamp} library.</p>
 * 
 * <p>Built in formats are available through the
 * {@link ey.manila.qa.utilities.DateTime.Format} class, though user-defined formats can
 * also be used apart from the built in formats. Please see {@link java.text.SimpleDateFormat}
 * when specifying custom formatting.</p>
 * 
 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
 * @version 1.00
 * @since 2018-05-15
 * 
 * @see java.sql.Timestamp
 * @see java.text.SimpleDateFormat
 */
public class DateTime {
	/* 
	 * The default time stamp formatting when user did not specify any formatting
	 */
	private static final String defaultFormat = Format.LONGDATE;
	
	/**
	 *<p>Generates a time stamp from the current date using the default formatting
	 * {@value #defaultFormat}</p> 
	 * 
	 * @return {@link java.lang.String} representation of the time stamp as specified by the
	 * default format {@value #defaultFormat}
	 */
	public static String stamp() {
		return stamp(defaultFormat, TimeZone.getDefault());
	}
	
	/**
	 *<p>Generates a time stamp from the current date using the default formatting
	 * {@value #defaultFormat}</p> 
	 * 
	 * @param format String formatting for the time stamp to be generated
	 * 
	 * @return {@link java.lang.String} representation of the time stamp as specified by the
	 * default format {@value #defaultFormat}
	 * 
	 * @see java.util.TimeZone
	 */
	public static String stamp(TimeZone zone) {
		return stamp(defaultFormat, zone);
	}
	
	/**
	 *<p>Generates a time stamp from the current date using the specified formatting. The
	 * formatting can either be from the built in formats in
	 * {@link ey.manila.qa.utilities.DateTime.Format}, or from user-defined formatting as per
	 * {@link java.text.SimpleDateFormat}</p>
	 * 
	 *  @param format String formatting for the time stamp to be generated
	 * 
	 * @return {@link java.lang.String} representation of the time stamp as specified by the
	 * input format
	 * 
	 * @see ey.manila.qa.utilities.DateTime.Format
	 * @see java.text.SimpleDateFormat
	 */
	public static String stamp(String format) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return stamp(format, timestamp, TimeZone.getDefault());
	}
	
	/**
	 *<p>Generates a time stamp from the current date using the specified formatting. The
	 * formatting can either be from the built in formats in
	 * {@link ey.manila.qa.utilities.DateTime.Format}, or from user-defined formatting as per
	 * {@link java.text.SimpleDateFormat}</p>
	 * 
	 *  @param format String formatting for the time stamp to be generated
	 *  @param zone Timezone of the time stamp to be generated
	 * 
	 * @return {@link java.lang.String} representation of the time stamp as specified by the
	 * input format
	 * 
	 * @see ey.manila.qa.utilities.DateTime.Format
	 * @see java.text.SimpleDateFormat
	 * @see java.util.TimeZone
	 */
	public static String stamp(String format, TimeZone zone) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return stamp(format, timestamp, zone);
	}
	
	/**
	 *<p>Generates a time stamp from the specified date using the specified formatting. The
	 * formatting can either be from the built in formats in
	 * {@link ey.manila.qa.utilities.DateTime.Format}, or from user-defined formatting as per
	 * {@link java.text.SimpleDateFormat}</p>
	 * 
	 *  @param format String formatting for the time stamp to be generated
	 *  @param customDate {@link java.sql.Timestamp} representation of the date
	 * 
	 * @return {@link java.lang.String} representation of the time stamp as specified by the
	 * input format
	 * 
	 * @see ey.manila.qa.utilities.DateTime.Format
	 * @see java.sql.Timestamp
	 * @see java.text.SimpleDateFormat
	 */
	public static String stamp(String format, Timestamp customDate, TimeZone zone) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(zone);
		return dateFormat.format(customDate);
	}
	
	/**
	 * <p>Converts a specified String representation of a Date to its equivalent representation
	 * in Timestamp data type.</p>
	 * 
	 * @param date String representation of the date to be converted
	 * @param format String formatting for the time stamp to be generated.
	 * The formatting can either be from the built in formats in
	 * {@link ey.manila.qa.utilities.DateTime.Format}, or from user-defined formatting as per
	 * {@link java.text.SimpleDateFormat}
	 * 
	 * @return Timestamp representation of the specified string date
	 * 
	 * @throws Exception
	 * 
	 * @see ey.manila.qa.utilities.DateTime.Format
	 * @see java.sql.Timestamp
	 * @see java.text.SimpleDateFormat
	 */
	public static Timestamp stringToDate(String date, String format) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		return (Timestamp) dateFormat.parse(date);
	}
	
	/**
	 * <p>Defines the built in formats in specifying a date through
	 * {@link ey.manila.qa.utilities.DateTime} class. User-defined formats can also be used
	 * apart from the built in formats. Please see {@link java.text.SimpleDateFormat}
	 * when specifying custom formatting.</p>
	 * 
	 * @author EY Manila Testing Team (EY_PHADV_Manila_Testing.GID@ey.net) 
	 * @version 1.00
	 * @since 2017-05-15
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public class Format {
		/**
		 * <p>Formats the date  as MM/dd/yyyy</p>
		 * <p>Ex: 01/01/1970</p> 
		 */
		public static final String SHORTDATE = "MM/dd/yyyy";
		
		/**
		 * <p>Formats the date as MM/dd/yyyy HH:mm:ss</p>
		 * <p>Ex: 01/01/1970 00:00:00</p>
		 */
		public static final String LONGDATE = "MM/dd/yyyy HH:mm:ss";
		
		/**
		 * <p>Formats the date as HH:mm:ss</p>
		 * <p>Ex: 00:00:00</p>
		 */
		public static final String TIME = "HH:mm:ss";
		
		/**
		 * <p>Formats the date as yyyyMMddHHmmss</p>
		 * <p>Ex: 19700101000000</p>
		 */
		public static final String CUSTOMLONGDATE = "yyyyMMddHHmmss";
		
		/**
		 * <p>Formats the date as yyyyMMdd</p>
		 * <p>Ex: 19700101</p>
		 */
		public static final String CUSTOMSHORTDATE = "yyyyMMdd";
		
		/**
		 * <p>Formats the date as HHmmss</p>
		 * <p>Ex: 000000</p>
		 */
		public static final String CUSTOMTIME = "HHmmss";
		
		/**
		 * <p>Formats the date as yyyy</p>
		 * <p>Ex: 1970</p>
		 */
		public static final String YEAR = "yyyy";
		
		/**
		 * <p>Formats the date as M</p>
		 * <p>Ex: 1</p>
		 */
		public static final String MONTHINDEX = "M";
		
		/**
		 * <p>Formats the date as MMM</p>
		 * <p>Ex: Jan</p>
		 */
		public static final String MONTHSHORTNAME = "MMM";
		
		/**
		 * <p>Formats the date as MMMM</p>
		 * <p>Ex: January</p>
		 */
		public static final String MONTHLONGNAME = "MMMM";
		
		/**
		 * <p>Formats the date as d</p>
		 * <p>Ex: 1</p>
		 */
		public static final String DATEOFMONTH = "d";
		
		/**
		 * <p>Formats the date as E</p>
		 * <p>Ex: Sun</p>
		 */
		public static final String DAYOFWEEKSHORTNAME = "E";
		
		/**
		 * <p>Formats the date as EEEE</p>
		 * <p>Ex: Sunday</p>
		 */
		public static final String DAYOFWEEKLONGNAME = "EEEE";
	}
}