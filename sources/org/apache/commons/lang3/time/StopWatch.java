package org.apache.commons.lang3.time;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class StopWatch {
    private static final long NANO_2_MILLIS = 1000000;
    private final String message;
    private State runningState;
    private SplitState splitState;
    private long startTimeMillis;
    private long startTimeNanos;
    private long stopTimeMillis;
    private long stopTimeNanos;

    public enum SplitState {
        SPLIT,
        UNSPLIT
    }

    public enum State {
        RUNNING {
            public boolean isStarted() {
                return true;
            }

            public boolean isStopped() {
                return false;
            }

            public boolean isSuspended() {
                return false;
            }
        },
        STOPPED {
            public boolean isStarted() {
                return false;
            }

            public boolean isStopped() {
                return true;
            }

            public boolean isSuspended() {
                return false;
            }
        },
        SUSPENDED {
            public boolean isStarted() {
                return true;
            }

            public boolean isStopped() {
                return false;
            }

            public boolean isSuspended() {
                return true;
            }
        },
        UNSTARTED {
            public boolean isStarted() {
                return false;
            }

            public boolean isStopped() {
                return true;
            }

            public boolean isSuspended() {
                return false;
            }
        };

        public abstract boolean isStarted();

        public abstract boolean isStopped();

        public abstract boolean isSuspended();
    }

    public StopWatch() {
        this((String) null);
    }

    public static StopWatch create() {
        return new StopWatch();
    }

    public static StopWatch createStarted() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    public String formatSplitTime() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public String formatTime() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public String getMessage() {
        return this.message;
    }

    public long getNanoTime() {
        long j;
        long j2;
        State state = this.runningState;
        if (state == State.STOPPED || state == State.SUSPENDED) {
            j = this.stopTimeNanos;
            j2 = this.startTimeNanos;
        } else if (state == State.UNSTARTED) {
            return 0;
        } else {
            if (state == State.RUNNING) {
                j = System.nanoTime();
                j2 = this.startTimeNanos;
            } else {
                throw new IllegalStateException("Illegal running state has occurred.");
            }
        }
        return j - j2;
    }

    public long getSplitNanoTime() {
        if (this.splitState == SplitState.SPLIT) {
            return this.stopTimeNanos - this.startTimeNanos;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time.");
    }

    public long getSplitTime() {
        return getSplitNanoTime() / NANO_2_MILLIS;
    }

    public long getStartTime() {
        if (this.runningState != State.UNSTARTED) {
            return this.startTimeMillis;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public long getStopTime() {
        if (this.runningState != State.UNSTARTED) {
            return this.stopTimeMillis;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public long getTime() {
        return getNanoTime() / NANO_2_MILLIS;
    }

    public boolean isStarted() {
        return this.runningState.isStarted();
    }

    public boolean isStopped() {
        return this.runningState.isStopped();
    }

    public boolean isSuspended() {
        return this.runningState.isSuspended();
    }

    public void reset() {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
    }

    public void resume() {
        if (this.runningState == State.SUSPENDED) {
            this.startTimeNanos += System.nanoTime() - this.stopTimeNanos;
            this.runningState = State.RUNNING;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public void split() {
        if (this.runningState == State.RUNNING) {
            this.stopTimeNanos = System.nanoTime();
            this.splitState = SplitState.SPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void start() {
        State state = this.runningState;
        if (state == State.STOPPED) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        } else if (state == State.UNSTARTED) {
            this.startTimeNanos = System.nanoTime();
            this.startTimeMillis = System.currentTimeMillis();
            this.runningState = State.RUNNING;
        } else {
            throw new IllegalStateException("Stopwatch already started. ");
        }
    }

    public void stop() {
        State state = this.runningState;
        State state2 = State.RUNNING;
        if (state == state2 || state == State.SUSPENDED) {
            if (state == state2) {
                this.stopTimeNanos = System.nanoTime();
                this.stopTimeMillis = System.currentTimeMillis();
            }
            this.runningState = State.STOPPED;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void suspend() {
        if (this.runningState == State.RUNNING) {
            this.stopTimeNanos = System.nanoTime();
            this.stopTimeMillis = System.currentTimeMillis();
            this.runningState = State.SUSPENDED;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public String toSplitString() {
        String objects = Objects.toString(this.message, "");
        String formatSplitTime = formatSplitTime();
        if (objects.isEmpty()) {
            return formatSplitTime;
        }
        return objects + " " + formatSplitTime;
    }

    public String toString() {
        String objects = Objects.toString(this.message, "");
        String formatTime = formatTime();
        if (objects.isEmpty()) {
            return formatTime;
        }
        return objects + " " + formatTime;
    }

    public void unsplit() {
        if (this.splitState == SplitState.SPLIT) {
            this.splitState = SplitState.UNSPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }

    public StopWatch(String str) {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
        this.message = str;
    }

    public long getTime(TimeUnit timeUnit) {
        return timeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS);
    }
}
