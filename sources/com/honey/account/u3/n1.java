package com.honey.account.u3;

import android.content.DialogInterface;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordTagScheduleDialog;

public final /* synthetic */ class n1 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordTagScheduleDialog f5193a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ n1(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, boolean z) {
        this.f5193a = fastRecordTagScheduleDialog;
        this.b = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FastRecordTagScheduleDialog.showSaveChangeDialog$lambda$7(this.f5193a, this.b, dialogInterface, i);
    }
}
