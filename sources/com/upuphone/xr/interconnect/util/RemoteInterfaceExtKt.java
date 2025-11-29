package com.upuphone.xr.interconnect.util;

import android.os.RemoteException;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\b\b¢\u0006\u0002\u0010\t\u001a8\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\b\bH\u0000¢\u0006\u0002\u0010\n\u001a>\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0006\u0010\u000b\u001a\u0002H\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\b\bH\u0000¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"safeRemoteCall", "T", "I", "warnLog", "Lkotlin/Function1;", "", "", "action", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Shared_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RemoteInterfaceExtKt {
    @Nullable
    public static final <I, T> T safeRemoteCall(I i, @NotNull Function1<? super I, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        return safeRemoteCall(i, (Object) null, function1);
    }

    public static final <I, T> T safeRemoteCall(I i, T t, @NotNull Function1<? super I, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        try {
            return function1.invoke(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return t;
        }
    }

    @Nullable
    public static final <I, T> T safeRemoteCall(I i, @NotNull Function1<? super String, Unit> function1, @NotNull Function1<? super I, ? extends T> function12) {
        Intrinsics.checkNotNullParameter(function1, "warnLog");
        Intrinsics.checkNotNullParameter(function12, WebJs.ACTION);
        try {
            return function12.invoke(i);
        } catch (RemoteException e) {
            function1.invoke("Failed calling on remote obj " + i + ": " + e.getLocalizedMessage());
            return null;
        } catch (RuntimeException e2) {
            function1.invoke("Failed performing action on " + i + ": " + e2.getLocalizedMessage());
            return null;
        }
    }
}
