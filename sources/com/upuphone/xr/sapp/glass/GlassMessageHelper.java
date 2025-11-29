package com.upuphone.xr.sapp.glass;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.view.web.WebJs;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.common.ResultListener;
import com.upuphone.xr.sapp.entity.BaseActionData;
import com.upuphone.xr.sapp.entity.BaseActionValue;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0000\n\u0002\b\u0004*\u0001(\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010 \u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!R&\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010#R2\u0010'\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160&0\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0014\u0010*\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010)¨\u0006+"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassMessageHelper;", "", "<init>", "()V", "", "msg", "", "bytes", "Lcom/upuphone/xr/sapp/common/ResultListener;", "listener", "", "needSendMessageCallback", "i", "(Ljava/lang/String;[BLcom/upuphone/xr/sapp/common/ResultListener;Z)Ljava/lang/String;", "uid", "", "b", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/common/ResultListener;)V", "e", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/common/ResultListener;", "action", "subAction", "Lcom/upuphone/xr/sapp/glass/TwinActionMessageListener;", "c", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/sapp/glass/TwinActionMessageListener;)V", "f", "message", "Lcom/upuphone/xr/sapp/entity/BaseActionData;", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/BaseActionData;", "h", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/sapp/common/ResultListener;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "resultListeners", "Lkotlin/Pair;", "", "twinActionMessageListeners", "com/upuphone/xr/sapp/glass/GlassMessageHelper$messageReceiver$1", "Lcom/upuphone/xr/sapp/glass/GlassMessageHelper$messageReceiver$1;", "messageReceiver", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,344:1\n186#1:360\n187#1,11:370\n209#1,11:381\n186#1:399\n187#1,11:409\n209#1,11:420\n1#2:345\n1#2:348\n72#3,2:346\n314#4,11:349\n314#4,9:361\n323#4,2:392\n314#4,9:400\n323#4,2:431\n314#4,11:433\n29#5,5:394\n*S KotlinDebug\n*F\n+ 1 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n*L\n294#1:360\n294#1:370,11\n294#1:381,11\n294#1:399\n294#1:409,11\n294#1:420,11\n139#1:348\n139#1:346,2\n186#1:349,11\n294#1:361,9\n294#1:392,2\n294#1:400,9\n294#1:431,2\n317#1:433,11\n293#1:394,5\n*E\n"})
public final class GlassMessageHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassMessageHelper f7054a = new GlassMessageHelper();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final GlassMessageHelper$messageReceiver$1 d;

    static {
        GlassMessageHelper$messageReceiver$1 glassMessageHelper$messageReceiver$1 = new GlassMessageHelper$messageReceiver$1();
        d = glassMessageHelper$messageReceiver$1;
        StarryMessageHelper.f7799a.j(glassMessageHelper$messageReceiver$1);
    }

    public final void b(String str, ResultListener resultListener) {
        Intrinsics.checkNotNullParameter(str, Oauth2AccessToken.KEY_UID);
        Intrinsics.checkNotNullParameter(resultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        b.put(str, resultListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r2 = new java.util.concurrent.CopyOnWriteArraySet();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r1, java.lang.String r2, com.upuphone.xr.sapp.glass.TwinActionMessageListener r3) {
        /*
            r0 = this;
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "subAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.concurrent.ConcurrentHashMap r0 = c
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0028
            java.util.concurrent.CopyOnWriteArraySet r2 = new java.util.concurrent.CopyOnWriteArraySet
            r2.<init>()
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = r0
        L_0x0028:
            java.util.Set r2 = (java.util.Set) r2
            r2.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassMessageHelper.c(java.lang.String, java.lang.String, com.upuphone.xr.sapp.glass.TwinActionMessageListener):void");
    }

    public final BaseActionData d(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "subAction");
        BaseActionValue baseActionValue = new BaseActionValue();
        baseActionValue.setAction(str2);
        if (str3 == null) {
            str3 = "";
        }
        baseActionValue.setValue(str3);
        BaseActionData baseActionData = new BaseActionData();
        baseActionData.setAction(str);
        baseActionData.setData(baseActionValue);
        return baseActionData;
    }

    public final ResultListener e(String str) {
        if (str != null) {
            return (ResultListener) b.remove(str);
        }
        return null;
    }

    public final void f(String str, String str2, TwinActionMessageListener twinActionMessageListener) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "subAction");
        Intrinsics.checkNotNullParameter(twinActionMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Set set = (Set) c.get(TuplesKt.to(str, str2));
        if (set != null) {
            set.remove(twinActionMessageListener);
        }
    }

    public final void g(String str, String str2, String str3, ResultListener resultListener) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "subAction");
        i(JsonUtils.f7893a.d(d(str, str2, str3)), (byte[]) null, resultListener, resultListener != null);
    }

    public final void h(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "subAction");
        i(JsonUtils.f7893a.d(d(str, str2, str3)), (byte[]) null, (ResultListener) null, false);
    }

    public final String i(String str, byte[] bArr, ResultListener resultListener, boolean z) {
        String str2;
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        GlassMessageHelper$sendMessageToGlass$sendMessageListener$2 glassMessageHelper$sendMessageToGlass$sendMessageListener$2 = null;
        if (InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice() == null) {
            ULog.f6446a.a("GlassMessageHelper", "sendMessageToGlass, connectedDevice is null, msg: " + str);
            if (resultListener != null) {
                resultListener.onFail(-1, "connectedDevice is null");
            }
            return null;
        }
        if (z) {
            String uuid = UUID.randomUUID().toString();
            if (resultListener != null) {
                f7054a.b(uuid, resultListener);
            }
            String str3 = uuid;
            glassMessageHelper$sendMessageToGlass$sendMessageListener$2 = new GlassMessageHelper$sendMessageToGlass$sendMessageListener$2(str, uuid);
            str2 = str3;
        } else {
            str2 = null;
        }
        StarryMessageHelper.f7799a.m(str, bArr, glassMessageHelper$sendMessageToGlass$sendMessageListener$2);
        return str2;
    }
}
