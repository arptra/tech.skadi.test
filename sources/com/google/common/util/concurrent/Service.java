package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@DoNotMock("Create an AbstractIdleService")
public interface Service {

    public static abstract class Listener {
        public void failed(State state, Throwable th) {
        }

        public void running() {
        }

        public void starting() {
        }

        public void stopping(State state) {
        }

        public void terminated(State state) {
        }
    }

    public enum State {
        NEW {
            public boolean isTerminal() {
                return false;
            }
        },
        STARTING {
            public boolean isTerminal() {
                return false;
            }
        },
        RUNNING {
            public boolean isTerminal() {
                return false;
            }
        },
        STOPPING {
            public boolean isTerminal() {
                return false;
            }
        },
        TERMINATED {
            public boolean isTerminal() {
                return true;
            }
        },
        FAILED {
            public boolean isTerminal() {
                return true;
            }
        };

        public abstract boolean isTerminal();
    }

    void addListener(Listener listener, Executor executor);

    void awaitRunning();

    void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException;

    void awaitTerminated();

    void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException;

    Throwable failureCause();

    boolean isRunning();

    @CanIgnoreReturnValue
    Service startAsync();

    State state();

    @CanIgnoreReturnValue
    Service stopAsync();
}
