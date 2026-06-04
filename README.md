# LiveLog

LiveLog is a zero-configuration Spring Boot starter that provides real-time application log streaming through a built-in web dashboard.

Simply add the dependency, start your application, and open:

http://localhost:8080/livelog

to view live logs from your application as they are generated.

---

## Features

* Real-time log streaming using WebSockets and STOMP
* Built-in dashboard available at `/livelog`
* Automatic Spring Boot auto-configuration
* Logback integration through a custom appender
* No manual WebSocket configuration required
* No `logback-spring.xml` configuration required
* Automatic reconnection support
* Enable or disable functionality using application properties

---

## How It Works

LiveLog captures Logback events and streams them to connected clients in real time.

```text
log.info(...)
    ↓
LiveLogAppender
    ↓
SpringEventPublisher
    ↓
ApplicationEventPublisher
    ↓
LogEventListener
    ↓
SimpMessagingTemplate
    ↓
/topic/log
    ↓
LiveLog Dashboard
```

---

## Installation

### 1. Add the dependency

```xml
<dependency>
    <groupId>com.yug</groupId>
    <artifactId>livelog-starter</artifactId>
    <version>0.1.0</version>
</dependency>
```

### 2. Start your Spring Boot application

No additional configuration is required.

### 3. Open the dashboard

```text
http://localhost:8080/livelog
```

You should immediately start seeing application logs appear in real time.

---

## Configuration

LiveLog is enabled by default.

### Disable LiveLog

```properties
livelog.enabled=false
```

---

## Dashboard

The built-in dashboard provides:

* Live log streaming
* Connection status indicator
* Log level highlighting
* Logger and thread information
* Automatic reconnection support

---

## Technologies Used

* Java
* Spring Boot
* Spring Boot AutoConfiguration
* Spring Events
* Logback
* WebSocket
* STOMP
* JavaScript

---

## Project Structure

```text
LiveLogAppender
    Captures Logback events

SpringEventPublisher
    Bridges Logback and Spring

LogEventListener
    Processes log events

LiveLogAppenderRegistrar
    Registers the custom appender

WebSocketConfig
    Configures WebSocket and STOMP endpoints

LiveLog Dashboard
    Displays logs in real time
```

---

## Roadmap

Future enhancements under consideration:

* Configurable dashboard endpoint
* Configurable WebSocket topics
* Log filtering by level
* Search functionality
* Custom dashboard themes

---

## License

This project is licensed under the MIT License.
