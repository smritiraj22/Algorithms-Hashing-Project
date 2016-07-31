package com.iit.algo.HashMap;

public class HashMapDoubleHashing {
	private static final int MAP_SIZE = 256;
	private HashMapSetter[] hashMapSize= new HashMapSetter[MAP_SIZE];
	private HashMapSetter del=new HashMapSetter(-1);;

	public int hash1(int key) {
		return key % MAP_SIZE;
	}

	public int hash2(int key) {
		return (SHA1.getSHA1(key));
	}

	public void put(int key, HashMapSetter item) {
		int hashnaive = hash1(key);
		int hashsha1 = hash2(key);
		while (hashMapSize[hashnaive] != null && hashMapSize[hashnaive].getKey() != -1) {
			hashnaive += hashsha1;
			hashnaive %= MAP_SIZE;
		}
		hashMapSize[hashnaive] = item;
	}

	public HashMapSetter remove(int key) {
		int hashnaive = hash1(key);
		int hashsha = hash2(key);
		while (hashMapSize[hashnaive] != null) {
			if (hashMapSize[hashnaive].getKey() == key) {
				HashMapSetter temp = hashMapSize[hashnaive];
				hashMapSize[hashnaive] = del;
				return temp;
			}
			hashnaive += hashsha;
			hashnaive %= MAP_SIZE;
		}
		return null;
	}

	public HashMapSetter get(int key) {
		int hashnaive = hash1(key);
		int hashsha1 = hash2(key);
		while (hashMapSize[hashnaive] != null) {
			if (hashMapSize[hashnaive].getKey() == key)
				return hashMapSize[hashnaive];
			hashnaive += hashsha1;
			hashnaive %= MAP_SIZE;
		}
		return null;
	}

	
}
    class HashMapSetter {
	public int getData() {
			return val;
		}

		public void setData(int data) {
			this.val = data;
		}

	private int val;

	public HashMapSetter(int i) {
		val = i;
	}

	public int getKey() {
		return val;
	}

}
