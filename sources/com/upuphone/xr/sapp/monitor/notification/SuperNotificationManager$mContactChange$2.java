package com.upuphone.xr.sapp.monitor.notification;

import com.upuphone.xr.sapp.monitor.contact.ContactChangeMonitor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SuperNotificationManager$mContactChange$2 extends Lambda implements Function0<ContactChangeMonitor> {
    public static final SuperNotificationManager$mContactChange$2 INSTANCE = new SuperNotificationManager$mContactChange$2();

    public SuperNotificationManager$mContactChange$2() {
        super(0);
    }

    @NotNull
    public final ContactChangeMonitor invoke() {
        return new ContactChangeMonitor();
    }
}
