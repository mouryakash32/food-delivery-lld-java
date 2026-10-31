package org.exampl.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    public static String getCurrentTime() {
        LocalDateTime time = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return time.format(formatter);
    }
}
