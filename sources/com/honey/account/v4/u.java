package com.honey.account.v4;

import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeBean f5276a;
    public final /* synthetic */ TranscribeRecordFragment b;

    public /* synthetic */ u(TranscribeBean transcribeBean, TranscribeRecordFragment transcribeRecordFragment) {
        this.f5276a = transcribeBean;
        this.b = transcribeRecordFragment;
    }

    public final void run() {
        TranscribeRecordFragment.addRecords$lambda$8(this.f5276a, this.b);
    }
}
