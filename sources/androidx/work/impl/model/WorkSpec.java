package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.room.Entity;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.honey.account.o0.a;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@SourceDebugExtension({"SMAP\nWorkSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkSpec.kt\nandroidx/work/impl/model/WorkSpec\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,544:1\n1549#2:545\n1620#2,3:546\n*S KotlinDebug\n*F\n+ 1 WorkSpec.kt\nandroidx/work/impl/model/WorkSpec\n*L\n482#1:545\n482#1:546,3\n*E\n"})
@RestrictTo
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bA\b\b\u0018\u0000 X2\u00020\u0001:\u0003YZ[Bé\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010%B\u0019\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010(J\r\u0010)\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0019¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b1\u00102R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b)\u00104R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b7\u00104R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\n\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b+\u0010<R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bD\u0010<R\u0016\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bE\u0010<R\u0016\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bF\u0010<R\u0016\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bG\u0010<R\u0016\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010\u001d\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bL\u0010A\u001a\u0004\b;\u00100\"\u0004\bM\u0010NR\u001a\u0010\u001e\u001a\u00020\u00118\u0006X\u0004¢\u0006\f\n\u0004\bO\u0010A\u001a\u0004\b7\u00100R\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010<\u001a\u0004\b8\u0010*\"\u0004\bQ\u0010RR\"\u0010 \u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bS\u0010A\u001a\u0004\b:\u00100\"\u0004\bT\u0010NR\u001a\u0010!\u001a\u00020\u00118\u0006X\u0004¢\u0006\f\n\u0004\bU\u0010A\u001a\u0004\b=\u00100R\u0011\u0010V\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b@\u0010,R\u0011\u0010W\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b>\u0010,¨\u0006\\"}, d2 = {"Landroidx/work/impl/model/WorkSpec;", "", "", "id", "Landroidx/work/WorkInfo$State;", "state", "workerClassName", "inputMergerClassName", "Landroidx/work/Data;", "input", "output", "", "initialDelay", "intervalDuration", "flexDuration", "Landroidx/work/Constraints;", "constraints", "", "runAttemptCount", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "", "expedited", "Landroidx/work/OutOfQuotaPolicy;", "outOfQuotaPolicy", "periodCount", "generation", "nextScheduleTimeOverride", "nextScheduleTimeOverrideGeneration", "stopReason", "<init>", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;IIJII)V", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "other", "(Ljava/lang/String;Landroidx/work/impl/model/WorkSpec;)V", "c", "()J", "i", "()Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "Landroidx/work/WorkInfo$State;", "d", "e", "Landroidx/work/Data;", "f", "g", "J", "h", "j", "Landroidx/work/Constraints;", "k", "I", "l", "Landroidx/work/BackoffPolicy;", "m", "n", "o", "p", "q", "Z", "r", "Landroidx/work/OutOfQuotaPolicy;", "s", "setPeriodCount", "(I)V", "t", "u", "setNextScheduleTimeOverride", "(J)V", "v", "setNextScheduleTimeOverrideGeneration", "w", "isPeriodic", "isBackedOff", "x", "Companion", "IdAndState", "WorkInfoPojo", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@Entity
public final class WorkSpec {
    public static final Companion x = new Companion((DefaultConstructorMarker) null);
    public static final String y;
    public static final Function z = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f2184a;
    public WorkInfo.State b;
    public String c;
    public String d;
    public Data e;
    public Data f;
    public long g;
    public long h;
    public long i;
    public Constraints j;
    public int k;
    public BackoffPolicy l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;
    public OutOfQuotaPolicy r;
    public int s;
    public final int t;
    public long u;
    public int v;
    public final int w;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R,\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001b0\u001a8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/work/impl/model/WorkSpec$Companion;", "", "<init>", "()V", "", "isBackedOff", "", "runAttemptCount", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "isPeriodic", "initialDelay", "flexDuration", "intervalDuration", "nextScheduleTimeOverride", "a", "(ZILandroidx/work/BackoffPolicy;JJIZJJJJ)J", "SCHEDULE_NOT_REQUESTED_YET", "J", "", "TAG", "Ljava/lang/String;", "Landroidx/arch/core/util/Function;", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "Landroidx/work/WorkInfo;", "WORK_INFO_MAPPER", "Landroidx/arch/core/util/Function;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(boolean z, int i, BackoffPolicy backoffPolicy, long j, long j2, int i2, boolean z2, long j3, long j4, long j5, long j6) {
            int i3 = i;
            BackoffPolicy backoffPolicy2 = backoffPolicy;
            long j7 = j;
            long j8 = j6;
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            if (j8 != LongCompanionObject.MAX_VALUE && z2) {
                return i2 == 0 ? j8 : RangesKt.coerceAtLeast(j8, 900000 + j2);
            }
            if (z) {
                return j2 + RangesKt.coerceAtMost(backoffPolicy2 == BackoffPolicy.LINEAR ? ((long) i3) * j7 : (long) Math.scalb((float) j7, i3 - 1), 18000000);
            } else if (!z2) {
                return j2 == -1 ? LongCompanionObject.MAX_VALUE : j2 + j3;
            } else {
                long j9 = i2 == 0 ? j2 + j3 : j2 + j5;
                if (j4 != j5 && i2 == 0) {
                    j9 += j5 - j4;
                }
                return j9;
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/work/impl/model/WorkSpec$IdAndState;", "", "", "id", "Landroidx/work/WorkInfo$State;", "state", "<init>", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "Landroidx/work/WorkInfo$State;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class IdAndState {

        /* renamed from: a  reason: collision with root package name */
        public String f2185a;
        public WorkInfo.State b;

        public IdAndState(String str, WorkInfo.State state) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            this.f2185a = str;
            this.b = state;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return Intrinsics.areEqual((Object) this.f2185a, (Object) idAndState.f2185a) && this.b == idAndState.b;
        }

        public int hashCode() {
            return (this.f2185a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.f2185a + ", state=" + this.b + ')';
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b9\b\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b.\u0010&R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b0\u00101R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010!R\u001a\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\b9\u0010!R\u001a\u0010\u000b\u001a\u00020\b8\u0006X\u0004¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u0010!R\u001a\u0010\r\u001a\u00020\f8\u0006X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010(R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u00107\u001a\u0004\bJ\u0010!\"\u0004\bK\u0010LR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bM\u00107\u001a\u0004\bN\u0010!\"\u0004\bO\u0010LR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010A\u001a\u0004\bQ\u0010(\"\u0004\bR\u0010SR\u001a\u0010\u0015\u001a\u00020\u000e8\u0006X\u0004¢\u0006\f\n\u0004\bT\u0010A\u001a\u0004\bU\u0010(R\u001a\u0010\u0016\u001a\u00020\b8\u0006X\u0004¢\u0006\f\n\u0004\bV\u00107\u001a\u0004\bW\u0010!R\u001a\u0010\u0017\u001a\u00020\u000e8\u0006X\u0004¢\u0006\f\n\u0004\bX\u0010A\u001a\u0004\bY\u0010(R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006X\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0006X\u0004¢\u0006\f\n\u0004\b^\u0010[\u001a\u0004\b_\u0010]R\u0011\u0010a\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b6\u0010`R\u0011\u0010b\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b2\u0010`¨\u0006c"}, d2 = {"Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "", "", "id", "Landroidx/work/WorkInfo$State;", "state", "Landroidx/work/Data;", "output", "", "initialDelay", "intervalDuration", "flexDuration", "Landroidx/work/Constraints;", "constraints", "", "runAttemptCount", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "generation", "nextScheduleTimeOverride", "stopReason", "", "tags", "progress", "<init>", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJIIJILjava/util/List;Ljava/util/List;)V", "Landroidx/work/WorkInfo$PeriodicityInfo;", "b", "()Landroidx/work/WorkInfo$PeriodicityInfo;", "a", "()J", "Landroidx/work/WorkInfo;", "e", "()Landroidx/work/WorkInfo;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Landroidx/work/WorkInfo$State;", "getState", "()Landroidx/work/WorkInfo$State;", "c", "Landroidx/work/Data;", "getOutput", "()Landroidx/work/Data;", "d", "J", "getInitialDelay", "getIntervalDuration", "f", "getFlexDuration", "g", "Landroidx/work/Constraints;", "getConstraints", "()Landroidx/work/Constraints;", "h", "I", "getRunAttemptCount", "i", "Landroidx/work/BackoffPolicy;", "getBackoffPolicy", "()Landroidx/work/BackoffPolicy;", "setBackoffPolicy", "(Landroidx/work/BackoffPolicy;)V", "j", "getBackoffDelayDuration", "setBackoffDelayDuration", "(J)V", "k", "getLastEnqueueTime", "setLastEnqueueTime", "l", "getPeriodCount", "setPeriodCount", "(I)V", "m", "getGeneration", "n", "getNextScheduleTimeOverride", "o", "getStopReason", "p", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "q", "getProgress", "()Z", "isPeriodic", "isBackedOff", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class WorkInfoPojo {

        /* renamed from: a  reason: collision with root package name */
        public final String f2186a;
        public final WorkInfo.State b;
        public final Data c;
        public final long d;
        public final long e;
        public final long f;
        public final Constraints g;
        public final int h;
        public BackoffPolicy i;
        public long j;
        public long k;
        public int l;
        public final int m;
        public final long n;
        public final int o;
        public final List p;
        public final List q;

        public WorkInfoPojo(String str, WorkInfo.State state, Data data, long j2, long j3, long j4, Constraints constraints, int i2, BackoffPolicy backoffPolicy, long j5, long j6, int i3, int i4, long j7, int i5, List list, List list2) {
            Constraints constraints2 = constraints;
            BackoffPolicy backoffPolicy2 = backoffPolicy;
            List list3 = list;
            List list4 = list2;
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(data, "output");
            Intrinsics.checkNotNullParameter(constraints2, "constraints");
            Intrinsics.checkNotNullParameter(backoffPolicy2, "backoffPolicy");
            Intrinsics.checkNotNullParameter(list3, "tags");
            Intrinsics.checkNotNullParameter(list4, PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
            this.f2186a = str;
            this.b = state;
            this.c = data;
            this.d = j2;
            this.e = j3;
            this.f = j4;
            this.g = constraints2;
            this.h = i2;
            this.i = backoffPolicy2;
            this.j = j5;
            this.k = j6;
            this.l = i3;
            this.m = i4;
            this.n = j7;
            this.o = i5;
            this.p = list3;
            this.q = list4;
        }

        public final long a() {
            return this.b == WorkInfo.State.ENQUEUED ? WorkSpec.x.a(c(), this.h, this.i, this.j, this.k, this.l, d(), this.d, this.f, this.e, this.n) : LongCompanionObject.MAX_VALUE;
        }

        public final WorkInfo.PeriodicityInfo b() {
            long j2 = this.e;
            if (j2 != 0) {
                return new WorkInfo.PeriodicityInfo(j2, this.f);
            }
            return null;
        }

        public final boolean c() {
            return this.b == WorkInfo.State.ENQUEUED && this.h > 0;
        }

        public final boolean d() {
            return this.e != 0;
        }

        public final WorkInfo e() {
            Data data = this.q.isEmpty() ^ true ? (Data) this.q.get(0) : Data.c;
            UUID fromString = UUID.fromString(this.f2186a);
            Intrinsics.checkNotNullExpressionValue(fromString, "fromString(id)");
            WorkInfo.State state = this.b;
            HashSet hashSet = new HashSet(this.p);
            Data data2 = this.c;
            Intrinsics.checkNotNullExpressionValue(data, PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
            return new WorkInfo(fromString, state, hashSet, data2, data, this.h, this.m, this.g, this.d, b(), a(), this.o);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return Intrinsics.areEqual((Object) this.f2186a, (Object) workInfoPojo.f2186a) && this.b == workInfoPojo.b && Intrinsics.areEqual((Object) this.c, (Object) workInfoPojo.c) && this.d == workInfoPojo.d && this.e == workInfoPojo.e && this.f == workInfoPojo.f && Intrinsics.areEqual((Object) this.g, (Object) workInfoPojo.g) && this.h == workInfoPojo.h && this.i == workInfoPojo.i && this.j == workInfoPojo.j && this.k == workInfoPojo.k && this.l == workInfoPojo.l && this.m == workInfoPojo.m && this.n == workInfoPojo.n && this.o == workInfoPojo.o && Intrinsics.areEqual((Object) this.p, (Object) workInfoPojo.p) && Intrinsics.areEqual((Object) this.q, (Object) workInfoPojo.q);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((this.f2186a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Long.hashCode(this.n)) * 31) + Integer.hashCode(this.o)) * 31) + this.p.hashCode()) * 31) + this.q.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.f2186a + ", state=" + this.b + ", output=" + this.c + ", initialDelay=" + this.d + ", intervalDuration=" + this.e + ", flexDuration=" + this.f + ", constraints=" + this.g + ", runAttemptCount=" + this.h + ", backoffPolicy=" + this.i + ", backoffDelayDuration=" + this.j + ", lastEnqueueTime=" + this.k + ", periodCount=" + this.l + ", generation=" + this.m + ", nextScheduleTimeOverride=" + this.n + ", stopReason=" + this.o + ", tags=" + this.p + ", progress=" + this.q + ')';
        }
    }

    static {
        String i2 = Logger.i("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(i2, "tagWithPrefix(\"WorkSpec\")");
        y = i2;
    }

    public WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j2, long j3, long j4, Constraints constraints, int i2, BackoffPolicy backoffPolicy, long j5, long j6, long j7, long j8, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i3, int i4, long j9, int i5, int i6) {
        Data data3 = data;
        Data data4 = data2;
        Constraints constraints2 = constraints;
        BackoffPolicy backoffPolicy2 = backoffPolicy;
        OutOfQuotaPolicy outOfQuotaPolicy2 = outOfQuotaPolicy;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(str2, "workerClassName");
        Intrinsics.checkNotNullParameter(str3, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(data3, "input");
        Intrinsics.checkNotNullParameter(data4, "output");
        Intrinsics.checkNotNullParameter(constraints2, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy2, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy2, "outOfQuotaPolicy");
        this.f2184a = str;
        this.b = state;
        this.c = str2;
        this.d = str3;
        this.e = data3;
        this.f = data4;
        this.g = j2;
        this.h = j3;
        this.i = j4;
        this.j = constraints2;
        this.k = i2;
        this.l = backoffPolicy2;
        this.m = j5;
        this.n = j6;
        this.o = j7;
        this.p = j8;
        this.q = z2;
        this.r = outOfQuotaPolicy2;
        this.s = i3;
        this.t = i4;
        this.u = j9;
        this.v = i5;
        this.w = i6;
    }

    public static final List b(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkInfoPojo) it.next()).e());
        }
        return arrayList;
    }

