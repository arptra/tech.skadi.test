package flyme.support.v7.widget;

import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class MzRecyclerViewHelper {
    public static final String TAG = "MzRecyclerViewHelper";

    public static RecyclerView.AdapterDataObserver getRecyclerViewDataObserver(Class cls, MzRecyclerView mzRecyclerView) {
        try {
            Field declaredField = cls.getDeclaredField("mObserver");
            declaredField.setAccessible(true);
            return (RecyclerView.AdapterDataObserver) declaredField.get(mzRecyclerView);
        } catch (Exception e) {
            Log.e(TAG, "getRecyclerViewDataObserver ex" + e.toString());
            return null;
        }
    }

    public static int getRvStateStepField(Class cls, RecyclerView.State state) {
        try {
            Field declaredField = cls.getDeclaredField("mLayoutStep");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(state)).intValue();
        } catch (Exception e) {
            Log.e(TAG, "getRvStateStepField ex" + e.toString());
            return 0;
        }
    }

    public static RecyclerView.State getStateField(Class cls, MzRecyclerView mzRecyclerView) {
        try {
            Field declaredField = cls.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return (RecyclerView.State) declaredField.get(mzRecyclerView);
        } catch (Exception e) {
            Log.e(TAG, "getStateField ex" + e.toString());
            return null;
        }
    }

    public static Interpolator getsQuinticInterpolator(Class cls, MzRecyclerView mzRecyclerView) {
        try {
            Field declaredField = cls.getDeclaredField("sQuinticInterpolator");
            declaredField.setAccessible(true);
            return (Interpolator) declaredField.get(mzRecyclerView);
        } catch (Exception e) {
            Log.e(TAG, "getsQuinticInterpolator ex" + e.toString());
            return null;
        }
    }

    public static void invokeRvRecyclerVClear(Class cls, MzRecyclerView mzRecyclerView) {
        try {
            Field declaredField = cls.getDeclaredField("mRecycler");
            declaredField.setAccessible(true);
            ((RecyclerView.Recycler) declaredField.get(mzRecyclerView)).clear();
        } catch (Exception e) {
            Log.e(TAG, "invokeRvRecyclerVClear ex" + e.toString());
        }
    }

    public static boolean invokeRvScrollByInternal(int i, int i2, MotionEvent motionEvent, int i3, Class cls, MzRecyclerView mzRecyclerView) {
        try {
            Class cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("scrollByInternal", new Class[]{cls2, cls2, MotionEvent.class, cls2});
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(mzRecyclerView, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), motionEvent, Integer.valueOf(i3)})).booleanValue();
        } catch (Exception e) {
            Log.e(TAG, "invokeRvScrollByInternal ex" + e.toString());
            return false;
        }
    }

    public static void invokeRvSetScrollState(int i, Class cls, MzRecyclerView mzRecyclerView) {
        try {
            Log.e(TAG, "invokeRvSetScrollState ");
            Method declaredMethod = cls.getDeclaredMethod("setScrollState", new Class[]{Integer.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(mzRecyclerView, new Object[]{Integer.valueOf(i)});
        } catch (Exception e) {
            Log.e(TAG, "invokeRvSetScrollState ex" + e.toString());
        }
    }

    public static boolean invokeRvStateDidStructureChange(Class cls, MzRecyclerView mzRecyclerView) {
        try {
            Field declaredField = cls.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return ((RecyclerView.State) declaredField.get(mzRecyclerView)).didStructureChange();
        } catch (Exception e) {
            Log.e(TAG, "invokeRvStateDidStructureChange ex" + e.toString());
            return false;
        }
    }

    public static void setInnerAdapterAsHeadAndFootAdapter(Class cls, MzRecyclerView mzRecyclerView, HeaderAndFooterWrapperAdapter headerAndFooterWrapperAdapter) {
        try {
            Field declaredField = cls.getDeclaredField("mAdapter");
            declaredField.setAccessible(true);
            declaredField.set(mzRecyclerView, headerAndFooterWrapperAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
