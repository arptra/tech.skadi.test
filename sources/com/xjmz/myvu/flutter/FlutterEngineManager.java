package com.xjmz.myvu.flutter;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterEngineGroup;
import io.flutter.embedding.engine.FlutterEngineGroupCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/xjmz/myvu/flutter/FlutterEngineManager;", "", "<init>", "()V", "Landroid/content/Context;", "appContext", "", "e", "(Landroid/content/Context;)V", "", "Ljava/util/Locale;", "newLocales", "f", "(Ljava/util/List;)V", "", "engineId", "Lio/flutter/embedding/engine/FlutterEngine;", "d", "(Ljava/lang/String;)Lio/flutter/embedding/engine/FlutterEngine;", "context", "engineGroupId", "defaultRoute", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/flutter/embedding/engine/FlutterEngine;", "Lio/flutter/embedding/engine/FlutterEngineGroup;", "c", "(Landroid/content/Context;Ljava/lang/String;)Lio/flutter/embedding/engine/FlutterEngineGroup;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FlutterEngineManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8242a = new Companion((DefaultConstructorMarker) null);
    public static final FlutterRoutes b = new FlutterRoutes();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xjmz/myvu/flutter/FlutterEngineManager$Companion;", "", "()V", "TAG", "", "flutterRoutes", "Lcom/xjmz/myvu/flutter/FlutterRoutes;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ FlutterEngine b(FlutterEngineManager flutterEngineManager, Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "flutter_engine_group_home";
        }
        if ((i & 8) != 0) {
            str3 = "";
        }
        return flutterEngineManager.a(context, str, str2, str3);
    }

    public final FlutterEngine a(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "engineId");
        Intrinsics.checkNotNullParameter(str2, "engineGroupId");
        Intrinsics.checkNotNullParameter(str3, "defaultRoute");
        FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(str);
        if (flutterEngine == null) {
            FlutterEngineGroup.Options options = new FlutterEngineGroup.Options(context);
            if (str3.length() > 0) {
                options.setInitialRoute(str3);
            }
            options.setDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
            flutterEngine = c(context, str2).createAndRunEngine(options);
            FlutterEngineCache.getInstance().put(str, flutterEngine);
        }
        Intrinsics.checkNotNull(flutterEngine);
        return flutterEngine;
    }

    public final FlutterEngineGroup c(Context context, String str) {
        FlutterEngineGroup flutterEngineGroup = FlutterEngineGroupCache.getInstance().get(str);
        if (flutterEngineGroup != null) {
            return flutterEngineGroup;
        }
        FlutterEngineGroup flutterEngineGroup2 = new FlutterEngineGroup(context);
        FlutterEngineGroupCache.getInstance().put(str, flutterEngineGroup2);
        return flutterEngineGroup2;
    }

    public final FlutterEngine d(String str) {
        Intrinsics.checkNotNullParameter(str, "engineId");
        return FlutterEngineCache.getInstance().get(str);
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        long currentTimeMillis = System.currentTimeMillis();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("FlutterEngineManager", "init-> start");
        c(context, "flutter_engine_group_home");
        b.a(this, context);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        delegate.g("FlutterEngineManager", "init-> end: " + currentTimeMillis2);
    }

    public final void f(List list) {
        Intrinsics.checkNotNullParameter(list, "newLocales");
        b.b(this, list);
    }
}
