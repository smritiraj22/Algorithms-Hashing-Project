package com.iit.algo.HashMap.LargeValuesTest;

import java.util.Calendar;

public class HashMapLinearQuadProbingTest {
	public static void main(String[] args) {
		int key;
		int value;
		int initCapacity=1000000;
		
		HashMapLinearProbing hm = new HashMapLinearProbing();
		Calendar calobj = Calendar.getInstance();
	    System.out.println("time is "+(calobj.getTimeInMillis()));
		for (int i = 0; i < initCapacity; i++) {
			key=i;
			value = (int) (java.lang.Math.random() *400 );
			hm.put(key, value);
			System.out.println(" LP key is inserted "+key+" "+value);
			System.out.println(" LP key is retrived "+hm.get(key));
			
		}
		System.out.println("time is "+(calobj.getTimeInMillis()));
		hm.remove(1);
		
		System.out.println("time is "+(calobj.getTimeInMillis()));
		HashMapQuadProbing quad = new HashMapQuadProbing();
		for (int i = 0; i < initCapacity; i++) {
			key=i;
			value = (int) (java.lang.Math.random() *400 );
			quad.put(key, value);
			System.out.println("Quad key is inserted "+key+" "+value);
			System.out.println("Quad key is retrived "+quad.contains(key));
			
		}
		System.out.println("time is "+(calobj.getTimeInMillis()));
		quad.remove(1);
		
		System.out.println("time is "+(calobj.getTimeInMillis()));
		HashMapLinearProbingMD5 hm5 = new HashMapLinearProbingMD5();
		for (int i = 0; i < initCapacity; i++) {
			key=i;
			value = (int) (java.lang.Math.random() *102 );
			hm5.put(key, value);
			System.out.println("LP MD5 key is inserted "+key+" "+value);
			System.out.println("LP MD5 key is retrived "+hm5.get(key));
			
		}
		System.out.println("time is "+(calobj.getTimeInMillis()));
		hm5.remove(1);
		
		System.out.println("time is "+(calobj.getTimeInMillis()));
		HashMapLinearProbingSHA1 hmsha1 = new HashMapLinearProbingSHA1();
		for (int i = 0; i < initCapacity; i++) {
			key=i;
			value = (int) (java.lang.Math.random() *400 );
			hmsha1.put(key, value);
			System.out.println("LP SHA1 key is inserted "+key+" "+value);
			System.out.println("LP SHA1 key is retrived "+hmsha1.get(key));
			
		}
		System.out.println("time is "+(calobj.getTimeInMillis()));
		hmsha1.remove(1);
		
	
	}
}
