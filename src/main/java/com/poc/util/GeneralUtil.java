package com.poc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class GeneralUtil {
	
	public float getDateDiff(String _requestdate) {
		
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		float daysBetween=0;
		try {
			 Date dateBefore = myFormat.parse(_requestdate);
		     Date dateAfter = new Date();
		     long difference = dateAfter.getTime() - dateBefore.getTime();
		     daysBetween = (difference / (1000*60*60*24));
		     if(daysBetween<0)
		    	 daysBetween =0;
		     
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	     return daysBetween;
		
	}
	

}
