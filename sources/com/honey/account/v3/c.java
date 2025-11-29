package com.honey.account.v3;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordDetailHistoryViewAdapter;

public final /* synthetic */ class c implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordDetailHistoryViewAdapter f5231a;
    public final /* synthetic */ FastRecordDetailHistoryViewAdapter.FastRecordDealViewHolder b;

    public /* synthetic */ c(FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter, FastRecordDetailHistoryViewAdapter.FastRecordDealViewHolder fastRecordDealViewHolder) {
        this.f5231a = fastRecordDetailHistoryViewAdapter;
        this.b = fastRecordDealViewHolder;
    }

    public final boolean onLongClick(View view) {
        return FastRecordDetailHistoryViewAdapter.FastRecordDealViewHolder._init_$lambda$1(this.f5231a, this.b, view);
    }
}
