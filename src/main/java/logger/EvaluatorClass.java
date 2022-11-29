package logger;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.TriggeringEventEvaluator;

public class EvaluatorClass implements TriggeringEventEvaluator {
    @Override
    public boolean isTriggeringEvent(LoggingEvent loggingEvent) {
        return true;
    }
}