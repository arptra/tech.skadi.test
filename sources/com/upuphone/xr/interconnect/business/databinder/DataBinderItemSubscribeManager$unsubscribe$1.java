package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataBinderItemSubscribeManager$unsubscribe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $name;
    final /* synthetic */ int $pid;
    final /* synthetic */ DataBinderItemSubscribeManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderItemSubscribeManager$unsubscribe$1(DataBinderItemSubscribeManager dataBinderItemSubscribeManager, String str, int i, String str2) {
        super(0);
        this.this$0 = dataBinderItemSubscribeManager;
        this.$name = str;
        this.$pid = i;
        this.$deviceId = str2;
    }

    public final void invoke() {
        Map map;
        DataBinderItemUpdateListener dataBinderItemUpdateListener;
        String access$getTag = this.this$0.getTag();
        String str = this.$name;
        int i = this.$pid;
        ILog.d(access$getTag, "Unsubscribing on " + str + " from " + i + ".");
        Map map2 = (Map) this.this$0.remoteSubscribers.get(this.$deviceId);
        if (map2 != null && (map = (Map) map2.get(this.$name)) != null && (dataBinderItemUpdateListener = (DataBinderItemUpdateListener) map.remove(Integer.valueOf(this.$pid))) != null) {
            DataBinderItemSubscribeManager dataBinderItemSubscribeManager = this.this$0;
            dataBinderItemSubscribeManager.manager.unsubscribe(this.$deviceId, this.$name, dataBinderItemUpdateListener);
        }
    }
}
