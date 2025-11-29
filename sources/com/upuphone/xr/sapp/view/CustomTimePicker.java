package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.widget.ScrollTextView;
import com.meizu.common.widget.TimePicker;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CustomTimePicker extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f7949a;
    public int b;
    public Boolean c;
    public boolean d;
    public ScrollTextView e;
    public ScrollTextView f;
    public ScrollTextView g;
    public String h;
    public String i;
    public TextView j;
    public TextView k;
    public int l;
    public int m;
    public int n;
    public int o;
    public OnTimeChangedListener p;
    public LinearLayout q;
    public int r;
    public int s;
    public int t;
    public Paint u;
    public boolean v;
    public boolean w;
    public int x;
    public String[] y;
    public String[] z;

    public interface OnTimeChangedListener {
        void a(CustomTimePicker customTimePicker, int i, int i2);
    }

    public class TimeAdapter implements ScrollTextView.IDataAdapter {

        /* renamed from: a  reason: collision with root package name */
        public int f7950a;

        public TimeAdapter(int i) {
            this.f7950a = i;
        }

        public String getItemText(int i) {
            int i2 = this.f7950a;
            if (i2 != 1) {
                if (i2 == 2) {
                    return CustomTimePicker.this.z[i];
                }
                if (i2 != 3) {
                    return null;
                }
                if (i == 0) {
                    return CustomTimePicker.this.h;
                }
                if (i == 1) {
                    return CustomTimePicker.this.i;
                }
                return null;
            } else if (CustomTimePicker.this.l()) {
                return CustomTimePicker.this.y[i];
            } else {
                if (i == 0) {
                    i = 12;
                }
                return CustomTimePicker.this.y[i];
            }
        }

        public void onChanged(View view, int i, int i2) {
            int i3 = this.f7950a;
            boolean z = true;
            if (i3 == 1) {
                CustomTimePicker.this.f7949a = i2;
            } else if (i3 == 2) {
                CustomTimePicker.this.b = i2;
            } else if (i3 == 3) {
                CustomTimePicker customTimePicker = CustomTimePicker.this;
                if (i2 != 0) {
                    z = false;
                }
                customTimePicker.d = z;
            } else {
                return;
            }
            if (CustomTimePicker.this.p != null) {
                OnTimeChangedListener b2 = CustomTimePicker.this.p;
                CustomTimePicker customTimePicker2 = CustomTimePicker.this;
                b2.a(customTimePicker2, customTimePicker2.getCurrentHour(), CustomTimePicker.this.getCurrentMinute().intValue());
            }
            CustomTimePicker.this.m(this.f7950a);
        }
    }

    public CustomTimePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!this.w || accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        String str = "";
        if (!this.c.booleanValue()) {
            str = str + h(3);
        }
        accessibilityEvent.getText().add(str + h(1) + this.j.getText() + h(2) + this.k.getText());
        return false;
    }

    public int getCurrentHour() {
        return this.c.booleanValue() ? this.f7949a : this.d ? this.f7949a : this.f7949a + 12;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.b);
    }

    public final String h(int i2) {
        if (i2 == 1) {
            int i3 = this.f7949a;
            if (l()) {
                return String.valueOf(i3);
            }
            if (i3 == 0) {
                i3 = 12;
            }
            return String.valueOf(i3);
        } else if (i2 == 2) {
            return String.valueOf(this.b);
        } else {
            if (i2 != 3) {
                return "";
            }
            boolean z2 = !this.d;
            return !z2 ? this.h : z2 ? this.i : "";
        }
    }

    public final void i() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (this.c.booleanValue()) {
            k();
        } else {
            j();
        }
        int color = getContext().getResources().getColor(R.color.mc_picker_selected_color);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_one)));
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_two)));
        int color2 = getContext().getResources().getColor(R.color.mc_picker_unselected_color);
        this.e.setTextColor(color, (List<Integer>) arrayList);
        this.f.setTextColor(color, (List<Integer>) arrayList);
        ScrollTextView scrollTextView = this.g;
        if (scrollTextView != null) {
            scrollTextView.setTextColor(color, color2);
        }
        this.j.setTextColor(color);
        this.k.setTextColor(color);
        int paddingTop = this.j.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f2 = displayMetrics.scaledDensity;
        float f3 = getResources().getDisplayMetrics().scaledDensity;
        TextView textView = this.j;
        int textSize = (int) (((float) paddingTop) - (((this.j.getTextSize() / f3) * (f3 - f2)) / 1.3f));
        textView.setPadding(textView.getPaddingLeft(), textSize, this.j.getPaddingRight(), this.j.getPaddingBottom());
        TextView textView2 = this.k;
        textView2.setPadding(textView2.getPaddingLeft(), textSize, this.k.getPaddingRight(), this.k.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
    }

    public final void j() {
        if (!this.c.booleanValue()) {
            View.inflate(getContext(), R.layout.mc_time_picker_column_12, this);
            TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
            this.j = textView;
            if (textView != null) {
                textView.setText(R.string.mc_date_time_hour);
            }
            TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
            this.k = textView2;
            if (textView2 != null) {
                textView2.setText(R.string.mc_date_time_min);
            }
            ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.e = scrollTextView;
            TimeAdapter timeAdapter = new TimeAdapter(1);
            int i2 = this.f7949a;
            int i3 = this.m;
            int i4 = this.l;
            scrollTextView.setData(timeAdapter, -1.0f, i2, (i3 - i4) + 1, this.x, i4, i3, true);
            ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.f = scrollTextView2;
            TimeAdapter timeAdapter2 = new TimeAdapter(2);
            int i5 = this.b;
            int i6 = this.o;
            int i7 = this.n;
            scrollTextView2.setData(timeAdapter2, -1.0f, i5, (i6 - i7) + 1, this.x, i7, i6, true);
            ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll3);
            this.g = scrollTextView3;
            scrollTextView3.setData(new TimeAdapter(3), -1.0f, this.d ^ true ? 1 : 0, 2, this.x, 0, 1, false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            float min = (float) Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
            this.e.setTextSize(min, (List<Float>) arrayList);
            this.f.setTextSize(min, (List<Float>) arrayList);
            this.g.setTextSize(getContext().getResources().getDimension(R.dimen.mc_picker_selected_word_size), getContext().getResources().getDimension(R.dimen.mc_picker_normal_word_size_two));
        }
    }

    public final void k() {
        if (this.c.booleanValue()) {
            View.inflate(getContext(), R.layout.mc_time_picker_column_24, this);
            TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
            this.j = textView;
            if (textView != null) {
                textView.setText(R.string.mc_date_time_hour);
            }
            TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
            this.k = textView2;
            if (textView2 != null) {
                textView2.setText(R.string.mc_date_time_min);
            }
            ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.e = scrollTextView;
            TimeAdapter timeAdapter = new TimeAdapter(1);
            int i2 = this.f7949a;
            int i3 = this.m;
            int i4 = this.l;
            scrollTextView.setData(timeAdapter, -1.0f, i2, (i3 - i4) + 1, this.x, i4, i3, true);
            ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.f = scrollTextView2;
            TimeAdapter timeAdapter2 = new TimeAdapter(2);
            int i5 = this.b;
            int i6 = this.o;
            int i7 = this.n;
            scrollTextView2.setData(timeAdapter2, -1.0f, i5, (i6 - i7) + 1, this.x, i7, i6, true);
            this.g = null;
            ArrayList arrayList = new ArrayList();
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            float min = (float) Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
            this.e.setTextSize(min, (List<Float>) arrayList);
            this.f.setTextSize(min, (List<Float>) arrayList);
        }
    }

    public boolean l() {
        return this.c.booleanValue();
    }

    public final void m(int i2) {
        View findViewById;
        if (this.w) {
            n();
            if (i2 == 3) {
                View findViewById2 = findViewById(R.id.mc_column3Layout);
                if (findViewById2 != null) {
                    findViewById2.sendAccessibilityEvent(4);
                }
            } else if (i2 == 1) {
                View findViewById3 = findViewById(R.id.mc_column1Layout);
                if (findViewById3 != null) {
                    findViewById3.sendAccessibilityEvent(4);
                }
            } else if (i2 == 2 && (findViewById = findViewById(R.id.mc_column2Layout)) != null) {
                findViewById.sendAccessibilityEvent(4);
            }
        }
    }

    public final void n() {
        if (this.w) {
            View findViewById = findViewById(R.id.mc_column3Layout);
            View findViewById2 = findViewById(R.id.mc_column2Layout);
            View findViewById3 = findViewById(R.id.mc_column1Layout);
            String str = "";
            if (!this.c.booleanValue()) {
                str = str + h(3);
            }
            String str2 = str + h(1) + this.j.getText() + h(2) + this.k.getText();
            if (findViewById != null) {
                findViewById.setFocusable(true);
                findViewById.setContentDescription("上下滚动设置上下午，当前时间是" + str2);
            }
            if (findViewById3 != null) {
                findViewById3.setFocusable(true);
                findViewById3.setContentDescription("上下滚动设置时，当前时间是" + str2);
            }
            if (findViewById2 != null) {
                findViewById2.setFocusable(true);
                findViewById2.setContentDescription("上下滚动设置分，当前时间是" + str2);
            }
        }
    }

    public void o(int i2, int i3) {
        this.l = i2;
        this.m = i3;
        ScrollTextView scrollTextView = this.e;
        TimeAdapter timeAdapter = new TimeAdapter(1);
        int i4 = this.f7949a;
        int i5 = this.m;
        int i6 = this.l;
        scrollTextView.setData(timeAdapter, -1.0f, i4, (i5 - i6) + 1, this.x, i6, i5, false);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.v) {
            int width = getWidth();
            int width2 = this.q.getWidth() - (this.t * 2);
            int i2 = (width - width2) / 2;
            int i3 = this.r;
            Canvas canvas2 = canvas;
            float f2 = (float) i2;
            float f3 = (float) (i2 + width2);
            canvas2.drawLine(f2, (float) i3, f3, (float) i3, this.u);
            int i4 = this.s;
            canvas2.drawLine(f2, (float) i4, f3, (float) i4, this.u);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        r(savedState.mHour, savedState.mMinute, this.c.booleanValue());
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.b);
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    public void p(int i2, int i3) {
        this.r = i2;
        this.s = i3;
    }

    public void q(int i2, int i3) {
        this.n = i2;
        this.o = i3;
        ScrollTextView scrollTextView = this.f;
        TimeAdapter timeAdapter = new TimeAdapter(2);
        int i4 = this.b;
        int i5 = this.o;
        int i6 = this.n;
        scrollTextView.setData(timeAdapter, -1.0f, i4, (i5 - i6) + 1, this.x, i6, i5, false);
    }

    public void r(int i2, int i3, boolean z2) {
        boolean z3;
        boolean z4 = false;
        if (!z2) {
            this.d = true;
            if (this.f7949a != i2) {
                this.f7949a = i2;
                z3 = true;
            } else {
                z3 = false;
            }
            int i4 = this.f7949a;
            if (i4 >= 12) {
                this.f7949a = i4 - 12;
                this.d = false;
            }
        } else if (this.f7949a != i2) {
            this.f7949a = i2;
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.b != i3) {
            this.b = i3;
            z4 = true;
        }
        if (z2 != this.c.booleanValue()) {
            this.c = Boolean.valueOf(z2);
            i();
        }
        if (z3) {
            this.e.refreshCurrent(this.f7949a);
        }
        if (z4) {
            this.f.refreshCurrent(this.b);
        }
        ScrollTextView scrollTextView = this.g;
        if (scrollTextView != null) {
            scrollTextView.refreshCurrent(this.d ^ true ? 1 : 0);
        }
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num.intValue() != getCurrentHour()) {
            r(num.intValue(), this.b, this.c.booleanValue());
        }
    }

    public void setCurrentMinute(Integer num) {
        r(getCurrentHour(), num.intValue(), this.c.booleanValue());
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.f.setEnabled(z2);
        this.e.setEnabled(z2);
        ScrollTextView scrollTextView = this.g;
        if (scrollTextView != null) {
            scrollTextView.setEnabled(z2);
        }
    }

    public void setIs24HourView(Boolean bool) {
        r(getCurrentHour(), this.b, bool.booleanValue());
    }

    public void setIsDrawLine(boolean z2) {
        this.v = z2;
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.p = onTimeChangedListener;
    }

    public static class SavedState extends View.BaseSavedState {
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
        /* access modifiers changed from: private */
        public final int mHour;
        /* access modifiers changed from: private */
        public final int mMinute;

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        this.f7949a = 0;
        this.b = 0;
        this.c = Boolean.FALSE;
        this.d = true;
        this.w = false;
        this.x = 5;
        String format = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{0});
        this.y = new String[100];
        for (int i4 = 0; i4 < 100; i4++) {
            this.y[i4] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i4)});
            if (i4 <= 9) {
                this.y[i4] = format + this.y[i4];
            }
        }
        this.z = new String[100];
        for (int i5 = 0; i5 < 100; i5++) {
            this.z[i5] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i5)});
            if (i5 <= 9) {
                this.z[i5] = format + this.z[i5];
            }
        }
        Calendar instance = Calendar.getInstance();
        try {
            this.f7949a = instance.get(11);
            this.b = instance.get(12);
            this.c = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.f7949a = 12;
            this.b = 30;
            this.c = Boolean.TRUE;
        }
        if (!this.c.booleanValue() && (i3 = this.f7949a) >= 12) {
            this.f7949a = i3 - 12;
            this.d = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.h = amPmStrings[0];
        this.i = amPmStrings[1];
        i();
        this.r = 0;
        this.s = 0;
        this.t = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        this.u = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.MZTheme);
        int i6 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColor, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        obtainStyledAttributes.recycle();
        this.u.setColor(i6);
        this.u.setAntiAlias(true);
        this.u.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.v = false;
        setWillNotDraw(false);
        this.q = (LinearLayout) findViewById(R.id.mc_column_parent);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.w = accessibilityManager.isEnabled();
        }
        n();
    }
}
