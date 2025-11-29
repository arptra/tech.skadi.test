package com.upuphone.xr.sapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.upuphone.xr.sapp.databinding.FragmentStarryNetDeviceListBindingImpl;
import com.upuphone.xr.sapp.databinding.LayoutDoubleChannelControlBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f6589a;

    public static class InnerBrLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final SparseArray f6590a;

        static {
            SparseArray sparseArray = new SparseArray(3);
            f6590a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "item");
            sparseArray.put(2, "viewModel");
        }
    }

    public static class InnerLayoutIdLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap f6591a;

        static {
            HashMap hashMap = new HashMap(2);
            f6591a = hashMap;
            hashMap.put("layout/fragment_starry_net_device_list_0", Integer.valueOf(R.layout.fragment_starry_net_device_list));
            hashMap.put("layout/layout_double_channel_control_0", Integer.valueOf(R.layout.layout_double_channel_control));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f6589a = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_starry_net_device_list, 1);
        sparseIntArray.put(R.layout.layout_double_channel_control, 2);
    }

    public List a() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.chad.library.DataBinderMapperImpl());
        arrayList.add(new com.upuphone.ar.navi.lite.DataBinderMapperImpl());
        return arrayList;
    }

    public ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = f6589a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            if ("layout/layout_double_channel_control_0".equals(tag)) {
                return new LayoutDoubleChannelControlBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for layout_double_channel_control is invalid. Received: " + tag);
        } else if ("layout/fragment_starry_net_device_list_0".equals(tag)) {
            return new FragmentStarryNetDeviceListBindingImpl(dataBindingComponent, view);
        } else {
            throw new IllegalArgumentException("The tag for fragment_starry_net_device_list is invalid. Received: " + tag);
        }
    }

    public ViewDataBinding c(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f6589a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
