package com.upuphone.ar.transcribe.phone.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TranscribeDetailActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeDetailActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n180#2,4:98\n71#3:102\n77#4:103\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeDetailActivity$initView$$inlined$doAfterTextChanged$1 implements TextWatcher {
    final /* synthetic */ TranscribeDetailActivity this$0;

    public TranscribeDetailActivity$initView$$inlined$doAfterTextChanged$1(TranscribeDetailActivity transcribeDetailActivity) {
        this.this$0 = transcribeDetailActivity;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        ActivityTranscribeDetailBinding access$getMBinding$p = this.this$0.mBinding;
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = null;
        if (access$getMBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            access$getMBinding$p = null;
        }
        if (access$getMBinding$p.m.q()) {
            ActivityTranscribeDetailBinding access$getMBinding$p2 = this.this$0.mBinding;
            if (access$getMBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTranscribeDetailBinding = access$getMBinding$p2;
            }
            activityTranscribeDetailBinding.i.setTextMenuEnable(this.this$0.isEditTextChange());
        }
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
