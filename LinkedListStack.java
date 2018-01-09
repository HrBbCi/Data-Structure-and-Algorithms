package com.hkt.tutorial.algorithms.ds;

import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Stack<T> {

  private int  size;
  private Node top;

  private class Node {
    private T    values;
    private Node next;
  }

  public LinkedListStack() {
    top = null;
    size = 0;
    assert check();
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void push(T item) {
    Node oldtop = top;
    top = new Node();
    top.values = item;
    top.next = oldtop;
    size++;
    assert check();
  }

  @Override
  public T pop() {
    if (isEmpty())
      throw new NoSuchElementException("Stack underflow");
    T value = top.values;
    top = top.next;
    size--;
    assert check();
    return value;
  }

  @Override
  public T peek() {
    if (isEmpty())
      throw new NoSuchElementException("Stack underflow");
    return top.values;
  }

  private boolean check() {
    if (size < 0) {
      return false;
    }
    if (size == 0) {
      if (top != null)
        return false;
    } else if (size == 1) {
      if (top == null)
        return false;
      if (top.next != null)
        return false;
    } else {
      if (top == null)
        return false;
      if (top.next == null)
        return false;
    }

    int numberOfNodes = 0;
    for (Node x = top; x != null && numberOfNodes <= size; x = x.next) {
      numberOfNodes++;
    }
    if (numberOfNodes != size)
      return false;

    return true;
  }
}
