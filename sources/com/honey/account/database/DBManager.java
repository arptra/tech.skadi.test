package com.honey.account.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.honey.account.country.data.CountryData;
import com.honey.account.country.db.CountryTable;
import com.honey.account.sysconfig.data.SysConfigData;
import com.honey.account.sysconfig.db.SysConfigTable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\rH\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/honey/account/database/DBManager;", "", "()V", "TAG", "", "dbHelper", "Lcom/honey/account/database/DBHelper;", "getDbHelper", "()Lcom/honey/account/database/DBHelper;", "dbHelper$delegate", "Lkotlin/Lazy;", "getCountrySortKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSysConfig", "Lcom/honey/account/sysconfig/data/SysConfigData;", "isInitializedCountry", "", "replaceCountryData", "countryDataList", "", "Lcom/honey/account/country/data/CountryData;", "updateSysConfig", "sysConfig", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DBManager {
    @NotNull
    public static final DBManager INSTANCE = new DBManager();
    @NotNull
    private static final String TAG = "DBManager";
    @NotNull
    private static final Lazy dbHelper$delegate = LazyKt.lazy(DBManager$dbHelper$2.INSTANCE);

    private DBManager() {
    }

    private final DBHelper getDbHelper() {
        return (DBHelper) dbHelper$delegate.getValue();
    }

    @SuppressLint({"Recycle"})
    private final SysConfigData getSysConfig() {
        Cursor rawQuery = getDbHelper().getWritableDatabase().rawQuery("select country_init from sys_config", (String[]) null);
        SysConfigData.Companion companion = SysConfigData.Companion;
        Intrinsics.checkNotNull(rawQuery);
        return companion.parse(rawQuery);
    }

    @NotNull
    @SuppressLint({"Recycle"})
    public final ArrayList<String> getCountrySortKeys() {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor rawQuery = getDbHelper().getWritableDatabase().rawQuery("select sort_key from country group by sort_key  ORDER by case WHEN sort_key REGEXP '[^a-zA-Z0-9]' THEN 0 else 1 end", (String[]) null);
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(0));
        }
        return arrayList;
    }

    public final boolean isInitializedCountry() {
        SysConfigData sysConfig = getSysConfig();
        if (sysConfig != null) {
            return sysConfig.getCountryInit();
        }
        return false;
    }

    @SuppressLint({"Recycle"})
    public final boolean replaceCountryData(@NotNull List<CountryData> list) {
        Intrinsics.checkNotNullParameter(list, "countryDataList");
        SQLiteDatabase writableDatabase = getDbHelper().getWritableDatabase();
        if (writableDatabase == null) {
            return false;
        }
        writableDatabase.beginTransaction();
        try {
            writableDatabase.rawQuery("delete from country", (String[]) null);
            for (CountryData next : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(CountryTable.BRIEF, next.getBrief());
                contentValues.put("country", next.getCountry());
                contentValues.put("code", next.getCode());
                contentValues.put(CountryTable.SIMPLE_CODE, next.getSimpleCode());
                contentValues.put(CountryTable.IS_FIRST, Boolean.valueOf(next.isFirst()));
                contentValues.put(CountryTable.SORT_KEY, next.getSortKey());
                Unit unit = Unit.INSTANCE;
                long insertWithOnConflict = writableDatabase.insertWithOnConflict("country", CountryTable.PRIMARY_KEY, contentValues, 5);
                Log.i(TAG, "replaceCountryData, insert row id: " + insertWithOnConflict);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return true;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public final boolean updateSysConfig(@NotNull SysConfigData sysConfigData) {
        Intrinsics.checkNotNullParameter(sysConfigData, "sysConfig");
        SQLiteDatabase writableDatabase = getDbHelper().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SysConfigTable.COUNTRY_INIT, Boolean.valueOf(sysConfigData.getCountryInit()));
        Unit unit = Unit.INSTANCE;
        return writableDatabase.update(SysConfigTable.TABLE_NAME, contentValues, (String) null, (String[]) null) > 0;
    }
}
