package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/work/impl/constraints/WorkConstraintsTracker;", "", "", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "controllers", "<init>", "(Ljava/util/List;)V", "Landroidx/work/impl/constraints/trackers/Trackers;", "trackers", "(Landroidx/work/impl/constraints/trackers/Trackers;)V", "Landroidx/work/impl/model/WorkSpec;", "spec", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/work/impl/constraints/ConstraintsState;", "b", "(Landroidx/work/impl/model/WorkSpec;)Lkotlinx/coroutines/flow/Flow;", "workSpec", "", "a", "(Landroidx/work/impl/model/WorkSpec;)Z", "Ljava/util/List;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWorkConstraintsTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,104:1\n766#2:105\n857#2,2:106\n1549#2:108\n1620#2,3:109\n766#2:117\n857#2,2:118\n287#3:112\n288#3:115\n37#4,2:113\n106#5:116\n*S KotlinDebug\n*F\n+ 1 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n*L\n84#1:105\n84#1:106,2\n84#1:108\n84#1:109,3\n91#1:117\n91#1:118,2\n85#1:112\n85#1:115\n85#1:113,2\n85#1:116\n*E\n"})
public final class WorkConstraintsTracker {

    /* renamed from: a  reason: collision with root package name */
    public final List f2138a;

    public WorkConstraintsTracker(List list) {
        Intrinsics.checkNotNullParameter(list, "controllers");
        this.f2138a = list;
    }

    public final boolean a(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        List list = this.f2138a;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((ConstraintController) next).d(workSpec)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger e = Logger.e();
            String a2 = WorkConstraintsTrackerKt.f2140a;
            e.a(a2, "Work " + workSpec.f2184a + " constrained by " + CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, WorkConstraintsTracker$areAllConstraintsMet$1.INSTANCE, 31, (Object) null));
        }
        return arrayList.isEmpty();
    }

    public final Flow b(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "spec");
        List list = this.f2138a;
        ArrayList<ConstraintController> arrayList = new ArrayList<>();
        for (Object next : list) {
            if (((ConstraintController) next).c(workSpec)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (ConstraintController f : arrayList) {
            arrayList2.add(f.f());
        }
        return FlowKt.p(new WorkConstraintsTracker$track$$inlined$combine$1((Flow[]) CollectionsKt.toList(arrayList2).toArray(new Flow[0])));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(Trackers trackers) {
        this(CollectionsKt.listOf(new BatteryChargingController(trackers.a()), new BatteryNotLowController(trackers.b()), new StorageNotLowController(trackers.d()), new NetworkConnectedController(trackers.c()), new NetworkUnmeteredController(trackers.c()), new NetworkNotRoamingController(trackers.c()), new NetworkMeteredController(trackers.c())));
        Intrinsics.checkNotNullParameter(trackers, "trackers");
    }
}
