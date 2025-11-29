package com.upuphone.xr.interconnect.business.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.checknavi.CheckNaviSupportManager;
import com.upuphone.xr.interconnect.checknavi.NaviNotSupportCallback;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.LaunchAppParam;
import com.upuphone.xr.interconnect.entity.StarryNetApp;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.pm.OpenRemoteStarryNetAppCode;
import com.upuphone.xr.interconnect.pm.StarryNetAppUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\f\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/interconnect/business/app/LaunchRequestHandler;", "Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "context", "Landroid/content/Context;", "logTag", "", "agent", "Lcom/upuphone/xr/interconnect/business/app/LaunchAgent;", "localAppList", "", "Lcom/upuphone/xr/interconnect/entity/StarryNetApp;", "(Landroid/content/Context;Ljava/lang/String;Lcom/upuphone/xr/interconnect/business/app/LaunchAgent;Ljava/util/Collection;)V", "PKG_NAVI_DOCER_SERVICE", "checkPackageName", "", "remotePackageName", "localPackageName", "getHandleType", "", "handle", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "function", "Lcom/upuphone/xr/interconnect/entity/Function;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLaunchRequestHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LaunchRequestHandler.kt\ncom/upuphone/xr/interconnect/business/app/LaunchRequestHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n1855#2,2:109\n288#2,2:111\n*S KotlinDebug\n*F\n+ 1 LaunchRequestHandler.kt\ncom/upuphone/xr/interconnect/business/app/LaunchRequestHandler\n*L\n40#1:109,2\n44#1:111,2\n*E\n"})
public final class LaunchRequestHandler implements MessageHandler {
    @NotNull
    private final String PKG_NAVI_DOCER_SERVICE = "com.upuphone.ar.navi.lite.service.NaviDocerService";
    @NotNull
    private final LaunchAgent agent;
    @NotNull
    private final Context context;
    @NotNull
    private final Collection<StarryNetApp> localAppList;
    @NotNull
    private final String logTag;

    public LaunchRequestHandler(@NotNull Context context2, @NotNull String str, @NotNull LaunchAgent launchAgent, @NotNull Collection<? extends StarryNetApp> collection) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(launchAgent, "agent");
        Intrinsics.checkNotNullParameter(collection, "localAppList");
        this.context = context2;
        this.logTag = str;
        this.agent = launchAgent;
        this.localAppList = collection;
    }

    private final boolean checkPackageName(String str, String str2) {
        String str3 = this.logTag;
        boolean areEqual = Intrinsics.areEqual((Object) str, (Object) "com.upuphone.star.launcher");
        ILog.w(str3, "checkPackageName remotePackageName == Constants.SUPER_APP_PKG_NAME is " + areEqual);
        String str4 = this.logTag;
        boolean contains$default = StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null);
        ILog.w(str4, "checkPackageName localPackageName.contains(remotePackageName) is " + contains$default);
        return StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null) || Intrinsics.areEqual((Object) str, (Object) "com.upuphone.star.launcher");
    }

    public int getHandleType() {
        return 11;
    }

    public void handle(@Nullable StarryNetMessage starryNetMessage, @NotNull Function function) {
        T t;
        Intrinsics.checkNotNullParameter(function, "function");
        LaunchAppParam launchAppParam = (LaunchAppParam) function.parseData(LaunchAppParam.class);
        String appId = launchAppParam.getAppId();
        if (!StarryNetAppUtil.isStarryNetAppIdValid(appId)) {
            ILog.d(this.logTag, "启动应用参数错误");
            launchAppParam.setSuccess(false);
            launchAppParam.setCode(OpenRemoteStarryNetAppCode.CODE_STARRY_NET_APP_ID_ERROR);
            Function function2 = new Function(12, launchAppParam);
            StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
            createInnerMessage.setMessage(function2.toString());
            InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, (IMessageSendListener) null);
            return;
        }
        String paresStarryNetAppPackage = StarryNetAppUtil.paresStarryNetAppPackage(appId);
        String parseStarryNetAppId = StarryNetAppUtil.parseStarryNetAppId(appId);
        ILog.i(this.logTag, "message packageName = " + paresStarryNetAppPackage);
        for (StarryNetApp packageName : this.localAppList) {
            ILog.i(this.logTag, "localAppList packageName = " + packageName.getPackageName());
        }
        Iterator<T> it = this.localAppList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            StarryNetApp starryNetApp = (StarryNetApp) t;
            Intrinsics.checkNotNull(paresStarryNetAppPackage);
            String packageName2 = starryNetApp.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
            if (checkPackageName(paresStarryNetAppPackage, packageName2) && Intrinsics.areEqual((Object) starryNetApp.getId(), (Object) parseStarryNetAppId)) {
                break;
            }
        }
        StarryNetApp starryNetApp2 = (StarryNetApp) t;
        if (starryNetApp2 == null) {
            launchAppParam.setSuccess(false);
            launchAppParam.setCode(OpenRemoteStarryNetAppCode.CODE_NO_STARRY_NET_APP_ID_ERROR);
            Function function3 = new Function(12, launchAppParam);
            StarryNetMessage createInnerMessage2 = StarryNetMessageFactory.createInnerMessage();
            createInnerMessage2.setMessage(function3.toString());
            InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage2, (IMessageSendListener) null);
            return;
        }
        Intent intent = new Intent();
        int launchType = starryNetApp2.getLaunchType();
        if (launchType == -1) {
            ILog.d(this.logTag, "Calling dock menu click listener " + starryNetApp2.getEntry() + ".");
            InterconnectManager.getInstance().getStarryNetAppManager().onLocalStarryNetAppDockMenuClick(appId, launchAppParam.getMenuId());
        } else if (launchType == 0) {
            ILog.d(this.logTag, "拉起Activity--" + starryNetApp2.getEntry());
            intent.setComponent(new ComponentName(starryNetApp2.getPackageName(), starryNetApp2.getEntry()));
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            this.agent.launchActivity(intent);
        } else if (launchType == 1) {
            ILog.d(this.logTag, "拉起Service-- " + starryNetApp2.getLaunchEntry() + ",targetApp.packageName = " + starryNetApp2.getPackageName());
            String launchEntry = starryNetApp2.getLaunchEntry();
            if (launchEntry == null || launchEntry.length() == 0 || !Intrinsics.areEqual((Object) starryNetApp2.getLaunchEntry(), (Object) this.PKG_NAVI_DOCER_SERVICE)) {
                intent.setComponent(new ComponentName(starryNetApp2.getPackageName(), starryNetApp2.getLaunchEntry()));
                this.agent.launchService(intent);
            } else {
                boolean z = this.context.getSharedPreferences("navi_support_preferences", 0).getBoolean("isSupport", true);
                ILog.d(this.logTag, "--isSupport-- " + z);
                if (z) {
                    intent.setComponent(new ComponentName(starryNetApp2.getPackageName(), starryNetApp2.getLaunchEntry()));
                    this.agent.launchService(intent);
                } else {
                    NaviNotSupportCallback callBack = CheckNaviSupportManager.INSTANCE.getCallBack();
                    if (callBack != null) {
                        callBack.naviNotSupport(2);
                    }
                }
            }
        }
        launchAppParam.setSuccess(true);
        launchAppParam.setCode(200);
        Function function4 = new Function(12, launchAppParam);
        StarryNetMessage createInnerMessage3 = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage3.setMessage(function4.toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage3, (IMessageSendListener) null);
    }
}
