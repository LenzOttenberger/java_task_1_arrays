package org.kiryl.arrays.io;

import java.io.FileNotFoundException;
import java.util.List;

public interface DataReader {
    List<String> readData(String filePath) throws FileNotFoundException;
}
