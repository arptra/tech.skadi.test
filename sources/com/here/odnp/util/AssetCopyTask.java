package com.here.odnp.util;

import android.content.Context;
import android.os.AsyncTask;
import android.os.ConditionVariable;
import com.here.odnp.util.OdnpAssetManager;
import java.lang.ref.WeakReference;

public class AssetCopyTask extends AsyncTask<OdnpAssetManager.Asset[], Void, Boolean> {
    private static final String TAG = "CopyTask";
    private final WeakReference<Context> mContext;
    private final OdnpAssetManager.AsyncCopyListener mListener;
    private final ConditionVariable mLock = new ConditionVariable();

    public AssetCopyTask(Context context, OdnpAssetManager.AsyncCopyListener asyncCopyListener) {
        this.mContext = new WeakReference<>(context);
        this.mListener = asyncCopyListener;
    }

    public void cancel() {
        super.cancel(false);
    }

    public AssetCopyTask start(OdnpAssetManager.Asset[] assetArr) {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new OdnpAssetManager.Asset[][]{assetArr});
        return this;
    }

    public void waitForCompletion() {
        this.mLock.block();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9 = java.lang.Boolean.valueOf(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005f, code lost:
        com.here.odnp.util.Log.v(TAG, "doInBackground: end", new java.lang.Object[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean doInBackground(com.here.odnp.util.OdnpAssetManager.Asset[]... r9) {
        /*
            r8 = this;
            java.lang.String r0 = "doInBackground: end"
            java.lang.String r1 = "CopyTask"
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.String r3 = "CopyTask:AMGR"
            r2.setName(r3)
            r2 = 0
            java.lang.String r3 = "doInBackground: start"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0033 }
            com.here.odnp.util.Log.v(r1, r3, r4)     // Catch:{ all -> 0x0033 }
            java.lang.ref.WeakReference<android.content.Context> r3 = r8.mContext     // Catch:{ all -> 0x0033 }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x0033 }
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ all -> 0x0033 }
            if (r3 != 0) goto L_0x0035
            java.lang.String r9 = "doInBackground: Context no longer available"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0033 }
            com.here.odnp.util.Log.v(r1, r9, r3)     // Catch:{ all -> 0x0033 }
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0033 }
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.here.odnp.util.Log.v(r1, r0, r2)
        L_0x002d:
            android.os.ConditionVariable r8 = r8.mLock
            r8.open()
            return r9
        L_0x0033:
            r9 = move-exception
            goto L_0x0065
        L_0x0035:
            r9 = r9[r2]     // Catch:{ all -> 0x0033 }
            int r4 = r9.length     // Catch:{ all -> 0x0033 }
            r5 = 1
            r6 = r2
        L_0x003a:
            if (r6 >= r4) goto L_0x005b
            r7 = r9[r6]     // Catch:{ all -> 0x0033 }
            boolean r7 = com.here.odnp.util.OdnpAssetManager.copyAsset(r3, r7)     // Catch:{ all -> 0x0033 }
            r5 = r5 & r7
            boolean r7 = r8.isCancelled()     // Catch:{ all -> 0x0033 }
            if (r7 == 0) goto L_0x0058
            java.lang.String r9 = "doInBackground: Cancelled"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0033 }
            com.here.odnp.util.Log.v(r1, r9, r3)     // Catch:{ all -> 0x0033 }
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0033 }
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.here.odnp.util.Log.v(r1, r0, r2)
            goto L_0x002d
        L_0x0058:
            int r6 = r6 + 1
            goto L_0x003a
        L_0x005b:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0033 }
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.here.odnp.util.Log.v(r1, r0, r2)
            goto L_0x002d
        L_0x0065:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.here.odnp.util.Log.v(r1, r0, r2)
            android.os.ConditionVariable r8 = r8.mLock
            r8.open()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.util.AssetCopyTask.doInBackground(com.here.odnp.util.OdnpAssetManager$Asset[][]):java.lang.Boolean");
    }

    public void onCancelled(Boolean bool) {
        this.mListener.asyncCopyFinished(false);
    }

    public void onPostExecute(Boolean bool) {
        this.mListener.asyncCopyFinished(bool.booleanValue());
    }

    public boolean waitForCompletion(long j) {
        return this.mLock.block(j);
    }
}
