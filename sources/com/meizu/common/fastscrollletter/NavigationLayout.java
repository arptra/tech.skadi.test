package com.meizu.common.fastscrollletter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.meizu.common.R;
import com.meizu.common.fastscrollletter.NavigationView;
import com.meizu.flyme.sdk.ContextBuilder;
import java.util.ArrayList;
import java.util.HashMap;

public class NavigationLayout extends RelativeLayout {
    private static final int[] COLORS = {R.color.mc_fast_scroll_letter_color_one, R.color.mc_fast_scroll_letter_color_two, R.color.mc_fast_scroll_letter_color_three, R.color.mc_fast_scroll_letter_color_four, R.color.mc_fast_scroll_letter_color_five, R.color.mc_fast_scroll_letter_color_six, R.color.mc_fast_scroll_letter_color_seven};
    private static final int[] COLORS_DEFAULT = {R.color.mc_fast_scroll_letter_color_default};
    public static final int NAVIGATION_VERTICAL_ALIGNMENT_BOTTOM = 2;
    public static final int NAVIGATION_VERTICAL_ALIGNMENT_CENTER = 0;
    public static final int NAVIGATION_VERTICAL_ALIGNMENT_TOP = 1;
    /* access modifiers changed from: private */
    public NavigationLayoutCallBack callBack;
    private Context context;
    /* access modifiers changed from: private */
    public int index;
    private int mNavigationVerticalAlignment;
    private int mNavigationViewBottomMargin;
    private int mNavigationViewTopMargin;
    /* access modifiers changed from: private */
    public ArrayList<String> navigationLetters = new ArrayList<>();
    /* access modifiers changed from: private */
    public NavigationView navigationView;
    private ArrayList<Integer> overlayLetterBackgroundColors;
    private int overlayLetterOneTextSize;
    /* access modifiers changed from: private */
    public int overlayLetterRightMargin;
    /* access modifiers changed from: private */
    public int overlayLetterSize;
    private int overlayLetterTextColor;
    private int overlayLetterThreeTextSize;
    private int overlayLetterTwoTextSize;
    /* access modifiers changed from: private */
    public ArrayList<String> overlayLetters;
    /* access modifiers changed from: private */
    public TextView overlayTextView;
    private ShapeDrawable shape;
    private HashMap<String, Integer> shapeColors;

    public interface NavigationLayoutCallBack {
        int getListViewFirstVisiblePosition();

        int getListViewHeightNow();

        int getListViewItemCount();

        int getListViewLastVisiblePosition();

        void location(String str);

        void stopListViewScroll();
    }

    public NavigationLayout(Context context2) {
        super(context2);
        this.context = ContextBuilder.build(context2, false, true);
        initializeDefault();
    }

