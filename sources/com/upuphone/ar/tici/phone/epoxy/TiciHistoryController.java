package com.upuphone.ar.tici.phone.epoxy;

import com.airbnb.epoxy.EpoxyController;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.listener.TiciHistoryItemListener;
import com.upuphone.xr.sapp.common.R;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u0004\u0018\u00010\tJ \u0010\u001d\u001a\u00020\u001b2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R*\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/tici/phone/epoxy/TiciHistoryController;", "Lcom/airbnb/epoxy/EpoxyController;", "listener", "Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;", "(Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;)V", "dataList", "", "", "", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "value", "", "impatientTiciId", "getImpatientTiciId", "()Ljava/lang/Long;", "setImpatientTiciId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getListener$ar_tici_release", "()Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;", "loadingTiciId", "getLoadingTiciId", "setLoadingTiciId", "runningTiciId", "getRunningTiciId", "setRunningTiciId", "buildModels", "", "peekLast", "refreshData", "data", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTiciHistoryController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHistoryController.kt\ncom/upuphone/ar/tici/phone/epoxy/TiciHistoryController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 EpoxyProcessorKotlinExtensions.kt\ncom/upuphone/ar/tici/phone/epoxy/EpoxyProcessorKotlinExtensionsKt\n*L\n1#1,87:1\n1864#2,2:88\n1864#2,2:96\n1866#2:104\n1866#2:105\n18#3,6:90\n27#3,6:98\n*S KotlinDebug\n*F\n+ 1 TiciHistoryController.kt\ncom/upuphone/ar/tici/phone/epoxy/TiciHistoryController\n*L\n38#1:88,2\n44#1:96,2\n44#1:104\n38#1:105\n39#1:90,6\n62#1:98,6\n*E\n"})
public final class TiciHistoryController extends EpoxyController {
    @Nullable
    private Map<String, ? extends List<TiciHistory>> dataList;
    @Nullable
    private Long impatientTiciId;
    @NotNull
    private final TiciHistoryItemListener listener;
    @Nullable
    private Long loadingTiciId;
    @Nullable
    private Long runningTiciId;

    public TiciHistoryController(@NotNull TiciHistoryItemListener ticiHistoryItemListener) {
        Intrinsics.checkNotNullParameter(ticiHistoryItemListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = ticiHistoryItemListener;
    }

    public void buildModels() {
        Map<String, ? extends List<TiciHistory>> map = this.dataList;
        if (map != null) {
            int i = 0;
            for (T next : map.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) next;
                TiciDateModel_ ticiDateModel_ = new TiciDateModel_();
                Object key = entry.getKey();
                ticiDateModel_.a("ticiDate" + key);
                ticiDateModel_.f((String) entry.getKey());
                int i3 = 1;
                ticiDateModel_.l(i == 0);
                add(ticiDateModel_);
                int i4 = 0;
                for (Object next2 : (Iterable) entry.getValue()) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    TiciHistory ticiHistory = (TiciHistory) next2;
                    int i6 = ((List) entry.getValue()).size() == i3 ? R.drawable.card_item_full_round_selector : i4 == 0 ? R.drawable.card_item_top_round_selector : i4 == ((List) entry.getValue()).size() - i3 ? R.drawable.card_item_bottom_round_selector : R.drawable.card_item_middle_rectangle_selector;
                    TiciHistoryFileModel_ ticiHistoryFileModel_ = new TiciHistoryFileModel_();
                    long id = ticiHistory.getId();
                    ticiHistoryFileModel_.a("ticiHistoryFile_" + id);
                    ticiHistoryFileModel_.g(ticiHistory);
                    Long l = this.loadingTiciId;
                    ticiHistoryFileModel_.n(l != null && l.longValue() == ticiHistory.getId());
                    Long l2 = this.impatientTiciId;
                    ticiHistoryFileModel_.j(l2 != null && l2.longValue() == ticiHistory.getId());
                    Long l3 = this.runningTiciId;
                    ticiHistoryFileModel_.m(l3 != null && l3.longValue() == ticiHistory.getId());
                    ticiHistoryFileModel_.b(i6);
                    i3 = 1;
                    ticiHistoryFileModel_.c(i == map.size() - 1 && i4 == ((List) entry.getValue()).size() - 1);
                    ticiHistoryFileModel_.i(this.listener);
                    add(ticiHistoryFileModel_);
                    i4 = i5;
                }
                i = i2;
            }
        }
    }

    @Nullable
    public final Long getImpatientTiciId() {
        return this.impatientTiciId;
    }

    @NotNull
    public final TiciHistoryItemListener getListener$ar_tici_release() {
        return this.listener;
    }

    @Nullable
    public final Long getLoadingTiciId() {
        return this.loadingTiciId;
    }

    @Nullable
    public final Long getRunningTiciId() {
        return this.runningTiciId;
    }

    @Nullable
    public final TiciHistory peekLast() {
        Collection<? extends List<TiciHistory>> values;
        List list;
        Map<String, ? extends List<TiciHistory>> map = this.dataList;
        if (map == null || (values = map.values()) == null || (list = (List) CollectionsKt.lastOrNull(values)) == null) {
            return null;
        }
        return (TiciHistory) CollectionsKt.lastOrNull(list);
    }

    public final void refreshData(@NotNull Map<String, ? extends List<TiciHistory>> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        if (hasPendingModelBuild()) {
            cancelPendingModelBuild();
        }
        this.dataList = map;
        requestModelBuild();
    }

    public final void setImpatientTiciId(@Nullable Long l) {
        this.impatientTiciId = l;
        requestModelBuild();
    }

    public final void setLoadingTiciId(@Nullable Long l) {
        this.loadingTiciId = l;
        requestModelBuild();
    }

    public final void setRunningTiciId(@Nullable Long l) {
        this.runningTiciId = l;
        requestModelBuild();
    }
}
