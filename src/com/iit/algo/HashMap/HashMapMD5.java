package com.iit.algo.HashMap;

public class HashMapMD5 {
	private final static int MAP_SIZE = 256;
	
    HashMapSetterNaive[] map = new HashMapSetterNaive[MAP_SIZE];

 

    public int get(int key) {
    	  int hash = (MD5.getMD5(key));
          if (map[hash] == null)
                return 0;
          else {
                HashMapSetterNaive current = map[hash];
                while (current != null && current.getKey() != key)
                      current = current.getNext();
                if (current == null)
                      return 0;
                else
                      return current.getValue();
          }
    }

    public void put(int key, int value) {
    	int hash = (MD5.getMD5(key));
          if (map[hash] == null)
                map[hash] = new HashMapSetterNaive(key, value);
          else {
                HashMapSetterNaive current = map[hash];
                while (current.getNext() != null && current.getKey() != key)
                      current = current.getNext();
                if (current.getKey() == key)
                      current.setValue(value);
                else
                      current.setNext(new HashMapSetterNaive(key, value));
          }
    }

    public void remove(int key) {
    	System.out.println(" The key being deleted is "+key+" and value "+get(key));
    	int hash = (MD5.getMD5(key));
          if (map[hash] != null) {
                HashMapSetterNaive prevEntry = null;
                HashMapSetterNaive current = map[hash];
                while (current.getNext() != null && current.getKey() != key) {
                      prevEntry = current;
                      current = current.getNext();
                }
                if (current.getKey() == key) {
                      if (prevEntry == null)
                           map[hash] = current.getNext();
                      else
                           prevEntry.setNext(current.getNext());
                }
          }
    }
}
