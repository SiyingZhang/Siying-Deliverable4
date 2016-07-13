package edu.pitt.siying;

/**
 * @author siying
 * Three properties have been tested with more than 100 run times
 * 
 */

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class BillifyMapTest {
	
	private int length;
	private int[] randomArr;

	//Property 1: Output array large a size than passed-in array
	@Test
	public void testProperty1() {
		
		boolean lengthIsEqual = true;
		//run 105 times
		for(int i=0; i<105; i++) {
			length = 1+(int)(Math.random()*100); //Generate number in 1~100
			randomArr = new int[length];
			
			//Randomly generate an array
			for(int j=0; j<length; j++) {
				randomArr[j] = 1 + (int)(Math.random()*100);
				//System.out.print(randomArr[i] + " ");
			}
			
			BillifyMap billifyMap = new BillifyMap();
			int[] newArray = billifyMap.billify(randomArr);
			
			if(newArray.length != length + 1) lengthIsEqual = false;
		}
		
		assertTrue(lengthIsEqual);
	}
	
	//Property 2: Pure-running it twice on same input array 
	//should always result in same output array
	@Test
	public void testProperty2() {
		
		boolean isEqual = true;
		
		//run 110 times
		for(int i=0; i<110; i++) {
			length = 1+(int)(Math.random()*100); //Generate number in 1~100
			randomArr = new int[length];
			
			//Randomly generate an array
			for(int j=0; j<length; j++) {
				randomArr[j] = 1 + (int)(Math.random()*100);
				//System.out.print(randomArr[i] + " ");
			}
			
			BillifyMap billifyMap = new BillifyMap();
			int[] array01 = billifyMap.billify(randomArr);
			int[] array02 = billifyMap.billify(randomArr);
			
			if(!Arrays.equals(array01, array02)) {
				isEqual = false;
				break;
			}
		}
		
		assertTrue(isEqual);
	}
	
	//Property 3: Every former element in output array should be the square of 
	//the element in input array
	@Test
	public void testProperty3() {
		
		boolean isSquare = true;
		
		//run 108 times
		for(int i=0; i<108; i++) {
			length = 1+(int)(Math.random()*100); //Generate number in 1~100
			randomArr = new int[length];
			
			//Randomly generate an array
			for(int j=0; j<length; j++) {
				randomArr[j] = 1 + (int)(Math.random()*100);
				//System.out.print(randomArr[i] + " ");
			}
			
			BillifyMap billifyMap = new BillifyMap();
			int[] newArray = billifyMap.billify(randomArr);
			
			//any incorrect calculation would cause fail
			for(int k=0; k<newArray.length-1; k++) {
				if(newArray[k] != (int)Math.pow(randomArr[k], 2)) {
					isSquare = false;
					fail("The " + k + " element is incorrectly mapped.");
				}
			}
		}

		assertTrue(isSquare);
	}

}
