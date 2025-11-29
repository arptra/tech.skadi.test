package com.meizu.common.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.util.Property;
import android.view.View;
import android.view.Window;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.app.ActivityOptionsCompat;
import com.meizu.common.R;
import java.lang.ref.WeakReference;

public class SearchAnimHelper {
    @SuppressLint({"NewApi"})
    private static final PathInterpolator PATH_INTERPOLATOR = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    @SuppressLint({"NewApi"})
    private static final PathInterpolator PATH_INTERPOLATOR_TRANSLATION_Y = new PathInterpolator(0.2f, 0.0f, 0.2f, 1.0f);
    private static final float SEARCH_ACTION_BAR_DEFAULT_TRANSLATION_Y = 224.0f;
    private static final int SEARCH_ALPHA_DELAY = 50;
    private static final int SEARCH_ALPHA_DURATION = 100;
    private static final int SEARCH_ALPHA_EMPTY_DURATION = 100;
    private static final int SEARCH_ALPHA_SEARCH_DURATION = 250;
    private static final int SEARCH_BAR_DURATION = 256;
    private static final float SEARCH_CONTENT_DEFAULT_TRANSLATION_Y = 512.0f;
    private static final int SEARCH_ICON_COLLAPSE_DURATION = 208;
    private static final int SEARCH_ICON_EXPAND_DURATION = 288;
    private static final int SEARCH_TRANSITION_Y_SEARCH_DURATION = 175;
    private static final int SEARCH_TRANSLATION_DURATION = 350;
    private final float ICON_SCALE = 1.37f;
    private TimeInterpolator interpolator1;
    private TimeInterpolator interpolator2;
    private View mContainerView;
    /* access modifiers changed from: private */
    public EditText mEditText;
    public AnimatorSet mExitAnimSet;
    /* access modifiers changed from: private */
    public String mHintText;
    private View mHomeUpView;
    public AnimatorListenerAdapter mOnAnimEndListener;
    private View mSearchBar;
    private View mSearchIcon;

    public SearchAnimHelper(Activity activity, View view, int i, AnimatorListenerAdapter animatorListenerAdapter) {
        this.mOnAnimEndListener = animatorListenerAdapter;
        this.mHomeUpView = activity.getWindow().findViewById(i);
        if (view != null) {
            this.mContainerView = view;
            this.mSearchBar = view.findViewById(R.id.mc_search_bar);
            this.mSearchIcon = this.mContainerView.findViewById(R.id.mc_search_icon);
            this.mEditText = (EditText) this.mContainerView.findViewById(R.id.mc_search_edit);
        }
        initInterpolator();
    }

    private void initInterpolator() {
        this.interpolator1 = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
        this.interpolator2 = new PathInterpolator(0.01f, 0.0f, 0.1f, 1.0f);
    }

    private boolean isAnimatedViewExits() {
        return (this.mSearchBar == null || this.mSearchIcon == null || this.mEditText == null) ? false : true;
    }

