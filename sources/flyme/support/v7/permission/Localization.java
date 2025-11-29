package flyme.support.v7.permission;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class Localization {
    @DrawableRes
    private int mIconId;
    private String mLabel;
    @StringRes
    private int mLabelId;
    private int mPriority;

    public Localization(int i, String str, @DrawableRes int i2) {
        this.mPriority = i;
        this.mLabel = str;
        this.mIconId = i2;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public int getLabelId() {
        return this.mLabelId;
    }

    public String getLabelString(Context context) {
        return this.mLabelId != 0 ? context.getResources().getString(this.mLabelId) : this.mLabel;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public Localization(int i, int i2, int i3) {
        this.mPriority = i;
        this.mLabelId = i2;
        this.mIconId = i3;
    }
}
