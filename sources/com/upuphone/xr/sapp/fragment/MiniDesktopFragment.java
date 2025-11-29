package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.c7;
import com.honey.account.h8.d7;
import com.honey.account.h8.e7;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentMiniDesktopBinding;
import com.upuphone.xr.sapp.utils.DynamicOperateUtil;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0001hB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J7\u0010(\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J?\u0010-\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00100*j\b\u0012\u0004\u0012\u00020\u0010`+H\u0002¢\u0006\u0004\b-\u0010.J'\u0010/\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00101\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b1\u00102J'\u00104\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 2\u0006\u00103\u001a\u00020\u0010H\u0002¢\u0006\u0004\b4\u00100J/\u00107\u001a\u00020\u00052\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020 0*j\b\u0012\u0004\u0012\u00020 `+2\u0006\u00106\u001a\u00020\u0016H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00100*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00100*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010GR2\u0010O\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00100Kj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0010`L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR2\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00100Kj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0010`L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010T\u001a\u00020\f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020\u00168\u0002XD¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020\u00168\u0002XD¢\u0006\u0006\n\u0004\bX\u0010VR\u001b\u0010_\u001a\u00020Z8BX\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020 0*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bc\u0010GR\u001c\u0010f\u001a\b\u0012\u0004\u0012\u00020 0*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\be\u0010G¨\u0006i"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MiniDesktopFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "<init>", "()V", "", "initView", "E0", "P0", "S0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "windowType", "actionType", "a", "(II)V", "", "data", "c", "(ILjava/lang/Object;)V", "R0", "", "name", "N0", "(Ljava/lang/String;)Landroid/view/View;", "type", "index", "", "isAdd", "F0", "(IILjava/lang/String;Landroid/view/View;Z)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tmpViewList", "J0", "(IILandroid/view/View;Ljava/util/ArrayList;)V", "G0", "(ILjava/lang/String;Landroid/view/View;)V", "I0", "(Ljava/lang/String;Landroid/view/View;)V", "addIcon", "L0", "list", "resId", "K0", "(Ljava/util/ArrayList;I)V", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "lp", "Q0", "(Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentMiniDesktopBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentMiniDesktopBinding;", "binding", "k", "Ljava/lang/String;", "lastShortcutName", "l", "currShortcutName", "m", "Ljava/util/ArrayList;", "addedViewList", "n", "moreViewList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "o", "Ljava/util/HashMap;", "addDeleteMap", "p", "textMap", "q", "Landroid/view/ViewGroup;", "currParentView", "r", "I", "ADDED_MOST_LIMIT", "s", "ADDED_LEAST_LIMIT", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "t", "Lkotlin/Lazy;", "M0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "u", "Z", "isConnect", "v", "addedNameList", "w", "moreNameList", "x", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMiniDesktopFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiniDesktopFragment.kt\ncom/upuphone/xr/sapp/fragment/MiniDesktopFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,551:1\n32#2,12:552\n1#3:564\n*S KotlinDebug\n*F\n+ 1 MiniDesktopFragment.kt\ncom/upuphone/xr/sapp/fragment/MiniDesktopFragment\n*L\n62#1:552,12\n*E\n"})
public final class MiniDesktopFragment extends BaseFragment implements SuperGenericWindowView.IActionCallback {
    public static final Companion x = new Companion((DefaultConstructorMarker) null);
    public FragmentMiniDesktopBinding j;
    public String k;
    public String l;
    public ArrayList m = new ArrayList();
    public ArrayList n = new ArrayList();
    public HashMap o = new HashMap();
    public HashMap p = new HashMap();
    public ViewGroup q;
    public final int r = 5;
    public final int s = 3;
    public final Lazy t;
    public boolean u;
    public ArrayList v;
    public ArrayList w;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MiniDesktopFragment$Companion;", "", "()V", "MINI_DESKTOP", "", "TAG", "TEST", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public MiniDesktopFragment() {
        DynamicOperateUtil dynamicOperateUtil = DynamicOperateUtil.f7880a;
        this.k = DynamicOperateUtil.n(dynamicOperateUtil, (String) null, 1, (Object) null);
        this.l = DynamicOperateUtil.n(dynamicOperateUtil, (String) null, 1, (Object) null);
        Class<DeviceControlModel> cls = DeviceControlModel.class;
        this.t = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void E0() {
        M0().L().observe(getViewLifecycleOwner(), new MiniDesktopFragment$sam$androidx_lifecycle_Observer$0(new MiniDesktopFragment$addObserver$1(this)));
    }

    public static final void H0(MiniDesktopFragment miniDesktopFragment, String str, int i, View view) {
        Intrinsics.checkNotNullParameter(miniDesktopFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$name");
        View view2 = (View) miniDesktopFragment.o.get(str);
        if (view2 != null) {
            miniDesktopFragment.L0(i, str, view2);
        }
        miniDesktopFragment.S0();
    }

    private final DeviceControlModel M0() {
        return (DeviceControlModel) this.t.getValue();
    }

    public static final void O0(MiniDesktopFragment miniDesktopFragment, View view) {
        Intrinsics.checkNotNullParameter(miniDesktopFragment, "this$0");
        if (miniDesktopFragment.k.equals(miniDesktopFragment.l)) {
            StaticMethodUtilsKt.q(miniDesktopFragment);
            return;
        }
        StaticMethodUtilsKt.I(miniDesktopFragment, CollectionsKt.arrayListOf(136), false, false, 6, (Object) null);
    }

    private final void P0() {
        Object obj = new JSONObject(this.k).get("added");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        List split$default = StringsKt.split$default((CharSequence) (String) obj, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        Intrinsics.checkNotNull(split$default, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        this.v = (ArrayList) split$default;
        Object obj2 = new JSONObject(this.k).get("more");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj2;
        this.w = new ArrayList();
        if (!StringsKt.isBlank(str)) {
            for (String str2 : StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null)) {
                ArrayList arrayList = this.w;
                if (arrayList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
                    arrayList = null;
                }
                arrayList.add(str2);
            }
        }
    }

    private final void S0() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = this.v;
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            arrayList = null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList2 = this.v;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList2 = null;
            }
            stringBuffer.append((String) arrayList2.get(i));
            stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        ((JSONObject) objectRef.element).put("added", stringBuffer.toString());
        stringBuffer.delete(0, stringBuffer.length());
        ArrayList arrayList3 = this.w;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
            arrayList3 = null;
        }
        int size2 = arrayList3.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ArrayList arrayList4 = this.w;
            if (arrayList4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
                arrayList4 = null;
            }
            stringBuffer.append((String) arrayList4.get(i2));
            stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        ((JSONObject) objectRef.element).put("more", stringBuffer.toString());
        String jSONObject = ((JSONObject) objectRef.element).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        this.l = jSONObject;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("MiniFragment", "lastShortcutName: " + this.k);
        delegate.g("MiniFragment", "currShortcutName: " + this.l);
        if (!this.k.equals(((JSONObject) objectRef.element).toString())) {
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding2 = this.j;
            if (fragmentMiniDesktopBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding2 = null;
            }
            fragmentMiniDesktopBinding2.m.setAlpha(1.0f);
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding3 = this.j;
            if (fragmentMiniDesktopBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMiniDesktopBinding = fragmentMiniDesktopBinding3;
            }
            fragmentMiniDesktopBinding.m.setOnClickListener(new e7(this, objectRef));
            return;
        }
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding4 = this.j;
        if (fragmentMiniDesktopBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniDesktopBinding4 = null;
        }
        fragmentMiniDesktopBinding4.m.setAlpha(0.25f);
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding5 = this.j;
        if (fragmentMiniDesktopBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMiniDesktopBinding = fragmentMiniDesktopBinding5;
        }
        fragmentMiniDesktopBinding.m.setClickable(false);
    }

    public static final void T0(MiniDesktopFragment miniDesktopFragment, Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(miniDesktopFragment, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$json");
        if (miniDesktopFragment.u) {
            DynamicOperateUtil dynamicOperateUtil = DynamicOperateUtil.f7880a;
            String jSONObject = ((JSONObject) objectRef.element).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            DynamicOperateUtil.B(dynamicOperateUtil, jSONObject, false, 2, (Object) null);
            dynamicOperateUtil.C(((JSONObject) objectRef.element).get("added").toString());
            StaticMethodUtilsKt.q(miniDesktopFragment);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = miniDesktopFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.b(requireContext, R.string.device_disconnect);
    }

    private final void initView() {
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding = this.j;
        if (fragmentMiniDesktopBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniDesktopBinding = null;
        }
        fragmentMiniDesktopBinding.i.setOnClickListener(new c7(this));
    }

    public final void F0(int i, int i2, String str, View view, boolean z) {
        ULog.f6446a.g("123456", "type: " + i + ", i: " + i2 + ", name: " + str + ", view:" + view + ", view.id:" + view.getId());
        ViewGroup viewGroup = null;
        if (i == 0) {
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding = this.j;
            if (fragmentMiniDesktopBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding = null;
            }
            ConstraintLayout constraintLayout = fragmentMiniDesktopBinding.b;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "addedLayout");
            this.q = constraintLayout;
            J0(i, i2, view, this.m);
        } else {
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding2 = this.j;
            if (fragmentMiniDesktopBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding2 = null;
            }
            ConstraintLayout constraintLayout2 = fragmentMiniDesktopBinding2.l;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "moreLayout");
            this.q = constraintLayout2;
            J0(i, i2, view, this.n);
        }
        if (z) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ((ConstraintLayout) parent).removeView(view);
            ViewGroup viewGroup2 = this.q;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currParentView");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.addView(view);
            G0(i, str, view);
            if (i == 0) {
                this.m.add(view);
            } else {
                this.n.add(view);
            }
        }
    }

    public final void G0(int i, String str, View view) {
        ConstraintLayout constraintLayout;
        if (!str.equals("com.upuphone.star.launcher.universe")) {
            ImageView imageView = new ImageView(getContext());
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding = null;
            if (i == 0) {
                imageView.setImageResource(R.drawable.shortcut_delete);
                FragmentMiniDesktopBinding fragmentMiniDesktopBinding2 = this.j;
                if (fragmentMiniDesktopBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentMiniDesktopBinding = fragmentMiniDesktopBinding2;
                }
                constraintLayout = fragmentMiniDesktopBinding.b;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "addedLayout");
            } else {
                imageView.setImageResource(R.drawable.shortcut_add);
                FragmentMiniDesktopBinding fragmentMiniDesktopBinding3 = this.j;
                if (fragmentMiniDesktopBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentMiniDesktopBinding = fragmentMiniDesktopBinding3;
                }
                constraintLayout = fragmentMiniDesktopBinding.l;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "moreLayout");
            }
            imageView.setOnClickListener(new d7(this, str, i));
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.i = view.getId();
            layoutParams.v = view.getId();
            layoutParams.topMargin = StaticMethodUtilsKt.h(-8.0f);
            layoutParams.setMarginEnd(StaticMethodUtilsKt.h(-6.0f));
            imageView.setLayoutParams(layoutParams);
            constraintLayout.addView(imageView);
            this.o.put(str, imageView);
            if (i == 1) {
                I0(str, view);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I0(java.lang.String r5, android.view.View r6) {
        /*
            r4 = this;
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "addTextView, name:"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "123456"
            r0.g(r2, r1)
            int r1 = r5.hashCode()
            java.lang.String r3 = "getString(...)"
            switch(r1) {
                case -1058944463: goto L_0x00ac;
                case -435501020: goto L_0x009a;
                case -192476540: goto L_0x0087;
                case 65531642: goto L_0x0074;
                case 313184810: goto L_0x0061;
                case 1448079879: goto L_0x004d;
                case 1640777725: goto L_0x0038;
                case 1659293491: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x00b4
        L_0x0023:
            java.lang.String r1 = "com.smile.gifmaker"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x002d
            goto L_0x00b4
        L_0x002d:
            int r0 = com.upuphone.xr.sapp.R.string.quick_worker
            java.lang.String r0 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            goto L_0x00d4
        L_0x0038:
            java.lang.String r1 = "com.upuphone.ar.translation.glasses"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0042
            goto L_0x00b4
        L_0x0042:
            int r0 = com.upuphone.xr.sapp.R.string.translator
            java.lang.String r0 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            goto L_0x00d4
        L_0x004d:
            java.lang.String r1 = "com.upuphone.star.launcher.user_guide"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0056
            goto L_0x00b4
        L_0x0056:
            int r0 = com.upuphone.xr.sapp.R.string.mini_novice_guide
            java.lang.String r0 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            goto L_0x00d4
        L_0x0061:
            java.lang.String r1 = "com.ss.android.ugc.aweme"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x006a
            goto L_0x00b4
        L_0x006a:
            int r0 = com.upuphone.xr.sapp.R.string.tiktok_web
            java.lang.String r0 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            goto L_0x00d4
        L_0x0074:
            java.lang.String r1 = "com.upuphone.star.launcher.music_player"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x007d
            goto L_0x00b4
        L_0x007d:
            int r0 = com.upuphone.xr.sapp.R.string.music_player
            java.lang.String r0 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            goto L_0x00d4
        L_0x0087:
            java.lang.String r1 = "com.upuphone.star.launcher.universe"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0090
            goto L_0x00b4
        L_0x0090:
            int r0 = com.upuphone.xr.sapp.R.string.ar_desktop_vientiane
            java.lang.String r0 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            goto L_0x00d4
        L_0x009a:
            java.lang.String r1 = "com.upuphone.ar.navi.glass"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x00b4
            int r0 = com.upuphone.xr.sapp.R.string.mini_navi
            java.lang.String r0 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            goto L_0x00d4
        L_0x00ac:
            java.lang.String r1 = "com.upuphone.star.launcher.setting"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x00cb
        L_0x00b4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "no match name, name:"
            r1.append(r3)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.g(r2, r1)
            java.lang.String r0 = ""
            goto L_0x00d4
        L_0x00cb:
            int r0 = com.upuphone.xr.sapp.R.string.setting
            java.lang.String r0 = r4.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
        L_0x00d4:
            android.widget.TextView r1 = new android.widget.TextView
            android.content.Context r2 = r4.getContext()
            r1.<init>(r2)
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = new androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
            r3 = -2
            r2.<init>((int) r3, (int) r3)
            int r3 = r6.getId()
            r2.t = r3
            int r3 = r6.getId()
            r2.v = r3
            int r6 = r6.getId()
            r2.j = r6
            r6 = 1090519040(0x41000000, float:8.0)
            int r6 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.h(r6)
            r2.topMargin = r6
            r1.setLayoutParams(r2)
            r1.setText(r0)
            android.content.res.Resources r6 = r4.getResources()
            int r0 = com.upuphone.xr.sapp.R.color.color_widget_name
            int r6 = r6.getColor(r0)
            r1.setTextColor(r6)
            r6 = 1094713344(0x41400000, float:12.0)
            r1.setTextSize(r6)
            com.upuphone.xr.sapp.databinding.FragmentMiniDesktopBinding r6 = r4.j
            if (r6 != 0) goto L_0x011f
            java.lang.String r6 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r6 = 0
        L_0x011f:
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.l
            r6.addView(r1)
            java.util.HashMap r4 = r4.p
            r4.put(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.MiniDesktopFragment.I0(java.lang.String, android.view.View):void");
    }

    public final void J0(int i, int i2, View view, ArrayList arrayList) {
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding;
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding2;
        int i3 = i2;
        View view2 = view;
        ArrayList arrayList2 = arrayList;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("123456", "index: " + i3 + ", view.id: " + view.getId());
        if (i == 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Q0(layoutParams2);
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding3 = this.j;
            if (fragmentMiniDesktopBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding3 = null;
            }
            layoutParams2.i = fragmentMiniDesktopBinding3.b.getId();
            layoutParams2.topMargin = StaticMethodUtilsKt.h(36.0f);
            int h = StaticMethodUtilsKt.h(0.0f);
            ArrayList arrayList3 = this.v;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList3 = null;
            }
            int size = arrayList3.size();
            if (size == 3) {
                h = StaticMethodUtilsKt.h(67.0f);
            } else if (size == 4) {
                h = StaticMethodUtilsKt.h(28.0f);
            } else if (size != 5) {
                ArrayList arrayList4 = this.v;
                if (arrayList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                    arrayList4 = null;
                }
                delegate.g("123456", "no match size, addedNameList.size:" + arrayList4.size());
            } else {
                h = StaticMethodUtilsKt.h(20.0f);
            }
            if (i3 == 0) {
                layoutParams2.setMarginStart(h);
                FragmentMiniDesktopBinding fragmentMiniDesktopBinding4 = this.j;
                if (fragmentMiniDesktopBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentMiniDesktopBinding4 = null;
                }
                layoutParams2.t = fragmentMiniDesktopBinding4.b.getId();
                layoutParams2.N = 1;
            } else {
                int i4 = i3 - 1;
                ViewGroup.LayoutParams layoutParams3 = ((View) arrayList2.get(i4)).getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.u = view.getId();
                ((View) arrayList2.get(i4)).setLayoutParams(layoutParams4);
                layoutParams2.s = ((View) arrayList2.get(i4)).getId();
            }
            ArrayList arrayList5 = this.v;
            if (arrayList5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList5 = null;
            }
            if (i3 == arrayList5.size() - 1) {
                FragmentMiniDesktopBinding fragmentMiniDesktopBinding5 = this.j;
                if (fragmentMiniDesktopBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentMiniDesktopBinding2 = null;
                } else {
                    fragmentMiniDesktopBinding2 = fragmentMiniDesktopBinding5;
                }
                layoutParams2.v = fragmentMiniDesktopBinding2.b.getId();
                layoutParams2.setMarginEnd(h);
            }
            view2.setLayoutParams(layoutParams2);
            return;
        }
        delegate.g("123456", "more region-------");
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
        Q0(layoutParams6);
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding6 = this.j;
        if (fragmentMiniDesktopBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniDesktopBinding6 = null;
        }
        layoutParams6.i = fragmentMiniDesktopBinding6.l.getId();
        layoutParams6.topMargin = StaticMethodUtilsKt.h(28.0f);
        if (i3 == 0) {
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding7 = this.j;
            if (fragmentMiniDesktopBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding = null;
            } else {
                fragmentMiniDesktopBinding = fragmentMiniDesktopBinding7;
            }
            layoutParams6.t = fragmentMiniDesktopBinding.l.getId();
        } else {
            layoutParams6.s = ((View) arrayList2.get(i3 - 1)).getId();
        }
        layoutParams6.setMarginStart(StaticMethodUtilsKt.h(20.0f));
        view2.setLayoutParams(layoutParams6);
    }

    public final void K0(ArrayList arrayList, int i) {
        for (Map.Entry entry : this.o.entrySet()) {
            if (arrayList.contains(entry.getKey())) {
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.widget.ImageView");
                ((ImageView) value).setImageResource(i);
            }
        }
    }

    public final void L0(int i, String str, View view) {
        int i2;
        int i3 = i;
        String str2 = str;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("123456", "click-----------------type:" + i3 + ", name:" + str2);
        if (!this.u) {
            delegate.g("MiniFragment", "curr is not connect");
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.b(requireContext, R.string.device_disconnect);
            return;
        }
        ArrayList arrayList = null;
        if (i3 == 0) {
            ArrayList arrayList2 = this.v;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList2 = null;
            }
            if (arrayList2.size() <= this.s) {
                delegate.g("123456", "最少保留3个");
                UToast.f6444a.b(MainApplication.k.f(), R.string.mini_least_toast);
                return;
            }
            delegate.g("123456", "delete");
            ArrayList arrayList3 = this.v;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList3 = null;
            }
            int indexOf = arrayList3.indexOf(str2);
            Object obj = this.m.get(indexOf);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            View view2 = (View) obj;
            this.m.remove(indexOf);
            ArrayList arrayList4 = this.v;
            if (arrayList4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList4 = null;
            }
            arrayList4.remove(indexOf);
            ArrayList arrayList5 = this.v;
            if (arrayList5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList5 = null;
            }
            int size = arrayList5.size();
            int i4 = 0;
            while (i4 < size) {
                ArrayList arrayList6 = this.v;
                if (arrayList6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                    arrayList6 = null;
                }
                Object obj2 = arrayList6.get(i4);
                Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                View N0 = N0((String) obj2);
                if (N0 != null) {
                    ArrayList arrayList7 = this.v;
                    if (arrayList7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                        arrayList7 = null;
                    }
                    Object obj3 = arrayList7.get(i4);
                    Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
                    i2 = i4;
                    F0(0, i4, (String) obj3, N0, false);
                } else {
                    i2 = i4;
                }
                i4 = i2 + 1;
            }
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding = this.j;
            if (fragmentMiniDesktopBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding = null;
            }
            fragmentMiniDesktopBinding.b.removeView(view2);
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding2 = this.j;
            if (fragmentMiniDesktopBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding2 = null;
            }
            fragmentMiniDesktopBinding2.b.removeView((View) this.o.get(str2));
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding3 = this.j;
            if (fragmentMiniDesktopBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding3 = null;
            }
            fragmentMiniDesktopBinding3.l.addView(view2);
            F0(1, this.n.size(), str, view2, true);
            ArrayList arrayList8 = this.w;
            if (arrayList8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
                arrayList8 = null;
            }
            arrayList8.add(str2);
            ArrayList arrayList9 = this.v;
            if (arrayList9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList9 = null;
            }
            if (arrayList9.size() == this.r - 1) {
                ArrayList arrayList10 = this.w;
                if (arrayList10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
                } else {
                    arrayList = arrayList10;
                }
                K0(arrayList, R.drawable.shortcut_add);
                return;
            }
            ArrayList arrayList11 = this.v;
            if (arrayList11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList11 = null;
            }
            if (arrayList11.size() == this.s) {
                ArrayList arrayList12 = this.v;
                if (arrayList12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                } else {
                    arrayList = arrayList12;
                }
                K0(arrayList, R.drawable.mini_cant_delete);
                return;
            }
            return;
        }
        delegate.g("123456", "add");
        ArrayList arrayList13 = this.v;
        if (arrayList13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            arrayList13 = null;
        }
        if (arrayList13.size() >= this.r) {
            delegate.g("123456", "最多可添加 5 个mini桌面图标");
            UToast.f6444a.b(MainApplication.k.f(), R.string.mini_most_toast);
            return;
        }
        ArrayList arrayList14 = this.w;
        if (arrayList14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
            arrayList14 = null;
        }
        int indexOf2 = arrayList14.indexOf(str2);
        Object obj4 = this.n.get(indexOf2);
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        View view3 = (View) obj4;
        this.n.remove(indexOf2);
        ArrayList arrayList15 = this.w;
        if (arrayList15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
            arrayList15 = null;
        }
        arrayList15.remove(indexOf2);
        if (indexOf2 == 0 && this.n.size() >= 1) {
            ViewGroup.LayoutParams layoutParams = ((View) this.n.get(indexOf2)).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            FragmentMiniDesktopBinding fragmentMiniDesktopBinding4 = this.j;
            if (fragmentMiniDesktopBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniDesktopBinding4 = null;
            }
            layoutParams2.t = fragmentMiniDesktopBinding4.l.getId();
            ((View) this.n.get(indexOf2)).setLayoutParams(layoutParams2);
        } else if (indexOf2 != 0 && indexOf2 < this.n.size()) {
            ViewGroup.LayoutParams layoutParams3 = ((View) this.n.get(indexOf2)).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.s = ((View) this.n.get(indexOf2 - 1)).getId();
            ((View) this.n.get(indexOf2)).setLayoutParams(layoutParams4);
        }
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding5 = this.j;
        if (fragmentMiniDesktopBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniDesktopBinding5 = null;
        }
        fragmentMiniDesktopBinding5.l.removeView(view3);
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding6 = this.j;
        if (fragmentMiniDesktopBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniDesktopBinding6 = null;
        }
        fragmentMiniDesktopBinding6.l.removeView((View) this.o.get(str2));
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding7 = this.j;
        if (fragmentMiniDesktopBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniDesktopBinding7 = null;
        }
        fragmentMiniDesktopBinding7.l.removeView((View) this.p.get(str2));
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding8 = this.j;
        if (fragmentMiniDesktopBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniDesktopBinding8 = null;
        }
        fragmentMiniDesktopBinding8.b.addView(view3);
        ViewParent parent = view3.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ((ConstraintLayout) parent).removeView(view3);
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding9 = this.j;
        if (fragmentMiniDesktopBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniDesktopBinding9 = null;
        }
        fragmentMiniDesktopBinding9.b.addView(view3);
        G0(0, str2, view3);
        this.m.add(view3);
        ArrayList arrayList16 = this.v;
        if (arrayList16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            arrayList16 = null;
        }
        arrayList16.add(str2);
        ArrayList arrayList17 = this.v;
        if (arrayList17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            arrayList17 = null;
        }
        int size2 = arrayList17.size();
        for (int i5 = 0; i5 < size2; i5++) {
            ArrayList arrayList18 = this.v;
            if (arrayList18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList18 = null;
            }
            Object obj5 = arrayList18.get(i5);
            Intrinsics.checkNotNullExpressionValue(obj5, "get(...)");
            View N02 = N0((String) obj5);
            if (N02 != null) {
                ArrayList arrayList19 = this.v;
                if (arrayList19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                    arrayList19 = null;
                }
                Object obj6 = arrayList19.get(i5);
                Intrinsics.checkNotNullExpressionValue(obj6, "get(...)");
                F0(0, i5, (String) obj6, N02, false);
            }
        }
        ArrayList arrayList20 = this.v;
        if (arrayList20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            arrayList20 = null;
        }
        if (arrayList20.size() == this.r) {
            ArrayList arrayList21 = this.w;
            if (arrayList21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
            } else {
                arrayList = arrayList21;
            }
            K0(arrayList, R.drawable.mini_cant_add);
            return;
        }
        ArrayList arrayList22 = this.v;
        if (arrayList22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            arrayList22 = null;
        }
        if (arrayList22.size() == this.s + 1) {
            ArrayList arrayList23 = this.v;
            if (arrayList23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            } else {
                arrayList = arrayList23;
            }
            K0(arrayList, R.drawable.shortcut_delete);
        }
    }

    public final View N0(String str) {
        FragmentMiniDesktopBinding fragmentMiniDesktopBinding = null;
        switch (str.hashCode()) {
            case -1058944463:
                if (str.equals("com.upuphone.star.launcher.setting")) {
                    FragmentMiniDesktopBinding fragmentMiniDesktopBinding2 = this.j;
                    if (fragmentMiniDesktopBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentMiniDesktopBinding = fragmentMiniDesktopBinding2;
                    }
                    return fragmentMiniDesktopBinding.c.g;
                }
                break;
            case -435501020:
                if (str.equals(AssistantConstants.PKG_NAME_NAV)) {
                    FragmentMiniDesktopBinding fragmentMiniDesktopBinding3 = this.j;
                    if (fragmentMiniDesktopBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentMiniDesktopBinding = fragmentMiniDesktopBinding3;
                    }
                    return fragmentMiniDesktopBinding.c.b;
                }
                break;
            case -192476540:
                if (str.equals("com.upuphone.star.launcher.universe")) {
                    FragmentMiniDesktopBinding fragmentMiniDesktopBinding4 = this.j;
                    if (fragmentMiniDesktopBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentMiniDesktopBinding = fragmentMiniDesktopBinding4;
                    }
                    return fragmentMiniDesktopBinding.c.i;
                }
                break;
            case 65531642:
                if (str.equals(AssistantConstants.PKG_NAME_MUSIC_PLAYER)) {
                    FragmentMiniDesktopBinding fragmentMiniDesktopBinding5 = this.j;
                    if (fragmentMiniDesktopBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentMiniDesktopBinding = fragmentMiniDesktopBinding5;
                    }
                    return fragmentMiniDesktopBinding.c.e;
                }
                break;
            case 313184810:
                if (str.equals(AssistantConstants.PKG_NAME_DOUYIN)) {
                    FragmentMiniDesktopBinding fragmentMiniDesktopBinding6 = this.j;
                    if (fragmentMiniDesktopBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentMiniDesktopBinding = fragmentMiniDesktopBinding6;
                    }
                    return fragmentMiniDesktopBinding.c.c;
                }
                break;
            case 1448079879:
                if (str.equals("com.upuphone.star.launcher.user_guide")) {
                    FragmentMiniDesktopBinding fragmentMiniDesktopBinding7 = this.j;
                    if (fragmentMiniDesktopBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentMiniDesktopBinding = fragmentMiniDesktopBinding7;
                    }
                    return fragmentMiniDesktopBinding.c.d;
                }
                break;
            case 1640777725:
                if (str.equals(AssistantConstants.PKG_NAME_TRANSLATION)) {
                    FragmentMiniDesktopBinding fragmentMiniDesktopBinding8 = this.j;
                    if (fragmentMiniDesktopBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentMiniDesktopBinding = fragmentMiniDesktopBinding8;
                    }
                    return fragmentMiniDesktopBinding.c.h;
                }
                break;
            case 1659293491:
                if (str.equals(AssistantConstants.PKG_NAME_KUAISHOU)) {
                    FragmentMiniDesktopBinding fragmentMiniDesktopBinding9 = this.j;
                    if (fragmentMiniDesktopBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentMiniDesktopBinding = fragmentMiniDesktopBinding9;
                    }
                    return fragmentMiniDesktopBinding.c.f;
                }
                break;
        }
        return null;
    }

    public final void Q0(ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.v = -1;
        layoutParams.u = -1;
        layoutParams.s = -1;
        layoutParams.t = -1;
        layoutParams.setMarginStart(StaticMethodUtilsKt.h(0.0f));
        layoutParams.setMarginEnd(StaticMethodUtilsKt.h(0.0f));
    }

    public final void R0() {
        ULog.f6446a.g("123456", "showMiniDesktop-------------------------");
        ArrayList arrayList = this.v;
        ArrayList arrayList2 = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            arrayList = null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList3 = this.v;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList3 = null;
            }
            Object obj = arrayList3.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            View N0 = N0((String) obj);
            if (N0 != null) {
                ArrayList arrayList4 = this.v;
                if (arrayList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                    arrayList4 = null;
                }
                Object obj2 = arrayList4.get(i);
                Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                F0(0, i, (String) obj2, N0, true);
            }
        }
        ArrayList arrayList5 = this.w;
        if (arrayList5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
            arrayList5 = null;
        }
        int size2 = arrayList5.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ArrayList arrayList6 = this.w;
            if (arrayList6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
                arrayList6 = null;
            }
            Object obj3 = arrayList6.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
            View N02 = N0((String) obj3);
            if (N02 != null) {
                ArrayList arrayList7 = this.w;
                if (arrayList7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
                    arrayList7 = null;
                }
                Object obj4 = arrayList7.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
                F0(1, i2, (String) obj4, N02, true);
            }
        }
        ArrayList arrayList8 = this.v;
        if (arrayList8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
            arrayList8 = null;
        }
        if (arrayList8.size() == this.r) {
            ArrayList arrayList9 = this.w;
            if (arrayList9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreNameList");
            } else {
                arrayList2 = arrayList9;
            }
            K0(arrayList2, R.drawable.mini_cant_add);
        } else {
            ArrayList arrayList10 = this.v;
            if (arrayList10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                arrayList10 = null;
            }
            if (arrayList10.size() == this.s) {
                ArrayList arrayList11 = this.v;
                if (arrayList11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addedNameList");
                } else {
                    arrayList2 = arrayList11;
                }
                K0(arrayList2, R.drawable.mini_cant_delete);
            }
        }
        ULog.f6446a.g("123456", "showAddShortcutInstruction-------------------------end");
    }

    public void a(int i, int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("MiniFragment", "----------------windowType: " + i + ", actionType:" + i2);
        if (i == 136 && i2 == 1101) {
            StaticMethodUtilsKt.q(this);
        }
    }

    public void c(int i, Object obj) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMiniDesktopBinding c = FragmentMiniDesktopBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        E0();
        P0();
        R0();
    }
}
