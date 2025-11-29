package com.upuphone.xr.sapp.fragment;

import com.upuphone.runasone.share.lib.TransferHandler;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.GenericMenuView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ScheduleDisplayFragment$selectArray$2 extends Lambda implements Function0<List<GenericMenuView.MenuItem>> {
    final /* synthetic */ ScheduleDisplayFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScheduleDisplayFragment$selectArray$2(ScheduleDisplayFragment scheduleDisplayFragment) {
        super(0);
        this.this$0 = scheduleDisplayFragment;
    }

    @NotNull
    public final List<GenericMenuView.MenuItem> invoke() {
        String string = this.this$0.getString(R.string.schedule_display_time_30);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        GenericMenuView.MenuItem menuItem = new GenericMenuView.MenuItem(string, TransferHandler.TIMEOUT, false);
        String string2 = this.this$0.getString(R.string.schedule_display_time_resident);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return CollectionsKt.toMutableList(CollectionsKt.arrayListOf(menuItem, new GenericMenuView.MenuItem(string2, -1, false)));
    }
}
