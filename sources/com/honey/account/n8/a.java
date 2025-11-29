package com.honey.account.n8;

import android.view.View;
import android.widget.Button;
import com.upuphone.xr.sapp.monitor.notification.NotificationMockActivity;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationMockActivity f7463a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ Button c;

    public /* synthetic */ a(NotificationMockActivity notificationMockActivity, Function2 function2, Button button) {
        this.f7463a = notificationMockActivity;
        this.b = function2;
        this.c = button;
    }

    public final void onClick(View view) {
        NotificationMockActivity.u0(this.f7463a, this.b, this.c, view);
    }
}
