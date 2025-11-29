package com.xjsd.ai.assistant.skill.alarm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0011\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException;", "message", "", "(Ljava/lang/String;)V", "SqliteException", "TimeFormatException", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateException$SqliteException;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AlarmCreateException extends AlarmException {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateException$SqliteException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SqliteException extends AlarmCreateException {
        public SqliteException() {
            super("alarm create error", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateException$TimeFormatException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimeFormatException extends AlarmException {
        public TimeFormatException() {
            super("time format error", (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ AlarmCreateException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private AlarmCreateException(String str) {
        super(str, (DefaultConstructorMarker) null);
    }
}
