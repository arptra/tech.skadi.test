package com.xjmz.myvu.account;

import com.upuphone.star.httplib.HttpInstance;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J#\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\t8\u0002XD¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0002XD¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/xjmz/myvu/account/UserLogOutHelper;", "", "<init>", "()V", "", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "", "", "map", "Lokhttp3/RequestBody;", "a", "(Ljava/util/Map;)Lokhttp3/RequestBody;", "Ljava/lang/String;", "TAG", "b", "queryUserLogoutApi", "Lcom/upuphone/star/httplib/HttpInstance;", "Lkotlin/Lazy;", "()Lcom/upuphone/star/httplib/HttpInstance;", "http", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUserLogOutHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserLogOutHelper.kt\ncom/xjmz/myvu/account/UserLogOutHelper\n+ 2 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n*L\n1#1,93:1\n208#2:94\n*S KotlinDebug\n*F\n+ 1 UserLogOutHelper.kt\ncom/xjmz/myvu/account/UserLogOutHelper\n*L\n72#1:94\n*E\n"})
public final class UserLogOutHelper {

    /* renamed from: a  reason: collision with root package name */
    public final String f8225a = "UserLogOutHelper";
    public final String b = "/account/query-user-cancel";
    public final Lazy c = LazyKt.lazy(UserLogOutHelper$http$2.INSTANCE);

    public final RequestBody a(Map map) {
        RequestBody.Companion companion = RequestBody.Companion;
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return companion.create(jSONObject, MediaType.Companion.parse("application/json; charset=utf-8"));
    }

    public final HttpInstance b() {
        return (HttpInstance) this.c.getValue();
    }

