package com.upuphone.xr.sapp.fragment;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.h8.i2;
import com.honey.account.h8.j2;
import com.honey.account.h8.k2;
import com.honey.account.h8.l2;
import com.honey.account.h8.m2;
import com.honey.account.h8.n2;
import com.honey.account.h8.o2;
import com.honey.account.h8.p2;
import com.honey.account.h8.q2;
import com.honey.account.h8.r2;
import com.honey.account.h8.s2;
import com.meizu.common.widget.DatePicker;
import com.meizu.common.widget.DatePickerDialog;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.FeedbackActivity;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.adapter.FeedBackFile;
import com.upuphone.xr.sapp.adapter.FeedBackFileAdapter;
import com.upuphone.xr.sapp.adapter.FeedbackCommonAdapter;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.entity.FeedbackCommonInfo;
import com.upuphone.xr.sapp.request.FeedBackReq;
import com.upuphone.xr.sapp.request.FileUploadReq;
import com.upuphone.xr.sapp.utils.FileUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.CustomTimePicker;
import com.upuphone.xr.sapp.view.CustomTimePickerDialog;
import com.upuphone.xr.sapp.view.SpaceItemDecoration;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 d2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J)\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u0003J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H@¢\u0006\u0004\b#\u0010$J\u0012\u0010&\u001a\u0004\u0018\u00010%H@¢\u0006\u0004\b&\u0010$J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!H@¢\u0006\u0004\b'\u0010$J\u000f\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\u0003J\u0010\u0010)\u001a\u00020\u000eH@¢\u0006\u0004\b)\u0010$J\u0019\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\"H\u0002¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b0\u0010-J\u0019\u00102\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b2\u0010-J\u0017\u00103\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b6\u00107R&\u0010>\u001a\u0012\u0012\u0004\u0012\u00020:09j\b\u0012\u0004\u0012\u00020:`;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R&\u0010A\u001a\u0012\u0012\u0004\u0012\u00020?09j\b\u0012\u0004\u0012\u00020?`;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010=R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR&\u0010H\u001a\u0012\u0012\u0004\u0012\u00020F09j\b\u0012\u0004\u0012\u00020F`;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010=R&\u0010J\u001a\u0012\u0012\u0004\u0012\u00020%09j\b\u0012\u0004\u0012\u00020%`;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010=R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010PR\u001b\u0010Y\u001a\u00020T8BX\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Z8BX\u0002¢\u0006\f\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010P¨\u0006f"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/FeedBackFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "initData", "j1", "o1", "initView", "D1", "E1", "(Landroid/view/View;)V", "G1", "", "", "h1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "m1", "i1", "I1", "H1", "mobiles", "", "C1", "(Ljava/lang/String;)Z", "k1", "()Ljava/lang/String;", "A1", "email", "B1", "F1", "(Landroid/view/View;)I", "Lcom/upuphone/xr/sapp/databinding/FragmentFeedbackBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentFeedbackBinding;", "binding", "Ljava/util/ArrayList;", "Lcom/upuphone/xr/sapp/entity/FeedbackCommonInfo;", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "commonList", "Lcom/upuphone/xr/sapp/adapter/FeedBackFile;", "l", "fileList", "Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter;", "m", "Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter;", "fileAdapter", "Landroid/widget/RelativeLayout;", "n", "frequencyList", "o", "zipFiles", "Lcom/upuphone/xr/sapp/FeedbackActivity;", "p", "Lcom/upuphone/xr/sapp/FeedbackActivity;", "mainActivity", "q", "Ljava/lang/String;", "commonId", "r", "frequencyId", "Lcom/upuphone/xr/sapp/request/FileUploadReq;", "s", "Lkotlin/Lazy;", "l1", "()Lcom/upuphone/xr/sapp/request/FileUploadReq;", "fileUploadHelper", "Lcom/upuphone/xr/sapp/request/FeedBackReq;", "t", "n1", "()Lcom/upuphone/xr/sapp/request/FeedBackReq;", "mFeedBackReq", "u", "Ljava/io/File;", "mGlassLogPath", "v", "latestDate", "w", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFeedBackFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,815:1\n65#2,16:816\n93#2,3:832\n1#3:835\n1855#4,2:836\n1855#4,2:838\n1855#4,2:840\n1855#4,2:842\n*S KotlinDebug\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment\n*L\n333#1:816,16\n333#1:832,3\n442#1:836,2\n506#1:838,2\n609#1:840,2\n627#1:842,2\n*E\n"})
public final class FeedBackFragment extends BaseFragment {
    public static String A = "54";
    public static String B = "27";
    public static String C = "28";
    public static String D = "29";
    public static String E = "30";
    public static final Companion w = new Companion((DefaultConstructorMarker) null);
    public static String x = "9";
    public static String y = "53";
    public static String z = "53";
    public FragmentFeedbackBinding j;
    public ArrayList k = new ArrayList();
    public ArrayList l = new ArrayList();
    public FeedBackFileAdapter m;
    public ArrayList n = new ArrayList();
    public ArrayList o = new ArrayList();
    public FeedbackActivity p;
    public String q = "0";
    public String r = "0";
    public final Lazy s = LazyKt.lazy(FeedBackFragment$fileUploadHelper$2.INSTANCE);
    public final Lazy t = LazyKt.lazy(FeedBackFragment$mFeedBackReq$2.INSTANCE);
    public File u;
    public String v = "";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u0014\u0010!\u001a\u00020 8\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002XT¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020 8\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u0006R\u0014\u0010(\u001a\u00020 8\u0002XT¢\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u0006R\u0014\u0010*\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u0006R\u0014\u0010+\u001a\u00020 8\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\"R\u0014\u0010,\u001a\u00020 8\u0006XT¢\u0006\u0006\n\u0004\b,\u0010\"¨\u0006-"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/FeedBackFragment$Companion;", "", "<init>", "()V", "", "FEEDBACK_PAGE_ID", "Ljava/lang/String;", "getFEEDBACK_PAGE_ID", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "COMMON_GLASS_ID", "b", "e", "COMMON_RING_ID", "c", "f", "COMMON_APP_ID", "a", "d", "FREQUENCY_LITTLE_ID", "getFREQUENCY_LITTLE_ID", "i", "FREQUENCY_ONES_ID", "getFREQUENCY_ONES_ID", "k", "FREQUENCY_MANY_ID", "getFREQUENCY_MANY_ID", "j", "FREQUENCY_ALWAYS_ID", "getFREQUENCY_ALWAYS_ID", "h", "", "DESCRIBE_MAX", "I", "", "GET_AIR_LOG_TIME_OUT", "J", "GLASS_LOG_SUPPORT_VERSION", "LOG_APP_PATH", "PICK_FILE_CODE", "SHOW_KEY", "TAG", "VIDEO_MAX", "VIDEO_MAX_LENGTH", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return FeedBackFragment.A;
        }

