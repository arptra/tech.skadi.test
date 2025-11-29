package com.upuphone.xr.sapp.vu.vm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;
import com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper;
import com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.upuphone.xr.sapp.vu.utils.VuWebViewUtils;
import com.xjmz.myvu.common.ConnectVoidResult;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import com.xjmz.myvu.flutter.pigeon.AndroidViewGlassControlApi;
import com.xjmz.myvu.modules.home.HomeFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \\2\u00020\u0001:\u0001]B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eH@¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u000eH@¢\u0006\u0004\b\u0017\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0013H@¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\bJ\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\bJ\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\bJ\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\bJ\u001f\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010)J!\u0010,\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010\u0011J\r\u0010/\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u00100\u001a\u0004\b1\u00102R'\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020504038BX\u0002¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b7\u00108R\u001b\u0010=\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b,\u00106\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010I\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010/R\u0016\u0010K\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010DR\u0016\u0010M\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010DR\u0016\u0010O\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010DR\u0016\u0010Q\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010DR$\u0010Y\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010D¨\u0006^"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesModel;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesBaseModel;", "Lcom/xjmz/myvu/modules/home/HomeFragment;", "fragment", "<init>", "(Lcom/xjmz/myvu/modules/home/HomeFragment;)V", "", "F", "()V", "E", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$ConnectState;", "state", "G", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$ConnectState;)V", "", "autoOpen", "L", "(Z)V", "J", "", "H", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "x", "S", "w", "()Z", "Q", "R", "y", "O", "N", "M", "onCreate", "b", "onResume", "onStop", "onDestroy", "windowType", "actionType", "a", "(II)V", "", "data", "c", "(ILjava/lang/Object;)V", "K", "I", "Lcom/xjmz/myvu/modules/home/HomeFragment;", "z", "()Lcom/xjmz/myvu/modules/home/HomeFragment;", "", "", "", "Lkotlin/Lazy;", "B", "()Ljava/util/List;", "mustPermission", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "A", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "glassesPreferenceModel", "Lcom/xjmz/myvu/flutter/pigeon/AndroidViewGlassControlApi$FlutterViewGlassControlApi;", "d", "D", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidViewGlassControlApi$FlutterViewGlassControlApi;", "viewGlassControlApi", "e", "Z", "requestingFloatWindow", "f", "isAutoOpen", "g", "ungrantedMustPermission", "h", "isOpeningArSpace", "i", "requestingMustPermission", "j", "shouldShowUnableConnectWindow", "k", "autoOpenWhenConnect", "Lkotlinx/coroutines/Job;", "l", "Lkotlinx/coroutines/Job;", "C", "()Lkotlinx/coroutines/Job;", "P", "(Lkotlinx/coroutines/Job;)V", "openArSpaceJob", "m", "firstPermissionChecked", "n", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassesModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassesModel.kt\ncom/upuphone/xr/sapp/vu/vm/VuGlassesModel\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,506:1\n32#2,12:507\n*S KotlinDebug\n*F\n+ 1 VuGlassesModel.kt\ncom/upuphone/xr/sapp/vu/vm/VuGlassesModel\n*L\n73#1:507,12\n*E\n"})
public final class VuGlassesModel implements VuGlassesBaseModel {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);
    public static VuGlassesModel o;
    public static boolean p;

    /* renamed from: a  reason: collision with root package name */
    public final HomeFragment f8115a;
    public final Lazy b = LazyKt.lazy(VuGlassesModel$mustPermission$2.INSTANCE);
    public final Lazy c;
    public final Lazy d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Job l;
    public boolean m;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0002XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001d8\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesModel$Companion;", "", "<init>", "()V", "Lcom/xjmz/myvu/modules/home/HomeFragment;", "fragment", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesBaseModel;", "a", "(Lcom/xjmz/myvu/modules/home/HomeFragment;)Lcom/upuphone/xr/sapp/vu/vm/VuGlassesBaseModel;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesModel;", "instance", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesModel;", "b", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassesModel;", "setInstance", "(Lcom/upuphone/xr/sapp/vu/vm/VuGlassesModel;)V", "", "checkAutoOpenArSpace", "Z", "getCheckAutoOpenArSpace", "()Z", "c", "(Z)V", "", "FLOAT_WINDOW_CODE", "I", "OPEN_3D_MODE_HID_ERROR", "OPEN_3D_MODE_NO_PERMISSION", "OPEN_3D_MODE_SUCCESS", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VuGlassesBaseModel a(HomeFragment homeFragment) {
            Intrinsics.checkNotNullParameter(homeFragment, "fragment");
            return new VuGlassesModel(homeFragment);
        }

        public final VuGlassesModel b() {
            return VuGlassesModel.o;
        }

        public final void c(boolean z) {
            VuGlassesModel.p = z;
        }

        public Companion() {
        }
    }

    public VuGlassesModel(HomeFragment homeFragment) {
        Intrinsics.checkNotNullParameter(homeFragment, "fragment");
        this.f8115a = homeFragment;
        Class<VuGlassesPreferenceModel> cls = VuGlassesPreferenceModel.class;
        this.c = GlobalViewStoreExtKt.a(homeFragment, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, homeFragment), new GlobalViewStoreExtKt$cachedViewModels$5(homeFragment));
        this.d = LazyKt.lazy(new VuGlassesModel$viewGlassControlApi$2(this));
        this.j = true;
    }

    public final VuGlassesPreferenceModel A() {
        return (VuGlassesPreferenceModel) this.c.getValue();
    }

    public final List B() {
        return (List) this.b.getValue();
    }

    public final Job C() {
        return this.l;
    }

    public final AndroidViewGlassControlApi.FlutterViewGlassControlApi D() {
        return (AndroidViewGlassControlApi.FlutterViewGlassControlApi) this.d.getValue();
    }

    public final void E() {
        A().j().observe(this.f8115a.getViewLifecycleOwner(), new VuGlassesModel$sam$androidx_lifecycle_Observer$0(new VuGlassesModel$listenBrightness$1(this)));
    }

    public final void F() {
        VuGlassControlModel.f8109a.v().observe(this.f8115a.getViewLifecycleOwner(), new VuGlassesModel$sam$androidx_lifecycle_Observer$0(new VuGlassesModel$listenGlassesInfo$1(this)));
    }

    public final void G(AndroidConnectApi.ConnectState connectState) {
        this.f8115a.k0().i(connectState, new ConnectVoidResult());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[SYNTHETIC, Splitter:B:27:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object H(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.upuphone.xr.sapp.vu.vm.VuGlassesModel$open3DMode$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$open3DMode$1 r0 = (com.upuphone.xr.sapp.vu.vm.VuGlassesModel$open3DMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$open3DMode$1 r0 = new com.upuphone.xr.sapp.vu.vm.VuGlassesModel$open3DMode$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = -1
            r3 = 1
            java.lang.String r4 = "VuGlassesModel"
            if (r1 == 0) goto L_0x0034
            if (r1 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0074
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r7)
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r7 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel$ViewGlassesInfo r7 = r7.o()
            if (r7 != 0) goto L_0x0044
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            return r7
        L_0x0044:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "glassInfo: "
            r5.append(r6)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r1.a(r4, r5)
            boolean r1 = r7.d()
            if (r1 == 0) goto L_0x0069
            int r7 = r7.a()
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r7
        L_0x0069:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r7 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f8100a
            r0.label = r3
            java.lang.Object r7 = r7.y(r0)
            if (r7 != r8) goto L_0x0074
            return r8
        L_0x0074:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0081
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            return r7
        L_0x0081:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r7 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a     // Catch:{ Exception -> 0x0088 }
            int r7 = r7.x()     // Catch:{ Exception -> 0x0088 }
            goto L_0x0091
        L_0x0088:
            r7 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "openArSpace: set2D3DMode error"
            r8.d(r4, r0, r7)
            r7 = -2
        L_0x0091:
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "openArSpace: set2D3DMode "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r8.a(r4, r0)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesModel.H(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void I() {
        String a2 = VuWebViewUtils.f8107a.a();
        String string = this.f8115a.getString(R.string.adapter_devices);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Bundle bundle = new Bundle();
        bundle.putString("h5_url", a2);
        bundle.putString("h5_title", string);
        StaticMethodUtilsKt.v(this.f8115a, R.id.commonH5Fragment, bundle);
    }

    public final void J(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesModel", "openArSpace: ");
        if (this.h) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = this.f8115a.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.b(requireContext, R.string.opening_arspace);
            ArSpaceReportHelper.c(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.OpenArSpaceResult.OPENING, (String) null, 2, (Object) null);
            delegate.a("VuGlassesModel", "openArSpace: isOpeningArSpace");
        } else if (z || VuGlassesHidUtil.f8104a.o()) {
            this.l = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.f8115a), (CoroutineContext) null, (CoroutineStart) null, new VuGlassesModel$openArSpace$1(this, z, (Continuation<? super VuGlassesModel$openArSpace$1>) null), 3, (Object) null);
        } else {
            UToast.Companion companion2 = UToast.f6444a;
            Context requireContext2 = this.f8115a.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            companion2.b(requireContext2, R.string.switching_mode);
            ArSpaceReportHelper.c(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.OpenArSpaceResult.DISPLAY_CHIP_NOT_READY, (String) null, 2, (Object) null);
        }
    }

    public void K(boolean z) {
        ArSpaceReportHelper.f8088a.h(z);
        L(z);
    }

    public final void L(boolean z) {
        this.f = z;
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            ArSpaceReportHelper.c(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.OpenArSpaceResult.INTL_NOT_SUPPORT, (String) null, 2, (Object) null);
        } else if (VuGlassesOtaModel.f8117a.A()) {
            StaticMethodUtilsKt.O(this.f8115a);
            ULog.f6446a.a("VuGlassesModel", "performOpenArSpace is updating");
            ArSpaceReportHelper.c(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.OpenArSpaceResult.UPDATING, (String) null, 2, (Object) null);
        } else {
            VuGlassControlModel vuGlassControlModel = VuGlassControlModel.f8109a;
            if (!vuGlassControlModel.z()) {
                StaticMethodUtilsKt.a0(this.f8115a);
                ArSpaceReportHelper.c(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.OpenArSpaceResult.GLASSES_NOT_CONNECT, (String) null, 2, (Object) null);
                ULog.f6446a.a("VuGlassesModel", "performOpenArSpace glass not connected");
            } else if (vuGlassControlModel.x()) {
                if (!w()) {
                    ULog.Delegate delegate = ULog.f6446a;
                    int i2 = this.g;
                    delegate.a("VuGlassesModel", "initView: requestMustPermission: " + i2);
                    O();
                    return;
                }
                this.i = false;
                J(this.f);
            } else if (vuGlassControlModel.y()) {
                R();
                ULog.f6446a.a("VuGlassesModel", "performOpenArSpace display invalid");
                ArSpaceReportHelper.c(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.OpenArSpaceResult.DISPLAY_INVALID, (String) null, 2, (Object) null);
            } else if (vuGlassControlModel.z()) {
                UToast.Companion companion = UToast.f6444a;
                Context requireContext = this.f8115a.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                companion.b(requireContext, R.string.switching_mode);
                ArSpaceReportHelper.c(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.OpenArSpaceResult.DISPLAY_NOT_READY, (String) null, 2, (Object) null);
                ULog.f6446a.a("VuGlassesModel", "performOpenArSpace display not ready");
            }
        }
    }

    public final void M() {
        ULog.f6446a.a("VuGlassesModel", "requestFirstPermission");
        this.f8115a.V0();
    }

    public final void N() {
        StaticMethodUtilsKt.I(this.f8115a, CollectionsKt.arrayListOf(2010), false, false, 6, (Object) null);
    }

    public final void O() {
        ULog.Delegate delegate = ULog.f6446a;
        int i2 = this.g;
        delegate.a("VuGlassesModel", "requestMustPermission: ungrantedMustPermission: " + i2);
        String[] strArr = (String[]) B().get(this.g);
        FragmentActivity requireActivity = this.f8115a.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        if (strArr == PermissionAndStateCheckUtils.f7907a.v()) {
            N();
        } else {
            PermissionHelper.f7819a.r(requireActivity, strArr, true, new VuGlassesModel$requestMustPermission$1(this, strArr));
        }
    }

    public final void P(Job job) {
        this.l = job;
    }

    public final void Q() {
        StaticMethodUtilsKt.I(this.f8115a, CollectionsKt.arrayListOf(2011), false, false, 6, (Object) null);
    }

    public final void R() {
        if (this.j) {
            this.j = false;
            StaticMethodUtilsKt.I(this.f8115a, CollectionsKt.arrayListOf(Integer.valueOf(MSG.MSG_PREPARING_HINT_WAITING)), false, false, 6, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object S(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.upuphone.xr.sapp.vu.vm.VuGlassesModel$waitDisplayConnected$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$waitDisplayConnected$1 r0 = (com.upuphone.xr.sapp.vu.vm.VuGlassesModel$waitDisplayConnected$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$waitDisplayConnected$1 r0 = new com.upuphone.xr.sapp.vu.vm.VuGlassesModel$waitDisplayConnected$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            int r1 = r0.I$1
            int r3 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r1
        L_0x002d:
            r1 = r3
            goto L_0x003d
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = -1
            r1 = 100
        L_0x003d:
            if (r1 < 0) goto L_0x0068
            com.upuphone.xr.sapp.vu.utils.VuGlassesHelper r3 = com.upuphone.xr.sapp.vu.utils.VuGlassesHelper.f8099a
            android.view.Display r4 = r3.c()
            android.graphics.Point r3 = r3.d(r4)
            int r3 = r3.x
            r5 = 3840(0xf00, float:5.381E-42)
            if (r3 != r5) goto L_0x0057
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r6 = r4.getDisplayId()
            goto L_0x0068
        L_0x0057:
            int r3 = r1 + -1
            r0.I$0 = r3
            r0.I$1 = r6
            r0.label = r2
            r4 = 200(0xc8, double:9.9E-322)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r4, r0)
            if (r1 != r7) goto L_0x002d
            return r7
        L_0x0068:
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesModel.S(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void a(int i2, int i3) {
        if (i2 != 2010) {
            if (i2 == 2011 && i3 == 1101) {
                L(this.f);
            }
        } else if (i3 == 1101) {
            String packageName = MainApplication.k.f().getPackageName();
            this.f8115a.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + packageName)), 102);
            this.e = true;
        }
    }

    public void b() {
        F();
        E();
    }

    public void c(int i2, Object obj) {
        if (i2 == 2005) {
            I();
        }
    }

    public void onCreate() {
        o = this;
    }

    public void onDestroy() {
        o = null;
    }

    public void onResume() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = this.e;
        boolean z2 = p;
        delegate.a("VuGlassesModel", "onResume: requestingFloatWindow " + z + ", checkAutoOpenArSpace: " + z2);
        if (this.e) {
            this.e = false;
            if (Settings.canDrawOverlays(this.f8115a.requireContext())) {
                L(this.f);
            } else {
                ArSpaceReportHelper.f8088a.b(ArSpaceReportHelper.OpenArSpaceResult.NO_PERMISSION, "android.permission.SYSTEM_ALERT_WINDOW");
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        VuTouchpadActivity.Companion companion = VuTouchpadActivity.w;
        long c2 = elapsedRealtime - companion.c();
        delegate.a("VuGlassesModel", "interval: " + c2);
        if (p && companion.b() == null && GlassDataStoreHelper.f8091a.d()) {
            if (VuGlassControlModel.f8109a.x()) {
                K(true);
            } else {
                this.k = true;
            }
        }
        p = false;
    }

    public void onStop() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        r1 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a.o();
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[PHI: r1 
      PHI: (r1v2 boolean) = (r1v1 boolean), (r1v4 boolean) binds: [B:14:0x0045, B:16:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.upuphone.xr.sapp.vu.vm.VuGlassesModel$check7911Ready$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$check7911Ready$1 r0 = (com.upuphone.xr.sapp.vu.vm.VuGlassesModel$check7911Ready$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$check7911Ready$1 r0 = new com.upuphone.xr.sapp.vu.vm.VuGlassesModel$check7911Ready$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            boolean r1 = r0.Z$0
            int r3 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x002c:
            r6 = r3
            goto L_0x0045
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "VuGlassesModel"
            java.lang.String r3 = "check7911"
            r6.a(r1, r3)
            r6 = 10
            r1 = 0
        L_0x0045:
            if (r6 <= 0) goto L_0x0061
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r1 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a
            boolean r1 = r1.o()
            if (r1 == 0) goto L_0x0050
            goto L_0x0061
        L_0x0050:
            int r3 = r6 + -1
            r0.I$0 = r3
            r0.Z$0 = r1
            r0.label = r2
            r4 = 200(0xc8, double:9.9E-322)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r4, r0)
            if (r6 != r7) goto L_0x002c
            return r7
        L_0x0061:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesModel.v(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean w() {
        Context requireContext = this.f8115a.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        int i2 = 0;
        for (String[] strArr : B()) {
            int i3 = i2 + 1;
            if (strArr == PermissionAndStateCheckUtils.f7907a.v()) {
                boolean canDrawOverlays = Settings.canDrawOverlays(requireContext);
                ULog.f6446a.a("VuGlassesModel", "checkMustPermission canDrawOverlays: " + canDrawOverlays);
                if (!canDrawOverlays) {
                    this.g = i2;
                    return false;
                }
            } else if (!PermissionHelper.f7819a.n(requireContext, strArr)) {
                this.g = i2;
                return false;
            }
            i2 = i3;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00da A[PHI: r11 
      PHI: (r11v10 java.lang.Object) = (r11v12 java.lang.Object), (r11v1 java.lang.Object) binds: [B:37:0x00d7, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.upuphone.xr.sapp.vu.vm.VuGlassesModel$checkUsbAgain$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$checkUsbAgain$1 r0 = (com.upuphone.xr.sapp.vu.vm.VuGlassesModel$checkUsbAgain$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel$checkUsbAgain$1 r0 = new com.upuphone.xr.sapp.vu.vm.VuGlassesModel$checkUsbAgain$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            java.lang.String r7 = "VuGlassesModel"
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00da
        L_0x0033:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003b:
            java.lang.Object r10 = r0.L$0
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r10 = (com.upuphone.xr.sapp.vu.vm.VuGlassesModel) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00bc
        L_0x0044:
            boolean r10 = r0.Z$0
            int r2 = r0.I$0
            java.lang.Object r8 = r0.L$0
            com.upuphone.xr.sapp.vu.vm.VuGlassesModel r8 = (com.upuphone.xr.sapp.vu.vm.VuGlassesModel) r8
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r2
            r2 = r10
            r10 = r8
            goto L_0x0060
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r11)
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r2 = "checkUsbAgain"
            r11.a(r7, r2)
            r11 = 40
            r2 = r6
        L_0x0060:
            if (r11 <= 0) goto L_0x0085
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r8 = "checkUsbAgain wait device connect"
            r2.a(r7, r8)
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r2 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            boolean r2 = r2.z()
            if (r2 == 0) goto L_0x0072
            goto L_0x0085
        L_0x0072:
            int r11 = r11 + -1
            r0.L$0 = r10
            r0.I$0 = r11
            r0.Z$0 = r2
            r0.label = r5
            r8 = 50
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r8, r0)
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0085:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "checkUsbAgain: connect result: "
            r5.append(r8)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r11.a(r7, r5)
            if (r2 != 0) goto L_0x00a2
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r10
        L_0x00a2:
            java.lang.String r2 = "checkUsbAgain needMustRecordPermission"
            r11.a(r7, r2)
            com.upuphone.xr.sapp.vu.utils.ArSpaceUtil r11 = com.upuphone.xr.sapp.vu.utils.ArSpaceUtil.f8089a
            boolean r11 = r11.i()
            if (r11 == 0) goto L_0x00cc
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r11 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f8100a
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r11 = r11.m(r0)
            if (r11 != r1) goto L_0x00bc
            return r1
        L_0x00bc:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x00cc
            r10.Q()
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r10
        L_0x00cc:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r10 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f8100a
            r11 = 0
            r0.L$0 = r11
            r0.label = r3
            java.lang.Object r11 = r10.y(r0)
            if (r11 != r1) goto L_0x00da
            return r1
        L_0x00da:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesModel.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void y() {
        GenericWindowManger.c.a().j(MSG.MSG_PREPARING_HINT_WAITING);
        this.j = true;
    }

    public final HomeFragment z() {
        return this.f8115a;
    }
}
