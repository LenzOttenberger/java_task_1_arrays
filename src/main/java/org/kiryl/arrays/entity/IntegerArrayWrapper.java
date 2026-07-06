package org.kiryl.arrays.entity;

public class IntegerArrayWrapper extends ArrayWrapper<Integer> {
  public IntegerArrayWrapper(Integer[] elements) {
    super(elements);
  }

  @Override
  public ArrayWrapper<Integer> createCopy(Integer[] newElements) {
    return new IntegerArrayWrapper(newElements);
  }

  @Override
  public Integer getElement(int index) {
    return elements[index];
  }
}
