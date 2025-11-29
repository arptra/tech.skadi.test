package com.upuphone.xr.sapp.bluetooth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/sapp/bluetooth/BluetoothListener;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BluetoothHelper$broadcastReceiver$1$onReceive$1 extends Lambda implements Function1<BluetoothListener, Unit> {
    final /* synthetic */ int $newState;
    final /* synthetic */ int $oldState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BluetoothHelper$broadcastReceiver$1$onReceive$1(int i, int i2) {
        super(1);
        this.$oldState = i;
        this.$newState = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BluetoothListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BluetoothListener bluetoothListener) {
        Intrinsics.checkNotNullParameter(bluetoothListener, "$this$callListeners");
        bluetoothListener.a(this.$oldState, this.$newState);
    }
}
