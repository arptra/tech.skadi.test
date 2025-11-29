package com.upuphone.xr.interconnect.util.log;

import android.os.Bundle;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"stringify", "", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTaskPrinting.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskPrinting.kt\ncom/upuphone/xr/interconnect/util/log/TaskPrintingKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,6:1\n1549#2:7\n1620#2,3:8\n*S KotlinDebug\n*F\n+ 1 TaskPrinting.kt\ncom/upuphone/xr/interconnect/util/log/TaskPrintingKt\n*L\n5#1:7\n5#1:8,3\n*E\n"})
public final class TaskPrintingKt {
    @NotNull
    public static final String stringify(@NotNull RunningTask runningTask) {
        Intrinsics.checkNotNullParameter(runningTask, "<this>");
        int i = runningTask.id;
        String str = runningTask.executorName;
        List<ResourceDescription> list = runningTask.occupiedResources;
        Intrinsics.checkNotNullExpressionValue(list, "occupiedResources");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ResourceDescription resourceDescription : list) {
            Intrinsics.checkNotNull(resourceDescription);
            arrayList.add(ResourcePrintingKt.stringify(resourceDescription));
        }
        Bundle bundle = runningTask.param;
        return "RunningTask(" + i + "): name=" + str + ", res=" + arrayList + ", launchParam=" + bundle;
    }
}
