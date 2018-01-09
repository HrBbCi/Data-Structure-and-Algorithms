package com.hkt.tutorial.algorithms.ds;

@SuppressWarnings("unused")

public class LinkedList<T> {
  private int  size;
  private Node head;

  public LinkedList() {
  }

  public void add(Object data) {
    if (head == null) {
      head = new Node(data);
    }
    Node temp = new Node(data);
    Node curr = head;
    if (curr != null) {
      while (curr.getNext() != null) {
        curr = curr.getNext();
      }
      curr.setNext(temp);
    }
    size++;
  }

  private int getN() {
    return size;
  }

  public void add(T data, int index) {
    Node temp = new Node(data);
    Node curr = head;
    if (curr != null) {
      for (int i = 0; i < index && curr.getNext() != null; i++) {
        curr = curr.getNext();
      }
    }
    temp.setNext(curr.getNext());
    curr.setNext(temp);
    size++;
  }

  public Object get(int index) {
    if (index < 0)
      return null;
    Node curr = null;
    if (head != null) {
      curr = head.getNext();
      for (int i = 0; i < index; i++) {
        if (curr.getNext() == null)
          return null;
        curr = curr.getNext();
      }
      return curr.getData();
    }
    return curr;

  }

  public boolean remove(int index) {
    if (index < 1 || index > size())
      return false;
    Node curr = head;
    if (head != null) {
      for (int i = 0; i < index; i++) {
        if (curr.getNext() == null)
          return false;
        curr = curr.getNext();
      }
      curr.setNext(curr.getNext().getNext());
      size--;
      return true;
    }
    return false;
  }

  public int size() {
    return getN();
  }

  private class Node {
    Node   next;
    Object data;

    public Node(Object dataValue) {
      next = null;
      data = dataValue;
    }

    public Node(Object dataValue, Node nextValue) {
      next = nextValue;
      data = dataValue;
    }

    public Object getData() {
      return data;
    }

    public void setData(Object dataValue) {
      data = dataValue;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node nextValue) {
      next = nextValue;
    }

  }

}
