package com.upuphone.xr.sapp.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.fragment.NavHostFragment;
import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.datatrack.ConnectEventReporter;
import com.upuphone.xr.sapp.entity.PermissionNote;
import com.upuphone.xr.sapp.fragment.BaseFragment;
import com.upuphone.xr.sapp.keeplive.server.SuperService;
import com.upuphone.xr.sapp.keeplive.utils.ProcessUtils;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a=\u0010\u0010\u001a\u00020\u0001*\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011\u001a=\u0010\u0013\u001a\u00020\u0001*\u00020\u00122\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014\u001ag\u0010\u001a\u001a\u00020\u0001*\u00020\u00152\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2(\b\u0002\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00182\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001e\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001f\u001aE\u0010\"\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\f\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b$\u0010%\u001a\u001d\u0010'\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0017¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010)\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b)\u0010*\u001as\u0010-\u001a\u00020\u0001*\u00020\u00122\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2(\b\u0002\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00182\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b-\u0010.\u001aG\u0010/\u001a\u00020\u0001*\u00020\u00122\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b/\u00100\u001a\u0013\u00101\u001a\u0004\u0018\u00010!*\u00020\u0015¢\u0006\u0004\b1\u00102\u001a\u0013\u00103\u001a\u0004\u0018\u00010!*\u00020\u0012¢\u0006\u0004\b3\u00104\u001a\u0011\u00106\u001a\u000205*\u00020\u0012¢\u0006\u0004\b6\u00107\u001a\u001b\u00109\u001a\u00020\u0001*\u00020\u00122\b\b\u0001\u00108\u001a\u00020\n¢\u0006\u0004\b9\u0010:\u001a#\u0010=\u001a\u00020\u0001*\u00020\u00122\b\b\u0001\u00108\u001a\u00020\n2\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>\u001a%\u0010?\u001a\u00020\u0001*\u00020\u00122\b\b\u0001\u00108\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b?\u0010@\u001a\u001b\u0010A\u001a\u00020\r*\u00020\u00122\b\b\u0001\u00108\u001a\u00020\n¢\u0006\u0004\bA\u0010B\u001a\u0011\u0010C\u001a\u00020\u0001*\u00020\u0012¢\u0006\u0004\bC\u0010D\u001a!\u0010G\u001a\u00020\u0001*\u00020\u00122\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n¢\u0006\u0004\bG\u0010H\u001a\u0011\u0010J\u001a\u00020\u0001*\u00020I¢\u0006\u0004\bJ\u0010K\u001a\u0011\u0010L\u001a\u00020\u0001*\u00020I¢\u0006\u0004\bL\u0010K\u001a\u0019\u0010O\u001a\u00020\u0001*\u00020I2\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010P\u001a9\u0010X\u001a\u00020W*\u00020Q2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020Q2\b\b\u0001\u0010T\u001a\u00020\n2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00010U¢\u0006\u0004\bX\u0010Y\u001a\u0017\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b\\\u0010]\u001a\u0011\u0010^\u001a\u00020\u0001*\u00020\u0012¢\u0006\u0004\b^\u0010D\u001a\u0011\u0010_\u001a\u00020\u0001*\u00020\u0015¢\u0006\u0004\b_\u0010`\u001a\u0011\u0010a\u001a\u00020\u0001*\u00020\u0012¢\u0006\u0004\ba\u0010D\u001a\u0011\u0010b\u001a\u00020\u0001*\u00020\u0012¢\u0006\u0004\bb\u0010D\u001a\u0019\u0010e\u001a\u00020\r*\u00020c2\u0006\u0010d\u001a\u00020Q¢\u0006\u0004\be\u0010f\u001a\u001f\u0010i\u001a\u00020\r*\u00020\u00122\f\u0010h\u001a\b\u0012\u0004\u0012\u00020Q0g¢\u0006\u0004\bi\u0010j\u001a\u0011\u0010k\u001a\u00020\u0001*\u00020\u0012¢\u0006\u0004\bk\u0010D\u001a\u0011\u0010l\u001a\u00020\u0001*\u00020\u0015¢\u0006\u0004\bl\u0010`\u001a\u0019\u0010n\u001a\u00020\u0001*\u00020\u00152\u0006\u0010m\u001a\u00020\n¢\u0006\u0004\bn\u0010o\u001a\r\u0010p\u001a\u00020M¢\u0006\u0004\bp\u0010q\u001a\u001b\u0010s\u001a\u00020\u0001*\u00020\u00122\b\u0010r\u001a\u0004\u0018\u00010Q¢\u0006\u0004\bs\u0010t\u001a\u001b\u0010x\u001a\u00020\u0001*\u00020u2\b\u0010w\u001a\u0004\u0018\u00010v¢\u0006\u0004\bx\u0010y\u001a\u0019\u0010|\u001a\u00020\r*\u00020I2\u0006\u0010{\u001a\u00020z¢\u0006\u0004\b|\u0010}\u001a\u0011\u0010~\u001a\u00020\r*\u00020Q¢\u0006\u0004\b~\u0010\u001a=\u0010\u0001\u001a\u00020\u0001*\u00030\u00012\u0006\u0010\f\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0014\u0010\u0001\u001a\u00020\r*\u00020I¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0013\u0010\u0001\u001a\u00020\u0001*\u00020I¢\u0006\u0005\b\u0001\u0010K\u001a\u0013\u0010\u0001\u001a\u00020\u0001*\u00020\u0012¢\u0006\u0005\b\u0001\u0010D\u001a\u0015\u0010\u0001\u001a\u00020\u0001*\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001\"\u0018\u0010\u0001\u001a\u00020Q8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bi\u0010\u0001\"\u0018\u0010\u0001\u001a\u00020Q8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\be\u0010\u0001\"'\u0010\u0001\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0006\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0005\b\u0001\u0010%\"\u0017\u0010\u0001\u001a\u00020z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010X\"\u001b\u0010\u0001\u001a\u00020;8\u0006¢\u0006\u000f\n\u0005\b\\\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0017\u0010\u0001\u001a\u00020\n*\u00020Z8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010]¨\u0006\u0001"}, d2 = {"Landroid/view/View;", "", "M", "(Landroid/view/View;)V", "Landroid/animation/Animator$AnimatorListener;", "callback", "c", "(Landroid/view/View;Landroid/animation/Animator$AnimatorListener;)V", "Landroidx/appcompat/app/AppCompatActivity;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "windowType", "", "touchOutsideDismiss", "backKeyDismiss", "A", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/util/ArrayList;ZZ)V", "Landroidx/fragment/app/Fragment;", "C", "(Landroidx/fragment/app/Fragment;Ljava/util/ArrayList;ZZ)V", "Landroid/app/Activity;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mExtras", "z", "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/util/HashMap;ZZ)V", "Lcom/upuphone/xr/sapp/entity/PermissionNote;", "permissionNote", "T", "(Landroid/app/Activity;Lcom/upuphone/xr/sapp/entity/PermissionNote;)V", "extras", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "y", "(Landroid/app/Activity;ILjava/lang/Object;ZZLcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;)V", "d", "(I)V", "data", "Z", "(ILjava/lang/Object;)V", "n", "(I)Z", "Landroid/os/Bundle;", "bundle", "B", "(Landroidx/fragment/app/Fragment;Ljava/util/ArrayList;Ljava/util/HashMap;ZZLandroid/os/Bundle;)V", "D", "(Landroidx/fragment/app/Fragment;Ljava/util/ArrayList;ZZLandroid/os/Bundle;)V", "f", "(Landroid/app/Activity;)Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "g", "(Landroidx/fragment/app/Fragment;)Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "Landroidx/navigation/NavController;", "i", "(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;", "resId", "t", "(Landroidx/fragment/app/Fragment;I)V", "Landroidx/navigation/NavOptions;", "option", "w", "(Landroidx/fragment/app/Fragment;ILandroidx/navigation/NavOptions;)V", "v", "(Landroidx/fragment/app/Fragment;ILandroid/os/Bundle;)V", "x", "(Landroidx/fragment/app/Fragment;I)Z", "q", "(Landroidx/fragment/app/Fragment;)V", "target", "backTo", "u", "(Landroidx/fragment/app/Fragment;II)V", "Landroid/content/Context;", "V", "(Landroid/content/Context;)V", "W", "Landroid/content/Intent;", "intent", "U", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "startStr", "endStr", "color", "Lkotlin/Function0;", "click", "Landroid/text/SpannableString;", "J", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)Landroid/text/SpannableString;", "", "dpValue", "e", "(F)I", "O", "N", "(Landroid/app/Activity;)V", "Y", "a0", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "permission", "b", "(Lcom/upuphone/xr/sapp/fragment/BaseFragment;Ljava/lang/String;)Z", "", "permissionList", "a", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;)Z", "p", "o", "requestCode", "k", "(Landroid/app/Activity;I)V", "s", "()Landroid/content/Intent;", "packageName", "r", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Landroid/widget/TextView;", "Landroid/graphics/LinearGradient;", "linearGradient", "K", "(Landroid/widget/TextView;Landroid/graphics/LinearGradient;)V", "", "interval", "m", "(Landroid/content/Context;J)Z", "X", "(Ljava/lang/String;)Z", "Lcom/upuphone/xr/sapp/MainApplication;", "P", "(Lcom/upuphone/xr/sapp/MainApplication;ILjava/lang/Object;ZZ)V", "l", "(Landroid/content/Context;)Z", "L", "R", "Landroidx/fragment/app/FragmentActivity;", "S", "(Landroidx/fragment/app/FragmentActivity;)V", "Ljava/lang/String;", "settingPkg", "installedAppDetails", "I", "getREQUEST_START_APP_DETAIL", "()I", "setREQUEST_START_APP_DETAIL", "REQUEST_START_APP_DETAIL", "lastClick", "Landroidx/navigation/NavOptions;", "j", "()Landroidx/navigation/NavOptions;", "optionsRightAndLeft", "h", "dp", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class StaticMethodUtilsKt {

    /* renamed from: a  reason: collision with root package name */
    public static String f7920a = "com.android.settings";
    public static String b = "com.android.settings.applications.InstalledAppDetails";
    public static int c = 2000;
    public static long d;
    public static final NavOptions e = NavOptionsBuilderKt.a(StaticMethodUtilsKt$optionsRightAndLeft$1.INSTANCE);

    public static final void A(AppCompatActivity appCompatActivity, ArrayList arrayList, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "windowType");
        GenericWindowManger.c.a().f(appCompatActivity, appCompatActivity, arrayList, (HashMap) null, z, z2);
    }

    public static final void B(Fragment fragment, ArrayList arrayList, HashMap hashMap, boolean z, boolean z2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "windowType");
        GenericWindowManger a2 = GenericWindowManger.c.a();
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        a2.g(requireContext, fragment, arrayList, hashMap, z, z2, bundle);
    }

    public static final void C(Fragment fragment, ArrayList arrayList, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "windowType");
        try {
            GenericWindowManger a2 = GenericWindowManger.c.a();
            Context requireContext = fragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            a2.f(requireContext, fragment, arrayList, (HashMap) null, z, z2);
        } catch (Exception unused) {
            ULog.f6446a.c("requestGenericWindow", "window error");
        }
    }

    public static final void D(Fragment fragment, ArrayList arrayList, boolean z, boolean z2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "windowType");
        GenericWindowManger a2 = GenericWindowManger.c.a();
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        a2.g(requireContext, fragment, arrayList, (HashMap) null, z, z2, bundle);
    }

    public static /* synthetic */ void E(Activity activity, int i, Object obj, boolean z, boolean z2, SuperGenericWindowView.IActionCallback iActionCallback, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        Object obj3 = obj;
        boolean z3 = (i2 & 4) != 0 ? false : z;
        boolean z4 = (i2 & 8) != 0 ? false : z2;
        if ((i2 & 16) != 0) {
            iActionCallback = f(activity);
        }
        y(activity, i, obj3, z3, z4, iActionCallback);
    }

    public static /* synthetic */ void F(Activity activity, ArrayList arrayList, HashMap hashMap, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            hashMap = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        z(activity, arrayList, hashMap, z, z2);
    }

    public static /* synthetic */ void G(AppCompatActivity appCompatActivity, ArrayList arrayList, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        A(appCompatActivity, arrayList, z, z2);
    }

    public static /* synthetic */ void H(Fragment fragment, ArrayList arrayList, HashMap hashMap, boolean z, boolean z2, Bundle bundle, int i, Object obj) {
        B(fragment, arrayList, (i & 2) != 0 ? null : hashMap, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? null : bundle);
    }

    public static /* synthetic */ void I(Fragment fragment, ArrayList arrayList, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        C(fragment, arrayList, z, z2);
    }

    public static final SpannableString J(String str, String str2, String str3, int i, Function0 function0) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "startStr");
        Intrinsics.checkNotNullParameter(str3, "endStr");
        Intrinsics.checkNotNullParameter(function0, "click");
        SpannableString spannableString = new SpannableString(str);
        String str4 = str;
        spannableString.setSpan(new StaticMethodUtilsKt$setClickString$clickableSpan$1(function0), StringsKt.indexOf$default((CharSequence) str4, str2, 0, false, 6, (Object) null) + 1, StringsKt.lastIndexOf$default((CharSequence) str4, str3, 0, false, 6, (Object) null), 33);
        String str5 = str;
        spannableString.setSpan(new ForegroundColorSpan(i), StringsKt.indexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null), StringsKt.lastIndexOf$default((CharSequence) str5, str3, 0, false, 6, (Object) null) + 1, 33);
        return spannableString;
    }

    public static final void K(TextView textView, LinearGradient linearGradient) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        float textSize = textView.getPaint().getTextSize() * ((float) textView.getText().length());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("setTextColor", "text width is: " + textSize);
        if (textSize == 0.0f) {
            textSize = 138.0f;
        }
        float f = textSize;
        if (linearGradient == null) {
            linearGradient = new LinearGradient(0.0f, 0.0f, f, 0.0f, textView.getContext().getResources().getColor(R.color.color_gradient_star), textView.getContext().getResources().getColor(R.color.color_gradient_end), Shader.TileMode.CLAMP);
        }
        textView.getPaint().setShader(linearGradient);
    }

    public static final void L(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DataStoreUtils.e.a().o("flyme_link_top_show", Boolean.FALSE);
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        boolean putInt = Settings.System.putInt(contentResolver, "flyme_fake_enhanced_service_com.flyme.linkUnion", 1);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MainApplication", "setEnhancedServiceOpen, start: " + putInt);
        context.getPackageManager().setApplicationEnabledSetting("com.upuphone.starrynet", 1, 0);
        TipsManager.f7827a.d(TipsKey.TIPS_PERMISSION);
        delegate.a("MainApplication", "setEnhancedServiceOpen, end");
    }

    public static final void M(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleX", new float[]{0.5f, 1.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(...)");
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "ScaleY", new float[]{0.5f, 1.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(...)");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration(150);
        animatorSet.start();
    }

    public static final void N(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        F(activity, CollectionsKt.arrayListOf(125), (HashMap) null, false, false, 2, (Object) null);
    }

    public static final void O(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        C(fragment, CollectionsKt.arrayListOf(125), false, false);
    }

    public static final void P(MainApplication mainApplication, int i, Object obj, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(mainApplication, "<this>");
        if (mainApplication.q().size() > 0) {
            ULog.f6446a.a("showGlobalDialog", "showGlobalDialog--------------ui");
            z((Activity) mainApplication.q().get(0), CollectionsKt.arrayListOf(Integer.valueOf(i)), obj != null ? MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(i), obj)) : null, z2, z);
            return;
        }
        ULog.f6446a.a("showGlobalDialog", "showGlobalDialog--------------no ui");
    }

    public static /* synthetic */ void Q(MainApplication mainApplication, int i, Object obj, boolean z, boolean z2, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        P(mainApplication, i, obj, z, z2);
    }

    public static final void R(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        S(requireActivity);
    }

    public static final void S(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new StaticMethodUtilsKt$showOpenFlymeLinkWindow$1(fragmentActivity, (Continuation<? super StaticMethodUtilsKt$showOpenFlymeLinkWindow$1>) null), 3, (Object) null);
    }

    public static final void T(Activity activity, PermissionNote permissionNote) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(permissionNote, "permissionNote");
        GenericWindowManger.Companion companion = GenericWindowManger.c;
        GenericWindowManger a2 = companion.a();
        Integer valueOf = Integer.valueOf(Opcodes.IF_ICMPLT);
        a2.j(Opcodes.IF_ICMPLT);
        companion.a().f(activity, activity, CollectionsKt.arrayListOf(valueOf), MapsKt.hashMapOf(TuplesKt.to(valueOf, permissionNote)), true, true);
    }

    public static final void U(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            context.startActivity(intent);
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.SETTINGS");
            intent2.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            context.startActivity(intent2);
        }
    }

    public static final void V(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "notification_resident", Boolean.TRUE, (Context) null, 4, (Object) null)).booleanValue();
        Class<SuperService> cls = SuperService.class;
        boolean a2 = ProcessUtils.f7105a.a(context, cls.getName());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("startSuperServer", "value is: " + booleanValue + " superService is: " + a2);
        if (!MainApplication.k.b() && booleanValue && !a2) {
            delegate.a("startSuperServer", "do start SuperService");
            Intent intent = new Intent();
            intent.setClass(context, cls);
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                ContextCompat.startForegroundService(context, intent);
            } else {
                context.startService(intent);
            }
        }
    }

    public static final void W(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intent intent = new Intent();
        intent.setClass(context, SuperService.class);
        context.stopService(intent);
    }

    public static final boolean X(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z = false;
        if (ActivityManager.isUserAMonkey()) {
            ULog.f6446a.a("superUnbound", "UNBOUND_DEVICE::monkey in");
            return false;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("superUnbound", "unbound device is: " + str + ",and stopDiscovery");
        StarryDevice connectedDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
        ConnectEventReporter connectEventReporter = ConnectEventReporter.b;
        if (connectedDevice == null) {
            z = true;
        }
        connectEventReporter.m(z);
        InterconnectManager.getInstance().getStarryNetDeviceManager().stopDiscovery();
        boolean unBondDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().unBondDevice(str);
        delegate.c("MainApplication", "unBondDevice state " + unBondDevice);
        if (unBondDevice) {
            connectEventReporter.n(true);
        } else {
            connectEventReporter.k(unBondDevice);
        }
        return unBondDevice;
    }

    public static final void Y(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = fragment.getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    public static final void Z(int i, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        GenericWindowManger.c.a().r(i, obj);
    }

    public static final boolean a(Fragment fragment, String[] strArr) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "permissionList");
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        return permissionHelper.n(requireContext, strArr);
    }

    public static final void a0(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = fragment.getString(R.string.view_glasses_not_connected_tip);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    public static final boolean b(BaseFragment baseFragment, String str) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "permission");
        return ContextCompat.checkSelfPermission(baseFragment.requireContext(), str) == 0;
    }

    public static final void c(View view, Animator.AnimatorListener animatorListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(animatorListener, "callback");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleX", new float[]{1.0f, 0.5f});
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(...)");
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "ScaleY", new float[]{1.0f, 0.5f});
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(...)");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.addListener(animatorListener);
        animatorSet.setDuration(150);
        animatorSet.start();
    }

    public static final void d(int i) {
        GenericWindowManger.c.a().j(i);
    }

    public static final int e(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final SuperGenericWindowView.IActionCallback f(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (activity instanceof SuperGenericWindowView.IActionCallback) {
            return (SuperGenericWindowView.IActionCallback) activity;
        }
        return null;
    }

    public static final SuperGenericWindowView.IActionCallback g(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        if (fragment instanceof SuperGenericWindowView.IActionCallback) {
            return (SuperGenericWindowView.IActionCallback) fragment;
        }
        return null;
    }

    public static final int h(float f) {
        return e(f);
    }

    public static final NavController i(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return NavHostFragment.f.c(fragment);
    }

    public static final NavOptions j() {
        return e;
    }

    public static final void k(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        try {
            ULog.f6446a.g("goToAppDetailForResult", MzContactsContract.START_PARAM_KEY);
            Intent intent = new Intent();
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                intent.setComponent(new ComponentName(f7920a, b));
                intent.setData(Uri.parse("package:com.upuphone.star.launcher.intl"));
                activity.startActivityForResult(intent, i);
                return;
            }
            intent.setAction("com.meizu.safe.security.SHOW_APPSEC");
            Bundle bundle = new Bundle();
            bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, "com.upuphone.star.launcher.intl");
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, i);
        } catch (Exception e2) {
            ULog.f6446a.o("goToAppDetailForResult", e2.toString());
            Intent intent2 = new Intent("android.settings.SETTINGS");
            intent2.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            activity.startActivityForResult(intent2, i);
        }
    }

    public static final boolean l(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        int i = Settings.System.getInt(contentResolver, "flyme_fake_enhanced_service_com.flyme.linkUnion", 1);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MainApplication", "isEnhancedServiceOpen: " + i);
        return i == 1;
    }

    public static final boolean m(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d > j) {
            d = currentTimeMillis;
            return false;
        }
        d = currentTimeMillis;
        return true;
    }

    public static final boolean n(int i) {
        return GenericWindowManger.c.a().k(i);
    }

    public static final void o(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        ULog.f6446a.g("jumpToSuperAppDetails", "jumpToSuperAppDetails");
        try {
            Intent intent = new Intent();
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                intent.setComponent(new ComponentName(f7920a, b));
                intent.setData(Uri.parse("package:com.upuphone.star.launcher.intl"));
                activity.startActivityForResult(intent, c);
                return;
            }
            intent.setAction("com.meizu.safe.security.SHOW_APPSEC");
            Bundle bundle = new Bundle();
            bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, "com.upuphone.star.launcher.intl");
            intent.putExtras(bundle);
            activity.startActivity(intent);
        } catch (Exception e2) {
            ULog.f6446a.o("jumpToSuperAppDetails", e2.toString());
            Intent intent2 = new Intent("android.settings.SETTINGS");
            intent2.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            activity.startActivity(intent2);
        }
    }

    public static final void p(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        ULog.f6446a.g("jumpToSuperAppDetails", "jumpToSuperAppDetails");
        try {
            Intent intent = new Intent();
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                intent.setComponent(new ComponentName(f7920a, b));
                intent.setData(Uri.parse("package:com.upuphone.star.launcher.intl"));
                fragment.startActivityForResult(intent, c);
                return;
            }
            intent.setAction("com.meizu.safe.security.SHOW_APPSEC");
            Bundle bundle = new Bundle();
            bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, "com.upuphone.star.launcher.intl");
            intent.putExtras(bundle);
            fragment.startActivity(intent);
        } catch (Exception e2) {
            ULog.f6446a.o("jumpToSuperAppDetails", e2.toString());
            Intent intent2 = new Intent("android.settings.SETTINGS");
            intent2.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            fragment.startActivity(intent2);
        }
    }

    public static final void q(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        try {
            if (!NavHostFragment.f.c(fragment).T()) {
                ULog.f6446a.a("MainApplication", "navPageBack, success=false, requireActivity()#onBackPressed");
                fragment.requireActivity().getOnBackPressedDispatcher().l();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final void r(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        try {
            Context context = fragment.getContext();
            PackageManager packageManager = context != null ? context.getPackageManager() : null;
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            if (packageManager != null) {
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "queryIntentActivities(...)");
                String str2 = queryIntentActivities.iterator().next().activityInfo.name;
                Intrinsics.checkNotNullExpressionValue(str2, "name");
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                Intrinsics.checkNotNull(str);
                intent2.setComponent(new ComponentName(str, str2));
                Context context2 = fragment.getContext();
                if (context2 != null) {
                    context2.startActivity(intent2);
                }
            }
        } catch (Exception e2) {
            ULog.f6446a.o("openApp", e2.toString());
            Intent intent3 = new Intent("android.settings.SETTINGS");
            intent3.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            fragment.startActivity(intent3);
        }
    }

    public static final Intent s() {
        Intent intent = new Intent();
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.upuphone.star.launcher.intl"));
        } else {
            intent.setAction("com.meizu.safe.security.SHOW_APPSEC");
            Bundle bundle = new Bundle();
            bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, "com.upuphone.star.launcher.intl");
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static final void t(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        try {
            if (!fragment.isDetached() && !fragment.isRemoving()) {
                NavHostFragment.f.c(fragment).P(i, (Bundle) null, e);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final void u(Fragment fragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        w(fragment, i, NavOptions.Builder.i(new NavOptions.Builder(), i2, false, false, 4, (Object) null).b(R.anim.next_open_enter).c(R.anim.next_open_exit).e(R.anim.next_close_enter).f(R.anim.next_close_exit).a());
    }

    public static final void v(Fragment fragment, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        try {
            if (!fragment.isDetached() && !fragment.isRemoving()) {
                NavHostFragment.f.c(fragment).P(i, bundle, e);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final void w(Fragment fragment, int i, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(navOptions, "option");
        try {
            if (!fragment.isDetached() && !fragment.isRemoving()) {
                NavHostFragment.f.c(fragment).P(i, (Bundle) null, navOptions);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final boolean x(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        try {
            if (!fragment.isDetached() && !fragment.isRemoving()) {
                boolean W = NavHostFragment.f.c(fragment).W(i, false);
                if (!W) {
                    ULog.f6446a.a("MainApplication", "popBackFragment, success=false");
                }
                return W;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static final void y(Activity activity, int i, Object obj, boolean z, boolean z2, SuperGenericWindowView.IActionCallback iActionCallback) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        GenericWindowManger.q(GenericWindowManger.c.a(), activity, i, obj, z, z2, (Bundle) null, iActionCallback, 32, (Object) null);
    }

    public static final void z(Activity activity, ArrayList arrayList, HashMap hashMap, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "windowType");
        GenericWindowManger.c.a().f(activity, activity, arrayList, hashMap, z, z2);
    }
}
