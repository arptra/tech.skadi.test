package com.upuphone.starrynet.api;

import android.content.Context;
import com.upuphone.starrynet.strategy.service.ServiceBinder;

public final class StarryNetApi {
    private static final String TAG = "StarryNetApi";
    private final ServiceBinder service;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final StarryNetApi INSTANCE = new StarryNetApi();

        private Holder() {
        }
    }

    public static IStarryService getStarryService() {
        return Holder.INSTANCE.service;
    }

    public static void init(Context context, IStarryNetApiCallback iStarryNetApiCallback) {
        Holder.INSTANCE.service.init(context, iStarryNetApiCallback);
    }

    private StarryNetApi() {
        this.service = new ServiceBinder();
    }
}
