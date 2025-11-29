package com.honey.account.i3;

import com.easy.logger.EasyLog;
import com.ucar.protocol.channel.SendFutureCallback;

public final /* synthetic */ class a implements SendFutureCallback {
    public final void c(Exception exc) {
        EasyLog.d("UCarAudioManager", "Send mic record data error", exc);
    }
}
