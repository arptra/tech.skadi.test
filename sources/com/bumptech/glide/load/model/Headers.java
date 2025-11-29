package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

public interface Headers {

    /* renamed from: a  reason: collision with root package name */
    public static final Headers f2564a = new Headers() {
        public Map a() {
            return Collections.emptyMap();
        }
    };
    public static final Headers b = new LazyHeaders.Builder().a();

    Map a();
}
