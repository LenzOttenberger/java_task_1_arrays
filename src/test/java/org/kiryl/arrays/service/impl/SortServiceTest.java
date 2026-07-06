package org.kiryl.arrays.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.entity.IntegerArrayWrapper;
import org.kiryl.arrays.service.SortService;

import static org.junit.jupiter.api.Assertions.*;

class SortServiceTest {

    private SortService bubbleSort;
    private SortService quickSort;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSortImpl();
        quickSort = new QuickSortImpl();
    }

    @Test
    void bubbleSortShouldSortArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{5, 3, 8, 1, 2});
        ArrayWrapper<Integer> result = bubbleSort.sort(wrapper);

        assertEquals(1, result.getElement(0));
        assertEquals(2, result.getElement(1));
        assertEquals(3, result.getElement(2));
        assertEquals(5, result.getElement(3));
        assertEquals(8, result.getElement(4));
    }

    @Test
    void quickSortShouldSortArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{5, 3, 8, 1, 2});
        ArrayWrapper<Integer> result = quickSort.sort(wrapper);

        assertEquals(1, result.getElement(0));
        assertEquals(2, result.getElement(1));
        assertEquals(3, result.getElement(2));
        assertEquals(5, result.getElement(3));
        assertEquals(8, result.getElement(4));
    }

    @Test
    void bubbleSortShouldReturnSameForEmptyArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{});
        ArrayWrapper<Integer> result = bubbleSort.sort(wrapper);

        assertEquals(0, result.getSize());
    }

    @Test
    void quickSortShouldReturnSameForNullWrapper() {
        ArrayWrapper<Integer> result = quickSort.sort(null);
        assertNull(result);
    }

    @Test
    void bubbleSortShouldNotMutateOriginalArray() {
        IntegerArrayWrapper wrapper = new IntegerArrayWrapper(new Integer[]{3, 1, 2});
        bubbleSort.sort(wrapper);

        // Original array should remain unchanged
        assertEquals(3, wrapper.getElement(0));
        assertEquals(1, wrapper.getElement(1));
        assertEquals(2, wrapper.getElement(2));
    }
}