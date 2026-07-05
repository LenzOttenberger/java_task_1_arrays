package org.kiryl.arrays.validator.impl;

import org.kiryl.arrays.validator.ArrayDataValidator;

import java.util.ArrayList;
import java.util.List;

public class DataValidation implements ArrayDataValidator {
  static final String VALID_PATTERN = "^[\\d\\s,;.-]*$"; //i asked qwen and he told
  // that the best practise is to set constants in class (QUESTION)!!!

  @Override
  public boolean isValid(String line) {
    if (line == null) {
      return false;
    }
    if (line.isBlank()) {
      return true;
    }
    return line.matches(VALID_PATTERN);
  }

  @Override
  public List<String> filterValidLines(List<String> lines) {
    if (lines == null) {
      throw new IllegalArgumentException("Lines list cannot be empty!");
    }

    List<String> validLines = new ArrayList<>();
    for (String line : lines) {
      if (isValid(line)) {
        validLines.add(line);
      }
    }

    return validLines;
  }
}
