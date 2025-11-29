package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;

public final /* synthetic */ class a implements DatabaseErrorHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteOpenHelper.Callback f1805a;
    public final /* synthetic */ FrameworkSQLiteOpenHelper.DBRefHolder b;

    public /* synthetic */ a(SupportSQLiteOpenHelper.Callback callback, FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder) {
        this.f1805a = callback;
        this.b = dBRefHolder;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteOpenHelper.OpenHelper.b(this.f1805a, this.b, sQLiteDatabase);
    }
}
