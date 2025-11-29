package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.h8.w2;
import com.honey.account.h8.x2;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentGlassAppListBinding;
import com.upuphone.xr.sapp.utils.DynamicOperateUtil;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import flyme.support.v7.widget.MzItemDecoration;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 52\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J+\u0010\u0018\u001a\u00020\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "M0", "Ljava/util/ArrayList;", "", "aList", "bList", "", "J0", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)Z", "N0", "I0", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassAppListBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassAppListBinding;", "binding", "k", "Ljava/lang/String;", "lastShortcutName", "l", "Ljava/util/ArrayList;", "addedNameList", "m", "addedNameListCopy", "Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$MyAdapter;", "n", "Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$MyAdapter;", "mAdapter", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "o", "Lkotlin/Lazy;", "K0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "p", "Z", "isConnect", "q", "Companion", "MyAdapter", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassAppListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassAppListFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassAppListFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,352:1\n32#2,12:353\n*S KotlinDebug\n*F\n+ 1 GlassAppListFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassAppListFragment\n*L\n47#1:353,12\n*E\n"})
public final class GlassAppListFragment extends BaseFragment {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);
    public FragmentGlassAppListBinding j;
    public String k = DynamicOperateUtil.n(DynamicOperateUtil.f7880a, (String) null, 1, (Object) null);
    public ArrayList l = new ArrayList();
    public ArrayList m = new ArrayList();
    public MyAdapter n;
    public final Lazy o;
    public boolean p;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$Companion;", "", "()V", "ADDED", "", "MORE", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B/\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$MyAdapter$ViewHolder;", "Landroid/content/Context;", "mContext", "Ljava/util/ArrayList;", "", "mList", "Landroidx/recyclerview/widget/ItemTouchHelper;", "mItemTouchHelper", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Landroidx/recyclerview/widget/ItemTouchHelper;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "l", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$MyAdapter$ViewHolder;", "getItemCount", "()I", "holder", "position", "", "j", "(Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$MyAdapter$ViewHolder;I)V", "name", "h", "(Ljava/lang/String;)I", "i", "(Ljava/lang/String;)Ljava/lang/String;", "a", "Landroid/content/Context;", "b", "Ljava/util/ArrayList;", "c", "Landroidx/recyclerview/widget/ItemTouchHelper;", "d", "Companion", "ViewHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        public static final Companion d = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public Context f6957a;
        public ArrayList b;
        public ItemTouchHelper c;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$MyAdapter$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassAppListFragment$MyAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "c", "()Landroid/widget/ImageView;", "setPressImg", "(Landroid/widget/ImageView;)V", "pressImg", "b", "setLogImg", "logImg", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setLogName", "(Landroid/widget/TextView;)V", "logName", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class ViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public ImageView f6958a;
            public ImageView b;
            public TextView c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ViewHolder(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "itemView");
                View findViewById = view.findViewById(R.id.long_press_img);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.f6958a = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.logo_img);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.b = (ImageView) findViewById2;
                View findViewById3 = view.findViewById(R.id.logo_name);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                this.c = (TextView) findViewById3;
            }

            public final ImageView a() {
                return this.b;
            }

            public final TextView b() {
                return this.c;
            }

            public final ImageView c() {
                return this.f6958a;
            }
        }

        public MyAdapter(Context context, ArrayList arrayList, ItemTouchHelper itemTouchHelper) {
            Intrinsics.checkNotNullParameter(arrayList, "mList");
            this.f6957a = context;
            this.b = arrayList;
            this.c = itemTouchHelper;
        }

        public static final boolean k(MyAdapter myAdapter, ViewHolder viewHolder, View view) {
            Intrinsics.checkNotNullParameter(myAdapter, "this$0");
            Intrinsics.checkNotNullParameter(viewHolder, "$holder");
            ItemTouchHelper itemTouchHelper = myAdapter.c;
            if (itemTouchHelper == null) {
                return true;
            }
            itemTouchHelper.startDrag(viewHolder);
            return true;
        }

        public int getItemCount() {
            return this.b.size();
        }

        public final int h(String str) {
            switch (str.hashCode()) {
                case -1924205941:
                    if (!str.equals("com.upuphone.ar.tici")) {
                        return 0;
                    }
                    return R.drawable.mimi_tici;
                case -1531224618:
                    if (!str.equals("com.upuphone.xr.ringmanager")) {
                        return 0;
                    }
                    return R.drawable.mini_ring;
                case -1058944463:
                    if (!str.equals("com.upuphone.star.launcher.setting")) {
                        return 0;
                    }
                    return R.drawable.ic_launcher_setting;
                case -435501020:
                    if (str.equals(AssistantConstants.PKG_NAME_NAV)) {
                        return R.drawable.ic_mini_arguide;
                    }
                    return 0;
                case -192476540:
                    if (!str.equals("com.upuphone.star.launcher.universe")) {
                        return 0;
                    }
                    return R.drawable.mini_vientiane;
                case 65531642:
                    if (!str.equals(AssistantConstants.PKG_NAME_MUSIC_PLAYER)) {
                        return 0;
                    }
                    Boolean bool = BuildConfig.f6575a;
                    Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
                    return bool.booleanValue() ? R.drawable.mini_oversea_music : R.drawable.mini_qq_music;
                case 313184810:
                    if (!str.equals(AssistantConstants.PKG_NAME_DOUYIN)) {
                        return 0;
                    }
                    return R.drawable.mini_douyin;
                case 465806113:
                    if (!str.equals("com.upuphone.ar.transcribe.glasses")) {
                        return 0;
                    }
                    return R.drawable.ic_mini_transcribe;
                case 1448079879:
                    if (!str.equals("com.upuphone.star.launcher.user_guide")) {
                        return 0;
                    }
                    return R.drawable.mini_novice_guide;
                case 1640777725:
                    if (!str.equals(AssistantConstants.PKG_NAME_TRANSLATION)) {
                        return 0;
                    }
                    return R.drawable.ic_mini_translator;
                case 1659293491:
                    if (!str.equals(AssistantConstants.PKG_NAME_KUAISHOU)) {
                        return 0;
                    }
                    return R.drawable.mini_quickworker;
                default:
                    return 0;
            }
        }

        public final String i(String str) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("MyAdapter", "name:" + str);
            switch (str.hashCode()) {
                case -1924205941:
                    if (str.equals("com.upuphone.ar.tici")) {
                        return GlobalExtKt.h(com.upuphone.ar.tici.R.string.tici_app_name);
                    }
                    break;
                case -1531224618:
                    if (str.equals("com.upuphone.xr.ringmanager")) {
                        return GlobalExtKt.h(R.string.ring);
                    }
                    break;
                case -1058944463:
                    if (str.equals("com.upuphone.star.launcher.setting")) {
                        return GlobalExtKt.h(R.string.setting);
                    }
                    break;
                case -435501020:
                    if (str.equals(AssistantConstants.PKG_NAME_NAV)) {
                        return GlobalExtKt.h(R.string.mini_navi);
                    }
                    break;
                case -192476540:
                    if (str.equals("com.upuphone.star.launcher.universe")) {
                        return GlobalExtKt.h(R.string.ar_desktop_vientiane);
                    }
                    break;
                case 65531642:
                    if (str.equals(AssistantConstants.PKG_NAME_MUSIC_PLAYER)) {
                        Boolean bool = BuildConfig.f6575a;
                        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
                        return bool.booleanValue() ? StringsKt.trim((CharSequence) StringsKt.replace$default(GlobalExtKt.h(R.string.qq_music), "QQ", "", false, 4, (Object) null)).toString() : GlobalExtKt.h(R.string.qq_music);
                    }
                    break;
                case 313184810:
                    if (str.equals(AssistantConstants.PKG_NAME_DOUYIN)) {
                        return GlobalExtKt.h(R.string.tiktok_web);
                    }
                    break;
                case 465806113:
                    if (str.equals("com.upuphone.ar.transcribe.glasses")) {
                        return GlobalExtKt.h(R.string.app_transcribe);
                    }
                    break;
                case 1448079879:
                    if (str.equals("com.upuphone.star.launcher.user_guide")) {
                        return GlobalExtKt.h(R.string.mini_novice_guide);
                    }
                    break;
                case 1640777725:
                    if (str.equals(AssistantConstants.PKG_NAME_TRANSLATION)) {
                        return GlobalExtKt.h(R.string.translator);
                    }
                    break;
                case 1659293491:
                    if (str.equals(AssistantConstants.PKG_NAME_KUAISHOU)) {
                        return GlobalExtKt.h(R.string.quick_worker);
                    }
                    break;
            }
            delegate.g("MyAdapter", "no match name, name:" + str);
            return "";
        }

        /* renamed from: j */
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            Object obj = this.b.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            String str = (String) obj;
            viewHolder.a().setImageResource(h(str));
            viewHolder.b().setText(i(str));
            viewHolder.c().setOnLongClickListener(new x2(this, viewHolder));
        }

        /* renamed from: l */
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f6957a).inflate(R.layout.item_app_list, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            return new ViewHolder(inflate);
        }
    }

    public GlassAppListFragment() {
        Class<DeviceControlModel> cls = DeviceControlModel.class;
        this.o = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final DeviceControlModel K0() {
        return (DeviceControlModel) this.o.getValue();
    }

    public static final void L0(GlassAppListFragment glassAppListFragment, View view) {
        Intrinsics.checkNotNullParameter(glassAppListFragment, "this$0");
        StaticMethodUtilsKt.q(glassAppListFragment);
    }

    private final void initView() {
        ULog.f6446a.a("GlassAppListFragment", "initView");
        FragmentGlassAppListBinding fragmentGlassAppListBinding = this.j;
        FragmentGlassAppListBinding fragmentGlassAppListBinding2 = null;
        if (fragmentGlassAppListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassAppListBinding = null;
        }
        fragmentGlassAppListBinding.b.setOnClickListener(new w2(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new GlassAppListFragment$initView$mItemTouchHelper$1(this));
        FragmentGlassAppListBinding fragmentGlassAppListBinding3 = this.j;
        if (fragmentGlassAppListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassAppListBinding3 = null;
        }
        fragmentGlassAppListBinding3.d.setLayoutManager(linearLayoutManager);
        this.n = new MyAdapter(requireContext(), this.l, itemTouchHelper);
        FragmentGlassAppListBinding fragmentGlassAppListBinding4 = this.j;
        if (fragmentGlassAppListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassAppListBinding4 = null;
        }
        fragmentGlassAppListBinding4.d.setAdapter(this.n);
        MzItemDecoration mzItemDecoration = new MzItemDecoration(requireContext());
        mzItemDecoration.setDivider(requireContext().getDrawable(R.color.transparent));
        mzItemDecoration.setDividerHeight(StaticMethodUtilsKt.h(12.0f));
        FragmentGlassAppListBinding fragmentGlassAppListBinding5 = this.j;
        if (fragmentGlassAppListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassAppListBinding5 = null;
        }
        fragmentGlassAppListBinding5.d.addItemDecoration(mzItemDecoration);
        FragmentGlassAppListBinding fragmentGlassAppListBinding6 = this.j;
        if (fragmentGlassAppListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassAppListBinding6 = null;
        }
        itemTouchHelper.attachToRecyclerView(fragmentGlassAppListBinding6.d);
        FragmentGlassAppListBinding fragmentGlassAppListBinding7 = this.j;
        if (fragmentGlassAppListBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassAppListBinding7 = null;
        }
        fragmentGlassAppListBinding7.d.setOnItemLongClickListener((MzRecyclerView.OnItemLongClickListener) null);
        FragmentGlassAppListBinding fragmentGlassAppListBinding8 = this.j;
        if (fragmentGlassAppListBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassAppListBinding2 = fragmentGlassAppListBinding8;
        }
        fragmentGlassAppListBinding2.d.setEnableDragSelection(false);
    }

    public final void I0() {
        K0().L().observe(getViewLifecycleOwner(), new GlassAppListFragment$sam$androidx_lifecycle_Observer$0(new GlassAppListFragment$addObserver$1(this)));
    }

    public final boolean J0(ArrayList arrayList, ArrayList arrayList2) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!Intrinsics.areEqual(arrayList.get(i), arrayList2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final void M0() {
        Object obj = new JSONObject(this.k).get("added");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        Intrinsics.checkNotNull(split$default, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        this.l = (ArrayList) split$default;
        List split$default2 = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        Intrinsics.checkNotNull(split$default2, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        this.m = (ArrayList) split$default2;
    }

    public final void N0() {
        JSONObject jSONObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append((String) this.l.get(i));
            stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        jSONObject.put("added", stringBuffer.toString());
        stringBuffer.delete(0, stringBuffer.length());
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        jSONObject.put("more", stringBuffer.toString());
        ULog.f6446a.g("GlassAppListFragment", "lastShortcutName: " + this.k);
        if (this.k.equals(jSONObject.toString())) {
            return;
        }
        if (this.p) {
            DynamicOperateUtil dynamicOperateUtil = DynamicOperateUtil.f7880a;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            DynamicOperateUtil.B(dynamicOperateUtil, jSONObject2, false, 2, (Object) null);
            String obj = jSONObject.get("added").toString();
            dynamicOperateUtil.y(obj, "com.upuphone.ar.transcribe.glasses");
            dynamicOperateUtil.y(obj, AssistantConstants.PKG_NAME_MUSIC_PLAYER);
            dynamicOperateUtil.C(obj);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.b(requireContext, R.string.device_disconnect);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentGlassAppListBinding c = FragmentGlassAppListBinding.c(layoutInflater, viewGroup, false);
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
        I0();
        M0();
        initView();
    }
}
