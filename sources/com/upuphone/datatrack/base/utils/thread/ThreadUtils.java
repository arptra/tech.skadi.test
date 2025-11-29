package com.upuphone.datatrack.base.utils.thread;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/datatrack/base/utils/thread/ThreadUtils;", "", "<init>", "()V", "Ljava/lang/Runnable;", "runnable", "", "a", "(Ljava/lang/Runnable;)V", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
public final class ThreadUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadUtils f6405a = new ThreadUtils();

    public static final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new ThreadUtils$doInBackground$1(runnable, (Continuation<? super ThreadUtils$doInBackground$1>) null), 3, (Object) null);
    }
}
