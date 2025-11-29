package com.xjmz.myvu;

import androidx.activity.OnBackPressedCallback;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MYVUActivity$onCreate$2 extends Lambda implements Function1<OnBackPressedCallback, Unit> {
    final /* synthetic */ MYVUActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MYVUActivity$onCreate$2(MYVUActivity mYVUActivity) {
        super(1);
        this.this$0 = mYVUActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OnBackPressedCallback) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        ULog.f6446a.a("MYVUActivity", "onBackEvent, moveTaskToBack");
        this.this$0.moveTaskToBack(true);
    }
}
