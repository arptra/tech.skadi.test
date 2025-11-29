package com.here.time;

import java.util.Objects;
import kotlin.jvm.internal.LongCompanionObject;

public final class Duration implements Comparable<Duration> {
    private static long MILLIS_PER_SECOND = 1000;
    private static int NANOS_PER_MILLIS = 1000000;
    private static long NANOS_PER_SECOND = 1000000000;
    private int mNanos;
    private long mSeconds;

    private Duration(long j, int i) {
        this.mSeconds = j;
        this.mNanos = i;
    }

    private static long divFloor(long j, long j2) {
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    private static long exactAdd(long j, long j2) throws ArithmeticException {
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i < 0 && j < Long.MIN_VALUE - j2) {
            throw new ArithmeticException("Integer underflow");
        } else if (i <= 0 || j <= LongCompanionObject.MAX_VALUE - j2) {
            return j + j2;
        } else {
            throw new ArithmeticException("Integer overflow");
        }
    }

    private static long exactMultiply(long j, long j2) throws ArithmeticException {
        int i = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
        if ((i == 0 && j == Long.MIN_VALUE) || (j == -1 && j2 == Long.MIN_VALUE)) {
            throw new ArithmeticException("Integer overflow");
        }
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 > 0 && j > LongCompanionObject.MAX_VALUE / j2) {
            throw new ArithmeticException("Integer overflow");
        } else if (i2 > 0 && j < Long.MIN_VALUE / j2) {
            throw new ArithmeticException("Integer underflow");
        } else if (i < 0 && j > Long.MIN_VALUE / j2) {
            throw new ArithmeticException("Integer underflow");
        } else if (i >= 0 || j >= LongCompanionObject.MAX_VALUE / j2) {
            return j * j2;
        } else {
            throw new ArithmeticException("Integer overflow");
        }
    }

    private static long modFloor(long j, long j2) {
        long j3 = j % j2;
        return ((j ^ j2) >= 0 || j3 == 0) ? j3 : j3 + j2;
    }

    public static Duration ofDays(long j) throws ArithmeticException {
        return ofHours(exactMultiply(j, 24));
    }

    public static Duration ofHours(long j) throws ArithmeticException {
        return ofMinutes(exactMultiply(j, 60));
    }

    public static Duration ofMillis(long j) {
        return ofNanos(j * ((long) NANOS_PER_MILLIS));
    }

    public static Duration ofMinutes(long j) throws ArithmeticException {
        return ofSeconds(exactMultiply(j, 60));
    }

    public static Duration ofNanos(long j) {
        long j2 = NANOS_PER_SECOND;
        long j3 = j / j2;
        int i = (int) (j % j2);
        if (i < 0) {
            i = (int) (((long) i) + j2);
            j3--;
        }
        return new Duration(j3, i);
    }

    public static Duration ofSeconds(long j) {
        return new Duration(j, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Duration.class != obj.getClass()) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.mSeconds == duration.mSeconds && this.mNanos == duration.mNanos;
    }

    public int getNano() {
        return this.mNanos;
    }

    public long getSeconds() {
        return this.mSeconds;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.mSeconds), Integer.valueOf(this.mNanos)});
    }

    public long toDays() {
        return toHours() / 24;
    }

    public long toDaysPart() {
        return toDays();
    }

    public long toHours() {
        return toMinutes() / 60;
    }

    public int toHoursPart() {
        return (int) (toHours() % 24);
    }

    public long toMillis() throws ArithmeticException {
        return exactAdd(exactMultiply(this.mSeconds, MILLIS_PER_SECOND), (long) (this.mNanos / NANOS_PER_MILLIS));
    }

    public int toMillisPart() {
        return this.mNanos / NANOS_PER_MILLIS;
    }

    public long toMinutes() {
        return this.mSeconds / 60;
    }

    public int toMinutesPart() {
        return (int) (toMinutes() % 60);
    }

    public long toNanos() throws ArithmeticException {
        return exactAdd(exactMultiply(this.mSeconds, NANOS_PER_SECOND), (long) this.mNanos);
    }

    public int toNanosPart() {
        return this.mNanos;
    }

    public long toSeconds() {
        return this.mSeconds;
    }

    public int toSecondsPart() {
        return (int) (this.mSeconds % 60);
    }

    public static Duration ofSeconds(long j, long j2) {
        return new Duration(exactAdd(j, divFloor(j2, NANOS_PER_SECOND)), (int) modFloor(j2, NANOS_PER_SECOND));
    }

    public int compareTo(Duration duration) {
        int i = (this.mSeconds > duration.mSeconds ? 1 : (this.mSeconds == duration.mSeconds ? 0 : -1));
        int i2 = i < 0 ? -1 : i > 0 ? 1 : 0;
        if (i2 == 0) {
            int i3 = this.mNanos;
            int i4 = duration.mNanos;
            if (i3 < i4) {
                return -1;
            }
            if (i3 > i4) {
                return 1;
            }
        }
        return i2;
    }
}
