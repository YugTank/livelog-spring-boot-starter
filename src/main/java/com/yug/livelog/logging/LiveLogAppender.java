package com.yug.livelog.logging;

import com.yug.livelog.bridge.SpringEventPublisher;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.yug.livelog.event.LogEvent;

public class LiveLogAppender extends AppenderBase<ILoggingEvent> {
    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        long timestamps= iLoggingEvent.getTimeStamp();
        String level = iLoggingEvent.getLevel().toString();
        String message = iLoggingEvent.getFormattedMessage();
        String threadName = iLoggingEvent.getThreadName();
        String loggerName = iLoggingEvent.getLoggerName();

        SpringEventPublisher.publish(new LogEvent(timestamps, level, loggerName, threadName, message));
    }
}