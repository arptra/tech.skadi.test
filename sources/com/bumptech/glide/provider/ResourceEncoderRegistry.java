package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List f2705a = new ArrayList();

    public static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class f2706a;
        public final ResourceEncoder b;

        public Entry(Class cls, ResourceEncoder resourceEncoder) {
            this.f2706a = cls;
            this.b = resourceEncoder;
        }

        public boolean a(Class cls) {
            return this.f2706a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, ResourceEncoder resourceEncoder) {
        this.f2705a.add(new Entry(cls, resourceEncoder));
    }

    public synchronized ResourceEncoder b(Class cls) {
        int size = this.f2705a.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) this.f2705a.get(i);
            if (entry.a(cls)) {
                return entry.b;
            }
        }
        return null;
    }
}
