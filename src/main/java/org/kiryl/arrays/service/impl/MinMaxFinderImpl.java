package org.kiryl.arrays.service.impl;

import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.service.MinMaxFinder;

import java.util.Optional;

public class MinMaxFinderImpl implements MinMaxFinder {
  @Override
  public Optional<Number> findMin(ArrayWrapper<?> wrapper) {
    if (wrapper == null || wrapper.getSize() == 0) {
      return Optional.empty();
    }

    Number min = wrapper.getElement(0);
    for (int i = 1; i < wrapper.getSize(); i++) {
      Number current = wrapper.getElement(i);
      if (current.doubleValue() < min.doubleValue()) {
        min = current;
      }
    }

    return Optional.of(min);
  }

  @Override
  public Optional<Number> findMax(ArrayWrapper<?> wrapper) {
    if (wrapper == null || wrapper.getSize() == 0) {
      return Optional.empty();
    }

    Number max = wrapper.getElement(0);
    for (int i = 1; i < wrapper.getSize(); i++) {
      Number current = wrapper.getElement(i);
      if (current.doubleValue() > max.doubleValue()) {
        max = current;
      }
    }

    return Optional.of(max);
  }

  @Override
  public Optional<Number[]> findMinMax(ArrayWrapper<?> wrapper) {
    if (wrapper == null || wrapper.getSize() == 0) {
      return Optional.empty();
    }

    Number min = wrapper.getElement(0);
    Number max = wrapper.getElement(0);
    for (int i = 1; i < wrapper.getSize(); i++) {
      Number current = wrapper.getElement(i);

      if (current.doubleValue() < min.doubleValue()) {
        min = current;
      } else if (current.doubleValue() > max.doubleValue()) {
        max = current;
      }
    }

    Number[] minMax = new Number[2];
    minMax[0] = min;
    minMax[1] = max;

    return Optional.of(minMax);
  }
}
