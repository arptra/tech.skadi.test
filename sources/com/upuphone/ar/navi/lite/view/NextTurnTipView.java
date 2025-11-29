package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;

public class NextTurnTipView extends AppCompatImageView {
    public static final String b = ("NAVI-" + NextTurnTipView.class.getSimpleName());
    public static final int[] c;
    public static final int[] d = {R.drawable.here_depart, R.drawable.here_arrive, R.drawable.here_left_u_turn, R.drawable.here_sharp_left_turn, R.drawable.here_left_turn, R.drawable.here_slight_left_turn, R.drawable.here_continue_on, R.drawable.here_slight_right_turn, R.drawable.here_right_turn, R.drawable.here_sharp_right_turn, R.drawable.here_right_u_turn, R.drawable.here_left_exit, R.drawable.here_right_exit, R.drawable.here_left_ramp, R.drawable.here_right_ramp, R.drawable.here_left_fork, R.drawable.here_middle_fork, R.drawable.here_right_fork, R.drawable.here_enter_highway_from_left, R.drawable.here_enter_highway_from_right, R.drawable.here_left_roundabout_enter, R.drawable.here_right_roundabout_enter, R.drawable.here_left_roundabout_pass, R.drawable.here_right_roundabout_pass, R.drawable.here_left_roundabout_exit1, R.drawable.here_left_roundabout_exit2, R.drawable.here_left_roundabout_exit3, R.drawable.here_left_roundabout_exit4, R.drawable.here_left_roundabout_exit5, R.drawable.here_left_roundabout_exit6, R.drawable.here_left_roundabout_exit7, R.drawable.here_left_roundabout_exit8, R.drawable.here_left_roundabout_exit9, R.drawable.here_left_roundabout_exit10, R.drawable.here_left_roundabout_exit11, R.drawable.here_left_roundabout_exit12, R.drawable.here_right_roundabout_exit1, R.drawable.here_right_roundabout_exit2, R.drawable.here_right_roundabout_exit3, R.drawable.here_right_roundabout_exit4, R.drawable.here_right_roundabout_exit5, R.drawable.here_right_roundabout_exit6, R.drawable.here_right_roundabout_exit7, R.drawable.here_right_roundabout_exit8, R.drawable.here_right_roundabout_exit9, R.drawable.here_right_roundabout_exit10, R.drawable.here_right_roundabout_exit11, R.drawable.here_right_roundabout_exit12};

    /* renamed from: a  reason: collision with root package name */
    public long f5838a = -1;

    static {
        int i = R.drawable.caricon;
        int i2 = R.drawable.amap_navi_lbs_sou2;
        int i3 = R.drawable.amap_navi_lbs_sou3;
        int i4 = R.drawable.amap_navi_lbs_sou4;
        int i5 = R.drawable.amap_navi_lbs_sou5;
        int i6 = R.drawable.amap_navi_lbs_sou6;
        int i7 = R.drawable.amap_navi_lbs_sou7;
        c = new int[]{i, i, i2, i3, i4, i5, i6, i7, R.drawable.amap_navi_lbs_sou8, R.drawable.amap_navi_lbs_sou9, R.drawable.amap_navi_lbs_sou10, R.drawable.amap_navi_lbs_sou11, R.drawable.amap_navi_lbs_sou12, R.drawable.amap_navi_lbs_sou13, R.drawable.amap_navi_lbs_sou14, R.drawable.amap_navi_lbs_sou15, R.drawable.amap_navi_lbs_sou16, R.drawable.amap_navi_lbs_sou17, R.drawable.amap_navi_lbs_sou18, i7, R.drawable.amap_navi_lbs_sou20};
    }

    public NextTurnTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAmapIconType(int i) {
        String str = b;
        StringBuilder sb = new StringBuilder();
        sb.append("setAmapIconType()  iconType=");
        sb.append(i);
        sb.append(" AMAP_ICON_TYPES.length=");
        int[] iArr = c;
        sb.append(iArr.length);
        CLog.b(str, sb.toString());
        if (i <= 20) {
            try {
                long j = (long) i;
                if (this.f5838a != j) {
                    setImageResource(iArr[i]);
                    this.f5838a = j;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setHereIconType(int i) {
        String str = b;
        StringBuilder sb = new StringBuilder();
        sb.append("setHereIconType()  iconType=");
        sb.append(i);
        sb.append(" HERE_ICON_TYPES.length=");
        int[] iArr = d;
        sb.append(iArr.length);
        CLog.b(str, sb.toString());
        if (i < iArr.length) {
            long j = (long) i;
            if (this.f5838a != j) {
                try {
                    setImageResource(iArr[i]);
                    this.f5838a = j;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIconType(int i) {
        String str = b;
        CLog.b(str, "setIconType()  iconType=" + i);
        if (NaviUtil.s0()) {
            setHereIconType(i);
        } else {
            setAmapIconType(i);
        }
    }

    public NextTurnTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NextTurnTipView(Context context) {
        super(context);
    }
}
