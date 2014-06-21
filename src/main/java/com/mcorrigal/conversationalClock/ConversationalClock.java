package com.mcorrigal.conversationalClock;

public class ConversationalClock {

	private TimeRounder timeRounder;
	private TimeTextualiser timeTextualiser;
	
	public ConversationalClock() {
		timeRounder = new TimeRounder();
		timeTextualiser = new TimeTextualiser();
	}
	
	public String tellTime(String timeString) throws Exception {
		Time time = Time.create(timeString);
		time = timeRounder.round(time);
		return timeTextualiser.textualise(time);
	}

}
