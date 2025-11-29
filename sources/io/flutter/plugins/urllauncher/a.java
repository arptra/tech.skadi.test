package io.flutter.plugins.urllauncher;

import android.content.Context;
import android.content.Intent;
import io.flutter.plugins.urllauncher.UrlLauncher;

public final /* synthetic */ class a implements UrlLauncher.IntentResolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8812a;

    public /* synthetic */ a(Context context) {
        this.f8812a = context;
    }

    public final String getHandlerComponentName(Intent intent) {
        return UrlLauncher.lambda$new$0(this.f8812a, intent);
    }
}
