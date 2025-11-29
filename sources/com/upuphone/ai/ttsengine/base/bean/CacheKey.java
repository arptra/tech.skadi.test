package com.upuphone.ai.ttsengine.base.bean;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\tR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\tR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0017\u0010\tR\u001b\u0010\u0019\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0015\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;", "", "", "voiceId", "language", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "a", "Ljava/lang/String;", "getVoiceId", "b", "getLanguage", "c", "Lkotlin/Lazy;", "key", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CacheKey {

    /* renamed from: a  reason: collision with root package name */
    public final String f5493a;
    public final String b;
    public final String c;
    public final Lazy d = LazyKt.lazy(new CacheKey$key$2(this));

    public CacheKey(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str3, "text");
        this.f5493a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String b() {
        return (String) this.d.getValue();
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        String str = this.f5493a;
        if (str != null && (!StringsKt.isBlank(str))) {
            sb.append(this.f5493a);
            sb.append('_');
        }
        String str2 = this.b;
        if (str2 != null && (!StringsKt.isBlank(str2))) {
            sb.append(this.b);
            sb.append('_');
        }
        sb.append(this.c);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheKey)) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) obj;
        return Intrinsics.areEqual((Object) this.f5493a, (Object) cacheKey.f5493a) && Intrinsics.areEqual((Object) this.b, (Object) cacheKey.b) && Intrinsics.areEqual((Object) this.c, (Object) cacheKey.c);
    }

    public int hashCode() {
        String str = this.f5493a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.c.hashCode();
    }

    public String toString() {
        String str = this.f5493a;
        String str2 = this.b;
        String str3 = this.c;
        return "CacheKey(voiceId=" + str + ", language=" + str2 + ", text=" + str3 + ")";
    }
}
