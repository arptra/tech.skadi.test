package com.upuphone.runasone.ability;

import android.os.DeadObjectException;
import com.upuphone.runasone.core.api.sys.ApiSystem;
import com.upuphone.runasone.core.api.sys.SysCallData;
import com.upuphone.runasone.core.api.sys.SystemCallBack;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.IStarryOperateCallback;
import com.upuphone.starrynet.api.bean.StDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/upuphone/runasone/ability/SystemApiImpl;", "Lcom/upuphone/runasone/core/api/sys/ApiSystem;", "()V", "TAG", "", "listCallBack", "", "Lcom/upuphone/runasone/core/api/sys/SystemCallBack;", "starryOperateCallback", "Lcom/upuphone/starrynet/api/IStarryOperateCallback;", "activeDeviceChange", "", "stDevice", "Lcom/upuphone/starrynet/api/bean/StDevice;", "callStateChanged", "phoneNum", "state", "", "dial", "number", "getAudioPlayDevice", "Lcom/upuphone/runasone/device/StarryDevice;", "getCallState", "getListBrDevice", "", "operateAction", "type", "action", "phoneBookChanged", "registerCallBack", "callBack", "switchAudioPlayDevice", "device", "unRegisterCallBack", "core-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SystemApiImpl implements ApiSystem {
    @NotNull
    public static final SystemApiImpl INSTANCE = new SystemApiImpl();
    @NotNull
    private static final String TAG = "SystemApiImpl";
    @NotNull
    private static final List<SystemCallBack> listCallBack = new ArrayList();
    @NotNull
    private static final IStarryOperateCallback starryOperateCallback;

    static {
        SystemApiImpl$starryOperateCallback$1 systemApiImpl$starryOperateCallback$1 = new SystemApiImpl$starryOperateCallback$1();
        starryOperateCallback = systemApiImpl$starryOperateCallback$1;
        StarrynetApiImpl.getInstance().registerOperateCallback(systemApiImpl$starryOperateCallback$1);
    }

    private SystemApiImpl() {
    }

    public final void activeDeviceChange(@Nullable StDevice stDevice) {
        LogUtil.i(TAG, "activeDeviceChange: stDevice:" + stDevice, new Object[0]);
        Iterator<SystemCallBack> it = listCallBack.iterator();
        while (it.hasNext()) {
            SystemCallBack next = it.next();
            if (stDevice != null) {
                try {
                    next.callBackData(new SysCallData(8, (Integer) null, (String) null, (Integer) null, Utils.convert(stDevice), 14, (DefaultConstructorMarker) null));
                } catch (DeadObjectException e) {
                    e.printStackTrace();
                    it.remove();
                }
            }
        }
    }

    public final void callStateChanged(@Nullable String str, int i) {
        LogUtil.i(TAG, "callStateChanged: phoneNum:" + str + "   state:" + i, new Object[0]);
        Iterator<SystemCallBack> it = listCallBack.iterator();
        while (it.hasNext()) {
            try {
                it.next().callBackData(new SysCallData(9, Integer.valueOf(i), str, (Integer) null, (StarryDevice) null, 24, (DefaultConstructorMarker) null));
            } catch (DeadObjectException e) {
                e.printStackTrace();
                it.remove();
            }
        }
    }

    public void dial(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "number");
        LogUtil.i(TAG, "dial: " + str, new Object[0]);
        StarrynetApiImpl.getInstance().dial(str);
    }

    @Nullable
    public StarryDevice getAudioPlayDevice() {
        LogUtil.i(TAG, "getAudioPlayDevice", new Object[0]);
        StDevice audioPlayDevice = StarrynetApiImpl.getInstance().getAudioPlayDevice();
        if (audioPlayDevice != null) {
            return Utils.convert(audioPlayDevice);
        }
        return null;
    }

    public int getCallState() {
        return -1;
    }

    @NotNull
    public List<StarryDevice> getListBrDevice() {
        List<StDevice> connectedDevices = StarrynetApiImpl.getInstance().getConnectedDevices(512);
        ArrayList arrayList = new ArrayList();
        if (connectedDevices != null) {
            for (StDevice convert : connectedDevices) {
                StarryDevice convert2 = Utils.convert(convert);
                Intrinsics.checkNotNullExpressionValue(convert2, "convert(it)");
                arrayList.add(convert2);
            }
        }
        LogUtil.i(TAG, "getListBrDevice: " + arrayList, new Object[0]);
        return arrayList;
    }

    public void operateAction(int i, int i2) {
        LogUtil.i(TAG, "operateAction: type:" + i + " action:" + i2, new Object[0]);
        StarrynetApiImpl.getInstance().operateAction(i, i2);
    }

    public final void phoneBookChanged(int i) {
        LogUtil.i(TAG, "phoneBookChanged: state:" + i, new Object[0]);
        Iterator<SystemCallBack> it = listCallBack.iterator();
        while (it.hasNext()) {
            try {
                it.next().callBackData(new SysCallData(10, (Integer) null, (String) null, Integer.valueOf(i), (StarryDevice) null, 22, (DefaultConstructorMarker) null));
            } catch (DeadObjectException e) {
                e.printStackTrace();
                it.remove();
            }
        }
    }

    public void registerCallBack(@NotNull SystemCallBack systemCallBack) {
        Intrinsics.checkNotNullParameter(systemCallBack, "callBack");
        listCallBack.add(systemCallBack);
        StarrynetApiImpl.getInstance().registerOperateCallback(starryOperateCallback);
    }

    public int switchAudioPlayDevice(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        LogUtil.i(TAG, "switchAudioPlayDevice: " + starryDevice, new Object[0]);
        return StarrynetApiImpl.getInstance().switchAudioPlayDevice(starryDevice);
    }

    public void unRegisterCallBack(@NotNull SystemCallBack systemCallBack) {
        Intrinsics.checkNotNullParameter(systemCallBack, "callBack");
        listCallBack.remove(systemCallBack);
    }
}
