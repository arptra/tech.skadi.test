package com.xjsd.ai.assistant.protocol.alarm;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\fJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040 j\b\u0012\u0004\u0012\u00020\u0004`!J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ \u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006&"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "", "()V", "bits", "", "(I)V", "getBits", "()I", "setBits", "count", "getCount", "isRepeating", "", "()Z", "equals", "o", "getDistanceToNextDay", "time", "Ljava/util/Calendar;", "getDistanceToPreviousDay", "hashCode", "isBitOn", "calendarDay", "setBit", "on", "toAccessibilityString", "", "context", "Landroid/content/Context;", "order", "Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays$Order;", "toAlarmClockDay", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "forceLongNames", "Companion", "Order", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWeekdays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Weekdays.kt\ncom/xjsd/ai/assistant/protocol/alarm/Weekdays\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,347:1\n215#2,2:348\n*S KotlinDebug\n*F\n+ 1 Weekdays.kt\ncom/xjsd/ai/assistant/protocol/alarm/Weekdays\n*L\n91#1:348,2\n*E\n"})
public final class Weekdays {
    /* access modifiers changed from: private */
    @NotNull
    public static final Weekdays ALL;
    private static final int ALL_DAYS = 127;
    @NotNull
    public static final Companion Companion;
    /* access modifiers changed from: private */
    @NotNull
    public static final Weekdays NONE;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<Integer, Integer> sCalendarDayToBit;
    private int bits;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bJ\u0012\u0010\u000f\u001a\u00020\u00042\n\u0010\u0010\u001a\u00020\u0011\"\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays$Companion;", "", "()V", "ALL", "Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "getALL", "()Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "ALL_DAYS", "", "NONE", "getNONE", "sCalendarDayToBit", "", "fromBits", "bits", "fromCalendarDays", "calendarDays", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Weekdays fromBits(int i) {
            return new Weekdays(i);
        }

        @NotNull
        public final Weekdays fromCalendarDays(@NotNull int... iArr) {
            Intrinsics.checkNotNullParameter(iArr, "calendarDays");
            int i = 0;
            for (int valueOf : iArr) {
                Map access$getSCalendarDayToBit$cp = Weekdays.sCalendarDayToBit;
                Intrinsics.checkNotNull(access$getSCalendarDayToBit$cp);
                Integer num = (Integer) access$getSCalendarDayToBit$cp.get(Integer.valueOf(valueOf));
                if (num != null) {
                    i |= num.intValue();
                }
            }
            return new Weekdays(i);
        }

        @NotNull
        public final Weekdays getALL() {
            return Weekdays.ALL;
        }

        @NotNull
        public final Weekdays getNONE() {
            return Weekdays.NONE;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays$Order;", "", "calendarDays", "", "", "(Ljava/lang/String;I[I)V", "", "getCalendarDays", "()Ljava/util/List;", "SAT_TO_FRI", "SUN_TO_SAT", "MON_TO_SUN", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Order {
        SAT_TO_FRI(7, 1, 2, 3, 4, 5, 6),
        SUN_TO_SAT(1, 2, 3, 4, 5, 6, 7),
        MON_TO_SUN(2, 3, 4, 5, 6, 7, 1);
        
        @NotNull
        private final List<Integer> calendarDays;

        static {
            Order[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private Order(int... iArr) {
            this.calendarDays = (iArr.length == 0) ^ true ? ArraysKt.asList(iArr) : CollectionsKt.emptyList();
        }

        @NotNull
        public static EnumEntries<Order> getEntries() {
            return $ENTRIES;
        }

        @NotNull
        public final List<Integer> getCalendarDays() {
            return this.calendarDays;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        ALL = companion.fromBits(127);
        NONE = companion.fromBits(0);
        Map<Integer, Integer> unmodifiableMap = Collections.unmodifiableMap(MapsKt.mapOf(TuplesKt.to(2, 1), TuplesKt.to(3, 2), TuplesKt.to(4, 4), TuplesKt.to(5, 8), TuplesKt.to(6, 16), TuplesKt.to(7, 32), TuplesKt.to(1, 64)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(...)");
        sCalendarDayToBit = unmodifiableMap;
    }

    public Weekdays() {
        this.bits = 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (Intrinsics.areEqual((Object) Weekdays.class, (Object) obj.getClass())) {
                return this.bits == ((Weekdays) obj).bits;
            }
        }
        return false;
    }

    public final int getBits() {
        return this.bits;
    }

    @VisibleForTesting
    public final int getCount() {
        int i = 0;
        for (int i2 = 1; i2 < 8; i2++) {
            if (isBitOn(i2)) {
                i++;
            }
        }
        return i;
    }

    public final int getDistanceToNextDay(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, RtspHeaders.Values.TIME);
        int i = calendar.get(7);
        for (int i2 = 0; i2 < 7; i2++) {
            if (isBitOn(i)) {
                return i2;
            }
            i++;
            if (i > 7) {
                i = 1;
            }
        }
        return -1;
    }

    public final int getDistanceToPreviousDay(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, RtspHeaders.Values.TIME);
        int i = calendar.get(7);
        for (int i2 = 1; i2 < 8; i2++) {
            i--;
            if (i < 1) {
                i = 7;
            }
            if (isBitOn(i)) {
                return i2;
            }
        }
        return -1;
    }

    public int hashCode() {
        return this.bits;
    }

    public final boolean isBitOn(int i) {
        Map<Integer, Integer> map = sCalendarDayToBit;
        Intrinsics.checkNotNull(map);
        Integer num = map.get(Integer.valueOf(i));
        if (num != null) {
            return (this.bits & num.intValue()) > 0;
        }
        throw new IllegalArgumentException(i + " is not a valid weekday");
    }

    public final boolean isRepeating() {
        return this.bits != 0;
    }

    @NotNull
    public final Weekdays setBit(int i, boolean z) {
        Map<Integer, Integer> map = sCalendarDayToBit;
        Intrinsics.checkNotNull(map);
        Integer num = map.get(Integer.valueOf(i));
        if (num == null) {
            return this;
        }
        int intValue = num.intValue();
        int i2 = this.bits;
        return new Weekdays(z ? i2 | intValue : i2 & (~intValue));
    }

    public final void setBits(int i) {
        this.bits = i;
    }

    @NotNull
    public final String toAccessibilityString(@NotNull Context context, @NotNull Order order) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(order, "order");
        return toString(context, order, true);
    }

    @NotNull
    public final ArrayList<Integer> toAlarmClockDay() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> key : sCalendarDayToBit.entrySet()) {
            int intValue = ((Number) key.getKey()).intValue();
            if (isBitOn(intValue)) {
                arrayList.add(Integer.valueOf(intValue));
            }
        }
        return arrayList;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder(19);
        sb.append("[");
        if (isBitOn(2)) {
            sb.append(sb.length() > 1 ? " M" : "M");
        }
        if (isBitOn(3)) {
            sb.append(sb.length() > 1 ? " T" : ExifInterface.GPS_DIRECTION_TRUE);
        }
        if (isBitOn(4)) {
            sb.append(sb.length() > 1 ? " W" : ExifInterface.LONGITUDE_WEST);
        }
        if (isBitOn(5)) {
            sb.append(sb.length() > 1 ? " Th" : "Th");
        }
        if (isBitOn(6)) {
            sb.append(sb.length() > 1 ? " F" : "F");
        }
        if (isBitOn(7)) {
            sb.append(sb.length() > 1 ? " Sa" : "Sa");
        }
        if (isBitOn(1)) {
            sb.append(sb.length() > 1 ? " Su" : "Su");
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public Weekdays(int i) {
        this.bits = i & 127;
    }

    @NotNull
    public final String toString(@NotNull Context context, @NotNull Order order) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(order, "order");
        return toString(context, order, false);
    }

    private final String toString(Context context, Order order, boolean z) {
        if (!isRepeating()) {
            return "";
        }
        if (this.bits == 127) {
            return "every_day";
        }
        boolean z2 = true;
        if (!z && getCount() > 1) {
            z2 = false;
        }
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        String[] weekdays = z2 ? dateFormatSymbols.getWeekdays() : dateFormatSymbols.getShortWeekdays();
        StringBuilder sb = new StringBuilder(40);
        for (Integer intValue : order.getCalendarDays()) {
            int intValue2 = intValue.intValue();
            if (isBitOn(intValue2)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(weekdays[intValue2]);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
