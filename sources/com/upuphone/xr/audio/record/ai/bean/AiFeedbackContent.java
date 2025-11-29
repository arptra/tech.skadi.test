package com.upuphone.xr.audio.record.ai.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/audio/record/ai/bean/AiFeedbackContent;", "", "", "content", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getContent", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
public final class AiFeedbackContent {

    /* renamed from: a  reason: collision with root package name */
    public final String f6559a;

    public AiFeedbackContent(String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.f6559a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AiFeedbackContent) && Intrinsics.areEqual((Object) this.f6559a, (Object) ((AiFeedbackContent) obj).f6559a);
    }

    public int hashCode() {
        return this.f6559a.hashCode();
    }

    public String toString() {
        String str = this.f6559a;
        return "AiFeedbackContent(content=" + str + ")";
    }
}
