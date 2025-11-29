package com.upuphone.xr.sapp.utils;

import android.content.Context;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "", "text", "", "duration", "", "c", "(Landroid/content/Context;Ljava/lang/CharSequence;I)V", "resId", "b", "(Landroid/content/Context;II)V", "d", "(Ljava/lang/CharSequence;I)V", "a", "(II)V", "lib_common_release"}, k = 2, mv = {1, 9, 0})
public final class ContextExtKt {
    public static final void a(int i, int i2) {
        b(SdkContext.f6675a.c().getContext(), i, i2);
    }

    public static final void b(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.c().getImmediate(), (CoroutineStart) null, new ContextExtKt$showToast$2(context, i, i2, (Continuation<? super ContextExtKt$showToast$2>) null), 2, (Object) null);
    }

    public static final void c(Context context, CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.c().getImmediate(), (CoroutineStart) null, new ContextExtKt$showToast$1(context, charSequence, i, (Continuation<? super ContextExtKt$showToast$1>) null), 2, (Object) null);
    }

    public static final void d(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        c(SdkContext.f6675a.c().getContext(), charSequence, i);
    }

    public static /* synthetic */ void e(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        a(i, i2);
    }

    public static /* synthetic */ void f(Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        b(context, i, i2);
    }

    public static /* synthetic */ void g(Context context, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        c(context, charSequence, i);
    }

    public static /* synthetic */ void h(CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        d(charSequence, i);
    }
}
