package com.honey.account.database;

import com.honey.account.AccountHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/honey/account/database/DBHelper;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DBManager$dbHelper$2 extends Lambda implements Function0<DBHelper> {
    public static final DBManager$dbHelper$2 INSTANCE = new DBManager$dbHelper$2();

    public DBManager$dbHelper$2() {
        super(0);
    }

    @NotNull
    public final DBHelper invoke() {
        return new DBHelper(AccountHelper.INSTANCE.getMApplicationContext());
    }
}
