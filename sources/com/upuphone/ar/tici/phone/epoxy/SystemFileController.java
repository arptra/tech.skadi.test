package com.upuphone.ar.tici.phone.epoxy;

import com.airbnb.epoxy.EpoxyController;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.data.SystemFileInfo;
import com.upuphone.ar.tici.phone.listener.SystemFileItemListener;
import com.upuphone.xr.sapp.common.R;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J \u0010\u0013\u001a\u00020\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/tici/phone/epoxy/SystemFileController;", "Lcom/airbnb/epoxy/EpoxyController;", "listener", "Lcom/upuphone/ar/tici/phone/listener/SystemFileItemListener;", "(Lcom/upuphone/ar/tici/phone/listener/SystemFileItemListener;)V", "dataList", "", "", "", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "value", "", "supportLargeFile", "getSupportLargeFile", "()Z", "setSupportLargeFile", "(Z)V", "buildModels", "", "refreshData", "data", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSystemFileController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemFileController.kt\ncom/upuphone/ar/tici/phone/epoxy/SystemFileController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 EpoxyProcessorKotlinExtensions.kt\ncom/upuphone/ar/tici/phone/epoxy/EpoxyProcessorKotlinExtensionsKt\n*L\n1#1,73:1\n1864#2,2:74\n1864#2,2:82\n1866#2:90\n1866#2:91\n18#3,6:76\n10#3,6:84\n*S KotlinDebug\n*F\n+ 1 SystemFileController.kt\ncom/upuphone/ar/tici/phone/epoxy/SystemFileController\n*L\n22#1:74,2\n28#1:82,2\n28#1:90\n22#1:91\n23#1:76,6\n46#1:84,6\n*E\n"})
public final class SystemFileController extends EpoxyController {
    @Nullable
    private Map<String, ? extends List<SystemFileInfo>> dataList;
    @NotNull
    private final SystemFileItemListener listener;
    private boolean supportLargeFile = TiciApp.b.l();

    public SystemFileController(@NotNull SystemFileItemListener systemFileItemListener) {
        Intrinsics.checkNotNullParameter(systemFileItemListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = systemFileItemListener;
    }

    public void buildModels() {
        Map<String, ? extends List<SystemFileInfo>> map = this.dataList;
        if (map != null) {
            int i = 0;
            for (T next : map.entrySet()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map.Entry entry = (Map.Entry) next;
                TiciDateModel_ ticiDateModel_ = new TiciDateModel_();
                ticiDateModel_.a("ticiDate_" + entry.getKey());
                ticiDateModel_.f((String) entry.getKey());
                ticiDateModel_.l(i == 0);
                add(ticiDateModel_);
                int i3 = 0;
                for (Object next2 : (Iterable) entry.getValue()) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SystemFileInfo systemFileInfo = (SystemFileInfo) next2;
                    int i5 = ((List) entry.getValue()).size() == 1 ? R.drawable.card_item_full_round_selector : i3 == 0 ? R.drawable.card_item_top_round_selector : i3 == ((List) entry.getValue()).size() - 1 ? R.drawable.card_item_bottom_round_selector : R.drawable.card_item_middle_rectangle_selector;
                    SystemFileModel_ systemFileModel_ = new SystemFileModel_();
                    systemFileModel_.a("systemFile" + systemFileInfo.getPath());
                    systemFileModel_.o(systemFileInfo);
                    systemFileModel_.b(i5);
                    systemFileModel_.h(this.supportLargeFile);
                    systemFileModel_.e(this.listener);
                    add(systemFileModel_);
                    i3 = i4;
                }
                i = i2;
            }
        }
    }

    public final boolean getSupportLargeFile() {
        return this.supportLargeFile;
    }

    public final void refreshData(@NotNull Map<String, ? extends List<SystemFileInfo>> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        if (hasPendingModelBuild()) {
            cancelPendingModelBuild();
        }
        this.dataList = map;
        requestModelBuild();
    }

    public final void setSupportLargeFile(boolean z) {
        if (hasPendingModelBuild()) {
            cancelPendingModelBuild();
        }
        this.supportLargeFile = z;
        requestModelBuild();
    }
}
