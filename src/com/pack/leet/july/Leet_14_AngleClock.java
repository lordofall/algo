package com.pack.leet.july;
/*
 * hour 12, minuste 30: 
 * output: 165
 * 
 * hour: 1, minute: 57
 * output: 76.5
 */
public class Leet_14_AngleClock {

	public static void main(String[] args) {
		Leet_14_AngleClock obj = new Leet_14_AngleClock();
		int hour = 1, minutes = 57;
		System.out.println(obj.angleClock(hour, minutes));

	}

	public double angleClock(int hour, int minutes) {
		double minutDegree = (minutes * 6);
		double hourDegree = (hour*30);
		hourDegree = hourDegree + ((double)minutes/60)*30;
		return Math.abs(minutDegree%360 - hourDegree%360);
	}

}
