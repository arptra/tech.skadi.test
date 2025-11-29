package com.xjsd.ai.assistant.skill.schedule;

import com.alibaba.fastjson.JSONObject;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u001c\u0010\u0017R\"\u0010 \u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\u0017¨\u0006!"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;", "", "Lcom/alibaba/fastjson/JSONObject;", "origin", "<init>", "(Lcom/alibaba/fastjson/JSONObject;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/alibaba/fastjson/JSONObject;", "b", "()Lcom/alibaba/fastjson/JSONObject;", "Ljava/lang/String;", "d", "h", "(Ljava/lang/String;)V", "target", "c", "g", "startTime", "f", "endTime", "e", "i", "timeText", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleParams {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f8696a;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";

    public ScheduleParams(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        this.f8696a = jSONObject;
    }

    public final String a() {
        return this.d;
    }

    public final JSONObject b() {
        return this.f8696a;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ScheduleParams) && Intrinsics.areEqual((Object) this.f8696a, (Object) ((ScheduleParams) obj).f8696a);
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public int hashCode() {
        return this.f8696a.hashCode();
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public String toString() {
        String str = this.b;
        String str2 = this.c;
        String str3 = this.d;
        String str4 = this.e;
        return "ScheduleParams(target='" + str + "', startTime='" + str2 + "', endTime='" + str3 + "', timeText='" + str4 + "')";
    }
}
