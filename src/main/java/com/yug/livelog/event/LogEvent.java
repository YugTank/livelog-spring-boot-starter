package com.yug.livelog.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogEvent {
    private final Long timestamp;
    private final String level;
    private final String loggerName;
    private final String threadName;
    private final String message;
}
