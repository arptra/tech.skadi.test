package com.upuphone.xr.sapp.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import com.honey.account.g8.a;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.adapter.ScheduleColoAdapter;
import com.upuphone.xr.sapp.databinding.DialogEditScheduleBinding;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import flyme.support.v7.app.LitePopup;
import flyme.support.v7.app.LitePopupActivity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0003J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/dialog/EditScheduleDialog;", "Lflyme/support/v7/app/LitePopupActivity;", "<init>", "()V", "Landroid/view/View;", "view", "", "setupContentView", "(Landroid/view/View;)V", "getContentView", "()Landroid/view/View;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Landroidx/core/view/WindowInsetsCompat;", "windowInsets", "m0", "(Landroidx/core/view/WindowInsetsCompat;)V", "Lcom/upuphone/xr/sapp/databinding/DialogEditScheduleBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/DialogEditScheduleBinding;", "binding", "Lcom/upuphone/xr/sapp/adapter/ScheduleColoAdapter;", "b", "Lcom/upuphone/xr/sapp/adapter/ScheduleColoAdapter;", "adapter", "", "c", "Ljava/lang/String;", "scheduleAccountId", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "d", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "localScheduleModel", "e", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nEditScheduleDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditScheduleDialog.kt\ncom/upuphone/xr/sapp/dialog/EditScheduleDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,126:1\n288#2,2:127\n*S KotlinDebug\n*F\n+ 1 EditScheduleDialog.kt\ncom/upuphone/xr/sapp/dialog/EditScheduleDialog\n*L\n51#1:127,2\n*E\n"})
public final class EditScheduleDialog extends LitePopupActivity {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public DialogEditScheduleBinding f6934a;
    public ScheduleColoAdapter b;
    public String c = "";
    public LocalScheduleModel d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/dialog/EditScheduleDialog$Companion;", "", "()V", "PARAM_ID_KEY", "", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final View getContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    public static final WindowInsetsCompat n0(EditScheduleDialog editScheduleDialog, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(editScheduleDialog, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        editScheduleDialog.m0(windowInsetsCompat);
        return WindowInsetsCompat.b;
    }

    private final void setupContentView(View view) {
        if (view != null) {
            ViewCompat.M0(view, new a(this));
        }
    }

    public final void initView() {
        DialogEditScheduleBinding dialogEditScheduleBinding;
        Object obj;
        String stringExtra = getIntent().getStringExtra("ID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.c = stringExtra;
        Iterator it = ScheduleAccountManager.f7776a.e().iterator();
        while (true) {
            dialogEditScheduleBinding = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((LocalScheduleModel) obj).c(), (Object) this.c)) {
                break;
            }
        }
        LocalScheduleModel localScheduleModel = (LocalScheduleModel) obj;
        if (localScheduleModel != null) {
            this.d = localScheduleModel;
            ScheduleColoAdapter scheduleColoAdapter = new ScheduleColoAdapter();
            this.b = scheduleColoAdapter;
            Intrinsics.checkNotNull(scheduleColoAdapter);
            ScheduleColoAdapter scheduleColoAdapter2 = this.b;
            Intrinsics.checkNotNull(scheduleColoAdapter2);
            scheduleColoAdapter.m(scheduleColoAdapter2.h().indexOf(localScheduleModel.a()));
            DialogEditScheduleBinding dialogEditScheduleBinding2 = this.f6934a;
            if (dialogEditScheduleBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogEditScheduleBinding2 = null;
            }
            dialogEditScheduleBinding2.c.setLayoutManager(new GridLayoutManager(this, 6));
            DialogEditScheduleBinding dialogEditScheduleBinding3 = this.f6934a;
            if (dialogEditScheduleBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogEditScheduleBinding3 = null;
            }
            dialogEditScheduleBinding3.c.setAdapter(this.b);
            if (getLitePopup() != null) {
                getLitePopup().setScrollPopupFirstOnTop(true);
                getLitePopup().showTitleBar();
                getLitePopup().setCancelable(false);
                getLitePopup().setCanceledOnTouchOutside(false);
            }
            DialogEditScheduleBinding dialogEditScheduleBinding4 = this.f6934a;
            if (dialogEditScheduleBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogEditScheduleBinding4 = null;
            }
            dialogEditScheduleBinding4.b.setOnDrawableClickListener(new EditScheduleDialog$initView$2$1(this));
            DialogEditScheduleBinding dialogEditScheduleBinding5 = this.f6934a;
            if (dialogEditScheduleBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogEditScheduleBinding = dialogEditScheduleBinding5;
            }
            dialogEditScheduleBinding.b.setText(localScheduleModel.b());
        }
    }

    public final void m0(WindowInsetsCompat windowInsetsCompat) {
        boolean q = windowInsetsCompat.q(WindowInsetsCompat.Type.a());
        Insets f = windowInsetsCompat.f(WindowInsetsCompat.Type.a());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("EditScheduleDialog", "onApplyWindowInsets2, isImeVisible: " + q + ", insets: " + f);
        if (q) {
            LitePopup litePopup = getLitePopup();
            litePopup.setUncollapsibleHeight(litePopup.getUncollapsibleHeight() + f.d);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogEditScheduleBinding c2 = DialogEditScheduleBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6934a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        setContentView((View) c2.getRoot());
        initView();
        setupContentView(getContentView());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_schedule_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != R.id.edit_add_confirm) {
            return super.onOptionsItemSelected(menuItem);
        }
        LocalScheduleModel localScheduleModel = this.d;
        if (localScheduleModel != null) {
            DialogEditScheduleBinding dialogEditScheduleBinding = this.f6934a;
            if (dialogEditScheduleBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogEditScheduleBinding = null;
            }
            String valueOf = String.valueOf(dialogEditScheduleBinding.b.getText());
            if (valueOf.length() > 0) {
                localScheduleModel.h(valueOf);
            }
            ScheduleColoAdapter scheduleColoAdapter = this.b;
            Intrinsics.checkNotNull(scheduleColoAdapter);
            ArrayList h = scheduleColoAdapter.h();
            ScheduleColoAdapter scheduleColoAdapter2 = this.b;
            Intrinsics.checkNotNull(scheduleColoAdapter2);
            Object obj = h.get(scheduleColoAdapter2.i());
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            localScheduleModel.g((String) obj);
            ScheduleAccountManager.f7776a.h(localScheduleModel);
        }
        finish();
        return true;
    }
}
