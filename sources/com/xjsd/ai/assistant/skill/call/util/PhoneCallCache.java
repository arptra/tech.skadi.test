package com.xjsd.ai.assistant.skill.call.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/util/PhoneCallCache;", "", "<init>", "()V", "", "contact", "tel", "", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setContactName", "(Ljava/lang/String;)V", "contactName", "d", "setPhoneNumber", "phoneNumber", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneCallCache {

    /* renamed from: a  reason: collision with root package name */
    public static final PhoneCallCache f8678a = new PhoneCallCache();
    public static String b;
    public static String c;

    public final void a(String str, String str2) {
        b = str;
        c = str2;
    }

    public final void b() {
        b = null;
        c = null;
    }

    public final String c() {
        return b;
    }

    public final String d() {
        return c;
    }
}
