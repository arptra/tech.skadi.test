package com.luck.picture.lib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;

public class IntentUtils {
    public static void a(Context context, String str) {
        Uri uri;
        Intent intent = new Intent("android.intent.action.VIEW");
        boolean z = PictureMimeType.c(str) || PictureMimeType.g(str);
        if (SdkVersionUtils.f()) {
            uri = z ? Uri.parse(str) : Uri.fromFile(new File(str));
        } else if (!SdkVersionUtils.a()) {
            uri = z ? Uri.parse(str) : Uri.fromFile(new File(str));
        } else if (z) {
            uri = Uri.parse(str);
        } else {
            uri = FileProvider.getUriForFile(context, context.getPackageName() + ".luckProvider", new File(str));
        }
        intent.addFlags(268468224);
        intent.addFlags(1);
        intent.setDataAndType(uri, "video/*");
        context.startActivity(intent);
    }
}
