package rxhttp.wrapper.callback;

import com.google.common.net.HttpHeaders;
import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Response;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.entity.ExpandOutputStream;
import rxhttp.wrapper.utils.Utils;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0002*\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012¨\u0006\u0013"}, d2 = {"Lrxhttp/wrapper/callback/FileOutputStreamFactory;", "Lrxhttp/wrapper/callback/OutputStreamFactory;", "", "localPath", "<init>", "(Ljava/lang/String;)V", "", "a", "()J", "Lokhttp3/Response;", "response", "Lrxhttp/wrapper/entity/ExpandOutputStream;", "b", "(Lokhttp3/Response;)Lrxhttp/wrapper/entity/ExpandOutputStream;", "d", "(Ljava/lang/String;Lokhttp3/Response;)Ljava/lang/String;", "c", "(Lokhttp3/Response;)Ljava/lang/String;", "Ljava/lang/String;", "rxhttp"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nOutputStreamFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OutputStreamFactory.kt\nrxhttp/wrapper/callback/FileOutputStreamFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,114:1\n1855#2,2:115\n*S KotlinDebug\n*F\n+ 1 OutputStreamFactory.kt\nrxhttp/wrapper/callback/FileOutputStreamFactory\n*L\n88#1:115,2\n*E\n"})
public final class FileOutputStreamFactory extends OutputStreamFactory<String> {

    /* renamed from: a  reason: collision with root package name */
    public final String f3539a;

    public FileOutputStreamFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "localPath");
        this.f3539a = str;
    }

    public long a() {
        return new File(this.f3539a).length();
    }

    public ExpandOutputStream b(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        File file = new File(d(this.f3539a, response));
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            ExpandOutputStream c = ExpandOutputStream.c(file, Utils.c(response));
            Intrinsics.checkNotNullExpressionValue(c, "run(...)");
            return c;
        }
        throw new IOException("Directory " + parentFile + " create fail");
    }

    public final String c(Response response) {
        String f = OkHttpCompat.f(response, HttpHeaders.CONTENT_DISPOSITION);
        if (f == null) {
            return null;
        }
        for (String split$default : StringsKt.split$default((CharSequence) f, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD}, false, 0, 6, (Object) null)) {
            List split$default2 = StringsKt.split$default((CharSequence) split$default, new String[]{"="}, false, 0, 6, (Object) null);
            if (split$default2.size() > 1) {
                String obj = StringsKt.trim((CharSequence) (String) split$default2.get(0)).toString();
                if (Intrinsics.areEqual((Object) obj, (Object) "filename")) {
                    String str = (String) split$default2.get(1);
                    if (new Regex("^[\"'][\\s\\S]*[\"']$").matches(str)) {
                        str = str.substring(1, str.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                    }
                    return URLDecoder.decode(str, "UTF-8");
                } else if (!Intrinsics.areEqual((Object) obj, (Object) "filename*")) {
                    return null;
                } else {
                    String str2 = (String) split$default2.get(1);
                    String str3 = str2;
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, "'", 0, false, 6, (Object) null);
                    int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str3, "'", 0, false, 6, (Object) null);
                    if (indexOf$default == -1 || lastIndexOf$default == -1 || indexOf$default >= lastIndexOf$default) {
                        return null;
                    }
                    String substring = str2.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    String substring2 = str2.substring(lastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    return URLDecoder.decode(substring2, substring);
                }
            }
        }
        return null;
    }

    public final String d(String str, Response response) {
        if (!StringsKt.endsWith(str, "%s", true) && !StringsKt.endsWith(str, "%1$s", true)) {
            return str;
        }
        String c = c(response);
        if (c == null) {
            List l = OkHttpCompat.l(response);
            Intrinsics.checkNotNullExpressionValue(l, "pathSegments(...)");
            c = (String) CollectionsKt.last(l);
        }
        String format = String.format(str, Arrays.copyOf(new Object[]{c}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
