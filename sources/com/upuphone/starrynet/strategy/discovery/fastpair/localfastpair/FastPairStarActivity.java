package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.meizu.common.widget.CircleProgressBar;
import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import com.meizu.flyme.policy.sdk.util.PolicySdkNetworkUtil;
import com.meizu.flyme.policy.sdk.util.PolicySdkToolsUtils;
import com.upuphone.starrynet.R;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairConnectChangeEvent;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairEventBus;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairOperateEvent;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairPolicyEvent;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.HashMap;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;

public class FastPairStarActivity extends Activity implements EventReceiver, View.OnClickListener {
    private static final String DEVICE_ID_AIR = "00021003";
    private static final String DEVICE_ID_AIR_PRO = "00021004";
    private static final String DEVICE_ID_STAR = "00021002";
    private static final String PREFIX_FAST_PAIR = "fast_pair_";
    private static final String SUFFIX_CONNECT = "_connect";
    private static final String SUFFIX_CONNECT_OK = "_connected";
    private static final String TAG = "FastPairStarActivity";
    private boolean isAppInstalled;
    private Button mBtnNegative;
    /* access modifiers changed from: private */
    public Button mBtnPositive;
    /* access modifiers changed from: private */
    public CheckBox mCbxPrivacy;
    private ConstraintLayout mClNegative;
    private int mConnectState;
    private String mConnectedResId;
    private String mConnectingResId;
    private Context mContext;
    private String mDeviceId;
    private String mDeviceName;
    private PAGImageView mImageView;
    private LinearLayout mLayoutPrivacy;
    /* access modifiers changed from: private */
    public ViewGroup mLayoutWindows;
    /* access modifiers changed from: private */
    public String mLocalPP;
    /* access modifiers changed from: private */
    public String mLocalUP;
    private TextView mTvDeviceName;
    private TextView mTvNegative;
    private TextView mTvTitle;

    private void checkSuperAppInstalled() {
        try {
            this.mContext.getPackageManager().getPackageInfo("com.upuphone.star.launcher", 0);
            this.isAppInstalled = true;
        } catch (PackageManager.NameNotFoundException unused) {
            this.isAppInstalled = false;
        }
    }

