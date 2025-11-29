package com.upuphone.xr.sapp.monitor.starry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.honey.account.view.web.WebJs;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.starry.cmd.CmdAction;
import com.upuphone.xr.sapp.monitor.starry.model.DialogCmdModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/starry/NotificationCmdHandler;", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "()V", "dealDialogAction", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "getAction", "", "msg", "initCmdHandler", "onMessageReceive", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NotificationCmdHandler extends MessageReceiver {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "NotificationCmdHandler";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/starry/NotificationCmdHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void dealDialogAction(StarryNetMessage starryNetMessage) {
        ULog.Delegate delegate = ULog.f6446a;
        String message = starryNetMessage.getMessage();
        delegate.g(TAG, "dealDialogAction message:" + message);
        DialogCmdModel dialogCmdModel = (DialogCmdModel) new Gson().fromJson(starryNetMessage.getMessage(), DialogCmdModel.class);
        if (Intrinsics.areEqual((Object) dialogCmdModel.getId(), (Object) "using_phone_prompt_glass_id")) {
            if (Intrinsics.areEqual((Object) dialogCmdModel.getAction(), (Object) CmdAction.CMD_DIALOG_CONFIRM)) {
                SuperNotificationManager.f7749a.O(false);
            }
            if (Intrinsics.areEqual((Object) dialogCmdModel.getAction(), (Object) CmdAction.CMD_DIALOG_CANCEL)) {
                SuperNotificationManager.f7749a.O(true);
            }
        }
    }

    private final String getAction(String str) {
        if (str == null) {
            return null;
        }
        JsonElement parseString = JsonParser.parseString(str);
        if (!(parseString instanceof JsonObject)) {
            return null;
        }
        JsonObject jsonObject = (JsonObject) parseString;
        if (jsonObject.has(WebJs.ACTION)) {
            return jsonObject.get(WebJs.ACTION).getAsString();
        }
        return null;
    }

    public final void initCmdHandler() {
        StarryMessageHelper.f7799a.j(this);
    }

    public void onMessageReceive(@NotNull StarryNetMessage starryNetMessage) {
        Intrinsics.checkNotNullParameter(starryNetMessage, "message");
        try {
            Result.Companion companion = Result.Companion;
            String action = getAction(starryNetMessage.getMessage());
            if (Intrinsics.areEqual((Object) action, (Object) CmdAction.CMD_DIALOG_CONFIRM) ? true : Intrinsics.areEqual((Object) action, (Object) CmdAction.CMD_DIALOG_CANCEL)) {
                dealDialogAction(starryNetMessage);
            }
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }
}
