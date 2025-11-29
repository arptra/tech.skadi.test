package com.upuphone.ar.tici.phone.utils;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StoragePermission$showPermissionDeniedDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ StoragePermission this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoragePermission$showPermissionDeniedDialog$1(StoragePermission storagePermission, Activity activity) {
        super(0);
        this.this$0 = storagePermission;
        this.$activity = activity;
    }

    public final void invoke() {
        CommonExtKt.e("showPermissionDeniedDialog-> 打开设置", "StoragePermission");
        this.this$0.i(this.$activity);
    }
}
