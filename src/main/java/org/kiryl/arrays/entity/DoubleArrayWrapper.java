package org.kiryl.arrays.entity;

public class DoubleArrayWrapper extends ArrayWrapper<Double> {
  public DoubleArrayWrapper(Double[] elements) {
    super(elements);
  }

  @Override
  public Double getElement(int index) {
    return elements[index];
  }
}
