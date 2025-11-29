package com.sina.weibo.sdk;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public final class p {
    public static u a(t tVar) {
        InputStream inputStream;
        String str = tVar.f9994a;
        Bundle bundle = tVar.b;
        if (!(bundle == null || bundle.size() == 0 || TextUtils.isEmpty(str))) {
            Uri parse = Uri.parse(str);
            if (!bundle.isEmpty()) {
                Uri.Builder buildUpon = parse.buildUpon();
                for (String next : bundle.keySet()) {
                    buildUpon.appendQueryParameter(next, String.valueOf(bundle.get(next)));
                }
                parse = buildUpon.build();
            }
            if (parse != null) {
                str = parse.toString();
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            Bundle bundle2 = new Bundle();
            bundle2.putString("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
            a(httpURLConnection, bundle2);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(tVar.g);
            httpURLConnection.setConnectTimeout(tVar.f);
            httpURLConnection.connect();
            a(httpURLConnection.getOutputStream(), tVar);
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            u uVar = new u(inputStream);
            httpURLConnection.disconnect();
            return uVar;
        } catch (Exception e) {
            throw new Throwable(e.getMessage());
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static void a(OutputStream outputStream, t tVar) {
        Bundle bundle = tVar.c;
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : bundle.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String valueOf = String.valueOf(bundle.get(next));
            try {
                sb.append(URLEncoder.encode(next, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(valueOf, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes("UTF-8"));
            dataOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(HttpURLConnection httpURLConnection, Bundle bundle) {
        for (String next : bundle.keySet()) {
            httpURLConnection.addRequestProperty(next, String.valueOf(bundle.get(next)));
        }
    }
}
