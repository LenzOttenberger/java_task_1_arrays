package org.kiryl.arrays.service;

import org.kiryl.arrays.entity.ArrayWrapper;

import java.util.Optional;

public interface AverageFinder {
    Optional<Double> calculateAverage(ArrayWrapper<?> wrapper);
}
