package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.honey.account.constant.AccountConstantKt;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MMSharedPreferences implements SharedPreferences {
    private static final String TAG = "MicroMsg.SDK.SharedPreferences";
    private final String[] columns = {"_id", IntentKey.ACTIVITY.ACTION_KEY, "type", AccountConstantKt.RESPONSE_VALUE};
    private final ContentResolver cr;
    private REditor editor = null;
    private final HashMap<String, Object> values = new HashMap<>();

    public static class REditor implements SharedPreferences.Editor {
        private boolean clear = false;
        private ContentResolver cr;
        private Set<String> remove = new HashSet();
        private Map<String, Object> values = new HashMap();

        public REditor(ContentResolver contentResolver) {
            this.cr = contentResolver;
        }

        public void apply() {
        }

        public SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x003e A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean commit() {
            /*
                r9 = this;
                android.content.ContentValues r0 = new android.content.ContentValues
                r0.<init>()
                boolean r1 = r9.clear
                r2 = 0
                if (r1 == 0) goto L_0x0014
                android.content.ContentResolver r1 = r9.cr
                android.net.Uri r3 = com.tencent.mm.opensdk.utils.a.f9613a
                r4 = 0
                r1.delete(r3, r4, r4)
                r9.clear = r2
            L_0x0014:
                java.util.Set<java.lang.String> r1 = r9.remove
                java.util.Iterator r1 = r1.iterator()
            L_0x001a:
                boolean r3 = r1.hasNext()
                java.lang.String r4 = "key = ?"
                if (r3 == 0) goto L_0x0034
                java.lang.Object r3 = r1.next()
                java.lang.String r3 = (java.lang.String) r3
                android.content.ContentResolver r5 = r9.cr
                android.net.Uri r6 = com.tencent.mm.opensdk.utils.a.f9613a
                java.lang.String[] r3 = new java.lang.String[]{r3}
                r5.delete(r6, r4, r3)
                goto L_0x001a
            L_0x0034:
                java.util.Map<java.lang.String, java.lang.Object> r1 = r9.values
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x003e:
                boolean r3 = r1.hasNext()
                r5 = 1
                if (r3 == 0) goto L_0x00be
                java.lang.Object r3 = r1.next()
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                java.lang.Object r6 = r3.getValue()
                java.lang.String r7 = "MicroMsg.SDK.PluginProvider.Resolver"
                if (r6 != 0) goto L_0x005a
                java.lang.String r5 = "unresolve failed, null value"
            L_0x0055:
                com.tencent.mm.opensdk.utils.Log.e(r7, r5)
                r5 = r2
                goto L_0x0097
            L_0x005a:
                boolean r8 = r6 instanceof java.lang.Integer
                if (r8 == 0) goto L_0x005f
                goto L_0x0097
            L_0x005f:
                boolean r5 = r6 instanceof java.lang.Long
                if (r5 == 0) goto L_0x0065
                r5 = 2
                goto L_0x0097
            L_0x0065:
                boolean r5 = r6 instanceof java.lang.String
                if (r5 == 0) goto L_0x006b
                r5 = 3
                goto L_0x0097
            L_0x006b:
                boolean r5 = r6 instanceof java.lang.Boolean
                if (r5 == 0) goto L_0x0071
                r5 = 4
                goto L_0x0097
            L_0x0071:
                boolean r5 = r6 instanceof java.lang.Float
                if (r5 == 0) goto L_0x0077
                r5 = 5
                goto L_0x0097
            L_0x0077:
                boolean r5 = r6 instanceof java.lang.Double
                if (r5 == 0) goto L_0x007d
                r5 = 6
                goto L_0x0097
            L_0x007d:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r8 = "unresolve failed, unknown type="
                r5.append(r8)
                java.lang.Class r8 = r6.getClass()
                java.lang.String r8 = r8.toString()
                r5.append(r8)
                java.lang.String r5 = r5.toString()
                goto L_0x0055
            L_0x0097:
                if (r5 != 0) goto L_0x009a
                goto L_0x003e
            L_0x009a:
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.String r7 = "type"
                r0.put(r7, r5)
                java.lang.String r5 = r6.toString()
                java.lang.String r6 = "value"
                r0.put(r6, r5)
                android.content.ContentResolver r5 = r9.cr
                android.net.Uri r6 = com.tencent.mm.opensdk.utils.a.f9613a
                java.lang.Object r3 = r3.getKey()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.String[] r3 = new java.lang.String[]{r3}
                r5.update(r6, r0, r4, r3)
                goto L_0x003e
            L_0x00be:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.openapi.MMSharedPreferences.REditor.commit():boolean");
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.values.put(str, Boolean.valueOf(z));
            this.remove.remove(str);
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            this.values.put(str, Float.valueOf(f));
            this.remove.remove(str);
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            this.values.put(str, Integer.valueOf(i));
            this.remove.remove(str);
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            this.values.put(str, Long.valueOf(j));
            this.remove.remove(str);
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            this.values.put(str, str2);
            this.remove.remove(str);
            return this;
        }

        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        public SharedPreferences.Editor remove(String str) {
            this.remove.add(str);
            return this;
        }
    }

    public MMSharedPreferences(Context context) {
        this.cr = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.cr.query(a.f9613a, this.columns, "key = ?", new String[]{str}, (String) null);
            if (query == null) {
                return null;
            }
            Object a2 = query.moveToFirst() ? com.tencent.mm.opensdk.channel.a.a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex(AccountConstantKt.RESPONSE_VALUE))) : null;
            query.close();
            return a2;
        } catch (Exception e) {
            Log.e(TAG, "getValue exception:" + e.getMessage());
            return null;
        }
    }

    public boolean contains(String str) {
        return getValue(str) != null;
    }

    public SharedPreferences.Editor edit() {
        if (this.editor == null) {
            this.editor = new REditor(this.cr);
        }
        return this.editor;
    }

    public Map<String, ?> getAll() {
        try {
            Cursor query = this.cr.query(a.f9613a, this.columns, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex(IntentKey.ACTIVITY.ACTION_KEY);
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex(AccountConstantKt.RESPONSE_VALUE);
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), com.tencent.mm.opensdk.channel.a.a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.values;
        } catch (Exception e) {
            Log.e(TAG, "getAll exception:" + e.getMessage());
            return this.values;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    public float getFloat(String str, float f) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f : ((Float) value).floatValue();
    }

    public int getInt(String str, int i) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
    }

    public long getLong(String str, long j) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
    }

    public String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
