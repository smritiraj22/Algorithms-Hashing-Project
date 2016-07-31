package com.iit.algo.HashMap;

public class HashMapLinearProbingMD5 {
	private static final int MAP_SIZE = 256;
	private HashMapLinearProbingMD5Setter[] map  = new HashMapLinearProbingMD5Setter[MAP_SIZE];

		
	public void put(int key, int value) {
		int hash = MD5.getMD5(key);
		int count = 0;
		while (map[hash] != null && map[hash].getKey() == key) {
			hash=MD5.getMD5(hash);
			count++;
			if (count == MAP_SIZE)
				System.out.println("Table is full");
			
		}
		map[hash] = new HashMapLinearProbingMD5Setter(key, value);
	}

	public int get(int key) {
		int hash = MD5.getMD5(key);
		int count = 0;
		while (map[hash] != null && map[hash].getKey() != key) {
			hash=MD5.getMD5(hash);
			count++;
			if (count == MAP_SIZE)
				System.out.println("Table is full");
		}
		if (map[hash] == null)
			System.out.println("Key is not present");

		return map[hash].getValue();

	}
	
	public void remove(int key){
		int hash = MD5.getMD5(key);
		int count = 0;

		while (map[hash] != null && map[hash].getKey() != key) {
			hash=MD5.getMD5(hash);
			count++;
			if (count == MAP_SIZE)
				System.out.println("Table is full");
			return;
		}
		if (map[hash] == null)
			System.out.println("Key is not present");
		System.out.println(" key removed of value "+map[hash].getValue());
		map[hash].setKey(0);
		map[hash].setValue(0);
	}

	class HashMapLinearProbingMD5Setter {

		public void setKey(int key) {
			this.key = key;
		}

		public void setValue(int value) {
			this.value = value;
		}

		private int key;
		private int value;

		public HashMapLinearProbingMD5Setter(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}
	}
}
