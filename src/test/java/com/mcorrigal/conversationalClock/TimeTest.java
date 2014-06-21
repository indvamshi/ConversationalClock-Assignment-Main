package com.mcorrigal.conversationalClock;

import static com.mcorrigal.conversationalClock.TestUtils.assertTime;

import com.mcorrigal.conversationalClock.Time;

import junit.framework.TestCase;


public class TimeTest extends TestCase {

	private Time time;
	
	@Override
	public void setUp() throws Exception {
		time = new Time(12, 30);
	}
	
	public void testNewTime() {
		assertTime(12, 30, time);
	}
	
	public void testNewTimeFromString() throws Exception {
		assertTime(12, 30, Time.create("12:30"));
	}
	
	public void testBadTimeStringHandling() {
		String[] badTimeStrings = {"1230", "AAAA", "1:0", "01:1", " 1:01"};
		for (String badTimeString : badTimeStrings) {
			try {
				Time.create(badTimeString);
			} catch (Exception e) {
				assertEquals("Not a valid time, enter in form hh:mm", e.getMessage());
			}
		}
	}
	
	public void testBadTimeHandling() {
		try {
			new Time(24, 0);
		} catch (Exception e) {
			assertEquals("Not a valid time, enter between 0 and 23 hours, and 0 and 59 minutes", e.getMessage());
		}
		try {
			new Time(20, 61);
		} catch (Exception e) {
			assertEquals("Not a valid time, enter between 0 and 23 hours, and 0 and 59 minutes", e.getMessage());
		}
	}
	
	public void testAddMinutesToTime() {
		time.addMinutes(5);
		assertTime(12, 35, time);
	}
	
	public void testSubtractMinutesFromTime() {
		time.subtractMinutes(5);
		assertTime(12, 25, time);
	}
	
	public void testAddMinutesThroughToNextHour() {
		time.addMinutes(35);
		assertTime(13, 5, time);
	}
	
	public void testSubtractMinutesThroughToPreviousHour() {
		time.subtractMinutes(35);
		assertTime(11, 55, time);
	}
	
	public void testAddMinutesThroughToNextDay() {
		time.addMinutes(720);
		assertTime(0, 30, time);
	}
	
	public void testSubtractMinutesThroughToPreviousDay() {
		time.subtractMinutes(780);
		assertTime(23, 30, time);
	}
	
}
