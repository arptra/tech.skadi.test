package com.luck.picture.lib.obj.pool;

import java.util.LinkedList;

public final class ObjectPools {

    public interface Pool<T> {
    }

    public static class SimpleObjectPool<T> implements Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList f9438a = new LinkedList();

        public Object a() {
            return this.f9438a.poll();
        }

        public void b() {
            this.f9438a.clear();
        }

        public final boolean c(Object obj) {
            return this.f9438a.contains(obj);
        }

        public boolean d(Object obj) {
            if (c(obj)) {
                return false;
            }
            return this.f9438a.add(obj);
        }
    }

    public static class SynchronizedPool<T> extends SimpleObjectPool<T> {
        public final Object b = new Object();

        public Object a() {
            Object a2;
            synchronized (this.b) {
                a2 = super.a();
            }
            return a2;
        }

        public void b() {
            synchronized (this.b) {
                super.b();
            }
        }

        public boolean d(Object obj) {
            boolean d;
            synchronized (this.b) {
                d = super.d(obj);
            }
            return d;
        }
    }
}
