package com.upuphone.ar.navi.lite.manger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.upuphone.ai.ttsengine.TtsCallback;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.model.INaviTts;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;

public class NaviTtsManager implements TtsCallback {
    private static final int[] AI_TIPS_ARRAY = {R.string.tts_navi_desp, R.string.tts_navi_desp_ok};
    private static final String TAG = ("NAVI-" + NaviTtsManager.class.getSimpleName());
    private static final long TIME_OUT_VALUE = 5000;
    private static NaviTtsManager instance;
    private Context mContext;
    private INaviTts naviTtsListener;
    private long ssTime = 0;
    private NaviTtsState ttsState = NaviTtsState.NONE;

    public enum NaviTtsState {
        NONE(0),
        START(1),
        ERROR(2),
        DONE(3);
        
        private int state;

        private NaviTtsState(int i) {
            this.state = i;
        }

        public int getType() {
            return this.state;
        }
    }

    public NaviTtsManager(Context context) {
        this.mContext = context.getApplicationContext();
        TtsSdk.f5490a.h(this);
    }

    public static NaviTtsManager getInstance(Context context) {
        if (instance == null) {
            instance = new NaviTtsManager(context);
        }
        return instance;
    }

    public int getNaviTipsTimes(Context context) {
        return context.getSharedPreferences("assistant", 0).getInt("NAVI_TIPS_TIMES", 0);
    }

    public boolean isPlayDone() {
        long currentTimeMillis = System.currentTimeMillis() - this.ssTime;
        NaviTtsState naviTtsState = this.ttsState;
        if (naviTtsState == NaviTtsState.DONE || naviTtsState == NaviTtsState.ERROR) {
            CLog.b(TAG, "isPlayDone() play DONE or ERROR!");
            return true;
        } else if (currentTimeMillis <= 5000) {
            return false;
        } else {
            CLog.b(TAG, "isPlayDone() tts play TIME_OUT!");
            this.ssTime = 0;
            return true;
        }
    }

    public void onDone(@Nullable String str, @Nullable String str2) {
        String str3 = TAG;
        CLog.b(str3, "onDone() enter. s=" + str + " s1=" + str2);
        if (str3.equals(str)) {
            this.ttsState = NaviTtsState.DONE;
            this.ssTime = 0;
            INaviTts iNaviTts = this.naviTtsListener;
            if (iNaviTts != null) {
                iNaviTts.onDone(str, str2);
            }
        }
    }

    public void onError(@Nullable String str, @Nullable String str2, int i) {
        String str3 = TAG;
        CLog.b(str3, "onError() enter. s=" + str + " s1=" + str2 + " i=" + i);
        if (str3.equals(str)) {
            this.ttsState = NaviTtsState.ERROR;
            this.ssTime = 0;
            INaviTts iNaviTts = this.naviTtsListener;
            if (iNaviTts != null) {
                iNaviTts.a(str, str2);
            }
        }
    }

    public void onStart(@Nullable String str, @Nullable String str2) {
        String str3 = TAG;
        CLog.b(str3, "onStart() enter. s=" + str + " s1=" + str2);
        if (str3.equals(str)) {
            this.ttsState = NaviTtsState.START;
            INaviTts iNaviTts = this.naviTtsListener;
            if (iNaviTts != null) {
                iNaviTts.onStart(str, str2);
            }
        }
    }

    public void setNaviTipsTimes(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("assistant", 0).edit();
        edit.putInt("NAVI_TIPS_TIMES", i);
        edit.apply();
    }

    public void setNaviTtsListener(INaviTts iNaviTts) {
        this.naviTtsListener = iNaviTts;
    }

    public void speakNormal() {
        String str;
        int naviTipsTimes = getNaviTipsTimes(this.mContext);
        String str2 = TAG;
        CLog.b(str2, "speakNormal() enter times=" + naviTipsTimes);
        if (NaviUtil.s0()) {
            str = NaviUtil.L(this.mContext, naviTipsTimes < 3 ? AI_TIPS_ARRAY[0] : AI_TIPS_ARRAY[1]);
        } else {
            str = NaviUtil.c0(this.mContext, naviTipsTimes < 3 ? AI_TIPS_ARRAY[0] : AI_TIPS_ARRAY[1]);
        }
        startSpeak(str);
        setNaviTipsTimes(this.mContext, naviTipsTimes + 1);
    }

    public void startSpeak(String str) {
        String str2 = TAG;
        CLog.b(str2, "startSpeak() enter. text=" + str);
        Bundle bundle = new Bundle();
        String str3 = System.currentTimeMillis() + "";
        bundle.putString("utteranceId", str3);
        bundle.putInt("caller_priority", 1);
        bundle.putInt("multi_language", 1);
        TtsSdk.f5490a.o(str2, str, 0, bundle, str3);
        this.ssTime = System.currentTimeMillis();
    }

    public void stopSpeak() {
        String str = TAG;
        CLog.b(str, "stopSpeak() enter.");
        TtsSdk.f5490a.r(str);
    }
}
