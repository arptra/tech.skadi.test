package com.upuphone.ar.navi.lite;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.upuphone.ar.navi.lite.databinding.ActivityAddressBindingImpl;
import com.upuphone.ar.navi.lite.databinding.ActivitySettingBindingImpl;
import com.upuphone.ar.navi.lite.databinding.HistoryItemBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f5637a;

    public static class InnerBrLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final SparseArray f5638a;

        static {
            SparseArray sparseArray = new SparseArray(3);
            f5638a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "item");
            sparseArray.put(2, "viewModel");
        }
    }

    public static class InnerLayoutIdLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap f5639a;

        static {
            HashMap hashMap = new HashMap(3);
            f5639a = hashMap;
            hashMap.put("layout/activity_address_0", Integer.valueOf(R.layout.activity_address));
            hashMap.put("layout/activity_setting_0", Integer.valueOf(R.layout.activity_setting));
            hashMap.put("layout/history_item_0", Integer.valueOf(R.layout.history_item));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        f5637a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_address, 1);
        sparseIntArray.put(R.layout.activity_setting, 2);
        sparseIntArray.put(R.layout.history_item, 3);
    }

    public List a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    public ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = f5637a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                if ("layout/history_item_0".equals(tag)) {
                    return new HistoryItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for history_item is invalid. Received: " + tag);
            } else if ("layout/activity_setting_0".equals(tag)) {
                return new ActivitySettingBindingImpl(dataBindingComponent, view);
            } else {
                throw new IllegalArgumentException("The tag for activity_setting is invalid. Received: " + tag);
            }
        } else if ("layout/activity_address_0".equals(tag)) {
            return new ActivityAddressBindingImpl(dataBindingComponent, view);
        } else {
            throw new IllegalArgumentException("The tag for activity_address is invalid. Received: " + tag);
        }
    }

    public ViewDataBinding c(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f5637a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
