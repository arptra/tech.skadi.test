package com.upuphone.ar.transcribe.phone.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ImageView;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;
import com.upuphone.star.core.log.ULog;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 5 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n449#2,5:98\n454#2:105\n262#3,2:103\n71#4:106\n77#5:107\n*S KotlinDebug\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment\n*L\n453#1:103,2\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeRecordFragment$showRenameDialog$$inlined$doAfterTextChanged$1 implements TextWatcher {
    final /* synthetic */ ListItemBean $bean$inlined;
    final /* synthetic */ ImageView $deleteBt$inlined;
    final /* synthetic */ TranscribeRecordFragment this$0;

    public TranscribeRecordFragment$showRenameDialog$$inlined$doAfterTextChanged$1(TranscribeRecordFragment transcribeRecordFragment, ListItemBean listItemBean, ImageView imageView) {
        this.this$0 = transcribeRecordFragment;
        this.$bean$inlined = listItemBean;
        this.$deleteBt$inlined = imageView;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        ULog.f6446a.a("TransRecordFragment", "afterTextChanged");
        int i = 0;
        boolean z = editable == null || editable.length() == 0;
        AlertDialog access$getRenameDialog$p = this.this$0.renameDialog;
        Button button = access$getRenameDialog$p != null ? access$getRenameDialog$p.getButton(-1) : null;
        if (button != null) {
            button.setEnabled(!z && !Intrinsics.areEqual((Object) String.valueOf(editable), (Object) String.valueOf(this.$bean$inlined.getTitle())));
        }
        ImageView imageView = this.$deleteBt$inlined;
        if (!(!z)) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
