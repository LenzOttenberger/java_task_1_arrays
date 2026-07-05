package org.kiryl.arrays.parser.impl;

import java.util.ArrayList;
import java.util.List;

public class ArrayParser implements org.kiryl.arrays.parser.ArrayParser {
  private static final String DELIMITER_PATTERN = "[,;\\-\\s]+";

  @Override
  public List<Number> parse(String line) {
    if (line == null) {
      throw new IllegalArgumentException("Line cannot be null!");
    }

    if (line.isBlank()) {
      return new ArrayList<>();
    }

    String[] parts = line.split(DELIMITER_PATTERN);

    List<Number> numbers = new ArrayList<>();
    for (String part : parts) {
      if (part.isEmpty()) {
        continue;
      }

      if (part.contains(".")) {
        numbers.add(Double.parseDouble(part));
      } else {
        numbers.add(Integer.parseInt(part));
      }
    }

    return numbers;
  }
}
