package com.airbnb.epoxy.preload;

import android.view.View;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.preload.PreloadRequestHolder;
import com.airbnb.epoxy.preload.ViewMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 \u001d*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\n\b\u0001\u0010\u0004*\u0004\u0018\u00010\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u00020\u0007:\u0001 J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;", "Lcom/airbnb/epoxy/EpoxyModel;", "T", "Lcom/airbnb/epoxy/preload/ViewMetadata;", "U", "Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "P", "", "epoxyModel", "e", "(Lcom/airbnb/epoxy/EpoxyModel;)Ljava/lang/Object;", "Landroid/view/View;", "view", "a", "(Landroid/view/View;)Lcom/airbnb/epoxy/preload/ViewMetadata;", "preloadTarget", "Lcom/airbnb/epoxy/preload/ViewData;", "viewData", "", "d", "(Lcom/airbnb/epoxy/EpoxyModel;Lcom/airbnb/epoxy/preload/PreloadRequestHolder;Lcom/airbnb/epoxy/preload/ViewData;)V", "Ljava/lang/Class;", "Ljava/lang/Class;", "b", "()Ljava/lang/Class;", "modelType", "", "", "Ljava/util/List;", "c", "()Ljava/util/List;", "preloadableViewIds", "Companion", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public abstract class EpoxyModelPreloader<T extends EpoxyModel<?>, U extends ViewMetadata, P extends PreloadRequestHolder> {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Class f2325a;
    public final List b;

    @SourceDebugExtension({"SMAP\nEpoxyModelPreloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EpoxyModelPreloader.kt\ncom/airbnb/epoxy/preload/EpoxyModelPreloader$Companion\n*L\n1#1,131:1\n93#1,7:132\n*S KotlinDebug\n*F\n+ 1 EpoxyModelPreloader.kt\ncom/airbnb/epoxy/preload/EpoxyModelPreloader$Companion\n*L\n72#1:132,7\n*E\n"})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/airbnb/epoxy/preload/EpoxyModelPreloader$Companion;", "", "<init>", "()V", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public abstract ViewMetadata a(View view);

    public final Class b() {
        return this.f2325a;
    }

    public final List c() {
        return this.b;
    }

    public abstract void d(EpoxyModel epoxyModel, PreloadRequestHolder preloadRequestHolder, ViewData viewData);

    public Object e(EpoxyModel epoxyModel) {
        Intrinsics.checkNotNullParameter(epoxyModel, "epoxyModel");
        return null;
    }
}
