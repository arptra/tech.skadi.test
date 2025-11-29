package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PagingDataDiffer$collectFrom$2", f = "PagingDataDiffer.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
public final class PagingDataDiffer$collectFrom$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ PagingData<T> $pagingData;
    int label;
    final /* synthetic */ PagingDataDiffer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataDiffer$collectFrom$2(PagingDataDiffer<T> pagingDataDiffer, PagingData<T> pagingData, Continuation<? super PagingDataDiffer$collectFrom$2> continuation) {
        super(1, continuation);
        this.this$0 = pagingDataDiffer;
        this.$pagingData = pagingData;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new PagingDataDiffer$collectFrom$2(this.this$0, this.$pagingData, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.d = this.$pagingData.c();
            Flow a2 = this.$pagingData.a();
            final PagingDataDiffer<T> pagingDataDiffer = this.this$0;
            final PagingData<T> pagingData = this.$pagingData;
            AnonymousClass1 r1 = new FlowCollector() {

                @SourceDebugExtension({"SMAP\nPagingDataDiffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagingDataDiffer.kt\nandroidx/paging/PagingDataDiffer$collectFrom$2$1$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,548:1\n1726#2,3:549\n1855#2,2:552\n*S KotlinDebug\n*F\n+ 1 PagingDataDiffer.kt\nandroidx/paging/PagingDataDiffer$collectFrom$2$1$2\n*L\n219#1:549,3\n249#1:552,2\n*E\n"})
                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.PagingDataDiffer$collectFrom$2$1$2", f = "PagingDataDiffer.kt", i = {}, l = {159, 169, 186}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.paging.PagingDataDiffer$collectFrom$2$1$2  reason: invalid class name */
                public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass2(pageEvent, pagingDataDiffer, pagingData, continuation);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ff A[LOOP:1: B:82:0x01f9->B:84:0x01ff, LOOP_END] */
                    @org.jetbrains.annotations.Nullable
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
                        /*
                            r10 = this;
                            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r0 = r10.label
                            r1 = 3
                            r2 = 2
                            r3 = 1
                            r4 = 0
                            if (r0 == 0) goto L_0x0024
                            if (r0 == r3) goto L_0x001f
                            if (r0 == r2) goto L_0x001f
                            if (r0 != r1) goto L_0x0017
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L_0x00d5
                        L_0x0017:
                            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                            r0.<init>(r1)
                            throw r0
                        L_0x001f:
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L_0x01e1
                        L_0x0024:
                            kotlin.ResultKt.throwOnFailure(r11)
                            androidx.paging.PageEvent<T> r0 = r6
                            boolean r5 = r0 instanceof androidx.paging.PageEvent.Insert
                            if (r5 == 0) goto L_0x0074
                            androidx.paging.PageEvent$Insert r0 = (androidx.paging.PageEvent.Insert) r0
                            androidx.paging.LoadType r0 = r0.j()
                            androidx.paging.LoadType r5 = androidx.paging.LoadType.REFRESH
                            if (r0 != r5) goto L_0x0074
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            androidx.paging.PageEvent<T> r1 = r6
                            androidx.paging.PageEvent$Insert r1 = (androidx.paging.PageEvent.Insert) r1
                            java.util.List r1 = r1.l()
                            androidx.paging.PageEvent<T> r2 = r6
                            androidx.paging.PageEvent$Insert r2 = (androidx.paging.PageEvent.Insert) r2
                            int r2 = r2.n()
                            androidx.paging.PageEvent<T> r4 = r6
                            androidx.paging.PageEvent$Insert r4 = (androidx.paging.PageEvent.Insert) r4
                            int r4 = r4.m()
                            androidx.paging.PageEvent<T> r5 = r6
                            androidx.paging.PageEvent$Insert r5 = (androidx.paging.PageEvent.Insert) r5
                            androidx.paging.LoadStates r5 = r5.o()
                            androidx.paging.PageEvent<T> r6 = r6
                            androidx.paging.PageEvent$Insert r6 = (androidx.paging.PageEvent.Insert) r6
                            androidx.paging.LoadStates r6 = r6.k()
                            androidx.paging.PagingData<T> r7 = r5
                            androidx.paging.HintReceiver r7 = r7.b()
                            r10.label = r3
                            r8 = 1
                            r3 = r4
                            r4 = r8
                            r8 = r10
                            java.lang.Object r0 = r0.u(r1, r2, r3, r4, r5, r6, r7, r8)
                            if (r0 != r9) goto L_0x01e1
                            return r9
                        L_0x0074:
                            androidx.paging.PageEvent<T> r0 = r6
                            boolean r0 = r0 instanceof androidx.paging.PageEvent.StaticList
                            if (r0 == 0) goto L_0x00c4
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            androidx.paging.TransformablePage r1 = new androidx.paging.TransformablePage
                            androidx.paging.PageEvent<T> r5 = r6
                            androidx.paging.PageEvent$StaticList r5 = (androidx.paging.PageEvent.StaticList) r5
                            java.util.List r5 = r5.g()
                            r1.<init>(r4, r5)
                            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
                            androidx.paging.PageEvent<T> r5 = r6
                            androidx.paging.PageEvent$StaticList r5 = (androidx.paging.PageEvent.StaticList) r5
                            androidx.paging.LoadStates r5 = r5.i()
                            if (r5 != 0) goto L_0x00a1
                            androidx.paging.PageEvent<T> r5 = r6
                            androidx.paging.PageEvent$StaticList r5 = (androidx.paging.PageEvent.StaticList) r5
                            androidx.paging.LoadStates r5 = r5.h()
                            if (r5 == 0) goto L_0x00a2
                        L_0x00a1:
                            r4 = r3
                        L_0x00a2:
                            androidx.paging.PageEvent<T> r3 = r6
                            androidx.paging.PageEvent$StaticList r3 = (androidx.paging.PageEvent.StaticList) r3
                            androidx.paging.LoadStates r5 = r3.i()
                            androidx.paging.PageEvent<T> r3 = r6
                            androidx.paging.PageEvent$StaticList r3 = (androidx.paging.PageEvent.StaticList) r3
                            androidx.paging.LoadStates r6 = r3.h()
                            androidx.paging.PagingData<T> r3 = r5
                            androidx.paging.HintReceiver r7 = r3.b()
                            r10.label = r2
                            r2 = 0
                            r3 = 0
                            r8 = r10
                            java.lang.Object r0 = r0.u(r1, r2, r3, r4, r5, r6, r7, r8)
                            if (r0 != r9) goto L_0x01e1
                            return r9
                        L_0x00c4:
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            boolean r0 = r0.s()
                            if (r0 == 0) goto L_0x00d5
                            r10.label = r1
                            java.lang.Object r0 = kotlinx.coroutines.YieldKt.a(r10)
                            if (r0 != r9) goto L_0x00d5
                            return r9
                        L_0x00d5:
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            androidx.paging.PagePresenter r0 = r0.e
                            androidx.paging.PageEvent<T> r1 = r6
                            androidx.paging.PagingDataDiffer<T> r2 = r3
                            androidx.paging.PagingDataDiffer$processPageEventCallback$1 r2 = r2.k
                            r0.n(r1, r2)
                            androidx.paging.PageEvent<T> r0 = r6
                            boolean r0 = r0 instanceof androidx.paging.PageEvent.Drop
                            if (r0 == 0) goto L_0x00f1
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            r0.i = r4
                        L_0x00f1:
                            androidx.paging.PageEvent<T> r0 = r6
                            boolean r0 = r0 instanceof androidx.paging.PageEvent.Insert
                            if (r0 == 0) goto L_0x01e1
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            androidx.paging.MutableCombinedLoadStateCollection r0 = r0.f
                            kotlinx.coroutines.flow.StateFlow r0 = r0.e()
                            java.lang.Object r0 = r0.getValue()
                            androidx.paging.CombinedLoadStates r0 = (androidx.paging.CombinedLoadStates) r0
                            if (r0 == 0) goto L_0x010e
                            androidx.paging.LoadStates r0 = r0.e()
                            goto L_0x010f
                        L_0x010e:
                            r0 = 0
                        L_0x010f:
                            if (r0 == 0) goto L_0x01d5
                            androidx.paging.LoadState r1 = r0.e()
                            boolean r1 = r1.a()
                            androidx.paging.LoadState r0 = r0.d()
                            boolean r0 = r0.a()
                            androidx.paging.PageEvent<T> r2 = r6
                            androidx.paging.PageEvent$Insert r2 = (androidx.paging.PageEvent.Insert) r2
                            androidx.paging.LoadType r2 = r2.j()
                            androidx.paging.LoadType r5 = androidx.paging.LoadType.PREPEND
                            if (r2 != r5) goto L_0x012f
                            if (r1 != 0) goto L_0x013e
                        L_0x012f:
                            androidx.paging.PageEvent<T> r1 = r6
                            androidx.paging.PageEvent$Insert r1 = (androidx.paging.PageEvent.Insert) r1
                            androidx.paging.LoadType r1 = r1.j()
                            androidx.paging.LoadType r2 = androidx.paging.LoadType.APPEND
                            if (r1 != r2) goto L_0x0140
                            if (r0 != 0) goto L_0x013e
                            goto L_0x0140
                        L_0x013e:
                            r0 = r4
                            goto L_0x0141
                        L_0x0140:
                            r0 = r3
                        L_0x0141:
                            androidx.paging.PageEvent<T> r1 = r6
                            androidx.paging.PageEvent$Insert r1 = (androidx.paging.PageEvent.Insert) r1
                            java.util.List r1 = r1.l()
                            boolean r2 = r1 instanceof java.util.Collection
                            if (r2 == 0) goto L_0x0154
                            boolean r2 = r1.isEmpty()
                            if (r2 == 0) goto L_0x0154
                            goto L_0x016f
                        L_0x0154:
                            java.util.Iterator r1 = r1.iterator()
                        L_0x0158:
                            boolean r2 = r1.hasNext()
                            if (r2 == 0) goto L_0x016f
                            java.lang.Object r2 = r1.next()
                            androidx.paging.TransformablePage r2 = (androidx.paging.TransformablePage) r2
                            java.util.List r2 = r2.b()
                            boolean r2 = r2.isEmpty()
                            if (r2 != 0) goto L_0x0158
                            r3 = r4
                        L_0x016f:
                            if (r0 != 0) goto L_0x0177
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            r0.i = r4
                            goto L_0x01e1
                        L_0x0177:
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            boolean r0 = r0.i
                            if (r0 != 0) goto L_0x0181
                            if (r3 == 0) goto L_0x01e1
                        L_0x0181:
                            if (r3 != 0) goto L_0x01b9
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            int r0 = r0.j
                            androidx.paging.PagingDataDiffer<T> r1 = r3
                            androidx.paging.PagePresenter r1 = r1.e
                            int r1 = r1.d()
                            if (r0 < r1) goto L_0x01b9
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            int r0 = r0.j
                            androidx.paging.PagingDataDiffer<T> r1 = r3
                            androidx.paging.PagePresenter r1 = r1.e
                            int r1 = r1.d()
                            androidx.paging.PagingDataDiffer<T> r2 = r3
                            androidx.paging.PagePresenter r2 = r2.e
                            int r2 = r2.c()
                            int r1 = r1 + r2
                            if (r0 <= r1) goto L_0x01b3
                            goto L_0x01b9
                        L_0x01b3:
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            r0.i = r4
                            goto L_0x01e1
                        L_0x01b9:
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            androidx.paging.HintReceiver r0 = r0.c
                            if (r0 == 0) goto L_0x01e1
                            androidx.paging.PagingDataDiffer<T> r1 = r3
                            androidx.paging.PagePresenter r1 = r1.e
                            androidx.paging.PagingDataDiffer<T> r2 = r3
                            int r2 = r2.j
                            androidx.paging.ViewportHint$Access r1 = r1.a(r2)
                            r0.a(r1)
                            goto L_0x01e1
                        L_0x01d5:
                            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                            java.lang.String r1 = "PagingDataDiffer.combinedLoadStatesCollection.stateFlow shouldnot hold null CombinedLoadStates after Insert event."
                            java.lang.String r1 = r1.toString()
                            r0.<init>(r1)
                            throw r0
                        L_0x01e1:
                            androidx.paging.PageEvent<T> r0 = r6
                            boolean r1 = r0 instanceof androidx.paging.PageEvent.Insert
                            if (r1 != 0) goto L_0x01ef
                            boolean r1 = r0 instanceof androidx.paging.PageEvent.Drop
                            if (r1 != 0) goto L_0x01ef
                            boolean r0 = r0 instanceof androidx.paging.PageEvent.StaticList
                            if (r0 == 0) goto L_0x0209
                        L_0x01ef:
                            androidx.paging.PagingDataDiffer<T> r0 = r3
                            java.util.concurrent.CopyOnWriteArrayList r0 = r0.g
                            java.util.Iterator r0 = r0.iterator()
                        L_0x01f9:
                            boolean r1 = r0.hasNext()
                            if (r1 == 0) goto L_0x0209
                            java.lang.Object r1 = r0.next()
                            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
                            r1.invoke()
                            goto L_0x01f9
                        L_0x0209:
                            kotlin.Unit r0 = kotlin.Unit.INSTANCE
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataDiffer$collectFrom$2.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* renamed from: d */
                public final Object emit(final PageEvent pageEvent, Continuation continuation) {
                    Logger a2 = LoggerKt.a();
                    if (a2 != null && a2.b(2)) {
                        a2.a(2, "Collected " + pageEvent, (Throwable) null);
                    }
                    CoroutineContext f = pagingDataDiffer.b;
                    final PagingDataDiffer pagingDataDiffer = pagingDataDiffer;
                    final PagingData pagingData = pagingData;
                    Object g = BuildersKt.g(f, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), continuation);
                    return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (a2.collect(r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((PagingDataDiffer$collectFrom$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
