package org.kiryl.arrays.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kiryl.arrays.entity.IntegerArrayWrapper;
import org.kiryl.arrays.entity.DoubleArrayWrapper;
import org.kiryl.arrays.service.SumFinder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculateSumImplTest {

    private SumFinder sumFinder;

    @BeforeEach
    void setUp() {
        sumFinder = new CalculateSumImpl();
    }

    @Test
    void shouldReturnSumForIntegerArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{1, 2, 3, 4, 5});
        Optional<Number> result = sumFinder.calculateSum(wrapper);

        assertTrue(result.isPresent());
        assertEquals(15.0, result.get().doubleValue());
    }

    @Test
    void shouldReturnSumForDoubleArray() {
        DoubleArrayWrapper wrapper = new DoubleArrayWrapper(new Double[]{1.5, 2.5, 3.0});
        Optional<Number> result = sumFinder.calculateSum(wrapper);

        assertTrue(result.isPresent());
        assertEquals(7.0, result.get().doubleValue());
    }

    @Test
    void shouldReturnEmptyForNullWrapper() {
        Optional<Number> result = sumFinder.calculateSum(null);
        assertFalse(result.isPresent());
    }

    @Test
    void shouldReturnEmptyForEmptyArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{});
        Optional<Number> result = sumFinder.calculateSum(wrapper);

        assertFalse(result.isPresent());
    }
}