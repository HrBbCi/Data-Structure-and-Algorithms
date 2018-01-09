package com.hkt.tutorial.algorithms.ds;

public class Thred implements Runnable {

  @Override
  public void run() {
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
