package com.upuphone.xr.sapp.vm;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.honey.account.z8.a;
import com.honey.account.z8.b;
import com.honey.account.z8.c;
import com.honey.account.z8.d;
import com.honey.account.z8.e;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.model.IPlaceInfo;
import com.upuphone.runasone.error.ConnectErrorCode;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.core.dns.ErrorCode;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceDiscoverListener;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.ability.PhoneSappAbility;
import com.upuphone.xr.sapp.audio.ArAudioFocusManager;
import com.upuphone.xr.sapp.entity.ConnectState;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.utils.AssociateUserManager;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.SingleLiveData;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.xjmz.myvu.ext.ContextExtKt;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0019\u0010 \u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b'\u0010\u0010J!\u0010,\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\bJ\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\bJ\u0017\u00100\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b0\u0010\u0010J\u000f\u00101\u001a\u00020*H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0014¢\u0006\u0004\b3\u0010\bJ\u0015\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\u00062\u0006\u00105\u001a\u000204¢\u0006\u0004\b8\u00107J\u001f\u00109\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b9\u0010-J!\u0010<\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010;\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\r¢\u0006\u0004\b?\u0010\u0010J\r\u0010@\u001a\u00020*¢\u0006\u0004\b@\u00102J\r\u0010A\u001a\u00020\u0006¢\u0006\u0004\bA\u0010\bJ\r\u0010B\u001a\u00020\u0006¢\u0006\u0004\bB\u0010\bJ\r\u0010C\u001a\u00020\u0006¢\u0006\u0004\bC\u0010\bR\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020E0D8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020E0K8\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020E0O8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020U0D8\u0006¢\u0006\f\n\u0004\bV\u0010G\u001a\u0004\bW\u0010IR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\r0K8\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010MR\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\r0O8\u0006¢\u0006\f\n\u0004\b[\u0010Q\u001a\u0004\b\\\u0010SR\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020^0K8\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010MR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020^0O8\u0006¢\u0006\f\n\u0004\ba\u0010Q\u001a\u0004\bb\u0010SR\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020d0K8\u0006¢\u0006\f\n\u0004\be\u0010M\u001a\u0004\bf\u0010gR\u001d\u0010k\u001a\b\u0012\u0004\u0012\u00020d0O8\u0006¢\u0006\f\n\u0004\bi\u0010Q\u001a\u0004\bj\u0010SR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020^0D8\u0006¢\u0006\f\n\u0004\bl\u0010G\u001a\u0004\bm\u0010IR\u0018\u0010q\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010w\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010z\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001a\u0010\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010\u0014R\u0018\u0010\u0001\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010\u0014R'\u0010\u0001\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010\u0014\u001a\u0005\b\u0001\u00102\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "b0", "()V", "v0", "R", "H", "W", "", "deviceId", "c0", "(Ljava/lang/String;)V", "B", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "listener", "Z", "(Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;)V", "z0", "Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener$Stub;", "X", "(Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener$Stub;)V", "w0", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "Y", "(Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;)V", "y0", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "a0", "(Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;)V", "A0", "", "error", "K", "(I)I", "B0", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "", "isOnline", "V", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;Z)V", "e0", "o0", "F", "U", "()Z", "onCleared", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "m0", "(Lcom/upuphone/xr/sapp/vm/SuperViewModel;)V", "i0", "D", "devId", "devName", "E", "(Ljava/lang/String;Ljava/lang/String;)V", "deviceInfo", "l0", "S", "n0", "j0", "I", "Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "Lcom/upuphone/xr/sapp/entity/DeviceState;", "b", "Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "O", "()Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "mDeviceDiscoverState", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "_mDeviceBoundState", "Landroidx/lifecycle/LiveData;", "d", "Landroidx/lifecycle/LiveData;", "M", "()Landroidx/lifecycle/LiveData;", "mDeviceBoundState", "Lcom/upuphone/xr/sapp/guide/model/ConnectResult;", "e", "N", "mDeviceConnectFail", "f", "_connectDeviceInfo", "g", "getConnectDeviceInfo", "connectDeviceInfo", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "h", "_connectDevice", "i", "L", "connectDevice", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;", "j", "Q", "()Landroidx/lifecycle/MutableLiveData;", "_selectDevice", "k", "P", "selectDevice", "l", "getSingleConnectDevice", "singleConnectDevice", "m", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "mDeviceDiscover", "n", "Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener$Stub;", "mDeviceBoundCallback", "o", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "mConnectionListener", "p", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "mConnectStateCallback", "Landroid/content/BroadcastReceiver;", "q", "Landroid/content/BroadcastReceiver;", "foregroundAndBluetoothStateReceiver", "r", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "mSuperViewModel", "Landroid/os/Handler;", "s", "Landroid/os/Handler;", "mHandler", "t", "mCheckStarryNetConnectState", "u", "mNeedAutoConnect", "v", "getChangeName", "k0", "(Z)V", "changeName", "w", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DeviceControlModel extends AndroidViewModel {
    public static final Companion w = new Companion((DefaultConstructorMarker) null);
    public final SingleLiveData b = new SingleLiveData();
    public final MutableLiveData c;
    public final LiveData d;
    public final SingleLiveData e;
    public final MutableLiveData f;
    public final LiveData g;
    public final MutableLiveData h;
    public final LiveData i;
    public final MutableLiveData j;
    public final LiveData k;
    public final SingleLiveData l;
    public StarryNetDeviceDiscoverListener m;
    public IDeviceBondStateListener.Stub n;
    public DeviceConnectionListener o;
    public StarryNetDeviceStateChangeListener p;
    public BroadcastReceiver q;
    public SuperViewModel r;
    public Handler s;
    public boolean t;
    public boolean u;
    public boolean v;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/vm/DeviceControlModel$Companion;", "", "()V", "FLY_ME_ROM_UPDATE_TYPE", "", "PP_DELAY_TIME", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceControlModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        this.d = mutableLiveData;
        this.e = new SingleLiveData();
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.f = mutableLiveData2;
        this.g = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.h = mutableLiveData3;
        this.i = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        this.j = mutableLiveData4;
        this.k = mutableLiveData4;
        this.l = new SingleLiveData();
        this.s = new Handler(Looper.getMainLooper());
    }

    public static final void G(DeviceControlModel deviceControlModel, String str) {
        Intrinsics.checkNotNullParameter(deviceControlModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "$deviceId");
        if (deviceControlModel.U() && Build.VERSION.SDK_INT > 33) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("DeviceControlModel", "checkStarryNetConnectState::disconnectDevice:" + str);
            deviceControlModel.u = true;
            InterconnectManager.getInstance().getStarryNetDeviceManager().disconnectDevice(str);
            StarryNetHelper.f7917a.k();
        }
        deviceControlModel.t = false;
    }

    private final void R() {
        this.m = new DeviceControlModel$initListener$1(this);
        this.n = new DeviceControlModel$initListener$2(this);
        this.o = new DeviceControlModel$initListener$3(this);
        this.p = new DeviceControlModel$initListener$4(this);
        this.q = new DeviceControlModel$initListener$5(this);
    }

    public static final void g0() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            NaviManager.getInstance(GlobalExtKt.f()).getLocationInfo(GlobalExtKt.f(), new d());
        }
    }

    public static final void h0(PlaceBean placeBean) {
        if (placeBean != null) {
            NaviManager.getInstance(GlobalExtKt.f()).getLocationInfo(GlobalExtKt.f(), (IPlaceInfo) null);
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            String str = (String) DataStoreUtils.i(companion.a(), "current_active_location", "", (Context) null, 4, (Object) null);
            ULog.Delegate delegate = ULog.f6446a;
            String str2 = placeBean.countryCode;
            delegate.a("DeviceControlModel", "onPlaceSearched:requestPolicyState::place is: " + str2 + " and location is: " + str);
            if (str.length() == 0) {
                PhoneSappAbility.Companion companion2 = PhoneSappAbility.h;
                PhoneSappAbility.l(companion2.a(), "glass_pp", (String) null, 2, (Object) null);
                companion.a().o("current_active_location", placeBean.countryCode);
                if (Intrinsics.areEqual((Object) placeBean.countryCode, (Object) "MYS")) {
                    companion2.a().p("myvu_pp", System.currentTimeMillis());
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) "MYS")) {
                PhoneSappAbility.l(PhoneSappAbility.h.a(), "myvu_pp", (String) null, 2, (Object) null);
            }
        }
    }

    public static final void s0() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            NaviManager.getInstance(GlobalExtKt.f()).getLocationInfo(GlobalExtKt.f(), new e());
        }
    }

    public static final void u0(PlaceBean placeBean) {
        if (placeBean != null) {
            NaviManager.getInstance(GlobalExtKt.f()).getLocationInfo(GlobalExtKt.f(), (IPlaceInfo) null);
            ULog.Delegate delegate = ULog.f6446a;
            String str = placeBean.countryCode;
            delegate.a("DeviceControlModel", "onPlaceSearched:submitGlassPolicyState::place is: " + str);
            if (Intrinsics.areEqual((Object) placeBean.countryCode, (Object) "MYS")) {
                PhoneSappAbility.h.a().p("glass_pp", System.currentTimeMillis());
            }
        }
    }

    public final void A0(StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceStateChangeListener(starryNetDeviceStateChangeListener);
    }

    public final void B(String str) {
        if (str != null) {
            ArAudioFocusManager.f6641a.f(str);
        }
    }

    public final void B0(String str) {
        DynamicAdapterUtils.f7879a.c(this, str);
    }

    public final void D(StarryNetDevice starryNetDevice, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        StarryNetDevice starryNetDevice2 = starryNetDevice;
        boolean z2 = z;
        if (starryNetDevice2 != null) {
            ULog.Delegate delegate = ULog.f6446a;
            String deviceName = starryNetDevice.getDeviceName();
            delegate.a("DeviceControlModel", "addOrMoveDevice::device key:" + deviceName + " isOnline is: " + z2);
            if (!z2) {
                MutableLiveData mutableLiveData = this.h;
                String deviceId = starryNetDevice.getDeviceId();
                ControlUtils controlUtils = ControlUtils.f7858a;
                String f2 = controlUtils.f();
                ConnectState connectState = ConnectState.UNCONNECTED;
                long currentTimeMillis = System.currentTimeMillis();
                String modelId = starryNetDevice.getModelId();
                if (modelId == null) {
                    str3 = "";
                } else {
                    Intrinsics.checkNotNull(modelId);
                    str3 = modelId;
                }
                mutableLiveData.postValue(new NetDevice(deviceId, f2, connectState, false, currentTimeMillis, str3, 8, (DefaultConstructorMarker) null));
                SingleLiveData singleLiveData = this.l;
                String deviceId2 = starryNetDevice.getDeviceId();
                String f3 = controlUtils.f();
                String modelId2 = starryNetDevice.getModelId();
                if (modelId2 == null) {
                    str4 = "";
                } else {
                    Intrinsics.checkNotNull(modelId2);
                    str4 = modelId2;
                }
                singleLiveData.postValue(new NetDevice(deviceId2, f3, connectState, false, 0, str4, 24, (DefaultConstructorMarker) null));
                V((StarryNetDevice) null, false);
                return;
            }
            StarryNetHelper starryNetHelper = StarryNetHelper.f7917a;
            String deviceId3 = starryNetDevice.getDeviceId();
            Intrinsics.checkNotNullExpressionValue(deviceId3, "getDeviceId(...)");
            String d2 = starryNetHelper.d(deviceId3);
            ControlUtils controlUtils2 = ControlUtils.f7858a;
            String deviceName2 = d2 == null ? starryNetDevice.getDeviceName() : d2;
            Intrinsics.checkNotNull(deviceName2);
            controlUtils2.i0(deviceName2);
            MutableLiveData mutableLiveData2 = this.h;
            String deviceId4 = starryNetDevice.getDeviceId();
            String deviceName3 = d2 == null ? starryNetDevice.getDeviceName() : d2;
            ConnectState connectState2 = ConnectState.CONNECTED;
            long currentTimeMillis2 = System.currentTimeMillis();
            String modelId3 = starryNetDevice.getModelId();
            if (modelId3 == null) {
                str = "";
            } else {
                Intrinsics.checkNotNull(modelId3);
                str = modelId3;
            }
            mutableLiveData2.postValue(new NetDevice(deviceId4, deviceName3, connectState2, this.v, currentTimeMillis2, str));
            SingleLiveData singleLiveData2 = this.l;
            String deviceId5 = starryNetDevice.getDeviceId();
            if (d2 == null) {
                d2 = starryNetDevice.getDeviceName();
            }
            String str5 = d2;
            String modelId4 = starryNetDevice.getModelId();
            if (modelId4 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNull(modelId4);
                str2 = modelId4;
            }
            singleLiveData2.postValue(new NetDevice(deviceId5, str5, connectState2, false, 0, str2, 24, (DefaultConstructorMarker) null));
            V(starryNetDevice2, true);
        }
    }

    public final void E(String str, String str2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceControlModel", "changeConnectDevice ... deviceId = " + str + ",deviceName = " + str2);
        NetDevice netDevice = (NetDevice) this.i.getValue();
        if (netDevice != null && Intrinsics.areEqual((Object) str, (Object) netDevice.getMIdentifier()) && str2 != null) {
            this.v = true;
            ControlUtils.f7858a.i0(str2);
            this.h.postValue(new NetDevice(str, str2, netDevice.getState(), true, 0, (String) null, 48, (DefaultConstructorMarker) null));
            this.l.postValue(new NetDevice(str, str2, netDevice.getState(), false, 0, (String) null, 56, (DefaultConstructorMarker) null));
        }
    }

    public final void F(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = this.t;
        delegate.a("DeviceControlModel", "checkStarryNetConnectState::mCheckStarryNetConnectState:" + z);
        if (!this.t) {
            this.t = true;
            this.s.removeCallbacksAndMessages((Object) null);
            this.s.postDelayed(new c(this, str), 10000);
            InterconnectManager.getInstance().checkStarryNetStatus(str, new DeviceControlModel$checkStarryNetConnectState$2(this));
        }
    }

    public final void H() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("DeviceControlModel", "commandAfterCheckStartDiscovery start");
        if (this.h.getValue() != null) {
            delegate.c("DeviceControlModel", "commandAfterCheckStartDiscovery _connectDevice is not null");
            MutableLiveData mutableLiveData = this.h;
            mutableLiveData.postValue(mutableLiveData.getValue());
            return;
        }
        delegate.c("DeviceControlModel", "commandAfterCheckStartDiscovery _connectDevice is null");
        StarryNetDevice bondedDevice = XrSdkBondDeviceUtil.INSTANCE.getBondedDevice(MainApplication.k.d());
        if (bondedDevice != null) {
            MutableLiveData mutableLiveData2 = this.h;
            String deviceId = bondedDevice.getDeviceId();
            String f2 = ControlUtils.f7858a.f();
            ConnectState connectState = ConnectState.UNCONNECTED;
            long currentTimeMillis = System.currentTimeMillis();
            String modelId = bondedDevice.getModelId();
            if (modelId == null) {
                modelId = "";
            } else {
                Intrinsics.checkNotNull(modelId);
            }
            mutableLiveData2.postValue(new NetDevice(deviceId, f2, connectState, false, currentTimeMillis, modelId, 8, (DefaultConstructorMarker) null));
        }
    }

    public final void I() {
        String mIdentifier;
        if (S()) {
            ULog.Delegate delegate = ULog.f6446a;
            NetDevice netDevice = (NetDevice) this.i.getValue();
            String mIdentifier2 = netDevice != null ? netDevice.getMIdentifier() : null;
            delegate.a("DeviceControlModel", "disconnectGlasses::disconnectDevice: " + mIdentifier2);
            NetDevice netDevice2 = (NetDevice) this.i.getValue();
            if (netDevice2 != null && (mIdentifier = netDevice2.getMIdentifier()) != null) {
                InterconnectManager.getInstance().getStarryNetDeviceManager().disconnectDevice(mIdentifier);
            }
        }
    }

    public final int K(int i2) {
        switch (i2) {
            case StErrorCode.CONNECT_STRATEGY_BLE_AUTH_TIMEOUT:
                return -300;
            case StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR:
            case StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_PARAM_ERROR:
            case ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID:
                return ErrorCode.ERROR_START_DIS_EXCEPTION;
            default:
                return -100;
        }
    }

    public final LiveData L() {
        return this.i;
    }

    public final LiveData M() {
        return this.d;
    }

    public final SingleLiveData N() {
        return this.e;
    }

    public final SingleLiveData O() {
        return this.b;
    }

    public final LiveData P() {
        return this.k;
    }

    public final MutableLiveData Q() {
        return this.j;
    }

    public final boolean S() {
        NetDevice netDevice = (NetDevice) this.i.getValue();
        return (netDevice != null ? netDevice.getState() : null) == ConnectState.CONNECTED;
    }

    public final boolean U() {
        String str = Build.HARDWARE;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceControlModel", "hardware is: " + str);
        Intrinsics.checkNotNull(str);
        if (!new Regex("mt[0-9]*").matches(str) && !PhoneTypeUtils.f7912a.k()) {
            return false;
        }
        delegate.a("DeviceControlModel", "MediaTek platform");
        return true;
    }

    public final void V(StarryNetDevice starryNetDevice, boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceControlModel", "notifyDeviceState::state:" + z + " devices:" + starryNetDevice);
        Context baseContext = ((MainApplication) c()).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
        if (!StaticMethodUtilsKt.m(baseContext, 50)) {
            delegate.a("DeviceControlModel", "notifyDeviceState::send broadcast");
            Intent intent = new Intent("action_discovery_device");
            intent.putExtra("device", starryNetDevice);
            intent.putExtra("device_online", z);
            ((MainApplication) c()).sendBroadcast(intent);
        }
    }

    public final void W() {
        ULog.f6446a.a("DeviceControlModel", "onNewDeviceBind");
        AssociateUserManager.c.a().f();
    }

    public final void X(IDeviceBondStateListener.Stub stub) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceBondStateListener(stub);
    }

    public final void Y(DeviceConnectionListener deviceConnectionListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceConnectionPriorityListener(deviceConnectionListener);
    }

    public final void Z(StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceDiscoverListener(starryNetDeviceDiscoverListener);
    }

    public final void a0(StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceStateChangeListener(starryNetDeviceStateChangeListener);
    }

    public final void b0() {
        ULog.f6446a.a("DeviceControlModel", "DeviceControlModel register callback");
        Z(this.m);
        X(this.n);
        Y(this.o);
        a0(this.p);
        MainApplication d2 = MainApplication.k.d();
        BroadcastReceiver broadcastReceiver = this.q;
        Intrinsics.checkNotNull(broadcastReceiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_notify_foreground");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        Unit unit = Unit.INSTANCE;
        ContextExtKt.a(d2, broadcastReceiver, intentFilter);
    }

    public final void c0(String str) {
        ArAudioFocusManager.f6641a.i(str);
    }

    public final void e0() {
        new Handler(((MainApplication) c()).getBaseContext().getMainLooper()).postDelayed(new a(), 4000);
    }

    public final void i0(SuperViewModel superViewModel) {
        Intrinsics.checkNotNullParameter(superViewModel, "viewModel");
        ULog.f6446a.a("DeviceControlModel", "resetMainViewModel init");
        this.r = superViewModel;
    }

    public final void j0() {
        DevicesConnector.getInstance().setDeviceConnectable(true, 2, (String) null);
    }

    public final void k0(boolean z) {
        this.v = z;
    }

    public final void l0(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceInfo");
        this.f.postValue(str);
    }

    public final void m0(SuperViewModel superViewModel) {
        Intrinsics.checkNotNullParameter(superViewModel, "viewModel");
        this.r = superViewModel;
        ULog.f6446a.a("DeviceControlModel", "DeviceControlModel init");
        v0();
        R();
        b0();
    }

    public final void n0() {
        DevicesConnector.getInstance().setDeviceConnectable(false, 2, (String) null);
    }

    public final void o0() {
        new Handler(((MainApplication) c()).getBaseContext().getMainLooper()).postDelayed(new b(), AssistantConstants.TIMEOUT_VAD_MUTE);
    }

    public void onCleared() {
        super.onCleared();
        ULog.f6446a.a("DeviceControlModel", "DeviceControlModel clear");
        z0(this.m);
        w0(this.n);
        y0(this.o);
        A0(this.p);
        this.s.removeCallbacksAndMessages((Object) null);
    }

    public final void v0() {
        try {
            ULog.f6446a.a("DeviceControlModel", "DeviceControlModel unregisterBeforeInit");
            z0(this.m);
            w0(this.n);
            y0(this.o);
            A0(this.p);
            BroadcastReceiver broadcastReceiver = this.q;
            if (broadcastReceiver != null) {
                MainApplication.k.d().unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e2.getMessage();
            delegate.a("DeviceControlModel", "unregisterBeforeInit e: " + message);
        }
    }

    public final void w0(IDeviceBondStateListener.Stub stub) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceBondStateListener(stub);
    }

    public final void y0(DeviceConnectionListener deviceConnectionListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceConnectionPriorityListener(deviceConnectionListener);
    }

    public final void z0(StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceDiscoverListener(starryNetDeviceDiscoverListener);
    }
}
