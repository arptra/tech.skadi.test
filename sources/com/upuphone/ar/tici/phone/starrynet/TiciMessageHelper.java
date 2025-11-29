package com.upuphone.ar.tici.phone.starrynet;

import com.honey.account.view.web.WebJs;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.starrynet.msg.SendContentMsg;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u000bJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJF\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0016H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J6\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010 \u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper;", "", "<init>", "()V", "Lcom/upuphone/ar/tici/phone/starrynet/msg/SendContentMsg;", "msg", "", "timeout", "Lkotlin/Result;", "", "g", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/SendContentMsg;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;", "b", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "msgId", "msgAction", "replyAction", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/ar/tici/phone/starrynet/msg/SendTiciContentPageMsg;", "j", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/SendTiciContentPageMsg;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "k", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "data", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "listener", "f", "(Lorg/json/JSONObject;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciMessageHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TiciMessageHelper f5973a = new TiciMessageHelper();

    public static /* synthetic */ Object c(TiciMessageHelper ticiMessageHelper, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 10000;
        }
        return ticiMessageHelper.b(j, continuation);
    }

    public static /* synthetic */ Object e(TiciMessageHelper ticiMessageHelper, String str, String str2, String str3, String str4, long j, Continuation continuation, int i, Object obj) {
        return ticiMessageHelper.d(str, str2, str3, str4, (i & 16) != 0 ? 10000 : j, continuation);
    }

    public static /* synthetic */ Object i(TiciMessageHelper ticiMessageHelper, SendContentMsg sendContentMsg, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 30000;
        }
        return ticiMessageHelper.h(sendContentMsg, j, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(long r5, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$checkTiciState$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$checkTiciState$1 r0 = (com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$checkTiciState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$checkTiciState$1 r0 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$checkTiciState$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$checkTiciState$2 r4 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$checkTiciState$2
            r1 = 0
            r4.<init>(r1)
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.c(r5, r4, r0)
            if (r4 != r7) goto L_0x0043
            return r7
        L_0x0043:
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.m29unboximpl()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.b(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, long r16, kotlin.coroutines.Continuation r18) {
        /*
            r11 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendAndWaitForMsgId$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendAndWaitForMsgId$1 r1 = (com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendAndWaitForMsgId$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001b
        L_0x0015:
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendAndWaitForMsgId$1 r1 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendAndWaitForMsgId$1
            r2 = r11
            r1.<init>(r11, r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x0034
            if (r3 != r4) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x004d
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r0)
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendAndWaitForMsgId$2 r0 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendAndWaitForMsgId$2
            r10 = 0
            r5 = r0
            r6 = r15
            r7 = r13
            r8 = r14
            r9 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            r1.label = r4
            r3 = r16
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.c(r3, r0, r1)
            if (r0 != r2) goto L_0x004d
            return r2
        L_0x004d:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.m29unboximpl()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.d(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void f(JSONObject jSONObject, SendMessageListener sendMessageListener) {
        TiciStarryMsgManager q = TiciApp.b.q();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(WebJs.ACTION, "tici");
        jSONObject2.put("data", jSONObject);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
        TiciStarryMsgManager.sendStarryMessage$ar_tici_release$default(q, jSONObject3, (String) null, sendMessageListener, 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(com.upuphone.ar.tici.phone.starrynet.msg.SendContentMsg r5, long r6, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsg$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsg$1 r0 = (com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsg$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsg$1 r0 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsg$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsg$2 r4 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsg$2
            r1 = 0
            r4.<init>(r5, r1)
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.c(r6, r4, r0)
            if (r4 != r8) goto L_0x0043
            return r8
        L_0x0043:
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.m29unboximpl()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.g(com.upuphone.ar.tici.phone.starrynet.msg.SendContentMsg, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(com.upuphone.ar.tici.phone.starrynet.msg.SendContentMsg r5, long r6, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsgV2$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsgV2$1 r0 = (com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsgV2$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsgV2$1 r0 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsgV2$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsgV2$2 r4 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentMsgV2$2
            r1 = 0
            r4.<init>(r5, r1)
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.c(r6, r4, r0)
            if (r4 != r8) goto L_0x0043
            return r8
        L_0x0043:
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.m29unboximpl()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.h(com.upuphone.ar.tici.phone.starrynet.msg.SendContentMsg, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(com.upuphone.ar.tici.phone.starrynet.msg.SendTiciContentPageMsg r12, kotlin.coroutines.Continuation r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentPage$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentPage$1 r0 = (com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentPage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r8 = r0
            goto L_0x001a
        L_0x0014:
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentPage$1 r0 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$sendTiciContentPage$1
            r0.<init>(r11, r13)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r13 = r8.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r11 = r13.m29unboximpl()
            goto L_0x0058
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = r12.toJsonString()
            java.lang.String r3 = r12.getMsgId()
            r8.label = r2
            java.lang.String r4 = "send_content_page"
            java.lang.String r5 = "send_content_page_reply"
            r6 = 0
            r9 = 16
            r10 = 0
            r1 = r11
            r2 = r13
            java.lang.Object r11 = e(r1, r2, r3, r4, r5, r6, r8, r9, r10)
            if (r11 != r0) goto L_0x0058
            return r0
        L_0x0058:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.j(com.upuphone.ar.tici.phone.starrynet.msg.SendTiciContentPageMsg, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(java.lang.String r5, java.lang.String r6, long r7, kotlin.coroutines.Continuation r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForMsgId$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForMsgId$1 r0 = (com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForMsgId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForMsgId$1 r0 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForMsgId$1
            r0.<init>(r4, r9)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForMsgId$2 r4 = new com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForMsgId$2
            r1 = 0
            r4.<init>(r6, r5, r1)
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.c(r7, r4, r0)
            if (r4 != r9) goto L_0x0043
            return r9
        L_0x0043:
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.m29unboximpl()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.k(java.lang.String, java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
