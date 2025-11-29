package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.business.databinder.DataBinderServer;
import com.upuphone.xr.interconnect.common.IDataBinderClient;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nDataBinderServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderServer.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderServer$ClientManager$updateDeviceList$1\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n37#2,2:70\n1855#3,2:72\n*S KotlinDebug\n*F\n+ 1 DataBinderServer.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderServer$ClientManager$updateDeviceList$1\n*L\n62#1:70,2\n63#1:72,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataBinderServer$ClientManager$updateDeviceList$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<String> $deviceList;
    final /* synthetic */ DataBinderServer.ClientManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderServer$ClientManager$updateDeviceList$1(DataBinderServer.ClientManager clientManager, List<String> list) {
        super(0);
        this.this$0 = clientManager;
        this.$deviceList = list;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        List<String> list = this.$deviceList;
        Set keySet = this.this$0.clientMap.keySet();
        ILog.d(access$getTag, "Broadcasting device list " + list + " to clients " + keySet);
        String[] strArr = (String[]) this.$deviceList.toArray(new String[0]);
        for (IDataBinderClient updateDeviceList : this.this$0.clientMap.values()) {
            updateDeviceList.updateDeviceList(strArr);
        }
    }
}
