package com.hkt.tutorial.algorithms.ds;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayList<T> implements List<T>,Iterable<T>{

  private T[] arr;
  private int curPos;
  
  public ArrayList(int size) {
    arr = (T[]) new Object[size];
    curPos = 0;
  }
  
  @Override
  public boolean add(T t) {
    checkFull() ;
    arr[curPos] = t;
    curPos++;
    return true;
  }

  public void addAll(T[] t) {
    for(T i : t) {
      add(i);
    }
  }
  
  @Override
  public int size() {
    return curPos;
  }

  @Override
  public boolean removeObj(T t) {
    int vitri = timKiem(t);
    if(vitri == -1) {
      throw new RuntimeException("Not found"+ t);
    } else {
      for(int i = vitri; i <= curPos - 2; i++) {
        arr[i] = arr[i+1];
      }
      curPos--;
      return true;
    }
  }

  @Override
  public void clear() {
    arr = (T[]) new Object[0];
    curPos = 0;
  }

  public int timKiem(T x) {
    for(int i = 0 ; i < arr.length;i++) {
      if(x.equals(arr[i])) {
        return i;
      }
    }
    return -1;
  }
  
  @Override
  public Iterator<T> iterator() {
    return Arrays.asList(arr).subList(0, curPos).iterator();
  }
  
  @Override
  public void add(int index,T element) {
    if(index >= curPos) {
      throw new RuntimeException("Out of array size");
    }
    for(int i = curPos-1; i > index; i--) {
      arr[i]= arr[i-1];
    }
    arr[index] = element ;
    curPos++;
  }
  
  @Override
  public void checkFull() {
    if(curPos == arr.length ) {
      if(arr.length < 3) {
        @SuppressWarnings("unused")
        T[] newArray = (T[]) new Object [arr.length + arr.length];
      }
      T[] newArray = (T[]) new Object [arr.length + arr.length/3];
      for(int i = 0; i < arr.length; i++) {
        newArray[i] = arr[i];
      }
      arr = newArray;
    }
  }
  
  @Override
  public T get(int index) {
    if(index >= arr.length) {
      throw new RuntimeException("Out of array size");
    }
    return arr[index];
  }
  
  @Override
  public int indexOf(T o) {
    int index = timKiem(o);
    if(index == -1) {
      return -1;
    }
    return index;
  }
  
  @Override
  public int lastIndexOf(T o) {
    for(int i = arr.length - 1 ; i > 0;i++) {
      if(o == arr[i]) {
        return i;
      }
    }
    return -1;
  }
  
  @Override
  public T set(int index, T element) {
    if(index > arr.length || index < 0) {
        throw new IndexOutOfBoundsException("Out of array size");
    }
    arr[index] = element;
    return arr[index];
  }
  
  @Override
  public T removeAt(int index) {
    if(index >= arr.length) {
      throw new RuntimeException("Out of array size");
    }
    for(int i = index ;i<curPos-1;i++) {
      arr[i] = arr[i+1];
    }
    curPos--;
    return null;
  }
  
  @Override
  public boolean isEmpty() {
    return (size()==0);
  }
}
