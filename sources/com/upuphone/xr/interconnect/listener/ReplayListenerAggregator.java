package com.upuphone.xr.interconnect.listener;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000b0\t\u0012#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\u000b0\r\u0012\u001d\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\u000e\u0012\u001d\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00062\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0016R!\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/interconnect/listener/ReplayListenerAggregator;", "L", "", "R", "Lcom/upuphone/xr/interconnect/listener/ListenerAggregator;", "name", "", "logTag", "serialize", "Lkotlin/Function2;", "Lkotlin/Function0;", "", "registrationScope", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "register", "unregister", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "previousAction", "addListener", "listener", "(Ljava/lang/Object;)V", "callEachListener", "matter", "action", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ReplayListenerAggregator<L, R> extends ListenerAggregator<L, R> {
    @Nullable
    private Function1<? super L, Unit> previousAction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReplayListenerAggregator(@NotNull String str, @NotNull String str2, @NotNull Function2<? super String, ? super Function0<Unit>, Unit> function2, @NotNull Function1<? super Function1<? super R, Unit>, Unit> function1, @NotNull Function2<? super R, ? super L, Unit> function22, @NotNull Function2<? super R, ? super L, Unit> function23) {
        super(str, str2, function2, function1, function22, function23);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "logTag");
        Intrinsics.checkNotNullParameter(function2, "serialize");
        Intrinsics.checkNotNullParameter(function1, "registrationScope");
        Intrinsics.checkNotNullParameter(function22, "register");
        Intrinsics.checkNotNullParameter(function23, "unregister");
    }

    public void addListener(@NotNull L l) {
        Intrinsics.checkNotNullParameter(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        super.addListener(l);
        Function1<? super L, Unit> function1 = this.previousAction;
        if (function1 != null) {
            function1.invoke(l);
        }
    }

    public void callEachListener(@NotNull String str, @NotNull Function1<? super L, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "matter");
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        super.callEachListener(str, function1);
        this.previousAction = function1;
    }
}
