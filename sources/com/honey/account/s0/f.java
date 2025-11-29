package com.honey.account.s0;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JsonReader f3093a;

    public /* synthetic */ f(JsonReader jsonReader) {
        this.f3093a = jsonReader;
    }

    public final void run() {
        Utils.closeQuietly(this.f3093a);
    }
}
