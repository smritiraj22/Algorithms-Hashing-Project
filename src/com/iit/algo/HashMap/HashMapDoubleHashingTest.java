package com.iit.algo.HashMap;

import java.util.Calendar;

public class HashMapDoubleHashingTest {

	public static void main(String[] args) {
		int key;
		HashMapSetter value;
		int  initCapacity=10;
		Calendar calobj = Calendar.getInstance();
	    System.out.println("time is "+(calobj.getTimeInMillis()));
		HashMapDoubleHashing hm = new HashMapDoubleHashing();
		for (int i = 0; i < initCapacity; i++) {
			key = (int) (java.lang.Math.random() * 10);
			value = new HashMapSetter(key);
			hm.put(key, value);
		}

		 System.out.println("time is "+(calobj.getTimeInMillis()));
		key = 187;
		value = new HashMapSetter(key);
		hm.put(key, value);
		key = 187;
		hm.remove(key);
		
	}
	

}
