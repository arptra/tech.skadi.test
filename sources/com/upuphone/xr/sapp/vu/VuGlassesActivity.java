package com.upuphone.xr.sapp.vu;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.honey.account.b9.o;
import com.honey.account.b9.p;
import com.honey.account.b9.q;
import com.honey.account.b9.r;
import com.honey.account.b9.s;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vu.arspace.WebsiteBlackListHelper;
import com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper;
import com.upuphone.xr.sapp.vu.ota.VuUpdateInfo;
import com.upuphone.xr.sapp.vu.ota.VuUpdateStatus;
import com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesPreferenceModel;
import com.xjmz.myvu.MYVUActivity;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001\\B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\tJ\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\tJ\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\tJ\u0019\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tJ\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\tJ\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\tJ\u0018\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H@¢\u0006\u0004\b(\u0010)J\u001f\u0010-\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J!\u00101\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b-\u00103\u001a\u0004\b4\u00105R\u001b\u0010:\u001a\u0002068BX\u0002¢\u0006\f\n\u0004\b(\u00107\u001a\u0004\b8\u00109R*\u0010A\u001a\u00020&2\u0006\u0010;\u001a\u00020&8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b1\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0I8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010PR\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020&0I8\u0006¢\u0006\f\n\u0004\bT\u0010L\u001a\u0004\bU\u0010VR\u001c\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010X0I8\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010L¨\u0006]"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuGlassesActivity;", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesHidManager$UsbOpenResultListener;", "Lcom/upuphone/xr/sapp/vu/VuBaseGlassesActivity;", "Lcom/xjmz/myvu/MYVUActivity;", "activity", "<init>", "(Lcom/xjmz/myvu/MYVUActivity;)V", "", "t", "()V", "x", "K", "y", "L", "u", "m", "B", "v", "I", "w", "J", "z", "A", "s", "C", "E", "D", "G", "F", "H", "onCreate", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onPause", "onResume", "onDestroy", "", "result", "b", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "windowType", "actionType", "a", "(II)V", "", "data", "c", "(ILjava/lang/Object;)V", "Lcom/xjmz/myvu/MYVUActivity;", "o", "()Lcom/xjmz/myvu/MYVUActivity;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "Lkotlin/Lazy;", "q", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "viewPreferenceModel", "value", "Z", "p", "()Z", "d", "(Z)V", "needConfirmConnect", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;", "updateInfoChangeListener", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateStatusChangeListener;", "e", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateStatusChangeListener;", "updateStatusChangeListener", "Landroidx/lifecycle/Observer;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "f", "Landroidx/lifecycle/Observer;", "glassInfoObserver", "Lkotlinx/coroutines/Job;", "g", "Lkotlinx/coroutines/Job;", "connectViewGlassesJob", "h", "connectAriGlassesJob", "i", "getConnectStateObserver", "()Landroidx/lifecycle/Observer;", "connectStateObserver", "", "j", "versionInfoObserver", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassesActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassesActivity.kt\ncom/upuphone/xr/sapp/vu/VuGlassesActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,370:1\n75#2,13:371\n*S KotlinDebug\n*F\n+ 1 VuGlassesActivity.kt\ncom/upuphone/xr/sapp/vu/VuGlassesActivity\n*L\n47#1:371,13\n*E\n"})
public final class VuGlassesActivity implements VuGlassesHidManager.UsbOpenResultListener, VuBaseGlassesActivity {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final MYVUActivity f8026a;
    public final Lazy b;
    public boolean c;
    public final VuGlassesOtaModel.UpdateInfoChangeListener d = new o(this);
    public final VuGlassesOtaModel.UpdateStatusChangeListener e = new p(this);
    public final Observer f = new q();
    public Job g;
    public Job h;
    public final Observer i = new r(this);
    public final Observer j = new s(this);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuGlassesActivity$Companion;", "", "<init>", "()V", "Lcom/xjmz/myvu/MYVUActivity;", "activity", "Lcom/upuphone/xr/sapp/vu/VuBaseGlassesActivity;", "a", "(Lcom/xjmz/myvu/MYVUActivity;)Lcom/upuphone/xr/sapp/vu/VuBaseGlassesActivity;", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VuBaseGlassesActivity a(MYVUActivity mYVUActivity) {
            Intrinsics.checkNotNullParameter(mYVUActivity, "activity");
            return new VuGlassesActivity(mYVUActivity);
        }

        public Companion() {
        }
    }

    public VuGlassesActivity(MYVUActivity mYVUActivity) {
        Intrinsics.checkNotNullParameter(mYVUActivity, "activity");
        this.f8026a = mYVUActivity;
        this.b = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VuGlassesPreferenceModel.class), new VuGlassesActivity$special$$inlined$viewModels$default$2(mYVUActivity), new VuGlassesActivity$special$$inlined$viewModels$default$1(mYVUActivity), new VuGlassesActivity$special$$inlined$viewModels$default$3((Function0) null, mYVUActivity));
    }

    public static final void M(VuGlassesActivity vuGlassesActivity, VuUpdateInfo vuUpdateInfo) {
        Intrinsics.checkNotNullParameter(vuGlassesActivity, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActivity", "hasOtaObserver: " + vuUpdateInfo);
        if (VuGlassControlModel.f8109a.z() && vuUpdateInfo != null && vuUpdateInfo.h()) {
            String string = vuGlassesActivity.f8026a.getString(R.string.view_glasses);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (VuGlassesOtaModel.f8117a.v()) {
                StaticMethodUtilsKt.z(vuGlassesActivity.f8026a, CollectionsKt.arrayListOf(2012), MapsKt.hashMapOf(TuplesKt.to(2012, string)), false, false);
            }
            VuGlassUpdateHelper.Companion companion = VuGlassUpdateHelper.f8081a;
            MYVUActivity mYVUActivity = vuGlassesActivity.f8026a;
            String string2 = mYVUActivity.getResources().getString(R.string.new_glass_update_found_param, new Object[]{string});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            companion.b(mYVUActivity, string2, vuUpdateInfo.g());
        }
    }

    public static final void N(VuGlassesActivity vuGlassesActivity, VuUpdateStatus vuUpdateStatus) {
        String str;
        Intrinsics.checkNotNullParameter(vuGlassesActivity, "this$0");
        Intrinsics.checkNotNullParameter(vuUpdateStatus, "it");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActivity", "otaStatusObserver: " + vuUpdateStatus);
        if (vuUpdateStatus.b() != 5) {
            return;
        }
        if (!Intrinsics.areEqual(vuUpdateStatus.a(), (Object) Boolean.TRUE)) {
            VuUpdateInfo w = VuGlassesOtaModel.f8117a.w();
            if (w == null || (str = w.g()) == null) {
                str = "";
            }
            if (MainApplication.k.f().v()) {
                vuGlassesActivity.C();
                return;
            }
            VuGlassUpdateHelper.Companion companion = VuGlassUpdateHelper.f8081a;
            MYVUActivity mYVUActivity = vuGlassesActivity.f8026a;
            String string = mYVUActivity.getString(R.string.notify_install_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.b(mYVUActivity, string, str);
            return;
        }
        VuGlassUpdateHelper.f8081a.a();
    }

    public static final void O(VuGlassesActivity vuGlassesActivity, String str) {
        Intrinsics.checkNotNullParameter(vuGlassesActivity, "this$0");
        DeviceInfo c2 = VuGlassesDeviceInfoModel.f8112a.c();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActivity", "OnVersionChange: " + c2);
        if (c2 != null) {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(vuGlassesActivity.f8026a), (CoroutineContext) null, (CoroutineStart) null, new VuGlassesActivity$versionInfoObserver$1$1(c2, (Continuation<? super VuGlassesActivity$versionInfoObserver$1$1>) null), 3, (Object) null);
        }
    }

    public static final void n(VuGlassesActivity vuGlassesActivity, boolean z) {
        Intrinsics.checkNotNullParameter(vuGlassesActivity, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActivity", "listenViewGlassConnect connectState: " + z);
        if (z) {
            vuGlassesActivity.z();
        } else {
            vuGlassesActivity.A();
        }
    }

    public static final void r(VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        if (viewGlassesInfo == null) {
            ULog.f6446a.a("VuGlassesActivity", "removeDeviceTypeFromHistory view");
            GlassDataStoreHelper.f8091a.h("view");
            return;
        }
        GlassDataStoreHelper.f8091a.k("view");
    }

    public final void A() {
        H();
        GenericWindowManger.Companion companion = GenericWindowManger.c;
        if (companion.a().k(2012)) {
            companion.a().j(2012);
        }
    }

    public final void B() {
        Job job = this.g;
        if (job != null && job.isActive()) {
            Job job2 = this.g;
            if (job2 != null) {
                Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
            }
            this.g = null;
        }
        G();
    }

    public final void C() {
        StaticMethodUtilsKt.A(this.f8026a, CollectionsKt.arrayListOf(2013), false, false);
    }

    public final void D() {
        VuGlassControlModel.f8109a.B();
    }

    public final void E() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActivity", "startUpdate");
        if (!VuGlassControlModel.f8109a.z()) {
            delegate.a("VuGlassesActivity", "startUpdate not connected");
            UToast.Companion companion = UToast.f6444a;
            MYVUActivity mYVUActivity = this.f8026a;
            String string = mYVUActivity.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(mYVUActivity, string);
            return;
        }
        VuGlassesOtaModel.f8117a.J();
    }

    public final void F() {
        Job job;
        Job job2 = this.h;
        if (!(job2 == null || !job2.isActive() || (job = this.h) == null)) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.f8026a.G1();
    }

    public final void G() {
        VuGlassControlModel.f8109a.C();
    }

    public final void H() {
        Job job;
        Job job2 = this.h;
        if (!(job2 == null || !job2.isActive() || (job = this.h) == null)) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.h = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.f8026a), (CoroutineContext) null, (CoroutineStart) null, new VuGlassesActivity$tryConnectAir$1(this, (Continuation<? super VuGlassesActivity$tryConnectAir$1>) null), 3, (Object) null);
    }

    public final void I() {
        VuGlassesOtaModel vuGlassesOtaModel = VuGlassesOtaModel.f8117a;
        vuGlassesOtaModel.E(this.e);
        vuGlassesOtaModel.F(this.d);
    }

    public final void J() {
        VuGlassesDeviceInfoModel.f8112a.e().removeObserver(this.j);
    }

    public final void K() {
        VuGlassControlModel.f8109a.s().removeObserver(this.i);
    }

    public final void L() {
        VuGlassControlModel.f8109a.v().removeObserver(this.f);
    }

    public void a(int i2, int i3) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActivity", "buttonAction: " + i2 + ", " + i3);
        if (i2 == 2001) {
            delegate.a("MYVUActivity", "buttonAction: WINDOW_TYPE_CONNECT_VIEW: action: " + i3);
            if (i3 == 1101) {
                D();
            }
        } else if (i2 == 2012) {
            if (i3 == 1101) {
                s();
            }
            VuGlassUpdateHelper.f8081a.a();
        } else if (i2 == 2013) {
            if (i3 == 1101) {
                E();
            }
            VuGlassUpdateHelper.f8081a.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(boolean r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.upuphone.xr.sapp.vu.VuGlassesActivity$onUsbOpenResult$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.xr.sapp.vu.VuGlassesActivity$onUsbOpenResult$1 r0 = (com.upuphone.xr.sapp.vu.VuGlassesActivity$onUsbOpenResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.VuGlassesActivity$onUsbOpenResult$1 r0 = new com.upuphone.xr.sapp.vu.VuGlassesActivity$onUsbOpenResult$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            com.upuphone.xr.sapp.vu.VuGlassesActivity r4 = (com.upuphone.xr.sapp.vu.VuGlassesActivity) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 != 0) goto L_0x003d
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x003d:
            r0.L$0 = r4
            r0.label = r3
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.b(r5, r0)
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r5 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a
            java.lang.String r6 = r5.d()
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Glasses openUsb success get name: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "VuGlassesActivity"
            r0.a(r2, r1)
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r0 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            r0.F(r6)
            com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel r6 = com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel.f8112a
            r6.f()
            com.upuphone.xr.sapp.vu.vm.VuGlassesPreferenceModel r4 = r4.q()
            r4.p()
            com.upuphone.xr.sapp.utils.NpsUtils r4 = com.upuphone.xr.sapp.utils.NpsUtils.b()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r5 = r5.g()
            r4.g(r6, r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.VuGlassesActivity.b(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void c(int i2, Object obj) {
        if (obj instanceof Integer) {
            boolean areEqual = Intrinsics.areEqual(obj, (Object) 2);
            DataStoreUtils.e.a().o("vu_auto_connect_view_glass", Boolean.valueOf(areEqual));
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassesActivity", "jumpAction: WINDOW_TYPE_CONNECT_VIEW: dontAskAgain: " + areEqual);
        }
    }

    public void d(boolean z) {
        this.c = z;
        if (z) {
            G();
        }
    }

    public final void m() {
        this.g = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.f8026a), (CoroutineContext) null, (CoroutineStart) null, new VuGlassesActivity$addViewGlassesObserver$1(this, (Continuation<? super VuGlassesActivity$addViewGlassesObserver$1>) null), 3, (Object) null);
    }

    public final MYVUActivity o() {
        return this.f8026a;
    }

    public void onCreate() {
        t();
    }

    public void onDestroy() {
        ULog.f6446a.a("VuGlassesActivity", "onDestroy");
        I();
        J();
        L();
        VuGlassesHidManager.f8100a.t(this);
        K();
    }

    public void onNewIntent(Intent intent) {
        boolean z = false;
        if (intent != null) {
            z = intent.getBooleanExtra("go_to_update", false);
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActivity", "onNewIntent gotoUpdate: " + z);
        if (z) {
            s();
            GenericWindowManger.Companion companion = GenericWindowManger.c;
            if (companion.a().k(2012)) {
                companion.a().j(2012);
            }
            if (companion.a().k(2013)) {
                companion.a().j(2013);
            }
        }
    }

    public void onPause() {
        ULog.f6446a.a("VuGlassesActivity", "onPause");
        VuGlassesHidManager.f8100a.o();
    }

    public void onResume() {
        ULog.f6446a.a("VuGlassesActivity", "onResume");
        VuGlassControlModel.f8109a.m();
        VuGlassesHidManager.f8100a.p();
    }

    public boolean p() {
        return this.c;
    }

    public final VuGlassesPreferenceModel q() {
        return (VuGlassesPreferenceModel) this.b.getValue();
    }

    public final void s() {
        if (!VuGlassControlModel.f8109a.z()) {
            UToast.Companion companion = UToast.f6444a;
            MYVUActivity mYVUActivity = this.f8026a;
            String string = mYVUActivity.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(mYVUActivity, string);
            return;
        }
        ULog.Delegate delegate = ULog.f6446a;
        VuGlassesOtaModel vuGlassesOtaModel = VuGlassesOtaModel.f8117a;
        boolean v = vuGlassesOtaModel.v();
        delegate.a("VuGlassesActivity", "gotoGlassUpdatePage: " + v);
        if (vuGlassesOtaModel.v()) {
            MYVUActivity.r1(this.f8026a, R.id.vuGlassUpdateFragment, (Bundle) null, 2, (Object) null);
        }
    }

    public final void t() {
        u();
        x();
        v();
        w();
        y();
        VuGlassesHidManager.f8100a.l(this);
    }

    public final void u() {
        MzAccountManager.c.b().d().observe(this.f8026a, new VuGlassesActivity$listenLoginState$1(this));
    }

    public final void v() {
        VuGlassesOtaModel vuGlassesOtaModel = VuGlassesOtaModel.f8117a;
        vuGlassesOtaModel.s(this.d);
        vuGlassesOtaModel.r(this.e);
    }

    public final void w() {
        VuGlassesDeviceInfoModel.f8112a.e().observeForever(this.j);
    }

    public final void x() {
        VuGlassControlModel.f8109a.s().observeForever(this.i);
    }

    public final void y() {
        VuGlassControlModel.f8109a.v().observeForever(this.f);
    }

    public final void z() {
        F();
        WebsiteBlackListHelper.f8056a.t();
    }
}
