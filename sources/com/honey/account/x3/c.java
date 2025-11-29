package com.honey.account.x3;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class c implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f5295a;

    public /* synthetic */ c(Ref.ObjectRef objectRef) {
        this.f5295a = objectRef;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        FastRecordFragment.showChangeNameDialog$lambda$5$lambda$4(this.f5295a, view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
