package com.upuphone.ar.music.phone.helper;

import android.app.Service;
import android.content.Context;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/music/phone/helper/MusicPhoneUniversalHelper;", "", "<init>", "()V", "Landroid/app/Service;", "service", "", "b", "(Landroid/app/Service;)V", "Landroid/content/Context;", "context", "", "phoneType", "a", "(Landroid/content/Context;Z)V", "ar-music-intl_release"}, k = 1, mv = {1, 9, 0})
public final class MusicPhoneUniversalHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final MusicPhoneUniversalHelper f5631a = new MusicPhoneUniversalHelper();

    public final void a(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        ULog.f6446a.o("MusicUniversalHelper", "initMusicForPhone intl version do not exit");
    }

    public final void b(Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        ULog.f6446a.o("MusicUniversalHelper", "initMusicFromService intl version do not exit");
    }
}
