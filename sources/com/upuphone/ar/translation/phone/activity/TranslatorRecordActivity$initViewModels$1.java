package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "isTextRtl", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorRecordActivity$initViewModels$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$initViewModels$1(TranslatorRecordActivity translatorRecordActivity) {
        super(1);
        this.this$0 = translatorRecordActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        boolean f = ContextExtKt.f(this.this$0);
        LogExt.j("initViewModels isTextRtl=" + bool + ", isViewRtl=" + f, "TranslatorRecordActivity");
        Intrinsics.checkNotNull(bool);
        int i = 6;
        int i2 = 8388613;
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding = null;
        if (bool.booleanValue()) {
            ActivityTranslatorRecordBinding access$getMBinding$p = this.this$0.mBinding;
            if (access$getMBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                access$getMBinding$p = null;
            }
            ClipboardEditText clipboardEditText = access$getMBinding$p.c;
            if (f) {
                i2 = 8388611;
            }
            clipboardEditText.setGravity(i2);
            ActivityTranslatorRecordBinding access$getMBinding$p2 = this.this$0.mBinding;
            if (access$getMBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTranslatorRecordBinding = access$getMBinding$p2;
            }
            ClipboardEditText clipboardEditText2 = activityTranslatorRecordBinding.c;
            if (f) {
                i = 5;
            }
            clipboardEditText2.setTextAlignment(i);
            return;
        }
        ActivityTranslatorRecordBinding access$getMBinding$p3 = this.this$0.mBinding;
        if (access$getMBinding$p3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            access$getMBinding$p3 = null;
        }
        ClipboardEditText clipboardEditText3 = access$getMBinding$p3.c;
        if (!f) {
            i2 = 8388611;
        }
        clipboardEditText3.setGravity(i2);
        ActivityTranslatorRecordBinding access$getMBinding$p4 = this.this$0.mBinding;
        if (access$getMBinding$p4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranslatorRecordBinding = access$getMBinding$p4;
        }
        ClipboardEditText clipboardEditText4 = activityTranslatorRecordBinding.c;
        if (!f) {
            i = 5;
        }
        clipboardEditText4.setTextAlignment(i);
    }
}
