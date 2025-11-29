package org.litepal.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.litepal.LitePalBase;
import org.litepal.Operator;
import org.litepal.annotation.Column;
import org.litepal.annotation.Encrypt;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import org.litepal.util.cipher.CipherUtil;

abstract class DataHandler extends LitePalBase {
    public static final String TAG = "DataHandler";
    private List<AssociationsInfo> fkInCurrentModel;
    private List<AssociationsInfo> fkInOtherModel;
    SQLiteDatabase mDatabase;
    private LitePalSupport tempEmptyModel;

    public static class QueryInfoCache {
        Field field;
        String getMethodName;
    }

    private void analyzeAssociations(String str) {
        Collection<AssociationsInfo> associationInfo = getAssociationInfo(str);
        List<AssociationsInfo> list = this.fkInCurrentModel;
        if (list == null) {
            this.fkInCurrentModel = new ArrayList();
        } else {
            list.clear();
        }
        List<AssociationsInfo> list2 = this.fkInOtherModel;
        if (list2 == null) {
            this.fkInOtherModel = new ArrayList();
        } else {
            list2.clear();
        }
        for (AssociationsInfo next : associationInfo) {
            if (next.getAssociationType() == 2 || next.getAssociationType() == 1) {
                if (next.getClassHoldsForeignKey().equals(str)) {
                    this.fkInCurrentModel.add(next);
                } else {
                    this.fkInOtherModel.add(next);
                }
            } else if (next.getAssociationType() == 3) {
                this.fkInOtherModel.add(next);
            }
        }
    }

    private String genGetColumnMethod(Field field) {
        Class<?> cls;
        if (isCollection(field.getType())) {
            cls = getGenericTypeClass(field);
        } else {
            cls = field.getType();
        }
        return genGetColumnMethod(cls);
    }

