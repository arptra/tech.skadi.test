package com.upuphone.xr.sapp.adapter;

import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.adapter.NotificationAppAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "button", "Lcom/meizu/common/widget/Switch;", "isChecked", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NotificationAppAdapter$onBindViewHolder$1 extends Lambda implements Function2<Switch, Boolean, Unit> {
    final /* synthetic */ NotificationAppAdapter.NotificationAppHolder $holder;
    final /* synthetic */ NotificationAppAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationAppAdapter$onBindViewHolder$1(NotificationAppAdapter notificationAppAdapter, NotificationAppAdapter.NotificationAppHolder notificationAppHolder) {
        super(2);
        this.this$0 = notificationAppAdapter;
        this.$holder = notificationAppHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Switch) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Switch switchR, boolean z) {
        Function2 i;
        Intrinsics.checkNotNullParameter(switchR, "button");
        if (switchR.isPressed() && (i = this.this$0.i()) != null) {
            i.invoke(Integer.valueOf(this.$holder.getLayoutPosition()), Boolean.valueOf(z));
        }
    }
}
