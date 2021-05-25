package lesson17.util;

import java.io.File;
import java.io.IOException;

/**
 * Class FileUtils
 *
 * Contains static method to work with files.
 */
public class FileUtils {
    /* Check file is exists in specified subfolder */
    public static boolean isExists(String fileName, String subFolderName) {
         return new File(System.getProperty("user.dir").concat(File.separator)
                .concat(subFolderName).concat(File.separator).concat(fileName)).exists();
    }

    /* Get file path by fileName and subFolderName. Creates a file if it doesn't exists. */
    public static String prepareFile(String fileName, String subFolderName) throws IOException {
        String dirPath = System.getProperty("user.dir").concat(File.separator);
        String filePath = dirPath.concat(subFolderName).concat(File.separator);
        File dir = new File(dirPath.concat(subFolderName));
        File file = new File(filePath.concat(fileName));

        if (file.exists() && file.isFile() && file.canWrite() && file.canRead()) {
            return filePath.concat(fileName);
        }

        // check for directory exists and create it if needed
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Created directory " + subFolderName + " at: " + dirPath);
            } else {
                System.out.println("Can't create directory " + subFolderName + " at: " + dirPath);
                throw new IOException();
            }
        } else {
            if (!dir.isDirectory()) {
                System.out.println("Can't create directory " + subFolderName + " at: " + dirPath);
                System.out.println("There is a file with such name.");
                throw new IOException();
            }
        }

        // check for file exists and create it if needed
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("Created file " + fileName + " at: " + filePath);
            } else {
                System.out.println("Can't create file " + fileName + " at: " + filePath);
                throw new IOException();
            }
        } else {
            if (!file.isFile()) {
                System.out.println("Can't create file " + fileName + " at: " + filePath);
                System.out.println("There is a folder with such name.");
                throw new IOException();
            }
        }

        return filePath.concat(fileName);
    }
}
