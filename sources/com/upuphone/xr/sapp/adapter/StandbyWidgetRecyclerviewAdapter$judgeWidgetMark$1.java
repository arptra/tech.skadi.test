package com.upuphone.xr.sapp.adapter;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "key", "", "value", "", "invoke", "(Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StandbyWidgetRecyclerviewAdapter$judgeWidgetMark$1 extends Lambda implements Function2<String, Integer, Unit> {
    final /* synthetic */ Ref.IntRef $widgetMark;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandbyWidgetRecyclerviewAdapter$judgeWidgetMark$1(Ref.IntRef intRef) {
        super(2);
        this.$widgetMark = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Integer) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull Integer num) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(num, AccountConstantKt.RESPONSE_VALUE);
        this.$widgetMark.element += num.intValue();
    }
}
