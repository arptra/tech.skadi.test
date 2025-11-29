package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "isListTextRtl", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorRecordActivity$initViewModels$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$initViewModels$2(TranslatorRecordActivity translatorRecordActivity) {
        super(1);
        this.this$0 = translatorRecordActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        Unit unit;
        NoteDetailAdapter access$getMAdapter$p = this.this$0.mAdapter;
        if (access$getMAdapter$p != null) {
            boolean f = ContextExtKt.f(this.this$0);
            LogExt.j("initViewModels isListTextRtl=" + bool + ", isViewRtl=" + f, "TranslatorRecordActivity");
            Intrinsics.checkNotNull(bool);
            access$getMAdapter$p.R0(bool.booleanValue(), f);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogExt.j("initViewModels set record rtl adapter is null", "TranslatorRecordActivity");
        }
    }
}
