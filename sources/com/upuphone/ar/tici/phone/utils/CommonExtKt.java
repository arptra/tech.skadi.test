package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.upuphone.ar.tici.R;
import com.upuphone.star.core.log.ULog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a'\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\n\u001a\u00020\u0002*\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\f\u001a\u00020\u0002*\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a%\u0010\u0011\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0014\u001a\u00020\u0002*\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"", "tag", "", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "b", "", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Landroid/view/View;", "g", "(Landroid/view/View;)V", "f", "Landroid/content/Context;", "context", "", "showTime", "i", "(Ljava/lang/String;Landroid/content/Context;I)V", "resId", "h", "(Landroid/content/Context;II)V", "", "updateTime", "a", "(Landroid/content/Context;J)Ljava/lang/String;", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class CommonExtKt {
    public static final String a(Context context, long j) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        int i = instance.get(1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.add(6, 0);
        Date time2 = instance.getTime();
        Date date = new Date(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(new Date(j));
        if (i == instance2.get(1)) {
            try {
                str = (!date.after(time2) || !date.before(time)) ? new SimpleDateFormat(context.getString(R.string.tici_date_format_month_day), Locale.getDefault()).format(Long.valueOf(j)) : new SimpleDateFormat("HH:mm", Locale.getDefault()).format(Long.valueOf(j));
            } catch (Exception e) {
                d("formatFileDate error: " + e, "TiciApp", (Throwable) null, 2, (Object) null);
                String format = new SimpleDateFormat("yyyy/M/d", Locale.getDefault()).format(Long.valueOf(j));
                Intrinsics.checkNotNull(format);
                return format;
            }
        } else {
            str = new SimpleDateFormat(context.getString(R.string.tici_date_format_year_month_day), Locale.getDefault()).format(Long.valueOf(j));
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    public static final void b(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ticip-" + str2, str);
    }

    public static final void c(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.d("ticip-" + str2, str, th);
    }

    public static /* synthetic */ void d(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        c(str, str2, th);
    }

    public static final void e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ticip-" + str2, str);
    }

    public static final void f(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public static final void g(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }

    public static final void h(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Toast.makeText(context, i, i2).show();
    }

    public static final void i(String str, Context context, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Toast.makeText(context, str, i).show();
    }

    public static /* synthetic */ void j(Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        h(context, i, i2);
    }

    public static /* synthetic */ void k(String str, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        i(str, context, i);
    }
}
