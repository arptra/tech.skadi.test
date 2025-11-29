package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nDataBinderItemSubscribeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderItemSubscribeManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager$unsubscribeAll$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,93:1\n215#2:94\n215#2,2:95\n216#2:97\n*S KotlinDebug\n*F\n+ 1 DataBinderItemSubscribeManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager$unsubscribeAll$1\n*L\n66#1:94\n67#1:95,2\n66#1:97\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataBinderItemSubscribeManager$unsubscribeAll$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $pid;
    final /* synthetic */ DataBinderItemSubscribeManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderItemSubscribeManager$unsubscribeAll$1(DataBinderItemSubscribeManager dataBinderItemSubscribeManager, int i) {
        super(0);
        this.this$0 = dataBinderItemSubscribeManager;
        this.$pid = i;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int i = this.$pid;
        ILog.d(access$getTag, "Unsubscribing all listeners from " + i + ".");
        Map access$getRemoteSubscribers$p = this.this$0.remoteSubscribers;
        int i2 = this.$pid;
        for (Map.Entry value : access$getRemoteSubscribers$p.entrySet()) {
            for (Map.Entry value2 : ((Map) value.getValue()).entrySet()) {
                Iterator it = ((Map) value2.getValue()).entrySet().iterator();
                while (it.hasNext()) {
                    if (((Number) ((Map.Entry) it.next()).getKey()).intValue() == i2) {
                        it.remove();
                    }
                }
            }
        }
    }
}
