package com.upuphone.xr.sapp.contract;

import com.upuphone.star.httplib.HttpInstance;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0011\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/contract/CheckNaviSupportController;", "", "<init>", "()V", "", "countryCode", "", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/gson/Gson;", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lcom/upuphone/star/httplib/HttpInstance;", "b", "()Lcom/upuphone/star/httplib/HttpInstance;", "http", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCheckNaviSupportController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckNaviSupportController.kt\ncom/upuphone/xr/sapp/contract/CheckNaviSupportController\n+ 2 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n*L\n1#1,56:1\n208#2:57\n*S KotlinDebug\n*F\n+ 1 CheckNaviSupportController.kt\ncom/upuphone/xr/sapp/contract/CheckNaviSupportController\n*L\n46#1:57\n*E\n"})
public final class CheckNaviSupportController {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f6690a = LazyKt.lazy(CheckNaviSupportController$gson$2.INSTANCE);
    public final Lazy b = LazyKt.lazy(CheckNaviSupportController$http$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/contract/CheckNaviSupportController$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f3 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f5 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.contract.CheckNaviSupportController$checkNaviRegionSupport$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.contract.CheckNaviSupportController$checkNaviRegionSupport$1 r0 = (com.upuphone.xr.sapp.contract.CheckNaviSupportController$checkNaviRegionSupport$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.contract.CheckNaviSupportController$checkNaviRegionSupport$1 r0 = new com.upuphone.xr.sapp.contract.CheckNaviSupportController$checkNaviRegionSupport$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "checkNaviSupport-> "
            java.lang.String r4 = "CheckNaviSupportController"
            r5 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r5) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x002e }
            goto L_0x00b1
        L_0x002e:
            r7 = move-exception
            goto L_0x00fb
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "checkNaviRegionSupport-> countryCode = "
            r2.append(r6)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r9.c(r4, r2)
            com.upuphone.xr.sapp.config.NetConfig$Companion r2 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r6 = "myvuConfigService"
            java.lang.String r2 = r2.v(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = "/"
            r6.append(r2)
            java.lang.String r2 = "api/v2/kvs/def/myvu:navigation:nonsupport"
            r6.append(r2)
            java.lang.String r2 = "?locale="
            r6.append(r2)
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r2.<init>()
            okhttp3.Request$Builder r8 = r2.url((java.lang.String) r8)
            okhttp3.Request$Builder r8 = r8.get()
            java.lang.String r2 = "Content-Type"
            java.lang.String r6 = "application/x-www-form-urlencoded"
            okhttp3.Request$Builder r8 = r8.addHeader(r2, r6)
            okhttp3.Request r8 = r8.build()
            java.lang.String r2 = "checkNaviSupport"
            r9.g(r4, r2)     // Catch:{ Exception -> 0x002e }
            com.upuphone.star.httplib.HttpInstance r7 = r7.b()     // Catch:{ Exception -> 0x002e }
            com.upuphone.xr.sapp.contract.CheckNaviSupportController$checkNaviRegionSupport$$inlined$request$1 r9 = new com.upuphone.xr.sapp.contract.CheckNaviSupportController$checkNaviRegionSupport$$inlined$request$1     // Catch:{ Exception -> 0x002e }
            r9.<init>()     // Catch:{ Exception -> 0x002e }
            java.lang.reflect.Type r9 = r9.getType()     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)     // Catch:{ Exception -> 0x002e }
            r0.label = r5     // Catch:{ Exception -> 0x002e }
            java.lang.Object r9 = r7.h(r8, r9, r0)     // Catch:{ Exception -> 0x002e }
            if (r9 != r1) goto L_0x00b1
            return r1
        L_0x00b1:
            com.upuphone.star.httplib.HttpResult r9 = (com.upuphone.star.httplib.HttpResult) r9     // Catch:{ Exception -> 0x002e }
            java.lang.Object r7 = r9.b()     // Catch:{ Exception -> 0x002e }
            com.upuphone.xr.sapp.entity.CheckNaviSupportEntity r7 = (com.upuphone.xr.sapp.entity.CheckNaviSupportEntity) r7     // Catch:{ Exception -> 0x002e }
            if (r7 == 0) goto L_0x00c7
            com.upuphone.xr.sapp.entity.NaviSupportEntity r7 = r7.getData()     // Catch:{ Exception -> 0x002e }
            if (r7 == 0) goto L_0x00c7
            java.lang.String r7 = r7.getUval()     // Catch:{ Exception -> 0x002e }
            if (r7 != 0) goto L_0x00c9
        L_0x00c7:
            java.lang.String r7 = "1"
        L_0x00c9:
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x002e }
            java.lang.Object r0 = r9.b()     // Catch:{ Exception -> 0x002e }
            java.lang.String r0 = com.xjsd.xr.sapp.asr.utils.GsonHelper.toJson(r0)     // Catch:{ Exception -> 0x002e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002e }
            r1.<init>()     // Catch:{ Exception -> 0x002e }
            r1.append(r3)     // Catch:{ Exception -> 0x002e }
            r1.append(r0)     // Catch:{ Exception -> 0x002e }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x002e }
            r8.g(r4, r0)     // Catch:{ Exception -> 0x002e }
            boolean r8 = r9.e()     // Catch:{ Exception -> 0x002e }
            if (r8 == 0) goto L_0x00f5
            java.lang.String r8 = "0"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x002e }
            if (r7 == 0) goto L_0x00f5
            r7 = r5
            goto L_0x00f6
        L_0x00f5:
            r7 = 0
        L_0x00f6:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ Exception -> 0x002e }
            return r7
        L_0x00fb:
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.g(r4, r7)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.contract.CheckNaviSupportController.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final HttpInstance b() {
        return (HttpInstance) this.b.getValue();
    }
}
