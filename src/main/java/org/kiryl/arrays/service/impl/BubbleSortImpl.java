package org.kiryl.arrays.service.impl;

import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.service.SortService;

public class BubbleSortImpl implements SortService {
  @Override
  public <T extends Number & Comparable<T>> ArrayWrapper<T> sort(ArrayWrapper<T> wrapper) {
    if (wrapper == null || wrapper.getSize() == 0) {
      return wrapper;
    }

    T[] array = wrapper.getElements();
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j].compareTo(array[j + 1]) > 0) {
          T temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }

    return wrapper.createCopy(array);
  }
}
