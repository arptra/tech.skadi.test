package com.upuphone.starrynet.core.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.tencent.mmkv.MMKV;
import com.upuphone.starrynet.api.StBroadcast;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.database.dao.BondInfo;
import java.util.Arrays;

public class StarryContentProvider extends ContentProvider {
    private static final String AUTHORITY = "com.upuphone.starrynet.provider";
    private static final String KEY_BOND_STATE = "bond_state";
    private static final String KEY_CATEGORY_ID = "category_id";
    private static final String KEY_COMPANY_ID = "company_id";
    private static final String KEY_DEVICE_NAME = "device_name";
    private static final String KEY_MAC = "mac";
    private static final String KEY_MODEL_ID = "model_id";
    private static final String KEY_TERMINAL_TYPE = "terminal_type";
    private static final int MATCH_DEVICE_REMOVE = 101;
    private static final int MATCH_DEVICE_TO_BR_EDR = 100;
    private static final String TAG = "StarryContentProvider";
    private static final UriMatcher mUriMatcher;
    private StarryDatabase mDatabase;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mUriMatcher = uriMatcher;
        uriMatcher.addURI(AUTHORITY, "device", 100);
        uriMatcher.addURI(AUTHORITY, "remove", 101);
    }

    private Cursor getCursor(String str, int i) {
        Log.d(TAG, "getCursor mac = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        final BondInfo bondInfoByBrEdrMac = this.mDatabase.getBondInfoByBrEdrMac(str);
        if (bondInfoByBrEdrMac == null) {
            Log.d(TAG, "getCursor bond info is null");
            return null;
        } else if (bondInfoByBrEdrMac.getTerminalType() != i) {
            Log.d(TAG, "TerminalType is not right = " + i);
            return null;
        } else if ((bondInfoByBrEdrMac.getStatus() & 15) == 4) {
            return new AbstractCursor() {
                public String[] getColumnNames() {
                    return new String[]{StarryContentProvider.KEY_MAC, StarryContentProvider.KEY_TERMINAL_TYPE, StarryContentProvider.KEY_DEVICE_NAME, StarryContentProvider.KEY_COMPANY_ID, StarryContentProvider.KEY_CATEGORY_ID, StarryContentProvider.KEY_MODEL_ID, StarryContentProvider.KEY_BOND_STATE};
                }

                public int getCount() {
                    return 1;
                }

                public double getDouble(int i) {
                    return 0.0d;
                }

                public float getFloat(int i) {
                    return 0.0f;
                }

                public int getInt(int i) {
                    if (i == 1) {
                        return bondInfoByBrEdrMac.getTerminalType();
                    }
                    if (i == 6) {
                        return bondInfoByBrEdrMac.getStatus();
                    }
                    return 0;
                }

                public long getLong(int i) {
                    return 0;
                }

                public short getShort(int i) {
                    return 0;
                }

                public String getString(int i) {
                    if (i == 0) {
                        return bondInfoByBrEdrMac.getBrEdrMac();
                    }
                    if (i == 2) {
                        return bondInfoByBrEdrMac.getDeviceName();
                    }
                    if (i == 3) {
                        return bondInfoByBrEdrMac.getCompanyID();
                    }
                    if (i == 4) {
                        return bondInfoByBrEdrMac.getCategoryID();
                    }
                    if (i == 5) {
                        return bondInfoByBrEdrMac.getModelID();
                    }
                    return null;
                }

                public boolean isNull(int i) {
                    return false;
                }
            };
        } else {
            Log.d(TAG, "getCursor bond info is not bonded");
            return null;
        }
    }

    private int removeBond(String str) {
        Log.d(TAG, "removeBond mac = " + str);
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        BondInfo bondInfoByBrEdrMac = this.mDatabase.getBondInfoByBrEdrMac(str);
        if (bondInfoByBrEdrMac == null) {
            Log.d(TAG, "removeBond bond info is null");
            return -2;
        }
        Intent intent = new Intent();
        intent.setPackage(getContext().getPackageName());
        intent.setAction(StBroadcast.LOCAL_ACTION_REMOVE_DEVICE);
        intent.putExtra(StBroadcast.EXTRA_DEVICE_ID, bondInfoByBrEdrMac.getIdentifier());
        LocalBroadcastManager.b(getContext()).d(intent);
        StLog.d(TAG, "removeBond broadcast");
        return 1;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        if (mUriMatcher.match(uri) == 101 && strArr != null && strArr.length == 1) {
            return removeBond(strArr[0]);
        }
        return 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        MMKV.y(getContext());
        this.mDatabase = StarryDatabase.getInstance(getContext());
        Log.d(TAG, "onCreate");
        return true;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int binarySearch;
        int i;
        Log.d(TAG, "query " + uri);
        if (mUriMatcher.match(uri) != 100 || strArr == null || strArr2 == null || strArr.length != strArr2.length || (binarySearch = Arrays.binarySearch(strArr, KEY_MAC)) < 0) {
            return null;
        }
        String str3 = strArr2[binarySearch];
        int binarySearch2 = Arrays.binarySearch(strArr, KEY_TERMINAL_TYPE);
        if (binarySearch2 >= 0) {
            try {
                i = Integer.parseInt(strArr2[binarySearch2]);
            } catch (NumberFormatException e) {
                Log.w(TAG, "parseInt error", e);
            }
            return getCursor(str3, i);
        }
        i = 2;
        return getCursor(str3, i);
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
