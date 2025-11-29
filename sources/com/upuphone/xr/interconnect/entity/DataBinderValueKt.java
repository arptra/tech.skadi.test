package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001*\u00020\u0003H\u0002\u001a \u0010\u0004\u001a\u00020\u0005*\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001H\u0002¨\u0006\u0007"}, d2 = {"readBatch", "", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "Landroid/os/Parcel;", "writeBatch", "", "batch", "Shared_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataBinderValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderValue.kt\ncom/upuphone/xr/interconnect/entity/DataBinderValueKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,269:1\n1855#2,2:270\n*S KotlinDebug\n*F\n+ 1 DataBinderValue.kt\ncom/upuphone/xr/interconnect/entity/DataBinderValueKt\n*L\n261#1:270,2\n*E\n"})
public final class DataBinderValueKt {
    /* access modifiers changed from: private */
    public static final List<DataBinderValue<?>> readBatch(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(DataBinderValue.CREATOR.createFromParcel(parcel));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final void writeBatch(Parcel parcel, List<? extends DataBinderValue<?>> list) {
        parcel.writeInt(list.size());
        for (DataBinderValue dataBinderValue : list) {
            if (dataBinderValue != null) {
                dataBinderValue.writeToParcel(parcel, 0);
            } else {
                parcel.writeByte((byte) -1);
            }
        }
    }
}
