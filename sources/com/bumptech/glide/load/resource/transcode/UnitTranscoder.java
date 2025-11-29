package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {

    /* renamed from: a  reason: collision with root package name */
    public static final UnitTranscoder f2673a = new UnitTranscoder();

    public static ResourceTranscoder b() {
        return f2673a;
    }

    public Resource a(Resource resource, Options options) {
        return resource;
    }
}
