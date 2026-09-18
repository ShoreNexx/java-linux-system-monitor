package com.cli;

public class Monitor {
//	this is the main class where the main method is present... from here the execution of the prog 
// will start
	public static void main(String[] args)  {
		System.out.println("======== System Information ========");
		System.out.println("HostName : "+HostName.status());
		System.out.println("Uptime : "+ Uptime.uptime());
		
		System.out.println();
		System.out.println("======== Memory Information ========");
		// calling memory method present in the memory class and storing it inside the memoryinfo object
		// using printf so that i can show only 2 numbers after decimal
		MemoryInfo memory = Memory.memory();
		System.out.printf("Total RAM : %.2f GiB \n",memory.getTotal());
		System.out.printf("Available RAM : %.2f GiB \n",memory.getAvailable());
		System.out.printf("RAM usage : %.0f %% \n",memory.getUsedPercentage());
		System.out.printf(
			    "Memory : %.2f GiB / %.2f GiB (%.0f%%)%n",
			    memory.getUsed(),
			    memory.getTotal(),
			    memory.getUsedPercentage()
			);
		
		
		
	}
	


	
	
}
