package com.mcorrigal.conversationalClock;

import java.util.HashMap;
import java.util.Map;

public class ConversationalTimeConstants {

	private static Map<Integer, String> HOUR_TEXTUAL_DICTIONARY = new HashMap<Integer, String>();
	private static Map<Integer, String> MINUTE_TEXTUAL_DICTIONARY = new HashMap<Integer, String>();
	
	public static final String MIDNIGHT = "Midnight";
	public static final String MIDDAY = "Midday";
	public static final String OCLOCK = "O'Clock";
	public static final String PAST = "past";
	public static final String TO = "to";
	
	static {
		HOUR_TEXTUAL_DICTIONARY.put(1, "One");
		HOUR_TEXTUAL_DICTIONARY.put(2, "Two");
		HOUR_TEXTUAL_DICTIONARY.put(3, "Three");
		HOUR_TEXTUAL_DICTIONARY.put(4, "Four");
		HOUR_TEXTUAL_DICTIONARY.put(5, "Five");
		HOUR_TEXTUAL_DICTIONARY.put(6, "Six");
		HOUR_TEXTUAL_DICTIONARY.put(7, "Seven");
		HOUR_TEXTUAL_DICTIONARY.put(8, "Eight");
		HOUR_TEXTUAL_DICTIONARY.put(9, "Nine");
		HOUR_TEXTUAL_DICTIONARY.put(10, "Ten");
		HOUR_TEXTUAL_DICTIONARY.put(11, "Eleven");
		HOUR_TEXTUAL_DICTIONARY.put(12, "Twelve");
		HOUR_TEXTUAL_DICTIONARY.put(0, "Midnight");
		
		MINUTE_TEXTUAL_DICTIONARY.put(5, "Five");
		MINUTE_TEXTUAL_DICTIONARY.put(10, "Ten");
		MINUTE_TEXTUAL_DICTIONARY.put(15, "A Quarter");
		MINUTE_TEXTUAL_DICTIONARY.put(20, "Twenty");
		MINUTE_TEXTUAL_DICTIONARY.put(25, "Twenty-Five");
		MINUTE_TEXTUAL_DICTIONARY.put(30, "Half");
	}
	
	public static String textForHour(int hour) {
		if (hour == 12) {
			return HOUR_TEXTUAL_DICTIONARY.get(hour); 
		} else {
			return HOUR_TEXTUAL_DICTIONARY.get(hour % 12);
		}
	}
	
	public static String textForMinute(int minute) {
		return MINUTE_TEXTUAL_DICTIONARY.get(minute);
	}
	
}
