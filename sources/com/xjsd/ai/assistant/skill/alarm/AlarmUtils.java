package com.xjsd.ai.assistant.skill.alarm;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.alarm.Alarm;
import com.xjsd.ai.assistant.protocol.alarm.AlarmExt;
import com.xjsd.ai.assistant.protocol.alarm.Weekdays;
import com.xjsd.ai.assistant.skill.alarm.AlarmCreateException;
import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u000fH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u0010-\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "id", "", "c", "(Landroid/content/Context;J)Z", "Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;", "alarmExt", "i", "(Landroid/content/Context;Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;)Z", "", "enable", "", "tag", "e", "(Landroid/content/Context;ILjava/lang/String;)I", "", "Lcom/xjsd/ai/assistant/protocol/alarm/Alarm;", "f", "(Landroid/content/Context;ILjava/lang/String;)Ljava/util/List;", "Lkotlin/Result;", "d", "(Landroid/content/Context;J)Ljava/lang/Object;", "alarm", "h", "(Landroid/content/Context;Lcom/xjsd/ai/assistant/protocol/alarm/Alarm;)Ljava/lang/Object;", "a", "(Landroid/content/Context;Lcom/xjsd/ai/assistant/protocol/alarm/Alarm;)J", "j", "(Landroid/content/Context;Lcom/xjsd/ai/assistant/protocol/alarm/Alarm;)Z", "dateStr", "Ljava/util/Date;", "b", "(Ljava/lang/String;)Ljava/util/Date;", "Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "daysOfWeek", "g", "(Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;)Ljava/lang/String;", "minutes", "l", "(I)Z", "hour", "k", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAlarmUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlarmUtils.kt\ncom/xjsd/ai/assistant/skill/alarm/AlarmUtils\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,434:1\n26#2:435\n26#2:436\n1#3:437\n*S KotlinDebug\n*F\n+ 1 AlarmUtils.kt\ncom/xjsd/ai/assistant/skill/alarm/AlarmUtils\n*L\n34#1:435\n70#1:436\n*E\n"})
public final class AlarmUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AlarmUtils f8668a = new AlarmUtils();

    public static final boolean c(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        ILog.a("AlarmUtils", "deleteAlarm: alarm id->" + j);
        if (j <= -1) {
            return false;
        }
        int delete = context.getContentResolver().delete(Alarm.Companion.getSTANDARD_CONTENT_URI(), "_id=?", new String[]{String.valueOf(j)});
        ILog.j("AlarmUtils", "deleteAlarm: result->" + delete);
        return delete > 0;
    }

    public static final boolean i(Context context, AlarmExt alarmExt) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(alarmExt, "alarmExt");
        ILog.a("AlarmUtils", "modifyAlarm: alarm->" + alarmExt);
        ContentValues contentValues = new ContentValues();
        contentValues.put("enabled", Boolean.valueOf(alarmExt.getEnabled()));
        contentValues.put("hour", Integer.valueOf(alarmExt.getHour()));
        contentValues.put("minutes", Integer.valueOf(alarmExt.getMinutes()));
        Weekdays daysOfWeek = alarmExt.getDaysOfWeek();
        contentValues.put("daysofweek", Integer.valueOf(daysOfWeek != null ? daysOfWeek.getBits() : 0));
        String[] strArr = {String.valueOf(alarmExt.getId())};
        Uri withAppendedId = ContentUris.withAppendedId(Alarm.Companion.getSTANDARD_CONTENT_URI(), alarmExt.getId());
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
        try {
            int update = context.getContentResolver().update(withAppendedId, contentValues, "_id=?", strArr);
            ILog.j("AlarmUtils", "modifyAlarm: result " + update);
            return ((long) update) > -1;
        } catch (Exception e) {
            ILog.h("AlarmUtils", "modifyAlarm: failed", e);
            return false;
        }
    }

    public final long a(Context context, Alarm alarm) {
        ArrayList<Integer> arrayList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(alarm, VuiModelType.ALARM);
        ILog.j("AlarmUtils", "addAlarm: " + GsonUtils.e(alarm));
        if (!k(alarm.getHour()) || !l(alarm.getMinutes())) {
            throw new AlarmCreateException.TimeFormatException();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("android.intent.extra.alarm.HOUR", alarm.getHour());
        bundle.putInt("android.intent.extra.alarm.MINUTES", alarm.getMinutes());
        bundle.putString("android.intent.extra.alarm.MESSAGE", alarm.getLabel());
        bundle.putBoolean("android.intent.extra.alarm.VIBRATE", alarm.getVibrate());
        bundle.putInt("android.intent.extra.alarm.ENABLE", 1);
        Weekdays daysOfWeek = alarm.getDaysOfWeek();
        if (daysOfWeek == null || (arrayList = daysOfWeek.toAlarmClockDay()) == null) {
            arrayList = null;
        }
        bundle.putIntegerArrayList("android.intent.extra.alarm.DAYS", arrayList);
        try {
            Bundle call = context.getContentResolver().call(Alarm.Companion.getSTANDARD_CONTENT_URI(), "setAlarm", (String) null, bundle);
            if (call == null) {
                return -1;
            }
            long j = call.getLong("id");
            ILog.a("AlarmUtils", "addAlarm: 返回id->" + j);
            return j;
        } catch (Exception e) {
            ILog.h("AlarmUtils", "addAlarm: failed", e);
            throw new AlarmCreateException.SqliteException();
        }
    }

    public final Date b(String str) {
        Intrinsics.checkNotNullParameter(str, "dateStr");
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        return parse;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(android.content.Context r10, long r11) {
        /*
            r9 = this;
            java.lang.String r9 = "alarm not found"
            java.lang.String r0 = "AlarmUtils"
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " _id=? "
            r1.append(r2)
            java.lang.String r6 = r1.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String[] r7 = new java.lang.String[]{r11}
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x0070 }
            com.xjsd.ai.assistant.protocol.alarm.Alarm$Companion r10 = com.xjsd.ai.assistant.protocol.alarm.Alarm.Companion     // Catch:{ Exception -> 0x0070 }
            android.net.Uri r4 = r10.getSTANDARD_CONTENT_URI()     // Catch:{ Exception -> 0x0070 }
            java.lang.String[] r5 = r10.getQUERY_COLUMNS()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r8 = "hour, minutes ASC, _id DESC"
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0070 }
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch:{ Exception -> 0x0070 }
            r11 = r10
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ all -> 0x0072 }
            r12 = 0
            if (r11 == 0) goto L_0x0074
            int r1 = r11.getCount()     // Catch:{ all -> 0x0072 }
            if (r1 <= 0) goto L_0x0074
            boolean r1 = r11.moveToFirst()     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x0074
            com.xjsd.ai.assistant.protocol.alarm.Alarm r1 = new com.xjsd.ai.assistant.protocol.alarm.Alarm     // Catch:{ all -> 0x0072 }
            r1.<init>((android.database.Cursor) r11)     // Catch:{ all -> 0x0072 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r11.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = "getAlarmById: result->"
            r11.append(r2)     // Catch:{ all -> 0x0072 }
            r11.append(r1)     // Catch:{ all -> 0x0072 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0072 }
            com.xjsd.ai.assistant.log.ILog.a(r0, r11)     // Catch:{ all -> 0x0072 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0072 }
            kotlin.io.CloseableKt.closeFinally(r10, r12)     // Catch:{ Exception -> 0x0070 }
            java.lang.Object r9 = kotlin.Result.m20constructorimpl(r1)
            return r9
        L_0x0070:
            r10 = move-exception
            goto L_0x0092
        L_0x0072:
            r11 = move-exception
            goto L_0x008c
        L_0x0074:
            java.lang.String r11 = "getAlarmById: result is empty"
            com.xjsd.ai.assistant.log.ILog.a(r0, r11)     // Catch:{ all -> 0x0072 }
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x0072 }
            java.lang.Throwable r11 = new java.lang.Throwable     // Catch:{ all -> 0x0072 }
            r11.<init>(r9)     // Catch:{ all -> 0x0072 }
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)     // Catch:{ all -> 0x0072 }
            java.lang.Object r11 = kotlin.Result.m20constructorimpl(r11)     // Catch:{ all -> 0x0072 }
            kotlin.io.CloseableKt.closeFinally(r10, r12)     // Catch:{ Exception -> 0x0070 }
            return r11
        L_0x008c:
            throw r11     // Catch:{ all -> 0x008d }
        L_0x008d:
            r12 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r11)     // Catch:{ Exception -> 0x0070 }
            throw r12     // Catch:{ Exception -> 0x0070 }
        L_0x0092:
            java.lang.String r11 = "getAlarmById: failed"
            com.xjsd.ai.assistant.log.ILog.h(r0, r11, r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Throwable r10 = new java.lang.Throwable
            r10.<init>(r9)
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r9 = kotlin.Result.m20constructorimpl(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.alarm.AlarmUtils.d(android.content.Context, long):java.lang.Object");
    }

    public final int e(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "tag");
        Object[] objArr = new String[0];
        StringBuilder sb = new StringBuilder();
        if (i != -1) {
            sb.append("enabled=? ");
            objArr = ArraysKt.plus((T[]) objArr, String.valueOf(i));
        }
        if (str.length() > 0) {
            sb.append("label=? ");
            objArr = ArraysKt.plus((T[]) objArr, String.valueOf(str));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Alarm.Companion companion = Alarm.Companion;
            Closeable query = contentResolver.query(companion.getSTANDARD_CONTENT_URI(), companion.getQUERY_COLUMNS(), sb2, (String[]) objArr, "hour, minutes ASC, _id DESC");
            try {
                Cursor cursor = (Cursor) query;
                Integer valueOf = cursor != null ? Integer.valueOf(cursor.getCount()) : null;
                ILog.a("AlarmUtils", "getAlarmCount: count->" + valueOf);
                int intValue = valueOf != null ? valueOf.intValue() : 0;
                CloseableKt.closeFinally(query, (Throwable) null);
                return intValue;
            } catch (Throwable th) {
                CloseableKt.closeFinally(query, th);
                throw th;
            }
        } catch (Exception e) {
            ILog.h("AlarmUtils", "getAlarmCount: failed", e);
            return 0;
        }
    }

    public final List f(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "tag");
        ArrayList arrayList = new ArrayList();
        Object[] objArr = new String[0];
        StringBuilder sb = new StringBuilder();
        if (i != -1) {
            sb.append("enabled=? ");
            objArr = ArraysKt.plus((T[]) objArr, String.valueOf(i));
        }
        if (str.length() > 0) {
            sb.append("label=? ");
            objArr = ArraysKt.plus((T[]) objArr, String.valueOf(str));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        ILog.a("AlarmUtils", "getAlarmList: where->" + sb2);
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Alarm.Companion companion = Alarm.Companion;
            Closeable query = contentResolver.query(companion.getSTANDARD_CONTENT_URI(), companion.getQUERY_COLUMNS(), sb2, (String[]) objArr, "hour, minutes ASC, _id DESC limit 15");
            try {
                Cursor cursor = (Cursor) query;
                if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                    ILog.j("AlarmUtils", "getAlarmList: result is empty");
                } else {
                    do {
                        arrayList.add(new Alarm(cursor));
                    } while (cursor.moveToNext());
                    int size = arrayList.size();
                    ILog.j("AlarmUtils", "getAlarmList: result size->" + size);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, (Throwable) null);
                return arrayList;
            } catch (Throwable th) {
                CloseableKt.closeFinally(query, th);
                throw th;
            }
        } catch (Exception e) {
            ILog.h("AlarmUtils", "getAlarmList: failed", e);
        }
    }

    public final String g(Weekdays weekdays) {
        Intrinsics.checkNotNullParameter(weekdays, "daysOfWeek");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(instance);
        int distanceToNextDay = weekdays.getDistanceToNextDay(instance);
        if (distanceToNextDay > Weekdays.Companion.fromBits(64).getDistanceToNextDay(instance)) {
            sb.append(ContextHelper.b(R.string.tts_week_next, new Object[0]));
        }
        sb.append(ContextHelper.c(R.array.tts_next_week_days)[((instance.get(7) + distanceToNextDay <= 7 ? instance.get(7) + distanceToNextDay : (instance.get(7) + distanceToNextDay) - 7) + 5) % 7]);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cc, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(android.content.Context r9, com.xjsd.ai.assistant.protocol.alarm.Alarm r10) {
        /*
            r8 = this;
            java.lang.String r8 = "alarm not found"
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "alarm"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " hour=? "
            r0.append(r1)
            java.lang.String r1 = " and minutes=? "
            r0.append(r1)
            java.lang.String r1 = " and label=? "
            r0.append(r1)
            java.lang.String r1 = " and daysofweek=? "
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            int r0 = r10.getHour()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r10.getMinutes()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = r10.getLabel()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.xjsd.ai.assistant.protocol.alarm.Weekdays r10 = r10.getDaysOfWeek()
            if (r10 == 0) goto L_0x0052
            int r10 = r10.getBits()
            goto L_0x0053
        L_0x0052:
            r10 = 0
        L_0x0053:
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String[] r6 = new java.lang.String[]{r0, r1, r2, r10}
            com.xjsd.ai.assistant.protocol.alarm.Alarm r10 = new com.xjsd.ai.assistant.protocol.alarm.Alarm
            r10.<init>()
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ Exception -> 0x00cd }
            com.xjsd.ai.assistant.protocol.alarm.Alarm$Companion r9 = com.xjsd.ai.assistant.protocol.alarm.Alarm.Companion     // Catch:{ Exception -> 0x00cd }
            android.net.Uri r3 = r9.getSTANDARD_CONTENT_URI()     // Catch:{ Exception -> 0x00cd }
            java.lang.String[] r4 = r9.getQUERY_COLUMNS()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r7 = "hour, minutes ASC, _id DESC"
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00cd }
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ Exception -> 0x00cd }
            r10 = r9
            android.database.Cursor r10 = (android.database.Cursor) r10     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = "AlarmUtils"
            r1 = 0
            if (r10 == 0) goto L_0x00af
            int r2 = r10.getCount()     // Catch:{ all -> 0x00ad }
            if (r2 <= 0) goto L_0x00af
            boolean r2 = r10.moveToFirst()     // Catch:{ all -> 0x00ad }
            if (r2 == 0) goto L_0x00af
            com.xjsd.ai.assistant.protocol.alarm.Alarm r2 = new com.xjsd.ai.assistant.protocol.alarm.Alarm     // Catch:{ all -> 0x00ad }
            r2.<init>((android.database.Cursor) r10)     // Catch:{ all -> 0x00ad }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r10.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r3 = "getSpecificAlarmInfo: result->"
            r10.append(r3)     // Catch:{ all -> 0x00ad }
            r10.append(r2)     // Catch:{ all -> 0x00ad }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00ad }
            com.xjsd.ai.assistant.log.ILog.a(r0, r10)     // Catch:{ all -> 0x00ad }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ad }
            kotlin.io.CloseableKt.closeFinally(r9, r1)     // Catch:{ Exception -> 0x00cd }
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r2)
            return r8
        L_0x00ad:
            r10 = move-exception
            goto L_0x00c7
        L_0x00af:
            java.lang.String r10 = "getSpecificAlarmInfo: result is empty"
            com.xjsd.ai.assistant.log.ILog.g(r0, r10)     // Catch:{ all -> 0x00ad }
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch:{ all -> 0x00ad }
            java.lang.Throwable r10 = new java.lang.Throwable     // Catch:{ all -> 0x00ad }
            r10.<init>(r8)     // Catch:{ all -> 0x00ad }
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)     // Catch:{ all -> 0x00ad }
            java.lang.Object r10 = kotlin.Result.m20constructorimpl(r10)     // Catch:{ all -> 0x00ad }
            kotlin.io.CloseableKt.closeFinally(r9, r1)     // Catch:{ Exception -> 0x00cd }
            return r10
        L_0x00c7:
            throw r10     // Catch:{ all -> 0x00c8 }
        L_0x00c8:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r10)     // Catch:{ Exception -> 0x00cd }
            throw r0     // Catch:{ Exception -> 0x00cd }
        L_0x00cd:
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Throwable r9 = new java.lang.Throwable
            r9.<init>(r8)
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.alarm.AlarmUtils.h(android.content.Context, com.xjsd.ai.assistant.protocol.alarm.Alarm):java.lang.Object");
    }

    public final boolean j(Context context, Alarm alarm) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(alarm, VuiModelType.ALARM);
        String e = GsonUtils.e(alarm);
        ILog.a("AlarmUtils", "updateAlarm: data->" + e);
        if (!k(alarm.getHour()) || !l(alarm.getMinutes())) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("enabled", Boolean.valueOf(alarm.getEnabled()));
        contentValues.put("hour", Integer.valueOf(alarm.getHour()));
        contentValues.put("minutes", Integer.valueOf(alarm.getMinutes()));
        contentValues.put("vibrate", Boolean.valueOf(alarm.getVibrate()));
        contentValues.put("delete_after_use", Boolean.valueOf(alarm.getDeleteAfterUse()));
        Weekdays daysOfWeek = alarm.getDaysOfWeek();
        contentValues.put("daysofweek", Integer.valueOf(daysOfWeek != null ? daysOfWeek.getBits() : 0));
        String[] strArr = {String.valueOf(alarm.getId())};
        Uri withAppendedId = ContentUris.withAppendedId(Alarm.Companion.getSTANDARD_CONTENT_URI(), alarm.getId());
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
        try {
            int update = context.getContentResolver().update(withAppendedId, contentValues, "_id=?", strArr);
            ILog.a("AlarmUtils", "updateAlarm: result->" + update);
            return ((long) update) > -1;
        } catch (Exception e2) {
            ILog.h("AlarmUtils", "updateAlarm: failed", e2);
            return false;
        }
    }

    public final boolean k(int i) {
        return i >= 0 && i < 24;
    }

    public final boolean l(int i) {
        return i >= 0 && i < 60;
    }
}
