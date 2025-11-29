package com.upuphone.xr.interconnect.listener;

import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0\b\u0012#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\r\u0012\u0004\u0012\u00020\n0\f\u0012\u001d\u0010\u000e\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\r\u0012\u001d\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0010J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ)\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00052\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\rH\u0016J\r\u0010!\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0018J\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\b\u0010$\u001a\u00020\nH\u0002J\u0013\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010&\u001a\u00020\nH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0014j\b\u0012\u0004\u0012\u00028\u0000`\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00028\u00008BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R%\u0010\u000e\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\rX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\r\u0012\u0004\u0012\u00020\n0\fX\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R%\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\rX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/upuphone/xr/interconnect/listener/ListenerAggregator;", "L", "", "R", "name", "", "logTag", "serialize", "Lkotlin/Function2;", "Lkotlin/Function0;", "", "registrationScope", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "register", "unregister", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "isParentRegistered", "", "listeners", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "parentListener", "getParentListener", "()Ljava/lang/Object;", "parentListener$delegate", "Lkotlin/Lazy;", "addListener", "listener", "(Ljava/lang/Object;)V", "callEachListener", "matter", "action", "createParentListener", "onServiceDown", "onServiceUp", "registerSelf", "removeListener", "unregisterSelf", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ListenerAggregator<L, R> {
    /* access modifiers changed from: private */
    public boolean isParentRegistered;
    /* access modifiers changed from: private */
    @NotNull
    public final HashSet<L> listeners = new HashSet<>();
    /* access modifiers changed from: private */
    @NotNull
    public final String logTag;
    /* access modifiers changed from: private */
    @NotNull
    public final String name;
    @NotNull
    private final Lazy parentListener$delegate = LazyKt.lazy(new ListenerAggregator$parentListener$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final Function2<R, L, Unit> register;
    @NotNull
    private final Function1<Function1<? super R, Unit>, Unit> registrationScope;
    @NotNull
    private final Function2<String, Function0<Unit>, Unit> serialize;
    /* access modifiers changed from: private */
    @NotNull
    public final Function2<R, L, Unit> unregister;

    public ListenerAggregator(@NotNull String str, @NotNull String str2, @NotNull Function2<? super String, ? super Function0<Unit>, Unit> function2, @NotNull Function1<? super Function1<? super R, Unit>, Unit> function1, @NotNull Function2<? super R, ? super L, Unit> function22, @NotNull Function2<? super R, ? super L, Unit> function23) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "logTag");
        Intrinsics.checkNotNullParameter(function2, "serialize");
        Intrinsics.checkNotNullParameter(function1, "registrationScope");
        Intrinsics.checkNotNullParameter(function22, "register");
        Intrinsics.checkNotNullParameter(function23, "unregister");
        this.name = str;
        this.logTag = str2;
        this.serialize = function2;
        this.registrationScope = function1;
        this.register = function22;
        this.unregister = function23;
    }

    /* access modifiers changed from: private */
    public final L getParentListener() {
        return this.parentListener$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void registerSelf() {
        String str = this.logTag;
        Log.d(str, "Trying to register " + this.name + " listeners.");
        this.registrationScope.invoke(new ListenerAggregator$registerSelf$1(this));
    }

    /* access modifiers changed from: private */
    public final void unregisterSelf() {
        String str = this.logTag;
        Log.d(str, "Trying to unregister " + this.name + " listeners.");
        this.registrationScope.invoke(new ListenerAggregator$unregisterSelf$1(this));
    }

    public void addListener(@NotNull L l) {
        Intrinsics.checkNotNullParameter(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String stringify = PrettyPrintExtKt.stringify(l);
        Function2<String, Function0<Unit>, Unit> function2 = this.serialize;
        function2.invoke("add " + this.name + " listener " + stringify, new ListenerAggregator$addListener$1(this, stringify, l));
    }

    public void callEachListener(@NotNull String str, @NotNull Function1<? super L, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "matter");
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        Function2<String, Function0<Unit>, Unit> function2 = this.serialize;
        function2.invoke("inform " + this.name + " listeners about " + str, new ListenerAggregator$callEachListener$1(this, function1));
    }

    @NotNull
    public abstract L createParentListener();

    public final void onServiceDown() {
        Function2<String, Function0<Unit>, Unit> function2 = this.serialize;
        function2.invoke("reset " + this.name + " listeners service status", new ListenerAggregator$onServiceDown$1(this));
    }

    public final void onServiceUp() {
        Function2<String, Function0<Unit>, Unit> function2 = this.serialize;
        function2.invoke("connect " + this.name + " listeners to service", new ListenerAggregator$onServiceUp$1(this));
    }

    public final void removeListener(@NotNull L l) {
        Intrinsics.checkNotNullParameter(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String stringify = PrettyPrintExtKt.stringify(l);
        Function2<String, Function0<Unit>, Unit> function2 = this.serialize;
        function2.invoke("remove " + this.name + " listener " + stringify, new ListenerAggregator$removeListener$1(this, stringify, l));
    }
}
