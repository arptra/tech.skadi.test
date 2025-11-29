package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.data.ImportFileState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper$importLargeTiciFile$2", f = "TiciHelper.kt", i = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8}, l = {139, 148, 149, 152, 205, 222, 228, 235, 240}, m = "invokeSuspend", n = {"file", "file", "maxLength", "file", "maxLength", "file", "maxLength", "maxLengthOffset", "fileReader", "contentSequence", "ticiEntity", "maxLength", "fileReader", "ticiEntity", "content", "maxLength", "totalRawTextLength", "totalTextLength", "totalPage", "totalByteSize", "fileReader", "ticiEntity", "content", "contentPart", "maxLength", "totalRawTextLength", "totalTextLength", "totalPage", "totalByteSize", "ticiEntity", "totalRawTextLength", "totalTextLength", "totalPage", "totalByteSize", "ticiEntity", "totalRawTextLength", "totalTextLength"}, s = {"L$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$3", "I$0", "I$1", "I$2", "I$3", "J$0", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "J$0", "L$0", "I$0", "I$1", "I$2", "J$0", "L$0", "I$0", "I$1"})
public final class TiciHelper$importLargeTiciFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImportFileState>, Object> {
    final /* synthetic */ String $filePath;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHelper$importLargeTiciFile$2(String str, Continuation<? super TiciHelper$importLargeTiciFile$2> continuation) {
        super(2, continuation);
        this.$filePath = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHelper$importLargeTiciFile$2(this.$filePath, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: java.io.File} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0376, code lost:
        if (r4.n(r3, r0) != r8) goto L_0x0379;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0378, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0379, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("importLargeTiciFile, update ticiEntity: " + r3.toSimpleString(), "TiciHelper");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0398, code lost:
        return new com.upuphone.ar.tici.phone.data.ImportFileState.Success(r3, r0.$filePath, r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0399, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x039a, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r11 = new com.upuphone.ar.tici.phone.data.ImportFileInfo(r4.length(), 0, (java.lang.String) null);
        com.upuphone.ar.tici.phone.utils.CommonExtKt.d("importLargeTiciFile, mime(" + r3 + ") is not supported", "TiciHelper", (java.lang.Throwable) null, 2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x03cb, code lost:
        return new com.upuphone.ar.tici.phone.data.ImportFileState.Fail(com.upuphone.ar.tici.phone.data.ImportFailReason.UnsupportedFile, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x03e9, code lost:
        r16 = r1.name();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03f0, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d4, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0103, code lost:
        r3 = (java.lang.String) r3;
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("importLargeTiciFile, mime: " + r3, "TiciHelper");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0119, code lost:
        if (r3 == null) goto L_0x039c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r1 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011f, code lost:
        r6 = 1700000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0125, code lost:
        if (r1 == -1050893613) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x012a, code lost:
        if (r1 == 817335912) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x012f, code lost:
        if (r1 == 904647503) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0139, code lost:
        if (r3.equals("application/msword") != false) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013d, code lost:
        r1 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a;
        r0.L$0 = r4;
        r0.I$0 = 1700000;
        r0.label = 2;
        r1 = r1.d(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0149, code lost:
        if (r1 != r8) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x014b, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x014c, code lost:
        r1 = (kotlin.sequences.Sequence) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x014e, code lost:
        r3 = r1;
        r1 = r6;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0159, code lost:
        if (r3.equals("text/plain") != false) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015d, code lost:
        r1 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a;
        r0.L$0 = r4;
        r0.I$0 = 1700000;
        r3 = 1700100;
        r0.I$1 = 1700100;
        r0.label = 4;
        r1 = r1.c(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x016f, code lost:
        if (r1 != r8) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0171, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0172, code lost:
        r1 = (java.nio.charset.Charset) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0174, code lost:
        if (r1 != null) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r12 = new com.upuphone.ar.tici.phone.data.ImportFileInfo(r4.length(), 0, (java.lang.String) null);
        com.upuphone.ar.tici.phone.utils.CommonExtKt.d("importLargeTiciFile, charset is null", "TiciHelper", (java.lang.Throwable) null, 2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0190, code lost:
        return new com.upuphone.ar.tici.phone.data.ImportFileState.Fail(com.upuphone.ar.tici.phone.data.ImportFailReason.UnknownEncoding, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0191, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0194, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("importLargeTiciFile, readTextSequence with charset: " + r1, "TiciHelper");
        r5 = new java.io.InputStreamReader(new java.io.FileInputStream(r4), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01b8, code lost:
        r3 = com.upuphone.ar.tici.phone.utils.FileExtKt.f(r5, r3, 10000);
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01c1, code lost:
        if (r3.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document") != false) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01c5, code lost:
        r1 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a;
        r0.L$0 = r4;
        r0.I$0 = 1700000;
        r0.label = 3;
        r1 = r1.f(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d2, code lost:
        if (r1 != r8) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d4, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01d5, code lost:
        r1 = (kotlin.sequences.Sequence) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01d9, code lost:
        r2 = r4.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "getName(...)");
        r2 = com.upuphone.ar.tici.phone.utils.StringExtKt.g(r2);
        r4 = com.upuphone.ar.tici.phone.TiciApp.b;
        r2 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.e(r2, "", (java.lang.Integer) null, r4.g());
        r4 = r4.w();
        r0.L$0 = r5;
        r0.L$1 = r3;
        r0.L$2 = r2;
        r0.I$0 = r1;
        r0.label = 5;
        r4 = r4.s(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0205, code lost:
        if (r4 != r8) goto L_0x0208;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0207, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0208, code lost:
        r2.setId(((java.lang.Number) r4).longValue());
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("importLargeTiciFile, insert ticiEntity: " + r2.toSimpleString(), "TiciHelper");
        r4 = 0;
        r12 = r1;
        r15 = r3.iterator();
        r13 = 0;
        r6 = 0;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0239, code lost:
        if (r15.hasNext() == false) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x023b, code lost:
        r1 = (java.lang.String) r15.next();
        r4 = r4 + r1.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0246, code lost:
        if (r4 <= r12) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0248, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("importLargeTiciFile, totalRawTextLength(" + r4 + ") reach max: " + r12, "TiciHelper");
        r11 = r2;
        r15 = r5;
        r24 = r6;
        r20 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x026a, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x026d, code lost:
        r3 = com.upuphone.ar.tici.phone.utils.StringExtKt.e(r1);
        r1 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a;
        r16 = r2.getId();
        r0.L$0 = r5;
        r0.L$1 = r2;
        r0.L$2 = r15;
        r0.L$3 = r3;
        r0.L$4 = r11;
        r0.I$0 = r12;
        r0.I$1 = r4;
        r0.I$2 = r6;
        r0.I$3 = r7;
        r0.J$0 = r13;
        r0.label = 6;
        r11 = r2;
        r18 = r3;
        r2 = r16;
        r16 = r4;
        r19 = r5;
        r24 = r6;
        r20 = r7;
        r1 = r1.j(r2, r18, r7, r6, r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02a4, code lost:
        if (r1 != r8) goto L_0x02a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02a6, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a7, code lost:
        r4 = r24;
        r6 = r12;
        r5 = r16;
        r12 = r18;
        r2 = r19;
        r3 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02b2, code lost:
        r7 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r1;
        r1 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = r2;
        r0.L$1 = r11;
        r0.L$2 = r15;
        r0.L$3 = r12;
        r0.L$4 = r7;
        r0.I$0 = r6;
        r0.I$1 = r5;
        r0.I$2 = r4;
        r0.I$3 = r3;
        r0.J$0 = r13;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02d6, code lost:
        if (r1.t(r7, r0) != r8) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02d8, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02d9, code lost:
        r21 = r15;
        r15 = r2;
        r1 = r13;
        r13 = r21;
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02e0, code lost:
        com.upuphone.ar.tici.phone.utils.CommonExtKt.e("importLargeTiciFile, saveTiciContentPart: " + r7.toSimpleString(), "TiciHelper");
        r4 = r4 + r12.length();
        r1 = r1 + ((long) com.upuphone.ar.tici.phone.utils.StringExtKt.a(r12));
        r12 = r6;
        r11 = null;
        r7 = r3 + 1;
        r6 = r4;
        r4 = r5;
        r5 = r15;
        r15 = r13;
        r2 = r14;
        r13 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0314, code lost:
        r11 = r2;
        r24 = r6;
        r20 = r7;
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x031c, code lost:
        if (r15 == null) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x031e, code lost:
        r0.L$0 = r11;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.I$0 = r5;
        r4 = r24;
        r0.I$1 = r4;
        r3 = r20;
        r0.I$2 = r3;
        r0.J$0 = r13;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x033d, code lost:
        if (com.upuphone.ar.tici.phone.utils.FileExtKt.a(r15, r0) != r8) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x033f, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0340, code lost:
        r6 = r11;
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0342, code lost:
        r13 = r1;
        r7 = r3;
        r1 = r4;
        r2 = r5;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0348, code lost:
        r7 = r20;
        r1 = r24;
        r2 = r5;
        r3 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0350, code lost:
        r3.setFileSize(r13);
        r3.setTotalTextLength(r1);
        r3.setTotalPage(r7);
        r4 = com.upuphone.ar.tici.phone.TiciApp.b.w();
        r0.L$0 = r3;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.I$0 = r2;
        r0.I$1 = r1;
        r0.label = 9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03f0  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r9 = 1
            r2 = 2
            java.lang.String r10 = "TiciHelper"
            r11 = 0
            switch(r1) {
                case 0: goto L_0x00d6;
                case 1: goto L_0x00cb;
                case 2: goto L_0x00bc;
                case 3: goto L_0x00ad;
                case 4: goto L_0x0098;
                case 5: goto L_0x0082;
                case 6: goto L_0x0059;
                case 7: goto L_0x0036;
                case 8: goto L_0x0025;
                case 9: goto L_0x0018;
                default: goto L_0x0010;
            }
        L_0x0010:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0018:
            int r1 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r3 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r3 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r3
            kotlin.ResultKt.throwOnFailure(r24)
            goto L_0x0379
        L_0x0025:
            long r1 = r0.J$0
            int r3 = r0.I$2
            int r4 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r6 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r6
            kotlin.ResultKt.throwOnFailure(r24)
            goto L_0x0342
        L_0x0036:
            long r1 = r0.J$0
            int r3 = r0.I$3
            int r4 = r0.I$2
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$4
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r7 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r7
            java.lang.Object r12 = r0.L$3
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r0.L$2
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r14 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r14 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r14
            java.lang.Object r15 = r0.L$0
            java.io.Reader r15 = (java.io.Reader) r15
            kotlin.ResultKt.throwOnFailure(r24)
            goto L_0x02e0
        L_0x0059:
            long r1 = r0.J$0
            int r3 = r0.I$3
            int r4 = r0.I$2
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r12 = r0.L$2
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r13 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r13
            java.lang.Object r14 = r0.L$0
            java.io.Reader r14 = (java.io.Reader) r14
            kotlin.ResultKt.throwOnFailure(r24)
            r15 = r12
            r11 = r13
            r12 = r7
            r21 = r1
            r1 = r24
            r2 = r14
            r13 = r21
            goto L_0x02b2
        L_0x0082:
            int r1 = r0.I$0
            java.lang.Object r2 = r0.L$2
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r2 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r2
            java.lang.Object r3 = r0.L$1
            kotlin.sequences.Sequence r3 = (kotlin.sequences.Sequence) r3
            java.lang.Object r4 = r0.L$0
            java.io.Reader r4 = (java.io.Reader) r4
            kotlin.ResultKt.throwOnFailure(r24)
            r5 = r4
            r4 = r24
            goto L_0x0208
        L_0x0098:
            int r1 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r4 = r0.L$0
            java.io.File r4 = (java.io.File) r4
            kotlin.ResultKt.throwOnFailure(r24)     // Catch:{ Exception -> 0x00a9 }
            r6 = r3
            r3 = r1
            r1 = r24
            goto L_0x0172
        L_0x00a9:
            r0 = move-exception
            r1 = r11
            goto L_0x03cc
        L_0x00ad:
            int r1 = r0.I$0
            java.lang.Object r3 = r0.L$0
            r4 = r3
            java.io.File r4 = (java.io.File) r4
            kotlin.ResultKt.throwOnFailure(r24)     // Catch:{ Exception -> 0x00a9 }
            r6 = r1
            r1 = r24
            goto L_0x01d5
        L_0x00bc:
            int r1 = r0.I$0
            java.lang.Object r3 = r0.L$0
            r4 = r3
            java.io.File r4 = (java.io.File) r4
            kotlin.ResultKt.throwOnFailure(r24)     // Catch:{ Exception -> 0x00a9 }
            r6 = r1
            r1 = r24
            goto L_0x014c
        L_0x00cb:
            java.lang.Object r1 = r0.L$0
            java.io.File r1 = (java.io.File) r1
            kotlin.ResultKt.throwOnFailure(r24)
            r3 = r24
        L_0x00d4:
            r4 = r1
            goto L_0x0103
        L_0x00d6:
            kotlin.ResultKt.throwOnFailure(r24)
            java.lang.String r1 = r0.$filePath
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "importLargeTiciFile, filePath: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r10)
            java.io.File r1 = new java.io.File
            java.lang.String r3 = r0.$filePath
            r1.<init>(r3)
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r3 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a
            r0.L$0 = r1
            r0.label = r9
            java.lang.Object r3 = r3.c(r1, r0)
            if (r3 != r8) goto L_0x00d4
            return r8
        L_0x0103:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "importLargeTiciFile, mime: "
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r10)
            if (r3 == 0) goto L_0x039c
            int r1 = r3.hashCode()     // Catch:{ Exception -> 0x0399 }
            r5 = -1050893613(0xffffffffc15ca2d3, float:-13.789752)
            r6 = 1700000(0x19f0a0, float:2.382207E-39)
            if (r1 == r5) goto L_0x01bb
            r5 = 817335912(0x30b78e68, float:1.3355477E-9)
            if (r1 == r5) goto L_0x0153
            r5 = 904647503(0x35ebd34f, float:1.7570363E-6)
            if (r1 == r5) goto L_0x0133
            goto L_0x039c
        L_0x0133:
            java.lang.String r1 = "application/msword"
            boolean r1 = r3.equals(r1)     // Catch:{ Exception -> 0x00a9 }
            if (r1 != 0) goto L_0x013d
            goto L_0x039c
        L_0x013d:
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r1 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a     // Catch:{ Exception -> 0x00a9 }
            r0.L$0 = r4     // Catch:{ Exception -> 0x00a9 }
            r0.I$0 = r6     // Catch:{ Exception -> 0x00a9 }
            r0.label = r2     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r1 = r1.d(r4, r0)     // Catch:{ Exception -> 0x00a9 }
            if (r1 != r8) goto L_0x014c
            return r8
        L_0x014c:
            kotlin.sequences.Sequence r1 = (kotlin.sequences.Sequence) r1     // Catch:{ Exception -> 0x00a9 }
        L_0x014e:
            r3 = r1
            r1 = r6
            r5 = r11
            goto L_0x01d9
        L_0x0153:
            java.lang.String r1 = "text/plain"
            boolean r1 = r3.equals(r1)     // Catch:{ Exception -> 0x00a9 }
            if (r1 != 0) goto L_0x015d
            goto L_0x039c
        L_0x015d:
            com.upuphone.ar.tici.phone.utils.TiciHelper r1 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a     // Catch:{ Exception -> 0x00a9 }
            r0.L$0 = r4     // Catch:{ Exception -> 0x00a9 }
            r0.I$0 = r6     // Catch:{ Exception -> 0x00a9 }
            r3 = 1700100(0x19f104, float:2.382348E-39)
            r0.I$1 = r3     // Catch:{ Exception -> 0x00a9 }
            r5 = 4
            r0.label = r5     // Catch:{ Exception -> 0x00a9 }
            java.lang.Object r1 = r1.c(r4, r0)     // Catch:{ Exception -> 0x00a9 }
            if (r1 != r8) goto L_0x0172
            return r8
        L_0x0172:
            java.nio.charset.Charset r1 = (java.nio.charset.Charset) r1     // Catch:{ Exception -> 0x00a9 }
            if (r1 != 0) goto L_0x0194
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo     // Catch:{ Exception -> 0x0191 }
            long r13 = r4.length()     // Catch:{ Exception -> 0x0191 }
            r15 = 0
            r17 = 0
            r12 = r0
            r12.<init>(r13, r15, r17)     // Catch:{ Exception -> 0x0191 }
            java.lang.String r3 = "importLargeTiciFile, charset is null"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r3, r10, r11, r2, r11)     // Catch:{ Exception -> 0x0191 }
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r3 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail     // Catch:{ Exception -> 0x0191 }
            com.upuphone.ar.tici.phone.data.ImportFailReason r5 = com.upuphone.ar.tici.phone.data.ImportFailReason.UnknownEncoding     // Catch:{ Exception -> 0x0191 }
            r3.<init>(r5, r0)     // Catch:{ Exception -> 0x0191 }
            return r3
        L_0x0191:
            r0 = move-exception
            goto L_0x03cc
        L_0x0194:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0191 }
            r5.<init>()     // Catch:{ Exception -> 0x0191 }
            java.lang.String r7 = "importLargeTiciFile, readTextSequence with charset: "
            r5.append(r7)     // Catch:{ Exception -> 0x0191 }
            r5.append(r1)     // Catch:{ Exception -> 0x0191 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0191 }
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r5, r10)     // Catch:{ Exception -> 0x0191 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0191 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0191 }
            r7.<init>(r4)     // Catch:{ Exception -> 0x0191 }
            r5.<init>(r7, r1)     // Catch:{ Exception -> 0x0191 }
            r7 = 10000(0x2710, float:1.4013E-41)
            kotlin.sequences.Sequence r1 = com.upuphone.ar.tici.phone.utils.FileExtKt.f(r5, r3, r7)     // Catch:{ Exception -> 0x0191 }
            r3 = r1
            r1 = r6
            goto L_0x01d9
        L_0x01bb:
            java.lang.String r1 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
            boolean r1 = r3.equals(r1)     // Catch:{ Exception -> 0x0399 }
            if (r1 != 0) goto L_0x01c5
            goto L_0x039c
        L_0x01c5:
            com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper$Companion r1 = com.upuphone.ar.tici.phone.utils.FileAnalyzeHelper.f5989a     // Catch:{ Exception -> 0x0399 }
            r0.L$0 = r4     // Catch:{ Exception -> 0x0399 }
            r0.I$0 = r6     // Catch:{ Exception -> 0x0399 }
            r3 = 3
            r0.label = r3     // Catch:{ Exception -> 0x0399 }
            java.lang.Object r1 = r1.f(r4, r0)     // Catch:{ Exception -> 0x0399 }
            if (r1 != r8) goto L_0x01d5
            return r8
        L_0x01d5:
            kotlin.sequences.Sequence r1 = (kotlin.sequences.Sequence) r1     // Catch:{ Exception -> 0x0399 }
            goto L_0x014e
        L_0x01d9:
            java.lang.String r2 = r4.getName()
            java.lang.String r4 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r2 = com.upuphone.ar.tici.phone.utils.StringExtKt.g(r2)
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b
            java.lang.String r6 = r4.g()
            java.lang.String r7 = ""
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r2 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.e(r2, r7, r11, r6)
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()
            r0.L$0 = r5
            r0.L$1 = r3
            r0.L$2 = r2
            r0.I$0 = r1
            r6 = 5
            r0.label = r6
            java.lang.Object r4 = r4.s(r2, r0)
            if (r4 != r8) goto L_0x0208
            return r8
        L_0x0208:
            java.lang.Number r4 = (java.lang.Number) r4
            long r6 = r4.longValue()
            r2.setId(r6)
            java.lang.String r4 = r2.toSimpleString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "importLargeTiciFile, insert ticiEntity: "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r4, r10)
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r6 = 0
            r12 = r1
            r15 = r3
            r13 = r6
            r6 = r4
            r7 = r6
        L_0x0235:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0314
            java.lang.Object r1 = r15.next()
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r1.length()
            int r4 = r4 + r3
            if (r4 <= r12) goto L_0x026d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "importLargeTiciFile, totalRawTextLength("
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = ") reach max: "
            r1.append(r3)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r10)
            r11 = r2
            r15 = r5
            r24 = r6
            r20 = r7
        L_0x026a:
            r5 = r4
            goto L_0x031c
        L_0x026d:
            java.lang.String r3 = com.upuphone.ar.tici.phone.utils.StringExtKt.e(r1)
            com.upuphone.ar.tici.phone.utils.TiciHelper r1 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a
            long r16 = r2.getId()
            r0.L$0 = r5
            r0.L$1 = r2
            r0.L$2 = r15
            r0.L$3 = r3
            r0.L$4 = r11
            r0.I$0 = r12
            r0.I$1 = r4
            r0.I$2 = r6
            r0.I$3 = r7
            r0.J$0 = r13
            r11 = 6
            r0.label = r11
            r11 = r2
            r18 = r3
            r2 = r16
            r16 = r4
            r4 = r18
            r19 = r5
            r5 = r7
            r24 = r6
            r20 = r7
            r7 = r23
            java.lang.Object r1 = r1.j(r2, r4, r5, r6, r7)
            if (r1 != r8) goto L_0x02a7
            return r8
        L_0x02a7:
            r4 = r24
            r6 = r12
            r5 = r16
            r12 = r18
            r2 = r19
            r3 = r20
        L_0x02b2:
            r7 = r1
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r7 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r7
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r1 = r1.w()
            r0.L$0 = r2
            r0.L$1 = r11
            r0.L$2 = r15
            r0.L$3 = r12
            r0.L$4 = r7
            r0.I$0 = r6
            r0.I$1 = r5
            r0.I$2 = r4
            r0.I$3 = r3
            r0.J$0 = r13
            r9 = 7
            r0.label = r9
            java.lang.Object r1 = r1.t(r7, r0)
            if (r1 != r8) goto L_0x02d9
            return r8
        L_0x02d9:
            r21 = r15
            r15 = r2
            r1 = r13
            r13 = r21
            r14 = r11
        L_0x02e0:
            java.lang.String r7 = r7.toSimpleString()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "importLargeTiciFile, saveTiciContentPart: "
            r9.append(r11)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r7, r10)
            int r7 = r12.length()
            int r4 = r4 + r7
            int r7 = com.upuphone.ar.tici.phone.utils.StringExtKt.a(r12)
            long r11 = (long) r7
            long r1 = r1 + r11
            r7 = 1
            int r3 = r3 + r7
            r12 = r6
            r9 = r7
            r11 = 0
            r7 = r3
            r6 = r4
            r4 = r5
            r5 = r15
            r15 = r13
            r21 = r1
            r2 = r14
            r13 = r21
            goto L_0x0235
        L_0x0314:
            r11 = r2
            r24 = r6
            r20 = r7
            r15 = r5
            goto L_0x026a
        L_0x031c:
            if (r15 == 0) goto L_0x0348
            r0.L$0 = r11
            r1 = 0
            r0.L$1 = r1
            r0.L$2 = r1
            r0.L$3 = r1
            r0.L$4 = r1
            r0.I$0 = r5
            r4 = r24
            r0.I$1 = r4
            r3 = r20
            r0.I$2 = r3
            r0.J$0 = r13
            r1 = 8
            r0.label = r1
            java.lang.Object r1 = com.upuphone.ar.tici.phone.utils.FileExtKt.a(r15, r0)
            if (r1 != r8) goto L_0x0340
            return r8
        L_0x0340:
            r6 = r11
            r1 = r13
        L_0x0342:
            r13 = r1
            r7 = r3
            r1 = r4
            r2 = r5
            r3 = r6
            goto L_0x0350
        L_0x0348:
            r4 = r24
            r3 = r20
            r7 = r3
            r1 = r4
            r2 = r5
            r3 = r11
        L_0x0350:
            r3.setFileSize(r13)
            r3.setTotalTextLength(r1)
            r3.setTotalPage(r7)
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()
            r0.L$0 = r3
            r5 = 0
            r0.L$1 = r5
            r0.L$2 = r5
            r0.L$3 = r5
            r0.L$4 = r5
            r0.I$0 = r2
            r0.I$1 = r1
            r5 = 9
            r0.label = r5
            java.lang.Object r4 = r4.n(r3, r0)
            if (r4 != r8) goto L_0x0379
            return r8
        L_0x0379:
            java.lang.String r4 = r3.toSimpleString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "importLargeTiciFile, update ticiEntity: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r4, r10)
            com.upuphone.ar.tici.phone.data.ImportFileState$Success r4 = new com.upuphone.ar.tici.phone.data.ImportFileState$Success
            java.lang.String r0 = r0.$filePath
            r4.<init>(r3, r0, r1, r2)
            return r4
        L_0x0399:
            r0 = move-exception
            r1 = 0
            goto L_0x03cc
        L_0x039c:
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo     // Catch:{ Exception -> 0x0399 }
            long r12 = r4.length()     // Catch:{ Exception -> 0x0399 }
            r14 = 0
            r16 = 0
            r11 = r0
            r11.<init>(r12, r14, r16)     // Catch:{ Exception -> 0x0399 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0399 }
            r1.<init>()     // Catch:{ Exception -> 0x0399 }
            java.lang.String r5 = "importLargeTiciFile, mime("
            r1.append(r5)     // Catch:{ Exception -> 0x0399 }
            r1.append(r3)     // Catch:{ Exception -> 0x0399 }
            java.lang.String r3 = ") is not supported"
            r1.append(r3)     // Catch:{ Exception -> 0x0399 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0399 }
            r3 = 0
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r1, r10, r3, r2, r3)     // Catch:{ Exception -> 0x0399 }
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r1 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail     // Catch:{ Exception -> 0x0399 }
            com.upuphone.ar.tici.phone.data.ImportFailReason r3 = com.upuphone.ar.tici.phone.data.ImportFailReason.UnsupportedFile     // Catch:{ Exception -> 0x0399 }
            r1.<init>(r3, r0)     // Catch:{ Exception -> 0x0399 }
            return r1
        L_0x03cc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "importLargeTiciFile, readFile error: "
            r3.append(r5)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 0
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r10, r3, r2, r3)
            com.upuphone.ar.tici.phone.data.ImportFileInfo r0 = new com.upuphone.ar.tici.phone.data.ImportFileInfo
            long r12 = r4.length()
            if (r1 == 0) goto L_0x03f0
            java.lang.String r11 = r1.name()
            r16 = r11
            goto L_0x03f2
        L_0x03f0:
            r16 = r3
        L_0x03f2:
            r14 = 0
            r11 = r0
            r11.<init>(r12, r14, r16)
            com.upuphone.ar.tici.phone.data.ImportFileState$Fail r1 = new com.upuphone.ar.tici.phone.data.ImportFileState$Fail
            com.upuphone.ar.tici.phone.data.ImportFailReason r2 = com.upuphone.ar.tici.phone.data.ImportFailReason.ReadFileError
            r1.<init>(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.TiciHelper$importLargeTiciFile$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ImportFileState> continuation) {
        return ((TiciHelper$importLargeTiciFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
