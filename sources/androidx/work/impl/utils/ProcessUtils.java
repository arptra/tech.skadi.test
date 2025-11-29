package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n¨\u0006\f"}, d2 = {"Landroid/content/Context;", "context", "Landroidx/work/Configuration;", "configuration", "", "b", "(Landroid/content/Context;Landroidx/work/Configuration;)Z", "", "a", "(Landroid/content/Context;)Ljava/lang/String;", "Ljava/lang/String;", "TAG", "work-runtime_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nProcessUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessUtils.kt\nandroidx/work/impl/utils/ProcessUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
@JvmName(name = "ProcessUtils")
public final class ProcessUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2236a;

    static {
        String i = Logger.i("ProcessUtils");
        Intrinsics.checkNotNullExpressionValue(i, "tagWithPrefix(\"ProcessUtils\")");
        f2236a = i;
    }

    public static final String a(Context context) {
        return Api28Impl.f2226a.a();
    }

    public static final boolean b(Context context, Configuration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        String a2 = a(context);
        String c = configuration.c();
        return (c == null || c.length() == 0) ? Intrinsics.areEqual((Object) a2, (Object) context.getApplicationInfo().processName) : Intrinsics.areEqual((Object) a2, (Object) configuration.c());
    }
}
