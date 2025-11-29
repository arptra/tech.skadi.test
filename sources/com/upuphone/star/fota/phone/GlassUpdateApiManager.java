package com.upuphone.star.fota.phone;

import android.content.Context;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.xr.sapp.context.SdkContext;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH@¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000eH@¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\n\u001a\u00020\u0011H@¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001a2\u0006\u0010\u0019\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010&\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010%R\u0014\u0010.\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010%¨\u0006/"}, d2 = {"Lcom/upuphone/star/fota/phone/GlassUpdateApiManager;", "", "<init>", "()V", "", "enable", "", "e", "(Z)V", "Lcom/upuphone/star/fota/phone/CheckGlassUpdateParam;", "param", "Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;", "c", "(Lcom/upuphone/star/fota/phone/CheckGlassUpdateParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/star/fota/phone/CheckGlassUpdateParamV2;", "d", "(Lcom/upuphone/star/fota/phone/CheckGlassUpdateParamV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/star/fota/phone/GlassUpdateResultParam;", "Lcom/upuphone/star/fota/phone/BasicResult;", "k", "(Lcom/upuphone/star/fota/phone/GlassUpdateResultParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "url", "a", "(Ljava/lang/String;)Ljava/lang/String;", "data", "", "b", "(Ljava/lang/Object;)Ljava/util/Map;", "Lcom/upuphone/star/fota/phone/HostProvider;", "Lcom/upuphone/star/fota/phone/HostProvider;", "getHostProvider", "()Lcom/upuphone/star/fota/phone/HostProvider;", "j", "(Lcom/upuphone/star/fota/phone/HostProvider;)V", "hostProvider", "i", "()Ljava/lang/String;", "responseErrorMsg", "Landroid/content/Context;", "f", "()Landroid/content/Context;", "context", "g", "networkTimeoutMsg", "h", "requestFailedMsg", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassUpdateApiManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateApiManager.kt\ncom/upuphone/star/fota/phone/GlassUpdateApiManager\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,177:1\n124#1,17:178\n162#1,13:195\n124#1,17:208\n162#1,13:225\n124#1,17:238\n162#1,13:255\n162#1,13:268\n13309#2,2:281\n*S KotlinDebug\n*F\n+ 1 GlassUpdateApiManager.kt\ncom/upuphone/star/fota/phone/GlassUpdateApiManager\n*L\n95#1:178,17\n95#1:195,13\n106#1:208,17\n106#1:225,13\n116#1:238,17\n116#1:255,13\n140#1:268,13\n145#1:281,2\n*E\n"})
public final class GlassUpdateApiManager {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassUpdateApiManager f6471a = new GlassUpdateApiManager();
    public static HostProvider b;

    public final String a(String str) {
        String str2;
        HostProvider hostProvider = b;
        if (hostProvider == null || (str2 = hostProvider.a()) == null) {
            str2 = "https://xr-nbs.myvu.cn/ar-ota";
        }
        return str2 + str;
    }

    public final Map b(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object obj2 = field.get(obj);
            String obj3 = obj2 != null ? obj2.toString() : null;
            if (obj3 != null) {
                String name = field.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                linkedHashMap.put(name, obj3);
            }
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097 A[Catch:{ IOException -> 0x0036, all -> 0x0033 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(com.upuphone.star.fota.phone.CheckGlassUpdateParam r14, kotlin.coroutines.Continuation r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdate$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdate$1 r0 = (com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdate$1 r0 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdate$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "GlassUpdateApiManager"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0041
            if (r2 != r4) goto L_0x0039
            java.lang.Object r13 = r0.L$0
            com.upuphone.star.fota.phone.GlassUpdateApiManager r13 = (com.upuphone.star.fota.phone.GlassUpdateApiManager) r13
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            goto L_0x0098
        L_0x0033:
            r14 = move-exception
            goto L_0x00f9
        L_0x0036:
            r14 = move-exception
            goto L_0x011f
        L_0x0039:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0041:
            java.lang.Object r13 = r0.L$2
            java.util.SortedMap r13 = (java.util.SortedMap) r13
            java.lang.Object r14 = r0.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r2 = r0.L$0
            com.upuphone.star.fota.phone.GlassUpdateApiManager r2 = (com.upuphone.star.fota.phone.GlassUpdateApiManager) r2
            kotlin.ResultKt.throwOnFailure(r15)
            r9 = r13
            r8 = r14
            r13 = r2
            goto L_0x007f
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.String r15 = "/client/v1/arupgrade/check"
            java.lang.String r15 = r13.a(r15)
            java.util.Map r14 = r13.b(r14)
            java.util.SortedMap r14 = kotlin.collections.MapsKt.toSortedMap(r14)
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.a()
            com.upuphone.star.fota.phone.GlassUpdateApiManager$postResult$2 r7 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$postResult$2
            r7.<init>(r14, r6)
            r0.L$0 = r13
            r0.L$1 = r15
            r0.L$2 = r14
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.g(r2, r7, r0)
            if (r2 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r9 = r14
            r8 = r15
        L_0x007f:
            com.upuphone.star.httplib.HttpUtils r14 = com.upuphone.star.httplib.HttpUtils.f6479a     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r11 = 4
            r12 = 0
            r10 = 0
            r7 = r14
            okhttp3.Request r15 = com.upuphone.star.httplib.HttpUtils.h(r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$0 = r13     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$1 = r6     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$2 = r6     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.label = r4     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            java.lang.Object r15 = r14.b(r15, r0)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            if (r15 != r1) goto L_0x0098
            return r1
        L_0x0098:
            okhttp3.Response r15 = (okhttp3.Response) r15     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            boolean r14 = r15.isSuccessful()
            if (r14 != 0) goto L_0x00b3
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            int r1 = r15.code()
            java.lang.String r2 = r13.h()
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0143
        L_0x00b3:
            okhttp3.ResponseBody r14 = r15.body()
            if (r14 == 0) goto L_0x00e7
            java.lang.String r14 = r14.string()
            if (r14 != 0) goto L_0x00c0
            goto L_0x00e7
        L_0x00c0:
            com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdate$$inlined$postResult$1 r15 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdate$$inlined$postResult$1
            r15.<init>()
            java.lang.reflect.Type r15 = r15.getType()
            com.upuphone.star.fota.phone.utils.JsonUtils r0 = com.upuphone.star.fota.phone.utils.JsonUtils.f6474a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            java.lang.Object r14 = r0.a(r14, r15)
            com.upuphone.star.fota.phone.BasicResult r14 = (com.upuphone.star.fota.phone.BasicResult) r14
            if (r14 == 0) goto L_0x00d7
            goto L_0x0143
        L_0x00d7:
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r2 = r13.i()
            r4 = 4
            r5 = 0
            r1 = -10
            r3 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0143
        L_0x00e7:
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            com.upuphone.star.fota.phone.GlassUpdateApiManager r13 = f6471a
            java.lang.String r8 = r13.i()
            r10 = 4
            r11 = 0
            r7 = -10
            r9 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11)
            goto L_0x0143
        L_0x00f9:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "postResult-Throwable: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.c(r3, r14)
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r6 = r13.i()
            r8 = 4
            r9 = 0
            r5 = -10
            r7 = 0
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0143
        L_0x011f:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "postResult-IOException: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.c(r3, r14)
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r6 = r13.g()
            r8 = 4
            r9 = 0
            r5 = -1
            r7 = 0
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9)
        L_0x0143:
            com.upuphone.star.fota.phone.GlassCheckUpdateResult r13 = new com.upuphone.star.fota.phone.GlassCheckUpdateResult
            int r15 = r14.getCode()
            java.lang.String r0 = r14.getMsg()
            java.lang.Object r14 = r14.getData()
            com.upuphone.star.fota.phone.GlassUpdateInfo r14 = (com.upuphone.star.fota.phone.GlassUpdateInfo) r14
            r13.<init>(r15, r0, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.star.fota.phone.GlassUpdateApiManager.c(com.upuphone.star.fota.phone.CheckGlassUpdateParam, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097 A[Catch:{ IOException -> 0x0036, all -> 0x0033 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(com.upuphone.star.fota.phone.CheckGlassUpdateParamV2 r14, kotlin.coroutines.Continuation r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdateV2$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdateV2$1 r0 = (com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdateV2$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdateV2$1 r0 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdateV2$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "GlassUpdateApiManager"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0041
            if (r2 != r4) goto L_0x0039
            java.lang.Object r13 = r0.L$0
            com.upuphone.star.fota.phone.GlassUpdateApiManager r13 = (com.upuphone.star.fota.phone.GlassUpdateApiManager) r13
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            goto L_0x0098
        L_0x0033:
            r14 = move-exception
            goto L_0x00f9
        L_0x0036:
            r14 = move-exception
            goto L_0x011f
        L_0x0039:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0041:
            java.lang.Object r13 = r0.L$2
            java.util.SortedMap r13 = (java.util.SortedMap) r13
            java.lang.Object r14 = r0.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r2 = r0.L$0
            com.upuphone.star.fota.phone.GlassUpdateApiManager r2 = (com.upuphone.star.fota.phone.GlassUpdateApiManager) r2
            kotlin.ResultKt.throwOnFailure(r15)
            r9 = r13
            r8 = r14
            r13 = r2
            goto L_0x007f
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.String r15 = "/client/v1/arupgrade/checkV2"
            java.lang.String r15 = r13.a(r15)
            java.util.Map r14 = r13.b(r14)
            java.util.SortedMap r14 = kotlin.collections.MapsKt.toSortedMap(r14)
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.a()
            com.upuphone.star.fota.phone.GlassUpdateApiManager$postResult$2 r7 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$postResult$2
            r7.<init>(r14, r6)
            r0.L$0 = r13
            r0.L$1 = r15
            r0.L$2 = r14
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.g(r2, r7, r0)
            if (r2 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r9 = r14
            r8 = r15
        L_0x007f:
            com.upuphone.star.httplib.HttpUtils r14 = com.upuphone.star.httplib.HttpUtils.f6479a     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r11 = 4
            r12 = 0
            r10 = 0
            r7 = r14
            okhttp3.Request r15 = com.upuphone.star.httplib.HttpUtils.h(r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$0 = r13     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$1 = r6     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$2 = r6     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.label = r4     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            java.lang.Object r15 = r14.b(r15, r0)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            if (r15 != r1) goto L_0x0098
            return r1
        L_0x0098:
            okhttp3.Response r15 = (okhttp3.Response) r15     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            boolean r14 = r15.isSuccessful()
            if (r14 != 0) goto L_0x00b3
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            int r1 = r15.code()
            java.lang.String r2 = r13.h()
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0143
        L_0x00b3:
            okhttp3.ResponseBody r14 = r15.body()
            if (r14 == 0) goto L_0x00e7
            java.lang.String r14 = r14.string()
            if (r14 != 0) goto L_0x00c0
            goto L_0x00e7
        L_0x00c0:
            com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdateV2$$inlined$postResult$1 r15 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$checkUpdateV2$$inlined$postResult$1
            r15.<init>()
            java.lang.reflect.Type r15 = r15.getType()
            com.upuphone.star.fota.phone.utils.JsonUtils r0 = com.upuphone.star.fota.phone.utils.JsonUtils.f6474a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            java.lang.Object r14 = r0.a(r14, r15)
            com.upuphone.star.fota.phone.BasicResult r14 = (com.upuphone.star.fota.phone.BasicResult) r14
            if (r14 == 0) goto L_0x00d7
            goto L_0x0143
        L_0x00d7:
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r2 = r13.i()
            r4 = 4
            r5 = 0
            r1 = -10
            r3 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0143
        L_0x00e7:
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            com.upuphone.star.fota.phone.GlassUpdateApiManager r13 = f6471a
            java.lang.String r8 = r13.i()
            r10 = 4
            r11 = 0
            r7 = -10
            r9 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11)
            goto L_0x0143
        L_0x00f9:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "postResult-Throwable: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.c(r3, r14)
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r6 = r13.i()
            r8 = 4
            r9 = 0
            r5 = -10
            r7 = 0
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0143
        L_0x011f:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "postResult-IOException: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.c(r3, r14)
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r6 = r13.g()
            r8 = 4
            r9 = 0
            r5 = -1
            r7 = 0
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9)
        L_0x0143:
            com.upuphone.star.fota.phone.GlassCheckUpdateResult r13 = new com.upuphone.star.fota.phone.GlassCheckUpdateResult
            int r15 = r14.getCode()
            java.lang.String r0 = r14.getMsg()
            java.lang.Object r14 = r14.getData()
            com.upuphone.star.fota.phone.GlassUpdateInfo r14 = (com.upuphone.star.fota.phone.GlassUpdateInfo) r14
            r13.<init>(r15, r0, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.star.fota.phone.GlassUpdateApiManager.d(com.upuphone.star.fota.phone.CheckGlassUpdateParamV2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void e(boolean z) {
        HttpUtils.f6479a.k(z);
    }

    public final Context f() {
        return SdkContext.f6675a.c().getContext();
    }

    public final String g() {
        String string = f().getString(R.string.ota_network_timeout);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String h() {
        String string = f().getString(R.string.ota_request_failed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String i() {
        String string = f().getString(R.string.ota_response_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final void j(HostProvider hostProvider) {
        b = hostProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097 A[Catch:{ IOException -> 0x0036, all -> 0x0033 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(com.upuphone.star.fota.phone.GlassUpdateResultParam r14, kotlin.coroutines.Continuation r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.upuphone.star.fota.phone.GlassUpdateApiManager$uploadUpdateResult$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.upuphone.star.fota.phone.GlassUpdateApiManager$uploadUpdateResult$1 r0 = (com.upuphone.star.fota.phone.GlassUpdateApiManager$uploadUpdateResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.star.fota.phone.GlassUpdateApiManager$uploadUpdateResult$1 r0 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$uploadUpdateResult$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "GlassUpdateApiManager"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0041
            if (r2 != r4) goto L_0x0039
            java.lang.Object r13 = r0.L$0
            com.upuphone.star.fota.phone.GlassUpdateApiManager r13 = (com.upuphone.star.fota.phone.GlassUpdateApiManager) r13
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            goto L_0x0098
        L_0x0033:
            r14 = move-exception
            goto L_0x00f9
        L_0x0036:
            r14 = move-exception
            goto L_0x011f
        L_0x0039:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0041:
            java.lang.Object r13 = r0.L$2
            java.util.SortedMap r13 = (java.util.SortedMap) r13
            java.lang.Object r14 = r0.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r2 = r0.L$0
            com.upuphone.star.fota.phone.GlassUpdateApiManager r2 = (com.upuphone.star.fota.phone.GlassUpdateApiManager) r2
            kotlin.ResultKt.throwOnFailure(r15)
            r9 = r13
            r8 = r14
            r13 = r2
            goto L_0x007f
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.String r15 = "/client/v1/arupgrade/notify"
            java.lang.String r15 = r13.a(r15)
            java.util.Map r14 = r13.b(r14)
            java.util.SortedMap r14 = kotlin.collections.MapsKt.toSortedMap(r14)
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.a()
            com.upuphone.star.fota.phone.GlassUpdateApiManager$postResult$2 r7 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$postResult$2
            r7.<init>(r14, r6)
            r0.L$0 = r13
            r0.L$1 = r15
            r0.L$2 = r14
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.g(r2, r7, r0)
            if (r2 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r9 = r14
            r8 = r15
        L_0x007f:
            com.upuphone.star.httplib.HttpUtils r14 = com.upuphone.star.httplib.HttpUtils.f6479a     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r11 = 4
            r12 = 0
            r10 = 0
            r7 = r14
            okhttp3.Request r15 = com.upuphone.star.httplib.HttpUtils.h(r7, r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$0 = r13     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$1 = r6     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.L$2 = r6     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            r0.label = r4     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            java.lang.Object r15 = r14.b(r15, r0)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            if (r15 != r1) goto L_0x0098
            return r1
        L_0x0098:
            okhttp3.Response r15 = (okhttp3.Response) r15     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            boolean r14 = r15.isSuccessful()
            if (r14 != 0) goto L_0x00b3
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            int r1 = r15.code()
            java.lang.String r2 = r13.h()
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0143
        L_0x00b3:
            okhttp3.ResponseBody r14 = r15.body()
            if (r14 == 0) goto L_0x00e7
            java.lang.String r14 = r14.string()
            if (r14 != 0) goto L_0x00c0
            goto L_0x00e7
        L_0x00c0:
            com.upuphone.star.fota.phone.GlassUpdateApiManager$uploadUpdateResult$$inlined$postResult$1 r15 = new com.upuphone.star.fota.phone.GlassUpdateApiManager$uploadUpdateResult$$inlined$postResult$1
            r15.<init>()
            java.lang.reflect.Type r15 = r15.getType()
            com.upuphone.star.fota.phone.utils.JsonUtils r0 = com.upuphone.star.fota.phone.utils.JsonUtils.f6474a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            java.lang.Object r14 = r0.a(r14, r15)
            com.upuphone.star.fota.phone.BasicResult r14 = (com.upuphone.star.fota.phone.BasicResult) r14
            if (r14 == 0) goto L_0x00d7
            goto L_0x0143
        L_0x00d7:
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r2 = r13.i()
            r4 = 4
            r5 = 0
            r1 = -10
            r3 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0143
        L_0x00e7:
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            com.upuphone.star.fota.phone.GlassUpdateApiManager r13 = f6471a
            java.lang.String r8 = r13.i()
            r10 = 4
            r11 = 0
            r7 = -10
            r9 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11)
            goto L_0x0143
        L_0x00f9:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "postResult-Throwable: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.c(r3, r14)
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r6 = r13.i()
            r8 = 4
            r9 = 0
            r5 = -10
            r7 = 0
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0143
        L_0x011f:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "postResult-IOException: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.c(r3, r14)
            com.upuphone.star.fota.phone.BasicResult r14 = new com.upuphone.star.fota.phone.BasicResult
            java.lang.String r6 = r13.g()
            r8 = 4
            r9 = 0
            r5 = -1
            r7 = 0
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9)
        L_0x0143:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.star.fota.phone.GlassUpdateApiManager.k(com.upuphone.star.fota.phone.GlassUpdateResultParam, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
