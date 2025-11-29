package com.upuphone.ar.tici.phone;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.p4.m;
import com.honey.account.p4.n;
import com.honey.account.p4.o;
import com.honey.account.p4.p;
import com.honey.account.p4.q;
import com.honey.account.p4.r;
import com.honey.account.p4.s;
import com.honey.account.p4.t;
import com.honey.account.p4.u;
import com.honey.account.p4.v;
import com.honey.account.p4.w;
import com.honey.account.p4.x;
import com.honey.account.p4.y;
import com.honey.account.p4.z;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.ActivityTiciHistoryBinding;
import com.upuphone.ar.tici.databinding.TiciImportFailedBinding;
import com.upuphone.ar.tici.databinding.TiciImportingFileBinding;
import com.upuphone.ar.tici.phone.data.ImportFailReason;
import com.upuphone.ar.tici.phone.data.ImportFileState;
import com.upuphone.ar.tici.phone.data.OpenTiciFrom;
import com.upuphone.ar.tici.phone.data.TiciFileChangedEvent;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.data.TiciHistoryKt;
import com.upuphone.ar.tici.phone.epoxy.TiciHistoryController;
import com.upuphone.ar.tici.phone.listener.TiciHistoryItemListener;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReply;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import com.upuphone.ar.tici.phone.utils.StringExtKt;
import com.upuphone.ar.tici.phone.utils.TiciDataTrack;
import com.upuphone.ar.tici.phone.viewmodel.TiciHistoryViewModel;
import com.upuphone.ar.tici.phone.widget.BubbleWidget;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.starrynet.common.StarryNetConstant;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.app.ShowAtBottomAlertDialog;
import flyme.support.v7.widget.PopupMenu;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Y2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u0019\u0010.\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0014¢\u0006\u0004\b2\u00103R\u001b\u00109\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0002¢\u0006\f\n\u0004\bD\u00106\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0002¢\u0006\f\n\u0004\bI\u00106\u001a\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciHistoryActivity;", "Lcom/upuphone/ar/tici/phone/BaseTiciActivity;", "<init>", "()V", "", "initViews", "r1", "U0", "initViewModels", "p1", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "ticiHistory", "z1", "(Lcom/upuphone/ar/tici/phone/data/TiciHistory;)V", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReply;", "result", "e1", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReply;)V", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV2;", "f1", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV2;)V", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV3;", "g1", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV3;)V", "Landroid/view/View;", "view", "w1", "(Landroid/view/View;)V", "t1", "(Landroid/view/View;Lcom/upuphone/ar/tici/phone/data/TiciHistory;)V", "V0", "Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "state", "c1", "(Lcom/upuphone/ar/tici/phone/data/ImportFileState;)V", "", "errorMsg", "showErrorMsg", "(Ljava/lang/String;)V", "Lcom/upuphone/ar/tici/phone/data/TiciFileChangedEvent;", "event", "h1", "(Lcom/upuphone/ar/tici/phone/data/TiciFileChangedEvent;)V", "s1", "Landroid/net/Uri;", "uri", "b1", "(Landroid/net/Uri;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/upuphone/ar/tici/databinding/ActivityTiciHistoryBinding;", "b", "Lkotlin/Lazy;", "X0", "()Lcom/upuphone/ar/tici/databinding/ActivityTiciHistoryBinding;", "layout", "Lcom/upuphone/ar/tici/phone/viewmodel/TiciHistoryViewModel;", "c", "a1", "()Lcom/upuphone/ar/tici/phone/viewmodel/TiciHistoryViewModel;", "viewModel", "Lcom/upuphone/ar/tici/phone/TiciAppViewModel;", "d", "Lcom/upuphone/ar/tici/phone/TiciAppViewModel;", "appViewModel", "Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;", "e", "Z0", "()Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;", "ticiHistoryItemListener", "Lcom/upuphone/ar/tici/phone/epoxy/TiciHistoryController;", "f", "Y0", "()Lcom/upuphone/ar/tici/phone/epoxy/TiciHistoryController;", "ticiHistoryController", "", "g", "Z", "isIntlVersion", "Landroidx/activity/result/ActivityResultLauncher;", "h", "Landroidx/activity/result/ActivityResultLauncher;", "fileChooseLauncher", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "autoHideErrorMsgJob", "j", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciHistoryActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHistoryActivity.kt\ncom/upuphone/ar/tici/phone/TiciHistoryActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 ContextExt.kt\ncom/upuphone/xr/sapp/utils/ContextExtKt\n*L\n1#1,547:1\n75#2,13:548\n262#3,2:561\n262#3,2:563\n262#3,2:565\n262#3,2:567\n19#4,9:569\n19#4,9:578\n*S KotlinDebug\n*F\n+ 1 TiciHistoryActivity.kt\ncom/upuphone/ar/tici/phone/TiciHistoryActivity\n*L\n61#1:548,13\n493#1:561,2\n501#1:563,2\n509#1:565,2\n519#1:567,2\n283#1:569,9\n295#1:578,9\n*E\n"})
public final class TiciHistoryActivity extends BaseTiciActivity {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(new TiciHistoryActivity$layout$2(this));
    public final Lazy c = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TiciHistoryViewModel.class), new TiciHistoryActivity$special$$inlined$viewModels$default$2(this), new TiciHistoryActivity$special$$inlined$viewModels$default$1(this), new TiciHistoryActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    public final TiciAppViewModel d = TiciApp.b.c();
    public final Lazy e = LazyKt.lazy(new TiciHistoryActivity$ticiHistoryItemListener$2(this));
    public final Lazy f = LazyKt.lazy(new TiciHistoryActivity$ticiHistoryController$2(this));
    public final boolean g = SdkContext.f6675a.c().e();
    public ActivityResultLauncher h;
    public Job i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciHistoryActivity$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.upuphone.ar.tici.phone.data.ImportFailReason[] r0 = com.upuphone.ar.tici.phone.data.ImportFailReason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.ar.tici.phone.data.ImportFailReason r1 = com.upuphone.ar.tici.phone.data.ImportFailReason.TextByteOverSize     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.ar.tici.phone.data.ImportFailReason r1 = com.upuphone.ar.tici.phone.data.ImportFailReason.FileOver200K     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.upuphone.ar.tici.phone.data.ImportFailReason r1 = com.upuphone.ar.tici.phone.data.ImportFailReason.FileOver10M     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.upuphone.ar.tici.phone.data.ImportFailReason r1 = com.upuphone.ar.tici.phone.data.ImportFailReason.UnknownEncoding     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.upuphone.ar.tici.phone.data.ImportFailReason r1 = com.upuphone.ar.tici.phone.data.ImportFailReason.UnsupportedFile     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.upuphone.ar.tici.phone.data.ImportFailReason r1 = com.upuphone.ar.tici.phone.data.ImportFailReason.EmptyContent     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciHistoryActivity.WhenMappings.<clinit>():void");
        }
    }

    public static final void W0(TiciHistoryActivity ticiHistoryActivity, TiciHistory ticiHistory, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(ticiHistoryActivity, "this$0");
        Intrinsics.checkNotNullParameter(ticiHistory, "$ticiHistory");
        CommonExtKt.e("deleteItemAsk-onClick, " + i2, "TiciHistoryActivity");
        ticiHistoryActivity.a1().g(ticiHistory);
        TiciDataTrack.f6001a.c("app_prompt_delete", MapsKt.emptyMap());
    }

    public static final void d1(DialogInterface dialogInterface, int i2) {
        CommonExtKt.e("handleImportFileState, click i_known", "TiciHistoryActivity");
    }

    public static final void i1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void initViewModels() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryActivity$initViewModels$1(this, (Continuation<? super TiciHistoryActivity$initViewModels$1>) null), 3, (Object) null);
        this.d.K().observe(this, new s(new TiciHistoryActivity$initViewModels$2(this)));
        this.d.I().observe(this, new t(new TiciHistoryActivity$initViewModels$3(this)));
        this.d.R().observe(this, new u(new TiciHistoryActivity$initViewModels$4(this)));
        Job unused2 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryActivity$initViewModels$5(this, (Continuation<? super TiciHistoryActivity$initViewModels$5>) null), 3, (Object) null);
        Job unused3 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryActivity$initViewModels$6(this, (Continuation<? super TiciHistoryActivity$initViewModels$6>) null), 3, (Object) null);
        Job unused4 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryActivity$initViewModels$7(this, (Continuation<? super TiciHistoryActivity$initViewModels$7>) null), 3, (Object) null);
        Job unused5 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryActivity$initViewModels$8(this, (Continuation<? super TiciHistoryActivity$initViewModels$8>) null), 3, (Object) null);
        Job unused6 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryActivity$initViewModels$9(this, (Continuation<? super TiciHistoryActivity$initViewModels$9>) null), 3, (Object) null);
    }

    private final void initViews() {
        TiciTitleBar ticiTitleBar = X0().g;
        ticiTitleBar.getTitle().setText(R.string.tici_files);
        ticiTitleBar.getSettingImg().setImageResource(R.drawable.btn_tici_add_selector);
        ViewExtKt.b(ticiTitleBar.getSettingImg(), new v(this));
        if (this.g) {
            ticiTitleBar.getFolderImg().setImageResource(R.drawable.ic_tici_alert);
            ViewExtKt.b(ticiTitleBar.getFolderImg(), new w(this));
        } else {
            CommonExtKt.f(ticiTitleBar.getFolderImg());
        }
        ViewExtKt.b(ticiTitleBar.getBackImg(), new x(this));
        RecyclerView recyclerView = X0().e;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(Y0().getAdapter());
        X0().f.getCloseBtn().setOnClickListener(new y(this));
        U0();
    }

    public static final void j1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void k1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void l1(TiciHistoryActivity ticiHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiHistoryActivity, "this$0");
        if (TiciApp.b.d()) {
            Intrinsics.checkNotNull(view);
            ticiHistoryActivity.w1(view);
        }
    }

    public static final void m1(TiciHistoryActivity ticiHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiHistoryActivity, "this$0");
        ticiHistoryActivity.r1();
    }

    public static final void n1(TiciHistoryActivity ticiHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiHistoryActivity, "this$0");
        ticiHistoryActivity.finish();
    }

    public static final void o1(TiciHistoryActivity ticiHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiHistoryActivity, "this$0");
        SpUtilKt.s(false);
        BubbleWidget bubbleWidget = ticiHistoryActivity.X0().f;
        Intrinsics.checkNotNullExpressionValue(bubbleWidget, "tipWidget");
        CommonExtKt.f(bubbleWidget);
    }

    public static final void q1(TiciHistoryActivity ticiHistoryActivity, Uri uri) {
        Intrinsics.checkNotNullParameter(ticiHistoryActivity, "this$0");
        ticiHistoryActivity.b1(uri);
    }

    public static final boolean u1(TiciHistoryActivity ticiHistoryActivity, TiciHistory ticiHistory, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(ticiHistoryActivity, "this$0");
        Intrinsics.checkNotNullParameter(ticiHistory, "$ticiHistory");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_edit_tici) {
            TiciNewFileActivity.e.a(ticiHistoryActivity, ticiHistory.getId());
            long id = ticiHistory.getId();
            TiciApp ticiApp = TiciApp.b;
            Long S = ticiApp.c().S();
            if (S != null && id == S.longValue()) {
                ticiApp.c().S0(false);
                ticiApp.q().sendAutoTiciState(false);
            }
            TiciDataTrack.f6001a.c("app_prompt_edit", MapsKt.emptyMap());
            return true;
        } else if (itemId != R.id.menu_delete_tici) {
            return true;
        } else {
            ticiHistoryActivity.V0(ticiHistory);
            return true;
        }
    }

    public static final void v1(View view, PopupMenu popupMenu) {
        Intrinsics.checkNotNullParameter(view, "$view");
        CommonExtKt.b("showItemMenu-onDismiss", "TiciHistoryActivity");
        view.setSelected(false);
    }

    public static final boolean x1(TiciHistoryActivity ticiHistoryActivity, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(ticiHistoryActivity, "this$0");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_create_tici_file) {
            Intent intent = new Intent(ticiHistoryActivity, TiciNewFileActivity.class);
            if (!(ticiHistoryActivity instanceof Activity)) {
                intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            }
            ticiHistoryActivity.startActivity(intent);
            TiciDataTrack.f6001a.c("app_prompt_add_click", MapsKt.mapOf(TuplesKt.to("type", 0)));
        } else if (itemId == R.id.menu_import_from_file) {
            if (ticiHistoryActivity.g) {
                ticiHistoryActivity.s1();
            } else {
                ticiHistoryActivity.startActivity(new Intent(ticiHistoryActivity, TiciImportFileActivity.class));
            }
            TiciDataTrack.f6001a.c("app_prompt_add_click", MapsKt.mapOf(TuplesKt.to("type", 1)));
        } else if (itemId == R.id.menu_import_from_other_app) {
            TiciDataTrack.f6001a.c("app_prompt_add_click", MapsKt.mapOf(TuplesKt.to("type", 2)));
        }
        return true;
    }

    public static final void y1(View view, PopupMenu popupMenu) {
        Intrinsics.checkNotNullParameter(view, "$view");
        CommonExtKt.b("showTitleBarMenu-onDismiss", "TiciHistoryActivity");
        view.setSelected(false);
    }

    public final void U0() {
        if (!this.g) {
            BubbleWidget bubbleWidget = X0().f;
            Intrinsics.checkNotNullExpressionValue(bubbleWidget, "tipWidget");
            CommonExtKt.f(bubbleWidget);
        } else if (SpUtilKt.i()) {
            BubbleWidget bubbleWidget2 = X0().f;
            Intrinsics.checkNotNullExpressionValue(bubbleWidget2, "tipWidget");
            CommonExtKt.g(bubbleWidget2);
        } else {
            BubbleWidget bubbleWidget3 = X0().f;
            Intrinsics.checkNotNullExpressionValue(bubbleWidget3, "tipWidget");
            CommonExtKt.f(bubbleWidget3);
        }
    }

    public final void V0(TiciHistory ticiHistory) {
        String string = getString(R.string.tici_delete_one_file);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ShowAtBottomAlertDialog.Builder builder = new ShowAtBottomAlertDialog.Builder(this);
        builder.setItems(new CharSequence[]{string}, (DialogInterface.OnClickListener) new q(this, ticiHistory), true, new ColorStateList[]{getColorStateList(R.color.red)}).show();
    }

    public final ActivityTiciHistoryBinding X0() {
        return (ActivityTiciHistoryBinding) this.b.getValue();
    }

    public final TiciHistoryController Y0() {
        return (TiciHistoryController) this.f.getValue();
    }

    public final TiciHistoryItemListener Z0() {
        return (TiciHistoryItemListener) this.e.getValue();
    }

    public final TiciHistoryViewModel a1() {
        return (TiciHistoryViewModel) this.c.getValue();
    }

    public final void b1(Uri uri) {
        CommonExtKt.b("handleChooseFileResult, uri: " + uri, "TiciHistoryActivity");
        if (uri != null) {
            TiciApp.b.c().J0(uri);
        }
    }

    public final void c1(ImportFileState importFileState) {
        CommonExtKt.e("handleImportFileState, state: " + importFileState, "TiciHistoryActivity");
        int i2 = 1;
        String str = null;
        if (importFileState instanceof ImportFileState.Success) {
            ImportFileState.Success success = (ImportFileState.Success) importFileState;
            String filePath = success.getFilePath();
            if (success.getFormattedTextLength() > 60000) {
                new AlertDialog.Builder(this).setTitle(R.string.tici_import_success).setMessage(success.getRawTextLength() > 1700000 ? R.string.tici_file_oversize_cut_cant_edit : R.string.tici_file_oversize_cant_edit).setPositiveButton(R.string.tici_i_known, (DialogInterface.OnClickListener) new r()).show();
            } else if (StringExtKt.i(filePath)) {
                CommonExtKt.j(this, R.string.tici_import_word_success, 0, 2, (Object) null);
            } else {
                CommonExtKt.j(this, R.string.tici_import_success, 0, 2, (Object) null);
            }
            a1().f(success.getTiciEntity());
            TiciDataTrack.f6001a.c("app_prompt_add_suc", MapsKt.mapOf(TuplesKt.to("type", 1), TuplesKt.to("byte_size", Long.valueOf(success.getTiciEntity().getFileSize())), TuplesKt.to("string_size", Integer.valueOf(success.getTiciEntity().getTotalTextLength()))));
        } else if (importFileState instanceof ImportFileState.Fail) {
            ImportFileState.Fail fail = (ImportFileState.Fail) importFileState;
            ImportFailReason failReason = fail.getFailReason();
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            switch (iArr[failReason.ordinal()]) {
                case 1:
                case 2:
                    String string = getString(R.string.tici_pls_use_200kb_utf8_file);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    showErrorMsg(string);
                    break;
                case 3:
                    String string2 = getString(R.string.tici_file_over_size_10m_toast);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    showErrorMsg(string2);
                    break;
                case 4:
                case 5:
                    String string3 = getString(R.string.tici_unknown_file_encoding);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    showErrorMsg(string3);
                    break;
                case 6:
                    String string4 = getString(R.string.tici_import_fail_empty_content);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    showErrorMsg(string4);
                    break;
                default:
                    String string5 = getString(R.string.tici_import_fail_tips);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    showErrorMsg(string5);
                    break;
            }
            int i3 = iArr[fail.getFailReason().ordinal()];
            if (!(i3 == 1 || i3 == 2 || i3 == 3)) {
                i2 = (i3 == 4 || i3 == 5) ? 0 : 2;
            }
            TiciDataTrack ticiDataTrack = TiciDataTrack.f6001a;
            Pair pair = TuplesKt.to("reason", Integer.valueOf(i2));
            Pair pair2 = TuplesKt.to("size_before", Long.valueOf(fail.getFileInfo().b()));
            Pair pair3 = TuplesKt.to("size_after", Long.valueOf(fail.getFileInfo().c()));
            String a2 = fail.getFileInfo().a();
            if (a2 == null) {
                a2 = StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
            ticiDataTrack.c("app_prompt_import_fail", MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("format", a2)));
        }
        if (importFileState instanceof ImportFileState.Importing) {
            TiciImportingFileBinding ticiImportingFileBinding = X0().d;
            ConstraintLayout b2 = ticiImportingFileBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
            b2.setVisibility(0);
            ticiImportingFileBinding.b.setText(StringExtKt.g(((ImportFileState.Importing) importFileState).getFileInfo().getName()));
        } else if (importFileState instanceof ImportFileState.ImportingUri) {
            TiciImportingFileBinding ticiImportingFileBinding2 = X0().d;
            ConstraintLayout b3 = ticiImportingFileBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
            b3.setVisibility(0);
            TextView textView = ticiImportingFileBinding2.b;
            String fileName = ((ImportFileState.ImportingUri) importFileState).getFileName();
            if (fileName != null) {
                str = StringExtKt.g(fileName);
            }
            textView.setText(str);
        } else {
            ConstraintLayout b4 = X0().d.getRoot();
            Intrinsics.checkNotNullExpressionValue(b4, "getRoot(...)");
            b4.setVisibility(8);
        }
    }

    public final void e1(OpenTiciMsgReply openTiciMsgReply) {
        String fileKey = openTiciMsgReply.getFileKey();
        CommonExtKt.e("handleOpenTiciMsgReply, fileKey: " + fileKey, "TiciHistoryActivity");
        finish();
    }

    public final void f1(OpenTiciMsgReplyV2 openTiciMsgReplyV2) {
        String fileKey = openTiciMsgReplyV2.getFileKey();
        CommonExtKt.e("handleOpenTiciMsgReplyV2, fileKey: " + fileKey, "TiciHistoryActivity");
        finish();
    }

    public final void g1(OpenTiciMsgReplyV3 openTiciMsgReplyV3) {
        String fileKey = openTiciMsgReplyV3.getFileKey();
        CommonExtKt.e("handleOpenTiciMsgReplyV3, fileKey: " + fileKey, "TiciHistoryActivity");
        finish();
    }

    public final void h1(TiciFileChangedEvent ticiFileChangedEvent) {
        String simpleString = ticiFileChangedEvent.a().toSimpleString();
        CommonExtKt.e("handleTiciFileChanged, ticiEntity: " + simpleString, "TiciHistoryActivity");
        a1().f(ticiFileChangedEvent.a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) X0().getRoot());
        initViews();
        initViewModels();
        p1();
        this.h = registerForActivityResult(new ActivityResultContracts.GetContent(), new m(this));
    }

    public final void p1() {
        String g2 = TiciApp.b.g();
        if (g2 == null || g2.length() == 0) {
            CommonExtKt.d("loadTiciHistory, userId is null", "TiciHistoryActivity", (Throwable) null, 2, (Object) null);
        } else {
            TiciHistoryViewModel.l(a1(), g2, (Long) null, 2, (Object) null);
        }
    }

    public final void r1() {
        SpUtilKt.s(false);
        BubbleWidget bubbleWidget = X0().f;
        Intrinsics.checkNotNullExpressionValue(bubbleWidget, "tipWidget");
        CommonExtKt.f(bubbleWidget);
        TiciApp.b.r(this);
    }

    public final void s1() {
        CommonExtKt.b("showFileChooser", "TiciHistoryActivity");
        ActivityResultLauncher activityResultLauncher = this.h;
        if (activityResultLauncher != null) {
            activityResultLauncher.a("text/plain");
        }
    }

    public final void showErrorMsg(String str) {
        TiciImportFailedBinding ticiImportFailedBinding = X0().c;
        ConstraintLayout b2 = ticiImportFailedBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(0);
        ticiImportFailedBinding.b.setText(str);
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.i = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryActivity$showErrorMsg$2(this, (Continuation<? super TiciHistoryActivity$showErrorMsg$2>) null), 3, (Object) null);
    }

    public final void t1(View view, TiciHistory ticiHistory) {
        view.setSelected(true);
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.tici_history_item_menu);
        popupMenu.setOnMenuItemClickListener(new z(this, ticiHistory));
        popupMenu.setOnDismissListener(new n(view));
        long id = ticiHistory.getId();
        Long S = TiciApp.b.c().S();
        if (S != null && id == S.longValue()) {
            popupMenu.getMenu().findItem(R.id.menu_delete_tici).setVisible(false);
        } else {
            popupMenu.getFMenu().findFMenuItem(R.id.menu_delete_tici).setTitleColor(getColorStateList(R.color.red));
        }
        if (!TiciHistoryKt.a(ticiHistory)) {
            popupMenu.getMenu().findItem(R.id.menu_edit_tici).setVisible(false);
        }
        popupMenu.show();
        CommonExtKt.b("showItemMenu", "TiciHistoryActivity");
    }

    public final void w1(View view) {
        view.setSelected(true);
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.tici_history_titlebar_menu);
        popupMenu.setOnMenuItemClickListener(new o(this));
        popupMenu.setOnDismissListener(new p(view));
        popupMenu.show();
        CommonExtKt.b("showTitleBarMenu", "TiciHistoryActivity");
    }

    public final void z1(TiciHistory ticiHistory) {
        TiciApp ticiApp = TiciApp.b;
        if (ticiApp.q().getConnectXrDevice() == null) {
            CommonExtKt.j(this, R.string.tici_disconnect_toast, 0, 2, (Object) null);
        } else {
            TiciAppViewModel.N0(ticiApp.c(), ticiHistory.getId(), OpenTiciFrom.TiciFileListPage, true, true, (Integer) null, (Integer) null, 48, (Object) null);
        }
    }
}
