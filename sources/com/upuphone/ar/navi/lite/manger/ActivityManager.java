package com.upuphone.ar.navi.lite.manger;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Stack;

public class ActivityManager {
    private static Stack<WeakReference<Activity>> mActStack = new Stack<>();

    public static class Singleton {
        /* access modifiers changed from: private */
        public static final ActivityManager INSTANCE = new ActivityManager();

        private Singleton() {
        }
    }

    public static ActivityManager getInstance() {
        return Singleton.INSTANCE;
    }

    private boolean isEqualsActivity(WeakReference<Activity> weakReference, Class cls) {
        return (weakReference == null || weakReference.get() == null || !weakReference.get().getClass().equals(cls)) ? false : true;
    }

    public void add(Activity activity) {
        mActStack.add(new WeakReference(activity));
    }

    public <T extends Activity> T find(Class cls) {
        return findFirst(cls);
    }

    public <T extends Activity> T findFirst(Class cls) {
        Iterator<WeakReference<Activity>> it = mActStack.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (isEqualsActivity((WeakReference<Activity>) next, cls)) {
                return (Activity) next.get();
            }
        }
        return null;
    }

    public <T extends Activity> T findLast(Class cls) {
        for (int size = mActStack.size() - 1; size >= 0; size--) {
            WeakReference weakReference = mActStack.get(size);
            if (isEqualsActivity((WeakReference<Activity>) weakReference, cls)) {
                return (Activity) weakReference.get();
            }
        }
        return null;
    }

    public void finish(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
        remove(activity);
    }

    public void finishAfter(Class cls) {
        Iterator<WeakReference<Activity>> it = mActStack.iterator();
        boolean z = false;
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (z) {
                if (!(next == null || next.get() == null)) {
                    finish((Activity) next.get());
                }
            } else if (isEqualsActivity((WeakReference<Activity>) next, cls)) {
                z = true;
            }
        }
    }

    public void finishAll() {
        int i = 0;
        while (i < mActStack.size()) {
            if (mActStack.size() > 0 && mActStack.get(i) != null) {
                mActStack.peek();
                finish((Activity) mActStack.get(i).get());
                i--;
            }
            i++;
        }
    }

    public void finishBefore(Class cls) {
        boolean z = false;
        for (int size = mActStack.size() - 1; size >= 0; size--) {
            WeakReference weakReference = mActStack.get(size);
            if (z) {
                if (!(weakReference == null || weakReference.get() == null)) {
                    finish((Activity) weakReference.get());
                }
            } else if (isEqualsActivity((WeakReference<Activity>) weakReference, cls)) {
                z = true;
            }
        }
    }

    public int getCount() {
        return mActStack.size();
    }

    public <T extends Activity> T getCurrent() {
        if (mActStack.lastElement() != null) {
            return (Activity) mActStack.lastElement().get();
        }
        return null;
    }

    public boolean isContains(Class<?> cls) {
        Iterator<WeakReference<Activity>> it = mActStack.iterator();
        while (it.hasNext()) {
            if (isEqualsActivity(it.next(), (Class) cls)) {
                return true;
            }
        }
        return false;
    }

    public void remove(Activity activity) {
        Iterator<WeakReference<Activity>> it = mActStack.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (isEqualsActivity((WeakReference<Activity>) next, activity)) {
                mActStack.remove(next);
                return;
            }
        }
    }

    private ActivityManager() {
    }

    private boolean isEqualsActivity(WeakReference<Activity> weakReference, Activity activity) {
        return (weakReference == null || weakReference.get() == null || weakReference.get() != activity) ? false : true;
    }

    public void finish(Class cls) {
        Iterator<WeakReference<Activity>> it = mActStack.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (isEqualsActivity((WeakReference<Activity>) next, cls)) {
                finish((Activity) next.get());
            }
        }
    }
}
