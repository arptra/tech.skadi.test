package com.upuphone.xr.audio.record.ai.feedback;

import android.app.Activity;
import android.content.Intent;
import com.google.gson.Gson;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse;
import com.upuphone.xr.audio.record.ai.bean.AiFeedbackContent;
import com.upuphone.xr.audio.record.ui.widget.AudioFeedBackDialog;
import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u00020\n2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"J#\u0010%\u001a\u00020$2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010 H\u0002¢\u0006\u0004\b%\u0010&R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010,R\u001b\u00102\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b/\u00101¨\u00063"}, d2 = {"Lcom/upuphone/xr/audio/record/ai/feedback/AiFeedBackManager;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "data", "Lcom/upuphone/xr/audio/record/ai/feedback/ReportCallback;", "callback", "", "k", "(Landroid/app/Activity;Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;Lcom/upuphone/xr/audio/record/ai/feedback/ReportCallback;)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "feedbackType", "g", "(Ljava/util/ArrayList;)V", "", "url", "h", "(Ljava/lang/String;Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "code", "msg", "", "i", "(ILjava/lang/String;Z)V", "j", "Lcom/upuphone/xr/interconnect/entity/AccountInfo;", "d", "()Lcom/upuphone/xr/interconnect/entity/AccountInfo;", "", "f", "(Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;)Ljava/util/Map;", "map", "Lokhttp3/RequestBody;", "c", "(Ljava/util/Map;)Lokhttp3/RequestBody;", "b", "Ljava/util/ArrayList;", "mCurFeedbackCodes", "Lcom/upuphone/xr/audio/record/ai/feedback/ReportCallback;", "mReportCallback", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "mAiFeedBackRequest", "Lcom/google/gson/Gson;", "e", "Lkotlin/Lazy;", "()Lcom/google/gson/Gson;", "gson", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAiFeedBackManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiFeedBackManager.kt\ncom/upuphone/xr/audio/record/ai/feedback/AiFeedBackManager\n+ 2 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n*L\n1#1,163:1\n208#2:164\n*S KotlinDebug\n*F\n+ 1 AiFeedBackManager.kt\ncom/upuphone/xr/audio/record/ai/feedback/AiFeedBackManager\n*L\n67#1:164\n*E\n"})
public final class AiFeedBackManager {

    /* renamed from: a  reason: collision with root package name */
    public static final AiFeedBackManager f6560a = new AiFeedBackManager();
    public static final ArrayList b = new ArrayList();
    public static ReportCallback c;
    public static AiFeedBackRequest d;
    public static final Lazy e = LazyKt.lazy(AiFeedBackManager$gson$2.INSTANCE);

    public final RequestBody c(Map map) {
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return companion.create(parse, jSONObject);
    }

    public final AccountInfo d() {
        String a2 = SdkContext.f6675a.b().a();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("AiFeedBackManager", "getAccountInfo info = " + a2);
        if (!StringsKt.isBlank(a2)) {
            return (AccountInfo) e().fromJson(a2, AccountInfo.class);
        }
        delegate.c("AiFeedBackManager", "getAccountInfo accountInfo is null");
        return null;
    }

    public final Gson e() {
        return (Gson) e.getValue();
    }

    public final Map f(AiFeedBackRequest aiFeedBackRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("originType", "2");
        hashMap.put("feedbackType", String.valueOf(aiFeedBackRequest.b()));
        hashMap.put("traceId", aiFeedBackRequest.d());
        String json = e().toJson((Object) new AiFeedbackContent(aiFeedBackRequest.a()));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        hashMap.put("content", json);
        hashMap.put("feedbackCodes", b);
        hashMap.put("requestId", aiFeedBackRequest.c());
        AccountInfo d2 = d();
        String str = null;
        String str2 = d2 != null ? d2.mzUid : null;
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        hashMap.put("mzUid", str2);
        if (d2 != null) {
            str = d2.id;
        }
        if (str != null) {
            str3 = str;
        }
        hashMap.put("xjUid", str3);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("AiFeedBackManager", "getRequestMap query = " + hashMap);
        return hashMap;
    }

