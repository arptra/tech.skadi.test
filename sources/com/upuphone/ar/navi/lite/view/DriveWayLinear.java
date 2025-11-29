package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.base.NaviLaneInfo;
import com.upuphone.ar.navi.lite.util.DensityUtils;
import com.upuphone.star.core.log.ULog;
import java.util.ArrayList;

public class DriveWayLinear extends LinearLayout {
    public static final String f = ("NAVI-" + DriveWayLinear.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public final int[] f5824a;
    public final int[] b;
    public final int[] c;
    public LinearLayout.LayoutParams d;
    public LinearLayout.LayoutParams e;

    public DriveWayLinear(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(ArrayList arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            addView(f(((Integer) arrayList.get(i)).intValue(), size == 1 ? R.drawable.navi_lane_shape_bg_over : (size <= 1 || i != 0) ? (size <= 1 || i != size + -1) ? R.drawable.navi_lane_shape_bg_center : R.drawable.navi_lane_shape_bg_right : R.drawable.navi_lane_shape_bg_left), this.e);
            if (size > 1 && i < size - 1) {
                addView(g(), this.d);
            }
            i++;
        }
    }

    public boolean b(NaviLaneInfo naviLaneInfo) {
        removeAllViews();
        int i = naviLaneInfo.laneCount;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            } else if (naviLaneInfo.backgroundLane[i2] == 255) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = naviLaneInfo.backgroundLane[i3];
            if (i4 < this.b.length) {
                int i5 = i(i4, naviLaneInfo.frontLane[i3]);
                if (i5 == -1) {
                    i5 = this.b[naviLaneInfo.backgroundLane[i3]];
                }
                arrayList.add(Integer.valueOf(i5));
            } else {
                ULog.k(f, " laneInfo backgroundLane index:" + naviLaneInfo.backgroundLane[i3]);
            }
        }
        a(arrayList);
        return true;
    }

    public boolean c(ArrayList arrayList) {
        removeAllViews();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(Integer.valueOf(this.f5824a[((Integer) arrayList.get(i)).intValue()]));
        }
        arrayList.clear();
        a(arrayList2);
        return true;
    }

    public final int d(int i, int i2) {
        int h = h(i, i2);
        if (h != -1) {
            return h;
        }
        int[] iArr = this.b;
        return i < iArr.length ? iArr[i] : h;
    }

    public boolean e(NaviLaneInfo naviLaneInfo) {
        ArrayList<Integer> arrayList = naviLaneInfo.lanesIconList;
        return arrayList != null ? c(arrayList) : b(naviLaneInfo);
    }

    public final View f(int i, int i2) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(getResources().getDrawable(i));
        imageView.setBackgroundDrawable(getResources().getDrawable(i2));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }

    public final View g() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.navi_arrow_leftline));
        imageView.setBackgroundColor(-15505160);
        return imageView;
    }

    public final int h(int i, int i2) {
        if (i == 10) {
            return p(i2);
        }
        if (i == 9) {
            return n(i2);
        }
        if (i == 2) {
            return j(i2);
        }
        if (i == 4) {
            return o(i2);
        }
        if (i == 6) {
            return s(i2);
        }
        if (i == 7) {
            return l(i2);
        }
        if (i == 11) {
            return r(i2);
        }
        if (i == 14 || i == 20) {
            return q(i2);
        }
        if (i == 16) {
            return k(i2);
        }
        if (i == 17) {
            return u(i2);
        }
        if (i == 18) {
            return t(i2);
        }
        if (i == 19) {
            return m(i2);
        }
        if (i == 21) {
            return R.drawable.landfront_kk;
        }
        if (i == 23) {
            return R.drawable.landback_l;
        }
        return -1;
    }

    public final int i(int i, int i2) {
        if (w(i)) {
            return d(i, i2);
        }
        if (x(i2)) {
            return this.c[i2];
        }
        return -1;
    }

    public final int j(int i) {
        if (i == 0) {
            return R.drawable.landfront_20;
        }
        if (i == 1) {
            return R.drawable.landfront_21;
        }
        return -1;
    }

    public final int k(int i) {
        if (i == 0) {
            return R.drawable.landfront_f0;
        }
        if (i == 1) {
            return R.drawable.landfront_f1;
        }
        if (i == 5) {
            return R.drawable.landfront_f5;
        }
        return -1;
    }

    public final int l(int i) {
        if (i == 0) {
            return R.drawable.landfront_70;
        }
        if (i == 1) {
            return R.drawable.landfront_71;
        }
        if (i == 3) {
            return R.drawable.landfront_73;
        }
        return -1;
    }

    public final int m(int i) {
        if (i == 0) {
            return R.drawable.landfront_70;
        }
        if (i == 3) {
            return R.drawable.landfront_73;
        }
        if (i == 8) {
            return R.drawable.landfront_71;
        }
        return -1;
    }

    public final int n(int i) {
        if (i == 0) {
            return R.drawable.landfront_90;
        }
        if (i == 5) {
            return R.drawable.landfront_95;
        }
        return -1;
    }

    public final int o(int i) {
        if (i == 0) {
            return R.drawable.landfront_40;
        }
        if (i == 3) {
            return R.drawable.landfront_43;
        }
        return -1;
    }

    public final int p(int i) {
        if (i == 0) {
            return R.drawable.landfront_a0;
        }
        if (i == 8) {
            return R.drawable.landfront_a8;
        }
        return -1;
    }

    public final int q(int i) {
        if (i == 1) {
            return R.drawable.landfront_e1;
        }
        if (i == 5) {
            return R.drawable.landfront_e5;
        }
        return -1;
    }

    public final int r(int i) {
        if (i == 5) {
            return R.drawable.landfront_b5;
        }
        if (i == 1) {
            return R.drawable.landfront_b1;
        }
        return -1;
    }

    public final int s(int i) {
        if (i == 1) {
            return R.drawable.landfront_61;
        }
        if (i == 3) {
            return R.drawable.landfront_63;
        }
        return -1;
    }

    public final int t(int i) {
        if (i == 1) {
            return R.drawable.landfront_j1;
        }
        if (i == 5) {
            return R.drawable.landfront_j8;
        }
        return -1;
    }

    public final int u(int i) {
        if (i == 8) {
            return R.drawable.landfront_c8;
        }
        if (i == 3) {
            return R.drawable.landfront_c3;
        }
        return -1;
    }

    public final void v(Context context) {
        this.d = new LinearLayout.LayoutParams(-2, DensityUtils.a(context, 58.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtils.a(context, 42.0f), DensityUtils.a(context, 58.0f));
        this.e = layoutParams;
        this.d.gravity = 81;
        layoutParams.gravity = 81;
        setGravity(1);
    }

    public final boolean w(int i) {
        return i == 14 || i == 2 || i == 4 || i == 9 || i == 10 || i == 11 || i == 12 || i == 6 || i == 7 || i == 16 || i >= 17;
    }

    public final boolean x(int i) {
        return i != 255;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DriveWayLinear(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5824a = new int[]{R.drawable.here_straight, R.drawable.here_slight_left, R.drawable.here_slight_right, R.drawable.here_quite_left, R.drawable.here_quite_right, R.drawable.here_hard_left, R.drawable.here_hard_right, R.drawable.here_uturn_left, R.drawable.here_uturn_right};
        int i = R.drawable.landback_0;
        int i2 = R.drawable.landback_1;
        int i3 = R.drawable.landback_2;
        int i4 = R.drawable.landback_3;
        int i5 = R.drawable.landback_4;
        int i6 = R.drawable.landback_5;
        int i7 = R.drawable.landback_6;
        int i8 = R.drawable.landback_7;
        int i9 = R.drawable.landback_8;
        int i10 = R.drawable.landback_9;
        int i11 = R.drawable.landback_a;
        int i12 = R.drawable.landback_b;
        int i13 = R.drawable.landback_c;
        int i14 = R.drawable.landback_d;
        int i15 = R.drawable.landback_e;
        int i16 = R.drawable.landback_f;
        int i17 = R.drawable.landback_g;
        int i18 = R.drawable.landback_h;
        int i19 = R.drawable.landback_i;
        int i20 = R.drawable.landback_j;
        int i21 = R.drawable.landfront_kk;
        int i22 = R.drawable.landback_l;
        this.b = new int[]{i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22};
        this.c = new int[]{R.drawable.landfront_0, R.drawable.landfront_1, i3, R.drawable.landfront_3, i5, R.drawable.landfront_5, i7, i8, R.drawable.landfront_8, i10, i11, i12, i13, R.drawable.landfront_d, i15, i16, i17, i18, i19, i20, i21, i22};
        v(context);
    }
}