    private void init() {
        StLog.d(TAG, "init");
        this.mTvTitle = (TextView) findViewById(R.id.tv_title);
        this.mTvDeviceName = (TextView) findViewById(R.id.tv_device_name);
        this.mLayoutPrivacy = (LinearLayout) findViewById(R.id.layout_privacy);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_privacy_cb_wrapper);
        this.mImageView = (PAGImageView) findViewById(R.id.iv_image);
        this.mCbxPrivacy = (CheckBox) findViewById(R.id.cbx_privacy);
        initServicePrivacy();
        this.mBtnNegative = (Button) findViewById(R.id.btn_negative);
        this.mBtnPositive = (Button) findViewById(R.id.btn_positive);
        this.mTvNegative = (TextView) findViewById(R.id.tv_negative);
        this.mClNegative = (ConstraintLayout) findViewById(R.id.cl_negative);
        this.mLayoutWindows = (ViewGroup) findViewById(R.id.layout_windows);
        if (getResources().getConfiguration().orientation == 2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mLayoutWindows.getLayoutParams().height = displayMetrics.heightPixels;
            this.mLayoutWindows.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    FastPairStarActivity.this.mLayoutWindows.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    StLog.d(FastPairStarActivity.TAG, " mLayoutWindows  onGlobalLayout");
                    FastPairStarActivity.this.mLayoutWindows.requestLayout();
                    FastPairStarActivity.this.mLayoutWindows.invalidate();
                }
            });
        }
        this.mBtnNegative.setOnClickListener(this);
        this.mBtnPositive.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
        this.mTvDeviceName.setText(this.mDeviceName);
        prepareResource();
        this.mCbxPrivacy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    FastPairStarActivity.this.mCbxPrivacy.setButtonDrawable(R.mipmap.fastpair_check_privacy_policy);
                    FastPairStarActivity.this.mBtnPositive.setTextColor(FastPairStarActivity.this.getColor(R.color.blue));
                    FastPairStarActivity.this.mBtnPositive.setEnabled(true);
                    return;
                }
                FastPairStarActivity.this.mCbxPrivacy.setButtonDrawable(R.mipmap.fastpair_uncheck_privacy_policy);
                FastPairStarActivity.this.mBtnPositive.setTextColor(FastPairStarActivity.this.getColor(R.color.blue_disable));
                FastPairStarActivity.this.mBtnPositive.setEnabled(false);
            }
        });
        initPolicySDK(this);
        this.mCbxPrivacy.setButtonDrawable(R.mipmap.fastpair_uncheck_privacy_policy);
        this.mBtnPositive.setTextColor(getColor(R.color.blue_disable));
        this.mBtnPositive.setEnabled(false);
        postOperateEvent(4);
    }

    private void initPolicySDK(Context context) {
        String str;
        String str2;
        this.mLocalUP = "file:////android_asset/html/up_0.html";
        this.mLocalPP = "file:////android_asset/html/pp_0.html";
        if (DEVICE_ID_STAR.equals(this.mDeviceId)) {
            str2 = "36152120683616089700";
            str = "afb122a91138414fbaffd3735fd8b767";
        } else if (DEVICE_ID_AIR.equals(this.mDeviceId) || DEVICE_ID_AIR_PRO.equals(this.mDeviceId)) {
            str2 = "82694969009158162640";
            str = "77751e6be6cf4556b96071cf7a1b1891";
        } else {
            str2 = "14008189647544656270";
            str = "6ec731cf52d84acfa7f1dfbc35066db6";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("up", this.mLocalUP);
        hashMap.put("pp", this.mLocalPP);
        PolicySdk.initSDK(context, str2, str, "2.2.0", hashMap);
    }

    private void initServicePrivacy() {
        TextView textView = (TextView) findViewById(R.id.tv_agreement_and_privacy);
        String string = getString(R.string.user_Agreement_Symbol);
        String string2 = getString(R.string.privacy_policy_Symbol);
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.Read_and_Agree));
        int length = sb.length();
        sb.append(string);
        int length2 = sb.length();
        sb.append(getString(R.string.and));
        int length3 = sb.length();
        sb.append(string2);
        int length4 = sb.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public void onClick(@NonNull View view) {
                FastPairStarActivity fastPairStarActivity = FastPairStarActivity.this;
                fastPairStarActivity.onClickGetPolicyData("up", fastPairStarActivity.getString(R.string.user_agreement), FastPairStarActivity.this.mLocalUP);
            }

            public void updateDrawState(@NonNull TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(FastPairStarActivity.this.getColor(R.color.blue));
                textPaint.setUnderlineText(false);
            }
        }, length, length2, 17);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public void onClick(@NonNull View view) {
                FastPairStarActivity fastPairStarActivity = FastPairStarActivity.this;
                fastPairStarActivity.onClickGetPolicyData("pp", fastPairStarActivity.getString(R.string.privacy_policy), FastPairStarActivity.this.mLocalPP);
            }

            public void updateDrawState(@NonNull TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(FastPairStarActivity.this.getColor(R.color.blue));
                textPaint.setUnderlineText(false);
            }
        }, length3, length4, 17);
        textView.setText(spannableStringBuilder);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* access modifiers changed from: private */
    public void onClickGetPolicyData(String str, final String str2, final String str3) {
        String language = PolicySdkToolsUtils.Companion.getLanguage();
        if (PolicySdkNetworkUtil.isNetworkAvailable(this)) {
            PolicySdk.getOnlinePolicyUrl(language, str, new PolicySdk.PolicySdkCallback() {
                public void getResult(PolicySdkResultBean policySdkResultBean) {
                    if (policySdkResultBean.getCode() == 0) {
                        FastPairStarActivity.this.startPolicyActivity(policySdkResultBean.getPolicyUrl(), str2);
                    } else {
                        FastPairStarActivity.this.startPolicyActivity(str3, str2);
                    }
                }
            });
        } else {
            startPolicyActivity(str3, str2);
        }
    }

    private void playPagAnimation(String str, boolean z) {
        StLog.d(TAG, "playPagAnimation :" + str);
        this.mImageView.setComposition(PAGFile.Load(getAssets(), str));
        this.mImageView.setRepeatCount(z ? 1 : 0);
        this.mImageView.play();
    }

    private void postOperateEvent(int i) {
        FastPairOperateEvent fastPairOperateEvent = new FastPairOperateEvent();
        fastPairOperateEvent.setAction(i);
        FastPairEventBus.get().post(fastPairOperateEvent);
    }

    private void setVirtualNavigationBarColor() {
        if (getResources().getConfiguration().orientation == 2) {
            getWindow().setNavigationBarColor(0);
        } else {
            getWindow().setNavigationBarColor(getApplicationContext().getColor(R.color.black_10));
        }
    }

    /* access modifiers changed from: private */
    public void startPolicyActivity(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        intent.setClass(this, FastPairPolicyActivity.class);
        startActivity(intent);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_negative) {
            if (this.mConnectState == 2) {
                if (this.isAppInstalled) {
                    postOperateEvent(2);
                } else {
                    postOperateEvent(3);
                }
            }
            finish();
        } else if (id == R.id.btn_positive) {
            int i = this.mConnectState;
            if (i == 0 || i == 3) {
                postOperateEvent(0);
            } else if (i == 2) {
                finish();
            }
        } else if (id == R.id.ll_privacy_cb_wrapper) {
            CheckBox checkBox = this.mCbxPrivacy;
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        StLog.d(TAG, "onConfigurationChanged");
        setVirtualNavigationBarColor();
        setContentView(R.layout.activity_fast_pair_star);
        init();
    }

    public void onCreate(Bundle bundle) {
        StLog.d(TAG, "onCreate");
        super.onCreate(bundle);
        this.mContext = getApplicationContext();
        Intent intent = getIntent();
        this.mDeviceId = intent.getStringExtra("id");
        this.mDeviceName = intent.getStringExtra("name");
        getWindow().clearFlags(CircleProgressBar.RIM_COLOR_DEF);
        getWindow().getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        setVirtualNavigationBarColor();
        setContentView(R.layout.activity_fast_pair_star);
        FastPairEventBus.get().register(FastPairConnectChangeEvent.class, this);
        FastPairEventBus.get().register(FastPairPolicyEvent.class, this);
        init();
    }

    public void onDestroy() {
        super.onDestroy();
        StLog.d(TAG, "onDestroy");
        FastPairEventBus.get().unregister(FastPairConnectChangeEvent.class, this);
        FastPairEventBus.get().unregister(FastPairPolicyEvent.class, this);
    }

    public void onEvent(Object obj) {
        if (obj instanceof FastPairConnectChangeEvent) {
            FastPairConnectChangeEvent fastPairConnectChangeEvent = (FastPairConnectChangeEvent) obj;
            StLog.d(TAG, "event = " + fastPairConnectChangeEvent.getStatus());
            onStatusChange(fastPairConnectChangeEvent.getStatus(), fastPairConnectChangeEvent.getErrorCode());
        } else if (obj instanceof FastPairPolicyEvent) {
            FastPairPolicyEvent fastPairPolicyEvent = (FastPairPolicyEvent) obj;
            boolean policy = fastPairPolicyEvent.getPolicy();
            StLog.d(TAG, "event = " + policy);
            if (policy) {
                FastPairEventBus.get().post(new FastPairOperateEvent(0));
            }
            if (fastPairPolicyEvent.isVisible()) {
                this.mLayoutWindows.setVisibility(0);
            } else {
                this.mLayoutWindows.setVisibility(4);
            }
        }
    }

    public void onStatusChange(int i, int i2) {
        if (this.mConnectState != 2) {
            this.mConnectState = i;
            if (i == 1) {
                this.mTvTitle.setText(R.string.connecting);
                this.mTvDeviceName.setText(this.mDeviceName);
                this.mLayoutPrivacy.setVisibility(8);
                this.mClNegative.setVisibility(8);
                this.mTvNegative.setVisibility(8);
                this.mBtnPositive.setVisibility(8);
            } else if (i == 2) {
                checkSuperAppInstalled();
                this.mTvTitle.setText(R.string.connect_success);
                this.mTvDeviceName.setText(R.string.explore_ar_world);
                playPagAnimation(this.mConnectedResId, true);
                if (this.isAppInstalled) {
                    this.mClNegative.setVisibility(0);
                    this.mBtnNegative.setVisibility(0);
                    this.mBtnNegative.setText("");
                    this.mTvNegative.setVisibility(0);
                    this.mTvNegative.setText(R.string.open_super_app);
                } else {
                    this.mClNegative.setVisibility(8);
                }
                this.mBtnPositive.setVisibility(0);
                this.mBtnPositive.setText(R.string.connect_done);
            } else if (i == 3) {
                this.mTvTitle.setText(R.string.connect_failed);
                String string = getString(R.string.connect_failed_text_retry);
                if (i2 == 1) {
                    string = getString(R.string.connect_failed_text_timeout);
                } else if (i2 == 2) {
                    string = getString(R.string.connect_failed_text_param_error);
                }
                this.mTvDeviceName.setText(string);
                this.mClNegative.setVisibility(0);
                this.mTvNegative.setVisibility(8);
                this.mBtnPositive.setVisibility(0);
                this.mBtnNegative.setText(R.string.cancel);
                this.mBtnPositive.setText(R.string.connect_again);
            }
        }
    }

    public void onStop() {
        super.onStop();
        StLog.d(TAG, "onStop");
        FastPairOperateEvent fastPairOperateEvent = new FastPairOperateEvent();
        fastPairOperateEvent.setAction(1);
        FastPairEventBus.get().post(fastPairOperateEvent);
        finishAndRemoveTask();
    }

    public void prepareResource() {
        if (this.mDeviceId.endsWith("1002")) {
            this.mConnectingResId = "pag/s_fail_bmp.pag";
            this.mConnectedResId = "pag/s_success_bmp.pag";
        } else if (this.mDeviceId.endsWith("1003")) {
            this.mConnectingResId = "pag/a_fail_bmp.pag";
            this.mConnectedResId = "pag/a_success_bmp.pag";
        } else {
            this.mConnectingResId = "pag/ap_fail_bmp.pag";
            this.mConnectedResId = "pag/ap_success_bmp.pag";
        }
        playPagAnimation(this.mConnectingResId, false);
    }
}
