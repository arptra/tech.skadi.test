package com.xjmz.myvu.flutter.pigeon.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.honey.account.s9.b;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.ability.relay.BypassListener;
import com.upuphone.xr.interconnect.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceDiscoverListener;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.ring2.SportService;
import com.upuphone.xr.sapp.utils.OSHelper;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.xjmz.myvu.common.ConnectVoidResult;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.ext.DeviceInfoExtKt;
import com.xjmz.myvu.flutter.base.BaseFlutterFragment;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010\u001aJ\u000f\u0010 \u001a\u00020\u0018H\u0002¢\u0006\u0004\b \u0010\u001aJ\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020#2\u0006\u0010\"\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010/J\u001b\u00102\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00107\u001a\u00020\u00182\u0006\u00105\u001a\u0002042\u0006\u0010\u0004\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u0002092\u0006\u0010\u0004\u001a\u000206H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u000206H\u0002¢\u0006\u0004\b<\u0010=J\u0018\u0010>\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u000206H@¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u000206H@¢\u0006\u0004\b@\u0010?J\u000f\u0010A\u001a\u00020\u0018H\u0016¢\u0006\u0004\bA\u0010\u001aJ\u000f\u0010B\u001a\u00020\u0018H\u0016¢\u0006\u0004\bB\u0010\u001aJ\u0017\u0010D\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u0007H\u0016¢\u0006\u0004\bD\u0010EJ%\u0010H\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u0002090FH\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u0007H\u0016¢\u0006\u0004\bJ\u0010EJ\u0015\u0010L\u001a\b\u0012\u0004\u0012\u00020#0KH\u0016¢\u0006\u0004\bL\u0010MJ\u0015\u0010N\u001a\b\u0012\u0004\u0012\u00020#0KH\u0016¢\u0006\u0004\bN\u0010MJ\u0017\u0010O\u001a\u0002092\u0006\u0010C\u001a\u00020\u0007H\u0016¢\u0006\u0004\bO\u0010PJ\u001f\u0010R\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00072\u0006\u0010Q\u001a\u000200H\u0016¢\u0006\u0004\bR\u0010SJ\u0017\u0010V\u001a\u00020\u00182\u0006\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bV\u0010WJ=\u0010\\\u001a\u00020\u00182\b\u0010C\u001a\u0004\u0018\u00010\u00072\b\u0010X\u001a\u0004\u0018\u00010\u00072\b\u0010Y\u001a\u0004\u0018\u00010\u00072\u0006\u0010Q\u001a\u0002002\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010d\u001a\u00020\u00078\u0002XD¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010f\u001a\u00020\u00078\u0002XD¢\u0006\u0006\n\u0004\be\u0010cR\u0014\u0010h\u001a\u00020\u00078\u0002XD¢\u0006\u0006\n\u0004\bg\u0010cR\u001c\u0010m\u001a\n j*\u0004\u0018\u00010i0i8\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001a\u0010\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R\u0019\u0010\u0001\u001a\u00020Z8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\bR\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$StarryNetApi;", "Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;", "Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "fragment", "<init>", "(Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;)V", "", "tag", "Lio/flutter/embedding/engine/FlutterEngine;", "c0", "(Ljava/lang/String;)Lio/flutter/embedding/engine/FlutterEngine;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$FlutterStarryNetApi;", "m0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$FlutterStarryNetApi;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$ScanDeviceCallback;", "k0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$ScanDeviceCallback;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$SendMessageCallback;", "l0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$SendMessageCallback;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;", "W", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;", "", "T", "()V", "g0", "d0", "a0", "()Ljava/lang/String;", "f0", "n0", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$StarryNetDevice;", "p0", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$StarryNetDevice;", "Lcom/upuphone/runasone/device/StarryDevice;", "o0", "(Lcom/upuphone/runasone/device/StarryDevice;)Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$StarryNetDevice;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$AppCountryType;", "Z", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$AppCountryType;", "modelId", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$DeviceCountryType;", "b0", "(Ljava/lang/String;)Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$DeviceCountryType;", "", "array", "X", "([B)[B", "Landroid/content/Context;", "context", "Landroidx/fragment/app/Fragment;", "V", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "", "U", "(Landroidx/fragment/app/Fragment;)Z", "h0", "(Landroidx/fragment/app/Fragment;)V", "j0", "(Landroidx/fragment/app/Fragment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i0", "u", "v", "deviceId", "t", "(Ljava/lang/String;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$Result;", "result", "A", "(Ljava/lang/String;Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$Result;)V", "disconnect", "", "getBondedDevice", "()Ljava/util/List;", "getConnectedDevice", "e0", "(Ljava/lang/String;)Z", "data", "l", "(Ljava/lang/String;[B)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$Ring2BatteryInfo;", "batteryInfo", "w", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidRingStarryNetApi$Ring2BatteryInfo;)V", "service", "character", "", "msgType", "onMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BI)V", "a", "Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "getFragment", "()Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "b", "Ljava/lang/String;", "SERVICE_DATA", "c", "SEND_DATA", "d", "RECEIVE_DATA", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceManager;", "kotlin.jvm.PlatformType", "e", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceManager;", "deviceManager", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "f", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "mDeviceDiscover", "Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener$Stub;", "g", "Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener$Stub;", "mDeviceBoundCallback", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "h", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "mConnectionListener", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "i", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "mConnectStateCallback", "Lcom/upuphone/xr/interconnect/InterconnectManager$OnStarrySdkStateChangeListener;", "j", "Lcom/upuphone/xr/interconnect/InterconnectManager$OnStarrySdkStateChangeListener;", "mAbilityStateListener", "k", "I", "searchTime", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMsgConfig;", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMsgConfig;", "messageConfig", "m", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStarryNetApiHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarryNetApiHandler.kt\ncom/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,609:1\n1855#2,2:610\n*S KotlinDebug\n*F\n+ 1 StarryNetApiHandler.kt\ncom/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler\n*L\n311#1:610,2\n*E\n"})
public final class StarryNetApiHandler implements AndroidRingStarryNetApi.StarryNetApi, BypassListener {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);
    public static MutableLiveData n = new MutableLiveData(Boolean.FALSE);

    /* renamed from: a  reason: collision with root package name */
    public final BaseFlutterFragment f8354a;
    public final String b = Constants.SERVICE_DATA;
    public final String c = Constants.DATA_Characteristic;
    public final String d = Constants.NOTIY_Characteristic;
    public final StarryNetDeviceManager e = InterconnectManager.getInstance().getStarryNetDeviceManager();
    public StarryNetDeviceDiscoverListener f;
    public IDeviceBondStateListener.Stub g;
    public DeviceConnectionListener h;
    public StarryNetDeviceStateChangeListener i;
    public InterconnectManager.OnStarrySdkStateChangeListener j;
    public int k;
    public final StarryNetRingMsgConfig l;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R0\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler$Companion;", "", "<init>", "()V", "", "b", "e", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "isStarryNetRegistered", "Landroidx/lifecycle/MutableLiveData;", "d", "()Landroidx/lifecycle/MutableLiveData;", "setStarryNetRegistered", "(Landroidx/lifecycle/MutableLiveData;)V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void c(boolean z) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "StarryNet SDK 初始化: " + z);
            StarryNetApiHandler.m.d().postValue(Boolean.valueOf(z));
        }

        public final void b() {
            InterconnectManager.getInstance().registerOnStarrySdkStateChangeListener(new b());
        }

        public final MutableLiveData d() {
            return StarryNetApiHandler.n;
        }

        public final void e() {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "unbindAllRing2");
            StarryNetDevice bondedRingDevice = XrSdkBondDeviceUtil.INSTANCE.getBondedRingDevice(MainApplication.k.d());
            if (bondedRingDevice != null) {
                delegate.g("StarryNetApiHandler", "unbindAllRing2 device: " + bondedRingDevice);
                InterconnectManager.getInstance().getStarryNetDeviceManager().unBondDevice(bondedRingDevice.getDeviceId());
            }
        }

        public Companion() {
        }
    }

    public StarryNetApiHandler(BaseFlutterFragment baseFlutterFragment) {
        Intrinsics.checkNotNullParameter(baseFlutterFragment, "fragment");
        this.f8354a = baseFlutterFragment;
        StarryNetRingMsgConfig starryNetRingMsgConfig = new StarryNetRingMsgConfig();
        starryNetRingMsgConfig.setServiceData(Constants.SERVICE_DATA);
        starryNetRingMsgConfig.setCharacteristic(Constants.DATA_Characteristic);
        starryNetRingMsgConfig.setVersion("2");
        this.l = starryNetRingMsgConfig;
        d0();
        baseFlutterFragment.getLifecycle().a(new DefaultLifecycleObserver(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ StarryNetApiHandler f8355a;

            {
                this.f8355a = r1;
            }

            public void onCreate(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                ULog.f6446a.g("StarryNetApiHandler", "onCreate addListener");
                this.f8355a.T();
            }

            public void onDestroy(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                ULog.f6446a.g("StarryNetApiHandler", " onDestroy removeListener");
                this.f8355a.g0();
            }
        });
    }

    public static /* synthetic */ byte[] Y(StarryNetApiHandler starryNetApiHandler, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr = null;
        }
        return starryNetApiHandler.X(bArr);
    }

    public void A(String str, AndroidRingStarryNetApi.Result result) {
        Intrinsics.checkNotNullParameter(str, com.upuphone.runasone.constant.Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "unbindRing: " + str);
        result.success(Boolean.valueOf(this.e.unBondDevice(str)));
    }

    public final void T() {
        this.e.registerDeviceDiscoverListener(this.f);
        this.e.registerDeviceBondStateListener(this.g);
        this.e.registerDeviceConnectionPriorityListener(this.h);
        this.e.registerDeviceStateChangeListener(this.i);
        InterconnectManager.getInstance().registerOnStarrySdkStateChangeListener(this.j);
    }

    public final boolean U(Fragment fragment) {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (!bool.booleanValue()) {
            return true;
        }
        h0(fragment);
        return false;
    }

    public final void V(Context context, Fragment fragment) {
        boolean l2 = StaticMethodUtilsKt.l(context);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "initEvent::enhancedServiceOpen is:" + l2 + ",binding.addGlass.tag = ring2");
        if (!l2) {
            StaticMethodUtilsKt.R(fragment);
        } else if (OSHelper.f7904a.d() && !PermissionAndStateCheckUtils.f7907a.f(context)) {
            StaticMethodUtilsKt.I(fragment, CollectionsKt.arrayListOf(102), false, false, 6, (Object) null);
        } else if (!PermissionAndStateCheckUtils.f7907a.b(context)) {
            StaticMethodUtilsKt.I(fragment, CollectionsKt.arrayListOf(110), false, false, 6, (Object) null);
        } else if (U(fragment)) {
            Object value = n.getValue();
            delegate.g("StarryNetApiHandler", "hasPermission = true，初始化StarryNet SDK: " + value);
            if (!Intrinsics.areEqual(n.getValue(), (Object) Boolean.TRUE)) {
                InterconnectManager.getInstance().init(MainApplication.k.d(), 0);
            }
        }
    }

    public final AndroidConnectApi.FlutterConnectApi W() {
        FlutterEngine c0 = c0("connectApi");
        if (c0 == null) {
            return null;
        }
        return new AndroidConnectApi.FlutterConnectApi(c0.getDartExecutor().getBinaryMessenger());
    }

    public final byte[] X(byte[] bArr) {
        return bArr == null ? new byte[0] : bArr;
    }

    public final AndroidRingStarryNetApi.AppCountryType Z() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        return bool.booleanValue() ? AndroidRingStarryNetApi.AppCountryType.OVERSEA : AndroidRingStarryNetApi.AppCountryType.CHINA;
    }

    public /* bridge */ /* synthetic */ Boolean a(String str) {
        return Boolean.valueOf(e0(str));
    }

    public final String a0() {
        return "MYYUBypassListener-Ring2";
    }

    public final AndroidRingStarryNetApi.DeviceCountryType b0(String str) {
        return Intrinsics.areEqual((Object) str, (Object) "1201") ? AndroidRingStarryNetApi.DeviceCountryType.CHINA : Intrinsics.areEqual((Object) str, (Object) "1202") ? AndroidRingStarryNetApi.DeviceCountryType.OVERSEA : AndroidRingStarryNetApi.DeviceCountryType.UNKNOWN;
    }

    public final FlutterEngine c0(String str) {
        try {
            if (!this.f8354a.isDetached()) {
                return this.f8354a.getFlutterEngine();
            }
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "getEngine() tag: " + str + " fragment is detached");
            return null;
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.g("StarryNetApiHandler", " getEngine() tag: " + str + " error: " + e2);
            return null;
        }
    }

    public final void d0() {
        this.f = new StarryNetApiHandler$initListener$1(this);
        this.g = new StarryNetApiHandler$initListener$2(this);
        this.h = new StarryNetApiHandler$initListener$3(this);
        this.i = new StarryNetApiHandler$initListener$4(this);
        this.j = new StarryNetApiHandler$initListener$5(this);
    }

    public void disconnect(String str) {
        Intrinsics.checkNotNullParameter(str, com.upuphone.runasone.constant.Constants.DEVICE_ID);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "disconnect: " + str);
        this.e.disconnectDevice(str);
    }

    public boolean e0(String str) {
        Intrinsics.checkNotNullParameter(str, com.upuphone.runasone.constant.Constants.DEVICE_ID);
        StarryNetDevice bondedRingDevice = XrSdkBondDeviceUtil.INSTANCE.getBondedRingDevice(MainApplication.k.d());
        return Intrinsics.areEqual((Object) bondedRingDevice != null ? bondedRingDevice.getDeviceId() : null, (Object) str);
    }

    public final void f0() {
        ULog.f6446a.g("StarryNetApiHandler", "notifyHistoryDevices");
        List<AndroidConnectApi.DeviceInfo> b2 = ConnectExtKt.b();
        for (AndroidConnectApi.DeviceInfo a2 : b2) {
            ULog.Delegate delegate = ULog.f6446a;
            String a3 = DeviceInfoExtKt.a(a2);
            delegate.g("StarryNetApiHandler", "notifyHistoryDevices() called: " + a3);
        }
        AndroidConnectApi.FlutterConnectApi W = W();
        if (W != null) {
            W.j(b2, new ConnectVoidResult());
        }
    }

    public final void g0() {
        this.e.unregisterDeviceDiscoverListener(this.f);
        this.e.unregisterDeviceBondStateListener(this.g);
        this.e.unregisterDeviceConnectionPriorityListener(this.h);
        this.e.unregisterDeviceStateChangeListener(this.i);
        InterconnectManager.getInstance().unregisterOnStarrySdkStateChangeListener(this.j);
        StarryNetAbilityManager.getInstance().unRegisterMultiBypassAbility(this.b, this.c, this, a0());
    }

    public List getBondedDevice() {
        StarryNetDevice bondedRingDevice = XrSdkBondDeviceUtil.INSTANCE.getBondedRingDevice(MainApplication.k.d());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "getBondedRing: " + bondedRingDevice);
        return bondedRingDevice == null ? new ArrayList() : CollectionsKt.mutableListOf(p0(bondedRingDevice));
    }

    public List getConnectedDevice() {
        StarryNetDevice connectedRingStarryNetDevice = this.e.getConnectedRingStarryNetDevice();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "getConnectedRing: " + connectedRingStarryNetDevice);
        return connectedRingStarryNetDevice == null ? new ArrayList() : CollectionsKt.mutableListOf(p0(connectedRingStarryNetDevice));
    }

    public final void h0(Fragment fragment) {
        if (fragment.getActivity() == null) {
            ULog.f6446a.c("StarryNetApiHandler", "requestNecessaryPermission, activity is null");
            return;
        }
        ULog.f6446a.g("StarryNetApiHandler", "requestNecessaryPermission");
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new StarryNetApiHandler$requestNecessaryPermission$2(this, fragment, (Continuation<? super StarryNetApiHandler$requestNecessaryPermission$2>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i0(androidx.fragment.app.Fragment r12, kotlin.coroutines.Continuation r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForAboveAndroid12$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForAboveAndroid12$1 r0 = (com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForAboveAndroid12$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForAboveAndroid12$1 r0 = new com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForAboveAndroid12$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 0
            java.lang.String r3 = "StarryNetApiHandler"
            r4 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 != r4) goto L_0x0031
            java.lang.Object r12 = r0.L$0
            androidx.fragment.app.Fragment r12 = (androidx.fragment.app.Fragment) r12
            kotlin.ResultKt.throwOnFailure(r11)
        L_0x002f:
            r5 = r12
            goto L_0x0076
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.fragment.app.FragmentActivity r11 = r12.requireActivity()
            java.lang.String r1 = "requireActivity(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r5 = "requestPermissionForAboveAndroid12"
            r1.g(r3, r5)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r1 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r1 = r1.z()
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r6 = com.upuphone.xr.sapp.R.string.bt_title
            java.lang.String r6 = r11.getString(r6)
            java.lang.String r7 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            int r8 = com.upuphone.xr.sapp.R.string.bt_content
            java.lang.String r8 = r11.getString(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r5.<init>(r6, r8)
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.a(r11, r1, r5, r2, r0)
            if (r11 != r13) goto L_0x002f
            return r13
        L_0x0076:
            com.upuphone.xr.sapp.permission.PermissionResult r11 = (com.upuphone.xr.sapp.permission.PermissionResult) r11
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "requestPermissionForAboveAndroid12, permissionResult: "
            r13.append(r0)
            r13.append(r11)
            java.lang.String r13 = r13.toString()
            r12.g(r3, r13)
            boolean r13 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r11)
            if (r13 == 0) goto L_0x00cf
            androidx.lifecycle.MutableLiveData r11 = n
            java.lang.Object r11 = r11.getValue()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "获得授权，初始化StarryNet SDK: "
            r13.append(r0)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.g(r3, r11)
            androidx.lifecycle.MutableLiveData r11 = n
            java.lang.Object r11 = r11.getValue()
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r11 != 0) goto L_0x00ea
            com.upuphone.xr.interconnect.InterconnectManager r11 = com.upuphone.xr.interconnect.InterconnectManager.getInstance()
            android.content.Context r12 = r5.requireContext()
            android.content.Context r12 = r12.getApplicationContext()
            r11.init(r12, r2)
            goto L_0x00ea
        L_0x00cf:
            boolean r11 = com.upuphone.xr.sapp.permission.PermissionResultKt.b(r11)
            if (r11 == 0) goto L_0x00ea
            r11 = 140(0x8c, float:1.96E-43)
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            java.lang.Integer[] r11 = new java.lang.Integer[]{r11}
            java.util.ArrayList r6 = kotlin.collections.CollectionsKt.arrayListOf(r11)
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.I(r5, r6, r7, r8, r9, r10)
        L_0x00ea:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler.i0(androidx.fragment.app.Fragment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j0(androidx.fragment.app.Fragment r18, kotlin.coroutines.Continuation r19) {
        /*
            r17 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForBelowAndroid12$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForBelowAndroid12$1 r1 = (com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForBelowAndroid12$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001c
        L_0x0015:
            com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForBelowAndroid12$1 r1 = new com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestPermissionForBelowAndroid12$1
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001c:
            java.lang.Object r0 = r1.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r11 = 0
            r12 = 2
            r13 = 1
            java.lang.String r14 = "StarryNetApiHandler"
            if (r2 == 0) goto L_0x004d
            if (r2 == r13) goto L_0x0040
            if (r2 != r12) goto L_0x0038
            java.lang.Object r1 = r1.L$0
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00fc
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            java.lang.Object r2 = r1.L$1
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2
            java.lang.Object r3 = r1.L$0
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            kotlin.ResultKt.throwOnFailure(r0)
            r15 = r3
            goto L_0x007e
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.fragment.app.FragmentActivity r0 = r18.requireActivity()
            java.lang.String r2 = "requireActivity(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r3 = "requestPermissionForBelowAndroid12"
            r2.g(r14, r3)
            r15 = r18
            r1.L$0 = r15
            r1.L$1 = r0
            r1.label = r13
            r3 = 187(0xbb, float:2.62E-43)
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 14
            r9 = 0
            r2 = r0
            r7 = r1
            java.lang.Object r2 = com.upuphone.xr.sapp.utils.GenericWindowExtKt.b(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r2 != r10) goto L_0x0079
            return r10
        L_0x0079:
            r16 = r2
            r2 = r0
            r0 = r16
        L_0x007e:
            com.upuphone.xr.sapp.utils.GenericWindowResult$ButtonAction r0 = (com.upuphone.xr.sapp.utils.GenericWindowResult.ButtonAction) r0
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "requestPermissionForBelowAndroid12, dialogResult: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.g(r14, r4)
            int r0 = r0.getActionType()
            r4 = 1101(0x44d, float:1.543E-42)
            if (r0 == r4) goto L_0x00a1
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00a1:
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r0 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r0 = r0.A()
            java.lang.String r4 = java.util.Arrays.toString(r0)
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "requestPermissionForBelowAndroid12, permissions: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.g(r14, r4)
            int r3 = com.upuphone.xr.sapp.R.string.location_title
            java.lang.String r3 = r2.getString(r3)
            java.lang.String r4 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            com.upuphone.xr.sapp.utils.OSHelper r4 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x00df
            int r4 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text_android_r
            java.lang.String r4 = r2.getString(r4)
            goto L_0x00e5
        L_0x00df:
            int r4 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
            java.lang.String r4 = r2.getString(r4)
        L_0x00e5:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            r5.<init>(r3, r4)
            r1.L$0 = r15
            r3 = 0
            r1.L$1 = r3
            r1.label = r12
            java.lang.Object r0 = com.upuphone.xr.sapp.permission.PermissionExtKt.a(r2, r0, r5, r11, r1)
            if (r0 != r10) goto L_0x00fb
            return r10
        L_0x00fb:
            r1 = r15
        L_0x00fc:
            com.upuphone.xr.sapp.permission.PermissionResult r0 = (com.upuphone.xr.sapp.permission.PermissionResult) r0
            boolean r2 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r0)
            if (r2 == 0) goto L_0x0141
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            androidx.lifecycle.MutableLiveData r2 = n
            java.lang.Object r2 = r2.getValue()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "获得授权，初始化StarryNet SDK: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.g(r14, r2)
            androidx.lifecycle.MutableLiveData r0 = n
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x015c
            com.upuphone.xr.interconnect.InterconnectManager r0 = com.upuphone.xr.interconnect.InterconnectManager.getInstance()
            android.content.Context r1 = r1.requireContext()
            android.content.Context r1 = r1.getApplicationContext()
            r0.init(r1, r11)
            goto L_0x015c
        L_0x0141:
            boolean r0 = com.upuphone.xr.sapp.permission.PermissionResultKt.b(r0)
            if (r0 == 0) goto L_0x015c
            r0 = 139(0x8b, float:1.95E-43)
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            java.lang.Integer[] r0 = new java.lang.Integer[]{r0}
            java.util.ArrayList r2 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.I(r1, r2, r3, r4, r5, r6)
        L_0x015c:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler.j0(androidx.fragment.app.Fragment, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final AndroidRingStarryNetApi.ScanDeviceCallback k0() {
        FlutterEngine c0 = c0("scanDeviceCallback");
        if (c0 == null) {
            return null;
        }
        return new AndroidRingStarryNetApi.ScanDeviceCallback(c0.getDartExecutor().getBinaryMessenger());
    }

    public void l(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, com.upuphone.runasone.constant.Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(bArr, "data");
        ULog.Delegate delegate = ULog.f6446a;
        String joinToString$default = ArraysKt.joinToString$default(bArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        delegate.g("StarryNetApiHandler", "sendMessage: " + str + " data: " + joinToString$default);
        InterconnectManager.getInstance().getStarryNetMessenger().sendRingMessage(this.l, str, bArr, new StarryNetApiHandler$sendMessage$1(this, bArr));
    }

    public final AndroidRingStarryNetApi.SendMessageCallback l0() {
        FlutterEngine c0 = c0("sendMessageCallback");
        if (c0 == null) {
            return null;
        }
        return new AndroidRingStarryNetApi.SendMessageCallback(c0.getDartExecutor().getBinaryMessenger());
    }

    public final AndroidRingStarryNetApi.FlutterStarryNetApi m0() {
        FlutterEngine c0 = c0("starryNetApi");
        if (c0 == null) {
            return null;
        }
        return new AndroidRingStarryNetApi.FlutterStarryNetApi(c0.getDartExecutor().getBinaryMessenger());
    }

    public final void n0() {
        int i2 = this.k + 1;
        this.k = i2;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "startDiscovery cur time = " + i2);
        this.e.stopDiscovery();
        this.e.startDiscovery();
    }

    public final AndroidRingStarryNetApi.StarryNetDevice o0(StarryDevice starryDevice) {
        AndroidRingStarryNetApi.StarryNetDevice.Builder j2 = new AndroidRingStarryNetApi.StarryNetDevice.Builder().g(starryDevice.getId()).j(starryDevice.getSelfId());
        String bleMac = starryDevice.getStarryDevice().getBleMac();
        String str = "";
        if (bleMac == null) {
            bleMac = str;
        }
        AndroidRingStarryNetApi.StarryNetDevice.Builder b2 = j2.b(bleMac);
        String name = starryDevice.getName();
        if (name != null) {
            str = name;
        }
        AndroidRingStarryNetApi.StarryNetDevice.Builder f2 = b2.h(str).i(Long.valueOf((long) starryDevice.getPort())).k(Long.valueOf((long) starryDevice.getStarryDevice().getStatus())).d(Long.valueOf((long) starryDevice.getStarryDevice().getBondStatus())).c(1L).f(Long.valueOf((long) starryDevice.getStarryDevice().getTerminalType()));
        String modelID = starryDevice.getStarryDevice().getModelID();
        Intrinsics.checkNotNullExpressionValue(modelID, "getModelID(...)");
        AndroidRingStarryNetApi.StarryNetDevice a2 = f2.e(b0(modelID)).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }

    public void onMessage(String str, String str2, String str3, byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (StringsKt.equals(this.b, str2, true) && Intrinsics.areEqual((Object) this.d, (Object) str3)) {
            ULog.Delegate delegate = ULog.f6446a;
            String joinToString$default = ArraysKt.joinToString$default(bArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
            delegate.g("StarryNetApiHandler", "receiveMessage: " + joinToString$default);
            SportService.f7826a.a(bArr);
            AndroidRingStarryNetApi.FlutterStarryNetApi m0 = m0();
            if (m0 != null) {
                Intrinsics.checkNotNull(str);
                Intrinsics.checkNotNull(str2);
                m0.j(str, str2, str3, bArr, Long.valueOf((long) i2), new StarryVoidResult());
            }
        }
    }

    public final AndroidRingStarryNetApi.StarryNetDevice p0(StarryNetDevice starryNetDevice) {
        AndroidRingStarryNetApi.StarryNetDevice.Builder j2 = new AndroidRingStarryNetApi.StarryNetDevice.Builder().g(starryNetDevice.getDeviceId()).j(starryNetDevice.getDeviceId());
        String bleMac = starryNetDevice.getBleMac();
        String str = "";
        if (bleMac == null) {
            bleMac = str;
        }
        AndroidRingStarryNetApi.StarryNetDevice.Builder b2 = j2.b(bleMac);
        String deviceName = starryNetDevice.getDeviceName();
        if (deviceName != null) {
            str = deviceName;
        }
        AndroidRingStarryNetApi.StarryNetDevice.Builder f2 = b2.h(str).i(0L).k(Long.valueOf((long) starryNetDevice.getStatus())).d(Long.valueOf((long) starryNetDevice.getStatus())).c(1L).f(Long.valueOf((long) starryNetDevice.getTerminalType()));
        String modelId = starryNetDevice.getModelId();
        Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
        AndroidRingStarryNetApi.StarryNetDevice a2 = f2.e(b0(modelId)).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }

    public void t(String str) {
        Intrinsics.checkNotNullParameter(str, com.upuphone.runasone.constant.Constants.DEVICE_ID);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "bindRing: " + str);
        this.e.connectDevice(str);
    }

    public void u() {
        boolean isStarryNetFinishInit = InterconnectManager.getInstance().isStarryNetFinishInit();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "StarryNet SDK 是否初始化: " + isStarryNetFinishInit);
        if (!isStarryNetFinishInit) {
            n.observe(this.f8354a.getViewLifecycleOwner(), new StarryNetApiHandler$sam$androidx_lifecycle_Observer$0(new StarryNetApiHandler$scanDevice$1(this)));
            delegate.g("StarryNetApiHandler", "StarryNet SDK 没有初始化，检查权限");
            Context requireContext = this.f8354a.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            V(requireContext, this.f8354a);
            return;
        }
        delegate.g("StarryNetApiHandler", "StarryNet SDK 已经初始化直接开始扫描 startDiscovery");
        n0();
    }

    public void v() {
        ULog.f6446a.g("StarryNetApiHandler", "stopScanRing");
        this.e.stopDiscovery();
    }

    public void w(AndroidRingStarryNetApi.Ring2BatteryInfo ring2BatteryInfo) {
        Intrinsics.checkNotNullParameter(ring2BatteryInfo, "batteryInfo");
    }
}
