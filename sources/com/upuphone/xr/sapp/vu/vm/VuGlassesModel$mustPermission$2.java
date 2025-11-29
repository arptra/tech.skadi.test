package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.vu.utils.ArSpaceUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassesModel$mustPermission$2 extends Lambda implements Function0<List<String[]>> {
    public static final VuGlassesModel$mustPermission$2 INSTANCE = new VuGlassesModel$mustPermission$2();

    public VuGlassesModel$mustPermission$2() {
        super(0);
    }

    @NotNull
    public final List<String[]> invoke() {
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        List<String[]> mutableListOf = CollectionsKt.mutableListOf(permissionAndStateCheckUtils.v());
        if (ArSpaceUtil.f8089a.i()) {
            mutableListOf.add(permissionAndStateCheckUtils.y());
        }
        return mutableListOf;
    }
}
