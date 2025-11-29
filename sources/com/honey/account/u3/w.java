package com.honey.account.u3;

import android.content.DialogInterface;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public final /* synthetic */ class w implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordHistoryDetailActivity f5217a;

    public /* synthetic */ w(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.f5217a = fastRecordHistoryDetailActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FastRecordHistoryDetailActivity.showSaveAsrDialog$lambda$35(this.f5217a, dialogInterface, i);
    }
}
