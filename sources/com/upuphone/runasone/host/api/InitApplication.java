package com.upuphone.runasone.host.api;

import android.content.Context;

public interface InitApplication {
    void initHighPriority(Context context, InitCallback initCallback);

    void initLowPriority(Context context);
}
