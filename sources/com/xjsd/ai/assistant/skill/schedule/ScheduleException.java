package com.xjsd.ai.assistant.skill.schedule;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\b\u0006\u0007\b\t\n\u000b\f\rB\u0011\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u0001\b\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "ScheduleCreateWithSqlException", "ScheduleExistInTimeException", "ScheduleReadAndWritePermissionException", "ScheduleReadPermissionException", "ScheduleWritePermissionException", "TimeFormatException", "TimeNoInfoException", "TimePassedException", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleCreateWithSqlException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleExistInTimeException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleReadAndWritePermissionException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleReadPermissionException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleWritePermissionException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$TimeFormatException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$TimeNoInfoException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$TimePassedException;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ScheduleException extends Exception {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleCreateWithSqlException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScheduleCreateWithSqlException extends ScheduleException {
        public ScheduleCreateWithSqlException() {
            super("schedule create error", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleExistInTimeException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScheduleExistInTimeException extends ScheduleException {
        public ScheduleExistInTimeException() {
            super("schedule exist", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleReadAndWritePermissionException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScheduleReadAndWritePermissionException extends ScheduleException {
        public ScheduleReadAndWritePermissionException() {
            super("schedule read and write permission", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleReadPermissionException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScheduleReadPermissionException extends ScheduleException {
        public ScheduleReadPermissionException() {
            super("schedule read permission", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$ScheduleWritePermissionException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScheduleWritePermissionException extends ScheduleException {
        public ScheduleWritePermissionException() {
            super("schedule write permission", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$TimeFormatException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimeFormatException extends ScheduleException {
        public TimeFormatException() {
            super("time format error", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$TimeNoInfoException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimeNoInfoException extends ScheduleException {
        public TimeNoInfoException() {
            super("time no info", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException$TimePassedException;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimePassedException extends ScheduleException {
        public TimePassedException() {
            super("time has passed", (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ ScheduleException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private ScheduleException(String str) {
        super(str);
    }
}
