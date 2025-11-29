package com.upuphone.xr.sapp.vm;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.xjmz.myvu.ext.ContextExtKt;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0018\u00010\u0019R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/vm/BluetoothViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "onCleared", "()V", "Landroid/content/Context;", "context", "f", "(Landroid/content/Context;)V", "g", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "_mBluetoothState", "Landroidx/lifecycle/LiveData;", "c", "Landroidx/lifecycle/LiveData;", "e", "()Landroidx/lifecycle/LiveData;", "mBluetoothState", "Lcom/upuphone/xr/sapp/vm/BluetoothViewModel$BluetoothListenerReceiver;", "d", "Lcom/upuphone/xr/sapp/vm/BluetoothViewModel$BluetoothListenerReceiver;", "receiver", "BluetoothListenerReceiver", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class BluetoothViewModel extends AndroidViewModel {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public final MutableLiveData b;
    public final LiveData c;
    public BluetoothListenerReceiver d;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/vm/BluetoothViewModel$BluetoothListenerReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/upuphone/xr/sapp/vm/BluetoothViewModel;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class BluetoothListenerReceiver extends BroadcastReceiver {
        public BluetoothListenerReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                BluetoothViewModel bluetoothViewModel = BluetoothViewModel.this;
                String action = intent.getAction();
                if (action != null && action.hashCode() == -1530327060 && action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                    if (intExtra == 10) {
                        bluetoothViewModel.b.postValue(Boolean.FALSE);
                    } else if (intExtra == 12) {
                        bluetoothViewModel.b.postValue(Boolean.TRUE);
                        GenericWindowManger.c.a().j(110);
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vm/BluetoothViewModel$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BluetoothViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData;
        this.c = mutableLiveData;
        f(application.getApplicationContext());
    }

    public final LiveData e() {
        return this.c;
    }

    public final void f(Context context) {
        this.d = new BluetoothListenerReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        if (context != null) {
            BluetoothListenerReceiver bluetoothListenerReceiver = this.d;
            Intrinsics.checkNotNull(bluetoothListenerReceiver);
            ContextExtKt.a(context, bluetoothListenerReceiver, intentFilter);
        }
    }

    public final void g(Context context) {
        BluetoothListenerReceiver bluetoothListenerReceiver = this.d;
        if (bluetoothListenerReceiver != null && context != null) {
            try {
                context.unregisterReceiver(bluetoothListenerReceiver);
                Unit unit = Unit.INSTANCE;
            } catch (Exception unused) {
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public void onCleared() {
        super.onCleared();
        g(c());
    }
}
