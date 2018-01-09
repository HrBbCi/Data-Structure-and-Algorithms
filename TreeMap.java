package com.hkt.tutorial.algorithms.ds;

import java.util.NoSuchElementException;

@SuppressWarnings({ "rawtypes", "unchecked", "hiding" })
public class TreeMap<K extends Comparable, V> implements Map<K, V> {

  private int     size;
  private Node<K> root;

  @Override
  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  @Override
  public V get(K key) {
    if (root == null) {
      return null;
    }
    Node<K> values = find(key, false);
    System.out.println();
    if (values == null)
      return null;
    return values.value;
  }

  @Override
  public V put(K key, V value) {
    if (root == null) {
      root = new Node<K>(key);
      size = 1;
      return null;
    }

    Node<K> location = find(key, true);
    int cp = key.compareTo(location.key);
    if (cp == 0) {
      V oldValue = location.value;
      location.value = value;
      return oldValue;
    } else {
      if (cp < 0)
        location.left = new Node<K>(key);
      else
        location.right = new Node<K>(key);
      size++;
      return null;
    }
  }

  @Override
  public boolean contains(K key) {
    V value = get(key);
    if (value == null) {
      return false;
    }
    return true;
  }

  public K firstKey() {
    if (root == null)
      throw new NoSuchElementException("Root Null");
    return (K) firstNode().key;
  }

  public K lastKey() {
    if (root == null)
      throw new NoSuchElementException();
    return (K) lastNode().key;
  }

  public Node firstNode() {
    Node node = root;
    while (node.right != null)
      node = node.right;
    return node;
  }

  public Node lastNode() {
    Node node = root;
    while (node.left != null)
      node = node.left;
    return node;
  }

  @Override
  public V remove(K key) {
    if (root == null)
      return null;
    root = splay(root, key);
    int cmp = key.compareTo(root.key);
    if (cmp == 0) {
      if (root.left == null) {
        root = root.right;
      } else {
        Node x = root.right;
        root = root.left;
        splay(root, key);
        root.right = x;
      }
    }
    return null;
  }

  private Node splay(Node h, K key) {
    if (h == null)
      return null;

    int cmp1 = key.compareTo(h.key);

    if (cmp1 < 0) {
      if (h.left == null) {
        return h;
      }
      int cmp2 = key.compareTo(h.left.key);
      if (cmp2 < 0) {
        h.left.left = splay(h.left.left, key);
        h = rotateRight(h);
      } else if (cmp2 > 0) {
        h.left.right = splay(h.left.right, key);
        if (h.left.right != null)
          h.left = rotateLeft(h.left);
      }
      if (h.left == null)
        return h;
      else
        return rotateRight(h);
    } else if (cmp1 > 0) {
      if (h.right == null) {
        return h;
      }
      int cmp2 = key.compareTo(h.right.key);
      if (cmp2 < 0) {
        h.right.left = splay(h.right.left, key);
        if (h.right.left != null)
          h.right = rotateRight(h.right);
      } else if (cmp2 > 0) {
        h.right.right = splay(h.right.right, key);
        h = rotateLeft(h);
      }

      if (h.right == null)
        return h;
      else
        return rotateLeft(h);
    }

    else
      return h;
  }

  private Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    return x;
  }

  private Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    return x;
  }

  private Node<K> find(K key, boolean b) {

    Node<K> current = root;
    Node<K> parent = null;
    do {
      int cp = key.compareTo(current.key);
      if (cp == 0)
        break;
      parent = current;
      if (cp < 0)
        current = current.left;
      else
        current = current.right;
    } while (current != null);
    if (current == null && b == true)
      return parent;
    return current;
  }

  private class Node<K extends Comparable> {

    Node<K> left, right;
    K       key;
    V       value;

    public Node(K k) {
      key = k;
    }
  }

}
