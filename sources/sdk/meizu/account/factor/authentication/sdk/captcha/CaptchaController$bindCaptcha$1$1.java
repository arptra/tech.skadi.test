package sdk.meizu.account.factor.authentication.sdk.captcha;

import android.util.Log;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.GT3Listener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0010"}, d2 = {"sdk/meizu/account/factor/authentication/sdk/captcha/CaptchaController$bindCaptcha$1$1", "Lcom/geetest/sdk/GT3Listener;", "onButtonClick", "", "onClosed", "p0", "", "onDialogResult", "result", "", "onFailed", "errorBean", "Lcom/geetest/sdk/GT3ErrorBean;", "onReceiveCaptchaCode", "onStatistics", "onSuccess", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CaptchaController$bindCaptcha$1$1 extends GT3Listener {
    public void onButtonClick() {
        Log.d("CaptchaManager", "onButtonClick");
        if (CaptchaController.mGt3ConfigBean != null && CaptchaController.mGt3GeetestUtils != null) {
            GT3ConfigBean access$getMGt3ConfigBean$p = CaptchaController.mGt3ConfigBean;
            if (access$getMGt3ConfigBean$p != null) {
                access$getMGt3ConfigBean$p.r(CaptchaController.mGt3ApiParam);
            }
            GT3GeetestUtils access$getMGt3GeetestUtils$p = CaptchaController.mGt3GeetestUtils;
            if (access$getMGt3GeetestUtils$p != null) {
                access$getMGt3GeetestUtils$p.b();
            }
        }
    }

    public void onClosed(int i) {
    }

    public void onDialogResult(@Nullable String str) {
        Log.d("CaptchaManager", "onDialogResult, result: " + str);
        GT3GeetestUtils access$getMGt3GeetestUtils$p = CaptchaController.mGt3GeetestUtils;
        if (access$getMGt3GeetestUtils$p != null) {
            access$getMGt3GeetestUtils$p.e();
        }
        if (str == null || str.length() == 0) {
            CaptchaController.Callback access$getMCallback$p = CaptchaController.mCallback;
            if (access$getMCallback$p != null) {
                access$getMCallback$p.onSuccess((GeetestData) null);
                return;
            }
            return;
        }
        try {
            CaptchaController.Callback access$getMCallback$p2 = CaptchaController.mCallback;
            if (access$getMCallback$p2 != null) {
                access$getMCallback$p2.onSuccess(GeetestData.Companion.parseData(str));
            }
        } catch (JSONException e) {
            CaptchaController.Callback access$getMCallback$p3 = CaptchaController.mCallback;
            if (access$getMCallback$p3 != null) {
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                access$getMCallback$p3.onFailed(101, message);
            }
        }
    }

    public void onFailed(@NotNull GT3ErrorBean gT3ErrorBean) {
        Intrinsics.checkNotNullParameter(gT3ErrorBean, "errorBean");
        CaptchaController.Callback access$getMCallback$p = CaptchaController.mCallback;
        if (access$getMCallback$p != null) {
            String str = gT3ErrorBean.f2897a;
            Intrinsics.checkNotNullExpressionValue(str, "errorCode");
            int parseInt = Integer.parseInt(str);
            String str2 = gT3ErrorBean.b;
            Intrinsics.checkNotNullExpressionValue(str2, "errorDesc");
            access$getMCallback$p.onFailed(parseInt, str2);
        }
    }

    public void onReceiveCaptchaCode(int i) {
    }

    public void onStatistics(@Nullable String str) {
    }

    public void onSuccess(@Nullable String str) {
    }
}
