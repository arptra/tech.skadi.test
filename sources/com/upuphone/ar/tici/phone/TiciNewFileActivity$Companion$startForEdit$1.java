package com.upuphone.ar.tici.phone;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciNewFileActivity$Companion$startForEdit$1 extends Lambda implements Function1<Intent, Unit> {
    final /* synthetic */ long $id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciNewFileActivity$Companion$startForEdit$1(long j) {
        super(1);
        this.$id = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "it");
        intent.putExtra("tici_id", this.$id);
    }
}