    public final long c() {
        Companion companion = x;
        return companion.a(j(), this.k, this.l, this.m, this.n, this.s, k(), this.g, this.i, this.h, this.u);
    }

    public final int d() {
        return this.t;
    }

    public final long e() {
        return this.u;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return Intrinsics.areEqual((Object) this.f2184a, (Object) workSpec.f2184a) && this.b == workSpec.b && Intrinsics.areEqual((Object) this.c, (Object) workSpec.c) && Intrinsics.areEqual((Object) this.d, (Object) workSpec.d) && Intrinsics.areEqual((Object) this.e, (Object) workSpec.e) && Intrinsics.areEqual((Object) this.f, (Object) workSpec.f) && this.g == workSpec.g && this.h == workSpec.h && this.i == workSpec.i && Intrinsics.areEqual((Object) this.j, (Object) workSpec.j) && this.k == workSpec.k && this.l == workSpec.l && this.m == workSpec.m && this.n == workSpec.n && this.o == workSpec.o && this.p == workSpec.p && this.q == workSpec.q && this.r == workSpec.r && this.s == workSpec.s && this.t == workSpec.t && this.u == workSpec.u && this.v == workSpec.v && this.w == workSpec.w;
    }

    public final int f() {
        return this.v;
    }

    public final int g() {
        return this.s;
    }

