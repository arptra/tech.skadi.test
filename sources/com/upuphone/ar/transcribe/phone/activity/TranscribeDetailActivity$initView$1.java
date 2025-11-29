package com.upuphone.ar.transcribe.phone.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeDetailActivity$initView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TranscribeDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeDetailActivity$initView$1(TranscribeDetailActivity transcribeDetailActivity) {
        super(0);
        this.this$0 = transcribeDetailActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        if (kotlin.text.StringsKt.isBlank(java.lang.String.valueOf(r0.m.getText())) != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r1 = this;
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r0 = r1.this$0
            boolean r0 = r0.isInEditModel()
            if (r0 == 0) goto L_0x0034
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r0 = r1.this$0
            boolean r0 = r0.isEditTextChange()
            if (r0 != 0) goto L_0x002e
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r0 = r1.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r0 = r0.mBinding
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = "mBinding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L_0x001e:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r0 = r0.m
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0034
        L_0x002e:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r1.this$0
            r1.showRecordEditedDialog()
            goto L_0x0039
        L_0x0034:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r1.this$0
            r1.finish()
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$initView$1.invoke():void");
    }
}
