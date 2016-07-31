package com.iit.algo.HashMap;

public class HashMapLinearProbingSHA1 {
	private static final int MAP_SIZE = 256;
	private HashMapLinearProbingSHA1Setter[] map  = new HashMapLinearProbingSHA1Setter[MAP_SIZE];

		
	public void put(int key, int value) {
		int hash = SHA1.getSHA1(key);
		int count = 0;
		while (map[hash] != null && map[hash].getKey() == key) {
			hash=SHA1.getSHA1(hash);
			if (count == MAP_SIZE)
				System.out.println("Table is full");
			count++;
			return;
		}
		map[hash] = new HashMapLinearProbingSHA1Setter(key, value);
	}

	public int get(int key) {
		int hash = SHA1.getSHA1(key);
		int count = 0;
		while (map[hash] != null && map[hash].getKey() != key) {
			hash=SHA1.getSHA1(hash);
			if (count == MAP_SIZE)
				System.out.println("Table is full");
			count++;
		}
		if (map[hash] == null)
			System.out.println("Key is not present");

		return map[hash].getValue();

	}
	
	public void remove(int key){
		int hash = SHA1.getSHA1(key);
		int count = 0;

		while (map[hash] != null && map[hash].getKey() != key) {
			hash=SHA1.getSHA1(hash);
			if (count == MAP_SIZE)
				System.out.println("Table is full");
			count++;
		}
		if (map[hash] == null)
			System.out.println("Key is not present");
		
		System.out.println(" key removed of value "+map[hash].getValue());
		map[hash].setKey(0);
		map[hash].setValue(0);
	}

	class HashMapLinearProbingSHA1Setter {

		public void setKey(int key) {
			this.key = key;
		}

		public void setValue(int value) {
			this.value = value;
		}

		private int key;
		private int value;

		public HashMapLinearProbingSHA1Setter(int key, int value) {
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
