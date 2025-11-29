package com.here.odnp.posclient.upload;

import android.content.Context;
import androidx.annotation.NonNull;
import com.here.odnp.config.OdnpConfigStatic;
import com.here.odnp.posclient.PosClientManager;
import com.here.odnp.util.Log;
import com.here.posclient.upload.UploadListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class UploadProxy implements UploadListener {
    private static final String TAG = "odnp.posclient.upload.UploadProxy";
    private final WeakReference<Context> mContextRef;
    private final WeakReference<PosClientManager> mPosClientManager;
    private ArrayList<UploadListener> mUploadListenerList = new ArrayList<>();
    private IUploadScheduler mUploadScheduler;

    /* renamed from: com.here.odnp.posclient.upload.UploadProxy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$odnp$config$OdnpConfigStatic$UploadSchedulingStrategy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.here.odnp.config.OdnpConfigStatic$UploadSchedulingStrategy[] r0 = com.here.odnp.config.OdnpConfigStatic.UploadSchedulingStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$odnp$config$OdnpConfigStatic$UploadSchedulingStrategy = r0
                com.here.odnp.config.OdnpConfigStatic$UploadSchedulingStrategy r1 = com.here.odnp.config.OdnpConfigStatic.UploadSchedulingStrategy.Timer     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$odnp$config$OdnpConfigStatic$UploadSchedulingStrategy     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.odnp.config.OdnpConfigStatic$UploadSchedulingStrategy r1 = com.here.odnp.config.OdnpConfigStatic.UploadSchedulingStrategy.JobService     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$odnp$config$OdnpConfigStatic$UploadSchedulingStrategy     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.odnp.config.OdnpConfigStatic$UploadSchedulingStrategy r1 = com.here.odnp.config.OdnpConfigStatic.UploadSchedulingStrategy.None     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.posclient.upload.UploadProxy.AnonymousClass1.<clinit>():void");
        }
    }

    public UploadProxy(@NonNull Context context, PosClientManager posClientManager) {
        this.mContextRef = new WeakReference<>(context);
        this.mPosClientManager = new WeakReference<>(posClientManager);
    }

    public void close() {
        Log.d(TAG, "close called", new Object[0]);
        IUploadScheduler iUploadScheduler = this.mUploadScheduler;
        if (iUploadScheduler != null) {
            iUploadScheduler.close();
            this.mUploadScheduler = null;
        }
    }

    public void onUploadDataAvailable(int i) {
        if (this.mUploadScheduler == null) {
            Log.e(TAG, "onUploadDataAvailable: upload disabled", new Object[0]);
            return;
        }
        Context context = this.mContextRef.get();
        if (context != null) {
            Log.d(TAG, "onUploadAvailable, delay %d secs", Integer.valueOf(i));
            this.mUploadScheduler.schedule(context, i);
        }
    }

    public void onUploadFailed() {
        Iterator<UploadListener> it = this.mUploadListenerList.iterator();
        while (it.hasNext()) {
            it.next().onUploadFailed();
        }
    }

    public void onUploaded() {
        Context context;
        if (!(this.mUploadScheduler == null || (context = this.mContextRef.get()) == null)) {
            this.mUploadScheduler.dataUploaded(context);
        }
        Iterator<UploadListener> it = this.mUploadListenerList.iterator();
        while (it.hasNext()) {
            it.next().onUploaded();
        }
    }

    public void open() {
        Log.d(TAG, "open called", new Object[0]);
        if (this.mUploadScheduler != null) {
            Log.e(TAG, "open: Upload scheduler already exists.", new Object[0]);
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$here$odnp$config$OdnpConfigStatic$UploadSchedulingStrategy[OdnpConfigStatic.UPLOAD_SCHEDULING.ordinal()];
        if (i == 1) {
            this.mUploadScheduler = TimerUploadStrategy.getUploadScheduler(this.mPosClientManager.get());
        } else if (i != 2) {
            Log.v(TAG, "open: upload disabled", new Object[0]);
            this.mContextRef.clear();
        } else {
            this.mUploadScheduler = JobUploadStrategy.getUploadScheduler();
        }
    }

    public void subscribe(@NonNull UploadListener uploadListener) {
        this.mUploadListenerList.add(uploadListener);
        Log.d(TAG, "subscribe, listeners: %d", Integer.valueOf(this.mUploadListenerList.size()));
    }

    public void unsubscribe(@NonNull UploadListener uploadListener) {
        this.mUploadListenerList.remove(uploadListener);
        Log.d(TAG, "unsubscribe, listeners: %d", Integer.valueOf(this.mUploadListenerList.size()));
    }
}
