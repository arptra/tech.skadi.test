package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.view.View;
import androidx.navigation.NavController;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.w8.f;
import com.honey.account.w8.g;
import com.honey.account.w8.h;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.Switch;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a4\u0010\u0011\u001a\u00020\u000f*\u00020\n2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012\u001aI\u0010\u0017\u001a\u00020\u000f*\u00020\u001326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\u0014¢\u0006\u0004\b\u0017\u0010\u0018\u001a>\u0010\u001b\u001a\u00020\u000f*\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010\u001d\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\u001d\u0010\t\u001a\u0011\u0010\u001f\u001a\u00020\u001e*\u00020\u0002¢\u0006\u0004\b\u001f\u0010 \"\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"", "id", "", "h", "(I)Ljava/lang/String;", "", "", "formatArgs", "i", "(I[Ljava/lang/Object;)Ljava/lang/String;", "Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "listener", "d", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "Lcom/meizu/common/widget/Switch;", "Lkotlin/Function2;", "", "isChecked", "j", "(Lcom/meizu/common/widget/Switch;Lkotlin/jvm/functions/Function2;)V", "Landroidx/navigation/NavController;", "navController", "l", "(Landroid/view/View;Landroidx/navigation/NavController;Lkotlin/jvm/functions/Function1;)V", "g", "Ljava/util/Locale;", "n", "(Ljava/lang/String;)Ljava/util/Locale;", "Landroid/content/Context;", "f", "()Landroid/content/Context;", "context", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlobalExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalExt.kt\ncom/upuphone/xr/sapp/utils/GlobalExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public final class GlobalExtKt {
    public static final void d(View view, Function1 function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        view.setOnClickListener(new h(view, function1));
    }

    public static final void e(View view, Function1 function1, View view2) {
        Intrinsics.checkNotNullParameter(view, "$this_click");
        Intrinsics.checkNotNullParameter(function1, "$listener");
        if (!StarryMessageHelper.f7799a.g()) {
            UToast.Companion companion = UToast.f6444a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.d(context, h(R.string.device_disconnect));
            return;
        }
        function1.invoke(view);
    }

    public static final Context f() {
        return MainApplication.k.f();
    }

    /* JADX INFO: finally extract failed */
    public static final String g(int i, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        Locale n = n(ControlUtils.f7858a.y());
        Configuration configuration = f().getResources().getConfiguration();
        Locale locale = configuration.getLocales().get(0);
        Resources resources = f().getResources();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("EXT", "getGlassLanguageStringResource " + n);
        try {
            Configuration configuration2 = new Configuration(configuration);
            configuration2.setLocale(n);
            configuration2.setLocales(new LocaleList(new Locale[]{n}));
            resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
            String string = f().getString(i, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Configuration configuration3 = new Configuration(configuration);
            configuration3.setLocale(locale);
            configuration3.setLocales(new LocaleList(new Locale[]{locale}));
            resources.updateConfiguration(configuration3, resources.getDisplayMetrics());
            if (string.length() != 0) {
                return string;
            }
            String string2 = f().getString(i, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } catch (Throwable th) {
            Configuration configuration4 = new Configuration(configuration);
            configuration4.setLocale(locale);
            configuration4.setLocales(new LocaleList(new Locale[]{locale}));
            resources.updateConfiguration(configuration4, resources.getDisplayMetrics());
            throw th;
        }
    }

    public static final String h(int i) {
        String string = f().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String i(int i, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        String string = f().getString(i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final void j(Switch switchR, Function2 function2) {
        Intrinsics.checkNotNullParameter(switchR, "<this>");
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        switchR.setOnClickListener(new f(switchR, function2));
    }

    public static final void k(Switch switchR, Function2 function2, View view) {
        Intrinsics.checkNotNullParameter(switchR, "$this_onCheckedChange");
        Intrinsics.checkNotNullParameter(function2, "$listener");
        if (!StarryMessageHelper.f7799a.g()) {
            switchR.setChecked(!switchR.isChecked());
            UToast.Companion companion = UToast.f6444a;
            Context context = switchR.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.d(context, h(R.string.device_disconnect));
            return;
        }
        function2.invoke(switchR, Boolean.valueOf(switchR.isChecked()));
    }

    public static final void l(View view, NavController navController, Function1 function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        view.setOnClickListener(new g(view, function1, navController));
    }

    public static final void m(View view, Function1 function1, NavController navController, View view2) {
        Intrinsics.checkNotNullParameter(view, "$this_reminderClick");
        Intrinsics.checkNotNullParameter(function1, "$listener");
        if (!StarryMessageHelper.f7799a.g()) {
            UToast.Companion companion = UToast.f6444a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.d(context, h(R.string.device_disconnect));
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        if (permissionAndStateCheckUtils.g(context2)) {
            function1.invoke(view);
        } else if (navController != null) {
            navController.N(R.id.reminderPermissionSteer);
        }
    }

    public static final Locale n(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{LunarCalendar.DATE_SEPARATOR}, false, 0, 6, (Object) null);
        return split$default.size() > 1 ? new Locale((String) split$default.get(0), (String) split$default.get(1)) : new Locale((String) split$default.get(0));
    }
}
