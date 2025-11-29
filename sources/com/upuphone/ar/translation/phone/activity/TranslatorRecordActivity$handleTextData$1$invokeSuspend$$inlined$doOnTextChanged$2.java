package com.upuphone.ar.translation.phone.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding;
import com.upuphone.ar.translation.phone.view.TransTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$3\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TranslatorRecordActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity$handleTextData$1\n*L\n1#1,97:1\n78#2:98\n71#3:99\n541#4,4:100\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslatorRecordActivity$handleTextData$1$invokeSuspend$$inlined$doOnTextChanged$2 implements TextWatcher {
    final /* synthetic */ TranslatorRecordActivity this$0;

    public TranslatorRecordActivity$handleTextData$1$invokeSuspend$$inlined$doOnTextChanged$2(TranslatorRecordActivity translatorRecordActivity) {
        this.this$0 = translatorRecordActivity;
    }

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        ActivityTranslatorRecordBinding access$getMBinding$p = this.this$0.mBinding;
        String str = null;
        if (access$getMBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            access$getMBinding$p = null;
        }
        TransTitleBar transTitleBar = access$getMBinding$p.i;
        if (charSequence != null) {
            str = charSequence.toString();
        }
        transTitleBar.setTextMenuEnabled((!Intrinsics.areEqual((Object) str, (Object) this.this$0.mOriginalRecordContent) && !this.this$0.isTextTitleBlank()) || this.this$0.isTextTitleUpdated());
    }
}
