package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;

public class ShareActionProvider extends ActionProvider {

    /* renamed from: a  reason: collision with root package name */
    public int f357a;
    public final ShareMenuItemOnMenuItemClickListener b;
    public final Context c;
    public String d;
    public OnShareTargetSelectedListener e;

    public interface OnShareTargetSelectedListener {
        boolean a(ShareActionProvider shareActionProvider, Intent intent);
    }

    public class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShareActionProvider f358a;

        public boolean a(ActivityChooserModel activityChooserModel, Intent intent) {
            ShareActionProvider shareActionProvider = this.f358a;
            OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.e;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.a(shareActionProvider, intent);
            return false;
        }
    }

    public class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShareActionProvider f359a;

        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = this.f359a;
            Intent b = ActivityChooserModel.d(shareActionProvider.c, shareActionProvider.d).b(menuItem.getItemId());
            if (b == null) {
                return true;
            }
            String action = b.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                this.f359a.a(b);
            }
            this.f359a.c.startActivity(b);
            return true;
        }
    }

    public void a(Intent intent) {
        intent.addFlags(134742016);
    }

    public boolean hasSubMenu() {
        return true;
    }

    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.c);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.d(this.c, this.d));
        }
        TypedValue typedValue = new TypedValue();
        this.c.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.b(this.c, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel d2 = ActivityChooserModel.d(this.c, this.d);
        PackageManager packageManager = this.c.getPackageManager();
        int f = d2.f();
        int min = Math.min(f, this.f357a);
        for (int i = 0; i < min; i++) {
            ResolveInfo e2 = d2.e(i);
            subMenu.add(0, i, i, e2.loadLabel(packageManager)).setIcon(e2.loadIcon(packageManager)).setOnMenuItemClickListener(this.b);
        }
        if (min < f) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.c.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < f; i2++) {
                ResolveInfo e3 = d2.e(i2);
                addSubMenu.add(0, i2, i2, e3.loadLabel(packageManager)).setIcon(e3.loadIcon(packageManager)).setOnMenuItemClickListener(this.b);
            }
        }
    }
}
