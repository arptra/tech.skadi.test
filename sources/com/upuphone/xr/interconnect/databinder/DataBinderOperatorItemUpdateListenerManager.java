package com.upuphone.xr.interconnect.databinder;

import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0006\u0010\u000f\u001a\u00020\rJ\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bJ\u001e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bJ\u001b\u0010\u0015\u001a\u00020\r2\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0017¢\u0006\u0002\u0010\u0018R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "logTag", "", "serverGetter", "Lkotlin/Function0;", "Lcom/upuphone/xr/interconnect/common/IDataBinderServer;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "subscribers", "", "", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "logd", "", "text", "registerSubscribers", "subscribe", "deviceId", "name", "listener", "unsubscribe", "updateDeviceList", "deviceIdList", "", "([Ljava/lang/String;)V", "DataBinderItemUpdateAggregateListener", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorItemUpdateListenerManager extends PetaStepSerializer {
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<IDataBinderServer> serverGetter;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, Map<String, Set<IDataBinderItemUpdateListener>>> subscribers = new HashMap();

    @SourceDebugExtension({"SMAP\nDataBinderOperatorItemUpdateListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderOperatorItemUpdateListenerManager.kt\ncom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager$DataBinderItemUpdateAggregateListener\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,70:1\n1855#2,2:71\n*S KotlinDebug\n*F\n+ 1 DataBinderOperatorItemUpdateListenerManager.kt\ncom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager$DataBinderItemUpdateAggregateListener\n*L\n64#1:71,2\n*E\n"})
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager$DataBinderItemUpdateAggregateListener;", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener$Stub;", "deviceId", "", "name", "(Lcom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager;Ljava/lang/String;Ljava/lang/String;)V", "onUpdate", "", "newValue", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DataBinderItemUpdateAggregateListener extends IDataBinderItemUpdateListener.Stub {
        @NotNull
        private final String deviceId;
        @NotNull
        private final String name;
        final /* synthetic */ DataBinderOperatorItemUpdateListenerManager this$0;

        public DataBinderItemUpdateAggregateListener(@NotNull DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager, @NotNull String str, String str2) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(str2, "name");
            this.this$0 = dataBinderOperatorItemUpdateListenerManager;
            this.deviceId = str;
            this.name = str2;
        }

        public void onUpdate(@Nullable DataBinderValue<?> dataBinderValue) {
            Set<IDataBinderItemUpdateListener> set;
            Map map = (Map) this.this$0.subscribers.get(this.deviceId);
            if (map != null && (set = (Set) map.get(this.name)) != null) {
                for (IDataBinderItemUpdateListener onUpdate : set) {
                    onUpdate.onUpdate(dataBinderValue);
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorItemUpdateListenerManager(@NotNull String str, @NotNull Function0<? extends IDataBinderServer> function0) {
        super(AnonymousClass1.INSTANCE, str);
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(function0, "serverGetter");
        this.serverGetter = function0;
    }

    /* access modifiers changed from: private */
    public final void logd(String str) {
        Log.d(getTag(), str);
    }

    public final void registerSubscribers() {
        serialize("connecting subscribers to server", new DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1(this));
    }

    public final void subscribe(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("subscription", new DataBinderOperatorItemUpdateListenerManager$subscribe$1(this, str, str2, iDataBinderItemUpdateListener));
    }

    public final void unsubscribe(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("unsubscribing", new DataBinderOperatorItemUpdateListenerManager$unsubscribe$1(this, str, str2, iDataBinderItemUpdateListener));
    }

    public final void updateDeviceList(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "deviceIdList");
        serialize("device list update", new DataBinderOperatorItemUpdateListenerManager$updateDeviceList$1(this, strArr));
    }
}
