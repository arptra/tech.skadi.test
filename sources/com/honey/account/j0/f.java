package com.honey.account.j0;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;

public final /* synthetic */ class f implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3063a;

    public /* synthetic */ f(Context context) {
        this.f3063a = context;
    }

    public final SupportSQLiteOpenHelper a(SupportSQLiteOpenHelper.Configuration configuration) {
        return WorkDatabase.Companion.c(this.f3063a, configuration);
    }
}
