package lesson18.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Class FileUtils
 *
 * Contains static methods to work with files
 */
public class FileUtils {

    /* File size in bytes */
    public static long fileSize(String path) {
        return new File(path).length();
    }

    /* Check directory in path exists */
    public static boolean dirExists(String path) {
        return new File(path).isDirectory();
    }

    /* Creates new directory named dirName at path */
    public static boolean dirCreate(String dirName, String path) {
        if(!dirExists(path)) {
            return false;
        }
        return new File(path.concat(File.separator).concat(dirName)).mkdir();
    }

    /* Array of file names at path */
    public static String[] listOfFiles(String path) {
        return new File(path).list();
    }

    /* Normalized file extension */
    public static String extension(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(fileName.lastIndexOf(".") + 1).toLowerCase()).orElse("");
    }

    /* File name without extension */
    public static String fileName(String fileName) {
        return fileName.replaceFirst("[.][^.]+$", "");
    }

    /* Reading file data to string */
    public static String readToString(String path) {
        StringBuilder content = new StringBuilder();
        try {
            Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                    .forEach(s -> content.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /* Writing string data to file at path */
    public static boolean writeToFile(String path, String data) {
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(data);
            myWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
