package com.upuphone.starrynet.core.database;

import android.content.Context;
import com.tencent.mmkv.MMKV;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.database.dao.BondInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StarryDatabase {
    private static final String TAG = "StarryDatabase";
    private static StarryDatabase database;
    private final MMKV mmkv;

    private StarryDatabase(Context context) {
        this.mmkv = MMKV.D(TAG, 1, TAG, context.getFilesDir().getAbsolutePath() + "/database");
    }

    public static synchronized StarryDatabase getInstance(Context context) {
        StarryDatabase starryDatabase;
        synchronized (StarryDatabase.class) {
            try {
                if (database == null) {
                    database = new StarryDatabase(context);
                }
                starryDatabase = database;
            } catch (Throwable th) {
                throw th;
            }
        }
        return starryDatabase;
    }

    public void delete(byte[] bArr) {
        this.mmkv.remove(Utils.bytesToHexString(bArr));
    }

    public BondInfo getBondInfoByBrEdrMac(String str) {
        String[] allKeys = this.mmkv.allKeys();
        if (!(allKeys == null || allKeys.length == 0)) {
            for (String h : allKeys) {
                BondInfo bondInfo = (BondInfo) this.mmkv.h(h, BondInfo.class);
                if (bondInfo != null && str.equals(bondInfo.getBrEdrMac())) {
                    return bondInfo;
                }
            }
        }
        return null;
    }

    public void insert(BondInfo bondInfo) {
        insert(Utils.bytesToHexString(bondInfo.getIdentifier()), bondInfo);
    }

    public List<BondInfo> loadAll() {
        String[] allKeys = this.mmkv.allKeys();
        if (allKeys == null || allKeys.length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : allKeys) {
            BondInfo bondInfo = (BondInfo) this.mmkv.h(str, BondInfo.class);
            if (bondInfo != null) {
                if (!str.equals(Utils.bytesToHexString(bondInfo.getIdentifier()))) {
                    this.mmkv.remove(str);
                } else {
                    arrayList.add(bondInfo);
                }
            }
        }
        return arrayList;
    }

    public void update(BondInfo bondInfo) {
        insert(bondInfo);
    }

    public void update(String str, BondInfo bondInfo) {
        insert(str, bondInfo);
    }

    public void delete(String str) {
        this.mmkv.remove(str);
    }

    public void insert(String str, BondInfo bondInfo) {
        this.mmkv.t(str, bondInfo);
    }
}
