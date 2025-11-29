package com.rousetime.android_startup;

import android.content.Context;
import android.os.Looper;
import androidx.core.os.TraceCompat;
import com.rousetime.android_startup.annotation.MultipleProcess;
import com.rousetime.android_startup.dispatcher.StartupManagerDispatcher;
import com.rousetime.android_startup.execption.StartupException;
import com.rousetime.android_startup.manager.StartupCacheManager;
import com.rousetime.android_startup.model.LoggerLevel;
import com.rousetime.android_startup.model.StartupConfig;
import com.rousetime.android_startup.model.StartupSortStore;
import com.rousetime.android_startup.sort.TopologySort;
import com.rousetime.android_startup.utils.ProcessUtils;
import com.rousetime.android_startup.utils.StartupCostTimesUtils;
import com.rousetime.android_startup.utils.StartupLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00142\u00020\u0001:\u0002'(B3\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010&¨\u0006)"}, d2 = {"Lcom/rousetime/android_startup/StartupManager;", "", "Landroid/content/Context;", "context", "", "Lcom/rousetime/android_startup/AndroidStartup;", "startupList", "Ljava/util/concurrent/atomic/AtomicInteger;", "needAwaitCount", "Lcom/rousetime/android_startup/model/StartupConfig;", "config", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/concurrent/atomic/AtomicInteger;Lcom/rousetime/android_startup/model/StartupConfig;)V", "i", "()Lcom/rousetime/android_startup/StartupManager;", "", "f", "()V", "Lcom/rousetime/android_startup/model/StartupSortStore;", "sortStore", "g", "(Lcom/rousetime/android_startup/model/StartupSortStore;)V", "Ljava/util/concurrent/CountDownLatch;", "a", "Ljava/util/concurrent/CountDownLatch;", "mAwaitCountDownLatch", "Lcom/rousetime/android_startup/dispatcher/StartupManagerDispatcher;", "b", "Lkotlin/Lazy;", "h", "()Lcom/rousetime/android_startup/dispatcher/StartupManagerDispatcher;", "mDefaultManagerDispatcher", "c", "Landroid/content/Context;", "d", "Ljava/util/List;", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lcom/rousetime/android_startup/model/StartupConfig;", "Builder", "Companion", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupManager {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public CountDownLatch f9819a;
    public final Lazy b;
    public final Context c;
    public final List d;
    public final AtomicInteger e;
    public final StartupConfig f;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00002\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/rousetime/android_startup/StartupManager$Builder;", "", "<init>", "()V", "Lcom/rousetime/android_startup/AndroidStartup;", "startup", "b", "(Lcom/rousetime/android_startup/AndroidStartup;)Lcom/rousetime/android_startup/StartupManager$Builder;", "", "list", "a", "(Ljava/util/List;)Lcom/rousetime/android_startup/StartupManager$Builder;", "Lcom/rousetime/android_startup/model/StartupConfig;", "config", "d", "(Lcom/rousetime/android_startup/model/StartupConfig;)Lcom/rousetime/android_startup/StartupManager$Builder;", "Landroid/content/Context;", "context", "Lcom/rousetime/android_startup/StartupManager;", "c", "(Landroid/content/Context;)Lcom/rousetime/android_startup/StartupManager;", "", "Ljava/util/List;", "mStartupList", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "mNeedAwaitCount", "Lcom/rousetime/android_startup/model/LoggerLevel;", "Lcom/rousetime/android_startup/model/LoggerLevel;", "mLoggerLevel", "", "J", "mAwaitTimeout", "e", "Lcom/rousetime/android_startup/model/StartupConfig;", "mConfig", "android-startup_release"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public List f9820a = new ArrayList();
        public AtomicInteger b = new AtomicInteger();
        public LoggerLevel c = LoggerLevel.NONE;
        public long d = 10000;
        public StartupConfig e;

        public final Builder a(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b((AndroidStartup) it.next());
            }
            return this;
        }

        public final Builder b(AndroidStartup androidStartup) {
            this.f9820a.add(androidStartup);
            return this;
        }

        public final StartupManager c(Context context) {
            String[] strArr;
            ArrayList arrayList = new ArrayList();
            for (AndroidStartup androidStartup : this.f9820a) {
                MultipleProcess multipleProcess = (MultipleProcess) androidStartup.getClass().getAnnotation(MultipleProcess.class);
                if (multipleProcess == null || (strArr = multipleProcess.process()) == null) {
                    strArr = new String[0];
                }
                if (strArr.length == 0 || ProcessUtils.f9835a.b(context, strArr)) {
                    arrayList.add(androidStartup);
                    if (androidStartup.h() && !androidStartup.g()) {
                        this.b.incrementAndGet();
                    }
                }
            }
            AtomicInteger atomicInteger = this.b;
            StartupConfig startupConfig = this.e;
            return new StartupManager(context, arrayList, atomicInteger, startupConfig != null ? startupConfig : new StartupConfig.Builder().c(this.c).b(this.d).a(), (DefaultConstructorMarker) null);
        }

        public final Builder d(StartupConfig startupConfig) {
            this.e = startupConfig;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/rousetime/android_startup/StartupManager$Companion;", "", "()V", "AWAIT_TIMEOUT", "", "android-startup_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StartupManager(Context context, List list, AtomicInteger atomicInteger, StartupConfig startupConfig) {
        this.c = context;
        this.d = list;
        this.e = atomicInteger;
        this.f = startupConfig;
        StartupCacheManager.d.a().e(startupConfig);
        StartupLogUtils.b.e(startupConfig.c());
        this.b = LazyKt.lazy(new StartupManager$mDefaultManagerDispatcher$2(this));
    }

    public final void f() {
        if (this.f9819a != null) {
            int i = this.e.get();
            try {
                CountDownLatch countDownLatch = this.f9819a;
                if (countDownLatch != null) {
                    countDownLatch.await(this.f.a(), TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (i > 0) {
                StartupCostTimesUtils.d.h(Long.valueOf(System.nanoTime()));
                TraceCompat.b();
                return;
            }
            return;
        }
        throw new StartupException("must be call start method before call await method.");
    }

    public final void g(StartupSortStore startupSortStore) {
        for (Startup b2 : startupSortStore.a()) {
            h().b(b2, startupSortStore);
        }
    }

    public final StartupManagerDispatcher h() {
        return (StartupManagerDispatcher) this.b.getValue();
    }

    public final StartupManager i() {
        if (!Intrinsics.areEqual((Object) Looper.getMainLooper(), (Object) Looper.myLooper())) {
            throw new StartupException("start method must be call in MainThread.");
        } else if (this.f9819a == null) {
            this.f9819a = new CountDownLatch(this.e.get());
            List list = this.d;
            if (list == null || list.isEmpty()) {
                StartupLogUtils.b.c(StartupManager$start$1$1.INSTANCE);
            } else {
                TraceCompat.a(StartupManager.class.getSimpleName());
                StartupCostTimesUtils startupCostTimesUtils = StartupCostTimesUtils.d;
                startupCostTimesUtils.i(System.nanoTime());
                StartupSortStore b2 = TopologySort.f9834a.b(this.d);
                h().c();
                g(b2);
                if (this.e.get() <= 0) {
                    startupCostTimesUtils.h(Long.valueOf(System.nanoTime()));
                    TraceCompat.b();
                }
            }
            return this;
        } else {
            throw new StartupException("start method repeated call.");
        }
    }

    public /* synthetic */ StartupManager(Context context, List list, AtomicInteger atomicInteger, StartupConfig startupConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, atomicInteger, startupConfig);
    }
}
