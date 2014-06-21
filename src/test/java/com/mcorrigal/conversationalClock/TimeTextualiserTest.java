package com.mcorrigal.conversationalClock;

import static com.mcorrigal.conversationalClock.ConversationalTimeConstants.MIDDAY;
import static com.mcorrigal.conversationalClock.ConversationalTimeConstants.MIDNIGHT;
import static com.mcorrigal.conversationalClock.TestUtils.assertConversationalTime;

import com.mcorrigal.conversationalClock.Time;
import com.mcorrigal.conversationalClock.TimeTextualiser;

import junit.framework.TestCase;

public class TimeTextualiserTest extends TestCase {

	private TimeTextualiser timeTextualiser;
	
	@Override
	public void setUp() {
		timeTextualiser = new TimeTextualiser();
	}
	
	public void testOnSpecificTimesInDay() throws Exception {
		assertConversationalTime(MIDDAY, timeTextualiser, new Time(12, 0));
		assertConversationalTime(MIDNIGHT, timeTextualiser, new Time(0, 0));
	}
	
	public void testTimeTextualiserOnOClocks() throws Exception {
		assertConversationalTime("One O'Clock", timeTextualiser, new Time(1, 0));
		assertConversationalTime("One O'Clock", timeTextualiser, new Time(13, 0));
	}
	
	public void testTimeTextualiserOnQuarterAndHalfPast() throws Exception {
		assertConversationalTime("A Quarter past One", timeTextualiser, new Time(1, 15));
		assertConversationalTime("Half past One", timeTextualiser, new Time(1, 30));
		assertConversationalTime("A Quarter past One", timeTextualiser, new Time(13, 15));
		assertConversationalTime("Half past One", timeTextualiser, new Time(13, 30));
	}
	
	public void testTimeTextualiserOnQuarterTo() throws Exception {
		assertConversationalTime("A Quarter to Two", timeTextualiser, new Time(1, 45));
		assertConversationalTime("A Quarter to Two", timeTextualiser, new Time(13, 45));
		assertConversationalTime("A Quarter to Twelve", timeTextualiser, new Time(11, 45));
		assertConversationalTime("A Quarter to Midnight", timeTextualiser, new Time(23, 45));
	}
	
	public void testTimeTextualiserOnOtherPasts() throws Exception {
		assertConversationalTime("Five past One", timeTextualiser, new Time(1, 5));
		assertConversationalTime("Five past One", timeTextualiser, new Time(13, 5));
		assertConversationalTime("Ten past One", timeTextualiser, new Time(1, 10));
		assertConversationalTime("Ten past One", timeTextualiser, new Time(13, 10));
		assertConversationalTime("Twenty past One", timeTextualiser, new Time(1, 20));
		assertConversationalTime("Twenty past One", timeTextualiser, new Time(13, 20));
		assertConversationalTime("Twenty-Five past One", timeTextualiser, new Time(1, 25));
		assertConversationalTime("Twenty-Five past One", timeTextualiser, new Time(13, 25));
		assertConversationalTime("Twenty-Five past Midnight", timeTextualiser, new Time(0, 25));
	}
	
	public void testTimeTextualiserOnOtherTos() throws Exception {
		assertConversationalTime("Five to Two", timeTextualiser, new Time(1, 55));
		assertConversationalTime("Five to Two", timeTextualiser, new Time(13, 55));
		assertConversationalTime("Ten to Two", timeTextualiser, new Time(1, 50));
		assertConversationalTime("Ten to Two", timeTextualiser, new Time(13, 50));
		assertConversationalTime("Twenty to Two", timeTextualiser, new Time(1, 40));
		assertConversationalTime("Twenty to Two", timeTextualiser, new Time(13, 40));
		assertConversationalTime("Twenty-Five to Two", timeTextualiser, new Time(1, 35));
		assertConversationalTime("Twenty-Five to Two", timeTextualiser, new Time(13, 35));
		assertConversationalTime("Five to Twelve", timeTextualiser, new Time(11, 55));
		assertConversationalTime("Five to Midnight", timeTextualiser, new Time(23, 55));
	}
	
}
