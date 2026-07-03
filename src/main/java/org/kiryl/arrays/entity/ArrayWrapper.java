package org.kiryl.arrays.entity;

public abstract class ArrayWrapper<T extends Number> {
  protected T[] elements;

  protected ArrayWrapper(T[] elements) {
    if (elements == null)
      throw new IllegalArgumentException(
          "Elements array have to contain some elements, but it not.");
    this.elements = elements.clone();
  }

  public T[] getElements() {
    return elements.clone();
  }

  public int getSize() {
    return elements.length;
  }

  public abstract T getElement(int index);
}
