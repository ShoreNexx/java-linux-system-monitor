package com.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Monitor {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println("Hello welcome to java based cli....");
		System.out.println("HostName : "+status());
		uptime();
		
		
	}
	
//	this method is used to get the host name of the local machine 
	public static String status() throws UnknownHostException {
		String localhost= InetAddress.getLocalHost().getHostName();
		return localhost;
	}
	
/*	
 * this method is used to fetch the uptime from  /proc/uptime file 
 * in this file only the 1st number is required for checking the uptime 
 * so we are converting that number to hrs min and sec because that number is in double
*/
	public static void uptime() {
		File myfile = new File("/proc/uptime");
		try (Scanner myfilereader = new Scanner(myfile)) {
			String	time =  myfilereader.next();
			double seconds = Double.parseDouble(time);
			long totalsec = (long)seconds;
			long hrs = (totalsec / 3600);
			long min = (totalsec %3600) /60;
			long sec = totalsec % 60;
			System.out.println("uptime : "+ hrs+ " hrs "+min+" min "+sec+" sec");
		
			
		} catch (FileNotFoundException e) {
			System.out.println("an error occrued while checking the uptime");
			e.printStackTrace();
		}
		
	}
	
	
}
