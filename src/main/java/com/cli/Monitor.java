package com.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Monitor {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println("Hello welcome to java based cli....");
		System.out.println("HostName : "+status());
		uptime();
		memory();
		
		
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
	/*
	 * this method is used to retrieve the memory information 
	 * since the meminfo file has key and value pair 
	 * i am using the hashmap to store the data
	 */
	 
	public static void memory() {
		File ramfile = new File("/proc/meminfo");
		Map<String, Double> meminfo = new HashMap<String, Double>();
		try (Scanner sc = new Scanner(ramfile)){
			// checking whether new line is present or not 
			while(sc.hasNextLine()) {
				// if present i am storing it inside the string var
				String line = sc.nextLine();
				//now i am splitting the string into to values and storing it in string array
				String linearray[] = line.split("\\s+");
				
				String key = linearray[0];
				//since the 2 value is in string format .. converting it into the double 
				double value = Double.parseDouble(linearray[1]);
				meminfo.put(key, value);
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("failed to load the mem info");
			e.printStackTrace();
		}
		double total =meminfo.get("MemTotal:")/1048576.0;
		double free =meminfo.get("MemFree:")/1048576.0;
		double available = meminfo.get("MemAvailable:")/1048576.0;
		double swap =meminfo.get("SwapTotal:")/1048576.0;
		double used = total -available;
		double usedper = (used / total )*100;
		
		// here i am using printf instead of println because in this we can format the output
		 	System.out.printf("Total   : %.2f GB%n", total , " GB");
		    System.out.printf("Free    : %.2f GB%n " , free , " GB");
		    System.out.printf("used    : %.2f GB%n " , used , " GB");
		    System.out.printf("usedpercentage    : %.2f %n " , usedper);
		    System.out.printf("Available: %.2f GB%n " , available , " GB");
		    System.out.printf("Swap    : %.2f GB%n" , swap , " GB");
	}
	
	
}
