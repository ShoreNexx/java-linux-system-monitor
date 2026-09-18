package com.cli;

public class MemoryInfo {
	// since i can't send multiple data through memory class i am creating new class which will 
	// help me to acess multiple data so that monitor class will be not cluttered
	
	private double total;
    private double free;
    private double available;
    private double swap;
    private double used;
    private double usedPercentage;
    
    
    
	public MemoryInfo(double total, double free, double available, double swap, double used, double usedPercentage) {
		this.total = total;
		this.free = free;
		this.available = available;
		this.swap = swap;
		this.used = used;
		this.usedPercentage = usedPercentage;
	}
	


	public double getTotal() {
		return total;
	}
	public double getFree() {
		return free;
	}
	public double getAvailable() {
		return available;
	}
	public double getSwap() {
		return swap;
	}
	public double getUsed() {
		return used;
	}
	public double getUsedPercentage() {
		return usedPercentage;
	}
    
    

}
