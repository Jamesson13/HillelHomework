package lesson17.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class TimeUtils
 *
 * Contains static methods to generate current timestamp.
 */
public class TimeUtils {
    public static String timeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    }

    public static String timeStampExtended() {
        return new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date());
    }
}
