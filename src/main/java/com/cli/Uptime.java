package com.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Uptime {
	
/*	
 * this method is used to fetch the uptime from  /proc/uptime file 
 * in this file only the 1st number is required for checking the uptime 
 * so we are converting that number to hrs min and sec because that number is in double
*/
	public static String uptime() {
		File myfile = new File("/proc/uptime");
		try (Scanner myfilereader = new Scanner(myfile)) {
			String	time =  myfilereader.next();
			double seconds = Double.parseDouble(time);
			long totalsec = (long)seconds;
			long hrs = (totalsec / 3600);
			long min = (totalsec %3600) /60;
			long sec = totalsec % 60;
			return   hrs+ " hrs "+min+" min "+sec+" sec";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "an error occrued while checking the uptime";
			
		}
		
	}

}
