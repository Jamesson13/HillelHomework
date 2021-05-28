package lesson18.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lesson18.util.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.Map;

/**
 * Class ConvertingService
 *
 * Provides functionality for converting json and yaml files.
 */
public class ConvertingService {
    private static final String LOG_FILE_NAME = "result.log";
    private static final String CONVERTED_DIR_NAME = "Converted";

    public static void convertFiles(String srcPath) {
        String dstPath;
        int filesConverted;

        if (!FileUtils.dirExists(srcPath)) {
            System.out.println("Directory doesn't exists. Nothing to convert.");
            return;
        }

        dstPath = srcPath.concat(File.separator).concat(CONVERTED_DIR_NAME);
        if (!FileUtils.dirExists(dstPath)) {
            if(!FileUtils.dirCreate(CONVERTED_DIR_NAME, srcPath)) {
                System.out.println("Unable to create directory for converted files.");
                return;
            }
        }

        filesConverted = convert(srcPath, dstPath);
        if (filesConverted == 0) {
            System.out.println("Files not found.");
        } else {
            System.out.println("Total files converted: " + filesConverted);
        }
    }

    private static int convert (String srcDir, String dstDir) {
        int convertedCnt = 0;
        boolean convertingStatus;
        long startTime;
        String statusStr;
        String dstFile;
        String srcPath, dstPath;
        Logger log = new Logger();

        for(String file : FileUtils.listOfFiles(srcDir)) {
            startTime = System.currentTimeMillis(); // start conversion time counting
            srcPath = srcDir.concat(File.separator).concat(file); // make source file path

            switch (FileUtils.extension(file)) {
                case "yaml" -> {
                    dstFile = FileUtils.fileName(file).concat(".json");
                    dstPath = dstDir.concat(File.separator).concat(dstFile); // make destination file path
                    convertingStatus = yamlToJson(srcPath, dstPath);
                    statusStr = statusString(convertingStatus, srcPath, dstPath, file, dstFile,
                            System.currentTimeMillis() - startTime); // make status string
                    System.out.println(statusStr);
                    log.appendLine(statusStr);
                    if (convertingStatus) {
                        convertedCnt++; // iterate counter
                    }
                }
                case "json" -> {
                    dstFile = FileUtils.fileName(file).concat(".yaml");
                    dstPath = dstDir.concat(File.separator).concat(dstFile); // make destination file path
                    convertingStatus = jsonToYaml(srcPath, dstPath);
                    statusStr = statusString(convertingStatus, srcPath, dstPath, file, dstFile,
                            System.currentTimeMillis() - startTime); // make status string
                    System.out.println(statusStr);
                    log.appendLine(statusStr);
                    if (convertingStatus) {
                        convertedCnt++; // iterate counter
                    }
                }
            }
        }

        // log data to file
        if (!log.toFile(srcDir.concat(File.separator).concat(LOG_FILE_NAME))) {
            System.out.println("Can't write log data to file.");
        }

        return convertedCnt;
    }

    private static boolean yamlToJson(String sourcePath, String destPath) {
        String yamlStr = FileUtils.readToString(sourcePath);
        try {
            Map<String, Object> objMap = new Yaml().load(yamlStr);
            String jsonStr = new GsonBuilder().setPrettyPrinting().create().toJson(objMap);
            return FileUtils.writeToFile(destPath, jsonStr);
        } catch (JsonSyntaxException | ClassCastException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean jsonToYaml(String sourcePath, String destPath) {
        String jsonStr = FileUtils.readToString(sourcePath);
        try {
            Map<String, Object> objMap = new Gson().fromJson(jsonStr,
                    new TypeToken<Map<String, Object>>() {
                    }.getType());
            String yamlStr = new Yaml().dump(objMap);
            return FileUtils.writeToFile(destPath, yamlStr);
        } catch (JsonSyntaxException | ClassCastException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String statusString(boolean convertingStatus, String srcPath, String dstPath, String srcFile, String dstFile, long convTime) {
        return  convertingStatus
                ?srcFile +
                " -> " +
                dstFile +
                ", " +
                convTime +
                "ms, " +
                FileUtils.fileSize(srcPath) +
                "bytes -> " +
                FileUtils.fileSize(dstPath) +
                "bytes"
                :srcFile + " -> not converted";
    }
}
