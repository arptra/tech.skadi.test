package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

public class ListPreference extends DialogPreference {
    public CharSequence[] g;
    public CharSequence[] h;
    public String i;
    public String j;
    public boolean k;

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<ListPreference> {

        /* renamed from: a  reason: collision with root package name */
        public static SimpleSummaryProvider f1657a;

        public static SimpleSummaryProvider b() {
            if (f1657a == null) {
                f1657a = new SimpleSummaryProvider();
            }
            return f1657a;
        }

        /* renamed from: c */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.t()) ? listPreference.getContext().getString(R.string.not_set) : listPreference.t();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, i2, i3);
        this.g = TypedArrayUtils.o(obtainStyledAttributes, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
        this.h = TypedArrayUtils.o(obtainStyledAttributes, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
        int i4 = R.styleable.ListPreference_useSimpleSummaryProvider;
        if (TypedArrayUtils.b(obtainStyledAttributes, i4, i4, false)) {
            setSummaryProvider(SimpleSummaryProvider.b());
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i2, i3);
        this.j = TypedArrayUtils.m(obtainStyledAttributes2, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().a(this);
        }
        Object t = t();
        CharSequence summary = super.getSummary();
        String str = this.j;
        if (str == null) {
            return summary;
        }
        if (t == null) {
            t = "";
        }
        String format = String.format(str, new Object[]{t});
        if (TextUtils.equals(format, summary)) {
            return summary;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public String getValue() {
        return this.i;
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setValue(savedState.mValue);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.mValue = getValue();
        return savedState;
    }

    public void onSetInitialValue(Object obj) {
        setValue(getPersistedString((String) obj));
    }

    public int r(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.h) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.h[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] s() {
        return this.g;
    }

    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null) {
            this.j = null;
        } else {
            this.j = charSequence.toString();
        }
    }

    public void setValue(String str) {
        boolean z = !TextUtils.equals(this.i, str);
        if (z || !this.k) {
            this.i = str;
            this.k = true;
            persistString(str);
            if (z) {
                notifyChanged();
            }
        }
    }

    public CharSequence t() {
        CharSequence[] charSequenceArr;
        int v = v();
        if (v < 0 || (charSequenceArr = this.g) == null) {
            return null;
        }
        return charSequenceArr[v];
    }

    public CharSequence[] u() {
        return this.h;
    }

    public final int v() {
        return r(this.i);
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String mValue;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mValue = parcel.readString();
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mValue);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.dialogPreferenceStyle, 16842897));
    }
}