    public final int h() {
        return this.w;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((this.f2184a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k)) * 31) + this.l.hashCode()) * 31) + Long.hashCode(this.m)) * 31) + Long.hashCode(this.n)) * 31) + Long.hashCode(this.o)) * 31) + Long.hashCode(this.p)) * 31;
        boolean z2 = this.q;
        if (z2) {
            z2 = true;
        }
        return ((((((((((((hashCode + (z2 ? 1 : 0)) * 31) + this.r.hashCode()) * 31) + Integer.hashCode(this.s)) * 31) + Integer.hashCode(this.t)) * 31) + Long.hashCode(this.u)) * 31) + Integer.hashCode(this.v)) * 31) + Integer.hashCode(this.w);
    }

    public final boolean i() {
        return !Intrinsics.areEqual((Object) Constraints.j, (Object) this.j);
    }

    public final boolean j() {
        return this.b == WorkInfo.State.ENQUEUED && this.k > 0;
    }

    public final boolean k() {
        return this.h != 0;
    }

    public String toString() {
        return "{WorkSpec: " + this.f2184a + '}';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkSpec(java.lang.String r35, androidx.work.WorkInfo.State r36, java.lang.String r37, java.lang.String r38, androidx.work.Data r39, androidx.work.Data r40, long r41, long r43, long r45, androidx.work.Constraints r47, int r48, androidx.work.BackoffPolicy r49, long r50, long r52, long r54, long r56, boolean r58, androidx.work.OutOfQuotaPolicy r59, int r60, int r61, long r62, int r64, int r65, int r66, kotlin.jvm.internal.DefaultConstructorMarker r67) {
        /*
            r34 = this;
            r0 = r66
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.ENQUEUED
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r36
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001d
            java.lang.Class<androidx.work.OverwritingInputMerger> r1 = androidx.work.OverwritingInputMerger.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "OverwritingInputMerger::class.java.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r6 = r1
            goto L_0x001f
        L_0x001d:
            r6 = r38
        L_0x001f:
            r1 = r0 & 16
            java.lang.String r2 = "EMPTY"
            if (r1 == 0) goto L_0x002c
            androidx.work.Data r1 = androidx.work.Data.c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r7 = r1
            goto L_0x002e
        L_0x002c:
            r7 = r39
        L_0x002e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0039
            androidx.work.Data r1 = androidx.work.Data.c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r8 = r1
            goto L_0x003b
        L_0x0039:
            r8 = r40
        L_0x003b:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0043
            r9 = r2
            goto L_0x0045
        L_0x0043:
            r9 = r41
        L_0x0045:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004b
            r11 = r2
            goto L_0x004d
        L_0x004b:
            r11 = r43
        L_0x004d:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0053
            r13 = r2
            goto L_0x0055
        L_0x0053:
            r13 = r45
        L_0x0055:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x005d
            androidx.work.Constraints r1 = androidx.work.Constraints.j
            r15 = r1
            goto L_0x005f
        L_0x005d:
            r15 = r47
        L_0x005f:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r5 = 0
            if (r1 == 0) goto L_0x0067
            r16 = r5
            goto L_0x0069
        L_0x0067:
            r16 = r48
        L_0x0069:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0072
            androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
            r17 = r1
            goto L_0x0074
        L_0x0072:
            r17 = r49
        L_0x0074:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x007b
            r18 = 30000(0x7530, double:1.4822E-319)
            goto L_0x007d
        L_0x007b:
            r18 = r50
        L_0x007d:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            r20 = -1
            if (r1 == 0) goto L_0x0086
            r22 = r20
            goto L_0x0088
        L_0x0086:
            r22 = r52
        L_0x0088:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x008f
            r24 = r2
            goto L_0x0091
        L_0x008f:
            r24 = r54
        L_0x0091:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009a
            r26 = r20
            goto L_0x009c
        L_0x009a:
            r26 = r56
        L_0x009c:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a3
            r1 = r5
            goto L_0x00a5
        L_0x00a3:
            r1 = r58
        L_0x00a5:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00af
            androidx.work.OutOfQuotaPolicy r2 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST
            r28 = r2
            goto L_0x00b1
        L_0x00af:
            r28 = r59
        L_0x00b1:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00b9
            r29 = r5
            goto L_0x00bb
        L_0x00b9:
            r29 = r60
        L_0x00bb:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00c3
            r30 = r5
            goto L_0x00c5
        L_0x00c3:
            r30 = r61
        L_0x00c5:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00d2
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r31 = r2
            goto L_0x00d4
        L_0x00d2:
            r31 = r62
        L_0x00d4:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00dc
            r33 = r5
            goto L_0x00de
        L_0x00dc:
            r33 = r64
        L_0x00de:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x00e6
            r0 = -256(0xffffffffffffff00, float:NaN)
            goto L_0x00e8
        L_0x00e6:
            r0 = r65
        L_0x00e8:
            r2 = r34
            r3 = r35
            r5 = r37
            r20 = r22
            r22 = r24
            r24 = r26
            r26 = r1
            r27 = r28
            r28 = r29
            r29 = r30
            r30 = r31
            r32 = r33
            r33 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29, r30, r32, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.WorkInfo$State, java.lang.String, java.lang.String, androidx.work.Data, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, long, long, boolean, androidx.work.OutOfQuotaPolicy, int, int, long, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WorkSpec(String str, String str2) {
        this(str, (WorkInfo.State) null, str2, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, 8388602, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "workerClassName_");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkSpec(java.lang.String r37, androidx.work.impl.model.WorkSpec r38) {
        /*
            r36 = this;
            r0 = r38
            r1 = r36
            r2 = r37
            java.lang.String r3 = "newId"
            r4 = r37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            java.lang.String r3 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r4 = r0.c
            androidx.work.WorkInfo$State r3 = r0.b
            java.lang.String r5 = r0.d
            androidx.work.Data r7 = new androidx.work.Data
            r6 = r7
            androidx.work.Data r8 = r0.e
            r7.<init>((androidx.work.Data) r8)
            androidx.work.Data r8 = new androidx.work.Data
            r7 = r8
            androidx.work.Data r9 = r0.f
            r8.<init>((androidx.work.Data) r9)
            long r8 = r0.g
            long r10 = r0.h
            long r12 = r0.i
            androidx.work.Constraints r15 = new androidx.work.Constraints
            r14 = r15
            androidx.work.Constraints r1 = r0.j
            r15.<init>(r1)
            int r15 = r0.k
            androidx.work.BackoffPolicy r1 = r0.l
            r16 = r1
            r35 = r2
            long r1 = r0.m
            r17 = r1
            long r1 = r0.n
            r19 = r1
            long r1 = r0.o
            r21 = r1
            long r1 = r0.p
            r23 = r1
            boolean r1 = r0.q
            r25 = r1
            androidx.work.OutOfQuotaPolicy r1 = r0.r
            r26 = r1
            int r1 = r0.s
            r27 = r1
            long r1 = r0.u
            r29 = r1
            int r1 = r0.v
            r31 = r1
            int r0 = r0.w
            r32 = r0
            r33 = 524288(0x80000, float:7.34684E-40)
            r34 = 0
            r28 = 0
            r1 = r36
            r2 = r35
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r23, r25, r26, r27, r28, r29, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.impl.model.WorkSpec):void");
    }
}
