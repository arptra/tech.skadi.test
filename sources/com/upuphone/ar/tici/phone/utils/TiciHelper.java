package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.data.ImportFailReason;
import com.upuphone.ar.tici.phone.data.ImportFileInfo;
import com.upuphone.ar.tici.phone.data.ImportFileState;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\t\u0010\nJ(\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H@¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H@¢\u0006\u0004\b!\u0010\u001fJ\u0010\u0010#\u001a\u00020\"H@¢\u0006\u0004\b#\u0010\u001fJ\u0018\u0010%\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004H@¢\u0006\u0004\b%\u0010&J0\u0010)\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H@¢\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b+\u0010&J\u0018\u0010,\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b,\u0010&J\u001a\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010.\u001a\u00020-H@¢\u0006\u0004\b0\u00101J.\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010/032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0019H@¢\u0006\u0004\b4\u0010\u001c¨\u00065"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/TiciHelper;", "", "<init>", "()V", "", "filePath", "", "supportLargeFile", "Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "h", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "i", "(Landroid/content/Context;Landroid/net/Uri;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "ticiId", "", "partList", "Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "o", "(JLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "", "wordCount", "n", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/ar/tici/phone/data/DefaultTiciContent;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "e", "", "l", "userId", "m", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "index", "contentOffsetStart", "j", "(JLjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "f", "Ljava/io/File;", "file", "Ljava/nio/charset/Charset;", "c", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "maxLength", "Lkotlin/Pair;", "k", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHelper.kt\ncom/upuphone/ar/tici/phone/utils/TiciHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,623:1\n1864#2,3:624\n*S KotlinDebug\n*F\n+ 1 TiciHelper.kt\ncom/upuphone/ar/tici/phone/utils/TiciHelper\n*L\n314#1:624,3\n*E\n"})
public final class TiciHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TiciHelper f6002a = new TiciHelper();

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(java.io.File r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.upuphone.ar.tici.phone.utils.TiciHelper$detectCharset$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.ar.tici.phone.utils.TiciHelper$detectCharset$1 r0 = (com.upuphone.ar.tici.phone.utils.TiciHelper$detectCharset$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.utils.TiciHelper$detectCharset$1 r0 = new com.upuphone.ar.tici.phone.utils.TiciHelper$detectCharset$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x0040
            if (r1 == r2) goto L_0x0038
            if (r1 != r3) goto L_0x0030
            java.lang.Object r6 = r0.L$0
            java.nio.charset.Charset r6 = (java.nio.charset.Charset) r6
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0062
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            java.lang.Object r6 = r0.L$0
            java.io.File r6 = (java.io.File) r6
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0050
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r5)
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r5 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            r0.L$0 = r6
            r0.label = r2
            java.lang.Object r5 = r5.a(r6, r0)
            if (r5 != r7) goto L_0x0050
            return r7
        L_0x0050:
            java.nio.charset.Charset r5 = (java.nio.charset.Charset) r5
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r1 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r1.b(r6, r0)
            if (r6 != r7) goto L_0x005f
            return r7
        L_0x005f:
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x0062:
            java.nio.charset.Charset r5 = (java.nio.charset.Charset) r5
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "detectCharset, charset1: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r0 = ", charset2: "
            r7.append(r0)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = "TiciHelper"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r7, r0)
            r7 = 0
            if (r6 == 0) goto L_0x00fa
            if (r5 != 0) goto L_0x0088
            goto L_0x00fa
        L_0x0088:
            boolean r1 = com.upuphone.ar.tici.phone.utils.CharsetExtKt.a(r6, r5)
            java.lang.String r2 = ")"
            if (r1 == 0) goto L_0x00b0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "detectCharset, charset1("
            r7.append(r1)
            r7.append(r6)
            java.lang.String r1 = ") is compatible with charset2("
            r7.append(r1)
            r7.append(r5)
            r7.append(r2)
            java.lang.String r5 = r7.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r5, r0)
            goto L_0x00f9
        L_0x00b0:
            boolean r1 = com.upuphone.ar.tici.phone.utils.CharsetExtKt.a(r5, r6)
            if (r1 == 0) goto L_0x00d7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "detectCharset, charset2("
            r7.append(r1)
            r7.append(r5)
            java.lang.String r1 = ") is compatible with charset1("
            r7.append(r1)
            r7.append(r6)
            r7.append(r2)
            java.lang.String r6 = r7.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r6, r0)
            r6 = r5
            goto L_0x00f9
        L_0x00d7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "detectCharset, neither charset("
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = ") nor charset("
            r1.append(r6)
            r1.append(r5)
            java.lang.String r5 = ") are compatible"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r5, r0)
            r6 = r7
        L_0x00f9:
            return r6
        L_0x00fa:
            java.lang.String r5 = "detectCharset, charset is null"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r5, r0, r7, r3, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper.c(java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.upuphone.ar.tici.phone.utils.TiciHelper$getDefaultTiciContent$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.ar.tici.phone.utils.TiciHelper$getDefaultTiciContent$1 r0 = (com.upuphone.ar.tici.phone.utils.TiciHelper$getDefaultTiciContent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.utils.TiciHelper$getDefaultTiciContent$1 r0 = new com.upuphone.ar.tici.phone.utils.TiciHelper$getDefaultTiciContent$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            int r9 = r0.I$0
            boolean r0 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x008c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            com.upuphone.xr.sapp.context.SdkContext r8 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.AppContext r8 = r8.c()
            boolean r8 = r8.e()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "getDefaultTiciContent, isIntl: "
            r1.append(r3)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "TiciHelper"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r3)
            if (r8 == 0) goto L_0x005e
            java.lang.String r1 = "tici/default_tici_content_intl"
            r4 = 6
            goto L_0x0061
        L_0x005e:
            java.lang.String r1 = "tici/default_tici_content"
            r4 = 5
        L_0x0061:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "getDefaultTiciContent, ticiFilePath: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r5, r3)
            com.upuphone.ar.tici.phone.TiciApp r3 = com.upuphone.ar.tici.phone.TiciApp.b
            android.content.Context r3 = r3.a()
            r0.Z$0 = r8
            r0.I$0 = r4
            r0.label = r2
            java.lang.Object r0 = com.upuphone.ar.tici.phone.utils.ContextExtKt.a(r3, r1, r0)
            if (r0 != r9) goto L_0x0088
            return r9
        L_0x0088:
            r9 = r4
            r7 = r0
            r0 = r8
            r8 = r7
        L_0x008c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r8 = com.upuphone.ar.tici.phone.utils.StringExtKt.e(r8)
            if (r0 == 0) goto L_0x00a5
            com.upuphone.ar.tici.phone.TiciApp r0 = com.upuphone.ar.tici.phone.TiciApp.b
            android.content.Context r0 = r0.a()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.upuphone.ar.tici.R.string.default_tici_file_name_intl
            java.lang.String r0 = r0.getString(r1)
            goto L_0x00b5
        L_0x00a5:
            com.upuphone.ar.tici.phone.TiciApp r0 = com.upuphone.ar.tici.phone.TiciApp.b
            android.content.Context r0 = r0.a()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.upuphone.ar.tici.R.string.default_tici_file_name
            java.lang.String r0 = r0.getString(r1)
        L_0x00b5:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.upuphone.ar.tici.phone.data.DefaultTiciContent r1 = new com.upuphone.ar.tici.phone.data.DefaultTiciContent
            r1.<init>(r0, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009c, code lost:
        r12 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009e, code lost:
        if (r12 == null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a0, code lost:
        r7 = r12.toSimpleString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a5, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("getLastTiciEntityOrDefault, lastTiciEntity: " + r7, "TiciHelper");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ba, code lost:
        if (r12 != null) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bc, code lost:
        r12 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = r11;
        r0.L$1 = null;
        r0.label = 2;
        r12 = r12.k(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cc, code lost:
        if (r12 != r1) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ce, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cf, code lost:
        r12 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d1, code lost:
        r10 = r12;
        r12 = r11;
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d4, code lost:
        if (r11 != null) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d6, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("getLastTiciEntityOrDefault, userTiciEntity is null, insert new", "TiciHelper");
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        r12 = r12.d(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e6, code lost:
        if (r12 != r1) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e9, code lost:
        r12 = (com.upuphone.ar.tici.phone.data.DefaultTiciContent) r12;
        r11 = com.upuphone.ar.tici.phone.data.DefaultTiciContentKt.a(r12, com.upuphone.ar.tici.phone.TiciApp.b.g());
        r2 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a;
        r12 = r12.getContent();
        r0.L$0 = r11;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0104, code lost:
        if (r2.e(r11, r12, false, r0) != r1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0106, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0108, code lost:
        r2 = com.upuphone.ar.tici.phone.TiciApp.b.c().s0();
        r4 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.c(r11);
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("getLastTiciEntityOrDefault, isDefaultContent: " + r4 + ", isGlassTiciRunning: " + r2, "TiciHelper");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0132, code lost:
        if (r4 == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0134, code lost:
        if (r2 != false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0136, code lost:
        r0.L$0 = r11;
        r0.L$1 = null;
        r0.label = 5;
        r12 = r12.d(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0141, code lost:
        if (r12 != r1) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0143, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0144, code lost:
        r2 = (com.upuphone.ar.tici.phone.data.DefaultTiciContent) r12;
        r12 = com.upuphone.ar.tici.phone.data.DefaultTiciContentKt.a(r2, com.upuphone.ar.tici.phone.TiciApp.b.g());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x015d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11.getFileType(), (java.lang.Object) r12.getFileType()) != false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x015f, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("getLastTiciEntityOrDefault, delete userTiciEntity, insert new", "TiciHelper");
        r4 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a;
        r7 = r11.getId();
        r0.L$0 = r2;
        r0.L$1 = r12;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0175, code lost:
        if (r4.b(r7, r0) != r1) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0177, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0178, code lost:
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0179, code lost:
        r12 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a;
        r2 = r2.getContent();
        r0.L$0 = r11;
        r0.L$1 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x018a, code lost:
        if (r12.e(r11, r2, false, r0) != r1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x018c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x018e, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("getLastTiciEntityOrDefault, keep userTiciEntity", "TiciHelper");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0193, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.upuphone.ar.tici.phone.utils.TiciHelper$getLastTiciEntityOrDefault$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.upuphone.ar.tici.phone.utils.TiciHelper$getLastTiciEntityOrDefault$1 r0 = (com.upuphone.ar.tici.phone.utils.TiciHelper$getLastTiciEntityOrDefault$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.utils.TiciHelper$getLastTiciEntityOrDefault$1 r0 = new com.upuphone.ar.tici.phone.utils.TiciHelper$getLastTiciEntityOrDefault$1
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            java.lang.String r5 = "TiciHelper"
            r6 = 0
            switch(r2) {
                case 0: goto L_0x0074;
                case 1: goto L_0x0065;
                case 2: goto L_0x005d;
                case 3: goto L_0x0058;
                case 4: goto L_0x004f;
                case 5: goto L_0x0046;
                case 6: goto L_0x0039;
                case 7: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0030:
            java.lang.Object r11 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x018d
        L_0x0039:
            java.lang.Object r11 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.tici.phone.data.DefaultTiciContent r2 = (com.upuphone.ar.tici.phone.data.DefaultTiciContent) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0179
        L_0x0046:
            java.lang.Object r11 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0144
        L_0x004f:
            java.lang.Object r11 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0107
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00e9
        L_0x005d:
            java.lang.Object r11 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r11 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00cf
        L_0x0065:
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r2 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r10 = r2
            r2 = r11
            r11 = r10
            goto L_0x009c
        L_0x0074:
            kotlin.ResultKt.throwOnFailure(r12)
            com.upuphone.ar.tici.phone.TiciApp r12 = com.upuphone.ar.tici.phone.TiciApp.b
            java.lang.String r2 = r12.g()
            if (r2 != 0) goto L_0x0086
            java.lang.String r2 = "getLastTiciEntityOrDefault, userId is null"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r2, r5, r6, r4, r6)
            java.lang.String r2 = "0"
        L_0x0086:
            long r7 = com.upuphone.ar.tici.phone.utils.SpUtilKt.f()
            com.upuphone.ar.tici.phone.db.TiciDao r12 = r12.w()
            r0.L$0 = r11
            r0.L$1 = r2
            r9 = 1
            r0.label = r9
            java.lang.Object r12 = r12.C(r2, r7, r0)
            if (r12 != r1) goto L_0x009c
            return r1
        L_0x009c:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r12 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r12
            if (r12 == 0) goto L_0x00a5
            java.lang.String r7 = r12.toSimpleString()
            goto L_0x00a6
        L_0x00a5:
            r7 = r6
        L_0x00a6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "getLastTiciEntityOrDefault, lastTiciEntity: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r7, r5)
            if (r12 != 0) goto L_0x00d1
            com.upuphone.ar.tici.phone.TiciApp r12 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r12 = r12.w()
            r0.L$0 = r11
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r12 = r12.k(r2, r0)
            if (r12 != r1) goto L_0x00cf
            return r1
        L_0x00cf:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r12 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r12
        L_0x00d1:
            r10 = r12
            r12 = r11
            r11 = r10
            if (r11 != 0) goto L_0x0108
            java.lang.String r11 = "getLastTiciEntityOrDefault, userTiciEntity is null, insert new"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r11, r5)
            r0.L$0 = r6
            r0.L$1 = r6
            r11 = 3
            r0.label = r11
            java.lang.Object r12 = r12.d(r0)
            if (r12 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            com.upuphone.ar.tici.phone.data.DefaultTiciContent r12 = (com.upuphone.ar.tici.phone.data.DefaultTiciContent) r12
            com.upuphone.ar.tici.phone.TiciApp r11 = com.upuphone.ar.tici.phone.TiciApp.b
            java.lang.String r11 = r11.g()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = com.upuphone.ar.tici.phone.data.DefaultTiciContentKt.a(r12, r11)
            com.upuphone.ar.tici.phone.db.TiciDBHelper r2 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a
            java.lang.String r12 = r12.getContent()
            r0.L$0 = r11
            r4 = 4
            r0.label = r4
            java.lang.Object r12 = r2.e(r11, r12, r3, r0)
            if (r12 != r1) goto L_0x0107
            return r1
        L_0x0107:
            return r11
        L_0x0108:
            com.upuphone.ar.tici.phone.TiciApp r2 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.TiciAppViewModel r2 = r2.c()
            boolean r2 = r2.s0()
            boolean r4 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.c(r11)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getLastTiciEntityOrDefault, isDefaultContent: "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = ", isGlassTiciRunning: "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r7, r5)
            if (r4 == 0) goto L_0x018e
            if (r2 != 0) goto L_0x018e
            r0.L$0 = r11
            r0.L$1 = r6
            r2 = 5
            r0.label = r2
            java.lang.Object r12 = r12.d(r0)
            if (r12 != r1) goto L_0x0144
            return r1
        L_0x0144:
            r2 = r12
            com.upuphone.ar.tici.phone.data.DefaultTiciContent r2 = (com.upuphone.ar.tici.phone.data.DefaultTiciContent) r2
            com.upuphone.ar.tici.phone.TiciApp r12 = com.upuphone.ar.tici.phone.TiciApp.b
            java.lang.String r12 = r12.g()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r12 = com.upuphone.ar.tici.phone.data.DefaultTiciContentKt.a(r2, r12)
            java.lang.Integer r4 = r11.getFileType()
            java.lang.Integer r7 = r12.getFileType()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r7)
            if (r4 != 0) goto L_0x018e
            java.lang.String r4 = "getLastTiciEntityOrDefault, delete userTiciEntity, insert new"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r4, r5)
            com.upuphone.ar.tici.phone.db.TiciDBHelper r4 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a
            long r7 = r11.getId()
            r0.L$0 = r2
            r0.L$1 = r12
            r11 = 6
            r0.label = r11
            java.lang.Object r11 = r4.b(r7, r0)
            if (r11 != r1) goto L_0x0178
            return r1
        L_0x0178:
            r11 = r12
        L_0x0179:
            com.upuphone.ar.tici.phone.db.TiciDBHelper r12 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a
            java.lang.String r2 = r2.getContent()
            r0.L$0 = r11
            r0.L$1 = r6
            r4 = 7
            r0.label = r4
            java.lang.Object r12 = r12.e(r11, r2, r3, r0)
            if (r12 != r1) goto L_0x018d
            return r1
        L_0x018d:
            return r11
        L_0x018e:
            java.lang.String r12 = "getLastTiciEntityOrDefault, keep userTiciEntity"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r12, r5)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object f(String str, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TiciHelper$importLargeTiciFile$2(str, (Continuation<? super TiciHelper$importLargeTiciFile$2>) null), continuation);
    }

    public final Object g(String str, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TiciHelper$importSmallTiciFile$2(str, (Continuation<? super TiciHelper$importSmallTiciFile$2>) null), continuation);
    }

    public final Object h(String str, boolean z, Continuation continuation) {
        CommonExtKt.e("importTiciFile, filePath: " + str + ", supportLargeFile: " + z, "TiciHelper");
        long length = new File(str).length();
        StringBuilder sb = new StringBuilder();
        sb.append("importLargeTiciFile, fileSize: ");
        sb.append(length);
        CommonExtKt.e(sb.toString(), "TiciHelper");
        if (length > 0) {
            return z ? f(str, continuation) : g(str, continuation);
        }
        ImportFileInfo importFileInfo = new ImportFileInfo(length, 0, (String) null);
        CommonExtKt.d("importLargeTiciFile, wrong file size ", "TiciHelper", (Throwable) null, 2, (Object) null);
        return new ImportFileState.Fail(ImportFailReason.EmptyContent, importFileInfo);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.io.File} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0138 A[SYNTHETIC, Splitter:B:41:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(android.content.Context r21, android.net.Uri r22, boolean r23, kotlin.coroutines.Continuation r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r24
            boolean r4 = r3 instanceof com.upuphone.ar.tici.phone.utils.TiciHelper$importTiciUri$1
            if (r4 == 0) goto L_0x001b
            r4 = r3
            com.upuphone.ar.tici.phone.utils.TiciHelper$importTiciUri$1 r4 = (com.upuphone.ar.tici.phone.utils.TiciHelper$importTiciUri$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x0020
        L_0x001b:
            com.upuphone.ar.tici.phone.utils.TiciHelper$importTiciUri$1 r4 = new com.upuphone.ar.tici.phone.utils.TiciHelper$importTiciUri$1
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 3
            r8 = 1
            java.lang.String r9 = "TiciHelper"
            r10 = 2
            r11 = 0
            if (r6 == 0) goto L_0x0075
            if (r6 == r8) goto L_0x0059
            if (r6 == r10) goto L_0x004b
            if (r6 != r7) goto L_0x0043
            java.lang.Object r0 = r4.L$0
            r1 = r0
            java.io.File r1 = (java.io.File) r1
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0040 }
            goto L_0x014d
        L_0x0040:
            r0 = move-exception
            goto L_0x0153
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            long r0 = r4.J$0
            boolean r2 = r4.Z$0
            java.lang.Object r6 = r4.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r6 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r6
            kotlin.ResultKt.throwOnFailure(r3)
            r13 = r0
            goto L_0x012c
        L_0x0059:
            boolean r0 = r4.Z$0
            java.lang.Object r1 = r4.L$2
            android.net.Uri r1 = (android.net.Uri) r1
            java.lang.Object r2 = r4.L$1
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Object r6 = r4.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r6 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r6
            kotlin.ResultKt.throwOnFailure(r3)
            r18 = r6
            r6 = r0
            r0 = r18
            r19 = r2
            r2 = r1
            r1 = r19
            goto L_0x00a1
        L_0x0075:
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "importTiciUri, uri: "
            r3.append(r6)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r3, r9)
            com.upuphone.ar.tici.phone.utils.FileUtils r3 = com.upuphone.ar.tici.phone.utils.FileUtils.f5991a
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r2
            r6 = r23
            r4.Z$0 = r6
            r4.label = r8
            java.lang.Object r3 = r3.c(r1, r2, r4)
            if (r3 != r5) goto L_0x00a1
            return r5
        L_0x00a1:
            java.lang.Number r3 = (java.lang.Number) r3
            long r13 = r3.longValue()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = "importTiciUri, fileSize: "
            r3.append(r8)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r3, r9)
            r15 = 0
            int r3 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r3 > 0) goto L_0x00d8
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            r15 = 0
            r17 = 0
            r12 = r0
            r12.<init>(r13, r15, r17)
            java.lang.String r1 = "importTiciUri, wrong file size "
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r1, r9, r11, r10, r11)
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r1 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            com.upuphone.ar.tici.phone.data.ImportFailReason r2 = com.upuphone.ar.tici.phone.data.ImportFailReason.EmptyContent
            r1.<init>(r2, r0)
            return r1
        L_0x00d8:
            if (r6 == 0) goto L_0x00df
            com.upuphone.ar.tici.phone.data.ImportFailReason r3 = com.upuphone.ar.tici.phone.data.ImportFailReason.FileOver10M
            r8 = 10485760(0xa00000, float:1.469368E-38)
            goto L_0x00e4
        L_0x00df:
            com.upuphone.ar.tici.phone.data.ImportFailReason r3 = com.upuphone.ar.tici.phone.data.ImportFailReason.FileOver200K
            r8 = 204800(0x32000, float:2.86986E-40)
        L_0x00e4:
            long r7 = (long) r8
            int r7 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0113
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            r15 = 0
            r17 = 0
            r12 = r0
            r7 = r13
            r12.<init>(r13, r15, r17)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "importTiciUri, file over size("
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r1, r9, r11, r10, r11)
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r1 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            r1.<init>(r3, r0)
            return r1
        L_0x0113:
            r7 = r13
            com.upuphone.ar.tici.phone.utils.FileUtils r3 = com.upuphone.ar.tici.phone.utils.FileUtils.f5991a
            r4.L$0 = r0
            r4.L$1 = r11
            r4.L$2 = r11
            r4.Z$0 = r6
            r4.J$0 = r7
            r4.label = r10
            java.lang.Object r3 = r3.a(r1, r2, r4)
            if (r3 != r5) goto L_0x0129
            return r5
        L_0x0129:
            r2 = r6
            r13 = r7
            r6 = r0
        L_0x012c:
            r1 = r3
            java.io.File r1 = (java.io.File) r1
            if (r1 == 0) goto L_0x0157
            boolean r0 = r1.exists()
            if (r0 != 0) goto L_0x0138
            goto L_0x0157
        L_0x0138:
            java.lang.String r0 = r1.getAbsolutePath()     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "getAbsolutePath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ all -> 0x0040 }
            r4.L$0 = r1     // Catch:{ all -> 0x0040 }
            r3 = 3
            r4.label = r3     // Catch:{ all -> 0x0040 }
            java.lang.Object r3 = r6.h(r0, r2, r4)     // Catch:{ all -> 0x0040 }
            if (r3 != r5) goto L_0x014d
            return r5
        L_0x014d:
            com.upuphone.ar.tici.phone.data.ImportFileState r3 = (com.upuphone.ar.tici.phone.data.ImportFileState) r3     // Catch:{ all -> 0x0040 }
            r1.delete()
            return r3
        L_0x0153:
            r1.delete()
            throw r0
        L_0x0157:
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            r15 = 0
            r17 = 0
            r12 = r0
            r12.<init>(r13, r15, r17)
            java.lang.String r1 = "importTiciUri, file not exist"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r1, r9, r11, r10, r11)
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r1 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            com.upuphone.ar.tici.phone.data.ImportFailReason r2 = com.upuphone.ar.tici.phone.data.ImportFailReason.ReadFileError
            r1.<init>(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper.i(android.content.Context, android.net.Uri, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(long r18, java.lang.String r20, int r21, int r22, kotlin.coroutines.Continuation r23) {
        /*
            r17 = this;
            r0 = r20
            r1 = r23
            boolean r2 = r1 instanceof com.upuphone.ar.tici.phone.utils.TiciHelper$newTiciContentPart$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.upuphone.ar.tici.phone.utils.TiciHelper$newTiciContentPart$1 r2 = (com.upuphone.ar.tici.phone.utils.TiciHelper$newTiciContentPart$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001e
        L_0x0017:
            com.upuphone.ar.tici.phone.utils.TiciHelper$newTiciContentPart$1 r2 = new com.upuphone.ar.tici.phone.utils.TiciHelper$newTiciContentPart$1
            r3 = r17
            r2.<init>(r3, r1)
        L_0x001e:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0047
            if (r4 != r5) goto L_0x003f
            int r0 = r2.I$2
            int r3 = r2.I$1
            int r4 = r2.I$0
            long r5 = r2.J$0
            java.lang.Object r2 = r2.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r9 = r2
            r15 = r3
            r14 = r4
            r7 = r5
            goto L_0x0071
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r1)
            int r1 = com.upuphone.ar.tici.phone.utils.StringExtKt.a(r20)
            com.upuphone.ar.tici.phone.utils.ParagraphHelper$Companion r4 = com.upuphone.ar.tici.phone.utils.ParagraphHelper.f5995a
            r2.L$0 = r0
            r6 = r18
            r2.J$0 = r6
            r8 = r21
            r2.I$0 = r8
            r9 = r22
            r2.I$1 = r9
            r2.I$2 = r1
            r2.label = r5
            r5 = 70
            java.lang.Object r2 = r4.c(r0, r5, r2)
            if (r2 != r3) goto L_0x006b
            return r3
        L_0x006b:
            r14 = r8
            r15 = r9
            r9 = r0
            r0 = r1
            r1 = r2
            r7 = r6
        L_0x0071:
            r10 = r1
            java.util.List r10 = (java.util.List) r10
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r1 = new com.upuphone.ar.tici.phone.db.entity.TiciContentPart
            long r12 = (long) r0
            int r0 = r9.length()
            int r16 = r15 + r0
            r5 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r7, r9, r10, r11, r12, r14, r15, r16)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper.j(long, java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(java.lang.String r12, int r13, kotlin.coroutines.Continuation r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.upuphone.ar.tici.phone.utils.TiciHelper$readFileAsText$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.ar.tici.phone.utils.TiciHelper$readFileAsText$1 r0 = (com.upuphone.ar.tici.phone.utils.TiciHelper$readFileAsText$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.utils.TiciHelper$readFileAsText$1 r0 = new com.upuphone.ar.tici.phone.utils.TiciHelper$readFileAsText$1
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 1
            r7 = 2
            java.lang.String r8 = "TiciHelper"
            r9 = 0
            if (r2 == 0) goto L_0x006c
            if (r2 == r6) goto L_0x005b
            if (r2 == r7) goto L_0x0056
            if (r2 == r5) goto L_0x0051
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r11 = r0.L$0
            java.nio.charset.Charset r11 = (java.nio.charset.Charset) r11
            kotlin.ResultKt.throwOnFailure(r14)
            r9 = r11
            goto L_0x0121
        L_0x003e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0046:
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$0
            java.io.File r12 = (java.io.File) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00fa
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x015a
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00de
        L_0x005b:
            int r13 = r0.I$0
            java.lang.Object r11 = r0.L$1
            java.io.File r11 = (java.io.File) r11
            java.lang.Object r12 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r12 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r12
            kotlin.ResultKt.throwOnFailure(r14)
            r10 = r12
            r12 = r11
            r11 = r10
            goto L_0x009c
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r2 = "readFileAsText, filePath: "
            r14.append(r2)
            r14.append(r12)
            java.lang.String r14 = r14.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r14, r8)
            java.io.File r14 = new java.io.File
            r14.<init>(r12)
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r12 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            r0.L$0 = r11
            r0.L$1 = r14
            r0.I$0 = r13
            r0.label = r6
            java.lang.Object r12 = r12.c(r14, r0)
            if (r12 != r1) goto L_0x0099
            return r1
        L_0x0099:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x009c:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "readFileAsText, mime: "
            r2.append(r6)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r8)
            if (r14 == 0) goto L_0x0161
            int r2 = r14.hashCode()
            r6 = -1050893613(0xffffffffc15ca2d3, float:-13.789752)
            if (r2 == r6) goto L_0x0143
            r5 = 817335912(0x30b78e68, float:1.3355477E-9)
            if (r2 == r5) goto L_0x00e2
            r11 = 904647503(0x35ebd34f, float:1.7570363E-6)
            if (r2 != r11) goto L_0x0161
            java.lang.String r11 = "application/msword"
            boolean r11 = r14.equals(r11)
            if (r11 == 0) goto L_0x0161
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r11 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r7
            java.lang.Object r14 = r11.e(r12, r0)
            if (r14 != r1) goto L_0x00de
            return r1
        L_0x00de:
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x015c
        L_0x00e2:
            java.lang.String r2 = "text/plain"
            boolean r2 = r14.equals(r2)
            if (r2 == 0) goto L_0x0161
            r0.L$0 = r12
            r0.L$1 = r9
            r0.I$0 = r13
            r0.label = r4
            java.lang.Object r14 = r11.c(r12, r0)
            if (r14 != r1) goto L_0x00f9
            return r1
        L_0x00f9:
            r11 = r13
        L_0x00fa:
            java.nio.charset.Charset r14 = (java.nio.charset.Charset) r14
            if (r14 == 0) goto L_0x0124
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r2 = "readFileAsText, readTxtFileContent with charset: "
            r13.append(r2)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r13, r8)
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r13 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r11 = r13.h(r12, r14, r11, r0)
            if (r11 != r1) goto L_0x011f
            return r1
        L_0x011f:
            r9 = r14
            r14 = r11
        L_0x0121:
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x015c
        L_0x0124:
            com.upuphone.ar.tici.phone.data.ImportFileInfo r11 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            long r1 = r12.length()
            r3 = 0
            r5 = 0
            r0 = r11
            r0.<init>(r1, r3, r5)
            java.lang.String r12 = "readFileAsText, charset is null"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r12, r8, r9, r7, r9)
            com.upuphone.ar.tici.phone.utils.ImportFailException r12 = new com.upuphone.ar.tici.phone.utils.ImportFailException
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r13 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            com.upuphone.ar.tici.phone.data.ImportFailReason r14 = com.upuphone.ar.tici.phone.data.ImportFailReason.UnknownEncoding
            r13.<init>(r14, r11)
            r12.<init>(r13)
            throw r12
        L_0x0143:
            java.lang.String r11 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
            boolean r11 = r14.equals(r11)
            if (r11 == 0) goto L_0x0161
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r11 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r14 = r11.g(r12, r0)
            if (r14 != r1) goto L_0x015a
            return r1
        L_0x015a:
            java.lang.String r14 = (java.lang.String) r14
        L_0x015c:
            kotlin.Pair r11 = kotlin.TuplesKt.to(r14, r9)
            return r11
        L_0x0161:
            com.upuphone.ar.tici.phone.data.ImportFileInfo r11 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            long r1 = r12.length()
            r3 = 0
            r5 = 0
            r0 = r11
            r0.<init>(r1, r3, r5)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "readFileAsText, mime("
            r12.append(r13)
            r12.append(r14)
            java.lang.String r13 = ") is not supported"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r12, r8, r9, r7, r9)
            com.upuphone.ar.tici.phone.utils.ImportFailException r12 = new com.upuphone.ar.tici.phone.utils.ImportFailException
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r13 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            com.upuphone.ar.tici.phone.data.ImportFailReason r14 = com.upuphone.ar.tici.phone.data.ImportFailReason.UnsupportedFile
            r13.<init>(r14, r11)
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper.k(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        r11 = r10;
        r10 = r2;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006d, code lost:
        r6 = r2;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009a, code lost:
        if (kotlinx.coroutines.JobKt.l(r0.getContext()) == false) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009c, code lost:
        if (r11 != null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009e, code lost:
        r11 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = r10;
        r0.L$1 = null;
        r0.label = 1;
        r11 = r11.r(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00af, code lost:
        if (r11 != r1) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b1, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b2, code lost:
        r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b4, code lost:
        r2 = r10;
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b7, code lost:
        r2 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r6 = r11.longValue();
        r0.L$0 = r10;
        r0.L$1 = null;
        r0.label = 2;
        r11 = r2.A(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cc, code lost:
        if (r11 != r1) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ce, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cf, code lost:
        r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d2, code lost:
        if (r10 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d4, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("runDbMigration, finish", "TiciHelper");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00db, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00dc, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("runDbMigration, ticiEntity: " + r10.toSimpleString(), "TiciHelper");
        r11 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r6 = r10.getId();
        r0.L$0 = r2;
        r0.L$1 = r10;
        r0.label = 3;
        r11 = r11.e(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0109, code lost:
        if (r11 != r1) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010c, code lost:
        r11 = ((java.lang.Number) r11).intValue();
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("runDbMigration, ticiId: " + r10.getId() + ", ticiEntity partCount: " + r11, "TiciHelper");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0130, code lost:
        if (r11 > 0) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0132, code lost:
        r6 = r10.getId();
        r11 = kotlin.collections.CollectionsKt.listOf(r10.getSourceText());
        r0.L$0 = r2;
        r0.L$1 = r10;
        r0.label = 4;
        r11 = r2.o(r6, r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0149, code lost:
        if (r11 != r1) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x014c, code lost:
        r11 = (java.util.List) r11;
        r10 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r7 = r2.getId();
        r0.L$0 = r6;
        r0.L$1 = r2;
        r0.L$2 = r11;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0165, code lost:
        if (r10.f(r7, r0) != r1) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0167, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0168, code lost:
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0169, code lost:
        r11 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = r6;
        r0.L$1 = r2;
        r0.L$2 = r10;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x017c, code lost:
        if (r11.p(r10, r0) != r1) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x017e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x017f, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("runDbMigration, ticiId: " + r10.getId() + ", saveTiciContentPart: " + r11.size(), "TiciHelper");
        r10.setCurrentPage(0);
        r10.setTotalPage(r11.size());
        r10.setTotalTextLength(r10.getSourceText().length());
        r11 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = r2;
        r0.L$1 = r10;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01ca, code lost:
        if (r11.n(r10, r0) != r1) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01cc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01cd, code lost:
        r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10.getId());
        r10 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01da, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.upuphone.ar.tici.phone.utils.TiciHelper$runDbMigration$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.upuphone.ar.tici.phone.utils.TiciHelper$runDbMigration$1 r0 = (com.upuphone.ar.tici.phone.utils.TiciHelper$runDbMigration$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.tici.phone.utils.TiciHelper$runDbMigration$1 r0 = new com.upuphone.ar.tici.phone.utils.TiciHelper$runDbMigration$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "runDbMigration, ticiId: "
            java.lang.String r4 = "TiciHelper"
            r5 = 0
            switch(r2) {
                case 0: goto L_0x008e;
                case 1: goto L_0x0086;
                case 2: goto L_0x007e;
                case 3: goto L_0x0071;
                case 4: goto L_0x0062;
                case 5: goto L_0x0051;
                case 6: goto L_0x003d;
                case 7: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0030:
            java.lang.Object r10 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r10 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r10
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r2 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x01cd
        L_0x003d:
            java.lang.Object r10 = r0.L$2
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r2 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r2
            java.lang.Object r6 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r6 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r6
            kotlin.ResultKt.throwOnFailure(r11)
        L_0x004c:
            r11 = r10
            r10 = r2
            r2 = r6
            goto L_0x017f
        L_0x0051:
            java.lang.Object r10 = r0.L$2
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r2 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r2
            java.lang.Object r6 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r6 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r6
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0169
        L_0x0062:
            java.lang.Object r10 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r10 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r10
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r2 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r2
            kotlin.ResultKt.throwOnFailure(r11)
        L_0x006d:
            r6 = r2
            r2 = r10
            goto L_0x014c
        L_0x0071:
            java.lang.Object r10 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r10 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r10
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r2 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x010c
        L_0x007e:
            java.lang.Object r10 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r10 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00cf
        L_0x0086:
            java.lang.Object r10 = r0.L$0
            com.upuphone.ar.tici.phone.utils.TiciHelper r10 = (com.upuphone.ar.tici.phone.utils.TiciHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00b2
        L_0x008e:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r5
        L_0x0092:
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            boolean r2 = kotlinx.coroutines.JobKt.l(r2)
            if (r2 == 0) goto L_0x01d8
            if (r11 != 0) goto L_0x00b7
            com.upuphone.ar.tici.phone.TiciApp r11 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r11 = r11.w()
            r0.L$0 = r10
            r0.L$1 = r5
            r2 = 1
            r0.label = r2
            java.lang.Object r11 = r11.r(r0)
            if (r11 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
        L_0x00b4:
            r2 = r10
            r10 = r11
            goto L_0x00d2
        L_0x00b7:
            com.upuphone.ar.tici.phone.TiciApp r2 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r2 = r2.w()
            long r6 = r11.longValue()
            r0.L$0 = r10
            r0.L$1 = r5
            r11 = 2
            r0.label = r11
            java.lang.Object r11 = r2.A(r6, r0)
            if (r11 != r1) goto L_0x00cf
            return r1
        L_0x00cf:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            goto L_0x00b4
        L_0x00d2:
            if (r10 != 0) goto L_0x00dc
            java.lang.String r10 = "runDbMigration, finish"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r10, r4)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00dc:
            java.lang.String r11 = r10.toSimpleString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "runDbMigration, ticiEntity: "
            r6.append(r7)
            r6.append(r11)
            java.lang.String r11 = r6.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r11, r4)
            com.upuphone.ar.tici.phone.TiciApp r11 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r11 = r11.w()
            long r6 = r10.getId()
            r0.L$0 = r2
            r0.L$1 = r10
            r8 = 3
            r0.label = r8
            java.lang.Object r11 = r11.e(r6, r0)
            if (r11 != r1) goto L_0x010c
            return r1
        L_0x010c:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            long r6 = r10.getId()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            r8.append(r6)
            java.lang.String r6 = ", ticiEntity partCount: "
            r8.append(r6)
            r8.append(r11)
            java.lang.String r6 = r8.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r6, r4)
            if (r11 > 0) goto L_0x01cd
            long r6 = r10.getId()
            java.lang.String r11 = r10.getSourceText()
            java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r11)
            r0.L$0 = r2
            r0.L$1 = r10
            r8 = 4
            r0.label = r8
            java.lang.Object r11 = r2.o(r6, r11, r0)
            if (r11 != r1) goto L_0x006d
            return r1
        L_0x014c:
            java.util.List r11 = (java.util.List) r11
            com.upuphone.ar.tici.phone.TiciApp r10 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r10 = r10.w()
            long r7 = r2.getId()
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r11
            r9 = 5
            r0.label = r9
            java.lang.Object r10 = r10.f(r7, r0)
            if (r10 != r1) goto L_0x0168
            return r1
        L_0x0168:
            r10 = r11
        L_0x0169:
            com.upuphone.ar.tici.phone.TiciApp r11 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r11 = r11.w()
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r10
            r7 = 6
            r0.label = r7
            java.lang.Object r11 = r11.p(r10, r0)
            if (r11 != r1) goto L_0x004c
            return r1
        L_0x017f:
            long r6 = r10.getId()
            int r8 = r11.size()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            r9.append(r6)
            java.lang.String r6 = ", saveTiciContentPart: "
            r9.append(r6)
            r9.append(r8)
            java.lang.String r6 = r9.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r6, r4)
            r6 = 0
            r10.setCurrentPage(r6)
            int r11 = r11.size()
            r10.setTotalPage(r11)
            java.lang.String r11 = r10.getSourceText()
            int r11 = r11.length()
            r10.setTotalTextLength(r11)
            com.upuphone.ar.tici.phone.TiciApp r11 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r11 = r11.w()
            r0.L$0 = r2
            r0.L$1 = r10
            r0.L$2 = r5
            r6 = 7
            r0.label = r6
            java.lang.Object r11 = r11.n(r10, r0)
            if (r11 != r1) goto L_0x01cd
            return r1
        L_0x01cd:
            long r10 = r10.getId()
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            r10 = r2
            goto L_0x0092
        L_0x01d8:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper.l(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object m(String str, Continuation continuation) {
        Object g = BuildersKt.g(Dispatchers.b(), new TiciHelper$runSPMigration$2(str, (Continuation<? super TiciHelper$runSPMigration$2>) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    public final Object n(String str, int i, Continuation continuation) {
        return BuildersKt.g(Dispatchers.a(), new TiciHelper$splitTiciContent$2(str, i, (Continuation<? super TiciHelper$splitTiciContent$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o(long r27, java.util.List r29, kotlin.coroutines.Continuation r30) {
        /*
            r26 = this;
            r0 = r30
            boolean r1 = r0 instanceof com.upuphone.ar.tici.phone.utils.TiciHelper$transformTiciContentPart$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            com.upuphone.ar.tici.phone.utils.TiciHelper$transformTiciContentPart$1 r1 = (com.upuphone.ar.tici.phone.utils.TiciHelper$transformTiciContentPart$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001c
        L_0x0015:
            com.upuphone.ar.tici.phone.utils.TiciHelper$transformTiciContentPart$1 r1 = new com.upuphone.ar.tici.phone.utils.TiciHelper$transformTiciContentPart$1
            r2 = r26
            r1.<init>(r2, r0)
        L_0x001c:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x0059
            if (r3 != r4) goto L_0x0051
            int r3 = r1.I$2
            int r5 = r1.I$1
            int r6 = r1.I$0
            long r7 = r1.J$0
            java.lang.Object r9 = r1.L$3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r1.L$2
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r1.L$0
            java.util.List r12 = (java.util.List) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r5
            r20 = r6
            r18 = r7
        L_0x004a:
            r21 = r9
            r22 = r10
            r15 = r11
            r13 = r12
            goto L_0x00b1
        L_0x0051:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef
            r3.<init>()
            java.util.Iterator r5 = r29.iterator()
            r6 = 0
            r12 = r0
            r11 = r3
            r10 = r5
            r5 = r6
            r3 = r1
            r0 = r27
        L_0x0072:
            boolean r6 = r10.hasNext()
            if (r6 == 0) goto L_0x00ed
            java.lang.Object r6 = r10.next()
            int r7 = r5 + 1
            if (r5 >= 0) goto L_0x0083
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0083:
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            int r6 = com.upuphone.ar.tici.phone.utils.StringExtKt.a(r9)
            com.upuphone.ar.tici.phone.utils.ParagraphHelper$Companion r8 = com.upuphone.ar.tici.phone.utils.ParagraphHelper.f5995a
            r3.L$0 = r12
            r3.L$1 = r11
            r3.L$2 = r10
            r3.L$3 = r9
            r3.J$0 = r0
            r3.I$0 = r7
            r3.I$1 = r5
            r3.I$2 = r6
            r3.label = r4
            r13 = 70
            java.lang.Object r8 = r8.c(r9, r13, r3)
            if (r8 != r2) goto L_0x00a7
            return r2
        L_0x00a7:
            r18 = r0
            r1 = r3
            r16 = r5
            r3 = r6
            r20 = r7
            r0 = r8
            goto L_0x004a
        L_0x00b1:
            r11 = r0
            java.util.List r11 = (java.util.List) r11
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r0 = new com.upuphone.ar.tici.phone.db.entity.TiciContentPart
            long r8 = (long) r3
            int r3 = r15.element
            int r5 = r21.length()
            int r17 = r3 + r5
            r6 = 0
            r12 = 0
            r5 = r0
            r23 = r8
            r8 = r18
            r10 = r21
            r4 = r13
            r13 = r23
            r25 = r15
            r15 = r16
            r16 = r3
            r5.<init>(r6, r8, r10, r11, r12, r13, r15, r16, r17)
            r4.add(r0)
            r11 = r25
            int r0 = r11.element
            int r3 = r21.length()
            int r0 = r0 + r3
            r11.element = r0
            r3 = r1
            r12 = r4
            r0 = r18
            r5 = r20
            r10 = r22
            r4 = 1
            goto L_0x0072
        L_0x00ed:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper.o(long, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
