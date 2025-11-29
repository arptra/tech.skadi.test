package com.here.sdk.mapview;

interface Function<From, To> {
    To apply(From from);
}
