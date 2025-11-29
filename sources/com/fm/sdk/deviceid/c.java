package com.fm.sdk.deviceid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.honey.account.constant.AccountConstantKt;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f2834a;
    public static final Uri b;
    public static boolean c = false;

    static {
        Uri parse = Uri.parse("content://com.fm.openservice");
        f2834a = parse;
        b = Uri.withAppendedPath(parse, "property");
    }

    public static String a(Context context) {
        if (c) {
            return "";
        }
        try {
            Cursor query = context.getContentResolver().query(b, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null && query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex(AccountConstantKt.REQUEST_HEADER_OAID));
                c = true;
                return string;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            c = true;
            throw th;
        }
        c = true;
        return "";
    }
}
