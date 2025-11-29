package com.honey.account.p4;

import android.content.DialogInterface;
import com.upuphone.ar.tici.phone.TiciHistoryActivity;
import com.upuphone.ar.tici.phone.data.TiciHistory;

public final /* synthetic */ class q implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciHistoryActivity f5066a;
    public final /* synthetic */ TiciHistory b;

    public /* synthetic */ q(TiciHistoryActivity ticiHistoryActivity, TiciHistory ticiHistory) {
        this.f5066a = ticiHistoryActivity;
        this.b = ticiHistory;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TiciHistoryActivity.W0(this.f5066a, this.b, dialogInterface, i);
    }
}
