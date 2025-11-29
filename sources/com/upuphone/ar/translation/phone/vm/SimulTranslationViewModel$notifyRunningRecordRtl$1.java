package com.upuphone.ar.translation.phone.vm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.SimulTranslationViewModel$notifyRunningRecordRtl$1", f = "SimulTranslationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SimulTranslationViewModel$notifyRunningRecordRtl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SimulTranslationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimulTranslationViewModel$notifyRunningRecordRtl$1(SimulTranslationViewModel simulTranslationViewModel, Continuation<? super SimulTranslationViewModel$notifyRunningRecordRtl$1> continuation) {
        super(2, continuation);
        this.this$0 = simulTranslationViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SimulTranslationViewModel$notifyRunningRecordRtl$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cd A[EDGE_INSN: B:33:0x00cd->B:27:0x00cd ?: BREAK  , SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            if (r0 != 0) goto L_0x00d0
            kotlin.ResultKt.throwOnFailure(r5)
            com.upuphone.ar.translation.phone.vm.SimulTranslationViewModel r5 = r4.this$0
            androidx.lifecycle.MutableLiveData r5 = r5.c
            java.lang.Object r5 = r5.getValue()
            com.upuphone.ar.translation.phone.bean.TranslationLanguage r5 = (com.upuphone.ar.translation.phone.bean.TranslationLanguage) r5
            if (r5 == 0) goto L_0x00cd
            com.upuphone.ar.translation.phone.vm.SimulTranslationViewModel r4 = r4.this$0
            com.upuphone.ar.translation.phone.bean.LanguageBean r0 = r5.getSrc()
            java.lang.String r0 = r0.getLangType()
            java.lang.String r1 = "ar"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x003a
            com.upuphone.ar.translation.phone.bean.LanguageBean r5 = r5.getDst()
            java.lang.String r5 = r5.getLangType()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
            if (r5 != 0) goto L_0x003a
            goto L_0x00cd
        L_0x003a:
            androidx.lifecycle.MutableLiveData r5 = r4.d
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 != 0) goto L_0x004b
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
        L_0x004b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0056
            goto L_0x00cd
        L_0x0056:
            com.upuphone.ar.translation.phone.TranslationManager$Companion r5 = com.upuphone.ar.translation.phone.TranslationManager.q
            com.upuphone.ar.translation.phone.TranslationManager r5 = r5.a()
            com.upuphone.ar.translation.phone.helper.RunningRecordHelper r5 = r5.o()
            if (r5 == 0) goto L_0x00cd
            java.util.List r5 = r5.f()
            if (r5 == 0) goto L_0x00cd
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x006f
            goto L_0x00cd
        L_0x006f:
            java.util.Iterator r5 = r5.iterator()
        L_0x0073:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00cd
            java.lang.Object r0 = r5.next()
            com.upuphone.ar.translation.phone.bean.SimulRunning r0 = (com.upuphone.ar.translation.phone.bean.SimulRunning) r0
            java.lang.String r1 = r0.getSrc()
            java.lang.String r2 = r0.getTempSrc()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = r0.getDst()
            java.lang.String r0 = r0.getTempDst()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)
            java.lang.String r0 = r0.toString()
            boolean r1 = com.upuphone.ar.translation.ext.StringExtKt.b(r1)
            if (r1 != 0) goto L_0x00c9
            boolean r0 = com.upuphone.ar.translation.ext.StringExtKt.b(r0)
            if (r0 == 0) goto L_0x0073
        L_0x00c9:
            r5 = 1
            r4.t(r5)
        L_0x00cd:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x00d0:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.SimulTranslationViewModel$notifyRunningRecordRtl$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SimulTranslationViewModel$notifyRunningRecordRtl$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
