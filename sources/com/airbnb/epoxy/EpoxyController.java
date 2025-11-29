package com.airbnb.epoxy;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

public abstract class EpoxyController implements ModelCollector, StickyHeaderCallbacks {
    private static final int DELAY_TO_CHECK_ADAPTER_COUNT_MS = 3000;
    private static final Timer NO_OP_TIMER = new NoOpTimer();
    public static Handler defaultDiffingHandler;
    public static Handler defaultModelBuildingHandler;
    private static boolean filterDuplicatesDefault = false;
    private static boolean globalDebugLoggingEnabled = false;
    private static ExceptionHandler globalExceptionHandler = new ExceptionHandler() {
        public void a(EpoxyController epoxyController, RuntimeException runtimeException) {
        }
    };
    /* access modifiers changed from: private */
    public final EpoxyControllerAdapter adapter;
    private final Runnable buildModelsRunnable;
    private EpoxyDiffLogger debugObserver;
    private volatile boolean filterDuplicates;
    /* access modifiers changed from: private */
    public volatile boolean hasBuiltModelsEver;
    /* access modifiers changed from: private */
    public final ControllerHelper helper;
    private final List<Interceptor> interceptors;
    private final Handler modelBuildHandler;
    private List<ModelInterceptorCallback> modelInterceptorCallbacks;
    /* access modifiers changed from: private */
    public ControllerModelList modelsBeingBuilt;
    /* access modifiers changed from: private */
    public int recyclerViewAttachCount;
    private volatile int requestedModelBuildType;
    /* access modifiers changed from: private */
    public EpoxyModel<?> stagedModel;
    /* access modifiers changed from: private */
    public volatile Thread threadBuildingModels;
    /* access modifiers changed from: private */
    public Timer timer;

    public interface ExceptionHandler {
        void a(EpoxyController epoxyController, RuntimeException runtimeException);
    }

    public interface Interceptor {
        void a(List list);
    }

    public interface ModelInterceptorCallback {
        void a(EpoxyController epoxyController);

        void b(EpoxyController epoxyController);
    }

    static {
        Handler handler = MainThreadExecutor.b.f2305a;
        defaultModelBuildingHandler = handler;
        defaultDiffingHandler = handler;
    }

    public EpoxyController() {
        this(defaultModelBuildingHandler, defaultDiffingHandler);
    }

    public static void setGlobalDebugLoggingEnabled(boolean z) {
        globalDebugLoggingEnabled = z;
    }

    public static void setGlobalDuplicateFilteringDefault(boolean z) {
        filterDuplicatesDefault = z;
    }

    public static void setGlobalExceptionHandler(@NonNull ExceptionHandler exceptionHandler) {
        globalExceptionHandler = exceptionHandler;
    }

    public final void a() {
        if (!isBuildingModels()) {
            throw new IllegalEpoxyUsage("Can only call this when inside the `buildModels` method");
        }
    }

    public void add(@NonNull EpoxyModel<?> epoxyModel) {
        epoxyModel.r(this);
    }

    public void addAfterInterceptorCallback(ModelInterceptorCallback modelInterceptorCallback) {
        a();
        if (this.modelInterceptorCallbacks == null) {
            this.modelInterceptorCallbacks = new ArrayList();
        }
        this.modelInterceptorCallbacks.add(modelInterceptorCallback);
    }

    public void addCurrentlyStagedModelIfExists() {
        EpoxyModel<?> epoxyModel = this.stagedModel;
        if (epoxyModel != null) {
            epoxyModel.r(this);
        }
        this.stagedModel = null;
    }

    public void addInterceptor(@NonNull Interceptor interceptor) {
        this.interceptors.add(interceptor);
    }

    public void addInternal(EpoxyModel<?> epoxyModel) {
        a();
        if (epoxyModel.C()) {
            throw new IllegalEpoxyUsage("You must set an id on a model before adding it. Use the @AutoModel annotation if you want an id to be automatically generated for you.");
        } else if (epoxyModel.H()) {
            clearModelFromStaging(epoxyModel);
            epoxyModel.f = null;
            this.modelsBeingBuilt.add(epoxyModel);
        } else {
            throw new IllegalEpoxyUsage("You cannot hide a model in an EpoxyController. Use `addIf` to conditionally add a model instead.");
        }
    }

