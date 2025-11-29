package com.honey.account.h8;

import android.content.DialogInterface;
import com.upuphone.xr.sapp.fragment.AboutGlassFragment;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AboutGlassFragment f4531a;
    public final /* synthetic */ Ref.ObjectRef b;

    public /* synthetic */ a(AboutGlassFragment aboutGlassFragment, Ref.ObjectRef objectRef) {
        this.f4531a = aboutGlassFragment;
        this.b = objectRef;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AboutGlassFragment.k1(this.f4531a, this.b, dialogInterface, i);
    }
}
