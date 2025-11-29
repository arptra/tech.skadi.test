package com.here.sdk.trafficbroadcast;

import androidx.annotation.NonNull;
import java.util.List;

public final class TMCData {
    @NonNull
    public List<Integer> additionalEvents;
    @NonNull
    public List<Long> additionalLocations;
    public short direction;
    public short diversionAdvice;
    public short durationPersistence;
    public int event;
    public short extent;
    public long location;
    public short numberOfGroups;

    public TMCData(short s, short s2, short s3, short s4, short s5, int i, long j, @NonNull List<Integer> list, @NonNull List<Long> list2) {
        this.numberOfGroups = s;
        this.extent = s2;
        this.direction = s3;
        this.diversionAdvice = s4;
        this.durationPersistence = s5;
        this.event = i;
        this.location = j;
        this.additionalEvents = list;
        this.additionalLocations = list2;
    }
}
