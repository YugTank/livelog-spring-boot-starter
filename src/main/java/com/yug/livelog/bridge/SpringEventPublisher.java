package com.yug.livelog.bridge;

import com.yug.livelog.event.LogEvent;
import org.springframework.context.ApplicationEventPublisher;


public class SpringEventPublisher {
    private static ApplicationEventPublisher publisher;

    public SpringEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public static void publish(LogEvent logEvent) {
        if (publisher!=null) {
            publisher.publishEvent(logEvent);
        }
    }
}
