package org.kiryl.arrays.validator.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kiryl.arrays.validator.ArrayDataValidator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataValidationTest {

    private ArrayDataValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DataValidation();
    }

    @Test
    void shouldReturnTrueForValidCommaSeparatedLine() {
        assertTrue(validator.isValid("1, 2, 3"));
    }

    @Test
    void shouldReturnTrueForValidDashSeparatedLine() {
        assertTrue(validator.isValid("1 - 2 - 3"));
    }

    @Test
    void shouldReturnTrueForBlankLine() {
        assertTrue(validator.isValid("   "));
    }

    @Test
    void shouldReturnFalseForLineWithLetters() {
        assertFalse(validator.isValid("1y1 21 32"));
    }

    @Test
    void shouldReturnFalseForNullLine() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldFilterValidLines() {
        List<String> lines = Arrays.asList("1, 2, 3", "invalid", "4 - 5", "   ");
        List<String> validLines = validator.filterValidLines(lines);

        assertEquals(3, validLines.size());
        assertTrue(validLines.contains("1, 2, 3"));
        assertTrue(validLines.contains("4 - 5"));
        assertTrue(validLines.contains("   "));
    }

    @Test
    void shouldThrowExceptionForNullList() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.filterValidLines(null);
        });
    }
}