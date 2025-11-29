package com.xingin.xhssharesdk.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;

public final class d extends a<f> {
    public d(Context context) {
        super(context);
    }

    public final long a() {
        if (!e()) {
            return 0;
        }
        try {
            return DatabaseUtils.queryNumEntries(this.f8172a, "biz");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final long b(f fVar) {
        if (!e()) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues(4);
            contentValues.put("eventId", fVar.b);
            contentValues.put("data", fVar.c);
            contentValues.put("createTime", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("monitorKey", fVar.d);
            return this.f8172a.insert("biz", (String) null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final boolean c(ArrayList arrayList) {
        if (!e()) {
            return false;
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SQLiteDatabase sQLiteDatabase = this.f8172a;
                sQLiteDatabase.delete("biz", "id = " + ((f) it.next()).f8175a, (String[]) null);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final ArrayList f() {
        Cursor query;
        if (!e()) {
            return null;
        }
        try {
            query = this.f8172a.query("biz", e.f8174a, (String) null, (String[]) null, (String) null, (String) null, "id ASC LIMIT + 100");
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                arrayList.add(new f(query.getLong(0), query.getString(1), query.getBlob(2), query.getString(3)));
            }
            query.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
