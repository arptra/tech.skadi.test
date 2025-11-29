package com.upuphone.xr.sapp.contract;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ModulePrivacyManagerKt$showModulePrivacyDialog$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ int $modlueId;
    final /* synthetic */ FragmentActivity $rootActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModulePrivacyManagerKt$showModulePrivacyDialog$1(int i, Function0<Unit> function0, FragmentActivity fragmentActivity) {
        super(1);
        this.$modlueId = i;
        this.$callback = function0;
        this.$rootActivity = fragmentActivity;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        int i = this.$modlueId;
        if (i == 1) {
            MainApplication.Companion companion = MainApplication.k;
            NaviManager.getInstance(companion.f()).startMap(companion.f());
            ModulePrivacyManagerKt.f(1);
        } else if (i == 2) {
            Context applicationContext = this.$rootActivity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            TranslationApp.startMainActivity(applicationContext);
            ModulePrivacyManagerKt.f(2);
        } else if (i == 3) {
            TiciApp ticiApp = TiciApp.b;
            Context applicationContext2 = this.$rootActivity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            ticiApp.t(applicationContext2);
            ModulePrivacyManagerKt.f(3);
        } else if (i == 4) {
            Function0<Unit> function0 = this.$callback;
            if (function0 != null) {
                function0.invoke();
            }
            ModulePrivacyManagerKt.f(4);
        }
    }
}
