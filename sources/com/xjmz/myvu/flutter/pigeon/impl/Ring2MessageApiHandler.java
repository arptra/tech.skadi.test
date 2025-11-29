package com.xjmz.myvu.flutter.pigeon.impl;

import com.honey.account.s9.a;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.xjmz.myvu.flutter.base.BaseFlutterFragment;
import com.xjmz.myvu.flutter.pigeon.AndroidRing2MessageApi;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u000212B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J>\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2%\b\u0002\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010!J:\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000b0\u0017H\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00180+j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018`,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/Ring2MessageApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$Ring2MessageSendApi;", "Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "fragment", "<init>", "(Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$Ring2Message;", "message", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$Result;", "", "result", "", "d", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$Ring2Message;Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$Result;)V", "", "tag", "Lio/flutter/embedding/engine/FlutterEngine;", "k", "(Ljava/lang/String;)Lio/flutter/embedding/engine/FlutterEngine;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$Ring2MessageReceiveApi;", "o", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$Ring2MessageReceiveApi;", "appId", "Lkotlin/Function1;", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "Lkotlin/ParameterName;", "name", "operator", "block", "l", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "j", "(Ljava/lang/String;)Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "q", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "msg", "r", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;)Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$Ring2Message;", "p", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;)Ljava/lang/String;", "a", "Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "operatorMap", "c", "Companion", "Ring2MessageResult", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class Ring2MessageApiHandler implements AndroidRing2MessageApi.Ring2MessageSendApi {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final BaseFlutterFragment f8352a;
    public final HashMap b = new HashMap();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/Ring2MessageApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/Ring2MessageApiHandler$Ring2MessageResult;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidRing2MessageApi$VoidResult;", "()V", "error", "", "", "success", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Ring2MessageResult implements AndroidRing2MessageApi.VoidResult {
        public void error(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "error");
        }

        public void success() {
        }
    }

    public Ring2MessageApiHandler(BaseFlutterFragment baseFlutterFragment) {
        Intrinsics.checkNotNullParameter(baseFlutterFragment, "fragment");
        this.f8352a = baseFlutterFragment;
        m(this, "com.upuphone.star.launcher", (Function1) null, 2, (Object) null);
        m(this, "com.upuphone.ar.touchpad", (Function1) null, 2, (Object) null);
    }

    public static /* synthetic */ void m(Ring2MessageApiHandler ring2MessageApiHandler, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        ring2MessageApiHandler.l(str, function1);
    }

    public static final void n(String str, Ring2MessageApiHandler ring2MessageApiHandler, Function1 function1, OperatorManager operatorManager) {
        Intrinsics.checkNotNullParameter(str, "$appId");
        Intrinsics.checkNotNullParameter(ring2MessageApiHandler, "this$0");
        Intrinsics.checkNotNullParameter(operatorManager, "it");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("Ring2MessageApiHandler", "appId: " + str + ", operator初始化成功");
        operatorManager.getMessageOperator().registerMessageReceiver(ring2MessageApiHandler.j(str));
        HashMap hashMap = ring2MessageApiHandler.b;
        StarryNetMessageOperator messageOperator = operatorManager.getMessageOperator();
        Intrinsics.checkNotNullExpressionValue(messageOperator, "getMessageOperator(...)");
        hashMap.put(str, messageOperator);
        if (function1 != null) {
            StarryNetMessageOperator messageOperator2 = operatorManager.getMessageOperator();
            Intrinsics.checkNotNullExpressionValue(messageOperator2, "getMessageOperator(...)");
            function1.invoke(messageOperator2);
        }
    }

    public void d(AndroidRing2MessageApi.Ring2Message ring2Message, AndroidRing2MessageApi.Result result) {
        Intrinsics.checkNotNullParameter(ring2Message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setMessage(ring2Message.d());
        starryNetMessage.setData(ring2Message.b());
        starryNetMessage.setSenderPkg(ring2Message.g());
        starryNetMessage.setReceiverPkg(ring2Message.f());
        starryNetMessage.setId(ring2Message.c());
        starryNetMessage.setTarget((int) ring2Message.h().longValue());
        starryNetMessage.setReceiveUniteCode(ring2Message.e());
        String g = ring2Message.g();
        Intrinsics.checkNotNullExpressionValue(g, "getSenderPkg(...)");
        q(g, new Ring2MessageApiHandler$sendMessage$1(this, starryNetMessage, ring2Message, result));
    }

    public final MessageReceiver j(String str) {
        return new Ring2MessageApiHandler$createMessageReceiver$1(str, this);
    }

    public final FlutterEngine k(String str) {
        try {
            if (!this.f8352a.isDetached()) {
                return this.f8352a.getFlutterEngine();
            }
            ULog.Delegate delegate = ULog.f6446a;
            String simpleName = this.f8352a.getClass().getSimpleName();
            delegate.g("Ring2MessageApiHandler", simpleName + " getEngine() tag: " + str + " fragment is detached");
            return null;
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String simpleName2 = this.f8352a.getClass().getSimpleName();
            delegate2.g("Ring2MessageApiHandler", simpleName2 + " getEngine() tag: " + str + " error: " + e);
            return null;
        }
    }

    public final void l(String str, Function1 function1) {
        SuperAppServiceManager.getInstance().init(str, new a(str, this, function1));
    }

    public final AndroidRing2MessageApi.Ring2MessageReceiveApi o() {
        FlutterEngine k = k("messageReceiveApi()");
        if (k == null) {
            return null;
        }
        return new AndroidRing2MessageApi.Ring2MessageReceiveApi(k.getDartExecutor().getBinaryMessenger());
    }

    public final String p(StarryNetMessage starryNetMessage) {
        String str = "receiverPkg:" + starryNetMessage.getReceiverPkg() + ",senderPkg:" + starryNetMessage.getSenderPkg() + ",message:" + starryNetMessage.getMessage() + ",id:" + starryNetMessage.getId() + ",version:" + starryNetMessage.getVersion() + ",target:" + starryNetMessage.getTarget() + ",receiveUniteCode:" + starryNetMessage.getReceiveUniteCode();
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    public final void q(String str, Function1 function1) {
        StarryNetMessageOperator starryNetMessageOperator = (StarryNetMessageOperator) this.b.get(str);
        if (starryNetMessageOperator == null) {
            ULog.f6446a.g("Ring2MessageApiHandler", "operator=null，初始化operator");
            l(str, function1);
            return;
        }
        function1.invoke(starryNetMessageOperator);
    }

    public final AndroidRing2MessageApi.Ring2Message r(StarryNetMessage starryNetMessage) {
        AndroidRing2MessageApi.Ring2Message.Builder builder = new AndroidRing2MessageApi.Ring2Message.Builder();
        String message = starryNetMessage.getMessage();
        String str = "";
        if (message == null) {
            message = str;
        }
        AndroidRing2MessageApi.Ring2Message.Builder d = builder.d(message);
        String receiverPkg = starryNetMessage.getReceiverPkg();
        if (receiverPkg == null) {
            receiverPkg = str;
        }
        AndroidRing2MessageApi.Ring2Message.Builder f = d.f(receiverPkg);
        String senderPkg = starryNetMessage.getSenderPkg();
        if (senderPkg != null) {
            str = senderPkg;
        }
        AndroidRing2MessageApi.Ring2Message a2 = f.g(str).c(starryNetMessage.getId()).i(Long.valueOf((long) starryNetMessage.getVersion())).h(Long.valueOf((long) starryNetMessage.getTarget())).b(starryNetMessage.getData()).e(starryNetMessage.getReceiveUniteCode()).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }
}
