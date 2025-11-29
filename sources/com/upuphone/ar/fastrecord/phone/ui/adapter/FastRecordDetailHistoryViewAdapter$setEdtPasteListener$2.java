package com.upuphone.ar.fastrecord.phone.ui.adapter;

import android.os.Build;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.widget.CopyEditText;
import com.upuphone.ar.fastrecord.phone.utils.RecordRomUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter$setEdtPasteListener$2", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText$OnPasteCallback;", "onCopy", "", "content", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDetailHistoryViewAdapter$setEdtPasteListener$2 implements CopyEditText.OnPasteCallback {
    final /* synthetic */ FastRecordDetailHistoryViewAdapter this$0;

    public FastRecordDetailHistoryViewAdapter$setEdtPasteListener$2(FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter) {
        this.this$0 = fastRecordDetailHistoryViewAdapter;
    }

    public boolean onCopy(@Nullable String str) {
        int i = Build.VERSION.SDK_INT;
        LogExt.logE("onCopy content = " + str + ",Build.VERSION.SDK_INT = " + i, FastRecordDetailHistoryViewAdapter.TAG);
        RecordRomUtils.INSTANCE.needShowToastForCopy(new FastRecordDetailHistoryViewAdapter$setEdtPasteListener$2$onCopy$1(this.this$0));
        return true;
    }
}
