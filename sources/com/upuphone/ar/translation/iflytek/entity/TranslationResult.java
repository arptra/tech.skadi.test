package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/TranslationResult;", "", "action", "", "code", "data", "desc", "sid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getCode", "getData", "getDesc", "getSid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslationResult {
    @SerializedName("action")
    @NotNull
    private final String action;
    @SerializedName("code")
    @NotNull
    private final String code;
    @SerializedName("data")
    @NotNull
    private final String data;
    @SerializedName("desc")
    @NotNull
    private final String desc;
    @SerializedName("sid")
    @NotNull
    private final String sid;

    public TranslationResult(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "code");
        Intrinsics.checkNotNullParameter(str3, "data");
        Intrinsics.checkNotNullParameter(str4, "desc");
        Intrinsics.checkNotNullParameter(str5, "sid");
        this.action = str;
        this.code = str2;
        this.data = str3;
        this.desc = str4;
        this.sid = str5;
    }

    public static /* synthetic */ TranslationResult copy$default(TranslationResult translationResult, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = translationResult.action;
        }
        if ((i & 2) != 0) {
            str2 = translationResult.code;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = translationResult.data;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = translationResult.desc;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = translationResult.sid;
        }
        return translationResult.copy(str, str6, str7, str8, str5);
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
        return this.data;
    }

    @NotNull
    public final String component4() {
        return this.desc;
    }

    @NotNull
    public final String component5() {
        return this.sid;
    }

    @NotNull
    public final TranslationResult copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "code");
        Intrinsics.checkNotNullParameter(str3, "data");
        Intrinsics.checkNotNullParameter(str4, "desc");
        Intrinsics.checkNotNullParameter(str5, "sid");
        return new TranslationResult(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslationResult)) {
            return false;
        }
        TranslationResult translationResult = (TranslationResult) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) translationResult.action) && Intrinsics.areEqual((Object) this.code, (Object) translationResult.code) && Intrinsics.areEqual((Object) this.data, (Object) translationResult.data) && Intrinsics.areEqual((Object) this.desc, (Object) translationResult.desc) && Intrinsics.areEqual((Object) this.sid, (Object) translationResult.sid);
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
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getSid() {
        return this.sid;
    }

    public int hashCode() {
        return (((((((this.action.hashCode() * 31) + this.code.hashCode()) * 31) + this.data.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.sid.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.action;
        String str2 = this.code;
        String str3 = this.data;
        String str4 = this.desc;
        String str5 = this.sid;
        return "TranslationResult(action='" + str + "', code='" + str2 + "', data='" + str3 + "', desc='" + str4 + "', sid='" + str5 + "')";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TranslationResult(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }
}
