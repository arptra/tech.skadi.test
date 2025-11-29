package com.sina.weibo.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.meizu.common.widget.MzContactsContract;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MediaObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.SuperGroupObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.ShareTransActivity;
import java.util.ArrayList;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public long f9982a;

    public static void a(Activity activity, WeiboMultiMessage weiboMultiMessage) {
        a.C0037a a2;
        if (activity != null) {
            if (weiboMultiMessage != null) {
                ArrayList arrayList = new ArrayList();
                TextObject textObject = weiboMultiMessage.textObject;
                if (textObject != null) {
                    arrayList.add(textObject);
                }
                ImageObject imageObject = weiboMultiMessage.imageObject;
                if (imageObject != null) {
                    arrayList.add(imageObject);
                }
                MediaObject mediaObject = weiboMultiMessage.mediaObject;
                if (mediaObject != null) {
                    arrayList.add(mediaObject);
                }
                MultiImageObject multiImageObject = weiboMultiMessage.multiImageObject;
                if (multiImageObject != null) {
                    arrayList.add(multiImageObject);
                }
                VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
                if (videoSourceObject != null) {
                    arrayList.add(videoSourceObject);
                }
                SuperGroupObject superGroupObject = weiboMultiMessage.superGroupObject;
                if (superGroupObject != null) {
                    arrayList.add(superGroupObject);
                }
                if (weiboMultiMessage.superGroupObject != null && ((a2 = a.a(activity)) == null || a2.b < 5040)) {
                    SuperGroupObject superGroupObject2 = weiboMultiMessage.superGroupObject;
                    if (arrayList.isEmpty() || superGroupObject2 == null || !arrayList.contains(superGroupObject2) || arrayList.size() != 1) {
                        weiboMultiMessage.superGroupObject = null;
                    } else {
                        Toast.makeText(activity, "微博版本过低，不支持超话分享", 0).show();
                        return;
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_command_type", 1);
            bundle.putString("_weibo_transaction", System.currentTimeMillis() + "");
            bundle.putAll(weiboMultiMessage.writeToBundle(bundle));
            Intent intent = new Intent(activity, ShareTransActivity.class);
            intent.putExtra("start_flag", 1001);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_TOKENS);
        }
    }
}
