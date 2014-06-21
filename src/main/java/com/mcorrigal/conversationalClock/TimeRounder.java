package com.mcorrigal.conversationalClock;

public class TimeRounder {

	public Time round(Time time) {
		if (isTimeAlreadyAtFiveMinuteInterval(time)) {
			return time;
		} else {
			return performRounding(time);
		}
	}

	private Time performRounding(Time time) {
		int remainderOnModFive = modFive(time.getMinute());
		if (remainderOnModFive == 1 || remainderOnModFive == 2) {
			return roundDown(time, remainderOnModFive);
		} else {
			return roundUp(time, remainderOnModFive);
		}
	}

	private Time roundDown(Time time, int remainderOnModFive) {
		time.subtractMinutes(remainderOnModFive);
		return time;
	}
	
	private Time roundUp(Time time, int remainderOnModFive) {
		time.addMinutes(5 - remainderOnModFive);
		return time;
	}

	private boolean isTimeAlreadyAtFiveMinuteInterval(Time time) {
		return (modFive(time.getMinute()) == 0) ? true : false;
	}
	
	private int modFive(int valiue) {
		return valiue % 5;
	}
	
	

}
