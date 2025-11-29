package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List f2698a = new ArrayList();

    public static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class f2699a;
        public final Encoder b;

        public Entry(Class cls, Encoder encoder) {
            this.f2699a = cls;
            this.b = encoder;
        }

        public boolean a(Class cls) {
            return this.f2699a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, Encoder encoder) {
        this.f2698a.add(new Entry(cls, encoder));
    }

    public synchronized Encoder b(Class cls) {
        for (Entry entry : this.f2698a) {
            if (entry.a(cls)) {
                return entry.b;
            }
        }
        return null;
    }
}
