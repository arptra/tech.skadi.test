package com.honey.account.r3;

import com.upuphone.ai.ttsengine.flavor.service.LicenceSender;
import com.upuphone.ai.ttsengine.flavor.service.connect.Communicator;

public final /* synthetic */ class a implements Communicator.OnConnectListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LicenceSender f5115a;

    public /* synthetic */ a(LicenceSender licenceSender) {
        this.f5115a = licenceSender;
    }

    public final void a(boolean z) {
        LicenceSender.b(this.f5115a, z);
    }
}
