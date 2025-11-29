package androidx.work;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0006\u001a\u00020\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005¨\u0006\u0007"}, d2 = {"", "className", "Landroidx/work/InputMerger;", "a", "(Ljava/lang/String;)Landroidx/work/InputMerger;", "Ljava/lang/String;", "TAG", "work-runtime_release"}, k = 2, mv = {1, 8, 0})
public final class InputMergerKt {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2056a;

    static {
        String i = Logger.i("InputMerger");
        Intrinsics.checkNotNullExpressionValue(i, "tagWithPrefix(\"InputMerger\")");
        f2056a = i;
    }

    public static final InputMerger a(String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            Object newInstance = Class.forName(str).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type androidx.work.InputMerger");
            return (InputMerger) newInstance;
        } catch (Exception e) {
            Logger e2 = Logger.e();
            String str2 = f2056a;
            e2.d(str2, "Trouble instantiating " + str, e);
            return null;
        }
    }
}
