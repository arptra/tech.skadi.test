package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper\n*L\n1#1,18:1\n543#2,2:19\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class UnicronUpdateHelper$startDownload$$inlined$Runnable$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassUpdateInfo f7837a;

    public UnicronUpdateHelper$startDownload$$inlined$Runnable$1(GlassUpdateInfo glassUpdateInfo) {
        this.f7837a = glassUpdateInfo;
    }

    public final void run() {
        UnicronUpdateHelper.b.V(this.f7837a, 1000);
    }
}
