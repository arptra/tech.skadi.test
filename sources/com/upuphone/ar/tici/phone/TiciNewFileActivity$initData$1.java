package com.upuphone.ar.tici.phone;

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

@SourceDebugExtension({"SMAP\nTiciNewFileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciNewFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciNewFileActivity$initData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,325:1\n1864#2,3:326\n*S KotlinDebug\n*F\n+ 1 TiciNewFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciNewFileActivity$initData$1\n*L\n157#1:326,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciNewFileActivity$initData$1", f = "TiciNewFileActivity.kt", i = {2, 3, 3}, l = {134, 143, 156, 166}, m = "invokeSuspend", n = {"loadingDialog", "loadingDialog", "index$iv"}, s = {"L$0", "L$0", "I$0"})
public final class TiciNewFileActivity$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $id;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TiciNewFileActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciNewFileActivity$initData$1(long j, TiciNewFileActivity ticiNewFileActivity, Continuation<? super TiciNewFileActivity$initData$1> continuation) {
        super(2, continuation);
        this.$id = j;
        this.this$0 = ticiNewFileActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciNewFileActivity$initData$1(this.$id, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x018a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 0
            r7 = 2
            r8 = 1
            java.lang.String r9 = "TiciNewFileActivity"
            if (r2 == 0) goto L_0x004e
            if (r2 == r8) goto L_0x0048
            if (r2 == r7) goto L_0x0041
            if (r2 == r5) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            int r2 = r0.I$0
            java.lang.Object r3 = r0.L$2
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r5 = r0.L$1
            com.upuphone.ar.tici.phone.TiciNewFileActivity r5 = (com.upuphone.ar.tici.phone.TiciNewFileActivity) r5
            java.lang.Object r6 = r0.L$0
            com.meizu.common.app.LoadingDialog r6 = (com.meizu.common.app.LoadingDialog) r6
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x0121
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.meizu.common.app.LoadingDialog r2 = (com.meizu.common.app.LoadingDialog) r2
            kotlin.ResultKt.throwOnFailure(r21)
            r6 = r2
            r2 = r21
            goto L_0x0114
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r21)
            r2 = r21
            goto L_0x00d4
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r21)
            r2 = r21
            goto L_0x0078
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r21)
            long r10 = r0.$id
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = "initData, id: "
            r2.append(r12)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r9)
            com.upuphone.ar.tici.phone.TiciApp r2 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r2 = r2.w()
            long r10 = r0.$id
            r0.label = r8
            java.lang.Object r2 = r2.q(r10, r0)
            if (r2 != r1) goto L_0x0078
            return r1
        L_0x0078:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r2 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r2
            if (r2 != 0) goto L_0x0095
            long r0 = r0.$id
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "can`t found ticiEntity for: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r9, r6, r7, r6)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0095:
            java.lang.String r8 = r2.toSimpleString()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "initData, ticiEntity: "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r8, r9)
            com.upuphone.ar.tici.phone.TiciNewFileActivity r8 = r0.this$0
            r8.c = r2
            com.upuphone.ar.tici.phone.TiciNewFileActivity r8 = r0.this$0
            com.upuphone.ar.tici.databinding.ActivityNewTiciFileBinding r8 = r8.F0()
            android.widget.EditText r8 = r8.c
            java.lang.String r10 = r2.getFileName()
            r8.setText(r10)
            com.upuphone.ar.tici.phone.TiciApp r8 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r8 = r8.w()
            long r10 = r2.getId()
            r0.label = r7
            java.lang.Object r2 = r8.a(r10, r0)
            if (r2 != r1) goto L_0x00d4
            return r1
        L_0x00d4:
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            com.upuphone.ar.tici.phone.TiciNewFileActivity$initData$1$sourceText$1 r16 = com.upuphone.ar.tici.phone.TiciNewFileActivity$initData$1$sourceText$1.INSTANCE
            r17 = 30
            r18 = 0
            java.lang.String r11 = ""
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r2 = kotlin.collections.CollectionsKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            com.upuphone.ar.tici.phone.TiciNewFileActivity r7 = r0.this$0
            r7.d = r2
            int r7 = r2.length()
            r8 = 10000(0x2710, float:1.4013E-41)
            if (r7 <= r8) goto L_0x018a
            com.upuphone.ar.tici.phone.TiciNewFileActivity r7 = r0.this$0
            int r10 = com.upuphone.ar.tici.R.string.tici_loading
            java.lang.String r10 = r7.getString(r10)
            com.meizu.common.app.LoadingDialog r6 = com.meizu.common.app.LoadingDialog.show(r7, r6, r10, r3)
            r7 = 60001(0xea61, float:8.408E-41)
            java.lang.String r2 = com.upuphone.ar.tici.phone.utils.StringExtKt.j(r2, r7)
            com.upuphone.ar.tici.phone.utils.TiciHelper r7 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r2 = r7.n(r2, r8, r0)
            if (r2 != r1) goto L_0x0114
            return r1
        L_0x0114:
            java.util.List r2 = (java.util.List) r2
            com.upuphone.ar.tici.phone.TiciNewFileActivity r5 = r0.this$0
            java.util.Iterator r2 = r2.iterator()
            r19 = r3
            r3 = r2
            r2 = r19
        L_0x0121:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0186
            java.lang.Object r7 = r3.next()
            int r8 = r2 + 1
            if (r2 >= 0) goto L_0x0132
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0132:
            java.lang.String r7 = (java.lang.String) r7
            if (r2 != 0) goto L_0x0154
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "initData, setText part: "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r9)
            com.upuphone.ar.tici.databinding.ActivityNewTiciFileBinding r2 = r5.F0()
            android.widget.EditText r2 = r2.b
            r2.setText(r7)
            goto L_0x0171
        L_0x0154:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "initData, append part: "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r9)
            com.upuphone.ar.tici.databinding.ActivityNewTiciFileBinding r2 = r5.F0()
            android.widget.EditText r2 = r2.b
            r2.append(r7)
        L_0x0171:
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r3
            r0.I$0 = r8
            r0.label = r4
            r10 = 1
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r10, r0)
            if (r2 != r1) goto L_0x0184
            return r1
        L_0x0184:
            r2 = r8
            goto L_0x0121
        L_0x0186:
            r6.dismiss()
            goto L_0x019a
        L_0x018a:
            com.upuphone.ar.tici.phone.TiciNewFileActivity r0 = r0.this$0
            com.upuphone.ar.tici.databinding.ActivityNewTiciFileBinding r0 = r0.F0()
            android.widget.EditText r0 = r0.b
            r0.setText(r2)
            java.lang.String r0 = "initData, setText all"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r0, r9)
        L_0x019a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciNewFileActivity$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciNewFileActivity$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
