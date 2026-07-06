package org.kiryl.arrays.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kiryl.arrays.entity.IntegerArrayWrapper;
import org.kiryl.arrays.service.MinMaxFinder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxFinderImplTest {

    private MinMaxFinder minMaxFinder;

    @BeforeEach
    void setUp() {
        minMaxFinder = new MinMaxFinderImpl();
    }

    @Test
    void shouldFindMinInArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{5, 2, 8, 1, 9});
        Optional<Number> result = minMaxFinder.findMin(wrapper);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().intValue());
    }

    @Test
    void shouldFindMaxInArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{5, 2, 8, 1, 9});
        Optional<Number> result = minMaxFinder.findMax(wrapper);

        assertTrue(result.isPresent());
        assertEquals(9, result.get().intValue());
    }

    @Test
    void shouldReturnEmptyForNullWrapper() {
        Optional<Number> result = minMaxFinder.findMin(null);
        assertFalse(result.isPresent());
    }

    @Test
    void shouldReturnEmptyForEmptyArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{});
        Optional<Number> result = minMaxFinder.findMin(wrapper);

        assertFalse(result.isPresent());
    }

    @Test
    void shouldHandleSingleElementArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{42});
        Optional<Number> min = minMaxFinder.findMin(wrapper);
        Optional<Number> max = minMaxFinder.findMax(wrapper);

        assertEquals(42, min.get().intValue());
        assertEquals(42, max.get().intValue());
    }
}