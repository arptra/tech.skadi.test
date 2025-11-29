package com.honey.account.u3;

import android.content.DialogInterface;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public final /* synthetic */ class m implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordHistoryDetailActivity f5188a;

    public /* synthetic */ m(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.f5188a = fastRecordHistoryDetailActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FastRecordHistoryDetailActivity.showMergeVoiceDialog$lambda$33(this.f5188a, dialogInterface, i);
    }
}
