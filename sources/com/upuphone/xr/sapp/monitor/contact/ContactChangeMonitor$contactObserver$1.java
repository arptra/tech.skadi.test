package com.upuphone.xr.sapp.monitor.contact;

import android.database.ContentObserver;
import android.os.Handler;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor$contactObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ContactChangeMonitor$contactObserver$1 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContactChangeMonitor f7741a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContactChangeMonitor$contactObserver$1(ContactChangeMonitor contactChangeMonitor, Handler handler) {
        super(handler);
        this.f7741a = contactChangeMonitor;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("ContactChangeMonitor", "contact observer on change selfChange:" + z);
        this.f7741a.k();
        this.f7741a.j();
    }
}
