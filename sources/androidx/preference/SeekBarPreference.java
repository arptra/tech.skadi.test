package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;

public class SeekBarPreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    public int f1693a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public SeekBar f;
    public TextView g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final SeekBar.OnSeekBarChangeListener k;
    public final View.OnKeyListener l;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.k = new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    if (seekBarPreference.j || !seekBarPreference.e) {
                        seekBarPreference.p(seekBar);
                        return;
                    }
                }
                SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
                seekBarPreference2.q(i + seekBarPreference2.b);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.e = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.e = false;
                int progress = seekBar.getProgress();
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (progress + seekBarPreference.b != seekBarPreference.f1693a) {
                    seekBarPreference.p(seekBar);
                }
            }
        };
        this.l = new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if ((!seekBarPreference.h && (i == 21 || i == 22)) || i == 23 || i == 66) {
                    return false;
                }
                SeekBar seekBar = seekBarPreference.f;
                if (seekBar != null) {
                    return seekBar.onKeyDown(i, keyEvent);
                }
                Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, i2, i3);
        this.b = obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        l(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100));
        m(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.h = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.i = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.j = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        obtainStyledAttributes.recycle();
    }

    public final void l(int i2) {
        int i3 = this.b;
        if (i2 < i3) {
            i2 = i3;
        }
        if (i2 != this.c) {
            this.c = i2;
            notifyChanged();
        }
    }

    public final void m(int i2) {
        if (i2 != this.d) {
            this.d = Math.min(this.c - this.b, Math.abs(i2));
            notifyChanged();
        }
    }

    public void n(int i2) {
        o(i2, true);
    }

    public final void o(int i2, boolean z) {
        int i3 = this.b;
        if (i2 < i3) {
            i2 = i3;
        }
        int i4 = this.c;
        if (i2 > i4) {
            i2 = i4;
        }
        if (i2 != this.f1693a) {
            this.f1693a = i2;
            q(i2);
            persistInt(i2);
            if (z) {
                notifyChanged();
            }
        }
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.l);
        this.f = (SeekBar) preferenceViewHolder.a(R.id.seekbar);
        TextView textView = (TextView) preferenceViewHolder.a(R.id.seekbar_value);
        this.g = textView;
        if (this.i) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.g = null;
        }
        SeekBar seekBar = this.f;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.k);
        this.f.setMax(this.c - this.b);
        int i2 = this.d;
        if (i2 != 0) {
            this.f.setKeyProgressIncrement(i2);
        } else {
            this.d = this.f.getKeyProgressIncrement();
        }
        this.f.setProgress(this.f1693a - this.b);
        q(this.f1693a);
        this.f.setEnabled(isEnabled());
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1693a = savedState.mSeekBarValue;
        this.b = savedState.mMin;
        this.c = savedState.mMax;
        notifyChanged();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.mSeekBarValue = this.f1693a;
        savedState.mMin = this.b;
        savedState.mMax = this.c;
        return savedState;
    }

    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        n(getPersistedInt(((Integer) obj).intValue()));
    }

    public void p(SeekBar seekBar) {
        int progress = this.b + seekBar.getProgress();
        if (progress == this.f1693a) {
            return;
        }
        if (callChangeListener(Integer.valueOf(progress))) {
            o(progress, false);
            return;
        }
        seekBar.setProgress(this.f1693a - this.b);
        q(this.f1693a);
    }

    public void q(int i2) {
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
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
        int mMax;
        int mMin;
        int mSeekBarValue;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mSeekBarValue = parcel.readInt();
            this.mMin = parcel.readInt();
            this.mMax = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mSeekBarValue);
            parcel.writeInt(this.mMin);
            parcel.writeInt(this.mMax);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SeekBarPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }
}
