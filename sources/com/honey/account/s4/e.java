package com.honey.account.s4;

import android.content.DialogInterface;
import com.upuphone.ar.tici.phone.utils.StoragePermission;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f5124a;

    public /* synthetic */ e(Function0 function0) {
        this.f5124a = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        StoragePermission.g(this.f5124a, dialogInterface, i);
    }
}
