package com.honey.account.y3;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f5309a;

    public /* synthetic */ a(Function0 function0) {
        this.f5309a = function0;
    }

    public final void run() {
        FastRecordHistoryAsrOperator.createOrPostHandlerCommand$lambda$1(this.f5309a);
    }
}
