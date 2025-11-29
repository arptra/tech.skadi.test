package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

public class WebSettingsAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final WebSettingsBoundaryInterface f1984a;

    public WebSettingsAdapter(WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.f1984a = webSettingsBoundaryInterface;
    }

    public void a(boolean z) {
        this.f1984a.setAlgorithmicDarkeningAllowed(z);
    }
}
