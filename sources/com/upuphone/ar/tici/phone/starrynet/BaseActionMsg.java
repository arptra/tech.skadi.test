package com.upuphone.ar.tici.phone.starrynet;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "action", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class BaseActionMsg extends BaseJsonMsg {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String MSG_APP_CANCEL_TICI = "app_cancel_tici";
    @NotNull
    public static final String MSG_AUTO_TICI_RUNNING = "auto_tici_running";
    @NotNull
    public static final String MSG_CHANGE_TICI_MODE = "change_tici_mode";
    @NotNull
    public static final String MSG_CHECK_TICI_STATE = "check_tici_state";
    @NotNull
    public static final String MSG_CHECK_TICI_STATE_REPLY = "check_tici_state_reply";
    @NotNull
    public static final String MSG_GLASSES_QUIT = "glasses_quit_msg";
    @NotNull
    public static final String MSG_GLASS_TICI_STARTED = "glass_tici_started";
    @NotNull
    public static final String MSG_HIGHLIGHT_INDEX = "highlight_index";
    @NotNull
    public static final String MSG_HIGHLIGHT_INDEX_V3 = "highlight_index_v3";
    @NotNull
    public static final String MSG_OPEN_FROM_GLASSES = "open_from_glasses";
    @NotNull
    public static final String MSG_OPEN_RESULT = "open_result";
    @NotNull
    public static final String MSG_OPEN_RESULT_V2 = "open_result_v2";
    @NotNull
    public static final String MSG_OPEN_RESULT_V3 = "open_result_v3";
    @NotNull
    public static final String MSG_REQUEST_SEND_CONTENT_PAGE = "request_send_content_page";
    @NotNull
    public static final String MSG_SEND_CONTENT = "send_content";
    @NotNull
    public static final String MSG_SEND_CONTENT_PAGE = "send_content_page";
    @NotNull
    public static final String MSG_SEND_CONTENT_PAGE_REPLY = "send_content_page_reply";
    @NotNull
    public static final String MSG_SEND_CONTENT_REPLY = "send_content_reply";
    @NotNull
    public static final String MSG_SYNC_PARAGRAPH_INFO = "sync_paragraph_info";
    @SerializedName("action")
    @NotNull
    private final String action;
    @SerializedName("value")
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg$Companion;", "", "()V", "MSG_APP_CANCEL_TICI", "", "MSG_AUTO_TICI_RUNNING", "MSG_CHANGE_TICI_MODE", "MSG_CHECK_TICI_STATE", "MSG_CHECK_TICI_STATE_REPLY", "MSG_GLASSES_QUIT", "MSG_GLASS_TICI_STARTED", "MSG_HIGHLIGHT_INDEX", "MSG_HIGHLIGHT_INDEX_V3", "MSG_OPEN_FROM_GLASSES", "MSG_OPEN_RESULT", "MSG_OPEN_RESULT_V2", "MSG_OPEN_RESULT_V3", "MSG_REQUEST_SEND_CONTENT_PAGE", "MSG_SEND_CONTENT", "MSG_SEND_CONTENT_PAGE", "MSG_SEND_CONTENT_PAGE_REPLY", "MSG_SEND_CONTENT_REPLY", "MSG_SYNC_PARAGRAPH_INFO", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseActionMsg(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ BaseActionMsg copy$default(BaseActionMsg baseActionMsg, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = baseActionMsg.action;
        }
        if ((i & 2) != 0) {
            str2 = baseActionMsg.value;
        }
        return baseActionMsg.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final BaseActionMsg copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        return new BaseActionMsg(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseActionMsg)) {
            return false;
        }
        BaseActionMsg baseActionMsg = (BaseActionMsg) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) baseActionMsg.action) && Intrinsics.areEqual((Object) this.value, (Object) baseActionMsg.value);
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.action.hashCode() * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.action;
        String str2 = this.value;
        return "BaseActionMsg(action=" + str + ", value=" + str2 + ")";
    }

    public BaseActionMsg(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        this.action = str;
        this.value = str2;
    }
}
