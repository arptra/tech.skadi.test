package com.upuphone.xr.sapp.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.h8.a2;
import com.honey.account.h8.b2;
import com.honey.account.h8.c2;
import com.honey.account.h8.d2;
import com.honey.account.h8.e2;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentEditScheduleBinding;
import com.upuphone.xr.sapp.dialog.EditScheduleDialog;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import flyme.support.v7.app.ShowAtBottomAlertDialog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/EditScheduleFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "j", "Ljava/lang/String;", "scheduleAccountId", "Lcom/upuphone/xr/sapp/databinding/FragmentEditScheduleBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentEditScheduleBinding;", "binding", "l", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nEditScheduleFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditScheduleFragment.kt\ncom/upuphone/xr/sapp/fragment/EditScheduleFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n288#2,2:98\n*S KotlinDebug\n*F\n+ 1 EditScheduleFragment.kt\ncom/upuphone/xr/sapp/fragment/EditScheduleFragment\n*L\n58#1:98,2\n*E\n"})
public final class EditScheduleFragment extends BaseFragment {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);
    public String j = "";
    public FragmentEditScheduleBinding k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/EditScheduleFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType[] r0 = com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType r1 = com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType.feishu     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType r1 = com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType.dingding     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType r1 = com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType.calendar     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.EditScheduleFragment.WhenMappings.<clinit>():void");
        }
    }

    public static final void F0(EditScheduleFragment editScheduleFragment, View view) {
        Intrinsics.checkNotNullParameter(editScheduleFragment, "this$0");
        FragmentKt.a(editScheduleFragment).T();
    }

    public static final void G0(LocalScheduleModel localScheduleModel, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(localScheduleModel, "$scheduleAccount");
        localScheduleModel.i(z);
        ScheduleAccountManager.f7776a.h(localScheduleModel);
    }

    public static final void H0(EditScheduleFragment editScheduleFragment, View view) {
        Intrinsics.checkNotNullParameter(editScheduleFragment, "this$0");
        String string = editScheduleFragment.getString(R.string.edit_schedule_del_content);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CharSequence[] charSequenceArr = {string};
        new ShowAtBottomAlertDialog.Builder(editScheduleFragment.requireContext()).setTitle((CharSequence) editScheduleFragment.getString(R.string.edit_schedule_del_desc)).setItems(charSequenceArr, (DialogInterface.OnClickListener) new e2(editScheduleFragment), true, new ColorStateList[]{editScheduleFragment.getResources().getColorStateList(R.color.red)}).show();
    }

    public static final void I0(EditScheduleFragment editScheduleFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(editScheduleFragment, "this$0");
        ScheduleAccountManager.f7776a.g(editScheduleFragment.j);
        FragmentKt.a(editScheduleFragment).T();
    }

    public static final void J0(EditScheduleFragment editScheduleFragment, View view) {
        Intrinsics.checkNotNullParameter(editScheduleFragment, "this$0");
        Intent intent = new Intent(editScheduleFragment.requireActivity(), EditScheduleDialog.class);
        intent.putExtra("ID", editScheduleFragment.j);
        editScheduleFragment.startActivity(intent);
    }

    private final void initView() {
        Object obj;
        int i;
        ULog.f6446a.a("EditScheduleFragment", "initView");
        FragmentEditScheduleBinding fragmentEditScheduleBinding = this.k;
        FragmentEditScheduleBinding fragmentEditScheduleBinding2 = null;
        if (fragmentEditScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEditScheduleBinding = null;
        }
        fragmentEditScheduleBinding.b.setOnClickListener(new a2(this));
        Iterator it = ScheduleAccountManager.f7776a.e().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((LocalScheduleModel) obj).c(), (Object) this.j)) {
                break;
            }
        }
        LocalScheduleModel localScheduleModel = (LocalScheduleModel) obj;
        if (localScheduleModel != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[localScheduleModel.e().ordinal()];
            if (i2 == 1) {
                i = R.drawable.import_schedule_fs;
            } else if (i2 == 2) {
                i = R.drawable.import_schedule_dd;
            } else if (i2 == 3) {
                i = R.drawable.import_schedule_dd;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            FragmentEditScheduleBinding fragmentEditScheduleBinding3 = this.k;
            if (fragmentEditScheduleBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentEditScheduleBinding3 = null;
            }
            fragmentEditScheduleBinding3.g.setImageResource(i);
            FragmentEditScheduleBinding fragmentEditScheduleBinding4 = this.k;
            if (fragmentEditScheduleBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentEditScheduleBinding4 = null;
            }
            fragmentEditScheduleBinding4.e.setChecked(localScheduleModel.f());
            FragmentEditScheduleBinding fragmentEditScheduleBinding5 = this.k;
            if (fragmentEditScheduleBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentEditScheduleBinding5 = null;
            }
            fragmentEditScheduleBinding5.h.setText(localScheduleModel.b());
            FragmentEditScheduleBinding fragmentEditScheduleBinding6 = this.k;
            if (fragmentEditScheduleBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentEditScheduleBinding6 = null;
            }
            fragmentEditScheduleBinding6.j.setBackgroundColor(Color.parseColor(localScheduleModel.a()));
            FragmentEditScheduleBinding fragmentEditScheduleBinding7 = this.k;
            if (fragmentEditScheduleBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentEditScheduleBinding7 = null;
            }
            fragmentEditScheduleBinding7.e.setOnCheckedChangeListener(new b2(localScheduleModel));
            FragmentEditScheduleBinding fragmentEditScheduleBinding8 = this.k;
            if (fragmentEditScheduleBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentEditScheduleBinding8 = null;
            }
            fragmentEditScheduleBinding8.f.setOnClickListener(new c2(this));
            FragmentEditScheduleBinding fragmentEditScheduleBinding9 = this.k;
            if (fragmentEditScheduleBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentEditScheduleBinding2 = fragmentEditScheduleBinding9;
            }
            fragmentEditScheduleBinding2.i.setOnClickListener(new d2(this));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentEditScheduleBinding c = FragmentEditScheduleBinding.c(layoutInflater, viewGroup, false);
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

    public void onResume() {
        super.onResume();
        initView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("id", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.j = string;
        }
    }
}
