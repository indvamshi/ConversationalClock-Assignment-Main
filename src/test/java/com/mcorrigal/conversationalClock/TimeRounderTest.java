package com.mcorrigal.conversationalClock;

import static com.mcorrigal.conversationalClock.TestUtils.assertTime;

import com.mcorrigal.conversationalClock.Time;
import com.mcorrigal.conversationalClock.TimeRounder;

import junit.framework.TestCase;

public class TimeRounderTest extends TestCase {

	private TimeRounder timeRounder;
	
	@Override
	public void setUp() {
		timeRounder = new TimeRounder();
	}
	
	public void testNoRoundingPerformedIfAtFiveMinuteInterval() throws Exception {
		assertTime(12, 0, timeRounder.round(new Time(12, 0)));
		assertTime(12, 5, timeRounder.round(new Time(12, 5)));
	}
	
	public void testRoundDownIfCloserToLowerFiveMinuteInterval() throws Exception {
		assertTime(12, 0, timeRounder.round(new Time(12, 1)));
		assertTime(12, 0, timeRounder.round(new Time(12, 2)));
		assertTime(12, 5, timeRounder.round(new Time(12, 6)));
		assertTime(12, 5, timeRounder.round(new Time(12, 7)));
	}
	
	public void testRoundUpIfCloserToHigherFiveMinuteInterval() throws Exception {
		assertTime(12, 5, timeRounder.round(new Time(12, 3)));
		assertTime(12, 5, timeRounder.round(new Time(12, 4)));
		assertTime(12, 10, timeRounder.round(new Time(12, 8)));
		assertTime(12, 10, timeRounder.round(new Time(12, 9)));
	}
	
	public void testRoundUpToNewHour() throws Exception {
		assertTime(13, 0, timeRounder.round(new Time(12, 58)));
		assertTime(13, 0, timeRounder.round(new Time(12, 59)));
	}
	
	public void testRoundUpToNewDay() throws Exception {
		assertTime(0, 0, timeRounder.round(new Time(23, 58)));
		assertTime(0, 0, timeRounder.round(new Time(23, 59)));
	}
	
}
