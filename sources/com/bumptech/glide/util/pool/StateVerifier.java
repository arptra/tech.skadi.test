package com.bumptech.glide.util.pool;

public abstract class StateVerifier {

    public static class DebugStateVerifier extends StateVerifier {

        /* renamed from: a  reason: collision with root package name */
        public volatile RuntimeException f2754a;

        public void b(boolean z) {
            if (z) {
                this.f2754a = new RuntimeException("Released");
            } else {
                this.f2754a = null;
            }
        }

        public void c() {
            if (this.f2754a != null) {
                throw new IllegalStateException("Already released", this.f2754a);
            }
        }
    }

    public static class DefaultStateVerifier extends StateVerifier {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f2755a;

        public DefaultStateVerifier() {
            super();
        }

        public void b(boolean z) {
            this.f2755a = z;
        }

        public void c() {
            if (this.f2755a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static StateVerifier a() {
        return new DefaultStateVerifier();
    }

    public abstract void b(boolean z);

    public abstract void c();

    public StateVerifier() {
    }
}
