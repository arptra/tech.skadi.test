package com.here.sdk.mapview;

import android.content.Context;
import com.here.sdk.mapview.MapScene;
import java.lang.reflect.Method;

public final /* synthetic */ class a implements MapScene.LoadSceneCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f9171a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(Method method, Context context, String str) {
        this.f9171a = method;
        this.b = context;
        this.c = str;
    }

    public final void onLoadScene(MapError mapError) {
        AttributeUtils.lambda$getCallback$0(this.f9171a, this.b, this.c, mapError);
    }
}
