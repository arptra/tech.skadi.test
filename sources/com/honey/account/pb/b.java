package com.honey.account.pb;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3685a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ b(String str, boolean z) {
        this.f3685a = str;
        this.b = z;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.threadFactory$lambda$1(this.f3685a, this.b, runnable);
    }
}
