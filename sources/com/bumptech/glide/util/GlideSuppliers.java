package com.bumptech.glide.util;

public final class GlideSuppliers {

    public interface GlideSupplier<T> {
        Object get();
    }

    public static GlideSupplier a(final GlideSupplier glideSupplier) {
        return new GlideSupplier<Object>() {

            /* renamed from: a  reason: collision with root package name */
            public volatile Object f2743a;

            public Object get() {
                if (this.f2743a == null) {
                    synchronized (this) {
                        try {
                            if (this.f2743a == null) {
                                this.f2743a = Preconditions.d(GlideSupplier.this.get());
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return this.f2743a;
            }
        };
    }
}
