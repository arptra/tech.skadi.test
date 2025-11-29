package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

@SourceDebugExtension({"SMAP\nSeparators.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Separators.kt\nandroidx/paging/SeparatorState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 PageEvent.kt\nandroidx/paging/PageEvent$Insert\n*L\n1#1,607:1\n1#2:608\n1726#3,3:609\n2661#3,7:620\n116#4,8:612\n116#4,8:627\n*S KotlinDebug\n*F\n+ 1 Separators.kt\nandroidx/paging/SeparatorState\n*L\n264#1:609,3\n406#1:620,7\n315#1:612,8\n481#1:627,8\n*E\n"})
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\u00020\u0001J'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b*\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\r\"\b\b\u0002\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0010\u001a\u00020\r\"\b\b\u0002\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\bH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001c\"\b\b\u0002\u0010\u0003*\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R`\u0010,\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000(\u0012\u0006\u0012\u0004\u0018\u00010\u00010#8\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010+R#\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c0-8\u0006¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b/\u00100R\"\u00107\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010:\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u0017\u0010?\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b\u001a\u0010<\u001a\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010M\u001a\u00020G8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010P\u001a\u00020G8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010H\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR\"\u0010T\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bQ\u00102\u001a\u0004\bR\u00104\"\u0004\bS\u00106R\"\u0010X\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bU\u00102\u001a\u0004\bV\u00104\"\u0004\bW\u00106\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, d2 = {"Landroidx/paging/SeparatorState;", "", "R", "T", "Landroidx/paging/PageEvent;", "event", "c", "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$Insert;", "a", "(Landroidx/paging/PageEvent$Insert;)Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/TerminalSeparatorType;", "terminalSeparatorType", "", "h", "(Landroidx/paging/PageEvent$Insert;Landroidx/paging/TerminalSeparatorType;)Z", "g", "d", "(Landroidx/paging/PageEvent$Insert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$Drop;", "b", "(Landroidx/paging/PageEvent$Drop;)Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "e", "(Landroidx/paging/PageEvent$LoadStateUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$StaticList;", "f", "(Landroidx/paging/PageEvent$StaticList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/TransformablePage;", "originalPage", "i", "(Landroidx/paging/TransformablePage;)Landroidx/paging/TransformablePage;", "Landroidx/paging/TerminalSeparatorType;", "getTerminalSeparatorType", "()Landroidx/paging/TerminalSeparatorType;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "before", "after", "Lkotlin/coroutines/Continuation;", "Lkotlin/jvm/functions/Function3;", "getGenerator", "()Lkotlin/jvm/functions/Function3;", "generator", "", "Ljava/util/List;", "getPageStash", "()Ljava/util/List;", "pageStash", "Z", "getEndTerminalSeparatorDeferred", "()Z", "setEndTerminalSeparatorDeferred", "(Z)V", "endTerminalSeparatorDeferred", "getStartTerminalSeparatorDeferred", "setStartTerminalSeparatorDeferred", "startTerminalSeparatorDeferred", "Landroidx/paging/MutableLoadStateCollection;", "Landroidx/paging/MutableLoadStateCollection;", "getSourceStates", "()Landroidx/paging/MutableLoadStateCollection;", "sourceStates", "Landroidx/paging/LoadStates;", "Landroidx/paging/LoadStates;", "getMediatorStates", "()Landroidx/paging/LoadStates;", "setMediatorStates", "(Landroidx/paging/LoadStates;)V", "mediatorStates", "", "I", "getPlaceholdersBefore", "()I", "setPlaceholdersBefore", "(I)V", "placeholdersBefore", "getPlaceholdersAfter", "setPlaceholdersAfter", "placeholdersAfter", "j", "getFooterAdded", "setFooterAdded", "footerAdded", "k", "getHeaderAdded", "setHeaderAdded", "headerAdded", "paging-common"}, k = 1, mv = {1, 8, 0})
final class SeparatorState<R, T extends R> {

