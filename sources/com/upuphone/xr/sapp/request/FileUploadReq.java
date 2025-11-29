package com.upuphone.xr.sapp.request;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\b\u0010\tJS\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rH@¢\u0006\u0004\b\u0014\u0010\u0015JS\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rH@¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006H@¢\u0006\u0004\b\u001c\u0010\tJ\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0004H@¢\u0006\u0004\b\u001d\u0010\u001eJI\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rH@¢\u0006\u0004\b\u001f\u0010 J8\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rH@¢\u0006\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/upuphone/xr/sapp/request/FileUploadReq;", "", "<init>", "()V", "", "ossFileName", "", "expiration", "h", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "file", "fileName", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "progressCall", "f", "(Ljava/io/File;Ljava/lang/String;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/net/Uri;", "uri", "n", "(Landroid/net/Uri;Ljava/lang/String;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "size", "Lcom/upuphone/xr/sapp/request/ResponseUploadSign;", "i", "k", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "(Ljava/io/File;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFileUploadReq.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUploadReq.kt\ncom/upuphone/xr/sapp/request/FileUploadReq\n+ 2 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n*L\n1#1,321:1\n178#2,6:322\n178#2,6:328\n92#2,5:334\n*S KotlinDebug\n*F\n+ 1 FileUploadReq.kt\ncom/upuphone/xr/sapp/request/FileUploadReq\n*L\n53#1:322,6\n76#1:328,6\n96#1:334,5\n*E\n"})
public final class FileUploadReq {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7824a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/request/FileUploadReq$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ Object g(FileUploadReq fileUploadReq, File file, String str, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 86400;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            function1 = null;
        }
        return fileUploadReq.f(file, str, j2, function1, continuation);
    }

    public static final void m(Function1 function1, long j, long j2) {
        double d = (((double) j) / ((double) j2)) * ((double) 100);
        if (function1 != null) {
            function1.invoke(Double.valueOf(d));
        }
    }

    public static /* synthetic */ Object o(FileUploadReq fileUploadReq, Uri uri, String str, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 86400;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            function1 = null;
        }
        return fileUploadReq.n(uri, str, j2, function1, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(java.io.File r8, java.lang.String r9, long r10, kotlin.jvm.functions.Function1 r12, kotlin.coroutines.Continuation r13) {
        /*
            r7 = this;
            boolean r0 = r13 instanceof com.upuphone.xr.sapp.request.FileUploadReq$fileToOssFileUrl$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.upuphone.xr.sapp.request.FileUploadReq$fileToOssFileUrl$1 r0 = (com.upuphone.xr.sapp.request.FileUploadReq$fileToOssFileUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.request.FileUploadReq$fileToOssFileUrl$1 r0 = new com.upuphone.xr.sapp.request.FileUploadReq$fileToOssFileUrl$1
            r0.<init>(r7, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "FileUploadReq"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0077
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            long r10 = r0.J$0
            java.lang.Object r7 = r0.L$0
            com.upuphone.xr.sapp.request.FileUploadReq r7 = (com.upuphone.xr.sapp.request.FileUploadReq) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0066
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.star.core.log.ULog$Delegate r13 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "fileToOssFileUrl fileName"
            r2.append(r6)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            r13.a(r3, r2)
            r0.L$0 = r7
            r0.J$0 = r10
            r0.label = r5
            java.lang.Object r13 = r7.l(r8, r9, r12, r0)
            if (r13 != r1) goto L_0x0066
            return r1
        L_0x0066:
            java.lang.String r13 = (java.lang.String) r13
            r8 = 0
            if (r13 != 0) goto L_0x006c
            return r8
        L_0x006c:
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r13 = r7.h(r13, r10, r0)
            if (r13 != r1) goto L_0x0077
            return r1
        L_0x0077:
            java.lang.String r13 = (java.lang.String) r13
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "uploadFileToOss "
            r8.append(r9)
            r8.append(r13)
            java.lang.String r8 = r8.toString()
            r7.c(r3, r8)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FileUploadReq.f(java.io.File, java.lang.String, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(java.lang.String r6, long r7, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$1 r0 = (com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$1 r0 = new com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$1
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0039
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0070
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004e
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$requestUrl$1 r1 = new com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$requestUrl$1
            r1.<init>(r7, r6, r4)
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.BuildersKt.g(r5, r1, r0)
            if (r5 != r9) goto L_0x004e
            return r9
        L_0x004e:
            java.lang.String r5 = (java.lang.String) r5
            com.upuphone.xr.sapp.monitor.net.HttpConfig r6 = com.upuphone.xr.sapp.monitor.net.HttpConfig.f7742a
            com.upuphone.star.httplib.HttpInstance r6 = r6.d()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$$inlined$get$default$1 r7 = new com.upuphone.xr.sapp.request.FileUploadReq$getFileOssUrl$$inlined$get$default$1
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getType()
            java.lang.String r8 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r0.label = r2
            java.lang.Object r5 = r6.d(r5, r4, r7, r0)
            if (r5 != r9) goto L_0x0070
            return r9
        L_0x0070:
            com.upuphone.star.httplib.HttpResult r5 = (com.upuphone.star.httplib.HttpResult) r5
            java.lang.Object r5 = com.upuphone.star.httplib.HttpResultKt.a(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0093
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getFileOssUrl "
            r7.append(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "FileUploadReq"
            r6.a(r8, r7)
            return r5
        L_0x0093:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FileUploadReq.h(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0099 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(java.lang.String r10, long r11, kotlin.coroutines.Continuation r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$1 r0 = (com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$1) r0
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
            com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$1 r0 = new com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$1
            r0.<init>(r9, r13)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r9 = r6.result
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            r7 = 0
            java.lang.String r8 = "FileUploadReq"
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x003d
            if (r0 == r2) goto L_0x0039
            if (r0 != r1) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009a
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0070
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "getUploadSign fileName:"
            r0.append(r3)
            r0.append(r10)
            java.lang.String r3 = " size:"
            r0.append(r3)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r9.a(r8, r0)
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$requestUrl$1 r0 = new com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$requestUrl$1
            r0.<init>(r10, r11, r7)
            r6.label = r2
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r9, r0, r6)
            if (r9 != r13) goto L_0x0070
            return r13
        L_0x0070:
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            com.upuphone.xr.sapp.monitor.net.HttpConfig r9 = com.upuphone.xr.sapp.monitor.net.HttpConfig.f7742a
            com.upuphone.star.httplib.HttpInstance r9 = r9.d()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$$inlined$post$default$1 r10 = new com.upuphone.xr.sapp.request.FileUploadReq$getUploadSign$$inlined$post$default$1
            r10.<init>()
            java.lang.reflect.Type r5 = r10.getType()
            java.lang.String r10 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)
            r6.label = r1
            r4 = 0
            r1 = r9
            java.lang.Object r9 = r1.f(r2, r3, r4, r5, r6)
            if (r9 != r13) goto L_0x009a
            return r13
        L_0x009a:
            com.upuphone.star.httplib.HttpResult r9 = (com.upuphone.star.httplib.HttpResult) r9
            java.lang.Object r9 = com.upuphone.star.httplib.HttpResultKt.a(r9)
            com.upuphone.xr.sapp.entity.BaseResultEntity r9 = (com.upuphone.xr.sapp.entity.BaseResultEntity) r9
            if (r9 == 0) goto L_0x00c3
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.Object r11 = r9.getData()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "getUploadSign result:"
            r12.append(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.a(r8, r11)
            java.lang.Object r9 = r9.getData()
            return r9
        L_0x00c3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FileUploadReq.i(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: okhttp3.Response} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(android.net.Uri r23, java.lang.String r24, kotlin.jvm.functions.Function1 r25, kotlin.coroutines.Continuation r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r26
            boolean r4 = r3 instanceof com.upuphone.xr.sapp.request.FileUploadReq$uploadByUri$1
            if (r4 == 0) goto L_0x001b
            r4 = r3
            com.upuphone.xr.sapp.request.FileUploadReq$uploadByUri$1 r4 = (com.upuphone.xr.sapp.request.FileUploadReq$uploadByUri$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x0020
        L_0x001b:
            com.upuphone.xr.sapp.request.FileUploadReq$uploadByUri$1 r4 = new com.upuphone.xr.sapp.request.FileUploadReq$uploadByUri$1
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 2
            r8 = 1
            java.lang.String r9 = "FileUploadReq"
            r10 = 0
            if (r6 == 0) goto L_0x006d
            if (r6 == r8) goto L_0x004d
            if (r6 != r7) goto L_0x0045
            java.lang.Object r0 = r4.L$1
            r1 = r0
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r4.L$0
            com.upuphone.xr.sapp.request.ResponseUploadSign r0 = (com.upuphone.xr.sapp.request.ResponseUploadSign) r0
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0041 }
            goto L_0x0161
        L_0x0041:
            r0 = move-exception
            r2 = r0
            goto L_0x0192
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004d:
            long r0 = r4.J$0
            java.lang.Object r2 = r4.L$5
            android.os.ParcelFileDescriptor r2 = (android.os.ParcelFileDescriptor) r2
            java.lang.Object r6 = r4.L$4
            android.content.ContentResolver r6 = (android.content.ContentResolver) r6
            java.lang.Object r8 = r4.L$3
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r11 = r4.L$2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r4.L$1
            android.net.Uri r12 = (android.net.Uri) r12
            java.lang.Object r13 = r4.L$0
            com.upuphone.xr.sapp.request.FileUploadReq r13 = (com.upuphone.xr.sapp.request.FileUploadReq) r13
            kotlin.ResultKt.throwOnFailure(r3)
            r19 = r8
            goto L_0x00c3
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r3)
            android.content.Context r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            android.content.ContentResolver r6 = r3.getContentResolver()
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r3 = r6.openFileDescriptor(r1, r3)     // Catch:{ FileNotFoundException -> 0x0199 }
            if (r3 != 0) goto L_0x0089
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "无法打开文件描述符"
            r0.c(r9, r1)
            return r10
        L_0x0089:
            long r11 = r3.getStatSize()
            r13 = 0
            int r13 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r13 > 0) goto L_0x009f
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "无效文件大小"
            r0.c(r9, r1)
            r3.close()
            return r10
        L_0x009f:
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r2
            r13 = r25
            r4.L$3 = r13
            r4.L$4 = r6
            r4.L$5 = r3
            r4.J$0 = r11
            r4.label = r8
            java.lang.Object r8 = r0.i(r2, r11, r4)
            if (r8 != r5) goto L_0x00b8
            return r5
        L_0x00b8:
            r19 = r13
            r13 = r0
            r20 = r11
            r12 = r1
            r11 = r2
            r2 = r3
            r3 = r8
            r0 = r20
        L_0x00c3:
            com.upuphone.xr.sapp.request.ResponseUploadSign r3 = (com.upuphone.xr.sapp.request.ResponseUploadSign) r3
            if (r3 != 0) goto L_0x00c8
            return r10
        L_0x00c8:
            java.lang.String r8 = r6.getType(r12)
            if (r8 != 0) goto L_0x00ee
            android.webkit.MimeTypeMap r8 = android.webkit.MimeTypeMap.getSingleton()
            r14 = 46
            java.lang.String r15 = ""
            java.lang.String r11 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r11, (char) r14, (java.lang.String) r15)
            java.util.Locale r14 = java.util.Locale.ROOT
            java.lang.String r11 = r11.toLowerCase(r14)
            java.lang.String r14 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r14)
            java.lang.String r8 = r8.getMimeTypeFromExtension(r11)
            if (r8 != 0) goto L_0x00ee
            java.lang.String r8 = "application/octet-stream"
        L_0x00ee:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            java.io.InputStream r18 = r6.openInputStream(r12)
            if (r18 != 0) goto L_0x0103
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "无法打开输入流"
            r0.c(r9, r1)
            r2.close()
            return r10
        L_0x0103:
            com.upuphone.xr.sapp.request.FileUploadReq$uploadByUri$requestBody$1 r6 = new com.upuphone.xr.sapp.request.FileUploadReq$uploadByUri$requestBody$1
            r14 = r6
            r15 = r8
            r16 = r0
            r14.<init>(r15, r16, r18, r19)
            okhttp3.Request$Builder r11 = new okhttp3.Request$Builder
            r11.<init>()
            java.lang.String r12 = r3.getUrl()
            okhttp3.Request$Builder r11 = r11.url((java.lang.String) r12)
            okhttp3.Request$Builder r6 = r11.put(r6)
            java.lang.String r11 = "Content-Length"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            okhttp3.Request$Builder r0 = r6.header(r11, r0)
            java.lang.String r1 = "Content-Type"
            okhttp3.Request$Builder r0 = r0.header(r1, r8)
            okhttp3.Request r0 = r0.build()
            okhttp3.OkHttpClient r1 = new okhttp3.OkHttpClient
            r1.<init>()
            okhttp3.Call r0 = r1.newCall(r0)
            okhttp3.Response r1 = r0.execute()
            r2.close()     // Catch:{ all -> 0x0041 }
            boolean r0 = r1.isSuccessful()     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x0166
            java.lang.String r0 = r3.getName()     // Catch:{ all -> 0x0041 }
            r4.L$0 = r3     // Catch:{ all -> 0x0041 }
            r4.L$1 = r1     // Catch:{ all -> 0x0041 }
            r4.L$2 = r10     // Catch:{ all -> 0x0041 }
            r4.L$3 = r10     // Catch:{ all -> 0x0041 }
            r4.L$4 = r10     // Catch:{ all -> 0x0041 }
            r4.L$5 = r10     // Catch:{ all -> 0x0041 }
            r4.label = r7     // Catch:{ all -> 0x0041 }
            java.lang.Object r0 = r13.k(r0, r4)     // Catch:{ all -> 0x0041 }
            if (r0 != r5) goto L_0x0160
            return r5
        L_0x0160:
            r0 = r3
        L_0x0161:
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0041 }
            goto L_0x018e
        L_0x0166:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0041 }
            int r2 = r1.code()     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = r1.message()     // Catch:{ all -> 0x0041 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r4.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = "上传失败: "
            r4.append(r5)     // Catch:{ all -> 0x0041 }
            r4.append(r2)     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = " - "
            r4.append(r2)     // Catch:{ all -> 0x0041 }
            r4.append(r3)     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0041 }
            r0.c(r9, r2)     // Catch:{ all -> 0x0041 }
            r0 = r10
        L_0x018e:
            kotlin.io.CloseableKt.closeFinally(r1, r10)
            return r0
        L_0x0192:
            throw r2     // Catch:{ all -> 0x0193 }
        L_0x0193:
            r0 = move-exception
            r3 = r0
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r3
        L_0x0199:
            r0 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "文件不存在: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.c(r9, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FileUploadReq.j(android.net.Uri, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$1 r0 = (com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$1) r0
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
            com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$1 r0 = new com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$1
            r0.<init>(r8, r10)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r8 = r6.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            java.lang.String r7 = "FileUploadReq"
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x003c
            if (r0 == r2) goto L_0x0038
            if (r0 != r1) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0093
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0069
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "uploadConfirm fileName"
            r0.append(r3)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r8.a(r7, r0)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$requestUrl$1 r0 = new com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$requestUrl$1
            r3 = 0
            r0.<init>(r9, r3)
            r6.label = r2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r8, r0, r6)
            if (r8 != r10) goto L_0x0069
            return r10
        L_0x0069:
            r2 = r8
            java.lang.String r2 = (java.lang.String) r2
            com.upuphone.xr.sapp.monitor.net.HttpConfig r8 = com.upuphone.xr.sapp.monitor.net.HttpConfig.f7742a
            com.upuphone.star.httplib.HttpInstance r8 = r8.d()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$$inlined$post$default$1 r9 = new com.upuphone.xr.sapp.request.FileUploadReq$uploadConfirm$$inlined$post$default$1
            r9.<init>()
            java.lang.reflect.Type r5 = r9.getType()
            java.lang.String r9 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r6.label = r1
            r4 = 0
            r1 = r8
            java.lang.Object r8 = r1.f(r2, r3, r4, r5, r6)
            if (r8 != r10) goto L_0x0093
            return r10
        L_0x0093:
            com.upuphone.star.httplib.HttpResult r8 = (com.upuphone.star.httplib.HttpResult) r8
            java.lang.Object r8 = com.upuphone.star.httplib.HttpResultKt.a(r8)
            com.upuphone.xr.sapp.entity.BaseResultEntity r8 = (com.upuphone.xr.sapp.entity.BaseResultEntity) r8
            if (r8 == 0) goto L_0x00b8
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.Object r8 = r8.getData()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "uploadConfirm "
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.c(r7, r8)
        L_0x00b8:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FileUploadReq.k(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: java.io.File} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(java.io.File r11, java.lang.String r12, kotlin.jvm.functions.Function1 r13, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.upuphone.xr.sapp.request.FileUploadReq$uploadFile$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.xr.sapp.request.FileUploadReq$uploadFile$1 r0 = (com.upuphone.xr.sapp.request.FileUploadReq$uploadFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.request.FileUploadReq$uploadFile$1 r0 = new com.upuphone.xr.sapp.request.FileUploadReq$uploadFile$1
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            java.lang.String r5 = "FileUploadReq"
            r6 = 0
            if (r2 == 0) goto L_0x005a
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r10 = r0.L$1
            java.io.Closeable r10 = (java.io.Closeable) r10
            java.lang.Object r11 = r0.L$0
            com.upuphone.xr.sapp.request.ResponseUploadSign r11 = (com.upuphone.xr.sapp.request.ResponseUploadSign) r11
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0038 }
            goto L_0x0157
        L_0x0038:
            r11 = move-exception
            goto L_0x0171
        L_0x003b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0043:
            java.lang.Object r10 = r0.L$3
            r13 = r10
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            java.lang.Object r10 = r0.L$2
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r0.L$1
            r11 = r10
            java.io.File r11 = (java.io.File) r11
            java.lang.Object r10 = r0.L$0
            com.upuphone.xr.sapp.request.FileUploadReq r10 = (com.upuphone.xr.sapp.request.FileUploadReq) r10
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0089
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "uploadFile fileName"
            r2.append(r7)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r14.a(r5, r2)
            long r7 = r11.length()
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.label = r4
            java.lang.Object r14 = r10.i(r12, r7, r0)
            if (r14 != r1) goto L_0x0089
            return r1
        L_0x0089:
            com.upuphone.xr.sapp.request.ResponseUploadSign r14 = (com.upuphone.xr.sapp.request.ResponseUploadSign) r14
            if (r14 != 0) goto L_0x008e
            return r6
        L_0x008e:
            boolean r2 = r11.exists()
            if (r2 != 0) goto L_0x009d
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r11 = "文件不不存在~"
            r10.c(r5, r11)
            return r6
        L_0x009d:
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            r7 = 46
            java.lang.String r8 = ""
            java.lang.String r12 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r12, (char) r7, (java.lang.String) r8)
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r12 = r12.toLowerCase(r7)
            java.lang.String r7 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r7)
            java.lang.String r12 = r2.getMimeTypeFromExtension(r12)
            if (r12 != 0) goto L_0x00bd
            java.lang.String r12 = "application/octet-stream"
        L_0x00bd:
            okhttp3.RequestBody$Companion r2 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r7 = okhttp3.MediaType.Companion
            okhttp3.MediaType r7 = r7.parse(r12)
            okhttp3.RequestBody r2 = r2.create((java.io.File) r11, (okhttp3.MediaType) r7)
            com.upuphone.xr.sapp.utils.CountingRequestBody r7 = new com.upuphone.xr.sapp.utils.CountingRequestBody
            com.honey.account.s8.a r8 = new com.honey.account.s8.a
            r8.<init>(r13)
            r7.<init>(r2, r8)
            okhttp3.Request$Builder r13 = new okhttp3.Request$Builder
            r13.<init>()
            java.lang.String r2 = r14.getUrl()
            okhttp3.Request$Builder r13 = r13.url((java.lang.String) r2)
            okhttp3.Request$Builder r13 = r13.put(r7)
            long r7 = r11.length()
            java.lang.String r11 = java.lang.String.valueOf(r7)
            java.lang.String r2 = "Content-Length"
            okhttp3.Request$Builder r11 = r13.header(r2, r11)
            java.lang.String r13 = "Content-Type"
            okhttp3.Request$Builder r11 = r11.header(r13, r12)
            okhttp3.Request r11 = r11.build()
            okhttp3.OkHttpClient r12 = new okhttp3.OkHttpClient     // Catch:{ Exception -> 0x0169 }
            r12.<init>()     // Catch:{ Exception -> 0x0169 }
            okhttp3.OkHttpClient$Builder r12 = r12.newBuilder()     // Catch:{ Exception -> 0x0169 }
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0169 }
            r7 = 10
            okhttp3.OkHttpClient$Builder r12 = r12.readTimeout(r7, r13)     // Catch:{ Exception -> 0x0169 }
            r7 = 15
            okhttp3.OkHttpClient$Builder r12 = r12.connectTimeout(r7, r13)     // Catch:{ Exception -> 0x0169 }
            okhttp3.OkHttpClient r12 = r12.build()     // Catch:{ Exception -> 0x0169 }
            okhttp3.Call r11 = r12.newCall(r11)     // Catch:{ Exception -> 0x0169 }
            okhttp3.Response r11 = r11.execute()     // Catch:{ Exception -> 0x0169 }
            int r12 = r11.code()     // Catch:{ all -> 0x015c }
            com.upuphone.star.core.log.ULog$Delegate r13 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x015c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015c }
            r2.<init>()     // Catch:{ all -> 0x015c }
            java.lang.String r7 = "uploadFile statusCode"
            r2.append(r7)     // Catch:{ all -> 0x015c }
            r2.append(r12)     // Catch:{ all -> 0x015c }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x015c }
            r13.a(r5, r12)     // Catch:{ all -> 0x015c }
            boolean r12 = r11.isSuccessful()     // Catch:{ all -> 0x015c }
            if (r12 != r4) goto L_0x0161
            java.lang.String r12 = r14.getName()     // Catch:{ all -> 0x015c }
            r0.L$0 = r14     // Catch:{ all -> 0x015c }
            r0.L$1 = r11     // Catch:{ all -> 0x015c }
            r0.L$2 = r6     // Catch:{ all -> 0x015c }
            r0.L$3 = r6     // Catch:{ all -> 0x015c }
            r0.label = r3     // Catch:{ all -> 0x015c }
            java.lang.Object r10 = r10.k(r12, r0)     // Catch:{ all -> 0x015c }
            if (r10 != r1) goto L_0x0155
            return r1
        L_0x0155:
            r10 = r11
            r11 = r14
        L_0x0157:
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0038 }
            goto L_0x0165
        L_0x015c:
            r10 = move-exception
            r9 = r11
            r11 = r10
            r10 = r9
            goto L_0x0171
        L_0x0161:
            if (r12 != 0) goto L_0x016b
            r10 = r11
            r11 = r6
        L_0x0165:
            kotlin.io.CloseableKt.closeFinally(r10, r6)     // Catch:{ Exception -> 0x0169 }
            return r11
        L_0x0169:
            r10 = move-exception
            goto L_0x0177
        L_0x016b:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x015c }
            r10.<init>()     // Catch:{ all -> 0x015c }
            throw r10     // Catch:{ all -> 0x015c }
        L_0x0171:
            throw r11     // Catch:{ all -> 0x0172 }
        L_0x0172:
            r12 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r11)     // Catch:{ Exception -> 0x0169 }
            throw r12     // Catch:{ Exception -> 0x0169 }
        L_0x0177:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "上传文件失败 "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = "~"
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.c(r5, r10)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FileUploadReq.l(java.io.File, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(android.net.Uri r8, java.lang.String r9, long r10, kotlin.jvm.functions.Function1 r12, kotlin.coroutines.Continuation r13) {
        /*
            r7 = this;
            boolean r0 = r13 instanceof com.upuphone.xr.sapp.request.FileUploadReq$uriToOssFileUrl$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.upuphone.xr.sapp.request.FileUploadReq$uriToOssFileUrl$1 r0 = (com.upuphone.xr.sapp.request.FileUploadReq$uriToOssFileUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.request.FileUploadReq$uriToOssFileUrl$1 r0 = new com.upuphone.xr.sapp.request.FileUploadReq$uriToOssFileUrl$1
            r0.<init>(r7, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "FileUploadReq"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0077
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            long r10 = r0.J$0
            java.lang.Object r7 = r0.L$0
            com.upuphone.xr.sapp.request.FileUploadReq r7 = (com.upuphone.xr.sapp.request.FileUploadReq) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0066
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.star.core.log.ULog$Delegate r13 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "fileToOssFileUrl fileName"
            r2.append(r6)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            r13.a(r3, r2)
            r0.L$0 = r7
            r0.J$0 = r10
            r0.label = r5
            java.lang.Object r13 = r7.j(r8, r9, r12, r0)
            if (r13 != r1) goto L_0x0066
            return r1
        L_0x0066:
            java.lang.String r13 = (java.lang.String) r13
            r8 = 0
            if (r13 != 0) goto L_0x006c
            return r8
        L_0x006c:
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r13 = r7.h(r13, r10, r0)
            if (r13 != r1) goto L_0x0077
            return r1
        L_0x0077:
            java.lang.String r13 = (java.lang.String) r13
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "uploadFileToOss "
            r8.append(r9)
            r8.append(r13)
            java.lang.String r8 = r8.toString()
            r7.c(r3, r8)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.request.FileUploadReq.n(android.net.Uri, java.lang.String, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
