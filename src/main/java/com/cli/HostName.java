package com.cli;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostName {
//	this method is used to get the host name of the local machine 
	public static String status()  {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "unable to fetch hostname";
		
		}
		
	}


}
