package com.sina.weibo.sdk;

import java.util.HashMap;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f9977a = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final f0 f9978a = new f0();
    }

    public static synchronized f0 a() {
        f0 f0Var;
        synchronized (f0.class) {
            f0Var = a.f9978a;
        }
        return f0Var;
    }
}
