package com.upuphone.ai.assistant.stks;

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
    public static final SparseIntArray f5487a = new SparseIntArray(0);

    public static class InnerBrLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final SparseArray f5488a;

        static {
            SparseArray sparseArray = new SparseArray(1);
            f5488a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    public static class InnerLayoutIdLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap f5489a = new HashMap(0);
    }

    public List a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    public ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i) {
        if (f5487a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding c(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f5487a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
