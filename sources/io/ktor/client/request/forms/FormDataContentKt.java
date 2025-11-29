package io.ktor.client.request.forms;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/core/Input;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "c", "(Lio/ktor/utils/io/core/Input;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "[B", "RN_BYTES", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFormDataContent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FormDataContent.kt\nio/ktor/client/request/forms/FormDataContentKt\n+ 2 WriterSession.kt\nio/ktor/utils/io/WriterSessionKt\n+ 3 Strings.kt\nio/ktor/utils/io/core/StringsKt\n*L\n1#1,172:1\n18#2,12:173\n7#3,4:185\n*S KotlinDebug\n*F\n+ 1 FormDataContent.kt\nio/ktor/client/request/forms/FormDataContentKt\n*L\n167#1:173,12\n14#1:185,4\n*E\n"})
public final class FormDataContentKt {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f8921a;

    static {
        byte[] bArr;
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual((Object) charset, (Object) charset)) {
            bArr = StringsKt.encodeToByteArray("\r\n");
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            bArr = CharsetJVMKt.g(newEncoder, "\r\n", 0, 2);
        }
        f8921a = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(io.ktor.utils.io.core.Input r18, io.ktor.utils.io.ByteWriteChannel r19, kotlin.coroutines.Continuation r20) {
        /*
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof io.ktor.client.request.forms.FormDataContentKt$copyTo$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            io.ktor.client.request.forms.FormDataContentKt$copyTo$1 r2 = (io.ktor.client.request.forms.FormDataContentKt$copyTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            io.ktor.client.request.forms.FormDataContentKt$copyTo$1 r2 = new io.ktor.client.request.forms.FormDataContentKt$copyTo$1
            r2.<init>(r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L_0x0070
            if (r4 == r8) goto L_0x006c
            if (r4 == r7) goto L_0x0055
            if (r4 == r6) goto L_0x0043
            if (r4 == r5) goto L_0x003a
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003a:
            java.lang.Object r0 = r2.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00ef
        L_0x0043:
            java.lang.Object r0 = r2.L$2
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.lang.Object r0 = r2.L$1
            io.ktor.utils.io.ByteWriteChannel r0 = (io.ktor.utils.io.ByteWriteChannel) r0
            java.lang.Object r4 = r2.L$0
            io.ktor.utils.io.core.Input r4 = (io.ktor.utils.io.core.Input) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r0 = r4
            goto L_0x0089
        L_0x0055:
            java.lang.Object r0 = r2.L$2
            io.ktor.utils.io.ByteWriteChannel r0 = (io.ktor.utils.io.ByteWriteChannel) r0
            java.lang.Object r4 = r2.L$1
            io.ktor.utils.io.ByteWriteChannel r4 = (io.ktor.utils.io.ByteWriteChannel) r4
            java.lang.Object r9 = r2.L$0
            io.ktor.utils.io.core.Input r9 = (io.ktor.utils.io.core.Input) r9
            kotlin.ResultKt.throwOnFailure(r1)
            r15 = r9
            r17 = r1
            r1 = r0
            r0 = r4
            r4 = r17
            goto L_0x00a0
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0084
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r1)
            boolean r1 = r0 instanceof io.ktor.utils.io.core.ByteReadPacket
            if (r1 == 0) goto L_0x0087
            io.ktor.utils.io.core.ByteReadPacket r0 = (io.ktor.utils.io.core.ByteReadPacket) r0
            r2.label = r8
            r1 = r19
            java.lang.Object r0 = r1.w(r0, r2)
            if (r0 != r3) goto L_0x0084
            return r3
        L_0x0084:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0087:
            r1 = r19
        L_0x0089:
            boolean r4 = r0.c0()
            if (r4 != 0) goto L_0x00f0
            r2.L$0 = r0
            r2.L$1 = r1
            r2.L$2 = r1
            r2.label = r7
            java.lang.Object r4 = io.ktor.utils.io.WriterSessionKt.e(r1, r8, r2)
            if (r4 != r3) goto L_0x009e
            return r3
        L_0x009e:
            r15 = r0
            r0 = r1
        L_0x00a0:
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4
            if (r4 != 0) goto L_0x00aa
            io.ktor.utils.io.core.Buffer$Companion r4 = io.ktor.utils.io.core.Buffer.g
            io.ktor.utils.io.core.Buffer r4 = r4.a()
        L_0x00aa:
            r16 = 0
            java.nio.ByteBuffer r10 = r4.h()     // Catch:{ all -> 0x00dc }
            int r9 = r4.k()     // Catch:{ all -> 0x00dc }
            long r11 = (long) r9     // Catch:{ all -> 0x00dc }
            int r9 = r4.g()     // Catch:{ all -> 0x00dc }
            long r13 = (long) r9     // Catch:{ all -> 0x00dc }
            long r13 = r13 - r11
            r9 = r15
            long r9 = io.ktor.utils.io.core.InputArraysKt.c(r9, r10, r11, r13)     // Catch:{ all -> 0x00dc }
            int r9 = (int) r9
            r4.a(r9)     // Catch:{ all -> 0x00da }
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)     // Catch:{ all -> 0x00da }
            r2.L$0 = r15
            r2.L$1 = r0
            r2.L$2 = r10
            r2.label = r6
            java.lang.Object r1 = io.ktor.utils.io.WriterSessionKt.c(r1, r4, r9, r2)
            if (r1 != r3) goto L_0x00d7
            return r3
        L_0x00d7:
            r1 = r0
            r0 = r15
            goto L_0x0089
        L_0x00da:
            r0 = move-exception
            goto L_0x00df
        L_0x00dc:
            r0 = move-exception
            r9 = r16
        L_0x00df:
            r2.L$0 = r0
            r6 = 0
            r2.L$1 = r6
            r2.L$2 = r6
            r2.label = r5
            java.lang.Object r1 = io.ktor.utils.io.WriterSessionKt.c(r1, r4, r9, r2)
            if (r1 != r3) goto L_0x00ef
            return r3
        L_0x00ef:
            throw r0
        L_0x00f0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.FormDataContentKt.c(io.ktor.utils.io.core.Input, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
