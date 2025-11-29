package com.meizu.common.util;

import android.content.ClipData;
import android.util.Log;
import android.view.ActionMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.meizu.common.widget.AnimCheckBox;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ListViewProxy implements InvocationHandler {
    public static final int ACTION_DRAG_FLAG_NFC_SHARE = 1;
    public static final int ACTION_DRAG_FLAG_NONE = 0;
    public static final int ACTION_TYPE_NORMAL = 0;
    public static final int ACTION_TYPE_WARNING = 1;
    private static Method mApplyMeizuPartitionStyle = null;
    private static Method mCheckedAll = null;
    private static Field mChoiceActionMode = null;
    private static Method mEnableOverScroll = null;
    private static Method mGetDragPosition = null;
    private static Method mNotifyDragDropAnimType = null;
    private static Method mNotifyStatusBarNfcShareStateChanged = null;
    private static Method mSetDelayTopOverScrollEnabled = null;
    private static Method mSetDelayTopOverScrollOffset = null;
    private static Method mSetDividerFilterListenerMethod = null;
    private static Method mSetDividerPaddingListenerMethod = null;
    private static Method mSetDragListenerMethod = null;
    private static Method mSetDragSelectionListenerMethod = null;
    private static Method mSetEnableDragSelectionMethod = null;
    private static Method mSetEnableHoldPress = null;
    private static Method mStartDragMz = null;
    private static Method mUnCheckedAll = null;
    private static final String tag = "AbsListViewProxy";
    protected AbsListView mAbsList;
    private boolean mIsFlyOS = true;

    public ListViewProxy(AbsListView absListView) {
        this.mAbsList = absListView;
    }

    private Object createListenerInstance(Class<?> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
    }

    private void getDragPostionAndId(long[] jArr) {
        if (this.mAbsList != null) {
            Object obj = null;
            try {
                if (mGetDragPosition == null) {
                    mGetDragPosition = AbsListView.class.getMethod("getDragPosition", (Class[]) null);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                mGetDragPosition = null;
            }
            ListAdapter listAdapter = (ListAdapter) this.mAbsList.getAdapter();
            Method method = mGetDragPosition;
            if (method != null && listAdapter != null) {
                try {
                    obj = method.invoke(this.mAbsList, (Object[]) null);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
                if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    long itemId = ((ListAdapter) this.mAbsList.getAdapter()).getItemId(intValue);
                    jArr[0] = (long) intValue;
                    jArr[1] = itemId;
                }
            }
        }
    }

    public static boolean notifyDragDropAnimType(View view, int i) {
        if (!CommonUtils.isFlymeOS()) {
            return false;
        }
        Class<View> cls = View.class;
        try {
            if (mNotifyDragDropAnimType == null) {
                mNotifyDragDropAnimType = cls.getDeclaredMethod("notifyDragDropAnimType", new Class[]{Integer.TYPE});
            }
            mNotifyDragDropAnimType.setAccessible(true);
            mNotifyDragDropAnimType.invoke(view, (Object[]) null);
            return true;
        } catch (Exception unused) {
            Log.e(tag, "notifyDragDropAnimType fail to be invoked");
            mNotifyDragDropAnimType = null;
            return false;
        }
    }

    public static boolean notifyStatusBarNfcShareStateChanged(View view, boolean z) {
        if (!CommonUtils.isFlymeOS()) {
            return false;
        }
        Class<View> cls = View.class;
        try {
            if (mNotifyStatusBarNfcShareStateChanged == null) {
                mNotifyStatusBarNfcShareStateChanged = cls.getDeclaredMethod("notifyStatusBarNfcShareStateChanged", new Class[]{Boolean.TYPE});
            }
            mNotifyStatusBarNfcShareStateChanged.setAccessible(true);
            mNotifyStatusBarNfcShareStateChanged.invoke(view, (Object[]) null);
            return true;
        } catch (Exception unused) {
            Log.e(tag, "notifyStatusBarNfcShareStateChanged fail to be invoked");
            mNotifyStatusBarNfcShareStateChanged = null;
            return false;
        }
    }

    public static boolean setItemForChecked(AbsListView absListView, View view) {
        View findViewById;
        if (view == null || CommonUtils.isFlymeOS() || absListView.getChoiceMode() != 3 || (findViewById = view.findViewById(16908289)) == null || !(findViewById instanceof Checkable)) {
            return false;
        }
        if (findViewById instanceof AnimCheckBox) {
            ((AnimCheckBox) findViewById).setIsAnimation(true);
        }
        if (absListView.getCheckedItemCount() > 0) {
            ((Checkable) findViewById).setChecked(true);
        } else {
            ((Checkable) findViewById).setChecked(false);
        }
        return true;
    }

    public static boolean startDragMz(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        if (!CommonUtils.isFlymeOS()) {
            return false;
        }
        Class<View> cls = View.class;
        try {
            if (mStartDragMz == null) {
                mStartDragMz = cls.getDeclaredMethod("startDragMz", new Class[]{ClipData.class, View.DragShadowBuilder.class, Object.class, Integer.TYPE});
            }
            mStartDragMz.setAccessible(true);
            mStartDragMz.invoke(view, (Object[]) null);
            return true;
        } catch (Exception unused) {
            Log.e(tag, "startDragMz fail to be invoked");
            mStartDragMz = null;
            return false;
        }
    }

    public boolean applyMeizuPartitionStyle() {
        if (this.mIsFlyOS && (this.mAbsList instanceof ListView)) {
            Class<ListView> cls = ListView.class;
            try {
                if (mApplyMeizuPartitionStyle == null) {
                    mApplyMeizuPartitionStyle = cls.getDeclaredMethod("applyMeizuPartitionStyle", (Class[]) null);
                }
                mApplyMeizuPartitionStyle.setAccessible(true);
                mApplyMeizuPartitionStyle.invoke(this.mAbsList, (Object[]) null);
                return true;
            } catch (Exception unused) {
                Log.e(tag, "setCenterListContent fail to be invoked");
                mApplyMeizuPartitionStyle = null;
            }
        }
        return false;
    }

    public boolean bottomDeviderEnabled() {
        return true;
    }

    public boolean checkedAll() {
        if (!this.mIsFlyOS) {
            for (int i = 0; i < this.mAbsList.getCount(); i++) {
                this.mAbsList.setItemChecked(i, true);
            }
            return true;
        } else if (!(this.mAbsList instanceof ListView)) {
            Log.e("tag", "the Target is not a ListView");
            return false;
        } else {
            Class<ListView> cls = ListView.class;
            try {
                if (mCheckedAll == null) {
                    mCheckedAll = cls.getDeclaredMethod("checkedAll", (Class[]) null);
                }
                mCheckedAll.setAccessible(true);
                mCheckedAll.invoke(this.mAbsList, (Object[]) null);
                return true;
            } catch (Exception unused) {
                mCheckedAll = null;
                Log.e(tag, "checkedAll fail to be invoked");
                return false;
            }
        }
    }

    public boolean dividerEnabled(int i) {
        return true;
    }

    public boolean finishMultiChoice() {
        if (!this.mIsFlyOS) {
            return false;
        }
        ActionMode actionMode = null;
        Class<AbsListView> cls = AbsListView.class;
        try {
            if (mChoiceActionMode == null) {
                mChoiceActionMode = cls.getDeclaredField("mChoiceActionMode");
            }
            mChoiceActionMode.setAccessible(true);
            if (mChoiceActionMode.get(this.mAbsList) instanceof ActionMode) {
                actionMode = (ActionMode) mChoiceActionMode.get(this.mAbsList);
            }
            if (actionMode == null) {
                return false;
            }
            actionMode.finish();
            return true;
        } catch (Exception unused) {
            Log.e(tag, "finishMultiChoice fail to be invoked");
            mChoiceActionMode = null;
            return false;
        }
    }

    public int getActionItemType(MenuItem menuItem) {
        return 0;
    }

    public int[] getDividerPadding(int i) {
        return null;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        int i;
        try {
            String name = method.getName();
            if ("onActionItemDragStart".equals(name)) {
                if (objArr.length > 0) {
                    i = onActionItemDragStart(objArr[0].intValue(), objArr[1].longValue());
                } else {
                    long[] jArr = new long[2];
                    getDragPostionAndId(jArr);
                    i = onActionItemDragStart((int) jArr[0], jArr[1]);
                }
                return Integer.valueOf(i);
            } else if ("onActionItemDrop".equals(name)) {
                onActionItemDrop(objArr[0], objArr[1].intValue(), objArr[2].longValue());
                return null;
            } else if ("onActionItemDragEnd".equals(name)) {
                if (objArr.length > 0) {
                    onActionItemDragEnd(objArr[0].intValue(), objArr[1].longValue());
                    return null;
                }
                long[] jArr2 = new long[2];
                getDragPostionAndId(jArr2);
                onActionItemDragEnd((int) jArr2[0], jArr2[1]);
                return null;
            } else if ("getActionItemType".equals(name)) {
                return Integer.valueOf(getActionItemType(objArr[0]));
            } else {
                if ("onDragSelection".equals(name)) {
                    return Boolean.valueOf(onDragSelection(objArr[0], objArr[1].intValue(), objArr[2].longValue()));
                }
                if ("topDividerEnabled".equals(name)) {
                    return Boolean.valueOf(topDividerEnabled());
                }
                if ("dividerEnabled".equals(name)) {
                    return Boolean.valueOf(dividerEnabled(objArr[0].intValue()));
                }
                if ("bottomDeviderEnabled".equals(name)) {
                    return Boolean.valueOf(bottomDeviderEnabled());
                }
                if ("getDividerPadding".equals(name)) {
                    return getDividerPadding(objArr[0].intValue());
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onActionItemDragEnd(int i, long j) {
    }

    public int onActionItemDragStart(int i, long j) {
        return 0;
    }

    public void onActionItemDrop(MenuItem menuItem, int i, long j) {
    }

    public boolean onDragSelection(View view, int i, long j) {
        return false;
    }

    public boolean setCenterListContent(boolean z) {
        return false;
    }

    public boolean setDelayTopOverScrollEnabled(boolean z) {
        if (this.mIsFlyOS) {
            Class<AbsListView> cls = AbsListView.class;
            try {
                if (mSetDelayTopOverScrollEnabled == null) {
                    mSetDelayTopOverScrollEnabled = cls.getDeclaredMethod("setDelayTopOverScrollEnabled", new Class[]{Boolean.TYPE});
                }
                mSetDelayTopOverScrollEnabled.setAccessible(true);
                mSetDelayTopOverScrollEnabled.invoke(this.mAbsList, new Object[]{Boolean.valueOf(z)});
                return true;
            } catch (Exception unused) {
                Log.e(tag, "setDelayTopOverScrollEnabled fail to be invoked");
                mSetDelayTopOverScrollEnabled = null;
            }
        }
        return false;
    }

    public boolean setDelayTopOverScrollOffset(int i) {
        if (this.mIsFlyOS) {
            Class<AbsListView> cls = AbsListView.class;
            try {
                if (mSetDelayTopOverScrollOffset == null) {
                    mSetDelayTopOverScrollOffset = cls.getDeclaredMethod("setDelayTopOverScrollOffset", new Class[]{Integer.TYPE});
                }
                mSetDelayTopOverScrollOffset.setAccessible(true);
                mSetDelayTopOverScrollOffset.invoke(this.mAbsList, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Exception unused) {
                Log.e(tag, "setDelayTopOverScrollOffset fail to be invoked");
                mSetDelayTopOverScrollOffset = null;
            }
        }
        return false;
    }

    public boolean setDividerFilterListener() {
        if (this.mIsFlyOS && (this.mAbsList instanceof ListView)) {
            try {
                Class<?> cls = Class.forName("android.widget.ListView$DividerFilter");
                if (mSetDividerFilterListenerMethod == null) {
                    mSetDividerFilterListenerMethod = ListView.class.getMethod("setDividerFilterListener", new Class[]{cls});
                }
                try {
                    Object createListenerInstance = createListenerInstance(cls);
                    if (createListenerInstance == null) {
                        return false;
                    }
                    mSetDividerFilterListenerMethod.invoke(this.mAbsList, new Object[]{createListenerInstance});
                    return true;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return false;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return false;
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                mSetDividerFilterListenerMethod = null;
            }
        }
        return false;
    }

    public boolean setDividerPaddingsListener() {
        if (this.mIsFlyOS && (this.mAbsList instanceof ListView)) {
            try {
                Class<?> cls = Class.forName("android.widget.ListView$DividerPadding");
                if (mSetDividerPaddingListenerMethod == null) {
                    mSetDividerPaddingListenerMethod = ListView.class.getMethod("setDividerPadding", new Class[]{cls});
                }
                try {
                    Object createListenerInstance = createListenerInstance(cls);
                    if (createListenerInstance == null) {
                        return false;
                    }
                    mSetDividerPaddingListenerMethod.invoke(this.mAbsList, new Object[]{createListenerInstance});
                    return true;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return false;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return false;
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                mSetDividerPaddingListenerMethod = null;
            }
        }
        return false;
    }

    public boolean setEnableDragSelection(boolean z) {
        if (this.mIsFlyOS && (this.mAbsList instanceof ListView)) {
            try {
                if (mSetEnableDragSelectionMethod == null) {
                    mSetEnableDragSelectionMethod = ListView.class.getMethod("setEnableDragSelection", new Class[]{Boolean.TYPE});
                }
                try {
                    mSetEnableDragSelectionMethod.invoke(this.mAbsList, new Object[]{Boolean.valueOf(z)});
                    return true;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return false;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return false;
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                mSetEnableDragSelectionMethod = null;
            }
        }
        return false;
    }

    public boolean setEnableDragSelectionListener() {
        if (this.mIsFlyOS && (this.mAbsList instanceof ListView)) {
            try {
                Class<?> cls = Class.forName("android.widget.ListView$OnDragSelectListener");
                if (mSetDragSelectionListenerMethod == null) {
                    mSetDragSelectionListenerMethod = ListView.class.getMethod("setEnableDragSelection", new Class[]{cls});
                }
                try {
                    Object createListenerInstance = createListenerInstance(cls);
                    if (createListenerInstance == null) {
                        return false;
                    }
                    mSetDragSelectionListenerMethod.invoke(this.mAbsList, new Object[]{createListenerInstance});
                    return true;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return false;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return false;
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                mSetDragSelectionListenerMethod = null;
            }
        }
        return false;
    }

    public boolean setEnableHoldPress(boolean z) {
        if (!this.mIsFlyOS) {
            return false;
        }
        try {
            if (mSetEnableHoldPress == null) {
                mSetEnableHoldPress = AbsListView.class.getDeclaredMethod("setEnableHoldPress", new Class[]{Boolean.TYPE});
            }
            mSetEnableHoldPress.invoke(this.mAbsList, new Object[]{Boolean.valueOf(z)});
            return true;
        } catch (Exception unused) {
            mSetEnableHoldPress = null;
            Log.e(tag, "mSetEnableHoldPress fail to be invoked");
            return false;
        }
    }

    public boolean setEnableOverScroll(boolean z) {
        if (!this.mIsFlyOS) {
            return false;
        }
        try {
            if (mEnableOverScroll == null) {
                mEnableOverScroll = AbsListView.class.getDeclaredMethod("setEnableOverScroll", new Class[]{Boolean.TYPE});
            }
            mEnableOverScroll.invoke(this.mAbsList, new Object[]{Boolean.valueOf(z)});
            return true;
        } catch (Exception unused) {
            mEnableOverScroll = null;
            Log.e(tag, "mEnableOverScroll fail to be invoked");
            return false;
        }
    }

    public boolean setEnabledMultiChoice() {
        if (!this.mIsFlyOS) {
            this.mAbsList.setChoiceMode(3);
            return true;
        }
        try {
            Class<?> cls = Class.forName("android.widget.AbsListView$OnItemDragListener");
            if (mSetDragListenerMethod == null) {
                mSetDragListenerMethod = AbsListView.class.getMethod("setItemDragListener", new Class[]{cls});
            }
            Object createListenerInstance = createListenerInstance(cls);
            if (createListenerInstance != null) {
                try {
                    mSetDragListenerMethod.invoke(this.mAbsList, new Object[]{createListenerInstance});
                    this.mAbsList.setChoiceMode(4);
                    return true;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            mSetDragListenerMethod = null;
            return false;
        }
    }

    public void setFlymeOS(boolean z) {
        this.mIsFlyOS = z;
    }

    public boolean topDividerEnabled() {
        return true;
    }

    public boolean unCheckedAll() {
        AbsListView absListView = this.mAbsList;
        if (!(absListView instanceof ListView)) {
            Log.e("tag", "unchecked error");
            return false;
        } else if (!this.mIsFlyOS) {
            absListView.clearChoices();
            this.mAbsList.setItemChecked(0, false);
            this.mAbsList.requestLayout();
            return true;
        } else {
            Class<ListView> cls = ListView.class;
            try {
                if (mUnCheckedAll == null) {
                    mUnCheckedAll = cls.getDeclaredMethod("unCheckedAll", (Class[]) null);
                }
                mUnCheckedAll.setAccessible(true);
                mUnCheckedAll.invoke(this.mAbsList, (Object[]) null);
                return true;
            } catch (Exception unused) {
                Log.e(tag, "unCheckedAll fail to be invoked");
                mUnCheckedAll = null;
                return false;
            }
        }
    }
}
