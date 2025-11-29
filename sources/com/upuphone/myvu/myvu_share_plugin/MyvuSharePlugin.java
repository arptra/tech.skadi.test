package com.upuphone.myvu.myvu_share_plugin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.upuphone.runasone.share.api.ApiConstant;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.model.sharedata.XhsImageInfo;
import com.xingin.xhssharesdk.model.sharedata.XhsImageResourceBean;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.BooleanUtils;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ'\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ/\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010-¨\u00060"}, d2 = {"Lcom/upuphone/myvu/myvu_share_plugin/MyvuSharePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "<init>", "()V", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "flutterPluginBinding", "", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "Lio/flutter/plugin/common/MethodCall;", "call", "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "binding", "onDetachedFromEngine", "h", "g", "d", "Landroid/content/Context;", "context", "", "imagePath", "e", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodChannel$Result;Ljava/lang/String;)V", "f", "", "state", "error", "", "", "b", "(ILjava/lang/String;)Ljava/util/Map;", "Lio/flutter/plugin/common/MethodChannel;", "a", "Lio/flutter/plugin/common/MethodChannel;", "channel", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "c", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "wxapi", "Lcom/sina/weibo/sdk/openapi/IWBAPI;", "Lcom/sina/weibo/sdk/openapi/IWBAPI;", "mWBAPI", "Companion", "myvu_share_plugin_release"}, k = 1, mv = {1, 7, 1})
public final class MyvuSharePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel f6428a;
    public FlutterPlugin.FlutterPluginBinding b;
    public IWXAPI c;
    public IWBAPI d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/myvu/myvu_share_plugin/MyvuSharePlugin$Companion;", "", "()V", "ACTION_WECHAT_SHARE_RESULT", "", "ACTION_WEIBO_SHARE_RESULT", "PLUGIN_METHOD_IS_CLIENT_INSTALLED", "PLUGIN_METHOD_REGIST", "PLUGIN_METHOD_SHARE", "TAG", "myvu_share_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ Map c(MyvuSharePlugin myvuSharePlugin, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return myvuSharePlugin.b(i, str);
    }

    public final Map b(int i, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("state", Integer.valueOf(i));
        if (str != null) {
            linkedHashMap.put("error", str);
        }
        return linkedHashMap;
    }

    public final void d(MethodCall methodCall, MethodChannel.Result result) {
        Map map;
        HashMap hashMap = (HashMap) methodCall.arguments();
        if (hashMap != null) {
            Object obj = hashMap.get("platform");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding = null;
            if (intValue == SharePlatform.wechatSession.ordinal() || intValue == SharePlatform.wechatTimeline.ordinal()) {
                if (this.c == null) {
                    FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.b;
                    if (flutterPluginBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        flutterPluginBinding2 = null;
                    }
                    Context applicationContext = flutterPluginBinding2.getApplicationContext();
                    Object obj2 = hashMap.get("app_id");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    this.c = WXAPIFactory.createWXAPI(applicationContext, (String) obj2, false);
                }
                ShareUtil shareUtil = ShareUtil.f6433a;
                FlutterPlugin.FlutterPluginBinding flutterPluginBinding3 = this.b;
                if (flutterPluginBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                } else {
                    flutterPluginBinding = flutterPluginBinding3;
                }
                Context applicationContext2 = flutterPluginBinding.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "flutterPluginBinding.applicationContext");
                map = ShareUtil.f(shareUtil, intValue, applicationContext2, this.c, (IWBAPI) null, 8, (Object) null);
            } else if (intValue == SharePlatform.sinaWeiBo.ordinal()) {
                if (this.d == null) {
                    FlutterPlugin.FlutterPluginBinding flutterPluginBinding4 = this.b;
                    if (flutterPluginBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        flutterPluginBinding4 = null;
                    }
                    this.d = WBAPIFactory.createWBAPI(flutterPluginBinding4.getApplicationContext());
                }
                ShareUtil shareUtil2 = ShareUtil.f6433a;
                FlutterPlugin.FlutterPluginBinding flutterPluginBinding5 = this.b;
                if (flutterPluginBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                } else {
                    flutterPluginBinding = flutterPluginBinding5;
                }
                Context applicationContext3 = flutterPluginBinding.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext3, "flutterPluginBinding.applicationContext");
                map = ShareUtil.f(shareUtil2, intValue, applicationContext3, (IWXAPI) null, this.d, 4, (Object) null);
            } else {
                ShareUtil shareUtil3 = ShareUtil.f6433a;
                FlutterPlugin.FlutterPluginBinding flutterPluginBinding6 = this.b;
                if (flutterPluginBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                } else {
                    flutterPluginBinding = flutterPluginBinding6;
                }
                Context applicationContext4 = flutterPluginBinding.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext4, "flutterPluginBinding.applicationContext");
                map = ShareUtil.f(shareUtil3, intValue, applicationContext4, (IWXAPI) null, (IWBAPI) null, 12, (Object) null);
            }
            result.success(map);
        }
    }

    public final void e(Context context, MethodChannel.Result result, String str) {
        context.registerReceiver(new MyvuSharePlugin$registSinaWeiboShareBroadcast$1(result, this, str), new IntentFilter("com.upuphone.star.launcher.action_weibo_share_result"), 4);
    }

    public final void f(Context context, MethodChannel.Result result, String str) {
        context.registerReceiver(new MyvuSharePlugin$registWechatShareBroadcast$1(result, this, str), new IntentFilter("com.upuphone.star.launcher.action_share_result"), 4);
    }

    public final void g(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        HashMap hashMap = (HashMap) methodCall.arguments();
        if (hashMap != null) {
            Object obj = hashMap.get("platform");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            Object obj2 = hashMap.get(PayloadConstant.KEY_PARAMS);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
            HashMap hashMap2 = (HashMap) obj2;
            if (intValue != SharePlatform.qq.ordinal()) {
                FlutterPlugin.FlutterPluginBinding flutterPluginBinding = null;
                if (intValue == SharePlatform.sinaWeiBo.ordinal()) {
                    String str2 = (String) hashMap2.get("app_key");
                    if (str2 != null) {
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.b;
                        if (flutterPluginBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                            flutterPluginBinding2 = null;
                        }
                        AuthInfo authInfo = new AuthInfo(flutterPluginBinding2.getApplicationContext(), str2, (String) hashMap2.get("redirect_url"), "");
                        if (this.d == null) {
                            FlutterPlugin.FlutterPluginBinding flutterPluginBinding3 = this.b;
                            if (flutterPluginBinding3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                                flutterPluginBinding3 = null;
                            }
                            this.d = WBAPIFactory.createWBAPI(flutterPluginBinding3.getApplicationContext());
                        }
                        IWBAPI iwbapi = this.d;
                        Intrinsics.checkNotNull(iwbapi);
                        iwbapi.setLoggerEnable(true);
                        IWBAPI iwbapi2 = this.d;
                        Intrinsics.checkNotNull(iwbapi2);
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding4 = this.b;
                        if (flutterPluginBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding4;
                        }
                        iwbapi2.registerApp(flutterPluginBinding.getApplicationContext(), authInfo);
                        result.success(Boolean.TRUE);
                    }
                } else if (intValue == SharePlatform.littleRedBook.ordinal()) {
                    String str3 = (String) hashMap2.get("app_key");
                    if (str3 != null) {
                        ShareUtil shareUtil = ShareUtil.f6433a;
                        Intrinsics.checkNotNullExpressionValue(str3, "appKey");
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding5 = this.b;
                        if (flutterPluginBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding5;
                        }
                        Context applicationContext = flutterPluginBinding.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
                        shareUtil.g(str3, applicationContext, new MyvuSharePlugin$registWithArgs$1$2$1(result));
                    }
                } else if ((intValue == SharePlatform.wechatSession.ordinal() || intValue == SharePlatform.wechatTimeline.ordinal()) && (str = (String) hashMap2.get("app_id")) != null) {
                    if (this.c == null) {
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding6 = this.b;
                        if (flutterPluginBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding6;
                        }
                        this.c = WXAPIFactory.createWXAPI(flutterPluginBinding.getApplicationContext(), str, false);
                    }
                    ShareUtil shareUtil2 = ShareUtil.f6433a;
                    Intrinsics.checkNotNullExpressionValue(str, "appId");
                    IWXAPI iwxapi = this.c;
                    Intrinsics.checkNotNull(iwxapi);
                    result.success(Boolean.valueOf(shareUtil2.h(str, iwxapi)));
                }
            }
        }
    }

    public final void h(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        HashMap hashMap = (HashMap) methodCall.arguments();
        if (hashMap != null) {
            Object obj = hashMap.get("platform");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            Object obj2 = hashMap.get(PayloadConstant.KEY_PARAMS);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
            HashMap hashMap2 = (HashMap) obj2;
            if (intValue != SharePlatform.qq.ordinal()) {
                FlutterPlugin.FlutterPluginBinding flutterPluginBinding = null;
                if (intValue == SharePlatform.sinaWeiBo.ordinal()) {
                    String str3 = (String) hashMap2.get("image_path");
                    if (str3 != null) {
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.b;
                        if (flutterPluginBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                            flutterPluginBinding2 = null;
                        }
                        Context applicationContext = flutterPluginBinding2.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
                        Intrinsics.checkNotNullExpressionValue(str3, "imagePath");
                        e(applicationContext, result, str3);
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding3 = this.b;
                        if (flutterPluginBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                            flutterPluginBinding3 = null;
                        }
                        Intent intent = new Intent(flutterPluginBinding3.getApplicationContext(), SinaActivity.class);
                        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                        intent.putExtra("image_path", str3);
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding4 = this.b;
                        if (flutterPluginBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding4;
                        }
                        flutterPluginBinding.getApplicationContext().startActivity(intent);
                    }
                } else if (intValue == SharePlatform.littleRedBook.ordinal()) {
                    String str4 = (String) hashMap2.get("image_path");
                    if (str4 != null) {
                        Log.d("MyvuSharePlugin", "shareWithArgs: " + str4);
                        XhsNote xhsNote = new XhsNote();
                        xhsNote.setImageInfo(new XhsImageInfo((List<XhsImageResourceBean>) CollectionsKt.listOf(new XhsImageResourceBean(new File(str4)))));
                        XhsShareSdk.setShareCallback(new MyvuSharePlugin$shareWithArgs$1$2$1(result, this, str4));
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding5 = this.b;
                        if (flutterPluginBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding5;
                        }
                        XhsShareSdk.shareNote(flutterPluginBinding.getApplicationContext(), xhsNote);
                    }
                } else if (intValue == SharePlatform.wechatSession.ordinal()) {
                    if (Intrinsics.areEqual(hashMap2.get("isThirdPlatform"), (Object) BooleanUtils.FALSE)) {
                        ShareUtil shareUtil = ShareUtil.f6433a;
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding6 = this.b;
                        if (flutterPluginBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding6;
                        }
                        Context applicationContext2 = flutterPluginBinding.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext2, "flutterPluginBinding.applicationContext");
                        Object obj3 = hashMap2.get("image_path");
                        Intrinsics.checkNotNull(obj3);
                        shareUtil.i(applicationContext2, (String) obj3, "com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
                        return;
                    }
                    IWXAPI iwxapi = this.c;
                    if (iwxapi != null && (str2 = (String) hashMap2.get("image_path")) != null) {
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding7 = this.b;
                        if (flutterPluginBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                            flutterPluginBinding7 = null;
                        }
                        Context applicationContext3 = flutterPluginBinding7.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext3, "flutterPluginBinding.applicationContext");
                        Intrinsics.checkNotNullExpressionValue(str2, "imagePath");
                        f(applicationContext3, result, str2);
                        ShareUtil shareUtil2 = ShareUtil.f6433a;
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding8 = this.b;
                        if (flutterPluginBinding8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding8;
                        }
                        Context applicationContext4 = flutterPluginBinding.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext4, "flutterPluginBinding.applicationContext");
                        shareUtil2.j(iwxapi, str2, 0, applicationContext4);
                    }
                } else if (intValue != SharePlatform.wechatTimeline.ordinal()) {
                } else {
                    if (Intrinsics.areEqual(hashMap2.get("isThirdPlatform"), (Object) BooleanUtils.FALSE)) {
                        ShareUtil shareUtil3 = ShareUtil.f6433a;
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding9 = this.b;
                        if (flutterPluginBinding9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding9;
                        }
                        Context applicationContext5 = flutterPluginBinding.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext5, "flutterPluginBinding.applicationContext");
                        Object obj4 = hashMap2.get("image_path");
                        Intrinsics.checkNotNull(obj4);
                        shareUtil3.i(applicationContext5, (String) obj4, "com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
                        return;
                    }
                    IWXAPI iwxapi2 = this.c;
                    if (iwxapi2 != null && (str = (String) hashMap2.get("image_path")) != null) {
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding10 = this.b;
                        if (flutterPluginBinding10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                            flutterPluginBinding10 = null;
                        }
                        Context applicationContext6 = flutterPluginBinding10.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext6, "flutterPluginBinding.applicationContext");
                        Intrinsics.checkNotNullExpressionValue(str, "imagePath");
                        f(applicationContext6, result, str);
                        ShareUtil shareUtil4 = ShareUtil.f6433a;
                        FlutterPlugin.FlutterPluginBinding flutterPluginBinding11 = this.b;
                        if (flutterPluginBinding11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
                        } else {
                            flutterPluginBinding = flutterPluginBinding11;
                        }
                        Context applicationContext7 = flutterPluginBinding.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext7, "flutterPluginBinding.applicationContext");
                        shareUtil4.j(iwxapi2, str, 1, applicationContext7);
                    }
                }
            }
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.b = flutterPluginBinding;
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "myvu_share_plugin");
        this.f6428a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f6428a;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -934795402) {
                if (hashCode != 109400031) {
                    if (hashCode == 968747365 && str.equals("isClientInstalled")) {
                        d(methodCall, result);
                        return;
                    }
                } else if (str.equals(ApiConstant.COMPONENT)) {
                    h(methodCall, result);
                    return;
                }
            } else if (str.equals("regist")) {
                g(methodCall, result);
                return;
            }
        }
        result.notImplemented();
    }
}
