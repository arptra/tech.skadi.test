package rxhttp.wrapper.callback;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import rxhttp.wrapper.entity.ExpandOutputStream;
import rxhttp.wrapper.utils.UriUtil;
import rxhttp.wrapper.utils.Utils;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000e¨\u0006\u0010"}, d2 = {"Lrxhttp/wrapper/callback/UriOutputStreamFactory;", "Lrxhttp/wrapper/callback/OutputStreamFactory;", "Landroid/net/Uri;", "", "a", "()J", "Lokhttp3/Response;", "response", "Lrxhttp/wrapper/entity/ExpandOutputStream;", "b", "(Lokhttp3/Response;)Lrxhttp/wrapper/entity/ExpandOutputStream;", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "rxhttp"}, k = 1, mv = {1, 9, 0})
public final class UriOutputStreamFactory extends OutputStreamFactory<Uri> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3543a;
    public final Uri b;

    public long a() {
        return UriUtil.b(this.b, this.f3543a);
    }

    public ExpandOutputStream b(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        ExpandOutputStream b2 = ExpandOutputStream.b(this.f3543a, this.b, Utils.c(response));
        Intrinsics.checkNotNullExpressionValue(b2, "open(...)");
        return b2;
    }
}
