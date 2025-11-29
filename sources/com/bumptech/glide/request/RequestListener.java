package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

public interface RequestListener<R> {
    boolean b(GlideException glideException, Object obj, Target target, boolean z);

    boolean f(Object obj, Object obj2, Target target, DataSource dataSource, boolean z);
}
