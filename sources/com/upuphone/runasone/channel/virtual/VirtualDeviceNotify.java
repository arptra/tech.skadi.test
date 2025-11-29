package com.upuphone.runasone.channel.virtual;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.honey.account.y5.a;
import com.honey.account.y5.b;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.bean.virtual.BroadcastBean;
import com.upuphone.runasone.channel.core.OutputCore;
import com.upuphone.runasone.channel.core.bean.ActionBean;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import java.util.Map;

public final class VirtualDeviceNotify {
    private static final String TAG = "VirtualDeviceNotify";
    private static VirtualDeviceNotify instance;

    private VirtualDeviceNotify() {
    }

    private static synchronized VirtualDeviceNotify createInstance() {
        VirtualDeviceNotify virtualDeviceNotify;
        synchronized (VirtualDeviceNotify.class) {
            try {
                if (instance == null) {
                    instance = new VirtualDeviceNotify();
                }
                virtualDeviceNotify = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return virtualDeviceNotify;
    }

    public static VirtualDeviceNotify getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendBroadCast$0(String str, StarryDevice starryDevice, int i, int i2, String str2, IChannel iChannel) {
        if (iChannel == null || TextUtils.equals(str2, str) || !iChannel.isLinkUp()) {
            LogUtil.d(TAG, (Object) "Self Not Need Send");
            return;
        }
        BroadcastBean broadcastBean = new BroadcastBean();
        broadcastBean.setTargetDevice(Utils.clone(starryDevice));
        broadcastBean.setActionType(i);
        broadcastBean.setThroughputType(i2);
        String json = new Gson().toJson((Object) broadcastBean);
        ActionBean actionBean = new ActionBean();
        actionBean.setActionType(i);
        actionBean.setData(json);
        String str3 = str2;
        String str4 = str2;
        OutputCore.getInstance().sendTo(str3, str4, QosLevel.QOS_0, new AbilityMessage(new Gson().toJson((Object) actionBean).getBytes()), StreamType.ACTION);
        LogUtil.d(TAG, (Object) "Send Up Device To Exist Device");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendBroadCast$1(String str, int i, String str2, IChannel iChannel) {
        StarryDevice findConnectDevice = DeviceManagerImpl.getInstance().findConnectDevice(str2);
        if (iChannel == null || TextUtils.equals(str2, str) || !iChannel.isLinkUp() || findConnectDevice == null) {
            LogUtil.d(TAG, (Object) "Self Not Need Send");
            return;
        }
        BroadcastBean broadcastBean = new BroadcastBean();
        broadcastBean.setTargetDevice(Utils.clone(findConnectDevice));
        broadcastBean.setActionType(i);
        broadcastBean.setThroughputType(findConnectDevice.getStatus() & 3);
        String json = new Gson().toJson((Object) broadcastBean);
        ActionBean actionBean = new ActionBean();
        actionBean.setActionType(i);
        actionBean.setData(json);
        String str3 = str;
        String str4 = str;
        OutputCore.getInstance().sendTo(str3, str4, QosLevel.QOS_0, new AbilityMessage(new Gson().toJson((Object) actionBean).getBytes()), StreamType.ACTION);
        LogUtil.d(TAG, (Object) "Send Exist Device To Up Device");
    }

    public void sendBroadCast(String str, StarryDevice starryDevice, int i, int i2) {
        Map<String, IChannel> findAllChannel = ChannelManagerImpl.getInstance().findAllChannel();
        String str2 = TAG;
        LogUtil.d(str2, (Object) "All Channel Size->>>" + findAllChannel.size());
        findAllChannel.forEach(new a(str, starryDevice, i, i2));
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(str);
        if (i == 1 && findChannelById != null && findChannelById.isLinkUp()) {
            findAllChannel.forEach(new b(str, i));
        }
    }
}
