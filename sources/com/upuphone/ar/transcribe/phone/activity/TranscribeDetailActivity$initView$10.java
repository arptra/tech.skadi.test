package com.upuphone.ar.transcribe.phone.activity;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeDetailActivity$initView$10 extends Lambda implements Function1<OnBackPressedCallback, Unit> {
    final /* synthetic */ TranscribeDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeDetailActivity$initView$10(TranscribeDetailActivity transcribeDetailActivity) {
        super(1);
        this.this$0 = transcribeDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OnBackPressedCallback) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        if (!this.this$0.isInEditModel() || !this.this$0.isEditTextChange()) {
            this.this$0.finish();
        } else {
            this.this$0.showRecordEditedDialog();
        }
    }
}
