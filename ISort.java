package com.hkt.tutorial.algorithms.sort;

import java.util.Comparator;

public interface ISort<T> {
  public void selectionSort(T[] a,Comparator<T> comparee);
  public void hoanVi(T a[], int i, int j);
  public void bublesort(T[] a, Comparator<T> comparee);
  public void printArray(T[] arr);
  public void  insertionSort(T[] a, Comparator<T> cmp);
  public void quicksort(T[] a, Comparator<T> cmp);
  public void sortPartion(T[] a, int left, int right, Comparator<T> cmp);
  public void mergeSort(T[] a,int al, int ar, Comparator<T> cmp);
  public void mSort(T[] a,int al, int am, int ar, Comparator<T> cmp);
}
