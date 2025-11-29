package com.honey.account.v3;

import android.widget.EditText;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordDetailHistoryViewAdapter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordDetailHistoryViewAdapter f5229a;
    public final /* synthetic */ EditText b;

    public /* synthetic */ a(FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter, EditText editText) {
        this.f5229a = fastRecordDetailHistoryViewAdapter;
        this.b = editText;
    }

    public final void run() {
        FastRecordDetailHistoryViewAdapter.showInput$lambda$4(this.f5229a, this.b);
    }
}
