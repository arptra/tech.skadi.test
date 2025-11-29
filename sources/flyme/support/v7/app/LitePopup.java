package flyme.support.v7.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface LitePopup {
    public static final int STYLE_BOTH = 0;
    public static final int STYLE_ONLY_MIDDLE = 1;
    public static final int STYLE_ONLY_TOP = 2;

    public interface OnDismissedListener {
        void onDismissProgress(float f);

        void onDismissed(boolean z);

        void onDragTriggered();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleState {
    }

    void addDimLayer();

    void cancelDrag();

    int getUncollapsibleHeight();

    void hideTitleBar();

    void onBackPressed();

    void removeDimLayer();

    void setCancelable(boolean z);

    void setCanceledOnTouchOutside(boolean z);

    void setScrollPopupFirstOnTop(boolean z);

    void setScrollToDismissEnabled(boolean z);

    void setStyle(int i);

    void setUncollapsibleHeight(int i);

    void showTitleBar();

    void unLimitMiddleOnlyHeight();
}
