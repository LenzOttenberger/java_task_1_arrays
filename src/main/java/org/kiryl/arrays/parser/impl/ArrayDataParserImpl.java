package org.kiryl.arrays.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayDataParserImpl implements org.kiryl.arrays.parser.ArrayDataParser {

  private final Logger logger = LogManager.getLogger(ArrayDataParserImpl.class);
  private static final String DELIMITER_PATTERN = "[,;\\-\\s]+";

  @Override
  public List<Number> parse(String line) {
    if (line == null) {
      throw new IllegalArgumentException("Line cannot be null");
    }

    if (line.isBlank()) {
      logger.debug("Parsed blank line, returning empty list");
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

    logger.debug("Parsed line into {} numbers", numbers.size());
    return numbers;
  }
}
