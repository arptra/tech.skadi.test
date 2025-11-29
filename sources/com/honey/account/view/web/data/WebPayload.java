package com.honey.account.view.web.data;

import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/honey/account/view/web/data/WebPayload;", "", "eventName", "", "data", "Lcom/google/gson/JsonElement;", "cbName", "(Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/String;)V", "getCbName", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonElement;", "getEventName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WebPayload {
    @Nullable
    private final String cbName;
    @Nullable
    private final JsonElement data;
    @NotNull
    private final String eventName;

    public WebPayload(@NotNull String str, @Nullable JsonElement jsonElement, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        this.eventName = str;
        this.data = jsonElement;
        this.cbName = str2;
    }

    public static /* synthetic */ WebPayload copy$default(WebPayload webPayload, String str, JsonElement jsonElement, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webPayload.eventName;
        }
        if ((i & 2) != 0) {
            jsonElement = webPayload.data;
        }
        if ((i & 4) != 0) {
            str2 = webPayload.cbName;
        }
        return webPayload.copy(str, jsonElement, str2);
    }

    @NotNull
    public final String component1() {
        return this.eventName;
    }

    @Nullable
    public final JsonElement component2() {
        return this.data;
    }

    @Nullable
    public final String component3() {
        return this.cbName;
    }

    @NotNull
    public final WebPayload copy(@NotNull String str, @Nullable JsonElement jsonElement, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        return new WebPayload(str, jsonElement, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebPayload)) {
            return false;
        }
        WebPayload webPayload = (WebPayload) obj;
        return Intrinsics.areEqual((Object) this.eventName, (Object) webPayload.eventName) && Intrinsics.areEqual((Object) this.data, (Object) webPayload.data) && Intrinsics.areEqual((Object) this.cbName, (Object) webPayload.cbName);
    }

    @Nullable
    public final String getCbName() {
        return this.cbName;
    }

    @Nullable
    public final JsonElement getData() {
        return this.data;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    public int hashCode() {
        int hashCode = this.eventName.hashCode() * 31;
        JsonElement jsonElement = this.data;
        int i = 0;
        int hashCode2 = (hashCode + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        String str = this.cbName;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "WebPayload(eventName=" + this.eventName + ", data=" + this.data + ", cbName=" + this.cbName + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebPayload(String str, JsonElement jsonElement, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : jsonElement, (i & 4) != 0 ? null : str2);
    }
}
