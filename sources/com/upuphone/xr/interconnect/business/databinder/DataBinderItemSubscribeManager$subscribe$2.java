package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nDataBinderItemSubscribeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderItemSubscribeManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager$subscribe$2\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,93:1\n372#2,7:94\n*S KotlinDebug\n*F\n+ 1 DataBinderItemSubscribeManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager$subscribe$2\n*L\n48#1:94,7\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataBinderItemSubscribeManager$subscribe$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ IDataBinderItemUpdateListener $listener;
    final /* synthetic */ String $name;
    final /* synthetic */ int $pid;
    final /* synthetic */ DataBinderItemSubscribeManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderItemSubscribeManager$subscribe$2(DataBinderItemSubscribeManager dataBinderItemSubscribeManager, String str, IDataBinderItemUpdateListener iDataBinderItemUpdateListener, int i, String str2) {
        super(0);
        this.this$0 = dataBinderItemSubscribeManager;
        this.$name = str;
        this.$listener = iDataBinderItemUpdateListener;
        this.$pid = i;
        this.$deviceId = str2;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$name;
        String stringify = PrettyPrintExtKt.stringify(this.$listener);
        int i = this.$pid;
        ILog.d(access$getTag, "Subscribing on " + str + " for " + stringify + " from " + i + ".");
        Map access$getRemoteSubscribers$p = this.this$0.remoteSubscribers;
        String str2 = this.$deviceId;
        Object obj = access$getRemoteSubscribers$p.get(str2);
        if (obj == null) {
            obj = new ConcurrentHashMap();
            access$getRemoteSubscribers$p.put(str2, obj);
        }
        Map map = (Map) obj;
        String str3 = this.$name;
        Object obj2 = map.get(str3);
        if (obj2 == null) {
            obj2 = new ConcurrentHashMap();
            map.put(str3, obj2);
        }
        Map map2 = (Map) obj2;
        DataBinderItemUpdateListener dataBinderItemUpdateListener = (DataBinderItemUpdateListener) map2.get(Integer.valueOf(this.$pid));
        if (dataBinderItemUpdateListener != null) {
            DataBinderItemSubscribeManager dataBinderItemSubscribeManager = this.this$0;
            dataBinderItemSubscribeManager.manager.unsubscribe(this.$deviceId, this.$name, dataBinderItemUpdateListener);
        }
        Integer valueOf = Integer.valueOf(this.$pid);
        DataBinderItemSubscribeManager.WrapperListener wrapperListener = new DataBinderItemSubscribeManager.WrapperListener(this.$listener);
        DataBinderItemSubscribeManager dataBinderItemSubscribeManager2 = this.this$0;
        dataBinderItemSubscribeManager2.manager.subscribe(this.$deviceId, this.$name, (DataBinderItemUpdateListener) wrapperListener);
        map2.put(valueOf, wrapperListener);
    }
}
