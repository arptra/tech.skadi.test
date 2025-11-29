package androidx.paging;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JG\u0010\n\u001a\u0004\u0018\u00010\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"androidx/paging/AsyncPagingDataDiffer$differBase$1", "Landroidx/paging/PagingDataDiffer;", "Landroidx/paging/NullPaddedList;", "previousList", "newList", "", "lastAccessedIndex", "Lkotlin/Function0;", "", "onListPresentable", "t", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "s", "()Z", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class AsyncPagingDataDiffer$differBase$1 extends PagingDataDiffer<Object> {
    public final /* synthetic */ AsyncPagingDataDiffer m;

    public boolean s() {
        return this.m.g();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: androidx.paging.NullPaddedList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: androidx.paging.NullPaddedList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object t(androidx.paging.NullPaddedList r7, androidx.paging.NullPaddedList r8, int r9, kotlin.jvm.functions.Function0 r10, kotlin.coroutines.Continuation r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1 r0 = (androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1 r0 = new androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$1
            r0.<init>(r6, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            int r9 = r0.I$0
            java.lang.Object r6 = r0.L$3
            r10 = r6
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            java.lang.Object r6 = r0.L$2
            r8 = r6
            androidx.paging.NullPaddedList r8 = (androidx.paging.NullPaddedList) r8
            java.lang.Object r6 = r0.L$1
            r7 = r6
            androidx.paging.NullPaddedList r7 = (androidx.paging.NullPaddedList) r7
            java.lang.Object r6 = r0.L$0
            androidx.paging.AsyncPagingDataDiffer$differBase$1 r6 = (androidx.paging.AsyncPagingDataDiffer$differBase$1) r6
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0099
        L_0x003e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r11)
            int r11 = r7.b()
            r2 = 0
            r4 = 0
            if (r11 != 0) goto L_0x0062
            r10.invoke()
            androidx.paging.AsyncPagingDataDiffer r6 = r6.m
            androidx.paging.DifferCallback r6 = r6.f()
            int r7 = r8.b()
            r6.onInserted(r2, r7)
            goto L_0x00af
        L_0x0062:
            int r11 = r8.b()
            if (r11 != 0) goto L_0x0079
            r10.invoke()
            androidx.paging.AsyncPagingDataDiffer r6 = r6.m
            androidx.paging.DifferCallback r6 = r6.f()
            int r7 = r7.b()
            r6.onRemoved(r2, r7)
            goto L_0x00af
        L_0x0079:
            androidx.paging.AsyncPagingDataDiffer r11 = r6.m
            kotlin.coroutines.CoroutineContext r11 = r11.c
            androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 r2 = new androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1
            androidx.paging.AsyncPagingDataDiffer r5 = r6.m
            r2.<init>(r7, r8, r5, r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.L$3 = r10
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r2, r0)
            if (r11 != r1) goto L_0x0099
            return r1
        L_0x0099:
            androidx.paging.NullPaddedDiffResult r11 = (androidx.paging.NullPaddedDiffResult) r11
            r10.invoke()
            androidx.paging.AsyncPagingDataDiffer r6 = r6.m
            androidx.recyclerview.widget.ListUpdateCallback r6 = r6.b
            androidx.paging.NullPaddedListDiffHelperKt.b(r7, r6, r8, r11)
            int r6 = androidx.paging.NullPaddedListDiffHelperKt.c(r7, r11, r8, r9)
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
        L_0x00af:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.AsyncPagingDataDiffer$differBase$1.t(androidx.paging.NullPaddedList, androidx.paging.NullPaddedList, int, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
