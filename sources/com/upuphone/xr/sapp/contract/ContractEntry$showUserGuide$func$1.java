package com.upuphone.xr.sapp.contract;

import android.app.Activity;
import androidx.core.util.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ContractEntry$showUserGuide$func$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ int $category;
    final /* synthetic */ Consumer<UserGuideAuthResult> $consumer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContractEntry$showUserGuide$func$1(int i, Activity activity, Consumer<UserGuideAuthResult> consumer) {
        super(0);
        this.$category = i;
        this.$activity = activity;
        this.$consumer = consumer;
    }

    public final void invoke() {
        if (this.$category == 1) {
            new AssistantUserGuideDialogController(this.$activity).k(this.$consumer);
        } else {
            new AppUserGuideDialogController(this.$activity).n();
        }
    }
}
