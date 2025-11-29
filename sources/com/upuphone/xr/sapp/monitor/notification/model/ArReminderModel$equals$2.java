package com.upuphone.xr.sapp.monitor.notification.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ArReminderModel$equals$2 extends Lambda implements Function1<Long, CharSequence> {
    public static final ArReminderModel$equals$2 INSTANCE = new ArReminderModel$equals$2();

    public ArReminderModel$equals$2() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(long j) {
        return String.valueOf(j);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }
}
