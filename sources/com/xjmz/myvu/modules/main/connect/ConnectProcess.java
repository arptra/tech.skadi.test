package com.xjmz.myvu.modules.main.connect;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.honey.account.t9.a;
import com.honey.account.t9.b;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0003'+.\u0018\u0000 \u00122\u00020\u0001:\u000212J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0011R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010/¨\u00063"}, d2 = {"Lcom/xjmz/myvu/modules/main/connect/ConnectProcess;", "", "", "j", "()V", "o", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "l", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "i", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mainActivity", "", "b", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "lastConnectId", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", "connectSucc", "", "d", "J", "lastFoundDeviceTime", "Lcom/xjmz/myvu/modules/main/connect/ConnectProcess$State;", "e", "Lcom/xjmz/myvu/modules/main/connect/ConnectProcess$State;", "connectState", "f", "connectShowingDevice", "Landroid/app/AlertDialog;", "g", "Landroid/app/AlertDialog;", "connectDialog", "com/xjmz/myvu/modules/main/connect/ConnectProcess$discoverListener$1", "h", "Lcom/xjmz/myvu/modules/main/connect/ConnectProcess$discoverListener$1;", "discoverListener", "com/xjmz/myvu/modules/main/connect/ConnectProcess$connectListener$1", "Lcom/xjmz/myvu/modules/main/connect/ConnectProcess$connectListener$1;", "connectListener", "com/xjmz/myvu/modules/main/connect/ConnectProcess$boundListener$1", "Lcom/xjmz/myvu/modules/main/connect/ConnectProcess$boundListener$1;", "boundListener", "Companion", "State", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ConnectProcess {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f8368a;
    public final String b;
    public Function1 c;
    public long d;
    public State e;
    public String f;
    public AlertDialog g;
    public final ConnectProcess$discoverListener$1 h;
    public final ConnectProcess$connectListener$1 i;
    public final ConnectProcess$boundListener$1 j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/modules/main/connect/ConnectProcess$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/modules/main/connect/ConnectProcess$State;", "", "(Ljava/lang/String;I)V", "INIT", "CONNECTING", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum State {
        INIT,
        CONNECTING;

        static {
            State[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        @NotNull
        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    public static final void m(StarryNetDevice starryNetDevice, ConnectProcess connectProcess, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "$device");
        Intrinsics.checkNotNullParameter(connectProcess, "this$0");
        InterconnectManager.getInstance().getStarryNetDeviceManager().connectDevice(starryNetDevice.getDeviceId());
        connectProcess.e = State.CONNECTING;
    }

    public static final void n(ConnectProcess connectProcess, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(connectProcess, "this$0");
        AlertDialog alertDialog = connectProcess.g;
        Intrinsics.checkNotNull(alertDialog);
        alertDialog.dismiss();
    }

    public final void i() {
        AlertDialog alertDialog = this.g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void j() {
        o();
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceDiscoverListener(this.h);
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceConnectionListener(this.i);
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceBondStateListener(this.j);
    }

    public final String k() {
        return this.b;
    }

    public final void l(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        AlertDialog alertDialog = this.g;
        if (alertDialog != null) {
            Intrinsics.checkNotNull(alertDialog);
            alertDialog.dismiss();
            this.g = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f8368a);
        String deviceId = starryNetDevice.getDeviceId();
        String deviceName = starryNetDevice.getDeviceName();
        AlertDialog create = builder.setTitle("连接设备: " + deviceId + ", " + deviceName).setPositiveButton("连接", new a(starryNetDevice, this)).setNegativeButton("取消", new b(this)).create();
        this.g = create;
        Intrinsics.checkNotNull(create);
        create.show();
    }

    public final void o() {
        this.e = State.INIT;
        InterconnectManager.getInstance().getStarryNetDeviceManager().stopDiscovery();
    }
}
