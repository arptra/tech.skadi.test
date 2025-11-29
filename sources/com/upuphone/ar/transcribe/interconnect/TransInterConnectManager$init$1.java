package com.upuphone.ar.transcribe.interconnect;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.xr.interconnect.outer.SuperServiceStateListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/upuphone/ar/transcribe/interconnect/TransInterConnectManager$init$1", "Lcom/upuphone/xr/interconnect/outer/SuperServiceStateListener;", "onServiceConnected", "", "onServiceDied", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransInterConnectManager$init$1 implements SuperServiceStateListener {
    public void onServiceConnected() {
        LogExt.g("独立APP监听互联互通连接成功！", "TranscribeConnectManager");
    }

    public void onServiceDied() {
        LogExt.g("独立APP监听互联互通断开连接！", "TranscribeConnectManager");
    }
}
