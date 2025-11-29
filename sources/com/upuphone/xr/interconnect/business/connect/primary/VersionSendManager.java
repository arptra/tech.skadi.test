package com.upuphone.xr.interconnect.business.connect.primary;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.starrynetsdk.ability.relay.RelayBean;
import com.upuphone.starrynetsdk.ability.relay.RemoteListener;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.ConnectMessageOuterClass;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u000bR\u00020\u00000\nj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u000bR\u00020\u0000`\fX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e`\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/primary/VersionSendManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "versionSendListener", "Lcom/upuphone/xr/interconnect/business/connect/primary/VersionSendListener;", "logTag", "", "(Lcom/upuphone/xr/interconnect/business/connect/primary/VersionSendListener;Ljava/lang/String;)V", "jobScope", "Lkotlinx/coroutines/CoroutineScope;", "versionSendCallbackMap", "Ljava/util/HashMap;", "Lcom/upuphone/xr/interconnect/business/connect/primary/VersionSendManager$VersionSendCallback;", "Lkotlin/collections/HashMap;", "versionSendJobMap", "Lkotlinx/coroutines/Job;", "cancelVersionSendJob", "", "deviceId", "launchVersionSendJob", "version", "", "retryVersionSend", "callback", "Lcom/upuphone/starrynetsdk/ability/relay/RemoteListener;", "sendVersion", "VersionSendCallback", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVersionSendManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VersionSendManager.kt\ncom/upuphone/xr/interconnect/business/connect/primary/VersionSendManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n1#2:85\n*E\n"})
public final class VersionSendManager extends PetaStepSerializer {
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineScope jobScope = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    /* access modifiers changed from: private */
    @NotNull
    public final HashMap<String, VersionSendCallback> versionSendCallbackMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public final HashMap<String, Job> versionSendJobMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public final VersionSendListener versionSendListener;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/primary/VersionSendManager$VersionSendCallback;", "Lcom/upuphone/starrynetsdk/ability/relay/RemoteListener;", "deviceId", "", "version", "", "(Lcom/upuphone/xr/interconnect/business/connect/primary/VersionSendManager;Ljava/lang/String;I)V", "isDestroyed", "", "()Z", "setDestroyed", "(Z)V", "onFailure", "", "uniteCode", "code", "onSuccess", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class VersionSendCallback implements RemoteListener {
        /* access modifiers changed from: private */
        @NotNull
        public final String deviceId;
        private volatile boolean isDestroyed;
        final /* synthetic */ VersionSendManager this$0;
        /* access modifiers changed from: private */
        public final int version;

        public VersionSendCallback(@NotNull VersionSendManager versionSendManager, String str, int i) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            this.this$0 = versionSendManager;
            this.deviceId = str;
            this.version = i;
        }

        public final boolean isDestroyed() {
            return this.isDestroyed;
        }

        public void onFailure(@Nullable String str, int i) {
            VersionSendManager versionSendManager = this.this$0;
            String str2 = this.deviceId;
            versionSendManager.serialize("retry@" + str2 + " caused by " + i, new VersionSendManager$VersionSendCallback$onFailure$1(this.this$0, this));
        }

        public void onSuccess(@Nullable String str) {
            VersionSendManager versionSendManager = this.this$0;
            String str2 = this.deviceId;
            versionSendManager.serialize("success@" + str2, new VersionSendManager$VersionSendCallback$onSuccess$1(this.this$0, this));
        }

        public final void setDestroyed(boolean z) {
            this.isDestroyed = z;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VersionSendManager(@NotNull VersionSendListener versionSendListener2, @NotNull String str) {
        super(AnonymousClass1.INSTANCE, str);
        Intrinsics.checkNotNullParameter(versionSendListener2, "versionSendListener");
        Intrinsics.checkNotNullParameter(str, "logTag");
        this.versionSendListener = versionSendListener2;
    }

    /* access modifiers changed from: private */
    public final void retryVersionSend(String str, int i, RemoteListener remoteListener) {
        serialize("version send retry", new VersionSendManager$retryVersionSend$1(this, i, str, remoteListener));
    }

    /* access modifiers changed from: private */
    public final void sendVersion(String str, int i, RemoteListener remoteListener) {
        String tag = getTag();
        boolean z = StarryNetAbilityManager.getInstance().getRelayAbility() != null;
        ILog.d(tag, "sendVersion start Version " + i + " sending to #" + str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + z);
        RelayAbility relayAbility = StarryNetAbilityManager.getInstance().getRelayAbility();
        if (relayAbility != null) {
            RelayBean relayBean = new RelayBean();
            relayBean.setTargetDeviceId(str);
            relayBean.setTargetUniteCode(InterconnectManager.getInstance().getPeerPackageName());
            ConnectMessageOuterClass.ConnectMessage.Builder newBuilder = ConnectMessageOuterClass.ConnectMessage.newBuilder();
            newBuilder.setVersion(i);
            relayBean.setData(((ConnectMessageOuterClass.ConnectMessage) newBuilder.build()).toByteArray());
            ILog.d(getTag(), "sendVersion relay");
            int relay = relayAbility.relay(relayBean, remoteListener);
            String tag2 = getTag();
            ILog.d(tag2, "Version " + i + " sending to #" + str + " completed with ret code " + relay + ".");
            if (relay != 0) {
                retryVersionSend(str, i, remoteListener);
            }
        }
    }

    public final void cancelVersionSendJob(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        VersionSendCallback remove = this.versionSendCallbackMap.remove(str);
        if (remove != null) {
            remove.setDestroyed(true);
        }
        Job remove2 = this.versionSendJobMap.remove(str);
        if (remove2 != null) {
            Job.DefaultImpls.a(remove2, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void launchVersionSendJob(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        serialize("version send to " + str, new VersionSendManager$launchVersionSendJob$1(this, i, str));
    }
}
