package com.honey.account.u3;

import android.content.DialogInterface;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public final /* synthetic */ class n implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordHistoryDetailActivity f5191a;

    public /* synthetic */ n(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.f5191a = fastRecordHistoryDetailActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FastRecordHistoryDetailActivity.showMergeVoiceDialog$lambda$34(this.f5191a, dialogInterface, i);
    }
}
