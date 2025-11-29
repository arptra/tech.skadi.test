package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;

public class Dropper extends AssociationUpdater {
    private Collection<TableModel> mTableModels;

    private void dropTables() {
        List<String> findTablesToDrop = findTablesToDrop();
        dropTables(findTablesToDrop, this.mDb);
        clearCopyInTableSchema(findTablesToDrop);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
        if (r1 == null) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> findTablesToDrop() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.mDb     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = "table_schema"
            r8 = 0
            r9 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0050 }
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0050 }
            if (r2 == 0) goto L_0x0058
        L_0x001a:
            java.lang.String r2 = "name"
            int r2 = r1.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = "type"
            int r3 = r1.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0050 }
            int r3 = r1.getInt(r3)     // Catch:{ Exception -> 0x0050 }
            boolean r3 = r10.shouldDropThisTable(r2, r3)     // Catch:{ Exception -> 0x0050 }
            if (r3 == 0) goto L_0x0052
            java.lang.String r3 = "AssociationUpdater"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r4.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = "need to drop "
            r4.append(r5)     // Catch:{ Exception -> 0x0050 }
            r4.append(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0050 }
            org.litepal.util.LitePalLog.d(r3, r4)     // Catch:{ Exception -> 0x0050 }
            r0.add(r2)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0052
        L_0x004e:
            r10 = move-exception
            goto L_0x0063
        L_0x0050:
            r10 = move-exception
            goto L_0x005c
        L_0x0052:
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x0050 }
            if (r2 != 0) goto L_0x001a
        L_0x0058:
            r1.close()
            goto L_0x0062
        L_0x005c:
            r10.printStackTrace()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0062
            goto L_0x0058
        L_0x0062:
            return r0
        L_0x0063:
            if (r1 == 0) goto L_0x0068
            r1.close()
        L_0x0068:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.tablemanager.Dropper.findTablesToDrop():java.util.List");
    }

    private List<String> pickTableNamesFromTableModels() {
        ArrayList arrayList = new ArrayList();
        for (TableModel tableName : this.mTableModels) {
            arrayList.add(tableName.getTableName());
        }
        return arrayList;
    }

    private boolean shouldDropThisTable(String str, int i) {
        return !BaseUtility.containsIgnoreCases(pickTableNamesFromTableModels(), str) && i == 0;
    }

    public void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.mTableModels = getAllTableModels();
        this.mDb = sQLiteDatabase;
        dropTables();
    }
}
