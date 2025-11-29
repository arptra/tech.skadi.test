package androidx.browser.trusted;

import android.content.pm.PackageManager;

public final class Token {

    /* renamed from: a  reason: collision with root package name */
    public final TokenContents f435a;

    public boolean a(String str, PackageManager packageManager) {
        return PackageIdentityUtils.c(str, packageManager, this.f435a);
    }
}
