package lesson18;

import lesson18.service.ConvertingService;

/**
 * Class Converter
 *
 * Converts files json->yaml or yaml->json.
 * Directory with files can be placed as program argument,
 * otherwise it working from current path.
 *
 * Creates /results.log with full information about conversion process.
 * All converted files are placed in /Converted/ subdirectory.
 */
public class Converter {
    public static void main(String[] args) {
        if (args.length > 0) {
            ConvertingService.convertFiles(args[0]);
        } else {
            System.out.println("There is no argument set. Working from current directory.");
            ConvertingService.convertFiles(System.getProperty("user.dir"));
        }
    }
}
