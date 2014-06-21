package com.mcorrigal.conversationalClock;

import com.mcorrigal.conversationalClock.ConversationalClock;

import junit.framework.TestCase;

public class ConversationalClockTest extends TestCase {
 	
	private ConversationalClock conversationalClock;

	@Override
	public void setUp() {
		conversationalClock = new ConversationalClock();
	}
	
	public void testClockRespondsWithConversationalTime() throws Exception {
		assertConversationalTimeFromClock("Midnight", "00:00");
		assertConversationalTimeFromClock("Five past Midnight", "00:05");
		assertConversationalTimeFromClock("Midnight", "00:01");
		assertConversationalTimeFromClock("A Quarter to Midnight", "23:45");
	}
	
	private void assertConversationalTimeFromClock(String expectedConversationalTime, String timeString) throws Exception {
		assertEquals(expectedConversationalTime, conversationalClock.tellTime(timeString));
	}
	
}
