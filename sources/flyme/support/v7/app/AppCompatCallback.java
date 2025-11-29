package flyme.support.v7.app;

import androidx.annotation.Nullable;
import flyme.support.v7.view.ActionMode;
import flyme.support.v7.view.menu.FMenu;
import flyme.support.v7.view.menu.FMenuItem;

public interface AppCompatCallback {
    void onBackTopTouch();

    boolean onBottomItemSelected(FMenuItem fMenuItem);

    boolean onCreateBottomMenu(FMenu fMenu);

    boolean onMenuItemSelected(int i, FMenuItem fMenuItem);

    void onOptionsMenuCreated(FMenu fMenu);

    void onSupportActionModeFinished(ActionMode actionMode);

    void onSupportActionModeStarted(ActionMode actionMode);

    @Nullable
    ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback);
}
