package com.xjsd.ai.assistant.protocol.schedule;

import com.xjsd.ai.assistant.log.ILog;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b9\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 U2\u00020\u0001:\u0001UB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0006\u0010J\u001a\u00020\u0005J\b\u0010K\u001a\u00020\rH\u0016J\u0010\u0010L\u001a\u00020\r2\b\u0010M\u001a\u0004\u0018\u00010\u0003J\u0006\u0010N\u001a\u00020\u0003J\u0006\u0010O\u001a\u00020\u0003J\b\u0010P\u001a\u00020\u0003H\u0016J\u0006\u0010Q\u001a\u00020RJ\u0018\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u0005H\u0002R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u0010\u0011R\u001a\u00104\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R\u001a\u00107\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011R\u001a\u0010:\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R\u001a\u0010=\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000f\"\u0004\b?\u0010\u0011R\u001a\u0010@\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000f\"\u0004\bB\u0010\u0011R\u001a\u0010C\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000f\"\u0004\bE\u0010\u0011¨\u0006V"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "Lcom/xjsd/ai/assistant/protocol/schedule/Event;", "title", "", "tStart", "", "tEnd", "(Ljava/lang/String;JJ)V", "event", "instance", "Lcom/xjsd/ai/assistant/protocol/schedule/Instance;", "(Lcom/xjsd/ai/assistant/protocol/schedule/Event;Lcom/xjsd/ai/assistant/protocol/schedule/Instance;)V", "end_day", "", "getEnd_day", "()I", "setEnd_day", "(I)V", "end_dayOfWeek", "getEnd_dayOfWeek", "setEnd_dayOfWeek", "end_hour", "getEnd_hour", "setEnd_hour", "end_minute", "getEnd_minute", "setEnd_minute", "end_month", "getEnd_month", "setEnd_month", "end_second", "getEnd_second", "setEnd_second", "end_year", "getEnd_year", "setEnd_year", "instanceBegin", "getInstanceBegin", "()J", "setInstanceBegin", "(J)V", "instanceEnd", "getInstanceEnd", "setInstanceEnd", "instanceId", "getInstanceId", "()Ljava/lang/String;", "setInstanceId", "(Ljava/lang/String;)V", "start_day", "getStart_day", "setStart_day", "start_dayOfWeek", "getStart_dayOfWeek", "setStart_dayOfWeek", "start_hour", "getStart_hour", "setStart_hour", "start_minute", "getStart_minute", "setStart_minute", "start_month", "getStart_month", "setStart_month", "start_second", "getStart_second", "setStart_second", "start_year", "getStart_year", "setStart_year", "equals", "", "o", "", "getCorrectDtEnd", "hashCode", "parseDurationValue", "str", "timeFormat", "timeInfo", "toString", "updateParamForUI", "", "sTime", "eTime", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSchedule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Schedule.kt\ncom/xjsd/ai/assistant/protocol/schedule/Schedule\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n1#2:190\n*E\n"})
public final class Schedule extends Event {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "Schedule_Bean";
    private int end_day;
    private int end_dayOfWeek;
    private int end_hour;
    private int end_minute;
    private int end_month;
    private int end_second;
    private int end_year;
    private long instanceBegin;
    private long instanceEnd;
    @Nullable
    private String instanceId;
    private int start_day;
    private int start_dayOfWeek;
    private int start_hour;
    private int start_minute;
    private int start_month;
    private int start_second;
    private int start_year;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/schedule/Schedule$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Schedule(@NotNull String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "title");
        setTitle(str);
        setDtStart(j);
        setDtEnd(Long.valueOf(j2));
        long dtStart = getDtStart();
        Long dtEnd = getDtEnd();
        Intrinsics.checkNotNull(dtEnd);
        updateParamForUI(dtStart, dtEnd.longValue());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Schedule)) {
            return false;
        }
        Schedule schedule = (Schedule) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) schedule.getId()) && Intrinsics.areEqual((Object) this.instanceId, (Object) schedule.instanceId);
    }

    public final long getCorrectDtEnd() {
        Long dtEnd = getDtEnd();
        return dtEnd != null ? dtEnd.longValue() : getDtStart() + getDtStart() + (((long) parseDurationValue(getDuration())) * 1000);
    }

    public final int getEnd_day() {
        return this.end_day;
    }

    public final int getEnd_dayOfWeek() {
        return this.end_dayOfWeek;
    }

    public final int getEnd_hour() {
        return this.end_hour;
    }

    public final int getEnd_minute() {
        return this.end_minute;
    }

    public final int getEnd_month() {
        return this.end_month;
    }

    public final int getEnd_second() {
        return this.end_second;
    }

    public final int getEnd_year() {
        return this.end_year;
    }

    public final long getInstanceBegin() {
        return this.instanceBegin;
    }

    public final long getInstanceEnd() {
        return this.instanceEnd;
    }

    @Nullable
    public final String getInstanceId() {
        return this.instanceId;
    }

    public final int getStart_day() {
        return this.start_day;
    }

    public final int getStart_dayOfWeek() {
        return this.start_dayOfWeek;
    }

    public final int getStart_hour() {
        return this.start_hour;
    }

    public final int getStart_minute() {
        return this.start_minute;
    }

    public final int getStart_month() {
        return this.start_month;
    }

    public final int getStart_second() {
        return this.start_second;
    }

    public final int getStart_year() {
        return this.start_year;
    }

    public int hashCode() {
        String id = getId();
        String str = this.instanceId;
        return (id + str).hashCode();
    }

    public final int parseDurationValue(@Nullable String str) {
        int i;
        int i2 = 1;
        if (!(str == null || str.length() == 0)) {
            int length = str.length();
            char charAt = str.charAt(0);
            if (charAt == '-') {
                i = -1;
            } else if (charAt == '+') {
                i = 1;
            } else {
                i = 1;
                i2 = 0;
            }
            if (length < i2) {
                return 0;
            }
            if (str.charAt(i2) == 'P') {
                int i3 = i2 + 1;
                if (str.charAt(i3) == 'T') {
                    i3 = i2 + 2;
                }
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i3 < length) {
                    char charAt2 = str.charAt(i3);
                    if ('0' > charAt2 || charAt2 >= ':') {
                        if (charAt2 == 'W') {
                            i4 = i9;
                        } else if (charAt2 == 'H') {
                            i6 = i9;
                        } else if (charAt2 == 'M') {
                            i7 = i9;
                        } else if (charAt2 == 'S') {
                            i8 = i9;
                        } else if (charAt2 == 'D') {
                            i5 = i9;
                        } else if (charAt2 != 'T') {
                            throw new IllegalArgumentException("Duration.parse(str='" + str + "') unexpected char '" + charAt2 + "' at index=" + i3);
                        }
                        i9 = 0;
                    } else {
                        i9 = (i9 * 10) + (charAt2 - '0');
                    }
                    i3++;
                }
                int i10 = i * ((i4 * 604800) + (i5 * 86400) + (i6 * 3600) + (i7 * 60) + i8);
                ILog.a(TAG, "parseDurationValue,value:" + i10);
                return i10;
            }
            throw new IllegalArgumentException(("Duration.parse(str='" + str + "') expected 'P' at index=" + i2).toString());
        }
        throw new IllegalArgumentException("Null or empty RFC string".toString());
    }

    public final void setEnd_day(int i) {
        this.end_day = i;
    }

    public final void setEnd_dayOfWeek(int i) {
        this.end_dayOfWeek = i;
    }

    public final void setEnd_hour(int i) {
        this.end_hour = i;
    }

    public final void setEnd_minute(int i) {
        this.end_minute = i;
    }

    public final void setEnd_month(int i) {
        this.end_month = i;
    }

    public final void setEnd_second(int i) {
        this.end_second = i;
    }

    public final void setEnd_year(int i) {
        this.end_year = i;
    }

    public final void setInstanceBegin(long j) {
        this.instanceBegin = j;
    }

    public final void setInstanceEnd(long j) {
        this.instanceEnd = j;
    }

    public final void setInstanceId(@Nullable String str) {
        this.instanceId = str;
    }

    public final void setStart_day(int i) {
        this.start_day = i;
    }

    public final void setStart_dayOfWeek(int i) {
        this.start_dayOfWeek = i;
    }

    public final void setStart_hour(int i) {
        this.start_hour = i;
    }

    public final void setStart_minute(int i) {
        this.start_minute = i;
    }

    public final void setStart_month(int i) {
        this.start_month = i;
    }

    public final void setStart_second(int i) {
        this.start_second = i;
    }

    public final void setStart_year(int i) {
        this.start_year = i;
    }

    @NotNull
    public final String timeFormat() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d-%02d-%02d %02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(this.start_year), Integer.valueOf(this.start_month), Integer.valueOf(this.start_day), Integer.valueOf(this.start_hour), Integer.valueOf(this.start_minute), Integer.valueOf(this.start_second)}, 6));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @NotNull
    public final String timeInfo() {
        int i = this.start_year;
        int i2 = this.start_month;
        int i3 = this.start_day;
        int i4 = this.start_hour;
        int i5 = this.start_minute;
        int i6 = this.start_second;
        return i + "年" + i2 + "月" + i3 + "日" + i4 + "点" + i5 + "分" + i6 + "秒";
    }

    @NotNull
    public String toString() {
        String id = getId();
        String title = getTitle();
        return "Schedule(id=" + id + ", title=" + title + ")";
    }

    public final void updateParamForUI() {
        if (isRepeatSchedule()) {
            updateParamForUI(getDtStart(), getDtStart() + (((long) parseDurationValue(getDuration())) * 1000));
            return;
        }
        long dtStart = getDtStart();
        Long dtEnd = getDtEnd();
        Intrinsics.checkNotNull(dtEnd);
        updateParamForUI(dtStart, dtEnd.longValue());
    }

    private final void updateParamForUI(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(new Date(j2));
        this.start_year = instance.get(1);
        this.start_month = instance.get(2) + 1;
        this.start_day = instance.get(5);
        this.start_hour = instance.get(11);
        this.start_minute = instance.get(12);
        this.start_second = instance.get(13);
        this.start_dayOfWeek = instance.get(7) - 1;
        this.end_year = instance2.get(1);
        this.end_month = instance2.get(2) + 1;
        this.end_day = instance2.get(5);
        this.end_hour = instance2.get(11);
        this.end_minute = instance2.get(12);
        this.end_second = instance2.get(13);
        this.end_dayOfWeek = instance2.get(7) - 1;
    }

    public Schedule(@NotNull Event event, @NotNull Instance instance) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(instance, "instance");
        setId(event.getId());
        setTitle(event.getTitle());
        setDuration(event.getDuration());
        setRrule(event.getRrule());
        setDtStart(event.getDtStart());
        setDtEnd(event.getDtEnd());
        setExDate(event.getExDate());
        this.instanceId = instance.getId();
        this.instanceBegin = instance.getBegin();
        long end = instance.getEnd();
        this.instanceEnd = end;
        updateParamForUI(this.instanceBegin, end);
    }
}
