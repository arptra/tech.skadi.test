package com.upuphone.xr.sapp.vu;

import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$arSpacePermission$2 extends Lambda implements Function0<HashMap<String, String[]>> {
    public static final VuTouchpadActivity$arSpacePermission$2 INSTANCE = new VuTouchpadActivity$arSpacePermission$2();

    public VuTouchpadActivity$arSpacePermission$2() {
        super(0);
    }

    @NotNull
    public final HashMap<String, String[]> invoke() {
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        return MapsKt.hashMapOf(TuplesKt.to("READ_MEDIA", permissionAndStateCheckUtils.l()), TuplesKt.to("ACCESS_LOCATION", permissionAndStateCheckUtils.A()));
    }
}
