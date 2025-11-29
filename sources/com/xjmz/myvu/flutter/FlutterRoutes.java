package com.xjmz.myvu.flutter;

import android.content.Context;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0003\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/xjmz/myvu/flutter/FlutterRoutes;", "", "<init>", "()V", "Lcom/xjmz/myvu/flutter/FlutterEngineManager;", "engineManager", "Landroid/content/Context;", "appContext", "", "a", "(Lcom/xjmz/myvu/flutter/FlutterEngineManager;Landroid/content/Context;)V", "", "Ljava/util/Locale;", "newLocales", "b", "(Lcom/xjmz/myvu/flutter/FlutterEngineManager;Ljava/util/List;)V", "Lkotlin/Pair;", "", "Ljava/util/List;", "routes", "Companion", "EngineGroups", "Pages", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFlutterRoutes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlutterRoutes.kt\ncom/xjmz/myvu/flutter/FlutterRoutes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1855#2,2:44\n1855#2,2:46\n*S KotlinDebug\n*F\n+ 1 FlutterRoutes.kt\ncom/xjmz/myvu/flutter/FlutterRoutes\n*L\n27#1:44,2\n37#1:46,2\n*E\n"})
public final class FlutterRoutes {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final List f8243a = CollectionsKt.mutableListOf(TuplesKt.to("main_engine", "/home"));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/FlutterRoutes$Companion;", "", "()V", "HOME_ENGINE", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/xjmz/myvu/flutter/FlutterRoutes$EngineGroups;", "", "<init>", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class EngineGroups {

        /* renamed from: a  reason: collision with root package name */
        public static final EngineGroups f8244a = new EngineGroups();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/xjmz/myvu/flutter/FlutterRoutes$Pages;", "", "<init>", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Pages {

        /* renamed from: a  reason: collision with root package name */
        public static final Pages f8245a = new Pages();
    }

    public final void a(FlutterEngineManager flutterEngineManager, Context context) {
        Intrinsics.checkNotNullParameter(flutterEngineManager, "engineManager");
        Intrinsics.checkNotNullParameter(context, "appContext");
        for (Pair pair : this.f8243a) {
            FlutterEngineManager.b(flutterEngineManager, context, (String) pair.getFirst(), (String) null, (String) pair.getSecond(), 4, (Object) null);
        }
    }

    public final void b(FlutterEngineManager flutterEngineManager, List list) {
        LocalizationChannel localizationChannel;
        Intrinsics.checkNotNullParameter(flutterEngineManager, "engineManager");
        Intrinsics.checkNotNullParameter(list, "newLocales");
        for (Pair first : this.f8243a) {
            FlutterEngine d = flutterEngineManager.d((String) first.getFirst());
            if (!(d == null || (localizationChannel = d.getLocalizationChannel()) == null)) {
                localizationChannel.sendLocales(list);
            }
        }
    }
}
