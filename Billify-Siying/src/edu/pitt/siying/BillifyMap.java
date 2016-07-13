package edu.pitt.siying;

public class BillifyMap {

	public int[] billify(int[] x) {
		
		//initialize the mapped array
		int[] mapped = new int[x.length+1];
		mapped[mapped.length-1] = 0;	//sum
		
		//square each item
		for(int i=0; i<x.length; i++) {
			mapped[i] = (int) Math.pow(x[i], 2);
			mapped[mapped.length-1] += mapped[i];
		}
		
		return mapped;
	}
	
}
