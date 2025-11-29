package com.rousetime.android_startup.manager;

import com.rousetime.android_startup.model.ResultModel;
import com.rousetime.android_startup.model.StartupConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R0\u0010\u0019\u001a\u001e\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d¨\u0006 "}, d2 = {"Lcom/rousetime/android_startup/manager/StartupCacheManager;", "", "<init>", "()V", "Ljava/lang/Class;", "Lcom/rousetime/android_startup/Startup;", "zClass", "Lcom/rousetime/android_startup/model/ResultModel;", "result", "", "f", "(Ljava/lang/Class;Lcom/rousetime/android_startup/model/ResultModel;)V", "", "c", "(Ljava/lang/Class;)Z", "T", "d", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/rousetime/android_startup/model/StartupConfig;", "config", "e", "(Lcom/rousetime/android_startup/model/StartupConfig;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "mInitializedComponents", "<set-?>", "b", "Lcom/rousetime/android_startup/model/StartupConfig;", "()Lcom/rousetime/android_startup/model/StartupConfig;", "initializedConfig", "Companion", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupCacheManager {
    public static final Lazy c = LazyKt.lazy(StartupCacheManager$Companion$instance$2.INSTANCE);
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f9826a = new ConcurrentHashMap();
    public StartupConfig b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/rousetime/android_startup/manager/StartupCacheManager$Companion;", "", "<init>", "()V", "Lcom/rousetime/android_startup/manager/StartupCacheManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/rousetime/android_startup/manager/StartupCacheManager;", "instance$annotations", "instance", "android-startup_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final StartupCacheManager a() {
            return (StartupCacheManager) StartupCacheManager.c.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final StartupConfig b() {
        return this.b;
    }

    public final boolean c(Class cls) {
        return this.f9826a.containsKey(cls);
    }

    public final Object d(Class cls) {
        ResultModel resultModel = (ResultModel) this.f9826a.get(cls);
        Object a2 = resultModel != null ? resultModel.a() : null;
        if (!(a2 instanceof Object)) {
            return null;
        }
        return a2;
    }

    public final void e(StartupConfig startupConfig) {
        this.b = startupConfig;
    }

    public final void f(Class cls, ResultModel resultModel) {
        this.f9826a.put(cls, resultModel);
    }
}
