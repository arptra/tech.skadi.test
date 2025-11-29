package com.upuphone.xr.sapp.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006J8\u0010\u000e\u001a\u00020\r2\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u0007j\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u0003`\t2\u0006\u0010\f\u001a\u00020\u000bH@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/request/FeedBackReq;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/entity/ConfigDataBean;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "deviceInfo", "", "b", "(Ljava/util/HashMap;Lcom/upuphone/xr/sapp/entity/DeviceInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFeedBackReq.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedBackReq.kt\ncom/upuphone/xr/sapp/request/FeedBackReq\n+ 2 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n*L\n1#1,78:1\n183#2:79\n*S KotlinDebug\n*F\n+ 1 FeedBackReq.kt\ncom/upuphone/xr/sapp/request/FeedBackReq\n*L\n29#1:79\n*E\n"})
public final class FeedBackReq {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7823a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/request/FeedBackReq$Companion;", "", "()V", "PROD_APP_ID", "", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.upuphone.xr.sapp.request.FeedBackReq$getConfig$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.upuphone.xr.sapp.request.FeedBackReq$getConfig$1 r0 = (com.upuphone.xr.sapp.request.FeedBackReq$getConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r6 = r0
            goto L_0x001a
        L_0x0014:
            com.upuphone.xr.sapp.request.FeedBackReq$getConfig$1 r0 = new com.upuphone.xr.sapp.request.FeedBackReq$getConfig$1
            r0.<init>(r7, r8)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r7 = r6.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            r1 = 1
            if (r0 == 0) goto L_0x0033
            if (r0 != r1) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0082
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r7)
            com.upuphone.xr.sapp.monitor.net.HttpConfig r7 = com.upuphone.xr.sapp.monitor.net.HttpConfig.f7742a
            com.upuphone.star.httplib.HttpInstance r7 = r7.d()
            com.upuphone.xr.sapp.config.NetConfig$Companion r0 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r2 = "feedbackService"
            java.lang.String r0 = r0.v(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "/v1/queryPage"
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = "appId"
            java.lang.String r3 = "19362850871626566290"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r3)
            kotlin.Pair[] r0 = new kotlin.Pair[]{r0}
            java.util.HashMap r4 = kotlin.collections.MapsKt.hashMapOf(r0)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            com.upuphone.xr.sapp.request.FeedBackReq$getConfig$$inlined$post$1 r0 = new com.upuphone.xr.sapp.request.FeedBackReq$getConfig$$inlined$post$1
            r0.<init>()
            java.lang.reflect.Type r5 = r0.getType()
            java.lang.String r0 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r6.label = r1
            r1 = r7
            java.lang.Object r7 = r1.f(r2, r3, r4, r5, r6)
            if (r7 != r8) goto L_0x0082
            return r8
        L_0x0082:
            com.upuphone.star.httplib.HttpResult r7 = (com.upuphone.star.httplib.HttpResult) r7
            java.lang.Object r7 = com.upuphone.star.httplib.HttpResultKt.a(r7)
            com.upuphone.xr.sapp.entity.BaseResultEntity r7 = (com.upuphone.xr.sapp.entity.BaseResultEntity) r7
            if (r7 == 0) goto L_0x00ad
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.Object r0 = r7.getData()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getConfig result:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "FeedBackReq"
            r8.a(r1, r0)
            java.lang.Object r7 = r7.getData()
            return r7
        L_0x00ad:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FeedBackReq.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(java.util.HashMap r17, com.upuphone.xr.sapp.entity.DeviceInfo r18, kotlin.coroutines.Continuation r19) {
        /*
            r16 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.upuphone.xr.sapp.request.FeedBackReq$uploadFeedback$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.upuphone.xr.sapp.request.FeedBackReq$uploadFeedback$1 r1 = (com.upuphone.xr.sapp.request.FeedBackReq$uploadFeedback$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0016
            int r2 = r2 - r3
            r1.label = r2
        L_0x0014:
            r7 = r1
            goto L_0x001e
        L_0x0016:
            com.upuphone.xr.sapp.request.FeedBackReq$uploadFeedback$1 r1 = new com.upuphone.xr.sapp.request.FeedBackReq$uploadFeedback$1
            r2 = r16
            r1.<init>(r2, r0)
            goto L_0x0014
        L_0x001e:
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r8 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r8) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00db
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = "appVersion"
            java.lang.String r2 = "2.40.51"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r0, r2)
            java.lang.String r0 = "phoneBrand"
            java.lang.String r2 = com.upuphone.xr.sapp.utils.AppInfoUtils.a()
            kotlin.Pair r10 = kotlin.TuplesKt.to(r0, r2)
            java.lang.String r0 = "phoneModel"
            java.lang.String r2 = com.upuphone.xr.sapp.utils.AppInfoUtils.b()
            kotlin.Pair r11 = kotlin.TuplesKt.to(r0, r2)
            java.lang.String r0 = "phoneOsSystem"
            java.lang.String r2 = com.upuphone.xr.sapp.utils.AppInfoUtils.c()
            kotlin.Pair r12 = kotlin.TuplesKt.to(r0, r2)
            java.lang.String r0 = r18.getRomVersion()
            java.lang.String r2 = ""
            if (r0 != 0) goto L_0x006a
            r0 = r2
        L_0x006a:
            java.lang.String r3 = "eyeFirmware"
            kotlin.Pair r13 = kotlin.TuplesKt.to(r3, r0)
            java.lang.String r0 = "eyeModel"
            java.lang.String r3 = r18.getModel()
            kotlin.Pair r14 = kotlin.TuplesKt.to(r0, r3)
            java.lang.String r0 = r18.getSerialNo()
            if (r0 != 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r2 = r0
        L_0x0082:
            java.lang.String r0 = "eyeSerialNum"
            kotlin.Pair r15 = kotlin.TuplesKt.to(r0, r2)
            kotlin.Pair[] r0 = new kotlin.Pair[]{r9, r10, r11, r12, r13, r14, r15}
            java.util.HashMap r4 = kotlin.collections.MapsKt.hashMapOf(r0)
            r0 = r17
            r4.putAll(r0)
            com.upuphone.xr.sapp.monitor.net.HttpConfig r0 = com.upuphone.xr.sapp.monitor.net.HttpConfig.f7742a
            com.upuphone.star.httplib.HttpInstance r2 = r0.d()
            com.upuphone.xr.sapp.config.NetConfig$Companion r0 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r3 = "feedbackService"
            java.lang.String r0 = r0.v(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "/v1/uploadFeedback"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = "appId"
            java.lang.String r5 = "19362850871626566290"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r5)
            kotlin.Pair[] r0 = new kotlin.Pair[]{r0}
            java.util.HashMap r5 = kotlin.collections.MapsKt.hashMapOf(r0)
            com.upuphone.xr.sapp.request.FeedBackReq$uploadFeedback$2 r0 = new com.upuphone.xr.sapp.request.FeedBackReq$uploadFeedback$2
            r0.<init>()
            java.lang.reflect.Type r6 = r0.getType()
            java.lang.String r0 = "getType(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            r7.label = r8
            java.lang.Object r0 = r2.g(r3, r4, r5, r6, r7)
            if (r0 != r1) goto L_0x00db
            return r1
        L_0x00db:
            com.upuphone.star.httplib.HttpResult r0 = (com.upuphone.star.httplib.HttpResult) r0
            java.lang.Object r0 = com.upuphone.star.httplib.HttpResultKt.a(r0)
            if (r0 == 0) goto L_0x0101
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "uploadFeedback result:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "FeedBackReq"
            r1.a(r2, r0)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r0
        L_0x0101:
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FeedBackReq.b(java.util.HashMap, com.upuphone.xr.sapp.entity.DeviceInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
