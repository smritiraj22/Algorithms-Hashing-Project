package com.iit.algo.HashMap.LargeValuesTest;

public class HashMapNaive {
	private final static int MAP_SIZE = 1000000;

	HashMapSetterNaive[] map = new HashMapSetterNaive[MAP_SIZE];

	public int get(int key) {
		int hash = (key % MAP_SIZE);
		if (map[hash] == null)
		{
			System.out.println("Table is null");
			return 0;
		}
		else {
			HashMapSetterNaive present = map[hash];
			while (present != null && present.getKey() != key)
				present = present.getNext();
			if (present == null){
				System.out.println("Key not found");
				return 0;
			}
			else
				return present.getValue();
		}
	}

	public void put(int key, int value) {
		int hash = (key % MAP_SIZE);
		if (map[hash] == null)
			map[hash] = new HashMapSetterNaive(key, value);
		else {
			HashMapSetterNaive present = map[hash];
			while (present.getNext() != null && present.getKey() != key)
				present = present.getNext();
			if (present.getKey() == key)
				present.setValue(value);
			else
				present.setNext(new HashMapSetterNaive(key, value));
		}
	}

	public void remove(int key) {
		int hash = (key % MAP_SIZE);
		System.out.println(" The key being deleted is " + key + " and value " + get(key));
		if (map[hash] != null) {
			HashMapSetterNaive previous = null;
			HashMapSetterNaive present = map[hash];
			while (present.getNext() != null && present.getKey() != key) {
				previous = present;
				present = present.getNext();
			}
			if (present.getKey() == key) {
				if (previous == null)
					map[hash] = present.getNext();
				else
					previous.setNext(present.getNext());
			}
		}
	}
}