    private String[] getCustomizedColumns(String[] strArr, List<Field> list, List<AssociationsInfo> list2) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Field name : list) {
            arrayList2.add(name.getName());
        }
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (BaseUtility.containsIgnoreCases(arrayList2, str)) {
                arrayList3.add(Integer.valueOf(i));
            } else if (isIdColumn(str)) {
                if ("_id".equalsIgnoreCase(str)) {
                    arrayList.set(i, BaseUtility.changeCase("id"));
                }
                z = true;
            }
        }
        for (int size = arrayList3.size() - 1; size >= 0; size--) {
            arrayList4.add((String) arrayList.remove(((Integer) arrayList3.get(size)).intValue()));
        }
        for (Field next : list) {
            if (BaseUtility.containsIgnoreCases(arrayList4, next.getName())) {
                arrayList5.add(next);
            }
        }
        list.clear();
        list.addAll(arrayList5);
        if (list2 != null && list2.size() > 0) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                arrayList.add(getForeignKeyColumnName(DBUtility.getTableNameByClassName(list2.get(i2).getAssociatedClassName())));
            }
        }
        if (!z) {
            arrayList.add(BaseUtility.changeCase("id"));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private Object getInitParamValue(Class<?> cls, Class<?> cls2) {
        String name = cls2.getName();
        if ("boolean".equals(name) || "java.lang.Boolean".equals(name)) {
            return Boolean.FALSE;
        }
        if ("float".equals(name) || "java.lang.Float".equals(name)) {
            return Float.valueOf(0.0f);
        }
        if ("double".equals(name) || "java.lang.Double".equals(name)) {
            return Double.valueOf(0.0d);
        }
        if ("int".equals(name) || "java.lang.Integer".equals(name)) {
            return 0;
        }
        if ("long".equals(name) || "java.lang.Long".equals(name)) {
            return 0L;
        }
        if ("short".equals(name) || "java.lang.Short".equals(name)) {
            return 0;
        }
        if ("char".equals(name) || "java.lang.Character".equals(name)) {
            return ' ';
        }
        if ("[B".equals(name) || "[Ljava.lang.Byte;".equals(name)) {
            return new byte[0];
        }
        if ("java.lang.String".equals(name)) {
            return "";
        }
        if (cls == cls2) {
            return null;
        }
        return createInstanceFromClass(cls2);
    }

    private Class<?> getObjectType(Class<?> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return null;
        }
        String name = cls.getName();
        if (name.equals("double")) {
            return Double.class;
        }
        if (name.equals("int")) {
            return Integer.class;
        }
        if (name.equals("char")) {
            return Character.class;
        }
        if (name.equals("long")) {
            return Long.class;
        }
        if (name.equals("boolean")) {
            return Boolean.class;
        }
        if (name.equals("float")) {
            return Float.class;
        }
        if (!name.equals("short")) {
            return null;
        }
        return Short.class;
    }

    private boolean isCharType(Field field) {
        String name = field.getType().getName();
        return name.equals("char") || name.endsWith("Character");
    }

    private boolean isFieldWithDefaultValue(LitePalSupport litePalSupport, Field field) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        LitePalSupport emptyModel = getEmptyModel(litePalSupport);
        Object fieldValue = getFieldValue(litePalSupport, field);
        Object fieldValue2 = getFieldValue(emptyModel, field);
        return (fieldValue == null || fieldValue2 == null) ? fieldValue == fieldValue2 : fieldValue.toString().equals(fieldValue2.toString());
    }

    private boolean isPrimitiveBooleanType(Field field) {
        return "boolean".equals(field.getType().getName());
    }

    private boolean isSaving() {
        return SaveHandler.class.getName().equals(getClass().getName());
    }

    private boolean isUpdating() {
        return UpdateHandler.class.getName().equals(getClass().getName());
    }

    private void putFieldsValueDependsOnSaveOrUpdate(LitePalSupport litePalSupport, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (isUpdating()) {
            if (!isFieldWithDefaultValue(litePalSupport, field)) {
                putContentValuesForUpdate(litePalSupport, field, contentValues);
            }
        } else if (isSaving()) {
            putContentValuesForSave(litePalSupport, field, contentValues);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0175 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setAssociatedModel(org.litepal.crud.LitePalSupport r25) {
        /*
            r24 = this;
            r0 = r24
            r7 = r25
            java.util.List<org.litepal.crud.model.AssociationsInfo> r1 = r0.fkInOtherModel
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            java.util.Iterator r8 = r1.iterator()
        L_0x000d:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0189
            java.lang.Object r1 = r8.next()
            r9 = r1
            org.litepal.crud.model.AssociationsInfo r9 = (org.litepal.crud.model.AssociationsInfo) r9
            java.lang.String r10 = r9.getAssociatedClassName()
            int r1 = r9.getAssociationType()
            r2 = 3
            if (r1 != r2) goto L_0x0027
            r12 = 1
            goto L_0x0029
        L_0x0027:
            r1 = 0
            r12 = r1
        L_0x0029:
            r1 = 0
            java.util.List r13 = r0.getSupportedFields(r10)     // Catch:{ Exception -> 0x008c }
            java.util.List r14 = r0.getSupportedGenericFields(r10)     // Catch:{ Exception -> 0x008c }
            if (r12 == 0) goto L_0x008f
            java.lang.String r2 = r25.getTableName()     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = org.litepal.util.DBUtility.getTableNameByClassName(r10)     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = org.litepal.util.DBUtility.getIntermediateTableName(r2, r3)     // Catch:{ Exception -> 0x008c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c }
            r5.<init>()     // Catch:{ Exception -> 0x008c }
            java.lang.String r6 = "select * from "
            r5.append(r6)     // Catch:{ Exception -> 0x008c }
            r5.append(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String r6 = " a inner join "
            r5.append(r6)     // Catch:{ Exception -> 0x008c }
            r5.append(r4)     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = " b on a.id = b."
            r5.append(r4)     // Catch:{ Exception -> 0x008c }
            r5.append(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = "_id"
            r5.append(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = " where b."
            r5.append(r3)     // Catch:{ Exception -> 0x008c }
            r5.append(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = "_id = ?"
            r5.append(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = org.litepal.util.BaseUtility.changeCase(r2)     // Catch:{ Exception -> 0x008c }
            long r3 = r25.getBaseObjId()     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ Exception -> 0x008c }
            android.database.Cursor r1 = org.litepal.Operator.findBySQL(r2)     // Catch:{ Exception -> 0x008c }
        L_0x0087:
            r15 = r1
            goto L_0x00d1
        L_0x0089:
            r0 = move-exception
            goto L_0x0183
        L_0x008c:
            r0 = move-exception
            goto L_0x0179
        L_0x008f:
            java.lang.String r2 = r9.getSelfClassName()     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = org.litepal.util.DBUtility.getTableNameByClassName(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = r0.getForeignKeyColumnName(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = org.litepal.util.DBUtility.getTableNameByClassName(r10)     // Catch:{ Exception -> 0x008c }
            android.database.sqlite.SQLiteDatabase r15 = r0.mDatabase     // Catch:{ Exception -> 0x008c }
            java.lang.String r16 = org.litepal.util.BaseUtility.changeCase(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c }
            r3.<init>()     // Catch:{ Exception -> 0x008c }
            r3.append(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = "=?"
            r3.append(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r18 = r3.toString()     // Catch:{ Exception -> 0x008c }
            long r2 = r25.getBaseObjId()     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String[] r19 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x008c }
            r22 = 0
            r23 = 0
            r17 = 0
            r20 = 0
            r21 = 0
            android.database.Cursor r1 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x008c }
            goto L_0x0087
        L_0x00d1:
            if (r15 == 0) goto L_0x016e
            boolean r1 = r15.moveToFirst()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            if (r1 == 0) goto L_0x016e
            android.util.SparseArray r16 = new android.util.SparseArray     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r16.<init>()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r6.<init>()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
        L_0x00e3:
            java.lang.Class r1 = java.lang.Class.forName(r10)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            java.lang.Object r1 = r0.createInstanceFromClass(r1)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r5 = r1
            org.litepal.crud.LitePalSupport r5 = (org.litepal.crud.LitePalSupport) r5     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            java.lang.String r1 = "id"
            int r1 = r15.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            long r1 = r15.getLong(r1)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r0.giveBaseObjIdValue(r5, r1)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r4 = 0
            r1 = r24
            r2 = r5
            r3 = r13
            r11 = r5
            r5 = r15
            r18 = r8
            r8 = r6
            r6 = r16
            r1.setValueToModel(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r0.setGenericValueToModel(r11, r14, r8)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            int r1 = r9.getAssociationType()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r2 = 2
            if (r1 == r2) goto L_0x0116
            if (r12 == 0) goto L_0x0118
        L_0x0116:
            r2 = 1
            goto L_0x012d
        L_0x0118:
            int r1 = r9.getAssociationType()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r2 = 1
            if (r1 != r2) goto L_0x015c
            java.lang.reflect.Field r1 = r9.getAssociateOtherModelFromSelf()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r0.setFieldValue(r7, r1, r11)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            goto L_0x015c
        L_0x0127:
            r0 = move-exception
            r1 = r15
            goto L_0x0183
        L_0x012a:
            r0 = move-exception
            r1 = r15
            goto L_0x0179
        L_0x012d:
            java.lang.reflect.Field r1 = r9.getAssociateOtherModelFromSelf()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            java.lang.Object r3 = r0.getFieldValue(r7, r1)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            if (r3 != 0) goto L_0x0159
            java.lang.Class r3 = r1.getType()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            boolean r3 = r0.isList(r3)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            if (r3 == 0) goto L_0x0149
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r3.<init>()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            goto L_0x014e
        L_0x0149:
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r3.<init>()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
        L_0x014e:
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            java.lang.Class r4 = r25.getClass()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            org.litepal.crud.DynamicExecutor.setField(r7, r1, r3, r4)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
        L_0x0159:
            r3.add(r11)     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
        L_0x015c:
            boolean r1 = r15.moveToNext()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            if (r1 != 0) goto L_0x0169
            r16.clear()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            r8.clear()     // Catch:{ Exception -> 0x012a, all -> 0x0127 }
            goto L_0x0170
        L_0x0169:
            r6 = r8
            r8 = r18
            goto L_0x00e3
        L_0x016e:
            r18 = r8
        L_0x0170:
            if (r15 == 0) goto L_0x0175
            r15.close()
        L_0x0175:
            r8 = r18
            goto L_0x000d
        L_0x0179:
            org.litepal.exceptions.LitePalSupportException r2 = new org.litepal.exceptions.LitePalSupportException     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0089 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0089 }
            throw r2     // Catch:{ all -> 0x0089 }
        L_0x0183:
            if (r1 == 0) goto L_0x0188
            r1.close()
        L_0x0188:
            throw r0
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.crud.DataHandler.setAssociatedModel(org.litepal.crud.LitePalSupport):void");
    }

    private void setToModelByReflection(Object obj, Field field, int i, String str, Cursor cursor) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = cursor.getClass();
        if (!cursor.isNull(i)) {
            Object invoke = cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(cursor, new Object[]{Integer.valueOf(i)});
            if (field.getType() == Boolean.TYPE || field.getType() == Boolean.class) {
                if ("0".equals(String.valueOf(invoke))) {
                    invoke = Boolean.FALSE;
                } else if ("1".equals(String.valueOf(invoke))) {
                    invoke = Boolean.TRUE;
                }
            } else if (field.getType() == Character.TYPE || field.getType() == Character.class) {
                invoke = Character.valueOf(((String) invoke).charAt(0));
            } else if (field.getType() == Date.class) {
                long longValue = ((Long) invoke).longValue();
                invoke = longValue == LongCompanionObject.MAX_VALUE ? null : new Date(longValue);
            }
            Class cls2 = Encrypt.class;
            if (isCollection(field.getType())) {
                Collection collection = (Collection) DynamicExecutor.getField(obj, field.getName(), obj.getClass());
                if (collection == null) {
                    collection = isList(field.getType()) ? new ArrayList() : new HashSet();
                    DynamicExecutor.setField(obj, field.getName(), collection, obj.getClass());
                }
                String genericTypeName = getGenericTypeName(field);
                if ("java.lang.String".equals(genericTypeName)) {
                    Encrypt encrypt = (Encrypt) field.getAnnotation(cls2);
                    if (encrypt != null) {
                        invoke = decryptValue(encrypt.algorithm(), invoke);
                    }
                } else if (obj.getClass().getName().equals(genericTypeName) && ((invoke instanceof Long) || (invoke instanceof Integer))) {
                    invoke = Operator.find(obj.getClass(), ((Long) invoke).longValue());
                }
                collection.add(invoke);
                return;
            }
            Encrypt encrypt2 = (Encrypt) field.getAnnotation(cls2);
            if (encrypt2 != null && "java.lang.String".equals(field.getType().getName())) {
                invoke = decryptValue(encrypt2.algorithm(), invoke);
            }
            DynamicExecutor.setField(obj, field.getName(), invoke, obj.getClass());
        }
    }

    public void analyzeAssociatedModels(LitePalSupport litePalSupport, Collection<AssociationsInfo> collection) {
        try {
            for (AssociationsInfo next : collection) {
                if (next.getAssociationType() == 2) {
                    new Many2OneAnalyzer().analyze(litePalSupport, next);
                } else if (next.getAssociationType() == 1) {
                    new One2OneAnalyzer().analyze(litePalSupport, next);
                } else if (next.getAssociationType() == 3) {
                    new Many2ManyAnalyzer().analyze(litePalSupport, next);
                }
            }
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    public Object createInstanceFromClass(Class<?> cls) {
        try {
            Constructor<?> findBestSuitConstructor = findBestSuitConstructor(cls);
            return findBestSuitConstructor.newInstance(getConstructorParams(cls, findBestSuitConstructor));
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    public Object decryptValue(String str, Object obj) {
        return (str == null || obj == null || !"AES".equalsIgnoreCase(str)) ? obj : CipherUtil.aesDecrypt((String) obj);
    }

    public Object encryptValue(String str, Object obj) {
        return (str == null || obj == null) ? obj : "AES".equalsIgnoreCase(str) ? CipherUtil.aesEncrypt((String) obj) : MessageDigestAlgorithms.MD5.equalsIgnoreCase(str) ? CipherUtil.md5Encrypt((String) obj) : obj;
    }

    public Constructor<?> findBestSuitConstructor(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors.length != 0) {
            Constructor<?> constructor = null;
            int i = Integer.MAX_VALUE;
            for (Constructor<?> constructor2 : declaredConstructors) {
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                int length = parameterTypes.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Class<?> cls2 = parameterTypes[i2];
                        if (cls2 == cls || (cls2.getName().startsWith("com.android") && cls2.getName().endsWith("InstantReloadException"))) {
                            break;
                        }
                        i2++;
                    } else if (parameterTypes.length < i) {
                        i = parameterTypes.length;
                        constructor = constructor2;
                    }
                }
            }
            if (constructor != null) {
                constructor.setAccessible(true);
                return constructor;
            }
            StringBuilder sb = new StringBuilder(cls.getName());
            sb.append(" has no suited constructor to new instance. Constructors defined in class:");
            for (Constructor<?> constructor3 : declaredConstructors) {
                sb.append(StringUtils.LF);
                sb.append(constructor3.toString());
            }
            throw new LitePalSupportException(sb.toString());
        }
        throw new LitePalSupportException(cls.getName() + " has no constructor. LitePal could not handle it");
    }

    public LitePalSupport getAssociatedModel(LitePalSupport litePalSupport, AssociationsInfo associationsInfo) throws SecurityException, IllegalArgumentException, IllegalAccessException {
        return (LitePalSupport) getFieldValue(litePalSupport, associationsInfo.getAssociateOtherModelFromSelf());
    }

    public Collection<LitePalSupport> getAssociatedModels(LitePalSupport litePalSupport, AssociationsInfo associationsInfo) throws SecurityException, IllegalArgumentException, IllegalAccessException {
        return (Collection) getFieldValue(litePalSupport, associationsInfo.getAssociateOtherModelFromSelf());
    }

    public Object[] getConstructorParams(Class<?> cls, Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = getInitParamValue(cls, parameterTypes[i]);
        }
        return objArr;
    }

    public LitePalSupport getEmptyModel(LitePalSupport litePalSupport) {
        LitePalSupport litePalSupport2 = this.tempEmptyModel;
        if (litePalSupport2 != null) {
            return litePalSupport2;
        }
        String str = null;
        try {
            str = litePalSupport.getClassName();
            LitePalSupport litePalSupport3 = (LitePalSupport) Class.forName(str).newInstance();
            this.tempEmptyModel = litePalSupport3;
            return litePalSupport3;
        } catch (ClassNotFoundException unused) {
            throw new DatabaseGenerateException(DatabaseGenerateException.CLASS_NOT_FOUND + str);
        } catch (InstantiationException e) {
            throw new LitePalSupportException(str + LitePalSupportException.INSTANTIATION_EXCEPTION, e);
        } catch (Exception e2) {
            throw new LitePalSupportException(e2.getMessage(), e2);
        }
    }

    public Object getFieldValue(LitePalSupport litePalSupport, Field field) throws SecurityException, IllegalArgumentException, IllegalAccessException {
        if (shouldGetOrSet(litePalSupport, field)) {
            return DynamicExecutor.getField(litePalSupport, field.getName(), litePalSupport.getClass());
        }
        return null;
    }

    public List<AssociationsInfo> getForeignKeyAssociations(String str, boolean z) {
        if (!z) {
            return null;
        }
        analyzeAssociations(str);
        return this.fkInCurrentModel;
    }

    public String getIntermediateTableName(LitePalSupport litePalSupport, String str) {
        return BaseUtility.changeCase(DBUtility.getIntermediateTableName(litePalSupport.getTableName(), str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Class<?>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Class<?>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?>[] getParameterTypes(java.lang.reflect.Field r6, java.lang.Object r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            boolean r0 = r5.isCharType(r6)
            r1 = 0
            r2 = 2
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r4 = 1
            if (r0 == 0) goto L_0x0018
            java.lang.String r5 = java.lang.String.valueOf(r7)
            r8[r4] = r5
            java.lang.Class[] r5 = new java.lang.Class[r2]
            r5[r1] = r3
            r5[r4] = r3
            goto L_0x0055
        L_0x0018:
            java.lang.Class r7 = r6.getType()
            boolean r7 = r7.isPrimitive()
            if (r7 == 0) goto L_0x0032
            java.lang.Class[] r7 = new java.lang.Class[r2]
            r7[r1] = r3
            java.lang.Class r6 = r6.getType()
            java.lang.Class r5 = r5.getObjectType(r6)
            r7[r4] = r5
            r5 = r7
            goto L_0x0055
        L_0x0032:
            java.lang.Class r5 = r6.getType()
            java.lang.String r5 = r5.getName()
            java.lang.String r7 = "java.util.Date"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x004b
            java.lang.Class[] r5 = new java.lang.Class[r2]
            r5[r1] = r3
            java.lang.Class<java.lang.Long> r6 = java.lang.Long.class
            r5[r4] = r6
            goto L_0x0055
        L_0x004b:
            java.lang.Class[] r5 = new java.lang.Class[r2]
            r5[r1] = r3
            java.lang.Class r6 = r6.getType()
            r5[r4] = r6
        L_0x0055:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.crud.DataHandler.getParameterTypes(java.lang.reflect.Field, java.lang.Object, java.lang.Object[]):java.lang.Class[]");
    }

    public String getTableName(Class<?> cls) {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName()));
    }

    public String[] getWhereArgs(String... strArr) {
        if (isAffectAllLines(strArr) || strArr == null || strArr.length <= 1) {
            return null;
        }
        String[] strArr2 = new String[(strArr.length - 1)];
        System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        return strArr2;
    }

    public String getWhereClause(String... strArr) {
        if (!isAffectAllLines(strArr) && strArr != null && strArr.length > 0) {
            return strArr[0];
        }
        return null;
    }

    public String getWhereOfIdsWithOr(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Long longValue : collection) {
            long longValue2 = longValue.longValue();
            if (z) {
                sb.append(" or ");
            }
            sb.append("id = ");
            sb.append(longValue2);
            z = true;
        }
        return BaseUtility.changeCase(sb.toString());
    }

    public void giveBaseObjIdValue(LitePalSupport litePalSupport, long j) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (j > 0) {
            DynamicExecutor.set(litePalSupport, "baseObjId", Long.valueOf(j), LitePalSupport.class);
        }
    }

    public boolean isAffectAllLines(Object... objArr) {
        return objArr != null && objArr.length == 0;
    }

    public String makeGetterMethodName(Field field) {
        String str;
        String name = field.getName();
        if (isPrimitiveBooleanType(field)) {
            if (name.matches("^is[A-Z]{1}.*$")) {
                name = name.substring(2);
            }
            str = "is";
        } else {
            str = "get";
        }
        if (name.matches("^[a-z]{1}[A-Z]{1}.*")) {
            return str + name;
        }
        return str + BaseUtility.capitalize(name);
    }

    public String makeSetterMethodName(Field field) {
        if (isPrimitiveBooleanType(field) && field.getName().matches("^is[A-Z]{1}.*$")) {
            return "set" + field.getName().substring(2);
        } else if (field.getName().matches("^[a-z]{1}[A-Z]{1}.*")) {
            return "set" + field.getName();
        } else {
            return "set" + BaseUtility.capitalize(field.getName());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T mathQuery(java.lang.String r10, java.lang.String[] r11, java.lang.String[] r12, java.lang.Class<T> r13) {
        /*
            r9 = this;
            org.litepal.util.BaseUtility.checkConditionsCorrect(r12)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.mDatabase     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = r9.getWhereClause(r12)     // Catch:{ Exception -> 0x0049 }
            java.lang.String[] r5 = r9.getWhereArgs(r12)     // Catch:{ Exception -> 0x0049 }
            r7 = 0
            r8 = 0
            r6 = 0
            r2 = r10
            r3 = r11
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0049 }
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            if (r11 == 0) goto L_0x0043
            java.lang.Class r11 = r10.getClass()     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            java.lang.String r9 = r9.genGetColumnMethod((java.lang.Class<?>) r13)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            java.lang.Class[] r12 = new java.lang.Class[]{r12}     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            java.lang.reflect.Method r9 = r11.getMethod(r9, r12)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            r11 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            java.lang.Object[] r11 = new java.lang.Object[]{r11}     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            java.lang.Object r0 = r9.invoke(r10, r11)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            goto L_0x0043
        L_0x003d:
            r9 = move-exception
            r0 = r10
            goto L_0x0054
        L_0x0040:
            r9 = move-exception
            r0 = r10
            goto L_0x004a
        L_0x0043:
            r10.close()
            return r0
        L_0x0047:
            r9 = move-exception
            goto L_0x0054
        L_0x0049:
            r9 = move-exception
        L_0x004a:
            org.litepal.exceptions.LitePalSupportException r10 = new org.litepal.exceptions.LitePalSupportException     // Catch:{ all -> 0x0047 }
            java.lang.String r11 = r9.getMessage()     // Catch:{ all -> 0x0047 }
            r10.<init>(r11, r9)     // Catch:{ all -> 0x0047 }
            throw r10     // Catch:{ all -> 0x0047 }
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r0.close()
        L_0x0059:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.crud.DataHandler.mathQuery(java.lang.String, java.lang.String[], java.lang.String[], java.lang.Class):java.lang.Object");
    }

    public void putContentValuesForSave(LitePalSupport litePalSupport, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Object fieldValue = getFieldValue(litePalSupport, field);
        if ("java.util.Date".equals(field.getType().getName())) {
            if (fieldValue != null) {
                fieldValue = Long.valueOf(((Date) fieldValue).getTime());
            } else {
                Column column = (Column) field.getAnnotation(Column.class);
                if (column != null) {
                    String defaultValue = column.defaultValue();
                    if (!defaultValue.isEmpty()) {
                        try {
                            fieldValue = Long.valueOf(Long.parseLong(defaultValue));
                        } catch (NumberFormatException unused) {
                            Log.w(TAG, field + " in " + litePalSupport.getClass() + " with invalid defaultValue. So we use null instead");
                        }
                    }
                }
                if (fieldValue == null) {
                    fieldValue = Long.valueOf(LongCompanionObject.MAX_VALUE);
                }
            }
        }
        if (fieldValue != null) {
            Encrypt encrypt = (Encrypt) field.getAnnotation(Encrypt.class);
            if (encrypt != null && "java.lang.String".equals(field.getType().getName())) {
                fieldValue = encryptValue(encrypt.algorithm(), fieldValue);
            }
            Object[] objArr = {BaseUtility.changeCase(DBUtility.convertToValidColumnName(field.getName())), fieldValue};
            DynamicExecutor.send(contentValues, "put", objArr, contentValues.getClass(), getParameterTypes(field, fieldValue, objArr));
        }
    }

    public void putContentValuesForUpdate(LitePalSupport litePalSupport, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Object fieldValue = getFieldValue(litePalSupport, field);
        if ("java.util.Date".equals(field.getType().getName())) {
            fieldValue = fieldValue != null ? Long.valueOf(((Date) fieldValue).getTime()) : Long.valueOf(LongCompanionObject.MAX_VALUE);
        }
        Encrypt encrypt = (Encrypt) field.getAnnotation(Encrypt.class);
        if (encrypt != null && "java.lang.String".equals(field.getType().getName())) {
            fieldValue = encryptValue(encrypt.algorithm(), fieldValue);
        }
        Object[] objArr = {BaseUtility.changeCase(DBUtility.convertToValidColumnName(field.getName())), fieldValue};
        DynamicExecutor.send(contentValues, "put", objArr, contentValues.getClass(), getParameterTypes(field, fieldValue, objArr));
    }

    public void putFieldsValue(LitePalSupport litePalSupport, List<Field> list, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (Field next : list) {
            if (!isIdColumn(next.getName())) {
                putFieldsValueDependsOnSaveOrUpdate(litePalSupport, next, contentValues);
            }
        }
    }

    public <T> List<T> query(Class<T> cls, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5, List<AssociationsInfo> list) {
        List<AssociationsInfo> list2 = list;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            List<Field> supportedFields = getSupportedFields(cls.getName());
            List<Field> supportedGenericFields = getSupportedGenericFields(cls.getName());
            String[] convertSelectClauseToValidNames = DBUtility.convertSelectClauseToValidNames(getCustomizedColumns(strArr, supportedGenericFields, list2));
            Cursor query = this.mDatabase.query(getTableName(cls), convertSelectClauseToValidNames, str, strArr2, str2, str3, str4, str5);
            if (query.moveToFirst()) {
                SparseArray sparseArray = new SparseArray();
                HashMap hashMap = new HashMap();
                do {
                    Object createInstanceFromClass = createInstanceFromClass(cls);
                    giveBaseObjIdValue((LitePalSupport) createInstanceFromClass, query.getLong(query.getColumnIndexOrThrow("id")));
                    setValueToModel(createInstanceFromClass, supportedFields, list, query, sparseArray);
                    setGenericValueToModel((LitePalSupport) createInstanceFromClass, supportedGenericFields, hashMap);
                    if (list2 != null) {
                        setAssociatedModel((LitePalSupport) createInstanceFromClass);
                    }
                    arrayList.add(createInstanceFromClass);
                } while (query.moveToNext());
                sparseArray.clear();
                hashMap.clear();
            }
            query.close();
            return arrayList;
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void setFieldValue(LitePalSupport litePalSupport, Field field, Object obj) throws SecurityException, IllegalArgumentException, IllegalAccessException {
        if (shouldGetOrSet(litePalSupport, field)) {
            DynamicExecutor.setField(litePalSupport, field.getName(), obj, litePalSupport.getClass());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setGenericValueToModel(org.litepal.crud.LitePalSupport r21, java.util.List<java.lang.reflect.Field> r22, java.util.Map<java.lang.reflect.Field, org.litepal.tablemanager.model.GenericModel> r23) throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r20 = this;
            r0 = r20
            r7 = r23
            java.util.Iterator r8 = r22.iterator()
        L_0x0008:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x00d9
            java.lang.Object r1 = r8.next()
            r9 = r1
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            java.lang.Object r1 = r7.get(r9)
            org.litepal.tablemanager.model.GenericModel r1 = (org.litepal.tablemanager.model.GenericModel) r1
            if (r1 != 0) goto L_0x006a
            java.lang.String r1 = r0.getGenericTypeName(r9)
            java.lang.String r2 = r21.getClassName()
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = org.litepal.util.DBUtility.getM2MSelfRefColumnName(r9)
            java.lang.String r2 = "getLong"
            goto L_0x003e
        L_0x0032:
            java.lang.String r1 = r9.getName()
            java.lang.String r1 = org.litepal.util.DBUtility.convertToValidColumnName(r1)
            java.lang.String r2 = r0.genGetColumnMethod((java.lang.reflect.Field) r9)
        L_0x003e:
            java.lang.String r3 = r21.getClassName()
            java.lang.String r4 = r9.getName()
            java.lang.String r3 = org.litepal.util.DBUtility.getGenericTableName(r3, r4)
            java.lang.String r4 = r21.getClassName()
            java.lang.String r4 = org.litepal.util.DBUtility.getGenericValueIdColumnName(r4)
            org.litepal.tablemanager.model.GenericModel r5 = new org.litepal.tablemanager.model.GenericModel
            r5.<init>()
            r5.setTableName(r3)
            r5.setValueColumnName(r1)
            r5.setValueIdColumnName(r4)
            r5.setGetMethodName(r2)
            r7.put(r9, r5)
            r10 = r1
            r11 = r2
        L_0x0068:
            r13 = r3
            goto L_0x007d
        L_0x006a:
            java.lang.String r3 = r1.getTableName()
            java.lang.String r2 = r1.getValueColumnName()
            java.lang.String r4 = r1.getValueIdColumnName()
            java.lang.String r1 = r1.getGetMethodName()
            r11 = r1
            r10 = r2
            goto L_0x0068
        L_0x007d:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r12 = r0.mDatabase     // Catch:{ all -> 0x00d2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r2.<init>()     // Catch:{ all -> 0x00d2 }
            r2.append(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = " = ?"
            r2.append(r3)     // Catch:{ all -> 0x00d2 }
            java.lang.String r15 = r2.toString()     // Catch:{ all -> 0x00d2 }
            long r2 = r21.getBaseObjId()     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String[] r16 = new java.lang.String[]{r2}     // Catch:{ all -> 0x00d2 }
            r18 = 0
            r19 = 0
            r14 = 0
            r17 = 0
            android.database.Cursor r12 = r12.query(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x00d2 }
            boolean r1 = r12.moveToFirst()     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x00cd
        L_0x00ae:
            java.lang.String r1 = org.litepal.util.BaseUtility.changeCase(r10)     // Catch:{ all -> 0x00c4 }
            int r4 = r12.getColumnIndex(r1)     // Catch:{ all -> 0x00c4 }
            r1 = -1
            if (r4 == r1) goto L_0x00c7
            r1 = r20
            r2 = r21
            r3 = r9
            r5 = r11
            r6 = r12
            r1.setToModelByReflection(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00c4 }
            goto L_0x00c7
        L_0x00c4:
            r0 = move-exception
            r1 = r12
            goto L_0x00d3
        L_0x00c7:
            boolean r1 = r12.moveToNext()     // Catch:{ all -> 0x00c4 }
            if (r1 != 0) goto L_0x00ae
        L_0x00cd:
            r12.close()
            goto L_0x0008
        L_0x00d2:
            r0 = move-exception
        L_0x00d3:
            if (r1 == 0) goto L_0x00d8
            r1.close()
        L_0x00d8:
            throw r0
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.crud.DataHandler.setGenericValueToModel(org.litepal.crud.LitePalSupport, java.util.List, java.util.Map):void");
    }

    public void setValueToModel(Object obj, List<Field> list, List<AssociationsInfo> list2, Cursor cursor, SparseArray<QueryInfoCache> sparseArray) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int size = sparseArray.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                QueryInfoCache queryInfoCache = sparseArray.get(keyAt);
                setToModelByReflection(obj, queryInfoCache.field, keyAt, queryInfoCache.getMethodName, cursor);
            }
        } else {
            for (Field next : list) {
                String genGetColumnMethod = genGetColumnMethod(next);
                int columnIndex = cursor.getColumnIndex(BaseUtility.changeCase(isIdColumn(next.getName()) ? "id" : DBUtility.convertToValidColumnName(next.getName())));
                if (columnIndex != -1) {
                    setToModelByReflection(obj, next, columnIndex, genGetColumnMethod, cursor);
                    QueryInfoCache queryInfoCache2 = new QueryInfoCache();
                    queryInfoCache2.getMethodName = genGetColumnMethod;
                    queryInfoCache2.field = next;
                    sparseArray.put(columnIndex, queryInfoCache2);
                }
            }
        }
        if (list2 != null) {
            for (AssociationsInfo next2 : list2) {
                int columnIndex2 = cursor.getColumnIndex(getForeignKeyColumnName(DBUtility.getTableNameByClassName(next2.getAssociatedClassName())));
                if (columnIndex2 != -1) {
                    try {
                        LitePalSupport litePalSupport = (LitePalSupport) Operator.find(Class.forName(next2.getAssociatedClassName()), cursor.getLong(columnIndex2));
                        if (litePalSupport != null) {
                            setFieldValue((LitePalSupport) obj, next2.getAssociateOtherModelFromSelf(), litePalSupport);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean shouldGetOrSet(LitePalSupport litePalSupport, Field field) {
        return (litePalSupport == null || field == null) ? false : true;
    }

    private String genGetColumnMethod(Class<?> cls) {
        String str;
        if (cls.isPrimitive()) {
            str = BaseUtility.capitalize(cls.getName());
        } else {
            str = cls.getSimpleName();
        }
        String str2 = "get" + str;
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1300054776:
                if (str2.equals("getInteger")) {
                    c = 0;
                    break;
                }
                break;
            case -75629620:
                if (str2.equals("getChar")) {
                    c = 1;
                    break;
                }
                break;
            case -75605980:
                if (str2.equals("getDate")) {
                    c = 2;
                    break;
                }
                break;
            case 1101572082:
                if (str2.equals("getBoolean")) {
                    c = 3;
                    break;
                }
                break;
            case 1554590835:
                if (str2.equals("getCharacter")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 3:
                return "getInt";
            case 1:
            case 4:
                return "getString";
            case 2:
                return "getLong";
            default:
                return str2;
        }
    }

    public String getWhereOfIdsWithOr(long... jArr) {
        StringBuilder sb = new StringBuilder();
        int length = jArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            long j = jArr[i];
            if (z) {
                sb.append(" or ");
            }
            sb.append("id = ");
            sb.append(j);
            i++;
            z = true;
        }
        return BaseUtility.changeCase(sb.toString());
    }
}
