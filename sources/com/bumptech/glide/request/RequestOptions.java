package com.bumptech.glide.request;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    public static RequestOptions n0(Class cls) {
        return (RequestOptions) new RequestOptions().g(cls);
    }

    public static RequestOptions o0(DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().h(diskCacheStrategy);
    }

    public static RequestOptions p0(Key key) {
        return (RequestOptions) new RequestOptions().d0(key);
    }

    public boolean equals(Object obj) {
        return (obj instanceof RequestOptions) && super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
