package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    public Set i = new HashSet();
    public boolean j;
    public CharSequence[] k;
    public CharSequence[] l;

    public static MultiSelectListPreferenceDialogFragmentCompat v0(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString(IntentKey.ACTIVITY.ACTION_KEY, str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    public void m0(boolean z) {
        if (z && this.j) {
            MultiSelectListPreference u0 = u0();
            if (u0.callChangeListener(this.i)) {
                u0.u(this.i);
            }
        }
        this.j = false;
    }

    public void n0(AlertDialog.Builder builder) {
        super.n0(builder);
        int length = this.l.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.i.contains(this.l[i2].toString());
        }
        builder.setMultiChoiceItems(this.k, zArr, (DialogInterface.OnMultiChoiceClickListener) new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                    multiSelectListPreferenceDialogFragmentCompat.j |= multiSelectListPreferenceDialogFragmentCompat.i.add(multiSelectListPreferenceDialogFragmentCompat.l[i].toString());
                    return;
                }
                MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat2 = MultiSelectListPreferenceDialogFragmentCompat.this;
                multiSelectListPreferenceDialogFragmentCompat2.j |= multiSelectListPreferenceDialogFragmentCompat2.i.remove(multiSelectListPreferenceDialogFragmentCompat2.l[i].toString());
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference u0 = u0();
            if (u0.r() == null || u0.s() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.i.clear();
            this.i.addAll(u0.t());
            this.j = false;
            this.k = u0.r();
            this.l = u0.s();
            return;
        }
        this.i.clear();
        this.i.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.j = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.k = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList(this.i));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.j);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.l);
    }

    public final MultiSelectListPreference u0() {
        return (MultiSelectListPreference) i0();
    }
}
