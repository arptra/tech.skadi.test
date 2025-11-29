package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {
    public Set i = new HashSet();
    public boolean j;
    public CharSequence[] k;
    public CharSequence[] l;

    public static MultiSelectListPreferenceDialogFragment i(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString(IntentKey.ACTIVITY.ACTION_KEY, str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    public void e(boolean z) {
        MultiSelectListPreference h = h();
        if (z && this.j) {
            Set set = this.i;
            if (h.callChangeListener(set)) {
                h.u(set);
            }
        }
        this.j = false;
    }

    public void f(AlertDialog.Builder builder) {
        super.f(builder);
        int length = this.l.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.i.contains(this.l[i2].toString());
        }
        builder.setMultiChoiceItems(this.k, zArr, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                    multiSelectListPreferenceDialogFragment.j |= multiSelectListPreferenceDialogFragment.i.add(multiSelectListPreferenceDialogFragment.l[i].toString());
                    return;
                }
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = MultiSelectListPreferenceDialogFragment.this;
                multiSelectListPreferenceDialogFragment2.j |= multiSelectListPreferenceDialogFragment2.i.remove(multiSelectListPreferenceDialogFragment2.l[i].toString());
            }
        });
    }

    public final MultiSelectListPreference h() {
        return (MultiSelectListPreference) a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference h = h();
            if (h.r() == null || h.s() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.i.clear();
            this.i.addAll(h.t());
            this.j = false;
            this.k = h.r();
            this.l = h.s();
            return;
        }
        this.i.clear();
        this.i.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragment.values"));
        this.j = bundle.getBoolean("MultiSelectListPreferenceDialogFragment.changed", false);
        this.k = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries");
        this.l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragment.values", new ArrayList(this.i));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragment.changed", this.j);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries", this.k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues", this.l);
    }
}
