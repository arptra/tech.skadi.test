package com.upuphone.xr.interconnect.databinder;

import android.util.Log;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.databinder.DataBinderOperatorItemUpdateListenerManager;
import com.upuphone.xr.interconnect.util.RemoteInterfaceExtKt;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nDataBinderOperatorItemUpdateListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderOperatorItemUpdateListenerManager.kt\ncom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager$subscribe$1\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,70:1\n361#2,7:71\n*S KotlinDebug\n*F\n+ 1 DataBinderOperatorItemUpdateListenerManager.kt\ncom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager$subscribe$1\n*L\n31#1:71,7\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorItemUpdateListenerManager$subscribe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ IDataBinderItemUpdateListener $listener;
    final /* synthetic */ String $name;
    final /* synthetic */ DataBinderOperatorItemUpdateListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorItemUpdateListenerManager$subscribe$1(DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager, String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        super(0);
        this.this$0 = dataBinderOperatorItemUpdateListenerManager;
        this.$deviceId = str;
        this.$name = str2;
        this.$listener = iDataBinderItemUpdateListener;
    }

    public final void invoke() {
        IDataBinderServer iDataBinderServer;
        String access$getTag = this.this$0.getTag();
        Log.d(access$getTag, "Subscribing on " + this.$deviceId + '/' + this.$name + " with " + this.$listener + '.');
        Map map = (Map) this.this$0.subscribers.get(this.$deviceId);
        boolean z = (map != null ? (Set) map.get(this.$name) : null) != null;
        Map access$getSubscribers$p = this.this$0.subscribers;
        String str = this.$deviceId;
        Object obj = access$getSubscribers$p.get(str);
        if (obj == null) {
            obj = new LinkedHashMap();
            access$getSubscribers$p.put(str, obj);
        }
        Map map2 = (Map) obj;
        String str2 = this.$name;
        Object obj2 = map2.get(str2);
        if (obj2 == null) {
            obj2 = new LinkedHashSet();
            map2.put(str2, obj2);
        }
        ((Set) obj2).add(this.$listener);
        if (!z && (iDataBinderServer = (IDataBinderServer) this.this$0.serverGetter.invoke()) != null) {
            AnonymousClass3 r1 = new Function1<String, Unit>(this.this$0) {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, "p0");
                    ((DataBinderOperatorItemUpdateListenerManager) this.receiver).logd(str);
                }
            };
            final String str3 = this.$deviceId;
            final String str4 = this.$name;
            final DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager = this.this$0;
            Unit unit = (Unit) RemoteInterfaceExtKt.safeRemoteCall(iDataBinderServer, (Function1<? super String, Unit>) r1, new Function1<IDataBinderServer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IDataBinderServer) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IDataBinderServer iDataBinderServer) {
                    Intrinsics.checkNotNullParameter(iDataBinderServer, "$this$safeRemoteCall");
                    iDataBinderServer.subscribe(str3, str4, new DataBinderOperatorItemUpdateListenerManager.DataBinderItemUpdateAggregateListener(dataBinderOperatorItemUpdateListenerManager, str3, str4));
                }
            });
        }
    }
}
