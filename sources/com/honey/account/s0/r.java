package com.honey.account.s0;

import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class r implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JSONObject f3105a;
    public final /* synthetic */ String b;

    public /* synthetic */ r(JSONObject jSONObject, String str) {
        this.f3105a = jSONObject;
        this.b = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonSync(this.f3105a, this.b);
    }
}
