package org.kiryl.arrays.service;

import org.kiryl.arrays.entity.ArrayWrapper;

import java.util.Optional;

public interface MinMaxFinder {
    Optional<Number> findMin(ArrayWrapper<?> wrapper);
    Optional<Number> findMax(ArrayWrapper<?> wrapper);

    Optional<Number[]> findMinMax(ArrayWrapper<?> wrapper);
}
