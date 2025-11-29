package com.xjmz.myvu.flutter.base;

import android.content.Context;
import android.os.Bundle;
import com.upuphone.star.core.log.ULog;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joor.Reflect;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/xjmz/myvu/flutter/base/SimpleFlutterFragment;", "Lio/flutter/embedding/android/FlutterFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "Lio/flutter/embedding/engine/FlutterEngine;", "provideFlutterEngine", "(Landroid/content/Context;)Lio/flutter/embedding/engine/FlutterEngine;", "flutterEngine", "", "configureFlutterEngine", "(Lio/flutter/embedding/engine/FlutterEngine;)V", "cleanUpFlutterEngine", "", "isEnabled", "g0", "(Z)V", "Lio/flutter/embedding/android/FlutterEngineProvider;", "a", "Lio/flutter/embedding/android/FlutterEngineProvider;", "getFlutterEngineProvider", "()Lio/flutter/embedding/android/FlutterEngineProvider;", "i0", "(Lio/flutter/embedding/android/FlutterEngineProvider;)V", "flutterEngineProvider", "Lio/flutter/embedding/android/FlutterEngineConfigurator;", "b", "Lio/flutter/embedding/android/FlutterEngineConfigurator;", "getFlutterEngineConfigurator", "()Lio/flutter/embedding/android/FlutterEngineConfigurator;", "h0", "(Lio/flutter/embedding/android/FlutterEngineConfigurator;)V", "flutterEngineConfigurator", "c", "Z", "isBackEnabled", "d", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public class SimpleFlutterFragment extends FlutterFragment {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FlutterEngineProvider f8247a;
    public FlutterEngineConfigurator b;
    public boolean c = true;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/xjmz/myvu/flutter/base/SimpleFlutterFragment$Companion;", "", "<init>", "()V", "", "engineId", "Lcom/xjmz/myvu/flutter/base/SimpleFlutterFragment;", "a", "(Ljava/lang/String;)Lcom/xjmz/myvu/flutter/base/SimpleFlutterFragment;", "engineGroupId", "initialRoute", "b", "(Ljava/lang/String;Ljava/lang/String;)Lcom/xjmz/myvu/flutter/base/SimpleFlutterFragment;", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SimpleFlutterFragment a(String str) {
            Intrinsics.checkNotNullParameter(str, "engineId");
            SimpleFlutterFragment simpleFlutterFragment = new SimpleFlutterFragment();
            Bundle bundle = new Bundle();
            bundle.putString("cached_engine_id", str);
            bundle.putBoolean("should_automatically_handle_on_back_pressed", true);
            bundle.putString("flutterview_transparency_mode", "opaque");
            bundle.putBoolean("should_attach_engine_to_activity", true);
            simpleFlutterFragment.setArguments(bundle);
            return simpleFlutterFragment;
        }

        public final SimpleFlutterFragment b(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "engineGroupId");
            SimpleFlutterFragment simpleFlutterFragment = new SimpleFlutterFragment();
            Bundle bundle = new Bundle();
            bundle.putString("cached_engine_group_id", str);
            bundle.putBoolean("should_automatically_handle_on_back_pressed", true);
            bundle.putString("flutterview_transparency_mode", "opaque");
            bundle.putString("initial_route", str2);
            bundle.putBoolean("should_attach_engine_to_activity", true);
            simpleFlutterFragment.setArguments(bundle);
            return simpleFlutterFragment;
        }

        public Companion() {
        }
    }

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        FlutterEngineConfigurator flutterEngineConfigurator = this.b;
        if (flutterEngineConfigurator != null) {
            flutterEngineConfigurator.cleanUpFlutterEngine(flutterEngine);
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        FlutterEngineConfigurator flutterEngineConfigurator = this.b;
        if (flutterEngineConfigurator != null) {
            flutterEngineConfigurator.configureFlutterEngine(flutterEngine);
        }
    }

    public final void g0(boolean z) {
        if (this.c != z) {
            this.c = z;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("SimpleFlutterFragment", "enableBackPressedCallback, isEnabled: " + z);
            try {
                Reflect.p(this).i("onBackPressedCallback").g("setEnabled", Boolean.valueOf(z));
            } catch (Exception e) {
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.c("SimpleFlutterFragment", "enableBackPressedCallback, error: " + e);
            }
        }
    }

    public final void h0(FlutterEngineConfigurator flutterEngineConfigurator) {
        this.b = flutterEngineConfigurator;
    }

    public final void i0(FlutterEngineProvider flutterEngineProvider) {
        this.f8247a = flutterEngineProvider;
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FlutterEngineProvider flutterEngineProvider = this.f8247a;
        if (flutterEngineProvider != null) {
            return flutterEngineProvider.provideFlutterEngine(context);
        }
        return null;
    }
}
