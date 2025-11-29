package androidx.paging;

import androidx.paging.LoadState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004JG\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0005*\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJM\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0005*\u00020\u00012(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ=\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\n\u0001\u0004\u0014\u0015\u0016\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/paging/PageEvent;", "", "T", "<init>", "()V", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "transform", "e", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "", "predicate", "a", "Drop", "Insert", "LoadStateUpdate", "StaticList", "Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "Landroidx/paging/PageEvent$StaticList;", "paging-common"}, k = 1, mv = {1, 8, 0})
public abstract class PageEvent<T> {

    @SourceDebugExtension({"SMAP\nPageEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageEvent.kt\nandroidx/paging/PageEvent$Drop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,318:1\n1#2:319\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B'\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\u0010¨\u0006\""}, d2 = {"Landroidx/paging/PageEvent$Drop;", "", "T", "Landroidx/paging/PageEvent;", "Landroidx/paging/LoadType;", "loadType", "", "minPageOffset", "maxPageOffset", "placeholdersRemaining", "<init>", "(Landroidx/paging/LoadType;III)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Landroidx/paging/LoadType;", "g", "()Landroidx/paging/LoadType;", "b", "I", "i", "c", "h", "d", "k", "j", "pageCount", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Drop<T> extends PageEvent<T> {

        /* renamed from: a  reason: collision with root package name */
        public final LoadType f1565a;
        public final int b;
        public final int c;
        public final int d;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    androidx.paging.LoadType[] r0 = androidx.paging.LoadType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Drop.WhenMappings.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Drop(LoadType loadType, int i, int i2, int i3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            this.f1565a = loadType;
            this.b = i;
            this.c = i2;
            this.d = i3;
            if (loadType == LoadType.REFRESH) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
            } else if (j() <= 0) {
                throw new IllegalArgumentException(("Drop count must be > 0, but was " + j()).toString());
            } else if (i3 < 0) {
                throw new IllegalArgumentException(("Invalid placeholdersRemaining " + i3).toString());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Drop)) {
                return false;
            }
            Drop drop = (Drop) obj;
            return this.f1565a == drop.f1565a && this.b == drop.b && this.c == drop.c && this.d == drop.d;
        }

        public final LoadType g() {
            return this.f1565a;
        }

        public final int h() {
            return this.c;
        }

        public int hashCode() {
            return (((((this.f1565a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public final int i() {
            return this.b;
        }

        public final int j() {
            return (this.c - this.b) + 1;
        }

        public final int k() {
            return this.d;
        }

        public String toString() {
            String str;
            int i = WhenMappings.$EnumSwitchMapping$0[this.f1565a.ordinal()];
            if (i == 1) {
                str = "end";
            } else if (i == 2) {
                str = "front";
            } else {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
            }
            return StringsKt.trimMargin$default("PageEvent.Drop from the " + str + " (\n                    |   minPageOffset: " + this.b + "\n                    |   maxPageOffset: " + this.c + "\n                    |   placeholdersRemaining: " + this.d + "\n                    |)", (String) null, 1, (Object) null);
        }
    }

    @SourceDebugExtension({"SMAP\nPageEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageEvent.kt\nandroidx/paging/PageEvent$Insert\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 LogUtil.kt\nandroidx/paging/internal/LogUtilKt\n*L\n1#1,318:1\n116#1,3:319\n119#1,5:326\n112#1,7:331\n119#1,5:346\n112#1,7:351\n119#1,5:365\n112#1,7:370\n119#1,5:384\n1549#2:322\n1620#2,3:323\n1549#2:338\n1620#2,2:339\n1549#2:341\n1620#2,3:342\n1622#2:345\n1549#2:358\n1620#2,2:359\n1864#2,3:361\n1622#2:364\n1549#2:377\n1620#2,2:378\n1864#2,3:380\n1622#2:383\n1789#2,3:389\n27#3,5:392\n*S KotlinDebug\n*F\n+ 1 PageEvent.kt\nandroidx/paging/PageEvent$Insert\n*L\n112#1:319,3\n112#1:326,5\n125#1:331,7\n125#1:346,5\n136#1:351,7\n136#1:365,5\n154#1:370,7\n154#1:384,5\n112#1:322\n112#1:323,3\n125#1:338\n125#1:339,2\n128#1:341\n128#1:342,3\n125#1:345\n136#1:358\n136#1:359,2\n139#1:361,3\n136#1:364\n154#1:377\n154#1:378,2\n157#1:380,3\n154#1:383\n233#1:389,3\n236#1:392,5\n*E\n"})
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\b\u0018\u0000 6*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003:\u00017BI\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u0011*\u00020\u00012\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016JM\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u0011*\u00020\u00012(\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00170\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J=\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ`\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b'\u0010(R#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010\"R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b/\u0010-\u001a\u0004\b0\u0010\"R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b2\u00103R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Landroidx/paging/PageEvent$Insert;", "", "T", "Landroidx/paging/PageEvent;", "Landroidx/paging/LoadType;", "loadType", "", "Landroidx/paging/TransformablePage;", "pages", "", "placeholdersBefore", "placeholdersAfter", "Landroidx/paging/LoadStates;", "sourceLoadStates", "mediatorLoadStates", "<init>", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "transform", "e", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "", "predicate", "a", "", "toString", "()Ljava/lang/String;", "h", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)Landroidx/paging/PageEvent$Insert;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/paging/LoadType;", "j", "()Landroidx/paging/LoadType;", "b", "Ljava/util/List;", "l", "()Ljava/util/List;", "I", "n", "d", "m", "Landroidx/paging/LoadStates;", "o", "()Landroidx/paging/LoadStates;", "f", "k", "g", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Insert<T> extends PageEvent<T> {
        public static final Companion g;
        public static final Insert h;

        /* renamed from: a  reason: collision with root package name */
        public final LoadType f1566a;
        public final List b;
        public final int c;
        public final int d;
        public final LoadStates e;
        public final LoadStates f;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JU\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000e\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000e\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u0012JM\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u000e\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0013\u0010\u0012R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/paging/PageEvent$Insert$Companion;", "", "<init>", "()V", "T", "", "Landroidx/paging/TransformablePage;", "pages", "", "placeholdersBefore", "placeholdersAfter", "Landroidx/paging/LoadStates;", "sourceLoadStates", "mediatorLoadStates", "Landroidx/paging/PageEvent$Insert;", "c", "(Ljava/util/List;IILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)Landroidx/paging/PageEvent$Insert;", "b", "(Ljava/util/List;ILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)Landroidx/paging/PageEvent$Insert;", "a", "EMPTY_REFRESH_LOCAL", "Landroidx/paging/PageEvent$Insert;", "e", "()Landroidx/paging/PageEvent$Insert;", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ Insert d(Companion companion, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, int i3, Object obj) {
                if ((i3 & 16) != 0) {
                    loadStates2 = null;
                }
                return companion.c(list, i, i2, loadStates, loadStates2);
            }

            public final Insert a(List list, int i, LoadStates loadStates, LoadStates loadStates2) {
                Intrinsics.checkNotNullParameter(list, "pages");
                Intrinsics.checkNotNullParameter(loadStates, "sourceLoadStates");
                return new Insert(LoadType.APPEND, list, -1, i, loadStates, loadStates2, (DefaultConstructorMarker) null);
            }

            public final Insert b(List list, int i, LoadStates loadStates, LoadStates loadStates2) {
                Intrinsics.checkNotNullParameter(list, "pages");
                Intrinsics.checkNotNullParameter(loadStates, "sourceLoadStates");
                return new Insert(LoadType.PREPEND, list, i, -1, loadStates, loadStates2, (DefaultConstructorMarker) null);
            }

            public final Insert c(List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2) {
                Intrinsics.checkNotNullParameter(list, "pages");
                Intrinsics.checkNotNullParameter(loadStates, "sourceLoadStates");
                return new Insert(LoadType.REFRESH, list, i, i2, loadStates, loadStates2, (DefaultConstructorMarker) null);
            }

            public final Insert e() {
                return Insert.h;
            }

            public Companion() {
            }
        }

        static {
            Companion companion = new Companion((DefaultConstructorMarker) null);
            g = companion;
            List listOf = CollectionsKt.listOf(TransformablePage.e.a());
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.b;
            h = Companion.d(companion, listOf, 0, 0, new LoadStates(companion2.b(), companion2.a(), companion2.a()), (LoadStates) null, 16, (Object) null);
        }

        public /* synthetic */ Insert(LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadType, list, i, i2, loadStates, loadStates2);
        }

        public static /* synthetic */ Insert i(Insert insert, LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                loadType = insert.f1566a;
            }
            if ((i3 & 2) != 0) {
                list = insert.b;
            }
            List list2 = list;
            if ((i3 & 4) != 0) {
                i = insert.c;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = insert.d;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                loadStates = insert.e;
            }
            LoadStates loadStates3 = loadStates;
            if ((i3 & 32) != 0) {
                loadStates2 = insert.f;
            }
            return insert.h(loadType, list2, i4, i5, loadStates3, loadStates2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00fb  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(kotlin.jvm.functions.Function2 r19, kotlin.coroutines.Continuation r20) {
            /*
                r18 = this;
                r0 = r20
                boolean r1 = r0 instanceof androidx.paging.PageEvent$Insert$filter$1
                if (r1 == 0) goto L_0x0017
                r1 = r0
                androidx.paging.PageEvent$Insert$filter$1 r1 = (androidx.paging.PageEvent$Insert$filter$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L_0x0017
                int r2 = r2 - r3
                r1.label = r2
                r2 = r18
                goto L_0x001e
            L_0x0017:
                androidx.paging.PageEvent$Insert$filter$1 r1 = new androidx.paging.PageEvent$Insert$filter$1
                r2 = r18
                r1.<init>(r2, r0)
            L_0x001e:
                java.lang.Object r0 = r1.result
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r4 = r1.label
                r5 = 1
                if (r4 == 0) goto L_0x006c
                if (r4 != r5) goto L_0x0064
                int r2 = r1.I$1
                int r4 = r1.I$0
                java.lang.Object r6 = r1.L$10
                java.util.Collection r6 = (java.util.Collection) r6
                java.lang.Object r7 = r1.L$9
                java.lang.Object r8 = r1.L$8
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r9 = r1.L$7
                java.util.List r9 = (java.util.List) r9
                java.lang.Object r10 = r1.L$6
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r11 = r1.L$5
                androidx.paging.TransformablePage r11 = (androidx.paging.TransformablePage) r11
                java.lang.Object r12 = r1.L$4
                java.util.Iterator r12 = (java.util.Iterator) r12
                java.lang.Object r13 = r1.L$3
                java.util.Collection r13 = (java.util.Collection) r13
                java.lang.Object r14 = r1.L$2
                androidx.paging.LoadType r14 = (androidx.paging.LoadType) r14
                java.lang.Object r15 = r1.L$1
                androidx.paging.PageEvent$Insert r15 = (androidx.paging.PageEvent.Insert) r15
                java.lang.Object r5 = r1.L$0
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                kotlin.ResultKt.throwOnFailure(r0)
                r16 = r11
                r11 = r4
                r4 = r12
                r12 = r16
                goto L_0x00f3
            L_0x0064:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x006c:
                kotlin.ResultKt.throwOnFailure(r0)
                androidx.paging.LoadType r0 = r18.j()
                java.util.List r4 = r18.l()
                java.util.ArrayList r5 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r6)
                r5.<init>(r6)
                java.util.Iterator r4 = r4.iterator()
                r6 = r5
                r5 = r0
                r0 = r19
            L_0x008a:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto L_0x012d
                java.lang.Object r7 = r4.next()
                androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.List r10 = r7.b()
                java.util.Iterator r10 = r10.iterator()
                r11 = 0
                r12 = r7
                r7 = r6
                r16 = r10
                r10 = r8
                r8 = r16
            L_0x00b0:
                boolean r13 = r8.hasNext()
                if (r13 == 0) goto L_0x011a
                java.lang.Object r13 = r8.next()
                int r14 = r11 + 1
                if (r11 >= 0) goto L_0x00c1
                kotlin.collections.CollectionsKt.throwIndexOverflow()
            L_0x00c1:
                r1.L$0 = r0
                r1.L$1 = r2
                r1.L$2 = r5
                r1.L$3 = r7
                r1.L$4 = r4
                r1.L$5 = r12
                r1.L$6 = r10
                r1.L$7 = r9
                r1.L$8 = r8
                r1.L$9 = r13
                r1.L$10 = r6
                r1.I$0 = r14
                r1.I$1 = r11
                r15 = 1
                r1.label = r15
                java.lang.Object r15 = r0.invoke(r13, r1)
                if (r15 != r3) goto L_0x00e5
                return r3
            L_0x00e5:
                r16 = r5
                r5 = r0
                r0 = r15
                r15 = r2
                r2 = r11
                r11 = r14
                r14 = r16
                r17 = r13
                r13 = r7
                r7 = r17
            L_0x00f3:
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x0115
                r10.add(r7)
                java.util.List r0 = r12.c()
                if (r0 == 0) goto L_0x010e
                java.lang.Object r0 = r0.get(r2)
                java.lang.Number r0 = (java.lang.Number) r0
                int r2 = r0.intValue()
            L_0x010e:
                java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
                r9.add(r0)
            L_0x0115:
                r0 = r5
                r7 = r13
                r5 = r14
                r2 = r15
                goto L_0x00b0
            L_0x011a:
                androidx.paging.TransformablePage r8 = new androidx.paging.TransformablePage
                int[] r11 = r12.e()
                int r12 = r12.d()
                r8.<init>(r11, r10, r12, r9)
                r6.add(r8)
                r6 = r7
                goto L_0x008a
            L_0x012d:
                java.util.List r6 = (java.util.List) r6
                int r7 = r2.n()
                int r8 = r2.m()
                androidx.paging.LoadStates r9 = r2.o()
                androidx.paging.LoadStates r10 = r2.k()
                androidx.paging.PageEvent$Insert r0 = new androidx.paging.PageEvent$Insert
                r11 = 0
                r4 = r0
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.a(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00bf  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00e6  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00fc  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0110 A[LOOP:0: B:28:0x0106->B:30:0x0110, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object c(kotlin.jvm.functions.Function2 r19, kotlin.coroutines.Continuation r20) {
            /*
                r18 = this;
                r0 = r20
                boolean r1 = r0 instanceof androidx.paging.PageEvent$Insert$flatMap$1
                if (r1 == 0) goto L_0x0017
                r1 = r0
                androidx.paging.PageEvent$Insert$flatMap$1 r1 = (androidx.paging.PageEvent$Insert$flatMap$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L_0x0017
                int r2 = r2 - r3
                r1.label = r2
                r2 = r18
                goto L_0x001e
            L_0x0017:
                androidx.paging.PageEvent$Insert$flatMap$1 r1 = new androidx.paging.PageEvent$Insert$flatMap$1
                r2 = r18
                r1.<init>(r2, r0)
            L_0x001e:
                java.lang.Object r0 = r1.result
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r4 = r1.label
                r5 = 1
                if (r4 == 0) goto L_0x0072
                if (r4 != r5) goto L_0x006a
                int r2 = r1.I$1
                int r4 = r1.I$0
                java.lang.Object r6 = r1.L$10
                java.util.Collection r6 = (java.util.Collection) r6
                java.lang.Object r7 = r1.L$9
                java.util.Collection r7 = (java.util.Collection) r7
                java.lang.Object r8 = r1.L$8
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r9 = r1.L$7
                java.util.List r9 = (java.util.List) r9
                java.lang.Object r10 = r1.L$6
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r11 = r1.L$5
                androidx.paging.TransformablePage r11 = (androidx.paging.TransformablePage) r11
                java.lang.Object r12 = r1.L$4
                java.util.Iterator r12 = (java.util.Iterator) r12
                java.lang.Object r13 = r1.L$3
                java.util.Collection r13 = (java.util.Collection) r13
                java.lang.Object r14 = r1.L$2
                androidx.paging.LoadType r14 = (androidx.paging.LoadType) r14
                java.lang.Object r15 = r1.L$1
                androidx.paging.PageEvent$Insert r15 = (androidx.paging.PageEvent.Insert) r15
                java.lang.Object r5 = r1.L$0
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                kotlin.ResultKt.throwOnFailure(r0)
                r16 = r11
                r11 = r4
                r4 = r15
                r15 = 1
                r17 = r10
                r10 = r8
                r8 = r17
                goto L_0x00f1
            L_0x006a:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0072:
                kotlin.ResultKt.throwOnFailure(r0)
                androidx.paging.LoadType r0 = r18.j()
                java.util.List r4 = r18.l()
                java.util.ArrayList r5 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r6)
                r5.<init>(r6)
                java.util.Iterator r4 = r4.iterator()
                r6 = r5
                r5 = r0
                r0 = r19
            L_0x0090:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto L_0x0134
                java.lang.Object r7 = r4.next()
                androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.List r10 = r7.b()
                java.util.Iterator r10 = r10.iterator()
                r11 = 0
                r12 = r7
                r7 = r6
            L_0x00b1:
                boolean r13 = r10.hasNext()
                if (r13 == 0) goto L_0x0120
                java.lang.Object r13 = r10.next()
                int r14 = r11 + 1
                if (r11 >= 0) goto L_0x00c2
                kotlin.collections.CollectionsKt.throwIndexOverflow()
            L_0x00c2:
                r1.L$0 = r0
                r1.L$1 = r2
                r1.L$2 = r5
                r1.L$3 = r7
                r1.L$4 = r4
                r1.L$5 = r12
                r1.L$6 = r8
                r1.L$7 = r9
                r1.L$8 = r10
                r1.L$9 = r8
                r1.L$10 = r6
                r1.I$0 = r14
                r1.I$1 = r11
                r15 = 1
                r1.label = r15
                java.lang.Object r13 = r0.invoke(r13, r1)
                if (r13 != r3) goto L_0x00e6
                return r3
            L_0x00e6:
                r16 = r12
                r12 = r4
                r4 = r2
                r2 = r11
                r11 = r14
                r14 = r5
                r5 = r0
                r0 = r13
                r13 = r7
                r7 = r8
            L_0x00f1:
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                kotlin.collections.CollectionsKt.addAll(r7, r0)
                java.util.List r0 = r16.c()
                if (r0 == 0) goto L_0x0106
                java.lang.Object r0 = r0.get(r2)
                java.lang.Number r0 = (java.lang.Number) r0
                int r2 = r0.intValue()
            L_0x0106:
                int r0 = r9.size()
                int r7 = r8.size()
                if (r0 >= r7) goto L_0x0118
                java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
                r9.add(r0)
                goto L_0x0106
            L_0x0118:
                r2 = r4
                r0 = r5
                r4 = r12
                r7 = r13
                r5 = r14
                r12 = r16
                goto L_0x00b1
            L_0x0120:
                r15 = 1
                androidx.paging.TransformablePage r10 = new androidx.paging.TransformablePage
                int[] r11 = r12.e()
                int r12 = r12.d()
                r10.<init>(r11, r8, r12, r9)
                r6.add(r10)
                r6 = r7
                goto L_0x0090
            L_0x0134:
                java.util.List r6 = (java.util.List) r6
                int r7 = r2.n()
                int r8 = r2.m()
                androidx.paging.LoadStates r9 = r2.o()
                androidx.paging.LoadStates r10 = r2.k()
                androidx.paging.PageEvent$Insert r0 = new androidx.paging.PageEvent$Insert
                r11 = 0
                r4 = r0
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.c(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00e1  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object e(kotlin.jvm.functions.Function2 r20, kotlin.coroutines.Continuation r21) {
            /*
                r19 = this;
                r0 = r21
                boolean r1 = r0 instanceof androidx.paging.PageEvent$Insert$map$1
                if (r1 == 0) goto L_0x0017
                r1 = r0
                androidx.paging.PageEvent$Insert$map$1 r1 = (androidx.paging.PageEvent$Insert$map$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L_0x0017
                int r2 = r2 - r3
                r1.label = r2
                r2 = r19
                goto L_0x001e
            L_0x0017:
                androidx.paging.PageEvent$Insert$map$1 r1 = new androidx.paging.PageEvent$Insert$map$1
                r2 = r19
                r1.<init>(r2, r0)
            L_0x001e:
                java.lang.Object r0 = r1.result
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r4 = r1.label
                r5 = 10
                r6 = 1
                if (r4 == 0) goto L_0x0076
                if (r4 != r6) goto L_0x006e
                java.lang.Object r2 = r1.L$10
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.Object r4 = r1.L$9
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r7 = r1.L$8
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r1.L$7
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.Object r9 = r1.L$6
                int[] r9 = (int[]) r9
                java.lang.Object r10 = r1.L$5
                androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
                java.lang.Object r11 = r1.L$4
                java.util.Iterator r11 = (java.util.Iterator) r11
                java.lang.Object r12 = r1.L$3
                java.util.Collection r12 = (java.util.Collection) r12
                java.lang.Object r13 = r1.L$2
                androidx.paging.LoadType r13 = (androidx.paging.LoadType) r13
                java.lang.Object r14 = r1.L$1
                androidx.paging.PageEvent$Insert r14 = (androidx.paging.PageEvent.Insert) r14
                java.lang.Object r15 = r1.L$0
                kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
                kotlin.ResultKt.throwOnFailure(r0)
                r16 = r11
                r11 = r7
                r7 = r16
                r17 = r12
                r12 = r8
                r8 = r17
                r18 = r10
                r10 = r9
                r9 = r13
                r13 = r18
                goto L_0x00e5
            L_0x006e:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0076:
                kotlin.ResultKt.throwOnFailure(r0)
                androidx.paging.LoadType r0 = r19.j()
                java.util.List r4 = r19.l()
                java.util.ArrayList r7 = new java.util.ArrayList
                int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r5)
                r7.<init>(r8)
                java.util.Iterator r4 = r4.iterator()
                r8 = r0
                r0 = r20
            L_0x0091:
                boolean r9 = r4.hasNext()
                if (r9 == 0) goto L_0x0102
                java.lang.Object r9 = r4.next()
                androidx.paging.TransformablePage r9 = (androidx.paging.TransformablePage) r9
                int[] r10 = r9.e()
                java.util.List r11 = r9.b()
                java.util.ArrayList r12 = new java.util.ArrayList
                int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r5)
                r12.<init>(r13)
                java.util.Iterator r11 = r11.iterator()
                r13 = r9
                r9 = r8
                r8 = r7
                r7 = r4
                r4 = r2
                r2 = r8
            L_0x00b8:
                boolean r14 = r11.hasNext()
                if (r14 == 0) goto L_0x00eb
                java.lang.Object r14 = r11.next()
                r1.L$0 = r0
                r1.L$1 = r4
                r1.L$2 = r9
                r1.L$3 = r8
                r1.L$4 = r7
                r1.L$5 = r13
                r1.L$6 = r10
                r1.L$7 = r12
                r1.L$8 = r11
                r1.L$9 = r12
                r1.L$10 = r2
                r1.label = r6
                java.lang.Object r14 = r0.invoke(r14, r1)
                if (r14 != r3) goto L_0x00e1
                return r3
            L_0x00e1:
                r15 = r0
                r0 = r14
                r14 = r4
                r4 = r12
            L_0x00e5:
                r4.add(r0)
                r4 = r14
                r0 = r15
                goto L_0x00b8
            L_0x00eb:
                java.util.List r12 = (java.util.List) r12
                int r11 = r13.d()
                java.util.List r13 = r13.c()
                androidx.paging.TransformablePage r14 = new androidx.paging.TransformablePage
                r14.<init>(r10, r12, r11, r13)
                r2.add(r14)
                r2 = r4
                r4 = r7
                r7 = r8
                r8 = r9
                goto L_0x0091
            L_0x0102:
                r9 = r7
                java.util.List r9 = (java.util.List) r9
                int r10 = r2.n()
                int r11 = r2.m()
                androidx.paging.LoadStates r12 = r2.o()
                androidx.paging.LoadStates r13 = r2.k()
                androidx.paging.PageEvent$Insert r0 = new androidx.paging.PageEvent$Insert
                r14 = 0
                r7 = r0
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.e(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Insert)) {
                return false;
            }
            Insert insert = (Insert) obj;
            return this.f1566a == insert.f1566a && Intrinsics.areEqual((Object) this.b, (Object) insert.b) && this.c == insert.c && this.d == insert.d && Intrinsics.areEqual((Object) this.e, (Object) insert.e) && Intrinsics.areEqual((Object) this.f, (Object) insert.f);
        }

        public final Insert h(LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            Intrinsics.checkNotNullParameter(list, "pages");
            Intrinsics.checkNotNullParameter(loadStates, "sourceLoadStates");
            return new Insert(loadType, list, i, i2, loadStates, loadStates2);
        }

        public int hashCode() {
            int hashCode = ((((((((this.f1566a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31;
            LoadStates loadStates = this.f;
            return hashCode + (loadStates == null ? 0 : loadStates.hashCode());
        }

        public final LoadType j() {
            return this.f1566a;
        }

        public final LoadStates k() {
            return this.f;
        }

        public final List l() {
            return this.b;
        }

        public final int m() {
            return this.d;
        }

        public final int n() {
            return this.c;
        }

        public final LoadStates o() {
            return this.e;
        }

        public String toString() {
            List b2;
            List b3;
            int i = 0;
            for (TransformablePage b4 : this.b) {
                i += b4.b().size();
            }
            int i2 = this.c;
            String str = "none";
            String valueOf = i2 != -1 ? String.valueOf(i2) : str;
            int i3 = this.d;
            if (i3 != -1) {
                str = String.valueOf(i3);
            }
            LoadStates loadStates = this.f;
            StringBuilder sb = new StringBuilder();
            sb.append("PageEvent.Insert for ");
            sb.append(this.f1566a);
            sb.append(", with ");
            sb.append(i);
            sb.append(" items (\n                    |   first item: ");
            TransformablePage transformablePage = (TransformablePage) CollectionsKt.firstOrNull(this.b);
            sb.append((transformablePage == null || (b3 = transformablePage.b()) == null) ? null : CollectionsKt.firstOrNull(b3));
            sb.append("\n                    |   last item: ");
            TransformablePage transformablePage2 = (TransformablePage) CollectionsKt.lastOrNull(this.b);
            sb.append((transformablePage2 == null || (b2 = transformablePage2.b()) == null) ? null : CollectionsKt.lastOrNull(b2));
            sb.append("\n                    |   placeholdersBefore: ");
            sb.append(valueOf);
            sb.append("\n                    |   placeholdersAfter: ");
            sb.append(str);
            sb.append("\n                    |   sourceLoadStates: ");
            sb.append(this.e);
            sb.append("\n                    ");
            String sb2 = sb.toString();
            if (loadStates != null) {
                sb2 = sb2 + "|   mediatorLoadStates: " + loadStates + 10;
            }
            return StringsKt.trimMargin$default(sb2 + "|)", (String) null, 1, (Object) null);
        }

        public Insert(LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2) {
            super((DefaultConstructorMarker) null);
            this.f1566a = loadType;
            this.b = list;
            this.c = i;
            this.d = i2;
            this.e = loadStates;
            this.f = loadStates2;
            if (loadType != LoadType.APPEND && i < 0) {
                throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + i).toString());
            } else if (loadType != LoadType.PREPEND && i2 < 0) {
                throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + i2).toString());
            } else if (loadType == LoadType.REFRESH && !(!list.isEmpty())) {
                throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
            }
        }
    }

    @SourceDebugExtension({"SMAP\nPageEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageEvent.kt\nandroidx/paging/PageEvent$LoadStateUpdate\n+ 2 LogUtil.kt\nandroidx/paging/internal/LogUtilKt\n*L\n1#1,318:1\n27#2,5:319\n*S KotlinDebug\n*F\n+ 1 PageEvent.kt\nandroidx/paging/PageEvent$LoadStateUpdate\n*L\n300#1:319,5\n*E\n"})
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate;", "", "T", "Landroidx/paging/PageEvent;", "Landroidx/paging/LoadStates;", "source", "mediator", "<init>", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Landroidx/paging/LoadStates;", "h", "()Landroidx/paging/LoadStates;", "b", "g", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class LoadStateUpdate<T> extends PageEvent<T> {

        /* renamed from: a  reason: collision with root package name */
        public final LoadStates f1567a;
        public final LoadStates b;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LoadStateUpdate(LoadStates loadStates, LoadStates loadStates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadStates, (i & 2) != 0 ? null : loadStates2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadStateUpdate)) {
                return false;
            }
            LoadStateUpdate loadStateUpdate = (LoadStateUpdate) obj;
            return Intrinsics.areEqual((Object) this.f1567a, (Object) loadStateUpdate.f1567a) && Intrinsics.areEqual((Object) this.b, (Object) loadStateUpdate.b);
        }

        public final LoadStates g() {
            return this.b;
        }

        public final LoadStates h() {
            return this.f1567a;
        }

        public int hashCode() {
            int hashCode = this.f1567a.hashCode() * 31;
            LoadStates loadStates = this.b;
            return hashCode + (loadStates == null ? 0 : loadStates.hashCode());
        }

        public String toString() {
            LoadStates loadStates = this.b;
            String str = "PageEvent.LoadStateUpdate (\n                    |   sourceLoadStates: " + this.f1567a + "\n                    ";
            if (loadStates != null) {
                str = str + "|   mediatorLoadStates: " + loadStates + 10;
            }
            return StringsKt.trimMargin$default(str + "|)", (String) null, 1, (Object) null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadStateUpdate(LoadStates loadStates, LoadStates loadStates2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(loadStates, "source");
            this.f1567a = loadStates;
            this.b = loadStates2;
        }
    }

    @SourceDebugExtension({"SMAP\nPageEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageEvent.kt\nandroidx/paging/PageEvent$StaticList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 LogUtil.kt\nandroidx/paging/internal/LogUtilKt\n*L\n1#1,318:1\n1549#2:319\n1620#2,3:320\n1360#2:323\n1446#2,5:324\n766#2:329\n857#2,2:330\n27#3,5:332\n*S KotlinDebug\n*F\n+ 1 PageEvent.kt\nandroidx/paging/PageEvent$StaticList\n*L\n48#1:319\n48#1:320,3\n58#1:323\n58#1:324,5\n66#1:329\n66#1:330,2\n73#1:332,5\n*E\n"})
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJG\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u000b*\u00020\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u000b*\u00020\u00012(\u0010\u000e\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00110\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010J=\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b&\u0010%\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/paging/PageEvent$StaticList;", "", "T", "Landroidx/paging/PageEvent;", "", "data", "Landroidx/paging/LoadStates;", "sourceLoadStates", "mediatorLoadStates", "<init>", "(Ljava/util/List;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "transform", "e", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "", "predicate", "a", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "g", "()Ljava/util/List;", "b", "Landroidx/paging/LoadStates;", "i", "()Landroidx/paging/LoadStates;", "h", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class StaticList<T> extends PageEvent<T> {

        /* renamed from: a  reason: collision with root package name */
        public final List f1568a;
        public final LoadStates b;
        public final LoadStates c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StaticList(List list, LoadStates loadStates, LoadStates loadStates2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "data");
            this.f1568a = list;
            this.b = loadStates;
            this.c = loadStates2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.paging.PageEvent$StaticList$filter$1
                if (r0 == 0) goto L_0x0013
                r0 = r9
                androidx.paging.PageEvent$StaticList$filter$1 r0 = (androidx.paging.PageEvent$StaticList$filter$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.paging.PageEvent$StaticList$filter$1 r0 = new androidx.paging.PageEvent$StaticList$filter$1
                r0.<init>(r7, r9)
            L_0x0018:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0043
                if (r2 != r3) goto L_0x003b
                java.lang.Object r7 = r0.L$4
                java.lang.Object r8 = r0.L$3
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r2 = r0.L$2
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.Object r4 = r0.L$1
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                java.lang.Object r5 = r0.L$0
                androidx.paging.PageEvent$StaticList r5 = (androidx.paging.PageEvent.StaticList) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x0076
            L_0x003b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0043:
                kotlin.ResultKt.throwOnFailure(r9)
                java.util.List r9 = r7.f1568a
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r9 = r9.iterator()
                r6 = r9
                r9 = r8
                r8 = r6
            L_0x0054:
                boolean r4 = r8.hasNext()
                if (r4 == 0) goto L_0x0084
                java.lang.Object r4 = r8.next()
                r0.L$0 = r7
                r0.L$1 = r9
                r0.L$2 = r2
                r0.L$3 = r8
                r0.L$4 = r4
                r0.label = r3
                java.lang.Object r5 = r9.invoke(r4, r0)
                if (r5 != r1) goto L_0x0071
                return r1
            L_0x0071:
                r6 = r5
                r5 = r7
                r7 = r4
                r4 = r9
                r9 = r6
            L_0x0076:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L_0x0081
                r2.add(r7)
            L_0x0081:
                r9 = r4
                r7 = r5
                goto L_0x0054
            L_0x0084:
                java.util.List r2 = (java.util.List) r2
                androidx.paging.LoadStates r8 = r7.b
                androidx.paging.LoadStates r7 = r7.c
                androidx.paging.PageEvent$StaticList r9 = new androidx.paging.PageEvent$StaticList
                r9.<init>(r2, r8, r7)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.StaticList.a(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object c(kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof androidx.paging.PageEvent$StaticList$flatMap$1
                if (r0 == 0) goto L_0x0013
                r0 = r8
                androidx.paging.PageEvent$StaticList$flatMap$1 r0 = (androidx.paging.PageEvent$StaticList$flatMap$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.paging.PageEvent$StaticList$flatMap$1 r0 = new androidx.paging.PageEvent$StaticList$flatMap$1
                r0.<init>(r6, r8)
            L_0x0018:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0044
                if (r2 != r3) goto L_0x003c
                java.lang.Object r6 = r0.L$3
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r0.L$2
                java.util.Collection r7 = (java.util.Collection) r7
                java.lang.Object r2 = r0.L$1
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                java.lang.Object r4 = r0.L$0
                androidx.paging.PageEvent$StaticList r4 = (androidx.paging.PageEvent.StaticList) r4
                kotlin.ResultKt.throwOnFailure(r8)
                r5 = r4
                r4 = r7
                r7 = r5
                goto L_0x0075
            L_0x003c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0044:
                kotlin.ResultKt.throwOnFailure(r8)
                java.util.List r8 = r6.f1568a
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r8 = r8.iterator()
                r5 = r7
                r7 = r6
                r6 = r8
                r8 = r5
            L_0x0056:
                boolean r4 = r6.hasNext()
                if (r4 == 0) goto L_0x007d
                java.lang.Object r4 = r6.next()
                r0.L$0 = r7
                r0.L$1 = r8
                r0.L$2 = r2
                r0.L$3 = r6
                r0.label = r3
                java.lang.Object r4 = r8.invoke(r4, r0)
                if (r4 != r1) goto L_0x0071
                return r1
            L_0x0071:
                r5 = r2
                r2 = r8
                r8 = r4
                r4 = r5
            L_0x0075:
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                kotlin.collections.CollectionsKt.addAll(r4, r8)
                r8 = r2
                r2 = r4
                goto L_0x0056
            L_0x007d:
                java.util.List r2 = (java.util.List) r2
                androidx.paging.LoadStates r6 = r7.b
                androidx.paging.LoadStates r7 = r7.c
                androidx.paging.PageEvent$StaticList r8 = new androidx.paging.PageEvent$StaticList
                r8.<init>(r2, r6, r7)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.StaticList.c(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object e(kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.paging.PageEvent$StaticList$map$1
                if (r0 == 0) goto L_0x0013
                r0 = r9
                androidx.paging.PageEvent$StaticList$map$1 r0 = (androidx.paging.PageEvent$StaticList$map$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.paging.PageEvent$StaticList$map$1 r0 = new androidx.paging.PageEvent$StaticList$map$1
                r0.<init>(r7, r9)
            L_0x0018:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0049
                if (r2 != r3) goto L_0x0041
                java.lang.Object r7 = r0.L$4
                java.util.Collection r7 = (java.util.Collection) r7
                java.lang.Object r8 = r0.L$3
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r2 = r0.L$2
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.Object r4 = r0.L$1
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                java.lang.Object r5 = r0.L$0
                androidx.paging.PageEvent$StaticList r5 = (androidx.paging.PageEvent.StaticList) r5
                kotlin.ResultKt.throwOnFailure(r9)
                r6 = r0
                r0 = r8
                r8 = r5
                r5 = r6
                goto L_0x0085
            L_0x0041:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0049:
                kotlin.ResultKt.throwOnFailure(r9)
                java.util.List r9 = r7.f1568a
                java.util.ArrayList r2 = new java.util.ArrayList
                r4 = 10
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r4)
                r2.<init>(r4)
                java.util.Iterator r9 = r9.iterator()
                r6 = r8
                r8 = r7
                r7 = r2
                r2 = r0
                r0 = r6
            L_0x0062:
                boolean r4 = r9.hasNext()
                if (r4 == 0) goto L_0x008d
                java.lang.Object r4 = r9.next()
                r2.L$0 = r8
                r2.L$1 = r0
                r2.L$2 = r7
                r2.L$3 = r9
                r2.L$4 = r7
                r2.label = r3
                java.lang.Object r4 = r0.invoke(r4, r2)
                if (r4 != r1) goto L_0x007f
                return r1
            L_0x007f:
                r5 = r2
                r2 = r7
                r6 = r0
                r0 = r9
                r9 = r4
                r4 = r6
            L_0x0085:
                r7.add(r9)
                r9 = r0
                r7 = r2
                r0 = r4
                r2 = r5
                goto L_0x0062
            L_0x008d:
                java.util.List r7 = (java.util.List) r7
                androidx.paging.LoadStates r9 = r8.b
                androidx.paging.LoadStates r8 = r8.c
                androidx.paging.PageEvent$StaticList r0 = new androidx.paging.PageEvent$StaticList
                r0.<init>(r7, r9, r8)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.StaticList.e(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StaticList)) {
                return false;
            }
            StaticList staticList = (StaticList) obj;
            return Intrinsics.areEqual((Object) this.f1568a, (Object) staticList.f1568a) && Intrinsics.areEqual((Object) this.b, (Object) staticList.b) && Intrinsics.areEqual((Object) this.c, (Object) staticList.c);
        }

        public final List g() {
            return this.f1568a;
        }

        public final LoadStates h() {
            return this.c;
        }

        public int hashCode() {
            int hashCode = this.f1568a.hashCode() * 31;
            LoadStates loadStates = this.b;
            int i = 0;
            int hashCode2 = (hashCode + (loadStates == null ? 0 : loadStates.hashCode())) * 31;
            LoadStates loadStates2 = this.c;
            if (loadStates2 != null) {
                i = loadStates2.hashCode();
            }
            return hashCode2 + i;
        }

        public final LoadStates i() {
            return this.b;
        }

        public String toString() {
            LoadStates loadStates = this.c;
            String str = "PageEvent.StaticList with " + this.f1568a.size() + " items (\n                    |   first item: " + CollectionsKt.firstOrNull(this.f1568a) + "\n                    |   last item: " + CollectionsKt.lastOrNull(this.f1568a) + "\n                    |   sourceLoadStates: " + this.b + "\n                    ";
            if (loadStates != null) {
                str = str + "|   mediatorLoadStates: " + loadStates + 10;
            }
            return StringsKt.trimMargin$default(str + "|)", (String) null, 1, (Object) null);
        }
    }

    public /* synthetic */ PageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ Object b(PageEvent pageEvent, Function2 function2, Continuation continuation) {
        return pageEvent;
    }

    public Object a(Function2 function2, Continuation continuation) {
        return b(this, function2, continuation);
    }

    public Object c(Function2 function2, Continuation continuation) {
        return Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.flatMap>");
    }

    public Object e(Function2 function2, Continuation continuation) {
        return Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.map>");
    }

    public PageEvent() {
    }
}
