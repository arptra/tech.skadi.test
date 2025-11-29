package com.upuphone.ar.tici.phone.db;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH@¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H@¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0018\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006H@¢\u0006\u0004\b\u001b\u0010\u001cJ(\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0006H@¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/upuphone/ar/tici/phone/db/TiciDBHelper;", "", "<init>", "()V", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ticiEntity", "", "content", "", "supportLargeFile", "", "e", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "targetPage", "Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "d", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "id", "b", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "ids", "c", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userId", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ticiId", "partIndex", "paragraphIndexes", "f", "(JILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciDBHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TiciDBHelper f5925a = new TiciDBHelper();

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteAll$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteAll$1 r0 = (com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteAll$1 r0 = new com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteAll$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 == r4) goto L_0x003f
            if (r1 == r3) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x007b
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0069
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0055
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r5)
            com.upuphone.ar.tici.phone.TiciApp r5 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r5 = r5.w()
            r0.label = r4
            java.lang.Object r5 = r5.i(r6, r0)
            if (r5 != r7) goto L_0x0055
            return r7
        L_0x0055:
            r6 = r5
            java.util.List r6 = (java.util.List) r6
            com.upuphone.ar.tici.phone.TiciApp r5 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r5 = r5.w()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.y(r6, r0)
            if (r5 != r7) goto L_0x0069
            return r7
        L_0x0069:
            com.upuphone.ar.tici.phone.TiciApp r5 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r5 = r5.w()
            r1 = 0
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r5 = r5.v(r6, r0)
            if (r5 != r7) goto L_0x007b
            return r7
        L_0x007b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.db.TiciDBHelper.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(long r5, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciById$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciById$1 r0 = (com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciById$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciById$1 r0 = new com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciById$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 == r3) goto L_0x0034
            if (r1 != r2) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x005d
        L_0x002c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0034:
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x004e
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.B(r5, r0)
            if (r4 != r7) goto L_0x004e
            return r7
        L_0x004e:
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()
            r0.label = r2
            java.lang.Object r4 = r4.f(r5, r0)
            if (r4 != r7) goto L_0x005d
            return r7
        L_0x005d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.db.TiciDBHelper.b(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(java.util.List r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciByIds$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciByIds$1 r0 = (com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciByIds$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciByIds$1 r0 = new com.upuphone.ar.tici.phone.db.TiciDBHelper$deleteTiciByIds$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 == r3) goto L_0x0034
            if (r1 != r2) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0062
        L_0x002c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0034:
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0050
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.y(r5, r0)
            if (r4 != r6) goto L_0x0050
            return r6
        L_0x0050:
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()
            r1 = 0
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.v(r5, r0)
            if (r4 != r6) goto L_0x0062
            return r6
        L_0x0062:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.db.TiciDBHelper.c(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc A[PHI: r13 
      PHI: (r13v2 java.lang.Object) = (r13v4 java.lang.Object), (r13v1 java.lang.Object) binds: [B:40:0x00f9, B:13:0x0031] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(com.upuphone.ar.tici.phone.db.entity.TiciEntity r11, java.lang.Integer r12, kotlin.coroutines.Continuation r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.upuphone.ar.tici.phone.db.TiciDBHelper$loadTiciInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.upuphone.ar.tici.phone.db.TiciDBHelper$loadTiciInfo$1 r0 = (com.upuphone.ar.tici.phone.db.TiciDBHelper$loadTiciInfo$1) r0
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
            com.upuphone.ar.tici.phone.db.TiciDBHelper$loadTiciInfo$1 r0 = new com.upuphone.ar.tici.phone.db.TiciDBHelper$loadTiciInfo$1
            r0.<init>(r10, r13)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r7 = 0
            if (r1 == 0) goto L_0x006c
            if (r1 == r5) goto L_0x005e
            if (r1 == r4) goto L_0x0052
            if (r1 == r3) goto L_0x003e
            if (r1 != r2) goto L_0x0036
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00fc
        L_0x0036:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003e:
            java.lang.Object r10 = r6.L$2
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r10 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r10
            java.lang.Object r11 = r6.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r11 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r11
            java.lang.Object r12 = r6.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r12 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r12
            kotlin.ResultKt.throwOnFailure(r13)
            r5 = r10
            r4 = r11
            r11 = r12
            goto L_0x00e7
        L_0x0052:
            java.lang.Object r10 = r6.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r10 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r10
            java.lang.Object r11 = r6.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00c9
        L_0x005e:
            int r10 = r6.I$0
            java.lang.Object r11 = r6.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            java.lang.Object r12 = r6.L$0
            com.upuphone.ar.tici.phone.db.TiciDBHelper r12 = (com.upuphone.ar.tici.phone.db.TiciDBHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0094
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r13)
            if (r12 == 0) goto L_0x0076
            int r12 = r12.intValue()
            goto L_0x007a
        L_0x0076:
            int r12 = r11.getCurrentPage()
        L_0x007a:
            com.upuphone.ar.tici.phone.TiciApp r13 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r13 = r13.w()
            long r8 = r11.getId()
            r6.L$0 = r10
            r6.L$1 = r11
            r6.I$0 = r12
            r6.label = r5
            java.lang.Object r13 = r13.b(r8, r12, r6)
            if (r13 != r0) goto L_0x0093
            return r0
        L_0x0093:
            r10 = r12
        L_0x0094:
            r12 = r13
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r12 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r12
            if (r12 != 0) goto L_0x00b0
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "loadTiciInfo, can`t find contentPart for page: "
            r11.append(r12)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            java.lang.String r11 = "TiciDBHelper"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r10, r11, r7, r4, r7)
            return r7
        L_0x00b0:
            com.upuphone.ar.tici.phone.TiciApp r13 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r13 = r13.w()
            long r8 = r11.getId()
            int r10 = r10 + r5
            r6.L$0 = r11
            r6.L$1 = r12
            r6.label = r4
            java.lang.Object r13 = r13.b(r8, r10, r6)
            if (r13 != r0) goto L_0x00c8
            return r0
        L_0x00c8:
            r10 = r12
        L_0x00c9:
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r13 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r13
            com.upuphone.ar.tici.phone.TiciApp r12 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r12 = r12.w()
            long r4 = r11.getId()
            r6.L$0 = r11
            r6.L$1 = r10
            r6.L$2 = r13
            r6.label = r3
            java.lang.Object r12 = r12.z(r4, r6)
            if (r12 != r0) goto L_0x00e4
            return r0
        L_0x00e4:
            r4 = r10
            r5 = r13
            r13 = r12
        L_0x00e7:
            r3 = r13
            java.util.List r3 = (java.util.List) r3
            com.upuphone.ar.tici.phone.data.TiciInfo$Companion r1 = com.upuphone.ar.tici.phone.data.TiciInfo.Companion
            r6.L$0 = r7
            r6.L$1 = r7
            r6.L$2 = r7
            r6.label = r2
            r2 = r11
            java.lang.Object r13 = r1.a(r2, r3, r4, r5, r6)
            if (r13 != r0) goto L_0x00fc
            return r0
        L_0x00fc:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.db.TiciDBHelper.d(com.upuphone.ar.tici.phone.db.entity.TiciEntity, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: java.lang.String} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0088, code lost:
        r9 = r11;
        r11 = r10;
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0091, code lost:
        r10.setTotalPage(r11.size());
        r10.setTotalTextLength(r12.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a7, code lost:
        if (r10.getCurrentPage() < r11.size()) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a9, code lost:
        r12 = r10.getCurrentPage();
        r13 = r11.size();
        com.upuphone.ar.tici.phone.utils.CommonExtKt.d("saveTiciContentInfo, fix wrong ticiEntity.currentPage: " + r12 + ", totalPage: " + r13, "TiciDBHelper", (java.lang.Throwable) null, 2, (java.lang.Object) null);
        r10.setCurrentPage(java.lang.Math.max(0, r11.size() - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d9, code lost:
        r12 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 2;
        r12 = r12.s(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e9, code lost:
        if (r12 != r14) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00eb, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ec, code lost:
        r9 = r12;
        r12 = r10;
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ef, code lost:
        r12.setId(((java.lang.Number) r10).longValue());
        r10 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a;
        r7 = r12.getId();
        r0.L$0 = r12;
        r0.L$1 = null;
        r0.label = 3;
        r10 = r10.o(r7, r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0109, code lost:
        if (r10 != r14) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010b, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x010c, code lost:
        r11 = (java.util.List) r10;
        r10 = ((com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r11.get(r12.getCurrentPage())).getParagraphIndexes();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0125, code lost:
        if (r12.getIndex() < r10.size()) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0127, code lost:
        r13 = r12.getIndex();
        r1 = r10.size();
        com.upuphone.ar.tici.phone.utils.CommonExtKt.d("saveTiciContentInfo, fix wrong ticiEntity.index: " + r13 + ", currentParagraphItemSize: " + r1, "TiciDBHelper", (java.lang.Throwable) null, 2, (java.lang.Object) null);
        r12.setIndex(java.lang.Math.max(0, r10.size() - 1));
        r10 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = r12;
        r0.L$1 = r11;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0168, code lost:
        if (r10.s(r12, r0) != r14) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x016a, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x016b, code lost:
        r10 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r12 = r12.getId();
        r0.L$0 = r11;
        r0.L$1 = null;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0180, code lost:
        if (r10.f(r12, r0) != r14) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0182, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0183, code lost:
        r10 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0192, code lost:
        if (r10.p(r11, r0) != r14) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0194, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0197, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(com.upuphone.ar.tici.phone.db.entity.TiciEntity r11, java.lang.String r12, boolean r13, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.upuphone.ar.tici.phone.db.TiciDBHelper$saveTiciContentInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.ar.tici.phone.db.TiciDBHelper$saveTiciContentInfo$1 r0 = (com.upuphone.ar.tici.phone.db.TiciDBHelper$saveTiciContentInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.db.TiciDBHelper$saveTiciContentInfo$1 r0 = new com.upuphone.ar.tici.phone.db.TiciDBHelper$saveTiciContentInfo$1
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 0
            java.lang.String r3 = "TiciDBHelper"
            r4 = 2
            r5 = 1
            r6 = 0
            switch(r1) {
                case 0: goto L_0x0070;
                case 1: goto L_0x0063;
                case 2: goto L_0x0056;
                case 3: goto L_0x004c;
                case 4: goto L_0x003f;
                case 5: goto L_0x0036;
                case 6: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0195
        L_0x0036:
            java.lang.Object r11 = r0.L$0
            java.util.List r11 = (java.util.List) r11
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0183
        L_0x003f:
            java.lang.Object r11 = r0.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r12 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r12
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x016b
        L_0x004c:
            java.lang.Object r11 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            kotlin.ResultKt.throwOnFailure(r10)
            r12 = r11
            goto L_0x010c
        L_0x0056:
            java.lang.Object r11 = r0.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r12 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r12
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00ef
        L_0x0063:
            java.lang.Object r11 = r0.L$1
            r12 = r11
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r11 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0086
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r13 == 0) goto L_0x008c
            com.upuphone.ar.tici.phone.utils.TiciHelper r10 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r5
            r13 = 10000(0x2710, float:1.4013E-41)
            java.lang.Object r10 = r10.n(r12, r13, r0)
            if (r10 != r14) goto L_0x0086
            return r14
        L_0x0086:
            java.util.List r10 = (java.util.List) r10
        L_0x0088:
            r9 = r11
            r11 = r10
            r10 = r9
            goto L_0x0091
        L_0x008c:
            java.util.List r10 = kotlin.collections.CollectionsKt.listOf(r12)
            goto L_0x0088
        L_0x0091:
            int r13 = r11.size()
            r10.setTotalPage(r13)
            int r12 = r12.length()
            r10.setTotalTextLength(r12)
            int r12 = r10.getCurrentPage()
            int r13 = r11.size()
            if (r12 < r13) goto L_0x00d9
            int r12 = r10.getCurrentPage()
            int r13 = r11.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = "saveTiciContentInfo, fix wrong ticiEntity.currentPage: "
            r1.append(r7)
            r1.append(r12)
            java.lang.String r12 = ", totalPage: "
            r1.append(r12)
            r1.append(r13)
            java.lang.String r12 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r12, r3, r6, r4, r6)
            int r12 = r11.size()
            int r12 = r12 - r5
            int r12 = java.lang.Math.max(r2, r12)
            r10.setCurrentPage(r12)
        L_0x00d9:
            com.upuphone.ar.tici.phone.TiciApp r12 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r12 = r12.w()
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r12 = r12.s(r10, r0)
            if (r12 != r14) goto L_0x00ec
            return r14
        L_0x00ec:
            r9 = r12
            r12 = r10
            r10 = r9
        L_0x00ef:
            java.lang.Number r10 = (java.lang.Number) r10
            long r7 = r10.longValue()
            r12.setId(r7)
            com.upuphone.ar.tici.phone.utils.TiciHelper r10 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a
            long r7 = r12.getId()
            r0.L$0 = r12
            r0.L$1 = r6
            r13 = 3
            r0.label = r13
            java.lang.Object r10 = r10.o(r7, r11, r0)
            if (r10 != r14) goto L_0x010c
            return r14
        L_0x010c:
            r11 = r10
            java.util.List r11 = (java.util.List) r11
            int r10 = r12.getCurrentPage()
            java.lang.Object r10 = r11.get(r10)
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r10 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r10
            java.util.List r10 = r10.getParagraphIndexes()
            int r13 = r12.getIndex()
            int r1 = r10.size()
            if (r13 < r1) goto L_0x016b
            int r13 = r12.getIndex()
            int r1 = r10.size()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "saveTiciContentInfo, fix wrong ticiEntity.index: "
            r7.append(r8)
            r7.append(r13)
            java.lang.String r13 = ", currentParagraphItemSize: "
            r7.append(r13)
            r7.append(r1)
            java.lang.String r13 = r7.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r13, r3, r6, r4, r6)
            int r10 = r10.size()
            int r10 = r10 - r5
            int r10 = java.lang.Math.max(r2, r10)
            r12.setIndex(r10)
            com.upuphone.ar.tici.phone.TiciApp r10 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r10 = r10.w()
            r0.L$0 = r12
            r0.L$1 = r11
            r13 = 4
            r0.label = r13
            java.lang.Object r10 = r10.s(r12, r0)
            if (r10 != r14) goto L_0x016b
            return r14
        L_0x016b:
            com.upuphone.ar.tici.phone.TiciApp r10 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r10 = r10.w()
            long r12 = r12.getId()
            r0.L$0 = r11
            r0.L$1 = r6
            r1 = 5
            r0.label = r1
            java.lang.Object r10 = r10.f(r12, r0)
            if (r10 != r14) goto L_0x0183
            return r14
        L_0x0183:
            com.upuphone.ar.tici.phone.TiciApp r10 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r10 = r10.w()
            r0.L$0 = r6
            r12 = 6
            r0.label = r12
            java.lang.Object r10 = r10.p(r11, r0)
            if (r10 != r14) goto L_0x0195
            return r14
        L_0x0195:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.db.TiciDBHelper.e(com.upuphone.ar.tici.phone.db.entity.TiciEntity, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(long r5, int r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.upuphone.ar.tici.phone.db.TiciDBHelper$updateTiciContentPart$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.upuphone.ar.tici.phone.db.TiciDBHelper$updateTiciContentPart$1 r0 = (com.upuphone.ar.tici.phone.db.TiciDBHelper$updateTiciContentPart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r9 = r0
            goto L_0x001a
        L_0x0014:
            com.upuphone.ar.tici.phone.db.TiciDBHelper$updateTiciContentPart$1 r0 = new com.upuphone.ar.tici.phone.db.TiciDBHelper$updateTiciContentPart$1
            r0.<init>(r4, r9)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r4 = r9.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x0042
            if (r1 == r2) goto L_0x0036
            if (r1 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0092
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            int r7 = r9.I$0
            long r5 = r9.J$0
            java.lang.Object r8 = r9.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x005a
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()
            r9.L$0 = r8
            r9.J$0 = r5
            r9.I$0 = r7
            r9.label = r2
            java.lang.Object r4 = r4.b(r5, r7, r9)
            if (r4 != r0) goto L_0x005a
            return r0
        L_0x005a:
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r4 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r4
            r1 = 0
            if (r4 != 0) goto L_0x0081
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "updateTiciContentPart, can`t find contentPart for ticiId: "
            r4.append(r8)
            r4.append(r5)
            java.lang.String r5 = ", partIndex: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "TiciDBHelper"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r4, r5, r1, r3, r1)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0081:
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r4 = r4.g(r5, r7, r8, r9)
            if (r4 != r0) goto L_0x0092
            return r0
        L_0x0092:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.db.TiciDBHelper.f(long, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
