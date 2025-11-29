package com.honey.account.s3;

import android.view.View;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.fastrecord.phone.ext.RecordViewKt;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f5119a;
    public final /* synthetic */ Switch b;

    public /* synthetic */ a(Function2 function2, Switch switchR) {
        this.f5119a = function2;
        this.b = switchR;
    }

    public final void onClick(View view) {
        RecordViewKt.recordOnCheckedChange$lambda$0(this.f5119a, this.b, view);
    }
}
