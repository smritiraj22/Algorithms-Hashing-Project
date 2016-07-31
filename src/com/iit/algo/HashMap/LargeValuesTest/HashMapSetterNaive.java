package com.iit.algo.HashMap.LargeValuesTest;

public class HashMapSetterNaive {
private int key;
private int value;
private HashMapSetterNaive next;


HashMapSetterNaive(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = null;
}

public int getValue() {
      return value;
}

public void setValue(int value) {
      this.value = value;
}

public int getKey() {
      return key;
}

public HashMapSetterNaive getNext() {
      return next;
}

public void setNext(HashMapSetterNaive next) {
      this.next = next;
}
}
