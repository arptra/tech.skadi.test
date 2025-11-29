package com.upuphone.ar.transcribe.phone.activity;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.content.ContextCompat;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.ActivityTranscirbeSearchBinding;
import com.upuphone.ar.transcribe.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TranscribeSearchActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeSearchActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n87#2,23:98\n71#3:121\n77#4:122\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeSearchActivity$initViews$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ TranscribeSearchActivity this$0;

    public TranscribeSearchActivity$initViews$$inlined$addTextChangedListener$default$1(TranscribeSearchActivity transcribeSearchActivity) {
        this.this$0 = transcribeSearchActivity;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        boolean z = false;
        if ((editable != null ? editable.length() : 0) > 0) {
            ActivityTranscirbeSearchBinding access$getBinding$p = this.this$0.binding;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            access$getBinding$p.g.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(this.this$0, R.drawable.trsb_serach_mark_icon), (Drawable) null, ContextCompat.getDrawable(this.this$0, R.drawable.trsb_search_delete_icon), (Drawable) null);
            LogExt.d("input search: " + editable, "TranscribeSearchActivity");
            if (editable != null && (!StringsKt.isBlank(editable))) {
                z = true;
            }
            if (z) {
                this.this$0.searchText(editable.toString());
            } else {
                this.this$0.hideViews();
            }
        } else {
            this.this$0.hideViews();
            ActivityTranscirbeSearchBinding access$getBinding$p2 = this.this$0.binding;
            if (access$getBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p2 = null;
            }
            access$getBinding$p2.g.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(this.this$0, R.drawable.trsb_serach_mark_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
