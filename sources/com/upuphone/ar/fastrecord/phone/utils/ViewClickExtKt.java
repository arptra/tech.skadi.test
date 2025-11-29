package com.upuphone.ar.fastrecord.phone.utils;

import android.view.View;
import com.honey.account.c4.e;
import com.honey.account.c4.f;
import com.honey.account.c4.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0002\u001a(\u0010\u0011\u001a\u00020\u0012*\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0015\u001a\u001e\u0010\u0016\u001a\u00020\u0012*\u00020\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0015\u001a(\u0010\u0017\u001a\u00020\u0012*\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"(\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00018B@BX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\"(\u0010\f\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00018B@BX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"DEFAULT_CLICK_INTERVAL_TIME", "", "TIME_TAG_KEY_TRIGGER_DELAY", "", "TIME_TAG_KEY_TRIGGER_LAST", "value", "triggerDelay", "Landroid/view/View;", "getTriggerDelay", "(Landroid/view/View;)J", "setTriggerDelay", "(Landroid/view/View;J)V", "triggerLastTime", "getTriggerLastTime", "setTriggerLastTime", "clickEnable", "", "clickJitter", "", "time", "block", "Lkotlin/Function1;", "clickJitterLong", "recyclerClickJitter", "ar-fastrecord_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ViewClickExtKt {
    public static final long DEFAULT_CLICK_INTERVAL_TIME = 200;
    public static final int TIME_TAG_KEY_TRIGGER_DELAY = 1111111112;
    public static final int TIME_TAG_KEY_TRIGGER_LAST = 1111111111;

    private static final boolean clickEnable(View view) {
        boolean z = System.currentTimeMillis() - getTriggerLastTime(view) >= getTriggerDelay(view);
        if (z) {
            setTriggerLastTime(view, System.currentTimeMillis());
        }
        return z;
    }

    public static final void clickJitter(@NotNull View view, long j, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        setTriggerDelay(view, j);
        view.setOnClickListener(new g(view, function1));
    }

    public static /* synthetic */ void clickJitter$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        clickJitter(view, j, function1);
    }

    /* access modifiers changed from: private */
    public static final void clickJitter$lambda$0(View view, Function1 function1, View view2) {
        Intrinsics.checkNotNullParameter(view, "$this_clickJitter");
        Intrinsics.checkNotNullParameter(function1, "$block");
        if (clickEnable(view)) {
            Intrinsics.checkNotNull(view2);
            function1.invoke(view2);
        }
    }

    public static final void clickJitterLong(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        view.setOnLongClickListener(new e(function1));
    }

    /* access modifiers changed from: private */
    public static final boolean clickJitterLong$lambda$1(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$block");
        Intrinsics.checkNotNull(view);
        function1.invoke(view);
        return true;
    }

    private static final long getTriggerDelay(View view) {
        if (view.getTag(TIME_TAG_KEY_TRIGGER_DELAY) == null) {
            return 500;
        }
        Object tag = view.getTag(TIME_TAG_KEY_TRIGGER_DELAY);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) tag).longValue();
    }

    private static final long getTriggerLastTime(View view) {
        if (view.getTag(TIME_TAG_KEY_TRIGGER_LAST) == null) {
            return 0;
        }
        Object tag = view.getTag(TIME_TAG_KEY_TRIGGER_LAST);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) tag).longValue();
    }

    public static final void recyclerClickJitter(@NotNull View view, long j, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        setTriggerDelay(view, j);
        if (!view.hasOnClickListeners()) {
            view.setOnClickListener(new f(view, function1));
        }
    }

    public static /* synthetic */ void recyclerClickJitter$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        recyclerClickJitter(view, j, function1);
    }

    /* access modifiers changed from: private */
    public static final void recyclerClickJitter$lambda$2(View view, Function1 function1, View view2) {
        Intrinsics.checkNotNullParameter(view, "$this_recyclerClickJitter");
        Intrinsics.checkNotNullParameter(function1, "$block");
        if (clickEnable(view)) {
            Intrinsics.checkNotNull(view2);
            function1.invoke(view2);
        }
    }

    private static final void setTriggerDelay(View view, long j) {
        view.setTag(TIME_TAG_KEY_TRIGGER_DELAY, Long.valueOf(j));
    }

    private static final void setTriggerLastTime(View view, long j) {
        view.setTag(TIME_TAG_KEY_TRIGGER_LAST, Long.valueOf(j));
    }
}
