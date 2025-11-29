package com.upuphone.ar.translation.phone.activity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorRecordActivity$initListener$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$initListener$5(TranslatorRecordActivity translatorRecordActivity) {
        super(0);
        this.this$0 = translatorRecordActivity;
    }

    public final void invoke() {
        List list;
        NoteBean access$getMNoteBean$p = this.this$0.mNoteBean;
        if (access$getMNoteBean$p != null) {
            TranslatorRecordActivity translatorRecordActivity = this.this$0;
            TranslatorRecordViewModel access$getMTranslatorRecordVm = translatorRecordActivity.getMTranslatorRecordVm();
            ActivityTranslatorRecordBinding access$getMBinding$p = translatorRecordActivity.mBinding;
            ActivityTranslatorRecordBinding activityTranslatorRecordBinding = null;
            if (access$getMBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                access$getMBinding$p = null;
            }
            RecyclerView recyclerView = access$getMBinding$p.h;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            ActivityTranslatorRecordBinding access$getMBinding$p2 = translatorRecordActivity.mBinding;
            if (access$getMBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                access$getMBinding$p2 = null;
            }
            ConstraintLayout constraintLayout = access$getMBinding$p2.b;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "clText");
            NoteDetailAdapter access$getMAdapter$p = translatorRecordActivity.mAdapter;
            if (access$getMAdapter$p == null || (list = access$getMAdapter$p.getData()) == null) {
                list = new ArrayList();
            }
            ActivityTranslatorRecordBinding access$getMBinding$p3 = translatorRecordActivity.mBinding;
            if (access$getMBinding$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTranslatorRecordBinding = access$getMBinding$p3;
            }
            access$getMTranslatorRecordVm.P(translatorRecordActivity, access$getMNoteBean$p, recyclerView, constraintLayout, list, String.valueOf(activityTranslatorRecordBinding.c.getText()));
        }
    }
}
