package com.scwang.smart.refresh.header;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smart.drawable.ProgressDrawable;
import com.scwang.smart.refresh.classics.ArrowDrawable;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.header.classics.R;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.util.SmartUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ClassicsHeader extends ClassicsAbstract<ClassicsHeader> implements RefreshHeader {
    public static final int H = R.id.srl_classics_update;
    public static String I = null;
    public static String J = null;
    public static String K = null;
    public static String L = null;
    public static String M = null;
    public static String N = null;
    public static String O = null;
    public static String P = null;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String t;
    public Date u;
    public TextView v;
    public SharedPreferences w;
    public DateFormat x;
    public boolean y;
    public String z;

    /* renamed from: com.scwang.smart.refresh.header.ClassicsHeader$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9840a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smart.refresh.layout.constant.RefreshState[] r0 = com.scwang.smart.refresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9840a = r0
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9840a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9840a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9840a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9840a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9840a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9840a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.header.ClassicsHeader.AnonymousClass1.<clinit>():void");
        }
    }

    public ClassicsHeader(Context context) {
        this(context, (AttributeSet) null);
    }

    public int f(RefreshLayout refreshLayout, boolean z2) {
        if (z2) {
            this.d.setText(this.D);
            if (this.u != null) {
                m(new Date());
            }
        } else {
            this.d.setText(this.E);
        }
        return super.f(refreshLayout, z2);
    }

    /* renamed from: l */
    public ClassicsHeader j(int i) {
        this.v.setTextColor((16777215 & i) | -872415232);
        return (ClassicsHeader) super.j(i);
    }

    public ClassicsHeader m(Date date) {
        this.u = date;
        this.v.setText(this.x.format(date));
        if (this.w != null && !isInEditMode()) {
            this.w.edit().putLong(this.t, date.getTime()).apply();
        }
        return this;
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.e;
        TextView textView = this.v;
        int i = 8;
        switch (AnonymousClass1.f9840a[refreshState2.ordinal()]) {
            case 1:
                if (this.y) {
                    i = 0;
                }
                textView.setVisibility(i);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.d.setText(this.A);
                imageView.setVisibility(8);
                return;
            case 5:
                this.d.setText(this.C);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.d.setText(this.G);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                if (this.y) {
                    i = 4;
                }
                textView.setVisibility(i);
                this.d.setText(this.B);
                return;
            default:
                return;
        }
        this.d.setText(this.z);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        FragmentManager supportFragmentManager;
        this.t = "LAST_UPDATE_TIME";
        this.y = true;
        View.inflate(context, R.layout.srl_classics_header, this);
        ImageView imageView = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.e = imageView;
        TextView textView = (TextView) findViewById(R.id.srl_classics_update);
        this.v = textView;
        ImageView imageView2 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f = imageView2;
        this.d = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, SmartUtil.c(0.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlDrawableMarginRight, SmartUtil.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.height);
        this.m = obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.m);
        this.y = obtainStyledAttributes.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.y);
        this.b = SpinnerStyle.i[obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.b.f9864a)];
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableArrow)) {
            this.e.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableArrow));
        } else if (this.e.getDrawable() == null) {
            ArrowDrawable arrowDrawable = new ArrowDrawable();
            this.h = arrowDrawable;
            arrowDrawable.a(-10066330);
            this.e.setImageDrawable(this.h);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableProgress)) {
            this.f.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableProgress));
        } else if (this.f.getDrawable() == null) {
            ProgressDrawable progressDrawable = new ProgressDrawable();
            this.i = progressDrawable;
            progressDrawable.a(-10066330);
            this.f.setImageDrawable(this.i);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.d.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTitle, SmartUtil.c(16.0f)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.v.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTime, SmartUtil.c(12.0f)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlPrimaryColor)) {
            super.k(obtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlAccentColor)) {
            j(obtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlAccentColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextPulling)) {
            this.z = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextPulling);
        } else {
            String str = I;
            if (str != null) {
                this.z = str;
            } else {
                this.z = context.getString(R.string.srl_header_pulling);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextLoading)) {
            this.B = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextLoading);
        } else {
            String str2 = K;
            if (str2 != null) {
                this.B = str2;
            } else {
                this.B = context.getString(R.string.srl_header_loading);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRelease)) {
            this.C = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRelease);
        } else {
            String str3 = L;
            if (str3 != null) {
                this.C = str3;
            } else {
                this.C = context.getString(R.string.srl_header_release);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFinish)) {
            this.D = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFinish);
        } else {
            String str4 = M;
            if (str4 != null) {
                this.D = str4;
            } else {
                this.D = context.getString(R.string.srl_header_finish);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFailed)) {
            this.E = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFailed);
        } else {
            String str5 = N;
            if (str5 != null) {
                this.E = str5;
            } else {
                this.E = context.getString(R.string.srl_header_failed);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSecondary)) {
            this.G = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextSecondary);
        } else {
            String str6 = P;
            if (str6 != null) {
                this.G = str6;
            } else {
                this.G = context.getString(R.string.srl_header_secondary);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRefreshing)) {
            this.A = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRefreshing);
        } else {
            String str7 = J;
            if (str7 != null) {
                this.A = str7;
            } else {
                this.A = context.getString(R.string.srl_header_refreshing);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextUpdate)) {
            this.F = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextUpdate);
        } else {
            String str8 = O;
            if (str8 != null) {
                this.F = str8;
            } else {
                this.F = context.getString(R.string.srl_header_update);
            }
        }
        this.x = new SimpleDateFormat(this.F, Locale.getDefault());
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator((TimeInterpolator) null);
        textView.setVisibility(this.y ? 0 : 8);
        this.d.setText(isInEditMode() ? this.A : this.z);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && supportFragmentManager.F0().size() > 0) {
                m(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.t += context.getClass().getName();
        this.w = context.getSharedPreferences("ClassicsHeader", 0);
        m(new Date(this.w.getLong(this.t, System.currentTimeMillis())));
    }
}
