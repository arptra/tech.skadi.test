package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    public static final HttpUrlConnectionFactory g = new DefaultHttpUrlConnectionFactory();

    /* renamed from: a  reason: collision with root package name */
    public final GlideUrl f2458a;
    public final int b;
    public final HttpUrlConnectionFactory c;
    public HttpURLConnection d;
    public InputStream e;
    public volatile boolean f;

    public static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public interface HttpUrlConnectionFactory {
        HttpURLConnection a(URL url);
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, g);
    }

    public static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e2) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e2);
            return -1;
        }
    }

    public static boolean h(int i) {
        return i / 100 == 2;
    }

    public static boolean i(int i) {
        return i / 100 == 3;
    }

    public Class a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.d = null;
    }

    public DataSource c() {
        return DataSource.REMOTE;
    }

    public void cancel() {
        this.f = true;
    }

    public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
        StringBuilder sb;
        long b2 = LogTime.b();
        try {
            dataCallback.e(j(this.f2458a.h(), 0, (URL) null, this.f2458a.e()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.a(b2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
            }
            dataCallback.f(e2);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(b2));
            }
            throw th;
        }
    }

    public final HttpURLConnection e(URL url, Map map) {
        try {
            HttpURLConnection a2 = this.c.a(url);
            for (Map.Entry entry : map.entrySet()) {
                a2.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            a2.setConnectTimeout(this.b);
            a2.setReadTimeout(this.b);
            a2.setUseCaches(false);
            a2.setDoInput(true);
            a2.setInstanceFollowRedirects(false);
            return a2;
        } catch (IOException e2) {
            throw new HttpException("URL.openConnection threw", 0, e2);
        }
    }

    public final InputStream g(HttpURLConnection httpURLConnection) {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.e = ContentLengthInputStream.b(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.e = httpURLConnection.getInputStream();
            }
            return this.e;
        } catch (IOException e2) {
            throw new HttpException("Failed to obtain InputStream", f(httpURLConnection), e2);
        }
    }

    public final InputStream j(URL url, int i, URL url2, Map map) {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection e2 = e(url, map);
            this.d = e2;
            try {
                e2.connect();
                this.e = this.d.getInputStream();
                if (this.f) {
                    return null;
                }
                int f2 = f(this.d);
                if (h(f2)) {
                    return g(this.d);
                }
                if (i(f2)) {
                    String headerField = this.d.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField)) {
                        try {
                            URL url3 = new URL(url, headerField);
                            b();
                            return j(url3, i + 1, url, map);
                        } catch (MalformedURLException e3) {
                            throw new HttpException("Bad redirect url: " + headerField, f2, e3);
                        }
                    } else {
                        throw new HttpException("Received empty or null redirect url", f2);
                    }
                } else if (f2 == -1) {
                    throw new HttpException(f2);
                } else {
                    try {
                        throw new HttpException(this.d.getResponseMessage(), f2);
                    } catch (IOException e4) {
                        throw new HttpException("Failed to get a response message", f2, e4);
                    }
                }
            } catch (IOException e5) {
                throw new HttpException("Failed to connect or obtain data", f(this.d), e5);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.f2458a = glideUrl;
        this.b = i;
        this.c = httpUrlConnectionFactory;
    }
}
