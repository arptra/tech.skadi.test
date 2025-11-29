package com.here.services.playback.internal.util;

import android.location.Location;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.CellMeasurement;
import java.io.Reader;
import java.util.List;

public interface IPullParser {
    public static final long INVALID_TIMESTAMP_VALUE = Long.MIN_VALUE;
    public static final String KEY_MEASUREMENT_ID = "com.here.services.location:measurementId";

    public interface IListener {
        void pushCell(long j, CellMeasurement cellMeasurement);

        void pushGnss(long j, Location location);

        void pushWifi(long j, IWifiManager.WifiScanResultContainer wifiScanResultContainer);
    }

    public static abstract class Measurement {
        private final long mDueAt;
        private final long mId;
        private final long mTimeStamp;
        private final Type mType;

        public enum Type {
            Cell,
            Gnss,
            Wifi
        }

        public Measurement(Type type, long j, long j2, long j3) {
            this.mType = type;
            this.mTimeStamp = j;
            this.mDueAt = j2;
            this.mId = j3;
        }

        public abstract void dispatch(IListener iListener);

        public long getDueAt() {
            return this.mDueAt;
        }

        public long getId() {
            return this.mId;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }

        public Type getType() {
            return this.mType;
        }
    }

    boolean isEof();

    List<Measurement> pullNextMeasurements();

    void setInput(Reader reader) throws Exception;
}
