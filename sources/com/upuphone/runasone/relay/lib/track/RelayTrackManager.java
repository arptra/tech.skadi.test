package com.upuphone.runasone.relay.lib.track;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.api.ApiConstant;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.relay.util.RelayConst;
import com.upuphone.starrynet.tracker.StTracker;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ.\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006JF\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J6\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006¨\u0006\u0017"}, d2 = {"Lcom/upuphone/runasone/relay/lib/track/RelayTrackManager;", "", "()V", "trackAttach", "", "deviceId", "", "list", "", "trackOpen", "send", "receive", "host", "openType", "trackReceive", "uniqueKey", "size", "supportMap", "needCallback", "errorCode", "trackSendCallback", "trackSendMessage", "Companion", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RelayTrackManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<RelayTrackManager> SIntance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, RelayTrackManager$Companion$SIntance$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/upuphone/runasone/relay/lib/track/RelayTrackManager$Companion;", "", "()V", "SIntance", "Lcom/upuphone/runasone/relay/lib/track/RelayTrackManager;", "getSIntance$annotations", "getSIntance", "()Lcom/upuphone/runasone/relay/lib/track/RelayTrackManager;", "SIntance$delegate", "Lkotlin/Lazy;", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSIntance$annotations() {
        }

        @NotNull
        public final RelayTrackManager getSIntance() {
            return (RelayTrackManager) RelayTrackManager.SIntance$delegate.getValue();
        }

        private Companion() {
        }
    }

    @NotNull
    public static final RelayTrackManager getSIntance() {
        return Companion.getSIntance();
    }

    public final void trackAttach(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(list, "list");
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.DEVICE_ID, str);
        String join = String.join(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, list);
        Intrinsics.checkNotNullExpressionValue(join, "join(\",\", list)");
        hashMap.put("metaInfo", join);
        StTracker.getInstance().reportEvent(RelayConst.TRACK_ATTACH, hashMap);
    }

    public final void trackOpen(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "send");
        Intrinsics.checkNotNullParameter(str3, "receive");
        Intrinsics.checkNotNullParameter(str4, ApiConstant.VALUE_HOST);
        Intrinsics.checkNotNullParameter(str5, "openType");
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.DEVICE_ID, str);
        hashMap.put("SendAppUniteCode", str2);
        hashMap.put("ReceiveAppUniteCode", str3);
        hashMap.put(ApiConstant.VALUE_HOST, str4);
        hashMap.put("openType", str5);
        StTracker.getInstance().reportEvent(RelayConst.TRACK_OPEN, hashMap);
    }

    public final void trackReceive(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "uniqueKey");
        Intrinsics.checkNotNullParameter(str3, "send");
        Intrinsics.checkNotNullParameter(str4, "receive");
        Intrinsics.checkNotNullParameter(str5, "size");
        Intrinsics.checkNotNullParameter(str6, "supportMap");
        Intrinsics.checkNotNullParameter(str7, "needCallback");
        Intrinsics.checkNotNullParameter(str8, "errorCode");
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.DEVICE_ID, str);
        hashMap.put("uniqueKey", str2);
        hashMap.put("SendAppUniteCode", str3);
        hashMap.put("ReceiveAppUniteCode", str4);
        hashMap.put("msgLength", str5);
        hashMap.put("supportMap", str6);
        hashMap.put("needCallback", str7);
        hashMap.put("errorCode", str8);
        hashMap.put("receiveTime", System.currentTimeMillis() + "");
        StTracker.getInstance().reportEvent(RelayConst.TRACK_RECEIVE, hashMap);
    }

    public final void trackSendCallback(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "uniqueKey");
        Intrinsics.checkNotNullParameter(str2, "errorCode");
        HashMap hashMap = new HashMap();
        hashMap.put("uniqueKey", str);
        hashMap.put("errorCode", str2);
        hashMap.put("endTime", String.valueOf(System.currentTimeMillis()));
        StTracker.getInstance().reportEvent(RelayConst.TRACK_MESSAGE_CALLBACK, hashMap);
    }

    public final void trackSendMessage(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "uniqueKey");
        Intrinsics.checkNotNullParameter(str3, "send");
        Intrinsics.checkNotNullParameter(str4, "receive");
        Intrinsics.checkNotNullParameter(str5, "size");
        Intrinsics.checkNotNullParameter(str6, "supportMap");
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.DEVICE_ID, str);
        hashMap.put("uniqueKey", str2);
        hashMap.put("SendAppUniteCode", str3);
        hashMap.put("ReceiveAppUniteCode", str4);
        hashMap.put("msgLength", str5);
        hashMap.put("supportMap", str6);
        hashMap.put("startTime", String.valueOf(System.currentTimeMillis()));
        StTracker.getInstance().reportEvent(RelayConst.TRACK_SEND_MESSAGE, hashMap);
    }
}
