package org.kiryl.arrays.entity;

public abstract class ArrayWrapper<T extends Number & Comparable<T>> {
  protected T[] elements;

  public abstract ArrayWrapper<T> createCopy(T[] newElements);

  protected ArrayWrapper(T[] elements) {
    if (elements == null) {
      throw new IllegalArgumentException("Elements array cannot be null");
    }
    this.elements = elements.clone();
  }

  public void setElement(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    if (index < 0 || index >= getSize()) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getSize());
    }
    this.elements[index] = element;
  }

  public T[] getElements() {
    return elements.clone();
  }

  public int getSize() {
    return elements.length;
  }

  public abstract T getElement(int index);
}