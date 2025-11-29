package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
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
import com.upuphone.xr.interconnect.business.databinder.DataBinderManager;
import com.upuphone.xr.interconnect.outer.InfoOperatorImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J\b\u0010.\u001a\u00020\u0010H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\u0014H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0018H\u0016J\b\u00103\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u001cH\u0016J\b\u00105\u001a\u00020\u001eH\u0016J\b\u00106\u001a\u00020 H\u0016J\b\u00107\u001a\u00020\"H\u0016J\b\u00108\u001a\u00020$H\u0016J\b\u00109\u001a\u00020&H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/upuphone/xr/interconnect/inner/InnerOperatorManager;", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "pkgName", "", "(Ljava/lang/String;)V", "accountAbilityOperator", "Lcom/upuphone/xr/interconnect/api/AccountAbilityOperator;", "deviceInfoOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceInfoOperator;", "deviceOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "dialerOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDialerOperator;", "fileOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetFileOperator;", "groupMessageOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetGroupMessageOperator;", "infoOperator", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "messageOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "naviAbilityOperator", "Lcom/upuphone/xr/interconnect/api/NaviAbilityOperator;", "resourceOperator", "Lcom/upuphone/xr/interconnect/api/ResourceOperator;", "sappAbilityOperator", "Lcom/upuphone/xr/interconnect/api/SappAbilityOperator;", "starryNetAppOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetAppOperator;", "starryNetDlnaServerOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDlnaServerOperator;", "taskOperator", "Lcom/upuphone/xr/interconnect/api/TaskOperator;", "transAbilityOperator", "Lcom/upuphone/xr/interconnect/api/TransAbilityOperator;", "volumeChangeControllerOperator", "Lcom/upuphone/xr/interconnect/api/VolumeChangeControllerOperator;", "wifiOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetWifiOperator;", "getAccountAbilityOperator", "getDataBinderOperator", "Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "getDeviceInfoOperator", "getDeviceOperator", "getDialerOperator", "getFileOperator", "getGroupMessageOperator", "getInfoOperator", "getMessageOperator", "getNaviAbilityOperator", "getResourceOperator", "getSappAbilityOperator", "getStarryNetAppOperator", "getStarryNetDlnaServerOperator", "getTaskOperator", "getTransAbilityOperator", "getVolumeChangeControllerOperator", "getWifiOperator", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InnerOperatorManager implements OperatorManager {
    @NotNull
    private final AccountAbilityOperator accountAbilityOperator;
    @NotNull
    private final StarryNetDeviceInfoOperator deviceInfoOperator;
    @NotNull
    private final StarryNetDeviceOperator deviceOperator;
    @NotNull
    private final StarryNetDialerOperator dialerOperator;
    @NotNull
    private final StarryNetFileOperator fileOperator;
    @NotNull
    private final StarryNetGroupMessageOperator groupMessageOperator = new InnerGroupMessageOperator();
    @NotNull
    private final InfoOperator infoOperator;
    @NotNull
    private final StarryNetMessageOperator messageOperator;
    @NotNull
    private final NaviAbilityOperator naviAbilityOperator;
    @NotNull
    private final ResourceOperator resourceOperator;
    @NotNull
    private final SappAbilityOperator sappAbilityOperator = new InnerSappAbilityOperator();
    @NotNull
    private final StarryNetAppOperator starryNetAppOperator;
    @NotNull
    private final StarryNetDlnaServerOperator starryNetDlnaServerOperator = new InnerDlnaServerOperator();
    @NotNull
    private final TaskOperator taskOperator;
    @NotNull
    private final TransAbilityOperator transAbilityOperator;
    @NotNull
    private final VolumeChangeControllerOperator volumeChangeControllerOperator = new InnerVolumeChangeController();
    @NotNull
    private final StarryNetWifiOperator wifiOperator;

    public InnerOperatorManager(@Nullable String str) {
        this.deviceOperator = new InnerDeviceOperator(str);
        this.fileOperator = new InnerFileOperator(str);
        this.messageOperator = new InnerMessageOperator(str);
        this.starryNetAppOperator = new InnerStarryNetAppOperator(str);
        this.naviAbilityOperator = new InnerNaviAbilityOperator();
        this.deviceInfoOperator = new InnerDeviceInfoOperator();
        this.wifiOperator = new InnerWifiOperator();
        this.dialerOperator = new InnerDialerOperator(str);
        this.accountAbilityOperator = new InnerAccountAbilityOperator();
        this.taskOperator = new InnerTaskOperator();
        this.resourceOperator = new InnerResourceOperator();
        this.transAbilityOperator = new InnerTransAbilityOperator();
        this.infoOperator = new InfoOperatorImpl(new InnerOperatorManager$infoOperator$1(this));
    }

    @NotNull
    public AccountAbilityOperator getAccountAbilityOperator() {
        return this.accountAbilityOperator;
    }

    @NotNull
    public DataBinderOperator getDataBinderOperator() {
        DataBinderManager dataBinderManager = InterconnectManager.getInstance().getDataBinderManager();
        Intrinsics.checkNotNullExpressionValue(dataBinderManager, "getDataBinderManager(...)");
        return dataBinderManager;
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
}
