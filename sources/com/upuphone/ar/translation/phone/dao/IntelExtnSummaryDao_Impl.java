package com.upuphone.ar.translation.phone.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import java.util.Collections;
import java.util.List;

public final class IntelExtnSummaryDao_Impl implements IntelExtnSummaryDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f6225a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;
    public final EntityDeletionOrUpdateAdapter d;

    public IntelExtnSummaryDao_Impl(RoomDatabase roomDatabase) {
        this.f6225a = roomDatabase;
        this.b = new EntityInsertionAdapter<IntelExtnSummary>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `IntelExtnSummary` (`id`,`accountId`,`recognizeId`,`requestId`,`summary`,`originalSummary`,`deleteStatus`,`isReported`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, IntelExtnSummary intelExtnSummary) {
                supportSQLiteStatement.F(1, intelExtnSummary.getId());
                supportSQLiteStatement.B(2, intelExtnSummary.getAccountId());
                supportSQLiteStatement.B(3, intelExtnSummary.getRecognizeId());
                supportSQLiteStatement.B(4, intelExtnSummary.getRequestId());
                supportSQLiteStatement.B(5, intelExtnSummary.getSummary());
                supportSQLiteStatement.B(6, intelExtnSummary.getOriginalSummary());
                supportSQLiteStatement.F(7, (long) intelExtnSummary.getDeleteStatus());
                supportSQLiteStatement.F(8, intelExtnSummary.isReported() ? 1 : 0);
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<IntelExtnSummary>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `IntelExtnSummary` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, IntelExtnSummary intelExtnSummary) {
                supportSQLiteStatement.F(1, intelExtnSummary.getId());
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<IntelExtnSummary>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `IntelExtnSummary` SET `id` = ?,`accountId` = ?,`recognizeId` = ?,`requestId` = ?,`summary` = ?,`originalSummary` = ?,`deleteStatus` = ?,`isReported` = ? WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, IntelExtnSummary intelExtnSummary) {
                supportSQLiteStatement.F(1, intelExtnSummary.getId());
                supportSQLiteStatement.B(2, intelExtnSummary.getAccountId());
                supportSQLiteStatement.B(3, intelExtnSummary.getRecognizeId());
                supportSQLiteStatement.B(4, intelExtnSummary.getRequestId());
                supportSQLiteStatement.B(5, intelExtnSummary.getSummary());
                supportSQLiteStatement.B(6, intelExtnSummary.getOriginalSummary());
                supportSQLiteStatement.F(7, (long) intelExtnSummary.getDeleteStatus());
                supportSQLiteStatement.F(8, intelExtnSummary.isReported() ? 1 : 0);
                supportSQLiteStatement.F(9, intelExtnSummary.getId());
            }
        };
    }

    public static List e() {
        return Collections.emptyList();
    }

    public List a(IntelExtnSummary... intelExtnSummaryArr) {
        this.f6225a.assertNotSuspendingTransaction();
        this.f6225a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList((T[]) intelExtnSummaryArr);
            this.f6225a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.f6225a.endTransaction();
        }
    }

    public IntelExtnSummary b(String str, String str2) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM intelextnsummary WHERE accountId = ? AND recognizeId = ?", 2);
        boolean z = true;
        c2.B(1, str);
        c2.B(2, str2);
        this.f6225a.assertNotSuspendingTransaction();
        IntelExtnSummary intelExtnSummary = null;
        Cursor c3 = DBUtil.c(this.f6225a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "recognizeId");
            int d5 = CursorUtil.d(c3, "requestId");
            int d6 = CursorUtil.d(c3, "summary");
            int d7 = CursorUtil.d(c3, "originalSummary");
            int d8 = CursorUtil.d(c3, "deleteStatus");
            int d9 = CursorUtil.d(c3, "isReported");
            if (c3.moveToFirst()) {
                intelExtnSummary = new IntelExtnSummary();
                intelExtnSummary.setId(c3.getLong(d2));
                intelExtnSummary.setAccountId(c3.getString(d3));
                intelExtnSummary.setRecognizeId(c3.getString(d4));
                intelExtnSummary.setRequestId(c3.getString(d5));
                intelExtnSummary.setSummary(c3.getString(d6));
                intelExtnSummary.setOriginalSummary(c3.getString(d7));
                intelExtnSummary.setDeleteStatus(c3.getInt(d8));
                if (c3.getInt(d9) == 0) {
                    z = false;
                }
                intelExtnSummary.setReported(z);
            }
            return intelExtnSummary;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public void c(IntelExtnSummary... intelExtnSummaryArr) {
        this.f6225a.assertNotSuspendingTransaction();
        this.f6225a.beginTransaction();
        try {
            this.d.handleMultiple((T[]) intelExtnSummaryArr);
            this.f6225a.setTransactionSuccessful();
        } finally {
            this.f6225a.endTransaction();
        }
    }

    public void d(IntelExtnSummary... intelExtnSummaryArr) {
        this.f6225a.assertNotSuspendingTransaction();
        this.f6225a.beginTransaction();
        try {
            this.c.handleMultiple((T[]) intelExtnSummaryArr);
            this.f6225a.setTransactionSuccessful();
        } finally {
            this.f6225a.endTransaction();
        }
    }
}
