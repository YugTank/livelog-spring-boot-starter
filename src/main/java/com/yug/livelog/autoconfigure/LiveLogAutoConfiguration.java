package com.yug.livelog.autoconfigure;

import com.yug.livelog.bridge.SpringEventPublisher;
import com.yug.livelog.controller.LiveLogController;
import com.yug.livelog.listener.LogEventListener;
import com.yug.livelog.logging.LiveLogAppenderRegistrar;
import com.yug.livelog.websocket.WebSocketConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.simp.SimpMessagingTemplate;


@AutoConfiguration
@Import(WebSocketConfig.class)
@ConditionalOnClass(SimpMessagingTemplate.class)
@ConditionalOnProperty(
        prefix = "livelog",
        name="enabled",
        havingValue="true",
        matchIfMissing=true
)
public class LiveLogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SpringEventPublisher springEventPublisher(ApplicationEventPublisher publisher) {
        return new SpringEventPublisher(publisher);
    }

    @Bean
    @ConditionalOnMissingBean
    public LogEventListener logEventListener(SimpMessagingTemplate template) {
        return new LogEventListener(template);
    }

    @Bean
    public LiveLogAppenderRegistrar liveLogAppenderRegistrar() {
        return new LiveLogAppenderRegistrar();
    }

    @Bean
    public LiveLogController liveLogController() {
        return new LiveLogController();
    }
}
