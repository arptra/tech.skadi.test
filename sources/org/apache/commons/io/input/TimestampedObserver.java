package org.apache.commons.io.input;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import org.apache.commons.io.input.ObservableInputStream;

public class TimestampedObserver extends ObservableInputStream.Observer {
    private volatile Instant closeInstant;
    private final Instant openInstant = Instant.now();

    public void closed() throws IOException {
        this.closeInstant = Instant.now();
    }

    public Instant getCloseInstant() {
        return this.closeInstant;
    }

    public Instant getOpenInstant() {
        return this.openInstant;
    }

    public Duration getOpenToCloseDuration() {
        return Duration.between(this.openInstant, this.closeInstant);
    }

    public Duration getOpenToNowDuration() {
        return Duration.between(this.openInstant, Instant.now());
    }

    public String toString() {
        return "TimestampedObserver [openInstant=" + this.openInstant + ", closeInstant=" + this.closeInstant + "]";
    }
}
