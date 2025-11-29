package com.scwang.smart.refresh.footer;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.scwang.smart.drawable.ProgressDrawable;
import com.scwang.smart.refresh.classics.ArrowDrawable;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.footer.classics.R;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.util.SmartUtil;

public class ClassicsFooter extends ClassicsAbstract<ClassicsFooter> implements RefreshFooter {
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;
    public boolean A;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* renamed from: com.scwang.smart.refresh.footer.ClassicsFooter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9839a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smart.refresh.layout.constant.RefreshState[] r0 = com.scwang.smart.refresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9839a = r0
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9839a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9839a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9839a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9839a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9839a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.footer.ClassicsFooter.AnonymousClass1.<clinit>():void");
        }
    }

    public ClassicsFooter(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean a(boolean z2) {
        if (this.A == z2) {
            return true;
        }
        this.A = z2;
        ImageView imageView = this.e;
        if (z2) {
            this.d.setText(this.z);
            imageView.setVisibility(8);
            return true;
        }
        this.d.setText(this.t);
        imageView.setVisibility(0);
        return true;
    }

    public int f(RefreshLayout refreshLayout, boolean z2) {
        super.f(refreshLayout, z2);
        if (this.A) {
            return 0;
        }
        this.d.setText(z2 ? this.x : this.y);
        return this.m;
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.e;
        if (!this.A) {
            switch (AnonymousClass1.f9839a[refreshState2.ordinal()]) {
                case 1:
                    imageView.setVisibility(0);
                    break;
                case 2:
                    break;
                case 3:
                case 4:
                    imageView.setVisibility(8);
                    this.d.setText(this.v);
                    return;
                case 5:
                    this.d.setText(this.u);
                    imageView.animate().rotation(0.0f);
                    return;
                case 6:
                    this.d.setText(this.w);
                    imageView.setVisibility(8);
                    return;
                default:
                    return;
            }
            this.d.setText(this.t);
            imageView.animate().rotation(180.0f);
        }
    }

    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.b == SpinnerStyle.f) {
            super.setPrimaryColors(iArr);
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.A = false;
        View.inflate(context, R.layout.srl_classics_footer, this);
        ImageView imageView = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.e = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f = imageView2;
        this.d = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, SmartUtil.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.height);
        this.m = obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.m);
        this.b = SpinnerStyle.i[obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.b.f9864a)];
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableArrow)) {
            this.e.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableArrow));
        } else if (this.e.getDrawable() == null) {
            ArrowDrawable arrowDrawable = new ArrowDrawable();
            this.h = arrowDrawable;
            arrowDrawable.a(-10066330);
            this.e.setImageDrawable(this.h);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableProgress)) {
            this.f.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableProgress));
        } else if (this.f.getDrawable() == null) {
            ProgressDrawable progressDrawable = new ProgressDrawable();
            this.i = progressDrawable;
            progressDrawable.a(-10066330);
            this.f.setImageDrawable(this.i);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.d.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlTextSizeTitle, SmartUtil.c(16.0f)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlPrimaryColor)) {
            super.k(obtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlAccentColor)) {
            super.j(obtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlAccentColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextPulling)) {
            this.t = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextPulling);
        } else {
            String str = B;
            if (str != null) {
                this.t = str;
            } else {
                this.t = context.getString(R.string.srl_footer_pulling);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextRelease)) {
            this.u = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextRelease);
        } else {
            String str2 = C;
            if (str2 != null) {
                this.u = str2;
            } else {
                this.u = context.getString(R.string.srl_footer_release);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextLoading)) {
            this.v = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextLoading);
        } else {
            String str3 = D;
            if (str3 != null) {
                this.v = str3;
            } else {
                this.v = context.getString(R.string.srl_footer_loading);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextRefreshing)) {
            this.w = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextRefreshing);
        } else {
            String str4 = E;
            if (str4 != null) {
                this.w = str4;
            } else {
                this.w = context.getString(R.string.srl_footer_refreshing);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextFinish)) {
            this.x = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextFinish);
        } else {
            String str5 = F;
            if (str5 != null) {
                this.x = str5;
            } else {
                this.x = context.getString(R.string.srl_footer_finish);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextFailed)) {
            this.y = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextFailed);
        } else {
            String str6 = G;
            if (str6 != null) {
                this.y = str6;
            } else {
                this.y = context.getString(R.string.srl_footer_failed);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextNothing)) {
            this.z = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextNothing);
        } else {
            String str7 = H;
            if (str7 != null) {
                this.z = str7;
            } else {
                this.z = context.getString(R.string.srl_footer_nothing);
            }
        }
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator((TimeInterpolator) null);
        this.d.setText(isInEditMode() ? this.v : this.t);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }
}
