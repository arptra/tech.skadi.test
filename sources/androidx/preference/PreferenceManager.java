package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;

public class PreferenceManager {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1689a;
    public long b = 0;
    public SharedPreferences c;
    public PreferenceDataStore d;
    public SharedPreferences.Editor e;
    public boolean f;
    public String g;
    public int h;
    public int i = 0;
    public PreferenceScreen j;
    public PreferenceComparisonCallback k;
    public OnPreferenceTreeClickListener l;
    public OnDisplayPreferenceDialogListener m;
    public OnNavigateToScreenListener n;

    public interface OnDisplayPreferenceDialogListener {
        void w(Preference preference);
    }

    public interface OnNavigateToScreenListener {
        void M(PreferenceScreen preferenceScreen);
    }

    public interface OnPreferenceTreeClickListener {
        boolean A(Preference preference);
    }

    public static abstract class PreferenceComparisonCallback {
        public abstract boolean a(Preference preference, Preference preference2);

        public abstract boolean b(Preference preference, Preference preference2);
    }

    public static class SimplePreferenceComparisonCallback extends PreferenceComparisonCallback {
        public boolean a(Preference preference, Preference preference2) {
            if (preference.getClass() != preference2.getClass()) {
                return false;
            }
            if ((preference == preference2 && preference.wasDetached()) || !TextUtils.equals(preference.getTitle(), preference2.getTitle()) || !TextUtils.equals(preference.getSummary(), preference2.getSummary())) {
                return false;
            }
            Drawable icon = preference.getIcon();
            Drawable icon2 = preference2.getIcon();
            if ((icon != icon2 && (icon == null || !icon.equals(icon2))) || preference.isEnabled() != preference2.isEnabled() || preference.isSelectable() != preference2.isSelectable()) {
                return false;
            }
            if (!(preference instanceof TwoStatePreference) || ((TwoStatePreference) preference).isChecked() == ((TwoStatePreference) preference2).isChecked()) {
                return !(preference instanceof DropDownPreference) || preference == preference2;
            }
            return false;
        }

        public boolean b(Preference preference, Preference preference2) {
            return preference.getId() == preference2.getId();
        }
    }

    public PreferenceManager(Context context) {
        this.f1689a = context;
        p(d(context));
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences(d(context), c());
    }

    public static int c() {
        return 0;
    }

    public static String d(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public Preference a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.j;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.l(charSequence);
    }

    public SharedPreferences.Editor e() {
        if (this.d != null) {
            return null;
        }
        if (!this.f) {
            return l().edit();
        }
        if (this.e == null) {
            this.e = l().edit();
        }
        return this.e;
    }

    public long f() {
        long j2;
        synchronized (this) {
            j2 = this.b;
            this.b = 1 + j2;
        }
        return j2;
    }

    public OnNavigateToScreenListener g() {
        return this.n;
    }

    public OnPreferenceTreeClickListener h() {
        return this.l;
    }

    public PreferenceComparisonCallback i() {
        return this.k;
    }

    public PreferenceDataStore j() {
        return this.d;
    }

    public PreferenceScreen k() {
        return this.j;
    }

    public SharedPreferences l() {
        if (j() != null) {
            return null;
        }
        if (this.c == null) {
            this.c = (this.i != 1 ? this.f1689a : ContextCompat.createDeviceProtectedStorageContext(this.f1689a)).getSharedPreferences(this.g, this.h);
        }
        return this.c;
    }

    public void m(OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener) {
        this.m = onDisplayPreferenceDialogListener;
    }

    public void n(OnNavigateToScreenListener onNavigateToScreenListener) {
        this.n = onNavigateToScreenListener;
    }

    public void o(OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        this.l = onPreferenceTreeClickListener;
    }

    public void p(String str) {
        this.g = str;
        this.c = null;
    }

    public boolean q() {
        return !this.f;
    }

    public void r(Preference preference) {
        OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener = this.m;
        if (onDisplayPreferenceDialogListener != null) {
            onDisplayPreferenceDialogListener.w(preference);
        }
    }
}
