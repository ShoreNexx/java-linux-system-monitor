package com.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Memory {
	/*
	 * this method is used to retrieve the memory information 
	 * since the meminfo file has key and value pair 
	 * i am using the hashmap to store the data
	 */
	 
	// returning MemoryInfo object
	public static MemoryInfo memory() {
		
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
			return null;
		}
		double total =meminfo.get("MemTotal:")/1048576.0;
		double free =meminfo.get("MemFree:")/1048576.0;
		double available = meminfo.get("MemAvailable:")/1048576.0;
		double swap =meminfo.get("SwapTotal:")/1048576.0;
		double used = total -available;
		double usedPercentage = (used / total )*100;
		
		// here i am returning the memoryinfo object
		return new MemoryInfo(
			    total,
			    free,
			    available,
			    swap,
			    used,
			    usedPercentage
			);
	}

}
