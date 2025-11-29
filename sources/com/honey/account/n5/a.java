package com.honey.account.n5;

import com.upuphone.runasone.CoreApplication;
import com.upuphone.runasone.host.api.InitCallback;
import com.upuphone.starrynet.api.IStarryNetApiCallback;

public final /* synthetic */ class a implements IStarryNetApiCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InitCallback f4963a;

    public /* synthetic */ a(InitCallback initCallback) {
        this.f4963a = initCallback;
    }

    public final void onInit() {
        CoreApplication.lambda$initHighPriority$1(this.f4963a);
    }
}
