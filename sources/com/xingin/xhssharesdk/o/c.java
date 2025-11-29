package com.xingin.xhssharesdk.o;

import android.text.TextUtils;
import com.ucar.databus.proto.UCarProto;
import com.xingin.xhssharesdk.l.b;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class c {
    public static String a(String str, Map map) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : map.keySet()) {
                if (sb.length() != 0) {
                    sb.append("&");
                }
                sb.append(str2);
                sb.append("=");
                sb.append(map.get(str2));
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(sb.length()));
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(UCarProto.SampleRate.SAMPLE_RATE_8000_VALUE);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.write(sb.toString());
            printWriter.flush();
            printWriter.close();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb2.append(readLine);
                    } else {
                        bufferedReader.close();
                        inputStream.close();
                        String sb3 = sb2.toString();
                        httpURLConnection.disconnect();
                        return sb3;
                    }
                }
            } else {
                httpURLConnection.disconnect();
                throw new b(httpURLConnection.getResponseCode());
            }
        } else {
            throw new com.xingin.xhssharesdk.l.c();
        }
    }
}
