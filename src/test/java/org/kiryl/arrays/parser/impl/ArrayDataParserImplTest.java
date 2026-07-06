package org.kiryl.arrays.parser.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kiryl.arrays.parser.ArrayDataParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDataParserImplTest {

    private ArrayDataParser parser;

    @BeforeEach
    void setUp() {
        parser = new ArrayDataParserImpl();
    }

    @Test
    void shouldParseCommaSeparatedIntegers() {
        List<Number> result = parser.parse("1, 2, 3");

        assertEquals(3, result.size());
        assertEquals(1, result.get(0).intValue());
        assertEquals(2, result.get(1).intValue());
        assertEquals(3, result.get(2).intValue());
    }

    @Test
    void shouldParseDashSeparatedDoubles() {
        List<Number> result = parser.parse("1.5 - 2.5 - 3.5");

        assertEquals(3, result.size());
        assertEquals(1.5, result.get(0).doubleValue());
        assertEquals(2.5, result.get(1).doubleValue());
        assertEquals(3.5, result.get(2).doubleValue());
    }

    @Test
    void shouldReturnEmptyListForBlankLine() {
        List<Number> result = parser.parse("   ");
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldThrowExceptionForNullLine() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parse(null);
        });
    }
}