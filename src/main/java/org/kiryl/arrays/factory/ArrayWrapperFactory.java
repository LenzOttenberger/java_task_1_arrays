package org.kiryl.arrays.factory;

import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.entity.DoubleArrayWrapper;
import org.kiryl.arrays.entity.IntegerArrayWrapper;

import java.util.List;

public class ArrayWrapperFactory {
  public ArrayWrapper<?> createWrapper(List<Number> numbers) {
    if (numbers == null) {
      throw new IllegalArgumentException("Number list cannot be null!");
    }

    if (numbers.isEmpty()) {
      return new IntegerArrayWrapper(new Integer[0]);
    }

    boolean hasFractionalPart = false;
    for (Number number : numbers) {
      // Mathematically check if the number has a fractional part
      if (number.doubleValue() % 1 != 0) {
        hasFractionalPart = true;
        break;
      }
    }

    if (hasFractionalPart) {
      Double[] doubleArray = new Double[numbers.size()];
      for (int i = 0; i < numbers.size(); i++) {
        doubleArray[i] = numbers.get(i).doubleValue();
      }
      return new DoubleArrayWrapper(doubleArray);
    } else {
      Integer[] intArray = new Integer[numbers.size()];
      for (int i = 0; i < numbers.size(); i++) {
        intArray[i] = numbers.get(i).intValue();
      }
      return new IntegerArrayWrapper(intArray);
    }
  }
}
