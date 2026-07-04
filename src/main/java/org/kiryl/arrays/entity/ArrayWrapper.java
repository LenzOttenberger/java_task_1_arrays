package org.kiryl.arrays.entity;

public abstract class ArrayWrapper<T extends Number & Comparable<T>> {
  protected T[] elements;

  protected ArrayWrapper(T[] elements) {
    if (elements == null)
      throw new IllegalArgumentException(
          "Elements array have to contain some elements, but it not.");
    this.elements = elements.clone();
  }

  public void setElement(int index, T element) {
    if(element == null) throw new IllegalArgumentException("Element cannot be null, but it is.");
    if(index < 0 || index >= this.getSize()) throw new IndexOutOfBoundsException("Index out of bounds");
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
