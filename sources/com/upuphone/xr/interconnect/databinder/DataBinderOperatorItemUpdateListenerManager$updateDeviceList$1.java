package com.upuphone.xr.interconnect.databinder;

import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorItemUpdateListenerManager$updateDeviceList$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String[] $deviceIdList;
    final /* synthetic */ DataBinderOperatorItemUpdateListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorItemUpdateListenerManager$updateDeviceList$1(DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager, String[] strArr) {
        super(0);
        this.this$0 = dataBinderOperatorItemUpdateListenerManager;
        this.$deviceIdList = strArr;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        Log.d(access$getTag, "Updating device list " + this.$deviceIdList + '.');
        Iterator it = this.this$0.subscribers.entrySet().iterator();
        String[] strArr = this.$deviceIdList;
        DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager = this.this$0;
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            if (!ArraysKt.contains((T[]) strArr, str)) {
                String access$getTag2 = dataBinderOperatorItemUpdateListenerManager.getTag();
                Log.d(access$getTag2, "Removing subscribers on #" + str);
                it.remove();
            }
        }
    }
}
