package com.upuphone.xr.sapp.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.honey.account.h8.m8;
import com.honey.account.h8.n8;
import com.honey.account.h8.o8;
import com.meizu.common.fastscrollletter.FastScrollLetter;
import com.meizu.common.util.VibrateUtil;
import com.meizu.common.widget.Switch;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.adapter.NotificationAppAdapter;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentPhoneNotifyBinding;
import com.upuphone.xr.sapp.databinding.NotificationAppEmptyBinding;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.algorithm.TaxiParse;
import com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.PackageHelper;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.FastScrollLetterRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.sourceforge.pinyin4j.PinyinHelper;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001LB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004R\u001b\u0010'\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R&\u00101\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R&\u00103\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00100R&\u00105\u001a\u0012\u0012\u0004\u0012\u00020\t0,j\b\u0012\u0004\u0012\u00020\t`.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00100R<\u00108\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u0002060,0,j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002060,j\b\u0012\u0004\u0012\u000206`.`.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00100R\u001b\u0010=\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b:\u0010$\u001a\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\t0,j\b\u0012\u0004\u0012\u00020\t`.8\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u00100R\u0016\u0010J\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/PhoneNotifyFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "", "initView", "R0", "b1", "", "appName", "", "V0", "(Ljava/lang/String;)C", "X0", "a1", "Z0", "S0", "packageName", "Q0", "(Ljava/lang/String;)V", "T0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onForeground", "onResume", "onDestroy", "Lcom/upuphone/xr/sapp/databinding/FragmentPhoneNotifyBinding;", "j", "Lkotlin/Lazy;", "U0", "()Lcom/upuphone/xr/sapp/databinding/FragmentPhoneNotifyBinding;", "binding", "", "k", "Z", "loadingShow", "Ljava/util/ArrayList;", "Lcom/upuphone/xr/sapp/monitor/notification/model/AppInfoModel;", "Lkotlin/collections/ArrayList;", "l", "Ljava/util/ArrayList;", "mAppList", "m", "recycleList", "n", "letters", "", "o", "dataArray", "Lcom/upuphone/xr/sapp/utils/PackageHelper;", "p", "W0", "()Lcom/upuphone/xr/sapp/utils/PackageHelper;", "mPackageHelper", "Landroid/content/BroadcastReceiver;", "q", "Landroid/content/BroadcastReceiver;", "mPackageChange", "Lcom/upuphone/xr/sapp/adapter/NotificationAppAdapter;", "r", "Lcom/upuphone/xr/sapp/adapter/NotificationAppAdapter;", "mAdapter", "s", "allLetters", "t", "Ljava/lang/String;", "openAppPackage", "u", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPhoneNotifyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhoneNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/PhoneNotifyFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,411:1\n1477#2:412\n1502#2,3:413\n1505#2,3:423\n1855#2,2:427\n766#2:431\n857#2,2:432\n372#3,7:416\n215#4:426\n216#4:429\n1#5:430\n256#6,2:434\n256#6,2:436\n*S KotlinDebug\n*F\n+ 1 PhoneNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/PhoneNotifyFragment\n*L\n146#1:412\n146#1:413,3\n146#1:423,3\n169#1:427,2\n324#1:431\n324#1:432,2\n146#1:416,7\n155#1:426\n155#1:429\n379#1:434,2\n255#1:436,2\n*E\n"})
public final class PhoneNotifyFragment extends BaseFragment implements LifecycleObserver {
    public static final Companion u = new Companion((DefaultConstructorMarker) null);
    public final Lazy j = LazyKt.lazy(new PhoneNotifyFragment$binding$2(this));
    public boolean k;
    public ArrayList l = new ArrayList();
    public ArrayList m = new ArrayList();
    public ArrayList n = new ArrayList();
    public ArrayList o = new ArrayList();
    public final Lazy p = LazyKt.lazy(PhoneNotifyFragment$mPackageHelper$2.INSTANCE);
    public BroadcastReceiver q;
    public NotificationAppAdapter r;
    public final ArrayList s = CollectionsKt.arrayListOf(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#");
    public String t = "";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/PhoneNotifyFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PhoneNotifyFragment() {
    }

    /* access modifiers changed from: private */
    public final void Q0(String str) {
        StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("DISMISS_NOTIFICATION", MapsKt.hashMapOf(TuplesKt.to("ids", ArraysKt.toList((T[]) new String[]{"phone-" + str})), TuplesKt.to("type", 0))), (SendMessageListener) null, 5, (Object) null);
    }

