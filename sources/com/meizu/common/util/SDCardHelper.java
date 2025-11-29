package com.meizu.common.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Observable;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SDCardHelper extends BroadcastReceiver {
    private static SDCardHelper sInstance;
    private Context mContext;
    private boolean mIsMounted = true;
    private List<MountPoint> mMountPathList = Collections.synchronizedList(new ArrayList());
    private final SDCardStateObservable mStateObservable = new SDCardStateObservable();
    private Method sDescription;
    private Method sIsRemovable;
    private Method sPath;
    private Object[] sStorageVolumes;
    private Method sVolumeState;

    public class MountPoint {
        private String mDescription;
        /* access modifiers changed from: private */
        public boolean mIsExternal;
        private String mMountedState;
        /* access modifiers changed from: private */
        public String mPath;

        public MountPoint() {
        }

        /* access modifiers changed from: private */
        public void setDescription(String str) {
            this.mDescription = str;
        }

        /* access modifiers changed from: private */
        public void setExternal(boolean z) {
            this.mIsExternal = z;
        }

        /* access modifiers changed from: private */
        public void setMountedState(String str) {
            this.mMountedState = str;
        }

        /* access modifiers changed from: private */
        public void setPath(String str) {
            this.mPath = str;
        }

        @SuppressLint({"NewApi"})
        public long availableSpace() {
            if (!isMounted()) {
                return 0;
            }
            StatFs statFs = new StatFs(this.mPath);
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getMountedState() {
            return this.mMountedState;
        }

        public String getPath() {
            return this.mPath;
        }

        @SuppressLint({"NewApi"})
        public long getTotalBlocks() {
            if (!isMounted()) {
                return 0;
            }
            StatFs statFs = new StatFs(this.mPath);
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        }

        public boolean isExternal() {
            return this.mIsExternal;
        }

        public boolean isMounted() {
            return this.mMountedState.equals("mounted");
        }
    }

    public static class SDCardStateObservable extends Observable<SDCardStateObserver> {
        private SDCardStateObservable() {
        }

        public void notifyStateChanged(Intent intent, boolean z) {
            synchronized (this.mObservers) {
                try {
                    for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                        ((SDCardStateObserver) this.mObservers.get(size)).onChanged(intent, z);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public interface SDCardStateObserver {
        void onChanged(Intent intent, boolean z);
    }

    private SDCardHelper(Context context) {
        this.mContext = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.mContext.registerReceiver(this, intentFilter);
        getMountPointList(context);
        this.mIsMounted = isSDCardMounted();
    }

    public static void createInstance(Context context) {
        if (sInstance == null) {
            synchronized (SDCardHelper.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new SDCardHelper(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static SDCardHelper getInstance() {
        return sInstance;
    }

    @TargetApi(19)
    public List<MountPoint> getMountPointList(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        this.mMountPathList.clear();
        try {
            if (this.sStorageVolumes == null) {
                this.sStorageVolumes = (Object[]) storageManager.getClass().getMethod("getVolumeList", (Class[]) null).invoke(storageManager, (Object[]) null);
            }
            Object[] objArr = this.sStorageVolumes;
            if (objArr != null) {
                for (Object obj : objArr) {
                    MountPoint mountPoint = new MountPoint();
                    if (this.sDescription == null || this.sPath == null || this.sIsRemovable == null || this.sVolumeState == null) {
                        this.sDescription = obj.getClass().getDeclaredMethod("getDescription", new Class[]{Context.class});
                        this.sPath = obj.getClass().getDeclaredMethod("getPath", (Class[]) null);
                        this.sIsRemovable = obj.getClass().getDeclaredMethod("isRemovable", (Class[]) null);
                        this.sVolumeState = storageManager.getClass().getMethod("getVolumeState", new Class[]{String.class});
                    }
                    String str = (String) this.sPath.invoke(obj, (Object[]) null);
                    mountPoint.setDescription((String) this.sDescription.invoke(obj, new Object[]{context}));
                    mountPoint.setPath(str);
                    mountPoint.setMountedState((String) this.sVolumeState.invoke(storageManager, new Object[]{str}));
                    mountPoint.setExternal(((Boolean) this.sIsRemovable.invoke(obj, (Object[]) null)).booleanValue());
                    this.mMountPathList.add(mountPoint);
                }
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return this.mMountPathList;
    }

    public MountPoint getOtgMountPoint() {
        for (MountPoint next : this.mMountPathList) {
            if (next.mIsExternal && next.mPath.contains("mnt")) {
                return next;
            }
        }
        return null;
    }

    public MountPoint getSDCardMountPoint() {
        for (MountPoint next : this.mMountPathList) {
            if (next.mIsExternal && next.mPath.contains("storage")) {
                return next;
            }
        }
        return null;
    }

    public MountPoint getStorageMountPoint() {
        for (MountPoint next : this.mMountPathList) {
            if (!next.mIsExternal) {
                return next;
            }
        }
        return null;
    }

    public boolean isMounted() {
        return this.mIsMounted;
    }

    public boolean isOtgMounted() {
        if (getOtgMountPoint() == null) {
            return false;
        }
        return getOtgMountPoint().isMounted();
    }

    public boolean isSDCardMounted() {
        if (getSDCardMountPoint() == null) {
            return false;
        }
        return getSDCardMountPoint().isMounted();
    }

    public void notifyStateChanged(Intent intent, boolean z) {
        this.mStateObservable.notifyStateChanged(intent, z);
    }

    public void onDestory() {
        this.mContext.unregisterReceiver(this);
        sInstance = null;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        getMountPointList(context);
        if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
            this.mIsMounted = true;
            notifyStateChanged(intent, true);
        } else if ("android.intent.action.MEDIA_EJECT".equals(action)) {
            this.mIsMounted = false;
            notifyStateChanged(intent, false);
        } else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
            this.mIsMounted = false;
            notifyStateChanged(intent, false);
        }
    }

    public void registerStateObserver(SDCardStateObserver sDCardStateObserver) {
        this.mStateObservable.registerObserver(sDCardStateObserver);
    }

    public void unregisterStateObserver(SDCardStateObserver sDCardStateObserver) {
        this.mStateObservable.unregisterObserver(sDCardStateObserver);
    }
}
