package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;

@Deprecated
public abstract class ExperimentalRequestListener<ResourceT> implements RequestListener<ResourceT> {
    public void a(Object obj) {
    }

    public abstract boolean c(Object obj, Object obj2, Target target, DataSource dataSource, boolean z, boolean z2);
}
