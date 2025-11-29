package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.x8.x;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.adapter.StandbyWidgetRecyclerviewAdapter;
import com.upuphone.xr.sapp.databinding.BottomSheetStandbyComponentBinding;
import com.upuphone.xr.sapp.entity.StandbyWidgetInfo;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import flyme.support.v7.app.LitePopup;
import flyme.support.v7.app.LitePopupActivity;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013`\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/view/StandbyComponentBottomSheet;", "Lflyme/support/v7/app/LitePopupActivity;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDismissed", "onBackPressed", "onResume", "Lcom/upuphone/xr/sapp/databinding/BottomSheetStandbyComponentBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/BottomSheetStandbyComponentBinding;", "binding", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "b", "Ljava/util/LinkedHashMap;", "widgetsMap", "Ljava/util/LinkedList;", "Lcom/upuphone/xr/sapp/entity/StandbyWidgetInfo;", "c", "Ljava/util/LinkedList;", "widgetList", "Lcom/upuphone/xr/sapp/adapter/StandbyWidgetRecyclerviewAdapter;", "d", "Lcom/upuphone/xr/sapp/adapter/StandbyWidgetRecyclerviewAdapter;", "standbyWidgetRecyclerviewAdapter", "e", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStandbyComponentBottomSheet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandbyComponentBottomSheet.kt\ncom/upuphone/xr/sapp/view/StandbyComponentBottomSheet\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,149:1\n1855#2,2:150\n*S KotlinDebug\n*F\n+ 1 StandbyComponentBottomSheet.kt\ncom/upuphone/xr/sapp/view/StandbyComponentBottomSheet\n*L\n72#1:150,2\n*E\n"})
public final class StandbyComponentBottomSheet extends LitePopupActivity {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final String f = "StandbyComponentBottomSheet";
    public static final String g = "weather_1x1";
    public static final String h = "weather_1x2";
    public static final String i = "steps";
    public static final String j = "weekday";
    public static final String k = RtspHeaders.Values.TIME;
    public static final String l = "aiBall";
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    public static final int r = 6;
    public static ArrayList s = new ArrayList();
    public static StandbyComponentChange t;
    public static StandbyComponentBottomSheet u;

    /* renamed from: a  reason: collision with root package name */
    public BottomSheetStandbyComponentBinding f7987a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedList c = new LinkedList();
    public StandbyWidgetRecyclerviewAdapter d;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00078\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00078\u0006XD¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u00078\u0006XD¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00078\u0006XD¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00078\u0006XD¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u00078\u0006XD¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\u001e\u001a\u00020\u001d8\u0006XD¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001d8\u0006XD¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001a\u0010$\u001a\u00020\u001d8\u0006XD¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001a\u0010&\u001a\u00020\u001d8\u0006XD¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001a\u0010(\u001a\u00020\u001d8\u0006XD¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\u001a\u0010*\u001a\u00020\u001d8\u0006XD¢\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u00103R&\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/upuphone/xr/sapp/view/StandbyComponentBottomSheet$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "widgetsList", "Lcom/upuphone/xr/sapp/view/StandbyComponentChange;", "componentChange", "", "n", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/upuphone/xr/sapp/view/StandbyComponentChange;)V", "WIDGETS_WEATHER_1", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "WIDGETS_WEATHER_2", "j", "WIDGETS_STEPS", "d", "WIDGETS_WEEK", "l", "WIDGETS_TIME", "f", "WIDGETS_AIBALL", "b", "", "WIDGETS_TIME_ORDER", "I", "g", "()I", "WIDGETS_WEATHER_1_ORDER", "i", "WIDGETS_WEATHER_2_ORDER", "k", "WIDGETS_STEPS_ORDER", "e", "WIDGETS_WEEK_ORDER", "m", "WIDGETS_AIBALL_ORDER", "c", "Lcom/upuphone/xr/sapp/view/StandbyComponentBottomSheet;", "standbyComponentBottomSheet", "Lcom/upuphone/xr/sapp/view/StandbyComponentBottomSheet;", "a", "()Lcom/upuphone/xr/sapp/view/StandbyComponentBottomSheet;", "setStandbyComponentBottomSheet", "(Lcom/upuphone/xr/sapp/view/StandbyComponentBottomSheet;)V", "Lcom/upuphone/xr/sapp/view/StandbyComponentChange;", "widgets", "Ljava/util/ArrayList;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StandbyComponentBottomSheet a() {
            return StandbyComponentBottomSheet.u;
        }

        public final String b() {
            return StandbyComponentBottomSheet.l;
        }

        public final int c() {
            return StandbyComponentBottomSheet.r;
        }

        public final String d() {
            return StandbyComponentBottomSheet.i;
        }

        public final int e() {
            return StandbyComponentBottomSheet.p;
        }

        public final String f() {
            return StandbyComponentBottomSheet.k;
        }

        public final int g() {
            return StandbyComponentBottomSheet.m;
        }

        public final String h() {
            return StandbyComponentBottomSheet.g;
        }

        public final int i() {
            return StandbyComponentBottomSheet.n;
        }

        public final String j() {
            return StandbyComponentBottomSheet.h;
        }

        public final int k() {
            return StandbyComponentBottomSheet.o;
        }

        public final String l() {
            return StandbyComponentBottomSheet.j;
        }

        public final int m() {
            return StandbyComponentBottomSheet.q;
        }

        public final void n(Context context, ArrayList arrayList, StandbyComponentChange standbyComponentChange) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(arrayList, "widgetsList");
            StandbyComponentBottomSheet.s = arrayList;
            StandbyComponentBottomSheet.t = standbyComponentChange;
            context.startActivity(new Intent(context, StandbyComponentBottomSheet.class));
        }

        public Companion() {
        }
    }

    public static final void F0(StandbyComponentBottomSheet standbyComponentBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(standbyComponentBottomSheet, "this$0");
        StandbyComponentChange standbyComponentChange = t;
        if (standbyComponentChange != null) {
            standbyComponentChange.d();
        }
        StandbyComponentChange standbyComponentChange2 = t;
        if (standbyComponentChange2 != null) {
            standbyComponentChange2.f(standbyComponentBottomSheet.b);
        }
        StandbyComponentChange standbyComponentChange3 = t;
        if (standbyComponentChange3 != null) {
            standbyComponentChange3.c(standbyComponentBottomSheet.b);
        }
        standbyComponentBottomSheet.dismiss();
    }

    private final void initView() {
        this.c.add(new StandbyWidgetInfo(i, false, 0));
        this.c.add(new StandbyWidgetInfo(h, false, 1));
        this.c.add(new StandbyWidgetInfo(j, false, 0));
        this.c.add(new StandbyWidgetInfo(g, false, 0));
        for (String str : s) {
            String str2 = g;
            if (Intrinsics.areEqual((Object) str, (Object) str2)) {
                ((StandbyWidgetInfo) this.c.get(3)).setChecked(true);
                this.b.put(str2, 1);
            } else {
                String str3 = h;
                if (Intrinsics.areEqual((Object) str, (Object) str3)) {
                    ((StandbyWidgetInfo) this.c.get(1)).setChecked(true);
                    this.b.put(str3, 2);
                } else {
                    String str4 = i;
                    if (Intrinsics.areEqual((Object) str, (Object) str4)) {
                        ((StandbyWidgetInfo) this.c.get(0)).setChecked(true);
                        this.b.put(str4, 1);
                    } else {
                        String str5 = j;
                        if (Intrinsics.areEqual((Object) str, (Object) str5)) {
                            ((StandbyWidgetInfo) this.c.get(2)).setChecked(true);
                            this.b.put(str5, 1);
                        }
                    }
                }
            }
        }
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            this.c.remove(1);
            this.b.remove(h);
        }
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        if (!phoneTypeUtils.e() && !phoneTypeUtils.c() && !phoneTypeUtils.i()) {
            this.c.remove(0);
            this.b.remove(i);
            if (!bool.booleanValue()) {
                LinkedList linkedList = this.c;
                linkedList.addFirst(linkedList.getLast());
                this.c.removeLast();
            }
        }
        this.d = new StandbyWidgetRecyclerviewAdapter(this, this.c, this.b, t);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        BottomSheetStandbyComponentBinding bottomSheetStandbyComponentBinding = this.f7987a;
        StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter = null;
        if (bottomSheetStandbyComponentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bottomSheetStandbyComponentBinding = null;
        }
        bottomSheetStandbyComponentBinding.c.setLayoutManager(gridLayoutManager);
        BottomSheetStandbyComponentBinding bottomSheetStandbyComponentBinding2 = this.f7987a;
        if (bottomSheetStandbyComponentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bottomSheetStandbyComponentBinding2 = null;
        }
        RecyclerView recyclerView = bottomSheetStandbyComponentBinding2.c;
        StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter2 = this.d;
        if (standbyWidgetRecyclerviewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("standbyWidgetRecyclerviewAdapter");
        } else {
            standbyWidgetRecyclerviewAdapter = standbyWidgetRecyclerviewAdapter2;
        }
        recyclerView.setAdapter(standbyWidgetRecyclerviewAdapter);
    }

    public void onBackPressed() {
        super.onBackPressed();
        dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BottomSheetStandbyComponentBinding c2 = BottomSheetStandbyComponentBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f7987a = c2;
        BottomSheetStandbyComponentBinding bottomSheetStandbyComponentBinding = null;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        setContentView((View) c2.getRoot());
        u = this;
        LitePopup litePopup = getLitePopup();
        litePopup.setStyle(1);
        litePopup.setCancelable(false);
        litePopup.setCanceledOnTouchOutside(false);
        litePopup.hideTitleBar();
        initView();
        BottomSheetStandbyComponentBinding bottomSheetStandbyComponentBinding2 = this.f7987a;
        if (bottomSheetStandbyComponentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bottomSheetStandbyComponentBinding = bottomSheetStandbyComponentBinding2;
        }
        bottomSheetStandbyComponentBinding.b.setOnClickListener(new x(this));
    }

    public void onDismissed() {
        super.onDismissed();
        StandbyComponentChange standbyComponentChange = t;
        if (standbyComponentChange != null) {
            standbyComponentChange.e(this.b);
        }
    }

    public void onResume() {
        super.onResume();
        StandbyComponentChange standbyComponentChange = t;
        if (standbyComponentChange != null) {
            standbyComponentChange.b();
        }
    }
}
