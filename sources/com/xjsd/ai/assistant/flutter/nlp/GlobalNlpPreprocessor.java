package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.template.TtsTemplate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/GlobalNlpPreprocessor;", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "<init>", "()V", "", "b", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "directive", "", "j", "(Ljava/lang/String;)Z", "a", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlobalNlpPreprocessor implements NlpPreprocessor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8485a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/GlobalNlpPreprocessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.i(this, nluResponse);
    }

    public String b() {
        return VuiModelType.GLOBAL;
    }

    public Object c(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.e(this, nluResponse, continuation);
    }

    public void clean() {
        NlpPreprocessor.DefaultImpls.a(this);
    }

    public void d(NluResponse nluResponse, int i) {
        NlpPreprocessor.DefaultImpls.j(this, nluResponse, i);
    }

    public void e(NluResponse nluResponse, TtsTemplate ttsTemplate) {
        NlpPreprocessor.DefaultImpls.k(this, nluResponse, ttsTemplate);
    }

    public void f(String str, String str2) {
        NlpPreprocessor.DefaultImpls.d(this, str, str2);
    }

    public boolean g(NluResponse nluResponse) {
        return NlpPreprocessor.DefaultImpls.c(this, nluResponse);
    }

    public void h(NluResponse nluResponse, String str) {
        NlpPreprocessor.DefaultImpls.l(this, nluResponse, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object i(com.xjsd.ai.assistant.nlu.bean.NluResponse r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor$process$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor$process$1 r0 = (com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor$process$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor$process$1 r0 = new com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor$process$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 == r4) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            goto L_0x0031
        L_0x0029:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0031:
            java.lang.Object r9 = r0.L$0
            r10 = r9
            com.xjsd.ai.assistant.nlu.bean.NluResponse r10 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x012e
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r11)
            com.xjsd.ai.assistant.protocol.VuiModel r11 = com.xjsd.ai.assistant.phone.helper.NluDataParser.a(r10)
            com.xjsd.ai.assistant.protocol.vui.Header r2 = r11.getHeader()
            java.lang.String r2 = r2.getName()
            if (r2 == 0) goto L_0x0123
            int r5 = r2.hashCode()
            java.lang.String r6 = "stks"
            java.lang.String r7 = "directive"
            java.lang.String r8 = "getString(...)"
            switch(r5) {
                case -1473615280: goto L_0x00fc;
                case -360766229: goto L_0x00d5;
                case -97093081: goto L_0x00aa;
                case 1322575975: goto L_0x005c;
                default: goto L_0x005a;
            }
        L_0x005a:
            goto L_0x0123
        L_0x005c:
            java.lang.String r5 = "GeneralDirective"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0066
            goto L_0x0123
        L_0x0066:
            com.alibaba.fastjson.JSONObject r11 = r11.getPayload()
            java.lang.String r11 = r11.getString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r8)
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 == 0) goto L_0x007c
            r9.l(r10)
            goto L_0x012e
        L_0x007c:
            java.lang.String r2 = "ReturnDesktop"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r11, r4)
            if (r2 != 0) goto L_0x009c
            java.lang.String r2 = "Cancel"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r11, r4)
            if (r2 != 0) goto L_0x009c
            java.lang.String r2 = "Back"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r11, r4)
            if (r2 != 0) goto L_0x009c
            java.lang.String r2 = "Exit"
            boolean r11 = kotlin.text.StringsKt.equals(r2, r11, r4)
            if (r11 == 0) goto L_0x009f
        L_0x009c:
            com.xjsd.ai.assistant.flutter.NlpCompact.a()
        L_0x009f:
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r9 = r9.k(r10, r0)
            if (r9 != r1) goto L_0x012e
            return r1
        L_0x00aa:
            java.lang.String r4 = "SayVisible"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00b4
            goto L_0x0123
        L_0x00b4:
            com.alibaba.fastjson.JSONObject r11 = r11.getPayload()
            java.lang.String r11 = r11.getString(r6)
            com.xjsd.ai.assistant.protocol.stks.HotWordControl r0 = new com.xjsd.ai.assistant.protocol.stks.HotWordControl
            r0.<init>()
            r0.setControl(r3)
            r0.setData(r11)
            com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor$process$2$1 r11 = new com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor$process$2$1
            r11.<init>()
            r1 = 107(0x6b, float:1.5E-43)
            com.xjsd.ai.assistant.common.Communicator.b(r1, r0, r11)
            r9.a(r10)
            goto L_0x012e
        L_0x00d5:
            java.lang.String r4 = "MediaDirective"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00de
            goto L_0x0123
        L_0x00de:
            com.alibaba.fastjson.JSONObject r11 = r11.getPayload()
            java.lang.String r11 = r11.getString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r8)
            boolean r11 = r9.j(r11)
            if (r11 == 0) goto L_0x00f8
            com.xjsd.ai.assistant.flutter.nlp.PendingNlpProcessor r9 = new com.xjsd.ai.assistant.flutter.nlp.PendingNlpProcessor
            r9.<init>()
            r9.k(r10)
            goto L_0x012e
        L_0x00f8:
            r9.l(r10)
            goto L_0x012e
        L_0x00fc:
            java.lang.String r4 = "FreeWake"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0105
            goto L_0x0123
        L_0x0105:
            com.alibaba.fastjson.JSONObject r11 = r11.getPayload()
            java.lang.String r11 = r11.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r8)
            boolean r11 = r9.j(r11)
            if (r11 == 0) goto L_0x011f
            com.xjsd.ai.assistant.flutter.nlp.PendingNlpProcessor r9 = new com.xjsd.ai.assistant.flutter.nlp.PendingNlpProcessor
            r9.<init>()
            r9.k(r10)
            goto L_0x012e
        L_0x011f:
            r9.l(r10)
            goto L_0x012e
        L_0x0123:
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r9 = r9.k(r10, r0)
            if (r9 != r1) goto L_0x012e
            return r1
        L_0x012e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor.i(com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        r4 = new com.xjsd.ai.assistant.core.api.music.MediaModel();
        r4.setCmdType("Control");
        r4.setControlType("Open");
        com.xjsd.ai.assistant.phone.media.MediaHelper.e(r4, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        if (com.xjsd.ai.assistant.phone.NewFunctionCompact.b() == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
        r4 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f("下一个", false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        r4 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f("下一首", false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
        if (com.xjsd.ai.assistant.phone.NewFunctionCompact.b() == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bf, code lost:
        r4 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f("上一个", false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
        r4 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f("上一首", false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f("继续播放", false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f("暂停播放", false);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(java.lang.String r5) {
        /*
            r4 = this;
            int r4 = r5.hashCode()
            java.lang.String r0 = "上一首"
            java.lang.String r1 = "下一首"
            java.lang.String r2 = "继续播放"
            r3 = 0
            switch(r4) {
                case -836144065: goto L_0x00b0;
                case -376049518: goto L_0x009f;
                case -150733609: goto L_0x0082;
                case -150668008: goto L_0x0065;
                case 19857184: goto L_0x005d;
                case 19858145: goto L_0x0055;
                case 110173065: goto L_0x004b;
                case 793936558: goto L_0x0040;
                case 802771031: goto L_0x0035;
                case 999870871: goto L_0x0027;
                case 1288261905: goto L_0x001d;
                case 1819030001: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x00cc
        L_0x0013:
            java.lang.String r4 = "MediaNext_stks"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x008b
            goto L_0x00cc
        L_0x001d:
            java.lang.String r4 = "MediaResume"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x002f
            goto L_0x00cc
        L_0x0027:
            boolean r4 = r5.equals(r2)
            if (r4 != 0) goto L_0x002f
            goto L_0x00cc
        L_0x002f:
            boolean r3 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f(r2, r3)
            goto L_0x00cc
        L_0x0035:
            java.lang.String r4 = "暂停音乐"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00a8
            goto L_0x00cc
        L_0x0040:
            java.lang.String r4 = "播放音乐"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x006e
            goto L_0x00cc
        L_0x004b:
            java.lang.String r4 = "MediaPre_stks"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00b9
            goto L_0x00cc
        L_0x0055:
            boolean r4 = r5.equals(r1)
            if (r4 != 0) goto L_0x008b
            goto L_0x00cc
        L_0x005d:
            boolean r4 = r5.equals(r0)
            if (r4 != 0) goto L_0x00b9
            goto L_0x00cc
        L_0x0065:
            java.lang.String r4 = "MediaPlay"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x006e
            goto L_0x00cc
        L_0x006e:
            com.xjsd.ai.assistant.core.api.music.MediaModel r4 = new com.xjsd.ai.assistant.core.api.music.MediaModel
            r4.<init>()
            java.lang.String r5 = "Control"
            r4.setCmdType(r5)
            java.lang.String r5 = "Open"
            r4.setControlType(r5)
            r3 = 1
            com.xjsd.ai.assistant.phone.media.MediaHelper.e(r4, r3)
            goto L_0x00cc
        L_0x0082:
            java.lang.String r4 = "MediaNext"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x008b
            goto L_0x00cc
        L_0x008b:
            boolean r4 = com.xjsd.ai.assistant.phone.NewFunctionCompact.b()
            if (r4 == 0) goto L_0x009a
            java.lang.String r4 = "下一个"
            boolean r4 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f(r4, r3)
        L_0x0098:
            r3 = r4
            goto L_0x00cc
        L_0x009a:
            boolean r4 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f(r1, r3)
            goto L_0x0098
        L_0x009f:
            java.lang.String r4 = "MediaPause"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00a8
            goto L_0x00cc
        L_0x00a8:
            java.lang.String r4 = "暂停播放"
            boolean r3 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f(r4, r3)
            goto L_0x00cc
        L_0x00b0:
            java.lang.String r4 = "MediaPre"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00b9
            goto L_0x00cc
        L_0x00b9:
            boolean r4 = com.xjsd.ai.assistant.phone.NewFunctionCompact.b()
            if (r4 == 0) goto L_0x00c7
            java.lang.String r4 = "上一个"
            boolean r4 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f(r4, r3)
            goto L_0x0098
        L_0x00c7:
            boolean r4 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f(r0, r3)
            goto L_0x0098
        L_0x00cc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.GlobalNlpPreprocessor.j(java.lang.String):boolean");
    }

    public Object k(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.f(this, nluResponse, continuation);
    }

    public void l(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.h(this, nluResponse);
    }
}
