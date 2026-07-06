package org.kiryl.arrays.io.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kiryl.arrays.exception.FileReadingException;
import org.kiryl.arrays.io.DataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader implements DataReader {

  private final Logger logger = LogManager.getLogger(FileDataReader.class);

  @Override
  public List<String> readData(String filePath) {
    if (filePath == null || filePath.isBlank()) {
      throw new IllegalArgumentException("File path cannot be null or blank");
    }

    Path path = Paths.get(filePath);
    logger.info("Attempting to read file: {}", filePath);

    try {
      List<String> lines = Files.readAllLines(path);
      logger.info("Successfully read {} lines from file", lines.size());
      return lines;
    } catch (IOException e) {
      logger.error("Failed to read file: {}", filePath, e);
      throw new FileReadingException("Failed to read file: " + filePath, e);
    }
  }
}
