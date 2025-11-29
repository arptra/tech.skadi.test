package com.upuphone.ar.translation.phone.broadcast;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.CalendarContract;
import com.upuphone.ar.translation.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0017\u001a\u00020\f2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aR3\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001d¨\u0006!"}, d2 = {"Lcom/upuphone/ar/translation/phone/broadcast/CalendarContentObserver;", "Landroid/database/ContentObserver;", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/Handler;)V", "", "selfChange", "Landroid/net/Uri;", "uri", "", "flags", "", "onChange", "(ZLandroid/net/Uri;I)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "eventId", "eventCallback", "Lkotlin/Function0;", "baseCallback", "a", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "b", "()V", "Lkotlin/jvm/functions/Function1;", "mEventCallback", "Lkotlin/jvm/functions/Function0;", "mBaseCallback", "c", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CalendarContentObserver extends ContentObserver {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Function1 f6223a;
    public Function0 b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/broadcast/CalendarContentObserver$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CalendarContentObserver(Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
    }

    public final void a(Function1 function1, Function0 function0) {
        Intrinsics.checkNotNullParameter(function1, "eventCallback");
        Intrinsics.checkNotNullParameter(function0, "baseCallback");
        this.f6223a = function1;
        this.b = function0;
    }

    public final void b() {
        this.f6223a = null;
        this.b = null;
    }

    public void onChange(boolean z, Uri uri, int i) {
        super.onChange(z, uri, i);
        if (uri != null) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
            String uri3 = CalendarContract.Events.CONTENT_URI.toString();
            Intrinsics.checkNotNullExpressionValue(uri3, "toString(...)");
            String uri4 = CalendarContract.CONTENT_URI.toString();
            Intrinsics.checkNotNullExpressionValue(uri4, "toString(...)");
            LogExt.j("onChange uriStr[" + uri2 + "], calendarEventUriStr[" + uri3 + "], calendarBaseUriStr[" + uri4 + "]", "CalendarContentObserver");
            if (StringsKt.startsWith$default(uri2, uri3, false, 2, (Object) null)) {
                String lastPathSegment = uri.getLastPathSegment();
                if (lastPathSegment != null) {
                    Intrinsics.checkNotNull(lastPathSegment);
                    Long longOrNull = StringsKt.toLongOrNull(lastPathSegment);
                    if (longOrNull != null) {
                        long longValue = longOrNull.longValue();
                        LogExt.j("onChange event callback eventId=" + longValue, "CalendarContentObserver");
                        Function1 function1 = this.f6223a;
                        if (function1 != null) {
                            function1.invoke(Long.valueOf(longValue));
                        }
                    }
                }
            } else if (StringsKt.startsWith$default(uri2, uri4, false, 2, (Object) null)) {
                LogExt.j("onChange base callback", "CalendarContentObserver");
                Function0 function0 = this.b;
                if (function0 != null) {
                    function0.invoke();
                }
            } else {
                LogExt.j("onChange not need uri", "CalendarContentObserver");
            }
        }
    }
}
