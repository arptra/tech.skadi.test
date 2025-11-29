package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

public interface ResourceDecoder<T, Z> {
    boolean a(Object obj, Options options);

    Resource b(Object obj, int i, int i2, Options options);
}
