package com.bumptech.glide.util;

import java.util.concurrent.Executor;

public final class Executors {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f2741a = new Executor() {
        public void execute(Runnable runnable) {
            Util.w(runnable);
        }
    };
    public static final Executor b = new Executor() {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    public static Executor a() {
        return b;
    }

    public static Executor b() {
        return f2741a;
    }
}
