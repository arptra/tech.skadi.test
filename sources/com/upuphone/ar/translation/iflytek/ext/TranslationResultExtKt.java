package com.upuphone.ar.translation.iflytek.ext;

import com.geetest.sdk.s;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.entity.Cw;
import com.upuphone.ar.translation.iflytek.entity.Dst;
import com.upuphone.ar.translation.iflytek.entity.Rt;
import com.upuphone.ar.translation.iflytek.entity.Src;
import com.upuphone.ar.translation.iflytek.entity.St;
import com.upuphone.ar.translation.iflytek.entity.TranscribedData;
import com.upuphone.ar.translation.iflytek.entity.TranslationData;
import com.upuphone.ar.translation.iflytek.entity.TranslationRepResult;
import com.upuphone.ar.translation.iflytek.entity.TranslationResult;
import com.upuphone.ar.translation.iflytek.entity.Ws;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.ar.translation.utils.JsonUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/TranslationResult;", "", "c", "(Lcom/upuphone/ar/translation/iflytek/entity/TranslationResult;)Ljava/lang/String;", "b", "action", "Lcom/upuphone/ar/translation/iflytek/entity/TranslationError;", "a", "(Lcom/upuphone/ar/translation/iflytek/entity/TranslationResult;Ljava/lang/String;)Lcom/upuphone/ar/translation/iflytek/entity/TranslationError;", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class TranslationResultExtKt {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.upuphone.ar.translation.iflytek.entity.TranslationError a(com.upuphone.ar.translation.iflytek.entity.TranslationResult r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = r10.getCode()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "error code:: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ", action:: "
            r3.append(r0)
            r3.append(r11)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "TranslationResultExt"
            com.upuphone.ar.translation.ext.LogExt.j(r0, r3)
            java.lang.String r0 = r10.getCode()
            int r3 = r0.hashCode()
            switch(r3) {
                case 48: goto L_0x01a8;
                case 46731127: goto L_0x0185;
                case 46731128: goto L_0x0161;
                case 46731129: goto L_0x013c;
                case 46731153: goto L_0x0117;
                case 46732085: goto L_0x00f2;
                case 46732087: goto L_0x00cd;
                case 46732088: goto L_0x00a8;
                case 46736888: goto L_0x0083;
                case 46737849: goto L_0x005e;
                case 46908910: goto L_0x0039;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x01b0
        L_0x0039:
            java.lang.String r3 = "16003"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0043
            goto L_0x01b0
        L_0x0043:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "基础组件异常"
            java.lang.String r7 = "重试或向服务提供商反馈"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x005e:
            java.lang.String r3 = "10800"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0068
            goto L_0x01b0
        L_0x0068:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "超过授权的连接数"
            java.lang.String r7 = "确认连接数是否超过授权的连接数"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x0083:
            java.lang.String r3 = "10700"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x008d
            goto L_0x01b0
        L_0x008d:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "引擎错误"
            java.lang.String r7 = "提供接口返回值，向服务提供商反馈"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x00a8:
            java.lang.String r3 = "10205"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00b2
            goto L_0x01b0
        L_0x00b2:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "服务端websocket读错误"
            java.lang.String r7 = "检查网络是否正常，向服务提供商反馈"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x00cd:
            java.lang.String r3 = "10204"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00d7
            goto L_0x01b0
        L_0x00d7:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "服务端websocket写错误"
            java.lang.String r7 = "检查网络是否正常，向服务提供商反馈"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x00f2:
            java.lang.String r3 = "10202"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00fc
            goto L_0x01b0
        L_0x00fc:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "websocket连接错误"
            java.lang.String r7 = "检查网络是否正常"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x0117:
            java.lang.String r3 = "10110"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0121
            goto L_0x01b0
        L_0x0121:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "无授权许可"
            java.lang.String r7 = "检查参数值是否超过范围或不符合要求"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x013c:
            java.lang.String r3 = "10107"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0146
            goto L_0x01b0
        L_0x0146:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "非法参数值"
            java.lang.String r7 = "检查参数值是否超过范围或不符合要求"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x0161:
            java.lang.String r3 = "10106"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x016a
            goto L_0x01b0
        L_0x016a:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "无效参数"
            java.lang.String r7 = "上传必要的参数， 检查参数格式以及编码"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x0185:
            java.lang.String r3 = "10105"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x018e
            goto L_0x01b0
        L_0x018e:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r6 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            java.lang.String r5 = "没有权限"
            java.lang.String r7 = "检查apiKey，ip，ts等授权参数是否正确"
            r0 = r6
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x01e7
        L_0x01a8:
            java.lang.String r3 = "0"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x01cc
        L_0x01b0:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r8 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            r6 = 16
            r7 = 0
            java.lang.String r5 = "未知异常"
            r9 = 0
            r0 = r8
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
        L_0x01ca:
            r6 = r8
            goto L_0x01e7
        L_0x01cc:
            com.upuphone.ar.translation.iflytek.entity.TranslationError r8 = new com.upuphone.ar.translation.iflytek.entity.TranslationError
            java.lang.String r3 = r10.getCode()
            java.lang.String r4 = r10.getDesc()
            r6 = 16
            r7 = 0
            java.lang.String r5 = "成功"
            r9 = 0
            r0 = r8
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x01ca
        L_0x01e7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.iflytek.ext.TranslationResultExtKt.a(com.upuphone.ar.translation.iflytek.entity.TranslationResult, java.lang.String):com.upuphone.ar.translation.iflytek.entity.TranslationError");
    }

    public static final String b(TranslationResult translationResult) {
        int i;
        Intrinsics.checkNotNullParameter(translationResult, "<this>");
        TranscribedData transcribedData = (TranscribedData) GsonUtils.a(translationResult.getData(), TranscribedData.class);
        LogExt.j("transcribedData:: " + transcribedData, "TranslationResultExt");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        St st = transcribedData.getCn().getSt();
        Iterator<Rt> it = st.getRt().iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            for (Ws cw : it.next().getWs()) {
                for (Cw next : cw.getCw()) {
                    sb.append(next.getW());
                    String wp = next.getWp();
                    if (!StringsKt.equals(wp, s.f, true)) {
                        sb2.append(wp);
                    }
                }
            }
        }
        int parseInt = Integer.parseInt(st.getType());
        LogExt.j("transcribed src content=" + sb + ", wp=" + sb2 + ", type=" + parseInt, "TranslationResultExt");
        if (!(sb2.length() == 0 && parseInt == 0)) {
            i = parseInt;
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return JsonUtils.d(new TranslationRepResult(new Src(i, sb3), (Dst) null));
    }

    public static final String c(TranslationResult translationResult) {
        Intrinsics.checkNotNullParameter(translationResult, "<this>");
        TranslationData translationData = (TranslationData) GsonUtils.a(translationResult.getData(), TranslationData.class);
        LogExt.j("translationData:: " + translationData, "TranslationResultExt");
        return JsonUtils.d(new TranslationRepResult((Src) null, new Dst(translationData.getType(), translationData.getDst(), translationData.getSrc())));
    }
}
