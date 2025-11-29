package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2167a;

    /* renamed from: androidx.work.impl.model.RawWorkInfoDao_Impl$1  reason: invalid class name */
    class AnonymousClass1 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SupportSQLiteQuery f2168a;
        public final /* synthetic */ RawWorkInfoDao_Impl b;

        /* JADX WARNING: Removed duplicated region for block: B:101:0x023c A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x0245 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0255 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x025e A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x026e A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x0275 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x0278 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x029e A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x02b1 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0124 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0127 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0133 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0136 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x014c A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x014f A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0155 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0158 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x015e A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0161 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0167 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x016a A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0172 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0175 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0181 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0184 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x018a A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x018f A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0197 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01a0 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x01a7 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x01b0 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x01b9 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01c2 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x01c9 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01d2 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01db A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01e4 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x01f1 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01fa A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x020a A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0213 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0223 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x022c A[Catch:{ all -> 0x00d1 }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List call() {
            /*
                r63 = this;
                r0 = r63
                androidx.work.impl.model.RawWorkInfoDao_Impl r1 = r0.b
                androidx.room.RoomDatabase r1 = r1.f2167a
                androidx.sqlite.db.SupportSQLiteQuery r2 = r0.f2168a
                r3 = 1
                r4 = 0
                android.database.Cursor r1 = androidx.room.util.DBUtil.c(r1, r2, r3, r4)
                java.lang.String r2 = "id"
                int r2 = androidx.room.util.CursorUtil.c(r1, r2)     // Catch:{ all -> 0x00d1 }
                java.lang.String r5 = "state"
                int r5 = androidx.room.util.CursorUtil.c(r1, r5)     // Catch:{ all -> 0x00d1 }
                java.lang.String r6 = "output"
                int r6 = androidx.room.util.CursorUtil.c(r1, r6)     // Catch:{ all -> 0x00d1 }
                java.lang.String r7 = "initial_delay"
                int r7 = androidx.room.util.CursorUtil.c(r1, r7)     // Catch:{ all -> 0x00d1 }
                java.lang.String r8 = "interval_duration"
                int r8 = androidx.room.util.CursorUtil.c(r1, r8)     // Catch:{ all -> 0x00d1 }
                java.lang.String r9 = "flex_duration"
                int r9 = androidx.room.util.CursorUtil.c(r1, r9)     // Catch:{ all -> 0x00d1 }
                java.lang.String r10 = "run_attempt_count"
                int r10 = androidx.room.util.CursorUtil.c(r1, r10)     // Catch:{ all -> 0x00d1 }
                java.lang.String r11 = "backoff_policy"
                int r11 = androidx.room.util.CursorUtil.c(r1, r11)     // Catch:{ all -> 0x00d1 }
                java.lang.String r12 = "backoff_delay_duration"
                int r12 = androidx.room.util.CursorUtil.c(r1, r12)     // Catch:{ all -> 0x00d1 }
                java.lang.String r13 = "last_enqueue_time"
                int r13 = androidx.room.util.CursorUtil.c(r1, r13)     // Catch:{ all -> 0x00d1 }
                java.lang.String r14 = "period_count"
                int r14 = androidx.room.util.CursorUtil.c(r1, r14)     // Catch:{ all -> 0x00d1 }
                java.lang.String r15 = "generation"
                int r15 = androidx.room.util.CursorUtil.c(r1, r15)     // Catch:{ all -> 0x00d1 }
                java.lang.String r3 = "next_schedule_time_override"
                int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d1 }
                java.lang.String r4 = "stop_reason"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r16 = r4
                java.lang.String r4 = "required_network_type"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r17 = r4
                java.lang.String r4 = "requires_charging"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r18 = r4
                java.lang.String r4 = "requires_device_idle"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r19 = r4
                java.lang.String r4 = "requires_battery_not_low"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r20 = r4
                java.lang.String r4 = "requires_storage_not_low"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r21 = r4
                java.lang.String r4 = "trigger_content_update_delay"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r22 = r4
                java.lang.String r4 = "trigger_max_content_delay"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r23 = r4
                java.lang.String r4 = "content_uri_triggers"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r24 = r4
                java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
                r4.<init>()     // Catch:{ all -> 0x00d1 }
                r25 = r3
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
                r3.<init>()     // Catch:{ all -> 0x00d1 }
            L_0x00b2:
                boolean r26 = r1.moveToNext()     // Catch:{ all -> 0x00d1 }
                if (r26 == 0) goto L_0x00ef
                r26 = r15
                java.lang.String r15 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                java.lang.Object r27 = r4.get(r15)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x00d1 }
                if (r27 != 0) goto L_0x00d4
                r27 = r14
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                r14.<init>()     // Catch:{ all -> 0x00d1 }
                r4.put(r15, r14)     // Catch:{ all -> 0x00d1 }
                goto L_0x00d6
            L_0x00d1:
                r0 = move-exception
                goto L_0x02f7
            L_0x00d4:
                r27 = r14
            L_0x00d6:
                java.lang.String r14 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                java.lang.Object r15 = r3.get(r14)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r15 = (java.util.ArrayList) r15     // Catch:{ all -> 0x00d1 }
                if (r15 != 0) goto L_0x00ea
                java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                r15.<init>()     // Catch:{ all -> 0x00d1 }
                r3.put(r14, r15)     // Catch:{ all -> 0x00d1 }
            L_0x00ea:
                r15 = r26
                r14 = r27
                goto L_0x00b2
            L_0x00ef:
                r27 = r14
                r26 = r15
                r14 = -1
                r1.moveToPosition(r14)     // Catch:{ all -> 0x00d1 }
                androidx.work.impl.model.RawWorkInfoDao_Impl r15 = r0.b     // Catch:{ all -> 0x00d1 }
                r15.c(r4)     // Catch:{ all -> 0x00d1 }
                androidx.work.impl.model.RawWorkInfoDao_Impl r0 = r0.b     // Catch:{ all -> 0x00d1 }
                r0.b(r3)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                int r15 = r1.getCount()     // Catch:{ all -> 0x00d1 }
                r0.<init>(r15)     // Catch:{ all -> 0x00d1 }
            L_0x010a:
                boolean r15 = r1.moveToNext()     // Catch:{ all -> 0x00d1 }
                if (r15 == 0) goto L_0x02f3
                if (r2 != r14) goto L_0x0115
            L_0x0112:
                r29 = 0
                goto L_0x0122
            L_0x0115:
                boolean r15 = r1.isNull(r2)     // Catch:{ all -> 0x00d1 }
                if (r15 == 0) goto L_0x011c
                goto L_0x0112
            L_0x011c:
                java.lang.String r15 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                r29 = r15
            L_0x0122:
                if (r5 != r14) goto L_0x0127
                r30 = 0
                goto L_0x0131
            L_0x0127:
                int r15 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                androidx.work.WorkInfo$State r15 = androidx.work.impl.model.WorkTypeConverters.f(r15)     // Catch:{ all -> 0x00d1 }
                r30 = r15
            L_0x0131:
                if (r6 != r14) goto L_0x0136
                r31 = 0
                goto L_0x0148
            L_0x0136:
                boolean r15 = r1.isNull(r6)     // Catch:{ all -> 0x00d1 }
                if (r15 == 0) goto L_0x013e
                r15 = 0
                goto L_0x0142
            L_0x013e:
                byte[] r15 = r1.getBlob(r6)     // Catch:{ all -> 0x00d1 }
            L_0x0142:
                androidx.work.Data r15 = androidx.work.Data.g(r15)     // Catch:{ all -> 0x00d1 }
                r31 = r15
            L_0x0148:
                r32 = 0
                if (r7 != r14) goto L_0x014f
                r34 = r32
                goto L_0x0153
            L_0x014f:
                long r34 = r1.getLong(r7)     // Catch:{ all -> 0x00d1 }
            L_0x0153:
                if (r8 != r14) goto L_0x0158
                r36 = r32
                goto L_0x015c
            L_0x0158:
                long r36 = r1.getLong(r8)     // Catch:{ all -> 0x00d1 }
            L_0x015c:
                if (r9 != r14) goto L_0x0161
                r38 = r32
                goto L_0x0165
            L_0x0161:
                long r38 = r1.getLong(r9)     // Catch:{ all -> 0x00d1 }
            L_0x0165:
                if (r10 != r14) goto L_0x016a
                r40 = 0
                goto L_0x0170
            L_0x016a:
                int r28 = r1.getInt(r10)     // Catch:{ all -> 0x00d1 }
                r40 = r28
            L_0x0170:
                if (r11 != r14) goto L_0x0175
                r41 = 0
                goto L_0x017f
            L_0x0175:
                int r28 = r1.getInt(r11)     // Catch:{ all -> 0x00d1 }
                androidx.work.BackoffPolicy r28 = androidx.work.impl.model.WorkTypeConverters.c(r28)     // Catch:{ all -> 0x00d1 }
                r41 = r28
            L_0x017f:
                if (r12 != r14) goto L_0x0184
                r42 = r32
                goto L_0x0188
            L_0x0184:
                long r42 = r1.getLong(r12)     // Catch:{ all -> 0x00d1 }
            L_0x0188:
                if (r13 != r14) goto L_0x018f
                r15 = r27
                r44 = r32
                goto L_0x0195
            L_0x018f:
                long r44 = r1.getLong(r13)     // Catch:{ all -> 0x00d1 }
                r15 = r27
            L_0x0195:
                if (r15 != r14) goto L_0x01a0
                r27 = 0
            L_0x0199:
                r62 = r26
                r26 = r5
                r5 = r62
                goto L_0x01a5
            L_0x01a0:
                int r27 = r1.getInt(r15)     // Catch:{ all -> 0x00d1 }
                goto L_0x0199
            L_0x01a5:
                if (r5 != r14) goto L_0x01b0
                r46 = 0
            L_0x01a9:
                r62 = r25
                r25 = r5
                r5 = r62
                goto L_0x01b7
            L_0x01b0:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                r46 = r28
                goto L_0x01a9
            L_0x01b7:
                if (r5 != r14) goto L_0x01c2
                r47 = r32
            L_0x01bb:
                r62 = r16
                r16 = r5
                r5 = r62
                goto L_0x01c7
            L_0x01c2:
                long r47 = r1.getLong(r5)     // Catch:{ all -> 0x00d1 }
                goto L_0x01bb
            L_0x01c7:
                if (r5 != r14) goto L_0x01d2
                r49 = 0
            L_0x01cb:
                r62 = r17
                r17 = r5
                r5 = r62
                goto L_0x01d9
            L_0x01d2:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                r49 = r28
                goto L_0x01cb
            L_0x01d9:
                if (r5 != r14) goto L_0x01e4
                r51 = 0
            L_0x01dd:
                r62 = r18
                r18 = r5
                r5 = r62
                goto L_0x01ef
            L_0x01e4:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                androidx.work.NetworkType r28 = androidx.work.impl.model.WorkTypeConverters.d(r28)     // Catch:{ all -> 0x00d1 }
                r51 = r28
                goto L_0x01dd
            L_0x01ef:
                if (r5 != r14) goto L_0x01fa
                r52 = 0
            L_0x01f3:
                r62 = r19
                r19 = r5
                r5 = r62
                goto L_0x0208
            L_0x01fa:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x0203
                r28 = 1
                goto L_0x0205
            L_0x0203:
                r28 = 0
            L_0x0205:
                r52 = r28
                goto L_0x01f3
            L_0x0208:
                if (r5 != r14) goto L_0x0213
                r53 = 0
            L_0x020c:
                r62 = r20
                r20 = r5
                r5 = r62
                goto L_0x0221
            L_0x0213:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x021c
                r28 = 1
                goto L_0x021e
            L_0x021c:
                r28 = 0
            L_0x021e:
                r53 = r28
                goto L_0x020c
            L_0x0221:
                if (r5 != r14) goto L_0x022c
                r54 = 0
            L_0x0225:
                r62 = r21
                r21 = r5
                r5 = r62
                goto L_0x023a
            L_0x022c:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x0235
                r28 = 1
                goto L_0x0237
            L_0x0235:
                r28 = 0
            L_0x0237:
                r54 = r28
                goto L_0x0225
            L_0x023a:
                if (r5 != r14) goto L_0x0245
                r55 = 0
            L_0x023e:
                r62 = r22
                r22 = r5
                r5 = r62
                goto L_0x0253
            L_0x0245:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x024e
                r28 = 1
                goto L_0x0250
            L_0x024e:
                r28 = 0
            L_0x0250:
                r55 = r28
                goto L_0x023e
            L_0x0253:
                if (r5 != r14) goto L_0x025e
                r56 = r32
            L_0x0257:
                r62 = r23
                r23 = r5
                r5 = r62
                goto L_0x0263
            L_0x025e:
                long r56 = r1.getLong(r5)     // Catch:{ all -> 0x00d1 }
                goto L_0x0257
            L_0x0263:
                if (r5 != r14) goto L_0x026e
            L_0x0265:
                r58 = r32
                r62 = r24
                r24 = r5
                r5 = r62
                goto L_0x0273
            L_0x026e:
                long r32 = r1.getLong(r5)     // Catch:{ all -> 0x00d1 }
                goto L_0x0265
            L_0x0273:
                if (r5 != r14) goto L_0x0278
                r60 = 0
                goto L_0x028b
            L_0x0278:
                boolean r28 = r1.isNull(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x0281
                r28 = 0
                goto L_0x0285
            L_0x0281:
                byte[] r28 = r1.getBlob(r5)     // Catch:{ all -> 0x00d1 }
            L_0x0285:
                java.util.Set r28 = androidx.work.impl.model.WorkTypeConverters.b(r28)     // Catch:{ all -> 0x00d1 }
                r60 = r28
            L_0x028b:
                androidx.work.Constraints r61 = new androidx.work.Constraints     // Catch:{ all -> 0x00d1 }
                r50 = r61
                r50.<init>(r51, r52, r53, r54, r55, r56, r58, r60)     // Catch:{ all -> 0x00d1 }
                java.lang.String r14 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                java.lang.Object r14 = r4.get(r14)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d1 }
                if (r14 != 0) goto L_0x02a3
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                r14.<init>()     // Catch:{ all -> 0x00d1 }
            L_0x02a3:
                r50 = r14
                java.lang.String r14 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                java.lang.Object r14 = r3.get(r14)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d1 }
                if (r14 != 0) goto L_0x02b6
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                r14.<init>()     // Catch:{ all -> 0x00d1 }
            L_0x02b6:
                r51 = r14
                androidx.work.impl.model.WorkSpec$WorkInfoPojo r14 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00d1 }
                r28 = r14
                r32 = r34
                r34 = r36
                r36 = r38
                r38 = r61
                r39 = r40
                r40 = r41
                r41 = r42
                r43 = r44
                r45 = r27
                r28.<init>(r29, r30, r31, r32, r34, r36, r38, r39, r40, r41, r43, r45, r46, r47, r49, r50, r51)     // Catch:{ all -> 0x00d1 }
                r0.add(r14)     // Catch:{ all -> 0x00d1 }
                r27 = r15
                r14 = -1
                r62 = r24
                r24 = r5
                r5 = r26
                r26 = r25
                r25 = r16
                r16 = r17
                r17 = r18
                r18 = r19
                r19 = r20
                r20 = r21
                r21 = r22
                r22 = r23
                r23 = r62
                goto L_0x010a
            L_0x02f3:
                r1.close()
                return r0
            L_0x02f7:
                r1.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.RawWorkInfoDao_Impl.AnonymousClass1.call():java.util.List");
        }
    }

    /* renamed from: androidx.work.impl.model.RawWorkInfoDao_Impl$2  reason: invalid class name */
    class AnonymousClass2 implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SupportSQLiteQuery f2169a;
        public final /* synthetic */ RawWorkInfoDao_Impl b;

        /* JADX WARNING: Removed duplicated region for block: B:101:0x023c A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x0245 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0255 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x025e A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x026e A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x0275 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x0278 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x029e A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x02b1 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0124 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0127 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0133 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0136 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x014c A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x014f A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0155 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0158 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x015e A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0161 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0167 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x016a A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0172 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0175 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0181 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0184 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x018a A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x018f A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0197 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01a0 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x01a7 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x01b0 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x01b9 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01c2 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x01c9 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01d2 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01db A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01e4 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x01f1 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01fa A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x020a A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0213 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0223 A[Catch:{ all -> 0x00d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x022c A[Catch:{ all -> 0x00d1 }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List call() {
            /*
                r63 = this;
                r0 = r63
                androidx.work.impl.model.RawWorkInfoDao_Impl r1 = r0.b
                androidx.room.RoomDatabase r1 = r1.f2167a
                androidx.sqlite.db.SupportSQLiteQuery r2 = r0.f2169a
                r3 = 1
                r4 = 0
                android.database.Cursor r1 = androidx.room.util.DBUtil.c(r1, r2, r3, r4)
                java.lang.String r2 = "id"
                int r2 = androidx.room.util.CursorUtil.c(r1, r2)     // Catch:{ all -> 0x00d1 }
                java.lang.String r5 = "state"
                int r5 = androidx.room.util.CursorUtil.c(r1, r5)     // Catch:{ all -> 0x00d1 }
                java.lang.String r6 = "output"
                int r6 = androidx.room.util.CursorUtil.c(r1, r6)     // Catch:{ all -> 0x00d1 }
                java.lang.String r7 = "initial_delay"
                int r7 = androidx.room.util.CursorUtil.c(r1, r7)     // Catch:{ all -> 0x00d1 }
                java.lang.String r8 = "interval_duration"
                int r8 = androidx.room.util.CursorUtil.c(r1, r8)     // Catch:{ all -> 0x00d1 }
                java.lang.String r9 = "flex_duration"
                int r9 = androidx.room.util.CursorUtil.c(r1, r9)     // Catch:{ all -> 0x00d1 }
                java.lang.String r10 = "run_attempt_count"
                int r10 = androidx.room.util.CursorUtil.c(r1, r10)     // Catch:{ all -> 0x00d1 }
                java.lang.String r11 = "backoff_policy"
                int r11 = androidx.room.util.CursorUtil.c(r1, r11)     // Catch:{ all -> 0x00d1 }
                java.lang.String r12 = "backoff_delay_duration"
                int r12 = androidx.room.util.CursorUtil.c(r1, r12)     // Catch:{ all -> 0x00d1 }
                java.lang.String r13 = "last_enqueue_time"
                int r13 = androidx.room.util.CursorUtil.c(r1, r13)     // Catch:{ all -> 0x00d1 }
                java.lang.String r14 = "period_count"
                int r14 = androidx.room.util.CursorUtil.c(r1, r14)     // Catch:{ all -> 0x00d1 }
                java.lang.String r15 = "generation"
                int r15 = androidx.room.util.CursorUtil.c(r1, r15)     // Catch:{ all -> 0x00d1 }
                java.lang.String r3 = "next_schedule_time_override"
                int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d1 }
                java.lang.String r4 = "stop_reason"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r16 = r4
                java.lang.String r4 = "required_network_type"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r17 = r4
                java.lang.String r4 = "requires_charging"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r18 = r4
                java.lang.String r4 = "requires_device_idle"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r19 = r4
                java.lang.String r4 = "requires_battery_not_low"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r20 = r4
                java.lang.String r4 = "requires_storage_not_low"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r21 = r4
                java.lang.String r4 = "trigger_content_update_delay"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r22 = r4
                java.lang.String r4 = "trigger_max_content_delay"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r23 = r4
                java.lang.String r4 = "content_uri_triggers"
                int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d1 }
                r24 = r4
                java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
                r4.<init>()     // Catch:{ all -> 0x00d1 }
                r25 = r3
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
                r3.<init>()     // Catch:{ all -> 0x00d1 }
            L_0x00b2:
                boolean r26 = r1.moveToNext()     // Catch:{ all -> 0x00d1 }
                if (r26 == 0) goto L_0x00ef
                r26 = r15
                java.lang.String r15 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                java.lang.Object r27 = r4.get(r15)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x00d1 }
                if (r27 != 0) goto L_0x00d4
                r27 = r14
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                r14.<init>()     // Catch:{ all -> 0x00d1 }
                r4.put(r15, r14)     // Catch:{ all -> 0x00d1 }
                goto L_0x00d6
            L_0x00d1:
                r0 = move-exception
                goto L_0x02f7
            L_0x00d4:
                r27 = r14
            L_0x00d6:
                java.lang.String r14 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                java.lang.Object r15 = r3.get(r14)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r15 = (java.util.ArrayList) r15     // Catch:{ all -> 0x00d1 }
                if (r15 != 0) goto L_0x00ea
                java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                r15.<init>()     // Catch:{ all -> 0x00d1 }
                r3.put(r14, r15)     // Catch:{ all -> 0x00d1 }
            L_0x00ea:
                r15 = r26
                r14 = r27
                goto L_0x00b2
            L_0x00ef:
                r27 = r14
                r26 = r15
                r14 = -1
                r1.moveToPosition(r14)     // Catch:{ all -> 0x00d1 }
                androidx.work.impl.model.RawWorkInfoDao_Impl r15 = r0.b     // Catch:{ all -> 0x00d1 }
                r15.c(r4)     // Catch:{ all -> 0x00d1 }
                androidx.work.impl.model.RawWorkInfoDao_Impl r0 = r0.b     // Catch:{ all -> 0x00d1 }
                r0.b(r3)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                int r15 = r1.getCount()     // Catch:{ all -> 0x00d1 }
                r0.<init>(r15)     // Catch:{ all -> 0x00d1 }
            L_0x010a:
                boolean r15 = r1.moveToNext()     // Catch:{ all -> 0x00d1 }
                if (r15 == 0) goto L_0x02f3
                if (r2 != r14) goto L_0x0115
            L_0x0112:
                r29 = 0
                goto L_0x0122
            L_0x0115:
                boolean r15 = r1.isNull(r2)     // Catch:{ all -> 0x00d1 }
                if (r15 == 0) goto L_0x011c
                goto L_0x0112
            L_0x011c:
                java.lang.String r15 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                r29 = r15
            L_0x0122:
                if (r5 != r14) goto L_0x0127
                r30 = 0
                goto L_0x0131
            L_0x0127:
                int r15 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                androidx.work.WorkInfo$State r15 = androidx.work.impl.model.WorkTypeConverters.f(r15)     // Catch:{ all -> 0x00d1 }
                r30 = r15
            L_0x0131:
                if (r6 != r14) goto L_0x0136
                r31 = 0
                goto L_0x0148
            L_0x0136:
                boolean r15 = r1.isNull(r6)     // Catch:{ all -> 0x00d1 }
                if (r15 == 0) goto L_0x013e
                r15 = 0
                goto L_0x0142
            L_0x013e:
                byte[] r15 = r1.getBlob(r6)     // Catch:{ all -> 0x00d1 }
            L_0x0142:
                androidx.work.Data r15 = androidx.work.Data.g(r15)     // Catch:{ all -> 0x00d1 }
                r31 = r15
            L_0x0148:
                r32 = 0
                if (r7 != r14) goto L_0x014f
                r34 = r32
                goto L_0x0153
            L_0x014f:
                long r34 = r1.getLong(r7)     // Catch:{ all -> 0x00d1 }
            L_0x0153:
                if (r8 != r14) goto L_0x0158
                r36 = r32
                goto L_0x015c
            L_0x0158:
                long r36 = r1.getLong(r8)     // Catch:{ all -> 0x00d1 }
            L_0x015c:
                if (r9 != r14) goto L_0x0161
                r38 = r32
                goto L_0x0165
            L_0x0161:
                long r38 = r1.getLong(r9)     // Catch:{ all -> 0x00d1 }
            L_0x0165:
                if (r10 != r14) goto L_0x016a
                r40 = 0
                goto L_0x0170
            L_0x016a:
                int r28 = r1.getInt(r10)     // Catch:{ all -> 0x00d1 }
                r40 = r28
            L_0x0170:
                if (r11 != r14) goto L_0x0175
                r41 = 0
                goto L_0x017f
            L_0x0175:
                int r28 = r1.getInt(r11)     // Catch:{ all -> 0x00d1 }
                androidx.work.BackoffPolicy r28 = androidx.work.impl.model.WorkTypeConverters.c(r28)     // Catch:{ all -> 0x00d1 }
                r41 = r28
            L_0x017f:
                if (r12 != r14) goto L_0x0184
                r42 = r32
                goto L_0x0188
            L_0x0184:
                long r42 = r1.getLong(r12)     // Catch:{ all -> 0x00d1 }
            L_0x0188:
                if (r13 != r14) goto L_0x018f
                r15 = r27
                r44 = r32
                goto L_0x0195
            L_0x018f:
                long r44 = r1.getLong(r13)     // Catch:{ all -> 0x00d1 }
                r15 = r27
            L_0x0195:
                if (r15 != r14) goto L_0x01a0
                r27 = 0
            L_0x0199:
                r62 = r26
                r26 = r5
                r5 = r62
                goto L_0x01a5
            L_0x01a0:
                int r27 = r1.getInt(r15)     // Catch:{ all -> 0x00d1 }
                goto L_0x0199
            L_0x01a5:
                if (r5 != r14) goto L_0x01b0
                r46 = 0
            L_0x01a9:
                r62 = r25
                r25 = r5
                r5 = r62
                goto L_0x01b7
            L_0x01b0:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                r46 = r28
                goto L_0x01a9
            L_0x01b7:
                if (r5 != r14) goto L_0x01c2
                r47 = r32
            L_0x01bb:
                r62 = r16
                r16 = r5
                r5 = r62
                goto L_0x01c7
            L_0x01c2:
                long r47 = r1.getLong(r5)     // Catch:{ all -> 0x00d1 }
                goto L_0x01bb
            L_0x01c7:
                if (r5 != r14) goto L_0x01d2
                r49 = 0
            L_0x01cb:
                r62 = r17
                r17 = r5
                r5 = r62
                goto L_0x01d9
            L_0x01d2:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                r49 = r28
                goto L_0x01cb
            L_0x01d9:
                if (r5 != r14) goto L_0x01e4
                r51 = 0
            L_0x01dd:
                r62 = r18
                r18 = r5
                r5 = r62
                goto L_0x01ef
            L_0x01e4:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                androidx.work.NetworkType r28 = androidx.work.impl.model.WorkTypeConverters.d(r28)     // Catch:{ all -> 0x00d1 }
                r51 = r28
                goto L_0x01dd
            L_0x01ef:
                if (r5 != r14) goto L_0x01fa
                r52 = 0
            L_0x01f3:
                r62 = r19
                r19 = r5
                r5 = r62
                goto L_0x0208
            L_0x01fa:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x0203
                r28 = 1
                goto L_0x0205
            L_0x0203:
                r28 = 0
            L_0x0205:
                r52 = r28
                goto L_0x01f3
            L_0x0208:
                if (r5 != r14) goto L_0x0213
                r53 = 0
            L_0x020c:
                r62 = r20
                r20 = r5
                r5 = r62
                goto L_0x0221
            L_0x0213:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x021c
                r28 = 1
                goto L_0x021e
            L_0x021c:
                r28 = 0
            L_0x021e:
                r53 = r28
                goto L_0x020c
            L_0x0221:
                if (r5 != r14) goto L_0x022c
                r54 = 0
            L_0x0225:
                r62 = r21
                r21 = r5
                r5 = r62
                goto L_0x023a
            L_0x022c:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x0235
                r28 = 1
                goto L_0x0237
            L_0x0235:
                r28 = 0
            L_0x0237:
                r54 = r28
                goto L_0x0225
            L_0x023a:
                if (r5 != r14) goto L_0x0245
                r55 = 0
            L_0x023e:
                r62 = r22
                r22 = r5
                r5 = r62
                goto L_0x0253
            L_0x0245:
                int r28 = r1.getInt(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x024e
                r28 = 1
                goto L_0x0250
            L_0x024e:
                r28 = 0
            L_0x0250:
                r55 = r28
                goto L_0x023e
            L_0x0253:
                if (r5 != r14) goto L_0x025e
                r56 = r32
            L_0x0257:
                r62 = r23
                r23 = r5
                r5 = r62
                goto L_0x0263
            L_0x025e:
                long r56 = r1.getLong(r5)     // Catch:{ all -> 0x00d1 }
                goto L_0x0257
            L_0x0263:
                if (r5 != r14) goto L_0x026e
            L_0x0265:
                r58 = r32
                r62 = r24
                r24 = r5
                r5 = r62
                goto L_0x0273
            L_0x026e:
                long r32 = r1.getLong(r5)     // Catch:{ all -> 0x00d1 }
                goto L_0x0265
            L_0x0273:
                if (r5 != r14) goto L_0x0278
                r60 = 0
                goto L_0x028b
            L_0x0278:
                boolean r28 = r1.isNull(r5)     // Catch:{ all -> 0x00d1 }
                if (r28 == 0) goto L_0x0281
                r28 = 0
                goto L_0x0285
            L_0x0281:
                byte[] r28 = r1.getBlob(r5)     // Catch:{ all -> 0x00d1 }
            L_0x0285:
                java.util.Set r28 = androidx.work.impl.model.WorkTypeConverters.b(r28)     // Catch:{ all -> 0x00d1 }
                r60 = r28
            L_0x028b:
                androidx.work.Constraints r61 = new androidx.work.Constraints     // Catch:{ all -> 0x00d1 }
                r50 = r61
                r50.<init>(r51, r52, r53, r54, r55, r56, r58, r60)     // Catch:{ all -> 0x00d1 }
                java.lang.String r14 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                java.lang.Object r14 = r4.get(r14)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d1 }
                if (r14 != 0) goto L_0x02a3
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                r14.<init>()     // Catch:{ all -> 0x00d1 }
            L_0x02a3:
                r50 = r14
                java.lang.String r14 = r1.getString(r2)     // Catch:{ all -> 0x00d1 }
                java.lang.Object r14 = r3.get(r14)     // Catch:{ all -> 0x00d1 }
                java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d1 }
                if (r14 != 0) goto L_0x02b6
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                r14.<init>()     // Catch:{ all -> 0x00d1 }
            L_0x02b6:
                r51 = r14
                androidx.work.impl.model.WorkSpec$WorkInfoPojo r14 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00d1 }
                r28 = r14
                r32 = r34
                r34 = r36
                r36 = r38
                r38 = r61
                r39 = r40
                r40 = r41
                r41 = r42
                r43 = r44
                r45 = r27
                r28.<init>(r29, r30, r31, r32, r34, r36, r38, r39, r40, r41, r43, r45, r46, r47, r49, r50, r51)     // Catch:{ all -> 0x00d1 }
                r0.add(r14)     // Catch:{ all -> 0x00d1 }
                r27 = r15
                r14 = -1
                r62 = r24
                r24 = r5
                r5 = r26
                r26 = r25
                r25 = r16
                r16 = r17
                r17 = r18
                r18 = r19
                r19 = r20
                r20 = r21
                r21 = r22
                r22 = r23
                r23 = r62
                goto L_0x010a
            L_0x02f3:
                r1.close()
                return r0
            L_0x02f7:
                r1.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.RawWorkInfoDao_Impl.AnonymousClass2.call():java.util.List");
        }
    }

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.f2167a = roomDatabase;
    }

    public static List g() {
        return Collections.emptyList();
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0239 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0242 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0252 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x025b A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x026b A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0272 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0275 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x029b A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02ae A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0121 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0124 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0130 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0133 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0149 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x014c A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0152 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0155 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x015b A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x015e A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0164 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0167 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x016f A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0172 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017e A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0181 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0187 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x018c A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0194 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x019d A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a4 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ad A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01b6 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01bf A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c6 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01cf A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01d8 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01e1 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ee A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01f7 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0207 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0210 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0220 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0229 A[Catch:{ all -> 0x00d2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(androidx.sqlite.db.SupportSQLiteQuery r63) {
        /*
            r62 = this;
            r0 = r62
            androidx.room.RoomDatabase r1 = r0.f2167a
            r1.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r1 = r0.f2167a
            r2 = 1
            r3 = 0
            r4 = r63
            android.database.Cursor r1 = androidx.room.util.DBUtil.c(r1, r4, r2, r3)
            java.lang.String r4 = "id"
            int r4 = androidx.room.util.CursorUtil.c(r1, r4)     // Catch:{ all -> 0x00d2 }
            java.lang.String r5 = "state"
            int r5 = androidx.room.util.CursorUtil.c(r1, r5)     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = "output"
            int r6 = androidx.room.util.CursorUtil.c(r1, r6)     // Catch:{ all -> 0x00d2 }
            java.lang.String r7 = "initial_delay"
            int r7 = androidx.room.util.CursorUtil.c(r1, r7)     // Catch:{ all -> 0x00d2 }
            java.lang.String r8 = "interval_duration"
            int r8 = androidx.room.util.CursorUtil.c(r1, r8)     // Catch:{ all -> 0x00d2 }
            java.lang.String r9 = "flex_duration"
            int r9 = androidx.room.util.CursorUtil.c(r1, r9)     // Catch:{ all -> 0x00d2 }
            java.lang.String r10 = "run_attempt_count"
            int r10 = androidx.room.util.CursorUtil.c(r1, r10)     // Catch:{ all -> 0x00d2 }
            java.lang.String r11 = "backoff_policy"
            int r11 = androidx.room.util.CursorUtil.c(r1, r11)     // Catch:{ all -> 0x00d2 }
            java.lang.String r12 = "backoff_delay_duration"
            int r12 = androidx.room.util.CursorUtil.c(r1, r12)     // Catch:{ all -> 0x00d2 }
            java.lang.String r13 = "last_enqueue_time"
            int r13 = androidx.room.util.CursorUtil.c(r1, r13)     // Catch:{ all -> 0x00d2 }
            java.lang.String r14 = "period_count"
            int r14 = androidx.room.util.CursorUtil.c(r1, r14)     // Catch:{ all -> 0x00d2 }
            java.lang.String r15 = "generation"
            int r15 = androidx.room.util.CursorUtil.c(r1, r15)     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = "next_schedule_time_override"
            int r2 = androidx.room.util.CursorUtil.c(r1, r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = "stop_reason"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r63 = r3
            java.lang.String r3 = "required_network_type"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r16 = r3
            java.lang.String r3 = "requires_charging"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r17 = r3
            java.lang.String r3 = "requires_device_idle"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r18 = r3
            java.lang.String r3 = "requires_battery_not_low"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r19 = r3
            java.lang.String r3 = "requires_storage_not_low"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r20 = r3
            java.lang.String r3 = "trigger_content_update_delay"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r21 = r3
            java.lang.String r3 = "trigger_max_content_delay"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r22 = r3
            java.lang.String r3 = "content_uri_triggers"
            int r3 = androidx.room.util.CursorUtil.c(r1, r3)     // Catch:{ all -> 0x00d2 }
            r23 = r3
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00d2 }
            r3.<init>()     // Catch:{ all -> 0x00d2 }
            r24 = r2
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x00d2 }
            r2.<init>()     // Catch:{ all -> 0x00d2 }
        L_0x00b3:
            boolean r25 = r1.moveToNext()     // Catch:{ all -> 0x00d2 }
            if (r25 == 0) goto L_0x00f0
            r25 = r15
            java.lang.String r15 = r1.getString(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.Object r26 = r3.get(r15)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r26 = (java.util.ArrayList) r26     // Catch:{ all -> 0x00d2 }
            if (r26 != 0) goto L_0x00d5
            r26 = r14
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r14.<init>()     // Catch:{ all -> 0x00d2 }
            r3.put(r15, r14)     // Catch:{ all -> 0x00d2 }
            goto L_0x00d7
        L_0x00d2:
            r0 = move-exception
            goto L_0x02f4
        L_0x00d5:
            r26 = r14
        L_0x00d7:
            java.lang.String r14 = r1.getString(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.Object r15 = r2.get(r14)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r15 = (java.util.ArrayList) r15     // Catch:{ all -> 0x00d2 }
            if (r15 != 0) goto L_0x00eb
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r15.<init>()     // Catch:{ all -> 0x00d2 }
            r2.put(r14, r15)     // Catch:{ all -> 0x00d2 }
        L_0x00eb:
            r15 = r25
            r14 = r26
            goto L_0x00b3
        L_0x00f0:
            r26 = r14
            r25 = r15
            r14 = -1
            r1.moveToPosition(r14)     // Catch:{ all -> 0x00d2 }
            r0.c(r3)     // Catch:{ all -> 0x00d2 }
            r0.b(r2)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            int r15 = r1.getCount()     // Catch:{ all -> 0x00d2 }
            r0.<init>(r15)     // Catch:{ all -> 0x00d2 }
        L_0x0107:
            boolean r15 = r1.moveToNext()     // Catch:{ all -> 0x00d2 }
            if (r15 == 0) goto L_0x02f0
            if (r4 != r14) goto L_0x0112
        L_0x010f:
            r28 = 0
            goto L_0x011f
        L_0x0112:
            boolean r15 = r1.isNull(r4)     // Catch:{ all -> 0x00d2 }
            if (r15 == 0) goto L_0x0119
            goto L_0x010f
        L_0x0119:
            java.lang.String r15 = r1.getString(r4)     // Catch:{ all -> 0x00d2 }
            r28 = r15
        L_0x011f:
            if (r5 != r14) goto L_0x0124
            r29 = 0
            goto L_0x012e
        L_0x0124:
            int r15 = r1.getInt(r5)     // Catch:{ all -> 0x00d2 }
            androidx.work.WorkInfo$State r15 = androidx.work.impl.model.WorkTypeConverters.f(r15)     // Catch:{ all -> 0x00d2 }
            r29 = r15
        L_0x012e:
            if (r6 != r14) goto L_0x0133
            r30 = 0
            goto L_0x0145
        L_0x0133:
            boolean r15 = r1.isNull(r6)     // Catch:{ all -> 0x00d2 }
            if (r15 == 0) goto L_0x013b
            r15 = 0
            goto L_0x013f
        L_0x013b:
            byte[] r15 = r1.getBlob(r6)     // Catch:{ all -> 0x00d2 }
        L_0x013f:
            androidx.work.Data r15 = androidx.work.Data.g(r15)     // Catch:{ all -> 0x00d2 }
            r30 = r15
        L_0x0145:
            r31 = 0
            if (r7 != r14) goto L_0x014c
            r33 = r31
            goto L_0x0150
        L_0x014c:
            long r33 = r1.getLong(r7)     // Catch:{ all -> 0x00d2 }
        L_0x0150:
            if (r8 != r14) goto L_0x0155
            r35 = r31
            goto L_0x0159
        L_0x0155:
            long r35 = r1.getLong(r8)     // Catch:{ all -> 0x00d2 }
        L_0x0159:
            if (r9 != r14) goto L_0x015e
            r37 = r31
            goto L_0x0162
        L_0x015e:
            long r37 = r1.getLong(r9)     // Catch:{ all -> 0x00d2 }
        L_0x0162:
            if (r10 != r14) goto L_0x0167
            r39 = 0
            goto L_0x016d
        L_0x0167:
            int r27 = r1.getInt(r10)     // Catch:{ all -> 0x00d2 }
            r39 = r27
        L_0x016d:
            if (r11 != r14) goto L_0x0172
            r40 = 0
            goto L_0x017c
        L_0x0172:
            int r27 = r1.getInt(r11)     // Catch:{ all -> 0x00d2 }
            androidx.work.BackoffPolicy r27 = androidx.work.impl.model.WorkTypeConverters.c(r27)     // Catch:{ all -> 0x00d2 }
            r40 = r27
        L_0x017c:
            if (r12 != r14) goto L_0x0181
            r41 = r31
            goto L_0x0185
        L_0x0181:
            long r41 = r1.getLong(r12)     // Catch:{ all -> 0x00d2 }
        L_0x0185:
            if (r13 != r14) goto L_0x018c
            r15 = r26
            r43 = r31
            goto L_0x0192
        L_0x018c:
            long r43 = r1.getLong(r13)     // Catch:{ all -> 0x00d2 }
            r15 = r26
        L_0x0192:
            if (r15 != r14) goto L_0x019d
            r26 = 0
        L_0x0196:
            r61 = r25
            r25 = r5
            r5 = r61
            goto L_0x01a2
        L_0x019d:
            int r26 = r1.getInt(r15)     // Catch:{ all -> 0x00d2 }
            goto L_0x0196
        L_0x01a2:
            if (r5 != r14) goto L_0x01ad
            r45 = 0
        L_0x01a6:
            r61 = r24
            r24 = r5
            r5 = r61
            goto L_0x01b4
        L_0x01ad:
            int r27 = r1.getInt(r5)     // Catch:{ all -> 0x00d2 }
            r45 = r27
            goto L_0x01a6
        L_0x01b4:
            if (r5 != r14) goto L_0x01bf
            r46 = r31
        L_0x01b8:
            r61 = r5
            r5 = r63
            r63 = r61
            goto L_0x01c4
        L_0x01bf:
            long r46 = r1.getLong(r5)     // Catch:{ all -> 0x00d2 }
            goto L_0x01b8
        L_0x01c4:
            if (r5 != r14) goto L_0x01cf
            r48 = 0
        L_0x01c8:
            r61 = r16
            r16 = r5
            r5 = r61
            goto L_0x01d6
        L_0x01cf:
            int r27 = r1.getInt(r5)     // Catch:{ all -> 0x00d2 }
            r48 = r27
            goto L_0x01c8
        L_0x01d6:
            if (r5 != r14) goto L_0x01e1
            r50 = 0
        L_0x01da:
            r61 = r17
            r17 = r5
            r5 = r61
            goto L_0x01ec
        L_0x01e1:
            int r27 = r1.getInt(r5)     // Catch:{ all -> 0x00d2 }
            androidx.work.NetworkType r27 = androidx.work.impl.model.WorkTypeConverters.d(r27)     // Catch:{ all -> 0x00d2 }
            r50 = r27
            goto L_0x01da
        L_0x01ec:
            if (r5 != r14) goto L_0x01f7
            r51 = 0
        L_0x01f0:
            r61 = r18
            r18 = r5
            r5 = r61
            goto L_0x0205
        L_0x01f7:
            int r27 = r1.getInt(r5)     // Catch:{ all -> 0x00d2 }
            if (r27 == 0) goto L_0x0200
            r27 = 1
            goto L_0x0202
        L_0x0200:
            r27 = 0
        L_0x0202:
            r51 = r27
            goto L_0x01f0
        L_0x0205:
            if (r5 != r14) goto L_0x0210
            r52 = 0
        L_0x0209:
            r61 = r19
            r19 = r5
            r5 = r61
            goto L_0x021e
        L_0x0210:
            int r27 = r1.getInt(r5)     // Catch:{ all -> 0x00d2 }
            if (r27 == 0) goto L_0x0219
            r27 = 1
            goto L_0x021b
        L_0x0219:
            r27 = 0
        L_0x021b:
            r52 = r27
            goto L_0x0209
        L_0x021e:
            if (r5 != r14) goto L_0x0229
            r53 = 0
        L_0x0222:
            r61 = r20
            r20 = r5
            r5 = r61
            goto L_0x0237
        L_0x0229:
            int r27 = r1.getInt(r5)     // Catch:{ all -> 0x00d2 }
            if (r27 == 0) goto L_0x0232
            r27 = 1
            goto L_0x0234
        L_0x0232:
            r27 = 0
        L_0x0234:
            r53 = r27
            goto L_0x0222
        L_0x0237:
            if (r5 != r14) goto L_0x0242
            r54 = 0
        L_0x023b:
            r61 = r21
            r21 = r5
            r5 = r61
            goto L_0x0250
        L_0x0242:
            int r27 = r1.getInt(r5)     // Catch:{ all -> 0x00d2 }
            if (r27 == 0) goto L_0x024b
            r27 = 1
            goto L_0x024d
        L_0x024b:
            r27 = 0
        L_0x024d:
            r54 = r27
            goto L_0x023b
        L_0x0250:
            if (r5 != r14) goto L_0x025b
            r55 = r31
        L_0x0254:
            r61 = r22
            r22 = r5
            r5 = r61
            goto L_0x0260
        L_0x025b:
            long r55 = r1.getLong(r5)     // Catch:{ all -> 0x00d2 }
            goto L_0x0254
        L_0x0260:
            if (r5 != r14) goto L_0x026b
        L_0x0262:
            r57 = r31
            r61 = r23
            r23 = r5
            r5 = r61
            goto L_0x0270
        L_0x026b:
            long r31 = r1.getLong(r5)     // Catch:{ all -> 0x00d2 }
            goto L_0x0262
        L_0x0270:
            if (r5 != r14) goto L_0x0275
            r59 = 0
            goto L_0x0288
        L_0x0275:
            boolean r27 = r1.isNull(r5)     // Catch:{ all -> 0x00d2 }
            if (r27 == 0) goto L_0x027e
            r27 = 0
            goto L_0x0282
        L_0x027e:
            byte[] r27 = r1.getBlob(r5)     // Catch:{ all -> 0x00d2 }
        L_0x0282:
            java.util.Set r27 = androidx.work.impl.model.WorkTypeConverters.b(r27)     // Catch:{ all -> 0x00d2 }
            r59 = r27
        L_0x0288:
            androidx.work.Constraints r60 = new androidx.work.Constraints     // Catch:{ all -> 0x00d2 }
            r49 = r60
            r49.<init>(r50, r51, r52, r53, r54, r55, r57, r59)     // Catch:{ all -> 0x00d2 }
            java.lang.String r14 = r1.getString(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.Object r14 = r3.get(r14)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d2 }
            if (r14 != 0) goto L_0x02a0
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r14.<init>()     // Catch:{ all -> 0x00d2 }
        L_0x02a0:
            r49 = r14
            java.lang.String r14 = r1.getString(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.Object r14 = r2.get(r14)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d2 }
            if (r14 != 0) goto L_0x02b3
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r14.<init>()     // Catch:{ all -> 0x00d2 }
        L_0x02b3:
            r50 = r14
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r14 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00d2 }
            r27 = r14
            r31 = r33
            r33 = r35
            r35 = r37
            r37 = r60
            r38 = r39
            r39 = r40
            r40 = r41
            r42 = r43
            r44 = r26
            r27.<init>(r28, r29, r30, r31, r33, r35, r37, r38, r39, r40, r42, r44, r45, r46, r48, r49, r50)     // Catch:{ all -> 0x00d2 }
            r0.add(r14)     // Catch:{ all -> 0x00d2 }
            r26 = r15
            r14 = -1
            r61 = r24
            r24 = r63
            r63 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r23 = r5
            r5 = r25
            r25 = r61
            goto L_0x0107
        L_0x02f0:
            r1.close()
            return r0
        L_0x02f4:
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.RawWorkInfoDao_Impl.a(androidx.sqlite.db.SupportSQLiteQuery):java.util.List");
    }

    public final void b(HashMap hashMap) {
        int i;
        Set<String> keySet = hashMap.keySet();
        if (!keySet.isEmpty()) {
            if (hashMap.size() > 999) {
                HashMap hashMap2 = new HashMap(999);
                loop0:
                while (true) {
                    i = 0;
                    for (String str : keySet) {
                        hashMap2.put(str, (ArrayList) hashMap.get(str));
                        i++;
                        if (i == 999) {
                            b(hashMap2);
                            hashMap2 = new HashMap(999);
                        }
                    }
                    break loop0;
                }
                if (i > 0) {
                    b(hashMap2);
                    return;
                }
                return;
            }
            StringBuilder b = StringUtil.b();
            b.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size = keySet.size();
            StringUtil.a(b, size);
            b.append(")");
            RoomSQLiteQuery c = RoomSQLiteQuery.c(b.toString(), size);
            int i2 = 1;
            for (String str2 : keySet) {
                if (str2 == null) {
                    c.L(i2);
                } else {
                    c.B(i2, str2);
                }
                i2++;
            }
            Cursor c2 = DBUtil.c(this.f2167a, c, false, (CancellationSignal) null);
            try {
                int c3 = CursorUtil.c(c2, "work_spec_id");
                if (c3 != -1) {
                    while (c2.moveToNext()) {
                        ArrayList arrayList = (ArrayList) hashMap.get(c2.getString(c3));
                        if (arrayList != null) {
                            arrayList.add(Data.g(c2.isNull(0) ? null : c2.getBlob(0)));
                        }
                    }
                    c2.close();
                }
            } finally {
                c2.close();
            }
        }
    }

    public final void c(HashMap hashMap) {
        int i;
        Set<String> keySet = hashMap.keySet();
        if (!keySet.isEmpty()) {
            if (hashMap.size() > 999) {
                HashMap hashMap2 = new HashMap(999);
                loop0:
                while (true) {
                    i = 0;
                    for (String str : keySet) {
                        hashMap2.put(str, (ArrayList) hashMap.get(str));
                        i++;
                        if (i == 999) {
                            c(hashMap2);
                            hashMap2 = new HashMap(999);
                        }
                    }
                    break loop0;
                }
                if (i > 0) {
                    c(hashMap2);
                    return;
                }
                return;
            }
            StringBuilder b = StringUtil.b();
            b.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size = keySet.size();
            StringUtil.a(b, size);
            b.append(")");
            RoomSQLiteQuery c = RoomSQLiteQuery.c(b.toString(), size);
            int i2 = 1;
            for (String str2 : keySet) {
                if (str2 == null) {
                    c.L(i2);
                } else {
                    c.B(i2, str2);
                }
                i2++;
            }
            Cursor c2 = DBUtil.c(this.f2167a, c, false, (CancellationSignal) null);
            try {
                int c3 = CursorUtil.c(c2, "work_spec_id");
                if (c3 != -1) {
                    while (c2.moveToNext()) {
                        ArrayList arrayList = (ArrayList) hashMap.get(c2.getString(c3));
                        if (arrayList != null) {
                            arrayList.add(c2.isNull(0) ? null : c2.getString(0));
                        }
                    }
                    c2.close();
                }
            } finally {
                c2.close();
            }
        }
    }
}
