package com.hkt.tutorial.algorithms.ds;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class RedBlackTree<K extends Comparable<K>> {

  private static boolean RED   = true;
  private static boolean BLACK = false;
  private RBNodee<K>     root;
  private int            size  = 0;

  private int size(RBNodee r) {
    if (r == null)
      return 0;
    return size;
  }

  public int size() {
    return size(root);
  }

  public void insert(K key) {
    root = insert(root, key);
    root.color = BLACK;
    size++;
  }

  public K get(K key) {
    RBNodee x = root;
    while (x != null) {
      int cmp = key.compareTo((K) x.key);
      if (cmp < 0)
        x = x.left;
      else if (cmp > 0)
        x = x.right;
      else if (cmp == 0) {
        return (K) x.key;
      }
    }
    return null;
  }

  private RBNodee insert(RBNodee h, K key) {
    if (h == null)
      return new RBNodee(key, RED);
    int cmp = key.compareTo((K) h.key);
    if (cmp < 0)
      h.left = insert(h.left, key);
    else if (cmp > 0)
      h.right = insert(h.right, key);
    if (isRed(h.right) && !isRed(h.left))
      h = rotateLeft(h);
    if (isRed(h.left) && !isRed(h.right))
      h = rotateRight(h);
    if (isRed(h.left) && isRed(h.right))
      reColors(h);
    return h;
  }

  public void delete(K key) {
    if (!isRed(root.left) && !isRed(root.right))
      root.color = RED;
    root = delete(root, key);
    root.color = BLACK;
  }

  private RBNodee delete(RBNodee h, K key) {
    int cmp = key.compareTo((K) h.key);
    if (cmp < 0) {
      if (!isRed(h.left) && !isRed(h.left.left))
        h = moveRedLeft(h);
      h.left = delete(h.left, key);
    } else {
      if (isRed(h.left))
        h = rotateRight(h);
      if (cmp == 0 && (h.right == null))
        return null;
      if (!isRed(h.right) && !isRed(h.right.left))
        h = moveRedRight(h);
      if (cmp == 0) {
        RBNodee x = leaf(h.right);
        h.key = x.key;
        h.right = deleteLeaf(h.right);
      } else
        h.right = delete(h.right, key);
    }
    return balance(h);
  }

  public boolean isRed(RBNodee x) {
    if (x == null) {
      return false;
    }
    return x.color == RED;
  }

  private RBNodee rotateLeft(RBNodee h) {
    RBNodee x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    return x;
  }

  private RBNodee rotateRight(RBNodee h) {
    RBNodee x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    return x;
  }

  private void reColors(RBNodee h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }

  public K leaf() {
    return (K) leaf(root).key;
  }

  private RBNodee leaf(RBNodee x) {
    if (x.left == null)
      return x;
    else
      return leaf(x.left);
  }

  private RBNodee moveRedRight(RBNodee h) {
    reColors(h);
    if (isRed(h.left.left)) {
      h = rotateRight(h);
      reColors(h);
    }
    return h;
  }

  public void deleteLeaf() {
    if (!isRed(root.left) && !isRed(root.right))
      root.color = RED;
    root = deleteLeaf(root);
    root.color = BLACK;
  }

  private RBNodee deleteLeaf(RBNodee h) {
    if (h.left == null)
      return null;

    if (!isRed(h.left) && !isRed(h.left))
      h = moveRedLeft(h);

    h.left = deleteLeaf(h.left);
    return balance(h);
  }

  private RBNodee balance(RBNodee h) {
    if (isRed(h.right))
      h = rotateLeft(h);
    if (isRed(h.left) && isRed(h.left.left))
      h = rotateRight(h);
    if (isRed(h.left) && isRed(h.right))
      reColors(h);
    size = size(h.left) + size(h.right) + 1;
    return h;
  }

  private RBNodee moveRedLeft(RBNodee h) {
    reColors(h);
    if (isRed(h.right.left)) {
      h.right = rotateRight(h.right);
      h = rotateLeft(h);
      reColors(h);
    }
    return h;
  }

  public boolean search(K val) {
    return search(root, val);
  }

  private boolean search(RBNodee r, K val) {
    boolean found = false;
    while ((r != null) && !found) {
      // System.out.println(val.compareTo((K) r.key));
      int cmp = val.compareTo((K) r.key);
      if (cmp < 0)
        r = r.left;
      else if (cmp > 0)
        r = r.right;
      else if (cmp == 0) {
        found = true;
        break;
      }
      found = search(r, val);
    }
    return found;
  }

  public void printTree() {
    printTree(root);
  }

  public void printTree(RBNodee node) {
    if (node == null) {
      return;
    }
    printTree(node.left);
    char co;
    if (node.color == RED) {
      co = 'R';
    } else {
      co = 'B';
    }
    System.out.print(node.key + "" + co + "    ");
    printTree(node.right);
  }

}
