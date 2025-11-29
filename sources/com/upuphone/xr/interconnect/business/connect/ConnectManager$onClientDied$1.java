package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.remote.BinderClient;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectManager$onClientDied$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,351:1\n1855#2,2:352\n*S KotlinDebug\n*F\n+ 1 ConnectManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectManager$onClientDied$1\n*L\n346#1:352,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$onClientDied$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BinderClient $client;
    final /* synthetic */ ConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$onClientDied$1(ConnectManager connectManager, BinderClient binderClient) {
        super(0);
        this.this$0 = connectManager;
        this.$client = binderClient;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        BinderClient binderClient = this.$client;
        ILog.d(access$getTag, "Client " + binderClient + " has died.");
        BinderClient binderClient2 = this.$client;
        String packageName = binderClient2 != null ? binderClient2.getPackageName() : null;
        if (packageName != null) {
            Collection<DeviceConnectionLevelManager> values = this.this$0.deviceConnectionLevelManagers.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            for (DeviceConnectionLevelManager clear : values) {
                clear.clear(packageName);
            }
        }
    }
}
