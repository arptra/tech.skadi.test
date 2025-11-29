package com.upuphone.xr.interconnect.business.app;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/interconnect/business/app/LaunchAgent;", "", "launchActivity", "", "intent", "Landroid/content/Intent;", "launchService", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface LaunchAgent {
    void launchActivity(@NotNull Intent intent);

    void launchService(@NotNull Intent intent);
}