    public final void g(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "feedbackType");
        b.addAll(arrayList);
        String nbsUrl = SdkContext.f6675a.c().a().getNbsUrl();
        String str = nbsUrl + "/ai-records/client/v2/ai/feedback-ai-content";
        ULog.f6446a.o("AiFeedBackManager", "reportAiIllegalEvent start requestUrl = " + nbsUrl + ",url = " + str);
        AiFeedBackRequest aiFeedBackRequest = d;
        if (aiFeedBackRequest != null) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AiFeedBackManager$reportAiIllegalEvent$1$1(str, aiFeedBackRequest, (Continuation<? super AiFeedBackManager$reportAiIllegalEvent$1$1>) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cd A[SYNTHETIC, Splitter:B:23:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011b A[Catch:{ Exception -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0120 A[Catch:{ Exception -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0129 A[Catch:{ Exception -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013f A[Catch:{ Exception -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0140 A[Catch:{ Exception -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(java.lang.String r10, com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest r11, kotlin.coroutines.Continuation r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager$sendFeedBackReport$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager$sendFeedBackReport$1 r0 = (com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager$sendFeedBackReport$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager$sendFeedBackReport$1 r0 = new com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager$sendFeedBackReport$1
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = -1
            java.lang.String r4 = "AiFeedBackManager"
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 != r5) goto L_0x0034
            java.lang.Object r9 = r0.L$0
            com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager r9 = (com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x0031 }
            goto L_0x007d
        L_0x0031:
            r10 = move-exception
            goto L_0x0145
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r12)
            okhttp3.Request$Builder r12 = new okhttp3.Request$Builder
            r12.<init>()
            okhttp3.Request$Builder r10 = r12.url((java.lang.String) r10)
            java.util.Map r11 = r9.f(r11)
            okhttp3.RequestBody r11 = r9.c(r11)
            java.lang.String r12 = "POST"
            okhttp3.Request$Builder r10 = r10.method(r12, r11)
            okhttp3.Request r10 = r10.build()
            com.upuphone.xr.sapp.context.SdkContext r11 = com.upuphone.xr.sapp.context.SdkContext.f6675a     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.sapp.context.AppContext r11 = r11.c()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.star.httplib.HttpInstance r11 = r11.j()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager$sendFeedBackReport$$inlined$request$1 r12 = new com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager$sendFeedBackReport$$inlined$request$1     // Catch:{ Exception -> 0x0031 }
            r12.<init>()     // Catch:{ Exception -> 0x0031 }
            java.lang.reflect.Type r12 = r12.getType()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)     // Catch:{ Exception -> 0x0031 }
            r0.L$0 = r9     // Catch:{ Exception -> 0x0031 }
            r0.label = r5     // Catch:{ Exception -> 0x0031 }
            java.lang.Object r12 = r11.h(r10, r12, r0)     // Catch:{ Exception -> 0x0031 }
            if (r12 != r1) goto L_0x007d
            return r1
        L_0x007d:
            com.upuphone.star.httplib.HttpResult r12 = (com.upuphone.star.httplib.HttpResult) r12     // Catch:{ Exception -> 0x0031 }
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x0031 }
            boolean r11 = r12.e()     // Catch:{ Exception -> 0x0031 }
            int r0 = r12.a()     // Catch:{ Exception -> 0x0031 }
            java.lang.Object r1 = r12.b()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r12.c()     // Catch:{ Exception -> 0x0031 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0031 }
            r7.<init>()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r8 = "getFeedBackReport-> "
            r7.append(r8)     // Catch:{ Exception -> 0x0031 }
            r7.append(r12)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r8 = ",state = "
            r7.append(r8)     // Catch:{ Exception -> 0x0031 }
            r7.append(r11)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r11 = ",code = "
            r7.append(r11)     // Catch:{ Exception -> 0x0031 }
            r7.append(r0)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r11 = ",data = "
            r7.append(r11)     // Catch:{ Exception -> 0x0031 }
            r7.append(r1)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r11 = ",msg = "
            r7.append(r11)     // Catch:{ Exception -> 0x0031 }
            r7.append(r2)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0031 }
            r10.g(r4, r11)     // Catch:{ Exception -> 0x0031 }
            boolean r10 = r12.e()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r11 = ""
            if (r10 == 0) goto L_0x0113
            java.lang.Object r10 = r12.b()     // Catch:{ Exception -> 0x0031 }
            if (r10 == 0) goto L_0x0113
            java.lang.Object r10 = r12.b()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse r10 = (com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse) r10     // Catch:{ Exception -> 0x0031 }
            if (r10 == 0) goto L_0x0113
            int r10 = r10.a()     // Catch:{ Exception -> 0x0031 }
            if (r10 != 0) goto L_0x0113
            java.lang.Object r10 = r12.b()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse r10 = (com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse) r10     // Catch:{ Exception -> 0x0031 }
            if (r10 == 0) goto L_0x00ee
            int r10 = r10.a()     // Catch:{ Exception -> 0x0031 }
            goto L_0x00ef
        L_0x00ee:
            r10 = r6
        L_0x00ef:
            java.lang.Object r0 = r12.b()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse r0 = (com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse) r0     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x00ff
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x0031 }
            if (r0 != 0) goto L_0x00fe
            goto L_0x00ff
        L_0x00fe:
            r11 = r0
        L_0x00ff:
            java.lang.Object r12 = r12.b()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse r12 = (com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse) r12     // Catch:{ Exception -> 0x0031 }
            if (r12 == 0) goto L_0x010e
            boolean r12 = r12.b()     // Catch:{ Exception -> 0x0031 }
            if (r12 == 0) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r5 = r6
        L_0x010f:
            r9.j(r10, r11, r5)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0157
        L_0x0113:
            java.lang.Object r10 = r12.b()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse r10 = (com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse) r10     // Catch:{ Exception -> 0x0031 }
            if (r10 == 0) goto L_0x0120
            int r10 = r10.a()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0121
        L_0x0120:
            r10 = r3
        L_0x0121:
            java.lang.Object r0 = r12.b()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse r0 = (com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse) r0     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0131
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x0031 }
            if (r0 != 0) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r11 = r0
        L_0x0131:
            java.lang.Object r12 = r12.b()     // Catch:{ Exception -> 0x0031 }
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse r12 = (com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse) r12     // Catch:{ Exception -> 0x0031 }
            if (r12 == 0) goto L_0x0140
            boolean r12 = r12.b()     // Catch:{ Exception -> 0x0031 }
            if (r12 == 0) goto L_0x0140
            goto L_0x0141
        L_0x0140:
            r5 = r6
        L_0x0141:
            r9.i(r10, r11, r5)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0157
        L_0x0145:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r12 = "reportAiIllegalEvent request fail "
            r11.c(r4, r12)
            java.lang.String r10 = r10.getMessage()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r9.i(r3, r10, r6)
        L_0x0157:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager.h(java.lang.String, com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void i(int i, String str, boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new AiFeedBackManager$showFeedBackFail$1(new AiFeedBackResponse(i, str, z), (Continuation<? super AiFeedBackManager$showFeedBackFail$1>) null), 3, (Object) null);
    }

    public final void j(int i, String str, boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new AiFeedBackManager$showFeedBackSuccess$1(new AiFeedBackResponse(i, str, z), (Continuation<? super AiFeedBackManager$showFeedBackSuccess$1>) null), 3, (Object) null);
    }

    public final void k(Activity activity, AiFeedBackRequest aiFeedBackRequest, ReportCallback reportCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(aiFeedBackRequest, "data");
        Intrinsics.checkNotNullParameter(reportCallback, "callback");
        b.clear();
        c = reportCallback;
        d = aiFeedBackRequest;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("AiFeedBackManager", "showReportIllegalDialog mAiFeedBackRequest = " + aiFeedBackRequest);
        activity.startActivity(new Intent(activity, AudioFeedBackDialog.class));
    }
}
