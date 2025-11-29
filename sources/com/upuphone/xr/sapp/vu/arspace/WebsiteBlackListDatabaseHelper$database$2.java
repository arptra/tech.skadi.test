package com.upuphone.xr.sapp.vu.arspace;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/database/sqlite/SQLiteDatabase;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class WebsiteBlackListDatabaseHelper$database$2 extends Lambda implements Function0<SQLiteDatabase> {
    final /* synthetic */ WebsiteBlackListDatabaseHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebsiteBlackListDatabaseHelper$database$2(WebsiteBlackListDatabaseHelper websiteBlackListDatabaseHelper) {
        super(0);
        this.this$0 = websiteBlackListDatabaseHelper;
    }

    public final SQLiteDatabase invoke() {
        return this.this$0.getWritableDatabase();
    }
}
