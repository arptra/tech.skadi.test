package com.honey.account.d7;

import android.content.Context;
import com.upuphone.starrynet.strategy.config.StConfigLoader;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StConfigLoader f4335a;
    public final /* synthetic */ Context b;

    public /* synthetic */ a(StConfigLoader stConfigLoader, Context context) {
        this.f4335a = stConfigLoader;
        this.b = context;
    }

    public final void run() {
        this.f4335a.lambda$requestRemoteStarryNetConfig$0(this.b);
    }
}
