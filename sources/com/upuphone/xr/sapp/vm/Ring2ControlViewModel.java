package com.upuphone.xr.sapp.vm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.honey.account.z8.g;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.sapp.entity.ConnectState;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\bR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010%\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/upuphone/xr/sapp/vm/Ring2ControlViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "m", "()V", "", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "j", "()Ljava/util/List;", "Lcom/upuphone/runasone/device/StarryDevice;", "device", "q", "(Lcom/upuphone/runasone/device/StarryDevice;)Lcom/upuphone/xr/sapp/entity/NetDevice;", "h", "(Lcom/upuphone/runasone/device/StarryDevice;)V", "p", "l", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "_connectDevice", "Landroidx/lifecycle/LiveData;", "c", "Landroidx/lifecycle/LiveData;", "k", "()Landroidx/lifecycle/LiveData;", "connectDevice", "Lcom/upuphone/starrynetsdk/device/connection/DevicesConnector;", "kotlin.jvm.PlatformType", "d", "Lcom/upuphone/starrynetsdk/device/connection/DevicesConnector;", "getDevicesConnector", "()Lcom/upuphone/starrynetsdk/device/connection/DevicesConnector;", "devicesConnector", "Landroidx/lifecycle/Observer;", "", "e", "Landroidx/lifecycle/Observer;", "mObserver", "f", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class Ring2ControlViewModel extends AndroidViewModel {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public final MutableLiveData b;
    public final LiveData c;
    public final DevicesConnector d = DevicesConnector.getInstance();
    public final Observer e = new g(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vm/Ring2ControlViewModel$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Ring2ControlViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData;
        this.c = mutableLiveData;
    }

    public static final void n(Ring2ControlViewModel ring2ControlViewModel, boolean z) {
        Intrinsics.checkNotNullParameter(ring2ControlViewModel, "this$0");
        ULog.f6446a.a("Ring2ControlViewModel", "StarryNetSDK初始化 initListener");
        ring2ControlViewModel.l();
    }

    public final void h(StarryDevice starryDevice) {
        this.b.postValue(q(starryDevice));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r2 = kotlin.sequences.SequencesKt.toList((r2 = kotlin.sequences.SequencesKt.map((r0 = kotlin.sequences.SequencesKt.filter((r0 = kotlin.collections.CollectionsKt.asSequence(r0)), com.upuphone.xr.sapp.vm.Ring2ControlViewModel$getBoundedRing2$1.INSTANCE)), new com.upuphone.xr.sapp.vm.Ring2ControlViewModel$getBoundedRing2$2(r2))));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List j() {
        /*
            r2 = this;
            com.upuphone.starrynetsdk.device.connection.DevicesConnector r0 = r2.d
            java.util.List r0 = r0.getBondedDevices()
            if (r0 == 0) goto L_0x0028
            kotlin.sequences.Sequence r0 = kotlin.collections.CollectionsKt.asSequence(r0)
            if (r0 == 0) goto L_0x0028
            com.upuphone.xr.sapp.vm.Ring2ControlViewModel$getBoundedRing2$1 r1 = com.upuphone.xr.sapp.vm.Ring2ControlViewModel$getBoundedRing2$1.INSTANCE
            kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt.filter(r0, r1)
            if (r0 == 0) goto L_0x0028
            com.upuphone.xr.sapp.vm.Ring2ControlViewModel$getBoundedRing2$2 r1 = new com.upuphone.xr.sapp.vm.Ring2ControlViewModel$getBoundedRing2$2
            r1.<init>(r2)
            kotlin.sequences.Sequence r2 = kotlin.sequences.SequencesKt.map(r0, r1)
            if (r2 == 0) goto L_0x0028
            java.util.List r2 = kotlin.sequences.SequencesKt.toList(r2)
            if (r2 == 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L_0x002c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.Ring2ControlViewModel.j():java.util.List");
    }

    public final LiveData k() {
        return this.c;
    }

    public final void l() {
        List<StarryDevice> connectedDevices = this.d.getConnectedDevices();
        T t = null;
        if (connectedDevices != null) {
            Iterator<T> it = connectedDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (((StarryDevice) next).getTerminalType() == 5) {
                    t = next;
                    break;
                }
            }
            t = (StarryDevice) t;
        }
        if (t != null) {
            h(t);
        }
        this.d.registerConnectionListener(new Ring2ControlViewModel$initConnectionListener$1(this));
    }

    public final void m() {
        StarryNetApiHandler.Companion companion = StarryNetApiHandler.m;
        if (Intrinsics.areEqual(companion.d().getValue(), (Object) Boolean.TRUE)) {
            ULog.f6446a.a("Ring2ControlViewModel", "StarryNetSDK已经初始化 initListener");
            l();
            return;
        }
        ULog.f6446a.a("Ring2ControlViewModel", "StarryNetSDK暂未初始化等待其初始化");
        companion.d().removeObserver(this.e);
        companion.d().observeForever(this.e);
    }

    public final void p(StarryDevice starryDevice) {
        String str;
        MutableLiveData mutableLiveData = this.b;
        String id = starryDevice.getId();
        String name = starryDevice.getName();
        ConnectState connectState = ConnectState.UNCONNECTED;
        long currentTimeMillis = System.currentTimeMillis();
        String modelID = starryDevice.getStarryDevice().getModelID();
        if (modelID == null || (str = ConnectExtKt.o(modelID)) == null) {
            str = "";
        }
        mutableLiveData.postValue(new NetDevice(id, name, connectState, false, currentTimeMillis, str, 8, (DefaultConstructorMarker) null));
    }

    public final NetDevice q(StarryDevice starryDevice) {
        String str;
        String id = starryDevice.getId();
        String name = starryDevice.getName();
        ConnectState connectState = ConnectState.CONNECTED;
        long currentTimeMillis = System.currentTimeMillis();
        String modelID = starryDevice.getStarryDevice().getModelID();
        if (modelID == null || (str = ConnectExtKt.o(modelID)) == null) {
            str = "";
        }
        return new NetDevice(id, name, connectState, false, currentTimeMillis, str, 8, (DefaultConstructorMarker) null);
    }
}
