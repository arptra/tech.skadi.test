package com.upuphone.xr.interconnect.task;

import com.upuphone.xr.interconnect.common.ITaskManager;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.util.DataBinderValueExtKt;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.ResourcePrintingKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0002\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0004H\u0000\u001a \u0010\u0005\u001a\u00020\u0006*\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¨\u0006\b"}, d2 = {"asResourceDescription", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "asResourceDescriptionList", "", "containsResource", "", "resource", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRunningTaskExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunningTaskExt.kt\ncom/upuphone/xr/interconnect/task/RunningTaskExtKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1747#2,2:52\n1749#2:55\n1603#2,9:56\n1855#2:65\n1856#2:67\n1612#2:68\n1#3:54\n1#3:66\n*S KotlinDebug\n*F\n+ 1 RunningTaskExt.kt\ncom/upuphone/xr/interconnect/task/RunningTaskExtKt\n*L\n13#1:52,2\n13#1:55\n26#1:56,9\n26#1:65\n26#1:67\n26#1:68\n26#1:66\n*E\n"})
public final class RunningTaskExtKt {
    private static final ResourceDescription asResourceDescription(DataBinderValue<?> dataBinderValue) {
        Integer asInt;
        List<DataBinderValue<?>> asList = DataBinderValueExtKt.asList(dataBinderValue);
        if (asList == null) {
            return null;
        }
        ILog.d(ITaskManager.TAG, "Converting " + asList + " to ResourceDescription.");
        if (asList.size() != 3) {
            return null;
        }
        DataBinderValue dataBinderValue2 = (DataBinderValue) CollectionsKt.getOrNull(asList, 0);
        String asString = dataBinderValue2 != null ? DataBinderValueExtKt.asString(dataBinderValue2) : null;
        DataBinderValue dataBinderValue3 = (DataBinderValue) CollectionsKt.getOrNull(asList, 1);
        Byte valueOf = (dataBinderValue3 == null || (asInt = DataBinderValueExtKt.asInt(dataBinderValue3)) == null) ? null : Byte.valueOf((byte) asInt.intValue());
        DataBinderValue dataBinderValue4 = (DataBinderValue) CollectionsKt.getOrNull(asList, 2);
        String asString2 = dataBinderValue4 != null ? DataBinderValueExtKt.asString(dataBinderValue4) : null;
        if (asString == null || valueOf == null || asString2 == null) {
            return null;
        }
        ResourceDescription resourceDescription = new ResourceDescription();
        resourceDescription.deviceId = asString;
        resourceDescription.type = valueOf.byteValue();
        resourceDescription.identifier = asString2;
        String stringify = ResourcePrintingKt.stringify(resourceDescription);
        ILog.d(ITaskManager.TAG, "Converted: " + stringify + ".");
        return resourceDescription;
    }

    @NotNull
    public static final List<ResourceDescription> asResourceDescriptionList(@NotNull List<? extends DataBinderValue<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (DataBinderValue dataBinderValue : list) {
            ILog.d(ITaskManager.TAG, "Converting occupied resource: " + dataBinderValue + ".");
            ResourceDescription asResourceDescription = dataBinderValue != null ? asResourceDescription(dataBinderValue) : null;
            if (asResourceDescription != null) {
                arrayList.add(asResourceDescription);
            }
        }
        return arrayList;
    }

    public static final boolean containsResource(@NotNull List<? extends DataBinderValue<?>> list, @NotNull ResourceDescription resourceDescription) {
        List<DataBinderValue<?>> asList;
        Integer asInt;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(resourceDescription, "resource");
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (DataBinderValue dataBinderValue : list) {
            if (!(dataBinderValue == null || (asList = DataBinderValueExtKt.asList(dataBinderValue)) == null || asList.size() != 3)) {
                DataBinderValue dataBinderValue2 = (DataBinderValue) CollectionsKt.getOrNull(asList, 0);
                String str = null;
                String asString = dataBinderValue2 != null ? DataBinderValueExtKt.asString(dataBinderValue2) : null;
                DataBinderValue dataBinderValue3 = (DataBinderValue) CollectionsKt.getOrNull(asList, 1);
                Byte valueOf = (dataBinderValue3 == null || (asInt = DataBinderValueExtKt.asInt(dataBinderValue3)) == null) ? null : Byte.valueOf((byte) asInt.intValue());
                DataBinderValue dataBinderValue4 = (DataBinderValue) CollectionsKt.getOrNull(asList, 2);
                if (dataBinderValue4 != null) {
                    str = DataBinderValueExtKt.asString(dataBinderValue4);
                }
                if (Intrinsics.areEqual((Object) resourceDescription.deviceId, (Object) asString) && valueOf != null && resourceDescription.type == valueOf.byteValue() && Intrinsics.areEqual((Object) resourceDescription.identifier, (Object) str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
