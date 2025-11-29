package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/work/impl/StartStopTokens;", "", "<init>", "()V", "Landroidx/work/impl/model/WorkGenerationalId;", "id", "Landroidx/work/impl/StartStopToken;", "d", "(Landroidx/work/impl/model/WorkGenerationalId;)Landroidx/work/impl/StartStopToken;", "b", "", "workSpecId", "", "c", "(Ljava/lang/String;)Ljava/util/List;", "", "a", "(Landroidx/work/impl/model/WorkGenerationalId;)Z", "Landroidx/work/impl/model/WorkSpec;", "spec", "e", "(Landroidx/work/impl/model/WorkSpec;)Landroidx/work/impl/StartStopToken;", "Ljava/lang/Object;", "lock", "", "Ljava/util/Map;", "runs", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nStartStopToken.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartStopToken.kt\nandroidx/work/impl/StartStopTokens\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n361#2,7:66\n467#2,7:73\n1855#3,2:80\n1#4:82\n*S KotlinDebug\n*F\n+ 1 StartStopToken.kt\nandroidx/work/impl/StartStopTokens\n*L\n40#1:66,7\n52#1:73,7\n53#1:80,2\n*E\n"})
public final class StartStopTokens {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2094a = new Object();
    public final Map b = new LinkedHashMap();

    public final boolean a(WorkGenerationalId workGenerationalId) {
        boolean containsKey;
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        synchronized (this.f2094a) {
            containsKey = this.b.containsKey(workGenerationalId);
        }
        return containsKey;
    }

    public final StartStopToken b(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        synchronized (this.f2094a) {
            startStopToken = (StartStopToken) this.b.remove(workGenerationalId);
        }
        return startStopToken;
    }

    public final List c(String str) {
        List list;
        Intrinsics.checkNotNullParameter(str, "workSpecId");
        synchronized (this.f2094a) {
            try {
                Map map = this.b;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (Intrinsics.areEqual((Object) ((WorkGenerationalId) entry.getKey()).b(), (Object) str)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (WorkGenerationalId remove : linkedHashMap.keySet()) {
                    this.b.remove(remove);
                }
                list = CollectionsKt.toList(linkedHashMap.values());
            } finally {
            }
        }
        return list;
    }

    public final StartStopToken d(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        synchronized (this.f2094a) {
            try {
                Map map = this.b;
                Object obj = map.get(workGenerationalId);
                if (obj == null) {
                    obj = new StartStopToken(workGenerationalId);
                    map.put(workGenerationalId, obj);
                }
                startStopToken = (StartStopToken) obj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return startStopToken;
    }

    public final StartStopToken e(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "spec");
        return d(WorkSpecKt.a(workSpec));
    }
}
