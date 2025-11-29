package com.honey.account.k6;

import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.starrynet.api.IStarryNetApiCallback;

public final /* synthetic */ class a implements IStarryNetApiCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IStarryNetApiCallback f4910a;

    public /* synthetic */ a(IStarryNetApiCallback iStarryNetApiCallback) {
        this.f4910a = iStarryNetApiCallback;
    }

    public final void onInit() {
        StarrynetApiImpl.lambda$init$0(this.f4910a);
    }
}