    public static final void Y0(PhoneNotifyFragment phoneNotifyFragment, View view) {
        Intrinsics.checkNotNullParameter(phoneNotifyFragment, "this$0");
        StaticMethodUtilsKt.q(phoneNotifyFragment);
    }

    public static final void c1(LinearLayoutManager linearLayoutManager, PhoneNotifyFragment phoneNotifyFragment) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "$linearLayoutManager");
        Intrinsics.checkNotNullParameter(phoneNotifyFragment, "this$0");
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        boolean z = true;
        int i = 0;
        int i2 = (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) ? 0 : (findLastVisibleItemPosition - findFirstVisibleItemPosition) + 1;
        FastScrollLetter fastScrollLetter = phoneNotifyFragment.U0().b;
        Intrinsics.checkNotNullExpressionValue(fastScrollLetter, "fastscrollLetter");
        if (i2 >= phoneNotifyFragment.m.size()) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        fastScrollLetter.setVisibility(i);
    }

    public static final int d1(PhoneNotifyFragment phoneNotifyFragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(phoneNotifyFragment, "this$0");
        VibrateUtil.tick(phoneNotifyFragment.requireContext());
        return i2 + i;
    }

    private final void initView() {
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_REMIND_APP_NOTICE_LIST, new HashMap());
        ProcessLifecycleOwner.i.a().getLifecycle().a(this);
        U0().h.setChecked(SuperNotificationManager.f7749a.C());
        Switch switchR = U0().h;
        Intrinsics.checkNotNullExpressionValue(switchR, "phoneNotifySwitch");
        GlobalExtKt.j(switchR, new PhoneNotifyFragment$initView$1(this));
        ConstraintLayout constraintLayout = U0().f;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "phoneNotifyItem");
        GlobalExtKt.l(constraintLayout, StaticMethodUtilsKt.i(this), new PhoneNotifyFragment$initView$2(this));
        PackageHelper W0 = W0();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.q = W0.i(requireContext, true, new PhoneNotifyFragment$initView$3(this));
        S0();
        U0().e.setOnClickListener(new o8(this));
        X0();
    }

    public final void R0() {
        List sortedWith = CollectionsKt.sortedWith(this.l, new PhoneNotifyFragment$dealPageData$$inlined$thenBy$1(new PhoneNotifyFragment$dealPageData$$inlined$compareBy$1(this), this));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : sortedWith) {
            Character valueOf = Character.valueOf(V0(((AppInfoModel) next).getName()));
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(next);
        }
        this.n.clear();
        this.m.clear();
        this.o.clear();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String valueOf2 = String.valueOf(((Character) entry.getKey()).charValue());
            this.n.add(valueOf2);
            this.m.add(new AppInfoModel("", "", 1, (Drawable) null, false, valueOf2, true, 24, (DefaultConstructorMarker) null));
            ArrayList arrayList = new ArrayList();
            for (AppInfoModel appInfoModel : (List) entry.getValue()) {
                appInfoModel.setLetter(valueOf2);
                appInfoModel.setDisableState(AppConfigHelper.d.a().e(appInfoModel.getPackageName()));
                this.m.add(appInfoModel);
                arrayList.add(appInfoModel);
            }
            this.o.add(arrayList);
        }
        b1();
    }

    public final void S0() {
        LinearLayout linearLayout = U0().d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "phoneNotifyAppLay");
        linearLayout.setVisibility(SuperNotificationManager.f7749a.C() ? 0 : 8);
    }

    public final void T0(String str) {
        if (ArraysKt.contains((T[]) TaxiParse.f7753a.a(), str)) {
            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("DISMISS_REMINDER", MapsKt.hashMapOf(TuplesKt.to("packages", ArraysKt.toList((T[]) new String[]{str})))), (SendMessageListener) null, 5, (Object) null);
        }
    }

    public final FragmentPhoneNotifyBinding U0() {
        return (FragmentPhoneNotifyBinding) this.j.getValue();
    }

    public final char V0(String str) {
        char first = StringsKt.first(str);
        if (new Regex("[a-zA-Z]").matches(String.valueOf(first))) {
            return Character.toUpperCase(first);
        }
        String[] hanyuPinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(first);
        if (hanyuPinyinStringArray == null) {
            return '#';
        }
        String str2 = hanyuPinyinStringArray[0];
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        return Character.toUpperCase(StringsKt.first(str2));
    }

    public final PackageHelper W0() {
        return (PackageHelper) this.p.getValue();
    }

    public final void X0() {
        String string = getResources().getString(R.string.phone_notify_setting_jump);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(getResources().getString(R.string.phone_notify_closed));
        spannableStringBuilder.append(string);
        spannableStringBuilder.setSpan(new PhoneNotifyFragment$initTextToSetting$1(string, this), StringsKt.indexOf$default((CharSequence) spannableStringBuilder, string, 0, false, 6, (Object) null), spannableStringBuilder.length(), 33);
        NotificationAppEmptyBinding c = NotificationAppEmptyBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.setText(spannableStringBuilder);
        c.b.setHighlightColor(0);
        c.b.setMovementMethod(LinkMovementMethod.getInstance());
        U0().i.addFooterView(new NotificationAppAdapter.NotificationAppHolder(c));
    }

    public final void Z0() {
        ULog.f6446a.g("PhoneNotifyFragment", "-----开始执行 query Package---");
        if (!this.k) {
            StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(123), false, false);
            this.k = true;
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new PhoneNotifyFragment$queryPackage$1(getResources().getInteger(R.integer.anim_time), this, (Continuation<? super PhoneNotifyFragment$queryPackage$1>) null), 3, (Object) null);
    }

    public final void a1() {
        String str = this.t;
        if (str.length() <= 0) {
            str = null;
        }
        if (str != null) {
            boolean e = AppConfigHelper.d.a().e(str);
            ArrayList arrayList = this.m;
            ArrayList arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                if (Intrinsics.areEqual((Object) ((AppInfoModel) next).getPackageName(), (Object) str)) {
                    arrayList2.add(next);
                }
            }
            ((AppInfoModel) CollectionsKt.first(arrayList2)).setDisableState(e);
            int indexOf = this.m.indexOf(CollectionsKt.first(arrayList2));
            NotificationAppAdapter notificationAppAdapter = this.r;
            if (notificationAppAdapter != null) {
                notificationAppAdapter.notifyItemChanged(indexOf);
            }
        }
        this.t = "";
    }

    public final void b1() {
        NotificationAppAdapter notificationAppAdapter = new NotificationAppAdapter(StaticMethodUtilsKt.i(this), this.m);
        notificationAppAdapter.m(new PhoneNotifyFragment$resetView$1$1(this));
        notificationAppAdapter.l(new PhoneNotifyFragment$resetView$1$2(this));
        this.r = notificationAppAdapter;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        FastScrollLetterRecyclerView fastScrollLetterRecyclerView = U0().i;
        fastScrollLetterRecyclerView.setLayoutManager(linearLayoutManager);
        fastScrollLetterRecyclerView.addOnScrollListener(new PhoneNotifyFragment$resetView$2$1(linearLayoutManager, this));
        fastScrollLetterRecyclerView.setAdapter(this.r);
        FastScrollLetter fastScrollLetter = U0().b;
        fastScrollLetter.setListView(U0().i);
        fastScrollLetter.initialize((ArrayList<String>) this.n, (ArrayList<ArrayList<Object>>) this.o);
        fastScrollLetter.getNavigationLayout().setCurrentLetter((String) this.n.get(0));
        fastScrollLetter.setNavigationLetters(this.s);
        fastScrollLetter.setOffsetCallBack(new m8(this));
        U0().i.post(new n8(linearLayoutManager, this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LinearLayout b = U0().getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        super.onDestroy();
        requireContext().unregisterReceiver(this.q);
        ProcessLifecycleOwner.i.a().getLifecycle().d(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onForeground() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("PhoneNotifyFragment", "onForeground--------");
        if (SuperNotificationManager.f7749a.C()) {
            delegate.g("PhoneNotifyFragment", "onResume 查询数据中.....");
            Z0();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.l.isEmpty()) {
            initView();
        }
        a1();
        PermissionAndStateCheckUtils.f7907a.h(this);
    }
}
