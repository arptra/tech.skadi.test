package com.upuphone.ar.navi.lite.car.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.honey.account.f4.a;
import com.upuphone.ar.navi.lite.R;
import java.util.Map;

public class VehicleInput extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final FieldViewGroup f5669a;
    public VehicleListener b;
    public SelectedDrawable c;

    public interface VehicleListener {
        void a(int i, String str);
    }

    public VehicleInput(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vehicleInputStyle);
    }

    public boolean b() {
        int c2 = this.f5669a.c();
        if (c2 > this.f5669a.h()) {
            return false;
        }
        this.f5669a.v(c2);
        EditText editText = (EditText) this.f5669a.g().get(Integer.valueOf(c2));
        VehicleListener vehicleListener = this.b;
        if (vehicleListener == null) {
            return true;
        }
        vehicleListener.a(d(c2), editText.getText().toString());
        return true;
    }

    public int c(EditText editText) {
        return this.f5669a.f(editText);
    }

    public final int d(int i) {
        if (i == 0) {
            return 0;
        }
        return i == 1 ? 1 : 2;
    }

    public final void e(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Class<?> cls = Class.forName(str);
                if (SelectedDrawable.class.isAssignableFrom(cls)) {
                    SelectedDrawable selectedDrawable = (SelectedDrawable) cls.newInstance();
                    this.c = selectedDrawable;
                    selectedDrawable.a(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean f() {
        return this.f5669a.m();
    }

    public void g(int i) {
        this.f5669a.v(i);
        EditText editText = (EditText) this.f5669a.g().get(Integer.valueOf(i));
        VehicleListener vehicleListener = this.b;
        if (vehicleListener != null) {
            vehicleListener.a(d(i), editText.getText().toString());
        }
    }

    public Map<Integer, EditText> getBtnMap() {
        return this.f5669a.g();
    }

    public String getVehicleLicense() {
        return this.f5669a.j();
    }

    public final void h(View view) {
        EditText editText = (EditText) view;
        int f = this.f5669a.f(editText);
        this.f5669a.v(f);
        invalidate();
        VehicleListener vehicleListener = this.b;
        if (vehicleListener != null) {
            vehicleListener.a(d(f), editText.getText().toString());
        }
    }

    public final /* synthetic */ boolean i(View view, MotionEvent motionEvent) {
        h(view);
        return true;
    }

    public final void j(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VehicleInput, i, 0);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.VehicleInput_vehicleInputTextSize, 0.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VehicleInput_vehicleSelectedDrawable);
        int color = obtainStyledAttributes.getColor(R.styleable.VehicleInput_vehicleItemBorderSelectedColor, ContextCompat.getColor(context, R.color.main_color_blue));
        obtainStyledAttributes.recycle();
        e(string, color);
        this.f5669a.v(0);
        this.f5669a.y(dimension);
        this.f5669a.x(new a(this));
        this.f5669a.A();
    }

    public boolean k(String str) {
        boolean t = this.f5669a.t(str);
        int z = this.f5669a.z();
        VehicleListener vehicleListener = this.b;
        if (vehicleListener != null) {
            vehicleListener.a(d(z), str);
        }
        return t;
    }

    public void setEnergyType(int i) {
        this.f5669a.b(i);
    }

    public void setVehicleLicense(String str) {
        this.f5669a.w(str);
        this.f5669a.v(0);
    }

    public void setVehicleListener(VehicleListener vehicleListener) {
        this.b = vehicleListener;
    }

    public VehicleInput(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View.inflate(context, R.layout.vehicle_input_layout, this);
        this.f5669a = new FieldViewGroup(context) {
            public EditText e(int i2) {
                return (EditText) VehicleInput.this.findViewById(i2);
            }
        };
        j(context, attributeSet, i);
    }
}
