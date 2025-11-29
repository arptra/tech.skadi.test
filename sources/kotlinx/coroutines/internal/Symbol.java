package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/internal/Symbol;", "", "", "symbol", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public final class Symbol {

    /* renamed from: a  reason: collision with root package name */
    public final String f3931a;

    public Symbol(String str) {
        this.f3931a = str;
    }

    public String toString() {
        return Typography.less + this.f3931a + Typography.greater;
    }
}
