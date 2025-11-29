package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nPagingDataDiffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagingDataDiffer.kt\nandroidx/paging/PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1\n+ 2 Logger.kt\nandroidx/paging/LoggerKt\n+ 3 LogUtil.kt\nandroidx/paging/internal/LogUtilKt\n*L\n1#1,548:1\n41#2,8:549\n50#2:562\n27#3,5:557\n*S KotlinDebug\n*F\n+ 1 PagingDataDiffer.kt\nandroidx/paging/PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1\n*L\n468#1:549,8\n468#1:562\n469#1:557,5\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LoadStates $mediatorLoadStates;
    final /* synthetic */ HintReceiver $newHintReceiver;
    final /* synthetic */ PagePresenter<T> $newPresenter;
    final /* synthetic */ Ref.BooleanRef $onListPresentableCalled;
    final /* synthetic */ List<TransformablePage<T>> $pages;
    final /* synthetic */ int $placeholdersAfter;
    final /* synthetic */ int $placeholdersBefore;
    final /* synthetic */ LoadStates $sourceLoadStates;
    final /* synthetic */ PagingDataDiffer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1(PagingDataDiffer<T> pagingDataDiffer, PagePresenter<T> pagePresenter, Ref.BooleanRef booleanRef, HintReceiver hintReceiver, LoadStates loadStates, List<TransformablePage<T>> list, int i, int i2, LoadStates loadStates2) {
        super(0);
        this.this$0 = pagingDataDiffer;
        this.$newPresenter = pagePresenter;
        this.$onListPresentableCalled = booleanRef;
        this.$newHintReceiver = hintReceiver;
        this.$mediatorLoadStates = loadStates;
        this.$pages = list;
        this.$placeholdersBefore = i;
        this.$placeholdersAfter = i2;
        this.$sourceLoadStates = loadStates2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003f, code lost:
        r9 = r9.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r11 = this;
            androidx.paging.PagingDataDiffer<T> r0 = r11.this$0
            androidx.paging.PagePresenter<T> r1 = r11.$newPresenter
            r0.e = r1
            kotlin.jvm.internal.Ref$BooleanRef r0 = r11.$onListPresentableCalled
            r1 = 1
            r0.element = r1
            androidx.paging.PagingDataDiffer<T> r0 = r11.this$0
            androidx.paging.HintReceiver r2 = r11.$newHintReceiver
            r0.c = r2
            androidx.paging.LoadStates r0 = r11.$mediatorLoadStates
            java.util.List<androidx.paging.TransformablePage<T>> r2 = r11.$pages
            int r3 = r11.$placeholdersBefore
            int r4 = r11.$placeholdersAfter
            androidx.paging.HintReceiver r5 = r11.$newHintReceiver
            androidx.paging.LoadStates r11 = r11.$sourceLoadStates
            androidx.paging.Logger r6 = androidx.paging.LoggerKt.a()
            if (r6 == 0) goto L_0x00c6
            r7 = 3
            boolean r8 = r6.b(r7)
            if (r8 != r1) goto L_0x00c6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Presenting data:\n                            |   first item: "
            r8.append(r9)
            java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            androidx.paging.TransformablePage r9 = (androidx.paging.TransformablePage) r9
            r10 = 0
            if (r9 == 0) goto L_0x004a
            java.util.List r9 = r9.b()
            if (r9 == 0) goto L_0x004a
            java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
            goto L_0x004b
        L_0x004a:
            r9 = r10
        L_0x004b:
            r8.append(r9)
            java.lang.String r9 = "\n                            |   last item: "
            r8.append(r9)
            java.lang.Object r2 = kotlin.collections.CollectionsKt.lastOrNull(r2)
            androidx.paging.TransformablePage r2 = (androidx.paging.TransformablePage) r2
            if (r2 == 0) goto L_0x0066
            java.util.List r2 = r2.b()
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = kotlin.collections.CollectionsKt.lastOrNull(r2)
            goto L_0x0067
        L_0x0066:
            r2 = r10
        L_0x0067:
            r8.append(r2)
            java.lang.String r2 = "\n                            |   placeholdersBefore: "
            r8.append(r2)
            r8.append(r3)
            java.lang.String r2 = "\n                            |   placeholdersAfter: "
            r8.append(r2)
            r8.append(r4)
            java.lang.String r2 = "\n                            |   hintReceiver: "
            r8.append(r2)
            r8.append(r5)
            java.lang.String r2 = "\n                            |   sourceLoadStates: "
            r8.append(r2)
            r8.append(r11)
            java.lang.String r11 = "\n                        "
            r8.append(r11)
            java.lang.String r11 = r8.toString()
            if (r0 == 0) goto L_0x00ae
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            java.lang.String r11 = "|   mediatorLoadStates: "
            r2.append(r11)
            r2.append(r0)
            r11 = 10
            r2.append(r11)
            java.lang.String r11 = r2.toString()
        L_0x00ae:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = "|)"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.String r11 = kotlin.text.StringsKt.trimMargin$default(r11, r10, r1, r10)
            r6.a(r7, r11, r10)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1.invoke():void");
    }
}
