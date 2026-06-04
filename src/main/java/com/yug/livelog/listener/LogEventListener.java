package com.yug.livelog.listener;

import com.yug.livelog.event.LogEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

public class LogEventListener {

    private final SimpMessagingTemplate messaging;

    public LogEventListener(SimpMessagingTemplate messaging) {
        this.messaging = messaging;
    }

    @EventListener
    @Async
    public void handleLogEvent(LogEvent logEvent){
        messaging.convertAndSend("/topic/log", logEvent);
    }
}
