package com.honey.account.w4;

import android.view.View;
import com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoteListAdapter f5290a;
    public final /* synthetic */ ListItemBean b;

    public /* synthetic */ c(NoteListAdapter noteListAdapter, ListItemBean listItemBean) {
        this.f5290a = noteListAdapter;
        this.b = listItemBean;
    }

    public final void onClick(View view) {
        NoteListAdapter.w0(this.f5290a, this.b, view);
    }
}
