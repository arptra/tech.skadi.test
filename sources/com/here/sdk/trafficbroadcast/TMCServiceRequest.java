package com.here.sdk.trafficbroadcast;

import androidx.annotation.NonNull;
import java.util.List;

public final class TMCServiceRequest {
    public short countryCode;
    @NonNull
    public List<Short> preferredSids;
    @NonNull
    public List<Short> supportedLtns;

    public TMCServiceRequest(short s, @NonNull List<Short> list, @NonNull List<Short> list2) {
        this.countryCode = s;
        this.preferredSids = list;
        this.supportedLtns = list2;
    }
}
