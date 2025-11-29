package com.upuphone.xr.interconnect.business.databinder;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.u7.a;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.common.IDataBinder;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nJ&\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0007J\u001e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u001e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0007J\u001e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u001e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000bJ\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\u0004\u0012\u00020\n\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u00060\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a \u0012\u0004\u0012\u00020\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00060\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "manager", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderManager;", "(Lcom/upuphone/xr/interconnect/business/databinder/DataBinderManager;)V", "innerSubscriberMap", "", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;", "remoteSubscribers", "", "", "subscribers", "", "getSubscribers$SharedImpl_intlRelease", "()Ljava/util/Map;", "onRemoteServiceDown", "", "deviceId", "onRemoteServiceUp", "subscribe", "pid", "name", "listener", "subscribeInner", "unsubscribe", "unsubscribeAll", "unsubscribeInner", "WrapperListener", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataBinderItemSubscribeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderItemSubscribeManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n372#2,7:94\n372#2,7:101\n1#3:108\n*S KotlinDebug\n*F\n+ 1 DataBinderItemSubscribeManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager\n*L\n24#1:94,7\n34#1:101,7\n*E\n"})
public final class DataBinderItemSubscribeManager extends PetaStepSerializer {
    @NotNull
    private final Map<IDataBinderItemUpdateListener, DataBinderItemUpdateListener> innerSubscriberMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final DataBinderManager manager;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, Map<String, Map<Integer, DataBinderItemUpdateListener>>> remoteSubscribers = new ConcurrentHashMap();
    @NotNull
    private final Map<String, Map<String, Set<DataBinderItemUpdateListener>>> subscribers;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager$WrapperListener;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;", "remoteListener", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "(Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;)V", "onUpdate", "", "newValue", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class WrapperListener implements DataBinderItemUpdateListener {
        @NotNull
        private final IDataBinderItemUpdateListener remoteListener;

        public WrapperListener(@NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
            Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, "remoteListener");
            this.remoteListener = iDataBinderItemUpdateListener;
        }

        public void onUpdate(@Nullable DataBinderValue<?> dataBinderValue) {
            this.remoteListener.onUpdate(dataBinderValue);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderItemSubscribeManager(@NotNull DataBinderManager dataBinderManager) {
        super(AnonymousClass1.INSTANCE, IDataBinder.TAG);
        Intrinsics.checkNotNullParameter(dataBinderManager, "manager");
        this.manager = dataBinderManager;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.subscribers = concurrentHashMap;
        concurrentHashMap.put("", new ConcurrentHashMap());
    }

    /* access modifiers changed from: private */
    public static final void subscribeInner$lambda$2(IDataBinderItemUpdateListener iDataBinderItemUpdateListener, DataBinderValue dataBinderValue) {
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, "$listener");
        iDataBinderItemUpdateListener.onUpdate(dataBinderValue);
    }

    @NotNull
    public final Map<String, Map<String, Set<DataBinderItemUpdateListener>>> getSubscribers$SharedImpl_intlRelease() {
        return this.subscribers;
    }

    public final void onRemoteServiceDown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        this.subscribers.remove(str);
    }

    public final void onRemoteServiceUp(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        this.subscribers.putIfAbsent(str, new ConcurrentHashMap());
    }

    public final void subscribe(@NotNull String str, @NotNull String str2, @NotNull DataBinderItemUpdateListener dataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(dataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Map map = this.subscribers.get(str);
        if (map != null) {
            Object obj = map.get(str2);
            if (obj == null) {
                obj = new ConcurrentHashSet();
                map.put(str2, obj);
            }
            ((Set) obj).add(dataBinderItemUpdateListener);
        }
    }

    public final void subscribeInner(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a aVar = new a(iDataBinderItemUpdateListener);
        DataBinderItemUpdateListener put = this.innerSubscriberMap.put(iDataBinderItemUpdateListener, aVar);
        Map map = this.subscribers.get(str);
        if (map != null) {
            Object obj = map.get(str2);
            if (obj == null) {
                obj = new ConcurrentHashSet();
                map.put(str2, obj);
            }
            Set set = (Set) obj;
            if (put != null) {
                set.remove(put);
            }
            set.add(aVar);
        }
    }

    public final void unsubscribe(@NotNull String str, @NotNull String str2, @NotNull DataBinderItemUpdateListener dataBinderItemUpdateListener) {
        Set set;
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(dataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Map map = this.subscribers.get(str);
        if (map != null && (set = (Set) map.get(str2)) != null) {
            set.remove(dataBinderItemUpdateListener);
        }
    }

    public final void unsubscribeAll(int i) {
        serialize("client death", new DataBinderItemSubscribeManager$unsubscribeAll$1(this, i));
    }

    public final void unsubscribeInner(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Map map;
        Set set;
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        DataBinderItemUpdateListener dataBinderItemUpdateListener = this.innerSubscriberMap.get(iDataBinderItemUpdateListener);
        if (dataBinderItemUpdateListener != null && (map = this.subscribers.get(str)) != null && (set = (Set) map.get(str2)) != null) {
            set.remove(dataBinderItemUpdateListener);
        }
    }

    public final void unsubscribe(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        serialize("client unsubscribing", new DataBinderItemSubscribeManager$unsubscribe$1(this, str2, i, str));
    }

    public final void subscribe(int i, @NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("client subscription", new DataBinderItemSubscribeManager$subscribe$2(this, str2, iDataBinderItemUpdateListener, i, str));
    }
}
