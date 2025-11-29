package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.upuphone.runasone.relay.api.IntentKey;

public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    public int i;
    public CharSequence[] j;
    public CharSequence[] k;

    public static ListPreferenceDialogFragmentCompat v0(String str) {
        ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = new ListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString(IntentKey.ACTIVITY.ACTION_KEY, str);
        listPreferenceDialogFragmentCompat.setArguments(bundle);
        return listPreferenceDialogFragmentCompat;
    }

    public void m0(boolean z) {
        int i2;
        if (z && (i2 = this.i) >= 0) {
            String charSequence = this.k[i2].toString();
            ListPreference u0 = u0();
            if (u0.callChangeListener(charSequence)) {
                u0.setValue(charSequence);
            }
        }
    }

    public void n0(AlertDialog.Builder builder) {
        super.n0(builder);
        builder.setSingleChoiceItems(this.j, this.i, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = ListPreferenceDialogFragmentCompat.this;
                listPreferenceDialogFragmentCompat.i = i;
                listPreferenceDialogFragmentCompat.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference u0 = u0();
            if (u0.s() == null || u0.u() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.i = u0.r(u0.getValue());
            this.j = u0.s();
            this.k = u0.u();
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

    public final ListPreference u0() {
        return (ListPreference) i0();
    }
}
