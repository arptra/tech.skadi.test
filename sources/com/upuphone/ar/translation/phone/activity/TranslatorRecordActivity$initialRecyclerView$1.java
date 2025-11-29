package com.upuphone.ar.translation.phone.activity;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "editable", "Landroid/text/Editable;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorRecordActivity$initialRecyclerView$1 extends Lambda implements Function2<Integer, Editable, Unit> {
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$initialRecyclerView$1(TranslatorRecordActivity translatorRecordActivity) {
        super(2);
        this.this$0 = translatorRecordActivity;
    }

    public final void invoke(int i, @NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        this.this$0.onListRecordChanged(i, editable);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (Editable) obj2);
        return Unit.INSTANCE;
    }
}
