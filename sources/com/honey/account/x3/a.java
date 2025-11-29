package com.honey.account.x3;

import android.content.DialogInterface;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f5294a;
    public final /* synthetic */ RecordEntity b;
    public final /* synthetic */ FastRecordFragment c;
    public final /* synthetic */ int d;

    public /* synthetic */ a(Ref.ObjectRef objectRef, RecordEntity recordEntity, FastRecordFragment fastRecordFragment, int i) {
        this.f5294a = objectRef;
        this.b = recordEntity;
        this.c = fastRecordFragment;
        this.d = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FastRecordFragment.showChangeNameDialog$lambda$2(this.f5294a, this.b, this.c, this.d, dialogInterface, i);
    }
}
