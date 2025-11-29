package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordHistoryDetailActivity f5626a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ RecordEntity c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ SummaryRequestBean e;

    public /* synthetic */ b(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, boolean z, RecordEntity recordEntity, Function1 function1, SummaryRequestBean summaryRequestBean) {
        this.f5626a = fastRecordHistoryDetailActivity;
        this.b = z;
        this.c = recordEntity;
        this.d = function1;
        this.e = summaryRequestBean;
    }

    public final void run() {
        FastRecordHistoryDetailActivity$getSummaryRequestBean$1$1.invoke$lambda$0(this.f5626a, this.b, this.c, this.d, this.e);
    }
}
