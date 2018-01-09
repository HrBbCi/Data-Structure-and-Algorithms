package com.hkt.tutorial.algorithms.ds;

@SuppressWarnings("rawtypes")
public interface Map<K, V> {
  public int size();

  public boolean contains(K key);

  public V get(K key);

  public V put(K key, V value);

  public V remove(K key);

  public void clear();

  public class Entry<Key, Value> {
    private Key   key;
    private Value value;
    private Entry next;

    public Key getKey() {
      return key;
    }

    public void setKey(Key key) {
      this.key = key;
    }

    public Value getValue() {
      return value;
    }

    public void setValue(Value value) {
      this.value = value;
    }

    public Entry getNext() {
      return next;
    }

    public void setNext(Entry next) {
      this.next = next;
    }

    public Entry(Key key, Value value, Entry next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public Entry(Key key, Value value) {
      super();
      this.key = key;
      this.value = value;
    }

  }
}
