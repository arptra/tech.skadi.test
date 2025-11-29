package com.upuphone.ai.ttsengine.helper;

import android.os.Bundle;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.protocol.bean.ReadBean;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR \u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010%¨\u0006'"}, d2 = {"Lcom/upuphone/ai/ttsengine/helper/ParamsHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "text", "", "id", "Landroid/os/Bundle;", "params", "", "e", "(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/String;Landroid/os/Bundle;)V", "Lcom/upuphone/ai/ttsengine/protocol/bean/ReadBean;", "readBean", "f", "(Lcom/upuphone/ai/ttsengine/protocol/bean/ReadBean;Landroid/os/Bundle;)V", "", "c", "(Ljava/lang/CharSequence;)Z", "d", "a", "b", "()Z", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "meetingPattern", "callingTipPattern", "wechatCallingPattern", "", "", "Ljava/util/Map;", "glassLanguageMap", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nParamsHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParamsHelper.kt\ncom/upuphone/ai/ttsengine/helper/ParamsHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n1#2:93\n*E\n"})
public final class ParamsHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ParamsHelper f5570a = new ParamsHelper();
    public static final AILOG b = AILOG.a("ParamsHelper");
    public static final Regex c = new Regex("^企业微信.*(?:点击入会|已开始)$");
    public static final Regex d = new Regex(".*通话进行中,点击返回.*$");
    public static final Regex e = new Regex("^微信.*邀请你(?:语音|视频)通话$");
    public static final Map f = MapsKt.mapOf(TuplesKt.to(1, "zh"), TuplesKt.to(11, "id"), TuplesKt.to(10, "th"), TuplesKt.to(3, "ms"), TuplesKt.to(2, "en"), TuplesKt.to(16, "ar"));

    public final boolean a(CharSequence charSequence) {
        if (charSequence != null) {
            return d.containsMatchIn(charSequence);
        }
        return false;
    }

    public final boolean b() {
        return true;
    }

    public final boolean c(CharSequence charSequence) {
        if (charSequence != null) {
            return c.containsMatchIn(charSequence);
        }
        return false;
    }

    public final boolean d(CharSequence charSequence) {
        if (charSequence != null) {
            return e.containsMatchIn(charSequence);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(android.content.Context r9, java.lang.CharSequence r10, java.lang.String r11, android.os.Bundle r12) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "caller_priority"
            r1 = 2
            int r0 = r12.getInt(r0, r1)
            boolean r9 = com.upuphone.ai.ttsengine.base.utils.PackageUtils.b(r9)
            r2 = 0
            if (r9 == 0) goto L_0x0020
        L_0x001d:
            r1 = r2
            goto L_0x0089
        L_0x0020:
            com.upuphone.ai.ttsengine.base.utils.SystemUtils r9 = com.upuphone.ai.ttsengine.base.utils.SystemUtils.f5531a
            boolean r3 = r9.d()
            java.lang.String r4 = "com.tencent.wework"
            r5 = 0
            if (r3 == 0) goto L_0x0038
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r4, (boolean) r2, (int) r1, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0038
            boolean r3 = r8.c(r10)
            if (r3 == 0) goto L_0x0038
            goto L_0x0089
        L_0x0038:
            boolean r3 = r8.d(r10)
            r6 = 1
            java.lang.String r7 = "com.tencent.mm"
            if (r3 == 0) goto L_0x0050
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r7, (boolean) r2, (int) r1, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0050
            java.lang.String r9 = "delay_time"
            r3 = 1000(0x3e8, double:4.94E-321)
            r12.putLong(r9, r3)
        L_0x004e:
            r1 = r6
            goto L_0x0089
        L_0x0050:
            boolean r10 = r8.a(r10)
            if (r10 == 0) goto L_0x0057
            goto L_0x0089
        L_0x0057:
            if (r0 == 0) goto L_0x005a
            goto L_0x001d
        L_0x005a:
            boolean r10 = r9.c()
            if (r10 == 0) goto L_0x0067
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r4, (boolean) r2, (int) r1, (java.lang.Object) r5)
            if (r10 == 0) goto L_0x0067
            goto L_0x0089
        L_0x0067:
            boolean r10 = r9.e()
            if (r10 != 0) goto L_0x0073
            boolean r10 = r9.c()
            if (r10 == 0) goto L_0x007a
        L_0x0073:
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r7, (boolean) r2, (int) r1, (java.lang.Object) r5)
            if (r10 == 0) goto L_0x007a
            goto L_0x004e
        L_0x007a:
            boolean r9 = r9.b()
            if (r9 == 0) goto L_0x001d
            java.lang.String r9 = "com.ss.android.lark"
            boolean r9 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r9, (boolean) r2, (int) r1, (java.lang.Object) r5)
            if (r9 == 0) goto L_0x001d
            r1 = 3
        L_0x0089:
            com.upuphone.ai.ttsengine.base.utils.AILOG r9 = b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "set params id: "
            r10.append(r3)
            r10.append(r11)
            java.lang.String r11 = ", priority: "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r11 = ", callingType: "
            r10.append(r11)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            java.lang.Object[] r11 = new java.lang.Object[r2]
            r9.c(r10, r11)
            java.lang.String r9 = "calling_type"
            r12.putInt(r9, r1)
            java.lang.String r9 = "voice_id"
            java.lang.String r10 = r12.getString(r9)
            if (r10 == 0) goto L_0x00c5
            boolean r10 = kotlin.text.StringsKt.isBlank(r10)
            if (r10 == 0) goto L_0x00d7
        L_0x00c5:
            boolean r8 = r8.b()
            if (r8 == 0) goto L_0x00ce
            java.lang.String r8 = "google"
            goto L_0x00d4
        L_0x00ce:
            com.upuphone.ai.ttsengine.TtsSdk r8 = com.upuphone.ai.ttsengine.TtsSdk.f5490a
            java.lang.String r8 = r8.k()
        L_0x00d4:
            r12.putString(r9, r8)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.helper.ParamsHelper.e(android.content.Context, java.lang.CharSequence, java.lang.String, android.os.Bundle):void");
    }

    public final void f(ReadBean readBean, Bundle bundle) {
        String caller;
        Intrinsics.checkNotNullParameter(readBean, "readBean");
        Intrinsics.checkNotNullParameter(bundle, PayloadConstant.KEY_PARAMS);
        if (b() && (caller = readBean.getCaller()) != null) {
            int hashCode = caller.hashCode();
            if (hashCode != -2017874896) {
                if (hashCode != 1063519484) {
                    if (hashCode != 1413835219 || !caller.equals("com.tts.notification")) {
                        return;
                    }
                } else if (caller.equals("com.tts.navigation")) {
                    bundle.putInt("multi_language", 1);
                    return;
                } else {
                    return;
                }
            } else if (!caller.equals("com.tts.dialog")) {
                return;
            }
            bundle.putInt("multi_language", 1);
            bundle.putString("language", (String) f.get(Integer.valueOf(readBean.getLanguage())));
        }
    }
}
