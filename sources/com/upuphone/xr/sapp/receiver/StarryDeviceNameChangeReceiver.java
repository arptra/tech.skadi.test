package com.upuphone.xr.sapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.honey.account.r8.a;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.api.StBroadcast;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.xjmz.myvu.ext.ContextExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0003R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/receiver/StarryDeviceNameChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "vm", "b", "(Landroidx/lifecycle/LifecycleOwner;Lcom/upuphone/xr/sapp/vm/DeviceControlModel;)V", "d", "(Lcom/upuphone/xr/sapp/vm/DeviceControlModel;)V", "e", "a", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "viewModel", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StarryDeviceNameChangeReceiver extends BroadcastReceiver {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public DeviceControlModel f7822a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/receiver/StarryDeviceNameChangeReceiver$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.receiver.StarryDeviceNameChangeReceiver.WhenMappings.<clinit>():void");
        }
    }

    public static final void c(StarryDeviceNameChangeReceiver starryDeviceNameChangeReceiver, DeviceControlModel deviceControlModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(starryDeviceNameChangeReceiver, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            starryDeviceNameChangeReceiver.d(deviceControlModel);
        } else if (i == 2) {
            starryDeviceNameChangeReceiver.e();
        }
    }

    public final void b(LifecycleOwner lifecycleOwner, DeviceControlModel deviceControlModel) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        lifecycleOwner.getLifecycle().a(new a(this, deviceControlModel));
    }

    public final void d(DeviceControlModel deviceControlModel) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(StBroadcast.ACTION_STARRY_NET_DEVICE_NAME_CHANGED);
        Context applicationContext = MainApplication.k.f().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ContextExtKt.a(applicationContext, this, intentFilter);
        this.f7822a = deviceControlModel;
    }

    public final void e() {
        MainApplication.k.f().getApplicationContext().unregisterReceiver(this);
        this.f7822a = null;
    }

    public void onReceive(Context context, Intent intent) {
        String action;
        DeviceControlModel deviceControlModel;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("StarryDeviceNameChangeReceiver", "intent = " + intent);
        if (intent != null && (action = intent.getAction()) != null && action.hashCode() == 707152200 && action.equals(StBroadcast.ACTION_STARRY_NET_DEVICE_NAME_CHANGED) && (deviceControlModel = this.f7822a) != null) {
            deviceControlModel.E(intent.getStringExtra(StBroadcast.EXTRA_DEVICE_ID), intent.getStringExtra(StBroadcast.EXTRA_DEVICE_NAME));
        }
    }
}
