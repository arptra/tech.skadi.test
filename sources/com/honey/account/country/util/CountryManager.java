package com.honey.account.country.util;

import android.content.Context;
import android.util.Log;
import com.honey.account.country.data.CountryData;
import com.honey.account.database.DBManager;
import com.honey.account.utils.sharedpreferences.SharedPreferencesUtilsKt;
import com.honey.account.utils.system.FileUtilsKt;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000eJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRD\u0010\f\u001a,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0018\u00010\rj\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\rj\b\u0012\u0004\u0012\u00020\u0001`\u000e\u0018\u0001`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/honey/account/country/util/CountryManager;", "", "()V", "TAG", "", "mCountryData", "", "Lcom/honey/account/country/data/CountryData;", "getMCountryData", "()Ljava/util/List;", "setMCountryData", "(Ljava/util/List;)V", "mCountryFastData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMCountryFastData", "()Ljava/util/ArrayList;", "setMCountryFastData", "(Ljava/util/ArrayList;)V", "getCountry", "context", "Landroid/content/Context;", "getCountryData", "getCountrySortKeys", "init", "", "setCountry", "countryData", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CountryManager {
    @NotNull
    public static final CountryManager INSTANCE = new CountryManager();
    @NotNull
    private static final String TAG = "CountryManager";
    @Nullable
    private static List<CountryData> mCountryData;
    @Nullable
    private static ArrayList<ArrayList<Object>> mCountryFastData;

    private CountryManager() {
    }

    private final List<CountryData> getCountryData(Context context) {
        try {
            InputStream open = context.getAssets().open("areacode/areacode.json");
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            JSONObject jSONObject = new JSONObject(FileUtilsKt.readStreamToString(open));
            ArrayList arrayList = new ArrayList();
            JSONArray names = jSONObject.names();
            if (names == null) {
                return arrayList;
            }
            mCountryFastData = new ArrayList<>();
            int length = names.length();
            for (int i = 0; i < length; i++) {
                String obj = names.get(i).toString();
                JSONArray optJSONArray = jSONObject.optJSONArray(obj);
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = optJSONArray.length();
                    int i2 = 0;
                    while (i2 < length2) {
                        CountryData parse = CountryData.Companion.parse(0, obj, i2 == 0, optJSONArray.optJSONObject(i2));
                        if (parse != null) {
                            arrayList.add(parse);
                            arrayList2.add(parse);
                        }
                        if (i2 == optJSONArray.length() - 1) {
                            ArrayList<ArrayList<Object>> arrayList3 = mCountryFastData;
                            if (arrayList3 != null) {
                                arrayList3.add(new ArrayList(arrayList2));
                            }
                            arrayList2.clear();
                        }
                        i2++;
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            Log.e(TAG, "getCountryData fail. ", th);
            return null;
        }
    }

    @NotNull
    public final String getCountry(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String config = SharedPreferencesUtilsKt.getConfig(context, "country_code", "");
        Intrinsics.checkNotNull(config);
        return config;
    }

    @NotNull
    public final synchronized ArrayList<String> getCountrySortKeys() {
        return DBManager.INSTANCE.getCountrySortKeys();
    }

    @Nullable
    public final List<CountryData> getMCountryData() {
        return mCountryData;
    }

    @Nullable
    public final ArrayList<ArrayList<Object>> getMCountryFastData() {
        return mCountryFastData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void init(@org.jetbrains.annotations.NotNull android.content.Context r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch:{ all -> 0x002f }
            java.util.List r0 = r2.getCountryData(r3)     // Catch:{ all -> 0x002f }
            mCountryData = r0     // Catch:{ all -> 0x002f }
            com.honey.account.database.DBManager r0 = com.honey.account.database.DBManager.INSTANCE     // Catch:{ all -> 0x002f }
            boolean r1 = r0.isInitializedCountry()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0016
            monitor-exit(r2)
            return
        L_0x0016:
            com.honey.account.country.data.CountryData r1 = com.honey.account.country.data.CountryData.US_COUNTRY     // Catch:{ all -> 0x002f }
            r2.setCountry(r3, r1)     // Catch:{ all -> 0x002f }
            java.util.List<com.honey.account.country.data.CountryData> r3 = mCountryData     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x0031
            boolean r3 = r0.replaceCountryData(r3)     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x0031
            com.honey.account.sysconfig.data.SysConfigData r3 = new com.honey.account.sysconfig.data.SysConfigData     // Catch:{ all -> 0x002f }
            r1 = 1
            r3.<init>(r1)     // Catch:{ all -> 0x002f }
            r0.updateSysConfig(r3)     // Catch:{ all -> 0x002f }
            goto L_0x0031
        L_0x002f:
            r3 = move-exception
            goto L_0x0033
        L_0x0031:
            monitor-exit(r2)
            return
        L_0x0033:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.country.util.CountryManager.init(android.content.Context):void");
    }

    public final void setCountry(@NotNull Context context, @NotNull CountryData countryData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(countryData, "countryData");
        String jSONObject = CountryData.Companion.toJson(countryData).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        SharedPreferencesUtilsKt.applyConfig(context, "country_code", jSONObject);
    }

    public final void setMCountryData(@Nullable List<CountryData> list) {
        mCountryData = list;
    }

    public final void setMCountryFastData(@Nullable ArrayList<ArrayList<Object>> arrayList) {
        mCountryFastData = arrayList;
    }
}
