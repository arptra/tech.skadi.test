package com.here.sdk.trafficbroadcast;

interface DecodingEventsListener {
    void onDecodingFailed();

    void onDecodingSucceeded();
}
