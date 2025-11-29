package com.upuphone.xr.sapp.glass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.honey.account.i8.f;
import com.honey.account.i8.g;
import com.honey.account.i8.h;
import com.honey.account.i8.i;
import com.honey.account.i8.j;
import com.meizu.common.app.LoadingDialog;
import com.meizu.common.widget.MzButton;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.fota.phone.GlassCheckUpdateResult;
import com.upuphone.star.fota.phone.GlassCheckUpdateResultKt;
import com.upuphone.star.fota.phone.GlassUpdateException;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.BaseActivity;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.ActivityGlassUpdateInfoBinding;
import com.upuphone.xr.sapp.databinding.LayGlassCheckUpdateErrorBinding;
import com.upuphone.xr.sapp.databinding.LayGlassNoUpdateBinding;
import com.upuphone.xr.sapp.databinding.LayGlassUpdateInfoBinding;
import com.upuphone.xr.sapp.entity.AirGlassInfo;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.BasicGlassInfoKt;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateState;
import com.upuphone.xr.sapp.entity.GlassUpdateDownloadProgress;
import com.upuphone.xr.sapp.entity.GlassUpdateProgress;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.FileSizeExtKt;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.StringExtKt;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import com.upuphone.xr.sapp.view.DownloadProgressView;
import com.upuphone.xr.sapp.view.InstallingProgressView;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import com.upuphone.xr.sapp.vm.GlassUpdateViewModel;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
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

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006*\u0002ae\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0001oB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\u0019\u001a\u00020\r2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001c\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\r2\b\b\u0001\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010\u0004J\u0017\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\r2\b\b\u0001\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b(\u0010#J#\u0010,\u001a\u00020\r2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000b0)H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020*H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020*H\u0002¢\u0006\u0004\b0\u0010/J\u0019\u00103\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u000101H\u0014¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\rH\u0014¢\u0006\u0004\b5\u0010\u0004J\u001f\u00108\u001a\u00020\r2\u0006\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020 H\u0016¢\u0006\u0004\b8\u00109J!\u0010<\u001a\u00020\r2\u0006\u00106\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010R\u001a\u00020M8BX\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0002¢\u0006\f\n\u0004\bZ\u0010O\u001a\u0004\b[\u0010\\R\u001b\u0010`\u001a\u00020Y8BX\u0002¢\u0006\f\n\u0004\b^\u0010O\u001a\u0004\b_\u0010\\R\u0014\u0010d\u001a\u00020a8\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0j0i8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006p"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassUpdateInfoActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "<init>", "()V", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "glassCheckUpdateState", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "glassUpdateState", "Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;", "glassUpdateProgress", "", "isConnected", "", "R0", "(Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;Lcom/upuphone/xr/sapp/entity/GlassUpdateState;Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;Z)V", "d1", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState$Error;", "error", "b1", "(Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState$Error;)V", "Lkotlin/Pair;", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;", "updatePair", "c1", "(Lkotlin/Pair;Lcom/upuphone/xr/sapp/entity/GlassUpdateState;Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;Z)V", "isAirGlass", "a1", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateState;Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;ZZ)V", "T0", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateState;)V", "", "errorCode", "e1", "(I)V", "J0", "wifiRequired", "K0", "(Z)V", "Q0", "", "", "result", "U0", "(Ljava/util/Map;)V", "P0", "()Ljava/lang/String;", "L0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "windowType", "actionType", "a", "(II)V", "", "data", "c", "(ILjava/lang/Object;)V", "Lcom/upuphone/xr/sapp/databinding/ActivityGlassUpdateInfoBinding;", "b", "Lcom/upuphone/xr/sapp/databinding/ActivityGlassUpdateInfoBinding;", "viewBinding", "Lcom/upuphone/xr/sapp/databinding/LayGlassCheckUpdateErrorBinding;", "Lcom/upuphone/xr/sapp/databinding/LayGlassCheckUpdateErrorBinding;", "updateErrorBinding", "Lcom/upuphone/xr/sapp/databinding/LayGlassUpdateInfoBinding;", "d", "Lcom/upuphone/xr/sapp/databinding/LayGlassUpdateInfoBinding;", "updateInfoBinding", "Lcom/upuphone/xr/sapp/databinding/LayGlassNoUpdateBinding;", "e", "Lcom/upuphone/xr/sapp/databinding/LayGlassNoUpdateBinding;", "noUpdateBinding", "Lcom/upuphone/xr/sapp/vm/GlassUpdateViewModel;", "f", "Lkotlin/Lazy;", "N0", "()Lcom/upuphone/xr/sapp/vm/GlassUpdateViewModel;", "glassUpdateVM", "g", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "currentGlassCheckUpdateState", "h", "Z", "needCheckUpdate", "Lcom/meizu/common/app/LoadingDialog;", "i", "M0", "()Lcom/meizu/common/app/LoadingDialog;", "checkingUpdateDialog", "j", "O0", "loadingDialog", "com/upuphone/xr/sapp/glass/GlassUpdateInfoActivity$networkCallback$1", "k", "Lcom/upuphone/xr/sapp/glass/GlassUpdateInfoActivity$networkCallback$1;", "networkCallback", "com/upuphone/xr/sapp/glass/GlassUpdateInfoActivity$connectListener$1", "l", "Lcom/upuphone/xr/sapp/glass/GlassUpdateInfoActivity$connectListener$1;", "connectListener", "Landroidx/activity/result/ActivityResultLauncher;", "", "m", "Landroidx/activity/result/ActivityResultLauncher;", "requestPermissionLauncher", "n", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassUpdateInfoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateInfoActivity.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateInfoActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1046:1\n75#2,13:1047\n256#3,2:1060\n256#3,2:1062\n256#3,2:1064\n256#3,2:1066\n256#3,2:1068\n256#3,2:1070\n256#3,2:1072\n256#3,2:1074\n256#3,2:1076\n256#3,2:1078\n256#3,2:1080\n256#3,2:1082\n256#3,2:1084\n256#3,2:1086\n256#3,2:1088\n256#3,2:1090\n256#3,2:1092\n256#3,2:1094\n256#3,2:1096\n256#3,2:1098\n256#3,2:1100\n256#3,2:1102\n256#3,2:1104\n256#3,2:1106\n256#3,2:1108\n256#3,2:1110\n256#3,2:1112\n256#3,2:1114\n256#3,2:1116\n256#3,2:1118\n256#3,2:1120\n256#3,2:1122\n256#3,2:1124\n256#3,2:1126\n256#3,2:1128\n256#3,2:1130\n256#3,2:1132\n256#3,2:1134\n256#3,2:1136\n254#3,4:1138\n256#3,2:1142\n254#3:1144\n256#3,2:1145\n256#3,2:1148\n256#3,2:1150\n1#4:1147\n*S KotlinDebug\n*F\n+ 1 GlassUpdateInfoActivity.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateInfoActivity\n*L\n78#1:1047,13\n255#1:1060,2\n256#1:1062,2\n257#1:1064,2\n267#1:1066,2\n268#1:1068,2\n269#1:1070,2\n276#1:1072,2\n277#1:1074,2\n284#1:1076,2\n285#1:1078,2\n292#1:1080,2\n293#1:1082,2\n300#1:1084,2\n301#1:1086,2\n308#1:1088,2\n309#1:1090,2\n324#1:1092,2\n325#1:1094,2\n336#1:1096,2\n340#1:1098,2\n346#1:1100,2\n352#1:1102,2\n353#1:1104,2\n367#1:1106,2\n368#1:1108,2\n369#1:1110,2\n370#1:1112,2\n371#1:1114,2\n372#1:1116,2\n390#1:1118,2\n391#1:1120,2\n392#1:1122,2\n423#1:1124,2\n424#1:1126,2\n454#1:1128,2\n455#1:1130,2\n583#1:1132,2\n591#1:1134,2\n613#1:1136,2\n614#1:1138,4\n615#1:1142,2\n617#1:1144\n616#1:1145,2\n894#1:1148,2\n895#1:1150,2\n*E\n"})
public final class GlassUpdateInfoActivity extends BaseActivity implements SuperGenericWindowView.IActionCallback {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);
    public ActivityGlassUpdateInfoBinding b;
    public LayGlassCheckUpdateErrorBinding c;
    public LayGlassUpdateInfoBinding d;
    public LayGlassNoUpdateBinding e;
    public final Lazy f = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GlassUpdateViewModel.class), new GlassUpdateInfoActivity$special$$inlined$viewModels$default$2(this), new GlassUpdateInfoActivity$special$$inlined$viewModels$default$1(this), new GlassUpdateInfoActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    public GlassCheckUpdateState g;
    public boolean h;
    public final Lazy i = LazyKt.lazy(new GlassUpdateInfoActivity$checkingUpdateDialog$2(this));
    public final Lazy j = LazyKt.lazy(new GlassUpdateInfoActivity$loadingDialog$2(this));
    public final GlassUpdateInfoActivity$networkCallback$1 k = new GlassUpdateInfoActivity$networkCallback$1(this);
    public final GlassUpdateInfoActivity$connectListener$1 l = new GlassUpdateInfoActivity$connectListener$1(this);
    public ActivityResultLauncher m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassUpdateInfoActivity$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ void S0(GlassUpdateInfoActivity glassUpdateInfoActivity, GlassCheckUpdateState glassCheckUpdateState, GlassUpdateState glassUpdateState, GlassUpdateProgress glassUpdateProgress, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            glassUpdateProgress = (GlassUpdateProgress) GlassUpdateHelper.b.K0().getValue();
        }
        if ((i2 & 8) != 0) {
            z = GlassHelper.f7049a.E();
        }
        glassUpdateInfoActivity.R0(glassCheckUpdateState, glassUpdateState, glassUpdateProgress, z);
    }

    public static final void V0(GlassUpdateInfoActivity glassUpdateInfoActivity, Map map) {
        Intrinsics.checkNotNullParameter(glassUpdateInfoActivity, "this$0");
        Intrinsics.checkNotNullParameter(map, "it");
        glassUpdateInfoActivity.U0(map);
    }

    public static final void W0(GlassUpdateInfoActivity glassUpdateInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(glassUpdateInfoActivity, "this$0");
        glassUpdateInfoActivity.onBackPressed();
    }

    public static final void X0(GlassUpdateInfoActivity glassUpdateInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(glassUpdateInfoActivity, "this$0");
        glassUpdateInfoActivity.J0();
    }

    public static final void Y0(GlassUpdateInfoActivity glassUpdateInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(glassUpdateInfoActivity, "this$0");
        if (!GlassHelper.f7049a.E()) {
            ContextExtKt.f(glassUpdateInfoActivity, R.string.device_disconnect, 0, 2, (Object) null);
        } else {
            GlassUpdateHelper.b.h0(0, true);
        }
    }

    public static final void Z0(GlassUpdateInfoActivity glassUpdateInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(glassUpdateInfoActivity, "this$0");
        AppUtils.q(AppUtils.f7842a, glassUpdateInfoActivity, 0, 2, (Object) null);
    }

    private final void d1() {
        LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding = this.c;
        LayGlassNoUpdateBinding layGlassNoUpdateBinding = null;
        if (layGlassCheckUpdateErrorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            layGlassCheckUpdateErrorBinding = null;
        }
        LinearLayout b2 = layGlassCheckUpdateErrorBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(8);
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding = this.d;
        if (layGlassUpdateInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding = null;
        }
        LinearLayout b3 = layGlassUpdateInfoBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(8);
        LayGlassNoUpdateBinding layGlassNoUpdateBinding2 = this.e;
        if (layGlassNoUpdateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noUpdateBinding");
        } else {
            layGlassNoUpdateBinding = layGlassNoUpdateBinding2;
        }
        LinearLayout b4 = layGlassNoUpdateBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b4, "getRoot(...)");
        b4.setVisibility(8);
        M0().show();
    }

    public final void J0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateInfoActivity$downloadPreCheck$1(this, (Continuation<? super GlassUpdateInfoActivity$downloadPreCheck$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r0 = r0.getSecond();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K0(boolean r11) {
        /*
            r10 = this;
            com.upuphone.xr.sapp.entity.GlassCheckUpdateState r0 = r10.g
            boolean r1 = r0 instanceof com.upuphone.xr.sapp.entity.GlassCheckUpdateState.Result
            java.lang.String r2 = "GlassUpdateInfoActivity"
            if (r1 != 0) goto L_0x001f
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "downloadUpdate, invalid currentGlassCheckUpdateState: "
            r11.append(r1)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.c(r2, r11)
            return
        L_0x001f:
            kotlin.Pair r0 = com.upuphone.xr.sapp.entity.GlassCheckUpdateStateKt.getResultOrNull(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0033
            java.lang.Object r0 = r0.getSecond()
            com.upuphone.star.fota.phone.GlassCheckUpdateResult r0 = (com.upuphone.star.fota.phone.GlassCheckUpdateResult) r0
            if (r0 == 0) goto L_0x0033
            com.upuphone.star.fota.phone.GlassUpdateInfo r0 = com.upuphone.star.fota.phone.GlassCheckUpdateResultKt.a(r0)
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            if (r0 != 0) goto L_0x003e
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r11 = "downloadUpdate, glassUpdateInfo is null"
            r10.c(r2, r11)
            return
        L_0x003e:
            java.lang.String r3 = r0.getPackLink()
            java.lang.String r4 = r0.getDigest()
            r5 = 0
            if (r3 == 0) goto L_0x00ed
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0051
            goto L_0x00ed
        L_0x0051:
            java.lang.String r3 = r0.getLatestVersion()
            if (r3 == 0) goto L_0x00ed
            int r3 = r3.length()
            if (r3 != 0) goto L_0x005f
            goto L_0x00ed
        L_0x005f:
            if (r4 == 0) goto L_0x00ed
            int r3 = r4.length()
            if (r3 != 0) goto L_0x0069
            goto L_0x00ed
        L_0x0069:
            java.lang.Long r3 = r0.getFileSize()
            if (r3 == 0) goto L_0x007b
            long r6 = r3.longValue()
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x007b
            goto L_0x00ed
        L_0x007b:
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r3 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            com.upuphone.xr.sapp.entity.GlassUpdateDownloadProgress r4 = r3.G0(r4)
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "downloadUpdate, savedDownloadProgress: "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            r6.a(r2, r7)
            r2 = 1
            if (r4 == 0) goto L_0x00be
            float r6 = r4.getPercent()
            r7 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x00be
            java.lang.String r6 = r4.getFilePath()
            if (r6 == 0) goto L_0x00be
            int r6 = r6.length()
            if (r6 != 0) goto L_0x00b1
            goto L_0x00be
        L_0x00b1:
            java.io.File r11 = new java.io.File
            java.lang.String r4 = r4.getFilePath()
            r11.<init>(r4)
            r3.n0(r11, r0, r2, r5)
            goto L_0x00c1
        L_0x00be:
            r3.H1(r0, r11, r2, r5)
        L_0x00c1:
            com.upuphone.xr.sapp.databinding.LayGlassUpdateInfoBinding r11 = r10.d
            java.lang.String r0 = "updateInfoBinding"
            if (r11 != 0) goto L_0x00cc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r11 = r1
        L_0x00cc:
            com.meizu.common.widget.MzButton r11 = r11.b
            java.lang.String r2 = "btnDownload"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            r2 = 8
            r11.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.LayGlassUpdateInfoBinding r10 = r10.d
            if (r10 != 0) goto L_0x00e0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x00e1
        L_0x00e0:
            r1 = r10
        L_0x00e1:
            android.widget.TextView r10 = r1.i
            java.lang.String r11 = "tvUpdateNotice"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r10.setVisibility(r2)
            return
        L_0x00ed:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "downloadUpdate, invalid glassUpdateInfo: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r11.c(r2, r0)
            int r11 = com.upuphone.xr.sapp.R.string.update_info_invalid
            r0 = 2
            com.upuphone.xr.sapp.utils.ContextExtKt.f(r10, r11, r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity.K0(boolean):void");
    }

    public final String L0() {
        try {
            int i2 = R.string.pls_keep_glass_battery;
            int m2 = GlassUpdateAdapter.b.m();
            String string = getString(i2, new Object[]{m2 + "%"});
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            String string2 = getString(R.string.pls_keep_glass_battery);
            delegate.c("GlassUpdateInfoActivity", "getBatteryLimitText, originalText: " + string2);
            delegate.c("GlassUpdateInfoActivity", "getBatteryLimitText, error: " + th);
            return "";
        }
    }

    public final LoadingDialog M0() {
        return (LoadingDialog) this.i.getValue();
    }

    public final GlassUpdateViewModel N0() {
        return (GlassUpdateViewModel) this.f.getValue();
    }

    public final LoadingDialog O0() {
        return (LoadingDialog) this.j.getValue();
    }

    public final String P0() {
        try {
            int i2 = R.string.glass_system_update_notice;
            int m2 = GlassUpdateAdapter.b.m();
            String string = getString(i2, new Object[]{m2 + "%"});
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            String string2 = getString(R.string.glass_system_update_notice);
            delegate.c("GlassUpdateInfoActivity", "getUpdateNoticeText, originalText: " + string2);
            delegate.c("GlassUpdateInfoActivity", "getUpdateNoticeText, error: " + th);
            return "";
        }
    }

    public final void Q0(int i2) {
        if (i2 == 1) {
            StaticMethodUtilsKt.N(this);
        } else if (i2 != 101) {
            if (!(i2 == 115 || i2 == 116)) {
                switch (i2) {
                    case 103:
                    case 104:
                        break;
                    case 105:
                        ContextExtKt.g(this, L0(), 0, 2, (Object) null);
                        return;
                    case 106:
                        StaticMethodUtilsKt.A(this, CollectionsKt.arrayListOf(Integer.valueOf(CmdCode.CODE_RESET_VAD_STATUS)), false, false);
                        return;
                    default:
                        ULog.Delegate delegate = ULog.f6446a;
                        delegate.a("GlassUpdateInfoActivity", "handleDownloadPreCheckEvent, unknown code: " + i2);
                        return;
                }
            }
            ContextExtKt.f(this, R.string.fail_to_get_glass_info, 0, 2, (Object) null);
        } else {
            ContextExtKt.f(this, R.string.glass_disconnect_toast, 0, 2, (Object) null);
        }
    }

    public final void R0(GlassCheckUpdateState glassCheckUpdateState, GlassUpdateState glassUpdateState, GlassUpdateProgress glassUpdateProgress, boolean z) {
        if (glassCheckUpdateState instanceof GlassCheckUpdateState.Loading) {
            d1();
        } else if (glassCheckUpdateState instanceof GlassCheckUpdateState.Error) {
            M0().dismiss();
            b1((GlassCheckUpdateState.Error) glassCheckUpdateState);
        } else if (glassCheckUpdateState instanceof GlassCheckUpdateState.Result) {
            M0().dismiss();
            c1(((GlassCheckUpdateState.Result) glassCheckUpdateState).getPair(), glassUpdateState, glassUpdateProgress, z);
        } else {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("GlassUpdateInfoActivity", "handleGlassUpdateState - unknown glassCheckUpdateState: " + glassCheckUpdateState);
        }
    }

    public final void T0(GlassUpdateState glassUpdateState) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassUpdateInfoActivity", "handleGlassUpdateStateResultEvent, state: " + glassUpdateState);
        if (glassUpdateState instanceof GlassUpdateState.GlassUpdateFail) {
            GlassUpdateHelper.b.Z0(((GlassUpdateState.GlassUpdateFail) glassUpdateState).getUid(), new GlassUpdateInfoActivity$handleGlassUpdateStateResultEvent$1(this));
        } else if (glassUpdateState instanceof GlassUpdateState.DownloadFail) {
            GlassUpdateHelper.b.Z0(((GlassUpdateState.DownloadFail) glassUpdateState).getUid(), new GlassUpdateInfoActivity$handleGlassUpdateStateResultEvent$2(this));
        } else if (glassUpdateState instanceof GlassUpdateState.InstallFail) {
            GlassUpdateHelper.b.Z0(((GlassUpdateState.InstallFail) glassUpdateState).getUid(), new GlassUpdateInfoActivity$handleGlassUpdateStateResultEvent$3(this, glassUpdateState));
        } else if (glassUpdateState instanceof GlassUpdateState.TransferFail) {
            GlassUpdateHelper.b.Z0(((GlassUpdateState.TransferFail) glassUpdateState).getUid(), new GlassUpdateInfoActivity$handleGlassUpdateStateResultEvent$4(this, glassUpdateState));
        } else if (glassUpdateState instanceof GlassUpdateState.VerifyFail) {
            GlassUpdateHelper.b.Z0(((GlassUpdateState.VerifyFail) glassUpdateState).getUid(), new GlassUpdateInfoActivity$handleGlassUpdateStateResultEvent$5(this));
        }
    }

    public final void U0(Map map) {
        Boolean bool = (Boolean) map.get("android.permission.ACCESS_FINE_LOCATION");
        if (bool != null && !bool.booleanValue()) {
            StaticMethodUtilsKt.A(this, CollectionsKt.arrayListOf(157), false, false);
        }
    }

    public void a(int i2, int i3) {
        if (i2 != 118) {
            if (i2 != 120) {
                if (i2 != 152) {
                    if (i2 != 153) {
                        switch (i2) {
                            case 103:
                                if (i3 == 1101) {
                                    K0(false);
                                    return;
                                }
                                return;
                            case 104:
                            case 105:
                                if (i3 == 1101) {
                                    J0();
                                    return;
                                }
                                return;
                            default:
                                switch (i2) {
                                    case 155:
                                        if (i3 == 1101) {
                                            StaticMethodUtilsKt.o(this);
                                            return;
                                        }
                                        return;
                                    case 156:
                                        if (i3 == 1101) {
                                            AppUtils.n(AppUtils.f7842a, this, 0, 2, (Object) null);
                                            return;
                                        }
                                        return;
                                    case 157:
                                        if (i3 == 1101) {
                                            StaticMethodUtilsKt.o(this);
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                        }
                    } else if (i3 == 1101) {
                        AppUtils.l(AppUtils.f7842a, this, 0, 2, (Object) null);
                    }
                } else if (i3 == 1101) {
                    AppUtils.q(AppUtils.f7842a, this, 0, 2, (Object) null);
                }
            } else if (i3 == 1101) {
                AppUtils.q(AppUtils.f7842a, this, 0, 2, (Object) null);
            }
        } else if (i3 == 1101) {
            AppUtils.f7842a.r(this);
        }
    }

    public final void a1(GlassUpdateState glassUpdateState, GlassUpdateProgress glassUpdateProgress, boolean z, boolean z2) {
        int progress;
        boolean z3 = glassUpdateState instanceof GlassUpdateState.Downloading;
        int i2 = 0;
        boolean z4 = true;
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding = null;
        if (z3) {
            int percent = (int) (((GlassUpdateState.Downloading) glassUpdateState).getPercent() * ((float) 100));
            String str = getString(R.string.status_downloading) + " " + percent + "%";
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding2 = this.d;
            if (layGlassUpdateInfoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding2 = null;
            }
            layGlassUpdateInfoBinding2.j.setText(str);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding3 = this.d;
            if (layGlassUpdateInfoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding3 = null;
            }
            layGlassUpdateInfoBinding3.f.c(percent, true);
        } else if (glassUpdateState instanceof GlassUpdateState.DownloadFail) {
            int percent2 = (int) (((GlassUpdateState.DownloadFail) glassUpdateState).getPercent() * ((float) 100));
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding4 = this.d;
            if (layGlassUpdateInfoBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding4 = null;
            }
            layGlassUpdateInfoBinding4.b.setText(R.string.resume_download);
            String str2 = getString(R.string.status_download_paused) + " " + percent2 + "%";
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding5 = this.d;
            if (layGlassUpdateInfoBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding5 = null;
            }
            layGlassUpdateInfoBinding5.j.setText(str2);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding6 = this.d;
            if (layGlassUpdateInfoBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding6 = null;
            }
            layGlassUpdateInfoBinding6.f.c(percent2, false);
        } else if (glassUpdateState instanceof GlassUpdateState.DownloadSuccess) {
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding7 = this.d;
            if (layGlassUpdateInfoBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding7 = null;
            }
            layGlassUpdateInfoBinding7.j.setText(R.string.status_download_complete);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding8 = this.d;
            if (layGlassUpdateInfoBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding8 = null;
            }
            layGlassUpdateInfoBinding8.f.c(100, false);
        } else if (glassUpdateState instanceof GlassUpdateState.Verifying) {
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding9 = this.d;
            if (layGlassUpdateInfoBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding9 = null;
            }
            layGlassUpdateInfoBinding9.j.setText(R.string.status_verifying);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding10 = this.d;
            if (layGlassUpdateInfoBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding10 = null;
            }
            layGlassUpdateInfoBinding10.f.c(100, false);
        } else if (glassUpdateState instanceof GlassUpdateState.VerifyFail) {
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding11 = this.d;
            if (layGlassUpdateInfoBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding11 = null;
            }
            layGlassUpdateInfoBinding11.b.setText(R.string.restart_download);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding12 = this.d;
            if (layGlassUpdateInfoBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding12 = null;
            }
            layGlassUpdateInfoBinding12.j.setText(R.string.status_verify_fail);
        } else if (glassUpdateState instanceof GlassUpdateState.VerifySuccess) {
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding13 = this.d;
            if (layGlassUpdateInfoBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding13 = null;
            }
            layGlassUpdateInfoBinding13.j.setText(R.string.status_verify_success);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding14 = this.d;
            if (layGlassUpdateInfoBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding14 = null;
            }
            layGlassUpdateInfoBinding14.f.c(100, false);
        } else if (glassUpdateState instanceof GlassUpdateState.WaitingUpdateDialogResult) {
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding15 = this.d;
            if (layGlassUpdateInfoBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding15 = null;
            }
            layGlassUpdateInfoBinding15.j.setText(R.string.status_waiting_confirm_on_glass);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding16 = this.d;
            if (layGlassUpdateInfoBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding16 = null;
            }
            layGlassUpdateInfoBinding16.f.c(100, false);
        } else {
            if (glassUpdateState instanceof GlassUpdateState.StarTransferring ? true : glassUpdateState instanceof GlassUpdateState.AirTransferring ? true : glassUpdateState instanceof GlassUpdateState.Installing) {
                String string = getString(R.string.status_installing);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (z && glassUpdateProgress != null && (progress = glassUpdateProgress.getProgress()) > 0) {
                    string = string + " " + progress + "%";
                }
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding17 = this.d;
                if (layGlassUpdateInfoBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding17 = null;
                }
                layGlassUpdateInfoBinding17.j.setText(string);
            } else {
                if (glassUpdateState instanceof GlassUpdateState.TransferFail ? true : glassUpdateState instanceof GlassUpdateState.InstallFail ? true : glassUpdateState instanceof GlassUpdateState.UpdateDisconnected ? true : glassUpdateState instanceof GlassUpdateState.GlassUpdateFail) {
                    LayGlassUpdateInfoBinding layGlassUpdateInfoBinding18 = this.d;
                    if (layGlassUpdateInfoBinding18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                        layGlassUpdateInfoBinding18 = null;
                    }
                    layGlassUpdateInfoBinding18.j.setText(R.string.status_install_fail);
                    LayGlassUpdateInfoBinding layGlassUpdateInfoBinding19 = this.d;
                    if (layGlassUpdateInfoBinding19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                        layGlassUpdateInfoBinding19 = null;
                    }
                    layGlassUpdateInfoBinding19.b.setText(R.string.update_now);
                } else if (glassUpdateState instanceof GlassUpdateState.UpdateDialogGlassCanceled) {
                    LayGlassUpdateInfoBinding layGlassUpdateInfoBinding20 = this.d;
                    if (layGlassUpdateInfoBinding20 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                        layGlassUpdateInfoBinding20 = null;
                    }
                    layGlassUpdateInfoBinding20.b.setText(R.string.update_now);
                } else if (glassUpdateState instanceof GlassUpdateState.GlassUpdateSuccess) {
                    LayGlassUpdateInfoBinding layGlassUpdateInfoBinding21 = this.d;
                    if (layGlassUpdateInfoBinding21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                        layGlassUpdateInfoBinding21 = null;
                    }
                    layGlassUpdateInfoBinding21.j.setText(R.string.update_success);
                } else {
                    ULog.f6446a.a("GlassUpdateInfoActivity", "refreshUpdateStateUI, unexpected glassUpdateState: " + glassUpdateState);
                }
            }
        }
        boolean z5 = z3 ? true : glassUpdateState instanceof GlassUpdateState.DownloadSuccess ? true : glassUpdateState instanceof GlassUpdateState.Verifying ? true : glassUpdateState instanceof GlassUpdateState.VerifySuccess ? true : glassUpdateState instanceof GlassUpdateState.WaitingUpdateDialogResult ? true : glassUpdateState instanceof GlassUpdateState.DownloadFail;
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding22 = this.d;
        if (layGlassUpdateInfoBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding22 = null;
        }
        DownloadProgressView downloadProgressView = layGlassUpdateInfoBinding22.f;
        Intrinsics.checkNotNullExpressionValue(downloadProgressView, "pbDownload");
        downloadProgressView.setVisibility(z5 ? 0 : 8);
        boolean z6 = glassUpdateState instanceof GlassUpdateState.Installing ? true : glassUpdateState instanceof GlassUpdateState.StarTransferring ? true : glassUpdateState instanceof GlassUpdateState.AirTransferring;
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding23 = this.d;
        if (layGlassUpdateInfoBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding23 = null;
        }
        InstallingProgressView installingProgressView = layGlassUpdateInfoBinding23.g;
        Intrinsics.checkNotNullExpressionValue(installingProgressView, "pbUpdate");
        installingProgressView.setVisibility(z6 ? 0 : 8);
        boolean z7 = glassUpdateState instanceof GlassUpdateState.DownloadFail;
        boolean z8 = z7 ? true : glassUpdateState instanceof GlassUpdateState.VerifyFail ? true : glassUpdateState instanceof GlassUpdateState.TransferFail ? true : glassUpdateState instanceof GlassUpdateState.InstallFail ? true : glassUpdateState instanceof GlassUpdateState.GlassUpdateFail ? true : glassUpdateState instanceof GlassUpdateState.UpdateDisconnected ? true : glassUpdateState instanceof GlassUpdateState.UpdateDialogGlassCanceled;
        boolean z9 = glassUpdateState instanceof GlassUpdateState.VerifySuccess ? !((GlassUpdateState.VerifySuccess) glassUpdateState).getInstallRequired() : z8;
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding24 = this.d;
        if (layGlassUpdateInfoBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding24 = null;
        }
        TextView textView = layGlassUpdateInfoBinding24.h;
        Intrinsics.checkNotNullExpressionValue(textView, "tvLatestVersion");
        textView.setVisibility(z8 && !z7 ? 0 : 8);
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding25 = this.d;
        if (layGlassUpdateInfoBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding25 = null;
        }
        TextView textView2 = layGlassUpdateInfoBinding25.j;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvUpdateStatus");
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding26 = this.d;
        if (layGlassUpdateInfoBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding26 = null;
        }
        TextView textView3 = layGlassUpdateInfoBinding26.h;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvLatestVersion");
        textView2.setVisibility((textView3.getVisibility() == 0) ^ true ? 0 : 8);
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding27 = this.d;
        if (layGlassUpdateInfoBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding27 = null;
        }
        MzButton mzButton = layGlassUpdateInfoBinding27.b;
        Intrinsics.checkNotNullExpressionValue(mzButton, "btnDownload");
        mzButton.setVisibility(z9 ? 0 : 8);
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding28 = this.d;
        if (layGlassUpdateInfoBinding28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding28 = null;
        }
        TextView textView4 = layGlassUpdateInfoBinding28.i;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvUpdateNotice");
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding29 = this.d;
        if (layGlassUpdateInfoBinding29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding29 = null;
        }
        MzButton mzButton2 = layGlassUpdateInfoBinding29.b;
        Intrinsics.checkNotNullExpressionValue(mzButton2, "btnDownload");
        if (!(mzButton2.getVisibility() == 0) || z7) {
            z4 = false;
        }
        if (!z4) {
            i2 = 8;
        }
        textView4.setVisibility(i2);
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding30 = this.d;
        if (layGlassUpdateInfoBinding30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding30 = null;
        }
        layGlassUpdateInfoBinding30.i.setText(P0());
        if (z5) {
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding31 = this.d;
            if (layGlassUpdateInfoBinding31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            } else {
                layGlassUpdateInfoBinding = layGlassUpdateInfoBinding31;
            }
            layGlassUpdateInfoBinding.k.setText(P0());
        } else if (z6) {
            if (z) {
                String n2 = GlassUpdateAdapter.b.n(this);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding32 = this.d;
                if (layGlassUpdateInfoBinding32 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                } else {
                    layGlassUpdateInfoBinding = layGlassUpdateInfoBinding32;
                }
                layGlassUpdateInfoBinding.k.setText(n2);
                return;
            }
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding33 = this.d;
            if (layGlassUpdateInfoBinding33 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            } else {
                layGlassUpdateInfoBinding = layGlassUpdateInfoBinding33;
            }
            layGlassUpdateInfoBinding.k.setText(R.string.glass_system_update_notice_disconnect);
        } else if (!z8) {
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding34 = this.d;
            if (layGlassUpdateInfoBinding34 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            } else {
                layGlassUpdateInfoBinding = layGlassUpdateInfoBinding34;
            }
            layGlassUpdateInfoBinding.k.setText(P0());
        }
    }

    public final void b1(GlassCheckUpdateState.Error error) {
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding = this.d;
        LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding = null;
        if (layGlassUpdateInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding = null;
        }
        LinearLayout b2 = layGlassUpdateInfoBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(8);
        LayGlassNoUpdateBinding layGlassNoUpdateBinding = this.e;
        if (layGlassNoUpdateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noUpdateBinding");
            layGlassNoUpdateBinding = null;
        }
        LinearLayout b3 = layGlassNoUpdateBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(8);
        LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding2 = this.c;
        if (layGlassCheckUpdateErrorBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            layGlassCheckUpdateErrorBinding2 = null;
        }
        LinearLayout b4 = layGlassCheckUpdateErrorBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b4, "getRoot(...)");
        b4.setVisibility(0);
        int errorCode = error.getErrorCode();
        if (errorCode == 1) {
            this.h = true;
            LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding3 = this.c;
            if (layGlassCheckUpdateErrorBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            } else {
                layGlassCheckUpdateErrorBinding = layGlassCheckUpdateErrorBinding3;
            }
            layGlassCheckUpdateErrorBinding.d.setImageResource(R.mipmap.ic_network_error);
            layGlassCheckUpdateErrorBinding.e.setText(R.string.network_not_available_pls_check);
            Button button = layGlassCheckUpdateErrorBinding.b;
            Intrinsics.checkNotNullExpressionValue(button, "btnRetry");
            button.setVisibility(8);
            Button button2 = layGlassCheckUpdateErrorBinding.c;
            Intrinsics.checkNotNullExpressionValue(button2, "btnSetupNetwork");
            button2.setVisibility(0);
        } else if (errorCode == 2) {
            LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding4 = this.c;
            if (layGlassCheckUpdateErrorBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            } else {
                layGlassCheckUpdateErrorBinding = layGlassCheckUpdateErrorBinding4;
            }
            layGlassCheckUpdateErrorBinding.d.setImageResource(R.mipmap.ic_bluetooth_error);
            layGlassCheckUpdateErrorBinding.e.setText(R.string.glass_disconnect_toast);
            Button button3 = layGlassCheckUpdateErrorBinding.b;
            Intrinsics.checkNotNullExpressionValue(button3, "btnRetry");
            button3.setVisibility(0);
            Button button4 = layGlassCheckUpdateErrorBinding.c;
            Intrinsics.checkNotNullExpressionValue(button4, "btnSetupNetwork");
            button4.setVisibility(8);
        } else if (errorCode == 3) {
            LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding5 = this.c;
            if (layGlassCheckUpdateErrorBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            } else {
                layGlassCheckUpdateErrorBinding = layGlassCheckUpdateErrorBinding5;
            }
            layGlassCheckUpdateErrorBinding.d.setImageResource(R.mipmap.ic_glass_error);
            layGlassCheckUpdateErrorBinding.e.setText(R.string.fail_to_get_glass_info);
            Button button5 = layGlassCheckUpdateErrorBinding.b;
            Intrinsics.checkNotNullExpressionValue(button5, "btnRetry");
            button5.setVisibility(0);
            Button button6 = layGlassCheckUpdateErrorBinding.c;
            Intrinsics.checkNotNullExpressionValue(button6, "btnSetupNetwork");
            button6.setVisibility(8);
        } else if (errorCode == 4) {
            LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding6 = this.c;
            if (layGlassCheckUpdateErrorBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            } else {
                layGlassCheckUpdateErrorBinding = layGlassCheckUpdateErrorBinding6;
            }
            layGlassCheckUpdateErrorBinding.d.setImageResource(R.mipmap.ic_network_error);
            layGlassCheckUpdateErrorBinding.e.setText(R.string.network_error_pls_retry_later);
            Button button7 = layGlassCheckUpdateErrorBinding.b;
            Intrinsics.checkNotNullExpressionValue(button7, "btnRetry");
            button7.setVisibility(0);
            Button button8 = layGlassCheckUpdateErrorBinding.c;
            Intrinsics.checkNotNullExpressionValue(button8, "btnSetupNetwork");
            button8.setVisibility(8);
        } else if (errorCode == 5) {
            LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding7 = this.c;
            if (layGlassCheckUpdateErrorBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            } else {
                layGlassCheckUpdateErrorBinding = layGlassCheckUpdateErrorBinding7;
            }
            layGlassCheckUpdateErrorBinding.d.setImageResource(R.mipmap.ic_network_error);
            layGlassCheckUpdateErrorBinding.e.setText(error.getMsg());
            Button button9 = layGlassCheckUpdateErrorBinding.b;
            Intrinsics.checkNotNullExpressionValue(button9, "btnRetry");
            button9.setVisibility(0);
            Button button10 = layGlassCheckUpdateErrorBinding.c;
            Intrinsics.checkNotNullExpressionValue(button10, "btnSetupNetwork");
            button10.setVisibility(8);
        }
    }

    public void c(int i2, Object obj) {
    }

    public final void c1(Pair pair, GlassUpdateState glassUpdateState, GlassUpdateProgress glassUpdateProgress, boolean z) {
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding;
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding2;
        String digest;
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding3;
        String digest2;
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding4;
        LayGlassNoUpdateBinding layGlassNoUpdateBinding;
        LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding;
        GlassUpdateState glassUpdateState2 = glassUpdateState;
        GlassUpdateProgress glassUpdateProgress2 = glassUpdateProgress;
        boolean z2 = z;
        if (pair == null) {
            ULog.f6446a.a("GlassUpdateInfoActivity", "setupUI - return, no updatePair");
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding5 = this.d;
            if (layGlassUpdateInfoBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding5 = null;
            }
            LinearLayout b2 = layGlassUpdateInfoBinding5.getRoot();
            Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
            b2.setVisibility(8);
            LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding2 = this.c;
            if (layGlassCheckUpdateErrorBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
                layGlassCheckUpdateErrorBinding = null;
            } else {
                layGlassCheckUpdateErrorBinding = layGlassCheckUpdateErrorBinding2;
            }
            LinearLayout b3 = layGlassCheckUpdateErrorBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
            b3.setVisibility(8);
            return;
        }
        try {
            GlassUpdateInfo b4 = GlassCheckUpdateResultKt.b((GlassCheckUpdateResult) pair.getSecond());
            LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding3 = this.c;
            if (layGlassCheckUpdateErrorBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
                layGlassCheckUpdateErrorBinding3 = null;
            }
            LinearLayout b5 = layGlassCheckUpdateErrorBinding3.getRoot();
            Intrinsics.checkNotNullExpressionValue(b5, "getRoot(...)");
            b5.setVisibility(8);
            BasicGlassInfo basicGlassInfo = (BasicGlassInfo) pair.getFirst();
            if (!b4.getExistsUpdate()) {
                LayGlassNoUpdateBinding layGlassNoUpdateBinding2 = this.e;
                if (layGlassNoUpdateBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noUpdateBinding");
                    layGlassNoUpdateBinding2 = null;
                }
                LinearLayout b6 = layGlassNoUpdateBinding2.getRoot();
                Intrinsics.checkNotNullExpressionValue(b6, "getRoot(...)");
                b6.setVisibility(0);
                LayGlassNoUpdateBinding layGlassNoUpdateBinding3 = this.e;
                if (layGlassNoUpdateBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noUpdateBinding");
                    layGlassNoUpdateBinding3 = null;
                }
                layGlassNoUpdateBinding3.b.setText(getString(R.string.glass_is_latest_version_param, new Object[]{BasicGlassInfoKt.getSafeDisplayName(basicGlassInfo)}));
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding6 = this.d;
                if (layGlassUpdateInfoBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding6 = null;
                }
                LinearLayout b7 = layGlassUpdateInfoBinding6.getRoot();
                Intrinsics.checkNotNullExpressionValue(b7, "getRoot(...)");
                b7.setVisibility(8);
                LayGlassNoUpdateBinding layGlassNoUpdateBinding4 = this.e;
                if (layGlassNoUpdateBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noUpdateBinding");
                    layGlassNoUpdateBinding = null;
                } else {
                    layGlassNoUpdateBinding = layGlassNoUpdateBinding4;
                }
                layGlassNoUpdateBinding.c.setText(basicGlassInfo.getRomVersion());
                return;
            }
            LayGlassNoUpdateBinding layGlassNoUpdateBinding5 = this.e;
            if (layGlassNoUpdateBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noUpdateBinding");
                layGlassNoUpdateBinding5 = null;
            }
            LinearLayout b8 = layGlassNoUpdateBinding5.getRoot();
            Intrinsics.checkNotNullExpressionValue(b8, "getRoot(...)");
            b8.setVisibility(8);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding7 = this.d;
            if (layGlassUpdateInfoBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding7 = null;
            }
            LinearLayout b9 = layGlassUpdateInfoBinding7.getRoot();
            Intrinsics.checkNotNullExpressionValue(b9, "getRoot(...)");
            b9.setVisibility(0);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding8 = this.d;
            if (layGlassUpdateInfoBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding8 = null;
            }
            layGlassUpdateInfoBinding8.h.setText(b4.getVersionFullName());
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding9 = this.d;
            if (layGlassUpdateInfoBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding9 = null;
            }
            TextView textView = layGlassUpdateInfoBinding9.k;
            Long fileSize = b4.getFileSize();
            textView.setText(FileSizeExtKt.a(fileSize != null ? fileSize.longValue() : 0));
            String a2 = StringExtKt.a(b4.getReleaseNote());
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding10 = this.d;
            if (layGlassUpdateInfoBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding10 = null;
            }
            layGlassUpdateInfoBinding10.l.setText(a2);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding11 = this.d;
            if (layGlassUpdateInfoBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding11 = null;
            }
            layGlassUpdateInfoBinding11.b.setText(R.string.download_and_install);
            LayGlassUpdateInfoBinding layGlassUpdateInfoBinding12 = this.d;
            if (layGlassUpdateInfoBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                layGlassUpdateInfoBinding12 = null;
            }
            layGlassUpdateInfoBinding12.i.setText(P0());
            if (glassUpdateState2 == null || (glassUpdateState2 instanceof GlassUpdateState.GlassUpdateIdle)) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("GlassUpdateInfoActivity", "setupUI, glassUpdateState: " + glassUpdateState2 + ", reset view visibility");
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding13 = this.d;
                if (layGlassUpdateInfoBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding13 = null;
                }
                TextView textView2 = layGlassUpdateInfoBinding13.j;
                Intrinsics.checkNotNullExpressionValue(textView2, "tvUpdateStatus");
                textView2.setVisibility(8);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding14 = this.d;
                if (layGlassUpdateInfoBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding14 = null;
                }
                InstallingProgressView installingProgressView = layGlassUpdateInfoBinding14.g;
                Intrinsics.checkNotNullExpressionValue(installingProgressView, "pbUpdate");
                installingProgressView.setVisibility(8);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding15 = this.d;
                if (layGlassUpdateInfoBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding15 = null;
                }
                DownloadProgressView downloadProgressView = layGlassUpdateInfoBinding15.f;
                Intrinsics.checkNotNullExpressionValue(downloadProgressView, "pbDownload");
                downloadProgressView.setVisibility(8);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding16 = this.d;
                if (layGlassUpdateInfoBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding16 = null;
                }
                TextView textView3 = layGlassUpdateInfoBinding16.h;
                Intrinsics.checkNotNullExpressionValue(textView3, "tvLatestVersion");
                textView3.setVisibility(0);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding17 = this.d;
                if (layGlassUpdateInfoBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding17 = null;
                }
                TextView textView4 = layGlassUpdateInfoBinding17.i;
                Intrinsics.checkNotNullExpressionValue(textView4, "tvUpdateNotice");
                textView4.setVisibility(0);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding18 = this.d;
                if (layGlassUpdateInfoBinding18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding18 = null;
                }
                MzButton mzButton = layGlassUpdateInfoBinding18.b;
                Intrinsics.checkNotNullExpressionValue(mzButton, "btnDownload");
                mzButton.setVisibility(0);
                GlassUpdateDownloadProgress G0 = GlassUpdateHelper.b.G0(b4.getDigest());
                if (G0 != null) {
                    delegate.a("GlassUpdateInfoActivity", "setupUI, savedDownloadProgress: " + G0);
                    if (G0.getPercent() >= 1.0f) {
                        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding19 = this.d;
                        if (layGlassUpdateInfoBinding19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                            layGlassUpdateInfoBinding2 = null;
                        } else {
                            layGlassUpdateInfoBinding2 = layGlassUpdateInfoBinding19;
                        }
                        layGlassUpdateInfoBinding2.b.setText(R.string.update_now);
                    } else if (G0.getPercent() > 0.0f) {
                        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding20 = this.d;
                        if (layGlassUpdateInfoBinding20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                            layGlassUpdateInfoBinding = null;
                        } else {
                            layGlassUpdateInfoBinding = layGlassUpdateInfoBinding20;
                        }
                        layGlassUpdateInfoBinding.b.setText(R.string.resume_download);
                    }
                }
            } else {
                T0(glassUpdateState2);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding21 = this.d;
                if (layGlassUpdateInfoBinding21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding21 = null;
                }
                TextView textView5 = layGlassUpdateInfoBinding21.h;
                Intrinsics.checkNotNullExpressionValue(textView5, "tvLatestVersion");
                textView5.setVisibility(0);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding22 = this.d;
                if (layGlassUpdateInfoBinding22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding22 = null;
                }
                TextView textView6 = layGlassUpdateInfoBinding22.j;
                Intrinsics.checkNotNullExpressionValue(textView6, "tvUpdateStatus");
                textView6.setVisibility(8);
                LayGlassUpdateInfoBinding layGlassUpdateInfoBinding23 = this.d;
                if (layGlassUpdateInfoBinding23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                    layGlassUpdateInfoBinding23 = null;
                }
                MzButton mzButton2 = layGlassUpdateInfoBinding23.b;
                Intrinsics.checkNotNullExpressionValue(mzButton2, "btnDownload");
                mzButton2.setVisibility(0);
                boolean z3 = basicGlassInfo instanceof AirGlassInfo;
                if (glassUpdateState2 instanceof GlassUpdateState.GlassUpdateFail) {
                    ULog.Delegate delegate2 = ULog.f6446a;
                    String latestVersion = b4.getLatestVersion();
                    GlassUpdateState.GlassUpdateFail glassUpdateFail = (GlassUpdateState.GlassUpdateFail) glassUpdateState2;
                    String version = glassUpdateFail.getVersion();
                    String digest3 = b4.getDigest();
                    String digest4 = glassUpdateFail.getDigest();
                    StringBuilder sb = new StringBuilder();
                    boolean z4 = z3;
                    sb.append("setupUI-GlassInstallFail, version: ");
                    sb.append(latestVersion);
                    sb.append(",  ");
                    sb.append(version);
                    sb.append(", digest: ");
                    sb.append(digest3);
                    sb.append(", ");
                    sb.append(digest4);
                    delegate2.a("GlassUpdateInfoActivity", sb.toString());
                    String version2 = glassUpdateFail.getVersion();
                    if (version2 == null || version2.length() == 0 || (digest2 = glassUpdateFail.getDigest()) == null || digest2.length() == 0) {
                        a1(glassUpdateState, glassUpdateProgress, z, z4);
                    } else if (Intrinsics.areEqual((Object) glassUpdateFail.getVersion(), (Object) b4.getLatestVersion()) || Intrinsics.areEqual((Object) glassUpdateFail.getDigest(), (Object) b4.getDigest())) {
                        a1(glassUpdateState, glassUpdateProgress, z, z4);
                    } else {
                        delegate2.c("GlassUpdateInfoActivity", "setupUI-GlassInstallFail, fallback");
                        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding24 = this.d;
                        if (layGlassUpdateInfoBinding24 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                            layGlassUpdateInfoBinding24 = null;
                        }
                        InstallingProgressView installingProgressView2 = layGlassUpdateInfoBinding24.g;
                        Intrinsics.checkNotNullExpressionValue(installingProgressView2, "pbUpdate");
                        installingProgressView2.setVisibility(8);
                        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding25 = this.d;
                        if (layGlassUpdateInfoBinding25 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                            layGlassUpdateInfoBinding4 = null;
                        } else {
                            layGlassUpdateInfoBinding4 = layGlassUpdateInfoBinding25;
                        }
                        DownloadProgressView downloadProgressView2 = layGlassUpdateInfoBinding4.f;
                        Intrinsics.checkNotNullExpressionValue(downloadProgressView2, "pbDownload");
                        downloadProgressView2.setVisibility(8);
                    }
                } else if (glassUpdateState2 instanceof GlassUpdateState.GlassUpdateSuccess) {
                    ULog.Delegate delegate3 = ULog.f6446a;
                    String latestVersion2 = b4.getLatestVersion();
                    GlassUpdateState.GlassUpdateSuccess glassUpdateSuccess = (GlassUpdateState.GlassUpdateSuccess) glassUpdateState2;
                    String version3 = glassUpdateSuccess.getVersion();
                    String digest5 = b4.getDigest();
                    String digest6 = glassUpdateSuccess.getDigest();
                    StringBuilder sb2 = new StringBuilder();
                    boolean z5 = z3;
                    sb2.append("setupUI-GlassUpdateSuccess, version: ");
                    sb2.append(latestVersion2);
                    sb2.append(", ");
                    sb2.append(version3);
                    sb2.append(", digest: ");
                    sb2.append(digest5);
                    sb2.append(", ");
                    sb2.append(digest6);
                    delegate3.a("GlassUpdateInfoActivity", sb2.toString());
                    String version4 = glassUpdateSuccess.getVersion();
                    if (version4 == null || version4.length() == 0 || (digest = glassUpdateSuccess.getDigest()) == null || digest.length() == 0) {
                        a1(glassUpdateState, glassUpdateProgress, z, z5);
                    } else if (Intrinsics.areEqual((Object) glassUpdateSuccess.getVersion(), (Object) b4.getLatestVersion()) || Intrinsics.areEqual((Object) glassUpdateSuccess.getDigest(), (Object) b4.getDigest())) {
                        a1(glassUpdateState, glassUpdateProgress, z, z5);
                    } else {
                        delegate3.c("GlassUpdateInfoActivity", "setupUI-GlassUpdateSuccess, fallback");
                        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding26 = this.d;
                        if (layGlassUpdateInfoBinding26 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                            layGlassUpdateInfoBinding26 = null;
                        }
                        InstallingProgressView installingProgressView3 = layGlassUpdateInfoBinding26.g;
                        Intrinsics.checkNotNullExpressionValue(installingProgressView3, "pbUpdate");
                        installingProgressView3.setVisibility(8);
                        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding27 = this.d;
                        if (layGlassUpdateInfoBinding27 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
                            layGlassUpdateInfoBinding3 = null;
                        } else {
                            layGlassUpdateInfoBinding3 = layGlassUpdateInfoBinding27;
                        }
                        DownloadProgressView downloadProgressView3 = layGlassUpdateInfoBinding3.f;
                        Intrinsics.checkNotNullExpressionValue(downloadProgressView3, "pbDownload");
                        downloadProgressView3.setVisibility(8);
                    }
                } else if (glassUpdateState2 instanceof GlassUpdateState.GlassUpdateInfoState) {
                    ULog.Delegate delegate4 = ULog.f6446a;
                    String latestVersion3 = b4.getLatestVersion();
                    GlassUpdateState.GlassUpdateInfoState glassUpdateInfoState = (GlassUpdateState.GlassUpdateInfoState) glassUpdateState2;
                    String latestVersion4 = glassUpdateInfoState.getGlassUpdateInfo().getLatestVersion();
                    String digest7 = b4.getDigest();
                    String digest8 = glassUpdateInfoState.getGlassUpdateInfo().getDigest();
                    delegate4.a("GlassUpdateInfoActivity", "setupUI-glassUpdateState: " + glassUpdateState2 + ", version: " + latestVersion3 + ",  " + latestVersion4 + ", digest: " + digest7 + ", " + digest8);
                    if (Intrinsics.areEqual((Object) b4.getDigest(), (Object) glassUpdateInfoState.getGlassUpdateInfo().getDigest()) && Intrinsics.areEqual((Object) b4.getLatestVersion(), (Object) glassUpdateInfoState.getGlassUpdateInfo().getLatestVersion())) {
                        a1(glassUpdateState2, glassUpdateProgress, z2, z3);
                    }
                }
            }
        } catch (GlassUpdateException e2) {
            ULog.Delegate delegate5 = ULog.f6446a;
            delegate5.a("GlassUpdateInfoActivity", "setupUI updatePair error: " + e2);
            b1(new GlassCheckUpdateState.Error(5, e2.getMsg()));
        }
    }

    public final void e1(int i2) {
        StaticMethodUtilsKt.A(this, CollectionsKt.arrayListOf(104), false, false);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassUpdateInfoActivity", "showUpdateFailTips, errorCode: " + i2);
    }

    public void onCreate(Bundle bundle) {
        ActivityGlassUpdateInfoBinding activityGlassUpdateInfoBinding;
        super.onCreate(bundle);
        ActivityGlassUpdateInfoBinding c2 = ActivityGlassUpdateInfoBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNull(c2);
        this.b = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityGlassUpdateInfoBinding = null;
        } else {
            activityGlassUpdateInfoBinding = c2;
        }
        LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding = activityGlassUpdateInfoBinding.c;
        Intrinsics.checkNotNullExpressionValue(layGlassCheckUpdateErrorBinding, "layGlassCheckUpdateError");
        this.c = layGlassCheckUpdateErrorBinding;
        ActivityGlassUpdateInfoBinding activityGlassUpdateInfoBinding2 = this.b;
        if (activityGlassUpdateInfoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityGlassUpdateInfoBinding2 = null;
        }
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding = activityGlassUpdateInfoBinding2.e;
        Intrinsics.checkNotNullExpressionValue(layGlassUpdateInfoBinding, "layGlassUpdateInfo");
        this.d = layGlassUpdateInfoBinding;
        ActivityGlassUpdateInfoBinding activityGlassUpdateInfoBinding3 = this.b;
        if (activityGlassUpdateInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityGlassUpdateInfoBinding3 = null;
        }
        LayGlassNoUpdateBinding layGlassNoUpdateBinding = activityGlassUpdateInfoBinding3.d;
        Intrinsics.checkNotNullExpressionValue(layGlassNoUpdateBinding, "layGlassNoUpdate");
        this.e = layGlassNoUpdateBinding;
        setContentView((View) c2.getRoot());
        FlymeUtils.a(c2.getRoot(), this);
        this.m = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new f(this));
        ActivityGlassUpdateInfoBinding activityGlassUpdateInfoBinding4 = this.b;
        if (activityGlassUpdateInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityGlassUpdateInfoBinding4 = null;
        }
        activityGlassUpdateInfoBinding4.b.setOnClickListener(new g(this));
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding2 = this.d;
        if (layGlassUpdateInfoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding2 = null;
        }
        MzButton mzButton = layGlassUpdateInfoBinding2.b;
        Intrinsics.checkNotNullExpressionValue(mzButton, "btnDownload");
        ViewExtKt.b(mzButton, new h(this));
        LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding2 = this.c;
        if (layGlassCheckUpdateErrorBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            layGlassCheckUpdateErrorBinding2 = null;
        }
        Button button = layGlassCheckUpdateErrorBinding2.b;
        Intrinsics.checkNotNullExpressionValue(button, "btnRetry");
        ViewExtKt.b(button, new i(this));
        LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding3 = this.c;
        if (layGlassCheckUpdateErrorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateErrorBinding");
            layGlassCheckUpdateErrorBinding3 = null;
        }
        Button button2 = layGlassCheckUpdateErrorBinding3.c;
        Intrinsics.checkNotNullExpressionValue(button2, "btnSetupNetwork");
        ViewExtKt.b(button2, new j(this));
        LayGlassUpdateInfoBinding layGlassUpdateInfoBinding3 = this.d;
        if (layGlassUpdateInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateInfoBinding");
            layGlassUpdateInfoBinding3 = null;
        }
        layGlassUpdateInfoBinding3.f.d(10, 10);
        NetworkUtils.f7898a.o(this, this.k);
        N0().d().observe(this, new GlassUpdateInfoActivity$sam$androidx_lifecycle_Observer$0(new GlassUpdateInfoActivity$onCreate$7(this)));
        N0().e().observe(this, new GlassUpdateInfoActivity$sam$androidx_lifecycle_Observer$0(new GlassUpdateInfoActivity$onCreate$8(this)));
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.K0().observe(this, new GlassUpdateInfoActivity$sam$androidx_lifecycle_Observer$0(new GlassUpdateInfoActivity$onCreate$9(this)));
        GlassHelper.f7049a.k(this, this.l);
        glassUpdateHelper.h0(0, true);
        glassUpdateHelper.j0(0, true);
        GlassUpdateHelper.r1(glassUpdateHelper, (GlassCheckUpdateState) null, 1, (Object) null);
    }

    public void onResume() {
        super.onResume();
        GlassUpdateHelper.b.b0();
    }
}
