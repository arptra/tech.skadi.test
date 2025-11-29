package com.upuphone.ar.navi.lite.car.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.view.CarSetDialog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

abstract class FieldViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f5667a = {R.id.number_0, R.id.number_1, R.id.number_2, R.id.number_3, R.id.number_4, R.id.number_5, R.id.number_6, R.id.number_7};
    public int b;
    public int c;
    public int d;
    public int e = -1;
    public int f = 0;
    public Map g = new HashMap();
    public Context h;

    public FieldViewGroup(Context context) {
        this.h = context;
        l(context);
        k();
    }

    public void A() {
        EditText editText = (EditText) this.g.get(0);
        if (editText != null) {
            CLog.a("InputView.ButtonGroup", "setSelect: isNewEnergyCar() = " + m());
            if (editText.isSelected()) {
                C(editText);
            } else {
                D(editText);
            }
            editText.setTextColor(TextUtils.isEmpty(editText.getText().toString()) ? this.c : this.b);
        }
    }

    public final void B() {
        for (int i = 0; i < this.g.size(); i++) {
            EditText editText = (EditText) this.g.get(Integer.valueOf(i));
            u(editText.isSelected(), editText);
            if (i == this.g.size() - 1) {
                q(editText);
            }
        }
    }

    public final void C(EditText editText) {
        if (CarSetDialog.z || m()) {
            editText.setBackgroundResource(TextUtils.isEmpty(editText.getText().toString()) ? R.drawable.vehicle_input_energy_item_filled : R.drawable.vehicle_input_energy_light_item_filled);
        } else {
            editText.setBackgroundResource(TextUtils.isEmpty(editText.getText().toString()) ? R.drawable.vehicle_input_item_filled : R.drawable.vehicle_input_light_item_filled);
        }
    }

    public final void D(EditText editText) {
        if (CarSetDialog.z || m()) {
            editText.setBackgroundResource(TextUtils.isEmpty(editText.getText().toString()) ? R.drawable.vehicle_input_energy_border : R.drawable.vehicle_input_energy_light_item_filled);
        } else {
            editText.setBackgroundResource(TextUtils.isEmpty(editText.getText().toString()) ? R.drawable.vehicle_input_border_gray : R.drawable.vehicle_input_light_item_filled);
        }
    }

    public void b(int i) {
        this.e = i;
        p();
        Map map = this.g;
        EditText editText = (EditText) map.get(Integer.valueOf(map.size() - 2));
        if (m() && this.f == this.g.size() - 2 && !TextUtils.isEmpty(editText.getText().toString())) {
            z();
        }
        s();
    }

    public int c() {
        EditText editText = (EditText) this.g.get(Integer.valueOf(this.f));
        if (editText != null) {
            if (TextUtils.isEmpty(editText.getText())) {
                int i = this.f;
                if (i > 0) {
                    int i2 = i - 1;
                    this.f = i2;
                    ((EditText) this.g.get(Integer.valueOf(i2))).setText("");
                } else {
                    CLog.a("InputView.ButtonGroup", "deleteFiledText: curIndex = " + this.f);
                }
            } else {
                editText.setText("");
            }
        }
        s();
        return this.f;
    }

    public void d(EditText editText) {
        try {
            Method method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(true);
            method.invoke(editText, new Object[]{Boolean.FALSE});
        } catch (Exception unused) {
        }
    }

    public abstract EditText e(int i);

    public int f(EditText editText) {
        for (Map.Entry entry : this.g.entrySet()) {
            if (entry.getValue() == editText) {
                return ((Integer) entry.getKey()).intValue();
            }
        }
        return -1;
    }

    public Map g() {
        return this.g;
    }

    public int h() {
        return this.g.size();
    }

    public final int i(int i) {
        int i2 = ((m() || i != this.g.size() - (CarSetDialog.z ? 1 : 2)) && i != this.g.size() - 1) ? i + 1 : this.f;
        int i3 = this.f;
        return i2 == i3 ? i3 : TextUtils.isEmpty(((EditText) this.g.get(Integer.valueOf(i2))).getText()) ? i2 : i(i2);
    }

    public String j() {
        StringBuilder sb = new StringBuilder();
        for (EditText text : this.g.values()) {
            sb.append(text.getText());
        }
        String trim = sb.toString().trim();
        if (trim.length() == 0) {
            return "car_license_clean";
        }
        if (m()) {
            return trim.length() == 8 ? trim : "imperfect_license_error";
        }
        if (trim.length() == 7) {
            return trim;
        }
        if (trim.length() != 8) {
            return "imperfect_license_error";
        }
        if (!n()) {
            return trim;
        }
        p();
        return "energy_license_error";
    }

    public final void k() {
        int i = 0;
        while (true) {
            int[] iArr = this.f5667a;
            if (i < iArr.length) {
                EditText e2 = e(iArr[i]);
                e2.setTag("[RAW.idx:" + i + "]");
                d(e2);
                this.g.put(Integer.valueOf(i), e2);
                i++;
            } else {
                return;
            }
        }
    }

    public final void l(Context context) {
        this.b = context.getColor(R.color.theme_color_1);
        this.c = context.getColor(R.color.theme_color_2);
        this.d = context.getColor(R.color.energy_text_color);
    }

    public boolean m() {
        Map map = this.g;
        EditText editText = (EditText) map.get(Integer.valueOf(map.size() - 1));
        if (editText == null) {
            return false;
        }
        return !TextUtils.isEmpty(editText.getText().toString());
    }

    public final boolean n() {
        return this.e >= 0 && !m();
    }

    public final void p() {
        Map map = this.g;
        EditText editText = (EditText) map.get(Integer.valueOf(map.size() - 1));
        if (n()) {
            editText.setText("");
            s();
            if (this.f == this.g.size() - 1) {
                v(this.f - 1);
            }
        }
    }

    public final void q(EditText editText) {
        if (editText.isSelected()) {
            u(TextUtils.isEmpty(editText.getText().toString()), editText);
        } else if (!CarSetDialog.z) {
            editText.setHint(TextUtils.isEmpty(editText.getText().toString()) ? this.h.getString(R.string.new_energy_hint) : editText.getText().toString());
        }
    }

    /* renamed from: r */
    public final void o(EditText editText) {
        editText.setSelected(false);
        editText.setTextColor(this.c);
    }

    public final void s() {
        Map map = this.g;
        ((EditText) map.get(Integer.valueOf(map.size() - 1))).setTextColor(this.d);
    }

    public boolean t(String str) {
        EditText editText = (EditText) this.g.get(Integer.valueOf(this.f));
        if (editText == null) {
            return false;
        }
        editText.setText(str);
        editText.setSelection(editText.getText().length());
        A();
        if (this.f == this.g.size() - 1) {
            s();
        }
        return true;
    }

    public final void u(boolean z, EditText editText) {
        if (z) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            return;
        }
        editText.clearFocus();
    }

    public void v(int i) {
        this.g.values().forEach(new a(this));
        EditText editText = (EditText) this.g.get(Integer.valueOf(i));
        CLog.a("InputView.ButtonGroup", "setSelect: index = " + i);
        if (editText != null) {
            editText.setSelected(true);
            this.f = i;
        }
        A();
        B();
    }

    public void w(String str) {
        int length = str.length();
        int i = 0;
        if (length == this.g.size()) {
            while (i < this.g.size()) {
                ((EditText) this.g.get(Integer.valueOf(i))).setText(String.valueOf(str.charAt(i)));
                ((EditText) this.g.get(Integer.valueOf(i))).setSelection(((EditText) this.g.get(Integer.valueOf(i))).getText().length());
                ((EditText) this.g.get(Integer.valueOf(i))).setTextSize(1, 15.0f);
                i++;
            }
        } else if (length == this.g.size() - 1) {
            while (i < this.g.size() - 1) {
                ((EditText) this.g.get(Integer.valueOf(i))).setText(String.valueOf(str.charAt(i)));
                ((EditText) this.g.get(Integer.valueOf(i))).setSelection(((EditText) this.g.get(Integer.valueOf(i))).getText().length());
                i++;
            }
            Map map = this.g;
            ((EditText) map.get(Integer.valueOf(map.size() - 1))).setTextSize(1, 10.0f);
        } else if (length == 0) {
            while (i < this.g.size()) {
                ((EditText) this.g.get(Integer.valueOf(i))).setText("");
                i++;
            }
            s();
        }
    }

    public void x(View.OnTouchListener onTouchListener) {
        for (EditText onTouchListener2 : this.g.values()) {
            onTouchListener2.setOnTouchListener(onTouchListener);
        }
    }

    public void y(float f2) {
        for (EditText editText : this.g.values()) {
            if (f(editText) != this.g.size() - 1) {
                editText.setTextSize(1, 15.0f);
                editText.setTextColor(this.c);
            }
        }
        s();
    }

    public int z() {
        int i = i(this.f);
        this.f = i;
        v(i);
        return this.f;
    }
}
