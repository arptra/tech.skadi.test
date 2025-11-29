package com.upuphone.xr.interconnect.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManagerImpl;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bJ\u0010\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010#\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J&\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00180(j\b\u0012\u0004\u0012\u00020\u0018`)2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\"J\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020,J\u0016\u0010-\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u000bJ\u0016\u0010.\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u000bJ\u0010\u0010/\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u0010\u00100\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u0010\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/upuphone/xr/interconnect/util/XrSdkBondDeviceUtil;", "", "()V", "RETRY_TIME_OUT", "", "TAG", "", "TERMINAL_TYPE_RING", "", "TERMINAL_TYPE_XR", "bondedGlassDevice", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "bondedRingDevice", "deviceId", "hasFinishCheck", "", "startCheckConnectStatusJob", "Lkotlinx/coroutines/Job;", "cancelTimeOutJob", "", "reason", "checkConnectTimeOutStatus", "checkDeviceTypeIsGlass", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "type", "checkDeviceTypeIsRing", "clearBondedGlassDeviceFromSp", "context", "Landroid/content/Context;", "clearBondedRingDeviceFromSp", "deviceTypeIsRingOrGlass", "getBondedDevice", "getBondedDeviceList", "", "getBondedGlassDevice", "getBondedGlassDeviceFromSp", "getBondedRingDevice", "getBondedRingDeviceFromSp", "getGlassDevice", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "deviceList", "isNotSupportDeviceType", "", "saveBondedGlassDeviceFromSp", "saveBondedRingDeviceFromSp", "saveGlassBoundDevice", "saveRingBoundDevice", "setDeviceId", "id", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nXrSdkBondDeviceUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XrSdkBondDeviceUtil.kt\ncom/upuphone/xr/interconnect/util/XrSdkBondDeviceUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,280:1\n1855#2,2:281\n*S KotlinDebug\n*F\n+ 1 XrSdkBondDeviceUtil.kt\ncom/upuphone/xr/interconnect/util/XrSdkBondDeviceUtil\n*L\n100#1:281,2\n*E\n"})
public final class XrSdkBondDeviceUtil {
    @NotNull
    public static final XrSdkBondDeviceUtil INSTANCE = new XrSdkBondDeviceUtil();
    private static final long RETRY_TIME_OUT = 10000;
    @NotNull
    private static final String TAG = "XrSdkBondDeviceUtil";
    private static final byte TERMINAL_TYPE_RING = 5;
    private static final byte TERMINAL_TYPE_XR = 2;
    @Nullable
    private static StarryNetDevice bondedGlassDevice;
    @Nullable
    private static StarryNetDevice bondedRingDevice;
    /* access modifiers changed from: private */
    @Nullable
    public static String deviceId;
    private static boolean hasFinishCheck;
    @Nullable
    private static Job startCheckConnectStatusJob;

    private XrSdkBondDeviceUtil() {
    }

