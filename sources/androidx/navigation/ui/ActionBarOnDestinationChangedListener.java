package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/navigation/ui/ActionBarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "", "title", "", "c", "(Ljava/lang/CharSequence;)V", "Landroid/graphics/drawable/Drawable;", "icon", "", "contentDescription", "b", "(Landroid/graphics/drawable/Drawable;I)V", "Landroidx/appcompat/app/AppCompatActivity;", "f", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "navigation-ui_release"}, k = 1, mv = {1, 6, 0})
@RestrictTo
public final class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    public final AppCompatActivity f;

    public void b(Drawable drawable, int i) {
        ActionBar supportActionBar = this.f.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.p(drawable != null);
            ActionBarDrawerToggle.Delegate drawerToggleDelegate = this.f.getDrawerToggleDelegate();
            if (drawerToggleDelegate != null) {
                drawerToggleDelegate.setActionBarUpIndicator(drawable, i);
                return;
            }
            throw new IllegalStateException(("Activity " + this.f + " does not have an DrawerToggleDelegate set").toString());
        }
        throw new IllegalStateException(("Activity " + this.f + " does not have an ActionBar set via setSupportActionBar()").toString());
    }

    public void c(CharSequence charSequence) {
        ActionBar supportActionBar = this.f.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.x(charSequence);
            return;
        }
        throw new IllegalStateException(("Activity " + this.f + " does not have an ActionBar set via setSupportActionBar()").toString());
    }
}
