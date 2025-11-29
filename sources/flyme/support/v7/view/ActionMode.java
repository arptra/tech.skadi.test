package flyme.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class ActionMode {
    private boolean mAnimateToShowMenu = true;
    private BackPressedListener mBackListener;
    private Object mTag;
    private boolean mTitleOptionalHint;

    public interface BackPressedListener {
        boolean onBackPressed();
    }

    public interface Callback {
        boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem);

        boolean onCreateActionMode(ActionMode actionMode, Menu menu);

        void onDestroyActionMode(ActionMode actionMode);

        boolean onPrepareActionMode(ActionMode actionMode, Menu menu);
    }

    public abstract void finish();

    public BackPressedListener getBackPressListener() {
        return this.mBackListener;
    }

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public Object getTag() {
        return this.mTag;
    }

    public abstract CharSequence getTitle();

    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }

    public abstract void invalidate();

    public boolean isAnimateToShowMenu() {
        return this.mAnimateToShowMenu;
    }

    public boolean isShowActionBar() {
        return true;
    }

    public boolean isTitleOptional() {
        return false;
    }

    public boolean isUiFocusable() {
        return true;
    }

    public void setAnimateToShowMenu(boolean z) {
        this.mAnimateToShowMenu = z;
    }

    public void setBackPressListener(BackPressedListener backPressedListener) {
        this.mBackListener = backPressedListener;
    }

    public abstract void setCustomView(View view);

    public void setShowActionBar(boolean z) {
    }

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charSequence);

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charSequence);

    public void setTitleOptionalHint(boolean z) {
        this.mTitleOptionalHint = z;
    }
}
