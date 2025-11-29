package com.here.posclient;

import com.here.services.radiomap.common.GeoArea;

public class RadioMapManager {
    public static final long RM_REQUEST_FLAG_CLEAR_ALL = 2;
    public static final long RM_REQUEST_FLAG_NONE = 0;
    public static final long RM_REQUEST_FLAG_UPDATE_OLD_ONLY = 1;
    public static final int RM_TECH_2G = 1;
    public static final int RM_TECH_3G_FDD = 2;
    public static final int RM_TECH_3G_TDD = 4;
    public static final int RM_TECH_4G = 8;
    public static final int RM_TECH_ALL_CELL = 15;
    public static final int RM_TECH_ALL_HDWIFI = 6144;
    public static final int RM_TECH_ALL_WIFI = 48;
    public static final int RM_TECH_HDWIFI_COVERAGE = 4096;
    public static final int RM_TECH_HDWIFI_LOCATION = 2048;
    public static final int RM_TECH_HIGH_ACCURACY = 1024;
    public static final int RM_TECH_NONE = 0;
    public static final int RM_TECH_WIFI_COARSE = 16;
    public static final int RM_TECH_WIFI_DETAILED = 32;

    public interface IRadioMapStorageActionListener {
        void onClosed();

        void onRadioMapActionProgress(int i);

        void onRadioMapQueryActionComplete(int i, long j);

        void onRadioMapStorageActionComplete(int i);
    }

    public interface NetworkConnectionType {
        public static final long CONNTYPE_ALL = 15;
        public static final long CONNTYPE_ETHERNET = 4;
        public static final long CONNTYPE_MOBILE = 2;
        public static final long CONNTYPE_OTHER = 8;
        public static final long CONNTYPE_WIFI = 1;
    }

    public static class Options {
        public final long allowedNetworkTypes;
        public final long flags;
        public final int technologies;

        public Options(int i, long j) {
            this(1, i, j);
        }

        public Options(long j, int i) {
            this(j, i, 0);
        }

        public Options(long j, int i, long j2) {
            this.allowedNetworkTypes = j;
            this.technologies = i;
            this.flags = j2;
        }
    }

    public enum RadioMapQueryAction {
        LOCAL_SIZE,
        EXTENDED_SIZE,
        UPDATED_SIZE
    }

    public enum RadioMapStorageAction {
        CLEAR,
        EXTEND,
        UPDATE
    }

    public static native boolean startRadioMapQuery(GeoArea[] geoAreaArr, RadioMapQueryAction radioMapQueryAction, Options options, IRadioMapStorageActionListener iRadioMapStorageActionListener);

    public static native void stopRadioMapAction(IRadioMapStorageActionListener iRadioMapStorageActionListener);

    public static native boolean updateRadioMapCoverage(GeoArea[] geoAreaArr, RadioMapStorageAction radioMapStorageAction, Options options, IRadioMapStorageActionListener iRadioMapStorageActionListener);
}
