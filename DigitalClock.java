package com.hkt.tutorial.algorithms.ds;

import java.awt.Font;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class DigitalClock extends java.applet.Applet implements Runnable {
  Font   theFont = new Font("TimesRoman", Font.BOLD, 24);
  Date   theDate;
  Thread runner;

  public void start() {
    if (runner == null) {
      runner = new Thread(this);
      runner.start();
    }
  }

  @SuppressWarnings("deprecation")
  public void stop() {
    if (runner != null) {
      runner.stop();
      runner = null;
    }
  }

  public void run() {
    while (true) {
      theDate = new Date();
      repaint();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
    }
  }

  public void paint(Graphics g) {
    g.setFont(theFont);
    DateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    String dateee = date.format(theDate);
    g.drawString(dateee, 10, 50);
  }
}
