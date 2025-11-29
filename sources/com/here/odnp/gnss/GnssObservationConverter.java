package com.here.odnp.gnss;

import android.location.GnssClock;
import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.here.odnp.util.Log;
import java.util.Collection;

public final class GnssObservationConverter {
    private static final String TAG = "com.here.odnp.posclient.GnssObservationConverter";
    private static boolean mCarrierPhaseMeasurements;
    private static boolean mDeltaRangeCycleSlips;
    private static boolean mDualBandMeasurements;
    private static final float[] mFirstDetectedCarrierFreq = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    private GnssObservationConverter() {
    }

    @NonNull
    public static GnssObservationData createObservationData(@NonNull GnssMeasurement gnssMeasurement) {
        GnssObservationData gnssObservationData = new GnssObservationData();
        gnssObservationData.svId = gnssMeasurement.getSvid();
        gnssObservationData.constellationType = gnssMeasurement.getConstellationType();
        gnssObservationData.state = gnssMeasurement.getState();
        gnssObservationData.timeOffsetNanos = gnssMeasurement.getTimeOffsetNanos();
        gnssObservationData.receivedSvTimeNanos = gnssMeasurement.getReceivedSvTimeNanos();
        gnssObservationData.receivedSvTimeNanosUncertainty = gnssMeasurement.getReceivedSvTimeUncertaintyNanos();
        int accumulatedDeltaRangeState = gnssMeasurement.getAccumulatedDeltaRangeState();
        gnssObservationData.accumulatedDeltaRangeState = accumulatedDeltaRangeState;
        if (accumulatedDeltaRangeState != 0) {
            mCarrierPhaseMeasurements = true;
            if ((accumulatedDeltaRangeState & 4) != 0) {
                Log.d(TAG, "createObservationData: cycle slip in constellation %d, svId %d", Integer.valueOf(gnssObservationData.constellationType), Integer.valueOf(gnssObservationData.svId));
                mDeltaRangeCycleSlips = true;
            }
            if ((gnssObservationData.accumulatedDeltaRangeState & 2) != 0) {
                Log.d(TAG, "createObservationData: delta range reset in constellation %d, svId %d", Integer.valueOf(gnssObservationData.constellationType), Integer.valueOf(gnssObservationData.svId));
                mDeltaRangeCycleSlips = true;
            }
            gnssObservationData.accumulatedDeltaRangeMeters = gnssMeasurement.getAccumulatedDeltaRangeMeters();
            gnssObservationData.accumulatedDeltaRangeMetersUncertainty = gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters();
        } else {
            gnssObservationData.accumulatedDeltaRangeMeters = 0.0d;
            gnssObservationData.accumulatedDeltaRangeMetersUncertainty = 0.0d;
        }
        gnssObservationData.hasAutomaticGainControlLevelDb = gnssMeasurement.hasAutomaticGainControlLevelDb();
        gnssObservationData.automaticGainControlLevelDb = gnssMeasurement.getAutomaticGainControlLevelDb();
        gnssObservationData.hasCarrierFrequencyHz = gnssMeasurement.hasCarrierFrequencyHz();
        gnssObservationData.carrierFrequencyHz = gnssMeasurement.getCarrierFrequencyHz();
        gnssObservationData.cn0DbHz = gnssMeasurement.getCn0DbHz();
        gnssObservationData.pseudorangeRateMetersPerSecond = gnssMeasurement.getPseudorangeRateMetersPerSecond();
        gnssObservationData.pseudorangeRateMetersPerSecondUncertainty = gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond();
        int multipathIndicator = gnssMeasurement.getMultipathIndicator();
        gnssObservationData.multipathIndicator = multipathIndicator;
        if (multipathIndicator == 1) {
            Log.d(TAG, "createObservationData: measurement shows signs of multi-path, constellation %d, svId %d", Integer.valueOf(gnssObservationData.constellationType), Integer.valueOf(gnssObservationData.svId));
        }
        gnssObservationData.hasSnrInDb = gnssMeasurement.hasSnrInDb();
        gnssObservationData.snrInDb = gnssMeasurement.getSnrInDb();
        if (gnssObservationData.hasCarrierFrequencyHz) {
            updateDualBandSupportedInfo(gnssObservationData.constellationType, gnssObservationData.carrierFrequencyHz);
        }
        return gnssObservationData;
    }

    @NonNull
    public static GnssObservationData[] createObservationDataArray(@NonNull GnssMeasurementsEvent gnssMeasurementsEvent) {
        Collection<GnssMeasurement> measurements = gnssMeasurementsEvent.getMeasurements();
        GnssObservationData[] gnssObservationDataArr = new GnssObservationData[measurements.size()];
        int i = 0;
        for (GnssMeasurement createObservationData : measurements) {
            gnssObservationDataArr[i] = createObservationData(createObservationData);
            i++;
        }
        return gnssObservationDataArr;
    }

