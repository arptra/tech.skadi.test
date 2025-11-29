package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;

@RestrictTo
public interface MenuItemHoverListener {
    void a(MenuBuilder menuBuilder, MenuItem menuItem);

    void d(MenuBuilder menuBuilder, MenuItem menuItem);
}
