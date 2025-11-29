package io.ktor.client.request.forms;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R(\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@RX\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\b\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lio/ktor/client/request/forms/MultiPartFormDataContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "d", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/ContentType;", "a", "Lio/ktor/http/ContentType;", "b", "()Lio/ktor/http/ContentType;", "contentType", "", "[B", "BOUNDARY_BYTES", "c", "LAST_BOUNDARY_BYTES", "", "Lio/ktor/client/request/forms/PreparedPart;", "Ljava/util/List;", "rawParts", "", "<set-?>", "e", "Ljava/lang/Long;", "()Ljava/lang/Long;", "contentLength", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFormDataContent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FormDataContent.kt\nio/ktor/client/request/forms/MultiPartFormDataContent\n+ 2 Strings.kt\nio/ktor/utils/io/core/StringsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n+ 5 Closeable.kt\nio/ktor/utils/io/core/CloseableKt\n*L\n1#1,172:1\n7#2,4:173\n7#2,4:177\n1549#3:181\n1620#3,2:182\n1622#3:195\n12#4,11:184\n8#5,4:196\n22#5,4:200\n12#5,9:204\n*S KotlinDebug\n*F\n+ 1 FormDataContent.kt\nio/ktor/client/request/forms/MultiPartFormDataContent\n*L\n46#1:173,4\n47#1:177,4\n52#1:181\n52#1:182,2\n52#1:195\n72#1:184,11\n122#1:196,4\n122#1:200,4\n122#1:204,9\n*E\n"})
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {

    /* renamed from: a  reason: collision with root package name */
    public final ContentType f8923a;
    public final byte[] b;
    public final byte[] c;
    public final List d;
    public Long e;

    public Long a() {
        return this.e;
    }

    public ContentType b() {
        return this.f8923a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v46, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v33, resolved type: io.ktor.utils.io.ByteWriteChannel} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        r8 = r7;
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c9, code lost:
        if (r8.hasNext() == false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cb, code lost:
        r2 = (io.ktor.client.request.forms.PreparedPart) r8.next();
        r4 = r6.b;
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.L$3 = r2;
        r0.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e2, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.b(r7, r4, r0) != r1) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e5, code lost:
        r4 = r6;
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e7, code lost:
        r2 = r6.a();
        r0.L$0 = r4;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.L$3 = r6;
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fa, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.b(r7, r2, r0) != r1) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fd, code lost:
        r2 = io.ktor.client.request.forms.FormDataContentKt.f8921a;
        r0.L$0 = r4;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.L$3 = r6;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0110, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.b(r7, r2, r0) != r1) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0112, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0113, code lost:
        r2 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0117, code lost:
        if ((r6 instanceof io.ktor.client.request.forms.PreparedPart.InputPart) == false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0119, code lost:
        r6 = (java.io.Closeable) ((io.ktor.client.request.forms.PreparedPart.InputPart) r6).b().invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r0.L$0 = r4;
        r0.L$1 = r2;
        r0.L$2 = r7;
        r0.L$3 = r6;
        r0.I$0 = 0;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013a, code lost:
        if (io.ktor.client.request.forms.FormDataContentKt.c((io.ktor.utils.io.core.Input) r6, r2, r0) != r1) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0142, code lost:
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0144, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0145, code lost:
        r2 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0154, code lost:
        if ((r6 instanceof io.ktor.client.request.forms.PreparedPart.ChannelPart) == false) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0156, code lost:
        r0.L$0 = r4;
        r0.L$1 = r2;
        r0.L$2 = r7;
        r0.L$3 = null;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0171, code lost:
        if (io.ktor.utils.io.ByteReadChannelKt.d((io.ktor.utils.io.ByteReadChannel) ((io.ktor.client.request.forms.PreparedPart.ChannelPart) r6).b().invoke(), r2, r0) != r1) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0173, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0174, code lost:
        r6 = r7;
        r7 = r2;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0177, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0179, code lost:
        r6 = r7;
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r8 = io.ktor.client.request.forms.FormDataContentKt.f8921a;
        r0.L$0 = r4;
        r0.L$1 = r7;
        r0.L$2 = r6;
        r0.L$3 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x018e, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.b(r7, r8, r0) != r1) goto L_0x0191;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0190, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0191, code lost:
        r8 = r6;
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0195, code lost:
        r6 = r6.c;
        r0.L$0 = r7;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01a4, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.b(r7, r6, r0) != r1) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01a6, code lost:
        return r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(io.ktor.utils.io.ByteWriteChannel r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1 r0 = (io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1 r0 = new io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x00bc;
                case 1: goto L_0x00a6;
                case 2: goto L_0x0090;
                case 3: goto L_0x0077;
                case 4: goto L_0x005d;
                case 5: goto L_0x004c;
                case 6: goto L_0x0039;
                case 7: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002c:
            java.lang.Object r6 = r0.L$0
            r7 = r6
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0036 }
            goto L_0x01a7
        L_0x0036:
            r6 = move-exception
            goto L_0x01ab
        L_0x0039:
            java.lang.Object r6 = r0.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r2 = (io.ktor.client.request.forms.MultiPartFormDataContent) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0036 }
            r8 = r6
            r6 = r2
            goto L_0x00c5
        L_0x004c:
            java.lang.Object r6 = r0.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r2 = (io.ktor.client.request.forms.MultiPartFormDataContent) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0036 }
            goto L_0x0177
        L_0x005d:
            java.lang.Object r6 = r0.L$3
            java.io.Closeable r6 = (java.io.Closeable) r6
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r4 = (io.ktor.client.request.forms.MultiPartFormDataContent) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0074 }
        L_0x0070:
            r8 = r7
            r7 = r2
            goto L_0x013d
        L_0x0074:
            r7 = move-exception
            goto L_0x0147
        L_0x0077:
            java.lang.Object r6 = r0.L$3
            io.ktor.client.request.forms.PreparedPart r6 = (io.ktor.client.request.forms.PreparedPart) r6
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r4 = (io.ktor.client.request.forms.MultiPartFormDataContent) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x008c }
            goto L_0x0115
        L_0x008c:
            r6 = move-exception
            r7 = r2
            goto L_0x01ab
        L_0x0090:
            java.lang.Object r6 = r0.L$3
            io.ktor.client.request.forms.PreparedPart r6 = (io.ktor.client.request.forms.PreparedPart) r6
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r4 = (io.ktor.client.request.forms.MultiPartFormDataContent) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x008c }
            r8 = r7
            r7 = r2
            goto L_0x00fd
        L_0x00a6:
            java.lang.Object r6 = r0.L$3
            io.ktor.client.request.forms.PreparedPart r6 = (io.ktor.client.request.forms.PreparedPart) r6
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.client.request.forms.MultiPartFormDataContent r4 = (io.ktor.client.request.forms.MultiPartFormDataContent) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x008c }
            r8 = r7
            r7 = r2
            goto L_0x00e7
        L_0x00bc:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.List r8 = r6.d     // Catch:{ all -> 0x0036 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0036 }
        L_0x00c5:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x0195
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x0036 }
            io.ktor.client.request.forms.PreparedPart r2 = (io.ktor.client.request.forms.PreparedPart) r2     // Catch:{ all -> 0x0036 }
            byte[] r4 = r6.b     // Catch:{ all -> 0x0036 }
            r0.L$0 = r6     // Catch:{ all -> 0x0036 }
            r0.L$1 = r7     // Catch:{ all -> 0x0036 }
            r0.L$2 = r8     // Catch:{ all -> 0x0036 }
            r0.L$3 = r2     // Catch:{ all -> 0x0036 }
            r5 = 1
            r0.label = r5     // Catch:{ all -> 0x0036 }
            java.lang.Object r4 = io.ktor.utils.io.ByteWriteChannelKt.b(r7, r4, r0)     // Catch:{ all -> 0x0036 }
            if (r4 != r1) goto L_0x00e5
            return r1
        L_0x00e5:
            r4 = r6
            r6 = r2
        L_0x00e7:
            byte[] r2 = r6.a()     // Catch:{ all -> 0x0036 }
            r0.L$0 = r4     // Catch:{ all -> 0x0036 }
            r0.L$1 = r7     // Catch:{ all -> 0x0036 }
            r0.L$2 = r8     // Catch:{ all -> 0x0036 }
            r0.L$3 = r6     // Catch:{ all -> 0x0036 }
            r5 = 2
            r0.label = r5     // Catch:{ all -> 0x0036 }
            java.lang.Object r2 = io.ktor.utils.io.ByteWriteChannelKt.b(r7, r2, r0)     // Catch:{ all -> 0x0036 }
            if (r2 != r1) goto L_0x00fd
            return r1
        L_0x00fd:
            byte[] r2 = io.ktor.client.request.forms.FormDataContentKt.f8921a     // Catch:{ all -> 0x0036 }
            r0.L$0 = r4     // Catch:{ all -> 0x0036 }
            r0.L$1 = r7     // Catch:{ all -> 0x0036 }
            r0.L$2 = r8     // Catch:{ all -> 0x0036 }
            r0.L$3 = r6     // Catch:{ all -> 0x0036 }
            r5 = 3
            r0.label = r5     // Catch:{ all -> 0x0036 }
            java.lang.Object r2 = io.ktor.utils.io.ByteWriteChannelKt.b(r7, r2, r0)     // Catch:{ all -> 0x0036 }
            if (r2 != r1) goto L_0x0113
            return r1
        L_0x0113:
            r2 = r7
            r7 = r8
        L_0x0115:
            boolean r8 = r6 instanceof io.ktor.client.request.forms.PreparedPart.InputPart     // Catch:{ all -> 0x008c }
            if (r8 == 0) goto L_0x0152
            io.ktor.client.request.forms.PreparedPart$InputPart r6 = (io.ktor.client.request.forms.PreparedPart.InputPart) r6     // Catch:{ all -> 0x008c }
            kotlin.jvm.functions.Function0 r6 = r6.b()     // Catch:{ all -> 0x008c }
            java.lang.Object r6 = r6.invoke()     // Catch:{ all -> 0x008c }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x008c }
            r8 = r6
            io.ktor.utils.io.core.Input r8 = (io.ktor.utils.io.core.Input) r8     // Catch:{ all -> 0x0074 }
            r0.L$0 = r4     // Catch:{ all -> 0x0074 }
            r0.L$1 = r2     // Catch:{ all -> 0x0074 }
            r0.L$2 = r7     // Catch:{ all -> 0x0074 }
            r0.L$3 = r6     // Catch:{ all -> 0x0074 }
            r5 = 0
            r0.I$0 = r5     // Catch:{ all -> 0x0074 }
            r5 = 4
            r0.label = r5     // Catch:{ all -> 0x0074 }
            java.lang.Object r8 = io.ktor.client.request.forms.FormDataContentKt.c(r8, r2, r0)     // Catch:{ all -> 0x0074 }
            if (r8 != r1) goto L_0x0070
            return r1
        L_0x013d:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0144 }
            r6.close()     // Catch:{ all -> 0x0036 }
            r6 = r8
            goto L_0x017b
        L_0x0144:
            r8 = move-exception
            r2 = r7
            r7 = r8
        L_0x0147:
            r6.close()     // Catch:{ all -> 0x014b }
            goto L_0x014f
        L_0x014b:
            r6 = move-exception
            io.ktor.utils.io.core.CloseableJVMKt.a(r7, r6)     // Catch:{ all -> 0x0150 }
        L_0x014f:
            throw r7     // Catch:{ all -> 0x0150 }
        L_0x0150:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x008c }
        L_0x0152:
            boolean r8 = r6 instanceof io.ktor.client.request.forms.PreparedPart.ChannelPart     // Catch:{ all -> 0x008c }
            if (r8 == 0) goto L_0x0179
            io.ktor.client.request.forms.PreparedPart$ChannelPart r6 = (io.ktor.client.request.forms.PreparedPart.ChannelPart) r6     // Catch:{ all -> 0x008c }
            kotlin.jvm.functions.Function0 r6 = r6.b()     // Catch:{ all -> 0x008c }
            java.lang.Object r6 = r6.invoke()     // Catch:{ all -> 0x008c }
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6     // Catch:{ all -> 0x008c }
            r0.L$0 = r4     // Catch:{ all -> 0x008c }
            r0.L$1 = r2     // Catch:{ all -> 0x008c }
            r0.L$2 = r7     // Catch:{ all -> 0x008c }
            r0.L$3 = r3     // Catch:{ all -> 0x008c }
            r8 = 5
            r0.label = r8     // Catch:{ all -> 0x008c }
            java.lang.Object r6 = io.ktor.utils.io.ByteReadChannelKt.d(r6, r2, r0)     // Catch:{ all -> 0x008c }
            if (r6 != r1) goto L_0x0174
            return r1
        L_0x0174:
            r6 = r7
            r7 = r2
            r2 = r4
        L_0x0177:
            r4 = r2
            goto L_0x017b
        L_0x0179:
            r6 = r7
            r7 = r2
        L_0x017b:
            byte[] r8 = io.ktor.client.request.forms.FormDataContentKt.f8921a     // Catch:{ all -> 0x0036 }
            r0.L$0 = r4     // Catch:{ all -> 0x0036 }
            r0.L$1 = r7     // Catch:{ all -> 0x0036 }
            r0.L$2 = r6     // Catch:{ all -> 0x0036 }
            r0.L$3 = r3     // Catch:{ all -> 0x0036 }
            r2 = 6
            r0.label = r2     // Catch:{ all -> 0x0036 }
            java.lang.Object r8 = io.ktor.utils.io.ByteWriteChannelKt.b(r7, r8, r0)     // Catch:{ all -> 0x0036 }
            if (r8 != r1) goto L_0x0191
            return r1
        L_0x0191:
            r8 = r6
            r6 = r4
            goto L_0x00c5
        L_0x0195:
            byte[] r6 = r6.c     // Catch:{ all -> 0x0036 }
            r0.L$0 = r7     // Catch:{ all -> 0x0036 }
            r0.L$1 = r3     // Catch:{ all -> 0x0036 }
            r0.L$2 = r3     // Catch:{ all -> 0x0036 }
            r8 = 7
            r0.label = r8     // Catch:{ all -> 0x0036 }
            java.lang.Object r6 = io.ktor.utils.io.ByteWriteChannelKt.b(r7, r6, r0)     // Catch:{ all -> 0x0036 }
            if (r6 != r1) goto L_0x01a7
            return r1
        L_0x01a7:
            io.ktor.utils.io.ByteWriteChannelKt.a(r7)
            goto L_0x01af
        L_0x01ab:
            r7.h(r6)     // Catch:{ all -> 0x01b2 }
            goto L_0x01a7
        L_0x01af:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x01b2:
            r6 = move-exception
            io.ktor.utils.io.ByteWriteChannelKt.a(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.MultiPartFormDataContent.d(io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
