package com.honey.account.v3;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordTodoViewAdapter;

public final /* synthetic */ class f implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordTodoViewAdapter f5234a;
    public final /* synthetic */ FastRecordTodoViewAdapter.FastRecordTodoViewHolder b;

    public /* synthetic */ f(FastRecordTodoViewAdapter fastRecordTodoViewAdapter, FastRecordTodoViewAdapter.FastRecordTodoViewHolder fastRecordTodoViewHolder) {
        this.f5234a = fastRecordTodoViewAdapter;
        this.b = fastRecordTodoViewHolder;
    }

    public final boolean onLongClick(View view) {
        return FastRecordTodoViewAdapter.FastRecordTodoViewHolder._init_$lambda$0(this.f5234a, this.b, view);
    }
}
