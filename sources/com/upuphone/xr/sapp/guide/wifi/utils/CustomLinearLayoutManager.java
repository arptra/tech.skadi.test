package com.upuphone.xr.sapp.guide.wifi.utils;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/guide/wifi/utils/CustomLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "flag", "", "a", "(Z)V", "canScrollVertically", "()Z", "Z", "isScrollEnabled", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CustomLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7099a = true;

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public final void a(boolean z) {
        this.f7099a = z;
    }

    public boolean canScrollVertically() {
        return this.f7099a && super.canScrollVertically();
    }
}
