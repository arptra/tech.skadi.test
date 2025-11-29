package com.upuphone.xr.sapp.fragment;

import android.content.Context;
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

@SourceDebugExtension({"SMAP\nVoiceAssistantsSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceAssistantsSettingsFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment$updateUi$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,518:1\n254#2:519\n254#2:520\n254#2:521\n254#2:522\n*S KotlinDebug\n*F\n+ 1 VoiceAssistantsSettingsFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment$updateUi$1$1\n*L\n156#1:519\n164#1:520\n168#1:521\n172#1:522\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment$updateUi$1$1", f = "VoiceAssistantsSettingsFragment.kt", i = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {148, 149, 150, 151, 152, 153, 154}, m = "invokeSuspend", n = {"isLowPowerWakeup", "isLowPowerWakeup", "isLowPowerWakeupScreenOff", "isLowPowerWakeup", "isLowPowerWakeupScreenOff", "isContinuousDialogue", "isLowPowerWakeup", "isLowPowerWakeupScreenOff", "isContinuousDialogue", "isAsrResultScreen", "isLowPowerWakeup", "isLowPowerWakeupScreenOff", "isContinuousDialogue", "isAsrResultScreen", "ttsTimbre", "isLowPowerWakeup", "isLowPowerWakeupScreenOff", "isContinuousDialogue", "isAsrResultScreen", "ttsTimbre", "isChatGptTTSPlay"}, s = {"Z$0", "Z$0", "Z$1", "Z$0", "Z$1", "Z$2", "Z$0", "Z$1", "Z$2", "Z$3", "Z$0", "Z$1", "Z$2", "Z$3", "I$0", "Z$0", "Z$1", "Z$2", "Z$3", "I$0", "Z$4"})
public final class VoiceAssistantsSettingsFragment$updateUi$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int I$0;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    boolean Z$4;
    int label;
    final /* synthetic */ VoiceAssistantsSettingsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceAssistantsSettingsFragment$updateUi$1$1(Context context, VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, Continuation<? super VoiceAssistantsSettingsFragment$updateUi$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = voiceAssistantsSettingsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceAssistantsSettingsFragment$updateUi$1$1(this.$context, this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0282, code lost:
        r2.f.setSubtitleText(com.upuphone.xr.sapp.R.string.timbre_csyj);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x028a, code lost:
        r2 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0290, code lost:
        if (r2 != null) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0292, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0296, code lost:
        r2.f.setSubtitleText(com.upuphone.xr.sapp.R.string.timbre_zxns);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x029d, code lost:
        if (r1 == false) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x029f, code lost:
        if (r7 == false) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02a1, code lost:
        r0.this$0.e = 0;
        r0 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02ad, code lost:
        if (r0 != null) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02af, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02b3, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02b4, code lost:
        r13.e.setIndicatorText(com.upuphone.xr.sapp.R.string.settings_voice_llm_reply_all);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02bc, code lost:
        r0.this$0.e = 1;
        r0 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02c7, code lost:
        if (r0 != null) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02c9, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02cd, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02ce, code lost:
        r13.e.setIndicatorText(com.upuphone.xr.sapp.R.string.settings_voice_llm_reply_tts);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02d6, code lost:
        r0.this$0.e = 2;
        r0 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02e1, code lost:
        if (r0 != null) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02e3, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02e7, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02e8, code lost:
        r13.e.setIndicatorText(com.upuphone.xr.sapp.R.string.settings_voice_llm_reply_text);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ef, code lost:
        com.upuphone.star.core.log.ULog.f6446a.g("VoiceAssistantsFragment", "updateUi:isLowPowerWakeup=" + r11 + " isLowPowerWakeupScreenOff=" + r10 + " isContinuousDialogue=" + r9 + " isAsrResultScreen=" + r8 + " isChatGptTTSPlay=" + r1 + " isChatGptCardDisplay=" + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0332, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008e, code lost:
        r2 = ((java.lang.Boolean) r2).booleanValue();
        r8 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r9 = r0.$context;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "$context");
        r0.Z$0 = r2;
        r0.label = 2;
        r8 = r8.o(r9, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a3, code lost:
        if (r8 != r1) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a6, code lost:
        r8 = ((java.lang.Boolean) r8).booleanValue();
        r9 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r10 = r0.$context;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "$context");
        r0.Z$0 = r2;
        r0.Z$1 = r8;
        r0.label = 3;
        r9 = r9.m(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00bd, code lost:
        if (r9 != r1) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00bf, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c0, code lost:
        r16 = r8;
        r8 = r2;
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c5, code lost:
        r9 = ((java.lang.Boolean) r9).booleanValue();
        r10 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r11 = r0.$context;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "$context");
        r0.Z$0 = r8;
        r0.Z$1 = r2;
        r0.Z$2 = r9;
        r0.label = 4;
        r10 = r10.j(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00de, code lost:
        if (r10 != r1) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e0, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e1, code lost:
        r16 = r9;
        r9 = r2;
        r2 = r8;
        r8 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e7, code lost:
        r10 = ((java.lang.Boolean) r10).booleanValue();
        r11 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r12 = r0.$context;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, "$context");
        r0.Z$0 = r2;
        r0.Z$1 = r9;
        r0.Z$2 = r8;
        r0.Z$3 = r10;
        r0.label = 5;
        r11 = r11.i(r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0103, code lost:
        if (r11 != r1) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0105, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0106, code lost:
        r16 = r10;
        r10 = r2;
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x010b, code lost:
        r11 = ((java.lang.Number) r11).intValue();
        r12 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r13 = r0.$context;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "$context");
        r0.Z$0 = r10;
        r0.Z$1 = r9;
        r0.Z$2 = r8;
        r0.Z$3 = r2;
        r0.I$0 = r11;
        r0.label = 6;
        r12 = r12.l(r13, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0129, code lost:
        if (r12 != r1) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x012b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x012c, code lost:
        r16 = r8;
        r8 = r2;
        r2 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0134, code lost:
        r12 = ((java.lang.Boolean) r12).booleanValue();
        r13 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a;
        r14 = r0.$context;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, "$context");
        r0.Z$0 = r11;
        r0.Z$1 = r10;
        r0.Z$2 = r9;
        r0.Z$3 = r8;
        r0.I$0 = r2;
        r0.Z$4 = r12;
        r0.label = 7;
        r7 = r13.k(r14, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0154, code lost:
        if (r7 != r1) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0156, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0157, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0158, code lost:
        r7 = ((java.lang.Boolean) r7).booleanValue();
        r12 = r0.this$0.f7014a;
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0167, code lost:
        if (r12 != null) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0169, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x016d, code lost:
        r12 = r12.g;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, "itemVoiceWakeup");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0178, code lost:
        if (r12.getVisibility() != 0) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x017a, code lost:
        r12 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0180, code lost:
        if (r12 != null) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0182, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0186, code lost:
        r12.g.setSwitchState(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x018b, code lost:
        r12 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0191, code lost:
        if (r12 != null) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0193, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0197, code lost:
        r12 = r12.h;
        r12.setEnabled(r11);
        r15 = r12.getBinding().b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01a6, code lost:
        if (r12.isEnabled() == false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a8, code lost:
        r12 = 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ab, code lost:
        r12 = 0.3f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ae, code lost:
        r15.setAlpha(r12);
        r12 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b7, code lost:
        if (r12 != null) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01b9, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01bd, code lost:
        r12 = r12.h;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, "itemVoiceWakeupOnScreenOff");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01c8, code lost:
        if (r12.getVisibility() != 0) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01ca, code lost:
        r12 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d0, code lost:
        if (r12 != null) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d2, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01d6, code lost:
        r12.h.setSwitchState(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01db, code lost:
        r12 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01e1, code lost:
        if (r12 != null) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e3, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e7, code lost:
        r12 = r12.d;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, "itemContinueDialog");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01f2, code lost:
        if (r12.getVisibility() != 0) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01f4, code lost:
        r12 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01fa, code lost:
        if (r12 != null) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01fc, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0200, code lost:
        r12.d.setSwitchState(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0205, code lost:
        r12 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x020b, code lost:
        if (r12 != null) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x020d, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0211, code lost:
        r12 = r12.c;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, "itemAsrDisplay");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x021c, code lost:
        if (r12.getVisibility() != 0) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x021e, code lost:
        r12 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0224, code lost:
        if (r12 != null) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0226, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x022a, code lost:
        r12.c.setSwitchState(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x022f, code lost:
        if (r2 == 0) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0231, code lost:
        if (r2 == 1) goto L_0x0276;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0233, code lost:
        if (r2 == 2) goto L_0x0262;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0235, code lost:
        if (r2 == 3) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0237, code lost:
        if (r2 == 4) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x023a, code lost:
        r2 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0240, code lost:
        if (r2 != null) goto L_0x0246;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0242, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0246, code lost:
        r2.f.setSubtitleText(com.upuphone.xr.sapp.R.string.timbre_qnns);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x024e, code lost:
        r2 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0254, code lost:
        if (r2 != null) goto L_0x025a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0256, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x025a, code lost:
        r2.f.setSubtitleText(com.upuphone.xr.sapp.R.string.timbre_kamt);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0262, code lost:
        r2 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0268, code lost:
        if (r2 != null) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x026a, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x026e, code lost:
        r2.f.setSubtitleText(com.upuphone.xr.sapp.R.string.timbre_tmns);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0276, code lost:
        r2 = r0.this$0.f7014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x027c, code lost:
        if (r2 != null) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x027e, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            java.lang.String r7 = "$context"
            switch(r2) {
                case 0: goto L_0x007b;
                case 1: goto L_0x0075;
                case 2: goto L_0x006d;
                case 3: goto L_0x0063;
                case 4: goto L_0x0050;
                case 5: goto L_0x0041;
                case 6: goto L_0x0030;
                case 7: goto L_0x0019;
                default: goto L_0x0011;
            }
        L_0x0011:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0019:
            boolean r1 = r0.Z$4
            int r2 = r0.I$0
            boolean r7 = r0.Z$3
            boolean r8 = r0.Z$2
            boolean r9 = r0.Z$1
            boolean r10 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r18)
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r18
            goto L_0x0158
        L_0x0030:
            int r2 = r0.I$0
            boolean r8 = r0.Z$3
            boolean r9 = r0.Z$2
            boolean r10 = r0.Z$1
            boolean r11 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r18)
            r12 = r18
            goto L_0x0134
        L_0x0041:
            boolean r2 = r0.Z$3
            boolean r8 = r0.Z$2
            boolean r9 = r0.Z$1
            boolean r10 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r18)
            r11 = r18
            goto L_0x010b
        L_0x0050:
            boolean r2 = r0.Z$2
            boolean r8 = r0.Z$1
            boolean r9 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r18)
            r10 = r18
            r16 = r8
            r8 = r2
            r2 = r9
            r9 = r16
            goto L_0x00e7
        L_0x0063:
            boolean r2 = r0.Z$1
            boolean r8 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r18)
            r9 = r18
            goto L_0x00c5
        L_0x006d:
            boolean r2 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r18)
            r8 = r18
            goto L_0x00a6
        L_0x0075:
            kotlin.ResultKt.throwOnFailure(r18)
            r2 = r18
            goto L_0x008e
        L_0x007b:
            kotlin.ResultKt.throwOnFailure(r18)
            com.xjsd.ai.assistant.common.data.DataStoreUtils r2 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r8 = r0.$context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            r0.label = r6
            java.lang.Object r2 = r2.n(r8, r0)
            if (r2 != r1) goto L_0x008e
            return r1
        L_0x008e:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r8 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r9 = r0.$context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
            r0.Z$0 = r2
            r0.label = r5
            java.lang.Object r8 = r8.o(r9, r0)
            if (r8 != r1) goto L_0x00a6
            return r1
        L_0x00a6:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r9 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r10 = r0.$context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r7)
            r0.Z$0 = r2
            r0.Z$1 = r8
            r0.label = r4
            java.lang.Object r9 = r9.m(r10, r0)
            if (r9 != r1) goto L_0x00c0
            return r1
        L_0x00c0:
            r16 = r8
            r8 = r2
            r2 = r16
        L_0x00c5:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r10 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r11 = r0.$context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r7)
            r0.Z$0 = r8
            r0.Z$1 = r2
            r0.Z$2 = r9
            r0.label = r3
            java.lang.Object r10 = r10.j(r11, r0)
            if (r10 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            r16 = r9
            r9 = r2
            r2 = r8
            r8 = r16
        L_0x00e7:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r11 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r12 = r0.$context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r7)
            r0.Z$0 = r2
            r0.Z$1 = r9
            r0.Z$2 = r8
            r0.Z$3 = r10
            r13 = 5
            r0.label = r13
            java.lang.Object r11 = r11.i(r12, r0)
            if (r11 != r1) goto L_0x0106
            return r1
        L_0x0106:
            r16 = r10
            r10 = r2
            r2 = r16
        L_0x010b:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r12 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r13 = r0.$context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r7)
            r0.Z$0 = r10
            r0.Z$1 = r9
            r0.Z$2 = r8
            r0.Z$3 = r2
            r0.I$0 = r11
            r14 = 6
            r0.label = r14
            java.lang.Object r12 = r12.l(r13, r0)
            if (r12 != r1) goto L_0x012c
            return r1
        L_0x012c:
            r16 = r8
            r8 = r2
            r2 = r11
            r11 = r10
            r10 = r9
            r9 = r16
        L_0x0134:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            com.xjsd.ai.assistant.common.data.DataStoreUtils r13 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            android.content.Context r14 = r0.$context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r7)
            r0.Z$0 = r11
            r0.Z$1 = r10
            r0.Z$2 = r9
            r0.Z$3 = r8
            r0.I$0 = r2
            r0.Z$4 = r12
            r7 = 7
            r0.label = r7
            java.lang.Object r7 = r13.k(r14, r0)
            if (r7 != r1) goto L_0x0157
            return r1
        L_0x0157:
            r1 = r12
        L_0x0158:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            r13 = 0
            java.lang.String r14 = "binding"
            if (r12 != 0) goto L_0x016d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x016d:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.g
            java.lang.String r15 = "itemVoiceWakeup"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            int r12 = r12.getVisibility()
            if (r12 != 0) goto L_0x018b
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            if (r12 != 0) goto L_0x0186
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x0186:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.g
            r12.setSwitchState(r11)
        L_0x018b:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            if (r12 != 0) goto L_0x0197
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x0197:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.h
            r12.setEnabled(r11)
            com.upuphone.xr.sapp.databinding.LayoutCardItemBinding r15 = r12.getBinding()
            androidx.constraintlayout.widget.ConstraintLayout r15 = r15.b
            boolean r12 = r12.isEnabled()
            if (r12 == 0) goto L_0x01ab
            r12 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01ae
        L_0x01ab:
            r12 = 1050253722(0x3e99999a, float:0.3)
        L_0x01ae:
            r15.setAlpha(r12)
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            if (r12 != 0) goto L_0x01bd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x01bd:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.h
            java.lang.String r15 = "itemVoiceWakeupOnScreenOff"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            int r12 = r12.getVisibility()
            if (r12 != 0) goto L_0x01db
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            if (r12 != 0) goto L_0x01d6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x01d6:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.h
            r12.setSwitchState(r10)
        L_0x01db:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            if (r12 != 0) goto L_0x01e7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x01e7:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.d
            java.lang.String r15 = "itemContinueDialog"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            int r12 = r12.getVisibility()
            if (r12 != 0) goto L_0x0205
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            if (r12 != 0) goto L_0x0200
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x0200:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.d
            r12.setSwitchState(r9)
        L_0x0205:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            if (r12 != 0) goto L_0x0211
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x0211:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.c
            java.lang.String r15 = "itemAsrDisplay"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            int r12 = r12.getVisibility()
            if (r12 != 0) goto L_0x022f
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r12 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r12 = r12.f7014a
            if (r12 != 0) goto L_0x022a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r12 = r13
        L_0x022a:
            com.upuphone.xr.sapp.view.SettingView r12 = r12.c
            r12.setSwitchState(r8)
        L_0x022f:
            if (r2 == 0) goto L_0x028a
            if (r2 == r6) goto L_0x0276
            if (r2 == r5) goto L_0x0262
            if (r2 == r4) goto L_0x024e
            if (r2 == r3) goto L_0x023a
            goto L_0x029d
        L_0x023a:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r2 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r2 = r2.f7014a
            if (r2 != 0) goto L_0x0246
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r2 = r13
        L_0x0246:
            com.upuphone.xr.sapp.view.SettingView r2 = r2.f
            int r3 = com.upuphone.xr.sapp.R.string.timbre_qnns
            r2.setSubtitleText((int) r3)
            goto L_0x029d
        L_0x024e:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r2 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r2 = r2.f7014a
            if (r2 != 0) goto L_0x025a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r2 = r13
        L_0x025a:
            com.upuphone.xr.sapp.view.SettingView r2 = r2.f
            int r3 = com.upuphone.xr.sapp.R.string.timbre_kamt
            r2.setSubtitleText((int) r3)
            goto L_0x029d
        L_0x0262:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r2 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r2 = r2.f7014a
            if (r2 != 0) goto L_0x026e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r2 = r13
        L_0x026e:
            com.upuphone.xr.sapp.view.SettingView r2 = r2.f
            int r3 = com.upuphone.xr.sapp.R.string.timbre_tmns
            r2.setSubtitleText((int) r3)
            goto L_0x029d
        L_0x0276:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r2 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r2 = r2.f7014a
            if (r2 != 0) goto L_0x0282
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r2 = r13
        L_0x0282:
            com.upuphone.xr.sapp.view.SettingView r2 = r2.f
            int r3 = com.upuphone.xr.sapp.R.string.timbre_csyj
            r2.setSubtitleText((int) r3)
            goto L_0x029d
        L_0x028a:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r2 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r2 = r2.f7014a
            if (r2 != 0) goto L_0x0296
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r2 = r13
        L_0x0296:
            com.upuphone.xr.sapp.view.SettingView r2 = r2.f
            int r3 = com.upuphone.xr.sapp.R.string.timbre_zxns
            r2.setSubtitleText((int) r3)
        L_0x029d:
            if (r1 == 0) goto L_0x02d6
            if (r7 == 0) goto L_0x02bc
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r2 = r0.this$0
            r3 = 0
            r2.e = r3
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r0 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r0 = r0.f7014a
            if (r0 != 0) goto L_0x02b3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            goto L_0x02b4
        L_0x02b3:
            r13 = r0
        L_0x02b4:
            com.upuphone.xr.sapp.view.SettingView r0 = r13.e
            int r2 = com.upuphone.xr.sapp.R.string.settings_voice_llm_reply_all
            r0.setIndicatorText((int) r2)
            goto L_0x02ef
        L_0x02bc:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r2 = r0.this$0
            r2.e = r6
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r0 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r0 = r0.f7014a
            if (r0 != 0) goto L_0x02cd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            goto L_0x02ce
        L_0x02cd:
            r13 = r0
        L_0x02ce:
            com.upuphone.xr.sapp.view.SettingView r0 = r13.e
            int r2 = com.upuphone.xr.sapp.R.string.settings_voice_llm_reply_tts
            r0.setIndicatorText((int) r2)
            goto L_0x02ef
        L_0x02d6:
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r2 = r0.this$0
            r2.e = r5
            com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment r0 = r0.this$0
            com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding r0 = r0.f7014a
            if (r0 != 0) goto L_0x02e7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            goto L_0x02e8
        L_0x02e7:
            r13 = r0
        L_0x02e8:
            com.upuphone.xr.sapp.view.SettingView r0 = r13.e
            int r2 = com.upuphone.xr.sapp.R.string.settings_voice_llm_reply_text
            r0.setIndicatorText((int) r2)
        L_0x02ef:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "updateUi:isLowPowerWakeup="
            r2.append(r3)
            r2.append(r11)
            java.lang.String r3 = " isLowPowerWakeupScreenOff="
            r2.append(r3)
            r2.append(r10)
            java.lang.String r3 = " isContinuousDialogue="
            r2.append(r3)
            r2.append(r9)
            java.lang.String r3 = " isAsrResultScreen="
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = " isChatGptTTSPlay="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " isChatGptCardDisplay="
            r2.append(r1)
            r2.append(r7)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "VoiceAssistantsFragment"
            r0.g(r2, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment$updateUi$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceAssistantsSettingsFragment$updateUi$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
