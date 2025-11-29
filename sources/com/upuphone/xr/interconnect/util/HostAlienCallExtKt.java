package com.upuphone.xr.interconnect.util;

import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0000¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"safeAlienCall", "T", "I", "logTag", "", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHostAlienCallExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HostAlienCallExt.kt\ncom/upuphone/xr/interconnect/util/HostAlienCallExtKt\n+ 2 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt\n*L\n1#1,11:1\n34#2,11:12\n*S KotlinDebug\n*F\n+ 1 HostAlienCallExt.kt\ncom/upuphone/xr/interconnect/util/HostAlienCallExtKt\n*L\n5#1:12,11\n*E\n"})
public final class HostAlienCallExtKt {
    @Nullable
    public static final <I, T> T safeAlienCall(I i, @NotNull String str, @NotNull Function1<? super I, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        T t = null;
        try {
            t = function1.invoke(i);
        } catch (RuntimeException e) {
            ILog.w(str, "Alien call failed because of: " + e.getLocalizedMessage() + '.');
        } catch (Throwable th) {
            ILog.v(str, "Alien code invoked.");
            throw th;
        }
        ILog.v(str, "Alien code invoked.");
        return t;
    }
}
