package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    public static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d) {
            super(sleepingStopwatch);
            this.maxBurstSeconds = d;
        }

        public double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        public void doSetRate(double d, double d2) {
            double d3 = this.maxPermits;
            double d4 = this.maxBurstSeconds * d;
            this.maxPermits = d4;
            if (d3 == Double.POSITIVE_INFINITY) {
                this.storedPermits = d4;
                return;
            }
            double d5 = 0.0d;
            if (d3 != 0.0d) {
                d5 = (this.storedPermits * d4) / d3;
            }
            this.storedPermits = d5;
        }

        public long storedPermitsToWaitTime(double d, double d2) {
            return 0;
        }
    }

    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j, TimeUnit timeUnit, double d) {
            super(sleepingStopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(j);
            this.coldFactor = d;
        }

        private double permitsToTime(double d) {
            return this.stableIntervalMicros + (d * this.slope);
        }

        public double coolDownIntervalMicros() {
            return ((double) this.warmupPeriodMicros) / this.maxPermits;
        }

        public void doSetRate(double d, double d2) {
            double d3 = this.maxPermits;
            double d4 = this.coldFactor * d2;
            long j = this.warmupPeriodMicros;
            double d5 = (((double) j) * 0.5d) / d2;
            this.thresholdPermits = d5;
            double d6 = ((((double) j) * 2.0d) / (d2 + d4)) + d5;
            this.maxPermits = d6;
            this.slope = (d4 - d2) / (d6 - d5);
            if (d3 == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
                return;
            }
            if (d3 != 0.0d) {
                d6 = (this.storedPermits * d6) / d3;
            }
            this.storedPermits = d6;
        }

        public long storedPermitsToWaitTime(double d, double d2) {
            long j;
            double d3 = d - this.thresholdPermits;
            if (d3 > 0.0d) {
                double min = Math.min(d3, d2);
                j = (long) (((permitsToTime(d3) + permitsToTime(d3 - min)) * min) / 2.0d);
                d2 -= min;
            } else {
                j = 0;
            }
            return j + ((long) (this.stableIntervalMicros * d2));
        }
    }

    public abstract double coolDownIntervalMicros();

    public final double doGetRate() {
        return ((double) TimeUnit.SECONDS.toMicros(1)) / this.stableIntervalMicros;
    }

    public abstract void doSetRate(double d, double d2);

    public final void doSetRate(double d, long j) {
        resync(j);
        double micros = ((double) TimeUnit.SECONDS.toMicros(1)) / d;
        this.stableIntervalMicros = micros;
        doSetRate(d, micros);
    }

    public final long queryEarliestAvailable(long j) {
        return this.nextFreeTicketMicros;
    }

    public final long reserveEarliestAvailable(int i, long j) {
        resync(j);
        long j2 = this.nextFreeTicketMicros;
        double d = (double) i;
        double min = Math.min(d, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, min) + ((long) ((d - min) * this.stableIntervalMicros)));
        this.storedPermits -= min;
        return j2;
    }

    public void resync(long j) {
        long j2 = this.nextFreeTicketMicros;
        if (j > j2) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (((double) (j - j2)) / coolDownIntervalMicros()));
            this.nextFreeTicketMicros = j;
        }
    }

    public abstract long storedPermitsToWaitTime(double d, double d2);

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0;
    }
}
