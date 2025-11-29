package com.upuphone.xr.sapp.guide.connectui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.k8.a;
import com.honey.account.k8.b;
import com.honey.account.k8.c;
import com.honey.account.k8.d;
import com.honey.account.k8.e;
import com.honey.account.k8.f;
import com.honey.account.k8.g;
import com.honey.account.k8.h;
import com.upuphone.ar.fastrecord.phone.utils.RecordExtKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.FragmentAddGlassBinding;
import com.upuphone.xr.sapp.entity.DeviceState;
import com.upuphone.xr.sapp.guide.base.GuideBaseFragment;
import com.upuphone.xr.sapp.guide.model.ConnectResult;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.SingleLiveData;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.BluetoothViewModel;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.dialog.starrynet.StarryNetConnectBluetoothDialog;
import com.xjmz.myvu.dialog.starrynet.StarryNetConnectDialog;
import com.xjmz.myvu.dialog.starrynet.StarryNetConnectLocationDialog;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  \u00012\u00020\u00012\u00020\u0002:\u0002¡\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u0004J\u001f\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020%H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u0010\u0004J\u0017\u00100\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b0\u0010\rJ\u0011\u00101\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b3\u00102J\u0011\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b4\u00102J!\u00105\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b5\u00106J\u0019\u00107\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b7\u0010+J!\u00108\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\nH\u0002¢\u0006\u0004\b:\u0010\u0004J\u000f\u0010;\u001a\u00020\nH\u0002¢\u0006\u0004\b;\u0010\u0004J\u000f\u0010<\u001a\u00020\nH\u0002¢\u0006\u0004\b<\u0010\u0004J\u000f\u0010=\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010>\u001a\u00020\nH\u0002¢\u0006\u0004\b>\u0010\u0004J\u000f\u0010?\u001a\u00020\nH\u0002¢\u0006\u0004\b?\u0010\u0004J\u0019\u0010A\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\nH\u0002¢\u0006\u0004\bC\u0010\u0004J\u000f\u0010D\u001a\u00020\nH\u0002¢\u0006\u0004\bD\u0010\u0004J\u000f\u0010E\u001a\u00020\nH\u0002¢\u0006\u0004\bE\u0010\u0004J\u000f\u0010F\u001a\u00020\nH\u0002¢\u0006\u0004\bF\u0010\u0004J\u000f\u0010G\u001a\u00020\nH\u0002¢\u0006\u0004\bG\u0010\u0004J\u0019\u0010J\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\nH\u0016¢\u0006\u0004\bL\u0010\u0004J\u000f\u0010M\u001a\u00020\nH\u0016¢\u0006\u0004\bM\u0010\u0004J+\u0010S\u001a\u00020R2\u0006\u0010O\u001a\u00020N2\b\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bS\u0010TJ!\u0010V\u001a\u00020\n2\u0006\u0010U\u001a\u00020R2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\bX\u0010\u0004J\u000f\u0010Y\u001a\u00020\nH\u0016¢\u0006\u0004\bY\u0010\u0004J\u000f\u0010Z\u001a\u00020\nH\u0016¢\u0006\u0004\bZ\u0010\u0004J\u0017\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u001b\u0010n\u001a\u00020i8BX\u0002¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u001b\u0010s\u001a\u00020o8BX\u0002¢\u0006\f\n\u0004\bp\u0010k\u001a\u0004\bq\u0010rR\u001b\u0010x\u001a\u00020t8BX\u0002¢\u0006\f\n\u0004\bu\u0010k\u001a\u0004\bv\u0010wR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00050y8\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0001\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050\u0001j\t\u0012\u0004\u0012\u00020\u0005`\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006¢\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/guide/connectui/AddGlassFragment;", "Lcom/upuphone/xr/sapp/guide/base/GuideBaseFragment;", "Lcom/upuphone/xr/interconnect/InterconnectManager$OnStarrySdkStateChangeListener;", "<init>", "()V", "Lcom/upuphone/xr/sapp/entity/DeviceState;", "state", "", "e1", "(Lcom/upuphone/xr/sapp/entity/DeviceState;)Z", "", "S1", "c1", "(Lcom/upuphone/xr/sapp/entity/DeviceState;)V", "", "windowType", "actionType", "h1", "(II)V", "", "data", "k1", "(ILjava/lang/Object;)V", "Q1", "m1", "R1", "A1", "()Z", "C1", "o1", "B1", "z1", "n1", "type", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "N1", "(ILcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "Lcom/upuphone/xr/sapp/guide/model/ConnectResult;", "X1", "(Lcom/upuphone/xr/sapp/guide/model/ConnectResult;)V", "l1", "deviceState", "p1", "(Lcom/upuphone/xr/sapp/entity/DeviceState;)I", "index", "g1", "(ILcom/upuphone/xr/sapp/entity/DeviceState;)V", "H1", "b1", "J1", "()Lcom/upuphone/xr/sapp/entity/DeviceState;", "L1", "K1", "O1", "(Lcom/upuphone/xr/sapp/entity/DeviceState;I)V", "u1", "f1", "(Lcom/upuphone/xr/sapp/entity/DeviceState;I)I", "I1", "q1", "T1", "V1", "F1", "G1", "connectDev", "E1", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "W1", "initView", "v1", "P1", "d1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onDestroy", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onStop", "M1", "enable", "onStateChanged", "(Z)V", "Lcom/upuphone/xr/sapp/databinding/FragmentAddGlassBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentAddGlassBinding;", "binding", "Landroid/os/Handler;", "l", "Landroid/os/Handler;", "mDelayHandler", "m", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "mCurStarryNetDevice", "Lcom/upuphone/xr/sapp/vm/BluetoothViewModel;", "n", "Lkotlin/Lazy;", "s1", "()Lcom/upuphone/xr/sapp/vm/BluetoothViewModel;", "bluetoothViewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "o", "t1", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "p", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "", "q", "Ljava/util/List;", "mFilterHasShowDeviceList", "r", "Z", "mInitSearch", "s", "mOnStop", "", "t", "J", "mCurrentTime", "u", "mConnectOK", "", "v", "Ljava/lang/String;", "mModelId", "Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectDialog;", "w", "Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectDialog;", "mStarryNetConnectDialog", "Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectLocationDialog;", "x", "Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectLocationDialog;", "mStarryNetConnectLocationDialog", "Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectBluetoothDialog;", "y", "Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectBluetoothDialog;", "mStarryNetConnectBluetoothDialog", "z", "I", "searchTime", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "A", "Ljava/util/ArrayList;", "mCacheDeviceList", "B", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAddGlassFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddGlassFragment.kt\ncom/upuphone/xr/sapp/guide/connectui/AddGlassFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,901:1\n32#2,12:902\n32#2,12:914\n32#2,12:926\n1855#3,2:938\n1855#3,2:940\n1864#3,3:942\n1855#3,2:945\n1855#3,2:947\n1#4:949\n256#5,2:950\n*S KotlinDebug\n*F\n+ 1 AddGlassFragment.kt\ncom/upuphone/xr/sapp/guide/connectui/AddGlassFragment\n*L\n70#1:902,12\n71#1:914,12\n72#1:926,12\n164#1:938,2\n211#1:940,2\n457#1:942,3\n519#1:945,2\n539#1:947,2\n879#1:950,2\n*E\n"})
public final class AddGlassFragment extends GuideBaseFragment implements InterconnectManager.OnStarrySdkStateChangeListener {
    public static final Companion B = new Companion((DefaultConstructorMarker) null);
    public volatile ArrayList A;
    public FragmentAddGlassBinding k;
    public final Handler l = new Handler(Looper.getMainLooper());
    public StarryNetDevice m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final List q;
    public boolean r;
    public boolean s;
    public long t;
    public boolean u;
    public String v;
    public StarryNetConnectDialog w;
    public StarryNetConnectLocationDialog x;
    public StarryNetConnectBluetoothDialog y;
    public int z;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/guide/connectui/AddGlassFragment$Companion;", "", "()V", "DELAY_SHOW_DIALOG", "", "LONG_SPACE_TIME", "START_DISCOVER_DELAY", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AddGlassFragment() {
        Class<BluetoothViewModel> cls = BluetoothViewModel.class;
        this.n = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.o = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<SuperViewModel> cls3 = SuperViewModel.class;
        this.p = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls3), new GlobalViewStoreExtKt$cachedViewModels$3(cls3.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        this.q = new ArrayList();
        this.v = "1002";
        this.A = new ArrayList();
    }

    public static final void D1(boolean z2, AddGlassFragment addGlassFragment) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        if (z2) {
            ULog.f6446a.o("AddGlassFragment", "showDeviceName");
            addGlassFragment.P1();
        }
    }

    private final void G1() {
        try {
            t1().M().observe(getViewLifecycleOwner(), new AddGlassFragment$sam$androidx_lifecycle_Observer$0(new AddGlassFragment$registerDeviceConnectCallback$1(this)));
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("AddGlassFragment", "registerDeviceConnectCallback::error: " + message);
        }
    }

    public static final void U1(AddGlassFragment addGlassFragment) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        FragmentAddGlassBinding fragmentAddGlassBinding = addGlassFragment.k;
        FragmentAddGlassBinding fragmentAddGlassBinding2 = null;
        if (fragmentAddGlassBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddGlassBinding = null;
        }
        fragmentAddGlassBinding.g.setEnabled(true);
        FragmentAddGlassBinding fragmentAddGlassBinding3 = addGlassFragment.k;
        if (fragmentAddGlassBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAddGlassBinding2 = fragmentAddGlassBinding3;
        }
        fragmentAddGlassBinding2.g.setText(addGlassFragment.getString(R.string.search_again));
    }

    public static final void i1(AddGlassFragment addGlassFragment) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        addGlassFragment.S1();
    }

    private final void initView() {
        this.u = false;
        MainApplication.k.l((String) null);
        InterconnectManager.getInstance().registerOnStarrySdkStateChangeListener(this);
        this.s = false;
        H1();
    }

    public static final void j1(AddGlassFragment addGlassFragment) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        addGlassFragment.S1();
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.p.getValue();
    }

    public static final void r1(AddGlassFragment addGlassFragment) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        addGlassFragment.r = true;
        addGlassFragment.T1();
    }

    private final DeviceControlModel t1() {
        return (DeviceControlModel) this.o.getValue();
    }

    private final void v1() {
        FragmentAddGlassBinding fragmentAddGlassBinding = this.k;
        FragmentAddGlassBinding fragmentAddGlassBinding2 = null;
        if (fragmentAddGlassBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddGlassBinding = null;
        }
        fragmentAddGlassBinding.g.setOnClickListener(new c(this));
        FragmentAddGlassBinding fragmentAddGlassBinding3 = this.k;
        if (fragmentAddGlassBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddGlassBinding3 = null;
        }
        fragmentAddGlassBinding3.c.setOnClickListener(new d(this));
        FragmentAddGlassBinding fragmentAddGlassBinding4 = this.k;
        if (fragmentAddGlassBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAddGlassBinding2 = fragmentAddGlassBinding4;
        }
        fragmentAddGlassBinding2.e.setOnClickListener(new e(this));
    }

    public static final void w1(AddGlassFragment addGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        if (Intrinsics.areEqual(addGlassFragment.s1().e().getValue(), (Object) Boolean.FALSE)) {
            addGlassFragment.Q1();
            return;
        }
        if (addGlassFragment.o0()) {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            Context requireContext = addGlassFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (!permissionAndStateCheckUtils.f(requireContext)) {
                addGlassFragment.R1();
                return;
            }
        }
        ULog.f6446a.a("AddGlassFragment", "mFilterDeviceStateList clear and startDiscoveryAndBtnToSearchIng");
        addGlassFragment.q.clear();
        addGlassFragment.A.clear();
        addGlassFragment.m = null;
        addGlassFragment.T1();
    }

    public static final void x1(AddGlassFragment addGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        StaticMethodUtilsKt.q(addGlassFragment);
    }

    public static final void y1(AddGlassFragment addGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        StaticMethodUtilsKt.q(addGlassFragment);
    }

    public final boolean A1() {
        StarryNetConnectBluetoothDialog starryNetConnectBluetoothDialog = this.y;
        return (starryNetConnectBluetoothDialog == null || starryNetConnectBluetoothDialog == null || !starryNetConnectBluetoothDialog.isShowing()) ? false : true;
    }

    public final boolean B1() {
        StarryNetConnectDialog starryNetConnectDialog = this.w;
        return (starryNetConnectDialog == null || starryNetConnectDialog == null || !starryNetConnectDialog.isShowing()) ? false : true;
    }

    public final boolean C1() {
        StarryNetConnectLocationDialog starryNetConnectLocationDialog = this.x;
        return (starryNetConnectLocationDialog == null || starryNetConnectLocationDialog == null || !starryNetConnectLocationDialog.isShowing()) ? false : true;
    }

    public final void E1(StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("AddGlassFragment", "popDlgConnectDlg WINDOW_TYPE_DEVICE_CONNECT connectDev = " + starryNetDevice + " ");
            StarryNetConnectDialog starryNetConnectDialog = this.w;
            if (starryNetConnectDialog == null || !starryNetConnectDialog.isShowing()) {
                N1(TrackerEvent.PositioningOfflineOutdoor, starryNetDevice);
                return;
            }
            StarryNetConnectDialog starryNetConnectDialog2 = this.w;
            if (starryNetConnectDialog2 != null) {
                starryNetConnectDialog2.D(TrackerEvent.PositioningOfflineOutdoor, starryNetDevice);
            }
        }
    }

    public final void F1() {
        s1().e().observe(getViewLifecycleOwner(), new AddGlassFragment$sam$androidx_lifecycle_Observer$0(new AddGlassFragment$registerBluetoothStateChange$1(this)));
    }

    public final void H1() {
        ULog.f6446a.o("AddGlassFragment", "resetCurDevice");
        this.m = null;
    }

    public final void I1() {
        ULog.f6446a.a("AddGlassFragment", "do searchGlass");
        SingleLiveData O = t1().O();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        O.observe(viewLifecycleOwner, new AddGlassFragment$sam$androidx_lifecycle_Observer$0(new AddGlassFragment$searchGlass$1(this)));
        SingleLiveData N = t1().N();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        N.observe(viewLifecycleOwner2, new AddGlassFragment$sam$androidx_lifecycle_Observer$0(new AddGlassFragment$searchGlass$2(this)));
        q1();
    }

    public final DeviceState J1() {
        DeviceState L1 = L1();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("AddGlassFragment", "selectDevice selectNormalFoundDevice is " + L1);
        return L1 == null ? K1() : L1;
    }

    public final DeviceState K1() {
        DeviceState deviceState = null;
        for (DeviceState deviceState2 : this.A) {
            ULog.Delegate delegate = ULog.f6446a;
            int windowType = deviceState2.getWindowType();
            StarryNetDevice device = deviceState2.getDevice();
            String deviceName = device != null ? device.getDeviceName() : null;
            delegate.o("AddGlassFragment", "selectFirstDeviceNotInCache windowType = " + windowType + ", deviceName = " + deviceName + ",checkDeviceStateIsInCache = " + e1(deviceState2));
            if (!e1(deviceState2)) {
                deviceState = deviceState2;
            }
        }
        ULog.f6446a.n("selectFirstDeviceNotInCache find device = " + deviceState);
        return deviceState;
    }

    public final DeviceState L1() {
        DeviceState deviceState = null;
        for (DeviceState deviceState2 : this.A) {
            ULog.Delegate delegate = ULog.f6446a;
            int windowType = deviceState2.getWindowType();
            StarryNetDevice device = deviceState2.getDevice();
            String deviceName = device != null ? device.getDeviceName() : null;
            delegate.o("AddGlassFragment", "selectNormalFoundDevice windowType = " + windowType + ",deviceName = " + deviceName + ",checkDeviceStateIsInCache = " + e1(deviceState2));
            if (deviceState2.getWindowType() == 132 && !e1(deviceState2)) {
                deviceState = deviceState2;
            }
        }
        return deviceState;
    }

    public void M1() {
    }

    public final void N1(int i, StarryNetDevice starryNetDevice) {
        StarryNetConnectDialog starryNetConnectDialog;
        ULog.Delegate delegate = ULog.f6446a;
        boolean z2 = this.w == null;
        delegate.c("AddGlassFragment", "mStarryNetConnectDialog is null = " + z2);
        StarryNetConnectDialog starryNetConnectDialog2 = this.w;
        Boolean valueOf = starryNetConnectDialog2 != null ? Boolean.valueOf(starryNetConnectDialog2.isShowing()) : null;
        delegate.c("AddGlassFragment", "mStarryNetConnectDialog is show = " + valueOf);
        n1();
        l1();
        z1();
        StarryNetConnectDialog starryNetConnectDialog3 = this.w;
        if (starryNetConnectDialog3 == null || !starryNetConnectDialog3.isShowing()) {
            StarryNetConnectDialog starryNetConnectDialog4 = this.w;
            if (starryNetConnectDialog4 != null) {
                starryNetConnectDialog4.r(i, starryNetDevice);
            }
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing() && (starryNetConnectDialog = this.w) != null) {
                starryNetConnectDialog.show();
            }
        }
    }

    public final void O1(DeviceState deviceState, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        StarryNetDevice device = deviceState != null ? deviceState.getDevice() : null;
        delegate.c("AddGlassFragment", "showConnectDialog OnFastFund  deviceState = " + deviceState + ",device = " + device + "  windowType = " + i);
        if (i != -1 && deviceState != null) {
            StarryNetDevice device2 = deviceState.getDevice();
            delegate.a("AddGlassFragment", "showConnectDialog OnFastFund  stateDevice is: " + deviceState + ",device is " + device2);
            deviceState.setWindowType(i);
            b1(deviceState);
            S1();
        }
    }

    public final void P1() {
        try {
            String deviceName = InterconnectManager.getInstance().getStarryNetDeviceManager().getSelfDevice().getDeviceName();
            ULog.f6446a.a("AddGlassFragment", "showDeviceName onStateChanged::deviceName is: " + deviceName);
            FragmentAddGlassBinding fragmentAddGlassBinding = this.k;
            FragmentAddGlassBinding fragmentAddGlassBinding2 = null;
            if (fragmentAddGlassBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAddGlassBinding = null;
            }
            TextView textView = fragmentAddGlassBinding.f;
            Intrinsics.checkNotNullExpressionValue(textView, "notifyBt");
            textView.setVisibility(0);
            FragmentAddGlassBinding fragmentAddGlassBinding3 = this.k;
            if (fragmentAddGlassBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentAddGlassBinding2 = fragmentAddGlassBinding3;
            }
            TextView textView2 = fragmentAddGlassBinding2.f;
            int i = R.string.self_name;
            if (deviceName == null) {
                deviceName = "AR Glasses";
            }
            textView2.setText(getString(i, deviceName));
        } catch (Exception e) {
            ULog.f6446a.c("AddGlassFragment", "onStateChanged::error is: " + e.getMessage());
        }
    }

    public final void Q1() {
        StarryNetConnectBluetoothDialog starryNetConnectBluetoothDialog;
        FragmentActivity activity;
        l1();
        if (this.y == null && (activity = getActivity()) != null) {
            StarryNetConnectBluetoothDialog starryNetConnectBluetoothDialog2 = new StarryNetConnectBluetoothDialog(activity);
            this.y = starryNetConnectBluetoothDialog2;
            starryNetConnectBluetoothDialog2.h(RecordExtKt.hasNavigationBar(activity));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && !activity2.isFinishing() && (starryNetConnectBluetoothDialog = this.y) != null) {
            starryNetConnectBluetoothDialog.show();
        }
    }

    public final void R1() {
        StarryNetConnectLocationDialog starryNetConnectLocationDialog;
        FragmentActivity activity;
        l1();
        if (this.x == null && (activity = getActivity()) != null) {
            StarryNetConnectLocationDialog starryNetConnectLocationDialog2 = new StarryNetConnectLocationDialog(activity);
            this.x = starryNetConnectLocationDialog2;
            starryNetConnectLocationDialog2.h(RecordExtKt.hasNavigationBar(activity));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && !activity2.isFinishing() && (starryNetConnectLocationDialog = this.x) != null) {
            starryNetConnectLocationDialog.show();
        }
    }

    public final void S1() {
        StarryNetDevice device;
        boolean B1 = B1();
        boolean A1 = A1();
        boolean C1 = C1();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("AddGlassFragment", "startCheckLocationJob connectDialogState = " + B1);
        delegate.o("AddGlassFragment", "startCheckLocationJob bluetoothDialogState = " + A1);
        delegate.o("AddGlassFragment", "startCheckLocationJob locationDialogState = " + C1);
        if (!B1 && !A1 && !C1) {
            DeviceState J1 = J1();
            delegate.a("AddGlassFragment", "curDeviceIsNotNull showConnectDialog queryDevice =" + J1);
            if (J1 != null && (device = J1.getDevice()) != null) {
                this.u = false;
                this.v = device.getModelId().toString();
                this.m = device;
                N1(J1.getWindowType(), device);
                c1(J1);
            }
        }
    }

    public final void T1() {
        ULog.f6446a.o("AddGlassFragment", "startDiscoveryAndBtnToSearchIng start");
        FragmentAddGlassBinding fragmentAddGlassBinding = this.k;
        FragmentAddGlassBinding fragmentAddGlassBinding2 = null;
        if (fragmentAddGlassBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddGlassBinding = null;
        }
        fragmentAddGlassBinding.g.setText(getString(R.string.searching_for_devices));
        FragmentAddGlassBinding fragmentAddGlassBinding3 = this.k;
        if (fragmentAddGlassBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAddGlassBinding2 = fragmentAddGlassBinding3;
        }
        fragmentAddGlassBinding2.g.setEnabled(false);
        V1();
        this.l.postDelayed(new f(this), 11000);
    }

    public final void V1() {
        this.z++;
        StarryNetHelper.f7917a.k();
        ULog.f6446a.o("AddGlassFragment", "startDiscoveryAndCountNumber cur time = " + this.z);
    }

    public final void W1() {
        InterconnectManager.getInstance().unregisterOnStarrySdkStateChangeListener(this);
        t1().L().removeObservers(getViewLifecycleOwner());
        t1().N().removeObservers(getViewLifecycleOwner());
        t1().O().removeObservers(getViewLifecycleOwner());
        s1().e().removeObservers(getViewLifecycleOwner());
    }

    public final void X1(ConnectResult connectResult) {
        StarryNetConnectDialog starryNetConnectDialog = this.w;
        if (starryNetConnectDialog != null) {
            starryNetConnectDialog.E(connectResult);
        }
    }

    public final void b1(DeviceState deviceState) {
        int p1 = p1(deviceState);
        if (p1 < 0) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o("AddGlassFragment", "addToDeviceList findIndex = " + p1 + ",add to first");
            this.A.add(0, deviceState);
            return;
        }
        ULog.Delegate delegate2 = ULog.f6446a;
        delegate2.o("AddGlassFragment", "addToDeviceList findIndex = " + p1 + " copy value");
        g1(p1, deviceState);
    }

    public final void c1(DeviceState deviceState) {
        ArrayList arrayList = new ArrayList();
        for (DeviceState deviceState2 : this.q) {
            ULog.Delegate delegate = ULog.f6446a;
            StarryNetDevice device = deviceState2.getDevice();
            String str = null;
            String deviceId = device != null ? device.getDeviceId() : null;
            StarryNetDevice device2 = deviceState.getDevice();
            String deviceId2 = device2 != null ? device2.getDeviceId() : null;
            delegate.o("AddGlassFragment", "addToFilterHasShowDeviceList filter device id = " + deviceId + ",state device id = " + deviceId2);
            StarryNetDevice device3 = deviceState2.getDevice();
            String deviceId3 = device3 != null ? device3.getDeviceId() : null;
            StarryNetDevice device4 = deviceState.getDevice();
            if (device4 != null) {
                str = device4.getDeviceId();
            }
            if (Intrinsics.areEqual((Object) deviceId3, (Object) str)) {
                arrayList.add(deviceState2);
            }
        }
        ULog.Delegate delegate2 = ULog.f6446a;
        int size = arrayList.size();
        delegate2.o("AddGlassFragment", "addToFilterHasShowDeviceList needDelList size = " + size + ",state = " + deviceState);
        this.q.removeAll(CollectionsKt.toSet(arrayList));
        this.q.add(deviceState);
    }

    public final void d1() {
        l1();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof MYVUActivity) {
                ULog.f6446a.a("AddGlassFragment", "backToPreviousPage, popBackFragment");
                StaticMethodUtilsKt.x(this, R.id.empty_fragment);
                return;
            }
            ULog.f6446a.a("AddGlassFragment", "backToPreviousPage, finish activity");
            activity.finish();
        }
    }

    public final boolean e1(DeviceState deviceState) {
        String str;
        ULog.Delegate delegate = ULog.f6446a;
        StarryNetDevice device = deviceState.getDevice();
        int beaconId = deviceState.getBeaconId();
        delegate.o("AddGlassFragment", "checkDeviceStateIsInCache state  = " + deviceState + ",device = " + device + ", beaconId = " + beaconId);
        Iterator it = this.q.iterator();
        boolean z2 = false;
        while (true) {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            DeviceState deviceState2 = (DeviceState) it.next();
            StarryNetDevice device2 = deviceState2.getDevice();
            String deviceId = device2 != null ? device2.getDeviceId() : null;
            if (deviceId == null) {
                deviceId = "";
            } else {
                Intrinsics.checkNotNull(deviceId);
            }
            int beaconId2 = deviceState2.getBeaconId();
            ULog.Delegate delegate2 = ULog.f6446a;
            StarryNetDevice device3 = deviceState2.getDevice();
            String deviceName = device3 != null ? device3.getDeviceName() : null;
            delegate2.c("AddGlassFragment", "checkDeviceStateIsInCache item deviceId = " + deviceId + ",deviceName = " + deviceName + ", beaconId = " + beaconId2);
            StarryNetDevice device4 = deviceState.getDevice();
            if (device4 != null) {
                str = device4.getDeviceId();
            }
            if (Intrinsics.areEqual((Object) deviceId, (Object) str) && beaconId2 == deviceState.getBeaconId()) {
                delegate2.c("AddGlassFragment", "checkDeviceStateIsInCache has found");
                z2 = true;
            }
        }
        ULog.Delegate delegate3 = ULog.f6446a;
        StarryNetDevice device5 = deviceState.getDevice();
        if (device5 != null) {
            str = device5.getDeviceName();
        }
        delegate3.c("AddGlassFragment", "checkDeviceStateIsInCache name = " + str + ",isFoundDevice = " + z2);
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        r2 = r10.getDevice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int f1(com.upuphone.xr.sapp.entity.DeviceState r10, int r11) {
        /*
            r9 = this;
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkWindowType deviceState type = "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "AddGlassFragment"
            r9.o(r1, r0)
            r0 = 132(0x84, float:1.85E-43)
            if (r11 != r0) goto L_0x00da
            r0 = 0
            if (r10 == 0) goto L_0x002a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r2 = r10.getDevice()
            if (r2 == 0) goto L_0x002a
            java.lang.String r2 = r2.getModelId()
            goto L_0x002b
        L_0x002a:
            r2 = r0
        L_0x002b:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            if (r10 == 0) goto L_0x0040
            com.upuphone.xr.interconnect.entity.StarryNetDevice r3 = r10.getDevice()
            if (r3 == 0) goto L_0x0040
            int r3 = r3.getRegion()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0041
        L_0x0040:
            r3 = r0
        L_0x0041:
            if (r10 == 0) goto L_0x004d
            com.upuphone.xr.interconnect.entity.StarryNetDevice r10 = r10.getDevice()
            if (r10 == 0) goto L_0x004d
            java.lang.String r0 = r10.getCategoryId()
        L_0x004d:
            java.lang.String r10 = "3001"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)
            r6 = 1
            r5 = r5 ^ r6
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)
            if (r10 != 0) goto L_0x006a
            if (r3 != 0) goto L_0x0062
            goto L_0x0069
        L_0x0062:
            int r10 = r3.intValue()
            if (r10 != 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r6 = 0
        L_0x006a:
            java.lang.Boolean r10 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "searchGlass region = "
            r7.append(r8)
            r7.append(r3)
            java.lang.String r3 = ", isIntlGlass = "
            r7.append(r3)
            r7.append(r4)
            java.lang.String r3 = ", modelId = "
            r7.append(r3)
            r7.append(r2)
            java.lang.String r2 = ",isInitVersion = "
            r7.append(r2)
            r7.append(r10)
            java.lang.String r2 = ",mCategoryId = "
            r7.append(r2)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            r9.c(r1, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00c2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "isIntlGlassForIntlSuperApp = "
            r10.append(r0)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            r9.c(r1, r10)
            if (r6 != 0) goto L_0x00da
            r11 = 189(0xbd, float:2.65E-43)
            goto L_0x00da
        L_0x00c2:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "isChinaGlassForChinaSuperApp = "
            r10.append(r0)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            r9.c(r1, r10)
            if (r5 != 0) goto L_0x00da
            r11 = 188(0xbc, float:2.63E-43)
        L_0x00da:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "checkWindowType deviceState windowType = "
            r10.append(r0)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.o(r1, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.guide.connectui.AddGlassFragment.f1(com.upuphone.xr.sapp.entity.DeviceState, int):int");
    }

    public final void g1(int i, DeviceState deviceState) {
        ((DeviceState) this.A.get(i)).setState(deviceState.getState());
        ((DeviceState) this.A.get(i)).setDevice(deviceState.getDevice());
        ((DeviceState) this.A.get(i)).setErrorCode(deviceState.getErrorCode());
        ((DeviceState) this.A.get(i)).setTime(deviceState.getTime());
        ((DeviceState) this.A.get(i)).setBeaconId(deviceState.getBeaconId());
        ((DeviceState) this.A.get(i)).setFromModifyGlassName(deviceState.getFromModifyGlassName());
        ((DeviceState) this.A.get(i)).setValidTime(deviceState.getValidTime());
    }

    public final void h1(int i, int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("AddGlassFragment", "dialogButtonAction windowType = " + i + ",actionType = " + i2);
        if (i != 102) {
            if (!(i == 203 || i == 188 || i == 189)) {
                switch (i) {
                    case TrackerEvent.PositioningOfflineOutdoor /*131*/:
                        delegate.a("AddGlassFragment", " dialogButtonAction WINDOW_TYPE_DEVICE_CONNECT ");
                        if (i2 == 1101) {
                            delegate.a("AddGlassFragment", "dialogButtonAction ACTION_CONFIRM stopDiscovery");
                            d1();
                            return;
                        }
                        return;
                    case 132:
                        if (i2 == 1102) {
                            M1();
                            MainApplication.Companion companion = MainApplication.k;
                            boolean g = companion.g();
                            delegate.a("AddGlassFragment", " dialogButtonAction ACTION_CANCEL mConnectFail is: " + g);
                            H1();
                            companion.o(false);
                            l1();
                            this.l.postDelayed(new g(this), 1000);
                            return;
                        }
                        CustomFrameAnimation.d.b().p(true);
                        d1();
                        return;
                    case 133:
                        break;
                    default:
                        return;
                }
            }
            delegate.a("AddGlassFragment", "dialogButtonAction ACTION_CANCEL showAnim");
            M1();
            H1();
            l1();
            this.l.postDelayed(new h(this), 1000);
            return;
        }
        delegate.a("AddGlassFragment", " dialogButtonAction WINDOW_TYPE_LOCATION ");
        if (i2 == 1101) {
            startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            l1();
        }
    }

    public final void k1(int i, Object obj) {
        int i2 = i;
        Object obj2 = obj;
        super.c(i, obj);
        if (i2 == 106) {
            StaticMethodUtilsKt.t(this, R.id.userAgreementFragment);
        } else if (i2 == 110) {
            startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
        } else if (i2 == 132 && (obj2 instanceof String)) {
            String str = (String) obj2;
            if (Intrinsics.areEqual((Object) str, (Object) "TYPE_ONE")) {
                if (Intrinsics.areEqual((Object) this.v, (Object) "1002")) {
                    ContractEntry contractEntry = ContractEntry.f6691a;
                    FragmentActivity requireActivity = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                    ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_STAR_UP, (String) null, 4, (Object) null);
                    return;
                }
                ContractEntry contractEntry2 = ContractEntry.f6691a;
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
                ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_AIR_UP, (String) null, 4, (Object) null);
            } else if (!Intrinsics.areEqual((Object) str, (Object) "TYPE_TWO")) {
            } else {
                if (Intrinsics.areEqual((Object) this.v, (Object) "1002")) {
                    ContractEntry contractEntry3 = ContractEntry.f6691a;
                    FragmentActivity requireActivity3 = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity(...)");
                    ContractEntry.w(contractEntry3, requireActivity3, ProtocolType.GLASS_STAR_PP, (String) null, 4, (Object) null);
                    return;
                }
                ContractEntry contractEntry4 = ContractEntry.f6691a;
                FragmentActivity requireActivity4 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity4, "requireActivity(...)");
                ContractEntry.w(contractEntry4, requireActivity4, ProtocolType.GLASS_AIR_PP, (String) null, 4, (Object) null);
            }
        }
    }

    public final void l1() {
        StarryNetConnectLocationDialog starryNetConnectLocationDialog;
        StarryNetConnectBluetoothDialog starryNetConnectBluetoothDialog;
        StarryNetConnectDialog starryNetConnectDialog;
        try {
            Result.Companion companion = Result.Companion;
            StarryNetConnectDialog starryNetConnectDialog2 = this.w;
            if (!(starryNetConnectDialog2 == null || !starryNetConnectDialog2.isShowing() || (starryNetConnectDialog = this.w) == null)) {
                starryNetConnectDialog.dismiss();
            }
            StarryNetConnectBluetoothDialog starryNetConnectBluetoothDialog2 = this.y;
            if (!(starryNetConnectBluetoothDialog2 == null || !starryNetConnectBluetoothDialog2.isShowing() || (starryNetConnectBluetoothDialog = this.y) == null)) {
                starryNetConnectBluetoothDialog.dismiss();
            }
            StarryNetConnectLocationDialog starryNetConnectLocationDialog2 = this.x;
            if (!(starryNetConnectLocationDialog2 == null || !starryNetConnectLocationDialog2.isShowing() || (starryNetConnectLocationDialog = this.x) == null)) {
                starryNetConnectLocationDialog.dismiss();
            }
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void m1() {
        StarryNetConnectBluetoothDialog starryNetConnectBluetoothDialog;
        StarryNetConnectBluetoothDialog starryNetConnectBluetoothDialog2;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && (starryNetConnectBluetoothDialog = this.y) != null && starryNetConnectBluetoothDialog.isShowing() && (starryNetConnectBluetoothDialog2 = this.y) != null) {
            starryNetConnectBluetoothDialog2.dismiss();
        }
    }

    public final void n1() {
        StarryNetConnectDialog starryNetConnectDialog;
        StarryNetConnectDialog starryNetConnectDialog2 = this.w;
        if (!(starryNetConnectDialog2 == null || !starryNetConnectDialog2.isShowing() || (starryNetConnectDialog = this.w) == null)) {
            starryNetConnectDialog.dismiss();
        }
        this.w = null;
    }

    public final void o1() {
        StarryNetConnectLocationDialog starryNetConnectLocationDialog;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && (starryNetConnectLocationDialog = this.x) != null) {
            starryNetConnectLocationDialog.dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ULog.f6446a.a("AddGlassFragment", "onCreate");
        k0();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAddGlassBinding c = FragmentAddGlassBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.k = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        super.onDestroy();
        this.q.clear();
        ULog.f6446a.a("AddGlassFragment", "onDestroy");
    }

    public void onDestroyView() {
        super.onDestroyView();
        ULog.f6446a.a("AddGlassFragment", "onDestroyView");
        this.r = false;
        this.l.removeCallbacksAndMessages((Object) null);
        W1();
        l1();
    }

    public void onResume() {
        super.onResume();
        ULog.f6446a.a("AddGlassFragment", "onResume");
        this.t = System.currentTimeMillis();
        if (this.s) {
            this.s = false;
            G1();
        }
        P1();
    }

    public void onStateChanged(boolean z2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("AddGlassFragment", "onStateChanged enable = " + z2);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new b(z2, this));
        }
    }

    public void onStop() {
        super.onStop();
        ULog.f6446a.a("AddGlassFragment", "onStop");
        this.s = true;
        t1().L().removeObservers(getViewLifecycleOwner());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        n0().W0(true);
        initView();
        v1();
        G1();
        F1();
        I1();
        M1();
    }

    public final int p1(DeviceState deviceState) {
        int i = -1;
        int i2 = 0;
        for (Object next : this.A) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            StarryNetDevice device = ((DeviceState) next).getDevice();
            String str = null;
            String deviceId = device != null ? device.getDeviceId() : null;
            StarryNetDevice device2 = deviceState.getDevice();
            if (device2 != null) {
                str = device2.getDeviceId();
            }
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o("AddGlassFragment", "findIndexInDeviceList indexDeviceId = " + deviceId + ",checkDeviceId = " + str);
            if (Intrinsics.areEqual((Object) deviceId, (Object) str)) {
                i = i2;
            }
            i2 = i3;
        }
        ULog.Delegate delegate2 = ULog.f6446a;
        delegate2.o("AddGlassFragment", "findIndexInDeviceList selectIndex = " + i);
        return i;
    }

    public final void q1() {
        InterconnectManager.getInstance().init(requireContext(), 0);
        this.l.postDelayed(new a(this), AssistantConstants.TIMEOUT_VAD_MUTE);
    }

    public final BluetoothViewModel s1() {
        return (BluetoothViewModel) this.n.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r2 = r7.getDevice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int u1(com.upuphone.xr.sapp.entity.DeviceState r7) {
        /*
            r6 = this;
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            r1 = 0
            if (r7 == 0) goto L_0x0010
            com.upuphone.xr.interconnect.entity.StarryNetDevice r2 = r7.getDevice()
            if (r2 == 0) goto L_0x0010
            java.lang.String r2 = r2.getDeviceName()
            goto L_0x0011
        L_0x0010:
            r2 = r1
        L_0x0011:
            if (r7 == 0) goto L_0x001c
            int r3 = r7.getState()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x001d
        L_0x001c:
            r3 = r1
        L_0x001d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getWindowType deviceState name = "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ", state = "
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            java.lang.String r3 = "AddGlassFragment"
            r0.o(r3, r2)
            if (r7 == 0) goto L_0x0045
            int r1 = r7.getState()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            goto L_0x004f
        L_0x0048:
            int r2 = r1.intValue()
            if (r2 != 0) goto L_0x004f
            goto L_0x0059
        L_0x004f:
            if (r1 != 0) goto L_0x0052
            goto L_0x005c
        L_0x0052:
            int r2 = r1.intValue()
            r4 = 1
            if (r2 != r4) goto L_0x005c
        L_0x0059:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x0084
        L_0x005c:
            if (r1 != 0) goto L_0x005f
            goto L_0x0067
        L_0x005f:
            int r2 = r1.intValue()
            r4 = 3
            if (r2 != r4) goto L_0x0067
            goto L_0x0071
        L_0x0067:
            if (r1 != 0) goto L_0x006a
            goto L_0x0074
        L_0x006a:
            int r2 = r1.intValue()
            r4 = 6
            if (r2 != r4) goto L_0x0074
        L_0x0071:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x0084
        L_0x0074:
            if (r1 != 0) goto L_0x0077
            goto L_0x0083
        L_0x0077:
            int r1 = r1.intValue()
            r2 = -202020(0xfffffffffffceadc, float:NaN)
            if (r1 != r2) goto L_0x0083
            r1 = 203(0xcb, float:2.84E-43)
            goto L_0x0084
        L_0x0083:
            r1 = -1
        L_0x0084:
            int r6 = r6.f1(r7, r1)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "getWindowType return type = "
            r7.append(r1)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            r0.o(r3, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.guide.connectui.AddGlassFragment.u1(com.upuphone.xr.sapp.entity.DeviceState):int");
    }

    public final void z1() {
        FragmentActivity activity;
        if (this.w == null && (activity = getActivity()) != null) {
            ULog.f6446a.a("AddGlassFragment", "initStarryNetConnectDialog");
            StarryNetConnectDialog starryNetConnectDialog = new StarryNetConnectDialog(activity, new AddGlassFragment$initStarryNetConnectDialog$1$1(this));
            this.w = starryNetConnectDialog;
            starryNetConnectDialog.G(RecordExtKt.hasNavigationBar(activity));
        }
    }
}
