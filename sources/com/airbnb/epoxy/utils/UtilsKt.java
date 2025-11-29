package com.airbnb.epoxy.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00008@X\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "", "a", "(Landroid/content/Context;)Z", "isDebuggable$annotations", "(Landroid/content/Context;)V", "isDebuggable", "epoxy-adapter_release"}, k = 2, mv = {1, 8, 0})
public final class UtilsKt {
    public static final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
