package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.databinding.ActivityTranscribeAiBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeAIActivity$initListener$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TranscribeAIActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeAIActivity$initListener$3(TranscribeAIActivity transcribeAIActivity) {
        super(0);
        this.this$0 = transcribeAIActivity;
    }

    public final void invoke() {
        ActivityTranscribeAiBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.c.requestFocus();
        this.this$0.shareTextFile();
    }
}
