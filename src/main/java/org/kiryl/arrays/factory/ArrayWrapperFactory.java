package org.kiryl.arrays.factory;

import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.entity.DoubleArrayWrapper;
import org.kiryl.arrays.entity.IntegerArrayWrapper;

import java.util.List;

public class ArrayWrapperFactory {
  public ArrayWrapper<?> createWrapper(List<Number> numbers) {
    if (numbers == null || numbers.isEmpty())
      throw new IllegalArgumentException("Number list cannot be null or empty");

    boolean allInteger = true;
    for (Number number : numbers) {
      if (number instanceof Double) {
        Double doubleValue = (Double) number;
        if (doubleValue % 1 != 0) {
          allInteger = false;
          break;
        }
      }
    }

    if (allInteger) {
      Integer[] intArray = new Integer[numbers.size()];
      for (int i = 0; i < numbers.size(); i++) {
        intArray[i] = numbers.get(i).intValue();
      }
      return new IntegerArrayWrapper(intArray);
    } else {
      Double[] doubleArray = new Double[numbers.size()];
      for (int i = 0; i < numbers.size(); i++) {
        doubleArray[i] = numbers.get(i).doubleValue();
      }
      return new DoubleArrayWrapper(doubleArray);
    }
  }
}
