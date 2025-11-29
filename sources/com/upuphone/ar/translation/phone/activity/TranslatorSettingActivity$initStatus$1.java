package com.upuphone.ar.translation.phone.activity;

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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1", f = "TranslatorSettingActivity.kt", i = {}, l = {131, 135, 147, 157, 161, 166, 171}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorSettingActivity$initStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TranslatorSettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSettingActivity$initStatus$1(TranslatorSettingActivity translatorSettingActivity, Continuation<? super TranslatorSettingActivity$initStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorSettingActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorSettingActivity$initStatus$1(this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        r1.setSettingChecked(((java.lang.Boolean) r6).booleanValue());
        r1 = r5.this$0;
        r6 = kotlinx.coroutines.Dispatchers.b();
        r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass2>) null);
        r5.L$0 = r1;
        r5.label = 2;
        r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008c, code lost:
        if (r6 != r0) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008f, code lost:
        r1.selectOtherSub(((java.lang.Number) r6).intValue(), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009d, code lost:
        if (com.upuphone.ar.translation.constants.TranslatorConstants.isAirPro() != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a1, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a2, code lost:
        r6 = com.upuphone.xr.sapp.context.SdkContext.f6675a.f().a(r5.this$0.locationPermissions);
        r1 = r5.this$0.getMBinding().i;
        r3 = kotlinx.coroutines.Dispatchers.b();
        r4 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass3((kotlin.coroutines.Continuation<? super com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass3>) null);
        r5.L$0 = r1;
        r5.label = 3;
        r6 = kotlinx.coroutines.BuildersKt.g(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cc, code lost:
        if (r6 != r0) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ce, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cf, code lost:
        r1.setSettingChecked(((java.lang.Boolean) r6).booleanValue());
        r1 = r5.this$0.getMBinding().h;
        r6 = kotlinx.coroutines.Dispatchers.b();
        r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass4((kotlin.coroutines.Continuation<? super com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass4>) null);
        r5.L$0 = r1;
        r5.label = 4;
        r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f2, code lost:
        if (r6 != r0) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f4, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f5, code lost:
        r1.setSettingChecked(((java.lang.Boolean) r6).booleanValue());
        r1 = r5.this$0;
        r6 = kotlinx.coroutines.Dispatchers.b();
        r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass5((kotlin.coroutines.Continuation<? super com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass5>) null);
        r5.L$0 = r1;
        r5.label = 5;
        r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0112, code lost:
        if (r6 != r0) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0114, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0115, code lost:
        r1.mCallAudio = ((java.lang.Number) r6).intValue();
        r6 = r5.this$0;
        r6.setCallAudioStr(r6.mCallAudio);
        r1 = r5.this$0;
        r6 = kotlinx.coroutines.Dispatchers.b();
        r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass6((kotlin.coroutines.Continuation<? super com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass6>) null);
        r5.L$0 = r1;
        r5.label = 6;
        r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x013b, code lost:
        if (r6 != r0) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x013d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x013e, code lost:
        r1.mMyselfAudioType = ((java.lang.Number) r6).intValue();
        r6 = r5.this$0;
        r6.setAudioTypeMyselfStr(r6.mMyselfAudioType);
        r6 = r5.this$0;
        r1 = kotlinx.coroutines.Dispatchers.b();
        r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass7((kotlin.coroutines.Continuation<? super com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.AnonymousClass7>) null);
        r5.L$0 = r6;
        r5.label = 7;
        r1 = kotlinx.coroutines.BuildersKt.g(r1, r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0164, code lost:
        if (r1 != r0) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0166, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0167, code lost:
        r0 = r6;
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0169, code lost:
        r0.mOtherAudioType = ((java.lang.Number) r6).intValue();
        r5 = r5.this$0;
        r5.setAudioTypeOtherStr(r5.mOtherAudioType);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x017d, code lost:
        return kotlin.Unit.INSTANCE;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x004f;
                case 1: goto L_0x0047;
                case 2: goto L_0x003f;
                case 3: goto L_0x0036;
                case 4: goto L_0x002d;
                case 5: goto L_0x0024;
                case 6: goto L_0x001b;
                case 7: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0012:
            java.lang.Object r0 = r5.L$0
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r0 = (com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0169
        L_0x001b:
            java.lang.Object r1 = r5.L$0
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r1 = (com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x013e
        L_0x0024:
            java.lang.Object r1 = r5.L$0
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r1 = (com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0115
        L_0x002d:
            java.lang.Object r1 = r5.L$0
            com.upuphone.ar.translation.phone.view.TransSettingItem r1 = (com.upuphone.ar.translation.phone.view.TransSettingItem) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00f5
        L_0x0036:
            java.lang.Object r1 = r5.L$0
            com.upuphone.ar.translation.phone.view.TransSettingItem r1 = (com.upuphone.ar.translation.phone.view.TransSettingItem) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00cf
        L_0x003f:
            java.lang.Object r1 = r5.L$0
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r1 = (com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x008f
        L_0x0047:
            java.lang.Object r1 = r5.L$0
            com.upuphone.ar.translation.phone.view.TransSettingItem r1 = (com.upuphone.ar.translation.phone.view.TransSettingItem) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006f
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r6)
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r6 = r5.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorSettingBinding r6 = r6.getMBinding()
            com.upuphone.ar.translation.phone.view.TransSettingItem r1 = r6.k
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$1 r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$1
            r3.<init>(r2)
            r5.L$0 = r1
            r4 = 1
            r5.label = r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5)
            if (r6 != r0) goto L_0x006f
            return r0
        L_0x006f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1.setSettingChecked(r6)
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r1 = r5.this$0
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$2 r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$2
            r3.<init>(r2)
            r5.L$0 = r1
            r4 = 2
            r5.label = r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5)
            if (r6 != r0) goto L_0x008f
            return r0
        L_0x008f:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r3 = 0
            r1.selectOtherSub(r6, r3)
            boolean r6 = com.upuphone.ar.translation.constants.TranslatorConstants.isAirPro()
            if (r6 != 0) goto L_0x00a2
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x00a2:
            com.upuphone.xr.sapp.context.SdkContext r6 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.PermissionContext r6 = r6.f()
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r1 = r5.this$0
            java.lang.String[] r1 = r1.locationPermissions
            boolean r6 = r6.a(r1)
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r1 = r5.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorSettingBinding r1 = r1.getMBinding()
            com.upuphone.ar.translation.phone.view.TransSettingItem r1 = r1.i
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$3 r4 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$3
            r4.<init>(r6, r2)
            r5.L$0 = r1
            r6 = 3
            r5.label = r6
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r3, r4, r5)
            if (r6 != r0) goto L_0x00cf
            return r0
        L_0x00cf:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1.setSettingChecked(r6)
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r6 = r5.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorSettingBinding r6 = r6.getMBinding()
            com.upuphone.ar.translation.phone.view.TransSettingItem r1 = r6.h
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$4 r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$4
            r3.<init>(r2)
            r5.L$0 = r1
            r4 = 4
            r5.label = r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5)
            if (r6 != r0) goto L_0x00f5
            return r0
        L_0x00f5:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1.setSettingChecked(r6)
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r1 = r5.this$0
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$5 r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$5
            r3.<init>(r2)
            r5.L$0 = r1
            r4 = 5
            r5.label = r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5)
            if (r6 != r0) goto L_0x0115
            return r0
        L_0x0115:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r1.mCallAudio = r6
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r6 = r5.this$0
            int r1 = r6.mCallAudio
            r6.setCallAudioStr(r1)
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r1 = r5.this$0
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$6 r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$6
            r3.<init>(r2)
            r5.L$0 = r1
            r4 = 6
            r5.label = r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r3, r5)
            if (r6 != r0) goto L_0x013e
            return r0
        L_0x013e:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r1.mMyselfAudioType = r6
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r6 = r5.this$0
            int r1 = r6.mMyselfAudioType
            r6.setAudioTypeMyselfStr(r1)
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r6 = r5.this$0
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$7 r3 = new com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1$7
            r3.<init>(r2)
            r5.L$0 = r6
            r2 = 7
            r5.label = r2
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.g(r1, r3, r5)
            if (r1 != r0) goto L_0x0167
            return r0
        L_0x0167:
            r0 = r6
            r6 = r1
        L_0x0169:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r0.mOtherAudioType = r6
            com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity r5 = r5.this$0
            int r6 = r5.mOtherAudioType
            r5.setAudioTypeOtherStr(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$initStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorSettingActivity$initStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
