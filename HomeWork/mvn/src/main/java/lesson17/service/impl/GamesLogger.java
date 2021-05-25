package lesson17.service.impl;

import lesson17.service.FileLogger;
import lesson17.util.FileUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Class GamesLogger
 *
 * Writes game log to file and put it into GamesLog folder.
 * Filename should be specified during the object creation.
 * If a file with such name exists, new file will be created.
 * The name of new file will be xxx_n.yyy,
 * where xxx - name specified in constructor argument,
 * n - counter with value (1...9),
 * yyy - file type.
 * If there is a file with the maximum counter (xxx_9.yyy) - data will be appended to it.
 */

public class GamesLogger implements FileLogger {
    private String fileName;

    public GamesLogger(String fileName) {
        this.fileName = fileName;
        // check file is exists
        if(FileUtils.isExists(this.fileName, "GamesLog")) {
            this.fileName = newIndexedFilename(this.fileName);
        }
    }

    @Override
    public boolean log(String data) {
        try {
            String filePath = FileUtils.prepareFile(fileName, "GamesLog");
            OutputStream outputStream = new FileOutputStream(filePath, true);
            outputStream.write(data.concat("\r\n").getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /* Make filename with index. If filename not consist '.' then return filename. */
    private String newIndexedFilename(String fileName) {
        String tmpName = fileName;
        if(!fileName.contains("\\.")) {
            String[] namePart = fileName.split("\\.");
            for (int i = 1; i < 9; i++) {
                tmpName = namePart[0].concat("_").concat(String.valueOf(i)).concat(".").concat(namePart[1]);
                if (!FileUtils.isExists(tmpName, "GamesLog")) {
                    return tmpName;
                }
            }
        }
        return tmpName;
    }
}
