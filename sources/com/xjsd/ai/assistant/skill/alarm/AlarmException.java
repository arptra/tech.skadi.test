package com.xjsd.ai.assistant.skill.alarm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0006\u0007\bB\u0011\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "TimeExceedException", "TimeFormatException", "TimePassedException", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateException$TimeFormatException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException$TimeExceedException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException$TimeFormatException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException$TimePassedException;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AlarmException extends Exception {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmException$TimeExceedException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimeExceedException extends AlarmException {
        public TimeExceedException() {
            super("time exceed", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmException$TimeFormatException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimeFormatException extends AlarmException {
        public TimeFormatException() {
            super("time format error", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmException$TimePassedException;", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException;", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimePassedException extends AlarmException {
        public TimePassedException() {
            super("time has passed", (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ AlarmException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private AlarmException(String str) {
        super(str);
    }
}
