package androidx.databinding.library.baseAdapters;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f1009a = new SparseIntArray(0);

    public static class InnerBrLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final SparseArray f1010a;

        static {
            SparseArray sparseArray = new SparseArray(1);
            f1010a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    public static class InnerLayoutIdLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap f1011a = new HashMap(0);
    }

    public List a() {
        return new ArrayList(0);
    }

    public ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i) {
        if (f1009a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding c(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f1009a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
