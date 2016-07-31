package com.iit.algo.HashMap.LargeValuesTest;

import java.util.Calendar;

public class HashMapChainingTest {
	public static void main(String[] args) {
		int key;
		int value;
		int  initCapacity= 1000000;
	
		HashMapNaive hm = new HashMapNaive();
		Calendar calobj = Calendar.getInstance();
	    System.out.println("time is "+(calobj.getTimeInMillis()));
		
		for (int i = 0; i < initCapacity; i++) {
			key=i;
			value = (int) (java.lang.Math.random() *500 );
			hm.put(key, value);
			System.out.println(" Chaining key is inserted "+key+" "+value);
			System.out.println(" Chaining key is retrived "+hm.get(key));
			
		}
		hm.remove(1);
		System.out.println("time is "+(calobj.getTime()));
		HashMapMD5 hm5 = new HashMapMD5();
		for (int i = 0; i < initCapacity; i++) {
			key=i;
			value = (int) (java.lang.Math.random() *10 );
			hm5.put(key, value);
			System.out.println("Chaining MD5 key is inserted "+key+" "+value);
			System.out.println("Chaining MD5 key is retrived "+hm5.get(key));
			
		}
		System.out.println("time is "+(calobj.getTimeInMillis()));
		hm5.remove(1);
		
		HashMapSHA1 hmsha1 = new HashMapSHA1();
		for (int i = 0; i < initCapacity; i++) {
			key=i;
			value = (int) (java.lang.Math.random() *10 );
			hmsha1.put(key, value);
			System.out.println("Chaining SHA1 key is inserted "+key+" "+value);
			System.out.println("Chaining SHA1 key is retrived "+hmsha1.get(key));
			
		}
		
		hmsha1.remove(1);
		System.out.println("time is "+(calobj.getTimeInMillis()));
	}

}
