package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/Data;", "T", "Landroidx/datastore/core/State;", "value", "", "hashCode", "<init>", "(Ljava/lang/Object;I)V", "", "a", "()V", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "I", "getHashCode", "()I", "datastore-core"}, k = 1, mv = {1, 5, 1})
final class Data<T> extends State<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1013a;
    public final int b;

    public Data(Object obj, int i) {
        super((DefaultConstructorMarker) null);
        this.f1013a = obj;
        this.b = i;
    }

    public final void a() {
        Object obj = this.f1013a;
        boolean z = false;
        if ((obj != null ? obj.hashCode() : 0) == this.b) {
            z = true;
        }
        if (!z) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }

    public final Object b() {
        return this.f1013a;
    }
}
