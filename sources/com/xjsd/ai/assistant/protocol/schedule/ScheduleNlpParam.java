package com.xjsd.ai.assistant.protocol.schedule;

import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006%"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;", "", "()V", "duration", "", "getDuration", "()Ljava/lang/String;", "setDuration", "(Ljava/lang/String;)V", "endTime", "getEndTime", "setEndTime", "index", "getIndex", "setIndex", "oldEndTime", "getOldEndTime", "setOldEndTime", "oldStartTime", "getOldStartTime", "setOldStartTime", "oldTarget", "getOldTarget", "setOldTarget", "originTime", "getOriginTime", "setOriginTime", "startTime", "getStartTime", "setStartTime", "target", "getTarget", "setTarget", "calTime", "", "update", "nlpParamFrom", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScheduleNlpParam {
    @NotNull
    private String duration = "";
    @NotNull
    private String endTime = "";
    @NotNull
    private String index = "";
    @NotNull
    private String oldEndTime = "";
    @NotNull
    private String oldStartTime = "";
    @NotNull
    private String oldTarget = "";
    @NotNull
    private String originTime = "";
    @NotNull
    private String startTime = "";
    @NotNull
    private String target = "";

    public final void calTime() {
        if (!Intrinsics.areEqual((Object) "", (Object) this.duration)) {
            Date date = new Date();
            date.getTime();
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(13, Integer.parseInt(this.duration));
            instance.getTime();
        }
    }

    @NotNull
    public final String getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getIndex() {
        return this.index;
    }

    @NotNull
    public final String getOldEndTime() {
        return this.oldEndTime;
    }

    @NotNull
    public final String getOldStartTime() {
        return this.oldStartTime;
    }

    @NotNull
    public final String getOldTarget() {
        return this.oldTarget;
    }

    @NotNull
    public final String getOriginTime() {
        return this.originTime;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getTarget() {
        return this.target;
    }

    public final void setDuration(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.duration = str;
    }

    public final void setEndTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endTime = str;
    }

    public final void setIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.index = str;
    }

    public final void setOldEndTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oldEndTime = str;
    }

    public final void setOldStartTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oldStartTime = str;
    }

    public final void setOldTarget(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oldTarget = str;
    }

    public final void setOriginTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originTime = str;
    }

    public final void setStartTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startTime = str;
    }

    public final void setTarget(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.target = str;
    }

    public final void update(@NotNull ScheduleNlpParam scheduleNlpParam) {
        Intrinsics.checkNotNullParameter(scheduleNlpParam, "nlpParamFrom");
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.originTime)) {
            this.originTime = scheduleNlpParam.originTime;
        }
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.oldStartTime)) {
            this.oldStartTime = scheduleNlpParam.oldStartTime;
        }
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.oldEndTime)) {
            this.oldEndTime = scheduleNlpParam.oldEndTime;
        }
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.oldTarget)) {
            this.oldTarget = scheduleNlpParam.oldTarget;
        }
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.startTime)) {
            this.startTime = scheduleNlpParam.startTime;
        }
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.endTime)) {
            this.endTime = scheduleNlpParam.endTime;
        }
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.target)) {
            this.target = scheduleNlpParam.target;
        }
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.duration)) {
            this.duration = scheduleNlpParam.duration;
        }
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.index)) {
            this.index = scheduleNlpParam.index;
        }
    }
}
