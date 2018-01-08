package com.telefonica.mockapi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	
	public static String getCalcDateString(Boolean old, Long days) {
		
		Date today = new Date();
		Date newDate = old ? 
				new Date(today.getTime() - (days*(1000 * 60 * 60 * 24))) :
					new Date(today.getTime() + (days*(1000 * 60 * 60 * 24)));
		
		return sdf.format(newDate);
	}
}
