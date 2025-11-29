package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.interconnect.outer.SuperServiceStateListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager$init$1", "Lcom/upuphone/xr/interconnect/outer/SuperServiceStateListener;", "onServiceConnected", "", "onServiceDied", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordConnectManager$init$1 implements SuperServiceStateListener {
    public void onServiceConnected() {
        LogExt.logI("独立APP监听互联互通连接成功！", "FastRecordInterConnectHelper");
    }

    public void onServiceDied() {
        LogExt.logI("独立APP监听互联互通断开连接！", "FastRecordInterConnectHelper");
    }
}
