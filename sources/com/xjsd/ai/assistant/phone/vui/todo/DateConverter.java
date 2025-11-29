package com.xjsd.ai.assistant.phone.vui.todo;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/todo/DateConverter;", "", "<init>", "()V", "", "value", "Ljava/util/Date;", "b", "(Ljava/lang/Long;)Ljava/util/Date;", "date", "a", "(Ljava/util/Date;)Ljava/lang/Long;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDateConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateConverter.kt\ncom/xjsd/ai/assistant/phone/vui/todo/DateConverter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
public final class DateConverter {
    public final Long a(Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }

    public final Date b(Long l) {
        if (l != null) {
            return new Date(l.longValue());
        }
        return null;
    }
}
