package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import java.util.List;

public final class UsageStats {
    @NonNull
    public Feature feature;
    @NonNull
    public List<NetworkStats> networkStats;

    public enum Feature {
        DETAILED_RENDERING(0),
        EV_RENDERING(1),
        EV_SEARCH(2),
        INTEROP(3),
        NAVIGATION(4),
        PLACES(5),
        RDS_TRAFFIC(6),
        RENDERING(7),
        ROUTER(8),
        ROUTING(9),
        SATELLITES(10),
        SEARCH(11),
        SEARCH_ONLINE(12),
        TRANSIT(13),
        TRANSIT_ROUTING_ENGINE(14),
        TRAFFIC(15),
        TRAFFIC_VECTOR_TILES(16),
        TRUCK(17),
        VECTOR_TILES(18),
        OTHER(19);
        
        public final int value;

        private Feature(int i) {
            this.value = i;
        }
    }

    public static final class MethodNames {
        public static final String ANALYTICS = "analytics";
        public static final String AUTHENTICATION = "authentication";
        public static final String CALCULATE_ROUTE = "calculateRoute";
        public static final String CALCULATE_ROUTE_WITH_TRAFFIC = "calculateRouteWithTraffic";
        public static final String CALCULATE_TRANSIT_ROUTE = "calculateTransitRoute";
        public static final String DEFAULT_NETWORK_CALL = "networkCall";
        public static final String MAP_CONTENT = "mapContent";
        public static final String SEARCH_METHOD = "search";
        public static final String TRAFFIC_FETCH_INCIDENTS = "fetchIncidents";
    }

    public static final class NetworkStats {
        @NonNull
        public String methodCall;
        public long receivedBytes;
        public long requestCounter;
        public long sentBytes;

        public NetworkStats(long j, long j2, @NonNull String str, long j3) {
            this.sentBytes = j;
            this.receivedBytes = j2;
            this.methodCall = str;
            this.requestCounter = j3;
        }
    }

    public UsageStats(@NonNull List<NetworkStats> list, @NonNull Feature feature2) {
        this.networkStats = list;
        this.feature = feature2;
    }
}
