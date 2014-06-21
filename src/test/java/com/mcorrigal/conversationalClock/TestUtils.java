package com.mcorrigal.conversationalClock;

import static org.junit.Assert.assertEquals;

import com.mcorrigal.conversationalClock.Time;
import com.mcorrigal.conversationalClock.TimeTextualiser;

public class TestUtils {

	public static void assertTime(int expectedHour, int expectedMinute, Time time) {
		assertEquals(expectedHour, time.getHour());
		assertEquals(expectedMinute, time.getMinute());
	}
	
	public static void assertConversationalTime(String expectedConversationalTime, TimeTextualiser timeTextualiser, Time time) {
		assertEquals(expectedConversationalTime, timeTextualiser.textualise(time));
	}
	
}
