package com.hkt.tutorial.algorithms.ds;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class HashMapp<K, V> implements Map<K, V> {
  private int size;

  private HashMapp.Entry<K, V>[] array;

  public HashMapp(int size) {
    array = new HashMapp.Entry[size];
    size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean contains(K key) {
    int index = hash(key);
    Entry<K, V> e = array[index];
    while (e != null) {
      if (e.getKey().equals(key)) {
        return true;
      }
      e = e.getNext();
    }
    return false;
  }

  @Override
  public V get(K key) {
    int index = hash(key);
    Entry<K, V> er = array[index];
    while (er != null) {
      if (er.getKey().equals(key)) {
        return er.getValue();
      }
      er = er.getNext();
    }
    return null;
  }

  @Override
  public V put(K key, V value) {
    int index = hash(key);
    Entry entry = new Entry(key, value);
    if (array[index] == null) {
      array[index] = entry;
    } else {
      Entry current = array[index];
      while (current != null) {
        if (current.getKey().equals(entry.getKey())) {
          current.setValue(entry.getValue());
          return (V) current.getValue();
        }
        current = current.getNext();
      }
      current.setNext(entry);
    }
    size++;
    return null;
  }

  @Override
  public V remove(K key) {
    int index = hash(key);
    Entry entry = null;
    Entry current = array[index];
    while (current != null) {
      if (current.getKey().equals(key)) {
        if (entry != null)
          entry.setNext(current.getNext());
        else
          array[index] = current.getNext();
        size--;
        return (V) current.getValue();
      }
      entry = current;
      current = current.getNext();
    }
    return null;
  }

  @Override
  public void clear() {
    for (int i = 0; i < array.length; i++) {
      array[i] = null;
    }
    size = 0;
  }

  public int hash(K key) {
    return Math.abs(key.hashCode() % array.length);
  }

}