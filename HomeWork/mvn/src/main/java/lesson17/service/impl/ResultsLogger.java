package lesson17.service.impl;

import lesson17.service.FileLogger;
import lesson17.util.FileUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Class ResultsLogger
 *
 * Writes game results to file named results.log into Results folder.
 * The data will be appended if the file exists.
 */
public class ResultsLogger implements FileLogger {
    @Override
    public boolean log(String data) {
        try {
            String filePath = FileUtils.prepareFile("results.log", "Results");
            OutputStream outputStream = new FileOutputStream(filePath, true);
            outputStream.write(data.concat("\r\n").getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
