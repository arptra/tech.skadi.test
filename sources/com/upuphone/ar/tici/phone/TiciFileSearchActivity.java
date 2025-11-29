package com.upuphone.ar.tici.phone;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.p4.e;
import com.honey.account.p4.f;
import com.honey.account.p4.g;
import com.honey.account.p4.h;
import com.honey.account.p4.i;
import com.honey.account.p4.j;
import com.honey.account.p4.k;
import com.upuphone.ar.tici.databinding.ActivityTiciSearchFileBinding;
import com.upuphone.ar.tici.phone.data.SearchFileType;
import com.upuphone.ar.tici.phone.data.SystemFileInfo;
import com.upuphone.ar.tici.phone.data.TiciSystemFiles;
import com.upuphone.ar.tici.phone.epoxy.SystemFileController;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.ConstantsKt;
import com.upuphone.ar.tici.phone.utils.EventBus;
import com.upuphone.ar.tici.phone.viewmodel.SearchFileViewModel;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\"R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020%0$8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciFileSearchActivity;", "Lcom/upuphone/ar/tici/phone/BaseTiciActivity;", "<init>", "()V", "", "initViewModels", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViews", "Lcom/upuphone/ar/tici/phone/data/SearchFileType;", "type", "Q0", "(Lcom/upuphone/ar/tici/phone/data/SearchFileType;)V", "P0", "Lcom/upuphone/ar/tici/databinding/ActivityTiciSearchFileBinding;", "b", "Lkotlin/Lazy;", "G0", "()Lcom/upuphone/ar/tici/databinding/ActivityTiciSearchFileBinding;", "layout", "Lcom/upuphone/ar/tici/phone/viewmodel/SearchFileViewModel;", "c", "H0", "()Lcom/upuphone/ar/tici/phone/viewmodel/SearchFileViewModel;", "viewModel", "com/upuphone/ar/tici/phone/TiciFileSearchActivity$itemListener$1", "d", "Lcom/upuphone/ar/tici/phone/TiciFileSearchActivity$itemListener$1;", "itemListener", "Lcom/upuphone/ar/tici/phone/epoxy/SystemFileController;", "e", "F0", "()Lcom/upuphone/ar/tici/phone/epoxy/SystemFileController;", "fileController", "", "Landroid/view/View;", "f", "Ljava/util/Map;", "searchButtons", "g", "Lcom/upuphone/ar/tici/phone/data/SearchFileType;", "searchFileType", "h", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciFileSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciFileSearchActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileSearchActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,157:1\n75#2,13:158\n58#3,23:171\n93#3,3:194\n215#4,2:197\n*S KotlinDebug\n*F\n+ 1 TiciFileSearchActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileSearchActivity\n*L\n41#1:158,13\n88#1:171,23\n88#1:194,3\n127#1:197,2\n*E\n"})
public final class TiciFileSearchActivity extends BaseTiciActivity {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(new TiciFileSearchActivity$layout$2(this));
    public final Lazy c = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SearchFileViewModel.class), new TiciFileSearchActivity$special$$inlined$viewModels$default$2(this), new TiciFileSearchActivity$special$$inlined$viewModels$default$1(this), new TiciFileSearchActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    public final TiciFileSearchActivity$itemListener$1 d = new TiciFileSearchActivity$itemListener$1(this);
    public final Lazy e = LazyKt.lazy(new TiciFileSearchActivity$fileController$2(this));
    public final Map f = new LinkedHashMap();
    public SearchFileType g = SearchFileType.All;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciFileSearchActivity$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.upuphone.ar.tici.phone.data.SearchFileType[] r0 = com.upuphone.ar.tici.phone.data.SearchFileType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.ar.tici.phone.data.SearchFileType r1 = com.upuphone.ar.tici.phone.data.SearchFileType.All     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.ar.tici.phone.data.SearchFileType r1 = com.upuphone.ar.tici.phone.data.SearchFileType.Txt     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.upuphone.ar.tici.phone.data.SearchFileType r1 = com.upuphone.ar.tici.phone.data.SearchFileType.Word     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciFileSearchActivity.WhenMappings.<clinit>():void");
        }
    }

    public static final void I0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void J0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void K0(TiciFileSearchActivity ticiFileSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiFileSearchActivity, "this$0");
        ticiFileSearchActivity.G0().e.setText((CharSequence) null);
    }

    public static final void L0(TiciFileSearchActivity ticiFileSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiFileSearchActivity, "this$0");
        ticiFileSearchActivity.finish();
    }

    public static final void M0(TiciFileSearchActivity ticiFileSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiFileSearchActivity, "this$0");
        ticiFileSearchActivity.Q0(SearchFileType.All);
    }

    public static final void N0(TiciFileSearchActivity ticiFileSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiFileSearchActivity, "this$0");
        ticiFileSearchActivity.Q0(SearchFileType.Txt);
    }

    public static final void O0(TiciFileSearchActivity ticiFileSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiFileSearchActivity, "this$0");
        ticiFileSearchActivity.Q0(SearchFileType.Word);
    }

    private final void initViewModels() {
        H0().g().observe(this, new e(new TiciFileSearchActivity$initViewModels$1(this)));
        TiciApp.b.c().W().observe(this, new f(new TiciFileSearchActivity$initViewModels$2(this)));
    }

    public final SystemFileController F0() {
        return (SystemFileController) this.e.getValue();
    }

    public final ActivityTiciSearchFileBinding G0() {
        return (ActivityTiciSearchFileBinding) this.b.getValue();
    }

    public final SearchFileViewModel H0() {
        return (SearchFileViewModel) this.c.getValue();
    }

    public final void P0() {
        List list;
        String obj = G0().e.getText().toString();
        SearchFileType searchFileType = this.g;
        CommonExtKt.b("searchFile, text: " + obj + ", searchFileType: " + searchFileType, "TiciFileSearchActivity");
        int i = WhenMappings.$EnumSwitchMapping$0[this.g.ordinal()];
        if (i == 1) {
            list = ConstantsKt.a();
        } else if (i == 2) {
            list = ConstantsKt.j();
        } else if (i == 3) {
            list = ConstantsKt.k();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        H0().h(obj, list);
    }

    public final void Q0(SearchFileType searchFileType) {
        this.g = searchFileType;
        for (Map.Entry entry : this.f.entrySet()) {
            ((View) entry.getValue()).setSelected(entry.getKey() == searchFileType);
        }
        P0();
    }

    public final void initViews() {
        EditText editText = G0().e;
        Intrinsics.checkNotNullExpressionValue(editText, "etSearch");
        editText.addTextChangedListener(new TiciFileSearchActivity$initViews$$inlined$doAfterTextChanged$1(this));
        ImageView imageView = G0().h;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivSearchDelete");
        ViewExtKt.b(imageView, new g(this));
        TextView textView = G0().m;
        Intrinsics.checkNotNullExpressionValue(textView, "tvCancel");
        ViewExtKt.b(textView, new h(this));
        TextView textView2 = G0().b;
        Intrinsics.checkNotNull(textView2);
        ViewExtKt.b(textView2, new i(this));
        Map map = this.f;
        SearchFileType searchFileType = SearchFileType.All;
        map.put(searchFileType, textView2);
        TextView textView3 = G0().c;
        Intrinsics.checkNotNull(textView3);
        ViewExtKt.b(textView3, new j(this));
        this.f.put(SearchFileType.Txt, textView3);
        TextView textView4 = G0().d;
        Intrinsics.checkNotNull(textView4);
        ViewExtKt.b(textView4, new k(this));
        this.f.put(SearchFileType.Word, textView4);
        Q0(searchFileType);
        RecyclerView recyclerView = G0().f;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(F0().getAdapter());
    }

    public void onCreate(Bundle bundle) {
        Map<String, List<SystemFileInfo>> map;
        super.onCreate(bundle);
        setContentView((View) G0().getRoot());
        initViews();
        initViewModels();
        TiciSystemFiles ticiSystemFiles = (TiciSystemFiles) EventBus.b.e(TiciSystemFiles.class);
        if (ticiSystemFiles == null || (map = ticiSystemFiles.getFiles()) == null) {
            map = MapsKt.emptyMap();
        }
        H0().j(map);
    }
}
