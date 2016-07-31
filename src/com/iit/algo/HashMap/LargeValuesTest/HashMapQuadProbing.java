package com.iit.algo.HashMap.LargeValuesTest;

public class HashMapQuadProbing {

	private int size= 0;	
	private static final int MAP_SIZE=1000000;
	private Integer[] keys,values=new Integer[MAP_SIZE];
	
	private boolean get(Integer key) {
		return contains(key) != null;
	}

	private int hash(int key) {
		return key % MAP_SIZE;
	}

	public void put(int key, int val) {
		int tmp = hash(key);
		int i = tmp, k = 1;
		do {
			if (keys[i] == null) {
				keys[i] = key;values[i] = val;
				size++;
				return;
			}
			if (keys[i].equals(key)) {
				values[i] = val;
				return;
			}
			i = (i + k * k) % MAP_SIZE;
			k++;
		} while (i != tmp);
	}

	public Integer contains(Integer key) {
		int i = hash(key), k = 1;
		while (keys[i] != null) {
			if (keys[i].equals(key))
				return values[i];
			i = (i + k * k) % MAP_SIZE;
			k++;
		}
		return null;
	}

	public void remove(Integer key) {
		if (!get(key))
			return;
		int i = hash(key), k = 1;
		System.out.println("Quad Key being deleted is " +key +" value "+contains(key));
		while (!key.equals(keys[i]))
			i = (i + k * k) % MAP_SIZE;
			k++;
		keys[i] = values[i] = null;
		for (i = (i + k * k) % MAP_SIZE; keys[i] != null; i = (i + k * k) % MAP_SIZE,k++) {
			Integer a=keys[i];
			Integer	b=values[i];
			keys[i] = values[i] = null;
			size--;
			put(a, b);
		}
		size--;
	}

}
