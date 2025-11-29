package com.upuphone.ar.tici.phone.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nImportFileViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportFileViewModel.kt\ncom/upuphone/ar/tici/phone/viewmodel/ImportFileViewModel$scanTxtFiles$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,117:1\n1054#2:118\n1549#2:119\n1620#2,3:120\n1477#2:123\n1502#2,3:124\n1505#2,3:134\n372#3,7:127\n*S KotlinDebug\n*F\n+ 1 ImportFileViewModel.kt\ncom/upuphone/ar/tici/phone/viewmodel/ImportFileViewModel$scanTxtFiles$1\n*L\n70#1:118\n73#1:119\n73#1:120,3\n83#1:123\n83#1:124,3\n83#1:134,3\n83#1:127,7\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel$scanTxtFiles$1", f = "ImportFileViewModel.kt", i = {0}, l = {60, 65}, m = "invokeSuspend", n = {"dirList"}, s = {"L$0"})
public final class ImportFileViewModel$scanTxtFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ImportFileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportFileViewModel$scanTxtFiles$1(ImportFileViewModel importFileViewModel, Continuation<? super ImportFileViewModel$scanTxtFiles$1> continuation) {
        super(2, continuation);
        this.this$0 = importFileViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImportFileViewModel$scanTxtFiles$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e2 A[Catch:{ Exception -> 0x001c }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011c A[LOOP:0: B:40:0x0116->B:42:0x011c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016e  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            java.lang.String r3 = "getAbsolutePath(...)"
            r4 = 1
            r5 = 2
            java.lang.String r6 = "ImportFileViewModel"
            r7 = 0
            if (r2 == 0) goto L_0x0037
            if (r2 == r4) goto L_0x0027
            if (r2 != r5) goto L_0x001f
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ Exception -> 0x001c }
            r2 = r18
            goto L_0x00e3
        L_0x001c:
            r0 = move-exception
            goto L_0x00e6
        L_0x001f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0027:
            java.lang.Object r2 = r1.L$1
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r4 = r1.L$0
            java.util.Set r4 = (java.util.Set) r4
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ Exception -> 0x001c }
            r8 = r4
            r4 = r18
            goto L_0x00ab
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r18)
            com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel r2 = r1.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.e
            java.lang.Object r2 = r2.getValue()
            boolean r8 = r2 instanceof com.upuphone.ar.tici.phone.data.ScanFileState.Success
            if (r8 == 0) goto L_0x004b
            com.upuphone.ar.tici.phone.data.ScanFileState$Success r2 = (com.upuphone.ar.tici.phone.data.ScanFileState.Success) r2
            goto L_0x004c
        L_0x004b:
            r2 = r7
        L_0x004c:
            if (r2 == 0) goto L_0x0053
            java.util.Map r2 = r2.a()
            goto L_0x0054
        L_0x0053:
            r2 = r7
        L_0x0054:
            if (r2 == 0) goto L_0x0063
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x005d
            goto L_0x0063
        L_0x005d:
            java.lang.String r2 = "asyncScanTxtFiles-> 已经有文件不显示loading"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r6)
            goto L_0x006e
        L_0x0063:
            com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel r2 = r1.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.e
            com.upuphone.ar.tici.phone.data.ScanFileState$Loading r8 = com.upuphone.ar.tici.phone.data.ScanFileState.Loading.f5915a
            r2.setValue(r8)
        L_0x006e:
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet     // Catch:{ Exception -> 0x001c }
            r2.<init>()     // Catch:{ Exception -> 0x001c }
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x001c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001c }
            r9.<init>()     // Catch:{ Exception -> 0x001c }
            java.lang.String r10 = "scanTxtFiles, rootPath: "
            r9.append(r10)     // Catch:{ Exception -> 0x001c }
            r9.append(r8)     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x001c }
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r9, r6)     // Catch:{ Exception -> 0x001c }
            java.lang.String r9 = r8.getAbsolutePath()     // Catch:{ Exception -> 0x001c }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)     // Catch:{ Exception -> 0x001c }
            r2.add(r9)     // Catch:{ Exception -> 0x001c }
            java.io.File r8 = r8.getParentFile()     // Catch:{ Exception -> 0x001c }
            if (r8 == 0) goto L_0x00b5
            com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel r9 = r1.this$0     // Catch:{ Exception -> 0x001c }
            r1.L$0 = r2     // Catch:{ Exception -> 0x001c }
            r1.L$1 = r2     // Catch:{ Exception -> 0x001c }
            r1.label = r4     // Catch:{ Exception -> 0x001c }
            java.lang.Object r4 = r9.l(r8, r1)     // Catch:{ Exception -> 0x001c }
            if (r4 != r0) goto L_0x00aa
            return r0
        L_0x00aa:
            r8 = r2
        L_0x00ab:
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ Exception -> 0x001c }
            boolean r2 = r2.addAll(r4)     // Catch:{ Exception -> 0x001c }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)     // Catch:{ Exception -> 0x001c }
            r2 = r8
        L_0x00b5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001c }
            r4.<init>()     // Catch:{ Exception -> 0x001c }
            java.lang.String r8 = "scanTxtFiles, start with dirList: "
            r4.append(r8)     // Catch:{ Exception -> 0x001c }
            r4.append(r2)     // Catch:{ Exception -> 0x001c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x001c }
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r4, r6)     // Catch:{ Exception -> 0x001c }
            com.upuphone.ar.tici.phone.utils.FileScanner r4 = new com.upuphone.ar.tici.phone.utils.FileScanner     // Catch:{ Exception -> 0x001c }
            r4.<init>()     // Catch:{ Exception -> 0x001c }
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)     // Catch:{ Exception -> 0x001c }
            java.util.List r8 = com.upuphone.ar.tici.phone.utils.ConstantsKt.j()     // Catch:{ Exception -> 0x001c }
            r1.L$0 = r7     // Catch:{ Exception -> 0x001c }
            r1.L$1 = r7     // Catch:{ Exception -> 0x001c }
            r1.label = r5     // Catch:{ Exception -> 0x001c }
            java.lang.Object r2 = r4.d(r2, r8, r1)     // Catch:{ Exception -> 0x001c }
            if (r2 != r0) goto L_0x00e3
            return r0
        L_0x00e3:
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x001c }
            goto L_0x00fe
        L_0x00e6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "scanTxtFiles, error: "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r6, r7, r5, r7)
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00fe:
            com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel$scanTxtFiles$1$invokeSuspend$$inlined$sortedByDescending$1 r0 = new com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel$scanTxtFiles$1$invokeSuspend$$inlined$sortedByDescending$1
            r0.<init>()
            java.util.List r0 = kotlin.collections.CollectionsKt.sortedWith(r2, r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r4)
            r2.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0116:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x015d
            java.lang.Object r4 = r0.next()
            java.io.File r4 = (java.io.File) r4
            com.upuphone.ar.tici.phone.data.SystemFileInfo r5 = new com.upuphone.ar.tici.phone.data.SystemFileInfo
            java.lang.String r8 = r4.getName()
            java.lang.String r7 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            java.lang.String r9 = r4.getAbsolutePath()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            long r10 = r4.length()
            long r12 = r4.lastModified()
            r15 = 16
            r16 = 0
            r14 = 0
            r7 = r5
            r7.<init>(r8, r9, r10, r12, r14, r15, r16)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "asyncScanTxtFiles: "
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r4, r6)
            r2.add(r5)
            goto L_0x0116
        L_0x015d:
            com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel r0 = r1.this$0
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0168:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x01b5
            java.lang.Object r4 = r2.next()
            r5 = r4
            com.upuphone.ar.tici.phone.data.SystemFileInfo r5 = (com.upuphone.ar.tici.phone.data.SystemFileInfo) r5
            long r7 = r5.getUpdateTime()
            android.app.Application r9 = r0.c()
            java.lang.String r5 = "getApplication(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            java.time.LocalDate r10 = r0.b
            java.lang.String r5 = "access$getToday$p(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)
            java.time.LocalDate r11 = r0.c
            java.lang.String r5 = "access$getRecentWeek$p(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            java.time.LocalDate r12 = r0.d
            java.lang.String r5 = "access$getRecentMonth$p(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r5)
            java.lang.String r5 = com.upuphone.ar.tici.phone.utils.DateTimeExtKt.a(r7, r9, r10, r11, r12)
            java.lang.Object r7 = r3.get(r5)
            if (r7 != 0) goto L_0x01af
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r3.put(r5, r7)
        L_0x01af:
            java.util.List r7 = (java.util.List) r7
            r7.add(r4)
            goto L_0x0168
        L_0x01b5:
            com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel r0 = r1.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.g
            r0.setValue(r3)
            com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel r0 = r1.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.e
            com.upuphone.ar.tici.phone.data.ScanFileState$Success r1 = new com.upuphone.ar.tici.phone.data.ScanFileState$Success
            r1.<init>(r3)
            r0.setValue(r1)
            java.lang.String r0 = "scanTxtFiles: end"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r0, r6)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel$scanTxtFiles$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImportFileViewModel$scanTxtFiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
