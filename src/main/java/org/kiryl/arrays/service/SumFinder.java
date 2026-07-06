package org.kiryl.arrays.service;

import org.kiryl.arrays.entity.ArrayWrapper;

import java.util.Optional;

public interface SumFinder {
    Optional<Number> calculateSum(ArrayWrapper<?> wrapper);
}