    private void addListener() {
        this.navigationView.setCallBack(new NavigationView.NavigationViewCallBack() {
            public int getListViewFirstVisiblePosition() {
                if (NavigationLayout.this.callBack != null) {
                    return NavigationLayout.this.callBack.getListViewFirstVisiblePosition();
                }
                return -1;
            }

            public int getListViewHeightNow() {
                if (NavigationLayout.this.callBack != null) {
                    return NavigationLayout.this.callBack.getListViewHeightNow();
                }
                return 0;
            }

            public int getListViewItemCount() {
                if (NavigationLayout.this.callBack != null) {
                    return NavigationLayout.this.callBack.getListViewItemCount();
                }
                return 0;
            }

            public int getListViewLastVisiblePosition() {
                if (NavigationLayout.this.callBack != null) {
                    return NavigationLayout.this.callBack.getListViewLastVisiblePosition();
                }
                return -1;
            }

            public void hideOverlay() {
                Handler handler = NavigationLayout.this.getHandler();
                if (handler != null) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            NavigationLayout.this.overlayTextView.setVisibility(8);
                        }
                    }, 50);
                }
            }

            @RequiresApi
            public void location(String str, int i) {
                if (NavigationLayout.this.index != i || NavigationLayout.this.index == -1) {
                    String str2 = str;
                    int i2 = i;
                    int i3 = i2;
                    while (true) {
                        if (i2 < 0 && i3 >= NavigationLayout.this.navigationLetters.size()) {
                            return;
                        }
                        if (NavigationLayout.this.overlayLetters.contains(str2)) {
                            int unused = NavigationLayout.this.index = i;
                            NavigationLayout.this.disposeOverLayTextView(str2);
                            if (NavigationLayout.this.callBack != null) {
                                if (NavigationLayout.this.navigationView != null) {
                                    NavigationLayout.this.navigationView.setCurrentLetter(str2);
                                }
                                NavigationLayout.this.callBack.location(str2);
                                return;
                            }
                            return;
                        } else if (NavigationLayout.this.overlayLetters.contains(str)) {
                            int unused2 = NavigationLayout.this.index = i;
                            NavigationLayout.this.disposeOverLayTextView(str);
                            if (NavigationLayout.this.callBack != null) {
                                if (NavigationLayout.this.navigationView != null) {
                                    NavigationLayout.this.navigationView.setCurrentLetter(str);
                                }
                                NavigationLayout.this.callBack.location(str);
                                return;
                            }
                            return;
                        } else {
                            if (i2 >= 0 && i2 < NavigationLayout.this.navigationLetters.size()) {
                                str2 = (String) NavigationLayout.this.navigationLetters.get(i2);
                            }
                            if (i3 >= 0 && i3 < NavigationLayout.this.navigationLetters.size()) {
                                str = (String) NavigationLayout.this.navigationLetters.get(i3);
                            }
                            i2--;
                            i3++;
                        }
                    }
                }
            }

            public void showOverlay() {
                NavigationLayout.this.overlayTextView.setVisibility(0);
            }

            public void stopListViewScroll() {
                int unused = NavigationLayout.this.index = -1;
                if (NavigationLayout.this.callBack != null) {
                    NavigationLayout.this.callBack.stopListViewScroll();
                }
            }

            public void touchY(float f) {
                if (f - ((float) (NavigationLayout.this.overlayLetterSize / 2)) < 0.0f) {
                    NavigationLayout.this.overlayTextView.setTranslationY(0.0f);
                } else if (f - ((float) (NavigationLayout.this.overlayLetterSize / 2)) > ((float) (NavigationLayout.this.navigationView.getHeight() - NavigationLayout.this.overlayLetterSize))) {
                    NavigationLayout.this.overlayTextView.setTranslationY((float) (NavigationLayout.this.navigationView.getHeight() - NavigationLayout.this.overlayLetterSize));
                } else {
                    NavigationLayout.this.overlayTextView.setTranslationY(f - ((float) (NavigationLayout.this.overlayLetterSize / 2)));
                }
                if (NavigationLayout.this.getLayoutDirection() == 1) {
                    NavigationLayout.this.overlayTextView.setTranslationX((float) NavigationLayout.this.overlayLetterRightMargin);
                }
            }
        });
    }

    private void disposeNavigationParams() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.navigationView.getLayoutParams();
        layoutParams.addRule(21);
        int i = this.mNavigationVerticalAlignment;
        if (i == 1) {
            layoutParams.addRule(10);
        } else if (i != 2) {
            layoutParams.addRule(15);
        } else {
            layoutParams.addRule(12);
        }
        layoutParams.setMargins(layoutParams.getMarginStart(), this.mNavigationViewTopMargin, layoutParams.getMarginEnd(), this.mNavigationViewBottomMargin);
        this.navigationView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void disposeOverLayTextView(String str) {
        if (str.length() == 1) {
            this.overlayTextView.setTextSize(0, (float) this.overlayLetterOneTextSize);
        } else if (str.length() == 2) {
            this.overlayTextView.setTextSize(0, (float) this.overlayLetterOneTextSize);
        } else if (str.length() == 3) {
            this.overlayTextView.setTextSize(0, (float) this.overlayLetterThreeTextSize);
        } else {
            this.overlayTextView.setTextSize(0, (float) this.overlayLetterOneTextSize);
        }
        this.overlayTextView.setText(str);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        this.shape = shapeDrawable;
        shapeDrawable.getPaint().setColor(getResources().getColor(this.shapeColors.get(str).intValue()));
        this.overlayTextView.setBackground(this.shape);
    }

    private void disposeOverlayTextViewParams() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.overlayTextView.getLayoutParams();
        layoutParams.addRule(6, this.navigationView.getId());
        layoutParams.addRule(16, this.navigationView.getId());
        layoutParams.rightMargin = this.overlayLetterRightMargin;
        int i = this.overlayLetterSize;
        layoutParams.width = i;
        layoutParams.height = i;
        this.overlayTextView.setLayoutParams(layoutParams);
    }

    private void disposeShapeColors(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.shapeColors.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                HashMap<String, Integer> hashMap = this.shapeColors;
                ArrayList<Integer> arrayList2 = this.overlayLetterBackgroundColors;
                hashMap.put(arrayList.get(i), arrayList2.get(i % arrayList2.size()));
            }
        }
    }

    private int getColor(int i) {
        return this.context.getResources().getColor(i);
    }

    private int getPxSize(int i) {
        return this.context.getResources().getDimensionPixelSize(i);
    }

    private void initializeDefault() {
        this.index = -1;
        this.overlayLetters = new ArrayList<>();
        this.overlayLetterBackgroundColors = new ArrayList<>();
        this.shapeColors = new HashMap<>();
        String[] strArr = NavigationView.DEFAULT_LETTERS;
        for (int i = 0; i < strArr.length; i++) {
            this.overlayLetters.add(strArr[i]);
            this.navigationLetters.add(strArr[i]);
        }
        setOverlayLetterBackgroundColors(COLORS_DEFAULT);
        disposeShapeColors(this.overlayLetters);
        this.overlayLetterTextColor = getColor(R.color.mc_fastscroll_letter_overlay_text_color);
        this.overlayLetterOneTextSize = getPxSize(R.dimen.mc_fastscroll_letter_overlay_text_size);
        this.overlayLetterTwoTextSize = getPxSize(R.dimen.mc_fastscroll_letter_overlay_two_text_size);
        this.overlayLetterThreeTextSize = getPxSize(R.dimen.mc_fastscroll_letter_overlay_three_text_size);
        this.overlayLetterSize = getPxSize(R.dimen.mc_fastscroll_letter_overlay_layout_width);
        this.overlayLetterRightMargin = getPxSize(R.dimen.mc_fastscroll_letter_overlay_layout_margin_right);
    }

    public ArrayList<Integer> getOverlayLetterBackgroundColors() {
        return this.overlayLetterBackgroundColors;
    }

    public HashMap<String, Integer> getOverlayLetterColors() {
        return this.shapeColors;
    }

    @SuppressLint({"ResourceType"})
    public void initializeFromAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(attributeSet, R.styleable.FastScrollLetter, R.attr.MeizuCommon_FastScrollLetter, 0);
        this.overlayLetterTextColor = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcOverlayLetterTextColor, this.overlayLetterTextColor);
        this.overlayLetterOneTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterOneTextSize, (float) this.overlayLetterOneTextSize);
        this.overlayLetterTwoTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterTwoTextSize, (float) this.overlayLetterTwoTextSize);
        this.overlayLetterThreeTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterThreeTextSize, (float) this.overlayLetterThreeTextSize);
        this.overlayLetterSize = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterSize, (float) this.overlayLetterSize);
        this.mNavigationViewTopMargin = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationViewTopMargin, 0.0f);
        this.mNavigationViewBottomMargin = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcNavigationViewBottomMargin, 0.0f);
        this.mNavigationVerticalAlignment = obtainStyledAttributes.getInt(R.styleable.FastScrollLetter_mcNavigationVerticalAlignment, 0);
        NavigationView navigationView2 = new NavigationView(this.context);
        this.navigationView = navigationView2;
        addView(navigationView2);
        this.navigationView.setId(10086);
        this.navigationView.initializeFromAttrs(attributeSet);
        disposeNavigationParams();
        TextView textView = new TextView(this.context);
        this.overlayTextView = textView;
        addView(textView);
        this.overlayTextView.setTextColor(this.overlayLetterTextColor);
        this.overlayTextView.setIncludeFontPadding(false);
        this.overlayTextView.setGravity(17);
        this.overlayTextView.setVisibility(8);
        disposeOverlayTextViewParams();
        addListener();
    }

    public void initialized() {
        this.navigationView.initialized();
        ArrayList<String> arrayList = this.overlayLetters;
        if (arrayList != null && arrayList.size() > 0) {
            disposeOverLayTextView(this.overlayLetters.get(0));
        }
    }

    public void setAutoHideLetter(boolean z) {
        this.navigationView.setAutoHideLetter(z);
    }

    public void setCallBack(NavigationLayoutCallBack navigationLayoutCallBack) {
        this.callBack = navigationLayoutCallBack;
    }

    public void setCurrentLetter(String str) {
        NavigationView navigationView2 = this.navigationView;
        if (navigationView2 != null) {
            navigationView2.setCurrentLetter(str);
        }
    }

    public void setCurrentLetterFormScrolling(int i, String str) {
        NavigationView navigationView2 = this.navigationView;
        if (navigationView2 != null) {
            navigationView2.setCurrentLetterFormScrolling(i, str);
        }
    }

    public void setHideBottomPassCount(int i) {
        this.navigationView.setHideBottomPassCount(i);
    }

    public void setHideNavigationLetter(String... strArr) {
        this.navigationView.setHideNavigationLetter(strArr);
    }

    public void setHideTopPassCount(int i) {
        this.navigationView.setHideTopPassCount(i);
    }

    public void setIntervalHide(int i) {
        this.navigationView.setIntervalHide(i);
    }

    public void setNavigationLetterActiveBackgroundColor(int i) {
        this.navigationView.setNavigationLetterActiveBackgroundColor(i);
    }

    public void setNavigationLetterActiveTextColor(int i) {
        this.navigationView.setNavigationLetterActiveTextColor(i);
    }

    public void setNavigationLetterNormalBackgroundColor(int i) {
        this.navigationView.setNavigationLetterNormalBackgroundColor(i);
    }

    public void setNavigationLetterNormalTextColor(int i) {
        this.navigationView.setNavigationLetterNormalTextColor(i);
    }

    public void setNavigationLetterRightMargin(int i) {
        this.navigationView.setNavigationLetterRightMargin(i);
    }

    public void setNavigationLetterRightPadding(int i) {
        this.navigationView.setNavigationLetterRightPadding(i);
    }

    public void setNavigationLetterSelectedBackgroundColor(int i) {
        this.navigationView.setNavigationLetterSelectedBackgroundColor(i);
    }

    public void setNavigationLetterSelectedBackgroundRadius(int i) {
        this.navigationView.setNavigationLetterSelectedBackgroundRadius(i);
    }

    public void setNavigationLetterSelectedTextColor(int i) {
        this.navigationView.setNavigationLetterSelectedTextColor(i);
    }

    public void setNavigationLetterTextSize(int i) {
        this.navigationView.setNavigationLetterTextSize(i);
    }

    public void setNavigationLetterVerticalSpace(int i) {
        this.navigationView.setNavigationLetterVerticalSpace(i);
    }

    public void setNavigationLetterWidth(int i) {
        this.navigationView.setNavigationLetterWidth(i);
    }

    public void setNavigationLetters(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.navigationLetters = arrayList;
            this.navigationView.setNavigationLetters(arrayList);
        }
    }

    public void setNavigationViewAlignment(int i) {
        if (i != this.mNavigationVerticalAlignment) {
            this.mNavigationVerticalAlignment = i;
            disposeNavigationParams();
            requestLayout();
        }
    }

    public void setNavigationViewVerticalMargins(int i, int i2) {
        if (i != this.mNavigationViewTopMargin || i2 != this.mNavigationViewBottomMargin) {
            this.mNavigationViewBottomMargin = i2;
            this.mNavigationViewTopMargin = i;
            disposeNavigationParams();
            requestLayout();
        }
    }

    public void setOverlayLetterBackgroundColors(String str) {
        if (str.equals(FastScrollLetterOverlayBG.COLORFUL)) {
            setOverlayLetterBackgroundColors(COLORS);
        } else {
            setOverlayLetterBackgroundColors(R.color.mc_fast_scroll_letter_color_gray);
        }
    }

    public void setOverlayLetterOneTextSize(int i) {
        this.overlayLetterOneTextSize = i;
    }

    public void setOverlayLetterRightMargin(int i) {
        this.overlayLetterRightMargin = i;
        disposeOverlayTextViewParams();
    }

    public void setOverlayLetterSize(int i) {
        this.overlayLetterSize = i;
        disposeOverlayTextViewParams();
    }

    public void setOverlayLetterTextColor(int i) {
        this.overlayLetterTextColor = i;
        TextView textView = this.overlayTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setOverlayLetterThreeTextSize(int i) {
        this.overlayLetterThreeTextSize = i;
    }

    public void setOverlayLetterTwoTextSize(int i) {
        this.overlayLetterTwoTextSize = i;
    }

    public void setOverlayLetters(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.overlayLetters = arrayList;
            disposeShapeColors(arrayList);
        }
    }

    public void setHideNavigationLetter(String str, Bitmap bitmap, Bitmap bitmap2) {
        this.navigationView.setHideNavigationLetter(str, bitmap, bitmap2);
    }

    public void setOverlayLetterBackgroundColors(int... iArr) {
        this.overlayLetterBackgroundColors.clear();
        for (int valueOf : iArr) {
            this.overlayLetterBackgroundColors.add(Integer.valueOf(valueOf));
        }
    }
}
