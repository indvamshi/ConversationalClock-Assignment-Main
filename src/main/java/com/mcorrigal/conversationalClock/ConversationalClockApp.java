package com.mcorrigal.conversationalClock;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConversationalClockApp {

	public static void main(String[] args) {
		ConversationalClock conversationalClock = new ConversationalClock();
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		while (true) {
			try {
				System.out.print("Enter time in format hh:mm: ");
				System.out.println(conversationalClock.tellTime(br.readLine()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
