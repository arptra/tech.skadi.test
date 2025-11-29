package org.litepal.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.Operator;
import org.litepal.annotation.Encrypt;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class UpdateHandler extends DataHandler {
    public UpdateHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    private void analyzeAssociations(LitePalSupport litePalSupport) {
        try {
            analyzeAssociatedModels(litePalSupport, getAssociationInfo(litePalSupport.getClassName()));
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    private void convertContentValues(ContentValues contentValues) {
        HashMap hashMap = new HashMap();
        for (String next : contentValues.keySet()) {
            if (DBUtility.isFieldNameConflictWithSQLiteKeywords(next)) {
                hashMap.put(next, contentValues.get(next));
            }
        }
        for (String str : hashMap.keySet()) {
            String convertToValidColumnName = DBUtility.convertToValidColumnName(str);
            Object obj = contentValues.get(str);
            contentValues.remove(str);
            if (obj == null) {
                contentValues.putNull(convertToValidColumnName);
            } else {
                String name = obj.getClass().getName();
                if ("java.lang.Byte".equals(name)) {
                    contentValues.put(convertToValidColumnName, (Byte) obj);
                } else if ("[B".equals(name)) {
                    contentValues.put(convertToValidColumnName, (byte[]) obj);
                } else if ("java.lang.Boolean".equals(name)) {
                    contentValues.put(convertToValidColumnName, (Boolean) obj);
                } else if ("java.lang.String".equals(name)) {
                    contentValues.put(convertToValidColumnName, (String) obj);
                } else if ("java.lang.Float".equals(name)) {
                    contentValues.put(convertToValidColumnName, (Float) obj);
                } else if ("java.lang.Long".equals(name)) {
                    contentValues.put(convertToValidColumnName, (Long) obj);
                } else if ("java.lang.Integer".equals(name)) {
                    contentValues.put(convertToValidColumnName, (Integer) obj);
                } else if ("java.lang.Short".equals(name)) {
                    contentValues.put(convertToValidColumnName, (Short) obj);
                } else if ("java.lang.Double".equals(name)) {
                    contentValues.put(convertToValidColumnName, (Double) obj);
                }
            }
        }
    }

    private int doUpdateAllAction(String str, ContentValues contentValues, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (contentValues.size() > 0) {
            return this.mDatabase.update(str, contentValues, getWhereClause(strArr), getWhereArgs(strArr));
        }
        return 0;
    }

    private int doUpdateAssociations(LitePalSupport litePalSupport, long j, ContentValues contentValues) {
        analyzeAssociations(litePalSupport);
        updateSelfTableForeignKey(litePalSupport, contentValues);
        return updateAssociatedTableForeignKey(litePalSupport, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        throw new org.litepal.exceptions.LitePalSupportException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c A[Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }, ExcHandler: Exception (r0v4 'e' java.lang.Exception A[CUSTOM_DECLARE, Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }]), Splitter:B:1:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void putFieldsToDefaultValue(org.litepal.crud.LitePalSupport r16, android.content.ContentValues r17, long... r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r18
            r2 = 0
            org.litepal.crud.LitePalSupport r3 = r15.getEmptyModel(r16)     // Catch:{ NoSuchFieldException -> 0x009b, Exception -> 0x006c }
            java.lang.Class r4 = r3.getClass()     // Catch:{ NoSuchFieldException -> 0x009b, Exception -> 0x006c }
            java.util.List r5 = r16.getFieldsToSetToDefault()     // Catch:{ NoSuchFieldException -> 0x009b, Exception -> 0x006c }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ NoSuchFieldException -> 0x009b, Exception -> 0x006c }
            r6 = r2
        L_0x0015:
            boolean r7 = r5.hasNext()     // Catch:{ NoSuchFieldException -> 0x0097, Exception -> 0x006c }
            if (r7 == 0) goto L_0x009a
            java.lang.Object r7 = r5.next()     // Catch:{ NoSuchFieldException -> 0x0097, Exception -> 0x006c }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NoSuchFieldException -> 0x0097, Exception -> 0x006c }
            boolean r8 = r15.isIdColumn(r7)     // Catch:{ NoSuchFieldException -> 0x0097, Exception -> 0x006c }
            if (r8 != 0) goto L_0x0093
            java.lang.reflect.Field r6 = r4.getDeclaredField(r7)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            java.lang.Class r8 = r6.getType()     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            boolean r8 = r15.isCollection(r8)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            if (r8 == 0) goto L_0x008c
            if (r1 == 0) goto L_0x0089
            int r8 = r1.length     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            if (r8 <= 0) goto L_0x0089
            java.lang.String r8 = r15.getGenericTypeName(r6)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            boolean r8 = org.litepal.util.BaseUtility.isGenericTypeSupported(r8)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            if (r8 == 0) goto L_0x0089
            java.lang.String r8 = r16.getClassName()     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            java.lang.String r6 = r6.getName()     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            java.lang.String r6 = org.litepal.util.DBUtility.getGenericTableName(r8, r6)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            java.lang.String r8 = r16.getClassName()     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            java.lang.String r8 = org.litepal.util.DBUtility.getGenericValueIdColumnName(r8)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            r9.<init>()     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            int r10 = r1.length     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            r11 = 0
            r12 = r11
        L_0x0060:
            if (r11 >= r10) goto L_0x0080
            r13 = r1[r11]     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            if (r12 == 0) goto L_0x0071
            java.lang.String r12 = " or "
            r9.append(r12)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            goto L_0x0071
        L_0x006c:
            r0 = move-exception
            goto L_0x009d
        L_0x006e:
            r0 = move-exception
            r2 = r7
            goto L_0x00a7
        L_0x0071:
            r9.append(r8)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            java.lang.String r12 = " = "
            r9.append(r12)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            r9.append(r13)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            int r11 = r11 + 1
            r12 = 1
            goto L_0x0060
        L_0x0080:
            android.database.sqlite.SQLiteDatabase r8 = r0.mDatabase     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            java.lang.String r9 = r9.toString()     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
            r8.delete(r6, r9, r2)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
        L_0x0089:
            r8 = r17
            goto L_0x0091
        L_0x008c:
            r8 = r17
            r15.putContentValuesForUpdate(r3, r6, r8)     // Catch:{ NoSuchFieldException -> 0x006e, Exception -> 0x006c }
        L_0x0091:
            r6 = r7
            goto L_0x0015
        L_0x0093:
            r8 = r17
            goto L_0x0015
        L_0x0097:
            r0 = move-exception
            r2 = r6
            goto L_0x00a7
        L_0x009a:
            return
        L_0x009b:
            r0 = move-exception
            goto L_0x00a7
        L_0x009d:
            org.litepal.exceptions.LitePalSupportException r1 = new org.litepal.exceptions.LitePalSupportException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x00a7:
            org.litepal.exceptions.LitePalSupportException r1 = new org.litepal.exceptions.LitePalSupportException
            java.lang.String r3 = r16.getClassName()
            java.lang.String r2 = org.litepal.exceptions.LitePalSupportException.noSuchFieldExceptioin(r3, r2)
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.crud.UpdateHandler.putFieldsToDefaultValue(org.litepal.crud.LitePalSupport, android.content.ContentValues, long[]):void");
    }

    private int updateAssociatedTableForeignKey(LitePalSupport litePalSupport, long j) {
        Map<String, Set<Long>> associatedModelsMapWithFK = litePalSupport.getAssociatedModelsMapWithFK();
        ContentValues contentValues = new ContentValues();
        for (String next : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(getForeignKeyColumnName(litePalSupport.getTableName()), Long.valueOf(j));
            Set set = associatedModelsMapWithFK.get(next);
            if (set != null && !set.isEmpty()) {
                return this.mDatabase.update(next, contentValues, getWhereOfIdsWithOr((Collection<Long>) set), (String[]) null);
            }
        }
        return 0;
    }

    private void updateGenericTables(LitePalSupport litePalSupport, List<Field> list, long... jArr) throws IllegalAccessException, InvocationTargetException {
        Field field;
        Iterator<Field> it;
        long[] jArr2 = jArr;
        if (jArr2 != null && jArr2.length > 0) {
            Iterator<Field> it2 = list.iterator();
            while (it2.hasNext()) {
                Field next = it2.next();
                Encrypt encrypt = (Encrypt) next.getAnnotation(Encrypt.class);
                String genericTypeName = getGenericTypeName(next);
                String algorithm = (encrypt == null || !"java.lang.String".equals(genericTypeName)) ? null : encrypt.algorithm();
                next.setAccessible(true);
                Collection collection = (Collection) next.get(litePalSupport);
                if (collection != null && !collection.isEmpty()) {
                    String genericTableName = DBUtility.getGenericTableName(litePalSupport.getClassName(), next.getName());
                    String genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(litePalSupport.getClassName());
                    int length = jArr2.length;
                    int i = 0;
                    while (i < length) {
                        long j = jArr2[i];
                        SQLiteDatabase sQLiteDatabase = this.mDatabase;
                        sQLiteDatabase.delete(genericTableName, genericValueIdColumnName + " = ?", new String[]{String.valueOf(j)});
                        Iterator it3 = collection.iterator();
                        while (it3.hasNext()) {
                            Object next2 = it3.next();
                            ContentValues contentValues = new ContentValues();
                            Iterator it4 = it3;
                            contentValues.put(genericValueIdColumnName, Long.valueOf(j));
                            Object encryptValue = encryptValue(algorithm, next2);
                            if (litePalSupport.getClassName().equals(genericTypeName)) {
                                LitePalSupport litePalSupport2 = (LitePalSupport) encryptValue;
                                if (litePalSupport2 != null) {
                                    long baseObjId = litePalSupport2.getBaseObjId();
                                    if (baseObjId > 0) {
                                        contentValues.put(DBUtility.getM2MSelfRefColumnName(next), Long.valueOf(baseObjId));
                                        it = it2;
                                        field = next;
                                    }
                                }
                                it3 = it4;
                            } else {
                                it = it2;
                                field = next;
                                DynamicExecutor.send(contentValues, "put", new Object[]{DBUtility.convertToValidColumnName(BaseUtility.changeCase(next.getName())), encryptValue}, contentValues.getClass(), new Class[]{String.class, getGenericTypeClass(next)});
                            }
                            this.mDatabase.insert(genericTableName, (String) null, contentValues);
                            it3 = it4;
                            it2 = it;
                            next = field;
                        }
                        Field field2 = next;
                        i++;
                        jArr2 = jArr;
                        it2 = it2;
                    }
                }
                jArr2 = jArr;
                it2 = it2;
            }
        }
    }

    private void updateSelfTableForeignKey(LitePalSupport litePalSupport, ContentValues contentValues) {
        Map<String, Long> associatedModelsMapWithoutFK = litePalSupport.getAssociatedModelsMapWithoutFK();
        for (String next : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(getForeignKeyColumnName(next), associatedModelsMapWithoutFK.get(next));
        }
    }

    public int onUpdate(LitePalSupport litePalSupport, long j) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Field> supportedFields = getSupportedFields(litePalSupport.getClassName());
        updateGenericTables(litePalSupport, getSupportedGenericFields(litePalSupport.getClassName()), j);
        ContentValues contentValues = new ContentValues();
        putFieldsValue(litePalSupport, supportedFields, contentValues);
        putFieldsToDefaultValue(litePalSupport, contentValues, j);
        if (contentValues.size() <= 0) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        String tableName = litePalSupport.getTableName();
        return sQLiteDatabase.update(tableName, contentValues, "id = " + j, (String[]) null);
    }

    public int onUpdateAll(LitePalSupport litePalSupport, String... strArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        long[] jArr;
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        List<Field> supportedFields = getSupportedFields(litePalSupport.getClassName());
        List<Field> supportedGenericFields = getSupportedGenericFields(litePalSupport.getClassName());
        if (!supportedGenericFields.isEmpty()) {
            List<?> find = Operator.select("id").where(strArr).find(litePalSupport.getClass());
            if (find.size() > 0) {
                int size = find.size();
                jArr = new long[size];
                for (int i = 0; i < size; i++) {
                    jArr[i] = ((LitePalSupport) find.get(i)).getBaseObjId();
                }
                updateGenericTables(litePalSupport, supportedGenericFields, jArr);
                ContentValues contentValues = new ContentValues();
                putFieldsValue(litePalSupport, supportedFields, contentValues);
                putFieldsToDefaultValue(litePalSupport, contentValues, jArr);
                return doUpdateAllAction(litePalSupport.getTableName(), contentValues, strArr);
            }
        }
        jArr = null;
        ContentValues contentValues2 = new ContentValues();
        putFieldsValue(litePalSupport, supportedFields, contentValues2);
        putFieldsToDefaultValue(litePalSupport, contentValues2, jArr);
        return doUpdateAllAction(litePalSupport.getTableName(), contentValues2, strArr);
    }

    public int onUpdate(Class<?> cls, long j, ContentValues contentValues) {
        if (contentValues.size() <= 0) {
            return 0;
        }
        convertContentValues(contentValues);
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        String tableName = getTableName(cls);
        return sQLiteDatabase.update(tableName, contentValues, "id = " + j, (String[]) null);
    }

    public int onUpdateAll(String str, ContentValues contentValues, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        convertContentValues(contentValues);
        return doUpdateAllAction(str, contentValues, strArr);
    }
}
