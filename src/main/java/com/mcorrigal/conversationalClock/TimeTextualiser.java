package com.mcorrigal.conversationalClock;

import static com.mcorrigal.conversationalClock.ConversationalTimeConstants.*;

public class TimeTextualiser {

	public String textualise(Time time) {
		if (isMidday(time)) return MIDDAY;
		if (isMidnight(time)) return MIDNIGHT;
		if (isOClock(time)) return createOClockMessage(time);
		if (isPastHour(time)) return createPastHourMessage(time);
		if (isToHour(time)) return createToHourMessage(time);
		return null;
	}

	private String createOClockMessage(Time time) {
		return textForHour(time.getHour()) + " " + OCLOCK;
	}
	
	private String createPastHourMessage(Time time) {
		return createPastOrToMessage(
				textForMinute(time.getMinute()), 
				PAST, 
				textForHour(time.getHour()));
	}
	
	private String createToHourMessage(Time time) {
		return createPastOrToMessage(
				textForMinute(getMinutesToNextHour(time.getMinute())),
				TO, 
				textForHour(getNextHour(time.getHour())));
	}

	private boolean isMidday(Time time) {
		return (time.getHour() == 12 && time.getMinute() == 0) ? true : false;
	}
	
	private boolean isMidnight(Time time) {
		return (time.getHour() == 0 && time.getMinute() == 0) ? true : false;
	}
	
	private boolean isOClock(Time time) {
		return time.getMinute() == 0 ? true : false;
	}
	
	private boolean isPastHour(Time time) {
		return (time.getMinute() <= 30) ? true : false;
	}
	
	private boolean isToHour(Time time) {
		return (time.getMinute() > 30) ? true : false;
	}
	
	private int getNextHour(int currentHour) {
		return currentHour == 23 ? 0 : currentHour + 1;
	}
	
	private int getMinutesToNextHour(int currentMinute) {
		return 60 - currentMinute;
	}
	
	private String createPastOrToMessage(String minutes, String pastOrTo, String hour) {
		return String.format("%s %s %s", minutes, pastOrTo, hour);
	}

}
