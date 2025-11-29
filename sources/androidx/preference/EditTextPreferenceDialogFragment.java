package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.upuphone.runasone.relay.api.IntentKey;

@Deprecated
public class EditTextPreferenceDialogFragment extends PreferenceDialogFragment {
    public EditText i;
    public CharSequence j;

    public static EditTextPreferenceDialogFragment i(String str) {
        EditTextPreferenceDialogFragment editTextPreferenceDialogFragment = new EditTextPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString(IntentKey.ACTIVITY.ACTION_KEY, str);
        editTextPreferenceDialogFragment.setArguments(bundle);
        return editTextPreferenceDialogFragment;
    }

    public boolean b() {
        return true;
    }

    public void c(View view) {
        super.c(view);
        EditText editText = (EditText) view.findViewById(16908291);
        this.i = editText;
        editText.requestFocus();
        EditText editText2 = this.i;
        if (editText2 != null) {
            editText2.setText(this.j);
            EditText editText3 = this.i;
            editText3.setSelection(editText3.getText().length());
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    public void e(boolean z) {
        if (z) {
            String obj = this.i.getText().toString();
            if (h().callChangeListener(obj)) {
                h().t(obj);
            }
        }
    }

    public final EditTextPreference h() {
        return (EditTextPreference) a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.j = h().s();
        } else {
            this.j = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.j);
    }
}
