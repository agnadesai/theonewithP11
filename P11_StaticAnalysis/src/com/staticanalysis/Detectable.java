package com.staticanalysis;

import java.util.ArrayList;
/**
 * Detectable flaws by using static analysis tools
 * PMD and findbugs
 */


public class Detectable {
	public static void main( String[] args )
    {
		//ArrayIndexoutof bounds
		arrayIndexoutofBoundsExample();
		arrayIndexoutofBoundsExample_mitigated();
   	 
   	 	//invalid typecasting
		invalditypecastingExample();
		invalditypecastingExample_mitigated();
   
		//NPE
		nullpointerExceptionExample();
		nullpointerExceptionExample_mitigated();
		
    }
	
	public static void arrayIndexoutofBoundsExample() {
		 
	     String[] string = new String[2];
	     string[0] = "Hello";
	     string[1] = "World";
	     string[2] = "World1";
	}
	
	
	public static void arrayIndexoutofBoundsExample_mitigated() {
		  //ArrayIndexoutof bounds - using arraylist of string
	     ArrayList<String> strArray = new  ArrayList<String>();;
	     strArray.add("Hello");
	     strArray.add("World");
	     strArray.add("World1");
	     
	}
	
	public static void invalditypecastingExample() {
		 
		final Object doubleValue = Double.valueOf(1.0);
	   	final Long value = (Long) doubleValue;
	   	System.out.println("   - " + value);
	   	
	}
	
	public static void invalditypecastingExample_mitigated() {
		 //using proper typecasting
		final Object doubleValue = Double.valueOf(1.0);
	   	final Double value =  (Double) doubleValue;
	   	System.out.println("   - " + value);
	   	
	}
	
	@SuppressWarnings("null")
	public static void nullpointerExceptionExample() {
		Object abc = null;
		System.out.println("hashcode = " +abc.hashCode());
	   	
	}
	
	public static void nullpointerExceptionExample_mitigated() {
		//check value is null before assigning
		Object abc = null;
		if(abc!=null) {
		System.out.println("hashcode = " + abc.hashCode());
		}
	   	
	}
}
