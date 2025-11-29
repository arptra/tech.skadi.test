package com.upuphone.ar.fastrecord.phone.ui.adapter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter$setEdtPasteListener$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "content", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDetailHistoryViewAdapter$setEdtPasteListener$1 implements TextWatcher {
    final /* synthetic */ int $position;
    final /* synthetic */ FastRecordDetailHistoryViewAdapter this$0;

    public FastRecordDetailHistoryViewAdapter$setEdtPasteListener$1(FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter, int i) {
        this.this$0 = fastRecordDetailHistoryViewAdapter;
        this.$position = i;
    }

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        int access$getCurEdtItemPosition$p = this.this$0.curEdtItemPosition;
        int i4 = this.$position;
        LogExt.logE("onTextChanged content = " + charSequence + ",curEdtItemPosition = " + access$getCurEdtItemPosition$p + ",position = " + i4, FastRecordDetailHistoryViewAdapter.TAG);
        this.this$0.curEdtValue = !TextUtils.isEmpty(charSequence) ? String.valueOf(charSequence) : "";
        if (this.this$0.curEdtItemPosition != -1 && this.this$0.curEdtItemPosition == this.$position) {
            ((RecordVoiceWordEntity) this.this$0.recordWordList.get(this.this$0.curEdtItemPosition)).setWordContentTemp(this.this$0.curEdtValue);
        }
    }
}
