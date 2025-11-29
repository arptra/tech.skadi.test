package com.share.connect.security;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;

public final class PeerDao_Impl implements PeerDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f9906a;
    public final EntityInsertionAdapter b;
    public final SharedSQLiteStatement c;
    public final SharedSQLiteStatement d;

    public PeerDao_Impl(RoomDatabase roomDatabase) {
        this.f9906a = roomDatabase;
        this.b = new EntityInsertionAdapter<Peer>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Peer` (`id`,`auth_key`,`connection_time`) VALUES (?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Peer peer) {
                String str = peer.f9905a;
                if (str == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, str);
                }
                String str2 = peer.b;
                if (str2 == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, str2);
                }
                supportSQLiteStatement.F(3, peer.c);
            }
        };
        this.c = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE peer SET connection_time= CASE WHEN id=? THEN 1 ELSE 0 END";
            }
        };
        this.d = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM peer WHERE id=?";
            }
        };
    }

    public static List d() {
        return Collections.emptyList();
    }

    public void a(String str) {
        this.f9906a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f9906a.beginTransaction();
        try {
            acquire.k();
            this.f9906a.setTransactionSuccessful();
        } finally {
            this.f9906a.endTransaction();
            this.d.release(acquire);
        }
    }

    public long b(Peer peer) {
        this.f9906a.assertNotSuspendingTransaction();
        this.f9906a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(peer);
            this.f9906a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f9906a.endTransaction();
        }
    }

    public int c(String str) {
        this.f9906a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f9906a.beginTransaction();
        try {
            int k = acquire.k();
            this.f9906a.setTransactionSuccessful();
            return k;
        } finally {
            this.f9906a.endTransaction();
            this.c.release(acquire);
        }
    }

    public Peer get(String str) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM peer WHERE id=?", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        this.f9906a.assertNotSuspendingTransaction();
        Peer peer = null;
        Cursor c3 = DBUtil.c(this.f9906a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "auth_key");
            int d4 = CursorUtil.d(c3, "connection_time");
            if (c3.moveToFirst()) {
                Peer peer2 = new Peer();
                if (c3.isNull(d2)) {
                    peer2.f9905a = null;
                } else {
                    peer2.f9905a = c3.getString(d2);
                }
                if (c3.isNull(d3)) {
                    peer2.b = null;
                } else {
                    peer2.b = c3.getString(d3);
                }
                peer2.c = c3.getLong(d4);
                peer = peer2;
            }
            c3.close();
            c2.release();
            return peer;
        } catch (Throwable th) {
            c3.close();
            c2.release();
            throw th;
        }
    }

    public Peer getLast() {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM peer ORDER BY connection_time DESC LIMIT 1", 0);
        this.f9906a.assertNotSuspendingTransaction();
        Peer peer = null;
        Cursor c3 = DBUtil.c(this.f9906a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "auth_key");
            int d4 = CursorUtil.d(c3, "connection_time");
            if (c3.moveToFirst()) {
                Peer peer2 = new Peer();
                if (c3.isNull(d2)) {
                    peer2.f9905a = null;
                } else {
                    peer2.f9905a = c3.getString(d2);
                }
                if (c3.isNull(d3)) {
                    peer2.b = null;
                } else {
                    peer2.b = c3.getString(d3);
                }
                peer2.c = c3.getLong(d4);
                peer = peer2;
            }
            c3.close();
            c2.release();
            return peer;
        } catch (Throwable th) {
            c3.close();
            c2.release();
            throw th;
        }
    }
}
