package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager$mDeviceConnectionListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordConnectManager$mDeviceConnectionListener$1 extends DeviceConnectionListener {
    final /* synthetic */ RecordConnectManager this$0;

    public RecordConnectManager$mDeviceConnectionListener$1(RecordConnectManager recordConnectManager) {
        this.this$0 = recordConnectManager;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        LogExt.logI("互联互通连接成功:: " + starryNetDevice + " setConnectState true", "FastRecordInterConnectHelper");
        if (starryNetDevice != null) {
            RecordConnectManager recordConnectManager = this.this$0;
            if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
                LogExt.logI("connected 眼镜和手机设备连接成功=" + starryNetDevice, "FastRecordInterConnectHelper");
                recordConnectManager.mIsDeviceConnected = true;
                FastRecordManager.Companion.getInstance().appViewModel().setConnectState(true);
            }
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        LogExt.logI("互联互通断开连接:: " + starryNetDevice + ",setConnectState false", "FastRecordInterConnectHelper");
        if (starryNetDevice != null) {
            RecordConnectManager recordConnectManager = this.this$0;
            if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
                LogExt.logI("disConnected 眼镜和手机设备断开连接=" + starryNetDevice, "FastRecordInterConnectHelper");
                recordConnectManager.mIsDeviceConnected = false;
                LogExt.logW("onDeviceDisconnected RecordVoiceUtils removeAllData", "FastRecordInterConnectHelper");
                RecordVoiceUtils.INSTANCE.initAllRecordingTagData();
                recordConnectManager.setStopVoiceState();
                FastRecordManager.Companion.getInstance().appViewModel().setConnectState(false);
                recordConnectManager.cacheAudioAmplitudeWhenPause();
            }
        }
    }
}
