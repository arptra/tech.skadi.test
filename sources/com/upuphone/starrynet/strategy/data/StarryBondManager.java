package com.upuphone.starrynet.strategy.data;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.database.StarryDatabase;
import com.upuphone.starrynet.core.database.dao.BondInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import java.util.ArrayList;
import java.util.List;

final class StarryBondManager {
    private static final int MSG_INIT_DATA = 1;
    private static final int MSG_SAVE_ENCRYPTION_DATA_TO_DATABASE = 2;
    private static final int MSG_UPDATE_ENCRYPTION_DATA_TO_DATABASE = 3;
    private static final String TAG = "StarryBondManager";
    private final List<BondInfo> mBondedRecords = new ArrayList();
    private final StarryBondManagerHandler mHandler;
    /* access modifiers changed from: private */
    public IStarryDeviceCallback mLoadCallback;
    private final StarryDatabase mStarryDatabase = StarryDatabase.getInstance(StarryNetData.getInstance().getApplicationContext());

    public class StarryBondManagerHandler extends Handler {
        public StarryBondManagerHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 1) {
                StarryBondManager.this.loadFromDatabase();
                if (StarryBondManager.this.mLoadCallback != null) {
                    StarryBondManager.this.mLoadCallback.onLoadFinish();
                }
            } else if (i == 2 || i == 3) {
                StarryBondManager.this.updateEncryptionData2Database((BondInfo) message.obj);
            }
        }
    }

    public StarryBondManager() {
        HandlerThread handlerThread = new HandlerThread("StarryBondManager Handler");
        handlerThread.start();
        this.mHandler = new StarryBondManagerHandler(handlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    public void loadFromDatabase() {
        StLog.d(TAG, "loadFromDatabase");
        for (BondInfo next : this.mStarryDatabase.loadAll()) {
            StLog.d(TAG, "info:" + next.toString());
            if (next.getStatus() > 0) {
                this.mBondedRecords.add(next);
            } else {
                this.mStarryDatabase.delete(next.getIdentifier());
            }
        }
        StLog.d(TAG, "loadFromDatabase size:" + this.mBondedRecords.size());
    }

    /* access modifiers changed from: private */
    public void updateEncryptionData2Database(BondInfo bondInfo) {
        if (bondInfo == null) {
            StLog.w(TAG, "updateEncryptionData2Database info is null");
            return;
        }
        this.mStarryDatabase.insert(bondInfo);
        StLog.w(TAG, "updateEncryptionData2Database info " + bondInfo);
    }

    public void addBondInfo2Database(BondInfo bondInfo) {
        if (bondInfo == null) {
            StLog.d(TAG, "addBondInfo2Database bondInfo null");
            return;
        }
        StLog.d(TAG, "addBondInfo2Database : " + bondInfo);
        Message.obtain(this.mHandler, 2, bondInfo).sendToTarget();
    }

    public List<BondInfo> getBondedInfo() {
        return this.mBondedRecords;
    }

    public void init(IStarryDeviceCallback iStarryDeviceCallback) {
        this.mLoadCallback = iStarryDeviceCallback;
        this.mHandler.sendEmptyMessage(1);
    }

    public void removeBondInfo2Database(BondInfo bondInfo) {
        if (bondInfo == null) {
            StLog.d(TAG, "removeBondInfo2Database bondInfo null");
            return;
        }
        StLog.d(TAG, "removeBondInfo2Database : " + bondInfo);
        this.mStarryDatabase.delete(bondInfo.getIdentifier());
    }

    @NonNull
    public String toString() {
        return "BondRecord{mBondedRecords=" + this.mBondedRecords + '}';
    }

    public void updateBondInfo2Database(BondInfo bondInfo) {
        if (bondInfo == null) {
            StLog.d(TAG, "updateBondInfo2Database bondInfo null");
        } else if (bondInfo.getDeviceType() == 3) {
            StLog.d(TAG, "updateBondInfo2Database iccoa device do not save in database");
        } else {
            StLog.d(TAG, "updateBondInfo2Database : " + bondInfo);
            Message.obtain(this.mHandler, 3, bondInfo).sendToTarget();
        }
    }
}
