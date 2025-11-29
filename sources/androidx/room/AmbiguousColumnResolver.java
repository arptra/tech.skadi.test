package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

@SourceDebugExtension({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,253:1\n1#2:254\n13579#3,2:255\n13644#3,3:257\n13644#3,2:260\n11335#3:262\n11670#3,2:263\n11672#3:267\n13646#3:268\n1855#4,2:265\n1726#4,3:269\n1549#4:272\n1620#4,3:273\n1855#4,2:278\n37#5,2:276\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver\n*L\n85#1:255,2\n87#1:257,3\n96#1:260,2\n118#1:262\n118#1:263,2\n118#1:267\n96#1:268\n120#1:265,2\n141#1:269,3\n151#1:272\n151#1:273,3\n188#1:278,2\n151#1:276,2\n*E\n"})
@RestrictTo
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/room/AmbiguousColumnResolver;", "", "<init>", "()V", "Match", "ResultColumn", "Solution", "room-common"}, k = 1, mv = {1, 8, 0})
public final class AmbiguousColumnResolver {

    /* renamed from: a  reason: collision with root package name */
    public static final AmbiguousColumnResolver f1719a = new AmbiguousColumnResolver();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\t\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Match;", "", "Lkotlin/ranges/IntRange;", "resultRange", "", "", "resultIndices", "<init>", "(Lkotlin/ranges/IntRange;Ljava/util/List;)V", "a", "Lkotlin/ranges/IntRange;", "b", "()Lkotlin/ranges/IntRange;", "Ljava/util/List;", "()Ljava/util/List;", "room-common"}, k = 1, mv = {1, 8, 0})
    public static final class Match {

        /* renamed from: a  reason: collision with root package name */
        public final IntRange f1720a;
        public final List b;

        public Match(IntRange intRange, List list) {
            Intrinsics.checkNotNullParameter(intRange, "resultRange");
            Intrinsics.checkNotNullParameter(list, "resultIndices");
            this.f1720a = intRange;
            this.b = list;
        }

        public final List a() {
            return this.b;
        }

        public final IntRange b() {
            return this.f1720a;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", "", "a", "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "name", "b", "I", "index", "room-common"}, k = 1, mv = {1, 8, 0})
    public static final class ResultColumn {

        /* renamed from: a  reason: collision with root package name */
        public final String f1721a;
        public final int b;

        public final String a() {
            return this.f1721a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return Intrinsics.areEqual((Object) this.f1721a, (Object) resultColumn.f1721a) && this.b == resultColumn.b;
        }

        public int hashCode() {
            return (this.f1721a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "ResultColumn(name=" + this.f1721a + ", index=" + this.b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "matches", "", "coverageOffset", "overlaps", "<init>", "(Ljava/util/List;II)V", "other", "a", "(Landroidx/room/AmbiguousColumnResolver$Solution;)I", "Ljava/util/List;", "getMatches", "()Ljava/util/List;", "b", "I", "getCoverageOffset", "()I", "c", "getOverlaps", "d", "Companion", "room-common"}, k = 1, mv = {1, 8, 0})
    public static final class Solution implements Comparable<Solution> {
        public static final Companion d = new Companion((DefaultConstructorMarker) null);
        public static final Solution e = new Solution(CollectionsKt.emptyList(), Integer.MAX_VALUE, Integer.MAX_VALUE);

        /* renamed from: a  reason: collision with root package name */
        public final List f1722a;
        public final int b;
        public final int c;

        @SourceDebugExtension({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$Solution$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,253:1\n1#2:254\n1774#3,3:255\n1855#3,2:258\n1777#3:260\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$Solution$Companion\n*L\n232#1:255,3\n234#1:258,2\n232#1:260\n*E\n"})
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", "<init>", "()V", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "matches", "Landroidx/room/AmbiguousColumnResolver$Solution;", "a", "(Ljava/util/List;)Landroidx/room/AmbiguousColumnResolver$Solution;", "room-common"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Solution a(List list) {
                Intrinsics.checkNotNullParameter(list, "matches");
                Iterator it = list.iterator();
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    Match match = (Match) it.next();
                    i2 += ((match.b().getLast() - match.b().getFirst()) + 1) - match.a().size();
                }
                Iterator it2 = list.iterator();
                if (it2.hasNext()) {
                    int first = ((Match) it2.next()).b().getFirst();
                    while (it2.hasNext()) {
                        int first2 = ((Match) it2.next()).b().getFirst();
                        if (first > first2) {
                            first = first2;
                        }
                    }
                    Iterator it3 = list.iterator();
                    if (it3.hasNext()) {
                        int last = ((Match) it3.next()).b().getLast();
                        while (it3.hasNext()) {
                            int last2 = ((Match) it3.next()).b().getLast();
                            if (last < last2) {
                                last = last2;
                            }
                        }
                        IntRange intRange = new IntRange(first, last);
                        if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                            Iterator it4 = intRange.iterator();
                            int i3 = 0;
                            while (it4.hasNext()) {
                                int nextInt = ((IntIterator) it4).nextInt();
                                Iterator it5 = list.iterator();
                                int i4 = 0;
                                while (true) {
                                    if (!it5.hasNext()) {
                                        break;
                                    }
                                    if (((Match) it5.next()).b().contains(nextInt)) {
                                        i4++;
                                        continue;
                                    }
                                    if (i4 > 1) {
                                        i3++;
                                        if (i3 < 0) {
                                            CollectionsKt.throwCountOverflow();
                                        }
                                    }
                                }
                            }
                            i = i3;
                        }
                        return new Solution(list, i2, i);
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }

            public Companion() {
            }
        }

        public Solution(List list, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "matches");
            this.f1722a = list;
            this.b = i;
            this.c = i2;
        }

        /* renamed from: a */
        public int compareTo(Solution solution) {
            Intrinsics.checkNotNullParameter(solution, "other");
            int compare = Intrinsics.compare(this.c, solution.c);
            return compare != 0 ? compare : Intrinsics.compare(this.b, solution.b);
        }
    }
}
