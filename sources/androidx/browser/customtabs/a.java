package androidx.browser.customtabs;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;

public final /* synthetic */ class a implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomTabsService.AnonymousClass1 f427a;
    public final /* synthetic */ CustomTabsSessionToken b;

    public /* synthetic */ a(CustomTabsService.AnonymousClass1 r1, CustomTabsSessionToken customTabsSessionToken) {
        this.f427a = r1;
        this.b = customTabsSessionToken;
    }

    public final void binderDied() {
        this.f427a.lambda$newSessionInternal$0(this.b);
    }
}
