package com.upuphone.ar.tici.phone.epoxy;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/tici/phone/epoxy/BasicEpoxyModel;", "Lcom/airbnb/epoxy/EpoxyHolder;", "T", "Lcom/airbnb/epoxy/EpoxyModelWithHolder;", "", "layoutRes", "<init>", "(I)V", "x", "()I", "l", "I", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public abstract class BasicEpoxyModel<T extends EpoxyHolder> extends EpoxyModelWithHolder<T> {
    public final int l;

    public BasicEpoxyModel(int i) {
        this.l = i;
    }

    public int x() {
        return this.l;
    }
}
