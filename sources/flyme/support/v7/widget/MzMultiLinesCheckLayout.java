package flyme.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.upuphone.starrynet.common.StarryNetConstant;
import flyme.support.v7.appcompat.R;
import java.util.Objects;

@RestrictTo
public class MzMultiLinesCheckLayout extends LinearLayout {
    private static boolean mIsPoleStarTheme = false;
    private boolean mChecked;

    public MzMultiLinesCheckLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static boolean isPoleStarTheme() {
        Class<String> cls = String.class;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{"ro.flyme.build.channel", StarryNetConstant.DEVICE_NAME_UNKNOWN});
            Objects.requireNonNull(invoke);
            return invoke.toString().contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setChecked(boolean z) {
        this.mChecked = z;
        if (!z) {
            ViewCompat.z0(this, getResources().getDrawable(R.drawable.mz_alert_dialog_multi_lines_checked_radius_item_bg));
        } else if (!mIsPoleStarTheme) {
            ViewCompat.z0(this, getResources().getDrawable(R.drawable.mz_alert_dialog_multi_lines_normal_radius_item_bg));
        } else {
            ViewCompat.z0(this, getResources().getDrawable(R.drawable.mz_alert_dialog_multi_lines_normal_radius_item_bg_polestar));
        }
    }

    public void toggle() {
        setChecked(!this.mChecked);
    }

    public MzMultiLinesCheckLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MzMultiLinesCheckLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChecked = false;
        setBackgroundResource(R.drawable.mz_alert_dialog_listview_item_bg_radius);
        mIsPoleStarTheme = isPoleStarTheme();
    }
}
