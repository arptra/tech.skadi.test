package com.upuphone.xr.interconnect.util;

import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ax\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0005*\u0002H\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00050\b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001ax\u0010\u0010\u001a\u00020\n\"\u0004\b\u0000\u0010\u0006*\u0002H\u00062\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0019\b\u0004\u0010\r\u001a\u0013\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a6\u0010\u0010\u001a\u00020\n\"\u0004\b\u0000\u0010\u0006*\u0002H\u00062\u0006\u0010\u0012\u001a\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0013\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "safeAlienCall", "T", "I", "logv", "Lkotlin/Function1;", "", "", "logw", "loge", "action", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "threadSafeAlienCall", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "logTag", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Shared_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAlienCallExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt\n*L\n1#1,46:1\n16#1,4:47\n*S KotlinDebug\n*F\n+ 1 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt\n*L\n24#1:47,4\n*E\n"})
public final class AlienCallExtKt {
    @NotNull
    private static final CoroutineScope mainScope = CoroutineScopeKt.b();

    @NotNull
    public static final CoroutineScope getMainScope() {
        return mainScope;
    }

    @Nullable
    public static final <I, T> T safeAlienCall(I i, @NotNull Function1<? super String, Unit> function1, @NotNull Function1<? super String, Unit> function12, @NotNull Function1<? super String, Unit> function13, @NotNull Function1<? super I, ? extends T> function14) {
        Intrinsics.checkNotNullParameter(function1, "logv");
        Intrinsics.checkNotNullParameter(function12, "logw");
        Intrinsics.checkNotNullParameter(function13, "loge");
        Intrinsics.checkNotNullParameter(function14, WebJs.ACTION);
        T t = null;
        try {
            t = function14.invoke(i);
            InlineMarker.finallyStart(1);
        } catch (RuntimeException e) {
            function12.invoke("Alien call failed because of: " + e.getLocalizedMessage() + '.');
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            function1.invoke("Alien code invoked.");
            InlineMarker.finallyEnd(1);
            throw th;
        }
        function1.invoke("Alien code invoked.");
        InlineMarker.finallyEnd(1);
        return t;
    }

    public static final <I> void threadSafeAlienCall(I i, @NotNull Function1<? super String, Unit> function1, @NotNull Function1<? super String, Unit> function12, @NotNull Function1<? super String, Unit> function13, @NotNull Function1<? super I, Unit> function14) {
        Intrinsics.checkNotNullParameter(function1, "logv");
        Intrinsics.checkNotNullParameter(function12, "logw");
        Intrinsics.checkNotNullParameter(function13, "loge");
        Intrinsics.checkNotNullParameter(function14, WebJs.ACTION);
        Job unused = BuildersKt__Builders_commonKt.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new AlienCallExtKt$threadSafeAlienCall$1(i, function1, function12, function13, function14, (Continuation<? super AlienCallExtKt$threadSafeAlienCall$1>) null), 3, (Object) null);
    }

    public static final <I> void threadSafeAlienCall(I i, @NotNull String str, @NotNull Function1<? super I, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        Job unused = BuildersKt__Builders_commonKt.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new AlienCallExtKt$threadSafeAlienCall$$inlined$threadSafeAlienCall$1(i, function1, (Continuation) null, str, str, str), 3, (Object) null);
    }
}
