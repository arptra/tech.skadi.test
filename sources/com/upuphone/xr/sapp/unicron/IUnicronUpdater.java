package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.entity.CheckUpdateFileReq;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/unicron/IUnicronUpdater;", "", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;", "req", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileResp;", "c", "(Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "file", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "unicronInfo", "", "a", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Lcom/upuphone/xr/sapp/entity/UnicronInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface IUnicronUpdater {
    void a(File file, GlassUpdateInfo glassUpdateInfo, UnicronInfo unicronInfo);

    Object c(CheckUpdateFileReq checkUpdateFileReq, Continuation continuation);
}
