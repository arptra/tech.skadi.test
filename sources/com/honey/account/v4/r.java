package com.honey.account.v4;

import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;
import com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;

public final /* synthetic */ class r implements NoteListAdapter.OnRenameTitleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeRecordFragment f5270a;

    public /* synthetic */ r(TranscribeRecordFragment transcribeRecordFragment) {
        this.f5270a = transcribeRecordFragment;
    }

    public final void a(ListItemBean listItemBean) {
        TranscribeRecordFragment.initAdapter$lambda$1(this.f5270a, listItemBean);
    }
}
