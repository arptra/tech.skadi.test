package com.upuphone.ar.tici.phone.data;

import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciFileChangedEvent;", "", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ticiEntity", "<init>", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;)V", "a", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "()Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciFileChangedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final TiciEntity f5918a;

    public TiciFileChangedEvent(TiciEntity ticiEntity) {
        Intrinsics.checkNotNullParameter(ticiEntity, "ticiEntity");
        this.f5918a = ticiEntity;
    }

    public final TiciEntity a() {
        return this.f5918a;
    }
}
