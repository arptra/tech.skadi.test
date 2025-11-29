package com.upuphone.ar.tici.phone.viewmodel;

import java.util.List;
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

@SourceDebugExtension({"SMAP\nSearchFileViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchFileViewModel.kt\ncom/upuphone/ar/tici/phone/viewmodel/SearchFileViewModel$searchFile$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n215#2:67\n216#2:84\n1603#3,9:68\n1855#3:77\n1726#3,3:78\n1856#3:82\n1612#3:83\n1#4:81\n*S KotlinDebug\n*F\n+ 1 SearchFileViewModel.kt\ncom/upuphone/ar/tici/phone/viewmodel/SearchFileViewModel$searchFile$1\n*L\n41#1:67\n41#1:84\n42#1:68,9\n42#1:77\n44#1:78,3\n42#1:82\n42#1:83\n42#1:81\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.viewmodel.SearchFileViewModel$searchFile$1", f = "SearchFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SearchFileViewModel$searchFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $suffixList;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ SearchFileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchFileViewModel$searchFile$1(String str, List<String> list, SearchFileViewModel searchFileViewModel, Continuation<? super SearchFileViewModel$searchFile$1> continuation) {
        super(2, continuation);
        this.$text = str;
        this.$suffixList = list;
        this.this$0 = searchFileViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchFileViewModel$searchFile$1(this.$text, this.$suffixList, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0067 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r24
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            if (r1 != 0) goto L_0x00fd
            kotlin.ResultKt.throwOnFailure(r25)
            java.lang.String r1 = r0.$text
            java.util.List<java.lang.String> r2 = r0.$suffixList
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "searchFile, text: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ", suffixList: "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "SearchFileViewModel"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.b(r1, r2)
            com.upuphone.ar.tici.phone.viewmodel.SearchFileViewModel r1 = r0.this$0
            java.util.Map r1 = r1.b
            if (r1 != 0) goto L_0x003a
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
        L_0x003a:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.List<java.lang.String> r3 = r0.$suffixList
            java.lang.String r10 = r0.$text
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x004b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00f1
            java.lang.Object r4 = r1.next()
            r11 = r4
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r4 = r11.getValue()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Iterator r13 = r4.iterator()
        L_0x0067:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x00e0
            java.lang.Object r4 = r13.next()
            r14 = r4
            com.upuphone.ar.tici.phone.data.SystemFileInfo r14 = (com.upuphone.ar.tici.phone.data.SystemFileInfo) r14
            boolean r4 = r3 instanceof java.util.Collection
            r15 = 0
            if (r4 == 0) goto L_0x0080
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0080
            goto L_0x00d9
        L_0x0080:
            java.util.Iterator r4 = r3.iterator()
        L_0x0084:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00d9
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = r14.getName()
            r7 = 0
            r8 = 2
            boolean r5 = kotlin.text.StringsKt.endsWith$default(r6, r5, r7, r8, r15)
            r5 = r5 ^ 1
            if (r5 != 0) goto L_0x0084
            int r4 = r10.length()
            if (r4 != 0) goto L_0x00a5
            goto L_0x00da
        L_0x00a5:
            boolean r4 = kotlin.text.StringsKt.isBlank(r10)
            if (r4 == 0) goto L_0x00ac
            goto L_0x00da
        L_0x00ac:
            java.lang.String r4 = r14.getName()
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            r5 = r10
            int r4 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r4, (java.lang.String) r5, (int) r6, (boolean) r7, (int) r8, (java.lang.Object) r9)
            if (r4 >= 0) goto L_0x00bc
            goto L_0x00d9
        L_0x00bc:
            com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem r5 = new com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem
            int r6 = r10.length()
            int r6 = r6 + r4
            r5.<init>(r4, r6)
            r22 = 15
            r23 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r21 = r5
            com.upuphone.ar.tici.phone.data.SystemFileInfo r4 = com.upuphone.ar.tici.phone.data.SystemFileInfo.copy$default(r14, r15, r16, r17, r19, r21, r22, r23)
            r14 = r4
            goto L_0x00da
        L_0x00d9:
            r14 = r15
        L_0x00da:
            if (r14 == 0) goto L_0x0067
            r12.add(r14)
            goto L_0x0067
        L_0x00e0:
            boolean r4 = r12.isEmpty()
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x004b
            java.lang.Object r4 = r11.getKey()
            r2.put(r4, r12)
            goto L_0x004b
        L_0x00f1:
            com.upuphone.ar.tici.phone.viewmodel.SearchFileViewModel r0 = r0.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.c
            r0.setValue(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00fd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.viewmodel.SearchFileViewModel$searchFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SearchFileViewModel$searchFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
