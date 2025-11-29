package com.here.odnp.gnss;

public class GnssObservationHeader {
    public double biasNanos;
    public double biasNanosUncertainty;
    public boolean carrierPhaseMeasurements;
    public boolean deltaRangeCycleSlips;
    public double driftNanosPerSecond;
    public double driftNanosPerSecondUncertainty;
    public boolean dualBandMeasurements;
    public long elapsedRealtimeNanos;
    public long fullBiasNanos;
    public boolean fullGnssMeasurements;
    public boolean hasBiasNanos;
    public boolean hasBiasNanosUncertainty;
    public boolean hasDriftNanosPerSecond;
    public boolean hasDriftNanosPerSecondUncertainty;
    public boolean hasFullBiasNanos;
    public boolean hasLeapSecond;
    public boolean hasTimeNanosUncertainty;
    public int hwClockDiscontinuityCount;
    public int leapSecond;
    public long timeNanos;
    public double timeNanosUncertainty;
}
