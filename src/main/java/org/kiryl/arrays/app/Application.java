package org.kiryl.arrays.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kiryl.arrays.entity.ArrayWrapper;
import org.kiryl.arrays.factory.ArrayWrapperFactory;
import org.kiryl.arrays.io.DataReader;
import org.kiryl.arrays.io.impl.FileDataReader;
import org.kiryl.arrays.parser.ArrayDataParser;
import org.kiryl.arrays.parser.impl.ArrayDataParserImpl;
import org.kiryl.arrays.service.AverageFinder;
import org.kiryl.arrays.service.MinMaxFinder;
import org.kiryl.arrays.service.SortService;
import org.kiryl.arrays.service.SumFinder;
import org.kiryl.arrays.service.impl.BubbleSortImpl;
import org.kiryl.arrays.service.impl.CalculateAverageImpl;
import org.kiryl.arrays.service.impl.CalculateSumImpl;
import org.kiryl.arrays.service.impl.MinMaxFinderImpl;
import org.kiryl.arrays.service.impl.QuickSortImpl;
import org.kiryl.arrays.validator.ArrayDataValidator;
import org.kiryl.arrays.validator.impl.DataValidation;

import java.util.List;
import java.util.Optional;

public class Application {

  private final Logger logger = LogManager.getLogger(Application.class);

  public void run() {
    logger.info("Application started");

    DataReader reader = new FileDataReader();
    ArrayDataValidator validator = new DataValidation();
    ArrayDataParser parser = new ArrayDataParserImpl();
    ArrayWrapperFactory factory = new ArrayWrapperFactory();

    SumFinder sumFinder = new CalculateSumImpl();
    MinMaxFinder minMaxFinder = new MinMaxFinderImpl();
    AverageFinder averageFinder = new CalculateAverageImpl(sumFinder);
    SortService bubbleSort = new BubbleSortImpl();
    SortService quickSort = new QuickSortImpl();

    logger.info("Components initialized successfully");

    try {
      List<String> lines = reader.readData("data/input.txt");
      logger.info("Read {} lines from file", lines.size());

      List<String> validLines = validator.filterValidLines(lines);
      logger.info("Filtered {} valid lines from {}", validLines.size(), lines.size());

      logger.info("--- Starting Array Processing ---");

      for (String line : validLines) {
        List<Number> numbers = parser.parse(line);
        ArrayWrapper<?> wrapper = factory.createWrapper(numbers);

        processAndLog(wrapper, minMaxFinder, sumFinder, averageFinder, bubbleSort, quickSort);
      }

      logger.info("--- Processing Finished ---");

    } catch (Exception e) {
      logger.error("Application failed with exception", e);
    }

    logger.info("Application finished");
  }

  private <T extends Number & Comparable<T>> void processAndLog(
      ArrayWrapper<T> wrapper,
      MinMaxFinder minMaxFinder,
      SumFinder sumFinder,
      AverageFinder averageFinder,
      SortService bubbleSort,
      SortService quickSort) {

    logger.info("Processing array of size: {}", wrapper.getSize());

    Optional<Number> min = minMaxFinder.findMin(wrapper);
    Optional<Number> max = minMaxFinder.findMax(wrapper);
    logOptional("Min", min);
    logOptional("Max", max);

    Optional<Number> sum = sumFinder.calculateSum(wrapper);
    logOptional("Sum", sum);

    Optional<Double> average = averageFinder.calculateAverage(wrapper);
    logOptional("Average", average);

    ArrayWrapper<T> bubbleSorted = bubbleSort.sort(wrapper);
    logger.info("Bubble Sort: {}", arrayToString(bubbleSorted));

    ArrayWrapper<T> quickSorted = quickSort.sort(wrapper);
    logger.info("Quick Sort: {}", arrayToString(quickSorted));
  }

  private void logOptional(String label, Optional<?> optional) {
    if (optional.isPresent()) {
      logger.info("{}: {}", label, optional.get());
    } else {
      logger.warn("{}: N/A (empty array)", label);
    }
  }

  private <T extends Number & Comparable<T>> String arrayToString(ArrayWrapper<T> wrapper) {
    if (wrapper.getSize() == 0) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < wrapper.getSize(); i++) {
      sb.append(wrapper.getElement(i));
      if (i < wrapper.getSize() - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  public static void main(String[] args) {
    Application app = new Application();
    app.run();
  }
}
