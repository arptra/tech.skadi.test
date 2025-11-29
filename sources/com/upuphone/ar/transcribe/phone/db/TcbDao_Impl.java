package com.upuphone.ar.transcribe.phone.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.ar.transcribe.phone.bean.IdTitleBean;
import com.upuphone.ar.transcribe.phone.db.TcbDao;
import com.upuphone.ar.transcribe.phone.db.entity.MessageEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TcbDao_Impl implements TcbDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f6086a;
    public final EntityInsertionAdapter b;
    public final EntityInsertionAdapter c;
    public final EntityDeletionOrUpdateAdapter d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;
    public final SharedSQLiteStatement h;
    public final SharedSQLiteStatement i;

    public TcbDao_Impl(RoomDatabase roomDatabase) {
        this.f6086a = roomDatabase;
        this.b = new EntityInsertionAdapter<TranscribeBean>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `transcribe` (`id`,`transResult`,`recordTime`,`xrType`,`title`,`location`,`type`,`account`,`superTitle`,`title2`,`recognizeId`,`language`,`fullLocation`,`simpleLocation`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TranscribeBean transcribeBean) {
                if (transcribeBean.getId() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.F(1, transcribeBean.getId().longValue());
                }
                if (transcribeBean.getTransResult() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, transcribeBean.getTransResult());
                }
                supportSQLiteStatement.F(3, transcribeBean.getRecordTime());
                supportSQLiteStatement.F(4, (long) transcribeBean.getXrType());
                if (transcribeBean.getTitle() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, transcribeBean.getTitle());
                }
                if (transcribeBean.getLocation() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, transcribeBean.getLocation());
                }
                supportSQLiteStatement.F(7, (long) transcribeBean.getType());
                if (transcribeBean.getAccount() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, transcribeBean.getAccount());
                }
                if (transcribeBean.getSuperTitle() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.B(9, transcribeBean.getSuperTitle());
                }
                if (transcribeBean.getTitle2() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, transcribeBean.getTitle2());
                }
                if (transcribeBean.getRecognizeId() == null) {
                    supportSQLiteStatement.L(11);
                } else {
                    supportSQLiteStatement.B(11, transcribeBean.getRecognizeId());
                }
                if (transcribeBean.getLanguage() == null) {
                    supportSQLiteStatement.L(12);
                } else {
                    supportSQLiteStatement.B(12, transcribeBean.getLanguage());
                }
                if (transcribeBean.getFullLocation() == null) {
                    supportSQLiteStatement.L(13);
                } else {
                    supportSQLiteStatement.B(13, transcribeBean.getFullLocation());
                }
                if (transcribeBean.getSimpleLocation() == null) {
                    supportSQLiteStatement.L(14);
                } else {
                    supportSQLiteStatement.B(14, transcribeBean.getSimpleLocation());
                }
            }
        };
        this.c = new EntityInsertionAdapter<MessageEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `messages` (`id`,`message`,`owner`,`timestamp`,`transcribeId`) VALUES (?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageEntity messageEntity) {
                if (messageEntity.getId() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.F(1, messageEntity.getId().longValue());
                }
                supportSQLiteStatement.B(2, messageEntity.getMessage());
                supportSQLiteStatement.F(3, (long) messageEntity.getOwner());
                supportSQLiteStatement.F(4, messageEntity.getTimestamp());
                supportSQLiteStatement.F(5, messageEntity.getTranscribeId());
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<TranscribeBean>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `transcribe` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TranscribeBean transcribeBean) {
                if (transcribeBean.getId() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.F(1, transcribeBean.getId().longValue());
                }
            }
        };
        this.e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM transcribe Where id = ?";
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE transcribe SET superTitle = ? WHERE id = ?";
            }
        };
        this.g = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE transcribe SET title = ? WHERE id = ?";
            }
        };
        this.h = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE messages SET message = ? WHERE id = ?";
            }
        };
        this.i = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM messages WHERE transcribeId = ?";
            }
        };
    }

    public static List r() {
        return Collections.emptyList();
    }

    public Long[] a(List list) {
        this.f6086a.assertNotSuspendingTransaction();
        this.f6086a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(list);
            this.f6086a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.f6086a.endTransaction();
        }
    }

    public void b(long[] jArr) {
        this.f6086a.assertNotSuspendingTransaction();
        StringBuilder b2 = StringUtil.b();
        b2.append("DELETE FROM transcribe WHERE id in (");
        StringUtil.a(b2, jArr.length);
        b2.append(")");
        SupportSQLiteStatement compileStatement = this.f6086a.compileStatement(b2.toString());
        int i2 = 1;
        for (long F : jArr) {
            compileStatement.F(i2, F);
            i2++;
        }
        this.f6086a.beginTransaction();
        try {
            compileStatement.k();
            this.f6086a.setTransactionSuccessful();
        } finally {
            this.f6086a.endTransaction();
        }
    }

    public void c(long j) {
        this.f6086a.beginTransaction();
        try {
            TcbDao.DefaultImpls.a(this, j);
            this.f6086a.setTransactionSuccessful();
        } finally {
            this.f6086a.endTransaction();
        }
    }

    public int count() {
        int i2 = 0;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT COUNT(*) FROM transcribe", 0);
        this.f6086a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6086a, c2, false, (CancellationSignal) null);
        try {
            if (c3.moveToFirst()) {
                i2 = c3.getInt(0);
            }
            return i2;
        } finally {
            c3.close();
            c2.release();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0091 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b A[Catch:{ all -> 0x00ac }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List d(androidx.sqlite.db.SupportSQLiteQuery r28) {
        /*
            r27 = this;
            r0 = r27
            androidx.room.RoomDatabase r1 = r0.f6086a
            r1.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r0.f6086a
            r1 = 0
            r2 = 0
            r3 = r28
            android.database.Cursor r3 = androidx.room.util.DBUtil.c(r0, r3, r1, r2)
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.CursorUtil.c(r3, r0)     // Catch:{ all -> 0x00ac }
            java.lang.String r4 = "recordTime"
            int r4 = androidx.room.util.CursorUtil.c(r3, r4)     // Catch:{ all -> 0x00ac }
            java.lang.String r5 = "type"
            int r5 = androidx.room.util.CursorUtil.c(r3, r5)     // Catch:{ all -> 0x00ac }
            java.lang.String r6 = "superTitle"
            int r6 = androidx.room.util.CursorUtil.c(r3, r6)     // Catch:{ all -> 0x00ac }
            java.lang.String r7 = "simpleLocation"
            int r7 = androidx.room.util.CursorUtil.c(r3, r7)     // Catch:{ all -> 0x00ac }
            java.lang.String r8 = "messageId"
            int r8 = androidx.room.util.CursorUtil.c(r3, r8)     // Catch:{ all -> 0x00ac }
            java.lang.String r9 = "message"
            int r9 = androidx.room.util.CursorUtil.c(r3, r9)     // Catch:{ all -> 0x00ac }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x00ac }
            int r11 = r3.getCount()     // Catch:{ all -> 0x00ac }
            r10.<init>(r11)     // Catch:{ all -> 0x00ac }
        L_0x0045:
            boolean r11 = r3.moveToNext()     // Catch:{ all -> 0x00ac }
            if (r11 == 0) goto L_0x00ae
            r11 = 0
            r13 = -1
            if (r0 != r13) goto L_0x0053
            r17 = r11
            goto L_0x0059
        L_0x0053:
            long r14 = r3.getLong(r0)     // Catch:{ all -> 0x00ac }
            r17 = r14
        L_0x0059:
            if (r4 != r13) goto L_0x005e
            r19 = r11
            goto L_0x0064
        L_0x005e:
            long r14 = r3.getLong(r4)     // Catch:{ all -> 0x00ac }
            r19 = r14
        L_0x0064:
            if (r5 != r13) goto L_0x0069
            r21 = r1
            goto L_0x006f
        L_0x0069:
            int r14 = r3.getInt(r5)     // Catch:{ all -> 0x00ac }
            r21 = r14
        L_0x006f:
            if (r6 != r13) goto L_0x0074
            r22 = r2
            goto L_0x007a
        L_0x0074:
            java.lang.String r14 = r3.getString(r6)     // Catch:{ all -> 0x00ac }
            r22 = r14
        L_0x007a:
            if (r7 != r13) goto L_0x007f
        L_0x007c:
            r23 = r2
            goto L_0x008c
        L_0x007f:
            boolean r14 = r3.isNull(r7)     // Catch:{ all -> 0x00ac }
            if (r14 == 0) goto L_0x0086
            goto L_0x007c
        L_0x0086:
            java.lang.String r14 = r3.getString(r7)     // Catch:{ all -> 0x00ac }
            r23 = r14
        L_0x008c:
            if (r8 != r13) goto L_0x0091
        L_0x008e:
            r24 = r11
            goto L_0x0096
        L_0x0091:
            long r11 = r3.getLong(r8)     // Catch:{ all -> 0x00ac }
            goto L_0x008e
        L_0x0096:
            if (r9 != r13) goto L_0x009b
            r26 = r2
            goto L_0x00a1
        L_0x009b:
            java.lang.String r11 = r3.getString(r9)     // Catch:{ all -> 0x00ac }
            r26 = r11
        L_0x00a1:
            com.upuphone.ar.transcribe.phone.bean.SearchBean r11 = new com.upuphone.ar.transcribe.phone.bean.SearchBean     // Catch:{ all -> 0x00ac }
            r16 = r11
            r16.<init>(r17, r19, r21, r22, r23, r24, r26)     // Catch:{ all -> 0x00ac }
            r10.add(r11)     // Catch:{ all -> 0x00ac }
            goto L_0x0045
        L_0x00ac:
            r0 = move-exception
            goto L_0x00b2
        L_0x00ae:
            r3.close()
            return r10
        L_0x00b2:
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.db.TcbDao_Impl.d(androidx.sqlite.db.SupportSQLiteQuery):java.util.List");
    }

    public List e(long j) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * From messages WHERE transcribeId = ?", 1);
        c2.F(1, j);
        this.f6086a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6086a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "message");
            int d4 = CursorUtil.d(c3, "owner");
            int d5 = CursorUtil.d(c3, "timestamp");
            int d6 = CursorUtil.d(c3, "transcribeId");
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                arrayList.add(new MessageEntity(c3.isNull(d2) ? null : Long.valueOf(c3.getLong(d2)), c3.getString(d3), c3.getInt(d4), c3.getLong(d5), c3.getLong(d6)));
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public List f(String str, int i2, int i3) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str2;
        int i4;
        int i5;
        String str3;
        String str4 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM transcribe WHERE account = ? OR account IS NULL OR account = '' ORDER BY recordTime DESC LIMIT ? OFFSET ?", 3);
        if (str4 == null) {
            c2.L(1);
        } else {
            c2.B(1, str4);
        }
        c2.F(2, (long) i2);
        c2.F(3, (long) i3);
        this.f6086a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6086a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "transResult");
            int d4 = CursorUtil.d(c3, "recordTime");
            int d5 = CursorUtil.d(c3, "xrType");
            int d6 = CursorUtil.d(c3, "title");
            int d7 = CursorUtil.d(c3, "location");
            int d8 = CursorUtil.d(c3, "type");
            int d9 = CursorUtil.d(c3, "account");
            int d10 = CursorUtil.d(c3, "superTitle");
            int d11 = CursorUtil.d(c3, "title2");
            int d12 = CursorUtil.d(c3, "recognizeId");
            int d13 = CursorUtil.d(c3, "language");
            int d14 = CursorUtil.d(c3, "fullLocation");
            roomSQLiteQuery = c2;
            try {
                int d15 = CursorUtil.d(c3, "simpleLocation");
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    Long valueOf = c3.isNull(d2) ? null : Long.valueOf(c3.getLong(d2));
                    String string = c3.isNull(d3) ? null : c3.getString(d3);
                    long j = c3.getLong(d4);
                    int i6 = c3.getInt(d5);
                    String string2 = c3.isNull(d6) ? null : c3.getString(d6);
                    String string3 = c3.isNull(d7) ? null : c3.getString(d7);
                    int i7 = c3.getInt(d8);
                    String string4 = c3.isNull(d9) ? null : c3.getString(d9);
                    String string5 = c3.isNull(d10) ? null : c3.getString(d10);
                    String string6 = c3.isNull(d11) ? null : c3.getString(d11);
                    String string7 = c3.isNull(d12) ? null : c3.getString(d12);
                    String string8 = c3.isNull(d13) ? null : c3.getString(d13);
                    if (c3.isNull(d14)) {
                        i4 = d15;
                        str2 = null;
                    } else {
                        str2 = c3.getString(d14);
                        i4 = d15;
                    }
                    if (c3.isNull(i4)) {
                        i5 = d2;
                        str3 = null;
                    } else {
                        i5 = d2;
                        str3 = c3.getString(i4);
                    }
                    arrayList.add(new TranscribeBean(valueOf, string, j, i6, string2, string3, i7, string4, string5, string6, string7, string8, str2, str3));
                    d2 = i5;
                    d15 = i4;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public int g(long j, String str) {
        this.f6086a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
        acquire.B(1, str);
        acquire.F(2, j);
        try {
            this.f6086a.beginTransaction();
            int k = acquire.k();
            this.f6086a.setTransactionSuccessful();
            this.f6086a.endTransaction();
            this.f.release(acquire);
            return k;
        } catch (Throwable th) {
            this.f.release(acquire);
            throw th;
        }
    }

    public long h(MessageEntity messageEntity) {
        this.f6086a.assertNotSuspendingTransaction();
        this.f6086a.beginTransaction();
        try {
            long insertAndReturnId = this.c.insertAndReturnId(messageEntity);
            this.f6086a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f6086a.endTransaction();
        }
    }

    public Long[] i(List list) {
        this.f6086a.assertNotSuspendingTransaction();
        this.f6086a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.c.insertAndReturnIdsArrayBox(list);
            this.f6086a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.f6086a.endTransaction();
        }
    }

    public int j(long j) {
        this.f6086a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        acquire.F(1, j);
        try {
            this.f6086a.beginTransaction();
            int k = acquire.k();
            this.f6086a.setTransactionSuccessful();
            this.f6086a.endTransaction();
            this.e.release(acquire);
            return k;
        } catch (Throwable th) {
            this.e.release(acquire);
            throw th;
        }
    }

    public void k(long[] jArr) {
        this.f6086a.assertNotSuspendingTransaction();
        StringBuilder b2 = StringUtil.b();
        b2.append("DELETE from messages WHERE transcribeId in (");
        StringUtil.a(b2, jArr.length);
        b2.append(")");
        SupportSQLiteStatement compileStatement = this.f6086a.compileStatement(b2.toString());
        int i2 = 1;
        for (long F : jArr) {
            compileStatement.F(i2, F);
            i2++;
        }
        this.f6086a.beginTransaction();
        try {
            compileStatement.k();
            this.f6086a.setTransactionSuccessful();
        } finally {
            this.f6086a.endTransaction();
        }
    }

    public void l(long[] jArr) {
        this.f6086a.beginTransaction();
        try {
            TcbDao.DefaultImpls.b(this, jArr);
            this.f6086a.setTransactionSuccessful();
        } finally {
            this.f6086a.endTransaction();
        }
    }

    public void m(long j) {
        this.f6086a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.i.acquire();
        acquire.F(1, j);
        try {
            this.f6086a.beginTransaction();
            acquire.k();
            this.f6086a.setTransactionSuccessful();
            this.f6086a.endTransaction();
            this.i.release(acquire);
        } catch (Throwable th) {
            this.i.release(acquire);
            throw th;
        }
    }

    public TranscribeBean n(long j) {
        TranscribeBean transcribeBean;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM transcribe WHERE id = ?", 1);
        c2.F(1, j);
        this.f6086a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6086a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "transResult");
            int d4 = CursorUtil.d(c3, "recordTime");
            int d5 = CursorUtil.d(c3, "xrType");
            int d6 = CursorUtil.d(c3, "title");
            int d7 = CursorUtil.d(c3, "location");
            int d8 = CursorUtil.d(c3, "type");
            int d9 = CursorUtil.d(c3, "account");
            int d10 = CursorUtil.d(c3, "superTitle");
            int d11 = CursorUtil.d(c3, "title2");
            int d12 = CursorUtil.d(c3, "recognizeId");
            int d13 = CursorUtil.d(c3, "language");
            int d14 = CursorUtil.d(c3, "fullLocation");
            int d15 = CursorUtil.d(c3, "simpleLocation");
            if (c3.moveToFirst()) {
                transcribeBean = new TranscribeBean(c3.isNull(d2) ? null : Long.valueOf(c3.getLong(d2)), c3.isNull(d3) ? null : c3.getString(d3), c3.getLong(d4), c3.getInt(d5), c3.isNull(d6) ? null : c3.getString(d6), c3.isNull(d7) ? null : c3.getString(d7), c3.getInt(d8), c3.isNull(d9) ? null : c3.getString(d9), c3.isNull(d10) ? null : c3.getString(d10), c3.isNull(d11) ? null : c3.getString(d11), c3.isNull(d12) ? null : c3.getString(d12), c3.isNull(d13) ? null : c3.getString(d13), c3.isNull(d14) ? null : c3.getString(d14), c3.isNull(d15) ? null : c3.getString(d15));
            } else {
                transcribeBean = null;
            }
            return transcribeBean;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public long o(TranscribeBean transcribeBean) {
        this.f6086a.assertNotSuspendingTransaction();
        this.f6086a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(transcribeBean);
            this.f6086a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f6086a.endTransaction();
        }
    }

    public int p(long j, String str) {
        this.f6086a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.h.acquire();
        acquire.B(1, str);
        acquire.F(2, j);
        try {
            this.f6086a.beginTransaction();
            int k = acquire.k();
            this.f6086a.setTransactionSuccessful();
            this.f6086a.endTransaction();
            this.h.release(acquire);
            return k;
        } catch (Throwable th) {
            this.h.release(acquire);
            throw th;
        }
    }

    public List q(String str) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT id, superTitle From transcribe WHERE account = ? OR account IS NULL OR account = ''", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        this.f6086a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6086a, c2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                arrayList.add(new IdTitleBean(c3.isNull(0) ? null : Long.valueOf(c3.getLong(0)), c3.isNull(1) ? null : c3.getString(1)));
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }
}
