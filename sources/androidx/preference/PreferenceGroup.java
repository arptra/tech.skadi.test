package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PreferenceGroup extends Preference {

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap f1678a;
    public final Handler b;
    public final List c;
    public boolean d;
    public int e;
    public boolean f;
    public int g;
    public OnExpandButtonClickListener h;
    public final Runnable i;

    @RestrictTo
    public interface OnExpandButtonClickListener {
        void a();
    }

    public interface PreferencePositionCallback {
        int b(Preference preference);

        int e(String str);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f1678a = new SimpleArrayMap();
        this.b = new Handler(Looper.getMainLooper());
        this.d = true;
        this.e = 0;
        this.f = false;
        this.g = Integer.MAX_VALUE;
        this.h = null;
        this.i = new Runnable() {
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.f1678a.clear();
                }
            }
        };
        this.c = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, i2, i3);
        int i4 = R.styleable.PreferenceGroup_orderingFromXml;
        this.d = TypedArrayUtils.b(obtainStyledAttributes, i4, i4, true);
        if (obtainStyledAttributes.hasValue(R.styleable.PreferenceGroup_initialExpandedChildrenCount)) {
            int i5 = R.styleable.PreferenceGroup_initialExpandedChildrenCount;
            r(TypedArrayUtils.d(obtainStyledAttributes, i5, i5, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    public void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int p = p();
        for (int i2 = 0; i2 < p; i2++) {
            o(i2).dispatchRestoreInstanceState(bundle);
        }
    }

    public void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int p = p();
        for (int i2 = 0; i2 < p; i2++) {
            o(i2).dispatchSaveInstanceState(bundle);
        }
    }

    public Preference l(CharSequence charSequence) {
        Preference l;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        } else {
            int p = p();
            for (int i2 = 0; i2 < p; i2++) {
                Preference o = o(i2);
                if (TextUtils.equals(o.getKey(), charSequence)) {
                    return o;
                }
                if ((o instanceof PreferenceGroup) && (l = ((PreferenceGroup) o).l(charSequence)) != null) {
                    return l;
                }
            }
            return null;
        }
    }

    public int m() {
        return this.g;
    }

    public OnExpandButtonClickListener n() {
        return this.h;
    }

    public void notifyDependencyChange(boolean z) {
        super.notifyDependencyChange(z);
        int p = p();
        for (int i2 = 0; i2 < p; i2++) {
            o(i2).onParentChanged(this, z);
        }
    }

    public Preference o(int i2) {
        return (Preference) this.c.get(i2);
    }

    public void onAttached() {
        super.onAttached();
        this.f = true;
        int p = p();
        for (int i2 = 0; i2 < p; i2++) {
            o(i2).onAttached();
        }
    }

    public void onDetached() {
        super.onDetached();
        this.f = false;
        int p = p();
        for (int i2 = 0; i2 < p; i2++) {
            o(i2).onDetached();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.g = savedState.mInitialExpandedChildrenCount;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.g);
    }

    public int p() {
        return this.c.size();
    }

    public boolean q() {
        return true;
    }

    public void r(int i2) {
        if (i2 != Integer.MAX_VALUE && !hasKey()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.g = i2;
    }

    public void s() {
        synchronized (this) {
            Collections.sort(this.c);
        }
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
        int mInitialExpandedChildrenCount;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mInitialExpandedChildrenCount = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mInitialExpandedChildrenCount);
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.mInitialExpandedChildrenCount = i;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
