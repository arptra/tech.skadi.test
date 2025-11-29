package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.upuphone.runasone.relay.api.IntentKey;

@Deprecated
public class ListPreferenceDialogFragment extends PreferenceDialogFragment {
    public int i;
    public CharSequence[] j;
    public CharSequence[] k;

    public static ListPreferenceDialogFragment i(String str) {
        ListPreferenceDialogFragment listPreferenceDialogFragment = new ListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString(IntentKey.ACTIVITY.ACTION_KEY, str);
        listPreferenceDialogFragment.setArguments(bundle);
        return listPreferenceDialogFragment;
    }

    public void e(boolean z) {
        int i2;
        ListPreference h = h();
        if (z && (i2 = this.i) >= 0) {
            String charSequence = this.k[i2].toString();
            if (h.callChangeListener(charSequence)) {
                h.setValue(charSequence);
            }
        }
    }

    public void f(AlertDialog.Builder builder) {
        super.f(builder);
        builder.setSingleChoiceItems(this.j, this.i, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ListPreferenceDialogFragment listPreferenceDialogFragment = ListPreferenceDialogFragment.this;
                listPreferenceDialogFragment.i = i;
                listPreferenceDialogFragment.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    public final ListPreference h() {
        return (ListPreference) a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference h = h();
            if (h.s() == null || h.u() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.i = h.r(h.getValue());
            this.j = h.s();
            this.k = h.u();
            return;
        }
        this.i = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.j = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.k = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.i);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.j);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.k);
    }
}
