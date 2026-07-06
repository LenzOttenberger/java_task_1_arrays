package org.kiryl.arrays.service;

import org.kiryl.arrays.entity.ArrayWrapper;

public interface SortService {
    <T extends Number & Comparable<T>>ArrayWrapper<T> sort(ArrayWrapper<T> wrapper);
}
