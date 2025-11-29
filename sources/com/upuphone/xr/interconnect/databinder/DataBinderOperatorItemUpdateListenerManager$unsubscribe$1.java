package com.upuphone.xr.interconnect.databinder;

import android.util.Log;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.util.RemoteInterfaceExtKt;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorItemUpdateListenerManager$unsubscribe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ IDataBinderItemUpdateListener $listener;
    final /* synthetic */ String $name;
    final /* synthetic */ DataBinderOperatorItemUpdateListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorItemUpdateListenerManager$unsubscribe$1(DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager, String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        super(0);
        this.this$0 = dataBinderOperatorItemUpdateListenerManager;
        this.$deviceId = str;
        this.$name = str2;
        this.$listener = iDataBinderItemUpdateListener;
    }

    public final void invoke() {
        IDataBinderServer iDataBinderServer;
        Map map;
        String access$getTag = this.this$0.getTag();
        Log.d(access$getTag, "Unsubscribing on " + this.$deviceId + '/' + this.$name + " for " + this.$listener + '.');
        Map map2 = (Map) this.this$0.subscribers.get(this.$deviceId);
        Set set = map2 != null ? (Set) map2.get(this.$name) : null;
        if (set != null) {
            set.remove(this.$listener);
        }
        if (!(set == null || !set.isEmpty() || (map = (Map) this.this$0.subscribers.get(this.$deviceId)) == null)) {
            Set set2 = (Set) map.remove(this.$name);
        }
        Map map3 = (Map) this.this$0.subscribers.get(this.$deviceId);
        if ((map3 == null || !map3.containsKey(this.$name)) && (iDataBinderServer = (IDataBinderServer) this.this$0.serverGetter.invoke()) != null) {
            AnonymousClass1 r1 = new Function1<String, Unit>(this.this$0) {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, "p0");
                    ((DataBinderOperatorItemUpdateListenerManager) this.receiver).logd(str);
                }
            };
            final String str = this.$deviceId;
            final String str2 = this.$name;
            Unit unit = (Unit) RemoteInterfaceExtKt.safeRemoteCall(iDataBinderServer, (Function1<? super String, Unit>) r1, new Function1<IDataBinderServer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IDataBinderServer) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IDataBinderServer iDataBinderServer) {
                    Intrinsics.checkNotNullParameter(iDataBinderServer, "$this$safeRemoteCall");
                    iDataBinderServer.unsubscribe(str, str2);
                }
            });
        }
    }
}
