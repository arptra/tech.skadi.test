package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataRewinderRegistry {
    public static final DataRewinder.Factory b = new DataRewinder.Factory<Object>() {
        public Class a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public DataRewinder b(Object obj) {
            return new DefaultRewinder(obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final Map f2455a = new HashMap();

    public static final class DefaultRewinder implements DataRewinder<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f2456a;

        public DefaultRewinder(Object obj) {
            this.f2456a = obj;
        }

        public Object a() {
            return this.f2456a;
        }

        public void b() {
        }
    }

    public synchronized DataRewinder a(Object obj) {
        DataRewinder.Factory factory;
        try {
            Preconditions.d(obj);
            factory = (DataRewinder.Factory) this.f2455a.get(obj.getClass());
            if (factory == null) {
                Iterator it = this.f2455a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DataRewinder.Factory factory2 = (DataRewinder.Factory) it.next();
                    if (factory2.a().isAssignableFrom(obj.getClass())) {
                        factory = factory2;
                        break;
                    }
                }
            }
            if (factory == null) {
                factory = b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return factory.b(obj);
    }

    public synchronized void b(DataRewinder.Factory factory) {
        this.f2455a.put(factory.a(), factory);
    }
}
