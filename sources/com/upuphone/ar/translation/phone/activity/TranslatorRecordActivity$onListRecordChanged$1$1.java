package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.translation.phone.bean.NoteDetailBean;
import com.upuphone.ar.translation.phone.bean.NoteDetailUpdateBean;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bean", "Lcom/upuphone/ar/translation/phone/bean/NoteDetailUpdateBean;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorRecordActivity$onListRecordChanged$1$1 extends Lambda implements Function1<NoteDetailUpdateBean, Unit> {
    final /* synthetic */ NoteDetailAdapter $adapter;
    final /* synthetic */ NoteDetailBean $noteDetailBean;
    final /* synthetic */ int $position;
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$onListRecordChanged$1$1(NoteDetailBean noteDetailBean, NoteDetailAdapter noteDetailAdapter, int i, TranslatorRecordActivity translatorRecordActivity) {
        super(1);
        this.$noteDetailBean = noteDetailBean;
        this.$adapter = noteDetailAdapter;
        this.$position = i;
        this.this$0 = translatorRecordActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NoteDetailUpdateBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NoteDetailUpdateBean noteDetailUpdateBean) {
        Intrinsics.checkNotNullParameter(noteDetailUpdateBean, "bean");
        String obj = StringsKt.trim((CharSequence) this.$noteDetailBean.getSrc()).toString();
        String obj2 = StringsKt.trim((CharSequence) this.$noteDetailBean.getDst()).toString();
        String obj3 = StringsKt.trim((CharSequence) noteDetailUpdateBean.getSrc()).toString();
        String obj4 = StringsKt.trim((CharSequence) noteDetailUpdateBean.getDst()).toString();
        int i = 2;
        if (this.$noteDetailBean.isDisplaySrc()) {
            if (!Intrinsics.areEqual((Object) obj, (Object) obj3) || !Intrinsics.areEqual((Object) obj2, (Object) obj4)) {
                this.$noteDetailBean.setSrc(obj3);
                this.$noteDetailBean.setDst(obj4);
                NoteDetailBean noteDetailBean = this.$noteDetailBean;
                if (!StringsKt.isBlank(obj3) || !StringsKt.isBlank(obj4)) {
                    i = 1;
                }
                noteDetailBean.setNoteStatus(i);
            } else {
                return;
            }
        } else if (!Intrinsics.areEqual((Object) obj2, (Object) obj4)) {
            this.$noteDetailBean.setDst(obj4);
            NoteDetailBean noteDetailBean2 = this.$noteDetailBean;
            if (StringsKt.isBlank(obj4)) {
                this.$noteDetailBean.setSrc("");
            } else {
                i = 1;
            }
            noteDetailBean2.setNoteStatus(i);
        } else {
            return;
        }
        this.$adapter.getData().set(this.$position, this.$noteDetailBean);
        LogExt.g("onListRecordChanged " + this.$adapter.getData().get(this.$position), "TranslatorRecordActivity");
        ActivityTranslatorRecordBinding access$getMBinding$p = this.this$0.mBinding;
        if (access$getMBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            access$getMBinding$p = null;
        }
        access$getMBinding$p.i.setTextMenuEnabled(true);
    }
}