    /* renamed from: a  reason: collision with root package name */
    public final TerminalSeparatorType f1631a;
    public final Function3 b;
    public final List c;
    public boolean d;
    public boolean e;
    public final MutableLoadStateCollection f;
    public LoadStates g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.paging.TerminalSeparatorType[] r0 = androidx.paging.TerminalSeparatorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.paging.TerminalSeparatorType r1 = androidx.paging.TerminalSeparatorType.FULLY_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.paging.TerminalSeparatorType r1 = androidx.paging.TerminalSeparatorType.SOURCE_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.WhenMappings.<clinit>():void");
        }
    }

    public final PageEvent.Insert a(PageEvent.Insert insert) {
        Intrinsics.checkNotNullParameter(insert, "<this>");
        return insert;
    }

    public final PageEvent.Drop b(PageEvent.Drop drop) {
        Intrinsics.checkNotNullParameter(drop, "event");
        this.f.c(drop.g(), LoadState.NotLoading.b.b());
        LoadType g2 = drop.g();
        LoadType loadType = LoadType.PREPEND;
        if (g2 == loadType) {
            this.h = drop.k();
            this.k = false;
        } else if (drop.g() == LoadType.APPEND) {
            this.i = drop.k();
            this.j = false;
        }
        if (this.c.isEmpty()) {
            if (drop.g() == loadType) {
                this.e = false;
            } else {
                this.d = false;
            }
        }
        CollectionsKt.removeAll(this.c, new SeparatorState$onDrop$1(new IntRange(drop.i(), drop.h())));
        return drop;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(androidx.paging.PageEvent r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.paging.SeparatorState$onEvent$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.paging.SeparatorState$onEvent$1 r0 = (androidx.paging.SeparatorState$onEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.SeparatorState$onEvent$1 r0 = new androidx.paging.SeparatorState$onEvent$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 == r5) goto L_0x0043
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r6 = r0.L$0
            androidx.paging.SeparatorState r6 = (androidx.paging.SeparatorState) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0092
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            java.lang.Object r6 = r0.L$0
            androidx.paging.SeparatorState r6 = (androidx.paging.SeparatorState) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007e
        L_0x0043:
            java.lang.Object r6 = r0.L$0
            androidx.paging.SeparatorState r6 = (androidx.paging.SeparatorState) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005f
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7 instanceof androidx.paging.PageEvent.Insert
            if (r8 == 0) goto L_0x0062
            androidx.paging.PageEvent$Insert r7 = (androidx.paging.PageEvent.Insert) r7
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r8 = r6.d(r7, r0)
            if (r8 != r1) goto L_0x005f
            return r1
        L_0x005f:
            androidx.paging.PageEvent r8 = (androidx.paging.PageEvent) r8
            goto L_0x0094
        L_0x0062:
            boolean r8 = r7 instanceof androidx.paging.PageEvent.Drop
            if (r8 == 0) goto L_0x006d
            androidx.paging.PageEvent$Drop r7 = (androidx.paging.PageEvent.Drop) r7
            androidx.paging.PageEvent$Drop r8 = r6.b(r7)
            goto L_0x0094
        L_0x006d:
            boolean r8 = r7 instanceof androidx.paging.PageEvent.LoadStateUpdate
            if (r8 == 0) goto L_0x0081
            androidx.paging.PageEvent$LoadStateUpdate r7 = (androidx.paging.PageEvent.LoadStateUpdate) r7
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r6.e(r7, r0)
            if (r8 != r1) goto L_0x007e
            return r1
        L_0x007e:
            androidx.paging.PageEvent r8 = (androidx.paging.PageEvent) r8
            goto L_0x0094
        L_0x0081:
            boolean r8 = r7 instanceof androidx.paging.PageEvent.StaticList
            if (r8 == 0) goto L_0x00c7
            androidx.paging.PageEvent$StaticList r7 = (androidx.paging.PageEvent.StaticList) r7
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r6.f(r7, r0)
            if (r8 != r1) goto L_0x0092
            return r1
        L_0x0092:
            androidx.paging.PageEvent r8 = (androidx.paging.PageEvent) r8
        L_0x0094:
            boolean r7 = r6.d
            if (r7 == 0) goto L_0x00ad
            java.util.List r7 = r6.c
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x00a1
            goto L_0x00ad
        L_0x00a1:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "deferred endTerm, page stash should be empty"
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x00ad:
            boolean r7 = r6.e
            if (r7 == 0) goto L_0x00c6
            java.util.List r6 = r6.c
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00ba
            goto L_0x00c6
        L_0x00ba:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "deferred startTerm, page stash should be empty"
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x00c6:
            return r8
        L_0x00c7:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.c(androidx.paging.PageEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: androidx.paging.TransformablePage} */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0409, code lost:
        r9 = r8.d();
        r7 = r8.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0411, code lost:
        if (r7 == null) goto L_0x041f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0413, code lost:
        r10 = ((java.lang.Number) kotlin.collections.CollectionsKt.first(r7)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x041f, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0420, code lost:
        androidx.paging.SeparatorsKt.a(r5, r6, (androidx.paging.TransformablePage) null, r8, r9, r10);
        r6 = r0;
        r5 = r1;
        r10 = r2;
        r9 = r11;
        r8 = r15;
        r11 = r18;
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0430, code lost:
        if (r6 != 0) goto L_0x0786;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0432, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r9);
        r0 = r9.intValue();
        r1 = 0;
        r26 = r10;
        r10 = r8;
        r8 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x043f, code lost:
        if (r1 >= r0) goto L_0x0483;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0441, code lost:
        r15 = r14.b;
        r3.L$0 = r14;
        r3.L$1 = r13;
        r3.L$2 = r7;
        r3.L$3 = r11;
        r3.L$4 = r10;
        r3.L$5 = r9;
        r3.L$6 = r8;
        r3.L$7 = r12;
        r3.L$8 = r7;
        r18 = r12;
        r3.L$9 = null;
        r3.Z$0 = r5;
        r3.I$0 = r6;
        r3.I$1 = r1;
        r3.I$2 = r0;
        r3.label = 3;
        r2 = androidx.paging.SeparatorsKt.c((androidx.paging.TransformablePage) r13.l().get(r1), r15, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0473, code lost:
        if (r2 != r4) goto L_0x0476;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0475, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0476, code lost:
        r12 = r10;
        r10 = r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0479, code lost:
        r8.add(r2);
        r1 = r1 + 1;
        r8 = r10;
        r10 = r12;
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0483, code lost:
        r18 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x048c, code lost:
        if (r13.j() != androidx.paging.LoadType.APPEND) goto L_0x050e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0495, code lost:
        if ((!r14.c.isEmpty()) == false) goto L_0x050e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0497, code lost:
        r0 = (androidx.paging.TransformablePage) kotlin.collections.CollectionsKt.last(r14.c);
        r1 = r14.b;
        r2 = kotlin.collections.CollectionsKt.last(r0.b());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r12 = kotlin.collections.CollectionsKt.first(r10.b());
        r3.L$0 = r14;
        r3.L$1 = r13;
        r3.L$2 = r7;
        r3.L$3 = r11;
        r3.L$4 = r10;
        r3.L$5 = r9;
        r3.L$6 = r8;
        r15 = r18;
        r3.L$7 = r15;
        r3.L$8 = r0;
        r28 = r0;
        r3.L$9 = null;
        r3.Z$0 = r5;
        r3.I$0 = r6;
        r3.label = 4;
        r2 = r1.invoke(r2, r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x04d8, code lost:
        if (r2 != r4) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x04da, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x04db, code lost:
        r1 = r5;
        r0 = r6;
        r12 = r10;
        r18 = r13;
        r19 = r14;
        r6 = r2;
        r14 = r7;
        r2 = r8;
        r13 = r11;
        r7 = r28;
        r11 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x04e9, code lost:
        r9 = r12.d();
        r5 = r12.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0099, code lost:
        r6 = r2;
        r8 = r5;
        r2 = r9;
        r15 = r14;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x04f1, code lost:
        if (r5 == null) goto L_0x04ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x04f3, code lost:
        r10 = ((java.lang.Number) kotlin.collections.CollectionsKt.first(r5)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x04ff, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0500, code lost:
        r5 = r14;
        androidx.paging.SeparatorsKt.a(r5, r6, r7, r12, r9, r10);
        r8 = r2;
        r9 = r11;
        r10 = r13;
        r6 = r15;
        r13 = r18;
        r14 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x050e, code lost:
        r1 = r5;
        r0 = r6;
        r5 = r7;
        r12 = r10;
        r10 = r11;
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0516, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r12);
        r10.add(r14.i(r12));
        r2 = r14.b;
        r3.L$0 = r14;
        r3.L$1 = r13;
        r3.L$2 = r5;
        r3.L$3 = r10;
        r3.L$4 = r9;
        r3.L$5 = r8;
        r3.L$6 = r6;
        r3.L$7 = r5;
        r3.L$8 = null;
        r3.L$9 = null;
        r3.Z$0 = r1;
        r3.I$0 = r0;
        r3.label = 5;
        r2 = androidx.paging.SeparatorsKt.c(r12, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0542, code lost:
        if (r2 != r4) goto L_0x0545;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0544, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0545, code lost:
        r11 = r5;
        r12 = r13;
        r13 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0548, code lost:
        r5.add(r2);
        r2 = r12.l();
        r5 = r9.intValue();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r6);
        r2 = r2.subList(r5, r6.intValue() + 1).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0568, code lost:
        if (r2.hasNext() == false) goto L_0x077e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x056a, code lost:
        r5 = r2.next();
        r9 = r6;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
        r10 = r8;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0579, code lost:
        if (r8.hasNext() == false) goto L_0x0690;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x057b, code lost:
        r6 = r8.next();
        r5 = (androidx.paging.TransformablePage) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x058e, code lost:
        if ((!r6.b().isEmpty()) == false) goto L_0x062d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0590, code lost:
        r2 = r14.b;
        r7 = kotlin.collections.CollectionsKt.last(r5.b());
        r15 = kotlin.collections.CollectionsKt.first(r6.b());
        r3.L$0 = r14;
        r3.L$1 = r13;
        r3.L$2 = r12;
        r3.L$3 = r11;
        r3.L$4 = r10;
        r3.L$5 = r9;
        r3.L$6 = r8;
        r3.L$7 = r6;
        r3.L$8 = r5;
        r28 = r5;
        r3.L$9 = null;
        r3.Z$0 = r1;
        r3.I$0 = r0;
        r3.label = 6;
        r2 = r2.invoke(r7, r15, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05c4, code lost:
        if (r2 != r4) goto L_0x05c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05c6, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x05c7, code lost:
        r15 = r11;
        r18 = r12;
        r19 = r13;
        r20 = r14;
        r11 = r6;
        r12 = r8;
        r13 = r9;
        r14 = r10;
        r6 = r2;
        r2 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00d2, code lost:
        r26 = r14;
        r14 = r8;
        r8 = r11;
        r11 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x05d5, code lost:
        r5 = r19.j();
        r7 = androidx.paging.LoadType.PREPEND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x05db, code lost:
        if (r5 != r7) goto L_0x05e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x05dd, code lost:
        r5 = r2.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x05e1, code lost:
        r9 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x05e3, code lost:
        r5 = r11.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x05ec, code lost:
        if (r19.j() != r7) goto L_0x0609;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x05ee, code lost:
        r5 = r2.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x05f2, code lost:
        if (r5 == null) goto L_0x0600;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x05f4, code lost:
        r5 = ((java.lang.Number) kotlin.collections.CollectionsKt.last(r5)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x05fe, code lost:
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0600, code lost:
        r5 = kotlin.collections.CollectionsKt.getLastIndex(r2.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0609, code lost:
        r5 = r11.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x060d, code lost:
        if (r5 == null) goto L_0x061a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x060f, code lost:
        r5 = ((java.lang.Number) kotlin.collections.CollectionsKt.first(r5)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x061a, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x061b, code lost:
        r5 = r18;
        androidx.paging.SeparatorsKt.a(r5, r6, r2, r11, r9, r10);
        r9 = r2;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r6 = r19;
        r8 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x062d, code lost:
        r28 = r5;
        r5 = r12;
        r12 = r9;
        r9 = r28;
        r26 = r10;
        r10 = r6;
        r6 = r13;
        r13 = r26;
        r27 = r11;
        r11 = r8;
        r8 = r14;
        r14 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0649, code lost:
        if ((!r10.b().isEmpty()) == false) goto L_0x0652;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x064b, code lost:
        r14.add(r8.i(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0652, code lost:
        r2 = r8.b;
        r3.L$0 = r8;
        r3.L$1 = r6;
        r3.L$2 = r5;
        r3.L$3 = r14;
        r3.L$4 = r13;
        r3.L$5 = r12;
        r3.L$6 = r11;
        r3.L$7 = r10;
        r3.L$8 = r9;
        r3.L$9 = r5;
        r3.Z$0 = r1;
        r3.I$0 = r0;
        r3.label = 7;
        r2 = androidx.paging.SeparatorsKt.c(r10, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0673, code lost:
        if (r2 != r4) goto L_0x0676;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0675, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0676, code lost:
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0679, code lost:
        r5.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0686, code lost:
        if ((!r10.b().isEmpty()) == false) goto L_0x0689;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0688, code lost:
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0689, code lost:
        r5 = r9;
        r9 = r12;
        r10 = r13;
        r12 = r15;
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0697, code lost:
        if (r13.j() != androidx.paging.LoadType.PREPEND) goto L_0x0711;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x06a0, code lost:
        if ((!r14.c.isEmpty()) == false) goto L_0x0711;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x06a2, code lost:
        r5 = (androidx.paging.TransformablePage) kotlin.collections.CollectionsKt.first(r14.c);
        r2 = r14.b;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r6 = kotlin.collections.CollectionsKt.last(r10.b());
        r7 = kotlin.collections.CollectionsKt.first(r5.b());
        r3.L$0 = r14;
        r3.L$1 = r13;
        r3.L$2 = r12;
        r3.L$3 = r11;
        r3.L$4 = r10;
        r3.L$5 = r9;
        r3.L$6 = r5;
        r3.L$7 = null;
        r3.L$8 = null;
        r3.L$9 = null;
        r3.Z$0 = r1;
        r3.I$0 = r0;
        r3.label = 8;
        r2 = r2.invoke(r6, r7, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x06e1, code lost:
        if (r2 != r4) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x06e3, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x06e4, code lost:
        r9 = r11.d();
        r5 = r11.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x06ec, code lost:
        if (r5 == null) goto L_0x06fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x06ee, code lost:
        r5 = ((java.lang.Number) kotlin.collections.CollectionsKt.last(r5)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x06fa, code lost:
        r5 = kotlin.collections.CollectionsKt.getLastIndex(r11.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0703, code lost:
        androidx.paging.SeparatorsKt.a(r13, r6, r11, r8, r9, r5);
        r6 = r0;
        r5 = r1;
        r9 = r2;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0711, code lost:
        r6 = r0;
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0713, code lost:
        r0 = r9.intValue() + 1;
        r1 = kotlin.collections.CollectionsKt.getLastIndex(r13.l());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0721, code lost:
        if (r0 > r1) goto L_0x0779;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0723, code lost:
        r9 = r5;
        r5 = r6;
        r15 = r14;
        r14 = r13;
        r26 = r1;
        r1 = r0;
        r0 = r26;
        r27 = r11;
        r11 = r10;
        r10 = r12;
        r12 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0732, code lost:
        r6 = r15.b;
        r3.L$0 = r15;
        r3.L$1 = r14;
        r3.L$2 = r10;
        r3.L$3 = r12;
        r3.L$4 = r11;
        r3.L$5 = r10;
        r3.L$6 = null;
        r3.L$7 = null;
        r3.L$8 = null;
        r3.L$9 = null;
        r3.Z$0 = r9;
        r3.I$0 = r5;
        r3.I$1 = r1;
        r3.I$2 = r0;
        r3.label = 9;
        r2 = androidx.paging.SeparatorsKt.c((androidx.paging.TransformablePage) r14.l().get(r1), r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0763, code lost:
        if (r2 != r4) goto L_0x0766;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0765, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0766, code lost:
        r13 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0767, code lost:
        r10.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x076a, code lost:
        if (r1 == r0) goto L_0x0770;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x076c, code lost:
        r1 = r1 + 1;
        r10 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0770, code lost:
        r1 = r3;
        r6 = r5;
        r5 = r9;
        r10 = r11;
        r11 = r12;
        r0 = r13;
        r7 = r14;
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0779, code lost:
        r1 = r3;
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x077b, code lost:
        r7 = r13;
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0785, code lost:
        throw new java.lang.UnsupportedOperationException("Empty collection can't be reduced.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0786, code lost:
        r1 = r3;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0789, code lost:
        if (r5 == false) goto L_0x07f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x078d, code lost:
        if (r3.j != false) goto L_0x07f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x078f, code lost:
        r3.j = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0792, code lost:
        if (r6 == 0) goto L_0x079d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0794, code lost:
        r2 = (androidx.paging.TransformablePage) kotlin.collections.CollectionsKt.last(r3.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x079d, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x07a1, code lost:
        r5 = r3.b;
        r6 = kotlin.collections.CollectionsKt.last(r2.b());
        r1.L$0 = r3;
        r1.L$1 = r7;
        r1.L$2 = r0;
        r1.L$3 = r11;
        r1.L$4 = r2;
        r1.L$5 = r0;
        r1.L$6 = null;
        r1.L$7 = null;
        r1.L$8 = null;
        r1.L$9 = null;
        r1.label = 10;
        r1 = r5.invoke(r6, null, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x07c8, code lost:
        if (r1 != r4) goto L_0x07cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x07ca, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x07cb, code lost:
        r5 = r0;
        r12 = r5;
        r13 = r1;
        r14 = r2;
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x07d0, code lost:
        r16 = r14.d();
        r0 = r14.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x07d8, code lost:
        if (r0 == null) goto L_0x07e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x07da, code lost:
        r0 = ((java.lang.Number) kotlin.collections.CollectionsKt.last(r0)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x07e7, code lost:
        r0 = kotlin.collections.CollectionsKt.getLastIndex(r14.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x07f0, code lost:
        androidx.paging.SeparatorsKt.a(r12, r13, r14, (androidx.paging.TransformablePage) null, r16, r0);
        r11 = r4;
        r20 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x07f9, code lost:
        r20 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x07fc, code lost:
        r3.d = false;
        r3.e = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0806, code lost:
        if (r7.j() != androidx.paging.LoadType.APPEND) goto L_0x080e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0808, code lost:
        r3.c.addAll(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x080e, code lost:
        r3.c.addAll(0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0813, code lost:
        r19 = r7.j();
        r7.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0833, code lost:
        return new androidx.paging.PageEvent.Insert(r19, r20, r7.n(), r7.m(), r7.o(), r7.k(), (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return new androidx.paging.PageEvent.Insert(r0, kotlin.collections.CollectionsKt.listOf(androidx.paging.SeparatorsKt.d(r2, new int[]{r3}, r3, r3)), r1.n(), r1.m(), r1.o(), r1.k(), (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return r0.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02e1, code lost:
        r0.d = r3;
        r0.e = r3;
        r0.k = r5;
        r0.j = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02e9, code lost:
        if (r2 != null) goto L_0x02f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02f0, code lost:
        r0 = r1.j();
        r1.l();
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r3v7, types: [boolean, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(androidx.paging.PageEvent.Insert r29, kotlin.coroutines.Continuation r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            boolean r3 = r2 instanceof androidx.paging.SeparatorState$onInsert$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            androidx.paging.SeparatorState$onInsert$1 r3 = (androidx.paging.SeparatorState$onInsert$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            androidx.paging.SeparatorState$onInsert$1 r3 = new androidx.paging.SeparatorState$onInsert$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            switch(r5) {
                case 0: goto L_0x0208;
                case 1: goto L_0x01f4;
                case 2: goto L_0x01b6;
                case 3: goto L_0x0176;
                case 4: goto L_0x013d;
                case 5: goto L_0x0114;
                case 6: goto L_0x00da;
                case 7: goto L_0x00a3;
                case 8: goto L_0x0076;
                case 9: goto L_0x0051;
                case 10: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            java.lang.Object r0 = r3.L$5
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r3.L$4
            androidx.paging.TransformablePage r1 = (androidx.paging.TransformablePage) r1
            java.lang.Object r4 = r3.L$3
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.lang.Object r5 = r3.L$2
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r7 = r3.L$1
            androidx.paging.PageEvent$Insert r7 = (androidx.paging.PageEvent.Insert) r7
            java.lang.Object r3 = r3.L$0
            androidx.paging.SeparatorState r3 = (androidx.paging.SeparatorState) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r12 = r0
            r14 = r1
            r13 = r2
            goto L_0x07d0
        L_0x0051:
            int r0 = r3.I$2
            int r1 = r3.I$1
            int r5 = r3.I$0
            boolean r9 = r3.Z$0
            java.lang.Object r10 = r3.L$5
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r11 = r3.L$4
            androidx.paging.TransformablePage r11 = (androidx.paging.TransformablePage) r11
            java.lang.Object r12 = r3.L$3
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.L$2
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r14 = r3.L$1
            androidx.paging.PageEvent$Insert r14 = (androidx.paging.PageEvent.Insert) r14
            java.lang.Object r15 = r3.L$0
            androidx.paging.SeparatorState r15 = (androidx.paging.SeparatorState) r15
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0767
        L_0x0076:
            int r0 = r3.I$0
            boolean r1 = r3.Z$0
            java.lang.Object r5 = r3.L$6
            androidx.paging.TransformablePage r5 = (androidx.paging.TransformablePage) r5
            java.lang.Object r9 = r3.L$5
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.L$4
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.L$3
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.L$2
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.L$1
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            java.lang.Object r14 = r3.L$0
            androidx.paging.SeparatorState r14 = (androidx.paging.SeparatorState) r14
            kotlin.ResultKt.throwOnFailure(r2)
        L_0x0099:
            r6 = r2
            r8 = r5
            r2 = r9
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            goto L_0x06e4
        L_0x00a3:
            int r0 = r3.I$0
            boolean r1 = r3.Z$0
            java.lang.Object r5 = r3.L$9
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r9 = r3.L$8
            androidx.paging.TransformablePage r9 = (androidx.paging.TransformablePage) r9
            java.lang.Object r10 = r3.L$7
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.L$6
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r3.L$5
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Object r13 = r3.L$4
            androidx.paging.TransformablePage r13 = (androidx.paging.TransformablePage) r13
            java.lang.Object r14 = r3.L$3
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.lang.Object r15 = r3.L$2
            java.util.ArrayList r15 = (java.util.ArrayList) r15
            java.lang.Object r6 = r3.L$1
            androidx.paging.PageEvent$Insert r6 = (androidx.paging.PageEvent.Insert) r6
            java.lang.Object r8 = r3.L$0
            androidx.paging.SeparatorState r8 = (androidx.paging.SeparatorState) r8
            kotlin.ResultKt.throwOnFailure(r2)
        L_0x00d2:
            r26 = r14
            r14 = r8
            r8 = r11
            r11 = r26
            goto L_0x0679
        L_0x00da:
            int r0 = r3.I$0
            boolean r1 = r3.Z$0
            java.lang.Object r5 = r3.L$8
            androidx.paging.TransformablePage r5 = (androidx.paging.TransformablePage) r5
            java.lang.Object r6 = r3.L$7
            androidx.paging.TransformablePage r6 = (androidx.paging.TransformablePage) r6
            java.lang.Object r8 = r3.L$6
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r3.L$5
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.L$4
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.L$3
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.L$2
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.L$1
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            java.lang.Object r14 = r3.L$0
            androidx.paging.SeparatorState r14 = (androidx.paging.SeparatorState) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = r11
            r18 = r12
            r19 = r13
            r20 = r14
            r11 = r6
            r12 = r8
            r13 = r9
            r14 = r10
            r6 = r2
            r2 = r5
            goto L_0x05d5
        L_0x0114:
            int r0 = r3.I$0
            boolean r1 = r3.Z$0
            java.lang.Object r5 = r3.L$7
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r3.L$6
            java.lang.Integer r6 = (java.lang.Integer) r6
            java.lang.Object r8 = r3.L$5
            androidx.paging.TransformablePage r8 = (androidx.paging.TransformablePage) r8
            java.lang.Object r9 = r3.L$4
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.L$3
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r11 = r3.L$2
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.L$1
            androidx.paging.PageEvent$Insert r12 = (androidx.paging.PageEvent.Insert) r12
            java.lang.Object r13 = r3.L$0
            androidx.paging.SeparatorState r13 = (androidx.paging.SeparatorState) r13
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0548
        L_0x013d:
            int r0 = r3.I$0
            boolean r1 = r3.Z$0
            java.lang.Object r5 = r3.L$8
            androidx.paging.TransformablePage r5 = (androidx.paging.TransformablePage) r5
            java.lang.Object r6 = r3.L$7
            java.lang.Integer r6 = (java.lang.Integer) r6
            java.lang.Object r8 = r3.L$6
            androidx.paging.TransformablePage r8 = (androidx.paging.TransformablePage) r8
            java.lang.Object r9 = r3.L$5
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.L$4
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.L$3
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.L$2
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.L$1
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            java.lang.Object r14 = r3.L$0
            androidx.paging.SeparatorState r14 = (androidx.paging.SeparatorState) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r5
            r15 = r6
            r18 = r13
            r19 = r14
            r6 = r2
            r2 = r8
            r13 = r11
            r14 = r12
            r11 = r9
            r12 = r10
            goto L_0x04e9
        L_0x0176:
            int r0 = r3.I$2
            int r1 = r3.I$1
            int r5 = r3.I$0
            boolean r6 = r3.Z$0
            java.lang.Object r8 = r3.L$8
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            java.lang.Object r9 = r3.L$7
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.L$6
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.L$5
            java.lang.Integer r11 = (java.lang.Integer) r11
            java.lang.Object r12 = r3.L$4
            androidx.paging.TransformablePage r12 = (androidx.paging.TransformablePage) r12
            java.lang.Object r13 = r3.L$3
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r14 = r3.L$2
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.lang.Object r15 = r3.L$1
            androidx.paging.PageEvent$Insert r15 = (androidx.paging.PageEvent.Insert) r15
            java.lang.Object r7 = r3.L$0
            androidx.paging.SeparatorState r7 = (androidx.paging.SeparatorState) r7
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r9
            r9 = r11
            r11 = r13
            r13 = r15
            r26 = r6
            r6 = r5
            r5 = r26
            r27 = r14
            r14 = r7
            r7 = r27
            goto L_0x0479
        L_0x01b6:
            int r0 = r3.I$0
            boolean r1 = r3.Z$0
            java.lang.Object r5 = r3.L$9
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r3.L$8
            androidx.paging.TransformablePage r6 = (androidx.paging.TransformablePage) r6
            java.lang.Object r7 = r3.L$7
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.Object r8 = r3.L$6
            androidx.paging.TransformablePage r8 = (androidx.paging.TransformablePage) r8
            java.lang.Object r9 = r3.L$5
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.L$4
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.L$3
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.L$2
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.L$1
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            java.lang.Object r14 = r3.L$0
            androidx.paging.SeparatorState r14 = (androidx.paging.SeparatorState) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = r10
            r18 = r11
            r19 = r12
            r12 = r7
            r11 = r9
            r26 = r6
            r6 = r2
            r2 = r8
            r8 = r26
            goto L_0x0409
        L_0x01f4:
            java.lang.Object r0 = r3.L$1
            androidx.paging.PageEvent$Insert r0 = (androidx.paging.PageEvent.Insert) r0
            java.lang.Object r1 = r3.L$0
            androidx.paging.SeparatorState r1 = (androidx.paging.SeparatorState) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r3 = 0
            r5 = 1
            r26 = r1
            r1 = r0
            r0 = r26
            goto L_0x02e1
        L_0x0208:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.paging.TerminalSeparatorType r2 = r0.f1631a
            boolean r2 = r0.h(r1, r2)
            androidx.paging.TerminalSeparatorType r5 = r0.f1631a
            boolean r5 = r0.g(r1, r5)
            java.util.List r6 = r29.l()
            boolean r7 = r6 instanceof java.util.Collection
            if (r7 == 0) goto L_0x0227
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0227
        L_0x0225:
            r6 = 1
            goto L_0x0242
        L_0x0227:
            java.util.Iterator r6 = r6.iterator()
        L_0x022b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0225
            java.lang.Object r7 = r6.next()
            androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
            java.util.List r7 = r7.b()
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x022b
            r6 = 0
        L_0x0242:
            boolean r7 = r0.k
            if (r7 == 0) goto L_0x025d
            androidx.paging.LoadType r7 = r29.j()
            androidx.paging.LoadType r8 = androidx.paging.LoadType.PREPEND
            if (r7 != r8) goto L_0x025d
            if (r6 == 0) goto L_0x0251
            goto L_0x025d
        L_0x0251:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Additional prepend event after prepend state is done"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x025d:
            boolean r7 = r0.j
            if (r7 == 0) goto L_0x0278
            androidx.paging.LoadType r7 = r29.j()
            androidx.paging.LoadType r8 = androidx.paging.LoadType.APPEND
            if (r7 != r8) goto L_0x0278
            if (r6 == 0) goto L_0x026c
            goto L_0x0278
        L_0x026c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Additional append event after append state is done"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0278:
            androidx.paging.MutableLoadStateCollection r7 = r0.f
            androidx.paging.LoadStates r8 = r29.o()
            r7.b(r8)
            androidx.paging.LoadStates r7 = r29.k()
            r0.g = r7
            androidx.paging.LoadType r7 = r29.j()
            androidx.paging.LoadType r8 = androidx.paging.LoadType.APPEND
            if (r7 == r8) goto L_0x0295
            int r7 = r29.n()
            r0.h = r7
        L_0x0295:
            androidx.paging.LoadType r7 = r29.j()
            androidx.paging.LoadType r8 = androidx.paging.LoadType.PREPEND
            if (r7 == r8) goto L_0x02a3
            int r7 = r29.m()
            r0.i = r7
        L_0x02a3:
            if (r6 == 0) goto L_0x0335
            if (r2 != 0) goto L_0x02ae
            if (r5 != 0) goto L_0x02ae
            androidx.paging.PageEvent$Insert r0 = r28.a(r29)
            return r0
        L_0x02ae:
            boolean r7 = r0.k
            if (r7 == 0) goto L_0x02bb
            boolean r7 = r0.j
            if (r7 == 0) goto L_0x02bb
            androidx.paging.PageEvent$Insert r0 = r28.a(r29)
            return r0
        L_0x02bb:
            java.util.List r7 = r0.c
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0335
            if (r2 == 0) goto L_0x031d
            if (r5 == 0) goto L_0x031d
            boolean r6 = r0.k
            if (r6 != 0) goto L_0x031d
            boolean r6 = r0.j
            if (r6 != 0) goto L_0x031d
            kotlin.jvm.functions.Function3 r2 = r0.b
            r3.L$0 = r0
            r3.L$1 = r1
            r5 = 1
            r3.label = r5
            r6 = 0
            java.lang.Object r2 = r2.invoke(r6, r6, r3)
            if (r2 != r4) goto L_0x02e0
            return r4
        L_0x02e0:
            r3 = 0
        L_0x02e1:
            r0.d = r3
            r0.e = r3
            r0.k = r5
            r0.j = r5
            if (r2 != 0) goto L_0x02f0
            androidx.paging.PageEvent$Insert r0 = r0.a(r1)
            goto L_0x031c
        L_0x02f0:
            androidx.paging.LoadType r0 = r1.j()
            r1.l()
            int[] r4 = new int[]{r3}
            androidx.paging.TransformablePage r2 = androidx.paging.SeparatorsKt.d(r2, r4, r3, r3)
            java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r2)
            int r4 = r1.n()
            int r5 = r1.m()
            androidx.paging.LoadStates r6 = r1.o()
            androidx.paging.LoadStates r7 = r1.k()
            androidx.paging.PageEvent$Insert r9 = new androidx.paging.PageEvent$Insert
            r8 = 0
            r1 = r9
            r2 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r0 = r9
        L_0x031c:
            return r0
        L_0x031d:
            if (r5 == 0) goto L_0x0327
            boolean r3 = r0.j
            if (r3 != 0) goto L_0x0327
            r3 = 1
            r0.d = r3
            goto L_0x0328
        L_0x0327:
            r3 = 1
        L_0x0328:
            if (r2 == 0) goto L_0x0330
            boolean r2 = r0.k
            if (r2 != 0) goto L_0x0330
            r0.e = r3
        L_0x0330:
            androidx.paging.PageEvent$Insert r0 = r28.a(r29)
            return r0
        L_0x0335:
            java.util.ArrayList r7 = new java.util.ArrayList
            java.util.List r8 = r29.l()
            int r8 = r8.size()
            r7.<init>(r8)
            java.util.ArrayList r11 = new java.util.ArrayList
            java.util.List r8 = r29.l()
            int r8 = r8.size()
            r11.<init>(r8)
            if (r6 != 0) goto L_0x03b1
            r8 = 0
        L_0x0352:
            java.util.List r9 = r29.l()
            int r9 = kotlin.collections.CollectionsKt.getLastIndex(r9)
            if (r8 >= r9) goto L_0x0373
            java.util.List r9 = r29.l()
            java.lang.Object r9 = r9.get(r8)
            androidx.paging.TransformablePage r9 = (androidx.paging.TransformablePage) r9
            java.util.List r9 = r9.b()
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0373
            int r8 = r8 + 1
            goto L_0x0352
        L_0x0373:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            java.util.List r10 = r29.l()
            java.lang.Object r8 = r10.get(r8)
            androidx.paging.TransformablePage r8 = (androidx.paging.TransformablePage) r8
            java.util.List r10 = r29.l()
            int r10 = kotlin.collections.CollectionsKt.getLastIndex(r10)
        L_0x0389:
            if (r10 <= 0) goto L_0x03a2
            java.util.List r12 = r29.l()
            java.lang.Object r12 = r12.get(r10)
            androidx.paging.TransformablePage r12 = (androidx.paging.TransformablePage) r12
            java.util.List r12 = r12.b()
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x03a2
            int r10 = r10 + -1
            goto L_0x0389
        L_0x03a2:
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            java.util.List r13 = r29.l()
            java.lang.Object r10 = r13.get(r10)
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            goto L_0x03b5
        L_0x03b1:
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
        L_0x03b5:
            if (r2 == 0) goto L_0x042e
            boolean r2 = r0.k
            if (r2 != 0) goto L_0x042e
            r2 = 1
            r0.k = r2
            if (r6 == 0) goto L_0x03c9
            java.util.List r2 = r0.c
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)
            androidx.paging.TransformablePage r2 = (androidx.paging.TransformablePage) r2
            goto L_0x03cd
        L_0x03c9:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r2 = r8
        L_0x03cd:
            kotlin.jvm.functions.Function3 r13 = r0.b
            java.util.List r14 = r2.b()
            java.lang.Object r14 = kotlin.collections.CollectionsKt.first(r14)
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r7
            r3.L$3 = r11
            r3.L$4 = r8
            r3.L$5 = r9
            r3.L$6 = r10
            r3.L$7 = r12
            r3.L$8 = r2
            r3.L$9 = r7
            r3.Z$0 = r5
            r3.I$0 = r6
            r15 = 2
            r3.label = r15
            r15 = 0
            java.lang.Object r13 = r13.invoke(r15, r14, r3)
            if (r13 != r4) goto L_0x03fa
            return r4
        L_0x03fa:
            r14 = r0
            r0 = r6
            r19 = r7
            r15 = r8
            r18 = r11
            r6 = r13
            r13 = r1
            r8 = r2
            r1 = r5
            r5 = r19
            r11 = r9
            r2 = r10
        L_0x0409:
            int r9 = r8.d()
            java.util.List r7 = r8.c()
            if (r7 == 0) goto L_0x041f
            java.lang.Object r7 = kotlin.collections.CollectionsKt.first(r7)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r10 = r7
            goto L_0x0420
        L_0x041f:
            r10 = 0
        L_0x0420:
            r7 = 0
            androidx.paging.SeparatorsKt.a(r5, r6, r7, r8, r9, r10)
            r6 = r0
            r5 = r1
            r10 = r2
            r9 = r11
            r8 = r15
            r11 = r18
            r7 = r19
            goto L_0x0430
        L_0x042e:
            r14 = r0
            r13 = r1
        L_0x0430:
            if (r6 != 0) goto L_0x0786
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r0 = r9.intValue()
            r1 = 0
            r26 = r10
            r10 = r8
            r8 = r26
        L_0x043f:
            if (r1 >= r0) goto L_0x0483
            java.util.List r2 = r13.l()
            java.lang.Object r2 = r2.get(r1)
            androidx.paging.TransformablePage r2 = (androidx.paging.TransformablePage) r2
            kotlin.jvm.functions.Function3 r15 = r14.b
            r3.L$0 = r14
            r3.L$1 = r13
            r3.L$2 = r7
            r3.L$3 = r11
            r3.L$4 = r10
            r3.L$5 = r9
            r3.L$6 = r8
            r3.L$7 = r12
            r3.L$8 = r7
            r18 = r12
            r12 = 0
            r3.L$9 = r12
            r3.Z$0 = r5
            r3.I$0 = r6
            r3.I$1 = r1
            r3.I$2 = r0
            r12 = 3
            r3.label = r12
            java.lang.Object r2 = androidx.paging.SeparatorsKt.c(r2, r15, r3)
            if (r2 != r4) goto L_0x0476
            return r4
        L_0x0476:
            r12 = r10
            r10 = r8
            r8 = r7
        L_0x0479:
            r8.add(r2)
            r2 = 1
            int r1 = r1 + r2
            r8 = r10
            r10 = r12
            r12 = r18
            goto L_0x043f
        L_0x0483:
            r18 = r12
            r2 = 1
            androidx.paging.LoadType r0 = r13.j()
            androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND
            if (r0 != r1) goto L_0x050e
            java.util.List r0 = r14.c
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x050e
            java.util.List r0 = r14.c
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r0)
            androidx.paging.TransformablePage r0 = (androidx.paging.TransformablePage) r0
            kotlin.jvm.functions.Function3 r1 = r14.b
            java.util.List r2 = r0.b()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.util.List r12 = r10.b()
            java.lang.Object r12 = kotlin.collections.CollectionsKt.first(r12)
            r3.L$0 = r14
            r3.L$1 = r13
            r3.L$2 = r7
            r3.L$3 = r11
            r3.L$4 = r10
            r3.L$5 = r9
            r3.L$6 = r8
            r15 = r18
            r3.L$7 = r15
            r3.L$8 = r0
            r28 = r0
            r0 = 0
            r3.L$9 = r0
            r3.Z$0 = r5
            r3.I$0 = r6
            r0 = 4
            r3.label = r0
            java.lang.Object r2 = r1.invoke(r2, r12, r3)
            if (r2 != r4) goto L_0x04db
            return r4
        L_0x04db:
            r1 = r5
            r0 = r6
            r12 = r10
            r18 = r13
            r19 = r14
            r6 = r2
            r14 = r7
            r2 = r8
            r13 = r11
            r7 = r28
            r11 = r9
        L_0x04e9:
            int r9 = r12.d()
            java.util.List r5 = r12.c()
            if (r5 == 0) goto L_0x04ff
            java.lang.Object r5 = kotlin.collections.CollectionsKt.first(r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            r10 = r5
            goto L_0x0500
        L_0x04ff:
            r10 = 0
        L_0x0500:
            r5 = r14
            r8 = r12
            androidx.paging.SeparatorsKt.a(r5, r6, r7, r8, r9, r10)
            r8 = r2
            r9 = r11
            r10 = r13
            r6 = r15
            r13 = r18
            r14 = r19
            goto L_0x0516
        L_0x050e:
            r15 = r18
            r1 = r5
            r0 = r6
            r5 = r7
            r12 = r10
            r10 = r11
            r6 = r15
        L_0x0516:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            androidx.paging.TransformablePage r2 = r14.i(r12)
            r10.add(r2)
            kotlin.jvm.functions.Function3 r2 = r14.b
            r3.L$0 = r14
            r3.L$1 = r13
            r3.L$2 = r5
            r3.L$3 = r10
            r3.L$4 = r9
            r3.L$5 = r8
            r3.L$6 = r6
            r3.L$7 = r5
            r7 = 0
            r3.L$8 = r7
            r3.L$9 = r7
            r3.Z$0 = r1
            r3.I$0 = r0
            r7 = 5
            r3.label = r7
            java.lang.Object r2 = androidx.paging.SeparatorsKt.c(r12, r2, r3)
            if (r2 != r4) goto L_0x0545
            return r4
        L_0x0545:
            r11 = r5
            r12 = r13
            r13 = r14
        L_0x0548:
            r5.add(r2)
            java.util.List r2 = r12.l()
            int r5 = r9.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r7 = r6.intValue()
            r9 = 1
            int r7 = r7 + r9
            java.util.List r2 = r2.subList(r5, r7)
            java.util.Iterator r2 = r2.iterator()
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x077e
            java.lang.Object r5 = r2.next()
            r9 = r6
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r8
            r8 = r2
        L_0x0575:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0690
            java.lang.Object r2 = r8.next()
            r6 = r2
            androidx.paging.TransformablePage r6 = (androidx.paging.TransformablePage) r6
            androidx.paging.TransformablePage r5 = (androidx.paging.TransformablePage) r5
            java.util.List r2 = r6.b()
            boolean r2 = r2.isEmpty()
            r7 = 1
            r2 = r2 ^ r7
            if (r2 == 0) goto L_0x062d
            kotlin.jvm.functions.Function3 r2 = r14.b
            java.util.List r7 = r5.b()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.last(r7)
            java.util.List r15 = r6.b()
            java.lang.Object r15 = kotlin.collections.CollectionsKt.first(r15)
            r3.L$0 = r14
            r3.L$1 = r13
            r3.L$2 = r12
            r3.L$3 = r11
            r3.L$4 = r10
            r3.L$5 = r9
            r3.L$6 = r8
            r3.L$7 = r6
            r3.L$8 = r5
            r28 = r5
            r5 = 0
            r3.L$9 = r5
            r3.Z$0 = r1
            r3.I$0 = r0
            r5 = 6
            r3.label = r5
            java.lang.Object r2 = r2.invoke(r7, r15, r3)
            if (r2 != r4) goto L_0x05c7
            return r4
        L_0x05c7:
            r15 = r11
            r18 = r12
            r19 = r13
            r20 = r14
            r11 = r6
            r12 = r8
            r13 = r9
            r14 = r10
            r6 = r2
            r2 = r28
        L_0x05d5:
            androidx.paging.LoadType r5 = r19.j()
            androidx.paging.LoadType r7 = androidx.paging.LoadType.PREPEND
            if (r5 != r7) goto L_0x05e3
            int r5 = r2.d()
        L_0x05e1:
            r9 = r5
            goto L_0x05e8
        L_0x05e3:
            int r5 = r11.d()
            goto L_0x05e1
        L_0x05e8:
            androidx.paging.LoadType r5 = r19.j()
            if (r5 != r7) goto L_0x0609
            java.util.List r5 = r2.c()
            if (r5 == 0) goto L_0x0600
            java.lang.Object r5 = kotlin.collections.CollectionsKt.last(r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
        L_0x05fe:
            r10 = r5
            goto L_0x061b
        L_0x0600:
            java.util.List r5 = r2.b()
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r5)
            goto L_0x05fe
        L_0x0609:
            java.util.List r5 = r11.c()
            if (r5 == 0) goto L_0x061a
            java.lang.Object r5 = kotlin.collections.CollectionsKt.first(r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            goto L_0x05fe
        L_0x061a:
            r10 = 0
        L_0x061b:
            r5 = r18
            r7 = r2
            r8 = r11
            androidx.paging.SeparatorsKt.a(r5, r6, r7, r8, r9, r10)
            r9 = r2
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r6 = r19
            r8 = r20
            goto L_0x063f
        L_0x062d:
            r28 = r5
            r5 = r12
            r12 = r9
            r9 = r28
            r26 = r10
            r10 = r6
            r6 = r13
            r13 = r26
            r27 = r11
            r11 = r8
            r8 = r14
            r14 = r27
        L_0x063f:
            java.util.List r2 = r10.b()
            boolean r2 = r2.isEmpty()
            r7 = 1
            r2 = r2 ^ r7
            if (r2 == 0) goto L_0x0652
            androidx.paging.TransformablePage r2 = r8.i(r10)
            r14.add(r2)
        L_0x0652:
            kotlin.jvm.functions.Function3 r2 = r8.b
            r3.L$0 = r8
            r3.L$1 = r6
            r3.L$2 = r5
            r3.L$3 = r14
            r3.L$4 = r13
            r3.L$5 = r12
            r3.L$6 = r11
            r3.L$7 = r10
            r3.L$8 = r9
            r3.L$9 = r5
            r3.Z$0 = r1
            r3.I$0 = r0
            r7 = 7
            r3.label = r7
            java.lang.Object r2 = androidx.paging.SeparatorsKt.c(r10, r2, r3)
            if (r2 != r4) goto L_0x0676
            return r4
        L_0x0676:
            r15 = r5
            goto L_0x00d2
        L_0x0679:
            r5.add(r2)
            java.util.List r2 = r10.b()
            boolean r2 = r2.isEmpty()
            r5 = 1
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x0689
            r9 = r10
        L_0x0689:
            r5 = r9
            r9 = r12
            r10 = r13
            r12 = r15
            r13 = r6
            goto L_0x0575
        L_0x0690:
            r5 = 1
            androidx.paging.LoadType r2 = r13.j()
            androidx.paging.LoadType r6 = androidx.paging.LoadType.PREPEND
            if (r2 != r6) goto L_0x0711
            java.util.List r2 = r14.c
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x0711
            java.util.List r2 = r14.c
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)
            r5 = r2
            androidx.paging.TransformablePage r5 = (androidx.paging.TransformablePage) r5
            kotlin.jvm.functions.Function3 r2 = r14.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.util.List r6 = r10.b()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.last(r6)
            java.util.List r7 = r5.b()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.first(r7)
            r3.L$0 = r14
            r3.L$1 = r13
            r3.L$2 = r12
            r3.L$3 = r11
            r3.L$4 = r10
            r3.L$5 = r9
            r3.L$6 = r5
            r8 = 0
            r3.L$7 = r8
            r3.L$8 = r8
            r3.L$9 = r8
            r3.Z$0 = r1
            r3.I$0 = r0
            r8 = 8
            r3.label = r8
            java.lang.Object r2 = r2.invoke(r6, r7, r3)
            if (r2 != r4) goto L_0x0099
            return r4
        L_0x06e4:
            int r9 = r11.d()
            java.util.List r5 = r11.c()
            if (r5 == 0) goto L_0x06fa
            java.lang.Object r5 = kotlin.collections.CollectionsKt.last(r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
        L_0x06f8:
            r10 = r5
            goto L_0x0703
        L_0x06fa:
            java.util.List r5 = r11.b()
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r5)
            goto L_0x06f8
        L_0x0703:
            r5 = r13
            r7 = r11
            androidx.paging.SeparatorsKt.a(r5, r6, r7, r8, r9, r10)
            r6 = r0
            r5 = r1
            r9 = r2
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            goto L_0x0713
        L_0x0711:
            r6 = r0
            r5 = r1
        L_0x0713:
            int r0 = r9.intValue()
            r1 = 1
            int r0 = r0 + r1
            java.util.List r1 = r13.l()
            int r1 = kotlin.collections.CollectionsKt.getLastIndex(r1)
            if (r0 > r1) goto L_0x0779
            r9 = r5
            r5 = r6
            r15 = r14
            r14 = r13
            r26 = r1
            r1 = r0
            r0 = r26
            r27 = r11
            r11 = r10
            r10 = r12
            r12 = r27
        L_0x0732:
            java.util.List r2 = r14.l()
            java.lang.Object r2 = r2.get(r1)
            androidx.paging.TransformablePage r2 = (androidx.paging.TransformablePage) r2
            kotlin.jvm.functions.Function3 r6 = r15.b
            r3.L$0 = r15
            r3.L$1 = r14
            r3.L$2 = r10
            r3.L$3 = r12
            r3.L$4 = r11
            r3.L$5 = r10
            r7 = 0
            r3.L$6 = r7
            r3.L$7 = r7
            r3.L$8 = r7
            r3.L$9 = r7
            r3.Z$0 = r9
            r3.I$0 = r5
            r3.I$1 = r1
            r3.I$2 = r0
            r7 = 9
            r3.label = r7
            java.lang.Object r2 = androidx.paging.SeparatorsKt.c(r2, r6, r3)
            if (r2 != r4) goto L_0x0766
            return r4
        L_0x0766:
            r13 = r10
        L_0x0767:
            r10.add(r2)
            if (r1 == r0) goto L_0x0770
            int r1 = r1 + 1
            r10 = r13
            goto L_0x0732
        L_0x0770:
            r1 = r3
            r6 = r5
            r5 = r9
            r10 = r11
            r11 = r12
            r0 = r13
            r7 = r14
            r3 = r15
            goto L_0x0789
        L_0x0779:
            r1 = r3
            r0 = r12
        L_0x077b:
            r7 = r13
            r3 = r14
            goto L_0x0789
        L_0x077e:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "Empty collection can't be reduced."
            r0.<init>(r1)
            throw r0
        L_0x0786:
            r1 = r3
            r0 = r7
            goto L_0x077b
        L_0x0789:
            if (r5 == 0) goto L_0x07f9
            boolean r2 = r3.j
            if (r2 != 0) goto L_0x07f9
            r2 = 1
            r3.j = r2
            if (r6 == 0) goto L_0x079d
            java.util.List r2 = r3.c
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r2)
            androidx.paging.TransformablePage r2 = (androidx.paging.TransformablePage) r2
            goto L_0x07a1
        L_0x079d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r2 = r10
        L_0x07a1:
            kotlin.jvm.functions.Function3 r5 = r3.b
            java.util.List r6 = r2.b()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.last(r6)
            r1.L$0 = r3
            r1.L$1 = r7
            r1.L$2 = r0
            r1.L$3 = r11
            r1.L$4 = r2
            r1.L$5 = r0
            r8 = 0
            r1.L$6 = r8
            r1.L$7 = r8
            r1.L$8 = r8
            r1.L$9 = r8
            r9 = 10
            r1.label = r9
            java.lang.Object r1 = r5.invoke(r6, r8, r1)
            if (r1 != r4) goto L_0x07cb
            return r4
        L_0x07cb:
            r5 = r0
            r12 = r5
            r13 = r1
            r14 = r2
            r4 = r11
        L_0x07d0:
            int r16 = r14.d()
            java.util.List r0 = r14.c()
            if (r0 == 0) goto L_0x07e7
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
        L_0x07e4:
            r17 = r0
            goto L_0x07f0
        L_0x07e7:
            java.util.List r0 = r14.b()
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r0)
            goto L_0x07e4
        L_0x07f0:
            r15 = 0
            androidx.paging.SeparatorsKt.a(r12, r13, r14, r15, r16, r17)
            r11 = r4
            r20 = r5
        L_0x07f7:
            r0 = 0
            goto L_0x07fc
        L_0x07f9:
            r20 = r0
            goto L_0x07f7
        L_0x07fc:
            r3.d = r0
            r3.e = r0
            androidx.paging.LoadType r1 = r7.j()
            androidx.paging.LoadType r2 = androidx.paging.LoadType.APPEND
            if (r1 != r2) goto L_0x080e
            java.util.List r0 = r3.c
            r0.addAll(r11)
            goto L_0x0813
        L_0x080e:
            java.util.List r1 = r3.c
            r1.addAll(r0, r11)
        L_0x0813:
            androidx.paging.LoadType r19 = r7.j()
            r7.l()
            int r21 = r7.n()
            int r22 = r7.m()
            androidx.paging.LoadStates r23 = r7.o()
            androidx.paging.LoadStates r24 = r7.k()
            androidx.paging.PageEvent$Insert r0 = new androidx.paging.PageEvent$Insert
            r25 = 0
            r18 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.d(androidx.paging.PageEvent$Insert, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object e(PageEvent.LoadStateUpdate loadStateUpdate, Continuation continuation) {
        LoadStates loadStates = this.g;
        if (!Intrinsics.areEqual((Object) this.f.d(), (Object) loadStateUpdate.h()) || !Intrinsics.areEqual((Object) loadStates, (Object) loadStateUpdate.g())) {
            this.f.b(loadStateUpdate.h());
            this.g = loadStateUpdate.g();
            LoadState loadState = null;
            if (loadStateUpdate.g() != null && loadStateUpdate.g().e().a()) {
                if (!Intrinsics.areEqual((Object) loadStates != null ? loadStates.e() : null, (Object) loadStateUpdate.g().e())) {
                    return d(PageEvent.Insert.g.b(CollectionsKt.emptyList(), this.h, loadStateUpdate.h(), loadStateUpdate.g()), continuation);
                }
            }
            if (loadStateUpdate.g() != null && loadStateUpdate.g().d().a()) {
                if (loadStates != null) {
                    loadState = loadStates.d();
                }
                if (!Intrinsics.areEqual((Object) loadState, (Object) loadStateUpdate.g().d())) {
                    return d(PageEvent.Insert.g.a(CollectionsKt.emptyList(), this.i, loadStateUpdate.h(), loadStateUpdate.g()), continuation);
                }
            }
            Intrinsics.checkNotNull(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
            return loadStateUpdate;
        }
        Intrinsics.checkNotNull(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
        return loadStateUpdate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(androidx.paging.PageEvent.StaticList r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.paging.SeparatorState$onStaticList$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.paging.SeparatorState$onStaticList$1 r0 = (androidx.paging.SeparatorState$onStaticList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.SeparatorState$onStaticList$1 r0 = new androidx.paging.SeparatorState$onStaticList$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            int r10 = r0.I$1
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$3
            java.lang.Object r4 = r0.L$2
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$1
            androidx.paging.PageEvent$StaticList r5 = (androidx.paging.PageEvent.StaticList) r5
            java.lang.Object r6 = r0.L$0
            androidx.paging.SeparatorState r6 = (androidx.paging.SeparatorState) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r6
            r6 = r10
            r10 = r8
            goto L_0x008a
        L_0x003e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r2 = r11.g()
            int r2 = r2.size()
            if (r2 < 0) goto L_0x009f
            r4 = 0
        L_0x0059:
            java.util.List r5 = r11.g()
            int r6 = r4 + -1
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r5, r6)
            java.util.List r6 = r11.g()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.getOrNull(r6, r4)
            kotlin.jvm.functions.Function3 r7 = r10.b
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r6
            r0.I$0 = r4
            r0.I$1 = r2
            r0.label = r3
            java.lang.Object r5 = r7.invoke(r5, r6, r0)
            if (r5 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r8 = r5
            r5 = r11
            r11 = r4
            r4 = r12
            r12 = r8
            r9 = r6
            r6 = r2
            r2 = r9
        L_0x008a:
            if (r12 == 0) goto L_0x008f
            r4.add(r12)
        L_0x008f:
            if (r2 == 0) goto L_0x0094
            r4.add(r2)
        L_0x0094:
            if (r11 == r6) goto L_0x009d
            int r11 = r11 + 1
            r12 = r4
            r2 = r6
            r4 = r11
            r11 = r5
            goto L_0x0059
        L_0x009d:
            r12 = r4
            r11 = r5
        L_0x009f:
            androidx.paging.PageEvent$StaticList r10 = new androidx.paging.PageEvent$StaticList
            androidx.paging.LoadStates r0 = r11.i()
            androidx.paging.LoadStates r11 = r11.h()
            r10.<init>(r12, r0, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.f(androidx.paging.PageEvent$StaticList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        r2 = (r2 = r3.k()).d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(androidx.paging.PageEvent.Insert r3, androidx.paging.TerminalSeparatorType r4) {
        /*
            r2 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "terminalSeparatorType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.paging.LoadType r0 = r3.j()
            androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND
            if (r0 != r1) goto L_0x0015
            boolean r2 = r2.d
            return r2
        L_0x0015:
            int[] r2 = androidx.paging.SeparatorState.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r2 = r2[r4]
            r4 = 1
            if (r2 == r4) goto L_0x0036
            r4 = 2
            if (r2 != r4) goto L_0x0030
            androidx.paging.LoadStates r2 = r3.o()
            androidx.paging.LoadState r2 = r2.d()
            boolean r4 = r2.a()
            goto L_0x0057
        L_0x0030:
            kotlin.NoWhenBranchMatchedException r2 = new kotlin.NoWhenBranchMatchedException
            r2.<init>()
            throw r2
        L_0x0036:
            androidx.paging.LoadStates r2 = r3.o()
            androidx.paging.LoadState r2 = r2.d()
            boolean r2 = r2.a()
            if (r2 == 0) goto L_0x0056
            androidx.paging.LoadStates r2 = r3.k()
            if (r2 == 0) goto L_0x0057
            androidx.paging.LoadState r2 = r2.d()
            if (r2 == 0) goto L_0x0057
            boolean r2 = r2.a()
            if (r2 != 0) goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.g(androidx.paging.PageEvent$Insert, androidx.paging.TerminalSeparatorType):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        r2 = (r2 = r3.k()).e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(androidx.paging.PageEvent.Insert r3, androidx.paging.TerminalSeparatorType r4) {
        /*
            r2 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "terminalSeparatorType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.paging.LoadType r0 = r3.j()
            androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND
            if (r0 != r1) goto L_0x0015
            boolean r2 = r2.e
            return r2
        L_0x0015:
            int[] r2 = androidx.paging.SeparatorState.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r2 = r2[r4]
            r4 = 1
            if (r2 == r4) goto L_0x0036
            r4 = 2
            if (r2 != r4) goto L_0x0030
            androidx.paging.LoadStates r2 = r3.o()
            androidx.paging.LoadState r2 = r2.e()
            boolean r4 = r2.a()
            goto L_0x0057
        L_0x0030:
            kotlin.NoWhenBranchMatchedException r2 = new kotlin.NoWhenBranchMatchedException
            r2.<init>()
            throw r2
        L_0x0036:
            androidx.paging.LoadStates r2 = r3.o()
            androidx.paging.LoadState r2 = r2.e()
            boolean r2 = r2.a()
            if (r2 == 0) goto L_0x0056
            androidx.paging.LoadStates r2 = r3.k()
            if (r2 == 0) goto L_0x0057
            androidx.paging.LoadState r2 = r2.e()
            if (r2 == 0) goto L_0x0057
            boolean r2 = r2.a()
            if (r2 != 0) goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.h(androidx.paging.PageEvent$Insert, androidx.paging.TerminalSeparatorType):boolean");
    }

    public final TransformablePage i(TransformablePage transformablePage) {
        int[] e2 = transformablePage.e();
        List listOf = CollectionsKt.listOf(CollectionsKt.first(transformablePage.b()), CollectionsKt.last(transformablePage.b()));
        int d2 = transformablePage.d();
        List c2 = transformablePage.c();
        Integer valueOf = Integer.valueOf(c2 != null ? ((Number) CollectionsKt.first(c2)).intValue() : 0);
        List c3 = transformablePage.c();
        return new TransformablePage(e2, listOf, d2, CollectionsKt.listOf(valueOf, Integer.valueOf(c3 != null ? ((Number) CollectionsKt.last(c3)).intValue() : CollectionsKt.getLastIndex(transformablePage.b()))));
    }
}