    public final void c() {
        AppUtils.f7842a.s();
        MzAccountManager.Companion companion = MzAccountManager.c;
        companion.b().f();
        companion.b().c();
        DataStoreUtils.e.a().e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.xjmz.myvu.account.UserLogOutHelper$queryUserLogout$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.xjmz.myvu.account.UserLogOutHelper$queryUserLogout$1 r0 = (com.xjmz.myvu.account.UserLogOutHelper$queryUserLogout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.account.UserLogOutHelper$queryUserLogout$1 r0 = new com.xjmz.myvu.account.UserLogOutHelper$queryUserLogout$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r9 = r0.L$2
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.xjmz.myvu.account.UserLogOutHelper r0 = (com.xjmz.myvu.account.UserLogOutHelper) r0
            kotlin.ResultKt.throwOnFailure(r10)
            r8 = r10
            r10 = r9
            r9 = r0
            r0 = r8
            goto L_0x00fa
        L_0x003a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.xr.sapp.common.MzAccountManager$Companion r10 = com.upuphone.xr.sapp.common.MzAccountManager.c
            boolean r2 = r10.c()
            if (r2 != 0) goto L_0x0059
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r9 = r9.f8225a
            java.lang.String r0 = "queryUserLogout-> 用户未登录，不查询用户是否注销"
            r10.a(r9, r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0059:
            com.upuphone.xr.sapp.config.NetConfig$Companion r2 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r4 = "sAccountService"
            java.lang.String r4 = r2.v(r4)
            java.lang.String r5 = r9.b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            com.upuphone.xr.sapp.common.MzAccountManager r10 = r10.b()
            androidx.lifecycle.LiveData r10 = r10.d()
            java.lang.Object r10 = r10.getValue()
            com.upuphone.xr.sapp.entity.AccountInfo r10 = (com.upuphone.xr.sapp.entity.AccountInfo) r10
            if (r10 == 0) goto L_0x0087
            java.lang.String r10 = r10.getId()
            goto L_0x0088
        L_0x0087:
            r10 = 0
        L_0x0088:
            if (r10 != 0) goto L_0x0096
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r9 = r9.f8225a
            java.lang.String r0 = "queryUserLogout-> userAccountId为空"
            r10.a(r9, r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0096:
            java.lang.String r5 = "userId"
            kotlin.Pair r10 = kotlin.TuplesKt.to(r5, r10)
            java.lang.String r5 = "accountType"
            java.lang.String r6 = "flyme"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r6)
            kotlin.Pair[] r10 = new kotlin.Pair[]{r10, r5}
            java.util.Map r10 = kotlin.collections.MapsKt.mapOf(r10)
            okhttp3.Request$Builder r5 = new okhttp3.Request$Builder
            r5.<init>()
            okhttp3.Request$Builder r5 = r5.url((java.lang.String) r4)
            java.lang.String r6 = "WR-ukey"
            java.lang.String r7 = r2.f()
            okhttp3.Request$Builder r5 = r5.addHeader(r6, r7)
            java.lang.String r6 = "WR-Client-Id"
            java.lang.String r2 = r2.d()
            okhttp3.Request$Builder r2 = r5.addHeader(r6, r2)
            java.lang.String r5 = "POST"
            okhttp3.RequestBody r6 = r9.a(r10)
            okhttp3.Request$Builder r2 = r2.method(r5, r6)
            okhttp3.Request r2 = r2.build()
            com.upuphone.star.httplib.HttpInstance r5 = r9.b()
            com.xjmz.myvu.account.UserLogOutHelper$queryUserLogout$$inlined$request$1 r6 = new com.xjmz.myvu.account.UserLogOutHelper$queryUserLogout$$inlined$request$1
            r6.<init>()
            java.lang.reflect.Type r6 = r6.getType()
            java.lang.String r7 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r0.L$0 = r9
            r0.L$1 = r4
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r0 = r5.h(r2, r6, r0)
            if (r0 != r1) goto L_0x00f9
            return r1
        L_0x00f9:
            r1 = r4
        L_0x00fa:
            com.upuphone.star.httplib.HttpResult r0 = (com.upuphone.star.httplib.HttpResult) r0
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r3 = r9.f8225a
            java.lang.String r4 = com.xjsd.xr.sapp.asr.utils.GsonHelper.toJson(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "queryUserLogout-> url: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = " queryMap:"
            r5.append(r1)
            r5.append(r10)
            java.lang.String r10 = " response:"
            r5.append(r10)
            r5.append(r4)
            java.lang.String r10 = r5.toString()
            r2.a(r3, r10)
            java.lang.Object r10 = r0.b()
            if (r10 == 0) goto L_0x016c
            java.lang.Object r10 = r0.b()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            com.upuphone.xr.sapp.entity.GetUserCancelResult r10 = (com.upuphone.xr.sapp.entity.GetUserCancelResult) r10
            com.upuphone.xr.sapp.entity.UserCancelInfo r10 = r10.getData()
            if (r10 == 0) goto L_0x016c
            java.lang.Object r10 = r0.b()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            com.upuphone.xr.sapp.entity.GetUserCancelResult r10 = (com.upuphone.xr.sapp.entity.GetUserCancelResult) r10
            com.upuphone.xr.sapp.entity.UserCancelInfo r10 = r10.getData()
            if (r10 == 0) goto L_0x0157
            java.lang.Boolean r10 = r10.getDeleted()
            if (r10 == 0) goto L_0x0157
            boolean r10 = r10.booleanValue()
            goto L_0x0158
        L_0x0157:
            r10 = 0
        L_0x0158:
            if (r10 == 0) goto L_0x0165
            java.lang.String r10 = r9.f8225a
            java.lang.String r0 = "queryUserLogout -> 查询到用户已注销，调用logout()"
            r2.a(r10, r0)
            r9.c()
            goto L_0x016c
        L_0x0165:
            java.lang.String r9 = r9.f8225a
            java.lang.String r10 = "queryUserLogout -> 查询到用户未注销"
            r2.a(r9, r10)
        L_0x016c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.account.UserLogOutHelper.d(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