        public final String b() {
            return FeedBackFragment.y;
        }

        public final String c() {
            return FeedBackFragment.z;
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FeedBackFragment.A = str;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FeedBackFragment.y = str;
        }

        public final void f(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FeedBackFragment.z = str;
        }

        public final void g(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FeedBackFragment.x = str;
        }

        public final void h(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FeedBackFragment.E = str;
        }

        public final void i(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FeedBackFragment.B = str;
        }

        public final void j(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FeedBackFragment.D = str;
        }

        public final void k(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            FeedBackFragment.C = str;
        }

        public Companion() {
        }
    }

    private final void initData() {
        ULog.f6446a.a("FeedBackFragment", "initData");
        if (this.k.size() == 0) {
            int i = R.drawable.ic_problem_glass;
            String string = getString(R.string.problem_glass);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            FeedbackCommonInfo feedbackCommonInfo = new FeedbackCommonInfo(false, i, string, y);
            int i2 = R.drawable.ic_problem_app;
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            String string2 = bool.booleanValue() ? getString(R.string.app_name_oversea) : getString(R.string.problem_app);
            Intrinsics.checkNotNull(string2);
            FeedbackCommonInfo feedbackCommonInfo2 = new FeedbackCommonInfo(false, i2, string2, A);
            int i3 = R.drawable.ic_problem_ring;
            String string3 = getString(R.string.problem_ring);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            FeedbackCommonInfo feedbackCommonInfo3 = new FeedbackCommonInfo(false, i3, string3, z);
            this.k.add(feedbackCommonInfo);
            this.k.add(feedbackCommonInfo2);
            this.k.add(feedbackCommonInfo3);
        }
        this.n.clear();
        ArrayList arrayList = this.n;
        FragmentFeedbackBinding fragmentFeedbackBinding = this.j;
        FragmentFeedbackBinding fragmentFeedbackBinding2 = null;
        if (fragmentFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding = null;
        }
        arrayList.add(fragmentFeedbackBinding.k);
        ArrayList arrayList2 = this.n;
        FragmentFeedbackBinding fragmentFeedbackBinding3 = this.j;
        if (fragmentFeedbackBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding3 = null;
        }
        arrayList2.add(fragmentFeedbackBinding3.l);
        ArrayList arrayList3 = this.n;
        FragmentFeedbackBinding fragmentFeedbackBinding4 = this.j;
        if (fragmentFeedbackBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding4 = null;
        }
        arrayList3.add(fragmentFeedbackBinding4.j);
        ArrayList arrayList4 = this.n;
        FragmentFeedbackBinding fragmentFeedbackBinding5 = this.j;
        if (fragmentFeedbackBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding5 = null;
        }
        arrayList4.add(fragmentFeedbackBinding5.b);
        if (!Intrinsics.areEqual((Object) this.r, (Object) "0")) {
            String str = this.r;
            if (Intrinsics.areEqual((Object) str, (Object) B)) {
                FragmentFeedbackBinding fragmentFeedbackBinding6 = this.j;
                if (fragmentFeedbackBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding6 = null;
                }
                fragmentFeedbackBinding6.k.setSelected(true);
                FragmentFeedbackBinding fragmentFeedbackBinding7 = this.j;
                if (fragmentFeedbackBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding7 = null;
                }
                RelativeLayout relativeLayout = fragmentFeedbackBinding7.k;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "neverLayout");
                E1(relativeLayout);
            } else if (Intrinsics.areEqual((Object) str, (Object) C)) {
                FragmentFeedbackBinding fragmentFeedbackBinding8 = this.j;
                if (fragmentFeedbackBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding8 = null;
                }
                fragmentFeedbackBinding8.l.setSelected(true);
                FragmentFeedbackBinding fragmentFeedbackBinding9 = this.j;
                if (fragmentFeedbackBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding9 = null;
                }
                RelativeLayout relativeLayout2 = fragmentFeedbackBinding9.l;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "onesLayout");
                E1(relativeLayout2);
            } else if (Intrinsics.areEqual((Object) str, (Object) D)) {
                FragmentFeedbackBinding fragmentFeedbackBinding10 = this.j;
                if (fragmentFeedbackBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding10 = null;
                }
                fragmentFeedbackBinding10.j.setSelected(true);
                FragmentFeedbackBinding fragmentFeedbackBinding11 = this.j;
                if (fragmentFeedbackBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding11 = null;
                }
                RelativeLayout relativeLayout3 = fragmentFeedbackBinding11.j;
                Intrinsics.checkNotNullExpressionValue(relativeLayout3, "manyLayout");
                E1(relativeLayout3);
            } else if (Intrinsics.areEqual((Object) str, (Object) E)) {
                FragmentFeedbackBinding fragmentFeedbackBinding12 = this.j;
                if (fragmentFeedbackBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding12 = null;
                }
                fragmentFeedbackBinding12.b.setSelected(true);
                FragmentFeedbackBinding fragmentFeedbackBinding13 = this.j;
                if (fragmentFeedbackBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding13 = null;
                }
                RelativeLayout relativeLayout4 = fragmentFeedbackBinding13.b;
                Intrinsics.checkNotNullExpressionValue(relativeLayout4, "awlaysLayout");
                E1(relativeLayout4);
            }
        }
        j1();
        FragmentFeedbackBinding fragmentFeedbackBinding14 = this.j;
        if (fragmentFeedbackBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentFeedbackBinding2 = fragmentFeedbackBinding14;
        }
        fragmentFeedbackBinding2.e.setText(k1());
    }

    private final void initView() {
        ULog.f6446a.a("FeedBackFragment", "initView");
        FragmentFeedbackBinding fragmentFeedbackBinding = this.j;
        FragmentFeedbackBinding fragmentFeedbackBinding2 = null;
        if (fragmentFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding = null;
        }
        fragmentFeedbackBinding.i.setOnClickListener(new i2(this));
        FeedbackCommonAdapter feedbackCommonAdapter = new FeedbackCommonAdapter(this.k);
        feedbackCommonAdapter.k(new FeedBackFragment$initView$2$1(this));
        FragmentFeedbackBinding fragmentFeedbackBinding3 = this.j;
        if (fragmentFeedbackBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding3 = null;
        }
        fragmentFeedbackBinding3.m.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        FragmentFeedbackBinding fragmentFeedbackBinding4 = this.j;
        if (fragmentFeedbackBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding4 = null;
        }
        fragmentFeedbackBinding4.m.addItemDecoration(new SpaceItemDecoration(StaticMethodUtilsKt.h(12.0f), StaticMethodUtilsKt.h(20.0f)));
        FragmentFeedbackBinding fragmentFeedbackBinding5 = this.j;
        if (fragmentFeedbackBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding5 = null;
        }
        fragmentFeedbackBinding5.m.setAdapter(feedbackCommonAdapter);
        FeedBackFileAdapter feedBackFileAdapter = new FeedBackFileAdapter(this.l);
        feedBackFileAdapter.p(new FeedBackFragment$initView$3$1(this));
        feedBackFileAdapter.q(new FeedBackFragment$initView$3$2(this));
        feedBackFileAdapter.r(new FeedBackFragment$initView$3$3(this));
        FragmentFeedbackBinding fragmentFeedbackBinding6 = this.j;
        if (fragmentFeedbackBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding6 = null;
        }
        fragmentFeedbackBinding6.s.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        FragmentFeedbackBinding fragmentFeedbackBinding7 = this.j;
        if (fragmentFeedbackBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding7 = null;
        }
        fragmentFeedbackBinding7.s.setAdapter(feedBackFileAdapter);
        FragmentFeedbackBinding fragmentFeedbackBinding8 = this.j;
        if (fragmentFeedbackBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding8 = null;
        }
        fragmentFeedbackBinding8.s.addItemDecoration(new SpaceItemDecoration(StaticMethodUtilsKt.h(8.0f), StaticMethodUtilsKt.h(20.0f)));
        this.m = feedBackFileAdapter;
        FragmentFeedbackBinding fragmentFeedbackBinding9 = this.j;
        if (fragmentFeedbackBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding9 = null;
        }
        fragmentFeedbackBinding9.l.setOnClickListener(new k2(this));
        FragmentFeedbackBinding fragmentFeedbackBinding10 = this.j;
        if (fragmentFeedbackBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding10 = null;
        }
        fragmentFeedbackBinding10.k.setOnClickListener(new l2(this));
        FragmentFeedbackBinding fragmentFeedbackBinding11 = this.j;
        if (fragmentFeedbackBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding11 = null;
        }
        fragmentFeedbackBinding11.j.setOnClickListener(new m2(this));
        FragmentFeedbackBinding fragmentFeedbackBinding12 = this.j;
        if (fragmentFeedbackBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding12 = null;
        }
        fragmentFeedbackBinding12.b.setOnClickListener(new n2(this));
        FragmentFeedbackBinding fragmentFeedbackBinding13 = this.j;
        if (fragmentFeedbackBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding13 = null;
        }
        EditText editText = fragmentFeedbackBinding13.h;
        Intrinsics.checkNotNullExpressionValue(editText, "describeEdit");
        editText.addTextChangedListener(new FeedBackFragment$initView$$inlined$addTextChangedListener$default$1(this));
        FragmentFeedbackBinding fragmentFeedbackBinding14 = this.j;
        if (fragmentFeedbackBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding14 = null;
        }
        fragmentFeedbackBinding14.e.addTextChangedListener(new FeedBackFragment$initView$9(this));
        FragmentFeedbackBinding fragmentFeedbackBinding15 = this.j;
        if (fragmentFeedbackBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding15 = null;
        }
        fragmentFeedbackBinding15.r.setText(this.v);
        FragmentFeedbackBinding fragmentFeedbackBinding16 = this.j;
        if (fragmentFeedbackBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding16 = null;
        }
        fragmentFeedbackBinding16.r.setOnClickListener(new o2(this));
        FragmentFeedbackBinding fragmentFeedbackBinding17 = this.j;
        if (fragmentFeedbackBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding17 = null;
        }
        fragmentFeedbackBinding17.c.setOnClickListener(new p2(this));
        FragmentFeedbackBinding fragmentFeedbackBinding18 = this.j;
        if (fragmentFeedbackBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentFeedbackBinding2 = fragmentFeedbackBinding18;
        }
        fragmentFeedbackBinding2.o.setOnClickListener(new q2(this));
        G1();
    }

    /* access modifiers changed from: private */
    public final void o1() {
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(requireActivity().getWindow().getDecorView().getWindowToken(), 0);
    }

    public static final void p1(FeedBackFragment feedBackFragment, View view) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        StaticMethodUtilsKt.q(feedBackFragment);
        FeedbackActivity feedbackActivity = feedBackFragment.p;
        if (feedbackActivity != null) {
            feedbackActivity.finish();
        }
    }

    public static final void q1(FeedBackFragment feedBackFragment, View view) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        feedBackFragment.o1();
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(feedBackFragment.getContext(), R.style.TimePickerStyle, new r2(feedBackFragment, instance), instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.setMaxYear(instance.get(1));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    public static final void r1(FeedBackFragment feedBackFragment, Calendar calendar, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FeedBackFragment", "DatePicker select year:" + i + " monthOfYear:" + i2 + " dayOfMonth:" + i3);
        CustomTimePickerDialog customTimePickerDialog = new CustomTimePickerDialog(feedBackFragment.getContext(), R.style.TimePickerStyle, new s2(feedBackFragment, i, i2, i3), calendar.get(11), calendar.get(12), true);
        customTimePickerDialog.d(0, calendar.get(11));
        customTimePickerDialog.e(0, calendar.get(12));
        customTimePickerDialog.f(new j2(calendar, customTimePickerDialog));
        customTimePickerDialog.show();
    }

    public static final void s1(FeedBackFragment feedBackFragment, int i, int i2, int i3, CustomTimePicker customTimePicker, int i4, int i5) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2 - 1, i3, i4, i5);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE).format(instance.getTime());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FeedBackFragment", "DatePicker formattedDate" + format);
        FragmentFeedbackBinding fragmentFeedbackBinding = feedBackFragment.j;
        if (fragmentFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding = null;
        }
        fragmentFeedbackBinding.r.setText(format);
        Intrinsics.checkNotNull(format);
        feedBackFragment.v = format;
    }

    public static final void t1(Calendar calendar, CustomTimePickerDialog customTimePickerDialog, CustomTimePicker customTimePicker, int i, int i2) {
        Intrinsics.checkNotNullParameter(customTimePickerDialog, "$this_apply");
        if (i < calendar.get(11)) {
            customTimePickerDialog.e(0, 60);
            return;
        }
        int i3 = calendar.get(12);
        customTimePickerDialog.e(0, calendar.get(12));
        if (i2 > i3) {
            customTimePickerDialog.g(i, i3);
        }
    }

    public static final void u1(FeedBackFragment feedBackFragment, View view) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        feedBackFragment.o1();
        feedBackFragment.I1();
    }

    public static final void v1(FeedBackFragment feedBackFragment, View view) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        FragmentActivity activity = feedBackFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void w1(FeedBackFragment feedBackFragment, View view) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        Intrinsics.checkNotNull(view);
        feedBackFragment.E1(view);
    }

    public static final void x1(FeedBackFragment feedBackFragment, View view) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        Intrinsics.checkNotNull(view);
        feedBackFragment.E1(view);
    }

    public static final void y1(FeedBackFragment feedBackFragment, View view) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        Intrinsics.checkNotNull(view);
        feedBackFragment.E1(view);
    }

    public static final void z1(FeedBackFragment feedBackFragment, View view) {
        Intrinsics.checkNotNullParameter(feedBackFragment, "this$0");
        Intrinsics.checkNotNull(view);
        feedBackFragment.E1(view);
    }

    public final boolean A1(String str) {
        return C1(str) || B1(str);
    }

    public final boolean B1(String str) {
        return Pattern.compile("^([a-zA-Z\\d_\\-\\.]+)@((\\[\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.)|(([a-zA-Z\\d\\-]+\\.)+))([a-zA-Z]{2,4}|\\d{1,3})(\\]?)$").matcher(str).matches();
    }

    public final boolean C1(String str) {
        return Pattern.compile("^1[3-9]\\d{9}$").matcher(str).matches();
    }

    public final void D1() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 10086);
    }

    public final void E1(View view) {
        o1();
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            ((RelativeLayout) this.n.get(i)).setSelected(view.getId() == ((RelativeLayout) this.n.get(i)).getId());
            if (!((RelativeLayout) this.n.get(i)).isSelected()) {
                ((RelativeLayout) this.n.get(i)).setSelected(false);
            } else if (i == 0) {
                this.r = B;
            } else if (i == 1) {
                this.r = C;
            } else if (i == 2) {
                this.r = D;
            } else if (i == 3) {
                this.r = E;
            }
        }
        G1();
    }

    public final int F1(View view) {
        WindowInsetsCompat H = ViewCompat.H(view);
        if (H != null) {
            int abs = Math.abs(H.f(WindowInsetsCompat.Type.d()).d - H.f(WindowInsetsCompat.Type.d()).b);
            SuperGenericWindowView.p.a(abs);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("FeedBackFragment", " setNaviHeight ::height is: " + abs);
            return abs;
        }
        ULog.f6446a.a("FeedBackFragment", "windowInsets is null");
        return 0;
    }

    public final void G1() {
        FragmentFeedbackBinding fragmentFeedbackBinding = this.j;
        FragmentFeedbackBinding fragmentFeedbackBinding2 = null;
        if (fragmentFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding = null;
        }
        Editable text = fragmentFeedbackBinding.h.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() > 0) {
            FragmentFeedbackBinding fragmentFeedbackBinding3 = this.j;
            if (fragmentFeedbackBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentFeedbackBinding3 = null;
            }
            fragmentFeedbackBinding3.c.setAlpha(1.0f);
            FragmentFeedbackBinding fragmentFeedbackBinding4 = this.j;
            if (fragmentFeedbackBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentFeedbackBinding2 = fragmentFeedbackBinding4;
            }
            fragmentFeedbackBinding2.c.setClickable(true);
            return;
        }
        FragmentFeedbackBinding fragmentFeedbackBinding5 = this.j;
        if (fragmentFeedbackBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding5 = null;
        }
        fragmentFeedbackBinding5.c.setAlpha(0.25f);
        FragmentFeedbackBinding fragmentFeedbackBinding6 = this.j;
        if (fragmentFeedbackBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentFeedbackBinding2 = fragmentFeedbackBinding6;
        }
        fragmentFeedbackBinding2.c.setClickable(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c0, code lost:
        r2 = new java.util.HashMap();
        r10 = r9.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c7, code lost:
        if (r10 != null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c9, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cd, code lost:
        r10 = r10.h.getText().toString();
        r2.put("feedBackPageId", x);
        r2.put("questionCategoryId", r9.q);
        r2.put("attributeCategoryId", r9.r);
        r2.put("feedbackContent", r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f7, code lost:
        if (r9.v.length() <= 0) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f9, code lost:
        r2.put("happenTime", r9.v);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0100, code lost:
        r10 = r9.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0102, code lost:
        if (r10 != null) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0104, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0108, code lost:
        r10 = r10.e.getText();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "getText(...)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0117, code lost:
        if (r10.length() <= 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0119, code lost:
        r10 = r9.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011b, code lost:
        if (r10 != null) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011d, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0121, code lost:
        r2.put("contact", r10.e.getText().toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0130, code lost:
        r0.L$0 = r9;
        r0.L$1 = r2;
        r0.L$2 = r2;
        r0.L$3 = "logFileUrlList";
        r0.label = 2;
        r4 = r9.i1(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0141, code lost:
        if (r4 != r1) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0143, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0144, code lost:
        r6 = r9;
        r9 = "logFileUrlList";
        r10 = r4;
        r4 = r2;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0148, code lost:
        r2.put(r9, r10);
        r0.L$0 = r6;
        r0.L$1 = r4;
        r0.L$2 = r4;
        r9 = "fileResourceUrlList";
        r0.L$3 = r9;
        r0.label = 3;
        r10 = r6.h1(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x015c, code lost:
        if (r10 != r1) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015f, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0160, code lost:
        r2.put(r9, r10);
        r9 = com.xjmz.myvu.ext.ConnectExtKt.b();
        r10 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0171, code lost:
        if (r10.hasNext() == false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0173, code lost:
        r2 = (com.xjmz.myvu.flutter.pigeon.AndroidConnectApi.DeviceInfo) r10.next();
        r8 = r2.d();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "getModelId(...)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0184, code lost:
        if (com.xjmz.myvu.ext.ConnectExtKt.i(r8) == false) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0186, code lost:
        r10 = r2.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x018b, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x018c, code lost:
        if (r10 == null) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0192, code lost:
        if (com.xjmz.myvu.ext.ConnectExtKt.k(r10) != true) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0194, code lost:
        r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel.f8112a.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x019b, code lost:
        r10 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a9, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6.q, (java.lang.Object) z) == false) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ab, code lost:
        r2 = new kotlin.jvm.internal.Ref.ObjectRef();
        r2.element = "";
        r9 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01bc, code lost:
        if (r9.hasNext() == false) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01be, code lost:
        r3 = (com.xjmz.myvu.flutter.pigeon.AndroidConnectApi.DeviceInfo) r9.next();
        r8 = r3.d();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "getModelId(...)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01cf, code lost:
        if (com.xjmz.myvu.ext.ConnectExtKt.j(r8) == false) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01d1, code lost:
        r9 = r3.c();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "getDeviceName(...)");
        r2.element = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01dc, code lost:
        r9 = kotlinx.coroutines.Dispatchers.c();
        r3 = new com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$2(r4, r2, (kotlin.coroutines.Continuation<? super com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$2>) null);
        r0.L$0 = r6;
        r0.L$1 = r4;
        r0.L$2 = r10;
        r0.L$3 = null;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01f4, code lost:
        if (kotlinx.coroutines.BuildersKt.g(r9, r3, r0) != r1) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01f6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01f7, code lost:
        r9 = r10;
        r2 = r4;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01fa, code lost:
        r10 = r9;
        r4 = r2;
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01fd, code lost:
        r9 = r6.n1();
        r0.L$0 = r6;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.label = 5;
        r10 = r9.b(r4, r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0210, code lost:
        if (r10 != r1) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0212, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0213, code lost:
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0214, code lost:
        r10 = ((java.lang.Boolean) r10).booleanValue();
        r2 = kotlinx.coroutines.Dispatchers.c();
        r3 = new com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$3(r9, r10, (kotlin.coroutines.Continuation<? super com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$3>) null);
        r0.L$0 = r9;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x022c, code lost:
        if (kotlinx.coroutines.BuildersKt.g(r2, r3, r0) != r1) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x022f, code lost:
        r10 = r9.u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0231, code lost:
        if (r10 == null) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0233, code lost:
        com.upuphone.xr.sapp.utils.FileUtils.f7881a.b(r10.getAbsolutePath());
        r9.u = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0240, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object H1(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$1 r0 = (com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$1 r0 = new com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "binding"
            r5 = 0
            switch(r2) {
                case 0: goto L_0x0084;
                case 1: goto L_0x007c;
                case 2: goto L_0x0067;
                case 3: goto L_0x0052;
                case 4: goto L_0x0041;
                case 5: goto L_0x0038;
                case 6: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002f:
            java.lang.Object r9 = r0.L$0
            com.upuphone.xr.sapp.fragment.FeedBackFragment r9 = (com.upuphone.xr.sapp.fragment.FeedBackFragment) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x022f
        L_0x0038:
            java.lang.Object r9 = r0.L$0
            com.upuphone.xr.sapp.fragment.FeedBackFragment r9 = (com.upuphone.xr.sapp.fragment.FeedBackFragment) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0214
        L_0x0041:
            java.lang.Object r9 = r0.L$2
            com.upuphone.xr.sapp.entity.DeviceInfo r9 = (com.upuphone.xr.sapp.entity.DeviceInfo) r9
            java.lang.Object r2 = r0.L$1
            java.util.HashMap r2 = (java.util.HashMap) r2
            java.lang.Object r3 = r0.L$0
            com.upuphone.xr.sapp.fragment.FeedBackFragment r3 = (com.upuphone.xr.sapp.fragment.FeedBackFragment) r3
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x01fa
        L_0x0052:
            java.lang.Object r9 = r0.L$3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$2
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r4 = r0.L$1
            java.util.HashMap r4 = (java.util.HashMap) r4
            java.lang.Object r6 = r0.L$0
            com.upuphone.xr.sapp.fragment.FeedBackFragment r6 = (com.upuphone.xr.sapp.fragment.FeedBackFragment) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0160
        L_0x0067:
            java.lang.Object r9 = r0.L$3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$2
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r4 = r0.L$1
            java.util.HashMap r4 = (java.util.HashMap) r4
            java.lang.Object r6 = r0.L$0
            com.upuphone.xr.sapp.fragment.FeedBackFragment r6 = (com.upuphone.xr.sapp.fragment.FeedBackFragment) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0148
        L_0x007c:
            java.lang.Object r9 = r0.L$0
            com.upuphone.xr.sapp.fragment.FeedBackFragment r9 = (com.upuphone.xr.sapp.fragment.FeedBackFragment) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00c0
        L_0x0084:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = r9.q
            java.lang.String r2 = y
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r2)
            if (r10 == 0) goto L_0x00c0
            com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding r10 = r9.j
            if (r10 != 0) goto L_0x0099
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r10 = r5
        L_0x0099:
            android.widget.CheckBox r10 = r10.n
            boolean r10 = r10.isChecked()
            if (r10 == 0) goto L_0x00c0
            com.upuphone.xr.sapp.utils.DynamicAdapterUtils r10 = com.upuphone.xr.sapp.utils.DynamicAdapterUtils.f7879a
            java.lang.String r10 = r10.a()
            boolean r10 = com.upuphone.xr.sapp.utils.ModelIdExtKt.a(r10)
            if (r10 == 0) goto L_0x00c0
            com.upuphone.xr.sapp.glass.GlassHelper r10 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r10 = r10.y()
            if (r10 == 0) goto L_0x00c0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r9.m1(r0)
            if (r10 != r1) goto L_0x00c0
            return r1
        L_0x00c0:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding r10 = r9.j
            if (r10 != 0) goto L_0x00cd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r10 = r5
        L_0x00cd:
            android.widget.EditText r10 = r10.h
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r6 = "feedBackPageId"
            java.lang.String r7 = x
            r2.put(r6, r7)
            java.lang.String r6 = "questionCategoryId"
            java.lang.String r7 = r9.q
            r2.put(r6, r7)
            java.lang.String r6 = "attributeCategoryId"
            java.lang.String r7 = r9.r
            r2.put(r6, r7)
            java.lang.String r6 = "feedbackContent"
            r2.put(r6, r10)
            java.lang.String r10 = r9.v
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x0100
            java.lang.String r10 = "happenTime"
            java.lang.String r6 = r9.v
            r2.put(r10, r6)
        L_0x0100:
            com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding r10 = r9.j
            if (r10 != 0) goto L_0x0108
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r10 = r5
        L_0x0108:
            android.widget.EditText r10 = r10.e
            android.text.Editable r10 = r10.getText()
            java.lang.String r6 = "getText(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r6)
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x0130
            com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding r10 = r9.j
            if (r10 != 0) goto L_0x0121
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r10 = r5
        L_0x0121:
            android.widget.EditText r10 = r10.e
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r4 = "contact"
            r2.put(r4, r10)
        L_0x0130:
            r0.L$0 = r9
            r0.L$1 = r2
            r0.L$2 = r2
            java.lang.String r10 = "logFileUrlList"
            r0.L$3 = r10
            r4 = 2
            r0.label = r4
            java.lang.Object r4 = r9.i1(r0)
            if (r4 != r1) goto L_0x0144
            return r1
        L_0x0144:
            r6 = r9
            r9 = r10
            r10 = r4
            r4 = r2
        L_0x0148:
            r2.put(r9, r10)
            r0.L$0 = r6
            r0.L$1 = r4
            r0.L$2 = r4
            java.lang.String r9 = "fileResourceUrlList"
            r0.L$3 = r9
            r10 = 3
            r0.label = r10
            java.lang.Object r10 = r6.h1(r0)
            if (r10 != r1) goto L_0x015f
            return r1
        L_0x015f:
            r2 = r4
        L_0x0160:
            r2.put(r9, r10)
            java.util.List r9 = com.xjmz.myvu.ext.ConnectExtKt.b()
            java.util.Iterator r10 = r9.iterator()
        L_0x016b:
            boolean r2 = r10.hasNext()
            java.lang.String r7 = "getModelId(...)"
            if (r2 == 0) goto L_0x018b
            java.lang.Object r2 = r10.next()
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r2 = (com.xjmz.myvu.flutter.pigeon.AndroidConnectApi.DeviceInfo) r2
            java.lang.String r8 = r2.d()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            boolean r8 = com.xjmz.myvu.ext.ConnectExtKt.i(r8)
            if (r8 == 0) goto L_0x016b
            java.lang.String r10 = r2.d()
            goto L_0x018c
        L_0x018b:
            r10 = r5
        L_0x018c:
            if (r10 == 0) goto L_0x019b
            boolean r10 = com.xjmz.myvu.ext.ConnectExtKt.k(r10)
            if (r10 != r3) goto L_0x019b
            com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel r10 = com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel.f8112a
            com.upuphone.xr.sapp.entity.DeviceInfo r10 = r10.d()
            goto L_0x01a1
        L_0x019b:
            com.upuphone.xr.sapp.utils.ControlUtils r10 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            com.upuphone.xr.sapp.entity.DeviceInfo r10 = r10.g()
        L_0x01a1:
            java.lang.String r2 = r6.q
            java.lang.String r3 = z
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x01fd
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.lang.String r3 = ""
            r2.element = r3
            java.util.Iterator r9 = r9.iterator()
        L_0x01b8:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x01dc
            java.lang.Object r3 = r9.next()
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r3 = (com.xjmz.myvu.flutter.pigeon.AndroidConnectApi.DeviceInfo) r3
            java.lang.String r8 = r3.d()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            boolean r8 = com.xjmz.myvu.ext.ConnectExtKt.j(r8)
            if (r8 == 0) goto L_0x01b8
            java.lang.String r9 = r3.c()
            java.lang.String r3 = "getDeviceName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            r2.element = r9
        L_0x01dc:
            kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$2 r3 = new com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$2
            r3.<init>(r4, r2, r5)
            r0.L$0 = r6
            r0.L$1 = r4
            r0.L$2 = r10
            r0.L$3 = r5
            r2 = 4
            r0.label = r2
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r9, r3, r0)
            if (r9 != r1) goto L_0x01f7
            return r1
        L_0x01f7:
            r9 = r10
            r2 = r4
            r3 = r6
        L_0x01fa:
            r10 = r9
            r4 = r2
            r6 = r3
        L_0x01fd:
            com.upuphone.xr.sapp.request.FeedBackReq r9 = r6.n1()
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r5
            r0.L$3 = r5
            r2 = 5
            r0.label = r2
            java.lang.Object r10 = r9.b(r4, r10, r0)
            if (r10 != r1) goto L_0x0213
            return r1
        L_0x0213:
            r9 = r6
        L_0x0214:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$3 r3 = new com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$3
            r3.<init>(r9, r10, r5)
            r0.L$0 = r9
            r10 = 6
            r0.label = r10
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.g(r2, r3, r0)
            if (r10 != r1) goto L_0x022f
            return r1
        L_0x022f:
            java.io.File r10 = r9.u
            if (r10 == 0) goto L_0x023e
            com.upuphone.xr.sapp.utils.FileUtils r0 = com.upuphone.xr.sapp.utils.FileUtils.f7881a
            java.lang.String r10 = r10.getAbsolutePath()
            r0.b(r10)
            r9.u = r5
        L_0x023e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.FeedBackFragment.H1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void I1() {
        ULog.f6446a.a("FeedBackFragment", "verifySubmitParam");
        long j2 = 0;
        for (FeedBackFile a2 : this.l) {
            FileUtils fileUtils = FileUtils.f7881a;
            Uri a3 = a2.a();
            Intrinsics.checkNotNull(a3);
            j2 += fileUtils.i(a3);
        }
        ULog.f6446a.a("FeedBackFragment", "verifySubmitParam videoLength:" + j2);
        if (j2 > 31457280) {
            Context context = getContext();
            if (context != null) {
                UToast.Companion companion = UToast.f6444a;
                String string = getString(R.string.vo_not_30m);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(context, string);
                return;
            }
            return;
        }
        FragmentFeedbackBinding fragmentFeedbackBinding = this.j;
        FragmentFeedbackBinding fragmentFeedbackBinding2 = null;
        if (fragmentFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding = null;
        }
        if (fragmentFeedbackBinding.e.getText().toString().length() > 0) {
            FragmentFeedbackBinding fragmentFeedbackBinding3 = this.j;
            if (fragmentFeedbackBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentFeedbackBinding3 = null;
            }
            if (!A1(fragmentFeedbackBinding3.e.getText().toString())) {
                FragmentFeedbackBinding fragmentFeedbackBinding4 = this.j;
                if (fragmentFeedbackBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentFeedbackBinding4 = null;
                }
                fragmentFeedbackBinding4.e.setBackgroundResource(R.drawable.bg_frequency_error);
                FragmentFeedbackBinding fragmentFeedbackBinding5 = this.j;
                if (fragmentFeedbackBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentFeedbackBinding2 = fragmentFeedbackBinding5;
                }
                fragmentFeedbackBinding2.f.setVisibility(0);
                return;
            }
        }
        StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(Integer.valueOf(Opcodes.IF_ACMPEQ)), false, false);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), Dispatchers.b(), (CoroutineStart) null, new FeedBackFragment$verifySubmitParam$3(this, (Continuation<? super FeedBackFragment$verifySubmitParam$3>) null), 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h1(kotlin.coroutines.Continuation r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.upuphone.xr.sapp.fragment.FeedBackFragment$dealImageFiles$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.upuphone.xr.sapp.fragment.FeedBackFragment$dealImageFiles$1 r0 = (com.upuphone.xr.sapp.fragment.FeedBackFragment$dealImageFiles$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.fragment.FeedBackFragment$dealImageFiles$1 r0 = new com.upuphone.xr.sapp.fragment.FeedBackFragment$dealImageFiles$1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r14 = r0.L$2
            java.util.Iterator r14 = (java.util.Iterator) r14
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.L$0
            com.upuphone.xr.sapp.fragment.FeedBackFragment r4 = (com.upuphone.xr.sapp.fragment.FeedBackFragment) r4
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00bb
        L_0x0036:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r2 = r14.l
            java.util.Iterator r2 = r2.iterator()
            r13 = r15
            r15 = r14
            r14 = r2
            r2 = r13
        L_0x0050:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x00c4
            java.lang.Object r4 = r14.next()
            com.upuphone.xr.sapp.adapter.FeedBackFile r4 = (com.upuphone.xr.sapp.adapter.FeedBackFile) r4
            com.upuphone.xr.sapp.utils.FileUtils r5 = com.upuphone.xr.sapp.utils.FileUtils.f7881a
            android.net.Uri r6 = r4.a()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.lang.String r5 = r5.h(r6)
            if (r5 != 0) goto L_0x006d
            java.lang.String r5 = ""
        L_0x006d:
            r6 = r5
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            android.net.Uri r7 = r4.a()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "dealImageFiles uri:"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = " fileName:"
            r8.append(r7)
            r8.append(r6)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = "FeedBackFragment"
            r5.a(r8, r7)
            com.upuphone.xr.sapp.request.FileUploadReq r5 = r15.l1()
            android.net.Uri r7 = r4.a()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r0.L$0 = r15
            r0.L$1 = r2
            r0.L$2 = r14
            r0.label = r3
            r8 = 94608000(0x5a39a80, double:4.67425626E-316)
            r10 = 0
            r11 = 8
            r12 = 0
            r4 = r5
            r5 = r7
            r7 = r8
            r9 = r10
            r10 = r0
            java.lang.Object r4 = com.upuphone.xr.sapp.request.FileUploadReq.o(r4, r5, r6, r7, r9, r10, r11, r12)
            if (r4 != r1) goto L_0x00b8
            return r1
        L_0x00b8:
            r13 = r4
            r4 = r15
            r15 = r13
        L_0x00bb:
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x00c2
            r2.add(r15)
        L_0x00c2:
            r15 = r4
            goto L_0x0050
        L_0x00c4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.FeedBackFragment.h1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i1(kotlin.coroutines.Continuation r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.upuphone.xr.sapp.fragment.FeedBackFragment$dealLogFiles$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.upuphone.xr.sapp.fragment.FeedBackFragment$dealLogFiles$1 r0 = (com.upuphone.xr.sapp.fragment.FeedBackFragment$dealLogFiles$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.fragment.FeedBackFragment$dealLogFiles$1 r0 = new com.upuphone.xr.sapp.fragment.FeedBackFragment$dealLogFiles$1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r14 = r0.L$2
            java.util.Iterator r14 = (java.util.Iterator) r14
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.L$0
            com.upuphone.xr.sapp.fragment.FeedBackFragment r4 = (com.upuphone.xr.sapp.fragment.FeedBackFragment) r4
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0111
        L_0x0036:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r15)
            com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding r15 = r14.j
            if (r15 != 0) goto L_0x004b
            java.lang.String r15 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r15)
            r15 = 0
        L_0x004b:
            android.widget.CheckBox r15 = r15.n
            boolean r15 = r15.isChecked()
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "dealLogFiles Checked: "
            r4.append(r5)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "FeedBackFragment"
            r2.a(r5, r4)
            if (r15 == 0) goto L_0x00a9
            com.upuphone.xr.sapp.utils.FileUtils r15 = com.upuphone.xr.sapp.utils.FileUtils.f7881a     // Catch:{ Exception -> 0x0092 }
            java.lang.String r2 = "/data/data/com.upuphone.star.launcher.intl/files/ulog/"
            java.lang.String r4 = "zip"
            java.util.ArrayList r2 = r15.e(r2, r4)     // Catch:{ Exception -> 0x0092 }
            boolean r4 = r2.isEmpty()     // Catch:{ Exception -> 0x0092 }
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x00a9
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0092 }
            java.lang.String r6 = "/data/data/com.upuphone.star.launcher.intl/files/ulog/log.zip"
            r4.<init>(r6)     // Catch:{ Exception -> 0x0092 }
            java.util.ArrayList r6 = r14.o     // Catch:{ Exception -> 0x0092 }
            r6.clear()     // Catch:{ Exception -> 0x0092 }
            r15.j(r2, r4)     // Catch:{ Exception -> 0x0092 }
            java.util.ArrayList r15 = r14.o     // Catch:{ Exception -> 0x0092 }
            r15.add(r4)     // Catch:{ Exception -> 0x0092 }
            goto L_0x00a9
        L_0x0092:
            r15 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = " dealLogFiles error:"
            r4.append(r6)
            r4.append(r15)
            java.lang.String r15 = r4.toString()
            r2.c(r5, r15)
        L_0x00a9:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.util.ArrayList r2 = r14.o
            int r2 = r2.size()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "dealLogFiles zip succeed  zipFiles.size:"
            r4.append(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r15.a(r5, r2)
            java.util.ArrayList r15 = r14.o
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r3
            if (r15 == 0) goto L_0x011b
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r2 = r14.o
            java.util.Iterator r2 = r2.iterator()
            r13 = r15
            r15 = r14
            r14 = r2
            r2 = r13
        L_0x00dd:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x011a
            java.lang.Object r4 = r14.next()
            r5 = r4
            java.io.File r5 = (java.io.File) r5
            com.upuphone.xr.sapp.request.FileUploadReq r4 = r15.l1()
            java.lang.String r6 = r5.getName()
            java.lang.String r7 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r0.L$0 = r15
            r0.L$1 = r2
            r0.L$2 = r14
            r0.label = r3
            r7 = 94608000(0x5a39a80, double:4.67425626E-316)
            r9 = 0
            r11 = 8
            r12 = 0
            r10 = r0
            java.lang.Object r4 = com.upuphone.xr.sapp.request.FileUploadReq.g(r4, r5, r6, r7, r9, r10, r11, r12)
            if (r4 != r1) goto L_0x010e
            return r1
        L_0x010e:
            r13 = r4
            r4 = r15
            r15 = r13
        L_0x0111:
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x0118
            r2.add(r15)
        L_0x0118:
            r15 = r4
            goto L_0x00dd
        L_0x011a:
            return r2
        L_0x011b:
            java.util.List r14 = kotlin.collections.CollectionsKt.emptyList()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.FeedBackFragment.i1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void j1() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), Dispatchers.b(), (CoroutineStart) null, new FeedBackFragment$getConfig$1(this, (Continuation<? super FeedBackFragment$getConfig$1>) null), 2, (Object) null);
    }

    public final String k1() {
        try {
            AccountInfo a2 = MzAccountManager.c.a();
            Intrinsics.checkNotNull(a2);
            return (a2.getPhone().length() <= 0 || !C1(a2.getPhone())) ? (a2.getEmail().length() <= 0 || !B1(a2.getEmail())) ? "" : a2.getEmail() : a2.getPhone();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.a("FeedBackFragment", "getContact::e is: " + message);
            return "";
        }
    }

    public final FileUploadReq l1() {
        return (FileUploadReq) this.s.getValue();
    }

    public final Object m1(Continuation continuation) {
        ULog.f6446a.a("FeedBackFragment", "getGlassLog=>star");
        return TimeoutKt.d(5000, new FeedBackFragment$getGlassLog$2((Continuation<? super FeedBackFragment$getGlassLog$2>) null), continuation);
    }

    public final FeedBackReq n1() {
        return (FeedBackReq) this.t.getValue();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ContentResolver contentResolver;
        String type;
        Uri data;
        ClipData clipData;
        super.onActivityResult(i, i2, intent);
        if (i == 10086 && i2 == -1) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            if (intent != null && (clipData = intent.getClipData()) != null) {
                int itemCount = clipData.getItemCount();
                for (int i3 = 0; i3 < itemCount; i3++) {
                    Uri uri = clipData.getItemAt(i3).getUri();
                    Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
                    arrayList.add(uri);
                }
            } else if (!(intent == null || (data = intent.getData()) == null)) {
                arrayList.add(data);
            }
            for (Uri uri2 : arrayList) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("FeedBackFragment", "onActivityResult uri:" + uri2.getPath());
                Context context = getContext();
                if (!(context == null || (contentResolver = context.getContentResolver()) == null || (type = contentResolver.getType(uri2)) == null)) {
                    delegate.a("FeedBackFragment", "onActivityResult mimeType:" + type);
                    FragmentFeedbackBinding fragmentFeedbackBinding = null;
                    this.l.add(new FeedBackFile(uri2, (String) null, 2, (DefaultConstructorMarker) null));
                    String str = this.l.size() + "/9";
                    FragmentFeedbackBinding fragmentFeedbackBinding2 = this.j;
                    if (fragmentFeedbackBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentFeedbackBinding = fragmentFeedbackBinding2;
                    }
                    fragmentFeedbackBinding.t.setText(str);
                    FeedBackFileAdapter feedBackFileAdapter = this.m;
                    if (feedBackFileAdapter != null) {
                        feedBackFileAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentFeedbackBinding c = FragmentFeedbackBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        LinearLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onResume() {
        super.onResume();
        FragmentFeedbackBinding fragmentFeedbackBinding = this.j;
        if (fragmentFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFeedbackBinding = null;
        }
        LinearLayout b = fragmentFeedbackBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        F1(b);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initData();
        initView();
    }
}
