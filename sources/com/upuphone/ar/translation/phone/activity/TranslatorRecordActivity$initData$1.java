package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "noteBean", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorRecordActivity$initData$1 extends Lambda implements Function1<NoteBean, Unit> {
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$initData$1(TranslatorRecordActivity translatorRecordActivity) {
        super(1);
        this.this$0 = translatorRecordActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NoteBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        this.this$0.mNoteBean = noteBean;
        NoteBean access$getMNoteBean$p = this.this$0.mNoteBean;
        LogExt.j("initData from DB noteBean=" + access$getMNoteBean$p, "TranslatorRecordActivity");
        this.this$0.handleSmartExtraction(noteBean);
        if (noteBean.getXrType() != 1) {
            this.this$0.handleListData(noteBean);
        } else if (noteBean.getTransType() == 3) {
            this.this$0.handleListData(noteBean);
        } else {
            this.this$0.handleTextData(noteBean);
        }
    }
}
