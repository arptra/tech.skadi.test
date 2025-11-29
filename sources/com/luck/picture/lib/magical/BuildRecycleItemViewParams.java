package com.luck.picture.lib.magical;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BuildRecycleItemViewParams {

    /* renamed from: a  reason: collision with root package name */
    public static final List f9424a = new ArrayList();

    public static void a() {
        List list = f9424a;
        if (list.size() > 0) {
            list.clear();
        }
    }

    public static void b(List list, int i, int i2, int i3) {
        if (i2 > 0) {
            while (i2 >= 1) {
                list.add(0, (Object) null);
                i2--;
            }
        }
        if (i3 < i) {
            for (int i4 = (i - 1) - i3; i4 >= 1; i4--) {
                list.add((Object) null);
            }
        }
    }

    public static void c(ViewGroup viewGroup, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        boolean z = viewGroup instanceof RecyclerView;
        if (z) {
            i2 = ((RecyclerView) viewGroup).getChildCount();
        } else if (viewGroup instanceof ListView) {
            i2 = ((ListView) viewGroup).getChildCount();
        } else {
            throw new IllegalArgumentException(viewGroup.getClass().getCanonicalName() + " Must be " + RecyclerView.class + " or " + ListView.class);
        }
        for (int i6 = 0; i6 < i2; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt != null) {
                arrayList.add(childAt);
            }
        }
        if (z) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) ((RecyclerView) viewGroup).getLayoutManager();
            if (gridLayoutManager != null) {
                i5 = gridLayoutManager.getItemCount();
                i4 = gridLayoutManager.findFirstVisibleItemPosition();
                i3 = gridLayoutManager.findLastVisibleItemPosition();
            } else {
                return;
            }
        } else {
            ListView listView = (ListView) viewGroup;
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                i5 = adapter.getCount();
                i4 = listView.getFirstVisiblePosition();
                i3 = listView.getLastVisiblePosition();
            } else {
                return;
            }
        }
        if (i3 > i5) {
            i3 = i5 - 1;
        }
        b(arrayList, i5, i4, i3);
        f9424a.clear();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            View view = (View) arrayList.get(i7);
            ViewParams viewParams = new ViewParams();
            if (view == null) {
                viewParams.setLeft(0);
                viewParams.setTop(0);
                viewParams.setWidth(0);
                viewParams.setHeight(0);
            } else {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                viewParams.setLeft(iArr[0]);
                viewParams.setTop(iArr[1] - i);
                viewParams.setWidth(view.getWidth());
                viewParams.setHeight(view.getHeight());
            }
            f9424a.add(viewParams);
        }
    }

    public static ViewParams d(int i) {
        List list = f9424a;
        if (list.size() > i) {
            return (ViewParams) list.get(i);
        }
        return null;
    }
}
