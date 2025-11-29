package rxhttp.wrapper.callback;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import rxhttp.wrapper.entity.ExpandOutputStream;
import rxhttp.wrapper.utils.UriUtil;
import rxhttp.wrapper.utils.Utils;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lrxhttp/wrapper/callback/UriFactory;", "Lrxhttp/wrapper/callback/OutputStreamFactory;", "Landroid/net/Uri;", "Lokhttp3/Response;", "response", "c", "(Lokhttp3/Response;)Landroid/net/Uri;", "d", "()Landroid/net/Uri;", "", "a", "()J", "Lrxhttp/wrapper/entity/ExpandOutputStream;", "b", "(Lokhttp3/Response;)Lrxhttp/wrapper/entity/ExpandOutputStream;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "rxhttp"}, k = 1, mv = {1, 9, 0})
public abstract class UriFactory extends OutputStreamFactory<Uri> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3542a;

    public long a() {
        return UriUtil.b(d(), this.f3542a);
    }

    public final ExpandOutputStream b(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        ExpandOutputStream b = ExpandOutputStream.b(this.f3542a, c(response), Utils.c(response));
        Intrinsics.checkNotNullExpressionValue(b, "open(...)");
        return b;
    }

    public abstract Uri c(Response response);

    public Uri d() {
        return null;
    }
}
