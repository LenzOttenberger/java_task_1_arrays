package org.kiryl.arrays.service.impl;

import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.service.AverageFinder;
import org.kiryl.arrays.service.SumFinder;

import java.util.Optional;

public class CalculateAverageImpl implements AverageFinder {
  private final SumFinder sumFinder;

  public CalculateAverageImpl(SumFinder sumFinder) {
    this.sumFinder = sumFinder;
  }

  @Override
  public Optional<Double> calculateAverage(ArrayWrapper<?> wrapper) {
    if (wrapper == null || wrapper.getSize() == 0) {
      return Optional.empty();
    }

    Optional<Number> sum = sumFinder.calculateSum(wrapper);
    double average = sum.get().doubleValue() / wrapper.getSize();
    return Optional.of(average);
  }
}
