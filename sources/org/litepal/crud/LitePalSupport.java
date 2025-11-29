package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.Operator;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class LitePalSupport {
    protected static final String AES = "AES";
    protected static final String MD5 = "MD5";
    Map<String, List<Long>> associatedModelsMapForJoinTable;
    private Map<String, Set<Long>> associatedModelsMapWithFK;
    private Map<String, Long> associatedModelsMapWithoutFK;
    long baseObjId;
    private List<String> fieldsToSetToDefault;
    private List<String> listToClearAssociatedFK;
    private List<String> listToClearSelfFK;

    private void clearFKNameList() {
        getListToClearSelfFK().clear();
        getListToClearAssociatedFK().clear();
    }

    private void clearIdOfModelForJoinTable() {
        for (String str : getAssociatedModelsMapForJoinTable().keySet()) {
            this.associatedModelsMapForJoinTable.get(str).clear();
        }
        this.associatedModelsMapForJoinTable.clear();
    }

    private void clearIdOfModelWithFK() {
        for (String str : getAssociatedModelsMapWithFK().keySet()) {
            this.associatedModelsMapWithFK.get(str).clear();
        }
        this.associatedModelsMapWithFK.clear();
    }

    private void clearIdOfModelWithoutFK() {
        getAssociatedModelsMapWithoutFK().clear();
    }

    public void addAssociatedModelForJoinTable(String str, long j) {
        List list = getAssociatedModelsMapForJoinTable().get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            this.associatedModelsMapForJoinTable.put(str, arrayList);
            return;
        }
        list.add(Long.valueOf(j));
    }

    public void addAssociatedModelWithFK(String str, long j) {
        Set set = getAssociatedModelsMapWithFK().get(str);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j));
            this.associatedModelsMapWithFK.put(str, hashSet);
            return;
        }
        set.add(Long.valueOf(j));
    }

    public void addAssociatedModelWithoutFK(String str, long j) {
        getAssociatedModelsMapWithoutFK().put(str, Long.valueOf(j));
    }

    public void addAssociatedTableNameToClearFK(String str) {
        List<String> listToClearAssociatedFK2 = getListToClearAssociatedFK();
        if (!listToClearAssociatedFK2.contains(str)) {
            listToClearAssociatedFK2.add(str);
        }
    }

    public void addEmptyModelForJoinTable(String str) {
        if (getAssociatedModelsMapForJoinTable().get(str) == null) {
            this.associatedModelsMapForJoinTable.put(str, new ArrayList());
        }
    }

    public void addFKNameToClearSelf(String str) {
        List<String> listToClearSelfFK2 = getListToClearSelfFK();
        if (!listToClearSelfFK2.contains(str)) {
            listToClearSelfFK2.add(str);
        }
    }

    public void assignBaseObjId(long j) {
        this.baseObjId = j;
    }

    public void clearAssociatedData() {
        clearIdOfModelWithFK();
        clearIdOfModelWithoutFK();
        clearIdOfModelForJoinTable();
        clearFKNameList();
    }

    public void clearSavedState() {
        this.baseObjId = 0;
    }

    public int delete() {
        SQLiteDatabase database;
        int onDelete;
        synchronized (LitePalSupport.class) {
            try {
                database = Connector.getDatabase();
                database.beginTransaction();
                onDelete = new DeleteHandler(database).onDelete(this);
                this.baseObjId = 0;
                database.setTransactionSuccessful();
                database.endTransaction();
            } catch (Throwable th) {
                throw th;
            }
        }
        return onDelete;
    }

    @Deprecated
    public UpdateOrDeleteExecutor deleteAsync() {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    try {
                        final int delete = LitePalSupport.this.delete();
                        if (updateOrDeleteExecutor.getListener() != null) {
                            Operator.getHandler().post(new Runnable() {
                                public void run() {
                                    updateOrDeleteExecutor.getListener().onFinish(delete);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    public Map<String, List<Long>> getAssociatedModelsMapForJoinTable() {
        if (this.associatedModelsMapForJoinTable == null) {
            this.associatedModelsMapForJoinTable = new HashMap();
        }
        return this.associatedModelsMapForJoinTable;
    }

    public Map<String, Set<Long>> getAssociatedModelsMapWithFK() {
        if (this.associatedModelsMapWithFK == null) {
            this.associatedModelsMapWithFK = new HashMap();
        }
        return this.associatedModelsMapWithFK;
    }

    public Map<String, Long> getAssociatedModelsMapWithoutFK() {
        if (this.associatedModelsMapWithoutFK == null) {
            this.associatedModelsMapWithoutFK = new HashMap();
        }
        return this.associatedModelsMapWithoutFK;
    }

    public long getBaseObjId() {
        return this.baseObjId;
    }

    public String getClassName() {
        return getClass().getName();
    }

    public List<String> getFieldsToSetToDefault() {
        if (this.fieldsToSetToDefault == null) {
            this.fieldsToSetToDefault = new ArrayList();
        }
        return this.fieldsToSetToDefault;
    }

    public List<String> getListToClearAssociatedFK() {
        if (this.listToClearAssociatedFK == null) {
            this.listToClearAssociatedFK = new ArrayList();
        }
        return this.listToClearAssociatedFK;
    }

    public List<String> getListToClearSelfFK() {
        if (this.listToClearSelfFK == null) {
            this.listToClearSelfFK = new ArrayList();
        }
        return this.listToClearSelfFK;
    }

    public String getTableName() {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(getClassName()));
    }

    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    public boolean save() {
        try {
            saveThrows();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public SaveExecutor saveAsync() {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    try {
                        final boolean save = LitePalSupport.this.save();
                        if (saveExecutor.getListener() != null) {
                            Operator.getHandler().post(new Runnable() {
                                public void run() {
                                    saveExecutor.getListener().onFinish(save);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        return saveExecutor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0067, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0069, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0005, B:29:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean saveOrUpdate(java.lang.String... r5) {
        /*
            r4 = this;
            java.lang.Class<org.litepal.crud.LitePalSupport> r0 = org.litepal.crud.LitePalSupport.class
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000d
            boolean r4 = r4.save()     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return r4
        L_0x000b:
            r4 = move-exception
            goto L_0x0068
        L_0x000d:
            org.litepal.FluentQuery r5 = org.litepal.Operator.where(r5)     // Catch:{ all -> 0x000b }
            java.lang.Class r1 = r4.getClass()     // Catch:{ all -> 0x000b }
            java.util.List r5 = r5.find(r1)     // Catch:{ all -> 0x000b }
            boolean r1 = r5.isEmpty()     // Catch:{ all -> 0x000b }
            if (r1 == 0) goto L_0x0025
            boolean r4 = r4.save()     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return r4
        L_0x0025:
            android.database.sqlite.SQLiteDatabase r1 = org.litepal.tablemanager.Connector.getDatabase()     // Catch:{ all -> 0x000b }
            r1.beginTransaction()     // Catch:{ all -> 0x000b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0050 }
        L_0x0030:
            boolean r2 = r5.hasNext()     // Catch:{ Exception -> 0x0050 }
            if (r2 == 0) goto L_0x0052
            java.lang.Object r2 = r5.next()     // Catch:{ Exception -> 0x0050 }
            org.litepal.crud.LitePalSupport r2 = (org.litepal.crud.LitePalSupport) r2     // Catch:{ Exception -> 0x0050 }
            long r2 = r2.getBaseObjId()     // Catch:{ Exception -> 0x0050 }
            r4.baseObjId = r2     // Catch:{ Exception -> 0x0050 }
            org.litepal.crud.SaveHandler r2 = new org.litepal.crud.SaveHandler     // Catch:{ Exception -> 0x0050 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0050 }
            r2.onSave(r4)     // Catch:{ Exception -> 0x0050 }
            r4.clearAssociatedData()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0030
        L_0x004e:
            r4 = move-exception
            goto L_0x0064
        L_0x0050:
            r4 = move-exception
            goto L_0x005b
        L_0x0052:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x0050 }
            r1.endTransaction()     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            r4 = 1
            return r4
        L_0x005b:
            r4.printStackTrace()     // Catch:{ all -> 0x004e }
            r1.endTransaction()     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            r4 = 0
            return r4
        L_0x0064:
            r1.endTransaction()     // Catch:{ all -> 0x000b }
            throw r4     // Catch:{ all -> 0x000b }
        L_0x0068:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.crud.LitePalSupport.saveOrUpdate(java.lang.String[]):boolean");
    }

    @Deprecated
    public SaveExecutor saveOrUpdateAsync(final String... strArr) {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    try {
                        final boolean saveOrUpdate = LitePalSupport.this.saveOrUpdate(strArr);
                        if (saveExecutor.getListener() != null) {
                            Operator.getHandler().post(new Runnable() {
                                public void run() {
                                    saveExecutor.getListener().onFinish(saveOrUpdate);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        return saveExecutor;
    }

    public void saveThrows() {
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                new SaveHandler(database).onSave(this);
                clearAssociatedData();
                database.setTransactionSuccessful();
                database.endTransaction();
            } catch (Exception e) {
                throw new LitePalSupportException(e.getMessage(), e);
            } catch (Throwable th) {
                database.endTransaction();
                throw th;
            }
        }
    }

    public void setToDefault(String str) {
        getFieldsToSetToDefault().add(str);
    }

    public int update(long j) {
        int onUpdate;
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                onUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(this, j);
                getFieldsToSetToDefault().clear();
                database.setTransactionSuccessful();
                database.endTransaction();
            } catch (Exception e) {
                throw new LitePalSupportException(e.getMessage(), e);
            } catch (Throwable th) {
                database.endTransaction();
                throw th;
            }
        }
        return onUpdate;
    }

    public int updateAll(String... strArr) {
        int onUpdateAll;
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                onUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(this, strArr);
                getFieldsToSetToDefault().clear();
                database.setTransactionSuccessful();
                database.endTransaction();
            } catch (Exception e) {
                throw new LitePalSupportException(e.getMessage(), e);
            } catch (Throwable th) {
                database.endTransaction();
                throw th;
            }
        }
        return onUpdateAll;
    }

    @Deprecated
    public UpdateOrDeleteExecutor updateAllAsync(final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    try {
                        final int updateAll = LitePalSupport.this.updateAll(strArr);
                        if (updateOrDeleteExecutor.getListener() != null) {
                            Operator.getHandler().post(new Runnable() {
                                public void run() {
                                    updateOrDeleteExecutor.getListener().onFinish(updateAll);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    @Deprecated
    public UpdateOrDeleteExecutor updateAsync(final long j) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    try {
                        final int update = LitePalSupport.this.update(j);
                        if (updateOrDeleteExecutor.getListener() != null) {
                            Operator.getHandler().post(new Runnable() {
                                public void run() {
                                    updateOrDeleteExecutor.getListener().onFinish(update);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }
}
