package io.ktor.client.plugins;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.ktor.client.plugins.observer.DelegatedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a^\u0010\u000b\u001a\u00020\u0000*\u00020\u00002F\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\"]\u0010\u0010\u001aH\u0012D\u0012B\b\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00010\r8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"]\u0010\u0012\u001aH\u0012D\u0012B\b\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00010\r8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "bytesSentTotal", "contentLength", "Lkotlin/coroutines/Continuation;", "", "", "listener", "c", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/jvm/functions/Function3;)Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/util/AttributeKey;", "a", "Lio/ktor/util/AttributeKey;", "UploadProgressListenerAttributeKey", "b", "DownloadProgressListenerAttributeKey", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class BodyProgressKt {

    /* renamed from: a  reason: collision with root package name */
    public static final AttributeKey f8831a = new AttributeKey("UploadProgressListenerAttributeKey");
    public static final AttributeKey b = new AttributeKey("DownloadProgressListenerAttributeKey");

    public static final HttpResponse c(HttpResponse httpResponse, Function3 function3) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(function3, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return DelegatedCallKt.a(httpResponse.p0(), ByteChannelUtilsKt.a(httpResponse.c(), httpResponse.getCoroutineContext(), HttpMessagePropertiesKt.c(httpResponse), function3)).g();
    }
}
