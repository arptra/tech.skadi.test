package com.upuphone.xr.interconnect.outer;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.api.ResourceOperator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004JM\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u00172\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00180\u001a¢\u0006\u0002\b\u001b2\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00170\u001a¢\u0006\u0002\b\u001bH\u0002¢\u0006\u0002\u0010\u001dR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/ResourceOperatorImpl;", "Lcom/upuphone/xr/interconnect/api/ResourceOperator;", "()V", "provider", "Lcom/upuphone/xr/interconnect/outer/SuperServiceProvider;", "getAvailability", "", "deviceId", "", "type", "identifier", "(Ljava/lang/String;BLjava/lang/String;)Ljava/lang/Byte;", "open", "", "targetDeviceId", "registerOpener", "taskExecutorName", "setAvailability", "available", "", "setProvider", "superServiceProvider", "withService", "T", "S", "getService", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResourceOperatorImpl implements ResourceOperator {
    @Nullable
    private SuperServiceProvider provider;

    private final <S, T> T withService(Function1<? super SuperServiceProvider, ? extends S> function1, Function1<? super S, ? extends T> function12) {
        Object invoke;
        SuperServiceProvider superServiceProvider = this.provider;
        if (superServiceProvider == null || (invoke = function1.invoke(superServiceProvider)) == null) {
            return null;
        }
        try {
            return function12.invoke(invoke);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Nullable
    public Byte getAvailability(@Nullable String str, byte b, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "identifier");
        return (Byte) withService(ResourceOperatorImpl$getAvailability$1.INSTANCE, new ResourceOperatorImpl$getAvailability$2(str, b, str2));
    }

    public void open(@Nullable String str, @NotNull String str2, byte b, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "identifier");
        withService(ResourceOperatorImpl$open$1.INSTANCE, new ResourceOperatorImpl$open$2(str, str2, b, str3));
    }

    public void registerOpener(byte b, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "taskExecutorName");
        withService(ResourceOperatorImpl$registerOpener$1.INSTANCE, new ResourceOperatorImpl$registerOpener$2(b, str));
    }

    public void setAvailability(byte b, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        withService(ResourceOperatorImpl$setAvailability$1.INSTANCE, new ResourceOperatorImpl$setAvailability$2(b, str, z));
    }

    public final void setProvider(@NotNull SuperServiceProvider superServiceProvider) {
        Intrinsics.checkNotNullParameter(superServiceProvider, "superServiceProvider");
        this.provider = superServiceProvider;
    }
}
