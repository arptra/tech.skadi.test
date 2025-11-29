package com.upuphone.ar.tici.phone;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.p4.a0;
import com.honey.account.p4.b0;
import com.honey.account.p4.c0;
import com.honey.account.p4.d0;
import com.honey.account.p4.e0;
import com.honey.account.p4.f0;
import com.honey.account.p4.g0;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.ActivityTiciImportFileBinding;
import com.upuphone.ar.tici.phone.data.TiciSystemFiles;
import com.upuphone.ar.tici.phone.epoxy.SystemFileController;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.EventBus;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import com.upuphone.ar.tici.phone.utils.StoragePermission;
import com.upuphone.ar.tici.phone.viewmodel.ImportFileViewModel;
import com.upuphone.ar.tici.phone.widget.BubbleWidget;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001&\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\u0003J/\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciImportFileActivity;", "Lcom/upuphone/ar/tici/phone/BaseTiciActivity;", "<init>", "()V", "", "initViews", "Q0", "initViewModels", "F0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/upuphone/ar/tici/databinding/ActivityTiciImportFileBinding;", "b", "Lkotlin/Lazy;", "H0", "()Lcom/upuphone/ar/tici/databinding/ActivityTiciImportFileBinding;", "layout", "Lcom/upuphone/ar/tici/phone/viewmodel/ImportFileViewModel;", "c", "I0", "()Lcom/upuphone/ar/tici/phone/viewmodel/ImportFileViewModel;", "viewModel", "Lcom/upuphone/ar/tici/phone/utils/StoragePermission;", "d", "Lcom/upuphone/ar/tici/phone/utils/StoragePermission;", "storagePermission", "com/upuphone/ar/tici/phone/TiciImportFileActivity$itemListener$1", "e", "Lcom/upuphone/ar/tici/phone/TiciImportFileActivity$itemListener$1;", "itemListener", "Lcom/upuphone/ar/tici/phone/epoxy/SystemFileController;", "f", "G0", "()Lcom/upuphone/ar/tici/phone/epoxy/SystemFileController;", "fileController", "g", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciImportFileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciImportFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciImportFileActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 ContextExt.kt\ncom/upuphone/xr/sapp/utils/ContextExtKt\n*L\n1#1,197:1\n75#2,13:198\n262#3,2:211\n262#3,2:213\n262#3,2:215\n19#4,9:217\n*S KotlinDebug\n*F\n+ 1 TiciImportFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciImportFileActivity\n*L\n47#1:198,13\n97#1:211,2\n167#1:213,2\n170#1:215,2\n94#1:217,9\n*E\n"})
public final class TiciImportFileActivity extends BaseTiciActivity {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(new TiciImportFileActivity$layout$2(this));
    public final Lazy c = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ImportFileViewModel.class), new TiciImportFileActivity$special$$inlined$viewModels$default$2(this), new TiciImportFileActivity$special$$inlined$viewModels$default$1(this), new TiciImportFileActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    public final StoragePermission d = new StoragePermission(this);
    public final TiciImportFileActivity$itemListener$1 e = new TiciImportFileActivity$itemListener$1(this);
    public final Lazy f = LazyKt.lazy(new TiciImportFileActivity$fileController$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciImportFileActivity$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void F0() {
        if (SpUtilKt.i()) {
            BubbleWidget bubbleWidget = H0().i;
            Intrinsics.checkNotNullExpressionValue(bubbleWidget, "tipWidget");
            CommonExtKt.g(bubbleWidget);
            return;
        }
        BubbleWidget bubbleWidget2 = H0().i;
        Intrinsics.checkNotNullExpressionValue(bubbleWidget2, "tipWidget");
        CommonExtKt.f(bubbleWidget2);
    }

    /* access modifiers changed from: private */
    public final SystemFileController G0() {
        return (SystemFileController) this.f.getValue();
    }

    /* access modifiers changed from: private */
    public static final void J0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void K0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void L0(TiciImportFileActivity ticiImportFileActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiImportFileActivity, "this$0");
        Map map = (Map) ticiImportFileActivity.I0().k().getValue();
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        EventBus.b.g(ticiImportFileActivity, new TiciSystemFiles(map));
        ticiImportFileActivity.startActivity(new Intent(ticiImportFileActivity, TiciFileSearchActivity.class));
    }

    public static final void M0(TiciImportFileActivity ticiImportFileActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiImportFileActivity, "this$0");
        ticiImportFileActivity.finish();
    }

    public static final void N0(TiciImportFileActivity ticiImportFileActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiImportFileActivity, "this$0");
        ticiImportFileActivity.Q0();
    }

    public static final void O0(TiciImportFileActivity ticiImportFileActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiImportFileActivity, "this$0");
        SpUtilKt.s(false);
        BubbleWidget bubbleWidget = ticiImportFileActivity.H0().i;
        Intrinsics.checkNotNullExpressionValue(bubbleWidget, "tipWidget");
        CommonExtKt.f(bubbleWidget);
    }

    public static final void P0(TiciImportFileActivity ticiImportFileActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiImportFileActivity, "this$0");
        ticiImportFileActivity.d.j();
    }

    private final void Q0() {
        SpUtilKt.s(false);
        BubbleWidget bubbleWidget = H0().i;
        Intrinsics.checkNotNullExpressionValue(bubbleWidget, "tipWidget");
        CommonExtKt.f(bubbleWidget);
        TiciApp.b.r(this);
    }

    private final void initViewModels() {
        I0().j().observe(this, new a0(new TiciImportFileActivity$initViewModels$1(this)));
        TiciApp.b.c().W().observe(this, new b0(new TiciImportFileActivity$initViewModels$2(this)));
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciImportFileActivity$initViewModels$3(this, (Continuation<? super TiciImportFileActivity$initViewModels$3>) null), 3, (Object) null);
    }

    private final void initViews() {
        TiciTitleBar ticiTitleBar = H0().j;
        ticiTitleBar.getFolderImg().setImageResource(R.drawable.ic_tici_search);
        ViewExtKt.b(ticiTitleBar.getFolderImg(), new c0(this));
        ticiTitleBar.getFolderImg().setVisibility(8);
        ticiTitleBar.getSettingImg().setImageResource(R.drawable.ic_tici_alert);
        ViewExtKt.b(ticiTitleBar.getBackImg(), new d0(this));
        ViewExtKt.b(ticiTitleBar.getSettingImg(), new e0(this));
        if (Build.VERSION.SDK_INT < 30) {
            H0().l.setText(R.string.request_permission_title);
        } else {
            H0().l.setText(R.string.tici_pls_open_permission);
        }
        H0().i.getCloseBtn().setOnClickListener(new f0(this));
        RecyclerView recyclerView = H0().c;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(G0().getAdapter());
        H0().b.setOnClickListener(new g0(this));
    }

    public final ActivityTiciImportFileBinding H0() {
        return (ActivityTiciImportFileBinding) this.b.getValue();
    }

    public final ImportFileViewModel I0() {
        return (ImportFileViewModel) this.c.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) H0().getRoot());
        initViews();
        initViewModels();
        F0();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        CommonExtKt.e("onRequestPermissionsResult", "TiciImportFileActivity");
        boolean z = true;
        if (i == 1) {
            StoragePermission storagePermission = this.d;
            if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                z = false;
            }
            storagePermission.k(z);
        }
    }

    public void onResume() {
        super.onResume();
        CommonExtKt.e("onResume", "TiciImportFileActivity");
        if (this.d.e()) {
            ConstraintLayout constraintLayout = H0().g;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "layPermissionTips");
            constraintLayout.setVisibility(8);
            I0().m();
            return;
        }
        ConstraintLayout constraintLayout2 = H0().g;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "layPermissionTips");
        constraintLayout2.setVisibility(0);
    }
}
