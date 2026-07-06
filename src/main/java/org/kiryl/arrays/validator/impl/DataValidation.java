package org.kiryl.arrays.validator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kiryl.arrays.validator.ArrayDataValidator;

import java.util.ArrayList;
import java.util.List;

public class DataValidation implements ArrayDataValidator {

  private final Logger logger = LogManager.getLogger(DataValidation.class);
  private static final String VALID_PATTERN = "^[\\d\\s,;.-]*$";

  @Override
  public boolean isValid(String line) {
    if (line == null) {
      return false;
    }
    if (line.isBlank()) {
      return true;
    }
    boolean result = line.matches(VALID_PATTERN);
    if (!result) {
      logger.warn("Line is invalid: {}", line);
    }
    return result;
  }

  @Override
  public List<String> filterValidLines(List<String> lines) {
    if (lines == null) {
      throw new IllegalArgumentException("Lines list cannot be null");
    }

    List<String> validLines = new ArrayList<>();
    for (String line : lines) {
      if (isValid(line)) {
        validLines.add(line);
      }
    }

    logger.info("Filtered {} valid lines from {}", validLines.size(), lines.size());
    return validLines;
  }
}
