package com.xjsd.ai.assistant.cloud;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.honey.account.z9.a;
import com.honey.account.z9.b;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocketManager;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001aH\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0010H\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010.\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/xjsd/ai/assistant/cloud/CloudAbilityImpl;", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "Lcom/xjsd/ai/assistant/cloud/CloudAbility;", "()V", "isVadEnd", "", "mCloudEventListener", "Lcom/xjsd/ai/assistant/cloud/CloudEventListener;", "mContext", "Landroid/content/Context;", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "mTraceId", "", "feed", "", "list", "", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndServiceData;", "([Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndServiceData;)V", "feedData", "data", "", "flush", "getErrorCode", "", "getFunctionType", "getVirtualAppName", "init", "application", "Landroid/app/Application;", "launch", "params", "Lcom/xjsd/ai/assistant/cloud/InitCloudParams;", "onClose", "code", "onData", "onMsg", "response", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "onParse", "onResume", "performLaunch", "setCloudEventListener", "listener", "stop", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCloudAbilityImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloudAbilityImpl.kt\ncom/xjsd/ai/assistant/cloud/CloudAbilityImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,130:1\n37#2,2:131\n*S KotlinDebug\n*F\n+ 1 CloudAbilityImpl.kt\ncom/xjsd/ai/assistant/cloud/CloudAbilityImpl\n*L\n87#1:131,2\n*E\n"})
public final class CloudAbilityImpl extends VirtualWebSocket implements CloudAbility {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "CloudAbilityImpl";
    private volatile boolean isVadEnd;
    @Nullable
    private CloudEventListener mCloudEventListener;
    private Context mContext;
    private final ExecutorService mExecutorService = ThreadPoolFactory.b("Cloud");
    @NotNull
    private String mTraceId = "";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/cloud/CloudAbilityImpl$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* access modifiers changed from: private */
    public static final Boolean launch$lambda$0(CloudAbilityImpl cloudAbilityImpl, InitCloudParams initCloudParams) {
        Intrinsics.checkNotNullParameter(cloudAbilityImpl, "this$0");
        Intrinsics.checkNotNullParameter(initCloudParams, "$params");
        return Boolean.valueOf(cloudAbilityImpl.performLaunch(initCloudParams));
    }

    private final boolean performLaunch(InitCloudParams initCloudParams) {
        this.isVadEnd = false;
        String str = initCloudParams.traceId;
        Intrinsics.checkNotNullExpressionValue(str, "traceId");
        this.mTraceId = str;
        String a2 = DeviceUtils.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getGlassDeviceId(...)");
        if (connect(a2)) {
            VirtualWebSocketManager.f8507a.c(this);
            List<EndToEndServiceData> list = initCloudParams.initData;
            Intrinsics.checkNotNullExpressionValue(list, "initData");
            EndToEndServiceData[] endToEndServiceDataArr = (EndToEndServiceData[]) list.toArray(new EndToEndServiceData[0]);
            feed((EndToEndServiceData[]) Arrays.copyOf(endToEndServiceDataArr, endToEndServiceDataArr.length));
            return true;
        }
        this.mTraceId = "";
        return false;
    }

    /* access modifiers changed from: private */
    public static final void stop$lambda$3(CloudAbilityImpl cloudAbilityImpl) {
        Intrinsics.checkNotNullParameter(cloudAbilityImpl, "this$0");
        VirtualWebSocketManager.f8507a.b(cloudAbilityImpl);
        cloudAbilityImpl.disconnect();
    }

    public void feed(@NotNull EndToEndServiceData... endToEndServiceDataArr) {
        Intrinsics.checkNotNullParameter(endToEndServiceDataArr, "list");
        sendMsg(this.mTraceId, (EndToEndServiceData[]) Arrays.copyOf(endToEndServiceDataArr, endToEndServiceDataArr.length));
    }

    public void feedData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        sendData(bArr);
    }

    public void flush() {
        this.isVadEnd = true;
        if (TextUtils.isEmpty(this.mTraceId)) {
            ILog.m(TAG, "requestId为空，不发送end data");
            return;
        }
        EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
        endToEndServiceData.setType("asr");
        AsrCloudOptions asrCloudOptions = new AsrCloudOptions();
        asrCloudOptions.setDeviceId(DeviceUtils.a());
        asrCloudOptions.setRequestId(this.mTraceId);
        asrCloudOptions.setEvent(AsrConstants.END_AUDIO);
        endToEndServiceData.setPayload(asrCloudOptions);
        feed(endToEndServiceData);
    }

    public int getErrorCode() {
        return getCloudErrorCode();
    }

    public int getFunctionType() {
        return 0;
    }

    @NotNull
    public String getVirtualAppName() {
        return AssistantConstants.APPLICATION_ID;
    }

    public final void init(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.mContext = applicationContext;
        VirtualWebSocketManager.f8507a.a(this);
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public boolean launch(@NotNull InitCloudParams initCloudParams) {
        Intrinsics.checkNotNullParameter(initCloudParams, PayloadConstant.KEY_PARAMS);
        FutureTask futureTask = new FutureTask(new b(this, initCloudParams));
        this.mExecutorService.submit(futureTask);
        Object obj = futureTask.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return ((Boolean) obj).booleanValue();
    }

    public void onClose(int i) {
        if (!TextUtils.isEmpty(this.mTraceId)) {
            CloudEventListener cloudEventListener = this.mCloudEventListener;
            if (cloudEventListener != null) {
                cloudEventListener.a(this.mTraceId, String.valueOf(i));
            }
            this.mTraceId = "";
        }
    }

    public void onData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        CloudEventListener cloudEventListener = this.mCloudEventListener;
        if (cloudEventListener != null) {
            cloudEventListener.b(bArr);
        }
    }

    public void onMsg(@NotNull EndToEndResponse endToEndResponse) {
        Intrinsics.checkNotNullParameter(endToEndResponse, "response");
        CloudEventListener cloudEventListener = this.mCloudEventListener;
        if (cloudEventListener != null) {
            cloudEventListener.c(endToEndResponse);
        }
    }

    public void onParse() {
    }

    public void onResume() {
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    public void setCloudEventListener(@Nullable CloudEventListener cloudEventListener) {
        this.mCloudEventListener = cloudEventListener;
    }

    public void stop() {
        this.mExecutorService.submit(new a(this));
    }
}