    public static boolean setDrawDuringWindowAnimation(View view, boolean z) {
        try {
            Object invoke = View.class.getDeclaredMethod("getViewRootImpl", (Class[]) null).invoke(view, (Object[]) null);
            invoke.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", new Class[]{Boolean.TYPE}).invoke(invoke, new Object[]{Boolean.valueOf(z)});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setupSearchBackTransition(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 1);
    }

    public static void setupSearchEnterTransition(Activity activity) {
        setupSearchEnterTransition(activity, (Transition.TransitionListener) null);
    }

    public static void setupSearchEnterTransitionF8(Activity activity) {
        Window window = activity.getWindow();
        window.setSharedElementEnterTransition(TransitionInflater.from(activity).inflateTransition(R.transition.mc_search_enter_scale));
        window.setSharedElementExitTransition(TransitionInflater.from(activity).inflateTransition(R.transition.mc_search_exit_scale));
        TransitionSet transitionSet = new TransitionSet();
        TransitionSet transitionSet2 = new TransitionSet();
        Fade fade = new Fade();
        fade.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        fade.setDuration(320);
        fade.excludeTarget(activity.getString(R.string.mc_search_view_toolbar_transition_name), true);
        Fade fade2 = new Fade();
        fade2.setDuration(320);
        fade2.setInterpolator(new PathInterpolator(0.18f, 0.7f, 0.5f, 1.0f));
        fade2.excludeTarget(activity.getString(R.string.mc_search_view_container_transition_name), true);
        Fade fade3 = new Fade();
        fade3.setDuration(48);
        fade3.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        fade3.excludeTarget(activity.getString(R.string.mc_search_view_container_transition_name), true);
        transitionSet.addTransition(fade);
        transitionSet.addTransition(fade2);
        transitionSet2.addTransition(fade);
        transitionSet2.addTransition(fade3);
        transitionSet.setOrdering(0);
        transitionSet2.setOrdering(0);
        window.setEnterTransition(transitionSet);
        window.setExitTransition(transitionSet2);
    }

    public static void setupSearchOutTransition(Activity activity) {
        View findViewById;
        View findViewById2 = activity.findViewById(R.id.mc_search_layout_container);
        if (findViewById2 != null && (findViewById = findViewById2.findViewById(R.id.mc_search_edit)) != null) {
            findViewById.clearFocus();
            findViewById.setFocusable(false);
        }
    }

    public static void setupSearchTransition(Activity activity) {
        setupSearchEnterTransition(activity);
    }

    public static void startSearchActivity(Activity activity, Intent intent) {
        String string = activity.getString(R.string.mc_search_view_share_element_name);
        View findViewById = activity.findViewById(R.id.mc_search_layout);
        setupSearchEnterTransition(activity, (Transition.TransitionListener) null);
        if (findViewById != null) {
            activity.startActivity(intent, ActivityOptionsCompat.a(activity, findViewById, string).b());
            activity.overridePendingTransition(0, 0);
            return;
        }
        activity.startActivity(intent);
    }

    public static void startSearchEmptyEnterAnimation(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(250);
        ofFloat.setStartDelay(50);
        ofFloat.setInterpolator(PATH_INTERPOLATOR);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{SEARCH_CONTENT_DEFAULT_TRANSLATION_Y, 0.0f});
        ofFloat2.setDuration(350);
        ofFloat2.setInterpolator(PATH_INTERPOLATOR_TRANSLATION_Y);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public static void startSearchEmptyExitAnimation(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 1.0f});
        ofFloat.setDuration(100);
        PathInterpolator pathInterpolator = PATH_INTERPOLATOR;
        ofFloat.setInterpolator(pathInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, SEARCH_CONTENT_DEFAULT_TRANSLATION_Y});
        ofFloat2.setDuration(350);
        ofFloat2.setInterpolator(pathInterpolator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public static void startSearchEnterAnimation(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(250);
        ofFloat.setStartDelay(50);
        ofFloat.setInterpolator(PATH_INTERPOLATOR);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{-512.0f, 0.0f});
        ofFloat2.setDuration(350);
        ofFloat2.setInterpolator(PATH_INTERPOLATOR_TRANSLATION_Y);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public static void startSearchExitAnimation(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(100);
        ofFloat.setStartDelay(0);
        ofFloat.setInterpolator(PATH_INTERPOLATOR);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, -224.0f});
        ofFloat2.setDuration(350);
        ofFloat2.setInterpolator(PATH_INTERPOLATOR_TRANSLATION_Y);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public void startSearchExitAnim(float f, float f2) {
        AnimatorSet animatorSet = this.mExitAnimSet;
        if ((animatorSet == null || !animatorSet.isRunning()) && isAnimatedViewExits()) {
            this.mEditText.setCursorVisible(false);
            this.mEditText.setText("");
            this.mEditText.setHint("");
            if (this.mExitAnimSet == null) {
                View view = this.mSearchBar;
                Property property = View.ALPHA;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, new float[]{1.0f, 0.0f});
                ofFloat.setInterpolator(this.interpolator1);
                ofFloat.setDuration(256);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mSearchIcon, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f, f2}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.37f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.37f})});
                ofPropertyValuesHolder.setInterpolator(this.interpolator1);
                ofPropertyValuesHolder.setDuration(208);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSearchIcon, property, new float[]{0.5f, 1.0f});
                ofFloat2.setInterpolator(this.interpolator2);
                ofFloat2.setDuration(208);
                AnimatorListenerAdapter animatorListenerAdapter = this.mOnAnimEndListener;
                if (animatorListenerAdapter != null) {
                    ofFloat2.addListener(animatorListenerAdapter);
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.mExitAnimSet = animatorSet2;
                View view2 = this.mHomeUpView;
                if (view2 != null) {
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, property, new float[]{1.0f, 0.0f});
                    ofFloat3.setInterpolator(this.interpolator1);
                    ofFloat3.setDuration(256);
                    this.mExitAnimSet.playTogether(new Animator[]{ofFloat, ofPropertyValuesHolder, ofFloat2, ofFloat3});
                } else {
                    animatorSet2.playTogether(new Animator[]{ofFloat, ofPropertyValuesHolder, ofFloat2});
                }
            }
            this.mExitAnimSet.start();
            this.mSearchIcon.setTranslationY(-1.0f);
        }
    }

    public void startSearchExpandAnim(float f, float f2) {
        if (isAnimatedViewExits()) {
            this.mSearchIcon.setTranslationX(f);
            this.mEditText.setCursorVisible(false);
            this.mHintText = this.mEditText.getHint().toString();
            this.mEditText.setHint("");
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mSearchIcon, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f, f2}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.37f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.37f, 1.0f})});
            ofPropertyValuesHolder.setInterpolator(this.interpolator1);
            ofPropertyValuesHolder.setDuration(288);
            View view = this.mSearchIcon;
            Property property = View.ALPHA;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, new float[]{1.0f, 0.5f});
            ofFloat.setInterpolator(this.interpolator2);
            ofFloat.setDuration(288);
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    SearchAnimHelper.this.mEditText.setCursorVisible(true);
                    SearchAnimHelper.this.mEditText.setHint(SearchAnimHelper.this.mHintText);
                }
            });
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSearchBar, property, new float[]{0.0f, 1.0f});
            ofFloat2.setInterpolator(this.interpolator1);
            ofFloat2.setDuration(256);
            View view2 = this.mHomeUpView;
            if (view2 != null) {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, property, new float[]{0.0f, 1.0f});
                ofFloat3.setInterpolator(this.interpolator1);
                ofFloat3.setDuration(256);
                ofFloat3.start();
            }
            ofFloat2.start();
            ofPropertyValuesHolder.start();
            ofFloat.start();
        }
    }

    @SuppressLint({"NewApi"})
    public static Transition setupSearchEnterTransition(Activity activity, Transition.TransitionListener transitionListener) {
        Window window = ((Activity) new WeakReference(activity).get()).getWindow();
        Transition inflateTransition = TransitionInflater.from(activity).inflateTransition(R.transition.mc_search_enter_scale);
        if (transitionListener != null) {
            inflateTransition.addListener(transitionListener);
        }
        window.setSharedElementEnterTransition(inflateTransition);
        return inflateTransition;
    }

    public static void startSearchActivity(Activity activity, Intent intent, Transition.TransitionListener transitionListener) {
        String string = activity.getString(R.string.mc_search_view_share_element_name);
        View findViewById = activity.findViewById(R.id.mc_search_layout);
        if (findViewById != null) {
            activity.startActivity(intent, ActivityOptionsCompat.a(activity, findViewById, string).b());
        } else {
            activity.startActivity(intent);
        }
    }
}
