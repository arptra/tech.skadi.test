package com.honey.account.j3;

import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.UCarChannel;
import com.ucar.vehiclesdk.control.ControlManager;

public final /* synthetic */ class a implements UCarChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ControlManager f4863a;

    public /* synthetic */ a(ControlManager controlManager) {
        this.f4863a = controlManager;
    }

    public final void a(UCarMessage uCarMessage) {
        this.f4863a.J(uCarMessage);
    }
}
