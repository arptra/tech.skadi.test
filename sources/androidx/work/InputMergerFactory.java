package androidx.work;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Landroidx/work/InputMergerFactory;", "", "<init>", "()V", "", "className", "Landroidx/work/InputMerger;", "a", "(Ljava/lang/String;)Landroidx/work/InputMerger;", "b", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public abstract class InputMergerFactory {
    public abstract InputMerger a(String str);

    public final InputMerger b(String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        InputMerger a2 = a(str);
        return a2 == null ? InputMergerKt.a(str) : a2;
    }
}
