package com.upuphone.xr.sapp.request;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

@SourceDebugExtension({"SMAP\nFileUploadReq.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUploadReq.kt\ncom/upuphone/xr/sapp/request/FileUploadReq$uploadByUri$requestBody$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n1#2:322\n*E\n"})
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/request/FileUploadReq$uploadByUri$requestBody$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileUploadReq$uploadByUri$requestBody$1 extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7825a;
    public final /* synthetic */ long b;
    public final /* synthetic */ InputStream c;
    public final /* synthetic */ Function1 d;

    public FileUploadReq$uploadByUri$requestBody$1(String str, long j, InputStream inputStream, Function1 function1) {
        this.f7825a = str;
        this.b = j;
        this.c = inputStream;
        this.d = function1;
    }

    public long contentLength() {
        return this.b;
    }

    public MediaType contentType() {
        return MediaType.Companion.parse(this.f7825a);
    }

    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        byte[] bArr = new byte[8192];
        InputStream inputStream = this.c;
        Function1 function1 = this.d;
        long j = this.b;
        long j2 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    j2 += (long) read;
                    if (function1 != null) {
                        function1.invoke(Double.valueOf((((double) j2) / ((double) j)) * ((double) 100)));
                    }
                    bufferedSink.write(bArr, 0, read);
                } else {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    return;
                }
            } catch (Throwable th) {
                CloseableKt.closeFinally(inputStream, th);
                throw th;
            }
        }
    }
}
