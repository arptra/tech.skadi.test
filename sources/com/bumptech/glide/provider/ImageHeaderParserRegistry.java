package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

public final class ImageHeaderParserRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List f2700a = new ArrayList();

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f2700a.add(imageHeaderParser);
    }

    public synchronized List b() {
        return this.f2700a;
    }
}
