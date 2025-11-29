package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.databinding.ActivityTranscribeAiBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeAIActivity$initViewModels$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ TranscribeAIActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeAIActivity$initViewModels$1(TranscribeAIActivity transcribeAIActivity) {
        super(1);
        this.this$0 = transcribeAIActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        String str2 = (String) this.this$0.getAiShareViewModel().k().getValue();
        ActivityTranscribeAiBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.c.setIconMenuEnable((str != null && !StringsKt.isBlank(str)) || (str2 != null && !StringsKt.isBlank(str2)));
    }
}
