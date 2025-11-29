package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment$showChangeNameDialog$3$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "content", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$showChangeNameDialog$3$1 implements TextWatcher {
    final /* synthetic */ Ref.ObjectRef<FastRecordDrawableEditText> $inputValueEdt;
    final /* synthetic */ FastRecordFragment this$0;

    public FastRecordFragment$showChangeNameDialog$3$1(FastRecordFragment fastRecordFragment, Ref.ObjectRef<FastRecordDrawableEditText> objectRef) {
        this.this$0 = fastRecordFragment;
        this.$inputValueEdt = objectRef;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        LogExt.logE("afterTextChanged", "FastRecordFragment");
        AlertDialog access$getMReNameDialog$p = this.this$0.mReNameDialog;
        Editable editable2 = null;
        Button button = access$getMReNameDialog$p != null ? access$getMReNameDialog$p.getButton(-1) : null;
        boolean z = false;
        if (button != null) {
            FastRecordDrawableEditText fastRecordDrawableEditText = (FastRecordDrawableEditText) this.$inputValueEdt.element;
            Editable text = fastRecordDrawableEditText != null ? fastRecordDrawableEditText.getText() : null;
            button.setEnabled(!(text == null || text.length() == 0));
        }
        T t = this.$inputValueEdt.element;
        FastRecordDrawableEditText fastRecordDrawableEditText2 = (FastRecordDrawableEditText) t;
        if (fastRecordDrawableEditText2 != null) {
            FastRecordFragment fastRecordFragment = this.this$0;
            FastRecordDrawableEditText fastRecordDrawableEditText3 = (FastRecordDrawableEditText) t;
            if (fastRecordDrawableEditText3 != null) {
                editable2 = fastRecordDrawableEditText3.getText();
            }
            if (editable2 == null || editable2.length() == 0) {
                z = true;
            }
            fastRecordFragment.setDrawable(fastRecordDrawableEditText2, !z);
        }
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
