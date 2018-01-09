package com.hkt.tutorial.algorithms.ds;

public class RBNodee<K> {
  protected K          key;
  protected RBNodee<K> left   = null;
  protected RBNodee<K> right  = null;
  protected RBNodee<K> parent = null;
  protected boolean    color;

  public RBNodee(K key, boolean color) {
    this.key = key;
    this.color = color;
  }
}
