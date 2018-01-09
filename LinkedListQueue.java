package com.hkt.tutorial.algorithms.ds;

import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Queue<T> {

  private int  size;
  private Node head, tail;

  private class Node {
    private T    values;
    private Node next;
  }

  public LinkedListQueue() {
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T peek() {
    if (isEmpty())
      throw new NoSuchElementException("Queue peek ex");
    return head.values;
  }

  @Override
  public void enqueue(T ele) {
    Node current = tail;
    tail = new Node();
    tail.values = ele;
    if (size++ == 0)
      head = tail;
    else
      current.next = tail;
  }

  @Override
  public T dequeue() {
    if (size == 0)
      throw new java.util.NoSuchElementException();
    T ele = head.values;
    head = head.next;
    if (--size == 0)
      tail = null;
    return ele;
  }

}
