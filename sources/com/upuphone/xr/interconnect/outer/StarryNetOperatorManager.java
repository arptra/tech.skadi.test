package com.upuphone.xr.interconnect.outer;

import android.content.Context;
import com.upuphone.xr.interconnect.api.AccountAbilityOperator;
import com.upuphone.xr.interconnect.api.DataBinderOperator;
import com.upuphone.xr.interconnect.api.InfoOperator;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.ResourceOperator;
import com.upuphone.xr.interconnect.api.SappAbilityOperator;
import com.upuphone.xr.interconnect.api.StarryNetAppOperator;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoOperator;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.api.StarryNetDialerOperator;
import com.upuphone.xr.interconnect.api.StarryNetDlnaServerOperator;
import com.upuphone.xr.interconnect.api.StarryNetFileOperator;
import com.upuphone.xr.interconnect.api.StarryNetGroupMessageOperator;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.api.StarryNetWifiOperator;
import com.upuphone.xr.interconnect.api.TaskOperator;
import com.upuphone.xr.interconnect.api.TransAbilityOperator;
import com.upuphone.xr.interconnect.api.VolumeChangeControllerOperator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020SH\u0016J\b\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020WH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/StarryNetOperatorManager;", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "Lcom/upuphone/xr/interconnect/outer/SuperServiceStateListener;", "context", "Landroid/content/Context;", "identifier", "", "outerSuperServiceStateListener", "serverPackage", "(Landroid/content/Context;Ljava/lang/String;Lcom/upuphone/xr/interconnect/outer/SuperServiceStateListener;Ljava/lang/String;)V", "accountAbilityOperator", "Lcom/upuphone/xr/interconnect/outer/AccountAbilityOperatorImpl;", "dataBinderOperator", "Lcom/upuphone/xr/interconnect/outer/DataBinderOperatorImpl;", "deviceInfoOperator", "Lcom/upuphone/xr/interconnect/outer/StarryNetDeviceInfoOperatorImpl;", "deviceOperator", "Lcom/upuphone/xr/interconnect/outer/DeviceOperatorImpl;", "dialerOperator", "Lcom/upuphone/xr/interconnect/outer/StarryNetDialerOperatorImpl;", "fileOperator", "Lcom/upuphone/xr/interconnect/outer/StarryNetFileOperatorImpl;", "groupMessageOperator", "Lcom/upuphone/xr/interconnect/outer/StarryNeGroupMessageOperatorImpl;", "infoOperator", "Lcom/upuphone/xr/interconnect/outer/InfoOperatorImpl;", "innerSuperServiceStateListeners", "", "messageOperator", "Lcom/upuphone/xr/interconnect/outer/MessageOperatorImpl;", "naviAbilityOperator", "Lcom/upuphone/xr/interconnect/outer/NaviAbilityOperatorImpl;", "provider", "Lcom/upuphone/xr/interconnect/outer/SuperServiceProvider;", "resourceOperator", "Lcom/upuphone/xr/interconnect/outer/ResourceOperatorImpl;", "sappAbilityOperator", "Lcom/upuphone/xr/interconnect/outer/SappAbilityOperatorImpl;", "starryNetAppOperator", "Lcom/upuphone/xr/interconnect/outer/StarryNetAppOperatorImpl;", "starryNetDlnaServerOperator", "Lcom/upuphone/xr/interconnect/outer/StarryNetDlnaServerOperatorImpl;", "taskOperator", "Lcom/upuphone/xr/interconnect/outer/TaskOperatorImpl;", "transAbilityOperator", "Lcom/upuphone/xr/interconnect/outer/TransAbilityOperatorImpl;", "volumeChangeControllerOperator", "Lcom/upuphone/xr/interconnect/outer/VolumeChangeControllerOperatorImpl;", "wifiOperator", "Lcom/upuphone/xr/interconnect/outer/StarryNetWifiOperatorImpl;", "getAccountAbilityOperator", "Lcom/upuphone/xr/interconnect/api/AccountAbilityOperator;", "getDataBinderOperator", "Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "getDeviceInfoOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceInfoOperator;", "getDeviceOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "getDialerOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDialerOperator;", "getFileOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetFileOperator;", "getGroupMessageOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetGroupMessageOperator;", "getInfoOperator", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "getMessageOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "getNaviAbilityOperator", "Lcom/upuphone/xr/interconnect/api/NaviAbilityOperator;", "getResourceOperator", "Lcom/upuphone/xr/interconnect/api/ResourceOperator;", "getSappAbilityOperator", "Lcom/upuphone/xr/interconnect/api/SappAbilityOperator;", "getStarryNetAppOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetAppOperator;", "getStarryNetDlnaServerOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDlnaServerOperator;", "getTaskOperator", "Lcom/upuphone/xr/interconnect/api/TaskOperator;", "getTransAbilityOperator", "Lcom/upuphone/xr/interconnect/api/TransAbilityOperator;", "getVolumeChangeControllerOperator", "Lcom/upuphone/xr/interconnect/api/VolumeChangeControllerOperator;", "getWifiOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetWifiOperator;", "onServiceConnected", "", "onServiceDied", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStarryNetOperatorManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarryNetOperatorManager.kt\ncom/upuphone/xr/interconnect/outer/StarryNetOperatorManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public final class StarryNetOperatorManager implements OperatorManager, SuperServiceStateListener {
    @NotNull
    private final AccountAbilityOperatorImpl accountAbilityOperator;
    /* access modifiers changed from: private */
    @NotNull
    public final DataBinderOperatorImpl dataBinderOperator;
    @NotNull
    private final StarryNetDeviceInfoOperatorImpl deviceInfoOperator;
    @NotNull
    private final DeviceOperatorImpl deviceOperator;
    @NotNull
    private final StarryNetDialerOperatorImpl dialerOperator;
    @NotNull
    private final StarryNetFileOperatorImpl fileOperator;
    @NotNull
    private final StarryNeGroupMessageOperatorImpl groupMessageOperator;
    @NotNull
    private final InfoOperatorImpl infoOperator = new InfoOperatorImpl(new StarryNetOperatorManager$infoOperator$1(this));
    @NotNull
    private final List<SuperServiceStateListener> innerSuperServiceStateListeners;
    @NotNull
    private final MessageOperatorImpl messageOperator;
    @NotNull
    private final NaviAbilityOperatorImpl naviAbilityOperator;
    @Nullable
    private final SuperServiceStateListener outerSuperServiceStateListener;
    /* access modifiers changed from: private */
    @NotNull
    public final SuperServiceProvider provider;
    @NotNull
    private final ResourceOperatorImpl resourceOperator;
    @NotNull
    private final SappAbilityOperatorImpl sappAbilityOperator;
    @NotNull
    private final StarryNetAppOperatorImpl starryNetAppOperator;
    @NotNull
    private final StarryNetDlnaServerOperatorImpl starryNetDlnaServerOperator;
    @NotNull
    private final TaskOperatorImpl taskOperator;
    @NotNull
    private final TransAbilityOperatorImpl transAbilityOperator;
    @NotNull
    private final VolumeChangeControllerOperatorImpl volumeChangeControllerOperator;
    @NotNull
    private final StarryNetWifiOperatorImpl wifiOperator;

    public StarryNetOperatorManager(@NotNull Context context, @NotNull String str, @Nullable SuperServiceStateListener superServiceStateListener, @NotNull String str2) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str3, "identifier");
        Intrinsics.checkNotNullParameter(str2, "serverPackage");
        this.outerSuperServiceStateListener = superServiceStateListener;
        SuperServiceProvider superServiceProvider = new SuperServiceProvider();
        superServiceProvider.setSuperAppServiceStateListener(this);
        this.provider = superServiceProvider;
        DeviceOperatorImpl deviceOperatorImpl = new DeviceOperatorImpl(str3, new StarryNetOperatorManager$deviceOperator$1(this));
        this.deviceOperator = deviceOperatorImpl;
        StarryNetFileOperatorImpl starryNetFileOperatorImpl = new StarryNetFileOperatorImpl();
        starryNetFileOperatorImpl.setProvider(superServiceProvider);
        starryNetFileOperatorImpl.setIdentifier(str3);
        this.fileOperator = starryNetFileOperatorImpl;
        MessageOperatorImpl messageOperatorImpl = new MessageOperatorImpl(new StarryNetOperatorManager$messageOperator$1(this), str3);
        this.messageOperator = messageOperatorImpl;
        StarryNeGroupMessageOperatorImpl starryNeGroupMessageOperatorImpl = new StarryNeGroupMessageOperatorImpl();
        starryNeGroupMessageOperatorImpl.setProvider(superServiceProvider);
        this.groupMessageOperator = starryNeGroupMessageOperatorImpl;
        StarryNetDlnaServerOperatorImpl starryNetDlnaServerOperatorImpl = new StarryNetDlnaServerOperatorImpl();
        starryNetDlnaServerOperatorImpl.setProvider(superServiceProvider);
        this.starryNetDlnaServerOperator = starryNetDlnaServerOperatorImpl;
        VolumeChangeControllerOperatorImpl volumeChangeControllerOperatorImpl = new VolumeChangeControllerOperatorImpl();
        volumeChangeControllerOperatorImpl.setProvider(superServiceProvider);
        this.volumeChangeControllerOperator = volumeChangeControllerOperatorImpl;
        SappAbilityOperatorImpl sappAbilityOperatorImpl = new SappAbilityOperatorImpl();
        sappAbilityOperatorImpl.setProvider(superServiceProvider);
        this.sappAbilityOperator = sappAbilityOperatorImpl;
        NaviAbilityOperatorImpl naviAbilityOperatorImpl = new NaviAbilityOperatorImpl();
        naviAbilityOperatorImpl.setProvider(superServiceProvider);
        this.naviAbilityOperator = naviAbilityOperatorImpl;
        StarryNetAppOperatorImpl starryNetAppOperatorImpl = new StarryNetAppOperatorImpl();
        starryNetAppOperatorImpl.setProvider(superServiceProvider);
        this.starryNetAppOperator = starryNetAppOperatorImpl;
        StarryNetDeviceInfoOperatorImpl starryNetDeviceInfoOperatorImpl = new StarryNetDeviceInfoOperatorImpl();
        starryNetDeviceInfoOperatorImpl.setProvider(superServiceProvider);
        this.deviceInfoOperator = starryNetDeviceInfoOperatorImpl;
        StarryNetWifiOperatorImpl starryNetWifiOperatorImpl = new StarryNetWifiOperatorImpl();
        starryNetWifiOperatorImpl.setProvider(superServiceProvider);
        this.wifiOperator = starryNetWifiOperatorImpl;
        StarryNetDialerOperatorImpl starryNetDialerOperatorImpl = new StarryNetDialerOperatorImpl();
        starryNetDialerOperatorImpl.setProvider(superServiceProvider);
        this.dialerOperator = starryNetDialerOperatorImpl;
        AccountAbilityOperatorImpl accountAbilityOperatorImpl = new AccountAbilityOperatorImpl();
        accountAbilityOperatorImpl.setProvider(superServiceProvider);
        this.accountAbilityOperator = accountAbilityOperatorImpl;
        DataBinderOperatorImpl dataBinderOperatorImpl = new DataBinderOperatorImpl(superServiceProvider);
        this.dataBinderOperator = dataBinderOperatorImpl;
        DataBinderOperatorImpl dataBinderOperatorImpl2 = dataBinderOperatorImpl;
        TaskOperatorImpl taskOperatorImpl = new TaskOperatorImpl();
        taskOperatorImpl.setProvider(superServiceProvider);
        this.taskOperator = taskOperatorImpl;
        ResourceOperatorImpl resourceOperatorImpl = new ResourceOperatorImpl();
        resourceOperatorImpl.setProvider(superServiceProvider);
        this.resourceOperator = resourceOperatorImpl;
        TransAbilityOperatorImpl transAbilityOperatorImpl = new TransAbilityOperatorImpl();
        transAbilityOperatorImpl.setProvider(superServiceProvider);
        this.transAbilityOperator = transAbilityOperatorImpl;
        this.innerSuperServiceStateListeners = CollectionsKt.listOf(deviceOperatorImpl, starryNetFileOperatorImpl, messageOperatorImpl, starryNeGroupMessageOperatorImpl, starryNetDlnaServerOperatorImpl, volumeChangeControllerOperatorImpl, sappAbilityOperatorImpl, naviAbilityOperatorImpl, starryNetAppOperatorImpl, starryNetDeviceInfoOperatorImpl, starryNetWifiOperatorImpl, starryNetDialerOperatorImpl, accountAbilityOperatorImpl, dataBinderOperatorImpl2, transAbilityOperatorImpl);
        superServiceProvider.launch(context, str, str2);
    }

    @NotNull
    public AccountAbilityOperator getAccountAbilityOperator() {
        return this.accountAbilityOperator;
    }

    @NotNull
    public DataBinderOperator getDataBinderOperator() {
        return this.dataBinderOperator;
    }

    @NotNull
    public StarryNetDeviceInfoOperator getDeviceInfoOperator() {
        return this.deviceInfoOperator;
    }

    @NotNull
    public StarryNetDeviceOperator getDeviceOperator() {
        return this.deviceOperator;
    }

    @NotNull
    public StarryNetDialerOperator getDialerOperator() {
        return this.dialerOperator;
    }

    @NotNull
    public StarryNetFileOperator getFileOperator() {
        return this.fileOperator;
    }

    @NotNull
    public StarryNetGroupMessageOperator getGroupMessageOperator() {
        return this.groupMessageOperator;
    }

    @NotNull
    public InfoOperator getInfoOperator() {
        return this.infoOperator;
    }

    @NotNull
    public StarryNetMessageOperator getMessageOperator() {
        return this.messageOperator;
    }

    @NotNull
    public NaviAbilityOperator getNaviAbilityOperator() {
        return this.naviAbilityOperator;
    }

    @NotNull
    public ResourceOperator getResourceOperator() {
        return this.resourceOperator;
    }

    @NotNull
    public SappAbilityOperator getSappAbilityOperator() {
        return this.sappAbilityOperator;
    }

    @NotNull
    public StarryNetAppOperator getStarryNetAppOperator() {
        return this.starryNetAppOperator;
    }

    @NotNull
    public StarryNetDlnaServerOperator getStarryNetDlnaServerOperator() {
        return this.starryNetDlnaServerOperator;
    }

    @NotNull
    public TaskOperator getTaskOperator() {
        return this.taskOperator;
    }

    @NotNull
    public TransAbilityOperator getTransAbilityOperator() {
        return this.transAbilityOperator;
    }

    @NotNull
    public VolumeChangeControllerOperator getVolumeChangeControllerOperator() {
        return this.volumeChangeControllerOperator;
    }

    @NotNull
    public StarryNetWifiOperator getWifiOperator() {
        return this.wifiOperator;
    }

    public void onServiceConnected() {
        for (SuperServiceStateListener onServiceConnected : this.innerSuperServiceStateListeners) {
            onServiceConnected.onServiceConnected();
        }
        SuperServiceStateListener superServiceStateListener = this.outerSuperServiceStateListener;
        if (superServiceStateListener != null) {
            superServiceStateListener.onServiceConnected();
        }
    }

    public void onServiceDied() {
        for (SuperServiceStateListener onServiceDied : this.innerSuperServiceStateListeners) {
            onServiceDied.onServiceDied();
        }
        SuperServiceStateListener superServiceStateListener = this.outerSuperServiceStateListener;
        if (superServiceStateListener != null) {
            superServiceStateListener.onServiceDied();
        }
    }
}
