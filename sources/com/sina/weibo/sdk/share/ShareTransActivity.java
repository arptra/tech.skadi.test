package com.sina.weibo.sdk.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.meizu.common.widget.MzContactsContract;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.c0;
import com.sina.weibo.sdk.d0;
import com.sina.weibo.sdk.g0;
import com.sina.weibo.sdk.n;
import com.sina.weibo.sdk.o;
import com.sina.weibo.sdk.v;
import java.util.ArrayList;
import java.util.Iterator;

public class ShareTransActivity extends BaseActivity {
    public static final /* synthetic */ int f = 0;

    /* renamed from: a  reason: collision with root package name */
    public Intent f9992a;
    public FrameLayout b;
    public c0 c;
    public String d;
    public a e = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof Intent) {
                    int i = ShareTransActivity.f;
                    ShareTransActivity.this.a((Intent) obj);
                    return;
                }
            }
            ShareTransActivity shareTransActivity = ShareTransActivity.this;
            int i2 = ShareTransActivity.f;
            shareTransActivity.b();
        }
    }

    public final void a(WeiboMultiMessage weiboMultiMessage) {
        String str;
        String str2;
        n.a(n.b, "start wb composer");
        try {
            this.f9992a.putExtra("start_flag", 1002);
            str = null;
            str2 = o.a(String.valueOf((Math.random() * 10000.0d) + ((double) System.currentTimeMillis())).getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            str2 = null;
        } catch (Throwable th) {
            n.a(n.b, "start wb composer fail,", th);
            a("Start weibo client's composer fail. " + th.getMessage());
            return;
        }
        this.d = str2;
        this.f9992a.putExtra("share_back_flag", str2);
        this.f9992a.putExtra("share_flag_for_new_version", 1);
        Bundle extras = this.f9992a.getExtras();
        Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
        a.C0037a a2 = com.sina.weibo.sdk.a.a(this);
        if (a2 != null) {
            intent.setPackage(a2.f9968a);
        }
        intent.putExtras(weiboMultiMessage.writeToBundle(extras));
        intent.putExtra("_weibo_sdkVersion", "0041005000");
        intent.putExtra("_weibo_appPackage", getPackageName());
        if (g0.f9981a) {
            intent.putExtra("_weibo_appKey", g0.b.getAppKey());
            intent.putExtra("_weibo_flag", 538116905);
            try {
                str = o.a(d0.a((Context) this, getPackageName()).getBytes());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            intent.putExtra("_weibo_sign", str);
            String stringExtra = this.f9992a.getStringExtra("start_web_activity");
            if (!TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WebActivity".equals(stringExtra)) {
                intent.setClassName(this, stringExtra);
                startActivityForResult(intent, MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_TOKENS);
            } else if (g0.b(this)) {
                if (a2 != null) {
                    intent.setPackage(a2.f9968a);
                }
                startActivityForResult(intent, MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_TOKENS);
            } else {
                a("Start weibo client's composer fail. And Weibo client is not installed.");
            }
        } else {
            throw new RuntimeException("please init sdk before use it. Wb.install()");
        }
    }

    public final void b() {
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.removeMessages(0);
            this.e = null;
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            setResult(-1, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        n.a(n.b, "onActivityResult. Means share result coming!");
        a aVar = this.e;
        if (aVar == null) {
            return;
        }
        if (i2 == -1) {
            Message obtain = Message.obtain(aVar, 1);
            obtain.obj = intent;
            this.e.sendMessageDelayed(obtain, 100);
            return;
        }
        aVar.sendEmptyMessageDelayed(0, 100);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = n.b;
        n.a(str, "start share activity.");
        Intent intent = getIntent();
        this.f9992a = intent;
        if (intent == null) {
            finish();
        } else if (intent.getIntExtra("start_flag", -1) != 1001) {
            finish();
            n.a(str, "flag error", (Throwable) null);
        } else {
            this.b = new FrameLayout(this);
            int intExtra = getIntent().getIntExtra("progress_id", -1);
            View inflate = intExtra != -1 ? ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra, (ViewGroup) null) : new ProgressBar(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.b.addView(inflate, layoutParams);
            this.b.setBackgroundColor(855638016);
            setContentView(this.b);
            n.a(str, "prepare wb resource.");
            Bundle extras = this.f9992a.getExtras();
            if (extras == null) {
                n.a(str, "extra error", (Throwable) null);
                finish();
                return;
            }
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            weiboMultiMessage.readFromBundle(extras);
            if (n.d) {
                n.b(str, "share_msg: " + weiboMultiMessage);
            }
            if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
                a(weiboMultiMessage);
                return;
            }
            c0 c0Var = this.c;
            if (c0Var != null) {
                c0Var.cancel(true);
            }
            c0 c0Var2 = new c0(this, new v(this));
            this.c = c0Var2;
            c0Var2.execute(new WeiboMultiMessage[]{weiboMultiMessage});
        }
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        n.a(n.b, "start share activity again. Means share result coming!");
        int intExtra = intent.getIntExtra("start_flag", -1);
        if (intExtra != 1001) {
            if (intExtra == 1002) {
                a(intent);
            } else {
                b();
            }
        }
    }

    public final void a(Intent intent) {
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.removeMessages(0);
            this.e = null;
        }
        if (!TextUtils.isEmpty(this.d) && intent != null && intent.getExtras().containsKey("share_back_flag")) {
            if (TextUtils.equals(this.d, intent.getStringExtra("share_back_flag"))) {
                if (!(intent == null || intent.getFlags() == 0)) {
                    int flags = intent.getFlags();
                    String binaryString = Integer.toBinaryString(flags);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(64);
                    arrayList.add(128);
                    arrayList.add(1);
                    arrayList.add(2);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        flags &= ~((Integer) it.next()).intValue();
                    }
                    String str = n.b;
                    n.a(str, "clear flags: " + binaryString + "->" + Integer.toBinaryString(flags));
                    intent.setFlags(flags);
                }
                setResult(-1, intent);
                finish();
                return;
            }
        }
        b();
    }

    public final void a(String str) {
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.removeMessages(0);
            this.e = null;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }
}
