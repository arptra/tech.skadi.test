package flyme.support.v7.util;

import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class ListViewProxy implements InvocationHandler {
    private static Class<?> mDividerPaddingListenerClass = null;
    private static Method mSetDividerPaddingListenerMethod = null;
    private static final String tag = "AbsListViewProxy";
    protected AbsListView mAbsList;
    private boolean mIsFlyOS = true;

    public ListViewProxy(AbsListView absListView) {
        this.mAbsList = absListView;
    }

    private Object createListenerInstance(Class<?> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
    }

    public abstract int[] getDividerPadding(int i);

    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            if ("getDividerPadding".equals(method.getName())) {
                return getDividerPadding(objArr[0].intValue());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean setDividerPaddingsListener() {
        if (this.mIsFlyOS && (this.mAbsList instanceof ListView)) {
            try {
                if (mDividerPaddingListenerClass == null) {
                    mDividerPaddingListenerClass = Class.forName("android.widget.ListView$DividerPadding");
                }
                if (mSetDividerPaddingListenerMethod == null) {
                    mSetDividerPaddingListenerMethod = ListView.class.getMethod("setDividerPadding", new Class[]{mDividerPaddingListenerClass});
                }
                try {
                    Object createListenerInstance = createListenerInstance(mDividerPaddingListenerClass);
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
                mDividerPaddingListenerClass = null;
                mSetDividerPaddingListenerMethod = null;
            }
        }
        return false;
    }
}
