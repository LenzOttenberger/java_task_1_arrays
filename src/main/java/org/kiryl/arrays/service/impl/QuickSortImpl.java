package org.kiryl.arrays.service.impl;

import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.service.SortService;

public class QuickSortImpl implements SortService {

  @Override
  public <T extends Number & Comparable<T>> ArrayWrapper<T> sort(ArrayWrapper<T> wrapper) {
    if (wrapper == null || wrapper.getSize() == 0) {
      return wrapper;
    }

    T[] array = wrapper.getElements();
    quickSort(array, 0, array.length - 1);
    return wrapper.createCopy(array);
  }

  private <T extends Number & Comparable<T>> void quickSort(T[] array, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(array, low, high);
      quickSort(array, low, pivotIndex - 1);
      quickSort(array, pivotIndex + 1, high);
    }
  }

  private <T extends Number & Comparable<T>> int partition(T[] array, int low, int high) {
    T pivot = array[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (array[j].compareTo(pivot) <= 0) {
        i++;
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    T temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return i + 1;
  }
}
