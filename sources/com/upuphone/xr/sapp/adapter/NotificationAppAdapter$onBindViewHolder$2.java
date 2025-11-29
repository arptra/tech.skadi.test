package com.upuphone.xr.sapp.adapter;

import android.view.View;
import com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NotificationAppAdapter$onBindViewHolder$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ AppInfoModel $model;
    final /* synthetic */ NotificationAppAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationAppAdapter$onBindViewHolder$2(NotificationAppAdapter notificationAppAdapter, AppInfoModel appInfoModel) {
        super(1);
        this.this$0 = notificationAppAdapter;
        this.$model = appInfoModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        Function1 h = this.this$0.h();
        if (h != null) {
            h.invoke(this.$model);
        }
    }
}
