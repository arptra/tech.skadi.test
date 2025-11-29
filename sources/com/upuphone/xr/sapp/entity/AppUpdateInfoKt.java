package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"isForceUpdate", "", "Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;", "(Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;)Z", "shouldShowDialog", "getShouldShowDialog", "app_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AppUpdateInfoKt {
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r2 = (r2 = r2.getUpgradeModalStatus()).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean getShouldShowDialog(@org.jetbrains.annotations.NotNull com.upuphone.xr.sapp.entity.AppUpdateInfo r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r2.getExistsUpdate()
            if (r0 == 0) goto L_0x001c
            java.lang.Integer r2 = r2.getUpgradeModalStatus()
            if (r2 == 0) goto L_0x001c
            int r2 = r2.intValue()
            r0 = 1
            if (r0 > r2) goto L_0x001c
            r1 = 3
            if (r2 >= r1) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.entity.AppUpdateInfoKt.getShouldShowDialog(com.upuphone.xr.sapp.entity.AppUpdateInfo):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = r1.getUpgradeModalStatus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isForceUpdate(@org.jetbrains.annotations.NotNull com.upuphone.xr.sapp.entity.AppUpdateInfo r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            boolean r0 = r1.getExistsUpdate()
            if (r0 == 0) goto L_0x001a
            java.lang.Integer r1 = r1.getUpgradeModalStatus()
            if (r1 != 0) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            int r1 = r1.intValue()
            r0 = 1
            if (r1 != r0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.entity.AppUpdateInfoKt.isForceUpdate(com.upuphone.xr.sapp.entity.AppUpdateInfo):boolean");
    }
}
