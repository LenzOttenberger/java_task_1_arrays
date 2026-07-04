package org.kiryl.arrays.io.impl;

import org.kiryl.arrays.io.DataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader implements DataReader {
  @Override
  public List<String> readData(String filePath) {
    if (filePath == null || filePath.isBlank()) {
      throw new IllegalArgumentException("String cannot be empty or null!");
    }

    Path path = Paths.get(filePath);

    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      // add custom exception for THIS CASE
      return null; // fix this and replace with EXCEPTION
    }
  }
}
