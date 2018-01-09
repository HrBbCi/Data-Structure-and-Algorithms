package com.hkt.tutorial.algorithms.sort;

import java.util.Comparator;

public class Sort<T> implements ISort<T>{

  @Override
  public void selectionSort(T[] arr,Comparator<T> comparee) {
    int len = arr.length;
    int i ,j;
    for ( i = 0; i < len-1; i++) { 
      int min_idx = i;
      for (j = i + 1; j < len; j++ ) 
        if (comparee.compare(arr[j],arr[min_idx]) > 0) 
          min_idx = j;
      hoanVi(arr, i, min_idx);
    }
  }
  
  @Override
  public void hoanVi(T a[], int i ,int j) {
      T temp = a[i];
      a[i] =a[j];
      a[j] = temp;
  }
  
  @Override
  public void printArray(T[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println("");
  }
  
  @Override
  public void bublesort(T[] arr, Comparator<T>comparee) {
    int len = arr.length;
    for (int i = 0; i < len; i++) { 
      for (int j = 0; j<len-i-1; j++ ) {
        if (comparee.compare(arr[j],arr[j+1]) > 0) { 
           hoanVi(arr, j, j+1);
        }
      }
    }
  }
  @Override
  public void insertionSort(T[] arr, Comparator<T> cmp) {
    int len = arr.length;
    for (int i = 1; i < len; i++) { 
      T key = arr[i]; 
      int j = i-1;
      while (j >= 0 && cmp.compare(arr[j],key) > 0) { 
        arr[j+1] = arr[j]; 
        j = j-1;
      }
      arr[j+1] = key; 
    }
  }
  
  @Override
  public void quicksort(T[] arr, Comparator<T> cmp) {
    sortPartion(arr, 0, arr.length-1, cmp);
  }
  
  @Override
  public void sortPartion(T[] a, int left, int right, Comparator<T> cmp) {
    int i = left, j = right;
    T pivot = a[left];
    do {
        while(cmp.compare(a[i],pivot) < 0 && i < right) i++;
        while(cmp.compare(a[j],pivot) > 0 && j > left) j--;
        if(i <= j){
            hoanVi(a, i, j);
            i++;
            j--;
        }
    } while (i <= j);
    if (left < j) sortPartion(a, left, j, cmp);
    if (i < right) sortPartion(a, i, right,cmp);

  }
  
  @Override
  public void mergeSort(T[] a, int l, int r, Comparator<T> cmp) {
    int m;
    if(l < r) {
        m = (l + r) / 2;
        mergeSort(a, l, m,cmp);
        mergeSort(a, m + 1, r,cmp);
        mSort(a, l, m + 1, r,cmp);
    }
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public void mSort(T[] a, int l, int m, int r, Comparator<T> cmp) {
    int i, length ;
    int l_end = m - 1;
    i = l;
    length = r-l;
    T[] temp =(T[]) new Object[100];
    while(l <= l_end && m <= r) {
        if (cmp.compare(a[l], a[m]) <= 0) {
            temp[i++] = a[l++];
        } else {
            temp[i++] = a[m++];
        }
    }
    while(l <= l_end) {
        temp[i++] = a[l++];
    }
    while(m <= r) {
        temp[i++] = a[m++];
    }
     
    for (i = 0; i <= length; i++, r--) {
        a[r] = temp[r];
    }
    
  }
}
