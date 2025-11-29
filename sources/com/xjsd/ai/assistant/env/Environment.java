package com.xjsd.ai.assistant.env;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/xjsd/ai/assistant/env/Environment;", "", "asrUrl", "", "nluUrl", "aiRecordUrl", "appId", "userKey", "userSecret", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAiRecordUrl", "()Ljava/lang/String;", "setAiRecordUrl", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAsrUrl", "setAsrUrl", "getNluUrl", "setNluUrl", "getUserKey", "setUserKey", "getUserSecret", "setUserSecret", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class Environment {
    @NotNull
    private String aiRecordUrl;
    @NotNull
    private String appId;
    @NotNull
    private String asrUrl;
    @NotNull
    private String nluUrl;
    @NotNull
    private String userKey;
    @NotNull
    private String userSecret;

    public Environment(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "asrUrl");
        Intrinsics.checkNotNullParameter(str2, "nluUrl");
        Intrinsics.checkNotNullParameter(str3, "aiRecordUrl");
        Intrinsics.checkNotNullParameter(str4, "appId");
        Intrinsics.checkNotNullParameter(str5, "userKey");
        Intrinsics.checkNotNullParameter(str6, "userSecret");
        this.asrUrl = str;
        this.nluUrl = str2;
        this.aiRecordUrl = str3;
        this.appId = str4;
        this.userKey = str5;
        this.userSecret = str6;
    }

    public static /* synthetic */ Environment copy$default(Environment environment, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = environment.asrUrl;
        }
        if ((i & 2) != 0) {
            str2 = environment.nluUrl;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = environment.aiRecordUrl;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = environment.appId;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = environment.userKey;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = environment.userSecret;
        }
        return environment.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.asrUrl;
    }

    @NotNull
    public final String component2() {
        return this.nluUrl;
    }

    @NotNull
    public final String component3() {
        return this.aiRecordUrl;
    }

    @NotNull
    public final String component4() {
        return this.appId;
    }

    @NotNull
    public final String component5() {
        return this.userKey;
    }

    @NotNull
    public final String component6() {
        return this.userSecret;
    }

    @NotNull
    public final Environment copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "asrUrl");
        Intrinsics.checkNotNullParameter(str2, "nluUrl");
        Intrinsics.checkNotNullParameter(str3, "aiRecordUrl");
        Intrinsics.checkNotNullParameter(str4, "appId");
        Intrinsics.checkNotNullParameter(str5, "userKey");
        Intrinsics.checkNotNullParameter(str6, "userSecret");
        return new Environment(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Environment)) {
            return false;
        }
        Environment environment = (Environment) obj;
        return Intrinsics.areEqual((Object) this.asrUrl, (Object) environment.asrUrl) && Intrinsics.areEqual((Object) this.nluUrl, (Object) environment.nluUrl) && Intrinsics.areEqual((Object) this.aiRecordUrl, (Object) environment.aiRecordUrl) && Intrinsics.areEqual((Object) this.appId, (Object) environment.appId) && Intrinsics.areEqual((Object) this.userKey, (Object) environment.userKey) && Intrinsics.areEqual((Object) this.userSecret, (Object) environment.userSecret);
    }

    @NotNull
    public final String getAiRecordUrl() {
        return this.aiRecordUrl;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAsrUrl() {
        return this.asrUrl;
    }

    @NotNull
    public final String getNluUrl() {
        return this.nluUrl;
    }

    @NotNull
    public final String getUserKey() {
        return this.userKey;
    }

    @NotNull
    public final String getUserSecret() {
        return this.userSecret;
    }

    public int hashCode() {
        return (((((((((this.asrUrl.hashCode() * 31) + this.nluUrl.hashCode()) * 31) + this.aiRecordUrl.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.userKey.hashCode()) * 31) + this.userSecret.hashCode();
    }

    public final void setAiRecordUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aiRecordUrl = str;
    }

    public final void setAppId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final void setAsrUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.asrUrl = str;
    }

    public final void setNluUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nluUrl = str;
    }

    public final void setUserKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userKey = str;
    }

    public final void setUserSecret(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userSecret = str;
    }

    @NotNull
    public String toString() {
        String str = this.asrUrl;
        String str2 = this.nluUrl;
        String str3 = this.aiRecordUrl;
        String str4 = this.appId;
        String str5 = this.userKey;
        String str6 = this.userSecret;
        return "Environment(asrUrl=" + str + ", nluUrl=" + str2 + ", aiRecordUrl=" + str3 + ", appId=" + str4 + ", userKey=" + str5 + ", userSecret=" + str6 + ")";
    }
}
