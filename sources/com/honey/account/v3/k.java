package com.honey.account.v3;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;

public final /* synthetic */ class k implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordViewAdapter f5239a;
    public final /* synthetic */ FastRecordViewAdapter.FastRecordViewHolder b;

    public /* synthetic */ k(FastRecordViewAdapter fastRecordViewAdapter, FastRecordViewAdapter.FastRecordViewHolder fastRecordViewHolder) {
        this.f5239a = fastRecordViewAdapter;
        this.b = fastRecordViewHolder;
    }

    public final boolean onLongClick(View view) {
        return FastRecordViewAdapter.FastRecordViewHolder._init_$lambda$1(this.f5239a, this.b, view);
    }
}
