package com.upuphone.runasone;

import android.os.Bundle;
import com.upuphone.runasone.core.api.sys.ApiSystemAdapter;
import com.upuphone.runasone.host.api.IAbility;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/upuphone/runasone/SystemApiAbility;", "Lcom/upuphone/runasone/host/api/IAbility;", "()V", "adapter", "Lcom/upuphone/runasone/core/api/sys/ApiSystemAdapter;", "getAdapter", "()Lcom/upuphone/runasone/core/api/sys/ApiSystemAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "appStateChanged", "", "pid", "", "packageName", "", "uniteCode", "state", "transfer", "inBundle", "Landroid/os/Bundle;", "outBundle", "core-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SystemApiAbility implements IAbility {
    @NotNull
    private final Lazy adapter$delegate = LazyKt.lazy(SystemApiAbility$adapter$2.INSTANCE);

    private final ApiSystemAdapter getAdapter() {
        return (ApiSystemAdapter) this.adapter$delegate.getValue();
    }

    public void appStateChanged(int i, @Nullable String str, @Nullable String str2, int i2) {
    }

    public void transfer(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        getAdapter().adapt(bundle, bundle2);
    }
}
