package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.List;

public class TranscoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List f2671a = new ArrayList();

    public static final class Entry<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class f2672a;
        public final Class b;
        public final ResourceTranscoder c;

        public Entry(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
            this.f2672a = cls;
            this.b = cls2;
            this.c = resourceTranscoder;
        }

        public boolean a(Class cls, Class cls2) {
            return this.f2672a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized ResourceTranscoder a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.b();
        }
        for (Entry entry : this.f2671a) {
            if (entry.a(cls, cls2)) {
                return entry.c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (Entry entry : this.f2671a) {
            if (entry.a(cls, cls2) && !arrayList.contains(entry.b)) {
                arrayList.add(entry.b);
            }
        }
        return arrayList;
    }

    public synchronized void c(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
        this.f2671a.add(new Entry(cls, cls2, resourceTranscoder));
    }
}