    @NonNull
    public static GnssObservationHeader createObservationHeader(@NonNull GnssMeasurementsEvent gnssMeasurementsEvent) {
        GnssClock clock = gnssMeasurementsEvent.getClock();
        GnssObservationHeader gnssObservationHeader = new GnssObservationHeader();
        gnssObservationHeader.timeNanos = clock.getTimeNanos();
        boolean hasTimeUncertaintyNanos = clock.hasTimeUncertaintyNanos();
        gnssObservationHeader.hasTimeNanosUncertainty = hasTimeUncertaintyNanos;
        double d = 0.0d;
        gnssObservationHeader.timeNanosUncertainty = hasTimeUncertaintyNanos ? clock.getTimeUncertaintyNanos() : 0.0d;
        boolean hasLeapSecond = clock.hasLeapSecond();
        gnssObservationHeader.hasLeapSecond = hasLeapSecond;
        gnssObservationHeader.leapSecond = hasLeapSecond ? clock.getLeapSecond() : 0;
        boolean hasBiasNanos = clock.hasBiasNanos();
        gnssObservationHeader.hasBiasNanos = hasBiasNanos;
        gnssObservationHeader.biasNanos = hasBiasNanos ? clock.getBiasNanos() : 0.0d;
        boolean hasBiasUncertaintyNanos = clock.hasBiasUncertaintyNanos();
        gnssObservationHeader.hasBiasNanosUncertainty = hasBiasUncertaintyNanos;
        gnssObservationHeader.biasNanosUncertainty = hasBiasUncertaintyNanos ? clock.getBiasUncertaintyNanos() : 0.0d;
        boolean hasFullBiasNanos = clock.hasFullBiasNanos();
        gnssObservationHeader.hasFullBiasNanos = hasFullBiasNanos;
        gnssObservationHeader.fullBiasNanos = hasFullBiasNanos ? clock.getFullBiasNanos() : 0;
        boolean hasDriftNanosPerSecond = clock.hasDriftNanosPerSecond();
        gnssObservationHeader.hasDriftNanosPerSecond = hasDriftNanosPerSecond;
        gnssObservationHeader.driftNanosPerSecond = hasDriftNanosPerSecond ? clock.getDriftNanosPerSecond() : 0.0d;
        boolean hasDriftUncertaintyNanosPerSecond = clock.hasDriftUncertaintyNanosPerSecond();
        gnssObservationHeader.hasDriftNanosPerSecondUncertainty = hasDriftUncertaintyNanosPerSecond;
        if (hasDriftUncertaintyNanosPerSecond) {
            d = clock.getDriftUncertaintyNanosPerSecond();
        }
        gnssObservationHeader.driftNanosPerSecondUncertainty = d;
        gnssObservationHeader.hwClockDiscontinuityCount = clock.getHardwareClockDiscontinuityCount();
        int i = Build.VERSION.SDK_INT;
        if (clock.hasElapsedRealtimeNanos()) {
            gnssObservationHeader.elapsedRealtimeNanos = clock.getElapsedRealtimeNanos();
        } else {
            gnssObservationHeader.elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        }
        gnssObservationHeader.carrierPhaseMeasurements = mCarrierPhaseMeasurements;
        gnssObservationHeader.dualBandMeasurements = mDualBandMeasurements;
        gnssObservationHeader.deltaRangeCycleSlips = mDeltaRangeCycleSlips;
        if (i > 30) {
            gnssObservationHeader.fullGnssMeasurements = true;
        } else {
            gnssObservationHeader.fullGnssMeasurements = false;
        }
        return gnssObservationHeader;
    }

    public static void resetCapabilitiesChecks() {
        mCarrierPhaseMeasurements = false;
        mDualBandMeasurements = false;
        mDeltaRangeCycleSlips = false;
        for (int i = 0; i < 7; i++) {
            mFirstDetectedCarrierFreq[i] = 0.0f;
        }
    }

    private static void updateDualBandSupportedInfo(int i, float f) {
        if (i == 1 || i == 6 || i == 5) {
            float[] fArr = mFirstDetectedCarrierFreq;
            float f2 = fArr[i];
            if (f2 == 0.0f) {
                fArr[i] = f;
            } else if (f2 != f) {
                if (!mDualBandMeasurements) {
                    Log.v(TAG, "updateDualBandSupportedInfo", new Object[0]);
                    if (i == 1) {
                        Log.v(TAG, "constellationType is GPS", new Object[0]);
                    } else if (i == 6) {
                        Log.v(TAG, "constellationType is GALILEO", new Object[0]);
                    } else {
                        Log.v(TAG, "constellationType is BEIDOU", new Object[0]);
                    }
                    Log.v(TAG, "carrierFrequencyHz %f", Float.valueOf(f));
                    Log.v(TAG, "mFirstDetectedCarrierFreq[constellationType] %f", Float.valueOf(fArr[i]));
                }
                mDualBandMeasurements = true;
            }
        } else if (i == 3) {
            float[] fArr2 = mFirstDetectedCarrierFreq;
            float f3 = fArr2[i];
            if (f3 == 0.0f) {
                fArr2[i] = (float) ((int) (f / 1.4E7f));
                return;
            }
            float f4 = (float) ((int) (f / 1.4E7f));
            if (f3 != f4) {
                if (!mDualBandMeasurements) {
                    Log.v(TAG, "updateDualBandSupportedInfo", new Object[0]);
                    Log.v(TAG, "constellationType is Glonass", new Object[0]);
                    Log.v(TAG, "(int)(carrierFrequencyHz / 14MHz) %f", Float.valueOf(f4));
                    Log.v(TAG, "mFirstDetectedCarrierFreq[constellationType] %f", Float.valueOf(fArr2[i]));
                }
                mDualBandMeasurements = true;
            }
        }
    }
}
