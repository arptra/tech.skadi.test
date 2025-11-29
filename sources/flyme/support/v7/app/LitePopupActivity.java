package flyme.support.v7.app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.StyleRes;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.widget.Toolbar;
import io.flutter.plugin.platform.PlatformPlugin;

public abstract class LitePopupActivity extends AppCompatActivity {
    public static final String EXTRA_KEY_IS_POPUP = "popup_activity";
    public static final String EXTRA_KEY_THEME_ID = "popup_theme_id";
    public static final String POPUP_STACK_TAG = "popup_stack";
    private Boolean mIsPopup = Boolean.TRUE;
    private LitePopupImpl mLitePopup;
    private boolean mSubDecorInstalled;
    @StyleRes
    private int mThemeId = R.style.Theme_Flyme_AppCompat_Light_LitePopupOverlay;
    private Toolbar mToolbar;

    private void ensureSubDecor() {
        if (!this.mSubDecorInstalled) {
            super.setContentView(R.layout.activity_lite_popup);
            View findViewById = findViewById(R.id.content_panel);
            ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
            if (viewGroup != null) {
                viewGroup.setId(-1);
                findViewById.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground((Drawable) null);
                }
            }
            this.mSubDecorInstalled = true;
            initView();
        }
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.title_bar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        this.mLitePopup = new LitePopupImpl(this);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.mIsPopup.booleanValue()) {
            super.addContentView(view, layoutParams);
            return;
        }
        ensureSubDecor();
        ((ViewGroup) findViewById(16908290)).addView(view, layoutParams);
        onContentChanged();
    }

    public void dismiss() {
        superOnBackPressed();
    }

    public void finish(boolean z) {
        finish();
    }

    public LitePopup getLitePopup() {
        return this.mLitePopup;
    }

    public boolean isPopup() {
        return this.mIsPopup.booleanValue();
    }

    public void onBackPressed() {
        if (this.mIsPopup.booleanValue()) {
            this.mLitePopup.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mIsPopup = Boolean.valueOf(bundle.getBoolean(EXTRA_KEY_IS_POPUP, this.mIsPopup.booleanValue()));
            this.mThemeId = bundle.getInt(EXTRA_KEY_THEME_ID, this.mThemeId);
        } else if (getIntent() != null) {
            Intent intent = getIntent();
            this.mIsPopup = Boolean.valueOf(intent.getBooleanExtra(EXTRA_KEY_IS_POPUP, this.mIsPopup.booleanValue()));
            this.mThemeId = intent.getIntExtra(EXTRA_KEY_THEME_ID, this.mThemeId);
        }
        if (isPopup()) {
            getTheme().applyStyle(this.mThemeId, true);
            ensureSubDecor();
            this.mLitePopup.onActivityCreate();
        } else {
            setTheme(this.mThemeId);
            overridePendingTransition(com.meizu.common.R.anim.mz_activity_to_next_open_enter, com.meizu.common.R.anim.mz_activity_to_next_open_exit);
        }
        super.onCreate(bundle);
        getWindow().setWindowAnimations(com.meizu.common.R.style.Flyme_Popup_Window_Animation_Style);
        if (isPopup()) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | PlatformPlugin.DEFAULT_SYSTEM_UI);
        }
    }

    public void onDismissProgress(float f) {
    }

    public void onDismissed() {
    }

    public void onDragToDismissTriggered() {
    }

    public void onResume() {
        super.onResume();
        if (this.mIsPopup.booleanValue()) {
            this.mLitePopup.onActivityResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(EXTRA_KEY_IS_POPUP, this.mIsPopup.booleanValue());
        bundle.putInt(EXTRA_KEY_THEME_ID, this.mThemeId);
    }

    public void performDismissProgress(float f) {
        onDismissProgress(f);
    }

    public void performDismissed() {
        onDismissed();
    }

    public void performDragTriggered() {
        onDragToDismissTriggered();
    }

    public void prepareStackPopup(int i) {
        this.mLitePopup.prepareStackPopup(i);
    }

    public void setContentView(int i) {
        if (!this.mIsPopup.booleanValue()) {
            super.setContentView(i);
            return;
        }
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this).inflate(i, viewGroup);
        onContentChanged();
    }

    public void superFinish() {
        super.finish();
    }

    public void superOnBackPressed() {
        super.onBackPressed();
        performDismissed();
    }

    public void finish() {
        if (this.mIsPopup.booleanValue()) {
            this.mLitePopup.onActivityFinish();
            return;
        }
        super.finish();
        overridePendingTransition(com.meizu.common.R.anim.mz_activity_to_next_close_enter, com.meizu.common.R.anim.mz_activity_to_next_close_exit);
    }

    public void setContentView(View view) {
        if (!this.mIsPopup.booleanValue()) {
            super.setContentView(view);
            return;
        }
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        onContentChanged();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.mIsPopup.booleanValue()) {
            super.setContentView(view, layoutParams);
            return;
        }
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        onContentChanged();
    }
}
