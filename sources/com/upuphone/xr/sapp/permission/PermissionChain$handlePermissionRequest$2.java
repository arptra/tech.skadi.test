package com.upuphone.xr.sapp.permission;

import android.os.SystemClock;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.permission.PermissionChain;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nPermissionChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionChain.kt\ncom/upuphone/xr/sapp/permission/PermissionChain$handlePermissionRequest$2\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,252:1\n215#2,2:253\n*S KotlinDebug\n*F\n+ 1 PermissionChain.kt\ncom/upuphone/xr/sapp/permission/PermissionChain$handlePermissionRequest$2\n*L\n171#1:253,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "", "", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PermissionChain$handlePermissionRequest$2 extends Lambda implements Function1<Map<String, ? extends Boolean>, Unit> {
    final /* synthetic */ PermissionChain.PermissionTask $permissionTask;
    final /* synthetic */ PermissionChain this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionChain$handlePermissionRequest$2(PermissionChain permissionChain, PermissionChain.PermissionTask permissionTask) {
        super(1);
        this.this$0 = permissionChain;
        this.$permissionTask = permissionTask;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, Boolean>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Map<String, Boolean> map) {
        int i;
        Intrinsics.checkNotNullParameter(map, "result");
        ArrayList arrayList = new ArrayList();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PermissionChain", "requestMultiplePermissionsResult, result: " + map);
        PermissionChain permissionChain = this.this$0;
        for (Map.Entry next : map.entrySet()) {
            PermissionHelper permissionHelper = PermissionHelper.f7819a;
            if (permissionHelper.u(permissionChain.f(), (String) next.getKey())) {
                permissionHelper.s((String) next.getKey(), true);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - ((Number) permissionChain.d.getOrDefault(next.getKey(), 0L)).longValue();
            ULog.Delegate delegate2 = ULog.f6446a;
            Object key = next.getKey();
            delegate2.a("PermissionChain", "requestMultiplePermissionsResult, permission: " + key + ", permissionCostTime: " + elapsedRealtime);
            if (((Boolean) next.getValue()).booleanValue()) {
                i = 0;
                permissionHelper.t((String) next.getKey(), 0);
            } else {
                if (elapsedRealtime < 350) {
                    permissionHelper.s((String) next.getKey(), true);
                }
                i = permissionHelper.h((String) next.getKey()) + 1;
                permissionHelper.t((String) next.getKey(), i);
            }
            arrayList.add(new PermissionDetail((String) next.getKey(), ((Boolean) next.getValue()).booleanValue(), i));
        }
        PermissionChain permissionChain2 = this.this$0;
        PermissionChain.PermissionTask permissionTask = this.$permissionTask;
        permissionChain2.h(permissionTask, new PermissionResult(permissionTask.b(), arrayList, true));
    }
}
