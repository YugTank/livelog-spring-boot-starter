package com.yug.livelog.logging;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class LiveLogAppenderRegistrar implements ApplicationRunner {
    private static final String APPENDER_NAME = "LIVE_LOG";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger=loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);

        if(rootLogger.getAppender(APPENDER_NAME)!=null)
                return;

        LiveLogAppender appender = new LiveLogAppender();
        appender.setName(APPENDER_NAME);
        appender.setContext(loggerContext);
        appender.start();

        rootLogger.addAppender(appender);
    }
}
