package com.upuphone.xr.interconnect.databinder;

import android.util.Log;
import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.util.RemoteInterfaceExtKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nDataBinderOperatorItemUpdateListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderOperatorItemUpdateListenerManager.kt\ncom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,70:1\n215#2:71\n215#2,2:72\n216#2:74\n*S KotlinDebug\n*F\n+ 1 DataBinderOperatorItemUpdateListenerManager.kt\ncom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1\n*L\n21#1:71\n22#1:72,2\n21#1:74\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DataBinderOperatorItemUpdateListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1(DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager) {
        super(0);
        this.this$0 = dataBinderOperatorItemUpdateListenerManager;
    }

    public final void invoke() {
        IDataBinderServer iDataBinderServer = (IDataBinderServer) this.this$0.serverGetter.invoke();
        if (iDataBinderServer == null) {
            Log.w(this.this$0.getTag(), "Cannot retrieve valid server, aborting startup.");
            return;
        }
        Map access$getSubscribers$p = this.this$0.subscribers;
        DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager = this.this$0;
        for (Map.Entry entry : access$getSubscribers$p.entrySet()) {
            String str = (String) entry.getKey();
            for (Map.Entry key : ((Map) entry.getValue()).entrySet()) {
                RemoteInterfaceExtKt.safeRemoteCall(iDataBinderServer, (Function1<? super String, Unit>) new DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1$1$1$1(dataBinderOperatorItemUpdateListenerManager), new DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1$1$1$2(str, (String) key.getKey(), dataBinderOperatorItemUpdateListenerManager));
            }
        }
    }
}
