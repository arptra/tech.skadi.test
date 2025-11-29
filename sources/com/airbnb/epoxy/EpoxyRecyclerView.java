package com.airbnb.epoxy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.Px;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.preload.EpoxyModelPreloader;
import com.airbnb.epoxy.preload.EpoxyPreloader;
import com.airbnb.epoxy.preload.PreloadRequestHolder;
import com.airbnb.epoxy.preload.ViewMetadata;
import com.airbnb.viewmodeladapter.R;
import com.honey.account.r0.a;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0005_`abcB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0015¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b&\u0010'J\u0019\u0010)\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010\fJ\u0017\u0010-\u001a\u00020\n2\b\b\u0001\u0010,\u001a\u00020\u0006¢\u0006\u0004\b-\u0010\u001aJ\u0017\u0010/\u001a\u00020\n2\b\b\u0001\u0010.\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\u001aJ\u0019\u00101\u001a\u00020\n2\b\b\u0001\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\u001aJ!\u00105\u001a\u00020\n2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030302H\u0016¢\u0006\u0004\b5\u00106J\u0015\u00109\u001a\u00020\n2\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\u00020\n2\u0006\u00108\u001a\u000207¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\nH\u0016¢\u0006\u0004\b<\u0010\fJ\u0019\u0010=\u001a\u00020\u00062\b\b\u0001\u0010.\u001a\u00020\u0006H\u0005¢\u0006\u0004\b=\u0010>J\u0019\u0010?\u001a\u00020\u00062\b\b\u0001\u0010,\u001a\u00020\u0006H\u0005¢\u0006\u0004\b?\u0010>J\u001d\u0010B\u001a\u00020\n2\f\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010@H\u0016¢\u0006\u0004\bB\u0010CJ%\u0010E\u001a\u00020\n2\f\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010@2\u0006\u0010D\u001a\u00020\u0014H\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\nH\u0016¢\u0006\u0004\bG\u0010\fJ\u000f\u0010H\u001a\u00020\nH\u0016¢\u0006\u0004\bH\u0010\fR\u001a\u0010N\u001a\u00020I8\u0004X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010OR\u001c\u0010R\u001a\b\u0012\u0002\b\u0003\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010QR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010SR\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010TR\u0016\u0010U\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010SR\u0014\u0010X\u001a\u00020V8\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010WR\u001e\u0010\\\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030Z0Y8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010[R&\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030]0Y8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010[¨\u0006d"}, d2 = {"Lcom/airbnb/epoxy/EpoxyRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "o", "()V", "i", "getContextForSharedViewPool", "()Landroid/content/Context;", "n", "j", "d", "c", "", "removeAdapterWhenDetachedFromWindow", "setRemoveAdapterWhenDetachedFromWindow", "(Z)V", "delayMsWhenRemovingAdapterOnDetach", "setDelayMsWhenRemovingAdapterOnDetach", "(I)V", "h", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "f", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "m", "()Z", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "e", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layout", "setLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "requestLayout", "itemSpacingRes", "setItemSpacingRes", "dp", "setItemSpacingDp", "spacingPx", "setItemSpacingPx", "", "Lcom/airbnb/epoxy/EpoxyModel;", "models", "setModels", "(Ljava/util/List;)V", "Lcom/airbnb/epoxy/EpoxyController;", "controller", "setController", "(Lcom/airbnb/epoxy/EpoxyController;)V", "setControllerAndBuildModels", "b", "g", "(I)I", "l", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "removeAndRecycleExistingViews", "swapAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Z)V", "onAttachedToWindow", "onDetachedFromWindow", "Lcom/airbnb/epoxy/EpoxyItemSpacingDecorator;", "a", "Lcom/airbnb/epoxy/EpoxyItemSpacingDecorator;", "getSpacingDecorator", "()Lcom/airbnb/epoxy/EpoxyItemSpacingDecorator;", "spacingDecorator", "Lcom/airbnb/epoxy/EpoxyController;", "epoxyController", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "removedAdapter", "Z", "I", "isRemoveAdapterRunnablePosted", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "removeAdapterRunnable", "", "Lcom/airbnb/epoxy/preload/EpoxyPreloader;", "Ljava/util/List;", "preloadScrollListeners", "Lcom/airbnb/epoxy/EpoxyRecyclerView$PreloadConfig;", "preloadConfigs", "Companion", "ModelBuilderCallback", "ModelBuilderCallbackController", "PreloadConfig", "WithModelsController", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEpoxyRecyclerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EpoxyRecyclerView.kt\ncom/airbnb/epoxy/EpoxyRecyclerView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,663:1\n1855#2,2:664\n1855#2,2:666\n1855#2,2:669\n1#3:668\n*S KotlinDebug\n*F\n+ 1 EpoxyRecyclerView.kt\ncom/airbnb/epoxy/EpoxyRecyclerView\n*L\n150#1:664,2\n154#1:666,2\n606#1:669,2\n*E\n"})
public class EpoxyRecyclerView extends RecyclerView {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public static final ActivityRecyclerPool k = new ActivityRecyclerPool();

    /* renamed from: a  reason: collision with root package name */
    public final EpoxyItemSpacingDecorator f2296a;
    public EpoxyController b;
    public RecyclerView.Adapter c;
    public boolean d;
    public int e;
    public boolean f;
    public final Runnable g;
    public final List h;
    public final List i;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/airbnb/epoxy/EpoxyRecyclerView$Companion;", "", "()V", "ACTIVITY_RECYCLER_POOL", "Lcom/airbnb/epoxy/ActivityRecyclerPool;", "DEFAULT_ADAPTER_REMOVAL_DELAY_MS", "", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/airbnb/epoxy/EpoxyRecyclerView$ModelBuilderCallback;", "", "Lcom/airbnb/epoxy/EpoxyController;", "controller", "", "a", "(Lcom/airbnb/epoxy/EpoxyController;)V", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public interface ModelBuilderCallback {
        void a(EpoxyController epoxyController);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/airbnb/epoxy/EpoxyRecyclerView$ModelBuilderCallbackController;", "Lcom/airbnb/epoxy/EpoxyController;", "()V", "callback", "Lcom/airbnb/epoxy/EpoxyRecyclerView$ModelBuilderCallback;", "getCallback", "()Lcom/airbnb/epoxy/EpoxyRecyclerView$ModelBuilderCallback;", "setCallback", "(Lcom/airbnb/epoxy/EpoxyRecyclerView$ModelBuilderCallback;)V", "buildModels", "", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ModelBuilderCallbackController extends EpoxyController {
        @NotNull
        private ModelBuilderCallback callback = new EpoxyRecyclerView$ModelBuilderCallbackController$callback$1();

        public void buildModels() {
            this.callback.a(this);
        }

        @NotNull
        public final ModelBuilderCallback getCallback() {
            return this.callback;
        }

        public final void setCallback(@NotNull ModelBuilderCallback modelBuilderCallback) {
            Intrinsics.checkNotNullParameter(modelBuilderCallback, "<set-?>");
            this.callback = modelBuilderCallback;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\n\b\u0001\u0010\u0004*\u0004\u0018\u00010\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u00020\u0007R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR1\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000ej\u0002`\u00138\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015R)\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f¨\u0006!"}, d2 = {"Lcom/airbnb/epoxy/EpoxyRecyclerView$PreloadConfig;", "Lcom/airbnb/epoxy/EpoxyModel;", "T", "Lcom/airbnb/epoxy/preload/ViewMetadata;", "U", "Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "P", "", "", "a", "I", "b", "()I", "maxPreload", "Lkotlin/Function2;", "Landroid/content/Context;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "Lcom/airbnb/epoxy/preload/PreloadErrorHandler;", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "errorHandler", "Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;", "c", "Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;", "()Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;", "preloader", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "requestHolderFactory", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public static final class PreloadConfig<T extends EpoxyModel<?>, U extends ViewMetadata, P extends PreloadRequestHolder> {

        /* renamed from: a  reason: collision with root package name */
        public final int f2297a;
        public final Function2 b;
        public final EpoxyModelPreloader c;
        public final Function0 d;

        public final Function2 a() {
            return this.b;
        }

        public final int b() {
            return this.f2297a;
        }

        public final EpoxyModelPreloader c() {
            return this.c;
        }

        public final Function0 d() {
            return this.d;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0014R+\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/airbnb/epoxy/EpoxyRecyclerView$WithModelsController;", "Lcom/airbnb/epoxy/EpoxyController;", "()V", "callback", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "buildModels", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WithModelsController extends EpoxyController {
        @NotNull
        private Function1<? super EpoxyController, Unit> callback = EpoxyRecyclerView$WithModelsController$callback$1.INSTANCE;

        public void buildModels() {
            this.callback.invoke(this);
        }

        @NotNull
        public final Function1<EpoxyController, Unit> getCallback() {
            return this.callback;
        }

        public final void setCallback(@NotNull Function1<? super EpoxyController, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.callback = function1;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EpoxyRecyclerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Context getContextForSharedViewPool() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return context;
            }
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "this.context");
        return context2;
    }

    public static final void k(EpoxyRecyclerView epoxyRecyclerView) {
        Intrinsics.checkNotNullParameter(epoxyRecyclerView, "this$0");
        if (epoxyRecyclerView.f) {
            epoxyRecyclerView.f = false;
            epoxyRecyclerView.j();
        }
    }

    public void b() {
        EpoxyController epoxyController = this.b;
        if (epoxyController != null) {
            epoxyController.cancelPendingModelBuild();
        }
        this.b = null;
        swapAdapter((RecyclerView.Adapter) null, true);
    }

    public final void c() {
        if (ActivityRecyclerPoolKt.a(getContext())) {
            getRecycledViewPool().clear();
        }
    }

    public final void d() {
        this.c = null;
        if (this.f) {
            removeCallbacks(this.g);
            this.f = false;
        }
    }

    public RecyclerView.LayoutManager e() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i2 = layoutParams.height;
        if (i2 != -1 && i2 != 0) {
            return new LinearLayoutManager(getContext(), 0, false);
        }
        int i3 = layoutParams.width;
        if (i3 == -1 || i3 == 0) {
            setHasFixedSize(true);
        }
        return new LinearLayoutManager(getContext());
    }

    public RecyclerView.RecycledViewPool f() {
        return new UnboundedViewPool();
    }

    public final int g(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics());
    }

    @NotNull
    public final EpoxyItemSpacingDecorator getSpacingDecorator() {
        return this.f2296a;
    }

    public void h() {
        setClipToPadding(false);
        i();
    }

    public final void i() {
        if (!m()) {
            setRecycledViewPool(f());
        } else {
            setRecycledViewPool(k.b(getContextForSharedViewPool(), new EpoxyRecyclerView$initViewPool$1(this)).c());
        }
    }

    public final void j() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            swapAdapter((RecyclerView.Adapter) null, true);
            this.c = adapter;
        }
        c();
    }

    public final int l(int i2) {
        return getResources().getDimensionPixelOffset(i2);
    }

    public boolean m() {
        return true;
    }

    public final void n() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        EpoxyController epoxyController = this.b;
        if ((layoutManager instanceof GridLayoutManager) && epoxyController != null) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            if (epoxyController.getSpanCount() != gridLayoutManager.getSpanCount() || gridLayoutManager.getSpanSizeLookup() != epoxyController.getSpanSizeLookup()) {
                epoxyController.setSpanCount(gridLayoutManager.getSpanCount());
                gridLayoutManager.setSpanSizeLookup(epoxyController.getSpanSizeLookup());
            }
        }
    }

    public final void o() {
        EpoxyPreloader epoxyPreloader;
        for (EpoxyPreloader removeOnScrollListener : this.h) {
            removeOnScrollListener(removeOnScrollListener);
        }
        this.h.clear();
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            for (PreloadConfig preloadConfig : this.i) {
                if (adapter instanceof EpoxyAdapter) {
                    epoxyPreloader = EpoxyPreloader.j.a((EpoxyAdapter) adapter, preloadConfig.d(), preloadConfig.a(), preloadConfig.b(), CollectionsKt.listOf(preloadConfig.c()));
                } else {
                    EpoxyController epoxyController = this.b;
                    epoxyPreloader = epoxyController != null ? EpoxyPreloader.j.b(epoxyController, preloadConfig.d(), preloadConfig.a(), preloadConfig.b(), CollectionsKt.listOf(preloadConfig.c())) : null;
                }
                if (epoxyPreloader != null) {
                    this.h.add(epoxyPreloader);
                    addOnScrollListener(epoxyPreloader);
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RecyclerView.Adapter adapter = this.c;
        if (adapter != null) {
            swapAdapter(adapter, false);
        }
        d();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (EpoxyPreloader b2 : this.h) {
            b2.b();
        }
        if (this.d) {
            int i2 = this.e;
            if (i2 > 0) {
                this.f = true;
                postDelayed(this.g, (long) i2);
            } else {
                j();
            }
        }
        c();
    }

    public void requestLayout() {
        n();
        super.requestLayout();
    }

    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        super.setAdapter(adapter);
        d();
        o();
    }

    public final void setController(@NotNull EpoxyController epoxyController) {
        Intrinsics.checkNotNullParameter(epoxyController, "controller");
        this.b = epoxyController;
        setAdapter(epoxyController.getAdapter());
        n();
    }

    public final void setControllerAndBuildModels(@NotNull EpoxyController epoxyController) {
        Intrinsics.checkNotNullParameter(epoxyController, "controller");
        epoxyController.requestModelBuild();
        setController(epoxyController);
    }

    public final void setDelayMsWhenRemovingAdapterOnDetach(int i2) {
        this.e = i2;
    }

    public final void setItemSpacingDp(@Dimension int i2) {
        setItemSpacingPx(g(i2));
    }

    public void setItemSpacingPx(@Px int i2) {
        removeItemDecoration(this.f2296a);
        this.f2296a.e(i2);
        if (i2 > 0) {
            addItemDecoration(this.f2296a);
        }
    }

    public final void setItemSpacingRes(@DimenRes int i2) {
        setItemSpacingPx(l(i2));
    }

    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        n();
    }

    public void setLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, PayloadConstant.KEY_PARAMS);
        boolean z = getLayoutParams() == null;
        super.setLayoutParams(layoutParams);
        if (z && getLayoutManager() == null) {
            setLayoutManager(e());
        }
    }

    public void setModels(@NotNull List<? extends EpoxyModel<?>> list) {
        Intrinsics.checkNotNullParameter(list, "models");
        EpoxyController epoxyController = this.b;
        SimpleEpoxyController simpleEpoxyController = epoxyController instanceof SimpleEpoxyController ? (SimpleEpoxyController) epoxyController : null;
        if (simpleEpoxyController == null) {
            simpleEpoxyController = new SimpleEpoxyController();
            setController(simpleEpoxyController);
        }
        simpleEpoxyController.setModels(list);
    }

    public final void setRemoveAdapterWhenDetachedFromWindow(boolean z) {
        this.d = z;
    }

    public void swapAdapter(RecyclerView.Adapter adapter, boolean z) {
        super.swapAdapter(adapter, z);
        d();
        o();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EpoxyRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EpoxyRecyclerView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EpoxyRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2296a = new EpoxyItemSpacingDecorator();
        this.d = true;
        this.e = 2000;
        this.g = new a(this);
        this.h = new ArrayList();
        this.i = new ArrayList();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EpoxyRecyclerView, i2, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleAttr, 0\n            )");
            setItemSpacingPx(obtainStyledAttributes.getDimensionPixelSize(R.styleable.EpoxyRecyclerView_itemSpacing, 0));
            obtainStyledAttributes.recycle();
        }
        h();
    }
}
