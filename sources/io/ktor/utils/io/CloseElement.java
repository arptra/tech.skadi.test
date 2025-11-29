package io.ktor.utils.io;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/CloseElement;", "", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "a", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class CloseElement {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f9081a;

    public CloseElement(Throwable th) {
        this.f9081a = th;
    }

    public final Throwable a() {
        return this.f9081a;
    }
}
