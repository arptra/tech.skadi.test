package com.upuphone.xr.sapp.monitor.schedule.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH@¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/request/ScheduleErrorInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "account", "", "b", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScheduleErrorInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleErrorInterceptor.kt\ncom/upuphone/xr/sapp/monitor/schedule/request/ScheduleErrorInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n288#2,2:91\n*S KotlinDebug\n*F\n+ 1 ScheduleErrorInterceptor.kt\ncom/upuphone/xr/sapp/monitor/schedule/request/ScheduleErrorInterceptor\n*L\n41#1:91,2\n*E\n"})
public final class ScheduleErrorInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7793a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/request/ScheduleErrorInterceptor$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor$getFsToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor$getFsToken$1 r0 = (com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor$getFsToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor$getFsToken$1 r0 = new com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor$getFsToken$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            java.lang.Object r6 = r0.L$0
            com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r6 = (com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel) r6
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0072
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "ScheduleErrorInterceptor"
            java.lang.String r3 = "getFsToken"
            r5.a(r1, r3)
            com.upuphone.xr.sapp.monitor.schedule.ScheduleRequestManager r5 = com.upuphone.xr.sapp.monitor.schedule.ScheduleRequestManager.f7781a
            com.upuphone.xr.sapp.monitor.schedule.request.ScheduleApi r5 = r5.c()
            com.upuphone.xr.sapp.monitor.schedule.config.ScheduleConfig r1 = com.upuphone.xr.sapp.monitor.schedule.config.ScheduleConfig.f7785a
            com.upuphone.xr.sapp.monitor.schedule.config.LarkType r1 = r1.a()
            java.lang.String r1 = r1.name()
            com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel r3 = r6.d()
            if (r3 == 0) goto L_0x005d
            java.lang.String r3 = r3.b()
            if (r3 != 0) goto L_0x005f
        L_0x005d:
            java.lang.String r3 = ""
        L_0x005f:
            com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType r4 = r6.e()
            java.lang.String r4 = r4.name()
            r0.L$0 = r6
            r0.label = r2
            java.lang.Object r5 = r5.refreshToken(r1, r3, r4, r0)
            if (r5 != r7) goto L_0x0072
            return r7
        L_0x0072:
            com.upuphone.xr.sapp.monitor.schedule.model.BaseResp r5 = (com.upuphone.xr.sapp.monitor.schedule.model.BaseResp) r5
            int r7 = r5.a()
            if (r7 != 0) goto L_0x00ad
            java.lang.Object r7 = r5.b()
            if (r7 == 0) goto L_0x00ad
            com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel r7 = r6.d()
            if (r7 != 0) goto L_0x0087
            goto L_0x0094
        L_0x0087:
            java.lang.Object r0 = r5.b()
            com.upuphone.xr.sapp.monitor.schedule.model.RefreshTokenRespModel r0 = (com.upuphone.xr.sapp.monitor.schedule.model.RefreshTokenRespModel) r0
            java.lang.String r0 = r0.getAccessToken()
            r7.c(r0)
        L_0x0094:
            com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel r7 = r6.d()
            if (r7 != 0) goto L_0x009b
            goto L_0x00a8
        L_0x009b:
            java.lang.Object r5 = r5.b()
            com.upuphone.xr.sapp.monitor.schedule.model.RefreshTokenRespModel r5 = (com.upuphone.xr.sapp.monitor.schedule.model.RefreshTokenRespModel) r5
            java.lang.String r5 = r5.getRefreshToken()
            r7.d(r5)
        L_0x00a8:
            com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager r5 = com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager.f7776a
            r5.h(r6)
        L_0x00ad:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor.b(com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008f, code lost:
        r2 = r3.d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ScheduleErrorInterceptor"
            java.lang.String r1 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            okhttp3.Request r1 = r8.request()
            okhttp3.Response r8 = r8.proceed(r1)
            java.lang.String r2 = "accountId"
            java.lang.String r1 = r1.header(r2)
            if (r1 != 0) goto L_0x0019
            java.lang.String r1 = ""
        L_0x0019:
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x00f6
            okhttp3.ResponseBody r2 = r8.body()     // Catch:{ Exception -> 0x0086 }
            if (r2 == 0) goto L_0x00f6
            okio.BufferedSource r2 = r2.source()     // Catch:{ Exception -> 0x0086 }
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r2.request(r3)     // Catch:{ Exception -> 0x0086 }
            okio.Buffer r2 = r2.getBuffer()     // Catch:{ Exception -> 0x0086 }
            okio.Buffer r2 = r2.clone()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r2 = r2.readUtf8()     // Catch:{ Exception -> 0x0086 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0086 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r2 = "code"
            int r2 = r3.optInt(r2)     // Catch:{ Exception -> 0x0086 }
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x0086 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            r4.<init>()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r5 = "读取到code:"
            r4.append(r5)     // Catch:{ Exception -> 0x0086 }
            r4.append(r2)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0086 }
            r3.a(r0, r4)     // Catch:{ Exception -> 0x0086 }
            r3 = 10005(0x2715, float:1.402E-41)
            if (r2 != r3) goto L_0x00f6
            com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager r2 = com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager.f7776a     // Catch:{ Exception -> 0x0086 }
            java.util.List r2 = r2.e()     // Catch:{ Exception -> 0x0086 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0086 }
        L_0x006d:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0086 }
            r4 = 0
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0086 }
            r5 = r3
            com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r5 = (com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel) r5     // Catch:{ Exception -> 0x0086 }
            java.lang.String r5 = r5.c()     // Catch:{ Exception -> 0x0086 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0086 }
            if (r5 == 0) goto L_0x006d
            goto L_0x0089
        L_0x0086:
            r7 = move-exception
            goto L_0x00db
        L_0x0088:
            r3 = r4
        L_0x0089:
            com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r3 = (com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel) r3     // Catch:{ Exception -> 0x0086 }
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x0086 }
            if (r3 == 0) goto L_0x009a
            com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel r2 = r3.d()     // Catch:{ Exception -> 0x0086 }
            if (r2 == 0) goto L_0x009a
            java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x0086 }
            goto L_0x009b
        L_0x009a:
            r2 = r4
        L_0x009b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            r5.<init>()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r6 = "获取userAccessToken 之前:"
            r5.append(r6)     // Catch:{ Exception -> 0x0086 }
            r5.append(r2)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0086 }
            r1.a(r0, r2)     // Catch:{ Exception -> 0x0086 }
            if (r3 == 0) goto L_0x00f6
            com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor$intercept$1$1$1 r2 = new com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor$intercept$1$1$1     // Catch:{ Exception -> 0x0086 }
            r2.<init>(r3, r7, r4)     // Catch:{ Exception -> 0x0086 }
            r7 = 1
            java.lang.Object unused = kotlinx.coroutines.BuildersKt__BuildersKt.b(r4, r2, r7, r4)     // Catch:{ Exception -> 0x0086 }
            com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel r7 = r3.d()     // Catch:{ Exception -> 0x0086 }
            if (r7 == 0) goto L_0x00c5
            java.lang.String r4 = r7.a()     // Catch:{ Exception -> 0x0086 }
        L_0x00c5:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            r7.<init>()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r2 = "获取userAccessToken:"
            r7.append(r2)     // Catch:{ Exception -> 0x0086 }
            r7.append(r4)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0086 }
            r1.a(r0, r7)     // Catch:{ Exception -> 0x0086 }
            goto L_0x00f6
        L_0x00db:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "获取userAccessToken 异常:"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1.a(r0, r7)
        L_0x00f6:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
