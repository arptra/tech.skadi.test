package com.upuphone.xr.sapp.contract;

import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.model.IPlace;
import com.upuphone.star.core.log.ULog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/upuphone/ar/navi/lite/base/PlaceBean;", "placeList", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 9, 0})
public final class ReceiveLocationEventManager$getCountryCode$2$1$1 implements IPlace {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f6704a;

    public ReceiveLocationEventManager$getCountryCode$2$1$1(CancellableContinuation cancellableContinuation) {
        this.f6704a = cancellableContinuation;
    }

    public final void a(List list) {
        if (list == null || list.isEmpty()) {
            ULog.f6446a.c("ReceiveLocationEventManager", "getCountryCode placeList为空");
            this.f6704a.m("", (Function1) null);
            return;
        }
        String countryCode = ((PlaceBean) list.get(0)).getCountryCode();
        CancellableContinuation cancellableContinuation = this.f6704a;
        Intrinsics.checkNotNull(countryCode);
        cancellableContinuation.m(countryCode, (Function1) null);
    }
}
