package com.iit.algo.HashMap;

public class HashMapLinearProbing {
	private static final int MAP_SIZE = 256;
	private HashMapLinearProbingSetter[] map  = new HashMapLinearProbingSetter[MAP_SIZE];

		
	public void put(int key, int value) {
		int hash = key % MAP_SIZE;
		int count = 0;
		while (map[hash] != null && map[hash].getKey() != key) {
			hash = (hash + 1) % MAP_SIZE;
			if (count == MAP_SIZE)
				System.out.println("Table is full");
			count++;
		}
		map[hash] = new HashMapLinearProbingSetter(key, value);
	}

	public int get(int key) {
		int hash = key % MAP_SIZE;
		int count = 0;

		while (map[hash] != null && map[hash].getKey() != key) {
			hash = (hash + 1) % MAP_SIZE;
			if (count == MAP_SIZE)
				System.out.println("Table is full");
			count++;
		}
		if (map[hash] == null)
			System.out.println("Key is not present");

		return map[hash].getValue();

	}
	
	public void remove(int key){
		int hash = key % MAP_SIZE;
		int count = 0;
		
		while (map[hash] != null && map[hash].getKey() != key) {
			hash = (hash + 1) % MAP_SIZE;
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

	class HashMapLinearProbingSetter {

		public void setKey(int key) {
			this.key = key;
		}

		public void setValue(int value) {
			this.value = value;
		}

		private int key;
		private int value;

		public HashMapLinearProbingSetter(int key, int value) {
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
