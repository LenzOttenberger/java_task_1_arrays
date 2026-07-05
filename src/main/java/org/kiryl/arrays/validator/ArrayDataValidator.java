package org.kiryl.arrays.validator;

import java.util.List;

public interface ArrayDataValidator {
  boolean isValid(String line);

  List<String> filterValidLines(List<String> lines);
}
