package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1216a;

    public /* synthetic */ a(String str) {
        this.f1216a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.c(this.f1216a, runnable);
    }
}
