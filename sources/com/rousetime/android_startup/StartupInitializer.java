package com.rousetime.android_startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import androidx.core.os.TraceCompat;
import com.rousetime.android_startup.execption.StartupException;
import com.rousetime.android_startup.extensions.StartupExtensionsKt;
import com.rousetime.android_startup.manager.StartupCacheManager;
import com.rousetime.android_startup.model.StartupProviderStore;
import com.rousetime.android_startup.provider.StartupProviderConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJI\u0010\u0012\u001a\u00020\u00112\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/rousetime/android_startup/StartupInitializer;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "providerName", "Lcom/rousetime/android_startup/model/StartupProviderStore;", "b", "(Landroid/content/Context;Ljava/lang/String;)Lcom/rousetime/android_startup/model/StartupProviderStore;", "Lcom/rousetime/android_startup/AndroidStartup;", "startup", "", "result", "initialize", "initialized", "", "c", "(Lcom/rousetime/android_startup/AndroidStartup;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "Companion", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupInitializer {

    /* renamed from: a  reason: collision with root package name */
    public static final Lazy f9818a = LazyKt.lazy(StartupInitializer$Companion$instance$2.INSTANCE);
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/rousetime/android_startup/StartupInitializer$Companion;", "", "<init>", "()V", "Lcom/rousetime/android_startup/StartupInitializer;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/rousetime/android_startup/StartupInitializer;", "instance$annotations", "instance", "android-startup_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final StartupInitializer a() {
            return (StartupInitializer) StartupInitializer.f9818a.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final StartupProviderStore b(Context context, String str) {
        TraceCompat.a(StartupInitializer.class.getSimpleName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
            ProviderInfo providerInfo = context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), str), 128);
            String string = context.getString(R.string.android_startup);
            Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.string.android_startup)");
            String string2 = context.getString(R.string.android_startup_provider_config);
            Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(R.stri…_startup_provider_config)");
            Bundle bundle = providerInfo.metaData;
            StartupProviderConfig startupProviderConfig = null;
            if (bundle != null) {
                Set<String> keySet = bundle.keySet();
                Intrinsics.checkExpressionValueIsNotNull(keySet, "metaData.keySet()");
                StartupProviderConfig startupProviderConfig2 = null;
                for (String str2 : keySet) {
                    Object obj = bundle.get(str2);
                    Class<?> cls = Class.forName(str2);
                    Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(key)");
                    if (Intrinsics.areEqual((Object) string, obj)) {
                        if (!AndroidStartup.class.isAssignableFrom(cls)) {
                            continue;
                        } else {
                            Object newInstance = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                            if (newInstance != null) {
                                c((AndroidStartup) newInstance, arrayList, arrayList2, arrayList3);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.rousetime.android_startup.AndroidStartup<*>");
                            }
                        }
                    } else if (Intrinsics.areEqual((Object) string2, obj) && StartupProviderConfig.class.isAssignableFrom(cls)) {
                        Object newInstance2 = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                        if (!(newInstance2 instanceof StartupProviderConfig)) {
                            newInstance2 = null;
                        }
                        startupProviderConfig2 = (StartupProviderConfig) newInstance2;
                        StartupCacheManager.d.a().e(startupProviderConfig2 != null ? startupProviderConfig2.a() : null);
                    }
                }
                startupProviderConfig = startupProviderConfig2;
            }
            TraceCompat.b();
            return new StartupProviderStore(arrayList, startupProviderConfig);
        } catch (Throwable th) {
            throw new StartupException(th);
        }
    }

    public final void c(AndroidStartup androidStartup, List list, List list2, List list3) {
        try {
            String a2 = StartupExtensionsKt.a(androidStartup.getClass());
            if (list2.contains(a2)) {
                throw new IllegalStateException("have circle dependencies.");
            } else if (!list3.contains(a2)) {
                list2.add(a2);
                list.add(androidStartup);
                List f = androidStartup.f();
                if (f != null) {
                    if (!f.isEmpty()) {
                        List<String> f2 = androidStartup.f();
                        if (f2 != null) {
                            for (String cls : f2) {
                                Class<?> cls2 = Class.forName(cls);
                                Intrinsics.checkExpressionValueIsNotNull(cls2, "Class.forName(it)");
                                Object newInstance = cls2.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                                if (newInstance != null) {
                                    c((AndroidStartup) newInstance, list, list2, list3);
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type com.rousetime.android_startup.AndroidStartup<*>");
                                }
                            }
                        }
                        list2.remove(a2);
                        list3.add(a2);
                    }
                }
                List<Class> dependencies = androidStartup.dependencies();
                if (dependencies != null) {
                    for (Class declaredConstructor : dependencies) {
                        Object newInstance2 = declaredConstructor.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                        if (newInstance2 != null) {
                            c((AndroidStartup) newInstance2, list, list2, list3);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.rousetime.android_startup.AndroidStartup<*>");
                        }
                    }
                }
                list2.remove(a2);
                list3.add(a2);
            }
        } catch (Throwable th) {
            throw new StartupException(th);
        }
    }
}
