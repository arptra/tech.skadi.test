package org.slf4j.event;

import org.slf4j.Logger;

public class DefaultLoggingEvent implements LoggingEvent {

    /* renamed from: a  reason: collision with root package name */
    public Logger f3455a;
    public Level b;

    public DefaultLoggingEvent(Level level, Logger logger) {
        this.f3455a = logger;
        this.b = level;
    }
}
