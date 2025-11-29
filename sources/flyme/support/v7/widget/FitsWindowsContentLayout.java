package flyme.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import androidx.appcompat.widget.ContentFrameLayout;

public class FitsWindowsContentLayout extends ContentFrameLayout {
    private OnStartActionModeListener mOnStartActionModeListener;

    public interface OnStartActionModeListener {
        ActionMode onContentStartingActionMode(ActionMode.Callback callback);

        ActionMode onContentStartingActionMode(ActionMode.Callback callback, int i);
    }

    public FitsWindowsContentLayout(Context context) {
        super(context);
    }

    public void makeOptionalFitsSystemWindows() {
    }

    public void setOnStartActionModeListener(OnStartActionModeListener onStartActionModeListener) {
        this.mOnStartActionModeListener = onStartActionModeListener;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        OnStartActionModeListener onStartActionModeListener = this.mOnStartActionModeListener;
        ActionMode onContentStartingActionMode = onStartActionModeListener != null ? onStartActionModeListener.onContentStartingActionMode(callback, 0) : null;
        return onContentStartingActionMode == null ? super.startActionModeForChild(view, callback) : onContentStartingActionMode;
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
