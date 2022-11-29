package logger;

import org.apache.log4j.Logger;

public class Log {
    public static void logInfo(Class<?> className, String recordMessage) {
        Logger logger = Logger.getLogger(className);
        logger.info(recordMessage);
    }

    public static void logMail(String errorText) {
        Logger.getLogger(Log.class).fatal(errorText);
    }
}