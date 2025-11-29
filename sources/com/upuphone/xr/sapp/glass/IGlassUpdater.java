package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0004\b\u0006\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH¦@¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H¦@¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0011H¦@¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014H¦@¢\u0006\u0004\b\u0015\u0010\u0004J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/glass/IGlassUpdater;", "", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "e", "", "requiredStorage", "f", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "version", "digest", "", "h", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "a", "c", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "d", "Ljava/io/File;", "downloadFile", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "", "g", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface IGlassUpdater {
    Object a(Continuation continuation);

    Object c(Continuation continuation);

    Object d(Continuation continuation);

    Object e(Continuation continuation);

    Object f(long j, Continuation continuation);

    void g(File file, GlassUpdateInfo glassUpdateInfo);

    Object h(String str, String str2, Continuation continuation);

    Object j(Continuation continuation);
}
