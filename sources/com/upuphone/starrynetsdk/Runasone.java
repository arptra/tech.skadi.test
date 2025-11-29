package com.upuphone.starrynetsdk;

import android.content.Context;
import com.upuphone.starrynetsdk.Dispatcher;

public class Runasone {
    private static Runasone instance;

    private Runasone() {
    }

    public static Runasone getInstance() {
        if (instance == null) {
            instance = new Runasone();
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void initCompleted(Context context, Dispatcher dispatcher) {
        RunasoneHub.getInstance().setDispatcher(dispatcher);
        StarryNet.getInstance().runasoneInitDone(context);
    }

    private void initDispatcher(final Context context) {
        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.init(context, new Dispatcher.InitListener() {
            public void onCompleted() {
                Runasone.this.initCompleted(context, dispatcher);
            }
        });
    }

    public void init(Context context) {
        SLog.d("Runasone init.");
        initDispatcher(context);
    }
}
