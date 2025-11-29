package com.honey.account.s0;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.concurrent.Callable;

public final /* synthetic */ class v implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JsonReader f3109a;
    public final /* synthetic */ String b;

    public /* synthetic */ v(JsonReader jsonReader, String str) {
        this.f3109a = jsonReader;
        this.b = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonReaderSync(this.f3109a, this.b);
    }
}
