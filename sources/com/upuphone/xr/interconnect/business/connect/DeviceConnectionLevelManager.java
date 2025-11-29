package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.collection.Buckets;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\nJ\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u001fJ\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\nH\u0002J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0016H\u0016J \u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\bJ\u0010\u0010/\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\nH\u0002J$\u00102\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\b032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00107\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\b03H\u0002J\f\u00108\u001a\u00020\u0016*\u000205H\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\rX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/DeviceConnectionLevelManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/main/StarryNetAbilityManager$OnStarryAbilityStateListener;", "deviceId", "", "(Ljava/lang/String;)V", "callbackLut", "Lcom/upuphone/xr/interconnect/util/collection/Buckets;", "Lcom/upuphone/xr/interconnect/common/IRequestCallback;", "currentLevel", "Lcom/upuphone/xr/interconnect/api/connection/ConnectionLevel;", "highRequestCallbacks", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "highRequesters", "infoSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "getInfoSlice", "()Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "infoSlice$delegate", "Lkotlin/Lazy;", "isBalanceConnected", "", "isEnhanceConnected", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "mediumRequestCallbacks", "requestingLevel", "timeoutJob", "Lkotlinx/coroutines/Job;", "abandon", "", "appId", "level", "abandonHigh", "connector", "Lcom/upuphone/starrynetsdk/device/connection/DevicesConnector;", "clear", "destroy", "handleRequests", "mutateCurrentLevel", "onEnhanceStateChange", "connected", "onStateChanged", "isEnable", "request", "callback", "requestHigh", "restartTimeout", "targetLevel", "informFail", "", "code", "", "message", "informSuccess", "isSuccessful", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeviceConnectionLevelManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceConnectionLevelManager.kt\ncom/upuphone/xr/interconnect/business/connect/DeviceConnectionLevelManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,186:1\n1855#2,2:187\n1855#2,2:189\n*S KotlinDebug\n*F\n+ 1 DeviceConnectionLevelManager.kt\ncom/upuphone/xr/interconnect/business/connect/DeviceConnectionLevelManager\n*L\n37#1:187,2\n42#1:189,2\n*E\n"})
public final class DeviceConnectionLevelManager extends PetaStepSerializer implements StarryNetAbilityManager.OnStarryAbilityStateListener {
    /* access modifiers changed from: private */
    @NotNull
    public final Buckets<String, IRequestCallback> callbackLut = new Buckets<>();
    @NotNull
    private ConnectionLevel currentLevel = ConnectionLevel.BASIC;
    /* access modifiers changed from: private */
    @NotNull
    public final String deviceId;
    /* access modifiers changed from: private */
    @NotNull
    public final HashSet<IRequestCallback> highRequestCallbacks = new HashSet<>();
    /* access modifiers changed from: private */
    @NotNull
    public final HashSet<String> highRequesters = new HashSet<>();
    @NotNull
    private final Lazy infoSlice$delegate = LazyKt.lazy(DeviceConnectionLevelManager$infoSlice$2.INSTANCE);
    /* access modifiers changed from: private */
    public boolean isBalanceConnected;
    /* access modifiers changed from: private */
    public boolean isEnhanceConnected;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineScope mainScope = CoroutineScopeKt.b();
    /* access modifiers changed from: private */
    @NotNull
    public final HashSet<IRequestCallback> mediumRequestCallbacks = new HashSet<>();
    /* access modifiers changed from: private */
    @Nullable
    public ConnectionLevel requestingLevel;
    /* access modifiers changed from: private */
    @Nullable
    public Job timeoutJob;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.upuphone.xr.interconnect.api.connection.ConnectionLevel[] r0 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.BASIC     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.BALANCE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.ENHANCE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceConnectionLevelManager(@org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "deviceId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$1 r0 = com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager.AnonymousClass1.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cNElVL#"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r3.<init>(r0, r1)
            r3.deviceId = r4
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.b()
            r3.mainScope = r4
            com.upuphone.xr.interconnect.api.connection.ConnectionLevel r4 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.BASIC
            r3.currentLevel = r4
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            r3.highRequesters = r4
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            r3.mediumRequestCallbacks = r4
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            r3.highRequestCallbacks = r4
            com.upuphone.xr.interconnect.util.collection.Buckets r4 = new com.upuphone.xr.interconnect.util.collection.Buckets
            r4.<init>()
            r3.callbackLut = r4
            com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$infoSlice$2 r4 = com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$infoSlice$2.INSTANCE
            kotlin.Lazy r4 = kotlin.LazyKt.lazy(r4)
            r3.infoSlice$delegate = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager.<init>(java.lang.String):void");
    }

    private final void abandonHigh(DevicesConnector devicesConnector) {
        devicesConnector.disconnect(this.deviceId, 2);
    }

