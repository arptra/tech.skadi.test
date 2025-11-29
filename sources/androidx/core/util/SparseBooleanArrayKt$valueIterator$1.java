package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"androidx/core/util/SparseBooleanArrayKt$valueIterator$1", "Lkotlin/collections/BooleanIterator;", "", "hasNext", "()Z", "nextBoolean", "", "a", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class SparseBooleanArrayKt$valueIterator$1 extends BooleanIterator {

    /* renamed from: a  reason: collision with root package name */
    public int f855a;
    public final /* synthetic */ SparseBooleanArray b;

    public boolean hasNext() {
        return this.f855a < this.b.size();
    }

    public boolean nextBoolean() {
        SparseBooleanArray sparseBooleanArray = this.b;
        int i = this.f855a;
        this.f855a = i + 1;
        return sparseBooleanArray.valueAt(i);
    }
}
