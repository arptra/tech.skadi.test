package com.upuphone.xr.sapp.utils;

import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/core/app/NotificationCompat$Builder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NotificationUtils$showNotification$1 extends Lambda implements Function1<NotificationCompat.Builder, Unit> {
    final /* synthetic */ boolean $autoCancel;
    final /* synthetic */ CharSequence $content;
    final /* synthetic */ PendingIntent $contentIntent;
    final /* synthetic */ boolean $onGoing;
    final /* synthetic */ int $priority;
    final /* synthetic */ Integer $progress;
    final /* synthetic */ boolean $silent;
    final /* synthetic */ int $smallIcon;
    final /* synthetic */ CharSequence $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationUtils$showNotification$1(int i, CharSequence charSequence, CharSequence charSequence2, Integer num, PendingIntent pendingIntent, int i2, boolean z, boolean z2, boolean z3) {
        super(1);
        this.$smallIcon = i;
        this.$title = charSequence;
        this.$content = charSequence2;
        this.$progress = num;
        this.$contentIntent = pendingIntent;
        this.$priority = i2;
        this.$autoCancel = z;
        this.$silent = z2;
        this.$onGoing = z3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NotificationCompat.Builder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NotificationCompat.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$showNotification");
        builder.H(this.$smallIcon);
        builder.n(this.$title);
        builder.m(this.$content);
        Integer num = this.$progress;
        if (num != null) {
            builder.D(100, num.intValue(), false);
        }
        builder.l(this.$contentIntent);
        builder.C(this.$priority);
        builder.q(-1);
        builder.Q(System.currentTimeMillis());
        builder.f(this.$autoCancel);
        builder.G(this.$silent);
        builder.A(this.$onGoing);
    }
}
