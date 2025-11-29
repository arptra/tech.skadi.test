package com.upuphone.ar.fastrecord.phone.ui.adapter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter$addContentEditTextChanged$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "content", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoViewAdapter$addContentEditTextChanged$1 implements TextWatcher {
    final /* synthetic */ int $position;
    final /* synthetic */ FastRecordTodoViewAdapter this$0;

    public FastRecordTodoViewAdapter$addContentEditTextChanged$1(FastRecordTodoViewAdapter fastRecordTodoViewAdapter, int i) {
        this.this$0 = fastRecordTodoViewAdapter;
        this.$position = i;
    }

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        LogExt.logE("beforeTextChanged", FastRecordTodoViewAdapter.TAG);
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        LogExt.logE("onTextChanged", FastRecordTodoViewAdapter.TAG);
        String valueOf = !TextUtils.isEmpty(charSequence) ? String.valueOf(charSequence) : "";
        int access$getLatestEditPosition$p = this.this$0.latestEditPosition;
        int i4 = this.$position;
        LogExt.logE("onTextChanged curEdtValue = " + valueOf + ",latestEditPosition = " + access$getLatestEditPosition$p + ",position = " + i4, FastRecordTodoViewAdapter.TAG);
        if (this.this$0.latestEditPosition >= 0 && this.$position == this.this$0.latestEditPosition) {
            if (valueOf.length() == 0) {
                int access$getLatestEditPosition$p2 = this.this$0.latestEditPosition;
                LogExt.logE("onTextChanged curEdtValue remove data latestEditPosition = " + access$getLatestEditPosition$p2, FastRecordTodoViewAdapter.TAG);
                this.this$0.editValueMap.put(Integer.valueOf(this.this$0.latestEditPosition), "");
                return;
            }
            LogExt.logE("onTextChanged curEdtValue editValueMap save value", FastRecordTodoViewAdapter.TAG);
            this.this$0.editValueMap.put(Integer.valueOf(this.this$0.latestEditPosition), valueOf);
        }
    }
}