    private final StarryNetDevice getBondedGlassDeviceFromSp(Context context) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "getBondedDeviceFromSp start");
        try {
            Result.Companion companion = Result.Companion;
            String string = context.getSharedPreferences(StarryNetDeviceManagerImpl.PREF_FILE_DEVICE_TYPE_NAME, 0).getString(StarryNetDeviceManagerImpl.PREF_FILE_BIND_GLASS_DEVICE_INFO_KEY, "");
            delegate.c(TAG, "getDeviceFromSp StarryNetDevice deviceInfo = " + string);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            StarryNetDevice starryNetDevice = (StarryNetDevice) new Gson().fromJson(string, StarryNetDevice.class);
            bondedGlassDevice = starryNetDevice;
            return starryNetDevice;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    private final StarryNetDevice getBondedRingDeviceFromSp(Context context) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "getBondedDeviceFromSp start");
        try {
            Result.Companion companion = Result.Companion;
            String string = context.getSharedPreferences(StarryNetDeviceManagerImpl.PREF_FILE_DEVICE_TYPE_NAME, 0).getString(StarryNetDeviceManagerImpl.PREF_FILE_BIND_RING_DEVICE_INFO_KEY, "");
            delegate.c(TAG, "getDeviceFromSp StarryNetDevice deviceInfo = " + string);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            StarryNetDevice starryNetDevice = (StarryNetDevice) new Gson().fromJson(string, StarryNetDevice.class);
            bondedRingDevice = starryNetDevice;
            return starryNetDevice;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    public final void cancelTimeOutJob(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o(TAG, "cancelTimeOutJob reason = " + str);
        Job job = startCheckConnectStatusJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        startCheckConnectStatusJob = null;
    }

    public final void checkConnectTimeOutStatus() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = hasFinishCheck;
        delegate.o(TAG, "BuildConfig.isAdaptThird = false,BuildConfig.isOverSea = true,hasFinishCheck = " + z);
        if (hasFinishCheck) {
            delegate.o(TAG, "hasFinishCheck is true return");
            return;
        }
        hasFinishCheck = true;
        startCheckConnectStatusJob = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new XrSdkBondDeviceUtil$checkConnectTimeOutStatus$1((Continuation<? super XrSdkBondDeviceUtil$checkConnectTimeOutStatus$1>) null), 3, (Object) null);
    }

    public final boolean checkDeviceTypeIsGlass(@Nullable StarryDevice starryDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = starryDevice == null;
        Byte valueOf = starryDevice != null ? Byte.valueOf(starryDevice.getTerminalType()) : null;
        delegate.o(TAG, "checkDeviceTypeIsGlass device is null = " + z + "  type = " + valueOf + ",TERMINAL_TYPE_XR = 2");
        if (starryDevice == null || 2 != starryDevice.getTerminalType()) {
            return false;
        }
        return true;
    }

    public final boolean checkDeviceTypeIsRing(@Nullable StarryDevice starryDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = starryDevice == null;
        Byte valueOf = starryDevice != null ? Byte.valueOf(starryDevice.getTerminalType()) : null;
        delegate.o(TAG, "checkDeviceTypeIsRing device is null = " + z + " type = " + valueOf + ",TERMINAL_TYPE_RING = 5");
        if (starryDevice == null || 5 != starryDevice.getTerminalType()) {
            return false;
        }
        return true;
    }

    public final void clearBondedGlassDeviceFromSp(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "clearBondedGlassDeviceFromSp start");
        try {
            Result.Companion companion = Result.Companion;
            bondedGlassDevice = null;
            SharedPreferences.Editor edit = context.getSharedPreferences(StarryNetDeviceManagerImpl.PREF_FILE_DEVICE_TYPE_NAME, 0).edit();
            delegate.c(TAG, "clearBondedGlassDeviceFromSp null");
            edit.putString(StarryNetDeviceManagerImpl.PREF_FILE_BIND_GLASS_DEVICE_INFO_KEY, "");
            edit.apply();
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void clearBondedRingDeviceFromSp(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "clearBondedRingDeviceFromSp start");
        try {
            Result.Companion companion = Result.Companion;
            bondedRingDevice = null;
            SharedPreferences.Editor edit = context.getSharedPreferences(StarryNetDeviceManagerImpl.PREF_FILE_DEVICE_TYPE_NAME, 0).edit();
            delegate.c(TAG, "clearBondedRingDeviceFromSp null");
            edit.putString(StarryNetDeviceManagerImpl.PREF_FILE_BIND_RING_DEVICE_INFO_KEY, "");
            edit.apply();
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final boolean deviceTypeIsRingOrGlass(byte b) {
        boolean z = checkDeviceTypeIsRing(b) || checkDeviceTypeIsGlass(b);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "deviceTypeIsRingOrGlass state = " + z);
        return z;
    }

    @Nullable
    public final StarryNetDevice getBondedDevice(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (bondedGlassDevice == null) {
            return getBondedGlassDeviceFromSp(context);
        }
        ULog.Delegate delegate = ULog.f6446a;
        StarryNetDevice starryNetDevice = bondedGlassDevice;
        delegate.o(TAG, "getBondedDevice device != null device =" + starryNetDevice + " ");
        return bondedGlassDevice;
    }

    @NotNull
    public final List<StarryNetDevice> getBondedDeviceList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        StarryNetDevice bondedGlassDevice2 = getBondedGlassDevice(context);
        StarryNetDevice bondedRingDevice2 = getBondedRingDevice(context);
        if (bondedGlassDevice2 != null) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o(TAG, "boundGlass info = " + bondedGlassDevice2 + " ");
            arrayList.add(bondedGlassDevice2);
        }
        if (bondedRingDevice2 != null) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.o(TAG, "boundRing info = " + bondedRingDevice2 + " ");
            arrayList.add(bondedRingDevice2);
        }
        return arrayList;
    }

    @Nullable
    public final StarryNetDevice getBondedGlassDevice(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (bondedGlassDevice == null) {
            return getBondedGlassDeviceFromSp(context);
        }
        ULog.Delegate delegate = ULog.f6446a;
        StarryNetDevice starryNetDevice = bondedGlassDevice;
        delegate.o(TAG, "getBondedGlassDevice device != null device =" + starryNetDevice + " ");
        return bondedGlassDevice;
    }

    @Nullable
    public final StarryNetDevice getBondedRingDevice(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (bondedRingDevice == null) {
            return getBondedRingDeviceFromSp(context);
        }
        ULog.Delegate delegate = ULog.f6446a;
        StarryNetDevice starryNetDevice = bondedRingDevice;
        delegate.o(TAG, "getBondedDevice device != null device =" + starryNetDevice + " ");
        return bondedRingDevice;
    }

    @NotNull
    public final ArrayList<StarryDevice> getGlassDevice(@Nullable List<? extends StarryDevice> list) {
        ArrayList<StarryDevice> arrayList = new ArrayList<>();
        if (list != null) {
            for (StarryDevice starryDevice : list) {
                ULog.Delegate delegate = ULog.f6446a;
                byte terminalType = starryDevice.getTerminalType();
                delegate.o(TAG, "getGlassDevice it devices type = " + terminalType);
                if (INSTANCE.checkDeviceTypeIsGlass(starryDevice.getTerminalType())) {
                    delegate.o(TAG, "getGlassDevice it devices type is glass");
                    arrayList.add(starryDevice);
                }
            }
        }
        return arrayList;
    }

    public final boolean isNotSupportDeviceType(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o(TAG, "checkDeviceTypeIsRing type = " + i);
        return 2 != i;
    }

    public final void saveBondedGlassDeviceFromSp(@NotNull Context context, @NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        bondedGlassDevice = starryNetDevice;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "saveBondedGlassDeviceFromSp start");
        try {
            Result.Companion companion = Result.Companion;
            SharedPreferences.Editor edit = context.getSharedPreferences(StarryNetDeviceManagerImpl.PREF_FILE_DEVICE_TYPE_NAME, 0).edit();
            String json = new Gson().toJson((Object) starryNetDevice);
            delegate.c(TAG, "saveBondedGlassDeviceFromSp StarryNetDevice deviceInfo = " + json);
            edit.putString(StarryNetDeviceManagerImpl.PREF_FILE_BIND_GLASS_DEVICE_INFO_KEY, json);
            edit.apply();
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void saveBondedRingDeviceFromSp(@NotNull Context context, @NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        bondedRingDevice = starryNetDevice;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "saveBondedRingDeviceFromSp start");
        try {
            Result.Companion companion = Result.Companion;
            SharedPreferences.Editor edit = context.getSharedPreferences(StarryNetDeviceManagerImpl.PREF_FILE_DEVICE_TYPE_NAME, 0).edit();
            String json = new Gson().toJson((Object) starryNetDevice);
            delegate.c(TAG, "saveBondedRingDeviceFromSp StarryNetDevice deviceInfo = " + json);
            edit.putString(StarryNetDeviceManagerImpl.PREF_FILE_BIND_RING_DEVICE_INFO_KEY, json);
            edit.apply();
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void saveGlassBoundDevice(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "saveGlassBoundDevice device = " + starryNetDevice);
        if (starryNetDevice == null) {
            Context context = InterconnectManager.getInstance().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            clearBondedGlassDeviceFromSp(context);
            return;
        }
        Context context2 = InterconnectManager.getInstance().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        saveBondedGlassDeviceFromSp(context2, starryNetDevice);
    }

    public final void saveRingBoundDevice(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "saveRingBoundDevice device = " + starryNetDevice);
        if (starryNetDevice == null) {
            Context context = InterconnectManager.getInstance().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            clearBondedRingDeviceFromSp(context);
            return;
        }
        Context context2 = InterconnectManager.getInstance().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        saveBondedRingDeviceFromSp(context2, starryNetDevice);
    }

    public final void setDeviceId(@Nullable String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o(TAG, "setDeviceId id = " + str);
        deviceId = str;
    }

    public final boolean checkDeviceTypeIsGlass(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = starryNetDevice == null;
        Byte valueOf = starryNetDevice != null ? Byte.valueOf(starryNetDevice.getTerminalType()) : null;
        delegate.o(TAG, "checkDeviceTypeIsGlass device is null = " + z + "  type = " + valueOf + ",TERMINAL_TYPE_XR = 2");
        if (starryNetDevice == null || 2 != starryNetDevice.getTerminalType()) {
            return false;
        }
        return true;
    }

    public final boolean checkDeviceTypeIsRing(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = starryNetDevice == null;
        Byte valueOf = starryNetDevice != null ? Byte.valueOf(starryNetDevice.getTerminalType()) : null;
        delegate.o(TAG, "checkDeviceTypeIsRing device is null = " + z + " type = " + valueOf + ",TERMINAL_TYPE_RING = 5");
        if (starryNetDevice == null || 5 != starryNetDevice.getTerminalType()) {
            return false;
        }
        return true;
    }

    public final boolean checkDeviceTypeIsGlass(byte b) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o(TAG, "checkDeviceTypeIsGlass type = " + b + ",TERMINAL_TYPE_XR = 2");
        return 2 == b;
    }

    public final boolean checkDeviceTypeIsRing(byte b) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o(TAG, "checkDeviceTypeIsRing type = " + b + ",TERMINAL_TYPE_RING = 5");
        return 5 == b;
    }
}
