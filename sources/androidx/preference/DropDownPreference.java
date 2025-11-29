package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DropDownPreference extends ListPreference {
    public final Context l;
    public final ArrayAdapter m;
    public Spinner n;
    public final AdapterView.OnItemSelectedListener o;

    public DropDownPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle);
    }

    public void notifyChanged() {
        super.notifyChanged();
        ArrayAdapter arrayAdapter = this.m;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        Spinner spinner = (Spinner) preferenceViewHolder.itemView.findViewById(R.id.spinner);
        this.n = spinner;
        spinner.setAdapter(this.m);
        this.n.setOnItemSelectedListener(this.o);
        this.n.setSelection(x(getValue()));
        super.onBindViewHolder(preferenceViewHolder);
    }

    public void onClick() {
        this.n.performClick();
    }

    public ArrayAdapter w() {
        return new ArrayAdapter(this.l, 17367049);
    }

    public final int x(String str) {
        CharSequence[] u = u();
        if (str == null || u == null) {
            return -1;
        }
        for (int length = u.length - 1; length >= 0; length--) {
            if (TextUtils.equals(u[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public final void y() {
        this.m.clear();
        if (s() != null) {
            for (CharSequence charSequence : s()) {
                this.m.add(charSequence.toString());
            }
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.o = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
                if (i >= 0) {
                    String charSequence = DropDownPreference.this.u()[i].toString();
                    if (!charSequence.equals(DropDownPreference.this.getValue()) && DropDownPreference.this.callChangeListener(charSequence)) {
                        DropDownPreference.this.setValue(charSequence);
                    }
                }
            }

            public void onNothingSelected(AdapterView adapterView) {
            }
        };
        this.l = context;
        this.m = w();
        y();
    }
}
