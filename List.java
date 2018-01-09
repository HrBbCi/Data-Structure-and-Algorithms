package com.hkt.tutorial.algorithms.ds;

public interface List<T> {
  public boolean add(T t);

  public int size();

  public boolean removeObj(T t);

  public void clear();

  public void add(int index, T element);

  public void checkFull();

  public T get(int index);

  public int indexOf(T o);

  public int lastIndexOf(T o);

  public T set(int index, T element);

  public T removeAt(int index);

  public boolean isEmpty();
}
