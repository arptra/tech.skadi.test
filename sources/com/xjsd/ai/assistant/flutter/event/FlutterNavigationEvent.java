package com.xjsd.ai.assistant.flutter.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/event/FlutterNavigationEvent;", "", "", "data", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "setData", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FlutterNavigationEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f8483a;

    public FlutterNavigationEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        this.f8483a = str;
    }

    public final String a() {
        return this.f8483a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FlutterNavigationEvent) && Intrinsics.areEqual((Object) this.f8483a, (Object) ((FlutterNavigationEvent) obj).f8483a);
    }

    public int hashCode() {
        return this.f8483a.hashCode();
    }

    public String toString() {
        String str = this.f8483a;
        return "FlutterNavigationEvent(data=" + str + ")";
    }
}