    public void addModelBuildListener(OnModelBuildFinishedListener onModelBuildFinishedListener) {
        this.adapter.G(onModelBuildFinishedListener);
    }

    public final void b() {
        if (isBuildingModels()) {
            throw new IllegalEpoxyUsage("Cannot call this from inside `buildModels`");
        }
    }

    public abstract void buildModels();

    public final void c(List list) {
        if (this.filterDuplicates) {
            this.timer.a("Duplicates filtered");
            HashSet hashSet = new HashSet(list.size());
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                EpoxyModel epoxyModel = (EpoxyModel) listIterator.next();
                if (!hashSet.add(Long.valueOf(epoxyModel.D()))) {
                    int previousIndex = listIterator.previousIndex();
                    listIterator.remove();
                    int d = d(list, epoxyModel);
                    EpoxyModel epoxyModel2 = (EpoxyModel) list.get(d);
                    if (previousIndex <= d) {
                        d++;
                    }
                    onExceptionSwallowed(new IllegalEpoxyUsage("Two models have the same ID. ID's must be unique!\nOriginal has position " + d + ":\n" + epoxyModel2 + "\nDuplicate has position " + previousIndex + ":\n" + epoxyModel));
                }
            }
            this.timer.stop();
        }
    }

    public synchronized void cancelPendingModelBuild() {
        if (this.requestedModelBuildType != 0) {
            this.requestedModelBuildType = 0;
            this.modelBuildHandler.removeCallbacks(this.buildModelsRunnable);
        }
    }

    public void clearModelFromStaging(EpoxyModel<?> epoxyModel) {
        if (this.stagedModel != epoxyModel) {
            addCurrentlyStagedModelIfExists();
        }
        this.stagedModel = null;
    }

    public final int d(List list, EpoxyModel epoxyModel) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((EpoxyModel) list.get(i)).D() == epoxyModel.D()) {
                return i;
            }
        }
        throw new IllegalArgumentException("No duplicates in list");
    }

    public final int e() {
        int itemCount = this.adapter.getItemCount();
        if (itemCount != 0) {
            return itemCount;
        }
        return 25;
    }

    public final void f() {
        if (!this.interceptors.isEmpty()) {
            List<ModelInterceptorCallback> list = this.modelInterceptorCallbacks;
            if (list != null) {
                for (ModelInterceptorCallback b : list) {
                    b.b(this);
                }
            }
            this.timer.a("Interceptors executed");
            for (Interceptor a2 : this.interceptors) {
                a2.a(this.modelsBeingBuilt);
            }
            this.timer.stop();
            List<ModelInterceptorCallback> list2 = this.modelInterceptorCallbacks;
            if (list2 != null) {
                for (ModelInterceptorCallback a3 : list2) {
                    a3.a(this);
                }
            }
        }
        this.modelInterceptorCallbacks = null;
    }

    @NonNull
    public EpoxyControllerAdapter getAdapter() {
        return this.adapter;
    }

    public int getFirstIndexOfModelInBuildingList(EpoxyModel<?> epoxyModel) {
        a();
        int size = this.modelsBeingBuilt.size();
        for (int i = 0; i < size; i++) {
            if (this.modelsBeingBuilt.get(i) == epoxyModel) {
                return i;
            }
        }
        return -1;
    }

    public int getModelCountBuiltSoFar() {
        a();
        return this.modelsBeingBuilt.size();
    }

    public int getSpanCount() {
        return this.adapter.l();
    }

    @NonNull
    public GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return this.adapter.m();
    }

    public boolean hasPendingModelBuild() {
        return (this.requestedModelBuildType == 0 && this.threadBuildingModels == null && !this.adapter.J()) ? false : true;
    }

    public boolean isBuildingModels() {
        return this.threadBuildingModels == Thread.currentThread();
    }

    public boolean isDebugLoggingEnabled() {
        return this.timer != NO_OP_TIMER;
    }

    public boolean isDuplicateFilteringEnabled() {
        return this.filterDuplicates;
    }

    public boolean isModelAddedMultipleTimes(EpoxyModel<?> epoxyModel) {
        a();
        int size = this.modelsBeingBuilt.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.modelsBeingBuilt.get(i2) == epoxyModel) {
                i++;
            }
        }
        return i > 1;
    }

    public boolean isMultiSpan() {
        return this.adapter.n();
    }

    public boolean isStickyHeader(int i) {
        return false;
    }

    public void moveModel(int i, int i2) {
        b();
        this.adapter.K(i, i2);
        requestDelayedModelBuild(500);
    }

    public void notifyModelChanged(int i) {
        b();
        this.adapter.L(i);
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    }

    public void onAttachedToRecyclerViewInternal(RecyclerView recyclerView) {
        int i = this.recyclerViewAttachCount + 1;
        this.recyclerViewAttachCount = i;
        if (i > 1) {
            MainThreadExecutor.b.f2305a.postDelayed(new Runnable() {
                public void run() {
                    if (EpoxyController.this.recyclerViewAttachCount > 1) {
                        EpoxyController.this.onExceptionSwallowed(new IllegalStateException("This EpoxyController had its adapter added to more than one ReyclerView. Epoxy does not support attaching an adapter to multiple RecyclerViews because saved state will not work properly. If you did not intend to attach your adapter to multiple RecyclerViews you may be leaking a reference to a previous RecyclerView. Make sure to remove the adapter from any previous RecyclerViews (eg if the adapter is reused in a Fragment across multiple onCreateView/onDestroyView cycles). See https://github.com/airbnb/epoxy/wiki/Avoiding-Memory-Leaks for more information."));
                    }
                }
            }, 3000);
        }
        onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
    }

    public void onDetachedFromRecyclerViewInternal(RecyclerView recyclerView) {
        this.recyclerViewAttachCount--;
        onDetachedFromRecyclerView(recyclerView);
    }

    public void onExceptionSwallowed(@NonNull RuntimeException runtimeException) {
        globalExceptionHandler.a(this, runtimeException);
    }

    public void onModelBound(@NonNull EpoxyViewHolder epoxyViewHolder, @NonNull EpoxyModel<?> epoxyModel, int i, @Nullable EpoxyModel<?> epoxyModel2) {
    }

    public void onModelUnbound(@NonNull EpoxyViewHolder epoxyViewHolder, @NonNull EpoxyModel<?> epoxyModel) {
    }

    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        this.adapter.y(bundle);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        this.adapter.z(bundle);
    }

    public void onViewAttachedToWindow(@NonNull EpoxyViewHolder epoxyViewHolder, @NonNull EpoxyModel<?> epoxyModel) {
    }

    public void onViewDetachedFromWindow(@NonNull EpoxyViewHolder epoxyViewHolder, @NonNull EpoxyModel<?> epoxyModel) {
    }

    public void removeInterceptor(@NonNull Interceptor interceptor) {
        this.interceptors.remove(interceptor);
    }

    public void removeModelBuildListener(OnModelBuildFinishedListener onModelBuildFinishedListener) {
        this.adapter.M(onModelBuildFinishedListener);
    }

    public synchronized void requestDelayedModelBuild(int i) {
        try {
            if (!isBuildingModels()) {
                int i2 = 1;
                if (this.requestedModelBuildType == 2) {
                    cancelPendingModelBuild();
                } else if (this.requestedModelBuildType == 1) {
                    return;
                }
                if (i != 0) {
                    i2 = 2;
                }
                this.requestedModelBuildType = i2;
                this.modelBuildHandler.postDelayed(this.buildModelsRunnable, (long) i);
                return;
            }
            throw new IllegalEpoxyUsage("Cannot call `requestDelayedModelBuild` from inside `buildModels`");
        } catch (Throwable th) {
            throw th;
        }
    }

    public void requestModelBuild() {
        if (isBuildingModels()) {
            throw new IllegalEpoxyUsage("Cannot call `requestModelBuild` from inside `buildModels`");
        } else if (this.hasBuiltModelsEver) {
            requestDelayedModelBuild(0);
        } else {
            this.buildModelsRunnable.run();
        }
    }

    public void setDebugLoggingEnabled(boolean z) {
        b();
        if (z) {
            this.timer = new DebugTimer(getClass().getSimpleName());
            if (this.debugObserver == null) {
                this.debugObserver = new EpoxyDiffLogger(getClass().getSimpleName());
            }
            this.adapter.registerAdapterDataObserver(this.debugObserver);
            return;
        }
        this.timer = NO_OP_TIMER;
        EpoxyDiffLogger epoxyDiffLogger = this.debugObserver;
        if (epoxyDiffLogger != null) {
            this.adapter.unregisterAdapterDataObserver(epoxyDiffLogger);
        }
    }

    public void setFilterDuplicates(boolean z) {
        this.filterDuplicates = z;
    }

    public void setSpanCount(int i) {
        this.adapter.D(i);
    }

    public void setStagedModel(EpoxyModel<?> epoxyModel) {
        if (epoxyModel != this.stagedModel) {
            addCurrentlyStagedModelIfExists();
        }
        this.stagedModel = epoxyModel;
    }

    public void setupStickyHeaderView(@NotNull View view) {
    }

    public void teardownStickyHeaderView(@NotNull View view) {
    }

    public EpoxyController(Handler handler, Handler handler2) {
        this.recyclerViewAttachCount = 0;
        this.interceptors = new CopyOnWriteArrayList();
        this.filterDuplicates = filterDuplicatesDefault;
        this.threadBuildingModels = null;
        this.timer = NO_OP_TIMER;
        this.helper = ControllerHelperLookup.b(this);
        this.requestedModelBuildType = 0;
        this.buildModelsRunnable = new Runnable() {
            public void run() {
                Thread unused = EpoxyController.this.threadBuildingModels = Thread.currentThread();
                EpoxyController.this.cancelPendingModelBuild();
                EpoxyController.this.helper.resetAutoModels();
                ControllerModelList unused2 = EpoxyController.this.modelsBeingBuilt = new ControllerModelList(EpoxyController.this.e());
                EpoxyController.this.timer.a("Models built");
                try {
                    EpoxyController.this.buildModels();
                    EpoxyController.this.addCurrentlyStagedModelIfExists();
                    EpoxyController.this.timer.stop();
                    EpoxyController.this.f();
                    EpoxyController epoxyController = EpoxyController.this;
                    epoxyController.c(epoxyController.modelsBeingBuilt);
                    EpoxyController.this.modelsBeingBuilt.freeze();
                    EpoxyController.this.timer.a("Models diffed");
                    EpoxyController.this.adapter.N(EpoxyController.this.modelsBeingBuilt);
                    EpoxyController.this.timer.stop();
                    ControllerModelList unused3 = EpoxyController.this.modelsBeingBuilt = null;
                    boolean unused4 = EpoxyController.this.hasBuiltModelsEver = true;
                    Thread unused5 = EpoxyController.this.threadBuildingModels = null;
                } catch (Throwable th) {
                    EpoxyController.this.timer.stop();
                    ControllerModelList unused6 = EpoxyController.this.modelsBeingBuilt = null;
                    boolean unused7 = EpoxyController.this.hasBuiltModelsEver = true;
                    Thread unused8 = EpoxyController.this.threadBuildingModels = null;
                    EpoxyModel unused9 = EpoxyController.this.stagedModel = null;
                    throw th;
                }
            }
        };
        this.adapter = new EpoxyControllerAdapter(this, handler2);
        this.modelBuildHandler = handler;
        setDebugLoggingEnabled(globalDebugLoggingEnabled);
    }

    public void add(@NonNull EpoxyModel<?>... epoxyModelArr) {
        ControllerModelList controllerModelList = this.modelsBeingBuilt;
        controllerModelList.ensureCapacity(controllerModelList.size() + epoxyModelArr.length);
        for (EpoxyModel<?> add : epoxyModelArr) {
            add(add);
        }
    }

    public void add(@NonNull List<? extends EpoxyModel<?>> list) {
        ControllerModelList controllerModelList = this.modelsBeingBuilt;
        controllerModelList.ensureCapacity(controllerModelList.size() + list.size());
        for (EpoxyModel add : list) {
            add((EpoxyModel<?>) add);
        }
    }
}
