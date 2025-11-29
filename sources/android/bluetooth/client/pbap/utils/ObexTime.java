package android.bluetooth.client.pbap.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class ObexTime {

    /* renamed from: a  reason: collision with root package name */
    public Date f83a;

    public String toString() {
        if (this.f83a == null) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(this.f83a);
        return String.format(Locale.US, "%04d%02d%02dT%02d%02d%02d", new Object[]{Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)), Integer.valueOf(instance.get(13))});
    }
}
