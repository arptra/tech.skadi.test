package org.litepal.tablemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.util.Const;
import org.litepal.util.DBUtility;
import org.litepal.util.LitePalLog;

public abstract class AssociationCreator extends Generator {
    private void addAssociations(Collection<AssociationsModel> collection, SQLiteDatabase sQLiteDatabase, boolean z) {
        for (AssociationsModel next : collection) {
            if (2 == next.getAssociationType() || 1 == next.getAssociationType()) {
                addForeignKeyColumn(next.getTableName(), next.getAssociatedTableName(), next.getTableHoldsForeignKey(), sQLiteDatabase);
            } else if (3 == next.getAssociationType()) {
                createIntermediateTable(next.getTableName(), next.getAssociatedTableName(), sQLiteDatabase, z);
            }
        }
        for (GenericModel createGenericTable : getGenericModels()) {
            createGenericTable(createGenericTable, sQLiteDatabase, z);
        }
    }

    private void createGenericTable(GenericModel genericModel, SQLiteDatabase sQLiteDatabase, boolean z) {
        String tableName = genericModel.getTableName();
        String valueColumnName = genericModel.getValueColumnName();
        String valueColumnType = genericModel.getValueColumnType();
        String valueIdColumnName = genericModel.getValueIdColumnName();
        ArrayList arrayList = new ArrayList();
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(valueColumnName);
        columnModel.setColumnType(valueColumnType);
        ColumnModel columnModel2 = new ColumnModel();
        columnModel2.setColumnName(valueIdColumnName);
        columnModel2.setColumnType("integer");
        arrayList.add(columnModel);
        arrayList.add(columnModel2);
        ArrayList arrayList2 = new ArrayList();
        if (!DBUtility.isTableExists(tableName, sQLiteDatabase)) {
            arrayList2.add(generateCreateTableSQL(tableName, arrayList, false));
        } else if (z) {
            arrayList2.add(generateDropTableSQL(tableName));
            arrayList2.add(generateCreateTableSQL(tableName, arrayList, false));
        }
        execute(arrayList2, sQLiteDatabase);
        giveTableSchemaACopy(tableName, 2, sQLiteDatabase);
    }

    private void createIntermediateTable(String str, String str2, SQLiteDatabase sQLiteDatabase, boolean z) {
        ArrayList arrayList = new ArrayList();
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(str + "_id");
        columnModel.setColumnType("integer");
        ColumnModel columnModel2 = new ColumnModel();
        columnModel2.setColumnName(str2 + "_id");
        columnModel2.setColumnType("integer");
        arrayList.add(columnModel);
        arrayList.add(columnModel2);
        String intermediateTableName = DBUtility.getIntermediateTableName(str, str2);
        ArrayList arrayList2 = new ArrayList();
        if (!DBUtility.isTableExists(intermediateTableName, sQLiteDatabase)) {
            arrayList2.add(generateCreateTableSQL(intermediateTableName, arrayList, false));
        } else if (z) {
            arrayList2.add(generateDropTableSQL(intermediateTableName));
            arrayList2.add(generateCreateTableSQL(intermediateTableName, arrayList, false));
        }
        execute(arrayList2, sQLiteDatabase);
        giveTableSchemaACopy(intermediateTableName, 1, sQLiteDatabase);
    }

    private boolean isContainsOnlyIdField(Collection<ColumnModel> collection) {
        for (ColumnModel isIdColumn : collection) {
            if (!isIdColumn.isIdColumn()) {
                return false;
            }
        }
        return true;
    }

    private boolean isNeedtoGiveACopy(Cursor cursor, String str) {
        return !isValueExists(cursor, str) && !isSpecialTable(str);
    }

    private boolean isSpecialTable(String str) {
        return Const.TableSchema.TABLE_NAME.equalsIgnoreCase(str);
    }

    private boolean isValueExists(Cursor cursor, String str) {
        if (cursor.moveToFirst()) {
            while (!cursor.getString(cursor.getColumnIndexOrThrow("name")).equalsIgnoreCase(str)) {
                if (!cursor.moveToNext()) {
                }
            }
            return true;
        }
        return false;
    }

