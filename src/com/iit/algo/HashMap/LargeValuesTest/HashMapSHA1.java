package com.iit.algo.HashMap.LargeValuesTest;

public class HashMapSHA1 {
	private final static int TABLE_SIZE = 256;
	
    HashMapSetterNaive[] table;

    HashMapSHA1() {
          table = new HashMapSetterNaive[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

    public int get(int key) {
    	  int hash = (SHA1.getSHA1(key));
          if (table[hash] == null)
                return -1;
          else {
                HashMapSetterNaive current = table[hash];
                while (current != null && current.getKey() != key)
                      current = current.getNext();
                if (current == null)
                      return -1;
                else
                      return current.getValue();
          }
    }

    public void put(int key, int value) {
    	int hash = (SHA1.getSHA1(key));
          if (table[hash] == null)
                table[hash] = new HashMapSetterNaive(key, value);
          else {
                HashMapSetterNaive current = table[hash];
                while (current.getNext() != null && current.getKey() != key)
                      current = current.getNext();
                if (current.getKey() == key)
                      current.setValue(value);
                else
                      current.setNext(new HashMapSetterNaive(key, value));
          }
    }

    public void remove(int key) {
    	int hash = (SHA1.getSHA1(key));
    	System.out.println(" The key being deleted is "+key+" and value "+get(key));
          if (table[hash] != null) {
                HashMapSetterNaive prevEntry = null;
                HashMapSetterNaive current = table[hash];
                while (current.getNext() != null && current.getKey() != key) {
                      prevEntry = current;
                      current = current.getNext();
                }
                if (current.getKey() == key) {
                      if (prevEntry == null)
                           table[hash] = current.getNext();
                      else
                           prevEntry.setNext(current.getNext());
                }
          }
    }
}