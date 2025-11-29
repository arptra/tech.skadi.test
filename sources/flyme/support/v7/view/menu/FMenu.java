package flyme.support.v7.view.menu;

import android.view.Menu;

public interface FMenu extends Menu {
    FMenuItem findFMenuItem(int i);

    void setOptionalIconsVisible(boolean z);
}
