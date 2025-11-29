package com.xjsd.xr.sapp.asr.dao;

import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrMessageState;", "", "action", "", "code", "desc", "illustrate", "processDesc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getCode", "getDesc", "getIllustrate", "getProcessDesc", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrMessageState {
    @NotNull
    private final String action;
    @NotNull
    private final String code;
    @NotNull
    private final String desc;
    @NotNull
    private final String illustrate;
    @NotNull
    private final String processDesc;

    public AsrMessageState() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AsrMessageState copy$default(AsrMessageState asrMessageState, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = asrMessageState.action;
        }
        if ((i & 2) != 0) {
            str2 = asrMessageState.code;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = asrMessageState.desc;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = asrMessageState.illustrate;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = asrMessageState.processDesc;
        }
        return asrMessageState.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final String component2() {
        return this.code;
    }

    @NotNull
    public final String component3() {
        return this.desc;
    }

    @NotNull
    public final String component4() {
        return this.illustrate;
    }

    @NotNull
    public final String component5() {
        return this.processDesc;
    }

    @NotNull
    public final AsrMessageState copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "code");
        Intrinsics.checkNotNullParameter(str3, "desc");
        Intrinsics.checkNotNullParameter(str4, "illustrate");
        Intrinsics.checkNotNullParameter(str5, "processDesc");
        return new AsrMessageState(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrMessageState)) {
            return false;
        }
        AsrMessageState asrMessageState = (AsrMessageState) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) asrMessageState.action) && Intrinsics.areEqual((Object) this.code, (Object) asrMessageState.code) && Intrinsics.areEqual((Object) this.desc, (Object) asrMessageState.desc) && Intrinsics.areEqual((Object) this.illustrate, (Object) asrMessageState.illustrate) && Intrinsics.areEqual((Object) this.processDesc, (Object) asrMessageState.processDesc);
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getIllustrate() {
        return this.illustrate;
    }

    @NotNull
    public final String getProcessDesc() {
        return this.processDesc;
    }

    public int hashCode() {
        return (((((((this.action.hashCode() * 31) + this.code.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.illustrate.hashCode()) * 31) + this.processDesc.hashCode();
    }

    @NotNull
    public String toString() {
        return "AsrMessageState(code='" + this.code + "', desc='" + this.desc + "', illustrate='" + this.illustrate + "', processDesc='" + this.processDesc + "')";
    }

    public AsrMessageState(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "code");
        Intrinsics.checkNotNullParameter(str3, "desc");
        Intrinsics.checkNotNullParameter(str4, "illustrate");
        Intrinsics.checkNotNullParameter(str5, "processDesc");
        this.action = str;
        this.code = str2;
        this.desc = str3;
        this.illustrate = str4;
        this.processDesc = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AsrMessageState(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "0" : str2, (i & 4) != 0 ? "success" : str3, (i & 8) != 0 ? "成功" : str4, (i & 16) != 0 ? "" : str5);
    }
}
