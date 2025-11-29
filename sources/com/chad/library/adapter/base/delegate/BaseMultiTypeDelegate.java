package com.chad.library.adapter.base.delegate;

import android.util.SparseIntArray;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J%\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/chad/library/adapter/base/delegate/BaseMultiTypeDelegate;", "T", "", "", "data", "", "position", "a", "(Ljava/util/List;I)I", "viewType", "b", "(I)I", "Landroid/util/SparseIntArray;", "Landroid/util/SparseIntArray;", "layouts", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseMultiTypeDelegate<T> {

    /* renamed from: a  reason: collision with root package name */
    public SparseIntArray f2781a;

    public abstract int a(List list, int i);

    public final int b(int i) {
        int i2 = this.f2781a.get(i);
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException(("ViewType: " + i + " found layoutResId，please use registerItemType() first!").toString());
    }
}
