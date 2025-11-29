package androidx.preference;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.upuphone.runasone.relay.api.IntentKey;

public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    public EditText i;
    public CharSequence j;
    public final Runnable k = new Runnable() {
        public void run() {
            EditTextPreferenceDialogFragmentCompat.this.y0();
        }
    };
    public long l = -1;

    public static EditTextPreferenceDialogFragmentCompat w0(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString(IntentKey.ACTIVITY.ACTION_KEY, str);
        editTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    public boolean j0() {
        return true;
    }

    public void k0(View view) {
        super.k0(view);
        EditText editText = (EditText) view.findViewById(16908291);
        this.i = editText;
        if (editText != null) {
            editText.requestFocus();
            this.i.setText(this.j);
            EditText editText2 = this.i;
            editText2.setSelection(editText2.getText().length());
            if (u0().r() != null) {
                u0().r().a(this.i);
                return;
            }
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    public void m0(boolean z) {
        if (z) {
            String obj = this.i.getText().toString();
            EditTextPreference u0 = u0();
            if (u0.callChangeListener(obj)) {
                u0.t(obj);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.j = u0().s();
        } else {
            this.j = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.j);
    }

    public void s0() {
        z0(true);
        y0();
    }

    public final EditTextPreference u0() {
        return (EditTextPreference) i0();
    }

    public final boolean v0() {
        long j2 = this.l;
        return j2 != -1 && j2 + 1000 > SystemClock.currentThreadTimeMillis();
    }

    public void y0() {
        if (v0()) {
            EditText editText = this.i;
            if (editText == null || !editText.isFocused()) {
                z0(false);
            } else if (((InputMethodManager) this.i.getContext().getSystemService("input_method")).showSoftInput(this.i, 0)) {
                z0(false);
            } else {
                this.i.removeCallbacks(this.k);
                this.i.postDelayed(this.k, 50);
            }
        }
    }

    public final void z0(boolean z) {
        this.l = z ? SystemClock.currentThreadTimeMillis() : -1;
    }
}