    public void addForeignKeyColumn(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        if (!DBUtility.isTableExists(str, sQLiteDatabase)) {
            throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST + str);
        } else if (DBUtility.isTableExists(str2, sQLiteDatabase)) {
            String foreignKeyColumnName = str.equals(str3) ? getForeignKeyColumnName(str2) : str2.equals(str3) ? getForeignKeyColumnName(str) : null;
            if (!DBUtility.isColumnExists(foreignKeyColumnName, str3, sQLiteDatabase)) {
                ColumnModel columnModel = new ColumnModel();
                columnModel.setColumnName(foreignKeyColumnName);
                columnModel.setColumnType("integer");
                ArrayList arrayList = new ArrayList();
                arrayList.add(generateAddColumnSQL(str3, columnModel));
                execute(arrayList, sQLiteDatabase);
                return;
            }
            LitePalLog.d(Generator.TAG, "column " + foreignKeyColumnName + " is already exist, no need to add one");
        } else {
            throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST + str2);
        }
    }

    public void addOrUpdateAssociation(SQLiteDatabase sQLiteDatabase, boolean z) {
        addAssociations(getAllAssociations(), sQLiteDatabase, z);
    }

    public abstract void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z);

    public String generateAddColumnSQL(String str, ColumnModel columnModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("alter table ");
        sb.append(str);
        sb.append(" add column ");
        sb.append(columnModel.getColumnName());
        sb.append(" ");
        sb.append(columnModel.getColumnType());
        if (!columnModel.isNullable()) {
            sb.append(" not null");
        }
        if (columnModel.isUnique()) {
            sb.append(" unique");
        }
        String defaultValue = columnModel.getDefaultValue();
        if (!TextUtils.isEmpty(defaultValue)) {
            sb.append(" default ");
            sb.append(defaultValue);
        } else if (!columnModel.isNullable()) {
            if ("integer".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "0";
            } else if ("text".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "''";
            } else if ("real".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "0.0";
            }
            sb.append(" default ");
            sb.append(defaultValue);
        }
        LitePalLog.d(Generator.TAG, "add column sql is >> " + sb);
        return sb.toString();
    }

    public String generateCreateIndexSQL(String str, ColumnModel columnModel) {
        StringBuilder sb = new StringBuilder();
        if (columnModel.hasIndex()) {
            sb.append("create index ");
            sb.append(DBUtility.getIndexName(str, columnModel.getColumnName()));
            sb.append(" on ");
            sb.append(str);
            sb.append(" (");
            sb.append(columnModel.getColumnName());
            sb.append(")");
            LitePalLog.d(Generator.TAG, "create table index sql is >> " + sb);
        }
        return sb.toString();
    }

    public List<String> generateCreateIndexSQLs(String str, Collection<ColumnModel> collection) {
        ArrayList arrayList = new ArrayList();
        for (ColumnModel next : collection) {
            if (next.hasIndex()) {
                arrayList.add(generateCreateIndexSQL(str, next));
            }
        }
        return arrayList;
    }

    public String generateCreateTableSQL(String str, Collection<ColumnModel> collection, boolean z) {
        StringBuilder sb = new StringBuilder("create table ");
        sb.append(str);
        sb.append(" (");
        if (z) {
            sb.append("id integer primary key autoincrement,");
        }
        if (isContainsOnlyIdField(collection)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        boolean z2 = false;
        for (ColumnModel next : collection) {
            if (!next.isIdColumn()) {
                if (z2) {
                    sb.append(", ");
                }
                sb.append(next.getColumnName());
                sb.append(" ");
                sb.append(next.getColumnType());
                if (!next.isNullable()) {
                    sb.append(" not null");
                }
                if (next.isUnique()) {
                    sb.append(" unique");
                }
                String defaultValue = next.getDefaultValue();
                if (!TextUtils.isEmpty(defaultValue)) {
                    sb.append(" default ");
                    sb.append(defaultValue);
                }
                z2 = true;
            }
        }
        sb.append(")");
        LitePalLog.d(Generator.TAG, "create table sql is >> " + sb);
        return sb.toString();
    }

    public String generateDropTableSQL(String str) {
        return "drop table if exists " + str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void giveTableSchemaACopy(java.lang.String r5, int r6, android.database.sqlite.SQLiteDatabase r7) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "select * from "
            r0.<init>(r1)
            java.lang.String r1 = "table_schema"
            r0.append(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "giveTableSchemaACopy SQL is >> "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Generator"
            org.litepal.util.LitePalLog.d(r3, r2)
            r2 = 0
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x005a }
            android.database.Cursor r0 = r7.rawQuery(r0, r2)     // Catch:{ Exception -> 0x005a }
            boolean r4 = r4.isNeedtoGiveACopy(r0, r5)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            if (r4 == 0) goto L_0x0052
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            r4.<init>()     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            java.lang.String r3 = "name"
            java.lang.String r5 = org.litepal.util.BaseUtility.changeCase(r5)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            r4.put(r3, r5)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            java.lang.String r5 = "type"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            r7.insert(r1, r2, r4)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            goto L_0x0052
        L_0x004c:
            r4 = move-exception
            r2 = r0
            goto L_0x0064
        L_0x004f:
            r4 = move-exception
            r2 = r0
            goto L_0x005b
        L_0x0052:
            if (r0 == 0) goto L_0x0063
            r0.close()
            goto L_0x0063
        L_0x0058:
            r4 = move-exception
            goto L_0x0064
        L_0x005a:
            r4 = move-exception
        L_0x005b:
            r4.printStackTrace()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0063
            r2.close()
        L_0x0063:
            return
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.tablemanager.AssociationCreator.giveTableSchemaACopy(java.lang.String, int, android.database.sqlite.SQLiteDatabase):void");
    }

    public boolean isForeignKeyColumnFormat(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.US).endsWith("_id") && !str.equalsIgnoreCase("_id");
    }
}
