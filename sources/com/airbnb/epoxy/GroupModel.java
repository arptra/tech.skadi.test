package com.airbnb.epoxy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@EpoxyModelClass
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u00012\u00020\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/airbnb/epoxy/GroupModel;", "Lcom/airbnb/epoxy/EpoxyModelGroup;", "Lcom/airbnb/epoxy/ModelCollector;", "Lcom/airbnb/epoxy/EpoxyModel;", "model", "", "add", "(Lcom/airbnb/epoxy/EpoxyModel;)V", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public abstract class GroupModel extends EpoxyModelGroup implements ModelCollector {
    public void add(EpoxyModel epoxyModel) {
        Intrinsics.checkNotNullParameter(epoxyModel, "model");
        super.e0(epoxyModel);
    }
}
