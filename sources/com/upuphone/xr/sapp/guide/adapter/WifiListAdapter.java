package com.upuphone.xr.sapp.guide.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.j8.g;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.WifiAutoSwitchItemLayoutBinding;
import com.upuphone.xr.sapp.databinding.WifiEmptyBinding;
import com.upuphone.xr.sapp.databinding.WifiItemBottomConnectLayoutBinding;
import com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding;
import com.upuphone.xr.sapp.databinding.WifiItemTopPairdLayoutBinding;
import com.upuphone.xr.sapp.databinding.WifiItemTopUnpairdLayoutBinding;
import com.upuphone.xr.sapp.databinding.WifiLoadingBinding;
import com.upuphone.xr.sapp.databinding.WifiSwitchItemLayoutBinding;
import com.upuphone.xr.sapp.guide.model.WifiInfoModel;
import com.upuphone.xr.sapp.guide.model.WifiResultModel;
import com.upuphone.xr.sapp.guide.wifi.utils.CustomLinearLayoutManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nWifiListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WifiListAdapter.kt\ncom/upuphone/xr/sapp/guide/adapter/WifiListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,872:1\n1864#2,3:873\n1855#2,2:876\n1864#2,3:878\n1864#2,3:881\n1864#2,3:884\n1855#2,2:887\n1864#2,3:889\n1855#2,2:892\n1864#2,3:894\n1864#2,3:897\n256#3,2:900\n256#3,2:902\n256#3,2:904\n256#3,2:906\n256#3,2:908\n256#3,2:910\n256#3,2:912\n256#3,2:914\n256#3,2:916\n256#3,2:918\n256#3,2:920\n256#3,2:922\n256#3,2:924\n256#3,2:926\n256#3,2:928\n256#3,2:930\n256#3,2:932\n256#3,2:934\n256#3,2:936\n256#3,2:938\n256#3,2:940\n256#3,2:942\n256#3,2:944\n256#3,2:946\n256#3,2:948\n256#3,2:950\n256#3,2:952\n256#3,2:954\n256#3,2:956\n256#3,2:958\n256#3,2:960\n256#3,2:962\n256#3,2:964\n256#3,2:966\n256#3,2:968\n256#3,2:970\n256#3,2:972\n256#3,2:974\n256#3,2:976\n256#3,2:978\n256#3,2:980\n256#3,2:982\n256#3,2:984\n256#3,2:986\n256#3,2:988\n*S KotlinDebug\n*F\n+ 1 WifiListAdapter.kt\ncom/upuphone/xr/sapp/guide/adapter/WifiListAdapter\n*L\n159#1:873,3\n173#1:876,2\n239#1:878,3\n276#1:881,3\n321#1:884,3\n354#1:887,2\n368#1:889,3\n390#1:892,2\n403#1:894,3\n427#1:897,3\n573#1:900,2\n576#1:902,2\n577#1:904,2\n578#1:906,2\n579#1:908,2\n583#1:910,2\n584#1:912,2\n585#1:914,2\n586#1:916,2\n590#1:918,2\n591#1:920,2\n592#1:922,2\n593#1:924,2\n597#1:926,2\n598#1:928,2\n599#1:930,2\n600#1:932,2\n604#1:934,2\n606#1:936,2\n613#1:938,2\n614#1:940,2\n616#1:942,2\n637#1:944,2\n640#1:946,2\n641#1:948,2\n642#1:950,2\n643#1:952,2\n647#1:954,2\n648#1:956,2\n649#1:958,2\n650#1:960,2\n654#1:962,2\n655#1:964,2\n656#1:966,2\n657#1:968,2\n661#1:970,2\n662#1:972,2\n663#1:974,2\n664#1:976,2\n670#1:978,2\n672#1:980,2\n690#1:982,2\n691#1:984,2\n694#1:986,2\n754#1:988,2\n*E\n"})
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0016\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u0001:\fabcdefghijklB'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\r*\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0019\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u000fJ\u001d\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010$\u001a\u00020\r2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\"¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\"¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\"¢\u0006\u0004\b+\u0010*J-\u00100\u001a\u00020\r2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\"¢\u0006\u0004\b0\u00101J\u0015\u00103\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0010¢\u0006\u0004\b3\u00104J\u001d\u00105\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0010¢\u0006\u0004\b5\u00106J\u0015\u00109\u001a\u00020\r2\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\u00020\r2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\r2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b=\u0010<J\u0015\u0010>\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\"¢\u0006\u0004\b@\u0010*J\r\u0010A\u001a\u00020\"¢\u0006\u0004\bA\u0010*J\u001f\u0010E\u001a\u00020\u00022\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020\u0010H\u0016¢\u0006\u0004\bE\u0010FJ\u001f\u0010H\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0010H\u0017¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0010H\u0016¢\u0006\u0004\bJ\u0010\u0012J\u0017\u0010K\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\bK\u0010LR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00170W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010\\¨\u0006m"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/guide/wifi/utils/CustomLinearLayoutManager;", "manger", "Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$IWifiListClickCallback;", "callback", "Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$ISwitchCallback;", "switchCallback", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "wifiAutoSwitchCallback", "<init>", "(Lcom/upuphone/xr/sapp/guide/wifi/utils/CustomLinearLayoutManager;Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$IWifiListClickCallback;Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$ISwitchCallback;Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "", "E", "()V", "", "w", "()I", "Landroid/view/View;", "q", "(Landroid/view/View;)V", "", "Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;", "list", "setData", "(Ljava/util/List;)V", "G", "position", "wifiState", "L", "(II)V", "", "ssid", "", "wifiInvalidState", "J", "(Ljava/lang/String;Z)V", "refresh", "H", "(Z)V", "u", "()Z", "t", "checked", "itemType", "index", "needNotify", "I", "(ZIIZ)V", "touchedIndex", "F", "(I)V", "v", "(II)Z", "Lcom/upuphone/xr/sapp/guide/model/WifiResultModel;", "wifiInfo", "n", "(Lcom/upuphone/xr/sapp/guide/model/WifiResultModel;)V", "p", "(Ljava/lang/String;)V", "K", "s", "(Ljava/lang/String;)I", "x", "o", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemCount", "getItemViewType", "(I)I", "a", "Lcom/upuphone/xr/sapp/guide/wifi/utils/CustomLinearLayoutManager;", "b", "Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$IWifiListClickCallback;", "getCallback", "()Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$IWifiListClickCallback;", "c", "Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$ISwitchCallback;", "d", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "e", "Ljava/util/List;", "mWifiList", "f", "Z", "mRefreshState", "g", "mConnectState", "h", "Companion", "ISwitchCallback", "IWifiListClickCallback", "LoadingHolder", "PairTopHolder", "PairWifiContentHolder", "UnPairedWifiHolder", "UnpairBottomHolder", "UnpairTopHolder", "WifiAutoSwitchHolder", "WifiEmptyHolder", "WifiSwitchHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WifiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public static int i = StaticMethodUtilsKt.h(73.0f);

    /* renamed from: a  reason: collision with root package name */
    public final CustomLinearLayoutManager f7082a;
    public final IWifiListClickCallback b;
    public final ISwitchCallback c;
    public final CompoundButton.OnCheckedChangeListener d;
    public List e = new ArrayList();
    public boolean f;
    public boolean g;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$Companion;", "", "()V", "ACTION_CONNECT", "", "ACTION_IGNORE", "ACTION_RESEARCH", "DEVICE_STATE_CONNECT", "", "DEVICE_STATE_DEFAULT", "DEVICE_STATE_PAIRING", "DEVICE_STATE_SAVE", "EMPTY_LIST", "LOADING", "MAX_MOVE_DISTANCE", "MOVE_STEP", "PAIRED_CONTENT", "PAIRED_TITLE", "TAG", "UNPAIRED_BOTTOM", "UNPAIRED_CONTENT", "UNPAIRED_TITLE", "VALID_MOVE_DISTANCE", "WIFI_AUTO_SWITCH", "WIFI_AUTO_SWITCH_INDEX", "WIFI_SWITCH", "WIFI_SWITCH_INDEX", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$ISwitchCallback;", "", "", "state", "", "a", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface ISwitchCallback {
        void a(boolean z);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$IWifiListClickCallback;", "", "wifiClickCallback", "", "action", "", "position", "", "info", "Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;", "refresh", "", "connect", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface IWifiListClickCallback {
        void wifiClickCallback(String str, int i, WifiInfoModel wifiInfoModel, boolean z, boolean z2);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$LoadingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiLoadingBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiLoadingBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiLoadingBinding;", "getBinding", "()Lcom/upuphone/xr/sapp/databinding/WifiLoadingBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class LoadingHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiLoadingBinding f7083a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadingHolder(WifiListAdapter wifiListAdapter, WifiLoadingBinding wifiLoadingBinding) {
            super(wifiLoadingBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiLoadingBinding, "binding");
            this.b = wifiListAdapter;
            this.f7083a = wifiLoadingBinding;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$PairTopHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiItemTopPairdLayoutBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiItemTopPairdLayoutBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiItemTopPairdLayoutBinding;", "()Lcom/upuphone/xr/sapp/databinding/WifiItemTopPairdLayoutBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class PairTopHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiItemTopPairdLayoutBinding f7084a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PairTopHolder(WifiListAdapter wifiListAdapter, WifiItemTopPairdLayoutBinding wifiItemTopPairdLayoutBinding) {
            super(wifiItemTopPairdLayoutBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiItemTopPairdLayoutBinding, "binding");
            this.b = wifiListAdapter;
            this.f7084a = wifiItemTopPairdLayoutBinding;
        }

        public final WifiItemTopPairdLayoutBinding a() {
            return this.f7084a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$PairWifiContentHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiItemLayoutBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiItemLayoutBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiItemLayoutBinding;", "()Lcom/upuphone/xr/sapp/databinding/WifiItemLayoutBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class PairWifiContentHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiItemLayoutBinding f7085a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PairWifiContentHolder(WifiListAdapter wifiListAdapter, WifiItemLayoutBinding wifiItemLayoutBinding) {
            super(wifiItemLayoutBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiItemLayoutBinding, "binding");
            this.b = wifiListAdapter;
            this.f7085a = wifiItemLayoutBinding;
        }

        public final WifiItemLayoutBinding a() {
            return this.f7085a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$UnPairedWifiHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiItemLayoutBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiItemLayoutBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiItemLayoutBinding;", "()Lcom/upuphone/xr/sapp/databinding/WifiItemLayoutBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class UnPairedWifiHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiItemLayoutBinding f7086a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnPairedWifiHolder(WifiListAdapter wifiListAdapter, WifiItemLayoutBinding wifiItemLayoutBinding) {
            super(wifiItemLayoutBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiItemLayoutBinding, "binding");
            this.b = wifiListAdapter;
            this.f7086a = wifiItemLayoutBinding;
        }

        public final WifiItemLayoutBinding a() {
            return this.f7086a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$UnpairBottomHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiItemBottomConnectLayoutBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiItemBottomConnectLayoutBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiItemBottomConnectLayoutBinding;", "getBinding", "()Lcom/upuphone/xr/sapp/databinding/WifiItemBottomConnectLayoutBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class UnpairBottomHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiItemBottomConnectLayoutBinding f7087a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnpairBottomHolder(WifiListAdapter wifiListAdapter, WifiItemBottomConnectLayoutBinding wifiItemBottomConnectLayoutBinding) {
            super(wifiItemBottomConnectLayoutBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiItemBottomConnectLayoutBinding, "binding");
            this.b = wifiListAdapter;
            this.f7087a = wifiItemBottomConnectLayoutBinding;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$UnpairTopHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiItemTopUnpairdLayoutBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiItemTopUnpairdLayoutBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiItemTopUnpairdLayoutBinding;", "()Lcom/upuphone/xr/sapp/databinding/WifiItemTopUnpairdLayoutBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class UnpairTopHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiItemTopUnpairdLayoutBinding f7088a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnpairTopHolder(WifiListAdapter wifiListAdapter, WifiItemTopUnpairdLayoutBinding wifiItemTopUnpairdLayoutBinding) {
            super(wifiItemTopUnpairdLayoutBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiItemTopUnpairdLayoutBinding, "binding");
            this.b = wifiListAdapter;
            this.f7088a = wifiItemTopUnpairdLayoutBinding;
        }

        public final WifiItemTopUnpairdLayoutBinding a() {
            return this.f7088a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$WifiAutoSwitchHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiAutoSwitchItemLayoutBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiAutoSwitchItemLayoutBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiAutoSwitchItemLayoutBinding;", "()Lcom/upuphone/xr/sapp/databinding/WifiAutoSwitchItemLayoutBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class WifiAutoSwitchHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiAutoSwitchItemLayoutBinding f7089a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WifiAutoSwitchHolder(WifiListAdapter wifiListAdapter, WifiAutoSwitchItemLayoutBinding wifiAutoSwitchItemLayoutBinding) {
            super(wifiAutoSwitchItemLayoutBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiAutoSwitchItemLayoutBinding, "binding");
            this.b = wifiListAdapter;
            this.f7089a = wifiAutoSwitchItemLayoutBinding;
        }

        public final WifiAutoSwitchItemLayoutBinding a() {
            return this.f7089a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$WifiEmptyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiEmptyBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiEmptyBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiEmptyBinding;", "()Lcom/upuphone/xr/sapp/databinding/WifiEmptyBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class WifiEmptyHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiEmptyBinding f7090a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WifiEmptyHolder(WifiListAdapter wifiListAdapter, WifiEmptyBinding wifiEmptyBinding) {
            super(wifiEmptyBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiEmptyBinding, "binding");
            this.b = wifiListAdapter;
            this.f7090a = wifiEmptyBinding;
        }

        public final WifiEmptyBinding a() {
            return this.f7090a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$WifiSwitchHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/WifiSwitchItemLayoutBinding;", "binding", "<init>", "(Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;Lcom/upuphone/xr/sapp/databinding/WifiSwitchItemLayoutBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/WifiSwitchItemLayoutBinding;", "()Lcom/upuphone/xr/sapp/databinding/WifiSwitchItemLayoutBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class WifiSwitchHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final WifiSwitchItemLayoutBinding f7091a;
        public final /* synthetic */ WifiListAdapter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WifiSwitchHolder(WifiListAdapter wifiListAdapter, WifiSwitchItemLayoutBinding wifiSwitchItemLayoutBinding) {
            super(wifiSwitchItemLayoutBinding.getRoot());
            Intrinsics.checkNotNullParameter(wifiSwitchItemLayoutBinding, "binding");
            this.b = wifiListAdapter;
            this.f7091a = wifiSwitchItemLayoutBinding;
        }

        public final WifiSwitchItemLayoutBinding a() {
            return this.f7091a;
        }
    }

    public WifiListAdapter(CustomLinearLayoutManager customLinearLayoutManager, IWifiListClickCallback iWifiListClickCallback, ISwitchCallback iSwitchCallback, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(customLinearLayoutManager, "manger");
        Intrinsics.checkNotNullParameter(iWifiListClickCallback, "callback");
        Intrinsics.checkNotNullParameter(iSwitchCallback, "switchCallback");
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, "wifiAutoSwitchCallback");
        this.f7082a = customLinearLayoutManager;
        this.b = iWifiListClickCallback;
        this.c = iSwitchCallback;
        this.d = onCheckedChangeListener;
    }

    public static final void A(WifiListAdapter wifiListAdapter, int i2, View view) {
        Intrinsics.checkNotNullParameter(wifiListAdapter, "this$0");
        wifiListAdapter.b.wifiClickCallback("connect", i2, (WifiInfoModel) wifiListAdapter.e.get(i2), wifiListAdapter.f, wifiListAdapter.g);
    }

    public static final void B(WifiListAdapter wifiListAdapter, int i2, View view) {
        Intrinsics.checkNotNullParameter(wifiListAdapter, "this$0");
        wifiListAdapter.b.wifiClickCallback("connect", i2, (WifiInfoModel) wifiListAdapter.e.get(i2), wifiListAdapter.f, wifiListAdapter.g);
    }

    public static final boolean C(WifiListAdapter wifiListAdapter, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.IntRef intRef, PairWifiContentHolder pairWifiContentHolder, int i2, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(wifiListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(floatRef, "$moveXStart");
        Intrinsics.checkNotNullParameter(floatRef2, "$move");
        Intrinsics.checkNotNullParameter(intRef, "$scrollX");
        Intrinsics.checkNotNullParameter(pairWifiContentHolder, "$content");
        int action = motionEvent.getAction();
        if (action == 0) {
            wifiListAdapter.f7082a.a(false);
            floatRef.element = motionEvent.getX();
        } else if (action == 1) {
            ULog.Delegate delegate = ULog.f6446a;
            float f2 = floatRef2.element;
            int i3 = intRef.element;
            int wifiState = ((WifiInfoModel) wifiListAdapter.e.get(i2)).getWifiState();
            delegate.a("WifiListAdapter", "ACTION_UP:move is: " + f2 + " and scrollX is: " + i3 + " mWifiList[position].wifiState is: " + wifiState);
            wifiListAdapter.f7082a.a(true);
            float f3 = floatRef2.element;
            if (f3 > 0.0f) {
                ((WifiInfoModel) wifiListAdapter.e.get(i2)).setDelete(true);
                pairWifiContentHolder.a().n.scrollTo(i, 0);
                ((WifiInfoModel) wifiListAdapter.e.get(i2)).setIgnoreShow(true);
            } else if (f3 <= 0.0f) {
                ((WifiInfoModel) wifiListAdapter.e.get(i2)).setDelete(false);
                pairWifiContentHolder.a().n.scrollTo(0, 0);
                ((WifiInfoModel) wifiListAdapter.e.get(i2)).setIgnoreShow(false);
                if (floatRef2.element == 0.0f || intRef.element == 0) {
                    view.performClick();
                }
            }
        } else if (action == 2) {
            floatRef2.element = floatRef.element - motionEvent.getX();
            int scrollX = pairWifiContentHolder.a().n.getScrollX();
            intRef.element = scrollX;
            if (scrollX <= i && StrictMath.abs(floatRef2.element) > 1.0f) {
                if (floatRef2.element > 0.0f) {
                    if (intRef.element + 15 > i) {
                        pairWifiContentHolder.a().n.setScrollX(i);
                    } else {
                        pairWifiContentHolder.a().n.setScrollX(intRef.element + 15);
                    }
                } else if (intRef.element - 15 < 0) {
                    pairWifiContentHolder.a().n.setScrollX(0);
                } else {
                    pairWifiContentHolder.a().n.setScrollX(intRef.element - 15);
                }
                intRef.element = pairWifiContentHolder.a().n.getScrollX();
            }
            floatRef.element = motionEvent.getX();
        }
        return true;
    }

    public static final void D(PairWifiContentHolder pairWifiContentHolder, WifiListAdapter wifiListAdapter, int i2, View view) {
        Intrinsics.checkNotNullParameter(pairWifiContentHolder, "$content");
        Intrinsics.checkNotNullParameter(wifiListAdapter, "this$0");
        pairWifiContentHolder.a().e.setVisibility(4);
        ProgressBar progressBar = pairWifiContentHolder.a().d;
        Intrinsics.checkNotNullExpressionValue(progressBar, "ignoreWifiPb");
        progressBar.setVisibility(0);
        wifiListAdapter.b.wifiClickCallback("ignore", i2, (WifiInfoModel) wifiListAdapter.e.get(i2), wifiListAdapter.f, wifiListAdapter.g);
    }

    public static final void r(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$this_dismissIgnore");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        view.scrollTo(((Integer) animatedValue).intValue(), 0);
    }

    public static final void y(WifiListAdapter wifiListAdapter, int i2, View view) {
        Intrinsics.checkNotNullParameter(wifiListAdapter, "this$0");
        wifiListAdapter.b.wifiClickCallback("action_research", i2, (WifiInfoModel) wifiListAdapter.e.get(i2), false, false);
    }

    public static final void z(WifiSwitchHolder wifiSwitchHolder, WifiListAdapter wifiListAdapter, View view) {
        Intrinsics.checkNotNullParameter(wifiSwitchHolder, "$content");
        Intrinsics.checkNotNullParameter(wifiListAdapter, "this$0");
        wifiListAdapter.c.a(wifiSwitchHolder.a().b.getBinding().i.isChecked());
    }

    public final void E() {
        int i2 = -1;
        int i3 = 0;
        for (Object next : this.e) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((WifiInfoModel) next).isPhoneConnectWifi()) {
                i2 = i3;
            }
            i3 = i4;
        }
        if (i2 >= 0) {
            WifiInfoModel wifiInfoModel = (WifiInfoModel) this.e.get(i2);
            this.e.remove(i2);
            if (this.e.size() >= 2 && wifiInfoModel.getItemType() == 3 && ((WifiInfoModel) this.e.get(2)).getItemType() == 0) {
                int w = w();
                if (w >= 0) {
                    this.e.add(w + 1, wifiInfoModel);
                    return;
                }
                return;
            }
            this.e.add(3, wifiInfoModel);
        }
    }

    public final void F(int i2) {
        int i3 = 0;
        for (Object next : this.e) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            WifiInfoModel wifiInfoModel = (WifiInfoModel) next;
            if (wifiInfoModel.getIgnoreShow() && i2 != i3) {
                wifiInfoModel.setIgnoreShow(false);
                notifyItemChanged(i3);
            }
            i3 = i4;
        }
    }

    public final void G() {
        this.e.clear();
        boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "is_wifi_enable", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WifiListAdapter", "wifiState is: " + booleanValue + " and autoConnect is: " + false + " ");
        WifiInfoModel wifiInfoModel = r2;
        WifiInfoModel wifiInfoModel2 = new WifiInfoModel("", "", 0, 6, false, false, false, false, booleanValue, true, false, false, false, 7408, (DefaultConstructorMarker) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(wifiInfoModel);
        if (booleanValue) {
            arrayList.add(new WifiInfoModel("", "", 0, 7, false, false, false, false, false, false, false, false, false, 6896, (DefaultConstructorMarker) null));
            arrayList.add(new WifiInfoModel("", "", 0, 5, false, false, false, false, false, false, false, false, false, 8176, (DefaultConstructorMarker) null));
        }
        this.g = false;
        this.e.addAll(arrayList);
        H(true);
        notifyDataSetChanged();
    }

    public final void H(boolean z) {
        this.g = false;
        this.f = z;
        for (WifiInfoModel wifiInfoModel : this.e) {
            if (wifiInfoModel.getItemType() == 2 || wifiInfoModel.getItemType() == 0) {
                wifiInfoModel.setRefreshState(z);
            }
        }
        if (z) {
            this.f7082a.a(false);
        } else {
            this.f7082a.a(true);
        }
    }

    public final void I(boolean z, int i2, int i3, boolean z2) {
        if (this.e.size() > 0 && ((WifiInfoModel) this.e.get(i3)).getItemType() == i2) {
            ((WifiInfoModel) this.e.get(i3)).setCheckedState(z);
            if (z2) {
                notifyItemChanged(i3);
            }
        }
    }

    public final void J(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        int i2 = 0;
        for (Object next : this.e) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual((Object) ((WifiInfoModel) next).getSSid(), (Object) str) && ((WifiInfoModel) this.e.get(i2)).getWifiInValid() != z) {
                ((WifiInfoModel) this.e.get(i2)).setWifiInValid(z);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    public final void K(String str) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        this.g = false;
        for (WifiInfoModel wifiInfoModel : this.e) {
            if (str.length() == 0) {
                wifiInfoModel.setPhoneConnectWifi(false);
            } else {
                wifiInfoModel.setPhoneConnectWifi(Intrinsics.areEqual((Object) wifiInfoModel.getSSid(), (Object) str));
            }
        }
        notifyDataSetChanged();
    }

    public final void L(int i2, int i3) {
        if (i2 >= 0) {
            this.g = i3 == 3;
            ((WifiInfoModel) this.e.get(i2)).setWifiState(i3);
            notifyItemChanged(i2);
        }
    }

    public int getItemCount() {
        return this.e.size();
    }

    public int getItemViewType(int i2) {
        return ((WifiInfoModel) this.e.get(i2)).getItemType();
    }

    public final void n(WifiResultModel wifiResultModel) {
        WifiResultModel wifiResultModel2 = wifiResultModel;
        Intrinsics.checkNotNullParameter(wifiResultModel2, "wifiInfo");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WifiListAdapter", "addItem::wifiInfo is: " + wifiResultModel2);
        this.g = false;
        if (this.e.size() >= 2 && ((WifiInfoModel) this.e.get(2)).getItemType() == 2) {
            List list = this.e;
            WifiInfoModel wifiInfoModel = r6;
            WifiInfoModel wifiInfoModel2 = new WifiInfoModel("", "", 0, 0, false, false, false, false, false, false, false, false, false, 8176, (DefaultConstructorMarker) null);
            list.add(2, wifiInfoModel);
        }
        int i2 = -1;
        String str = "-1";
        int i3 = 0;
        boolean z = false;
        for (Object next : this.e) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            WifiInfoModel wifiInfoModel3 = (WifiInfoModel) next;
            ULog.Delegate delegate2 = ULog.f6446a;
            String bSsid = wifiInfoModel3.getBSsid();
            delegate2.a("WifiListAdapter", "addItem::wifiInfoModel.bSsid is: " + bSsid);
            if (StringsKt.contains$default((CharSequence) wifiInfoModel3.getBSsid(), (CharSequence) wifiResultModel.getMBssid(), false, 2, (Object) null) || Intrinsics.areEqual((Object) wifiInfoModel3.getSSid(), (Object) wifiResultModel.getMSsid())) {
                z = wifiInfoModel3.getNeedPassword();
                i2 = i3;
            }
            if (wifiInfoModel3.getWifiState() == 2) {
                wifiInfoModel3.setWifiState(1);
            }
            if (wifiInfoModel3.isPhoneConnectWifi()) {
                str = wifiInfoModel3.getSSid();
            }
            if (wifiInfoModel3.getItemType() == 7) {
                ((WifiInfoModel) this.e.get(i3)).setCheckedState(((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "wifi_auto_connect", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue());
            }
            i3 = i4;
        }
        if (i2 >= 0) {
            this.e.remove(i2);
        }
        ULog.Delegate delegate3 = ULog.f6446a;
        delegate3.a("WifiListAdapter", "addItem::changeIndex is: " + i2);
        this.e.add(3, new WifiInfoModel(wifiResultModel.getMSsid(), wifiResultModel.getMBssid(), 2, 1, z, false, Intrinsics.areEqual((Object) str, (Object) wifiResultModel.getMSsid()), false, false, false, false, false, false, HttpPostBodyUtil.chunkSize, (DefaultConstructorMarker) null));
        H(true);
        E();
        notifyDataSetChanged();
    }

    public final boolean o() {
        for (WifiInfoModel wifiInfoModel : this.e) {
            if (wifiInfoModel.getWifiState() == 2 && wifiInfoModel.isPhoneConnectWifi()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x05f2 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x05f4 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0607 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0631 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0634 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0651 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0653 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x068b A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x068e A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0692 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0694 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x06b8 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x06ba A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x05ca A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x05cc A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x05cf A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x05d1 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x05ed A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x05ef A[Catch:{ Exception -> 0x0069 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r22, int r23) {
        /*
            r21 = this;
            r8 = r21
            r1 = r22
            r9 = r23
            java.lang.String r2 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            int r2 = r22.getItemViewType()     // Catch:{ Exception -> 0x0069 }
            if (r2 == 0) goto L_0x0713
            java.lang.String r7 = "wifiPhoneConnect"
            java.lang.String r10 = "wifiNameSub"
            java.lang.String r11 = "wifiNameSubInvalid"
            java.lang.String r12 = "wifiConnectEd"
            java.lang.String r13 = "connectingLoading"
            java.lang.String r14 = "ignoreWifiPb"
            java.lang.String r4 = "wifiBottom"
            java.lang.String r5 = "wifiBottomNormal"
            java.lang.String r6 = "wifiTopNormal"
            java.lang.String r15 = "wifiTop"
            r3 = 1
            r19 = r7
            r7 = 8
            if (r2 == r3) goto L_0x03d3
            r3 = 2
            if (r2 == r3) goto L_0x039c
            r3 = 3
            if (r2 == r3) goto L_0x0145
            r3 = 6
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r2 == r3) goto L_0x00c9
            r3 = 7
            if (r2 == r3) goto L_0x006d
            if (r2 == r7) goto L_0x0046
            goto L_0x0765
        L_0x0046:
            com.upuphone.xr.sapp.guide.adapter.WifiListAdapter$WifiEmptyHolder r1 = (com.upuphone.xr.sapp.guide.adapter.WifiListAdapter.WifiEmptyHolder) r1     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiEmptyBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "researchTv"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.K(r2, r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiEmptyBinding r1 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.getRoot()     // Catch:{ Exception -> 0x0069 }
            com.honey.account.j8.a r2 = new com.honey.account.j8.a     // Catch:{ Exception -> 0x0069 }
            r2.<init>(r8, r9)     // Catch:{ Exception -> 0x0069 }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0765
        L_0x0069:
            r0 = move-exception
            r1 = r0
            goto L_0x0749
        L_0x006d:
            com.upuphone.xr.sapp.guide.adapter.WifiListAdapter$WifiAutoSwitchHolder r1 = (com.upuphone.xr.sapp.guide.adapter.WifiListAdapter.WifiAutoSwitchHolder) r1     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiAutoSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setSwitchListener(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiAutoSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            boolean r3 = r3.getCheckedState()     // Catch:{ Exception -> 0x0069 }
            r2.setSwitchState(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiAutoSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r2 = r2.getBinding()     // Catch:{ Exception -> 0x0069 }
            com.meizu.common.widget.Switch r2 = r2.i     // Catch:{ Exception -> 0x0069 }
            r2.setAlpha(r4)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiAutoSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.getRoot()     // Catch:{ Exception -> 0x0069 }
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            boolean r3 = r3.getCheckedVisible()     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x00b9
            r6 = -2
            goto L_0x00ba
        L_0x00b9:
            r6 = 0
        L_0x00ba:
            r2.height = r6     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiAutoSwitchItemLayoutBinding r1 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.b     // Catch:{ Exception -> 0x0069 }
            android.widget.CompoundButton$OnCheckedChangeListener r2 = r8.d     // Catch:{ Exception -> 0x0069 }
            r1.setSwitchListener(r2)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0765
        L_0x00c9:
            com.upuphone.xr.sapp.guide.adapter.WifiListAdapter$WifiSwitchHolder r1 = (com.upuphone.xr.sapp.guide.adapter.WifiListAdapter.WifiSwitchHolder) r1     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setSwitchListener(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            boolean r3 = r3.getCheckedState()     // Catch:{ Exception -> 0x0069 }
            r2.setSwitchState(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r2 = r2.getBinding()     // Catch:{ Exception -> 0x0069 }
            com.meizu.common.widget.Switch r2 = r2.i     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            boolean r3 = r3.getCheckedEnable()     // Catch:{ Exception -> 0x0069 }
            r2.setEnabled(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r2 = r2.getBinding()     // Catch:{ Exception -> 0x0069 }
            com.meizu.common.widget.Switch r2 = r2.i     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            boolean r3 = r3.getCheckedEnable()     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x0120
            goto L_0x0122
        L_0x0120:
            r4 = 1048576000(0x3e800000, float:0.25)
        L_0x0122:
            r2.setAlpha(r4)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r2 = r2.getBinding()     // Catch:{ Exception -> 0x0069 }
            com.meizu.common.widget.Switch r2 = r2.i     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setClickable(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiSwitchItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.view.CardItemView r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            com.honey.account.j8.b r3 = new com.honey.account.j8.b     // Catch:{ Exception -> 0x0069 }
            r3.<init>(r1, r8)     // Catch:{ Exception -> 0x0069 }
            r2.setOnClickListener(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0765
        L_0x0145:
            com.upuphone.xr.sapp.guide.adapter.WifiListAdapter$UnPairedWifiHolder r1 = (com.upuphone.xr.sapp.guide.adapter.WifiListAdapter.UnPairedWifiHolder) r1     // Catch:{ Exception -> 0x0069 }
            java.util.List r2 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r2 = r2.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r2 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r2     // Catch:{ Exception -> 0x0069 }
            boolean r2 = r2.isDelete()     // Catch:{ Exception -> 0x0069 }
            if (r2 != 0) goto L_0x0174
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.n     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.scrollTo(r3, r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r2 = r2.e     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ProgressBar r2 = r2.d     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
        L_0x0174:
            java.util.List r2 = r8.e     // Catch:{ Exception -> 0x0069 }
            int r3 = r9 + -1
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r2 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r2     // Catch:{ Exception -> 0x0069 }
            int r2 = r2.getItemType()     // Catch:{ Exception -> 0x0069 }
            r14 = 2
            if (r2 != r14) goto L_0x01d5
            java.util.List r2 = r8.e     // Catch:{ Exception -> 0x0069 }
            int r14 = r9 + 1
            java.lang.Object r2 = r2.get(r14)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r2 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r2     // Catch:{ Exception -> 0x0069 }
            int r2 = r2.getItemType()     // Catch:{ Exception -> 0x0069 }
            r14 = 3
            if (r2 != r14) goto L_0x01d5
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.t     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.u     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.l     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.k     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r2 = r2.c     // Catch:{ Exception -> 0x0069 }
            int r3 = com.upuphone.xr.sapp.R.drawable.bg_wifi_ignore_top     // Catch:{ Exception -> 0x0069 }
            r2.setBackgroundResource(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x02e1
        L_0x01d5:
            java.util.List r2 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r2 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r2     // Catch:{ Exception -> 0x0069 }
            int r2 = r2.getItemType()     // Catch:{ Exception -> 0x0069 }
            r14 = 3
            if (r2 != r14) goto L_0x0234
            java.util.List r2 = r8.e     // Catch:{ Exception -> 0x0069 }
            int r14 = r9 + 1
            java.lang.Object r2 = r2.get(r14)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r2 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r2     // Catch:{ Exception -> 0x0069 }
            int r2 = r2.getItemType()     // Catch:{ Exception -> 0x0069 }
            r14 = 4
            if (r2 != r14) goto L_0x0234
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.t     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.u     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.l     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.k     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r2 = r2.c     // Catch:{ Exception -> 0x0069 }
            int r3 = com.upuphone.xr.sapp.R.drawable.bg_wifi_ignore_bottom     // Catch:{ Exception -> 0x0069 }
            r2.setBackgroundResource(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x02e1
        L_0x0234:
            java.util.List r2 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r2 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r2     // Catch:{ Exception -> 0x0069 }
            int r2 = r2.getItemType()     // Catch:{ Exception -> 0x0069 }
            r3 = 2
            if (r2 != r3) goto L_0x029b
            java.util.List r2 = r8.e     // Catch:{ Exception -> 0x0069 }
            int r3 = r9 + 1
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r2 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r2     // Catch:{ Exception -> 0x0069 }
            int r2 = r2.getItemType()     // Catch:{ Exception -> 0x0069 }
            r3 = 4
            if (r2 != r3) goto L_0x029b
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.t     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.u     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.l     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.k     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.n     // Catch:{ Exception -> 0x0069 }
            r2.setPadding(r3, r3, r3, r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r2 = r2.c     // Catch:{ Exception -> 0x0069 }
            int r3 = com.upuphone.xr.sapp.R.drawable.bg_wifi_ignore_all     // Catch:{ Exception -> 0x0069 }
            r2.setBackgroundResource(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x02e1
        L_0x029b:
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.t     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.u     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.l     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.k     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.n     // Catch:{ Exception -> 0x0069 }
            r3 = 0
            r2.setPadding(r3, r3, r3, r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r2 = r2.c     // Catch:{ Exception -> 0x0069 }
            int r3 = com.upuphone.xr.sapp.R.drawable.bg_wifi_ignore_middle     // Catch:{ Exception -> 0x0069 }
            r2.setBackgroundResource(r3)     // Catch:{ Exception -> 0x0069 }
        L_0x02e1:
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.LinearLayout r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r13)     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            int r3 = r3.getWifiState()     // Catch:{ Exception -> 0x0069 }
            r4 = 3
            if (r3 != r4) goto L_0x02fc
            r20 = 1
            goto L_0x02fe
        L_0x02fc:
            r20 = 0
        L_0x02fe:
            if (r20 == 0) goto L_0x0302
            r3 = 0
            goto L_0x0303
        L_0x0302:
            r3 = r7
        L_0x0303:
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.m     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r12)     // Catch:{ Exception -> 0x0069 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r2 = r2.p     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = r3.getSSid()     // Catch:{ Exception -> 0x0069 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.getRoot()     // Catch:{ Exception -> 0x0069 }
            android.content.Context r2 = r2.getContext()     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            boolean r3 = r3.getNeedPassword()     // Catch:{ Exception -> 0x0069 }
            if (r3 != 0) goto L_0x0344
            int r3 = com.upuphone.xr.sapp.R.drawable.icon_wifi_unlock     // Catch:{ Exception -> 0x0069 }
            goto L_0x0346
        L_0x0344:
            int r3 = com.upuphone.xr.sapp.R.drawable.icon_wifi_lock     // Catch:{ Exception -> 0x0069 }
        L_0x0346:
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r2, r3)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r3 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r3 = r3.r     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r11)     // Catch:{ Exception -> 0x0069 }
            r3.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r3 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r3 = r3.q     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)     // Catch:{ Exception -> 0x0069 }
            r3.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r3 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r3 = r3.o     // Catch:{ Exception -> 0x0069 }
            r3.setImageDrawable(r2)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r2 = r2.s     // Catch:{ Exception -> 0x0069 }
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            boolean r3 = r3.isPhoneConnectWifi()     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x0386
            r6 = 0
            goto L_0x0387
        L_0x0386:
            r6 = r7
        L_0x0387:
            r2.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.getRoot()     // Catch:{ Exception -> 0x0069 }
            com.honey.account.j8.c r2 = new com.honey.account.j8.c     // Catch:{ Exception -> 0x0069 }
            r2.<init>(r8, r9)     // Catch:{ Exception -> 0x0069 }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0765
        L_0x039c:
            r3 = 4
            com.upuphone.xr.sapp.guide.adapter.WifiListAdapter$UnpairTopHolder r1 = (com.upuphone.xr.sapp.guide.adapter.WifiListAdapter.UnpairTopHolder) r1     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemTopUnpairdLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ProgressBar r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            java.util.List r4 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r4 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r4     // Catch:{ Exception -> 0x0069 }
            boolean r4 = r4.getRefreshState()     // Catch:{ Exception -> 0x0069 }
            if (r4 == 0) goto L_0x03b5
            r5 = 0
            goto L_0x03b6
        L_0x03b5:
            r5 = r3
        L_0x03b6:
            r2.setVisibility(r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemTopUnpairdLayoutBinding r1 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.getRoot()     // Catch:{ Exception -> 0x0069 }
            r2 = 1107296256(0x42000000, float:32.0)
            int r2 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.h(r2)     // Catch:{ Exception -> 0x0069 }
            r3 = 1094713344(0x41400000, float:12.0)
            int r3 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.h(r3)     // Catch:{ Exception -> 0x0069 }
            r4 = 0
            r1.setPadding(r4, r2, r4, r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0765
        L_0x03d3:
            r3 = r19
            kotlin.jvm.internal.Ref$FloatRef r16 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ Exception -> 0x0069 }
            r16.<init>()     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Ref$IntRef r17 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ Exception -> 0x0069 }
            r17.<init>()     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Ref$FloatRef r18 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ Exception -> 0x0069 }
            r18.<init>()     // Catch:{ Exception -> 0x0069 }
            r2 = r1
            com.upuphone.xr.sapp.guide.adapter.WifiListAdapter$PairWifiContentHolder r2 = (com.upuphone.xr.sapp.guide.adapter.WifiListAdapter.PairWifiContentHolder) r2     // Catch:{ Exception -> 0x0069 }
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            boolean r1 = r1.isDelete()     // Catch:{ Exception -> 0x0069 }
            if (r1 != 0) goto L_0x0416
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.n     // Catch:{ Exception -> 0x0069 }
            r7 = 0
            r1.scrollTo(r7, r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r1 = r1.e     // Catch:{ Exception -> 0x0069 }
            r1.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ProgressBar r1 = r1.d     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r14)     // Catch:{ Exception -> 0x0069 }
            r7 = 8
            r1.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
        L_0x0416:
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            int r7 = r9 + -1
            java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            int r1 = r1.getItemType()     // Catch:{ Exception -> 0x0069 }
            if (r1 != 0) goto L_0x047c
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            int r14 = r9 + 1
            java.lang.Object r1 = r1.get(r14)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            int r1 = r1.getItemType()     // Catch:{ Exception -> 0x0069 }
            r14 = 1
            if (r1 != r14) goto L_0x047c
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.t     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r15)     // Catch:{ Exception -> 0x0069 }
            r7 = 0
            r1.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.u     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)     // Catch:{ Exception -> 0x0069 }
            r6 = 8
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.l     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ Exception -> 0x0069 }
            r5 = 0
            r1.setVisibility(r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.k     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)     // Catch:{ Exception -> 0x0069 }
            r4 = 8
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r1 = r1.c     // Catch:{ Exception -> 0x0069 }
            int r4 = com.upuphone.xr.sapp.R.drawable.bg_wifi_ignore_top     // Catch:{ Exception -> 0x0069 }
            r1.setBackgroundResource(r4)     // Catch:{ Exception -> 0x0069 }
        L_0x0478:
            r4 = 8
            goto L_0x0591
        L_0x047c:
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            int r1 = r1.getItemType()     // Catch:{ Exception -> 0x0069 }
            r14 = 1
            if (r1 != r14) goto L_0x04de
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            int r14 = r9 + 1
            java.lang.Object r1 = r1.get(r14)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            int r1 = r1.getItemType()     // Catch:{ Exception -> 0x0069 }
            r14 = 2
            if (r1 != r14) goto L_0x04de
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.t     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r15)     // Catch:{ Exception -> 0x0069 }
            r7 = 8
            r1.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.u     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)     // Catch:{ Exception -> 0x0069 }
            r6 = 0
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.l     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ Exception -> 0x0069 }
            r5 = 8
            r1.setVisibility(r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.k     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)     // Catch:{ Exception -> 0x0069 }
            r4 = 0
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r1 = r1.c     // Catch:{ Exception -> 0x0069 }
            int r4 = com.upuphone.xr.sapp.R.drawable.bg_wifi_ignore_bottom     // Catch:{ Exception -> 0x0069 }
            r1.setBackgroundResource(r4)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0478
        L_0x04de:
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            int r1 = r1.getItemType()     // Catch:{ Exception -> 0x0069 }
            if (r1 != 0) goto L_0x0547
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            int r7 = r9 + 1
            java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            int r1 = r1.getItemType()     // Catch:{ Exception -> 0x0069 }
            r7 = 2
            if (r1 != r7) goto L_0x0547
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.t     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r15)     // Catch:{ Exception -> 0x0069 }
            r7 = 0
            r1.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.u     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)     // Catch:{ Exception -> 0x0069 }
            r6 = 8
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.l     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ Exception -> 0x0069 }
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.k     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)     // Catch:{ Exception -> 0x0069 }
            r4 = 0
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.n     // Catch:{ Exception -> 0x0069 }
            r1.setPadding(r4, r4, r4, r4)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r1 = r1.c     // Catch:{ Exception -> 0x0069 }
            int r4 = com.upuphone.xr.sapp.R.drawable.bg_wifi_ignore_all     // Catch:{ Exception -> 0x0069 }
            r1.setBackgroundResource(r4)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0478
        L_0x0547:
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.t     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r15)     // Catch:{ Exception -> 0x0069 }
            r7 = 8
            r1.setVisibility(r7)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.u     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)     // Catch:{ Exception -> 0x0069 }
            r6 = 0
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.l     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ Exception -> 0x0069 }
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.k     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)     // Catch:{ Exception -> 0x0069 }
            r4 = 8
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.n     // Catch:{ Exception -> 0x0069 }
            r5 = 0
            r1.setPadding(r5, r5, r5, r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r1 = r1.c     // Catch:{ Exception -> 0x0069 }
            int r5 = com.upuphone.xr.sapp.R.drawable.bg_wifi_ignore_middle     // Catch:{ Exception -> 0x0069 }
            r1.setBackgroundResource(r5)     // Catch:{ Exception -> 0x0069 }
        L_0x0591:
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.getRoot()     // Catch:{ Exception -> 0x0069 }
            r5 = 0
            r1.setOnClickListener(r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r1 = r1.p     // Catch:{ Exception -> 0x0069 }
            java.util.List r5 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r5 = r5.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r5 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r5     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = r5.getSSid()     // Catch:{ Exception -> 0x0069 }
            r1.setText(r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.LinearLayout r1 = r1.b     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)     // Catch:{ Exception -> 0x0069 }
            java.util.List r5 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r5 = r5.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r5 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r5     // Catch:{ Exception -> 0x0069 }
            int r5 = r5.getWifiState()     // Catch:{ Exception -> 0x0069 }
            r6 = 3
            if (r5 != r6) goto L_0x05cc
            r5 = 1
            goto L_0x05cd
        L_0x05cc:
            r5 = 0
        L_0x05cd:
            if (r5 == 0) goto L_0x05d1
            r5 = 0
            goto L_0x05d2
        L_0x05d1:
            r5 = r4
        L_0x05d2:
            r1.setVisibility(r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.m     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)     // Catch:{ Exception -> 0x0069 }
            java.util.List r5 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r5 = r5.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r5 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r5     // Catch:{ Exception -> 0x0069 }
            int r5 = r5.getWifiState()     // Catch:{ Exception -> 0x0069 }
            r6 = 2
            if (r5 != r6) goto L_0x05ef
            r5 = 1
            goto L_0x05f0
        L_0x05ef:
            r5 = 0
        L_0x05f0:
            if (r5 == 0) goto L_0x05f4
            r5 = 0
            goto L_0x05f5
        L_0x05f4:
            r5 = r4
        L_0x05f5:
            r1.setVisibility(r5)     // Catch:{ Exception -> 0x0069 }
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            int r1 = r1.getWifiState()     // Catch:{ Exception -> 0x0069 }
            r5 = 2
            if (r1 == r5) goto L_0x0617
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.getRoot()     // Catch:{ Exception -> 0x0069 }
            com.honey.account.j8.d r5 = new com.honey.account.j8.d     // Catch:{ Exception -> 0x0069 }
            r5.<init>(r8, r9)     // Catch:{ Exception -> 0x0069 }
            r1.setOnClickListener(r5)     // Catch:{ Exception -> 0x0069 }
        L_0x0617:
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.getRoot()     // Catch:{ Exception -> 0x0069 }
            android.content.Context r1 = r1.getContext()     // Catch:{ Exception -> 0x0069 }
            java.util.List r5 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r5 = r5.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r5 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r5     // Catch:{ Exception -> 0x0069 }
            boolean r5 = r5.getNeedPassword()     // Catch:{ Exception -> 0x0069 }
            if (r5 != 0) goto L_0x0634
            int r5 = com.upuphone.xr.sapp.R.drawable.icon_wifi_unlock     // Catch:{ Exception -> 0x0069 }
            goto L_0x0636
        L_0x0634:
            int r5 = com.upuphone.xr.sapp.R.drawable.icon_wifi_lock     // Catch:{ Exception -> 0x0069 }
        L_0x0636:
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r5 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r5 = r5.r     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r11)     // Catch:{ Exception -> 0x0069 }
            java.util.List r6 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r6 = r6.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r6 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r6     // Catch:{ Exception -> 0x0069 }
            boolean r6 = r6.getWifiInValid()     // Catch:{ Exception -> 0x0069 }
            if (r6 == 0) goto L_0x0653
            r6 = 0
            goto L_0x0654
        L_0x0653:
            r6 = r4
        L_0x0654:
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r5 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.TextView r5 = r5.q     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)     // Catch:{ Exception -> 0x0069 }
            java.util.List r6 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r6 = r6.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r6 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r6     // Catch:{ Exception -> 0x0069 }
            boolean r6 = r6.isPhoneConnectWifi()     // Catch:{ Exception -> 0x0069 }
            if (r6 != 0) goto L_0x068e
            java.util.List r6 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r6 = r6.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r6 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r6     // Catch:{ Exception -> 0x0069 }
            int r6 = r6.getWifiState()     // Catch:{ Exception -> 0x0069 }
            r7 = 2
            if (r6 != r7) goto L_0x068e
            java.util.List r6 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r6 = r6.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r6 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r6     // Catch:{ Exception -> 0x0069 }
            boolean r6 = r6.getWifiInValid()     // Catch:{ Exception -> 0x0069 }
            if (r6 != 0) goto L_0x068e
            r20 = 1
            goto L_0x0690
        L_0x068e:
            r20 = 0
        L_0x0690:
            if (r20 == 0) goto L_0x0694
            r6 = 0
            goto L_0x0695
        L_0x0694:
            r6 = r4
        L_0x0695:
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r5 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r5 = r5.o     // Catch:{ Exception -> 0x0069 }
            r5.setImageDrawable(r1)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = r1.s     // Catch:{ Exception -> 0x0069 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Exception -> 0x0069 }
            java.util.List r3 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r3 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r3     // Catch:{ Exception -> 0x0069 }
            boolean r3 = r3.isPhoneConnectWifi()     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x06ba
            r6 = 0
            goto L_0x06bb
        L_0x06ba:
            r6 = r4
        L_0x06bb:
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0069 }
            java.util.List r1 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r1 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r1     // Catch:{ Exception -> 0x0069 }
            boolean r1 = r1.getIgnoreShow()     // Catch:{ Exception -> 0x0069 }
            if (r1 != 0) goto L_0x06e7
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.n     // Catch:{ Exception -> 0x0069 }
            int r1 = r1.getScrollX()     // Catch:{ Exception -> 0x0069 }
            if (r1 == 0) goto L_0x06e7
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.n     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "wifiContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Exception -> 0x0069 }
            r8.q(r1)     // Catch:{ Exception -> 0x0069 }
        L_0x06e7:
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r2.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r10 = r1.getRoot()     // Catch:{ Exception -> 0x0069 }
            com.honey.account.j8.e r11 = new com.honey.account.j8.e     // Catch:{ Exception -> 0x0069 }
            r1 = r11
            r12 = r2
            r2 = r21
            r3 = r16
            r4 = r18
            r5 = r17
            r6 = r12
            r7 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0069 }
            r10.setOnTouchListener(r11)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemLayoutBinding r1 = r12.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.FrameLayout r1 = r1.c     // Catch:{ Exception -> 0x0069 }
            com.honey.account.j8.f r2 = new com.honey.account.j8.f     // Catch:{ Exception -> 0x0069 }
            r2.<init>(r12, r8, r9)     // Catch:{ Exception -> 0x0069 }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0765
        L_0x0713:
            r3 = 4
            com.upuphone.xr.sapp.guide.adapter.WifiListAdapter$PairTopHolder r1 = (com.upuphone.xr.sapp.guide.adapter.WifiListAdapter.PairTopHolder) r1     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemTopPairdLayoutBinding r2 = r1.a()     // Catch:{ Exception -> 0x0069 }
            android.widget.ProgressBar r2 = r2.b     // Catch:{ Exception -> 0x0069 }
            java.util.List r4 = r8.e     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.guide.model.WifiInfoModel r4 = (com.upuphone.xr.sapp.guide.model.WifiInfoModel) r4     // Catch:{ Exception -> 0x0069 }
            boolean r4 = r4.getRefreshState()     // Catch:{ Exception -> 0x0069 }
            if (r4 == 0) goto L_0x072c
            r5 = 0
            goto L_0x072d
        L_0x072c:
            r5 = r3
        L_0x072d:
            r2.setVisibility(r5)     // Catch:{ Exception -> 0x0069 }
            com.upuphone.xr.sapp.databinding.WifiItemTopPairdLayoutBinding r1 = r1.a()     // Catch:{ Exception -> 0x0069 }
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.getRoot()     // Catch:{ Exception -> 0x0069 }
            r2 = 1107296256(0x42000000, float:32.0)
            int r2 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.h(r2)     // Catch:{ Exception -> 0x0069 }
            r3 = 1094713344(0x41400000, float:12.0)
            int r3 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.h(r3)     // Catch:{ Exception -> 0x0069 }
            r4 = 0
            r1.setPadding(r4, r2, r4, r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0765
        L_0x0749:
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "adapter error : "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "WifiListAdapter"
            r2.c(r3, r1)
        L_0x0765:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.guide.adapter.WifiListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (i2) {
            case 0:
                WifiItemTopPairdLayoutBinding c2 = WifiItemTopPairdLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
                return new PairTopHolder(this, c2);
            case 1:
                WifiItemLayoutBinding c3 = WifiItemLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c3, "inflate(...)");
                return new PairWifiContentHolder(this, c3);
            case 2:
                WifiItemTopUnpairdLayoutBinding c4 = WifiItemTopUnpairdLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c4, "inflate(...)");
                return new UnpairTopHolder(this, c4);
            case 3:
                WifiItemLayoutBinding c5 = WifiItemLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c5, "inflate(...)");
                return new UnPairedWifiHolder(this, c5);
            case 4:
                WifiItemBottomConnectLayoutBinding c6 = WifiItemBottomConnectLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c6, "inflate(...)");
                return new UnpairBottomHolder(this, c6);
            case 5:
                WifiLoadingBinding c7 = WifiLoadingBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c7, "inflate(...)");
                return new LoadingHolder(this, c7);
            case 6:
                WifiSwitchItemLayoutBinding c8 = WifiSwitchItemLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c8, "inflate(...)");
                return new WifiSwitchHolder(this, c8);
            case 7:
                WifiAutoSwitchItemLayoutBinding c9 = WifiAutoSwitchItemLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c9, "inflate(...)");
                return new WifiAutoSwitchHolder(this, c9);
            case 8:
                WifiEmptyBinding c10 = WifiEmptyBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c10, "inflate(...)");
                return new WifiEmptyHolder(this, c10);
            default:
                WifiItemBottomConnectLayoutBinding c11 = WifiItemBottomConnectLayoutBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(c11, "inflate(...)");
                return new UnpairBottomHolder(this, c11);
        }
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        boolean z = false;
        this.g = false;
        int i2 = -1;
        int i3 = 0;
        for (Object next : this.e) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            WifiInfoModel wifiInfoModel = (WifiInfoModel) next;
            if (Intrinsics.areEqual((Object) wifiInfoModel.getSSid(), (Object) str)) {
                i2 = i3;
            }
            if (wifiInfoModel.isDelete()) {
                wifiInfoModel.setDelete(false);
            }
            if (wifiInfoModel.getItemType() == 7) {
                ((WifiInfoModel) this.e.get(i3)).setCheckedState(((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "wifi_auto_connect", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue());
            }
            i3 = i4;
        }
        if (i2 >= 0) {
            if (((WifiInfoModel) this.e.get(i2 - 1)).getItemType() == 0 && ((WifiInfoModel) this.e.get(i2 + 1)).getItemType() == 2) {
                z = true;
            }
            this.e.remove(i2);
        }
        if (z) {
            this.e.remove(2);
        }
        H(true);
        E();
        notifyDataSetChanged();
    }

    public final void q(View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, 0});
        ofInt.setDuration(400);
        ofInt.addUpdateListener(new g(view));
        ofInt.start();
    }

    public final int s(String str) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        int i2 = 0;
        for (Object next : this.e) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            WifiInfoModel wifiInfoModel = (WifiInfoModel) next;
            if (Intrinsics.areEqual((Object) wifiInfoModel.getSSid(), (Object) str) && wifiInfoModel.getWifiState() != 2) {
                return i2;
            }
            i2 = i3;
        }
        return -1;
    }

    public final void setData(List list) {
        List list2 = list;
        Intrinsics.checkNotNullParameter(list2, "list");
        this.g = false;
        if (this.e.size() > 2) {
            this.e = this.e.subList(0, 2);
        }
        if (list.isEmpty()) {
            List list3 = this.e;
            WifiInfoModel wifiInfoModel = r3;
            WifiInfoModel wifiInfoModel2 = new WifiInfoModel("", "", 0, 8, false, false, false, false, false, false, false, false, false, 8176, (DefaultConstructorMarker) null);
            list3.add(wifiInfoModel);
        } else {
            this.e.addAll(list2);
        }
        E();
        H(false);
        notifyDataSetChanged();
    }

    public final boolean t() {
        return this.g;
    }

    public final boolean u() {
        return this.f;
    }

    public final boolean v(int i2, int i3) {
        if (this.e.size() <= 0 || ((WifiInfoModel) this.e.get(i3)).getItemType() != i2) {
            return false;
        }
        return ((WifiInfoModel) this.e.get(i3)).getCheckedState();
    }

    public final int w() {
        int i2 = -1;
        int i3 = 0;
        for (Object next : this.e) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((WifiInfoModel) next).getItemType() == 2) {
                i2 = i3;
            }
            i3 = i4;
        }
        return i2;
    }

    public final boolean x() {
        return this.e.size() == 3 && ((WifiInfoModel) this.e.get(2)).getItemType() == 5;
    }
}
