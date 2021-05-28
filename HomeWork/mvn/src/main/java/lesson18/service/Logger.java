package lesson18.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Class Logger
 *
 * Object Logger can be used to log data and write it to a file later.
 * There are some functionality for cleaning the log or String representation.
 */
public class Logger {
    private final StringBuilder logData = new StringBuilder();

    /* Append data */
    public void append(String data) {
        this.logData.append(data);
    }

    /* Append data with new line character */
    public void appendLine(String data) {
        this.logData.append(data).append("\r\n");
    }

    /* Clean log data */
    public void clean() {
        this.logData.setLength(0);
    }

    /* Log data to file */
    public boolean toFile(String path) {
        try {
            OutputStream oStream = new FileOutputStream(path, true);
            oStream.write(this.logData.toString().getBytes(StandardCharsets.UTF_8));
            oStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* String representation of logged data */
    public String toString() {
        return this.logData.toString();
    }
}
