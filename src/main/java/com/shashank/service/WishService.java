package com.shashank.service;

import java.util.Calendar;
import org.springframework.stereotype.Service;

@Service
public class WishService {
	
	public String generateWish() {
		// get system Date and time
		Calendar calender = Calendar.getInstance();
		int hour = calender.get(Calendar.HOUR_OF_DAY);
	 	String msg = null;
		if (hour < 12)
			msg = " Good Morning too";
		else if (hour < 16)
			msg = " Good AfterNoon";
		else if (hour < 20)
			msg = " Good Evening";
		else
			msg = "Good Night";
		return msg;
	}// generateWish()
}
