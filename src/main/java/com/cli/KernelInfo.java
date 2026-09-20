package com.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KernelInfo {
	
	public static String kernalInfo() {
		File kernelname = new File("/proc/sys/kernel/osrelease");
		
		try (Scanner sc = new Scanner(kernelname)) {
			return sc.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "kernel name not found";
		}
	}

}
