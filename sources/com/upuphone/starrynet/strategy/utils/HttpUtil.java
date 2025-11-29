package com.upuphone.starrynet.strategy.utils;

import android.util.Log;
import androidx.core.util.Consumer;
import com.upuphone.starrynet.common.StLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    public static final String ST_CONFIG_URL = "https://safe-apk.mzres.com/pack/cdnresource/starrynet/st_configs.json";
    private static final String TAG = "HttpUtil";
    private static final OkHttpClient mOkHttpClient = new OkHttpClient();

    public static void downloadContent(final String str, final Consumer<byte[]> consumer) {
        try {
            mOkHttpClient.newCall(new Request.Builder().url(str).build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    StLog.d(HttpUtil.TAG, "request call=" + call + " onFail, exception :" + Log.getStackTraceString(iOException));
                    Consumer consumer = Consumer.this;
                    if (consumer != null) {
                        consumer.accept((Object) null);
                    }
                }

                public void onResponse(Call call, Response response) throws IOException {
                    StLog.d(HttpUtil.TAG, "request url=" + str + " onResponse, code =" + response.code());
                    if (response.isSuccessful()) {
                        byte[] bytes = response.body().bytes();
                        Consumer consumer = Consumer.this;
                        if (consumer != null) {
                            consumer.accept(bytes);
                            return;
                        }
                        return;
                    }
                    Consumer consumer2 = Consumer.this;
                    if (consumer2 != null) {
                        consumer2.accept((Object) null);
                    }
                }
            });
        } catch (Exception e) {
            StLog.d(TAG, "downloadContent happen exception :" + Log.getStackTraceString(e));
        }
    }
}