    /* access modifiers changed from: private */
    public final DataBinderSlice getInfoSlice() {
        return (DataBinderSlice) this.infoSlice$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleRequests(DevicesConnector devicesConnector) {
        if (!this.highRequesters.isEmpty()) {
            requestHigh(devicesConnector);
        } else {
            abandonHigh(devicesConnector);
        }
    }

    /* access modifiers changed from: private */
    public final void informFail(Set<IRequestCallback> set, int i, String str) {
        for (IRequestCallback deviceConnectionLevelManager$informFail$1$1 : set) {
            Job unused = BuildersKt__Builders_commonKt.d(this.mainScope, (CoroutineContext) null, (CoroutineStart) null, new DeviceConnectionLevelManager$informFail$1$1(deviceConnectionLevelManager$informFail$1$1, this, i, str, (Continuation<? super DeviceConnectionLevelManager$informFail$1$1>) null), 3, (Object) null);
        }
        set.clear();
    }

    /* access modifiers changed from: private */
    public final void informSuccess(Set<IRequestCallback> set) {
        for (IRequestCallback deviceConnectionLevelManager$informSuccess$1$1 : set) {
            Job unused = BuildersKt__Builders_commonKt.d(this.mainScope, (CoroutineContext) null, (CoroutineStart) null, new DeviceConnectionLevelManager$informSuccess$1$1(deviceConnectionLevelManager$informSuccess$1$1, this, (Continuation<? super DeviceConnectionLevelManager$informSuccess$1$1>) null), 3, (Object) null);
        }
        set.clear();
    }

    private final boolean isSuccessful(int i) {
        return i == 0 || i == 202000 || i == 202005;
    }

    /* access modifiers changed from: private */
    public final void mutateCurrentLevel(ConnectionLevel connectionLevel) {
        this.currentLevel = connectionLevel;
        DataBinderSlice infoSlice = getInfoSlice();
        String[] strArr = {"device", this.deviceId, "connectionLevel"};
        int i = WhenMappings.$EnumSwitchMapping$0[connectionLevel.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            if (i == 3) {
                i2 = 2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        infoSlice.set(strArr, i2);
    }

    private final void requestHigh(DevicesConnector devicesConnector) {
        int connect = devicesConnector.connect(this.deviceId, 2);
        ConnectionLevel connectionLevel = this.currentLevel;
        ConnectionLevel connectionLevel2 = ConnectionLevel.ENHANCE;
        if (connectionLevel == connectionLevel2) {
            informSuccess(this.highRequestCallbacks);
            informSuccess(this.mediumRequestCallbacks);
        } else if (this.requestingLevel == connectionLevel2) {
        } else {
            if (isSuccessful(connect)) {
                this.requestingLevel = connectionLevel2;
                restartTimeout(connectionLevel2);
                return;
            }
            HashSet<IRequestCallback> hashSet = this.highRequestCallbacks;
            informFail(hashSet, 4, "Request failed: " + connect + ".");
            this.highRequesters.clear();
        }
    }

    private final void restartTimeout(ConnectionLevel connectionLevel) {
        Job job = this.timeoutJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.timeoutJob = BuildersKt__Builders_commonKt.d(PetaStepSerializer.Companion.getScope(), (CoroutineContext) null, (CoroutineStart) null, new DeviceConnectionLevelManager$restartTimeout$1(this, connectionLevel, (Continuation<? super DeviceConnectionLevelManager$restartTimeout$1>) null), 3, (Object) null);
    }

    public final void abandon(@NotNull String str, @NotNull ConnectionLevel connectionLevel) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(connectionLevel, "level");
        serialize("abandoning", new DeviceConnectionLevelManager$abandon$1(this, str, connectionLevel));
    }

    public final void clear(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        serialize("client death", new DeviceConnectionLevelManager$clear$1(this, str));
    }

    public final void destroy() {
        serialize("destroy", new DeviceConnectionLevelManager$destroy$1(this));
    }

    public final void onEnhanceStateChange(boolean z) {
        serialize("enhance state", new DeviceConnectionLevelManager$onEnhanceStateChange$1(this, z));
    }

    public void onStateChanged(boolean z) {
        if (z) {
            DevicesConnector devicesConnector = StarryNetAbilityManager.getInstance().getDevicesConnector();
            Intrinsics.checkNotNull(devicesConnector);
            serialize("ability ready", new DeviceConnectionLevelManager$onStateChanged$1(this, devicesConnector));
        }
    }

    public final void request(@NotNull String str, @NotNull ConnectionLevel connectionLevel, @Nullable IRequestCallback iRequestCallback) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(connectionLevel, "level");
        serialize("request", new DeviceConnectionLevelManager$request$1(this, str, connectionLevel, iRequestCallback));
    }
}
