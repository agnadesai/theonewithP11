package com.staticanalysis;

import java.util.Scanner;
/**
 * Not detectable flaws by using static analysis tools
 * PMD and findbugs
 */

public class notDectable {
	public static void main( String[] args ) {
		//not detected by static analysis
		//Devide by zero
		devidebyzero();
		devidebyzero_mitigation();
		//bufferoverflow
		bufferoverflowExample();
		bufferoverflowExamplemitigation();
		//nullpointerException
		NPEEXampleTest npe = new NPEEXampleTest();
		npe.getName();
	
		//mitigation strategy for NPE
		try {
			// Example 3: NPE will be thrown if you are trying to access null Object during Class Initialization
			NPEEXampleTest npe1 = new NPEEXampleTest();
			npe.getName();
		} catch (NullPointerException npe3) {
			System.out.println("\n Exception in NPEEXampleTest()");
			npe3.printStackTrace();
		}

}
	
	public static void devidebyzero() {
		int b = 0;
		int c = 10;
		int a = c/b;
		System.out.println("The value of a = " +a);
	}	
	
	//mitigation strategy for devidebyZero
	public static void devidebyzero_mitigation() {
		int b = 0;
		int c = 10;
		int a = 0;
		if(b!=0) {
		 a = c/b;
		}
		System.out.println("The value of a in mitigationstrategy Example = " +a);
	}	
	
	public static void bufferoverflowExample() {
		//bufferoverflow at run time
		int[] intArray = new int[5];
		for(int i = 0 ;i < 10 ; i++) 
		{
			intArray[i] = i++;
			System.out.println("value of intArray[i]  = " + intArray[i]);
		}
	}	

	//mitigation for buffer overflow
	public static void bufferoverflowExamplemitigation() {
		//bufferoverflow at run time
		int[] intArray = new int[5];
		for(int i = 1 ;i < intArray.length ; i++) 
		{
			intArray[i] = i++;
			System.out.println("value of intArray[i] in mitigationstrategy Example = " + intArray[i]);
		}
	}	
}



class NPEEXampleTest {
	private String Name;
 
	public void setName(String name) {
		this.Name = name;
	}
 
	public void getName() {
		printName(Name);
	}
 
	private void printName(String s) {
		System.out.println(s + " (" + s.length() + ")");
	}
}
