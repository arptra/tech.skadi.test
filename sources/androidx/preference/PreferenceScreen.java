package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceManager;

public final class PreferenceScreen extends PreferenceGroup {
    public boolean j = true;

    @RestrictTo
    public PreferenceScreen(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.a(context, R.attr.preferenceScreenStyle, 16842891));
    }

    public void onClick() {
        PreferenceManager.OnNavigateToScreenListener g;
        if (getIntent() == null && getFragment() == null && p() != 0 && (g = getPreferenceManager().g()) != null) {
            g.M(this);
        }
    }

    public boolean q() {
        return false;
    }

    public boolean t() {
        return this.j;
    }
}
