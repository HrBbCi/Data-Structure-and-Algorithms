package com.hkt.tutorial.algorithms.ds;

public interface Queue<T> {
  public boolean isEmpty();

  public int size();

  public T peek();

  public void enqueue(T item);

  public T dequeue();
}
