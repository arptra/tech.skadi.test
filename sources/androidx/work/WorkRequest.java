package androidx.work;

import androidx.work.impl.model.WorkSpec;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0012\b&\u0018\u0000 \u00102\u00020\u0001:\u0002\u0017\u0018B'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0015¨\u0006\u0019"}, d2 = {"Landroidx/work/WorkRequest;", "", "Ljava/util/UUID;", "id", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "", "", "tags", "<init>", "(Ljava/util/UUID;Landroidx/work/impl/model/WorkSpec;Ljava/util/Set;)V", "a", "Ljava/util/UUID;", "()Ljava/util/UUID;", "b", "Landroidx/work/impl/model/WorkSpec;", "d", "()Landroidx/work/impl/model/WorkSpec;", "c", "Ljava/util/Set;", "()Ljava/util/Set;", "()Ljava/lang/String;", "stringId", "Builder", "Companion", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public abstract class WorkRequest {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final UUID f2070a;
    public final WorkSpec b;
    public final Set c;

    @SourceDebugExtension({"SMAP\nWorkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkRequest.kt\nandroidx/work/WorkRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,356:1\n1#2:357\n*E\n"})
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\b\b&\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0000*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\u0019\b\u0000\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00028\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00028\u0001H ¢\u0006\u0004\b\u001a\u0010\u0019R\"\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00058\u0000X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u001e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u000b\u001a\u00020\n8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020*8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b \u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u00020\u000e018\u0000X\u0004¢\u0006\f\n\u0004\b&\u00102\u001a\u0004\b3\u00104R\u0014\u00108\u001a\u00028\u00008 X \u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Landroidx/work/WorkRequest$Builder;", "B", "Landroidx/work/WorkRequest;", "W", "", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "workerClass", "<init>", "(Ljava/lang/Class;)V", "Ljava/util/UUID;", "id", "i", "(Ljava/util/UUID;)Landroidx/work/WorkRequest$Builder;", "", "tag", "a", "(Ljava/lang/String;)Landroidx/work/WorkRequest$Builder;", "", "duration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "j", "(JLjava/util/concurrent/TimeUnit;)Landroidx/work/WorkRequest$Builder;", "b", "()Landroidx/work/WorkRequest;", "c", "Ljava/lang/Class;", "getWorkerClass$work_runtime_release", "()Ljava/lang/Class;", "", "Z", "d", "()Z", "setBackoffCriteriaSet$work_runtime_release", "(Z)V", "backoffCriteriaSet", "Ljava/util/UUID;", "e", "()Ljava/util/UUID;", "setId$work_runtime_release", "(Ljava/util/UUID;)V", "Landroidx/work/impl/model/WorkSpec;", "Landroidx/work/impl/model/WorkSpec;", "h", "()Landroidx/work/impl/model/WorkSpec;", "setWorkSpec$work_runtime_release", "(Landroidx/work/impl/model/WorkSpec;)V", "workSpec", "", "Ljava/util/Set;", "f", "()Ljava/util/Set;", "tags", "g", "()Landroidx/work/WorkRequest$Builder;", "thisObject", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {

        /* renamed from: a  reason: collision with root package name */
        public final Class f2071a;
        public boolean b;
        public UUID c;
        public WorkSpec d;
        public final Set e;

        public Builder(Class cls) {
            Intrinsics.checkNotNullParameter(cls, "workerClass");
            this.f2071a = cls;
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
            this.c = randomUUID;
            String uuid = this.c.toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "id.toString()");
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "workerClass.name");
            this.d = new WorkSpec(uuid, name);
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "workerClass.name");
            this.e = SetsKt.mutableSetOf(name2);
        }

        public final Builder a(String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            this.e.add(str);
            return g();
        }

        public final WorkRequest b() {
            WorkRequest c2 = c();
            Constraints constraints = this.d.j;
            boolean z = constraints.e() || constraints.f() || constraints.g() || constraints.h();
            WorkSpec workSpec = this.d;
            if (workSpec.q) {
                if (!(!z)) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
                } else if (workSpec.g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
                }
            }
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
            i(randomUUID);
            return c2;
        }

        public abstract WorkRequest c();

        public final boolean d() {
            return this.b;
        }

        public final UUID e() {
            return this.c;
        }

        public final Set f() {
            return this.e;
        }

        public abstract Builder g();

        public final WorkSpec h() {
            return this.d;
        }

        public final Builder i(UUID uuid) {
            Intrinsics.checkNotNullParameter(uuid, "id");
            this.c = uuid;
            String uuid2 = uuid.toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "id.toString()");
            this.d = new WorkSpec(uuid2, this.d);
            return g();
        }

        public Builder j(long j, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.d.g = timeUnit.toMillis(j);
            if (LongCompanionObject.MAX_VALUE - System.currentTimeMillis() > this.d.g) {
                return g();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/work/WorkRequest$Companion;", "", "()V", "DEFAULT_BACKOFF_DELAY_MILLIS", "", "MAX_BACKOFF_MILLIS", "MIN_BACKOFF_MILLIS", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public WorkRequest(UUID uuid, WorkSpec workSpec, Set set) {
        Intrinsics.checkNotNullParameter(uuid, "id");
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(set, "tags");
        this.f2070a = uuid;
        this.b = workSpec;
        this.c = set;
    }

    public UUID a() {
        return this.f2070a;
    }

    public final String b() {
        String uuid = a().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "id.toString()");
        return uuid;
    }

    public final Set c() {
        return this.c;
    }

    public final WorkSpec d() {
        return this.b;
    }
}
