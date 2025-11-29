package com.upuphone.xr.sapp;

import android.view.MenuItem;
import flyme.support.v7.widget.PopupMenu;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lflyme/support/v7/widget/PopupMenu;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TodoManageActivity$morePopupMenu$2 extends Lambda implements Function0<PopupMenu> {
    final /* synthetic */ TodoManageActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoManageActivity$morePopupMenu$2(TodoManageActivity todoManageActivity) {
        super(0);
        this.this$0 = todoManageActivity;
    }

    /* access modifiers changed from: private */
    public static final boolean invoke$lambda$0(TodoManageActivity todoManageActivity, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        todoManageActivity.d1(!todoManageActivity.f);
        return true;
    }

    @NotNull
    public final PopupMenu invoke() {
        TodoManageActivity todoManageActivity = this.this$0;
        PopupMenu popupMenu = new PopupMenu(todoManageActivity, todoManageActivity.L0().c, 5);
        popupMenu.inflate(R.menu.menu_todo_more_popup);
        popupMenu.setOnMenuItemClickListener(new a(this.this$0));
        return popupMenu;
    }
}
