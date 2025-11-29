package com.upuphone.xr.sapp.utils;

import android.os.Build;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nPermissionAndStateCheckUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionAndStateCheckUtils.kt\ncom/upuphone/xr/sapp/utils/PermissionAndStateCheckUtils$thirdStarryPermissions$2\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,534:1\n37#2,2:535\n*S KotlinDebug\n*F\n+ 1 PermissionAndStateCheckUtils.kt\ncom/upuphone/xr/sapp/utils/PermissionAndStateCheckUtils$thirdStarryPermissions$2\n*L\n83#1:535,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/String;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PermissionAndStateCheckUtils$thirdStarryPermissions$2 extends Lambda implements Function0<String[]> {
    public static final PermissionAndStateCheckUtils$thirdStarryPermissions$2 INSTANCE = new PermissionAndStateCheckUtils$thirdStarryPermissions$2();

    public PermissionAndStateCheckUtils$thirdStarryPermissions$2() {
        super(0);
    }

    @NotNull
    public final String[] invoke() {
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
            arrayList.add("android.permission.BLUETOOTH_SCAN");
        }
        if (i >= 33) {
            arrayList.add("android.permission.NEARBY_WIFI_DEVICES");
        }
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        return (String[]) arrayList.toArray(new String[0]);
    }
}
