package org.kiryl.arrays.service.impl;

import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.service.SumFinder;

import java.util.Optional;

public class CalculateSumImpl implements SumFinder {
  @Override
  public Optional<Number> calculateSum(ArrayWrapper<?> wrapper) {
    if (wrapper == null || wrapper.getSize() == 0) {
      return Optional.empty();
    }

    double sum = 0;
    for (int i = 0; i < wrapper.getSize(); i++) {
      sum += wrapper.getElement(i).doubleValue();
    }

    return Optional.of(sum);
  }
}
